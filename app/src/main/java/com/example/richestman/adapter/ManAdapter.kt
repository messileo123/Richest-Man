package com.example.richestman.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.richestman.Model.Man
import com.example.richestman.databinding.ManItemBinding

class ManAdapter(private val manList: ArrayList<Man>): RecyclerView.Adapter<ManAdapter.ManViewHolder>() {

    var onclick: ((Man) -> Unit)? = null

    class ManViewHolder(val binding: ManItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManViewHolder {
        val view = ManItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ManViewHolder(view)
    }


    override fun getItemCount(): Int {
        return manList.size
    }

    override fun onBindViewHolder(holder: ManViewHolder, position: Int) {
        holder.binding.apply {
            ManName.text = manList[position].toString()
            MAnAge.text = "age : 60"[position].toString()
            Networht.text = "networht: 5B$"[position].toString()
            MAnImg.setImageResource(manList[position].manImg)

        }

        holder.itemView.setOnClickListener {
            onclick?.invoke(manList[position])
        }
        holder.itemView.setOnLongClickListener {
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete man Item")
                .setMessage("Are you sure you want to delete this item?")
                .setPositiveButton("Yes") { _, _ ->
                    manList.removeAt(position)
                    notifyItemRemoved(position)
                }
                .setNegativeButton("No") { _, _ -> null}
                .show()
            true

        }


    }
}









