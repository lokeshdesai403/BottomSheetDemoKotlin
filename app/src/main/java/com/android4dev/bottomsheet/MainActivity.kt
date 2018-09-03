package com.android4dev.bottomsheet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.CoordinatorLayout
import android.view.View
import com.android4dev.bottomsheet.R.layout.bottom_sheet_layout
import com.android4dev.bottomsheet.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet_layout.*
import android.support.design.widget.BottomSheetDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*


class MainActivity : BaseActivity(), View.OnClickListener {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        buttonSlideUp.setOnClickListener(this)
        buttonBottomSheetDialog.setOnClickListener(this)
        buttonBottomSheetDialogFragment.setOnClickListener(this)
       textViewFacebook.setOnClickListener {
            Toast.makeText(this,"Facebook",Toast.LENGTH_SHORT).show()
        }
        textViewTwitter.setOnClickListener {
            Toast.makeText(this,"Twitter",Toast.LENGTH_SHORT).show()
        }
        textViewInstagram.setOnClickListener {
            Toast.makeText(this,"Instagram",Toast.LENGTH_SHORT).show()
        }
        textViewLinkedin.setOnClickListener {
            Toast.makeText(this,"Linkedin",Toast.LENGTH_SHORT).show()
        }
        bottomSheetBehavior = BottomSheetBehavior.from<ConstraintLayout>(bottomSheet)
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        buttonSlideUp.text = "Slide Up"
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {

                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        buttonSlideUp.text = "Slide Down"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {

                    }
                    BottomSheetBehavior.STATE_SETTLING -> {

                    }
                }
            }
        })
    }

    override fun onClick(clickView: View?) {
        when (clickView) {
            buttonSlideUp -> {
                slideUpDownBottomSheet()
            }
            buttonBottomSheetDialogFragment -> {
                showBottomSheetDialogFragment()
            }
            buttonBottomSheetDialog -> {
                showBottomSheetDialog()
            }
        }
    }

    /***
     * Manually Slide up and Slide Down
     */
    private fun slideUpDownBottomSheet() {
        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            buttonSlideUp.text = "Slide Down";
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED;
            buttonSlideUp.text = "Slide Up"
        }
    }

    private fun showBottomSheetDialog() {
        val view = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        view.textViewFacebook.setOnClickListener {
            Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show()
        }
        view.textViewTwitter.setOnClickListener {
            Toast.makeText(this, "Twitter", Toast.LENGTH_SHORT).show()
        }
        view.textViewInstagram.setOnClickListener {
            Toast.makeText(this, "Instagram", Toast.LENGTH_SHORT).show()
        }
        view.textViewLinkedin.setOnClickListener {
            Toast.makeText(this, "Linkedin", Toast.LENGTH_SHORT).show()
        }
        dialog.show()
    }

    private fun showBottomSheetDialogFragment() {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }
}
