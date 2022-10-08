package com.karlina.mybio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnEmail;
    Button btnPhone;
    Button btnAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmail = findViewById(R.id.btn_email);
        btnPhone = findViewById(R.id.btn_phone);
        btnAddress = findViewById(R.id.btn_address);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoEmail();
            }
        });

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoPhone();
            }
        });

        btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAddress();
            }
        });

    }

    public void gotoEmail(){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","karlinads0809@email.com", null));
        startActivity(Intent.createChooser(intent, "Halooo"));
    }

    public void gotoPhone(){
        Intent callInten = new Intent(Intent.ACTION_DIAL);
        callInten.setData(Uri.parse("tel:085947369676"));
        startActivity(callInten);
    }

    public void gotoAddress(){
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Desa Kepanean+Gg.sawo+tegal.selatan+kab.tegal");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}