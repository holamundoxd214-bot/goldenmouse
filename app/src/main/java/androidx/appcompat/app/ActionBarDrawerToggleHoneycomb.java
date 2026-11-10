package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb {
    class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        SetIndicatorInfo(Activity arg7) {
            super();
            try {
                Class v2 = ActionBar.class;
                this.setHomeAsUpIndicator = v2.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.setHomeActionContentDescription = v2.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
                return;
            }
            catch(NoSuchMethodException ) {
                int v2_1 = 0x102002C;
                View v7 = arg7.findViewById(v2_1);
                if(v7 == null) {
                }
                else {
                    ViewParent v7_1 = v7.getParent();
                    if(((ViewGroup)v7_1).getChildCount() != 2) {
                    }
                    else {
                        View v0 = ((ViewGroup)v7_1).getChildAt(0);
                        v7 = ((ViewGroup)v7_1).getChildAt(1);
                        if(v0.getId() == v2_1) {
                            v0 = v7;
                        }

                        if(!(v0 instanceof ImageView)) {
                            return;
                        }

                        this.upIndicatorView = ((ImageView)v0);
                    }
                }

                return;
            }
        }
    }

    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS;

    static {
        ActionBarDrawerToggleHoneycomb.THEME_ATTRS = new int[]{0x101030B};
    }

    private ActionBarDrawerToggleHoneycomb() {
        super();
    }

    public static Drawable getThemeUpIndicator(Activity arg1) {
        TypedArray v1 = arg1.obtainStyledAttributes(ActionBarDrawerToggleHoneycomb.THEME_ATTRS);
        Drawable v0 = v1.getDrawable(0);
        v1.recycle();
        return v0;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo arg1, Activity arg2, int arg3) {
        if(arg1 == null) {
            arg1 = new SetIndicatorInfo(arg2);
        }

        if(arg1.setHomeAsUpIndicator != null) {
            try {
                arg1.setHomeActionContentDescription.invoke(arg2.getActionBar(), Integer.valueOf(arg3));
                return arg1;
            }
            catch(Exception v2) {
                Log.w("ActionBarDrawerToggleHC", "Couldn\'t set content description via JB-MR2 API", ((Throwable)v2));
            }
        }

        return arg1;
    }

    public static SetIndicatorInfo setActionBarUpIndicator(Activity arg3, Drawable arg4, int arg5) {
        SetIndicatorInfo v0 = new SetIndicatorInfo(arg3);
        String v2 = "ActionBarDrawerToggleHC";
        if(v0.setHomeAsUpIndicator != null) {
            try {
                ActionBar v3_1 = arg3.getActionBar();
                v0.setHomeAsUpIndicator.invoke(v3_1, arg4);
                v0.setHomeActionContentDescription.invoke(v3_1, Integer.valueOf(arg5));
                return v0;
            }
            catch(Exception v3) {
                Log.w(v2, "Couldn\'t set home-as-up indicator via JB-MR2 API", ((Throwable)v3));
                return v0;
            }
        }

        if(v0.upIndicatorView != null) {
            v0.upIndicatorView.setImageDrawable(arg4);
            return v0;
        }

        Log.w(v2, "Couldn\'t set home-as-up indicator");
        return v0;
    }
}

