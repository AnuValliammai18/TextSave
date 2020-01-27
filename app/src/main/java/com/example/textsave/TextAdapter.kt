package com.example.textsave

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.text_view_layout.view.*

class TextAdapter(var textList:List<TextData>) : RecyclerView.Adapter<TextAdapter.TextViewHolder>()
{

    class TextViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
        val text_view=view.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.text_view_layout,parent,false))
    }

    override fun getItemCount():Int=textList.size

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.text_view.text=textList[position].text
    }
}