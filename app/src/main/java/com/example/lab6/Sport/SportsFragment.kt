package com.example.lab6.Sport

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SportsFragment: Fragment() {
    private lateinit var rv: RecyclerView
    private lateinit var sportList: MutableList<Sport>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sport, container, false)
        rv = view.findViewById(R.id.sport_recycler_view)

        rv.layoutManager = GridLayoutManager(context, 2)
        sportList = Sport.createSample()
        rv.adapter = SportAdapter(requireContext(), sportList)

        val addButton: FloatingActionButton = view.findViewById(R.id.fab_add)

        addButton.setOnClickListener{
            val builder = AlertDialog.Builder(context)
            val inflaterDialog = layoutInflater

            builder.setTitle("Add New Sport")
            val dialogLayout = inflaterDialog.inflate(R.layout.fragment_sport_dialog, null)
            builder.setView(dialogLayout)

            val measure  = dialogLayout.findViewById<Spinner>(R.id.s_measure)
            val name  = dialogLayout.findViewById<EditText>(R.id.et_sport_name)
            val description  = dialogLayout.findViewById<EditText>(R.id.et_description)

            builder.setPositiveButton("Add") { _, _ ->

                val measureValue: String = measure.getSelectedItem().toString()
                val nameValue: String = name.getText().toString()
                val descriptionValue: String = description.getText().toString()

                if (measureValue.isEmpty()) {
                    Toast.makeText(context, "You have to select one measure!", Toast.LENGTH_LONG).show()
                } else if (nameValue.isEmpty()) {
                    Toast.makeText(context, "Name is empty!", Toast.LENGTH_LONG).show()
                } else if(descriptionValue.isEmpty()) {
                    Toast.makeText(context, "Description is empty!", Toast.LENGTH_LONG).show()
                } else {
                    sportList.add(Sport(measureValue, nameValue, descriptionValue))
                }
            }
            builder.setNegativeButton("Cancel") {_, _ -> }
            builder.show()
        }

        return view
    }

    inner class SportAdapter(private val context: Context, private val sportList: List<Sport>) :
        RecyclerView.Adapter<SportAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sport_layout, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val sport = sportList[position]
            holder.bind(sport)
        }

        override fun getItemCount(): Int {
            return sportList.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val type: TextView = itemView.findViewById(R.id.tv_type)
            private val name: TextView = itemView.findViewById(R.id.tv_name)
            private val instruction: TextView = itemView.findViewById(R.id.tv_instruction)

            fun bind(sport: Sport) {
                type.text = sport.type
                name.text = sport.name
                instruction.text = sport.instruction
            }
        }
    }
}