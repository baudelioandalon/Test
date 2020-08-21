package com.example.test.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.test.R
import com.example.test.databinding.ActivityNewColaboradorBinding
import com.example.test.network.model.jsonModel.Employee
import com.example.test.network.model.jsonModel.Location
import com.example.test.sys.di.component.*
import com.example.test.sys.utils.PrettyToast
import com.example.test.sys.utils.TextChanged
import com.example.test.sys.utils.validation.Valid
import com.example.test.sys.utils.menusliding.StatusBarChangeColor
import com.example.test.sys.utils.validation.Element
import com.example.test.sys.utils.validation.ValidationMetrics
import com.example.test.sys.utils.validation.enums.TypeActionFromValidation
import com.example.test.sys.utils.validation.enums.TypeComponent
import com.example.test.sys.utils.validation.enums.TypePrettyToast
import com.example.test.sys.utils.validation.enums.TypeValidation
import com.example.test.viewmodel.NewColaboradorViewModel
import com.google.android.gms.tasks.Task
import org.jetbrains.annotations.NotNull
import javax.inject.Inject

class NewColaboradorActivity: AppCompatActivity() {

    @Inject lateinit var statusBarChangeColor: StatusBarChangeColor
    @Inject lateinit var viewModel: NewColaboradorViewModel
    @Inject lateinit var valid: Valid
    @Inject lateinit var changed: TextChanged
    @Inject lateinit var prettyToast: PrettyToast
    private lateinit var binding: ActivityNewColaboradorBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(@NotNull savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_colaborador)

        //Dagger INIT
        DaggerComponentStatusBarChangeColor.create().inject(this)
        DaggerComponentNewColaboradorViewModel.create().inject(this)
        DaggerComponentValid.create().inject(this)
        DaggerComponentTextChanged.create().inject(this)
        DaggerComponentPrettyToast.create().inject(this)

        //ViewModel INIT
        viewModel = ViewModelProvider(this).get(NewColaboradorViewModel::class.java)

        //ChangeColorTop
        statusBarChangeColor.changeColor(this,null,null, null,
            viewModel.topColors.value!!, this::class.java.simpleName)

        binding = DataBindingUtil.setContentView<ActivityNewColaboradorBinding>(this,
            R.layout.activity_new_colaborador).apply {
            this.lifecycleOwner = this@NewColaboradorActivity
            this.viewModel = viewModel }

        //Binding & TextWatcher
        binding.txtName.addTextChangedListener(changed.tWatcher(binding.txtName))
        binding.txtMail.addTextChangedListener(changed.tWatcher(binding.txtMail))
        binding.txtLat.addTextChangedListener(changed.tWatcher(binding.txtLat))
        binding.txtLog.addTextChangedListener(changed.tWatcher(binding.txtLog))

    }

    fun closeNewColaborador(view: View) {
        cleanElements(null)
        finish()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun cleanElements(view: View?) {
        binding.txtName.setText("")
        binding.txtMail.setText("")
        binding.txtLat.setText("")
        binding.txtLog.setText("")
    }

    fun sendData(view: View) {
        if(valid.isValid(this, arrayOf(
                Element( arrayOf(ValidationMetrics(TypeValidation.LIMIT, null, null,
                    5, null, TypeActionFromValidation.CHANGE_DRAWABLE)),
                    binding.txtName, TypeComponent.EDIT_TEXT),
                Element( arrayOf(ValidationMetrics(TypeValidation.EMAIL, null, null,
                    1, null, TypeActionFromValidation.CHANGE_DRAWABLE)),
                    binding.txtMail, TypeComponent.EDIT_TEXT),
                Element( arrayOf(ValidationMetrics(TypeValidation.LIMIT, null, null,
                    1, null, TypeActionFromValidation.CHANGE_DRAWABLE)),
                    binding.txtLat, TypeComponent.EDIT_TEXT),
                Element( arrayOf(ValidationMetrics(TypeValidation.LIMIT, null, null,
                    1, null, TypeActionFromValidation.CHANGE_DRAWABLE)),
                    binding.txtLog, TypeComponent.EDIT_TEXT)))){

                viewModel.sendUsers(arrayListOf(Employee("2423",
                    Location("23.324", "34.222"),binding.txtMail.text.toString().trim(),
                    binding.txtName.text.toString().trim())), observerSet())

        }
    }

    private fun observerSet(): Observer<Task<Void>> {
        return Observer {
            if(it.isSuccessful){
                prettyToast.showToast("Correct", TypePrettyToast.SUCCESS_TOAST, this)
            }else{
                prettyToast.showToast("Algo salio mal", TypePrettyToast.ERROR_TOAST, this)
            }
        }
    }

}