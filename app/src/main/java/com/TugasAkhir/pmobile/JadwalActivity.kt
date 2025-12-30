package com.TugasAkhir.pmobile.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.TugasAkhir.pmobile.adapter.JadwalAdapter
import com.TugasAkhir.pmobile.databinding.ActivityJadwalBinding
import com.TugasAkhir.pmobile.model.Jadwal
import com.TugasAkhir.pmobile.utils.FirebaseUtil

class JadwalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJadwalBinding
    private val list = arrayListOf<Jadwal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJadwalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnTambah.setOnClickListener {
            startActivity(Intent(this, TambahJadwalActivity::class.java))
        }

        loadData()
    }

    private fun loadData() {
        FirebaseUtil.db.collection("jadwal")
            .addSnapshotListener { value, _ ->
                list.clear()
                value?.forEach {
                    list.add(it.toObject(Jadwal::class.java))
                }
                binding.recyclerView.adapter = JadwalAdapter(list)
            }
    }
}
