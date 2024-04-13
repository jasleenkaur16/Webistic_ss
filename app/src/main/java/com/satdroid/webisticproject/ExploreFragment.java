package com.satdroid.webisticproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.satdroid.webisticproject.Adap.CategoryItem;

import java.util.ArrayList;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link ExploreFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class ExploreFragment extends Fragment {
    private RecyclerView recyclerView;
    private AdapterExplore adapterExplore;
    private ArrayList<CategoryItem> dataList;

//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public ExploreFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ExploreFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static ExploreFragment newInstance(String param1, String param2) {
//        ExploreFragment fragment = new ExploreFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }

    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView = view.findViewById(R.id.rcv_explore);

        // Initialize data list
        dataList = new ArrayList<>();
        // Add sample data
        dataList.add(new CategoryItem("Photography", "https://wallpapers.com/images/featured/flower-pictures-unpxbv1q9kxyqr1d.jpg"));
        dataList.add(new CategoryItem("Travel", "https://wallpapers.com/images/featured/flower-pictures-unpxbv1q9kxyqr1d.jpg"));
        dataList.add(new CategoryItem("Food", "https://wallpapers.com/images/featured/flower-pictures-unpxbv1q9kxyqr1d.jpg"));
        dataList.add(new CategoryItem("Fashion", "https://wallpapers.com/images/featured/flower-pictures-unpxbv1q9kxyqr1d.jpg"));
        dataList.add(new CategoryItem("Technology", "https://wallpapers.com/images/featured/flower-pictures-unpxbv1q9kxyqr1d.jpg"));

        // Initialize adapter
        adapterExplore = new AdapterExplore(dataList);

        // Set adapter to RecyclerView
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapterExplore);

    }
}