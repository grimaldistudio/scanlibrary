package com.scanlibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by jhansi on 05/04/15.
 */
public class Utils {

    private Utils() {

    }

    public static Uri getUri(Context context, Bitmap bitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);   

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        /*
        if (width > height) {
            // landscape
            float ratio = (float) width / 1440;
            width = 1440;
            height = (int)(height / ratio);
        } else if (height > width) {
            // portrait
            float ratio = (float) height / 2960;
            height = 2960;
            width = (int)(width / ratio);
        } else {
            // square
            height = 2960;
            width = 1440;
        }
        */
    
        bitmap = Bitmap.createScaledBitmap(bitmap,width,height, false);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Title", null);
        return Uri.parse(path);
    }

    public static Bitmap getBitmap(Context context, Uri uri) throws IOException {
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
        return bitmap;
    }
}
