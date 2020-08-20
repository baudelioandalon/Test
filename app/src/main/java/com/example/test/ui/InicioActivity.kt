package com.example.test.ui

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.ActivityInicioBinding
import com.example.test.sys.di.component.DaggerComponentInicioViewModel
import com.example.test.sys.di.component.DaggerComponentMethodMenu
import com.example.test.sys.di.component.DaggerComponentStatusBarChangeColor
import com.example.test.sys.utils.MethodMenu
import com.example.test.sys.utils.menusliding.DrawerAdapter
import com.example.test.sys.utils.menusliding.SlidingStatus
import com.example.test.sys.utils.menusliding.StatusBarChangeColor
import com.example.test.viewmodel.InicioViewModel
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder
import org.jetbrains.annotations.NotNull
import javax.inject.Inject

class InicioActivity : AppCompatActivity(), DrawerAdapter.OnItemSelectedListener {

    //Dagger
    @Inject lateinit var methodMenu: MethodMenu
    @Inject lateinit var statusBarChangeColor: StatusBarChangeColor
    @Inject lateinit var viewModel: InicioViewModel

    lateinit var dataBindingUtil: ActivityInicioBinding
    lateinit var slidingRootNav: SlidingRootNav

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(@NotNull savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        DaggerComponentMethodMenu.create().inject(this)
        DaggerComponentStatusBarChangeColor.create().inject(this)
        DaggerComponentInicioViewModel.create().inject(this)
        viewModel =  ViewModelProvider(this).get(InicioViewModel::class.java)
        dataBindingUtil = DataBindingUtil.setContentView<ActivityInicioBinding>(this,
            R.layout.activity_inicio).apply {
            //*** Con el apply puedes acceder a lo que está dentro del elemento ***
            this.lifecycleOwner = this@InicioActivity
            this.viewModel = viewModel
        }

        slidingRootNav = SlidingRootNavBuilder(this)
            .withMenuOpened(viewModel.stateMenu.value!!)
            .withContentClickableWhenMenuOpened(true)
            .withMenuLayout(R.layout.menu_left_drawer)
            .inject()

        statusBarChangeColor.changeColor(this, viewModel.stateMenu.value!!, viewModel.position.value!!, SlidingStatus.STARTING, viewModel.topColors.value!!, null)

        //Mantiene el SlidingRootNav en la misma seleccion tras el giro
        slidingRootNav.layout.addDragListener {
            when(it.toInt()){
                0 -> {
                    viewModel.stateMenu.postValue(false)
                    statusBarChangeColor.changeColor(this, viewModel.stateMenu.value!!, viewModel.position.value!!, SlidingStatus.CLOSED, viewModel.topColors.value!!, this::class.java.simpleName)
                }
                else -> {
                    viewModel.stateMenu.postValue(true)
                    statusBarChangeColor.changeColor(this, viewModel.stateMenu.value!!, viewModel.position.value!!, SlidingStatus.OPENED, viewModel.topColors.value!!, this::class.java.simpleName)
                }
            }
        }
        val adapter = DrawerAdapter(listOf(
            methodMenu.createItemFor(0, loadScreenTitles(), loadScreenIcons(), this).setChecked(true),
            methodMenu.createItemFor(1,loadScreenTitles(), loadScreenIcons(), this)))
        adapter.setListener(this)
        val list: RecyclerView = findViewById(R.id.list)
        list.isNestedScrollingEnabled = true
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
        adapter.setSelected(viewModel.position.value!!)
        //INICIALIZACION DE LOS OBSERVERS
        viewModel.position.observe(this, Observer {
            showFragment(viewModel.fragmentsInicio.value!![it])
        })

    }
    private fun loadScreenTitles(): Array<String> {
        return resources.getStringArray(R.array.ld_activityScreenTitles)
    }

    private fun loadScreenIcons(): Array<Drawable?> {
        val ta = resources.obtainTypedArray(R.array.ld_activityScreenIcons)
        val icons = arrayOfNulls<Drawable>(ta.length())
        for (i in 0 until ta.length()) {
            val id = ta.getResourceId(i, 0)
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id)
            }
        }
        ta.recycle()
        return icons
    }
    override fun onItemSelected(position: Int) {
        slidingRootNav.closeMenu()
        viewModel.position.postValue(position)
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

}