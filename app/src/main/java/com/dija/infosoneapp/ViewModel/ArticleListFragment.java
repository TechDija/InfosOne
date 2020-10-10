package com.dija.infosoneapp.ViewModel;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dija.infosoneapp.Model.Article;
import com.dija.infosoneapp.Model.GenerateArticles;
import com.dija.infosoneapp.R;
import com.dija.infosoneapp.View.ArticleListAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArticleListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticleListFragment extends Fragment {
    private List<Article> mArticles;
    private RecyclerView mRecyclerView;
    private ArticleListAdapter mAdapter;

    public static ArticleListFragment newInstance() {
        ArticleListFragment fragment = new ArticleListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArticles = GenerateArticles.getArticles();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_article_list, container, false);
        mAdapter = new ArticleListAdapter(this.mArticles);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return mRecyclerView;
    }

    private void initList() {
        mArticles = GenerateArticles.getArticles();
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    public void onsStart() {
        super.onStart();
        initList();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}