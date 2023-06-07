package com.example.cobatokped.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cobatokped.core.data.source.remote.network.State
import com.example.cobatokped.core.data.source.remote.request.LoginRequest
import com.example.cobatokped.databinding.ActivityLoginBinding
import com.example.cobatokped.util.Prefs
import com.inyongtisto.myhelper.extension.isEmpty
import com.inyongtisto.myhelper.extension.showToast
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toVisible
import com.inyongtisto.myhelper.extension.toastError
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

    private fun setData() {
        viewModel.text.observe(this, {
        binding.edtEmail.setText(it)
        })

        binding.btnMasuk.setOnClickListener {
            login()
        }
    }

    private fun login() {

        if (binding.edtEmail.isEmpty()) return
        if (binding.edtPassword.isEmpty()) return

        val body = LoginRequest(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )

        viewModel.login(body).observe(this, {

            when (it.state){
                State.SUCCESS ->{
                    binding.pd.toGone()
                    showToast("Selamat Datang "+it.data?.name)
                }
                State.ERROR -> {
                    binding.pd.toGone()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
                    binding.pd.toVisible()
                }
            }
        })
    }
}
