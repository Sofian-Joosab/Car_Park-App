package com.example.rock_boy69.car_parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditUsersActivity extends AppCompatActivity {

    private String User_id;

    private TextView Text;

    private TextView mDisplayID;
    private Spinner mHora, mLocal, mLugar;

    private Button mActualizarBtn;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference mUsersDatabase = database.getReference().child("Carro");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_users);

        User_id = getIntent().getStringExtra("user_id");


        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Carro").child(User_id);





//------------------------------------------------------------

        mDisplayID = (TextView) findViewById(R.id.mEditID);
        mHora = (Spinner) findViewById(R.id.mEditHora);
        mLocal = (Spinner) findViewById(R.id.mEditLocal);
        mLugar = (Spinner) findViewById(R.id.mEditLugar);
        mActualizarBtn = (Button) findViewById(R.id.Editar_btn_Carro);

        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {

                    String Id = dataSnapshot.child("id").getValue().toString();
                    mDisplayID.setText(Id);

                }catch (NullPointerException ex){

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mActualizarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Id = mDisplayID.getText().toString();
                String hora = mHora.getSelectedItem().toString();
                String lugar = mLugar.getSelectedItem().toString();
                String local = mLocal.getSelectedItem().toString();


                DatabaseReference id = mUsersDatabase;
                id.child("id").setValue(Id);
                id.child("hora").setValue(hora);
                id.child("lugar").setValue(lugar);
                id.child("local").setValue(local);

                Toast.makeText(EditUsersActivity.this, "Actualizado com Sucesso!",
                        Toast.LENGTH_LONG).show();

                Intent Main = new Intent(EditUsersActivity.this, MainActivity.class);
                startActivity(Main);
                finish();
            }
        });

        DatabaseReference mUsersDatabase = database.getReference().child("Carro");

        User_id = getIntent().getStringExtra("user_id");


        Text = (TextView) findViewById(R.id.ID);

        Text.setText(User_id);






    }

    }

