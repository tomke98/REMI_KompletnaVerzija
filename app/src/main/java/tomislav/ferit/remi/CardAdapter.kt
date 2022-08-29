package tomislav.ferit.remi

import android.content.Context
import android.location.GnssAntennaInfo
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates


class CardAdapter(
     var Cards: MutableList<Card>
):RecyclerView.Adapter<CardAdapter.CardViewHolder>()
{
    inner class CardViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_card,parent,false)
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val checkBox =holder.itemView.findViewById<CheckBox>(R.id.cbCard)
        val cardImage = holder.itemView.findViewById<ImageView>(R.id.iwCardImage).also {
            it.setImageResource(Cards[holder.adapterPosition].image)
        }
        checkBox.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{                            //omogućuje adapteru da pomocu listenera pamti chekirane karte
            override fun onCheckedChanged(compoundButton: CompoundButton?, bool: Boolean) {
                Cards[holder.adapterPosition].isChecked = checkBox.isChecked
            }
        })

        checkBox.isChecked=Cards[holder.adapterPosition].isChecked
        if(checkBox.isChecked)
            Toast.makeText(holder.itemView.rootView.context,
                "You checked card[ ${holder.adapterPosition} ]",
                Toast.LENGTH_SHORT).show()
        }

    override fun getItemCount(): Int {
        return Cards.size
    }




    fun printAllStates(){
        for(i in 0 until itemCount){
            Log.d("States","Card[$i] is ${Cards[i].isChecked}")
        }
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}