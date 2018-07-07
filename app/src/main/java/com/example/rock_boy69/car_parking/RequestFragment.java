package com.example.rock_boy69.car_parking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class RequestFragment extends Fragment {

    private AppCompatEditText mReg_matricula;
    private Spinner mReg_hora;
    private Spinner mReg_lugar;
    private Spinner mReg_local;

    private Button mReg_btn;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("Carro");


    public RequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_request, container, false);

        mReg_matricula = rootView.findViewById(R.id.reg_matricula);
        mReg_hora = rootView.findViewById(R.id.reg_hora);
        mReg_lugar = rootView.findViewById(R.id.reg_lugar);
        mReg_local = rootView.findViewById(R.id.reg_local);
        mReg_btn = rootView.findViewById(R.id.Editar_btn_Carro);

        mReg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String matricula = mReg_matricula.getText().toString();
                String hora = mReg_hora.getSelectedItem().toString();
                String lugar = mReg_lugar.getSelectedItem().toString();
                String local = mReg_local.getSelectedItem().toString();

            if(matricula.equals("")){

                Toast.makeText(RequestFragment.this.getActivity(), "Por favor introduza a Matricula!",
                        Toast.LENGTH_LONG).show();


                if(hora.equals("----")){
                    Toast.makeText(RequestFragment.this.getActivity(), "Por favor introduza a Hora!",
                            Toast.LENGTH_LONG).show();
                }
                if (lugar.equals("----")){
                    Toast.makeText(RequestFragment.this.getActivity(), "Por favor introduza o Lugar!",
                            Toast.LENGTH_LONG).show();
                }
                if (local.equals("----")) {
                    Toast.makeText(RequestFragment.this.getActivity(), "Por favor introduza o Local!",
                            Toast.LENGTH_LONG).show();
                }
            }else{
                DatabaseReference id = myRef.push();
                id.child("id").setValue(matricula);
                id.child("hora").setValue(hora);
                id.child("lugar").setValue(lugar);
                id.child("local").setValue(local);


                Toast.makeText(RequestFragment.this.getActivity(), "Regisrado com Sucesso!",
                        Toast.LENGTH_LONG).show();

                mReg_matricula.setText("");
                mReg_hora.setSelection(0);
                mReg_lugar.setSelection(0);
                mReg_local.setSelection(0);
            }
            }


        });
        // Inflate the layout for this fragment
        return rootView;
    }
}
