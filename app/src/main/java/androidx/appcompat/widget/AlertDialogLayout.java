package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import androidx.appcompat.R$id;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context arg1) {
        super(arg1);
    }

    public AlertDialogLayout(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    private void forceUniformWidth(int arg10, int arg11) {
        int v6;
        AlertDialogLayout v2;
        int v4 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0x40000000);
        int v0 = 0;
        while(v0 < arg10) {
            View v3 = this.getChildAt(v0);
            if(v3.getVisibility() != 8) {
                ViewGroup$LayoutParams v1 = v3.getLayoutParams();
                if(((LayoutParams)v1).width == -1) {
                    int v8 = ((LayoutParams)v1).height;
                    ((LayoutParams)v1).height = v3.getMeasuredHeight();
                    v2 = this;
                    v6 = arg11;
                    v2.measureChildWithMargins(v3, v4, 0, v6, 0);
                    ((LayoutParams)v1).height = v8;
                }
                else {
                    goto label_23;
                }
            }
            else {
            label_23:
                v2 = this;
                v6 = arg11;
            }

            ++v0;
            this = v2;
            arg11 = v6;
        }
    }

    protected void onLayout(boolean arg11, int arg12, int arg13, int arg14, int arg15) {
        AlertDialogLayout v3_1;
        int v5;
        int v11 = this.getPaddingLeft();
        arg14 -= arg12;
        arg12 = arg14 - this.getPaddingRight();
        arg14 = arg14 - v11 - this.getPaddingRight();
        int v0 = this.getMeasuredHeight();
        int v1 = this.getChildCount();
        int v2 = this.getGravity();
        int v3 = v2 & 0x70;
        v2 &= 0x800007;
        if(v3 == 16) {
            arg13 = this.getPaddingTop() + (arg15 - arg13 - v0) / 2;
        }
        else if(v3 != 80) {
            arg13 = this.getPaddingTop();
        }
        else {
            arg13 = this.getPaddingTop() + arg15 - arg13 - v0;
        }

        Drawable v15 = this.getDividerDrawable();
        v0 = 0;
        arg15 = v15 == null ? 0 : v15.getIntrinsicHeight();
        while(v0 < v1) {
            View v4 = this.getChildAt(v0);
            if(v4 == null || v4.getVisibility() == 8) {
                v3_1 = this;
            }
            else {
                int v7 = v4.getMeasuredWidth();
                int v8 = v4.getMeasuredHeight();
                ViewGroup$LayoutParams v9 = v4.getLayoutParams();
                v3 = ((LayoutParams)v9).gravity;
                if(v3 < 0) {
                    v3 = v2;
                }

                v3 = GravityCompat.getAbsoluteGravity(v3, ViewCompat.getLayoutDirection(((View)this))) & 7;
                if(v3 == 1) {
                    v3 = (arg14 - v7) / 2 + v11 + ((LayoutParams)v9).leftMargin;
                    v5 = ((LayoutParams)v9).rightMargin;
                label_67:
                    v3 -= v5;
                }
                else if(v3 != 5) {
                    v3 = ((LayoutParams)v9).leftMargin + v11;
                }
                else {
                    v3 = arg12 - v7;
                    v5 = ((LayoutParams)v9).rightMargin;
                    goto label_67;
                }

                v5 = v3;
                if(this.hasDividerBeforeChildAt(v0)) {
                    arg13 += arg15;
                }

                int v6 = arg13 + ((LayoutParams)v9).topMargin;
                v3_1 = this;
                v3_1.setChildFrame(v4, v5, v6, v7, v8);
                arg13 = v6 + (v8 + ((LayoutParams)v9).bottomMargin);
            }

            ++v0;
            this = v3_1;
        }
    }

    protected void onMeasure(int arg2, int arg3) {
        if(!this.tryOnMeasure(arg2, arg3)) {
            super.onMeasure(arg2, arg3);
        }
    }

    private static int resolveMinimumHeight(View arg3) {
        int v0 = ViewCompat.getMinimumHeight(arg3);
        if(v0 > 0) {
            return v0;
        }

        if(((arg3 instanceof ViewGroup)) && ((ViewGroup)arg3).getChildCount() == 1) {
            return AlertDialogLayout.resolveMinimumHeight(((ViewGroup)arg3).getChildAt(0));
        }

        return 0;
    }

    private void setChildFrame(View arg1, int arg2, int arg3, int arg4, int arg5) {
        arg1.layout(arg2, arg3, arg4 + arg2, arg5 + arg3);
    }

    private boolean tryOnMeasure(int arg17, int arg18) {
        int v15;
        int v14;
        int v13;
        int v4_1;
        AlertDialogLayout v0 = this;
        int v1 = arg17;
        int v2 = arg18;
        int v3 = v0.getChildCount();
        View v4 = null;
        View v6 = v4;
        View v7 = v6;
        int v8;
        for(v8 = 0; true; ++v8) {
            int v9 = 8;
            if(v8 >= v3) {
                break;
            }

            View v10 = v0.getChildAt(v8);
            if(v10.getVisibility() == v9) {
            }
            else {
                v9 = v10.getId();
                if(v9 == id.topPanel) {
                    v4 = v10;
                }
                else if(v9 == id.buttonPanel) {
                    v6 = v10;
                }
                else {
                    if(v9 != id.contentPanel) {
                        if(v9 == id.customPanel) {
                        }
                        else {
                            return 0;
                        }
                    }

                    if(v7 != null) {
                        return 0;
                    }

                    v7 = v10;
                }
            }
        }

        v8 = View$MeasureSpec.getMode(v2);
        int v10_1 = View$MeasureSpec.getSize(v2);
        int v11 = View$MeasureSpec.getMode(v1);
        int v12 = v0.getPaddingTop() + v0.getPaddingBottom();
        if(v4 != null) {
            v4.measure(v1, 0);
            v12 += v4.getMeasuredHeight();
            v4_1 = View.combineMeasuredStates(0, v4.getMeasuredState());
        }
        else {
            v4_1 = 0;
        }

        if(v6 != null) {
            v6.measure(v1, 0);
            v13 = AlertDialogLayout.resolveMinimumHeight(v6);
            v14 = v6.getMeasuredHeight() - v13;
            v12 += v13;
            v4_1 = View.combineMeasuredStates(v4_1, v6.getMeasuredState());
        }
        else {
            v13 = 0;
            v14 = 0;
        }

        if(v7 != null) {
            v15 = v8 == 0 ? 0 : View$MeasureSpec.makeMeasureSpec(Math.max(0, v10_1 - v12), v8);
            v7.measure(v1, v15);
            v15 = v7.getMeasuredHeight();
            v12 += v15;
            v4_1 = View.combineMeasuredStates(v4_1, v7.getMeasuredState());
        }
        else {
            v15 = 0;
        }

        v10_1 -= v12;
        int v5 = 0x40000000;
        if(v6 != null) {
            v12 -= v13;
            v14 = Math.min(v10_1, v14);
            if(v14 > 0) {
                v10_1 -= v14;
                v13 += v14;
            }

            v6.measure(v1, View$MeasureSpec.makeMeasureSpec(v13, v5));
            v12 += v6.getMeasuredHeight();
            v4_1 = View.combineMeasuredStates(v4_1, v6.getMeasuredState());
        }

        if(v7 != null && v10_1 > 0) {
            v7.measure(v1, View$MeasureSpec.makeMeasureSpec(v15 + v10_1, v8));
            v12 = v12 - v15 + v7.getMeasuredHeight();
            v4_1 = View.combineMeasuredStates(v4_1, v7.getMeasuredState());
        }

        int v6_1 = 0;
        int v7_1 = 0;
        while(v6_1 < v3) {
            View v8_1 = v0.getChildAt(v6_1);
            if(v8_1.getVisibility() != v9) {
                v7_1 = Math.max(v7_1, v8_1.getMeasuredWidth());
            }

            ++v6_1;
        }

        v0.setMeasuredDimension(View.resolveSizeAndState(v7_1 + (v0.getPaddingLeft() + v0.getPaddingRight()), v1, v4_1), View.resolveSizeAndState(v12, v2, 0));
        if(v11 != v5) {
            v0.forceUniformWidth(v3, v2);
        }

        return 1;
    }
}

