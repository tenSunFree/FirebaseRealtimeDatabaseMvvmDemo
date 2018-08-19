package com.example.administrator.firebaserealtimedatabasemvvmdemo.ViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class FirebaseDatabaseChangeDataViewModel {

    private ArrayList<String> numberValueArrayList;

    @Inject
    public FirebaseDatabaseChangeDataViewModel() {
        numberValueArrayList = new ArrayList<String>();
    }

    public ArrayList<String> getNumberValueArrayList() {
        return numberValueArrayList;
    }
}
