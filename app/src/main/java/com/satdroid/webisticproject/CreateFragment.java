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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link CreateFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class CreateFragment extends Fragment {
    private ImageButton recordVideoBtn, uploadBtn;
    private VideoView videoView;
    private Uri videoUri;
     FirebaseDatabase firebaseDatabase;
     DatabaseReference databaseReference;


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

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Uploaded Videos");

        recordVideoBtn = view.findViewById(R.id.playButton);
        videoView = view.findViewById(R.id.videoView);
        uploadBtn = view.findViewById(R.id.uploda_btn);

        // Adding click listener for recording button.
        recordVideoBtn.setOnClickListener(v -> {
            // Opening an intent to capture a video.
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            // Starting an activity for result.
            startActivityForResult(intent, 1);
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri newUri=videoUri;
                if (newUri != null) {
                    StorageReference ImageFolder = FirebaseStorage.getInstance().getReference().child("Uploaded Videos");
                    Toast.makeText(getContext(),"Inside firebase storage 2",Toast.LENGTH_SHORT).show();
                    final StorageReference ImageName = ImageFolder.child("Video "+ System.currentTimeMillis());

                    ImageName.putFile(newUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            Toast.makeText(getContext()," Video uploaded",Toast.LENGTH_SHORT).show();
                            ImageName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    Toast.makeText(getContext()," 3 Dwd Url obtained "+uri,Toast.LENGTH_SHORT).show();

                                    UriDataModal uriDataModal=new UriDataModal(uri.toString());
                                    databaseReference.child(String.valueOf(System.currentTimeMillis()))
                                            .setValue(uriDataModal).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    Toast.makeText(getContext()," 4 Url string realtime db",Toast.LENGTH_SHORT).show();
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(getContext()," 4 Url string not in realtime db",Toast.LENGTH_SHORT).show();

                                                }
                                            });
                                }
                            });
                        }
                    });

                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            // Setting video URI for our video view.
            videoUri = data.getData();
            videoView.setVideoURI(videoUri);
            // Starting the video view.
            videoView.start();
        }
    }
}
