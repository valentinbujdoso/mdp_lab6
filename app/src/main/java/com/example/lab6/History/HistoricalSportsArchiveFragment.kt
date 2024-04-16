package com.example.lab6.History

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HistoricalSportsArchiveFragment: Fragment() {
    private lateinit var rv: RecyclerView
    private lateinit var historicalSportsArchiveList: MutableList<HistoricalSportsArchive>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_historical_sports_archive, container, false)
        rv = view.findViewById(R.id.historical_activity_recycler_view)

        rv.layoutManager = LinearLayoutManager(context)
        historicalSportsArchiveList = HistoricalSportsArchive.createSample()
        rv.adapter = HistoricalSportsArchiveAdapter(requireContext(), historicalSportsArchiveList)

        val addButton: FloatingActionButton = view.findViewById(R.id.fab_add)

        addButton.setOnClickListener{
            val builder = AlertDialog.Builder(context)
            val inflaterDialog = layoutInflater

            builder.setTitle("Add New Historical Sports Archive")
            val dialogLayout = inflaterDialog.inflate(R.layout.fragment_historical_sports_archive_dialog, null)
            builder.setView(dialogLayout)

            val name  = dialogLayout.findViewById<EditText>(R.id.et_name)
            val date  = dialogLayout.findViewById<DatePicker>(R.id.dp_date)
            val description  = dialogLayout.findViewById<EditText>(R.id.et_description)

            builder.setPositiveButton("Add") { _, _ ->

                val nameValue: String = name.getText().toString()
                val dateValue: String = "${date.month}, ${date.dayOfMonth} ${date.year}"
                val descriptionValue: String = description.getText().toString()

                if (nameValue.isEmpty()) {
                    Toast.makeText(context, "Name is empty!", Toast.LENGTH_LONG).show()
                } else if (dateValue.isEmpty()) {
                    Toast.makeText(context, "Date is empty!", Toast.LENGTH_LONG).show()
                } else if(descriptionValue.isEmpty()) {
                    Toast.makeText(context, "Description is empty!", Toast.LENGTH_LONG).show()
                } else {
                    historicalSportsArchiveList.add(HistoricalSportsArchive(nameValue, descriptionValue, dateValue))
                }
            }
            builder.setNegativeButton("Cancel") {_, _ -> }
            builder.show()
        }

        return view
    }

    inner class HistoricalSportsArchiveAdapter(private val context: Context, private val historicalSportArchiveList: List<HistoricalSportsArchive>) :
        RecyclerView.Adapter<HistoricalSportsArchiveAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_historical_activity_layout, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val historicalSportArchive = historicalSportArchiveList[position]
            holder.bind(historicalSportArchive)
        }

        override fun getItemCount(): Int {
            return historicalSportArchiveList.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val name: TextView = itemView.findViewById(R.id.tv_name)
            private val date: TextView = itemView.findViewById(R.id.tv_date)
            private val description: TextView = itemView.findViewById(R.id.tv_description)

            fun bind(historicalSportsArchive: HistoricalSportsArchive) {
                name.text = historicalSportsArchive.name
                date.text = historicalSportsArchive.date
                description.text = historicalSportsArchive.description
            }
        }
    }
}