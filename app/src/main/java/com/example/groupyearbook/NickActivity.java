package com.example.groupyearbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class NickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickactivity);
    }

    public void buttonClick (View view) {
        Intent i = new Intent(getApplicationContext(), PablosActivity.class);
        startActivity(i);
    }

    public void buttonClick1 (View view){
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.picture1);
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(),
                b, "Title", null);
        Uri imageUri = Uri.parse(path);
        share.putExtra(Intent.EXTRA_STREAM, imageUri);
        startActivity(Intent.createChooser(share, "Select"));

/*
        Intent shareIntent = new Intent();
    Uri imageUri = Uri.parse("android.resource://your.package/drawable/picture1.png");
    Intent intent = new Intent(Intent.ACTION_SEND);
    shareIntent.setAction(Intent.ACTION_SEND);
    shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
    shareIntent.setType("image/png");
    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.app_name)));
*/
    }
}
