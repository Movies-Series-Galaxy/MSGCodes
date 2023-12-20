plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.msg.msgalaxy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.msg.msgalaxy"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Picasso Lib for loading images from url
    implementation("com.squareup.picasso:picasso:2.8")

    //Shimmer effect When loading data
    implementation("com.facebook.shimmer:shimmer:0.5.0")

    //Costum Bottom Navigation
    implementation("com.github.ibrahimsn98:NiceBottomBar:2.3")
    //Cicle Image
    implementation("de.hdodenhof:circleimageview:3.1.0")
    //Lottie Lib for Animation
    implementation("com.airbnb.android:lottie:6.1.0")
    //For Indicator With View Pager
    implementation("me.relex:circleindicator:2.1.6")

    //to get the data from Database and put it in Android Studio
    implementation("com.android.volley:volley:1.2.1")

    //FireBase Lib
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-database")

}