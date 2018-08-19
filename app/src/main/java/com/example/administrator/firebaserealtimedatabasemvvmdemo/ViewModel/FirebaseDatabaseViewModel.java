package com.example.administrator.firebaserealtimedatabasemvvmdemo.ViewModel;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

public class FirebaseDatabaseViewModel {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Inject
    public FirebaseDatabaseViewModel() {
        firebaseDatabase = FirebaseDatabase.getInstance();                                             // 必須完成FirebaseSetup後才能使用, 取得Firebase連結
    }

    public DatabaseReference getDatabaseReference(String string) {
        databaseReference = firebaseDatabase.getReference(string);                                  // Firebase入面邊個目錄
        return databaseReference;
    }
}
