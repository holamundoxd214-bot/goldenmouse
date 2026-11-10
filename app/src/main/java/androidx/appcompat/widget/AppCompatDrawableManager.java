package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;

public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff$Mode DEFAULT_MODE = null;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    static {
        AppCompatDrawableManager.DEFAULT_MODE = PorterDuff$Mode.SRC_IN;
    }

    public AppCompatDrawableManager() {
        super();
    }

    static PorterDuff$Mode access$000() {
        return AppCompatDrawableManager.DEFAULT_MODE;
    }

    public static AppCompatDrawableManager get() {
        AppCompatDrawableManager v1_1;
        Class v0 = AppCompatDrawableManager.class;
        __monitor_enter(v0);
        try {
            if(AppCompatDrawableManager.INSTANCE == null) {
                AppCompatDrawableManager.preload();
            }

            v1_1 = AppCompatDrawableManager.INSTANCE;
        }
        catch(Throwable v1) {
            try {
            label_9:
                __monitor_exit(v0);
            }
            catch(Throwable v1) {
                goto label_9;
            }

            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public Drawable getDrawable(Context arg2, int arg3) {
        Drawable v2_1;
        __monitor_enter(this);
        try {
            v2_1 = this.mResourceManager.getDrawable(arg2, arg3);
        }
        catch(Throwable v2) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_6;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v2_1;
    }

    Drawable getDrawable(Context arg2, int arg3, boolean arg4) {
        Drawable v2_1;
        __monitor_enter(this);
        try {
            v2_1 = this.mResourceManager.getDrawable(arg2, arg3, arg4);
        }
        catch(Throwable v2) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_6;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v2_1;
    }

    public static PorterDuffColorFilter getPorterDuffColorFilter(int arg1, PorterDuff$Mode arg2) {
        PorterDuffColorFilter v1_1;
        Class v0 = AppCompatDrawableManager.class;
        __monitor_enter(v0);
        try {
            v1_1 = ResourceManagerInternal.getPorterDuffColorFilter(arg1, arg2);
        }
        catch(Throwable v1) {
            try {
            label_6:
                __monitor_exit(v0);
            }
            catch(Throwable v1) {
                goto label_6;
            }

            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    ColorStateList getTintList(Context arg2, int arg3) {
        ColorStateList v2_1;
        __monitor_enter(this);
        try {
            v2_1 = this.mResourceManager.getTintList(arg2, arg3);
        }
        catch(Throwable v2) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_6;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v2_1;
    }

    public void onConfigurationChanged(Context arg2) {
        __monitor_enter(this);
        try {
            this.mResourceManager.onConfigurationChanged(arg2);
        }
        catch(Throwable v2) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_6;
            }

            throw v2;
        }

        __monitor_exit(this);
    }

    Drawable onDrawableLoadedFromResources(Context arg2, VectorEnabledTintResources arg3, int arg4) {
        Drawable v2_1;
        __monitor_enter(this);
        try {
            v2_1 = this.mResourceManager.onDrawableLoadedFromResources(arg2, arg3, arg4);
        }
        catch(Throwable v2) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_6;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v2_1;
    }

    public static void preload() {
        Class v0 = AppCompatDrawableManager.class;
        __monitor_enter(v0);
        try {
            if(AppCompatDrawableManager.INSTANCE == null) {
                AppCompatDrawableManager v1_1 = new AppCompatDrawableManager();
                AppCompatDrawableManager.INSTANCE = v1_1;
                v1_1.mResourceManager = ResourceManagerInternal.get();
                AppCompatDrawableManager.INSTANCE.mResourceManager.setHooks(new ResourceManagerHooks() {
                    private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
                    private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
                    private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
                    private final int[] TINT_CHECKABLE_BUTTON_LIST;
                    private final int[] TINT_COLOR_CONTROL_NORMAL;
                    private final int[] TINT_COLOR_CONTROL_STATE_LIST;

                    private boolean arrayContains(int[] arg4, int arg5) {
                        int v3 = arg4.length;
                        int v1;
                        for(v1 = 0; v1 < v3; ++v1) {
                            if(arg4[v1] == arg5) {
                                return 1;
                            }
                        }

                        return 0;
                    }

                    private ColorStateList createBorderlessButtonColorStateList(Context arg2) {
                        return this.createButtonColorStateList(arg2, 0);
                    }

                    private ColorStateList createButtonColorStateList(Context arg5, int arg6) {
                        int[][] v0 = new int[4][];
                        int[] v4 = new int[4];
                        int v1 = ThemeUtils.getThemeAttrColor(arg5, attr.colorControlHighlight);
                        int v5 = ThemeUtils.getDisabledThemeAttrColor(arg5, attr.colorButtonNormal);
                        v0[0] = ThemeUtils.DISABLED_STATE_SET;
                        v4[0] = v5;
                        v0[1] = ThemeUtils.PRESSED_STATE_SET;
                        v4[1] = ColorUtils.compositeColors(v1, arg6);
                        v0[2] = ThemeUtils.FOCUSED_STATE_SET;
                        v4[2] = ColorUtils.compositeColors(v1, arg6);
                        v0[3] = ThemeUtils.EMPTY_STATE_SET;
                        v4[3] = arg6;
                        return new ColorStateList(v0, v4);
                    }

                    private ColorStateList createColoredButtonColorStateList(Context arg2) {
                        return this.createButtonColorStateList(arg2, ThemeUtils.getThemeAttrColor(arg2, attr.colorAccent));
                    }

                    private ColorStateList createDefaultButtonColorStateList(Context arg2) {
                        return this.createButtonColorStateList(arg2, ThemeUtils.getThemeAttrColor(arg2, attr.colorButtonNormal));
                    }

                    public Drawable createDrawableFor(ResourceManagerInternal arg3, Context arg4, int arg5) {
                        if(arg5 == drawable.abc_cab_background_top_material) {
                            return new LayerDrawable(new Drawable[]{arg3.getDrawable(arg4, drawable.abc_cab_background_internal_bg), arg3.getDrawable(arg4, drawable.abc_cab_background_top_mtrl_alpha)});
                        }

                        if(arg5 == drawable.abc_ratingbar_material) {
                            return this.getRatingBarLayerDrawable(arg3, arg4, dimen.abc_star_big);
                        }

                        if(arg5 == drawable.abc_ratingbar_indicator_material) {
                            return this.getRatingBarLayerDrawable(arg3, arg4, dimen.abc_star_medium);
                        }

                        if(arg5 == drawable.abc_ratingbar_small_material) {
                            return this.getRatingBarLayerDrawable(arg3, arg4, dimen.abc_star_small);
                        }

                        return null;
                    }

                    private ColorStateList createSwitchThumbColorStateList(Context arg7) {
                        int[][] v0 = new int[3][];
                        int[] v6 = new int[3];
                        ColorStateList v1 = ThemeUtils.getThemeAttrColorStateList(arg7, attr.colorSwitchThumbNormal);
                        int v2 = 2;
                        if(v1 == null || !v1.isStateful()) {
                            v0[0] = ThemeUtils.DISABLED_STATE_SET;
                            v6[0] = ThemeUtils.getDisabledThemeAttrColor(arg7, attr.colorSwitchThumbNormal);
                            v0[1] = ThemeUtils.CHECKED_STATE_SET;
                            v6[1] = ThemeUtils.getThemeAttrColor(arg7, attr.colorControlActivated);
                            v0[v2] = ThemeUtils.EMPTY_STATE_SET;
                            v6[v2] = ThemeUtils.getThemeAttrColor(arg7, attr.colorSwitchThumbNormal);
                        }
                        else {
                            int[] v5 = ThemeUtils.DISABLED_STATE_SET;
                            v0[0] = v5;
                            v6[0] = v1.getColorForState(v5, 0);
                            v0[1] = ThemeUtils.CHECKED_STATE_SET;
                            v6[1] = ThemeUtils.getThemeAttrColor(arg7, attr.colorControlActivated);
                            v0[v2] = ThemeUtils.EMPTY_STATE_SET;
                            v6[v2] = v1.getDefaultColor();
                        }

                        return new ColorStateList(v0, v6);
                    }

                    private LayerDrawable getRatingBarLayerDrawable(ResourceManagerInternal arg4, Context arg5, int arg6) {
                        BitmapDrawable v5;
                        BitmapDrawable v6_1;
                        int v3 = arg5.getResources().getDimensionPixelSize(arg6);
                        Drawable v6 = arg4.getDrawable(arg5, drawable.abc_star_black_48dp);
                        Drawable v4 = arg4.getDrawable(arg5, drawable.abc_star_half_black_48dp);
                        if(!(v6 instanceof BitmapDrawable) || v6.getIntrinsicWidth() != v3 || v6.getIntrinsicHeight() != v3) {
                            Bitmap v5_1 = Bitmap.createBitmap(v3, v3, Bitmap$Config.ARGB_8888);
                            Canvas v1 = new Canvas(v5_1);
                            v6.setBounds(0, 0, v3, v3);
                            v6.draw(v1);
                            v6_1 = new BitmapDrawable(v5_1);
                            v5 = new BitmapDrawable(v5_1);
                        }
                        else {
                            v5 = new BitmapDrawable(((BitmapDrawable)v6).getBitmap());
                        }

                        v5.setTileModeX(Shader$TileMode.REPEAT);
                        if(!(v4 instanceof BitmapDrawable) || v4.getIntrinsicWidth() != v3 || v4.getIntrinsicHeight() != v3) {
                            Bitmap v1_1 = Bitmap.createBitmap(v3, v3, Bitmap$Config.ARGB_8888);
                            Canvas v2 = new Canvas(v1_1);
                            v4.setBounds(0, 0, v3, v3);
                            v4.draw(v2);
                            BitmapDrawable v4_1 = new BitmapDrawable(v1_1);
                        }
                        else {
                        }

                        LayerDrawable v3_1 = new LayerDrawable(new Drawable[]{((Drawable)v6_1), v4, v5});
                        v3_1.setId(0, 0x1020000);
                        v3_1.setId(1, 0x102000F);
                        v3_1.setId(2, 0x102000D);
                        return v3_1;
                    }

                    public ColorStateList getTintListForDrawableRes(Context arg2, int arg3) {
                        if(arg3 == drawable.abc_edit_text_material) {
                            return AppCompatResources.getColorStateList(arg2, color.abc_tint_edittext);
                        }

                        if(arg3 == drawable.abc_switch_track_mtrl_alpha) {
                            return AppCompatResources.getColorStateList(arg2, color.abc_tint_switch_track);
                        }

                        if(arg3 == drawable.abc_switch_thumb_material) {
                            return this.createSwitchThumbColorStateList(arg2);
                        }

                        if(arg3 == drawable.abc_btn_default_mtrl_shape) {
                            return this.createDefaultButtonColorStateList(arg2);
                        }

                        if(arg3 == drawable.abc_btn_borderless_material) {
                            return this.createBorderlessButtonColorStateList(arg2);
                        }

                        if(arg3 == drawable.abc_btn_colored_material) {
                            return this.createColoredButtonColorStateList(arg2);
                        }

                        if(arg3 != drawable.abc_spinner_mtrl_am_alpha) {
                            if(arg3 == drawable.abc_spinner_textfield_background_material) {
                            }
                            else if(this.arrayContains(this.TINT_COLOR_CONTROL_NORMAL, arg3)) {
                                return ThemeUtils.getThemeAttrColorStateList(arg2, attr.colorControlNormal);
                            }
                            else if(this.arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, arg3)) {
                                return AppCompatResources.getColorStateList(arg2, color.abc_tint_default);
                            }
                            else if(this.arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, arg3)) {
                                return AppCompatResources.getColorStateList(arg2, color.abc_tint_btn_checkable);
                            }
                            else if(arg3 == drawable.abc_seekbar_thumb_material) {
                                return AppCompatResources.getColorStateList(arg2, color.abc_tint_seek_thumb);
                            }
                            else {
                                return null;
                            }
                        }

                        return AppCompatResources.getColorStateList(arg2, color.abc_tint_spinner);
                    }

                    public PorterDuff$Mode getTintModeForDrawableRes(int arg1) {
                        if(arg1 == drawable.abc_switch_thumb_material) {
                            return PorterDuff$Mode.MULTIPLY;
                        }

                        return null;
                    }

                    private void setPorterDuffColorFilter(Drawable arg1, int arg2, PorterDuff$Mode arg3) {
                        if(DrawableUtils.canSafelyMutateDrawable(arg1)) {
                            arg1 = arg1.mutate();
                        }

                        if(arg3 == null) {
                            arg3 = AppCompatDrawableManager.DEFAULT_MODE;
                        }

                        arg1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(arg2, arg3));
                    }

                    public boolean tintDrawable(Context arg6, int arg7, Drawable arg8) {
                        int v2 = 0x102000D;
                        int v3 = 0x102000F;
                        int v4 = 0x1020000;
                        if(arg7 == drawable.abc_seekbar_track_material) {
                            this.setPorterDuffColorFilter(((LayerDrawable)arg8).findDrawableByLayerId(v4), ThemeUtils.getThemeAttrColor(arg6, attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                            this.setPorterDuffColorFilter(((LayerDrawable)arg8).findDrawableByLayerId(v3), ThemeUtils.getThemeAttrColor(arg6, attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                            this.setPorterDuffColorFilter(((LayerDrawable)arg8).findDrawableByLayerId(v2), ThemeUtils.getThemeAttrColor(arg6, attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                            return 1;
                        }

                        if(arg7 != drawable.abc_ratingbar_material && arg7 != drawable.abc_ratingbar_indicator_material) {
                            if(arg7 == drawable.abc_ratingbar_small_material) {
                            }
                            else {
                                return 0;
                            }
                        }

                        this.setPorterDuffColorFilter(((LayerDrawable)arg8).findDrawableByLayerId(v4), ThemeUtils.getDisabledThemeAttrColor(arg6, attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                        this.setPorterDuffColorFilter(((LayerDrawable)arg8).findDrawableByLayerId(v3), ThemeUtils.getThemeAttrColor(arg6, attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                        this.setPorterDuffColorFilter(((LayerDrawable)arg8).findDrawableByLayerId(v2), ThemeUtils.getThemeAttrColor(arg6, attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                        return 1;
                    }

                    public boolean tintDrawableUsingColorFilter(Context arg6, int arg7, Drawable arg8) {
                        int v5;
                        PorterDuff$Mode v0 = AppCompatDrawableManager.DEFAULT_MODE;
                        int v4 = -1;
                        if(this.arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, arg7)) {
                            v5 = attr.colorControlNormal;
                            goto label_8;
                        }
                        else if(this.arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, arg7)) {
                            v5 = attr.colorControlActivated;
                            goto label_8;
                        }
                        else {
                            int v1 = 0x1010031;
                            if(this.arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, arg7)) {
                                v0 = PorterDuff$Mode.MULTIPLY;
                            }
                            else if(arg7 == drawable.abc_list_divider_mtrl_alpha) {
                                arg7 = Math.round(40.799999f);
                                v5 = 0x1010030;
                                v1 = 1;
                                goto label_39;
                            }
                            else if(arg7 == drawable.abc_dialog_material_background) {
                            }
                            else {
                                goto label_36;
                            }

                            v5 = v1;
                        label_8:
                            v1 = 1;
                            goto label_9;
                        label_36:
                            v5 = 0;
                            v1 = 0;
                        label_9:
                            arg7 = v4;
                        }

                    label_39:
                        if(v1 != 0) {
                            if(DrawableUtils.canSafelyMutateDrawable(arg8)) {
                                arg8 = arg8.mutate();
                            }

                            arg8.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(arg6, v5), v0));
                            if(arg7 != v4) {
                                arg8.setAlpha(arg7);
                            }

                            return 1;
                        }

                        return 0;
                    }
                });
            }
        }
        catch(Throwable v1) {
            try {
            label_17:
                __monitor_exit(v0);
            }
            catch(Throwable v1) {
                goto label_17;
            }

            throw v1;
        }

        __monitor_exit(v0);
    }

    static void tintDrawable(Drawable arg0, TintInfo arg1, int[] arg2) {
        ResourceManagerInternal.tintDrawable(arg0, arg1, arg2);
    }

    boolean tintDrawableUsingColorFilter(Context arg1, int arg2, Drawable arg3) {
        return this.mResourceManager.tintDrawableUsingColorFilter(arg1, arg2, arg3);
    }
}

