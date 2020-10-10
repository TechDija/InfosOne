package com.dija.infosoneapp.ViewModel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dija.infosoneapp.R;

public class MainActivity extends AppCompatActivity {
    private ArticleListFragment mArticleListFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.displayMainFragment();
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