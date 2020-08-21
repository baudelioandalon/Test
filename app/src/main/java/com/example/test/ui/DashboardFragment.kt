package com.example.test.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.test.R
import com.example.test.databinding.FragmentDashboardBinding
import com.example.test.sys.di.component.DaggerComponentColorMarker
import com.example.test.sys.di.component.DaggerComponentDashboardFragmentViewModel
import com.example.test.sys.utils.ColorMarker
import com.example.test.viewmodel.DashboardFragmentViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import javax.inject.Inject


/**
 * Created by Baudelio Andalon on 22.07.2020.
 */
  class DashboardFragment : Fragment() {

    @Inject lateinit var viewModel: DashboardFragmentViewModel
    @Inject lateinit var colorMarker: ColorMarker
    private lateinit var binding: FragmentDashboardBinding

    private val DEFAULT_ZOOM = 16f

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerComponentDashboardFragmentViewModel.create().inject(this)
        DaggerComponentColorMarker.create().inject(this)
        viewModel = ViewModelProvider(this).get(DashboardFragmentViewModel::class.java)
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.content_map) as SupportMapFragment
        mapFragment.getMapAsync{ googleMap ->
            viewModel.mMap = googleMap
            viewModel.requestLocalUsers() }
        return  binding.root}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.users.observe(viewLifecycleOwner, Observer {
            it.forEach { user ->
                user.apply {
                        val place = LatLng(location.lat.toDouble(), location.log.toDouble())
                        viewModel.mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(place, DEFAULT_ZOOM))
                        viewModel.mMap!!.addMarker(MarkerOptions().position(place).title("$id \n $mail \n lat: ${this.location.lat} " +
                                "\n log: ${this.location.log}")
                            .snippet(name).draggable(false)
                            .icon(colorMarker.markerIcon).zIndex(1.0f)
                        )
                }
            }
            viewModel.sendUsers(it)
        })
    }
}