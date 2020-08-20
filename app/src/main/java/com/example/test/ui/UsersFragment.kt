package com.example.test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.test.databinding.FragmentUsuariosBinding
import com.example.test.sys.di.component.DaggerComponentUsersFragmentViewModel
import com.example.test.viewmodel.UsersFragmentViewModel
import javax.inject.Inject

/**
 * Created by Baudelio Andalon on 22.07.2020.
 */
  class UsersFragment : Fragment() {

    @Inject
    lateinit var viewModel: UsersFragmentViewModel
    lateinit var dataBindingUtil: FragmentUsuariosBinding

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerComponentUsersFragmentViewModel.create().inject(this)
        dataBindingUtil = FragmentUsuariosBinding.inflate(inflater, container,false)
        return  dataBindingUtil.root}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
    }

}