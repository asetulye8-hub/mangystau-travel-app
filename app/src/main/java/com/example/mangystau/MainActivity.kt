package com.example.mangystau

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mangystau.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var places: List<Place>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        places = listOf(
            Place("Шақпақ ата", "Маңғыстаудың танымал табиғи көрікті жері", R.drawable.shakpak_ata, 44.735, 50.601),
            Place("Бозжыра", "Құмды және таулы аймақ", R.drawable.bozzhira, 44.746, 50.620)
        )

        val adapter = PlaceAdapter(places) { place ->
            val intent = Intent(this, PlaceDetailActivity::class.java)
            intent.putExtra("placeName", place.name)
            intent.putExtra("placeDescription", place.description)
            intent.putExtra("placeImage", place.image)
            intent.putExtra("placeLat", place.lat)
            intent.putExtra("placeLng", place.lng)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}
