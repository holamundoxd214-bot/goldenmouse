package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;

public class Snackbar extends BaseTransientBottomBar {
    public class Callback extends BaseCallback {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        public Callback() {
            super();
        }

        public void onDismissed(Snackbar arg1, int arg2) {
        }

        public void onDismissed(Object arg1, int arg2) {
            this.onDismissed(((Snackbar)arg1), arg2);
        }

        public void onShown(Snackbar arg1) {
        }

        public void onShown(Object arg1) {
            this.onShown(((Snackbar)arg1));
        }
    }

    public final class SnackbarLayout extends SnackbarBaseLayout {
        public SnackbarLayout(Context arg1) {
            super(arg1);
        }

        public SnackbarLayout(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
        }

        protected void onMeasure(int arg6, int arg7) {
            super.onMeasure(arg6, arg7);
            arg6 = this.getChildCount();
            arg7 = this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int v0;
            for(v0 = 0; v0 < arg6; ++v0) {
                View v1 = this.getChildAt(v0);
                if(v1.getLayoutParams().width == -1) {
                    v1.measure(View$MeasureSpec.makeMeasureSpec(arg7, 0x40000000), View$MeasureSpec.makeMeasureSpec(v1.getMeasuredHeight(), 0x40000000));
                }
            }
        }

        public void setBackground(Drawable arg1) {
            super.setBackground(arg1);
        }

        public void setBackgroundDrawable(Drawable arg1) {
            super.setBackgroundDrawable(arg1);
        }

        public void setBackgroundTintList(ColorStateList arg1) {
            super.setBackgroundTintList(arg1);
        }

        public void setBackgroundTintMode(PorterDuff$Mode arg1) {
            super.setBackgroundTintMode(arg1);
        }

        public void setLayoutParams(ViewGroup$LayoutParams arg1) {
            super.setLayoutParams(arg1);
        }

        public void setOnClickListener(View$OnClickListener arg1) {
            super.setOnClickListener(arg1);
        }
    }

    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR;
    private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS;
    private final AccessibilityManager accessibilityManager;
    private BaseCallback callback;
    private boolean hasAction;

    static {
        Snackbar.SNACKBAR_BUTTON_STYLE_ATTR = new int[]{attr.snackbarButtonStyle};
        Snackbar.SNACKBAR_CONTENT_STYLE_ATTRS = new int[]{attr.snackbarButtonStyle, attr.snackbarTextViewStyle};
    }

    private Snackbar(Context arg1, ViewGroup arg2, View arg3, ContentViewCallback arg4) {
        super(arg1, arg2, arg3, arg4);
        this.accessibilityManager = arg2.getContext().getSystemService("accessibility");
    }

    public void dismiss() {
        super.dismiss();
    }

    private static ViewGroup findSuitableParent(View arg3) {
        View v0 = null;
        ViewGroup v1 = ((ViewGroup)v0);
        do {
            if((arg3 instanceof CoordinatorLayout)) {
                return arg3;
            }

            if((arg3 instanceof FrameLayout)) {
                if(arg3.getId() == 0x1020002) {
                    return arg3;
                }
                else {
                    View v1_1 = arg3;
                }
            }

            if(arg3 != null) {
                ViewParent v3 = ((View)v3).getParent();
                if((v3 instanceof View)) {
                }
                else {
                    arg3 = v0;
                }
            }
        }
        while(arg3 != null);

        return v1;
    }

    private Button getActionView() {
        return this.getContentLayout().getActionView();
    }

    private SnackbarContentLayout getContentLayout() {
        return this.view.getChildAt(0);
    }

    public int getDuration() {
        int v0 = super.getDuration();
        int v1 = -2;
        if(v0 == v1) {
            return v1;
        }

        int v2 = Build$VERSION.SDK_INT;
        boolean v3 = this.hasAction;
        if(v2 >= 29) {
            v1 = v3 ? 4 : 0;
            return this.accessibilityManager.getRecommendedTimeoutMillis(v0, v1 | 3);
        }

        if((v3) && (this.accessibilityManager.isTouchExplorationEnabled())) {
            return v1;
        }

        return v0;
    }

    private TextView getMessageView() {
        return this.getContentLayout().getMessageView();
    }

    @Deprecated protected static boolean hasSnackbarButtonStyleAttr(Context arg3) {
        TypedArray v3 = arg3.obtainStyledAttributes(Snackbar.SNACKBAR_BUTTON_STYLE_ATTR);
        int v2 = v3.getResourceId(0, -1);
        v3.recycle();
        if(v2 != -1) {
            return 1;
        }

        return 0;
    }

