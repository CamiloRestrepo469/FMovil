package com.example.fmovil;

import android.os.Bundle;

import com.example.fmovil.adaters.MovilAdapter;
import com.example.fmovil.conection.firebaseConection;
import com.example.fmovil.models.MovilModels;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EditarActivity extends BaseActivity {

    private static final String TAG ="TAG" ;
    protected MovilModels models;
    protected ArrayList<MovilModels> modelsArrayList;
    protected MovilAdapter adapter;

    protected FirebaseFirestore db;
    protected FirebaseAuth mAuth;
    protected FirebaseStorage mFirebaseStorage;

    protected Query query;
    protected CollectionReference collectionReference;
    protected StorageReference mStorageReference,fileReference;

    protected final String COLLECTION_NAME = "registro";
    private EditText editText_editar_consecutivo, editText_editar_marca, editText_editar_concepto;
    private FloatingActionButton fab_editar_update_guardar, fab_eliminar_;

    private DocumentReference documentReference;
    private Object String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       db = FirebaseFirestore.getInstance();
        super.init();
        init();
        init2();
        fab_editar_update_guardar = findViewById(R.id.fab_editar_update_guardar);
        fab_eliminar_ = findViewById(R.id.fab_eliminar_);

        editText_editar_consecutivo = findViewById(R.id.editText_editar_consecutivo);
        editText_editar_marca = findViewById(R.id.editText_editar_marca);
        editText_editar_concepto = findViewById(R.id.editText_editar_concepto);

        models= (MovilModels) getIntent().getSerializableExtra("models");
        Toast.makeText(getApplicationContext(), "voy en el modelo "  , Toast.LENGTH_LONG).show();
            if(models!=null){
                Toast.makeText(getApplicationContext(), "treje el modelo "  , Toast.LENGTH_LONG).show();
                editText_editar_concepto.setText(models.getConcepto());
                editText_editar_marca.setText(models.getMarca());
                editText_editar_consecutivo.setText(models.getConsecutivo());
            update(models);
            }else {
                Toast.makeText(getApplicationContext(), "No recibimos nada de nada"  , Toast.LENGTH_LONG).show();

                editText_editar_concepto.setText("No recibimos nada");
                editText_editar_marca.setText("No recibimos nada");
                editText_editar_consecutivo.setText("No recibimos nada");


//            update(models);
        }



        fab_editar_update_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(models);
            }
        });
    }

    protected void init2(){
        models = new MovilModels();
        db = firebaseConection.ConectionFirestore();
        mAuth = firebaseConection.ConectionAuth();
        mFirebaseStorage = firebaseConection.ConectionStorage();
        collectionReference = db.collection(COLLECTION_NAME);
    }
    private void update(final MovilModels models) {
        documentReference=db.collection(COLLECTION_NAME).document(models.getConsecutivo());
        documentReference.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "estoy en el get"  , Toast.LENGTH_LONG).show();
                            DocumentSnapshot document=task.getResult();
                            document.toObject(MovilModels.class);
                            models.getConsecutivo();
                            models.getMarca();
                            models.getConcepto();
                            if(models!=null){
                                Toast.makeText(getApplicationContext(), "estoy en el set"  , Toast.LENGTH_LONG).show();

                                editText_editar_concepto.setText(models.getConcepto());
                                editText_editar_consecutivo.setText(models.getConsecutivo());
                                editText_editar_marca.setText(models.getMarca());
                            }
                            updateModelo(models);
                        }
                        

                    }
                });


    }

    private void updateModelo(MovilModels models) {
        models.setConsecutivo(editText_editar_consecutivo.getText().toString());
        models.setMarca(editText_editar_marca.getText().toString());
        models.setConcepto(editText_editar_concepto.getText().toString());
        documentReference=db.collection(COLLECTION_NAME).document(models.getConsecutivo());
        documentReference.set(models)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG,"termino de actualizar");
                        }

                    }
                });
    }

    private void clear(){

    }
}