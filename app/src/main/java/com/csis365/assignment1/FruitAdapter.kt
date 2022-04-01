import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.R
import com.csis365.assignment1.service.dto.Fruit

class FruitAdapter(private val data: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.MyViewHolder>() {
    private lateinit var mListener: FruitDetailListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitAdapter.MyViewHolder {
         val view = LayoutInflater.from(parent.context)
             .inflate(R.layout.activity_fruit_list, parent, false)
        return  MyViewHolder(view, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FruitAdapter.MyViewHolder, position: Int) {
        holder.aName.text = data[position].name
        holder.aGen.text = "Genus: " + data[position].genus
        holder.anOrder.text = "Order: " + data[position].order
//        holder.anId.text = data[position].id.toString()
//        holder.aFam.text = data[position].family.toString()
//        holder.nutrit.text = data[position].nutritions.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class MyViewHolder (view: View, listener: FruitDetailListener): RecyclerView.ViewHolder(view){

        val aName: TextView
        val aGen: TextView
        val anOrder: TextView
//        val anId: TextView
//        val aFam: TextView
//        val nutrit: TextView


        init{
            aName = view.findViewById(R.id.tv_name)
            aGen = view.findViewById(R.id.tv_genus)
            anOrder = view.findViewById(R.id.tv_order)
//            anId = view.findViewById(R.id.tv_id)
//            aFam = view.findViewById(R.id.tv_family)
//            nutrit = view.findViewById(R.id.tv_nutritions)
            view.setOnClickListener { listener.onItemClick(adapterPosition) }
        }
    }

    interface FruitDetailListener{
        fun onItemClick(position: Int)
    }

    fun setFruitDetailListener(listener: FruitDetailListener) {
        mListener = listener
    }

}
