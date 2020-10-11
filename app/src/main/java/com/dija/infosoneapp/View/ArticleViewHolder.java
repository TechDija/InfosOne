package com.dija.infosoneapp.View;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dija.infosoneapp.Model.Article;
import com.dija.infosoneapp.R;
import com.dija.infosoneapp.ViewModel.ArticleListFragment;
import com.dija.infosoneapp.ViewModel.MainActivity;

import java.text.SimpleDateFormat;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    public ImageView mPhoto;
    public TextView mSource;
    public TextView mTitle;
    public TextView mAuthor;
    public TextView mDate;

    public ArticleViewHolder(View itemView) {
        super(itemView);
        mPhoto = itemView.findViewById(R.id.photo_ImageView);
        mSource = itemView.findViewById(R.id.source);
        mTitle = itemView.findViewById(R.id.title);
        mAuthor = itemView.findViewById(R.id.author);
        mDate = itemView.findViewById(R.id.date);
    }
    public void updateWithArticle(Article article) {

        mSource.setText(article.getSource());
        mTitle.setText(article.getTitle());
        mAuthor.setText(article.getAuthor());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        mDate.setText(sdf.format(article.getDate()));
    }
}
