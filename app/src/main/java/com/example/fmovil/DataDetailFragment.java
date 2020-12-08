package com.example.fmovil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fmovil.models.MovilModels;

public class DataDetailFragment extends Fragment {

    private static String consecutivo, concepto,marca;
    private boolean active;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_detail, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv_data_detail_consecutivo,tv_data_detail_concepto,tv_data_detail_marca;

        tv_data_detail_consecutivo=view.findViewById(R.id.tv_data_detail_consecutivo);
        tv_data_detail_concepto=view.findViewById(R.id.tv_data_detail_concepto);
        tv_data_detail_marca=view.findViewById(R.id.tv_data_detail_marca);

        tv_data_detail_consecutivo.setText(consecutivo);
        tv_data_detail_concepto.setText(concepto);
        tv_data_detail_marca.setText(marca);


        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DataDetailFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
    static void reciveData(Bundle bundle){
        MovilModels models= (MovilModels) bundle.getSerializable("models");
        if(models!=null){
            consecutivo=models.getConsecutivo();
            concepto=models.getConcepto();
            marca=models.getMarca();

        }
    }
}