package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class AnimateLayoutChangeDetector {
    private static final ViewGroup$MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS;
    private LinearLayoutManager mLayoutManager;

    static {
        ViewGroup$MarginLayoutParams v0 = new ViewGroup$MarginLayoutParams(-1, -1);
        AnimateLayoutChangeDetector.ZERO_MARGIN_LAYOUT_PARAMS = v0;
        v0.setMargins(0, 0, 0, 0);
    }

    AnimateLayoutChangeDetector(LinearLayoutManager arg1) {
        super();
        this.mLayoutManager = arg1;
    }

    private boolean arePagesLaidOutContiguously() {
        int v7_2;
        int v6_1;
        int v10;
        int v9;
        int v0 = this.mLayoutManager.getChildCount();
        if(v0 == 0) {
            return 1;
        }

        int v2 = this.mLayoutManager.getOrientation() == 0 ? 1 : 0;
        int[] v5 = new int[2];
        v5[1] = 2;
        v5[0] = v0;
        Object v4 = Array.newInstance(Integer.TYPE, v5);
        int v5_1;
        for(v5_1 = 0; true; ++v5_1) {
            if(v5_1 >= v0) {
                goto label_52;
            }

            View v6 = this.mLayoutManager.getChildAt(v5_1);
            if(v6 == null) {
                break;
            }

            ViewGroup$LayoutParams v7 = v6.getLayoutParams();
            if((v7 instanceof ViewGroup$MarginLayoutParams)) {
            }
            else {
                ViewGroup$MarginLayoutParams v7_1 = AnimateLayoutChangeDetector.ZERO_MARGIN_LAYOUT_PARAMS;
            }

            Object v8 = v4[v5_1];
            if(v2 != 0) {
                v9 = v6.getLeft();
                v10 = ((ViewGroup$MarginLayoutParams)v7).leftMargin;
            }
            else {
                v9 = v6.getTop();
                v10 = ((ViewGroup$MarginLayoutParams)v7).topMargin;
            }

            v8[0] = v9 - v10;
            v8 = v4[v5_1];
            if(v2 != 0) {
                v6_1 = v6.getRight();
                v7_2 = ((ViewGroup$MarginLayoutParams)v7).rightMargin;
            }
            else {
                v6_1 = v6.getBottom();
                v7_2 = ((ViewGroup$MarginLayoutParams)v7).bottomMargin;
            }

            v8[1] = v6_1 + v7_2;
        }

        throw new IllegalStateException("null view contained in the view hierarchy");
    label_52:
        Arrays.sort(((Object[])v4), new Comparator() {
            public int compare(Object arg1, Object arg2) {
                return this.compare(((int[])arg1), ((int[])arg2));
            }

            public int compare(int[] arg1, int[] arg2) {
                return arg1[0] - arg2[0];
            }
        });
        int v11;
        for(v11 = 1; v11 < v0; ++v11) {
            if(v4[v11 - 1][1] != v4[v11][0]) {
                return 0;
            }
        }

        Object v11_1 = v4[0];
        v2 = v11_1[1] - v11_1[0];
        if(v11_1[0] <= 0) {
            if(v4[v0 - 1][1] < v2) {
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    private boolean hasRunningChangingLayoutTransition() {
        int v0 = this.mLayoutManager.getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(AnimateLayoutChangeDetector.hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(v2))) {
                return 1;
            }
        }

        return 0;
    }

    private static boolean hasRunningChangingLayoutTransition(View arg5) {
        if((arg5 instanceof ViewGroup)) {
            LayoutTransition v0 = ((ViewGroup)arg5).getLayoutTransition();
            if(v0 != null && (v0.isChangingLayout())) {
                return 1;
            }

            int v0_1 = ((ViewGroup)arg5).getChildCount();
            int v3;
            for(v3 = 0; v3 < v0_1; ++v3) {
                if(AnimateLayoutChangeDetector.hasRunningChangingLayoutTransition(((ViewGroup)arg5).getChildAt(v3))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    boolean mayHaveInterferingAnimations() {
        if((!this.arePagesLaidOutContiguously() || this.mLayoutManager.getChildCount() <= 1) && (this.hasRunningChangingLayoutTransition())) {
            return 1;
        }

        return 0;
    }
}

