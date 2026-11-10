package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;

public class LinearSnapHelper extends SnapHelper {
    private static final float INVALID_DISTANCE = 1f;
    private OrientationHelper mHorizontalHelper;
    private OrientationHelper mVerticalHelper;

    public LinearSnapHelper() {
        super();
    }

    public int[] calculateDistanceToFinalSnap(LayoutManager arg5, View arg6) {
        int[] v0 = new int[2];
        v0[0] = arg5.canScrollHorizontally() ? this.distanceToCenter(arg5, arg6, this.getHorizontalHelper(arg5)) : 0;
        if(arg5.canScrollVertically()) {
            v0[1] = this.distanceToCenter(arg5, arg6, this.getVerticalHelper(arg5));
            return v0;
        }

        v0[1] = 0;
        return v0;
    }

    private float computeDistancePerChild(LayoutManager arg10, OrientationHelper arg11) {
        int v9 = arg10.getChildCount();
        float v0 = 1f;
        if(v9 == 0) {
            return v0;
        }

        View v1 = null;
        int v5 = 0;
        int v4 = 0x80000000;
        int v3 = 0x7FFFFFFF;
        View v2 = v1;
        while(v5 < v9) {
            View v6 = arg10.getChildAt(v5);
            int v7 = arg10.getPosition(v6);
            if(v7 == -1) {
            }
            else {
                if(v7 < v3) {
                    v1 = v6;
                    v3 = v7;
                }

                if(v7 <= v4) {
                    goto label_24;
                }

                v2 = v6;
                v4 = v7;
            }

        label_24:
            ++v5;
        }

        if(v1 != null) {
            if(v2 == null) {
            }
            else {
                int v10 = Math.max(arg11.getDecoratedEnd(v1), arg11.getDecoratedEnd(v2)) - Math.min(arg11.getDecoratedStart(v1), arg11.getDecoratedStart(v2));
                if(v10 == 0) {
                    return v0;
                }
                else {
                    return (((float)v10)) * v0 / (((float)(v4 - v3 + 1)));
                }
            }
        }

        return v0;
    }

    private int distanceToCenter(LayoutManager arg1, View arg2, OrientationHelper arg3) {
        return arg3.getDecoratedStart(arg2) + arg3.getDecoratedMeasurement(arg2) / 2 - (arg3.getStartAfterPadding() + arg3.getTotalSpace() / 2);
    }

    private int estimateNextPositionDiffForFling(LayoutManager arg2, OrientationHelper arg3, int arg4, int arg5) {
        int[] v4 = this.calculateScrollDistance(arg4, arg5);
        float v1 = this.computeDistancePerChild(arg2, arg3);
        if(Float.compare(v1, 0f) <= 0) {
            return 0;
        }

        int v2 = Math.abs(v4[0]) > Math.abs(v4[1]) ? v4[0] : v4[1];
        return Math.round((((float)v2)) / v1);
    }

    private View findCenterView(LayoutManager arg8, OrientationHelper arg9) {
        int v7 = arg8.getChildCount();
        View v0 = null;
        if(v7 == 0) {
            return v0;
        }

        int v1 = arg9.getStartAfterPadding() + arg9.getTotalSpace() / 2;
        int v2 = 0x7FFFFFFF;
        int v3;
        for(v3 = 0; v3 < v7; ++v3) {
            View v4 = arg8.getChildAt(v3);
            int v5 = Math.abs(arg9.getDecoratedStart(v4) + arg9.getDecoratedMeasurement(v4) / 2 - v1);
            if(v5 < v2) {
                v0 = v4;
                v2 = v5;
            }
        }

        return v0;
    }

    public View findSnapView(LayoutManager arg2) {
        if(arg2.canScrollVertically()) {
            return this.findCenterView(arg2, this.getVerticalHelper(arg2));
        }

        if(arg2.canScrollHorizontally()) {
            return this.findCenterView(arg2, this.getHorizontalHelper(arg2));
        }

        return null;
    }

    public int findTargetSnapPosition(LayoutManager arg9, int arg10, int arg11) {
        int v8;
        int v1 = -1;
        if(!(arg9 instanceof ScrollVectorProvider)) {
            return v1;
        }

        int v0 = arg9.getItemCount();
        if(v0 == 0) {
            return v1;
        }

        View v2 = this.findSnapView(arg9);
        if(v2 == null) {
            return v1;
        }

        int v2_1 = arg9.getPosition(v2);
        if(v2_1 == v1) {
            return v1;
        }

        int v4 = v0 - 1;
        PointF v3 = arg9.computeScrollVectorForPosition(v4);
        if(v3 == null) {
            return v1;
        }

        int v7 = 0;
        if(arg9.canScrollHorizontally()) {
            arg10 = this.estimateNextPositionDiffForFling(arg9, this.getHorizontalHelper(arg9), arg10, 0);
            if(v3.x < 0f) {
                arg10 = -arg10;
            }
        }
        else {
            arg10 = 0;
        }

        if(arg9.canScrollVertically()) {
            v8 = this.estimateNextPositionDiffForFling(arg9, this.getVerticalHelper(arg9), 0, arg11);
            if(v3.y < 0f) {
                v8 = -v8;
            }
        }
        else {
            v8 = 0;
        }

        if(arg9.canScrollVertically()) {
            arg10 = v8;
        }

        if(arg10 == 0) {
            return v1;
        }

        v2_1 += arg10;
        if(v2_1 < 0) {
        }
        else {
            v7 = v2_1;
        }

        if(v7 >= v0) {
            return v4;
        }

        return v7;
    }

    private OrientationHelper getHorizontalHelper(LayoutManager arg2) {
        OrientationHelper v0 = this.mHorizontalHelper;
        if(v0 == null || v0.mLayoutManager != arg2) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(arg2);
        }

        return this.mHorizontalHelper;
    }

    private OrientationHelper getVerticalHelper(LayoutManager arg2) {
        OrientationHelper v0 = this.mVerticalHelper;
        if(v0 == null || v0.mLayoutManager != arg2) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(arg2);
        }

        return this.mVerticalHelper;
    }
}

