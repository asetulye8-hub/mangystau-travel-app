package com.example.mangystau

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mangystau.databinding.ActivityPlaceDetailBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class PlaceDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaceDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("placeName")
        val description = intent.getStringExtra("placeDescription")
        val image = intent.getIntExtra("placeImage", 0)
        val lat = intent.getDoubleExtra("placeLat", 0.0)
        val lng = intent.getDoubleExtra("placeLng", 0.0)

        binding.placeName.text = name
        binding.placeDescription.text = description
        binding.placeImage.setImageResource(image)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            val location = LatLng(lat, lng)
            googleMap.addMarker(MarkerOptions().position(location).title(name))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
        }
    }
}
