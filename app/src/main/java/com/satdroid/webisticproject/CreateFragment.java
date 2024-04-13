package com.satdroid.webisticproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link CreateFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class CreateFragment extends Fragment {
    private ImageButton recordVideoBtn;
    private VideoView videoView;

//    private DatabaseReference databaseReference;
//    private FirebaseDatabase firebaseDatabase;
//    private FirebaseAuth firebaseAuth;
//    private FirebaseStorage firebaseStorage;


//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public CreateFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment CreateFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static CreateFragment newInstance(String param1, String param2) {
//        CreateFragment fragment = new CreateFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        if (getArguments() != null) {
////            mParam1 = getArguments().getString(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
////        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false);
    }

    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recordVideoBtn = view.findViewById(R.id.playButton);
        videoView = view.findViewById(R.id.videoView);
//        private DatabaseReference databaseReference;
//        private FirebaseDatabase firebaseDatabase;
//        private FirebaseAuth firebaseAuth;
//        private FirebaseStorage firebaseStorage;

//        firebaseDatabase=FirebaseDatabase.getInstance();
//        firebaseAuth=FirebaseAuth.getInstance();
//        firebaseStorage=FirebaseStorage.getInstance();
//
//        databaseReference=firebaseDatabase.getReference();
//        Toast.makeText(getContext(),"User id "+firebaseAuth.getUid(),Toast.LENGTH_SHORT).show();
//
//        databaseReference.setValue("My video").addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                Toast.makeText(getContext(),firebaseAuth.getUid(),Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.d("exception handled","E "+e);
//                Toast.makeText(getContext(), (CharSequence) e,Toast.LENGTH_SHORT).show();
//            }
//        });

        // Adding click listener for recording button.
        recordVideoBtn.setOnClickListener(v -> {
            // Opening an intent to capture a video.
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            // Starting an activity for result.
            startActivityForResult(intent, 1);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 1)
         {
            // Setting video URI for our video view.
            Uri videoUri = data.getData();
            videoView.setVideoURI(videoUri);
            // Starting the video view.
            videoView.start();
        }
    }
    }
