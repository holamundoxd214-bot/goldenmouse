package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.widget.ImageView;

public class ImageViewCompat {
    private ImageViewCompat() {
        super();
    }

    public static ColorStateList getImageTintList(ImageView arg0) {
        return arg0.getImageTintList();
    }

    public static PorterDuff$Mode getImageTintMode(ImageView arg0) {
        return arg0.getImageTintMode();
    }

    public static void setImageTintList(ImageView arg0, ColorStateList arg1) {
        arg0.setImageTintList(arg1);
    }

    public static void setImageTintMode(ImageView arg0, PorterDuff$Mode arg1) {
        arg0.setImageTintMode(arg1);
    }
}

