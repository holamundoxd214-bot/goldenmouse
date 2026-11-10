package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;

class FastScroller extends ItemDecoration implements OnItemTouchListener {
    class androidx.recyclerview.widget.FastScroller$1 implements Runnable {
        androidx.recyclerview.widget.FastScroller$1(FastScroller arg1) {
            FastScroller.this = arg1;
            super();
        }

        public void run() {
            FastScroller.this.hide(500);
        }
    }

    class androidx.recyclerview.widget.FastScroller$2 extends OnScrollListener {
        androidx.recyclerview.widget.FastScroller$2(FastScroller arg1) {
            FastScroller.this = arg1;
            super();
        }

        public void onScrolled(RecyclerView arg1, int arg2, int arg3) {
            FastScroller.this.updateScrollPosition(arg1.computeHorizontalScrollOffset(), arg1.computeVerticalScrollOffset());
        }
    }

    class AnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled;

        AnimatorListener(FastScroller arg1) {
            FastScroller.this = arg1;
            super();
            this.mCanceled = false;
        }

        public void onAnimationCancel(Animator arg1) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator arg3) {
            if(this.mCanceled) {
                this.mCanceled = false;
                return;
            }

            int v3 = Float.compare(FastScroller.this.mShowHideAnimator.getAnimatedValue().floatValue(), 0f);
            FastScroller v1 = FastScroller.this;
            if(v3 == 0) {
                v1.mAnimationState = 0;
                FastScroller.this.setState(0);
                return;
            }

            v1.mAnimationState = 2;
            FastScroller.this.requestRedraw();
        }
    }

    class AnimatorUpdater implements ValueAnimator$AnimatorUpdateListener {
        AnimatorUpdater(FastScroller arg1) {
            FastScroller.this = arg1;
            super();
        }

        public void onAnimationUpdate(ValueAnimator arg2) {
            int v2 = ((int)(arg2.getAnimatedValue().floatValue() * 255f));
            FastScroller.this.mVerticalThumbDrawable.setAlpha(v2);
            FastScroller.this.mVerticalTrackDrawable.setAlpha(v2);
            FastScroller.this.requestRedraw();
        }
    }

    private static final int ANIMATION_STATE_FADING_IN = 1;
    private static final int ANIMATION_STATE_FADING_OUT = 3;
    private static final int ANIMATION_STATE_IN = 2;
    private static final int ANIMATION_STATE_OUT = 0;
    private static final int DRAG_NONE = 0;
    private static final int DRAG_X = 1;
    private static final int DRAG_Y = 2;
    private static final int[] EMPTY_STATE_SET = null;
    private static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
    private static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
    private static final int HIDE_DURATION_MS = 500;
    private static final int[] PRESSED_STATE_SET = null;
    private static final int SCROLLBAR_FULL_OPAQUE = 0xFF;
    private static final int SHOW_DURATION_MS = 500;
    private static final int STATE_DRAGGING = 2;
    private static final int STATE_HIDDEN = 0;
    private static final int STATE_VISIBLE = 1;
    int mAnimationState;
    private int mDragState;
    private final Runnable mHideRunnable;
    float mHorizontalDragX;
    private final int[] mHorizontalRange;
    int mHorizontalThumbCenterX;
    private final StateListDrawable mHorizontalThumbDrawable;
    private final int mHorizontalThumbHeight;
    int mHorizontalThumbWidth;
    private final Drawable mHorizontalTrackDrawable;
    private final int mHorizontalTrackHeight;
    private final int mMargin;
    private boolean mNeedHorizontalScrollbar;
    private boolean mNeedVerticalScrollbar;
    private final OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;
    private int mRecyclerViewHeight;
    private int mRecyclerViewWidth;
    private final int mScrollbarMinimumRange;
    final ValueAnimator mShowHideAnimator;
    private int mState;
    float mVerticalDragY;
    private final int[] mVerticalRange;
    int mVerticalThumbCenterY;
    final StateListDrawable mVerticalThumbDrawable;
    int mVerticalThumbHeight;
    private final int mVerticalThumbWidth;
    final Drawable mVerticalTrackDrawable;
    private final int mVerticalTrackWidth;

    static {
        FastScroller.PRESSED_STATE_SET = new int[]{0x10100A7};
        FastScroller.EMPTY_STATE_SET = new int[0];
    }

    FastScroller(RecyclerView arg4, StateListDrawable arg5, Drawable arg6, StateListDrawable arg7, Drawable arg8, int arg9, int arg10, int arg11) {
        super();
        this.mRecyclerViewWidth = 0;
        this.mRecyclerViewHeight = 0;
        this.mNeedVerticalScrollbar = false;
        this.mNeedHorizontalScrollbar = false;
        this.mState = 0;
        this.mDragState = 0;
        this.mVerticalRange = new int[2];
        this.mHorizontalRange = new int[2];
        ValueAnimator v1 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        this.mShowHideAnimator = v1;
        this.mAnimationState = 0;
        this.mHideRunnable = new androidx.recyclerview.widget.FastScroller$1(this);
        this.mOnScrollListener = new androidx.recyclerview.widget.FastScroller$2(this);
        this.mVerticalThumbDrawable = arg5;
        this.mVerticalTrackDrawable = arg6;
        this.mHorizontalThumbDrawable = arg7;
        this.mHorizontalTrackDrawable = arg8;
        this.mVerticalThumbWidth = Math.max(arg9, arg5.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(arg9, arg6.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(arg9, arg7.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(arg9, arg8.getIntrinsicWidth());
        this.mScrollbarMinimumRange = arg10;
        this.mMargin = arg11;
        arg5.setAlpha(0xFF);
        arg6.setAlpha(0xFF);
        v1.addListener(new AnimatorListener(this));
        v1.addUpdateListener(new AnimatorUpdater(this));
        this.attachToRecyclerView(arg4);
    }

    public void attachToRecyclerView(RecyclerView arg2) {
        RecyclerView v0 = this.mRecyclerView;
        if(v0 == arg2) {
        }
        else {
            if(v0 != null) {
                this.destroyCallbacks();
            }

            this.mRecyclerView = arg2;
            if(arg2 == null) {
                return;
            }

            this.setupCallbacks();
        }
    }

    private void cancelHide() {
        this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(((ItemDecoration)this));
        this.mRecyclerView.removeOnItemTouchListener(((OnItemTouchListener)this));
        this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
        this.cancelHide();
    }

    private void drawHorizontalScrollbar(Canvas arg7) {
        int v0 = this.mRecyclerViewHeight;
        int v1 = this.mHorizontalThumbHeight;
        v0 -= v1;
        int v2 = this.mHorizontalThumbCenterX - this.mHorizontalThumbWidth / 2;
        this.mHorizontalThumbDrawable.setBounds(0, 0, this.mHorizontalThumbWidth, v1);
        this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
        arg7.translate(0f, ((float)v0));
        this.mHorizontalTrackDrawable.draw(arg7);
        arg7.translate(((float)v2), 0f);
        this.mHorizontalThumbDrawable.draw(arg7);
        arg7.translate(((float)(-v2)), ((float)(-v0)));
    }

    private void drawVerticalScrollbar(Canvas arg7) {
        int v0 = this.mRecyclerViewWidth;
        int v1 = this.mVerticalThumbWidth;
        v0 -= v1;
        int v2 = this.mVerticalThumbCenterY - this.mVerticalThumbHeight / 2;
        this.mVerticalThumbDrawable.setBounds(0, 0, v1, this.mVerticalThumbHeight);
        this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
        if(this.isLayoutRTL()) {
            this.mVerticalTrackDrawable.draw(arg7);
            arg7.translate(((float)this.mVerticalThumbWidth), ((float)v2));
            arg7.scale(-1f, 1f);
            this.mVerticalThumbDrawable.draw(arg7);
            arg7.scale(1f, 1f);
            arg7.translate(((float)(-this.mVerticalThumbWidth)), ((float)(-v2)));
            return;
        }

        arg7.translate(((float)v0), 0f);
        this.mVerticalTrackDrawable.draw(arg7);
        arg7.translate(0f, ((float)v2));
        this.mVerticalThumbDrawable.draw(arg7);
        arg7.translate(((float)(-v0)), ((float)(-v2)));
    }

    private int[] getHorizontalRange() {
        int[] v0 = this.mHorizontalRange;
        int v1 = this.mMargin;
        v0[0] = v1;
        v0[1] = this.mRecyclerViewWidth - v1;
        return v0;
    }

    Drawable getHorizontalThumbDrawable() {
        return this.mHorizontalThumbDrawable;
    }

    Drawable getHorizontalTrackDrawable() {
        return this.mHorizontalTrackDrawable;
    }

    private int[] getVerticalRange() {
        int[] v0 = this.mVerticalRange;
        int v1 = this.mMargin;
        v0[0] = v1;
        v0[1] = this.mRecyclerViewHeight - v1;
        return v0;
    }

    Drawable getVerticalThumbDrawable() {
        return this.mVerticalThumbDrawable;
    }

    Drawable getVerticalTrackDrawable() {
        return this.mVerticalTrackDrawable;
    }

    void hide(int arg6) {
        int v0 = this.mAnimationState;
        int v1 = 2;
        if(v0 == 1) {
            this.mShowHideAnimator.cancel();
        }
        else if(v0 != v1) {
            return;
        }

        this.mAnimationState = 3;
        ValueAnimator v0_1 = this.mShowHideAnimator;
        float v3 = v0_1.getAnimatedValue().floatValue();
        float[] v1_1 = new float[v1];
        v1_1[0] = v3;
        v1_1[1] = 0f;
        v0_1.setFloatValues(v1_1);
        this.mShowHideAnimator.setDuration(((long)arg6));
        this.mShowHideAnimator.start();
    }

    private void horizontalScrollTo(float arg9) {
        int[] v3 = this.getHorizontalRange();
        float v2 = Math.max(((float)v3[0]), Math.min(((float)v3[1]), arg9));
        if(Math.abs((((float)this.mHorizontalThumbCenterX)) - v2) < 2f) {
            return;
        }

        FastScroller v0 = this;
        int v8 = v0.scrollTo(this.mHorizontalDragX, v2, v3, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
        if(v8 != 0) {
            v0.mRecyclerView.scrollBy(v8, 0);
        }

        v0.mHorizontalDragX = v2;
    }

    public boolean isDragging() {
        if(this.mState == 2) {
            return 1;
        }

        return 0;
    }

    private boolean isLayoutRTL() {
        if(ViewCompat.getLayoutDirection(this.mRecyclerView) == 1) {
            return 1;
        }

        return 0;
    }

    boolean isPointInsideHorizontalThumb(float arg3, float arg4) {
        if(arg4 >= (((float)(this.mRecyclerViewHeight - this.mHorizontalThumbHeight)))) {
            int v4 = this.mHorizontalThumbCenterX;
            int v2 = this.mHorizontalThumbWidth;
            if(arg3 >= (((float)(v4 - v2 / 2))) && arg3 <= (((float)(v4 + v2 / 2)))) {
                return 1;
            }
        }

        return 0;
    }

    boolean isPointInsideVerticalThumb(float arg3, float arg4) {
        if(this.isLayoutRTL()) {
            if(arg3 <= (((float)(this.mVerticalThumbWidth / 2)))) {
                goto label_12;
            }
        }
        else if(arg3 >= (((float)(this.mRecyclerViewWidth - this.mVerticalThumbWidth)))) {
        label_12:
            int v3 = this.mVerticalThumbCenterY;
            int v2 = this.mVerticalThumbHeight;
            if(arg4 >= (((float)(v3 - v2 / 2))) && arg4 <= (((float)(v3 + v2 / 2)))) {
                return 1;
            }
        }

        return 0;
    }

    boolean isVisible() {
        if(this.mState == 1) {
            return 1;
        }

        return 0;
    }

    public void onDrawOver(Canvas arg1, RecyclerView arg2, State arg3) {
        if(this.mRecyclerViewWidth == this.mRecyclerView.getWidth()) {
            if(this.mRecyclerViewHeight != this.mRecyclerView.getHeight()) {
            }
            else {
                if(this.mAnimationState != 0) {
                    if(this.mNeedVerticalScrollbar) {
                        this.drawVerticalScrollbar(arg1);
                    }

                    if(!this.mNeedHorizontalScrollbar) {
                        return;
                    }

                    this.drawHorizontalScrollbar(arg1);
                }

                return;
            }
        }

        this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
        this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
        this.setState(0);
    }

    public boolean onInterceptTouchEvent(RecyclerView arg6, MotionEvent arg7) {
        int v6 = this.mState;
        int v1 = 2;
        if(v6 == 1) {
            boolean v6_1 = this.isPointInsideVerticalThumb(arg7.getX(), arg7.getY());
            boolean v3 = this.isPointInsideHorizontalThumb(arg7.getX(), arg7.getY());
            if(arg7.getAction() == 0 && ((v6_1) || (v3))) {
                if(v3) {
                    this.mDragState = 1;
                    this.mHorizontalDragX = ((float)(((int)arg7.getX())));
                }
                else if(v6_1) {
                    this.mDragState = v1;
                    this.mVerticalDragY = ((float)(((int)arg7.getY())));
                }

                this.setState(v1);
                return 1;
            }

            return 0;
        }

        if(v6 == v1) {
            return 1;
        }

        return 0;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean arg1) {
    }

    public void onTouchEvent(RecyclerView arg5, MotionEvent arg6) {
        if(this.mState == 0) {
        }
        else {
            int v1 = 2;
            if(arg6.getAction() == 0) {
                boolean v5 = this.isPointInsideVerticalThumb(arg6.getX(), arg6.getY());
                boolean v2 = this.isPointInsideHorizontalThumb(arg6.getX(), arg6.getY());
                if(!v5 && !v2) {
                    return;
                }

                if(v2) {
                    this.mDragState = 1;
                    this.mHorizontalDragX = ((float)(((int)arg6.getX())));
                }
                else if(v5) {
                    this.mDragState = v1;
                    this.mVerticalDragY = ((float)(((int)arg6.getY())));
                }

                this.setState(v1);
                return;
            }
            else {
                if(arg6.getAction() == 1 && this.mState == v1) {
                    this.mVerticalDragY = 0f;
                    this.mHorizontalDragX = 0f;
                    this.setState(1);
                    this.mDragState = 0;
                    return;
                }

                if(arg6.getAction() != v1) {
                    return;
                }

                if(this.mState != v1) {
                    return;
                }

                this.show();
                if(this.mDragState == 1) {
                    this.horizontalScrollTo(arg6.getX());
                }

                if(this.mDragState != v1) {
                    return;
                }

                this.verticalScrollTo(arg6.getY());
            }
        }
    }

    void requestRedraw() {
        this.mRecyclerView.invalidate();
    }

    private void resetHideDelay(int arg4) {
        this.cancelHide();
        this.mRecyclerView.postDelayed(this.mHideRunnable, ((long)arg4));
    }

    private int scrollTo(float arg2, float arg3, int[] arg4, int arg5, int arg6, int arg7) {
        int v1 = arg4[1] - arg4[0];
        if(v1 == 0) {
            return 0;
        }

        arg5 -= arg7;
        v1 = ((int)((arg3 - arg2) / (((float)v1)) * (((float)arg5))));
        arg6 += v1;
        if(arg6 < arg5 && arg6 >= 0) {
            return v1;
        }

        return 0;
    }

    void setState(int arg4) {
        int v0 = 2;
        if(arg4 == v0 && this.mState != v0) {
            this.mVerticalThumbDrawable.setState(FastScroller.PRESSED_STATE_SET);
            this.cancelHide();
        }

        if(arg4 == 0) {
            this.requestRedraw();
        }
        else {
            this.show();
        }

        if(this.mState == v0 && arg4 != v0) {
            this.mVerticalThumbDrawable.setState(FastScroller.EMPTY_STATE_SET);
            this.resetHideDelay(1200);
        }
        else if(arg4 == 1) {
            this.resetHideDelay(1500);
        }

        this.mState = arg4;
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(((ItemDecoration)this));
        this.mRecyclerView.addOnItemTouchListener(((OnItemTouchListener)this));
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
    }

    public void show() {
        int v0 = this.mAnimationState;
        if(v0 != 0) {
            if(v0 != 3) {
                return;
            }
            else {
                this.mShowHideAnimator.cancel();
            }
        }

        this.mAnimationState = 1;
        this.mShowHideAnimator.setFloatValues(new float[]{this.mShowHideAnimator.getAnimatedValue().floatValue(), 1f});
        this.mShowHideAnimator.setDuration(500);
        this.mShowHideAnimator.setStartDelay(0);
        this.mShowHideAnimator.start();
    }

    void updateScrollPosition(int arg9, int arg10) {
        int v0 = this.mRecyclerView.computeVerticalScrollRange();
        int v1 = this.mRecyclerViewHeight;
        boolean v2 = v0 - v1 <= 0 || v1 < this.mScrollbarMinimumRange ? false : true;
        this.mNeedVerticalScrollbar = v2;
        int v2_1 = this.mRecyclerView.computeHorizontalScrollRange();
        int v5 = this.mRecyclerViewWidth;
        boolean v6 = v2_1 - v5 <= 0 || v5 < this.mScrollbarMinimumRange ? false : true;
        this.mNeedHorizontalScrollbar = v6;
        boolean v7 = this.mNeedVerticalScrollbar;
        if((v7) || (v6)) {
            float v3 = 2f;
            if(v7) {
                float v6_1 = ((float)v1);
                this.mVerticalThumbCenterY = ((int)(v6_1 * ((((float)arg10)) + v6_1 / v3) / (((float)v0))));
                this.mVerticalThumbHeight = Math.min(v1, v1 * v1 / v0);
            }

            if(this.mNeedHorizontalScrollbar) {
                float v10 = ((float)v5);
                this.mHorizontalThumbCenterX = ((int)(v10 * ((((float)arg9)) + v10 / v3) / (((float)v2_1))));
                this.mHorizontalThumbWidth = Math.min(v5, v5 * v5 / v2_1);
            }

            arg9 = this.mState;
            if(arg9 != 0) {
                if(arg9 == 1) {
                }
                else {
                    return;
                }
            }

            goto label_66;
        }
        else if(this.mState != 0) {
            this.setState(0);
            return;
        }

        return;
    label_66:
        this.setState(1);
    }

    private void verticalScrollTo(float arg9) {
        int[] v3 = this.getVerticalRange();
        float v2 = Math.max(((float)v3[0]), Math.min(((float)v3[1]), arg9));
        if(Math.abs((((float)this.mVerticalThumbCenterY)) - v2) < 2f) {
            return;
        }

        FastScroller v0 = this;
        int v8 = v0.scrollTo(this.mVerticalDragY, v2, v3, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
        if(v8 != 0) {
            v0.mRecyclerView.scrollBy(0, v8);
        }

        v0.mVerticalDragY = v2;
    }
}

