package dev.xesam.android.slf4j_log4j;

import android.app.Application;
import android.os.Environment;

import org.apache.log4j.Level;

import java.io.File;

import de.mindpipe.android.logging.log4j.LogConfigurator;

/**
 * Created by xesamguo@gmail.com on 16-6-16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogConfigurator logConfigurator = new LogConfigurator();
        logConfigurator.setFileName(Environment.getExternalStorageDirectory() + File.separator + "log4j.txt");
        logConfigurator.setRootLevel(Level.DEBUG);
        logConfigurator.setLevel("org.apache", Level.ERROR);
        logConfigurator.setFilePattern("%d %-5p [%c{2}]-[%L] %m%n");
        logConfigurator.setMaxFileSize(1024 * 1024 * 2);
        logConfigurator.setImmediateFlush(true);
        logConfigurator.configure();
    }
}
