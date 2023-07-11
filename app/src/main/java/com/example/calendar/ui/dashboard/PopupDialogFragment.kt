package com.example.calendar.ui.dashboard

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.calendar.R
import java.io.FileWriter
import org.json.JSONObject
import com.google.gson.Gson
import java.io.File

class PopupDialogFragment : DialogFragment() {

    data class User(val name: String, val age: Int, val email: String)

    companion object {
        fun newInstance(day: String, month: String, year: String): PopupDialogFragment {
            val fragment = PopupDialogFragment()
            val args = Bundle()
            args.putString("day", day)
            args.putString("month", month)
            args.putString("year", year)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val day = arguments?.getString("day")
        val month = arguments?.getString("month")
        val year = arguments?.getString("year")

        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.popup_dialog)

        val messageTextView = dialog.findViewById<TextView>(R.id.messageTextView)
        messageTextView.text = "$day $month $year"

        val canelButton = dialog.findViewById<Button>(R.id.Cancelbutton)
        canelButton.setOnClickListener {
            dialog.dismiss()
        }

        val okButton = dialog.findViewById<Button>(R.id.okButton)
        okButton.setOnClickListener {
            val file = File("data.json")
            val json = file.readText()

            val gson = Gson()
            val user = gson.fromJson(json, User::class.java)

            println("Name: ${user.name}")
            println("Age: ${user.age}")
            println("Email: ${user.email}")
            dismiss()
        }

        return dialog
    }


}

