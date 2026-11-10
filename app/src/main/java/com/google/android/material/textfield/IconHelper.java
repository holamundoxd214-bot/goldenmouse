package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.view.View$OnClickListener;
import android.view.View$OnLongClickListener;
import android.view.View;
import android.widget.ImageView$ScaleType;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;

class IconHelper {
    private IconHelper() {
        super();
    }

    static void applyIconTint(TextInputLayout arg2, CheckableImageButton arg3, ColorStateList arg4, PorterDuff$Mode arg5) {
        Drawable v0 = arg3.getDrawable();
        if(v0 != null) {
            v0 = DrawableCompat.wrap(v0).mutate();
            if(arg4 == null || !arg4.isStateful()) {
                DrawableCompat.setTintList(v0, arg4);
            }
            else {
                DrawableCompat.setTintList(v0, ColorStateList.valueOf(arg4.getColorForState(IconHelper.mergeIconState(arg2, arg3), arg4.getDefaultColor())));
            }

            if(arg5 == null) {
                goto label_16;
            }

            DrawableCompat.setTintMode(v0, arg5);
        }

    label_16:
        if(arg3.getDrawable() != v0) {
            arg3.setImageDrawable(v0);
        }
    }

    static ImageView$ScaleType convertScaleType(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 != 2) {
                    if(arg1 != 3) {
                        if(arg1 != 5) {
                            if(arg1 != 6) {
                                return ImageView$ScaleType.CENTER;
                            }

                            return ImageView$ScaleType.CENTER_INSIDE;
                        }

                        return ImageView$ScaleType.CENTER_CROP;
                    }

                    return ImageView$ScaleType.FIT_END;
                }

                return ImageView$ScaleType.FIT_CENTER;
            }

            return ImageView$ScaleType.FIT_START;
        }

        return ImageView$ScaleType.FIT_XY;
    }

    private static int[] mergeIconState(TextInputLayout arg3, CheckableImageButton arg4) {
        int[] v3 = arg3.getDrawableState();
        int[] v4 = arg4.getDrawableState();
        int v0 = v3.length;
        v3 = Arrays.copyOf(v3, v3.length + v4.length);
        System.arraycopy(v4, 0, v3, v0, v4.length);
        return v3;
    }

    static void refreshIconDrawableState(TextInputLayout arg2, CheckableImageButton arg3, ColorStateList arg4) {
        Drawable v0 = arg3.getDrawable();
        if(arg3.getDrawable() != null && arg4 != null) {
            if(!arg4.isStateful()) {
            }
            else {
                int v2 = arg4.getColorForState(IconHelper.mergeIconState(arg2, arg3), arg4.getDefaultColor());
                Drawable v4 = DrawableCompat.wrap(v0).mutate();
                DrawableCompat.setTintList(v4, ColorStateList.valueOf(v2));
                arg3.setImageDrawable(v4);
            }
        }
    }

    static void setCompatRippleBackgroundIfNeeded(CheckableImageButton arg0) {
    }

    private static void setIconClickable(CheckableImageButton arg3, View$OnLongClickListener arg4) {
        boolean v0 = ViewCompat.hasOnClickListeners(((View)arg3));
        boolean v1 = false;
        int v2 = 1;
        boolean v4 = arg4 != null ? true : false;
        if((v0) || (v4)) {
            v1 = true;
        }

        arg3.setFocusable(v1);
        arg3.setClickable(v0);
        arg3.setPressable(v0);
        arg3.setLongClickable(v4);
        if(v1) {
        }
        else {
            v2 = 2;
        }

        ViewCompat.setImportantForAccessibility(((View)arg3), v2);
    }

    static void setIconMinSize(CheckableImageButton arg0, int arg1) {
        arg0.setMinimumWidth(arg1);
        arg0.setMinimumHeight(arg1);
    }

    static void setIconOnClickListener(CheckableImageButton arg0, View$OnClickListener arg1, View$OnLongClickListener arg2) {
        arg0.setOnClickListener(arg1);
        IconHelper.setIconClickable(arg0, arg2);
    }

    static void setIconOnLongClickListener(CheckableImageButton arg0, View$OnLongClickListener arg1) {
        arg0.setOnLongClickListener(arg1);
        IconHelper.setIconClickable(arg0, arg1);
    }

    static void setIconScaleType(CheckableImageButton arg0, ImageView$ScaleType arg1) {
        arg0.setScaleType(arg1);
    }
}

