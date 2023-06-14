package com.app.turistae.utils;

import com.denzcoskun.imageslider.constants.ScaleTypes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class CustomSlideModel {
    private String imageUrl;
    private Integer imagePath;
    private String title;
    private ScaleTypes scaleType;

    public CustomSlideModel(String imageUrl, String title, ScaleTypes scaleType) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.scaleType = scaleType;
    }

    public CustomSlideModel(Integer imagePath, String title, ScaleTypes scaleType) {
        this.imagePath = imagePath;
        this.title = title;
        this.scaleType = scaleType;
    }

    public CustomSlideModel(String imageUrl, ScaleTypes scaleType) {
        this.imageUrl = imageUrl;
        this.scaleType = scaleType;
    }

    public CustomSlideModel(Integer imagePath, ScaleTypes scaleType) {
        this.imagePath = imagePath;
        this.scaleType = scaleType;
    }

    public CustomSlideModel(Bitmap bitmap, ScaleTypes scaleType) {
        this.imageUrl = bitmapToBase64(bitmap);
        this.scaleType = scaleType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getImagePath() {
        return imagePath;
    }

    public void setImagePath(Integer imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ScaleTypes getScaleType() {
        return scaleType;
    }

    public void setScaleType(ScaleTypes scaleType) {
        this.scaleType = scaleType;
    }

    private String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return "data:image/png;base64," + Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    private Bitmap base64ToBitmap(String base64Image) {
        if (base64Image != null && !base64Image.isEmpty()) {
            String pureBase64Image = base64Image.split(",")[1];
            byte[] decodedString = Base64.decode(pureBase64Image, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        }
        return null;
    }
}
