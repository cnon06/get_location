package com.cnon.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task


class MainActivity : AppCompatActivity() {


    // i suggest to try this in real phone instead emulator

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)


        var button = findViewById<Button>(R.id.getLocation)


        button.setOnClickListener {

        fetchLocation()
        }


    }




    fun fetchLocation()
    {
      //  Toast.makeText(applicationContext,"Null",Toast.LENGTH_SHORT).show()
     //   val task : Task<Location> = fusedLocationProviderClient.lastLocation

            if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
                ,101)

            return
        }

        fusedLocationProviderClient.lastLocation.addOnSuccessListener {
            println("fdfgfgh")
            if(it != null)
            {
                Toast.makeText(applicationContext,"Latitude: ${it.latitude} + Longtitude: ${it.longitude}",Toast.LENGTH_SHORT).show()
            }

        }


        /*
        task.addOnSuccessListener {
            if(it != null)
            {
                Toast.makeText(applicationContext,"${it.latitude}",Toast.LENGTH_SHORT).show()
            }


        }
         */


    }

}