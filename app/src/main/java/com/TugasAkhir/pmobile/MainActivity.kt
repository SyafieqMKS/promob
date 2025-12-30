package com.TugasAkhir.pmobile.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.TugasAkhir.pmobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJadwal.setOnClickListener {
            startActivity(Intent(this, JadwalActivity::class.java))
        }

        binding.btnTugas.setOnClickListener {
            startActivity(Intent(this, TugasActivity::class.java))
        }
    }
}
