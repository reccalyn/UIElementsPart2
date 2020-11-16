package com.example.uielementspart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView

class AlbumsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        val GridView = findViewById<GridView>(R.id.gridView) as GridView

        GridView.adapter = ImageAdapter(applicationContext)

        GridView.onItemClickListener = AdapterView.OnItemClickListener{parent, v, position, id ->
            val intent = Intent(this, AlbumDetails::class.java)
            var songsToBeDisplayed = arrayListOf<String>()
            var uri: String = ""
            if (position == 0) {
                uri = "@drawable/moira"
                songsToBeDisplayed.clear()
                songsToBeDisplayed.addAll(resources.getStringArray(R.array.moira))
            } else if (position == 1) {
                uri = "@drawable/grande"
                songsToBeDisplayed.clear()
                songsToBeDisplayed.addAll(resources.getStringArray(R.array.grande))
            } else {
                uri = "@drawable/ariana"
                songsToBeDisplayed.clear()
                songsToBeDisplayed.addAll(resources.getStringArray(R.array.ariana))
            }
            intent.putStringArrayListExtra("songs", songsToBeDisplayed )
            intent.putExtra("imageUri",  uri)
            intent.putExtra("position", position)
            startActivity(intent)


        }



    }




}