package com.miempresa.tprepaso3.ui.home;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends AndroidViewModel {

    private final MutableLiveData<String> mText;
    private MutableLiveData<String> resultado=null;



    public HomeViewModel(@NonNull Application application) {
        super(application);
        mText = new MutableLiveData<>();
        mText.setValue("Ingrese el numero a llamar");
    }

    public LiveData<String> getResultado() {
        if (resultado == null) {

            this.resultado = new MutableLiveData<>();

        }
        return resultado;
    }

    public void llamar(String numeroTelefono) {

    if (!numeroTelefono.isEmpty() && numeroTelefono.matches("\\d+")){
        Uri uri = Uri.parse("tel:" + numeroTelefono);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         getApplication().getApplicationContext().startActivity(intent);
    }else{
        resultado.setValue("El numero no es correcto");
    }
    }


    public LiveData<String> getText() {
        return mText;
    }
}