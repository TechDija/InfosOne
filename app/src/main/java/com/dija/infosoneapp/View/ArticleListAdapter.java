package com.dija.infosoneapp.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dija.infosoneapp.Model.Article;
import com.dija.infosoneapp.R;
import com.dija.infosoneapp.ViewModel.ArticleActivity;
import com.dija.infosoneapp.ViewModel.ArticleListFragment;

import java.text.SimpleDateFormat;
import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private List<Article> mArticles;
    private Context context;

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
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, final int position) {
        Article article = mArticles.get(position);
        holder.mPhoto.setImageResource(getImageId(context, article.getPicture()));
        holder.mSource.setText(article.getSource());
        holder.mTitle.setText(article.getTitle());
        holder.mAuthor.setText(article.getAuthor());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        holder.mDate.setText(sdf.format(article.getDate()));

        holder.mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ArticleActivity.class);
                intent.putExtra("article", mArticles.get(position));
                context.startActivity(intent);
            }
        });
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
    @Override
    public int getItemCount() {
        return mArticles== null ? 0 : mArticles.size();
    }
}
