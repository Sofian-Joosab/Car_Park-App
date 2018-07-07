package com.example.rock_boy69.car_parking;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {

    private RecyclerView mFriendsList;
    private DatabaseReference mFriendsDatabase;
    private FirebaseAuth mAuth;

    private String mCurrent_user_id;

    private View mMainView;


    public FriendsFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mMainView = inflater.inflate(R.layout.fragment_chats, container, false);
        mFriendsList = (RecyclerView) mMainView.findViewById(R.id.friends_list);
        mAuth = FirebaseAuth.getInstance();

        mCurrent_user_id = mAuth.getCurrentUser().getUid();

        mFriendsDatabase = FirebaseDatabase.getInstance().getReference().child("CarroHistorico");


        mFriendsList.setHasFixedSize(true);
        mFriendsList.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inflate the layout for this fragment
        return mMainView;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Friends, ChatsFragment.FriendsViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Friends, ChatsFragment.FriendsViewHolder>(
                Friends.class,
                R.layout.users_single_layout,
                ChatsFragment.FriendsViewHolder.class,
                mFriendsDatabase
        ) {
            @Override
            protected void populateViewHolder(ChatsFragment.FriendsViewHolder friendsViewHolder, Friends friends, int position) {

                friendsViewHolder.setDisplayName(friends.getId());
                friendsViewHolder.setUserStatus(friends.getHora());
                friendsViewHolder.setUserStatusLugar(friends.getLugar());
                friendsViewHolder.setUserStatusLocal(friends.getLocal());

                final String user_id = getRef(position).getKey();

                friendsViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CharSequence options[] = new CharSequence[]{"Restaurar"};
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Selecione Opcao");
                        builder.setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Click Event for each item.
                                if (which == 0) {
                                    Intent IntentEliminar = new Intent(getContext(), DeleteUsers2Activity.class);
                                    IntentEliminar.putExtra("user_id", user_id);
                                    startActivity(IntentEliminar);

                                }
                            }
                        });
                        builder.show();

                    }
                });
            }
        };

        mFriendsList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class FriendsViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public FriendsViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setDisplayName(String name){

            TextView userNameView = (TextView) mView.findViewById(R.id.user_single_name);
            userNameView.setText(name);

        }

        public void setUserStatus(String status){

            TextView userStatusView = (TextView) mView.findViewById(R.id.user_single_status);
            userStatusView.setText(status);

        }
        public void setUserStatusLugar(String status){

            TextView userStatusViewLugar = (TextView) mView.findViewById(R.id.user_single_status_lugr);
            userStatusViewLugar.setText(status);

        }
        public void setUserStatusLocal(String status){

            TextView userStatusViewLocal = (TextView) mView.findViewById(R.id.user_single_status_local);
            userStatusViewLocal.setText(status);

        }


    }
}


