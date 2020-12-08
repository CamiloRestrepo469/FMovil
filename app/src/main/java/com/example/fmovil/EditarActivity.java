package com.example.fmovil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.example.fmovil.adaters.MovilAdapter;
import com.example.fmovil.models.MovilModels;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
    protected StorageReference mStorageReference, fileReference;

    protected final String COLLECTION_NAME = "registro";
    private EditText editText_editar_consecutivo, editText_editar_marca, editText_editar_concepto;
    private FloatingActionButton fab_editar_update_guardar, fab_eliminar_;

    private DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mFirebaseStorage = FirebaseStorage.getInstance();

        models= (MovilModels) getIntent().getSerializableExtra("models");
//        models = new MovilModels();

        super.init();
        init();

        editText_editar_consecutivo = findViewById(R.id.editText_editar_consecutivo);
        editText_editar_marca = findViewById(R.id.editText_editar_marca);
        editText_editar_concepto = findViewById(R.id.editText_editar_concepto);

        fab_editar_update_guardar = findViewById(R.id.fab_editar_update_guardar);
        fab_eliminar_ = findViewById(R.id.fab_eliminar_);




        if(models!=null){
//            models.getConcepto();
            editText_editar_concepto.setText(models.getConcepto());
            editText_editar_marca.setText(models.getMarca());
            editText_editar_consecutivo.setText(models.getConsecutivo());
        }else {
            editText_editar_concepto.setText("No recibimos nada");
            editText_editar_marca.setText("No recibimos nada");
            editText_editar_consecutivo.setText("No recibimos nada");

        }


        fab_editar_update_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                documentReference = db.collection(COLLECTION_NAME).document();
               maleSimpleAlertDialog("Actualizar","ya se esta actualizando  ");
                documentReference.set(models)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                models.setConcepto(models.getConcepto());
                                models.setMarca(models.getMarca());
                                models.setConsecutivo(models.getConsecutivo());
                                if(models != null){
                                    editText_editar_concepto.getText().toString();
                                    editText_editar_marca.getText().toString();
                                    editText_editar_consecutivo.getText().toString();
                                                    }
                                Log.d(TAG, "ya se esta actualizando!");
                                        }

                        }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.w(TAG, "Error no se pudo actualizar", e);
                }
            });

            }
        });

    }
    private void clear(){







    }
}