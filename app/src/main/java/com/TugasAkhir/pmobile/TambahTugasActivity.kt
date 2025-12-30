package com.TugasAkhir.pmobile.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.TugasAkhir.pmobile.databinding.ActivityTambahTugasBinding
import com.TugasAkhir.pmobile.model.Tugas
import com.TugasAkhir.pmobile.utils.FirebaseUtil

class TambahTugasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahTugasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahTugasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSimpan.setOnClickListener {
            val tugas = Tugas(
                binding.etNama.text.toString(),
                binding.etDeadline.text.toString(),
                binding.etDeskripsi.text.toString()
            )

            FirebaseUtil.db.collection("tugas").add(tugas)
                .addOnSuccessListener {
                    Toast.makeText(this, "Tugas ditambahkan", Toast.LENGTH_SHORT).show()
                    finish()
                }
        }
    }
}
