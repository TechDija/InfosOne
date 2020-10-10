package com.dija.infosoneapp.ViewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dija.infosoneapp.Model.Article;
import com.dija.infosoneapp.R;
import com.dija.infosoneapp.View.ArticleViewHolder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ArticleActivity extends AppCompatActivity {
    private ImageView mReturn;
    //private ImageView mImage;
    private TextView mTitle;
    private TextView mAuthor;
    private TextView mDate;
    private TextView mContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_activity);
        Intent intent = getIntent();
        Article article = intent.getParcelableExtra("article");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");

        mReturn = (ImageView) findViewById(R.id.return_image);
        //mImage = (ImageView) findViewById(R.id.photo_display);
          //  mImage.setImageDrawable(article.getPicture());
        mTitle = (TextView) findViewById(R.id.title_display);
            mTitle.setText(article.getTitle());
        mAuthor = (TextView) findViewById(R.id.author_display);
            mAuthor.setText(article.getAuthor());
        mDate = (TextView) findViewById(R.id.date_display);
            mDate.setText(dateFormat.format(article.getDate()));
        mContent = (TextView) findViewById(R.id.content_display);
            mContent.setText(article.getContent());

     mReturn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent MainActivity = new Intent(ArticleActivity.this, com.dija.infosoneapp.ViewModel.MainActivity.class);
             startActivity(MainActivity);
         }
     });


    }
}