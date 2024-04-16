package com.example.lab6.Athlete

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.Event.Event
import com.example.lab6.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AthleteFragment: Fragment() {
    private lateinit var rv: RecyclerView
    private lateinit var athleteList: MutableList<Athlete>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_athlete, container, false)
        rv = view.findViewById(R.id.athlete_recycler_view)

        rv.layoutManager = LinearLayoutManager(context)
        athleteList = Athlete.createSample()
        rv.adapter = AthleteAdapter(requireContext(), athleteList)

        val addButton: FloatingActionButton = view.findViewById(R.id.fab_add)

        addButton.setOnClickListener{
            val builder = AlertDialog.Builder(context)
            val inflaterDialog = layoutInflater

            builder.setTitle("Add New News")
            val dialogLayout = inflaterDialog.inflate(R.layout.fragment_athlete_dialog, null)
            builder.setView(dialogLayout)

            val name  = dialogLayout.findViewById<EditText>(R.id.et_name)
            val sport  = dialogLayout.findViewById<EditText>(R.id.et_sport)
            val country  = dialogLayout.findViewById<EditText>(R.id.et_country)
            val performance  = dialogLayout.findViewById<EditText>(R.id.et_performance)
            val medal  = dialogLayout.findViewById<EditText>(R.id.et_medal)
            val facts  = dialogLayout.findViewById<EditText>(R.id.et_facts)

            builder.setPositiveButton("Add") { _, _ ->

                val nameValue: String = name.getText().toString()
                val sportValue: String = sport.getText().toString()
                val countryValue: String = country.getText().toString()
                val performanceValue: String = performance.getText().toString()
                val medalValue: String = medal.getText().toString()
                val factsValue: String = facts.getText().toString()

                if (nameValue.isEmpty()) {
                    Toast.makeText(context, "Name is empty!", Toast.LENGTH_LONG).show()
                } else if (sportValue.isEmpty()) {
                    Toast.makeText(context, "Sport is empty!", Toast.LENGTH_LONG).show()
                } else if (countryValue.isEmpty()) {
                    Toast.makeText(context, "Country is empty!", Toast.LENGTH_LONG).show()
                } else if (performanceValue.isEmpty()) {
                    Toast.makeText(context, "Performance is empty!", Toast.LENGTH_LONG).show()
                } else if (medalValue.isEmpty()) {
                    Toast.makeText(context, "Medal is empty!", Toast.LENGTH_LONG).show()
                } else if (factsValue.isEmpty()) {
                    Toast.makeText(context, "Facts is empty!", Toast.LENGTH_LONG).show()
                } else {
                    athleteList.add(Athlete(nameValue, sportValue, countryValue, performanceValue,
                        medalValue, factsValue))
                }
            }
            builder.setNegativeButton("Cancel") {_, _ -> }
            builder.show()
        }

        return view
    }

    inner class AthleteAdapter(private val context: Context, private val athleteList: List<Athlete>) :
        RecyclerView.Adapter<AthleteAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_athlete_layout, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val athlete = athleteList[position]
            holder.bind(athlete)
        }

        override fun getItemCount(): Int {
            return athleteList.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val name: TextView = itemView.findViewById(R.id.tv_name)
            private val sport: TextView = itemView.findViewById(R.id.tv_sport)
            private val country: TextView = itemView.findViewById(R.id.tv_country)
            private val performance: TextView = itemView.findViewById(R.id.tv_performance)
            private val medals: TextView = itemView.findViewById(R.id.tv_medals)
            private val facts: TextView = itemView.findViewById(R.id.tv_facts)

            fun bind(athlete: Athlete) {
                name.text = "Name: ${athlete.name}"
                sport.text = "Sport: ${athlete.sport}"
                country.text = "Country: ${athlete.country}"
                performance.text = "Personal Best: ${athlete.performance}"
                medals.text = "Medals: ${athlete.medals}"
                facts.text = "Facts: ${athlete.facts}"

            }
        }
    }
}