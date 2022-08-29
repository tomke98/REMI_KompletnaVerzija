package tomislav.ferit.remi

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [welcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class welcomeFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment welcomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            welcomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spNumOfJokerCards: Spinner = view.findViewById(R.id.spNumOfJokerCards)
        val btnStart=view.findViewById<Button>(R.id.btnStart)
// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter =  ArrayAdapter.createFromResource(
            view.context,
            R.array.Desired_Number_Of_Joker_Cards,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spNumOfJokerCards.adapter = adapter

        spNumOfJokerCards.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                Toast.makeText(parent.context,
                    "Your desired number of Joker cards is: ${parent.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT).show()
                val input=parent.getItemAtPosition(position).toString().toInt()

                setFragmentResult("requestKey", bundleOf("NumberOfJokerCards" to input))
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnStart.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flMainActivity,GameFragment())
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

}