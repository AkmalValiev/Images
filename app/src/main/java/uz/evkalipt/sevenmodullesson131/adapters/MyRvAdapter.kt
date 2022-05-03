package uz.evkalipt.sevenmodullesson131.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.evkalipt.sevenmodullesson131.databinding.ItemForRvBinding
import uz.evkalipt.sevenmodullesson131.models.SaveModel

class MyRvAdapter(var list: List<SaveModel>, var myOnClick: MyOnClick):RecyclerView.Adapter<MyRvAdapter.Vh>() {

    inner class Vh(var itemForRvBinding: ItemForRvBinding):RecyclerView.ViewHolder(itemForRvBinding.root){
        fun onBind(saveModel: SaveModel){
            Picasso.get().load(saveModel.url).into(itemForRvBinding.imageRv)
            itemForRvBinding.root.setOnClickListener {
                myOnClick.myClick(saveModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemForRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface MyOnClick{
        fun myClick(saveModel: SaveModel)
    }

}