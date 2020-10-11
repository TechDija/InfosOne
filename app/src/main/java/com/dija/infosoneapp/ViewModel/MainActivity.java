package com.dija.infosoneapp.ViewModel;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.dija.infosoneapp.Model.Article;
import com.dija.infosoneapp.R;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    private ArticleListFragment mArticleListFragment;
    private ImageView mShareButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.displayMainFragment();
        mShareButton = findViewById(R.id.share);

        mShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
    }

    private void share() {
        Intent sharingintent = new Intent (Intent.ACTION_SEND);
        sharingintent.setType("text/plain");
        sharingintent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey, je suis l'actualité à travers l'aplication Infos One!");
        startActivity(Intent.createChooser(sharingintent, "Share via"));
    }


    private void displayMainFragment() {
        mArticleListFragment = (ArticleListFragment) getSupportFragmentManager().findFragmentById(R.id.main_frame_layout);
        if (mArticleListFragment == null) {
            mArticleListFragment = new ArticleListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_frame_layout, mArticleListFragment)
                    .commit();
            }
        }
    }

