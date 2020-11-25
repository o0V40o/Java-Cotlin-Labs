package ru.shar.androidversions.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.shar.androidversions.android.Android
import ru.shar.androidversions.fragments.DetailsFragment

class ViewPagerAdapter(private val androidList: List<Android>, fragManager: FragmentManager)
    : FragmentPagerAdapter(
        fragManager,
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    )
{
    override fun getItem(index: Int): Fragment {
        return DetailsFragment.newInstance(androidList[index])
    }

    override fun getCount(): Int {
        return androidList.size
    }
}