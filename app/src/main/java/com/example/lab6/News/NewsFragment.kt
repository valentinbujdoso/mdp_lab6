package com.example.lab6.News

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab6.R
import com.example.lab6.Sport.Sport
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NewsFragment: Fragment() {
    private lateinit var rv: RecyclerView
    private lateinit var newsList: MutableList<News>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        rv = view.findViewById(R.id.news_recycler_view)

        rv.layoutManager = LinearLayoutManager(context)
        newsList = News.createSample()
        rv.adapter = NewsAdapter(requireContext(), newsList)

        val addButton: FloatingActionButton = view.findViewById(R.id.fab_add)

        addButton.setOnClickListener{
            val builder = AlertDialog.Builder(context)
            val inflaterDialog = layoutInflater

            builder.setTitle("Add New News")
            val dialogLayout = inflaterDialog.inflate(R.layout.fragment_news_dialog, null)
            builder.setView(dialogLayout)

            val image  = dialogLayout.findViewById<EditText>(R.id.et_image)
            val name  = dialogLayout.findViewById<EditText>(R.id.et_name)
            val description  = dialogLayout.findViewById<EditText>(R.id.et_description)

            builder.setPositiveButton("Add") { _, _ ->

                val imageValue: String = image.getText().toString()
                val nameValue: String = name.getText().toString()
                val descriptionValue: String = description.getText().toString()

                if (imageValue.isEmpty()) {
                    Toast.makeText(context, "Image URL is empty!", Toast.LENGTH_LONG).show()
                } else if (nameValue.isEmpty()) {
                    Toast.makeText(context, "Name is empty!", Toast.LENGTH_LONG).show()
                } else if(descriptionValue.isEmpty()) {
                    Toast.makeText(context, "Description is empty!", Toast.LENGTH_LONG).show()
                } else {
                    newsList.add(News(nameValue, imageValue, descriptionValue))
                }
            }
            builder.setNegativeButton("Cancel") {_, _ -> }
            builder.show()
        }

        return view
    }

    inner class NewsAdapter(private val context: Context, private val newsList: List<News>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_layout, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.bind(news)
        }

        override fun getItemCount(): Int {
            return newsList.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val name: TextView = itemView.findViewById(R.id.tv_name)
            private val image: ImageView = itemView.findViewById(R.id.iv_image)
            private val description: TextView = itemView.findViewById(R.id.tv_description)

            fun bind(news: News) {
                name.text = news.name
                description.text = news.description
                Glide.with(itemView.context)
                    .load(news.url)
                    .into(image)
            }
        }
    }
}