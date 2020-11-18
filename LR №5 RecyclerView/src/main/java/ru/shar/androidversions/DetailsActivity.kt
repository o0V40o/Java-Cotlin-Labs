package ru.shar.androidversions

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val Poster: ImageView = findViewById(R.id.poster)
        val Image: ImageView = findViewById(R.id.version_image)
        val Title: TextView = findViewById(R.id.version_title)
        val ReleaseDate: TextView = findViewById(R.id.release_date)
        val OverviewText: TextView = findViewById(R.id.overview_text)
        val TrailerButton: Button = findViewById(R.id.trailer_button)

        Poster.setImageResource(intent.getIntExtra("poster", 1))
        Image.setImageResource(intent.getIntExtra("image", 1))
        Title.setText(intent.getStringExtra("title"))
        ReleaseDate.setText(intent.getStringExtra("released"))
        OverviewText.setText(intent.getStringExtra("description"))

        TrailerButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(intent.getStringExtra("reference")))
            startActivity(intent)
        }
    }
}
