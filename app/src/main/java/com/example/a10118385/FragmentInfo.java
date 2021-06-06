package com.example.a10118385;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a10118385.fragments.FragmentInfo1;
import com.example.a10118385.fragments.FragmentInfo2;

import java.util.ArrayList;
import java.util.List;

public class FragmentInfo extends Fragment {

    //Tanggal   :04 Juni 2021
    //NIM       :10118385
    //Nama      :Julian Arisky Lase
    //Kelas     :IF9

    private ViewPager pager;
    private SlidePagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        List<Fragment> list = new ArrayList<>();
        list.add(new FragmentInfo1());
        list.add(new FragmentInfo2());

        pager = view.findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(requireActivity().getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);
        return view;
    }
}