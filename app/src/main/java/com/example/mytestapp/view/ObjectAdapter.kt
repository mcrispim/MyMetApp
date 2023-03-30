package com.example.mytestapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestapp.databinding.ItemObjectBinding
import com.example.mytestapp.model.MuseumObject

class ObjectAdapter : RecyclerView.Adapter<ObjectAdapter.ObjectViewHolder>() {

    inner class ObjectViewHolder(val binding: ItemObjectBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var museumObjectIds: List<Int>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

    override fun getItemCount() = museumObjectIds.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectViewHolder {
        return ObjectViewHolder(ItemObjectBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ObjectViewHolder, position: Int) {
        holder.binding.apply {
            val museumObjectId = museumObjectIds[position]
            tvObjectId.text = museumObjectId.toString()
        }
    }
}