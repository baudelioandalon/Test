package com.example.test.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.test.R
import com.example.test.databinding.ActivityMenuPrincipalBinding
import com.example.test.sys.di.component.DaggerComponentMenuViewModel
import com.example.test.sys.di.component.DaggerComponentPrettyToast
import com.example.test.sys.utils.PrettyToast
import com.example.test.sys.utils.validation.enums.TypePrettyToast
import com.example.test.viewmodel.MenuViewModel
import javax.inject.Inject

class MenuPrincipal : AppCompatActivity() {

    @Inject lateinit var viewModel: MenuViewModel
    @Inject lateinit var prettyToast: PrettyToast
    lateinit var binding: ActivityMenuPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)
        DaggerComponentMenuViewModel.create().inject(this)
        DaggerComponentPrettyToast.create().inject(this)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        lifecycle.addObserver(viewModel)
        binding = DataBindingUtil.setContentView<ActivityMenuPrincipalBinding>(this,
            R.layout.activity_menu_principal
        ).apply {
            //*** Con el apply puedes acceder a lo que está dentro del elemento ***
            this.lifecycleOwner = this@MenuPrincipal
            this.viewModel = viewModel
        }
        viewModel.data.observeForever {
            it.apply {
                if (success) {
//                    prettyToast.showToast("Datos obtenidos con exito", TypePrettyToast.SUCCESS_TOAST, this@MenuPrincipal)
                } else {
                    prettyToast.showToast(error?.message.toString(), TypePrettyToast.ERROR_TOAST, this@MenuPrincipal)
                    Log.e("data code", code.toString())
                    Log.e("data error", error?.message.toString())
                }
            }
        }

        binding.misEmpleados.setOnClickListener {
            startActivity(Intent(this, InicioActivity::class.java))
            finish()
        }
        binding.addEmpleado.setOnClickListener {
            startActivity(Intent(this, NewColaboradorActivity::class.java))
        }

    }

}