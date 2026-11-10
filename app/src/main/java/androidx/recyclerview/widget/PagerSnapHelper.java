package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

public class PagerSnapHelper extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    private OrientationHelper mHorizontalHelper;
    private OrientationHelper mVerticalHelper;

    public PagerSnapHelper() {
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

    protected LinearSmoothScroller createSnapScroller(LayoutManager arg2) {
        if(!(arg2 instanceof ScrollVectorProvider)) {
            return null;
        }

        return new LinearSmoothScroller(this.mRecyclerView.getContext()) {
            protected float calculateSpeedPerPixel(DisplayMetrics arg1) {
                return 100f / (((float)arg1.densityDpi));
            }

            protected int calculateTimeForScrolling(int arg2) {
                return Math.min(100, super.calculateTimeForScrolling(arg2));
            }

            protected void onTargetFound(View arg3, State arg4, Action arg5) {
                int[] v3 = PagerSnapHelper.this.calculateDistanceToFinalSnap(PagerSnapHelper.this.mRecyclerView.getLayoutManager(), arg3);
                int v4 = v3[0];
                int v3_1 = v3[1];
                int v0 = this.calculateTimeForDeceleration(Math.max(Math.abs(v4), Math.abs(v3_1)));
                if(v0 > 0) {
                    arg5.update(v4, v3_1, v0, this.mDecelerateInterpolator);
                }
            }
        };
    }

    private int distanceToCenter(LayoutManager arg1, View arg2, OrientationHelper arg3) {
        return arg3.getDecoratedStart(arg2) + arg3.getDecoratedMeasurement(arg2) / 2 - (arg3.getStartAfterPadding() + arg3.getTotalSpace() / 2);
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

    public int findTargetSnapPosition(LayoutManager arg12, int arg13, int arg14) {
        int v0 = arg12.getItemCount();
        int v1 = -1;
        if(v0 == 0) {
            return v1;
        }

        OrientationHelper v2 = this.getOrientationHelper(arg12);
        if(v2 == null) {
            return v1;
        }

        int v3 = arg12.getChildCount();
        View v4 = null;
        int v8 = 0;
        int v7 = 0x7FFFFFFF;
        int v6 = 0x80000000;
        View v5 = v4;
        while(v8 < v3) {
            View v9 = arg12.getChildAt(v8);
            if(v9 == null) {
            }
            else {
                int v10 = this.distanceToCenter(arg12, v9, v2);
                if(v10 <= 0 && v10 > v6) {
                    v5 = v9;
                    v6 = v10;
                }

                if(v10 < 0) {
                    goto label_29;
                }

                if(v10 >= v7) {
                    goto label_29;
                }

                v4 = v9;
                v7 = v10;
            }

        label_29:
            ++v8;
        }

        boolean v13 = this.isForwardFling(arg12, arg13, arg14);
        if((v13) && v4 != null) {
            return arg12.getPosition(v4);
        }

        if(!v13 && v5 != null) {
            return arg12.getPosition(v5);
        }

        if(v13) {
            v4 = v5;
        }

        if(v4 == null) {
            return v1;
        }

        arg14 = arg12.getPosition(v4);
        int v11 = this.isReverseLayout(arg12) == v13 ? v1 : 1;
        arg14 += v11;
        if(arg14 >= 0) {
            if(arg14 >= v0) {
            }
            else {
                return arg14;
            }
        }

        return v1;
    }

    private OrientationHelper getHorizontalHelper(LayoutManager arg2) {
        OrientationHelper v0 = this.mHorizontalHelper;
        if(v0 == null || v0.mLayoutManager != arg2) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(arg2);
        }

        return this.mHorizontalHelper;
    }

    private OrientationHelper getOrientationHelper(LayoutManager arg2) {
        if(arg2.canScrollVertically()) {
            return this.getVerticalHelper(arg2);
        }

        if(arg2.canScrollHorizontally()) {
            return this.getHorizontalHelper(arg2);
        }

        return null;
    }

    private OrientationHelper getVerticalHelper(LayoutManager arg2) {
        OrientationHelper v0 = this.mVerticalHelper;
        if(v0 == null || v0.mLayoutManager != arg2) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(arg2);
        }

        return this.mVerticalHelper;
    }

    private boolean isForwardFling(LayoutManager arg2, int arg3, int arg4) {
        if(arg2.canScrollHorizontally()) {
            if(arg3 > 0) {
                return 1;
            }

            return 0;
        }

        if(arg4 > 0) {
            return 1;
        }

        return 0;
    }

    private boolean isReverseLayout(LayoutManager arg4) {
        int v3 = arg4.getItemCount();
        if((arg4 instanceof ScrollVectorProvider)) {
            PointF v3_1 = ((ScrollVectorProvider)arg4).computeScrollVectorForPosition(v3 - 1);
            if(v3_1 != null) {
                if(v3_1.x >= 0f) {
                    if(v3_1.y < 0f) {
                    }
                    else {
                        return 0;
                    }
                }

                return 1;
            }
        }

        return 0;
    }
}

