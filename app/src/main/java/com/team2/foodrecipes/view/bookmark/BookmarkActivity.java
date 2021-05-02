/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/29/21 8:58 PM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2021. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.team2.foodrecipes.view.bookmark;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.team2.foodrecipes.R;

public class BookmarkActivity extends AppCompatActivity {

    private ImageView bookmarkImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark);
    }
}
