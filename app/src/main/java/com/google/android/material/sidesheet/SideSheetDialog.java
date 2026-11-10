package com.google.android.material.sidesheet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;

public class SideSheetDialog extends SheetDialog {
    private static final int SIDE_SHEET_DIALOG_DEFAULT_THEME_RES;
    private static final int SIDE_SHEET_DIALOG_THEME_ATTR;

    static {
        SideSheetDialog.SIDE_SHEET_DIALOG_THEME_ATTR = attr.sideSheetDialogTheme;
        SideSheetDialog.SIDE_SHEET_DIALOG_DEFAULT_THEME_RES = style.Theme_Material3_Light_SideSheetDialog;
    }

    public SideSheetDialog(Context arg2) {
        this(arg2, 0);
    }

    public SideSheetDialog(Context arg3, int arg4) {
        super(arg3, arg4, SideSheetDialog.SIDE_SHEET_DIALOG_THEME_ATTR, SideSheetDialog.SIDE_SHEET_DIALOG_DEFAULT_THEME_RES);
    }

    void addSheetCancelOnHideCallback(Sheet arg2) {
        arg2.addCallback(new SideSheetCallback() {
            public void onSlide(View arg1, float arg2) {
            }

            public void onStateChanged(View arg1, int arg2) {
                if(arg2 == 5) {
                    SideSheetDialog.this.cancel();
                }
            }
        });
    }

    public void cancel() {
        super.cancel();
    }

    public Sheet getBehavior() {
        return this.getBehavior();
    }

    public SideSheetBehavior getBehavior() {
        Sheet v1 = super.getBehavior();
        if((v1 instanceof SideSheetBehavior)) {
            return ((SideSheetBehavior)v1);
        }

        throw new IllegalStateException("The view is not associated with SideSheetBehavior");
    }

    Sheet getBehaviorFromSheet(FrameLayout arg1) {
        return SideSheetBehavior.from(((View)arg1));
    }

    int getDialogId() {
        return id.m3_side_sheet;
    }

    int getLayoutResId() {
        return layout.m3_side_sheet_dialog;
    }

    int getStateOnStart() {
        return 3;
    }

    public boolean isDismissWithSheetAnimationEnabled() {
        return super.isDismissWithSheetAnimationEnabled();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setCancelable(boolean arg1) {
        super.setCancelable(arg1);
    }

    public void setCanceledOnTouchOutside(boolean arg1) {
        super.setCanceledOnTouchOutside(arg1);
    }

    public void setContentView(int arg1) {
        super.setContentView(arg1);
    }

    public void setContentView(View arg1) {
        super.setContentView(arg1);
    }

    public void setContentView(View arg1, ViewGroup$LayoutParams arg2) {
        super.setContentView(arg1, arg2);
    }

    public void setDismissWithSheetAnimationEnabled(boolean arg1) {
        super.setDismissWithSheetAnimationEnabled(arg1);
    }

    public void setSheetEdge(int arg1) {
        super.setSheetEdge(arg1);
    }
}

