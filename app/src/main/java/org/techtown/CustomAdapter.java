package com.example.firsttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener {
    //어디서든 사용 가능
    private Context context;
    private List list;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
    }
    class ViewHolder {
        public TextView nameTextView;
        public TextView ageTextView;
        public ImageView petImgView;
    }

    public CustomAdapter(Context context, ArrayList list){
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.fragment_home, parent, false);
        }

        viewHolder = new ViewHolder();
        viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
        viewHolder.ageTextView = (TextView) convertView.findViewById(R.id.ageTextView);
        viewHolder.petImgView = (ImageView) convertView.findViewById(R.id.petImageView);

        final SingleItem item = (SingleItem) list.get(position);
        viewHolder.nameTextView.setText(item.getName());
        viewHolder.ageTextView.setText(item.getAge());
        Glide
                .with(context)
                .load(item.getImageUrl())
                .centerCrop()
                .apply(new RequestOptions().override(250, 350))
                .into(viewHolder.petImgView);
        viewHolder.nameTextView.setTag(item.getName());
        return convertView;
    }
}
