package ru.shar.androidversions.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import ru.itmo.androidversions.data.DataStorage
import ru.shar.androidversions.android.Android
import ru.shar.androidversions.ListAdapter
import ru.shar.androidversions.R

class ListFragment: Fragment(), ListAdapter.OnItemClickListener
{
    private val androidList: List<Android> = DataStorage.getVersionsList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.androidRecyclerView)
        recycler.adapter = this.context?.let { ListAdapter(it, androidList, this) }
        recycler.addItemDecoration(
            DividerItemDecoration(this.context, DividerItemDecoration.HORIZONTAL)
        )

        return view
    }

    override fun onItemClicked(indexOfClicked: Int)
    {
        /*activity?.supportFragmentManager?.beginTransaction()
            ?.replace(
                R.id.fragment_frame,
                DetailsFragment.newInstance(androidList[indexOfClicked])
            )
            ?.addToBackStack(null)
            ?.commit()*/

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(
                R.id.fragment_frame,
                ViewPagerFragment.newInstance(indexOfClicked)
            )
            ?.addToBackStack(null)
            ?.commit()
    }
}