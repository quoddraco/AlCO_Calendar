package com.example.calendar.ui.dashboard

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.calendar.R

class PopupDialogFragment : DialogFragment() {

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

        val okButton = dialog.findViewById<Button>(R.id.okButton)
        okButton.setOnClickListener {
            dialog.dismiss()
        }

        return dialog
    }
}

