package com.TugasAkhir.pmobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.TugasAkhir.pmobile.databinding.ItemTugasBinding
import com.TugasAkhir.pmobile.model.Tugas

class TugasAdapter(private val list: List<Tugas>) :
    RecyclerView.Adapter<TugasAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemTugasBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTugasBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tugas = list[position]
        holder.binding.tvNamaTugas.text = tugas.namaTugas
        holder.binding.tvDeadline.text = tugas.deadline
    }

    override fun getItemCount() = list.size
}
