package com.example.bottomsheetsorting

import android.content.Context

class DataSource(val context: Context) {
    fun getSortingCategory() :Array<String> {

        // return sorting category from string resources
        return context.resources.getStringArray(R.array.sorting_category_array)
    }

    fun getFilterCategory(): Array<String> {

        // return sorting category from string resources
        return context.resources.getStringArray(R.array.filter_category_array)
    }
}