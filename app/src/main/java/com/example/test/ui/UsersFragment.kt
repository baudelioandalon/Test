package com.example.test.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.test.adapter.CustomAdapter
import com.example.test.adapter.CustomListeners
import com.example.test.databinding.FragmentUsuariosBinding
import com.example.test.network.model.jsonModel.Employee
import com.example.test.sys.di.component.DaggerComponentUsersFragmentViewModel
import com.example.test.viewmodel.UsersFragmentViewModel
import javax.inject.Inject

/**
 * Created by Baudelio Andalon on 22.07.2020.
 */
  class UsersFragment : Fragment(), CustomListeners {

    @Inject
    lateinit var viewModel: UsersFragmentViewModel
    lateinit var binding: FragmentUsuariosBinding

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerComponentUsersFragmentViewModel.create().inject(this)
        binding = FragmentUsuariosBinding.inflate(inflater, container,false)
        viewModel = ViewModelProvider(this).get(UsersFragmentViewModel::class.java)
        lifecycle.addObserver(viewModel)
        return  binding.root}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setRecyclerview()
    }

    private fun setRecyclerview() {
        binding.recyclerProductos.adapter = CustomAdapter(this)
        viewModel.users.observe(viewLifecycleOwner, Observer {
            (binding.recyclerProductos.adapter as CustomAdapter).submitList(it) })

    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
    }

    override fun onShow(item: Employee, position: Int) {
        TODO("Not yet implemented")
    }

}