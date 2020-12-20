package com.example.electrogoods;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.storage.StorageReference;

public class Selling6 extends AppCompatActivity {
    ImageView add_picture;
    EditText add_name, add_phone;
    Button post_selling6;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling6);

        add_picture = findViewById(R.id.enter_photo);
        add_name = findViewById(R.id.enter_name);
        add_phone = findViewById(R.id.enter_phone);
        post_selling6 = findViewById(R.id.posting6);

        Intent get5 = getIntent();
        final String get_pilihan = get5.getStringExtra("Pilihan");
        final String get_category = get5.getStringExtra("Category");
        final String get_merk = get5.getStringExtra("Merk");
        final String get_title = get5.getStringExtra("Title");
        final String get_describe = get5.getStringExtra("Describe");
        final String get_picture = get5.getStringExtra("Picture");
        final String get_price = get5.getStringExtra("Price");
        final String get_location = get5.getStringExtra("Location");

        add_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED) {
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else {
                        pickImageFromGallery();
                    }
                }
                else {
                    pickImageFromGallery();
                }
            }
        });

        post_selling6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap_photo = add_picture.getDrawingCache();
                String set_name = add_name.getText().toString();
                String set_phone = add_phone.getText().toString();

                Intent intent = new Intent(getApplicationContext(), Selling7.class);
                intent.putExtra("Category", get_category);
                intent.putExtra("Pilihan", get_pilihan);
                intent.putExtra("Merk", get_merk);
                intent.putExtra("Title", get_title);
                intent.putExtra("Describe", get_describe);
                intent.putExtra("Picture", get_picture);
                intent.putExtra("Price", get_price);
                intent.putExtra("Location", get_location);

                intent.putExtra("Photo", bitmap_photo);
                intent.putExtra("Name", set_name);
                intent.putExtra("Phone", set_phone);
                startActivity(intent);
            }
        });
    }

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length >0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery();
                }
                else {
                    Toast.makeText(this, "Permission denied...!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            add_picture.setImageURI(data.getData());
            add_picture.buildDrawingCache();
        }
    }
}
