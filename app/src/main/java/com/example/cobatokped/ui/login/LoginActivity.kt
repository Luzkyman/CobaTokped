package com.example.cobatokped.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cobatokped.databinding.ActivityLoginBinding
import com.example.cobatokped.util.Prefs
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel : LoginViewModel by viewModel()
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }

    fun setData() {
        viewModel.text.observe(this, {
        binding.edtEmail.setText(it)
        })

        binding.btnMasuk.setOnClickListener {
            viewModel.ubahData()
        }
    }
    fun testingData() {
        val s = Prefs(this)
        if(s.getIsLogin()){
            binding.tvStatus.text = "Sudah Login"
        } else binding.tvStatus.text = "Belum Login"

        binding.btnLogin.setOnClickListener {
            s.setIsLogin(true)
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnLogout.setOnClickListener {
            s.setIsLogin(false)
            onBackPressedDispatcher.onBackPressed()
        }

        Log.d("Respon", "pesan singkat")
    }



}