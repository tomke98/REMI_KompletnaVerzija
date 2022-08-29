package tomislav.ferit.remi

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GameFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val inputtedData = bundle.getInt("NumberOfJokerCards")

            val gameManager=GameManager(numberOfJokerCards = inputtedData , context= this.requireContext())
            var playerCards= gameManager.playerDeckOfCards.toMutableList()
            val cardAdapter=CardAdapter(playerCards)

            val playersDeckRecyclerView=view.findViewById<RecyclerView>(R.id.rvPlayersDeck)

            playersDeckRecyclerView.adapter=cardAdapter

            playersDeckRecyclerView.layoutManager=LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)

            val btnSwap =view.findViewById<Button>(R.id.btnSwap)
            Log.d("oldPlayerCards","$playerCards")

            btnSwap.setOnClickListener{
                val adapterCards=cardAdapter.Cards
                val swappedDeckOfPlayerCards = gameManager.switchTwoCheckedCards(adapterCards)
                Log.d("switch","$swappedDeckOfPlayerCards")


                for(position in 0 until swappedDeckOfPlayerCards.size){
                    if(playerCards[position].image!=swappedDeckOfPlayerCards[position].image){
                          playerCards[position]=swappedDeckOfPlayerCards[position]
                    }
                }
                cardAdapter.notifyDataSetChanged()
            }

            val btnReplace = view.findViewById<Button>(R.id.btnReplace)

            btnReplace.setOnClickListener{
                val adapterCards=cardAdapter.Cards
                playerCards=gameManager.replace(adapterCards)
                cardAdapter.notifyDataSetChanged()
            }

            val btnCheck =view.findViewById<Button>(R.id.btnCheck)

            btnCheck.setOnClickListener {
                val adapterCards = cardAdapter.Cards
                 playerCards=gameManager.discardCheckedCards(adapterCards)
                Log.d("Check","${playerCards}")
                cardAdapter.notifyDataSetChanged()
                if(playerCards.isEmpty()){
                    parentFragmentManager.beginTransaction().apply {
                        replace(R.id.flMainActivity, WinFragment())
                        addToBackStack(null)
                        commit()
                    }
                }
            }

            val btnUndo = view.findViewById<Button>(R.id.btnUndo)
            btnUndo.setOnClickListener {
                if(gameManager.savedStates.isNotEmpty()){
                    playerCards.addAll(gameManager.restoreFromMemento())
                    cardAdapter.notifyDataSetChanged()
                }
            }

            val btnMark_Unmark = view.findViewById<Button>(R.id.btnMarkAll)

            btnMark_Unmark.setOnClickListener {
                val adapterCards=cardAdapter.Cards
                var markedCardsCount = 0                //broji označene karte
                for(i in 0 until cardAdapter.itemCount){
                    if(cardAdapter.Cards[i].isChecked) {
                        markedCardsCount++
                    }
                }

                if(markedCardsCount==cardAdapter.itemCount){        //ako su sve karte označene, odznači ih
                    for(i in 0 until cardAdapter.itemCount){
                        playerCards[i].isChecked= false
                    }
                }

                else{
                    for(i in 0 until cardAdapter.itemCount){        //ako nisu sve karte označene (makar bila jedna), označi sve
                        playerCards[i].isChecked=true
                    }
                }

                   cardAdapter.notifyDataSetChanged()
            }

            val btnSort = view.findViewById<Button>(R.id.btnSort)

            btnSort.setOnClickListener {
                val adapterCards=cardAdapter.Cards
                Log.d("UNSORTED","$playerCards")
                val sortedPlayerCards=gameManager.sortAllChecked(adapterCards)
                for(position in 0 until adapterCards.size){
                    playerCards[position]=sortedPlayerCards[position]
                }
                cardAdapter.notifyDataSetChanged()
                Log.d("SORTED","$playerCards")





            }

        }


    }














    }
