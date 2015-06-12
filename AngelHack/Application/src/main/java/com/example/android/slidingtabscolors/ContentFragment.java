/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.slidingtabscolors;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * Simple Fragment used to display some meaningful content for each page in the sample's
 * {@link android.support.v4.view.ViewPager}.
 */
public class ContentFragment extends Fragment {

    private static final String KEY_TITLE = "title";
    private static final String KEY_INDICATOR_COLOR = "indicator_color";
    private static final String KEY_DIVIDER_COLOR = "divider_color";

    /**
     * @return a new instance of {@link ContentFragment}, adding the parameters into a bundle and
     * setting them as arguments.
     */
    public static ContentFragment newInstance(CharSequence title, int indicatorColor,
                                              int dividerColor) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(KEY_TITLE, title);
        bundle.putInt(KEY_INDICATOR_COLOR, indicatorColor);
        bundle.putInt(KEY_DIVIDER_COLOR, dividerColor);

        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        view.setBackgroundResource(R.drawable.background1);

        if (args != null) {
            if (args.getCharSequence(KEY_TITLE).toString().equals("Donate")) {
                ImageView imgViewDonate = (ImageView) view.findViewById(R.id.ImageView01);
                imgViewDonate.setImageResource(R.drawable.logo);
                imgViewDonate.setPadding(300,50,0,0);
                imgViewDonate.setVisibility(View.VISIBLE);
                Button btn = (Button) view.findViewById(R.id.donateButton);
                btn.setVisibility(View.VISIBLE);
            } else if (args.getCharSequence(KEY_TITLE).toString().equals("Analysis")) {
                ImageView imgViewAnalysis = (ImageView) view.findViewById(R.id.ImageView01);
                imgViewAnalysis.setImageResource(R.drawable.chart);
                imgViewAnalysis.setVisibility(View.VISIBLE);
            } else if (args.getCharSequence(KEY_TITLE).toString().equals("Friends")) {
                TextView title = (TextView) view.findViewById(R.id.item_title);
                title.setText("Most Generous Friends");
                ImageView friend1_imgView = (ImageView) view.findViewById(R.id.friend1);
                TextView textF1 = (TextView) view.findViewById(R.id.textFieldFriend1);
                textF1.setText("Bill Gate");
                textF1.setVisibility(View.VISIBLE);
                friend1_imgView.setVisibility(View.VISIBLE);
                ImageView friend2_imgView = (ImageView) view.findViewById(R.id.friend2);
                TextView textF2 = (TextView) view.findViewById(R.id.textFieldFriend2);
                textF2.setText("John Adams");
                textF2.setVisibility(View.VISIBLE);
                friend2_imgView.setVisibility(View.VISIBLE);
                ImageView friend3_imgView = (ImageView) view.findViewById(R.id.friend3);
                TextView textF3 = (TextView) view.findViewById(R.id.textFieldFriend3);
                textF3.setText("David Jones");
                textF3.setVisibility(View.VISIBLE);
                friend3_imgView.setVisibility(View.VISIBLE);
                ImageView friend4_imgView = (ImageView) view.findViewById(R.id.friend4);
                TextView textF4 = (TextView) view.findViewById(R.id.textFieldFriend4);
                textF4.setText("Old Guy");
                textF4.setVisibility(View.VISIBLE);
                friend4_imgView.setVisibility(View.VISIBLE);
                ImageView friend5_imgView = (ImageView) view.findViewById(R.id.friend5);
                TextView textF5 = (TextView) view.findViewById(R.id.textFieldFriend5);
                textF5.setText("Rohit Krishnan");
                textF5.setVisibility(View.VISIBLE);
                friend5_imgView.setVisibility(View.VISIBLE);
                ImageView friend6_imgView = (ImageView) view.findViewById(R.id.friend6);
                TextView textF6 = (TextView) view.findViewById(R.id.textFieldFriend6);
                textF6.setText("Justin Nguyen");
                textF6.setVisibility(View.VISIBLE);
                friend6_imgView.setVisibility(View.VISIBLE);
            } else {
                TextView title = (TextView) view.findViewById(R.id.item_title);
                title.setText(args.getCharSequence(KEY_TITLE));
                ImageView friend1_imgView = (ImageView) view.findViewById(R.id.friend1);
                TextView textF1 = (TextView) view.findViewById(R.id.textFieldFriend1);
                textF1.setText("Earthquake");
                friend1_imgView.setImageResource(R.drawable.earthquake);
                textF1.setVisibility(View.VISIBLE);
                friend1_imgView.setVisibility(View.VISIBLE);
                ImageView friend2_imgView = (ImageView) view.findViewById(R.id.friend2);
                TextView textF2 = (TextView) view.findViewById(R.id.textFieldFriend2);
                textF2.setText("Volcano");
                friend2_imgView.setImageResource(R.drawable.volcano);
                textF2.setVisibility(View.VISIBLE);
                friend2_imgView.setVisibility(View.VISIBLE);
                ImageView friend3_imgView = (ImageView) view.findViewById(R.id.friend3);
                TextView textF3 = (TextView) view.findViewById(R.id.textFieldFriend3);
                textF3.setText("Forest Fire");
                friend3_imgView.setImageResource(R.drawable.forest);
                textF3.setVisibility(View.VISIBLE);
                friend3_imgView.setVisibility(View.VISIBLE);
                ImageView friend4_imgView = (ImageView) view.findViewById(R.id.friend4);
                TextView textF4 = (TextView) view.findViewById(R.id.textFieldFriend4);
                textF4.setText("Biological");
                friend4_imgView.setImageResource(R.drawable.biological);
                textF4.setVisibility(View.VISIBLE);
                friend4_imgView.setVisibility(View.VISIBLE);
                ImageView friend5_imgView = (ImageView) view.findViewById(R.id.friend5);
                TextView textF5 = (TextView) view.findViewById(R.id.textFieldFriend5);
                textF5.setText("Heat Wave");
                friend5_imgView.setImageResource(R.drawable.heat);
                textF5.setVisibility(View.VISIBLE);
                friend5_imgView.setVisibility(View.VISIBLE);
                ImageView friend6_imgView = (ImageView) view.findViewById(R.id.friend6);
                TextView textF6 = (TextView) view.findViewById(R.id.textFieldFriend6);
                textF6.setText("Tornado");
                friend6_imgView.setImageResource(R.drawable.tornado);
                textF6.setVisibility(View.VISIBLE);
                friend6_imgView.setVisibility(View.VISIBLE);

            }
        }
    }

}