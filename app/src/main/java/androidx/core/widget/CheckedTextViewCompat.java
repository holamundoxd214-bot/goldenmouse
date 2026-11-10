package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.annotation.ReplaceWith;

public final class CheckedTextViewCompat {
    private CheckedTextViewCompat() {
        super();
    }

    @ReplaceWith(expression="textView.getCheckMarkDrawable()") @Deprecated public static Drawable getCheckMarkDrawable(CheckedTextView arg0) {
        return arg0.getCheckMarkDrawable();
    }

    public static ColorStateList getCheckMarkTintList(CheckedTextView arg0) {
        return arg0.getCheckMarkTintList();
    }

    public static PorterDuff$Mode getCheckMarkTintMode(CheckedTextView arg0) {
        return arg0.getCheckMarkTintMode();
    }

    public static void setCheckMarkTintList(CheckedTextView arg0, ColorStateList arg1) {
        arg0.setCheckMarkTintList(arg1);
    }

    public static void setCheckMarkTintMode(CheckedTextView arg0, PorterDuff$Mode arg1) {
        arg0.setCheckMarkTintMode(arg1);
    }
}

