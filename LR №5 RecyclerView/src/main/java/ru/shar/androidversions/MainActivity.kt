package ru.shar.androidversions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import ru.itmo.androidversions.data.DataStorage

class MainActivity : AppCompatActivity(), AndroidAdapter.OnItemClickListener
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val androidList = DataStorage.getVersionsList()

        val adapter = AndroidAdapter(this, androidList, this)

        val recycler = findViewById<RecyclerView>(R.id.androidRecyclerView)
        recycler.adapter = adapter

        val decoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        //decoration.setDrawable(ContextCompat.getDrawable(this, R.color.colorPrimary)!!)
        recycler.addItemDecoration(decoration)
    }

    override fun OnItemClicked(itemClicked: Android)
    {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("title", itemClicked.title)
        intent.putExtra("image", itemClicked.image)
        intent.putExtra("poster", itemClicked.poster)
        intent.putExtra("description", itemClicked.description)
        intent.putExtra("released", itemClicked.released)
        intent.putExtra("reference", itemClicked.reference)
        startActivity(intent)
    }
}
