package com.dija.infosoneapp.ViewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dija.infosoneapp.Model.Article;
import com.dija.infosoneapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ArticleActivity extends AppCompatActivity {
    private ImageView mReturn;
    private TextView mTitre;
    private TextView mAuteur;
    private TextView mDate;
    private TextView mContenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_activity);

        Intent intent = getIntent();
        Article article = intent.getParcelableExtra("article");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        String titre = article.getTitle();
        String auteur = article.getAuthor();
        String contenu = article.getContent();

        mReturn = (ImageView) findViewById(R.id.return_image);
        mTitre = (TextView) findViewById(R.id.title_display);
            mTitre.setText(titre);
        mAuteur = (TextView) findViewById(R.id.author_display);
            mAuteur.setText(auteur);
        mDate = (TextView) findViewById(R.id.date_display);
            mDate.setText(dateFormat.format(article.getDate()));
        mContenu = (TextView) findViewById(R.id.content_display);
            mContenu.setText(contenu);



     mReturn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent MainActivity = new Intent(ArticleActivity.this, com.dija.infosoneapp.ViewModel.MainActivity.class);
             startActivity(MainActivity);
         }
     });


    }
}