package com.example.rock_boy69.car_parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DeleteUsersActivity extends AppCompatActivity {

    private String User_id;

    private TextView Text;

    private TextView mDisplayID, mHora, mLocal, mLugar;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference mUsersDatabase = database.getReference().child("Carro");

    DatabaseReference myRef = database.getReference().child("CarroHistorico");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_users);

        User_id = getIntent().getStringExtra("user_id");


        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Carro").child(User_id);





//------------------------------------------------------------

        mHora = (TextView) findViewById(R.id.user_hora);
        mDisplayID = (TextView) findViewById(R.id.profile_display_name);
        mLocal = (TextView) findViewById(R.id.user_local);
        mLugar = (TextView) findViewById(R.id.user_lugar);

        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            try {
                    String hora = dataSnapshot.child("hora").getValue().toString();
                    String Id = dataSnapshot.child("id").getValue().toString();
                    String local = dataSnapshot.child("local").getValue().toString();
                    String lugar = dataSnapshot.child("lugar").getValue().toString();

                    mHora.setText(hora);
                    mDisplayID.setText(Id);
                    mLocal.setText(local);
                    mLugar.setText(lugar);

                    DatabaseReference id = myRef.push();
                    id.child("id").setValue(Id);
                    id.child("hora").setValue(hora);
                    id.child("lugar").setValue(lugar);
                    id.child("local").setValue(local);
            }catch (NullPointerException ex){

            }





            }

            @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });


        DatabaseReference mUsersDatabase = database.getReference().child("Carro");

        User_id = getIntent().getStringExtra("user_id");


        Text = (TextView) findViewById(R.id.ID);

        Text.setText(User_id);

        mUsersDatabase.child(User_id).removeValue();

        Intent IntentEditar = new Intent(DeleteUsersActivity.this, MainActivity.class);
        IntentEditar.putExtra("user_id",User_id );
        startActivity(IntentEditar);
        finish();





    }
}
