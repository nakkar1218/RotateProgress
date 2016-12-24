package com.shohei.rotateprogresslibraryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shohei.rotateprogresslibrary.RotateProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rotate_progress_bar)
    RotateProgressBar rotateProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
