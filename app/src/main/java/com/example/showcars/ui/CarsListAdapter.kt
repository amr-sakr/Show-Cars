package com.example.showcars.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.showcars.R
import com.example.showcars.data.Data
import com.example.showcars.databinding.ActivityMainBinding
import com.example.showcars.databinding.CarsListItemBinding
import timber.log.Timber


class CarsListAdapter() : ListAdapter<Data, CarsListAdapter.CarsViewHolder>(CarsListDiffUtil()) {


    class CarsViewHolder(var binding: CarsListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data) {

            item.apply {

                Glide.with(itemView.context)
                        .load(imageUrl).into(binding.imageView)

                binding.tvBrand.text = brand
                binding.tvConstructionYear.text = constructionYear
                binding.tvCondition.text = when (this.isUsed) {
                    true -> "Used"
                    else -> "New"
                }
            }
        }

        companion object {

            fun from(parent: ViewGroup): CarsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CarsListItemBinding.inflate(layoutInflater, parent, false)
                return CarsViewHolder(binding)
            }
        }
    }


    override fun submitList(list: List<Data>?) {
        super.submitList(list?.let { ArrayList(it) })
        Timber.d("List = ${list.toString()}")
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        return CarsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}


class CarsListDiffUtil : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}