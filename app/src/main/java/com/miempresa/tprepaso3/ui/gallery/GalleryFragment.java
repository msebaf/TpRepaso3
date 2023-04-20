package com.miempresa.tprepaso3.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
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


//private GoogleMap mapa;


    private FragmentGalleryBinding binding;
    private GalleryViewModel mv;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

             mv =   new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv.GetMap().observe(getViewLifecycleOwner(), new Observer<GalleryViewModel.MapaActual>() {
            @Override
            public void onChanged(GalleryViewModel.MapaActual mapaActual) {
                SupportMapFragment smf=(SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
                smf.getMapAsync(mapaActual);
            }
        });

            mv.llamarMapa();


        return root;
    }

   /* @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/






}