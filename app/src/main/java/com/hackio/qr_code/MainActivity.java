package com.hackio.qr_code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    ImageView imageQR;
    Bitmap bitmap;
    private static final String TAG = "QRActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageQR = findViewById(R.id.qrcode);
        floatingActionButton=findViewById(R.id.floatingActionButton);

        QRGEncoder qrgEncoder = new QRGEncoder("annonymous",QRGContents.Type.TEXT, 500);
        try {
            // Getting QR-Code as Bitmap
            bitmap = qrgEncoder.getBitmap();
            // Setting Bitmap to ImageView
            imageQR.setImageBitmap(bitmap);

        } catch (Exception e) {
            Log.v(TAG, e.getMessage());
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScannedBarcodeActivity.class));
            }
        });

    }



}