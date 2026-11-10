package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.WindowManager$LayoutParams;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

class TooltipPopup {
    private static final String TAG = "TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final WindowManager$LayoutParams mLayoutParams;
    private final TextView mMessageView;
    private final int[] mTmpAnchorPos;
    private final int[] mTmpAppPos;
    private final Rect mTmpDisplayFrame;

    TooltipPopup(Context arg5) {
        super();
        WindowManager$LayoutParams v0 = new WindowManager$LayoutParams();
        this.mLayoutParams = v0;
        this.mTmpDisplayFrame = new Rect();
        this.mTmpAnchorPos = new int[2];
        this.mTmpAppPos = new int[2];
        this.mContext = arg5;
        View v1 = LayoutInflater.from(arg5).inflate(layout.abc_tooltip, null);
        this.mContentView = v1;
        this.mMessageView = v1.findViewById(id.message);
        v0.setTitle(this.getClass().getSimpleName());
        v0.packageName = arg5.getPackageName();
        v0.type = 1002;
        v0.width = -2;
        v0.height = -2;
        v0.format = -3;
        v0.windowAnimations = style.Animation_AppCompat_Tooltip;
        v0.flags = 24;
    }

    private void computePosition(View arg9, int arg10, int arg11, boolean arg12, WindowManager$LayoutParams arg13) {
        int v1;
        arg13.token = arg9.getApplicationWindowToken();
        int v0 = this.mContext.getResources().getDimensionPixelOffset(dimen.tooltip_precise_anchor_threshold);
        if(arg9.getWidth() >= v0) {
        }
        else {
            arg10 = arg9.getWidth() / 2;
        }

        if(arg9.getHeight() >= v0) {
            v0 = this.mContext.getResources().getDimensionPixelOffset(dimen.tooltip_precise_anchor_extra_offset);
            v1 = arg11 + v0;
            arg11 -= v0;
        }
        else {
            v1 = arg9.getHeight();
            arg11 = 0;
        }

        arg13.gravity = 49;
        Resources v0_1 = this.mContext.getResources();
        int v3 = arg12 ? dimen.tooltip_y_offset_touch : dimen.tooltip_y_offset_non_touch;
        v0 = v0_1.getDimensionPixelOffset(v3);
        View v3_1 = TooltipPopup.getAppRootView(arg9);
        if(v3_1 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }

        v3_1.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        if(this.mTmpDisplayFrame.left < 0 && this.mTmpDisplayFrame.top < 0) {
            Resources v4 = this.mContext.getResources();
            int v5 = v4.getIdentifier("status_bar_height", "dimen", "android");
            v5 = v5 != 0 ? v4.getDimensionPixelSize(v5) : 0;
            DisplayMetrics v4_1 = v4.getDisplayMetrics();
            this.mTmpDisplayFrame.set(0, v5, v4_1.widthPixels, v4_1.heightPixels);
        }

        v3_1.getLocationOnScreen(this.mTmpAppPos);
        arg9.getLocationOnScreen(this.mTmpAnchorPos);
        int[] v9 = this.mTmpAnchorPos;
        int v4_2 = v9[0];
        int[] v5_1 = this.mTmpAppPos;
        v4_2 -= v5_1[0];
        v9[0] = v4_2;
        v9[1] -= v5_1[1];
        arg13.x = v4_2 + arg10 - v3_1.getWidth() / 2;
        int v9_1 = View$MeasureSpec.makeMeasureSpec(0, 0);
        this.mContentView.measure(v9_1, v9_1);
        v9_1 = this.mContentView.getMeasuredHeight();
        arg11 = arg11 + this.mTmpAnchorPos[1] - v0 - v9_1;
        arg10 = this.mTmpAnchorPos[1] + v1 + v0;
        if(arg12) {
            if(arg11 >= 0) {
                arg13.y = arg11;
                return;
            }

            arg13.y = arg10;
            return;
        }

        if(v9_1 + arg10 <= this.mTmpDisplayFrame.height()) {
            arg13.y = arg10;
            return;
        }

        arg13.y = arg11;
    }

    private static View getAppRootView(View arg3) {
        View v0 = arg3.getRootView();
        ViewGroup$LayoutParams v1 = v0.getLayoutParams();
        if(!(v1 instanceof WindowManager$LayoutParams) || ((WindowManager$LayoutParams)v1).type != 2) {
            Context v3 = arg3.getContext();
            while((v3 instanceof ContextWrapper)) {
                if((v3 instanceof Activity)) {
                    return ((Activity)v3).getWindow().getDecorView();
                }
                else {
                    v3 = ((ContextWrapper)v3).getBaseContext();
                    continue;
                }

                return v0;
            }
        }
        else {
        }

        return v0;
    }

    void hide() {
        if(!this.isShowing()) {
            return;
        }

        this.mContext.getSystemService("window").removeView(this.mContentView);
    }

    boolean isShowing() {
        if(this.mContentView.getParent() != null) {
            return 1;
        }

        return 0;
    }

    void show(View arg2, int arg3, int arg4, boolean arg5, CharSequence arg6) {
        if(this.isShowing()) {
            this.hide();
        }

        this.mMessageView.setText(arg6);
        this.computePosition(arg2, arg3, arg4, arg5, this.mLayoutParams);
        this.mContext.getSystemService("window").addView(this.mContentView, this.mLayoutParams);
    }
}

