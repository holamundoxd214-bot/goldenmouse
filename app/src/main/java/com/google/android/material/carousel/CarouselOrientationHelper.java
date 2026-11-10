package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;

abstract class CarouselOrientationHelper {
    final int orientation;

    private CarouselOrientationHelper(int arg1) {
        super();
        this.orientation = arg1;
    }

    CarouselOrientationHelper(int arg1, com.google.android.material.carousel.CarouselOrientationHelper$1 arg2) {
        this(arg1);
    }

    abstract void containMaskWithinBounds(RectF arg1, RectF arg2, RectF arg3);

    private static CarouselOrientationHelper createHorizontalHelper(CarouselLayoutManager arg2) {
        return new CarouselOrientationHelper(0, arg2) {
            public void containMaskWithinBounds(RectF arg2, RectF arg3, RectF arg4) {
                float v1;
                if(arg3.left < arg4.left && arg3.right > arg4.left) {
                    v1 = arg4.left - arg3.left;
                    arg2.left += v1;
                    arg3.left += v1;
                }

                if(arg3.right > arg4.right && arg3.left < arg4.right) {
                    v1 = arg3.right - arg4.right;
                    arg2.right = Math.max(arg2.right - v1, arg2.left);
                    arg3.right = Math.max(arg3.right - v1, arg3.left);
                }
            }

            public float getMaskMargins(LayoutParams arg1) {
                return ((float)(arg1.rightMargin + arg1.leftMargin));
            }

            public RectF getMaskRect(float arg1, float arg2, float arg3, float arg4) {
                return new RectF(arg4, 0f, arg2 - arg4, arg1);
            }

            int getParentBottom() {
                return this.val$carouselLayoutManager.getHeight() - this.val$carouselLayoutManager.getPaddingBottom();
            }

            int getParentEnd() {
                if(this.val$carouselLayoutManager.isLayoutRtl()) {
                    return this.getParentLeft();
                }

                return this.getParentRight();
            }

            int getParentLeft() {
                return 0;
            }

            int getParentRight() {
                return this.val$carouselLayoutManager.getWidth();
            }

            int getParentStart() {
                if(this.val$carouselLayoutManager.isLayoutRtl()) {
                    return this.getParentRight();
                }

                return this.getParentLeft();
            }

            int getParentTop() {
                return this.val$carouselLayoutManager.getPaddingTop();
            }

            public void layoutDecoratedWithMargins(View arg7, int arg8, int arg9) {
                this.val$carouselLayoutManager.layoutDecoratedWithMargins(arg7, arg8, this.getParentTop(), arg9, this.getParentBottom());
            }

            public void moveMaskOnEdgeOutsideBounds(RectF arg4, RectF arg5, RectF arg6) {
                float v0 = 1f;
                if(Float.compare(arg5.right, arg6.left) <= 0) {
                    arg4.right = (((float)Math.floor(((double)arg4.right)))) - v0;
                    arg4.left = Math.min(arg4.left, arg4.right);
                }

                if(arg5.left >= arg6.right) {
                    arg4.left = (((float)Math.ceil(((double)arg4.left)))) + v0;
                    arg4.right = Math.max(arg4.left, arg4.right);
                }
            }

            public void offsetChild(View arg1, Rect arg2, float arg3, float arg4) {
                arg1.offsetLeftAndRight(((int)(arg4 - ((((float)arg2.left)) + arg3))));
            }
        };
    }

    static CarouselOrientationHelper createOrientationHelper(CarouselLayoutManager arg1, int arg2) {
        if(arg2 != 0) {
            if(arg2 == 1) {
                return CarouselOrientationHelper.createVerticalHelper(arg1);
            }

            throw new IllegalArgumentException("invalid orientation");
        }

        return CarouselOrientationHelper.createHorizontalHelper(arg1);
    }

    private static CarouselOrientationHelper createVerticalHelper(CarouselLayoutManager arg2) {
        return new CarouselOrientationHelper(1, arg2) {
            public void containMaskWithinBounds(RectF arg2, RectF arg3, RectF arg4) {
                float v1;
                if(arg3.top < arg4.top && arg3.bottom > arg4.top) {
                    v1 = arg4.top - arg3.top;
                    arg2.top += v1;
                    arg4.top += v1;
                }

                if(arg3.bottom > arg4.bottom && arg3.top < arg4.bottom) {
                    v1 = arg3.bottom - arg4.bottom;
                    arg2.bottom = Math.max(arg2.bottom - v1, arg2.top);
                    arg3.bottom = Math.max(arg3.bottom - v1, arg3.top);
                }
            }

            public float getMaskMargins(LayoutParams arg1) {
                return ((float)(arg1.topMargin + arg1.bottomMargin));
            }

            public RectF getMaskRect(float arg1, float arg2, float arg3, float arg4) {
                return new RectF(0f, arg3, arg2, arg1 - arg3);
            }

            int getParentBottom() {
                return this.val$carouselLayoutManager.getHeight();
            }

            int getParentEnd() {
                return this.getParentBottom();
            }

            int getParentLeft() {
                return this.val$carouselLayoutManager.getPaddingLeft();
            }

            int getParentRight() {
                return this.val$carouselLayoutManager.getWidth() - this.val$carouselLayoutManager.getPaddingRight();
            }

            int getParentStart() {
                return this.getParentTop();
            }

            int getParentTop() {
                return 0;
            }

            public void layoutDecoratedWithMargins(View arg7, int arg8, int arg9) {
                this.val$carouselLayoutManager.layoutDecoratedWithMargins(arg7, this.getParentLeft(), arg8, this.getParentRight(), arg9);
            }

            public void moveMaskOnEdgeOutsideBounds(RectF arg4, RectF arg5, RectF arg6) {
                float v0 = 1f;
                if(Float.compare(arg5.bottom, arg6.top) <= 0) {
                    arg4.bottom = (((float)Math.floor(((double)arg4.bottom)))) - v0;
                    arg4.top = Math.min(arg4.top, arg4.bottom);
                }

                if(arg5.top >= arg6.bottom) {
                    arg4.top = (((float)Math.ceil(((double)arg4.top)))) + v0;
                    arg4.bottom = Math.max(arg4.top, arg4.bottom);
                }
            }

            public void offsetChild(View arg1, Rect arg2, float arg3, float arg4) {
                arg1.offsetTopAndBottom(((int)(arg4 - ((((float)arg2.top)) + arg3))));
            }
        };
    }

    abstract float getMaskMargins(LayoutParams arg1);

    abstract RectF getMaskRect(float arg1, float arg2, float arg3, float arg4);

    abstract int getParentBottom();

    abstract int getParentEnd();

    abstract int getParentLeft();

    abstract int getParentRight();

    abstract int getParentStart();

    abstract int getParentTop();

    abstract void layoutDecoratedWithMargins(View arg1, int arg2, int arg3);

    abstract void moveMaskOnEdgeOutsideBounds(RectF arg1, RectF arg2, RectF arg3);

    abstract void offsetChild(View arg1, Rect arg2, float arg3, float arg4);
}

