package com.wakecap.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wakecap.R
import com.wakecap.model.Item
import com.wakecap.stickyheaders.HeaderAdapter
import kotlinx.android.synthetic.main.row_item.view.*
import kotlinx.android.synthetic.main.view_header.view.*

class HomeAdapter(private val context: Context, private val items: ArrayList<Item>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(), HeaderAdapter<HomeAdapter.HeaderViewHolder> {

    override fun getHeaderId(position: Int): String {
       return items[position].attributes.role
    }

    private fun getHeaderView(parent: ViewGroup): HeaderViewHolder {
        val convertView = LayoutInflater.from(context).inflate(R.layout.view_header, parent, false)
        return HeaderViewHolder(convertView)
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup): HeaderViewHolder {
        return getHeaderView(parent)
    }

    override fun onBindHeaderViewHolder(viewHolder: HeaderViewHolder, position: Int) {
        viewHolder.bind(position)
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtHeader = itemView.txtHeader
        fun bind(position: Int) {
            txtHeader.text = getHeaderId(position)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val convertView = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(convertView)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtItem = itemView.txtItem!!

        fun bind(position: Int) {
            val item = items[position]
            txtItem.text = item.attributes.fullName
        }
    }
}
