package com.TugasAkhir.pmobile.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.TugasAkhir.pmobile.adapter.TugasAdapter
import com.TugasAkhir.pmobile.databinding.ActivityTugasBinding
import com.TugasAkhir.pmobile.model.Tugas
import com.TugasAkhir.pmobile.utils.FirebaseUtil

class TugasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTugasBinding
    private val list = arrayListOf<Tugas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnTambah.setOnClickListener {
            startActivity(Intent(this, TambahTugasActivity::class.java))
        }

        FirebaseUtil.db.collection("tugas")
            .addSnapshotListener { value, _ ->
                list.clear()
                value?.forEach {
                    list.add(it.toObject(Tugas::class.java))
                }
                binding.recyclerView.adapter = TugasAdapter(list)
            }
    }
}
