package com.example.a10118385;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentDiary extends Fragment {

    //Tanggal   :04 Juni 2021
    //NIM       :10118385
    //Nama      :Julian Arisky Lase
    //Kelas     :IF9

    private ArrayList<Diary> diaries;
    private DBHelper dbHelper;
    private DiaryAdapter diaryAdapter;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);

        FloatingActionButton button_add = view.findViewById(R.id.button_add);
        recyclerView = view.findViewById(R.id.mynote);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), AddNoteActivity.class);
                requireContext().startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        read();

    }

    @Override
    public void onResume() {
        super.onResume();
        read();
    }


    private void read(){
        diaries = new ArrayList<Diary>();
        dbHelper = new DBHelper(getContext());
        Cursor cursor = dbHelper.read();
        if(cursor.moveToFirst()){
            do {
                Diary n = new Diary(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );

                diaries.add(n);
            }while (cursor.moveToNext());
        }
        diaryAdapter = new DiaryAdapter(diaries);
        recyclerView.setAdapter(diaryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }
}