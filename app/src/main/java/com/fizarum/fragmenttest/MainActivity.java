package com.fizarum.fragmenttest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fizarum.fragmenttest.fragmets.FirstFragment;

public class MainActivity extends AppCompatActivity {

    private Button mShowFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowFragmentButton = (Button) findViewById(R.id.show_fragment_button);
        mShowFragmentButton.setOnClickListener(createShowFragmentClickListener());
    }



    private View.OnClickListener createShowFragmentClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment f = fragmentManager.findFragmentById(R.id.fragment_placeholder);
                if(f != null) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_placeholder, new FirstFragment()).commit();
                } else {
                    fragmentManager.beginTransaction().add(R.id.fragment_placeholder, new FirstFragment()).commit();
                }
            }
        };
    }
}
