package com.example.uielementspart2
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.core.content.ContextCompat
import java.util.*

class AlbumDetails: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        val uri = intent.getStringExtra("imageUri")
        val songsToBeDisplayed = intent.getStringArrayListExtra("songs")

        var songsArray = songsToBeDisplayed!!.toTypedArray()

        val AlbumCover = findViewById<ImageView>(R.id.albumCover)

        val albumDetailsListView = findViewById<ListView>(R.id.albumDetailsListView)

        var imageResource = getResources().getIdentifier(uri, null, getPackageName()) //Gets the resource using the URI
        var res = getResources().getDrawable(imageResource)
        AlbumCover.setImageDrawable(res)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        albumDetailsListView.adapter = adapter

        Log.i("try", songsToBeDisplayed.toString())

    }
}