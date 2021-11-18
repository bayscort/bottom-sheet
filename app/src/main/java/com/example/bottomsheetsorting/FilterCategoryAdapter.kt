package com.example.bottomsheetsorting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class FilterCategoryAdapter(val categoryList: Array<String>) : RecyclerView.Adapter<FilterCategoryAdapter.CategoryViewHolder>() {

    // describe an item view and its place within the RecyclerView
    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryCheckBox: CheckBox = itemView.findViewById(R.id.checkBox)

        fun bind(word: String) {
            categoryCheckBox.text = word
        }
    }

    // return a new view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.kategori_item, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

}