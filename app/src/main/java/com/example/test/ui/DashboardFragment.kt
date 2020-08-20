package com.example.test.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.test.R
import com.example.test.databinding.FragmentDashboardBinding
import com.example.test.sys.di.component.DaggerComponentDashboardFragmentViewModel
import com.example.test.viewmodel.DashboardFragmentViewModel
import com.example.test.viewmodel.LoginViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import javax.inject.Inject


/**
 * Created by Baudelio Andalon on 22.07.2020.
 */
  class DashboardFragment : Fragment() {

    @Inject
    lateinit var viewModel: DashboardFragmentViewModel
    lateinit var binding: FragmentDashboardBinding
    private lateinit var mMap : GoogleMap
    private var mapReady = false

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerComponentDashboardFragmentViewModel.create().inject(this)
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.content_map) as SupportMapFragment
        mapFragment.getMapAsync{
            googleMap ->
            mMap = googleMap
            mapReady = true
            updateMap()
        }
        return  binding.root}

    private fun updateMap() {

    }


    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity.let {
            viewModel = ViewModelProvider(it!!).get(DashboardFragmentViewModel::class.java)
        }


    }
}