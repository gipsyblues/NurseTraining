package training.nurse.nursetraining.Adapters;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import training.nurse.nursetraining.Models.Chapter;
import training.nurse.nursetraining.R;

public class ChapterBodyAdapter
        extends RecyclerView.Adapter<ChapterBodyAdapter.MyViewHolder> {
    private List<Chapter> chapterList;
    private Context context;

    public void setContext(Context context){
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvText;
        public TextView tvTitle;
        public TextView tvLeftItalic;
        public FrameLayout flPic;
        public ImageView ivPic;
        public Button btnNext;
        public Button btnBack;

        public MyViewHolder(View view){
            super(view);
            tvText = (TextView) view.findViewById(R.id.tvText);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvLeftItalic = (TextView) view.findViewById(R.id.tvLeftItalic);
            flPic = (FrameLayout) view.findViewById(R.id.flPic);
            ivPic = (ImageView) view.findViewById(R.id.ivPic);
            btnNext = (Button) view.findViewById(R.id.btnNext);
            btnBack = (Button) view.findViewById(R.id.btnBack);

        }
    }

    public ChapterBodyAdapter(List<Chapter> childrenList){
        this.chapterList = childrenList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Chapter chapter = chapterList.get(position);



        try {
            if (!chapter.getTitle().isEmpty()) {
                holder.tvTitle.setText(chapter.getTitle());
                holder.tvTitle.setVisibility(View.VISIBLE);
            }
        }
        catch(NullPointerException e){}

        try {
            if (!chapter.getLeftItalic().isEmpty()) {
                holder.tvLeftItalic.setText(chapter.getLeftItalic());
                holder.tvLeftItalic.setVisibility(View.VISIBLE);
            }
        }
        catch(NullPointerException e){}

        try {
            if (!chapter.getText().isEmpty()) {
                holder.tvText.setText(chapter.getText());
                holder.tvText.setVisibility(View.VISIBLE);
            }
        }
        catch(NullPointerException e){}

        try {
            if (!chapter.getNext().isEmpty()) {
                holder.btnNext.setVisibility(View.VISIBLE);
            }
        }
        catch(NullPointerException e){}

        try {
            if (!chapter.getBack().isEmpty()) {
                holder.btnBack.setVisibility(View.VISIBLE);
            }
        }
        catch(NullPointerException e){}

        try {
            if (!chapter.getPhoto().isEmpty()) {
                holder.flPic.setVisibility(View.VISIBLE);
                InputStream ims = context.getAssets().open(chapter.getPhoto());
                Drawable d = Drawable.createFromStream(ims, null);
                holder.ivPic.setImageDrawable(d);
                ims .close();
            }
        }
        catch(NullPointerException e){} catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount(){
        return chapterList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chapter_items, parent, false);
        return new MyViewHolder(v);
    }

}