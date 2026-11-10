package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

public final class CompoundButtonCompat {
    private CompoundButtonCompat() {
        super();
    }

    public static Drawable getButtonDrawable(CompoundButton arg0) {
        return arg0.getButtonDrawable();
    }

    public static ColorStateList getButtonTintList(CompoundButton arg0) {
        return arg0.getButtonTintList();
    }

    public static PorterDuff$Mode getButtonTintMode(CompoundButton arg0) {
        return arg0.getButtonTintMode();
    }

    public static void setButtonTintList(CompoundButton arg0, ColorStateList arg1) {
        arg0.setButtonTintList(arg1);
    }

    public static void setButtonTintMode(CompoundButton arg0, PorterDuff$Mode arg1) {
        arg0.setButtonTintMode(arg1);
    }
}

