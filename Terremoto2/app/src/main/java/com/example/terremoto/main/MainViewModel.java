package com.example.terremoto.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.terremoto.Earthquake;
import com.example.terremoto.database.EqDatabase;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final MainRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        EqDatabase database = EqDatabase.getDatabase(application);
        repository = new MainRepository(database);
    }


    public LiveData<List<Earthquake>> getEqList() {
        return repository.getEqList();
    }

    public void downloadEarthquakes() {
        repository.downloadAndSaveEarthquakes();
    }


}
