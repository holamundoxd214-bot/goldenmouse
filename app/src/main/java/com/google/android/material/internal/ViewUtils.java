package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.drawable.DrawableUtils;
import java.util.ArrayList;
import java.util.List;

public class ViewUtils {
    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View arg1, WindowInsetsCompat arg2, RelativePadding arg3);
    }

    public class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int arg1, int arg2, int arg3, int arg4) {
            super();
            this.start = arg1;
            this.top = arg2;
            this.end = arg3;
            this.bottom = arg4;
        }

        public RelativePadding(RelativePadding arg2) {
            super();
            this.start = arg2.start;
            this.top = arg2.top;
            this.end = arg2.end;
            this.bottom = arg2.bottom;
        }

        public void applyToView(View arg4) {
            ViewCompat.setPaddingRelative(arg4, this.start, this.top, this.end, this.bottom);
        }
    }

    public static final int EDGE_TO_EDGE_FLAGS = 0x300;

    private ViewUtils() {
        super();
    }

    public static void addOnGlobalLayoutListener(View arg0, ViewTreeObserver$OnGlobalLayoutListener arg1) {
        if(arg0 != null) {
            arg0.getViewTreeObserver().addOnGlobalLayoutListener(arg1);
        }
    }

    public static Rect calculateOffsetRectFromBounds(View arg5, View arg6) {
        int[] v1 = new int[2];
        arg6.getLocationOnScreen(v1);
        int v3 = v1[0];
        int v1_1 = v1[1];
        int[] v0 = new int[2];
        arg5.getLocationOnScreen(v0);
        v3 -= v0[0];
        v1_1 -= v0[1];
        return new Rect(v3, v1_1, arg6.getWidth() + v3, arg6.getHeight() + v1_1);
    }

    public static Rect calculateRectFromBounds(View arg4, int arg5) {
        return new Rect(arg4.getLeft(), arg4.getTop() + arg5, arg4.getRight(), arg4.getBottom() + arg5);
    }

    public static Rect calculateRectFromBounds(View arg1) {
        return ViewUtils.calculateRectFromBounds(arg1, 0);
    }

    public static void doOnApplyWindowInsets(View arg2, AttributeSet arg3, int arg4, int arg5, OnApplyWindowInsetsListener arg6) {
        TypedArray v3 = arg2.getContext().obtainStyledAttributes(arg3, styleable.Insets, arg4, arg5);
        boolean v4 = v3.getBoolean(styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean v0 = v3.getBoolean(styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean v5 = v3.getBoolean(styleable.Insets_paddingRightSystemWindowInsets, false);
        v3.recycle();
        ViewUtils.doOnApplyWindowInsets(arg2, new OnApplyWindowInsetsListener(v4, v0, v5, arg6) {
            public WindowInsetsCompat onApplyWindowInsets(View arg4, WindowInsetsCompat arg5, RelativePadding arg6) {
                if(this.val$paddingBottomSystemWindowInsets) {
                    arg6.bottom += arg5.getSystemWindowInsetBottom();
                }

                boolean v0 = ViewUtils.isLayoutRtl(arg4);
                if(this.val$paddingLeftSystemWindowInsets) {
                    if(v0) {
                        arg6.end += arg5.getSystemWindowInsetLeft();
                    }
                    else {
                        arg6.start += arg5.getSystemWindowInsetLeft();
                    }
                }

                if(this.val$paddingRightSystemWindowInsets) {
                    if(v0) {
                        arg6.start += arg5.getSystemWindowInsetRight();
                    }
                    else {
                        arg6.end += arg5.getSystemWindowInsetRight();
                    }
                }

                arg6.applyToView(arg4);
                OnApplyWindowInsetsListener v3 = this.val$listener;
                if(v3 != null) {
                    return v3.onApplyWindowInsets(arg4, arg5, arg6);
                }

                return arg5;
            }
        });
    }

    public static void doOnApplyWindowInsets(View arg5, OnApplyWindowInsetsListener arg6) {
        ViewCompat.setOnApplyWindowInsetsListener(arg5, new androidx.core.view.OnApplyWindowInsetsListener(arg6, new RelativePadding(ViewCompat.getPaddingStart(arg5), arg5.getPaddingTop(), ViewCompat.getPaddingEnd(arg5), arg5.getPaddingBottom())) {
            public WindowInsetsCompat onApplyWindowInsets(View arg3, WindowInsetsCompat arg4) {
                return this.val$listener.onApplyWindowInsets(arg3, arg4, new RelativePadding(this.val$initialPadding));
            }
        });
        ViewUtils.requestApplyInsetsWhenAttached(arg5);
    }

    public static void doOnApplyWindowInsets(View arg1, AttributeSet arg2, int arg3, int arg4) {
        ViewUtils.doOnApplyWindowInsets(arg1, arg2, arg3, arg4, null);
    }

    public static float dpToPx(Context arg1, int arg2) {
        return TypedValue.applyDimension(1, ((float)arg2), arg1.getResources().getDisplayMetrics());
    }

    public static Integer getBackgroundColor(View arg0) {
        ColorStateList v0 = DrawableUtils.getColorStateListOrNull(arg0.getBackground());
        if(v0 != null) {
            return Integer.valueOf(v0.getDefaultColor());
        }

        return null;
    }

    public static List getChildren(View arg3) {
        ArrayList v0 = new ArrayList();
        if((arg3 instanceof ViewGroup)) {
            int v1;
            for(v1 = 0; v1 < ((ViewGroup)arg3).getChildCount(); ++v1) {
                ((List)v0).add(((ViewGroup)arg3).getChildAt(v1));
            }
        }

        return ((List)v0);
    }

    public static ViewGroup getContentView(View arg3) {
        ViewGroup v0 = null;
        if(arg3 == null) {
            return v0;
        }

        View v1 = arg3.getRootView();
        View v2 = v1.findViewById(0x1020002);
        if(v2 != null) {
            return ((ViewGroup)v2);
        }

        if(v1 != arg3 && ((v1 instanceof ViewGroup))) {
            return ((ViewGroup)v1);
        }

        return v0;
    }

    public static ViewOverlayImpl getContentViewOverlay(View arg0) {
        return ViewUtils.getOverlay(ViewUtils.getContentView(arg0));
    }

    private static InputMethodManager getInputMethodManager(View arg1) {
        return ContextCompat.getSystemService(arg1.getContext(), InputMethodManager.class);
    }

    public static ViewOverlayImpl getOverlay(View arg1) {
        if(arg1 == null) {
            return null;
        }

        return new ViewOverlayApi18(arg1);
    }

    public static float getParentAbsoluteElevation(View arg2) {
        ViewParent v2 = arg2.getParent();
        float v0 = 0f;
        while((v2 instanceof View)) {
            v0 += ViewCompat.getElevation(v2);
            v2 = v2.getParent();
        }

        return v0;
    }

    public static void hideKeyboard(View arg1, boolean arg2) {
        if(arg2) {
            WindowInsetsControllerCompat v2 = ViewCompat.getWindowInsetsController(arg1);
            if(v2 != null) {
                v2.hide(Type.ime());
                return;
            }
        }

        InputMethodManager v2_1 = ViewUtils.getInputMethodManager(arg1);
        if(v2_1 != null) {
            v2_1.hideSoftInputFromWindow(arg1.getWindowToken(), 0);
        }
    }

    public static void hideKeyboard(View arg1) {
        ViewUtils.hideKeyboard(arg1, true);
    }

    public static boolean isLayoutRtl(View arg1) {
        if(ViewCompat.getLayoutDirection(arg1) == 1) {
            return 1;
        }

        return 0;
    }

    static void lambda$requestFocusAndShowKeyboard$0(View arg0, boolean arg1) {
        ViewUtils.showKeyboard(arg0, arg1);
    }

    public static PorterDuff$Mode parseTintMode(int arg1, PorterDuff$Mode arg2) {
        if(arg1 == 3) {
            goto label_18;
        }

        if(arg1 == 5) {
            goto label_16;
        }

        if(arg1 == 9) {
            goto label_14;
        }

        switch(arg1) {
            case 14: {
                goto label_12;
            }
            case 15: {
                goto label_10;
            }
            case 16: {
                goto label_8;
            }
        }

        return arg2;
    label_8:
        return PorterDuff$Mode.ADD;
    label_10:
        return PorterDuff$Mode.SCREEN;
    label_12:
        return PorterDuff$Mode.MULTIPLY;
    label_14:
        return PorterDuff$Mode.SRC_ATOP;
    label_16:
        return PorterDuff$Mode.SRC_IN;
    label_18:
        return PorterDuff$Mode.SRC_OVER;
    }

    public static void removeOnGlobalLayoutListener(View arg0, ViewTreeObserver$OnGlobalLayoutListener arg1) {
        if(arg0 != null) {
            ViewUtils.removeOnGlobalLayoutListener(arg0.getViewTreeObserver(), arg1);
        }
    }

    public static void removeOnGlobalLayoutListener(ViewTreeObserver arg0, ViewTreeObserver$OnGlobalLayoutListener arg1) {
        arg0.removeOnGlobalLayoutListener(arg1);
    }

    public static void requestApplyInsetsWhenAttached(View arg1) {
        if(ViewCompat.isAttachedToWindow(arg1)) {
            ViewCompat.requestApplyInsets(arg1);
            return;
        }

        arg1.addOnAttachStateChangeListener(new View$OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View arg1) {
                arg1.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
                ViewCompat.requestApplyInsets(arg1);
            }

            public void onViewDetachedFromWindow(View arg1) {
            }
        });
    }

    public static void requestFocusAndShowKeyboard(View arg1, boolean arg2) {
        arg1.requestFocus();
        arg1.post(new ViewUtils$$ExternalSyntheticLambda0(arg1, arg2));
    }

    public static void requestFocusAndShowKeyboard(View arg1) {
        ViewUtils.requestFocusAndShowKeyboard(arg1, true);
    }

    public static void setBoundsFromRect(View arg1, Rect arg2) {
        arg1.setLeft(arg2.left);
        arg1.setTop(arg2.top);
        arg1.setRight(arg2.right);
        arg1.setBottom(arg2.bottom);
    }

    public static void showKeyboard(View arg1, boolean arg2) {
        if(arg2) {
            WindowInsetsControllerCompat v2 = ViewCompat.getWindowInsetsController(arg1);
            if(v2 != null) {
                v2.show(Type.ime());
                return;
            }
        }

        ViewUtils.getInputMethodManager(arg1).showSoftInput(arg1, 1);
    }

    public static void showKeyboard(View arg1) {
        ViewUtils.showKeyboard(arg1, true);
    }
}

