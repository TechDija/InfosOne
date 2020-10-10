package com.dija.infosoneapp.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.dija.infosoneapp.Model.Article;
import com.dija.infosoneapp.R;
import com.dija.infosoneapp.ViewModel.ArticleActivity;

import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private List<Article> mArticles;

    public ArticleListAdapter(List<Article> mArticles) {
        this.mArticles = mArticles;
    }


    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_article, parent, false);
        return new ArticleViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ArticleViewHolder holder, final int position) {
        holder.updateWithArticle(this.mArticles.get(position));

        holder.mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ArticleActivity.class);
                intent.putExtra("neighbour", mArticles.get(position));
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mArticles== null ? 0 : mArticles.size();
    }
}
