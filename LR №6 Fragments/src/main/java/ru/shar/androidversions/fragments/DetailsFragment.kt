package ru.shar.androidversions.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.shar.androidversions.android.Android
import ru.shar.androidversions.R

class DetailsFragment : Fragment()
{
    companion object
    {
        private val key = "androidObject"

        fun newInstance(android: Android): DetailsFragment
        {
            val fragment = DetailsFragment()
            val args = Bundle()

            args.putParcelable(key, android)
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        val androidObject = arguments?.getParcelable<Android>(key)

        val Poster: ImageView = view.findViewById(R.id.poster)
        val Image: ImageView = view.findViewById(R.id.version_image)
        val Title: TextView = view.findViewById(R.id.version_title)
        val ReleaseDate: TextView = view.findViewById(R.id.release_date)
        val OverviewText: TextView = view.findViewById(R.id.overview_text)
        val TrailerButton: Button = view.findViewById(R.id.trailer_button)

        androidObject?.poster?.let { Poster.setImageResource(it) }
        androidObject?.image?.let { Image.setImageResource(it) }
        Title.setText(androidObject?.title)
        ReleaseDate.text = androidObject?.released
        OverviewText.text = androidObject?.description

        TrailerButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(androidObject?.reference))
            startActivity(intent)
        }

        return view
    }
}