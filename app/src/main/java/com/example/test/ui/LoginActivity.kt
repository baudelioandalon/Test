package com.example.test.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.test.R
import com.example.test.data.datasource.local.AppDB
import com.example.test.databinding.ActivityLoginBinding
import com.example.test.sys.di.App
import com.example.test.sys.di.component.DaggerComponentLoginViewModel
import com.example.test.sys.di.component.DaggerComponentPrettyToast
import com.example.test.sys.di.module.enums.StartSessionResult
import com.example.test.sys.utils.PrettyToast
import com.example.test.sys.utils.validation.enums.TypePrettyToast
import com.example.test.viewmodel.LoginViewModel
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    //Dagger
    @Inject lateinit var prettyToast: PrettyToast
    @Inject lateinit var viewModel: LoginViewModel

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        DaggerComponentPrettyToast.create().inject(this)
        DaggerComponentLoginViewModel.create().inject(this)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        AppDB.get(App.getAppContext())
        binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this,
                R.layout.activity_login).apply {
            //*** Con el apply puedes acceder a lo que está dentro del elemento ***
            this.lifecycleOwner = this@LoginActivity
            this.viewModelLogin = viewModelLogin
        }

        viewModel.loggingUser.observeForever {
            binding.apply {
                if(it){
                    scrollContent.visibility = View.GONE
                    imgStarting.visibility = View.VISIBLE
                }else{
                    scrollContent.visibility = View.VISIBLE
                    imgStarting.visibility = View.GONE
                }
            }
        }
        viewModel.onRequestLoginSuccessful.observeForever{auth ->
            when(auth.sessionCode){
                StartSessionResult.CORRECT -> {
                    prettyToast.showToast("Bienvenido", TypePrettyToast.SUCCESS_TOAST, this)
                    startActivity(Intent(this, MenuPrincipal::class.java))
                    binding.scrollContent.visibility = View.VISIBLE
                    binding.imgStarting.visibility = View.GONE
                    finish()
                }
                StartSessionResult.EMAIL_NOT_VERIFIED -> {
                    prettyToast.showToast("Verifique el correo electronico, antes de iniciar sesion", TypePrettyToast.ERROR_TOAST, this)
                }
                StartSessionResult.INCORRECT -> {
                    prettyToast.showToast("Algunos datos son incorrectos", TypePrettyToast.ERROR_TOAST, this)
                }
            }
        }
    }
    private fun logging(){
        val user = binding.txtEmail.text.toString().trim()
        val pass = binding.txtPassword.text.toString().trim()
        if(user.isEmpty() || pass.isEmpty()){
            return prettyToast.showToast("Vacio", TypePrettyToast.WARNING_TOAST, this)
        }
        viewModel.requestLogin(user, pass)
        viewModel.loggingUser.postValue(true)
    }

    fun startSession(view: View) {
        logging()
    }
}