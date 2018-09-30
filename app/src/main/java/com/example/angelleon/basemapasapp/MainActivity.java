package com.example.angelleon.basemapasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);
        //map.getUiSettings().setMyLocationButtonEnabled(true);
        //map.getUiSettings().setMapToolbarEnabled(true);
        //map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng plazaGrande = new LatLng(20.9670842,-89.6259703);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(plazaGrande,18));

        MarkerOptions plazaMarker = new MarkerOptions();
        //plazaMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable...)); //cambia el icono
        plazaMarker.title("Plaza Grande");
        plazaMarker.position(plazaGrande);

        map.addMarker(plazaMarker);
    }
}
