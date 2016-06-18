package dev.xesam.android.slf4j_log4j;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity extends AppCompatActivity {

    Logger logger = LoggerFactory.getLogger(MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logger.info("My Application Created");
    }
}
