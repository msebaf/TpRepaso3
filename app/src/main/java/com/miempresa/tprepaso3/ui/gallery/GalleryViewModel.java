package com.miempresa.tprepaso3.ui.gallery;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.miempresa.tprepaso3.R;

public class GalleryViewModel extends ViewModel {

    private static final LatLng Aiello=new LatLng(-33.290004,-66.295076);
    private static final LatLng ChangoMas=new LatLng(-33.295484,-66.303139);
    private static final LatLng SupermercadoRey=new LatLng(-33.285422,-66.307424);


    private MutableLiveData<MapaActual> sm= null;

    public LiveData<MapaActual> GetMap() {
        if (sm == null) {

            this.sm = new MutableLiveData<>();

        }
        return sm;
    }

    public void llamarMapa() {
       sm.setValue(new MapaActual());
    }

    public class MapaActual implements OnMapReadyCallback {


        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            googleMap.addMarker(new MarkerOptions().position(ChangoMas).title("Chango mas"));
            googleMap.addMarker(new MarkerOptions().position(Aiello).title("Aiello"));
            googleMap.addMarker(new MarkerOptions().position(SupermercadoRey).title("Supermercado Rey"));
            CameraPosition camPos=new CameraPosition.Builder()
                    .target(ChangoMas)
                    .zoom(15)
                    .bearing(0)
                    .tilt(70)
                    .build();
            CameraUpdate update= CameraUpdateFactory.newCameraPosition(camPos);
            googleMap.animateCamera(update);

        }
    }
}