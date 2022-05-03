package uz.evkalipt.sevenmodullesson131.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.evkalipt.sevenmodullesson131.databinding.ItemForRvBinding
import uz.evkalipt.sevenmodullesson131.photoModel.MyPhoto

class MyPaging3Adapter(var myOnClick: MyOnClick):PagingDataAdapter<MyPhoto, MyPaging3Adapter.Vh>(MyDiffUtil()){

    inner class Vh(private var itemForRvBinding: ItemForRvBinding):RecyclerView.ViewHolder(itemForRvBinding.root){
        fun onBind(myPhoto: MyPhoto?){
            Picasso.get().load(myPhoto?.urls?.small).into(itemForRvBinding.imageRv)
            itemForRvBinding.imageRv.setOnClickListener {
                myOnClick.myClick(myPhoto!!)
            }
        }
    }

    class MyDiffUtil:DiffUtil.ItemCallback<MyPhoto>(){
        override fun areItemsTheSame(oldItem: MyPhoto, newItem: MyPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MyPhoto, newItem: MyPhoto): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemForRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    interface MyOnClick{
        fun myClick(myPhoto: MyPhoto)
    }

}