package com.example.a10118385;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder> {

    //Tanggal   :04 Juni 2021
    //NIM       :10118385
    //Nama      :Julian Arisky Lase
    //Kelas     :IF9

    private List<Diary> diaries;

    public DiaryAdapter(List<Diary> notes) {
        this.diaries = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_note, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(diaries.get(position).getTitle());
        holder.category.setText(diaries.get(position).getCategory());
        holder.desc.setText(diaries.get(position).getDesc());
        holder.date.setText(diaries.get(position).getDate());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), AddNoteActivity.class);
            intent.putExtra("Note", diaries.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return diaries.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView category;
        TextView desc;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_note);
            category = itemView.findViewById(R.id.category_note);
            desc = itemView.findViewById(R.id.desc_note);
            date = itemView.findViewById(R.id.date_note);
        }
    }
}