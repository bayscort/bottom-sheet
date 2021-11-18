package com.example.bottomsheetsorting

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // sorting button

        val buttonSorting: Button = findViewById(R.id.buttonSorting)

        buttonSorting.setOnClickListener {
            initSortingBottomSheet()
        }

        // filter button

        val buttonFilter: Button = findViewById(R.id.buttonFilter)

        buttonFilter.setOnClickListener {
            initFilterBottomSheet()
        }

        // filter kategori

        val buttonFilterCategory: Button = findViewById(R.id.buttonFilterKategori)

        buttonFilterCategory.setOnClickListener {
            initFilterCategoryBottomSheet()
        }
    }

    private fun initSortingBottomSheet() {
        // retrieves data from datasource
        val categoryList = DataSource(this).getSortingCategory()

        val bottomSheetDialogSorting = BottomSheetDialog(
            this@MainActivity, R.style.BottomSheetDialogTheme
        )

        val bottomSheetSorting = LayoutInflater.from(this).inflate(
            R.layout.layout_bottom_sheet, null
        )
        val flContent = bottomSheetSorting.findViewById<FrameLayout>(R.id.content)
        val contentLayout = LayoutInflater.from(this).inflate(R.layout.content_container, null)

        val recyclerView: RecyclerView = contentLayout.findViewById(R.id.recycler_view)
        recyclerView.adapter = SortingCategoryAdapter(categoryList)

        flContent.addView(contentLayout)

        bottomSheetDialogSorting.setContentView(bottomSheetSorting)
        bottomSheetDialogSorting.show()
    }

    private fun initFilterBottomSheet() {
        val bsCategoryDialog = BottomSheetDialog(
            this@MainActivity,
            R.style.BottomSheetDialogTheme
        )

        val bottomSheetFilter = LayoutInflater.from(this).inflate(
            R.layout.filter_layout_bottom_sheet,
            null
        )
        bsCategoryDialog.setContentView(bottomSheetFilter)
        bsCategoryDialog.show()
    }

    private fun initFilterCategoryBottomSheet() {
        // retrieves data from datasource
        val filterCategoryList = DataSource(this).getFilterCategory()

        val bottomSheetDialogKategoriFilter = BottomSheetDialog(
            this@MainActivity, R.style.BottomSheetDialogTheme
        )

        val bottomSheetKategoriFilter = LayoutInflater.from(this).inflate(
            R.layout.kategori_content_container,
            null
        )

        val flContentKategoriFilter = bottomSheetKategoriFilter.findViewById<FrameLayout>(R.id.contentFilterKategori)
        val contentFilterKategoriLayout = LayoutInflater.from(this).inflate(
            R.layout.kategori_content,
            null)

        val recyclerViewFilterKategori: RecyclerView = contentFilterKategoriLayout.findViewById(R.id.recycler_view_filter_kategori)
        recyclerViewFilterKategori.adapter = FilterCategoryAdapter(filterCategoryList)

        flContentKategoriFilter.addView(contentFilterKategoriLayout)

        bottomSheetDialogKategoriFilter.setContentView(bottomSheetKategoriFilter)
        bottomSheetDialogKategoriFilter.show()
    }

}