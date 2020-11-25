package ru.shar.androidversions.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import ru.itmo.androidversions.data.DataStorage
import ru.shar.androidversions.R
import ru.shar.androidversions.adapters.ViewPagerAdapter
import ru.shar.androidversions.android.Android

class ViewPagerFragment: Fragment()
{
    private var key: String? = null
    private var index: Int? = null
    private val androidList: List<Android> = DataStorage.getVersionsList()

    companion object {
        fun newInstance(index: Int): ViewPagerFragment
        {
            val fragment = ViewPagerFragment()
            fragment.key = "index"
            val args = Bundle()
            args.putInt(fragment.key, index)
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            index = it.getInt(key)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val view = inflater.inflate(R.layout.fragment_viewpager, container, false)
        val pager = view.findViewById<ViewPager>(R.id.viewpager)

        pager.adapter = ViewPagerAdapter(androidList, childFragmentManager)
        pager.isSaveFromParentEnabled = false
        index?.let { pager.setCurrentItem(it, false) }

        return view
    }
}