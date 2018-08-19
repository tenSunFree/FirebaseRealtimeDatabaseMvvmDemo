package com.example.administrator.firebaserealtimedatabasemvvmdemo.View;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.firebaserealtimedatabasemvvmdemo.DependencyInjection.AppPackage.MyApplication;
import com.example.administrator.firebaserealtimedatabasemvvmdemo.R;
import com.example.administrator.firebaserealtimedatabasemvvmdemo.ViewModel.FirebaseDatabaseChangeDataViewModel;
import com.example.administrator.firebaserealtimedatabasemvvmdemo.ViewModel.FirebaseDatabaseViewModel;
import com.example.administrator.firebaserealtimedatabasemvvmdemo.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    public FirebaseDatabaseViewModel firebaseDatabaseViewModel;
    @Inject
    public FirebaseDatabaseChangeDataViewModel firebaseDatabaseChangeDataViewModel;

    public ActivityMainBinding activityMainBinding;
    private ViewAdapter viewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialization();
        firebaseValueEventListener();

        activityMainBinding.addButton.setOnClickListener(this);
        activityMainBinding.deleteButton.setOnClickListener(this);
    }

    private void firebaseValueEventListener() {
        firebaseDatabaseViewModel
                .getDatabaseReference("test")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        firebaseDatabaseChangeDataViewModel.getNumberValueArrayList().clear();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            firebaseDatabaseChangeDataViewModel.getNumberValueArrayList()
                                    .add(ds.child("number").getValue().toString());
                        }
                        viewAdapter = new ViewAdapter(
                                firebaseDatabaseChangeDataViewModel.getNumberValueArrayList());
                        activityMainBinding.firebaseListView.setAdapter(viewAdapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
    }

    private void Initialization() {
        activityMainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        firebaseDatabaseViewModel = MyApplication.firebaseComponent.firebaseDatabaseViewModel();
        firebaseDatabaseChangeDataViewModel = MyApplication.firebaseComponent.FirebaseDatabaseChangeDataViewModel();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addButton:
                if (!activityMainBinding.inputEditText.getText().toString().equals("")) {
                    activityMainBinding.addButton.setClickable(false);
                    firebaseDatabaseViewModel.getDatabaseReference("test")
                            .child("" + (firebaseDatabaseChangeDataViewModel.getNumberValueArrayList().size() + 1))
                            .child("number").setValue(activityMainBinding.inputEditText.getText().toString());
                    activityMainBinding.inputEditText.setText("");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            activityMainBinding.addButton.setClickable(true);
                        }
                    }, 1000);
                } else {
                    Toast.makeText(MyApplication.getInstance(), "請先輸入", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.deleteButton:
                activityMainBinding.deleteButton.setClickable(false);
                firebaseDatabaseViewModel.getDatabaseReference("test")
                        .child("" + (firebaseDatabaseChangeDataViewModel.getNumberValueArrayList().size()))
                        .child("number").removeValue();
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        activityMainBinding.deleteButton.setClickable(true);
                    }}, 1000);
                break;
        }
    }
}
