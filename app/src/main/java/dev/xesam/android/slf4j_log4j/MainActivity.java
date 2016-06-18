package dev.xesam.android.slf4j_log4j;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity extends AppCompatActivity {

    Logger logger = LoggerFactory.getLogger(MainActivity.class);
    org.apache.log4j.Logger logger1 = org.apache.log4j.Logger.getLogger(MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//        logger.info("My Application Created");
                logger1.info("My Application Created");
            }
        });

    }
}
