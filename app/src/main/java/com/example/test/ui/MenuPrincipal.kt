package com.example.test.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.test.R
import com.example.test.databinding.ActivityMenuPrincipalBinding
import com.example.test.sys.di.component.DaggerComponentMenuViewModel
import com.example.test.sys.di.component.DaggerComponentPrettyToast
import com.example.test.sys.utils.PrettyToast
import com.example.test.sys.utils.TypePrettyToast
import com.example.test.viewmodel.MenuViewModel
import javax.inject.Inject

class MenuPrincipal : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MenuViewModel
    @Inject
    lateinit var prettyToast: PrettyToast
    lateinit var binding: ActivityMenuPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)
        DaggerComponentMenuViewModel.create().inject(this)
        DaggerComponentPrettyToast.create().inject(this)
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
                    prettyToast.showToast("Datos obtenidos con exito", TypePrettyToast.SUCCESS_TOAST, this@MenuPrincipal)
                    saveData(it.data!!.file)
                } else {
                    prettyToast.showToast(error?.message.toString(), TypePrettyToast.ERROR_TOAST, this@MenuPrincipal)
                    Log.e("data code", code.toString())
                    Log.e("data error", error?.message.toString())
                }
            }
        }

        binding.misEmpleados.setOnClickListener {
            startActivity(Intent(this, InicioActivity::class.java))
        }

    }

    private fun saveData(json: String) {
//        Log.e("empleado json", json)
//        val arrayListTutorialType = object : TypeToken<UserModel>() {}.type
//        val gson = Gson()
//        gson.apply {
//            val element: JsonElement = fromJson(toJsonTree(json), JsonElement::class.java)
//            Log.e("elemento", element.asJsonObject.toString())
//        }

//        val db = Room.databaseBuilder(applicationContext, AppDB::class.java, "userDB").build()
//        val user = UserEntity()
//        Thread{
//            db.clearAllTables()
//
//            db.userDAO().saveUser(user)
//        }.start()
    }
}