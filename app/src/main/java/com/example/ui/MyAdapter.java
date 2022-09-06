package com.example.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MyAdapter extends ArrayAdapter<Object> {
    private final Context context;

    protected String[] toons, captions;

    public MyAdapter(Context context, String[] toons, String[] captions){
        super(context, R.layout.row);
        this.context = context;
        this.toons = toons;
        this.captions = captions;

        addAll(new Object[toons.length]);
    }

    @androidx.annotation.NonNull
    public View getView(int pos, View view, @NonNull ViewGroup parent) {
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row, parent, false);
        }
        // set image for ImageView
        ImageView imageView = view.findViewById(R.id.imageView);
        int id = context.getResources().getIdentifier(toons[pos], "drawable", context.getPackageName());
        imageView.setImageResource(id);

        // set the text for TextView
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(captions[pos]);

        return view;
    }
}
