package com.example.fmovil;

import android.content.ContentValues;
import android.os.Bundle;

import com.example.fmovil.adaters.MovilAdapter;
import com.example.fmovil.conection.firebaseConection;
import com.example.fmovil.models.MovilModels;
import com.google.android.gms.tasks.OnCompleteListener;
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

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateActivity extends BaseActivity {

    FloatingActionButton fab_create_save,fab_create_clear,fab_create_back,fab_create_update;
    ImageView tv_create_img_movil;
    TextView tv_create_click_img;
    EditText et_create_concepto;
    EditText et_create_marca;
    EditText et_create_consecutivo;
    private  FirebaseAuth mAuth;
    private  FirebaseFirestore db;
    private  FirebaseStorage mFirebaseStorage;
    private DocumentReference documentReference;
    protected MovilModels models;
    protected ArrayList<MovilModels> modelsArrayList;
    protected MovilAdapter adapter;

//    protected FirebaseFirestore db;
//    protected FirebaseAuth mAuth;
//    protected FirebaseStorage mFirebaseStorage;

    protected Query query;
    protected CollectionReference collectionReference;
    protected StorageReference mStorageReference,fileReference;

    protected final String COLLECTION_NAME = "movil";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mFirebaseStorage=FirebaseStorage.getInstance();

        super.init();
        init2();
        init();

        fab_create_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToList();
            }
        });


        fab_create_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               clear();
            }
        });



        fab_create_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consecutivo,concepto,marca;
                boolean active;

                consecutivo=et_create_consecutivo.getText().toString();
                concepto=et_create_concepto.getText().toString();
                marca=et_create_marca.getText().toString();

                if(consecutivo.isEmpty() || concepto.isEmpty() || marca.isEmpty()){
                    maleSimpleAlertDialog("info","Por favor llene todos los campos");
                }else {

                    models=new MovilModels();
                    models.setActive(true);
                    models.setConcepto(concepto);
                    models.setMarca(marca);
                    models.setConsecutivo(consecutivo);

                    save(models);


                }


            }
        });
    }

    //Guardar información



    private void save(MovilModels models) {
        if(collectionReference!=null){
            collectionReference.add(models)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            if(task.isSuccessful()){
                                if(task.getResult()!=null){
                                     maleSimpleAlertDialog("Success","Movil guardado");
                                    clear();
                                }else {
                                    maleSimpleAlertDialog("Warning","Movil No se guardo ");
                                }

                            }else {
                                maleSimpleAlertDialog("Error",task.getException().getMessage());
                            }

                        }
                    });
        }else {
            maleSimpleAlertDialog("Error","No hay conexion a la base de datos ");
        }
    }

    protected void init2(){
        models = new MovilModels();
        db = firebaseConection.ConectionFirestore();
        mAuth = firebaseConection.ConectionAuth();
        mFirebaseStorage = firebaseConection.ConectionStorage();
        collectionReference = db.collection(COLLECTION_NAME);




    }

    protected void init(){
        fab_create_save=findViewById(R.id.fab_create_save);
        fab_create_clear=findViewById(R.id.fab_create_clear);
        fab_create_back=findViewById(R.id.fab_create_back);
        tv_create_img_movil=findViewById(R.id.tv_create_img_movil);
        tv_create_click_img=findViewById(R.id.tv_create_click_img);
        et_create_concepto=findViewById(R.id.et_create_concepto);
        et_create_marca=findViewById(R.id.et_create_marca);
        et_create_consecutivo=findViewById(R.id.et_create_consecutivo);

    }

    private void clear(){
        et_create_consecutivo.requestFocus();
        et_create_marca.setText("");
        et_create_concepto.setText("");
        et_create_consecutivo.setText("");


        tv_create_img_movil.setImageResource(R.drawable.ic_mobile_friendly_black_18dp);



    }

    public <collectionReference> void update(MovilModels model) {
        db.getFirestoreSettings();









    }



   }

//    public void update(MovilModels model) {
//        documentReference = db.collection(String.valueOf(collectionReference)).document();
//        documentReference.update(,mFirebaseStorage)
//                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                        if(task.isSuccessful()){
//
//                            DocumentSnapshot documentSnapshot = task.getResult();
//                            models=documentSnapshot.toObject(MovilModels.class);
//                            models.setFbid(documentSnapshot.getId());
//
//                            if(task.getResult()!=null){
//                                maleSimpleAlertDialog("Success","Movil actualizado");
//                                clear();
//                            }else {
//                                maleSimpleAlertDialog("Warning","Movil No se actualizo ");
//                            }
//
//                        }else {
//                            maleSimpleAlertDialog("Error",task.getException().getMessage());
//                        }
//
//                    }
//                });
//
//
////        Toast.makeText(getApplicationContext(),"Contacto Actualizado correctamente...",Toast.LENGTH_SHORT).show();
//
//    }
