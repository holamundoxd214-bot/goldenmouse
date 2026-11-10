package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;

public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private final TimeInterpolator contentInterpolator;
    private int maxInlineActionWidth;
    private TextView messageView;

    public SnackbarContentLayout(Context arg2) {
        this(arg2, null);
    }

    public SnackbarContentLayout(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        this.contentInterpolator = MotionUtils.resolveThemeInterpolator(arg2, attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    public void animateContentIn(int arg8, int arg9) {
        this.messageView.setAlpha(0f);
        float v2 = 1f;
        long v3 = ((long)arg9);
        long v5 = ((long)arg8);
        this.messageView.animate().alpha(v2).setDuration(v3).setInterpolator(this.contentInterpolator).setStartDelay(v5).start();
        if(this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0f);
            this.actionView.animate().alpha(v2).setDuration(v3).setInterpolator(this.contentInterpolator).setStartDelay(v5).start();
        }
    }

    public void animateContentOut(int arg8, int arg9) {
        float v1 = 1f;
        this.messageView.setAlpha(v1);
        long v3 = ((long)arg9);
        long v5 = ((long)arg8);
        this.messageView.animate().alpha(0f).setDuration(v3).setInterpolator(this.contentInterpolator).setStartDelay(v5).start();
        if(this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(v1);
            this.actionView.animate().alpha(0f).setDuration(v3).setInterpolator(this.contentInterpolator).setStartDelay(v5).start();
        }
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = this.findViewById(id.snackbar_text);
        this.actionView = this.findViewById(id.snackbar_action);
    }

    protected void onMeasure(int arg8, int arg9) {
        super.onMeasure(arg8, arg9);
        if(this.getOrientation() == 1) {
        }
        else {
            int v0 = this.getResources().getDimensionPixelSize(dimen.design_snackbar_padding_vertical_2lines);
            int v2 = this.getResources().getDimensionPixelSize(dimen.design_snackbar_padding_vertical);
            Layout v3 = this.messageView.getLayout();
            int v3_1 = v3 == null || v3.getLineCount() <= 1 ? 0 : 1;
            if(v3_1 == 0 || this.maxInlineActionWidth <= 0 || this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) {
                if(v3_1 != 0) {
                }
                else {
                    v0 = v2;
                }

                if(!this.updateViewsWithinLayout(0, v0, v0)) {
                    return;
                }
            }
            else if(this.updateViewsWithinLayout(1, v0, v0 - v2)) {
            }
            else {
                return;
            }

            super.onMeasure(arg8, arg9);
        }
    }

    public void setMaxInlineActionWidth(int arg1) {
        this.maxInlineActionWidth = arg1;
    }

    void updateActionTextColorAlphaIfNeeded(float arg3) {
        if(arg3 != 1f) {
            this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(((View)this), attr.colorSurface), this.actionView.getCurrentTextColor(), arg3));
        }
    }

    private static void updateTopBottomPadding(View arg2, int arg3, int arg4) {
        if(ViewCompat.isPaddingRelative(arg2)) {
            ViewCompat.setPaddingRelative(arg2, ViewCompat.getPaddingStart(arg2), arg3, ViewCompat.getPaddingEnd(arg2), arg4);
            return;
        }

        arg2.setPadding(arg2.getPaddingLeft(), arg3, arg2.getPaddingRight(), arg4);
    }

    private boolean updateViewsWithinLayout(int arg3, int arg4, int arg5) {
        boolean v3;
        if(arg3 != this.getOrientation()) {
            this.setOrientation(arg3);
            v3 = true;
        }
        else {
            v3 = false;
        }

        if(this.messageView.getPaddingTop() == arg4) {
            if(this.messageView.getPaddingBottom() != arg5) {
            }
            else {
                return v3;
            }
        }

        SnackbarContentLayout.updateTopBottomPadding(this.messageView, arg4, arg5);
        return 1;
    }
}

