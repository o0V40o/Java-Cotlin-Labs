package ru.shar.androidversions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AndroidAdapter(context: Context, private val androidList: List<Android>, val onClickListener: OnItemClickListener)
    : RecyclerView.Adapter<AndroidAdapter.ViewHolder>()
{
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_android, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, index: Int) {
        holder.bind(getItem(index), onClickListener)
    }

    override fun getItemCount(): Int {
        return androidList.size
    }

    private fun getItem(index: Int): Android = androidList[index]

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView)
    {
        private val image: ImageView = itemView.findViewById(R.id.item_image)
        private val title: TextView = itemView.findViewById(R.id.item_text)

        fun bind(version: Android, onClickListener: OnItemClickListener)
        {
            image.setImageResource(version.image)
            title.text = version.title

            itemView.setOnClickListener {
                onClickListener.OnItemClicked(version)
            }
        }
    }

    interface OnItemClickListener {
        fun OnItemClicked(itemClicked: Android)
    }
}