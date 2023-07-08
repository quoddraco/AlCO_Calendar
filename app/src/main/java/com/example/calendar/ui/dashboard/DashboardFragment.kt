package com.example.calendar.ui.dashboard

import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.calendar.R
import com.example.calendar.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val tableLayout: TableLayout = binding.tableLayout
        dashboardViewModel.textDay.observe(viewLifecycleOwner) {
            // Добавление дней недели
            val weekDays = listOf("Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс")
            val headerRow = TableRow(requireContext())
            for (day in weekDays) {
                val headerTextView = TextView(requireContext())
                headerTextView.text = day
                headerTextView.setPadding(16, 16, 16, 16)
                headerTextView.gravity = Gravity.CENTER
                headerTextView.setTypeface(null, Typeface.BOLD)
                val layoutParams = TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
                )
                layoutParams.setMargins(8, 8, 8, 8)

                headerRow.addView(headerTextView, layoutParams)
            }
            tableLayout.addView(headerRow)


            val numbers = mutableListOf<Int>()
            for (i in 1..it) {
                numbers.add(i)
            }
            val columnCount = 7 // Количество столбцов (неделя)

            var row: TableRow? = null
            for ((index, number) in numbers.withIndex()) {
                if (index % columnCount == 0) {
                    row = TableRow(requireContext())
                    tableLayout.addView(row)
                }

                val textView = TextView(requireContext())
                textView.text = number.toString()
                textView.setPadding(16, 16, 16, 16)
                textView.gravity = Gravity.CENTER

                val layoutParams = TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
                )
                layoutParams.setMargins(8, 8, 8, 8)

                row?.addView(textView, layoutParams)
            }

        }




        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val textViewMonth: TextView = binding.textMonth
        dashboardViewModel.text2.observe(viewLifecycleOwner) {
            textViewMonth.text = it
        }

        val buttonLeft: Button = binding.buttonLeft
        buttonLeft.setOnClickListener {
            tableLayout.removeAllViews()
            dashboardViewModel.incrementClickCountMin()
        }

        val buttonRight: Button = binding.buttonRight
        buttonRight.setOnClickListener {
            tableLayout.removeAllViews()
            dashboardViewModel.incrementClickCountPlus()

        }




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}