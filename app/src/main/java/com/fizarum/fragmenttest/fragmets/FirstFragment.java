package com.fizarum.fragmenttest.fragmets;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fizarum.fragmenttest.R;


public class FirstFragment extends Fragment {

    private FirstFragmentViewWrapper mViewWrapper;
    private SimpleAsynTask mTask;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // I know it looks crappy but made specially for test purposes
        // good way is to return result of inflater.inflate() here and continue working with
        // view in onViewCreated() method
        final View view = inflater.inflate(R.layout.fragment_first, container, false);

        mViewWrapper = new FirstFragmentViewWrapper(view);

        mTask = new SimpleAsynTask();

        //start task
        mTask.execute();

        return view;
    }

    private class SimpleAsynTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mViewWrapper.onPrepare();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                //mimic some work here
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mViewWrapper.onPost();
        }
    }
}
