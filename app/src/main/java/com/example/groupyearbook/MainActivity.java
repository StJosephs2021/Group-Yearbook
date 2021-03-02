package com.example.groupyearbook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("first", "Pablowork", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
            webView = (WebView) findViewById(R.id.webview);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://www.google.com");
        }
    }

    public void buttonClick(View view){
        Intent i = new Intent(getApplicationContext(),NickActivity.class);
        startActivity(i);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onPause() {
        super.onPause();

        new CountDownTimer(5000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                //Display noti info
                Noti();
            }
        }.start();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Noti(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "first")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Your app is playing")
                .setContentText("Your app is still running in the background")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(1, builder.build());
    }

}
