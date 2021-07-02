package com.yefimoyevhen.mediaplayerapp.view.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.yefimoyevhen.mediaplayerapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet_layout.*
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

     //   bindUiWithNavigation()
    }

    private fun bindUiWithNavigation() {
        val navController = findNavController()
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController)
        navView.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        (requireActivity() as AppCompatActivity).setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)
    }



    private fun showBottomSheetDialog(view: View) {
        val bottomSheetDialog = BottomSheetDialog(view.context, R.style.BottomSheetTheme)

        val sheetView = LayoutInflater.from(view.context)
            .inflate(R.layout.bottom_sheet_layout, bottom_sheet)

        sheetView.ll_share.setOnClickListener {
            makeToast(R.string.share)
            bottomSheetDialog.dismiss()
        }
        val tvSheetTitle = sheetView.tv_sheet_title
        tvSheetTitle.text = "Ария Штиль  "
        tvSheetTitle.setSingleLine()
        tvSheetTitle.isSelected = true

        bottomSheetDialog.setContentView(sheetView)
        bottomSheetDialog.show()
    }

    private fun makeToast(stringRes: Int) {
        Toast.makeText(
            activity,
            stringRes,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.top_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.drive_mode_item -> makeToast(R.string.drive_mode)
            R.id.more_item -> showBottomSheetDialog(requireView())
        }
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }

}