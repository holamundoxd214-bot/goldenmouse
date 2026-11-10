package com.google.android.material.carousel;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$Action;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

public class CarouselSnapHelper extends SnapHelper {
    private static final float HORIZONTAL_SNAP_SPEED = 100f;
    private static final float VERTICAL_SNAP_SPEED = 50f;
    private final boolean disableFling;
    private RecyclerView recyclerView;

    public CarouselSnapHelper() {
        this(true);
    }

    public CarouselSnapHelper(boolean arg1) {
        super();
        this.disableFling = arg1;
    }

    static RecyclerView access$000(CarouselSnapHelper arg0) {
        return arg0.recyclerView;
    }

    static int[] access$100(CarouselSnapHelper arg0, LayoutManager arg1, View arg2, boolean arg3) {
        return arg0.calculateDistanceToSnap(arg1, arg2, arg3);
    }

    public void attachToRecyclerView(RecyclerView arg1) {
        super.attachToRecyclerView(arg1);
        this.recyclerView = arg1;
    }

    public int[] calculateDistanceToFinalSnap(LayoutManager arg2, View arg3) {
        return this.calculateDistanceToSnap(arg2, arg3, false);
    }

    private int[] calculateDistanceToSnap(LayoutManager arg3, View arg4, boolean arg5) {
        if(!(arg3 instanceof CarouselLayoutManager)) {
            return new int[]{0, 0};
        }

        int v2 = this.distanceToFirstFocalKeyline(arg4, arg3, arg5);
        if(arg3.canScrollHorizontally()) {
            return new int[]{v2, 0};
        }

        if(arg3.canScrollVertically()) {
            return new int[]{0, v2};
        }

        return new int[]{0, 0};
    }

    protected SmoothScroller createScroller(LayoutManager arg3) {
        if((arg3 instanceof ScrollVectorProvider)) {
            return new LinearSmoothScroller(this.recyclerView.getContext(), arg3) {
                protected float calculateSpeedPerPixel(DisplayMetrics arg1) {
                    float v1;
                    float v0;
                    if(this.val$layoutManager.canScrollVertically()) {
                        v0 = ((float)arg1.densityDpi);
                        v1 = 50f;
                    }
                    else {
                        v0 = ((float)arg1.densityDpi);
                        v1 = 100f;
                    }

                    return v1 / v0;
                }

                protected void onTargetFound(View arg3, State arg4, Action arg5) {
                    if(CarouselSnapHelper.this.recyclerView != null) {
                        int[] v3 = CarouselSnapHelper.this.calculateDistanceToSnap(CarouselSnapHelper.this.recyclerView.getLayoutManager(), arg3, true);
                        int v4 = v3[0];
                        int v3_1 = v3[1];
                        int v0 = this.calculateTimeForDeceleration(Math.max(Math.abs(v4), Math.abs(v3_1)));
                        if(v0 > 0) {
                            arg5.update(v4, v3_1, v0, this.mDecelerateInterpolator);
                        }
                    }
                }
            };
        }

        return null;
    }

    private int distanceToFirstFocalKeyline(View arg1, CarouselLayoutManager arg2, boolean arg3) {
        return arg2.getOffsetToScrollToPositionForSnap(arg2.getPosition(arg1), arg3);
    }

    public View findSnapView(LayoutManager arg1) {
        return this.findViewNearestFirstKeyline(arg1);
    }

    public int findTargetSnapPosition(LayoutManager arg12, int arg13, int arg14) {
        int v1 = -1;
        if(!this.disableFling) {
            return v1;
        }

        int v0 = arg12.getItemCount();
        if(v0 == 0) {
            return v1;
        }

        int v2 = arg12.getChildCount();
        View v4 = null;
        int v8 = 0;
        int v7 = 0x7FFFFFFF;
        int v6 = 0x80000000;
        View v5 = v4;
        while(v8 < v2) {
            View v9 = arg12.getChildAt(v8);
            if(v9 == null) {
            }
            else {
                int v10 = this.distanceToFirstFocalKeyline(v9, arg12, false);
                if(v10 <= 0 && v10 > v6) {
                    v5 = v9;
                    v6 = v10;
                }

                if(v10 < 0) {
                    goto label_30;
                }

                if(v10 >= v7) {
                    goto label_30;
                }

                v4 = v9;
                v7 = v10;
            }

        label_30:
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

    private View findViewNearestFirstKeyline(LayoutManager arg8) {
        int v7 = arg8.getChildCount();
        View v0 = null;
        if(v7 != 0) {
            if(!(arg8 instanceof CarouselLayoutManager)) {
            }
            else {
                LayoutManager v1 = arg8;
                int v3 = 0x7FFFFFFF;
                int v4;
                for(v4 = 0; v4 < v7; ++v4) {
                    View v5 = arg8.getChildAt(v4);
                    int v6 = Math.abs(((CarouselLayoutManager)v1).getOffsetToScrollToPositionForSnap(arg8.getPosition(v5), false));
                    if(v6 < v3) {
                        v0 = v5;
                        v3 = v6;
                    }
                }
            }
        }

        return v0;
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

