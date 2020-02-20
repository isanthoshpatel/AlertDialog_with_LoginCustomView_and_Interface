package com.example.alertdialog_with_customview_and_interface

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.app.ActivityCompat.recreate
import kotlinx.android.synthetic.main.alertdialog_customview.*
import kotlinx.android.synthetic.main.alertdialog_customview.view.*

class AlertDialogEx : AppCompatDialogFragment() {
    lateinit var v: View
    lateinit var interfaceObje: MyInterface

    interface MyInterface {
        fun myWork(username: String, pass: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        v = activity!!.layoutInflater.inflate(R.layout.alertdialog_customview, null)

        return AlertDialog.Builder(activity!!)
            .setTitle("OnlineApp")
            .setView(v)
            .setPositiveButton("LogIn") { dialog, which ->
                var email = v.et_email.text.toString().trim()
                var pass = v.et_pass.text.toString().trim()

                if (email.isEmpty()){
                    v.et_email.requestFocus()
                    recreate(activity!!) }

                else if (pass.isEmpty()){
                    v.et_pass.requestFocus()
                    recreate(activity!!)
                }

                else{ interfaceObje.myWork(email, pass)
                dialog.cancel()}

            }
            .setNegativeButton("cancel") { d, w -> d.dismiss() }
            .create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        interfaceObje = context as MyInterface

    }

}