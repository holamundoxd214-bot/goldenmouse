package com.google.android.material.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources$NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build$VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableUtils {
    public static final int INTRINSIC_SIZE = -1;
    private static final int UNSPECIFIED_HEIGHT = -1;
    private static final int UNSPECIFIED_WIDTH = -1;

    private DrawableUtils() {
        super();
    }

    public static Drawable compositeTwoLayeredDrawable(Drawable arg1, Drawable arg2) {
        return DrawableUtils.compositeTwoLayeredDrawable(arg1, arg2, -1, -1);
    }

    public static Drawable compositeTwoLayeredDrawable(Drawable arg4, Drawable arg5, int arg6, int arg7) {
        if(arg4 == null) {
            return arg5;
        }

        if(arg5 == null) {
            return arg4;
        }

        int v0 = -1;
        if(arg6 == v0) {
            arg6 = DrawableUtils.getTopLayerIntrinsicWidth(arg4, arg5);
        }

        if(arg7 == v0) {
            arg7 = DrawableUtils.getTopLayerIntrinsicHeight(arg4, arg5);
        }

        if(arg6 > arg4.getIntrinsicWidth() || arg7 > arg4.getIntrinsicHeight()) {
            float v6 = (((float)arg6)) / (((float)arg7));
            if(v6 >= (((float)arg4.getIntrinsicWidth())) / (((float)arg4.getIntrinsicHeight()))) {
                arg7 = arg4.getIntrinsicWidth();
                int v3 = arg7;
                arg7 = ((int)((((float)arg7)) / v6));
                arg6 = v3;
            }
            else {
                arg7 = arg4.getIntrinsicHeight();
                arg6 = ((int)(v6 * (((float)arg7))));
            }
        }
        else {
        }

        LayerDrawable v0_1 = new LayerDrawable(new Drawable[]{arg4, arg5});
        v0_1.setLayerSize(1, arg6, arg7);
        v0_1.setLayerGravity(1, 17);
        return ((Drawable)v0_1);
    }

    public static Drawable createTintableDrawableIfNeeded(Drawable arg1, ColorStateList arg2, PorterDuff$Mode arg3) {
        return DrawableUtils.createTintableMutatedDrawableIfNeeded(arg1, arg2, arg3, false);
    }

    public static Drawable createTintableMutatedDrawableIfNeeded(Drawable arg1, ColorStateList arg2, PorterDuff$Mode arg3) {
        return DrawableUtils.createTintableMutatedDrawableIfNeeded(arg1, arg2, arg3, false);
    }

    private static Drawable createTintableMutatedDrawableIfNeeded(Drawable arg0, ColorStateList arg1, PorterDuff$Mode arg2, boolean arg3) {
        if(arg0 == null) {
            return null;
        }

        if(arg1 != null) {
            arg0 = DrawableCompat.wrap(arg0).mutate();
            if(arg2 != null) {
                DrawableCompat.setTintMode(arg0, arg2);
            }

            return arg0;
        }

        if(arg3) {
            arg0.mutate();
        }

        return arg0;
    }

    public static int[] getCheckedState(int[] arg3) {
        int v2;
        int v0;
        for(v0 = 0; true; ++v0) {
            v2 = 0x10100A0;
            if(v0 >= arg3.length) {
                break;
            }

            int v1 = arg3[v0];
            if(v1 == v2) {
                return arg3;
            }

            if(v1 == 0) {
                Object v3 = arg3.clone();
                v3[v0] = v2;
                return ((int[])v3);
            }
        }

        int[] v0_1 = Arrays.copyOf(arg3, arg3.length + 1);
        v0_1[arg3.length] = v2;
        return v0_1;
    }

    public static ColorStateList getColorStateListOrNull(Drawable arg2) {
        if((arg2 instanceof ColorDrawable)) {
            return ColorStateList.valueOf(((ColorDrawable)arg2).getColor());
        }

        if(Build$VERSION.SDK_INT >= 29 && ((arg2 instanceof ColorStateListDrawable))) {
            return ((ColorStateListDrawable)arg2).getColorStateList();
        }

        return null;
    }

    private static int getTopLayerIntrinsicHeight(Drawable arg1, Drawable arg2) {
        int v2 = arg2.getIntrinsicHeight();
        if(v2 != -1) {
            return v2;
        }

        return arg1.getIntrinsicHeight();
    }

    private static int getTopLayerIntrinsicWidth(Drawable arg1, Drawable arg2) {
        int v2 = arg2.getIntrinsicWidth();
        if(v2 != -1) {
            return v2;
        }

        return arg1.getIntrinsicWidth();
    }

    public static int[] getUncheckedState(int[] arg6) {
        int[] v0 = new int[arg6.length];
        int v1 = arg6.length;
        int v2 = 0;
        int v3 = 0;
        while(v2 < v1) {
            int v4 = arg6[v2];
            if(v4 != 0x10100A0) {
                v0[v3] = v4;
                ++v3;
            }

            ++v2;
        }

        return v0;
    }

    public static AttributeSet parseDrawableXml(Context arg3, int arg4, CharSequence arg5) {
        try {
            XmlResourceParser v3_2 = arg3.getResources().getXml(arg4);
            do {
                int v0 = ((XmlPullParser)v3_2).next();
                int v1 = 2;
                if(v0 == v1) {
                    break;
                }
            }
            while(v0 != 1);

            if(v0 == v1) {
                if(TextUtils.equals(((XmlPullParser)v3_2).getName(), arg5)) {
                    return Xml.asAttributeSet(((XmlPullParser)v3_2));
                }

                throw new XmlPullParserException("Must have a <" + arg5 + "> start tag");
            }

            throw new XmlPullParserException("No start tag found");
        }
        catch(IOException v3) {
        }
        catch(XmlPullParserException v3_1) {
        }

        Resources$NotFoundException v5 = new Resources$NotFoundException("Can\'t load badge resource ID #0x" + Integer.toHexString(arg4));
        v5.initCause(((Throwable)v3));
        throw v5;
    }

    public static void setOutlineToPath(Outline arg2, Path arg3) {
        if(Build$VERSION.SDK_INT >= 30) {
            arg2.setPath(arg3);
            return;
        }

        if(Build$VERSION.SDK_INT >= 29) {
            try {
                arg2.setConvexPath(arg3);
                return;
            }
            catch(IllegalArgumentException ) {
                return;
            }
        }

        if(arg3.isConvex()) {
            arg2.setConvexPath(arg3);
        }
    }

    public static void setRippleDrawableRadius(RippleDrawable arg0, int arg1) {
        arg0.setRadius(arg1);
    }

    public static void setTint(Drawable arg1, int arg2) {
        int v0 = arg2 != 0 ? 1 : 0;
        if(v0 != 0) {
            DrawableCompat.setTint(arg1, arg2);
            return;
        }

        DrawableCompat.setTintList(arg1, null);
    }

    public static PorterDuffColorFilter updateTintFilter(Drawable arg1, ColorStateList arg2, PorterDuff$Mode arg3) {
        if(arg2 != null) {
            if(arg3 == null) {
            }
            else {
                return new PorterDuffColorFilter(arg2.getColorForState(arg1.getState(), 0), arg3);
            }
        }

        return null;
    }
}

