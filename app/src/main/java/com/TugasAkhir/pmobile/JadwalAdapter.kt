package com.TugasAkhir.pmobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.TugasAkhir.pmobile.databinding.ItemJadwalBinding
import com.TugasAkhir.pmobile.model.Jadwal

class JadwalAdapter(private val list: List<Jadwal>) :
    RecyclerView.Adapter<JadwalAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemJadwalBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemJadwalBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jadwal = list[position]
        holder.binding.tvMatkul.text = jadwal.mataKuliah
        holder.binding.tvHari.text = jadwal.hari
        holder.binding.tvJam.text = jadwal.jam
    }

    override fun getItemCount() = list.size
}
