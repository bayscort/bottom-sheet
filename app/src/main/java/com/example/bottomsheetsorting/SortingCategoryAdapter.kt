package com.example.bottomsheetsorting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView

class SortingCategoryAdapter(val filterCategoryList: Array<String>): RecyclerView.Adapter<SortingCategoryAdapter.CategoryViewHolder>() {
    // describes an item view and its place within the RecyclerView
    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryRadioButton : RadioButton = itemView.findViewById(R.id.radioButton)

        fun bind(word: String) {
            categoryRadioButton.text = word
        }
    }

    // returns a new ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sorting_category, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(filterCategoryList[position])
    }

    override fun getItemCount(): Int {
        return filterCategoryList.size
    }}