package com.shohei.rotateprogresslibraryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shohei.rotateprogress.RotateProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rotate_progress_bar)
    RotateProgressBar rotateProgressBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        rotateProgressBuilder.setColors(Color.RED, Color.BLUE, Color.GREEN, Color.CYAN);
//        rotateProgressBuilder.setColors("#F44336", "#E91E63", "#9C27B0", "#673AB7", "#3F51B5", "#2196F3", "#03A9F4", "#00BCD4", "#009688", "#4CAF50", "#8BC34A", "#CDDC39", "#FFC107", "#FF9800", "#FF5722", "#795548", "#9E9E9E", "#607D8B");
        rotateProgressBuilder.setColorsResource(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        rotateProgressBuilder.start();
    }
}
