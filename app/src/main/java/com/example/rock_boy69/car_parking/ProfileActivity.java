package com.example.rock_boy69.car_parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private TextView mDisplayID, mHora, mLocal, mLugar;
    private Button mEditar_btn, mEliminar_btn;




    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    to get ID
    DatabaseReference mUsersDatabase = database.getReference().child("Carro");
//    To delete ID
    DatabaseReference myRef = database.getReference().child("CarroHistorico");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        String user_id = getIntent().getStringExtra("user_id");

        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Carro").child(user_id);

        mHora = (TextView) findViewById(R.id.user_hora);
        mDisplayID = (TextView) findViewById(R.id.profile_display_name);
        mLocal = (TextView) findViewById(R.id.user_local);
        mLugar = (TextView) findViewById(R.id.user_lugar);
        mEditar_btn = (Button) findViewById(R.id.editar_profile);
        mEliminar_btn = (Button) findViewById(R.id.eliminar_profile);

        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               String hora = dataSnapshot.child("hora").getValue().toString();
               String Id = dataSnapshot.child("id").getValue().toString();
               String local = dataSnapshot.child("local").getValue().toString();
               String lugar = dataSnapshot.child("lugar").getValue().toString();

                mHora.setText(hora);
                mDisplayID.setText(Id);
                mLocal.setText(local);
                mLugar.setText(lugar);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mEditar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Intentedit = new Intent(ProfileActivity.this, MainActivity.class);
                Intentedit.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(Intentedit);
                finish();
            }
        });

        mEliminar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String matricula = mDisplayID.getText().toString();
                String hora = mHora.getText().toString();
                String lugar = mLugar.getText().toString();
                String local = mLocal.getText().toString();

                DatabaseReference id = myRef.push();
                id.child("id").setValue(matricula);
                id.child("hora").setValue(hora);
                id.child("lugar").setValue(lugar);
                id.child("local").setValue(local);




//                mUsersDatabase.child("Carro").child(matricula).removeValue();
//
//                Intent IntentEliminar = new Intent(ProfileActivity.this, MainActivity.class);
//                IntentEliminar.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(IntentEliminar);
//                finish();
            }
        });

    }
}
