package com.miempresa.tprepaso3.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.miempresa.tprepaso3.R;
import com.miempresa.tprepaso3.databinding.FragmentGalleryBinding;
import com.miempresa.tprepaso3.databinding.FragmentSlideshowBinding;
import com.miempresa.tprepaso3.ui.slideshow.Alert;
import com.miempresa.tprepaso3.ui.slideshow.SlideshowViewModel;

public class GalleryFragment extends Fragment {

    private static final LatLng Aiello=new LatLng(-33.290004,-66.295076);
    private static final LatLng ChangoMas=new LatLng(-33.295484,-66.303139);
    private static final LatLng SupermercadoRey=new LatLng(-33.285422,-66.307424);
//private GoogleMap mapa;


    private FragmentGalleryBinding binding;
    private GalleryViewModel mv;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

             mv =   new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        SupportMapFragment smf=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        smf.getMapAsync(new MapaActual());

        return root;
    }

   /* @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/




    private class MapaActual implements OnMapReadyCallback {


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