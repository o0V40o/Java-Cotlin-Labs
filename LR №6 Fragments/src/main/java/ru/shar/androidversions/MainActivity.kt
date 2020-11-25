package ru.shar.androidversions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.shar.androidversions.fragments.ListFragment

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null)
        {
            val listFragment = ListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_frame, listFragment)
                .commit()
        }
    }
}