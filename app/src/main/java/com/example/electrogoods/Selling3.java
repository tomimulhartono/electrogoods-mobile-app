package com.example.electrogoods;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class Selling3 extends AppCompatActivity {

    ImageView openGallery, addpicture;
    Button post_selling3;

    private Uri mImageuri;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;
    private StorageReference mStorageRef;
    private StorageTask mUploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling3);

        openGallery = findViewById(R.id.upload_picture);
        addpicture = findViewById(R.id.add_pict);
        post_selling3 = findViewById(R.id.posting3);

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");

        Intent get2 = getIntent();
        final String get_category = get2.getStringExtra("Category");
        final String get_pilihan = get2.getStringExtra("Pilihan");
        final String get_merk = get2.getStringExtra("Merk");
        final String get_title = get2.getStringExtra("Title");
        final String get_describe = get2.getStringExtra("Describe");


        openGallery.setOnClickListener(new View.OnClickListener() {
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

        post_selling3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUploadTask != null && mUploadTask.isInProgress()) {
                    Toast.makeText(Selling3.this, "Upload In Progress", Toast.LENGTH_SHORT).show();
                } else {
                    final StorageReference filereference = mStorageRef.child(System.currentTimeMillis() + "." + getFileExension(mImageuri));
                    mUploadTask = filereference.putFile(mImageuri)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    filereference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            Uri downloadUrl = uri;
                                            String url = downloadUrl.toString();

                                            Intent intent = new Intent(getApplicationContext(), Selling4.class);
                                            intent.putExtra("Category", get_category);
                                            intent.putExtra("Pilihan", get_pilihan);
                                            intent.putExtra("Merk", get_merk);
                                            intent.putExtra("Title", get_title);
                                            intent.putExtra("Describe", get_describe);
                                            intent.putExtra("Picture", url);
                                            startActivity(intent);
                                        }
                                    });
                                    Toast.makeText(Selling3.this, "Upload Successful", Toast.LENGTH_LONG).show();
                                    finishAndRemoveTask();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Selling3.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
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
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE && data != null && data.getData() != null) {
            mImageuri = data.getData();
            addpicture.setImageURI(mImageuri);
        }
    }

    private String getFileExension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

}
