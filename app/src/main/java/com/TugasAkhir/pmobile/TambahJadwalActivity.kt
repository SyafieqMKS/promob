package com.TugasAkhir.pmobile.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.TugasAkhir.pmobile.databinding.ActivityTambahJadwalBinding
import com.TugasAkhir.pmobile.model.Jadwal
import com.TugasAkhir.pmobile.utils.FirebaseUtil

class TambahJadwalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahJadwalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahJadwalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSimpan.setOnClickListener {
            val jadwal = Jadwal(
                binding.etMatkul.text.toString(),
                binding.etHari.text.toString(),
                binding.etJam.text.toString()
            )

            FirebaseUtil.db.collection("jadwal").add(jadwal)
                .addOnSuccessListener {
                    Toast.makeText(this, "Jadwal tersimpan", Toast.LENGTH_SHORT).show()
                    finish()
                }
        }
    }
}
