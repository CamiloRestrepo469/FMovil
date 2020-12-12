package com.example.fmovil;

import android.os.Bundle;

import com.example.fmovil.models.MovilModels;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class DetalleActivity extends BaseActivity {

    private FloatingActionButton fab_detail_list,fab_create_update;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private FirebaseStorage mFirebaseStorage;
    private DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab_create_update=findViewById(R.id.fab_create_update);
        fab_detail_list=findViewById(R.id.fab_detail_list);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mFirebaseStorage=FirebaseStorage.getInstance();

        super.init();
        init();

        //• Ver el detalle de un documento
        models= (MovilModels) getIntent().getSerializableExtra("models");

        fab_create_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maleSimpleAlertDialog("Error ","Modelos vacíos  ");
                    goToEdit(models);
            }
        });


        if(models!=null){
            maleSimpleAlertDialog("Éxito  ","Modelos :  "+models.getFirebaseid());
            Bundle bundle=new Bundle();
            bundle.putSerializable("models",models);
            DataDetailFragment.reciveData(bundle);
        }else {
            maleSimpleAlertDialog("Error ","Modelos vacíos  ");
        }
        fab_detail_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToList();
            }
        });

    }
    protected void init(){
        fab_detail_list=findViewById(R.id.fab_detail_list);
    }

    public void update(View view) {


        Toast.makeText(getApplicationContext(),"Contacto Actualizado correctamente...",Toast.LENGTH_SHORT).show();

    }
}