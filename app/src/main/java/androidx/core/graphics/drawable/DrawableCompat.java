package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ReplaceWith;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
    private DrawableCompat() {
        super();
    }

    public static void applyTheme(Drawable arg0, Resources$Theme arg1) {
        arg0.applyTheme(arg1);
    }

    public static boolean canApplyTheme(Drawable arg0) {
        return arg0.canApplyTheme();
    }

    public static void clearColorFilter(Drawable arg0) {
        arg0.clearColorFilter();
    }

    @ReplaceWith(expression="drawable.getAlpha()") @Deprecated public static int getAlpha(Drawable arg0) {
        return arg0.getAlpha();
    }

    public static ColorFilter getColorFilter(Drawable arg0) {
        return arg0.getColorFilter();
    }

    public static int getLayoutDirection(Drawable arg0) {
        return arg0.getLayoutDirection();
    }

    public static void inflate(Drawable arg0, Resources arg1, XmlPullParser arg2, AttributeSet arg3, Resources$Theme arg4) throws XmlPullParserException, IOException {
        arg0.inflate(arg1, arg2, arg3, arg4);
    }

    @ReplaceWith(expression="drawable.isAutoMirrored()") @Deprecated public static boolean isAutoMirrored(Drawable arg0) {
        return arg0.isAutoMirrored();
    }

    @ReplaceWith(expression="drawable.jumpToCurrentState()") @Deprecated public static void jumpToCurrentState(Drawable arg0) {
        arg0.jumpToCurrentState();
    }

    @ReplaceWith(expression="drawable.setAutoMirrored(mirrored)") @Deprecated public static void setAutoMirrored(Drawable arg0, boolean arg1) {
        arg0.setAutoMirrored(arg1);
    }

    public static void setHotspot(Drawable arg0, float arg1, float arg2) {
        arg0.setHotspot(arg1, arg2);
    }

    public static void setHotspotBounds(Drawable arg0, int arg1, int arg2, int arg3, int arg4) {
        arg0.setHotspotBounds(arg1, arg2, arg3, arg4);
    }

    public static boolean setLayoutDirection(Drawable arg0, int arg1) {
        return arg0.setLayoutDirection(arg1);
    }

    public static void setTint(Drawable arg0, int arg1) {
        arg0.setTint(arg1);
    }

    public static void setTintList(Drawable arg0, ColorStateList arg1) {
        arg0.setTintList(arg1);
    }

    public static void setTintMode(Drawable arg0, PorterDuff$Mode arg1) {
        arg0.setTintMode(arg1);
    }

    public static Drawable unwrap(Drawable arg1) {
        if((arg1 instanceof WrappedDrawable)) {
            arg1 = ((WrappedDrawable)arg1).getWrappedDrawable();
        }

        return arg1;
    }

    public static Drawable wrap(Drawable arg0) {
        return arg0;
    }
}

