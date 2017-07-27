package com.fizarum.fragmenttest.fragmets;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.fizarum.fragmenttest.R;

/**
 * Created by fizarum on 7/27/17.
 */

public class FirstFragmentViewWrapper {

    private View mRootView;

    private CheckBox mCheckbox;
    private EditText mEditText;
    private LinearLayout mContentLayout;
    private LinearLayout mProgressLayout;

    public FirstFragmentViewWrapper(View view) {
        mRootView = view;
        mCheckbox = (CheckBox) mRootView.findViewById(R.id.first_fragment_checkbox);
        mEditText = (EditText) mRootView.findViewById(R.id.first_fragment_edit_text);

        mContentLayout = (LinearLayout) mRootView.findViewById(R.id.first_fragment_content);
        mProgressLayout = (LinearLayout) mRootView.findViewById(R.id.first_fragment_progress);
    }

    public void onPrepare() {
        Log.d("TAG", "on prepare");
        mContentLayout.setVisibility(View.GONE);
        mProgressLayout.setVisibility(View.VISIBLE);
        //just for test it wont be visible to user because of progress bar
        mCheckbox.setTextColor(ContextCompat.getColor(mRootView.getContext(), android.R.color.holo_orange_dark));
        mCheckbox.setEnabled(false);

        mEditText.setTextColor(ContextCompat.getColor(mRootView.getContext(), android.R.color.holo_orange_dark));
        mEditText.setEnabled(false);
    }

    public void onPost() {
        Log.d("TAG", "on post");

        mContentLayout.setVisibility(View.VISIBLE);
        mProgressLayout.setVisibility(View.GONE);

        mCheckbox.setTextColor(ContextCompat.getColor(mRootView.getContext(), android.R.color.holo_purple));
        mCheckbox.setEnabled(true);

        mEditText.setTextColor(ContextCompat.getColor(mRootView.getContext(), android.R.color.holo_purple));
        mEditText.setEnabled(true);
    }


}