    private static boolean hasSnackbarContentStyleAttrs(Context arg5) {
        TypedArray v5 = arg5.obtainStyledAttributes(Snackbar.SNACKBAR_CONTENT_STYLE_ATTRS);
        int v1 = -1;
        int v2 = v5.getResourceId(0, v1);
        int v4 = v5.getResourceId(1, v1);
        v5.recycle();
        if(v2 != v1 && v4 != v1) {
            return 1;
        }

        return 0;
    }

    public boolean isShown() {
        return super.isShown();
    }

    void lambda$setAction$0$com-google-android-material-snackbar-Snackbar(View$OnClickListener arg1, View arg2) {
        arg1.onClick(arg2);
        this.dispatchDismiss(1);
    }

    public static Snackbar make(Context arg0, View arg1, CharSequence arg2, int arg3) {
        return Snackbar.makeInternal(arg0, arg1, arg2, arg3);
    }

    public static Snackbar make(View arg1, int arg2, int arg3) {
        return Snackbar.make(arg1, arg1.getResources().getText(arg2), arg3);
    }

    public static Snackbar make(View arg1, CharSequence arg2, int arg3) {
        return Snackbar.makeInternal(null, arg1, arg2, arg3);
    }

    private static Snackbar makeInternal(Context arg3, View arg4, CharSequence arg5, int arg6) {
        ViewGroup v4 = Snackbar.findSuitableParent(arg4);
        if(v4 != null) {
            if(arg3 == null) {
                arg3 = v4.getContext();
            }

            LayoutInflater v0 = LayoutInflater.from(arg3);
            int v1 = Snackbar.hasSnackbarContentStyleAttrs(arg3) ? layout.mtrl_layout_snackbar_include : layout.design_layout_snackbar_include;
            View v0_1 = v0.inflate(v1, v4, false);
            Snackbar v1_1 = new Snackbar(arg3, v4, v0_1, ((ContentViewCallback)v0_1));
            v1_1.setText(arg5);
            v1_1.setDuration(arg6);
            return v1_1;
        }

        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    public Snackbar setAction(int arg2, View$OnClickListener arg3) {
        return this.setAction(this.getContext().getText(arg2), arg3);
    }

    public Snackbar setAction(CharSequence arg4, View$OnClickListener arg5) {
        Button v0 = this.getActionView();
        if(!TextUtils.isEmpty(arg4)) {
            if(arg5 == null) {
            }
            else {
                this.hasAction = true;
                ((TextView)v0).setVisibility(0);
                ((TextView)v0).setText(arg4);
                ((TextView)v0).setOnClickListener(new Snackbar$$ExternalSyntheticLambda0(this, arg5));
                return this;
            }
        }

        ((TextView)v0).setVisibility(8);
        ((TextView)v0).setOnClickListener(null);
        this.hasAction = false;
        return this;
    }

    public Snackbar setActionTextColor(int arg2) {
        this.getActionView().setTextColor(arg2);
        return this;
    }

    public Snackbar setActionTextColor(ColorStateList arg2) {
        this.getActionView().setTextColor(arg2);
        return this;
    }

    public Snackbar setBackgroundTint(int arg1) {
        return this.setBackgroundTintList(ColorStateList.valueOf(arg1));
    }

    public Snackbar setBackgroundTintList(ColorStateList arg2) {
        this.view.setBackgroundTintList(arg2);
        return this;
    }

    public Snackbar setBackgroundTintMode(PorterDuff$Mode arg2) {
        this.view.setBackgroundTintMode(arg2);
        return this;
    }

    @Deprecated public Snackbar setCallback(Callback arg2) {
        BaseCallback v0 = this.callback;
        if(v0 != null) {
            this.removeCallback(v0);
        }

        if(arg2 != null) {
            this.addCallback(((BaseCallback)arg2));
        }

        this.callback = ((BaseCallback)arg2);
        return this;
    }

    public Snackbar setMaxInlineActionWidth(int arg2) {
        this.getContentLayout().setMaxInlineActionWidth(arg2);
        return this;
    }

    public Snackbar setText(CharSequence arg2) {
        this.getMessageView().setText(arg2);
        return this;
    }

    public Snackbar setText(int arg2) {
        return this.setText(this.getContext().getText(arg2));
    }

    public Snackbar setTextColor(int arg2) {
        this.getMessageView().setTextColor(arg2);
        return this;
    }

    public Snackbar setTextColor(ColorStateList arg2) {
        this.getMessageView().setTextColor(arg2);
        return this;
    }

    public Snackbar setTextMaxLines(int arg2) {
        this.getMessageView().setMaxLines(arg2);
        return this;
    }

    public void show() {
        super.show();
    }
}

