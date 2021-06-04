/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/29/21 8:58 PM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2021. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.team2.foodrecipes.view.bookmark;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.FileProvider;

import com.team2.foodrecipes.R;
import com.team2.foodrecipes.Utils;
import com.team2.foodrecipes.db.AppDatabase;
import com.team2.foodrecipes.db.Recipe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import okhttp3.internal.Util;

public class AddNewRecipeActivity extends AppCompatActivity {

    String path;
    OutputStream outputStream;
    Context context;
    ImageView thumb;
    Bitmap bmaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);

        EditText recipeNameInput = findViewById(R.id.recipeNameInput);
        EditText detailInput = findViewById(R.id.detailInput);
        Button saveButton = findViewById(R.id.saveButton);
        Button addImageButton = findViewById(R.id.addImageButton);
        EditText kategoriInput = findViewById(R.id.kategorInput);
        EditText negaraInput = findViewById(R.id.negaraInput);
        EditText bahanInput = findViewById(R.id.bahanInput);
        thumb = findViewById(R.id.inputThumb);

        // build channel untuk notification jika android versi diatas Oreo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Notification", "Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        //tap action buat notifikasi
        Intent intent = new Intent(this, BookmarkActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewRecipe(
                        recipeNameInput.getText().toString(),
                        detailInput.getText().toString(),
                        kategoriInput.getText().toString(),
                        negaraInput.getText().toString(),
                        bahanInput.getText().toString()
                );

                //buat simple notif
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "Notification")
                        .setSmallIcon(R.drawable.ic_favorite)
                        .setContentTitle("Recipe Saved")
                        .setContentText("You just saved " + recipeNameInput.getText().toString())
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

                //show notif
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
                notificationManager.notify(1, builder.build());
            }
        });

        //not functioning (progress) button buat pilih gambar dari gallery
        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosePicture();
            }
        });

    }

    private void saveNewRecipe (String recipeName, String detail, String kategori, String negara, String bahan) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        // fungsi simpan gambar input (not working right now)
        //saveGmbr();

        Recipe recipe = new Recipe();
        recipe.recipeName = recipeName;
        recipe.recipeDetail = detail;
        recipe.kategori = kategori;
        recipe.negara = negara;
        recipe.bahan = bahan;
        recipe.uri = path;
        db.recipeDao().insertRecipe(recipe);

        finish();
    }

    //not functioning (progress) fungsi untuk save gambar ke folder dan ambil path urinya
    /*
    private void saveGmbr() {
        String randomKey = UUID.randomUUID().toString();
        File dir = new File(Environment.getExternalStorageDirectory(),"RecipeImage");
        if (!dir.exists()){
            dir.mkdir();
        }
        File file = new File(dir,randomKey +".jpg");
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        thumb.invalidate();
        BitmapDrawable drawable = (BitmapDrawable) thumb.getDrawable();
        Bitmap bmap = drawable.getBitmap();



        bmaps.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = dir.toString() + randomKey + ".jpg";
    }
    */

    //fungsi pilih gambar di gallery
    private void choosePicture(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK &&
                data!=null && data.getData()!=null) {
            Uri imageUrl = data.getData();
            thumb.setImageURI(imageUrl);
            try {
                bmaps = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
