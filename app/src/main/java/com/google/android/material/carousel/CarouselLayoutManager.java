package com.google.android.material.carousel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View$OnLayoutChangeListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CarouselLayoutManager extends LayoutManager implements ScrollVectorProvider, Carousel {
    final class ChildCalculations {
        final float center;
        final View child;
        final float offsetCenter;
        final KeylineRange range;

        ChildCalculations(View arg1, float arg2, float arg3, KeylineRange arg4) {
            super();
            this.child = arg1;
            this.center = arg2;
            this.offsetCenter = arg3;
            this.range = arg4;
        }
    }

    class DebugItemDecoration extends ItemDecoration {
        private List keylines;
        private final Paint linePaint;

        DebugItemDecoration() {
            super();
            Paint v0 = new Paint();
            this.linePaint = v0;
            this.keylines = Collections.unmodifiableList(new ArrayList());
            v0.setStrokeWidth(5f);
            v0.setColor(0xFFFF00FF);
        }

        public void onDrawOver(Canvas arg17, RecyclerView arg18, State arg19) {
            DebugItemDecoration v0 = this;
            super.onDrawOver(arg17, arg18, arg19);
            v0.linePaint.setStrokeWidth(arg18.getResources().getDimension(dimen.m3_carousel_debug_keyline_width));
            Iterator v1 = v0.keylines.iterator();
            while(v1.hasNext()) {
                Object v2 = v1.next();
                v0.linePaint.setColor(ColorUtils.blendARGB(0xFFFF00FF, 0xFF0000FF, ((Keyline)v2).mask));
                if(arg18.getLayoutManager().isHorizontal()) {
                    arg17.drawLine(((Keyline)v2).locOffset, ((float)arg18.getLayoutManager().getParentTop()), ((Keyline)v2).locOffset, ((float)arg18.getLayoutManager().getParentBottom()), v0.linePaint);
                    continue;
                }

                arg17.drawLine(((float)arg18.getLayoutManager().getParentLeft()), ((Keyline)v2).locOffset, ((float)arg18.getLayoutManager().getParentRight()), ((Keyline)v2).locOffset, v0.linePaint);
            }
        }

        void setKeylines(List arg1) {
            this.keylines = Collections.unmodifiableList(arg1);
        }
    }

    class KeylineRange {
        final Keyline leftOrTop;
        final Keyline rightOrBottom;

        KeylineRange(Keyline arg3, Keyline arg4) {
            super();
            boolean v0 = arg3.loc <= arg4.loc ? true : false;
            Preconditions.checkArgument(v0);
            this.leftOrTop = arg3;
            this.rightOrBottom = arg4;
        }
    }

    class LayoutDirection {
        private static final int INVALID_LAYOUT = 0x80000000;
        private static final int LAYOUT_END = 1;
        private static final int LAYOUT_START = -1;

        private LayoutDirection() {
            super();
        }
    }

    public static final int ALIGNMENT_CENTER = 1;
    public static final int ALIGNMENT_START = 0;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "CarouselLayoutManager";
    public static final int VERTICAL = 1;
    private int carouselAlignment;
    private CarouselStrategy carouselStrategy;
    private int currentEstimatedPosition;
    private int currentFillStartPosition;
    private KeylineState currentKeylineState;
    private final DebugItemDecoration debugItemDecoration;
    private boolean isDebuggingEnabled;
    private KeylineStateList keylineStateList;
    private Map keylineStatePositionMap;
    private int lastItemCount;
    int maxScroll;
    int minScroll;
    private CarouselOrientationHelper orientationHelper;
    private final View$OnLayoutChangeListener recyclerViewSizeChangeListener;
    int scrollOffset;

    public static void $r8$lambda$EVyYoVT11DpL60suE9bxns8qbCM(CarouselLayoutManager arg0) {
        arg0.refreshKeylineState();
    }

    public CarouselLayoutManager() {
        this(new MultiBrowseCarouselStrategy());
    }

    public CarouselLayoutManager(CarouselStrategy arg2) {
        this(arg2, 0);
    }

    public CarouselLayoutManager(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        super();
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        this.recyclerViewSizeChangeListener = new CarouselLayoutManager$$ExternalSyntheticLambda1(this);
        this.currentEstimatedPosition = -1;
        this.carouselAlignment = 0;
        this.setCarouselStrategy(new MultiBrowseCarouselStrategy());
        this.setCarouselAttributes(arg1, arg2);
    }

    public CarouselLayoutManager(CarouselStrategy arg3, int arg4) {
        super();
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        this.recyclerViewSizeChangeListener = new CarouselLayoutManager$$ExternalSyntheticLambda1(this);
        this.currentEstimatedPosition = -1;
        this.carouselAlignment = 0;
        this.setCarouselStrategy(arg3);
        this.setOrientation(arg4);
    }

    static KeylineStateList access$000(CarouselLayoutManager arg0) {
        return arg0.keylineStateList;
    }

    static int access$100(CarouselLayoutManager arg0) {
        return arg0.getParentTop();
    }

    static int access$200(CarouselLayoutManager arg0) {
        return arg0.getParentBottom();
    }

    static int access$300(CarouselLayoutManager arg0) {
        return arg0.getParentLeft();
    }

    static int access$400(CarouselLayoutManager arg0) {
        return arg0.getParentRight();
    }

    private void addAndLayoutView(View arg3, int arg4, ChildCalculations arg5) {
        float v0 = this.currentKeylineState.getItemSize() / 2f;
        this.addView(arg3, arg4);
        this.orientationHelper.layoutDecoratedWithMargins(arg3, ((int)(arg5.offsetCenter - v0)), ((int)(arg5.offsetCenter + v0)));
        this.updateChildMaskForLocation(arg3, arg5.center, arg5.range);
    }

    private float addEnd(float arg1, float arg2) {
        if(this.isLayoutRtl()) {
            return arg1 - arg2;
        }

        return arg1 + arg2;
    }

    private float addStart(float arg1, float arg2) {
        if(this.isLayoutRtl()) {
            return arg1 + arg2;
        }

        return arg1 - arg2;
    }

    private void addViewAtPosition(Recycler arg2, int arg3, int arg4) {
        if(arg3 >= 0) {
            if(arg3 >= this.getItemCount()) {
            }
            else {
                ChildCalculations v2 = this.makeChildCalculations(arg2, this.calculateChildStartForFill(arg3), arg3);
                this.addAndLayoutView(v2.child, arg4, v2);
            }
        }
    }

    private void addViewsEnd(Recycler arg5, State arg6, int arg7) {
        float v0 = this.calculateChildStartForFill(arg7);
        while(arg7 < arg6.getItemCount()) {
            ChildCalculations v1 = this.makeChildCalculations(arg5, v0, arg7);
            if(this.isLocOffsetOutOfFillBoundsEnd(v1.offsetCenter, v1.range)) {
            }
            else {
                v0 = this.addEnd(v0, this.currentKeylineState.getItemSize());
                if(this.isLocOffsetOutOfFillBoundsStart(v1.offsetCenter, v1.range)) {
                }
                else {
                    this.addAndLayoutView(v1.child, -1, v1);
                }

                ++arg7;
                continue;
            }

            return;
        }
    }

    private void addViewsStart(Recycler arg5, int arg6) {
        float v0 = this.calculateChildStartForFill(arg6);
        while(arg6 >= 0) {
            ChildCalculations v1 = this.makeChildCalculations(arg5, v0, arg6);
            if(this.isLocOffsetOutOfFillBoundsStart(v1.offsetCenter, v1.range)) {
            }
            else {
                v0 = this.addStart(v0, this.currentKeylineState.getItemSize());
                if(this.isLocOffsetOutOfFillBoundsEnd(v1.offsetCenter, v1.range)) {
                }
                else {
                    this.addAndLayoutView(v1.child, 0, v1);
                }

                --arg6;
                continue;
            }

            return;
        }
    }

    private float calculateChildOffsetCenterForLocation(View arg5, float arg6, KeylineRange arg7) {
        float v0 = AnimationUtils.lerp(arg7.leftOrTop.locOffset, arg7.rightOrBottom.locOffset, arg7.leftOrTop.loc, arg7.rightOrBottom.loc, arg6);
        if(arg7.rightOrBottom != this.currentKeylineState.getFirstKeyline()) {
            if(arg7.leftOrTop == this.currentKeylineState.getLastKeyline()) {
            }
            else {
                return v0;
            }
        }

        return v0 + (arg6 - arg7.rightOrBottom.loc) * (1f - arg7.rightOrBottom.mask + this.orientationHelper.getMaskMargins(arg5.getLayoutParams()) / this.currentKeylineState.getItemSize());
    }

    private float calculateChildStartForFill(int arg3) {
        return this.addEnd(((float)(this.getParentStart() - this.scrollOffset)), this.currentKeylineState.getItemSize() * (((float)arg3)));
    }

    private int calculateEndScroll(State arg4, KeylineStateList arg5) {
        boolean v0 = this.isLayoutRtl();
        KeylineState v5 = v0 ? arg5.getStartState() : arg5.getEndState();
        Keyline v1 = v0 ? v5.getFirstFocalKeyline() : v5.getLastFocalKeyline();
        float v4 = (((float)(arg4.getItemCount() - 1))) * v5.getItemSize() + (((float)this.getPaddingEnd()));
        float v5_1 = v0 ? -1f : 1f;
        int v3 = ((int)(v4 * v5_1 - (v1.loc - (((float)this.getParentStart()))) + ((((float)this.getParentEnd())) - v1.loc)));
        if(v0) {
            return Math.min(0, v3);
        }

        return Math.max(0, v3);
    }

    int calculateScrollDeltaToMakePositionVisible(int arg2) {
        return ((int)((((float)this.scrollOffset)) - (((float)this.getScrollOffsetForPosition(arg2, this.getKeylineStateForPosition(arg2))))));
    }

    private static int calculateShouldScrollBy(int arg1, int arg2, int arg3, int arg4) {
        int v0 = arg2 + arg1;
        if(v0 < arg3) {
            return arg3 - arg2;
        }

        if(v0 > arg4) {
            return arg4 - arg2;
        }

        return arg1;
    }

    private int calculateStartScroll(KeylineStateList arg4) {
        boolean v0 = this.isLayoutRtl();
        KeylineState v4 = v0 ? arg4.getEndState() : arg4.getStartState();
        Keyline v1 = v0 ? v4.getLastFocalKeyline() : v4.getFirstFocalKeyline();
        int v2 = this.getPaddingStart();
        int v0_1 = v0 ? 1 : -1;
        return ((int)((((float)(v2 * v0_1))) + (((float)this.getParentStart())) - this.addStart(v1.loc, v4.getItemSize() / 2f)));
    }

    public boolean canScrollHorizontally() {
        return this.isHorizontal();
    }

    public boolean canScrollVertically() {
        return this.isHorizontal() ^ 1;
    }

    public int computeHorizontalScrollExtent(State arg3) {
        if(this.getChildCount() != 0 && this.keylineStateList != null) {
            if(this.getItemCount() <= 1) {
            }
            else {
                return ((int)((((float)this.getWidth())) * (this.keylineStateList.getDefaultState().getItemSize() / (((float)this.computeHorizontalScrollRange(arg3))))));
            }
        }

        return 0;
    }

    public int computeHorizontalScrollOffset(State arg1) {
        return this.scrollOffset;
    }

    public int computeHorizontalScrollRange(State arg1) {
        return this.maxScroll - this.minScroll;
    }

    public PointF computeScrollVectorForPosition(int arg2) {
        if(this.keylineStateList == null) {
            return null;
        }

        arg2 = this.getOffsetToScrollToPosition(arg2, this.getKeylineStateForPosition(arg2));
        if(this.isHorizontal()) {
            return new PointF(((float)arg2), 0f);
        }

        return new PointF(0f, ((float)arg2));
    }

    public int computeVerticalScrollExtent(State arg3) {
        if(this.getChildCount() != 0 && this.keylineStateList != null) {
            if(this.getItemCount() <= 1) {
            }
            else {
                return ((int)((((float)this.getHeight())) * (this.keylineStateList.getDefaultState().getItemSize() / (((float)this.computeVerticalScrollRange(arg3))))));
            }
        }

        return 0;
    }

    public int computeVerticalScrollOffset(State arg1) {
        return this.scrollOffset;
    }

    public int computeVerticalScrollRange(State arg1) {
        return this.maxScroll - this.minScroll;
    }

    private int convertFocusDirectionToLayoutDirection(int arg6) {
        int v0 = this.getOrientation();
        int v1 = -1;
        if(arg6 != 1) {
            if(arg6 != 2) {
                int v4 = 0x80000000;
                if(arg6 != 17) {
                    if(arg6 != 33) {
                        if(arg6 != 66) {
                            if(arg6 != 130) {
                                Log.d("CarouselLayoutManager", "Unknown focus request:" + arg6);
                                return v4;
                            }

                            if(v0 == 1) {
                                return 1;
                            }

                            return v4;
                        }

                        if(v0 == 0) {
                            if(this.isLayoutRtl()) {
                                return v1;
                            }

                            return 1;
                        }

                        return v4;
                    }

                    if(v0 == 1) {
                        return v1;
                    }

                    return v4;
                }

                if(v0 == 0) {
                    if(this.isLayoutRtl()) {
                        return 1;
                    }

                    return v1;
                }

                return v4;
            }

            return 1;
        }

        return v1;
    }

    private void fill(Recycler arg3, State arg4) {
        this.removeAndRecycleOutOfBoundsViews(arg3);
        if(this.getChildCount() == 0) {
            this.addViewsStart(arg3, this.currentFillStartPosition - 1);
            this.addViewsEnd(arg3, arg4, this.currentFillStartPosition);
        }
        else {
            int v0 = this.getPosition(this.getChildAt(0));
            int v1 = this.getPosition(this.getChildAt(this.getChildCount() - 1));
            this.addViewsStart(arg3, v0 - 1);
            this.addViewsEnd(arg3, arg4, v1 + 1);
        }

        this.validateChildOrderIfDebugging();
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public int getCarouselAlignment() {
        return this.carouselAlignment;
    }

    private View getChildClosestToEnd() {
        int v0 = this.isLayoutRtl() ? 0 : this.getChildCount() - 1;
        return this.getChildAt(v0);
    }

    private View getChildClosestToStart() {
        int v0 = this.isLayoutRtl() ? this.getChildCount() - 1 : 0;
        return this.getChildAt(v0);
    }

    public int getContainerHeight() {
        return this.getHeight();
    }

    private int getContainerSize() {
        if(this.isHorizontal()) {
            return this.getContainerWidth();
        }

        return this.getContainerHeight();
    }

    public int getContainerWidth() {
        return this.getWidth();
    }

    public void getDecoratedBoundsWithMargins(View arg4, Rect arg5) {
        super.getDecoratedBoundsWithMargins(arg4, arg5);
        float v4 = ((float)arg5.centerY());
        if(this.isHorizontal()) {
            v4 = ((float)arg5.centerX());
        }

        v4 = this.getMaskedItemSizeForLocOffset(v4, CarouselLayoutManager.getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), v4, true));
        float v1 = 2f;
        float v2 = 0f;
        float v0 = this.isHorizontal() ? ((((float)arg5.width())) - v4) / v1 : 0f;
        if(this.isHorizontal()) {
        }
        else {
            v2 = ((((float)arg5.height())) - v4) / v1;
        }

        arg5.set(((int)((((float)arg5.left)) + v0)), ((int)((((float)arg5.top)) + v2)), ((int)((((float)arg5.right)) - v0)), ((int)((((float)arg5.bottom)) - v2)));
    }

    private float getDecoratedCenterWithMargins(View arg2) {
        Rect v0 = new Rect();
        super.getDecoratedBoundsWithMargins(arg2, v0);
        int v1 = this.isHorizontal() ? v0.centerX() : v0.centerY();
        return ((float)v1);
    }

    private KeylineState getKeylineStateForPosition(int arg4) {
        Map v0 = this.keylineStatePositionMap;
        if(v0 != null) {
            Object v4 = v0.get(Integer.valueOf(MathUtils.clamp(arg4, 0, Math.max(0, this.getItemCount() - 1))));
            if(v4 != null) {
                return ((KeylineState)v4);
            }
        }

        return this.keylineStateList.getDefaultState();
    }

    private float getMaskedItemSizeForLocOffset(float arg3, KeylineRange arg4) {
        return AnimationUtils.lerp(arg4.leftOrTop.maskedItemSize, arg4.rightOrBottom.maskedItemSize, arg4.leftOrTop.locOffset, arg4.rightOrBottom.locOffset, arg3);
    }

    int getOffsetToScrollToPosition(int arg1, KeylineState arg2) {
        return this.getScrollOffsetForPosition(arg1, arg2) - this.scrollOffset;
    }

    int getOffsetToScrollToPositionForSnap(int arg6, boolean arg7) {
        int v0 = this.getOffsetToScrollToPosition(arg6, this.keylineStateList.getShiftedState(((float)this.scrollOffset), ((float)this.minScroll), ((float)this.maxScroll), true));
        int v5 = this.keylineStatePositionMap != null ? this.getOffsetToScrollToPosition(arg6, this.getKeylineStateForPosition(arg6)) : v0;
        if((arg7) && Math.abs(v5) < Math.abs(v0)) {
            return v5;
        }

        return v0;
    }

    public int getOrientation() {
        return this.orientationHelper.orientation;
    }

    private int getParentBottom() {
        return this.orientationHelper.getParentBottom();
    }

    private int getParentEnd() {
        return this.orientationHelper.getParentEnd();
    }

    private int getParentLeft() {
        return this.orientationHelper.getParentLeft();
    }

    private int getParentRight() {
        return this.orientationHelper.getParentRight();
    }

    private int getParentStart() {
        return this.orientationHelper.getParentStart();
    }

    private int getParentTop() {
        return this.orientationHelper.getParentTop();
    }

    private int getScrollOffsetForPosition(int arg3, KeylineState arg4) {
        float v1 = 2f;
        float v2 = this.isLayoutRtl() ? (((float)this.getContainerSize())) - arg4.getLastFocalKeyline().loc - (((float)arg3)) * arg4.getItemSize() - arg4.getItemSize() / v1 : (((float)arg3)) * arg4.getItemSize() - arg4.getFirstFocalKeyline().loc + arg4.getItemSize() / v1;
        return ((int)v2);
    }

    private int getSmallestScrollOffsetToFocalKeyline(int arg7, KeylineState arg8) {
        Iterator v0 = arg8.getFocalKeylines().iterator();
        int v1;
        for(v1 = 0x7FFFFFFF; v0.hasNext(); v1 = v2_1) {
            Object v2 = v0.next();
            float v3 = (((float)arg7)) * arg8.getItemSize() + arg8.getItemSize() / 2f;
            int v2_1 = this.isLayoutRtl() ? ((int)((((float)this.getContainerSize())) - ((Keyline)v2).loc - v3)) : ((int)(v3 - ((Keyline)v2).loc));
            v2_1 -= this.scrollOffset;
            if(Math.abs(v1) <= Math.abs(v2_1)) {
                continue;
            }
        }

        return v1;
    }

    private static KeylineRange getSurroundingKeylineRange(List arg13, float arg14, boolean arg15) {
        int v0 = -1;
        float v1 = 3.402823E+38f;
        int v6 = v0;
        int v7 = v6;
        int v8 = v7;
        int v9 = v8;
        float v4 = -3.402823E+38f;
        int v5 = 0;
        float v2 = v1;
        float v3 = v2;
        while(v5 < arg13.size()) {
            Object v10 = arg13.get(v5);
            float v10_1 = arg15 ? ((Keyline)v10).locOffset : ((Keyline)v10).loc;
            float v11 = Math.abs(v10_1 - arg14);
            if(v10_1 <= arg14 && v11 <= v1) {
                v6 = v5;
                v1 = v11;
            }

            if(v10_1 > arg14 && v11 <= v2) {
                v8 = v5;
                v2 = v11;
            }

            if(v10_1 <= v3) {
                v7 = v5;
                v3 = v10_1;
            }

            if(v10_1 > v4) {
                v9 = v5;
                v4 = v10_1;
            }

            ++v5;
        }

        if(v6 == v0) {
            v6 = v7;
        }

        if(v8 == v0) {
            v8 = v9;
        }

        return new KeylineRange(arg13.get(v6), arg13.get(v8));
    }

    public boolean isHorizontal() {
        if(this.orientationHelper.orientation == 0) {
            return 1;
        }

        return 0;
    }

    boolean isLayoutRtl() {
        if((this.isHorizontal()) && this.getLayoutDirection() == 1) {
            return 1;
        }

        return 0;
    }

    private boolean isLocOffsetOutOfFillBoundsEnd(float arg3, KeylineRange arg4) {
        arg3 = this.addStart(arg3, this.getMaskedItemSizeForLocOffset(arg3, arg4) / 2f);
        if(this.isLayoutRtl()) {
            if(arg3 < 0f) {
                return 1;
            }

            return 0;
        }

        if(arg3 > (((float)this.getContainerSize()))) {
            return 1;
        }

        return 0;
    }

    private boolean isLocOffsetOutOfFillBoundsStart(float arg3, KeylineRange arg4) {
        arg3 = this.addEnd(arg3, this.getMaskedItemSizeForLocOffset(arg3, arg4) / 2f);
        if(this.isLayoutRtl()) {
            if(arg3 > (((float)this.getContainerSize()))) {
                return 1;
            }

            return 0;
        }

        if(arg3 < 0f) {
            return 1;
        }

        return 0;
    }

    void lambda$new$0$com-google-android-material-carousel-CarouselLayoutManager(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        if(arg2 == arg6 && arg3 == arg7 && arg4 == arg8) {
            if(arg5 != arg9) {
            }
            else {
                return;
            }
        }

        arg1.post(new CarouselLayoutManager$$ExternalSyntheticLambda0(this));
    }

    private void logChildrenIfDebugging() {
        if(!this.isDebuggingEnabled) {
        }
        else {
            String v1 = "CarouselLayoutManager";
            if(Log.isLoggable(v1, 3)) {
                Log.d(v1, "internal representation of views on the screen");
                int v0;
                for(v0 = 0; v0 < this.getChildCount(); ++v0) {
                    View v2 = this.getChildAt(v0);
                    Log.d(v1, "item position " + this.getPosition(v2) + ", center:" + this.getDecoratedCenterWithMargins(v2) + ", child index:" + v0);
                }

                Log.d(v1, "==============");
            }
        }
    }

    private ChildCalculations makeChildCalculations(Recycler arg3, float arg4, int arg5) {
        View v3 = arg3.getViewForPosition(arg5);
        this.measureChildWithMargins(v3, 0, 0);
        arg4 = this.addEnd(arg4, this.currentKeylineState.getItemSize() / 2f);
        KeylineRange v5 = CarouselLayoutManager.getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), arg4, false);
        return new ChildCalculations(v3, arg4, this.calculateChildOffsetCenterForLocation(v3, arg4, v5), v5);
    }

    public void measureChildWithMargins(View arg8, int arg9, int arg10) {
        if((arg8 instanceof Maskable)) {
            ViewGroup$LayoutParams v0 = arg8.getLayoutParams();
            Rect v1 = new Rect();
            this.calculateItemDecorationsForChild(arg8, v1);
            arg9 += v1.left + v1.right;
            arg10 += v1.top + v1.bottom;
            float v1_1 = this.keylineStateList == null || this.orientationHelper.orientation != 0 ? ((float)((LayoutParams)v0).width) : this.keylineStateList.getDefaultState().getItemSize();
            float v2 = this.keylineStateList == null || this.orientationHelper.orientation != 1 ? ((float)((LayoutParams)v0).height) : this.keylineStateList.getDefaultState().getItemSize();
            arg8.measure(CarouselLayoutManager.getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingLeft() + this.getPaddingRight() + ((LayoutParams)v0).leftMargin + ((LayoutParams)v0).rightMargin + arg9, ((int)v1_1), this.canScrollHorizontally()), CarouselLayoutManager.getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingTop() + this.getPaddingBottom() + ((LayoutParams)v0).topMargin + ((LayoutParams)v0).bottomMargin + arg10, ((int)v2), this.canScrollVertically()));
            return;
        }

        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    private float offsetChild(View arg3, float arg4, float arg5, Rect arg6) {
        arg4 = this.addEnd(arg4, arg5);
        KeylineRange v0 = CarouselLayoutManager.getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), arg4, false);
        float v1 = this.calculateChildOffsetCenterForLocation(arg3, arg4, v0);
        super.getDecoratedBoundsWithMargins(arg3, arg6);
        this.updateChildMaskForLocation(arg3, arg4, v0);
        this.orientationHelper.offsetChild(arg3, arg6, arg5, v1);
        return v1;
    }

    public void onAttachedToWindow(RecyclerView arg1) {
        super.onAttachedToWindow(arg1);
        this.refreshKeylineState();
        arg1.addOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    public void onDetachedFromWindow(RecyclerView arg1, Recycler arg2) {
        super.onDetachedFromWindow(arg1, arg2);
        arg1.removeOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    public View onFocusSearchFailed(View arg2, int arg3, Recycler arg4, State arg5) {
        View v0 = null;
        if(this.getChildCount() == 0) {
            return v0;
        }

        arg3 = this.convertFocusDirectionToLayoutDirection(arg3);
        if(arg3 == 0x80000000) {
            return v0;
        }

        int v5 = -1;
        if(arg3 == v5) {
            if(this.getPosition(arg2) == 0) {
                return v0;
            }

            this.addViewAtPosition(arg4, this.getPosition(this.getChildAt(0)) - 1, 0);
            return this.getChildClosestToStart();
        }

        if(this.getPosition(arg2) == this.getItemCount() - 1) {
            return v0;
        }

        this.addViewAtPosition(arg4, this.getPosition(this.getChildAt(this.getChildCount() - 1)) + 1, v5);
        return this.getChildClosestToEnd();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent arg2) {
        super.onInitializeAccessibilityEvent(arg2);
        if(this.getChildCount() > 0) {
            arg2.setFromIndex(this.getPosition(this.getChildAt(0)));
            arg2.setToIndex(this.getPosition(this.getChildAt(this.getChildCount() - 1)));
        }
    }

    public void onItemsAdded(RecyclerView arg1, int arg2, int arg3) {
        super.onItemsAdded(arg1, arg2, arg3);
        this.updateItemCount();
    }

    public void onItemsRemoved(RecyclerView arg1, int arg2, int arg3) {
        super.onItemsRemoved(arg1, arg2, arg3);
        this.updateItemCount();
    }

    public void onLayoutChildren(Recycler arg7, State arg8) {
        if(arg8.getItemCount() > 0) {
            if((((float)this.getContainerSize())) <= 0f) {
            }
            else {
                boolean v0 = this.isLayoutRtl();
                int v2 = this.keylineStateList == null ? 1 : 0;
                if(v2 != 0) {
                    this.recalculateKeylineStateList(arg7);
                }

                int v3 = this.calculateStartScroll(this.keylineStateList);
                int v4 = this.calculateEndScroll(arg8, this.keylineStateList);
                int v5 = v0 ? v4 : v3;
                this.minScroll = v5;
                if(v0) {
                    v4 = v3;
                }

                this.maxScroll = v4;
                if(v2 != 0) {
                    this.scrollOffset = v3;
                    this.keylineStatePositionMap = this.keylineStateList.getKeylineStateForPositionMap(this.getItemCount(), this.minScroll, this.maxScroll, this.isLayoutRtl());
                    int v0_1 = this.currentEstimatedPosition;
                    if(v0_1 != -1) {
                        this.scrollOffset = this.getScrollOffsetForPosition(v0_1, this.getKeylineStateForPosition(v0_1));
                    }
                }

                this.scrollOffset += CarouselLayoutManager.calculateShouldScrollBy(0, this.scrollOffset, this.minScroll, this.maxScroll);
                this.currentFillStartPosition = MathUtils.clamp(this.currentFillStartPosition, 0, arg8.getItemCount());
                this.updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
                this.detachAndScrapAttachedViews(arg7);
                this.fill(arg7, arg8);
                this.lastItemCount = this.getItemCount();
                return;
            }
        }

        this.removeAndRecycleAllViews(arg7);
        this.currentFillStartPosition = 0;
    }

    public void onLayoutCompleted(State arg2) {
        super.onLayoutCompleted(arg2);
        this.currentFillStartPosition = this.getChildCount() == 0 ? 0 : this.getPosition(this.getChildAt(0));
        this.validateChildOrderIfDebugging();
    }

    private void recalculateKeylineStateList(Recycler arg2) {
        View v2 = arg2.getViewForPosition(0);
        this.measureChildWithMargins(v2, 0, 0);
        KeylineState v2_1 = this.carouselStrategy.onFirstChildMeasuredWithMargins(((Carousel)this), v2);
        if(this.isLayoutRtl()) {
            v2_1 = KeylineState.reverse(v2_1, ((float)this.getContainerSize()));
        }

        this.keylineStateList = KeylineStateList.from(((Carousel)this), v2_1);
    }

    private void refreshKeylineState() {
        this.keylineStateList = null;
        this.requestLayout();
    }

    private void removeAndRecycleOutOfBoundsViews(Recycler arg5) {
        float v2;
        View v0;
        while(this.getChildCount() > 0) {
            v0 = this.getChildAt(0);
            v2 = this.getDecoratedCenterWithMargins(v0);
            if(!this.isLocOffsetOutOfFillBoundsStart(v2, CarouselLayoutManager.getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), v2, true))) {
                break;
            }

            this.removeAndRecycleView(v0, arg5);
        }

        while(this.getChildCount() - 1 >= 0) {
            v0 = this.getChildAt(this.getChildCount() - 1);
            v2 = this.getDecoratedCenterWithMargins(v0);
            if(!this.isLocOffsetOutOfFillBoundsEnd(v2, CarouselLayoutManager.getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), v2, true))) {
                return;
            }

            this.removeAndRecycleView(v0, arg5);
        }
    }

    public boolean requestChildRectangleOnScreen(RecyclerView arg2, View arg3, Rect arg4, boolean arg5, boolean arg6) {
        if(this.keylineStateList == null) {
            return 0;
        }

        int v4 = this.getSmallestScrollOffsetToFocalKeyline(this.getPosition(arg3), this.getKeylineStateForPosition(this.getPosition(arg3)));
        if(v4 == 0) {
            return 0;
        }

        this.scrollBy(arg2, this.getSmallestScrollOffsetToFocalKeyline(this.getPosition(arg3), this.keylineStateList.getShiftedState(((float)(this.scrollOffset + CarouselLayoutManager.calculateShouldScrollBy(v4, this.scrollOffset, this.minScroll, this.maxScroll))), ((float)this.minScroll), ((float)this.maxScroll))));
        return 1;
    }

    private int scrollBy(int arg10, Recycler arg11, State arg12) {
        int v1 = 0;
        if(this.getChildCount() != 0) {
            if(arg10 == 0) {
            }
            else {
                if(this.keylineStateList == null) {
                    this.recalculateKeylineStateList(arg11);
                }

                arg10 = CarouselLayoutManager.calculateShouldScrollBy(arg10, this.scrollOffset, this.minScroll, this.maxScroll);
                this.scrollOffset += arg10;
                this.updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
                float v0 = this.currentKeylineState.getItemSize() / 2f;
                float v2 = this.calculateChildStartForFill(this.getPosition(this.getChildAt(0)));
                Rect v3 = new Rect();
                boolean v4 = this.isLayoutRtl();
                KeylineState v5 = this.currentKeylineState;
                float v4_1 = v4 ? v5.getLastFocalKeyline().locOffset : v5.getFirstFocalKeyline().locOffset;
                float v5_1 = 3.402823E+38f;
                while(v1 < this.getChildCount()) {
                    View v6 = this.getChildAt(v1);
                    float v7 = Math.abs(v4_1 - this.offsetChild(v6, v2, v0, v3));
                    if(v6 != null && v7 < v5_1) {
                        this.currentEstimatedPosition = this.getPosition(v6);
                        v5_1 = v7;
                    }

                    v2 = this.addEnd(v2, this.currentKeylineState.getItemSize());
                    ++v1;
                }

                this.fill(arg11, arg12);
                return arg10;
            }
        }

        return 0;
    }

    private void scrollBy(RecyclerView arg2, int arg3) {
        if(this.isHorizontal()) {
            arg2.scrollBy(arg3, 0);
            return;
        }

        arg2.scrollBy(0, arg3);
    }

    public int scrollHorizontallyBy(int arg2, Recycler arg3, State arg4) {
        if(this.canScrollHorizontally()) {
            return this.scrollBy(arg2, arg3, arg4);
        }

        return 0;
    }

    public void scrollToPosition(int arg3) {
        this.currentEstimatedPosition = arg3;
        if(this.keylineStateList == null) {
            return;
        }

        this.scrollOffset = this.getScrollOffsetForPosition(arg3, this.getKeylineStateForPosition(arg3));
        this.currentFillStartPosition = MathUtils.clamp(arg3, 0, Math.max(0, this.getItemCount() - 1));
        this.updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
        this.requestLayout();
    }

    public int scrollVerticallyBy(int arg2, Recycler arg3, State arg4) {
        if(this.canScrollVertically()) {
            return this.scrollBy(arg2, arg3, arg4);
        }

        return 0;
    }

    public void setCarouselAlignment(int arg1) {
        this.carouselAlignment = arg1;
        this.refreshKeylineState();
    }

    private void setCarouselAttributes(Context arg2, AttributeSet arg3) {
        if(arg3 != null) {
            TypedArray v2 = arg2.obtainStyledAttributes(arg3, styleable.Carousel);
            this.setCarouselAlignment(v2.getInt(styleable.Carousel_carousel_alignment, 0));
            this.setOrientation(v2.getInt(styleable.RecyclerView_android_orientation, 0));
            v2.recycle();
        }
    }

    public void setCarouselStrategy(CarouselStrategy arg1) {
        this.carouselStrategy = arg1;
        this.refreshKeylineState();
    }

    public void setDebuggingEnabled(RecyclerView arg2, boolean arg3) {
        this.isDebuggingEnabled = arg3;
        arg2.removeItemDecoration(this.debugItemDecoration);
        if(arg3) {
            arg2.addItemDecoration(this.debugItemDecoration);
        }

        arg2.invalidateItemDecorations();
    }

    public void setOrientation(int arg3) {
        if(arg3 != 0) {
            if(arg3 == 1) {
            }
            else {
                throw new IllegalArgumentException("invalid orientation:" + arg3);
            }
        }

        this.assertNotInLayoutOrScroll(null);
        CarouselOrientationHelper v0 = this.orientationHelper;
        if(v0 != null) {
            if(arg3 != v0.orientation) {
            }
            else {
                return;
            }
        }

        this.orientationHelper = CarouselOrientationHelper.createOrientationHelper(this, arg3);
        this.refreshKeylineState();
    }

    public void smoothScrollToPosition(RecyclerView arg1, State arg2, int arg3) {
        com.google.android.material.carousel.CarouselLayoutManager$1 v2 = new LinearSmoothScroller(arg1.getContext()) {
            public int calculateDxToMakeVisible(View arg1, int arg2) {
                if(CarouselLayoutManager.this.keylineStateList != null) {
                    if(!CarouselLayoutManager.this.isHorizontal()) {
                    }
                    else {
                        return CarouselLayoutManager.this.calculateScrollDeltaToMakePositionVisible(CarouselLayoutManager.this.getPosition(arg1));
                    }
                }

                return 0;
            }

            public int calculateDyToMakeVisible(View arg1, int arg2) {
                if(CarouselLayoutManager.this.keylineStateList != null) {
                    if(CarouselLayoutManager.this.isHorizontal()) {
                    }
                    else {
                        return CarouselLayoutManager.this.calculateScrollDeltaToMakePositionVisible(CarouselLayoutManager.this.getPosition(arg1));
                    }
                }

                return 0;
            }

            public PointF computeScrollVectorForPosition(int arg1) {
                return CarouselLayoutManager.this.computeScrollVectorForPosition(arg1);
            }
        };
        ((LinearSmoothScroller)v2).setTargetPosition(arg3);
        this.startSmoothScroll(((SmoothScroller)v2));
    }

    private void updateChildMaskForLocation(View arg9, float arg10, KeylineRange arg11) {
        if(!(arg9 instanceof Maskable)) {
            return;
        }

        float v0 = AnimationUtils.lerp(arg11.leftOrTop.mask, arg11.rightOrBottom.mask, arg11.leftOrTop.loc, arg11.rightOrBottom.loc, arg10);
        float v1 = ((float)arg9.getHeight());
        float v2 = ((float)arg9.getWidth());
        RectF v0_1 = this.orientationHelper.getMaskRect(v1, v2, AnimationUtils.lerp(0f, v1 / 2f, 0f, 1f, v0), AnimationUtils.lerp(0f, v2 / 2f, 0f, 1f, v0));
        arg10 = this.calculateChildOffsetCenterForLocation(arg9, arg10, arg11);
        RectF v3 = new RectF(arg10 - v0_1.width() / 2f, arg10 - v0_1.height() / 2f, arg10 + v0_1.width() / 2f, v0_1.height() / 2f + arg10);
        RectF v10 = new RectF(((float)this.getParentLeft()), ((float)this.getParentTop()), ((float)this.getParentRight()), ((float)this.getParentBottom()));
        if(this.carouselStrategy.isContained()) {
            this.orientationHelper.containMaskWithinBounds(v0_1, v3, v10);
        }

        this.orientationHelper.moveMaskOnEdgeOutsideBounds(v0_1, v3, v10);
        ((Maskable)arg9).setMaskRectF(v0_1);
    }

    private void updateCurrentKeylineStateForScrollOffset(KeylineStateList arg4) {
        KeylineState v4;
        int v0 = this.maxScroll;
        int v1 = this.minScroll;
        if(v0 <= v1) {
            v4 = this.isLayoutRtl() ? arg4.getEndState() : arg4.getStartState();
            this.currentKeylineState = v4;
        }
        else {
            v4 = arg4.getShiftedState(((float)this.scrollOffset), ((float)v1), ((float)v0));
            this.currentKeylineState = v4;
        }

        this.debugItemDecoration.setKeylines(v4.getKeylines());
    }

    private void updateItemCount() {
        int v0 = this.getItemCount();
        int v1 = this.lastItemCount;
        if(v0 != v1) {
            if(this.keylineStateList == null) {
            }
            else {
                if(this.carouselStrategy.shouldRefreshKeylineState(((Carousel)this), v1)) {
                    this.refreshKeylineState();
                }

                this.lastItemCount = v0;
            }
        }
    }

    private void validateChildOrderIfDebugging() {
        int v4;
        int v3;
        int v2;
        if(this.isDebuggingEnabled) {
            if(this.getChildCount() < 1) {
            }
            else {
                int v0 = 0;
                while(true) {
                    if(v0 < this.getChildCount() - 1) {
                        v2 = this.getPosition(this.getChildAt(v0));
                        v3 = v0 + 1;
                        v4 = this.getPosition(this.getChildAt(v3));
                        if(v2 <= v4) {
                            v0 = v3;
                            continue;
                        }
                        else {
                            break;
                        }
                    }

                    return;
                }

                this.logChildrenIfDebugging();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + v0 + "] had adapter position [" + v2 + "] and child at index [" + v3 + "] had adapter position [" + v4 + "].");
            }
        }
    }
}

