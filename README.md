# Android Log

slf4j and log4j for Android

1. Android + slf4j --> slf4j-api-xxx + slf4j-android-xxx
2. Android + log4j --> log4j-xxx + android-logging-log4j
3. Android + slf4j + log4j --> slf4j-api-xxx + slf4j-log4j-xxx + log4j-xxx + android-logging-log4j

## slf4j-api-xxx + slf4j-log4j-xxx + slf4j-android-xxx

[slf4j-api](http://www.slf4j.org/download.html)

## slf4j-android-xxx

[slf4j-android](http://www.slf4j.org/android/)

## log4j-xxx

[log4j](http://logging.apache.org/log4j/1.2/download.html)

## android-logging-log4j

[android-logging-log4j](https://github.com/eetac/android-logging-log4j)

## remove log with ProGuard

### 1

build.gradle

    buildTypes {
        release {
            minifyEnabled true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
    
            // With the file below, it does not work!
            //proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    
proguard-rules.pro    

    -assumenosideeffects class * implements org.slf4j.Logger {
        public *** trace(...);
        public *** debug(...);
        public *** info(...);
        public *** warn(...);
        public *** error(...);
    }
    
    -assumenosideeffects class org.slf4j.Logger {
        public *** trace(...);
        public *** debug(...);
        public *** info(...);
        public *** warn(...);
        public *** error(...);
    }
    
### 2

build.gradle

    buildTypes {
        release {
            minifyEnabled true
            proguardFiles 'proguard-rules.pro'
        }
    }
    
proguard-rules.pro    
    
    -optimizations <your config>
    
    ....
        
    -assumenosideeffects class * implements org.slf4j.Logger {
        public *** trace(...);
        public *** debug(...);
        public *** info(...);
        public *** warn(...);
        public *** error(...);
    }
    
    -assumenosideeffects class org.slf4j.Logger {
        public *** trace(...);
        public *** debug(...);
        public *** info(...);
        public *** warn(...);
        public *** error(...);
    }