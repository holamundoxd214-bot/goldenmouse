package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.widget.NestedScrollView$OnScrollChangeListener;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

class TouchResponse {
    private static final boolean DEBUG = false;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final float[][] TOUCH_DIRECTION = null;
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final float[][] TOUCH_SIDES = null;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP;
    private float[] mAnchorDpDt;
    private float mDragScale;
    private boolean mDragStarted;
    private float mDragThreshold;
    private int mFlags;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private final MotionLayout mMotionLayout;
    private boolean mMoveWhenScrollAtTop;
    private int mOnTouchUp;
    private int mTouchAnchorId;
    private int mTouchAnchorSide;
    private float mTouchAnchorX;
    private float mTouchAnchorY;
    private float mTouchDirectionX;
    private float mTouchDirectionY;
    private int mTouchRegionId;
    private int mTouchSide;

    static {
        TouchResponse.TOUCH_SIDES = new float[][]{new float[]{0.5f, 0f}, new float[]{0f, 0.5f}, new float[]{1f, 0.5f}, new float[]{0.5f, 1f}, new float[]{0.5f, 0.5f}, new float[]{0f, 0.5f}, new float[]{1f, 0.5f}};
        TouchResponse.TOUCH_DIRECTION = new float[][]{new float[]{0f, -1f}, new float[]{0f, 1f}, new float[]{-1f, 0f}, new float[]{1f, 0f}, new float[]{-1f, 0f}, new float[]{1f, 0f}};
    }

    TouchResponse(Context arg4, MotionLayout arg5, XmlPullParser arg6) {
        super();
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mTouchDirectionX = 0f;
        this.mTouchDirectionY = 1f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mMaxVelocity = 4f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1f;
        this.mFlags = 0;
        this.mDragThreshold = 10f;
        this.mMotionLayout = arg5;
        this.fillFromAttributeList(arg4, Xml.asAttributeSet(arg6));
    }

    float dot(float arg2, float arg3) {
        return arg2 * this.mTouchDirectionX + arg3 * this.mTouchDirectionY;
    }

    private void fill(TypedArray arg7) {
        float[] v3_1;
        int v0 = arg7.getIndexCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            int v3 = arg7.getIndex(v2);
            if(v3 == styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = arg7.getResourceId(v3, this.mTouchAnchorId);
            }
            else if(v3 == styleable.OnSwipe_touchAnchorSide) {
                v3 = arg7.getInt(v3, this.mTouchAnchorSide);
                this.mTouchAnchorSide = v3;
                v3_1 = TouchResponse.TOUCH_SIDES[v3];
                this.mTouchAnchorX = v3_1[0];
                this.mTouchAnchorY = v3_1[1];
            }
            else if(v3 == styleable.OnSwipe_dragDirection) {
                v3 = arg7.getInt(v3, this.mTouchSide);
                this.mTouchSide = v3;
                v3_1 = TouchResponse.TOUCH_DIRECTION[v3];
                this.mTouchDirectionX = v3_1[0];
                this.mTouchDirectionY = v3_1[1];
            }
            else if(v3 == styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = arg7.getFloat(v3, this.mMaxVelocity);
            }
            else if(v3 == styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = arg7.getFloat(v3, this.mMaxAcceleration);
            }
            else if(v3 == styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = arg7.getBoolean(v3, this.mMoveWhenScrollAtTop);
            }
            else if(v3 == styleable.OnSwipe_dragScale) {
                this.mDragScale = arg7.getFloat(v3, this.mDragScale);
            }
            else if(v3 == styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = arg7.getFloat(v3, this.mDragThreshold);
            }
            else if(v3 == styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = arg7.getResourceId(v3, this.mTouchRegionId);
            }
            else if(v3 == styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = arg7.getInt(v3, this.mOnTouchUp);
            }
            else if(v3 == styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = arg7.getInteger(v3, 0);
            }
            else if(v3 == styleable.OnSwipe_limitBoundsTo) {
                this.mLimitBoundsTo = arg7.getResourceId(v3, 0);
            }
        }
    }

    private void fillFromAttributeList(Context arg2, AttributeSet arg3) {
        TypedArray v2 = arg2.obtainStyledAttributes(arg3, styleable.OnSwipe);
        this.fill(v2);
        v2.recycle();
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getFlags() {
        return this.mFlags;
    }

    RectF getLimitBoundsTo(ViewGroup arg3, RectF arg4) {
        int v2 = this.mLimitBoundsTo;
        RectF v1 = null;
        if(v2 == -1) {
            return v1;
        }

        View v2_1 = arg3.findViewById(v2);
        if(v2_1 == null) {
            return v1;
        }

        arg4.set(((float)v2_1.getLeft()), ((float)v2_1.getTop()), ((float)v2_1.getRight()), ((float)v2_1.getBottom()));
        return arg4;
    }

    int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    float getProgressDirection(float arg8, float arg9) {
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, this.mMotionLayout.getProgress(), this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float v0 = this.mTouchDirectionX;
        int v2 = Float.compare(v0, 0f);
        float[] v3 = this.mAnchorDpDt;
        float v4 = 1.000000E-07f;
        if(v2 != 0) {
            if(v3[0] == 0f) {
                v3[0] = v4;
            }

            return arg8 * v0 / v3[0];
        }

        if(v3[1] == 0f) {
            v3[1] = v4;
        }

        return arg9 * this.mTouchDirectionY / v3[1];
    }

    RectF getTouchRegion(ViewGroup arg3, RectF arg4) {
        int v2 = this.mTouchRegionId;
        RectF v1 = null;
        if(v2 == -1) {
            return v1;
        }

        View v2_1 = arg3.findViewById(v2);
        if(v2_1 == null) {
            return v1;
        }

        arg4.set(((float)v2_1.getLeft()), ((float)v2_1.getTop()), ((float)v2_1.getRight()), ((float)v2_1.getBottom()));
        return arg4;
    }

    int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    void processTouchEvent(MotionEvent arg19, MotionTracker arg20, int arg21, MotionScene arg22) {
        float v1_1;
        float[] v5_2;
        float[] v11;
        float v5_1;
        float v3_1;
        TouchResponse v0 = this;
        MotionTracker v1 = arg20;
        MotionEvent v2 = arg19;
        v1.addMovement(v2);
        int v3 = v2.getAction();
        if(v3 == 0) {
            goto label_186;
        }

        int v5 = -1;
        int v6 = 1000;
        float v7 = 1f;
        if(v3 == 1) {
            v0.mDragStarted = false;
            v1.computeCurrentVelocity(v6);
            float v2_1 = v1.getXVelocity();
            v1_1 = v1.getYVelocity();
            float v12_1 = v0.mMotionLayout.getProgress();
            int v11_1 = v0.mTouchAnchorId;
            MotionLayout v10_1 = v0.mMotionLayout;
            if(v11_1 != v5) {
                v10_1.getAnchorDpDt(v11_1, v12_1, v0.mTouchAnchorX, v0.mTouchAnchorY, v0.mAnchorDpDt);
            }
            else {
                v3_1 = ((float)Math.min(v10_1.getWidth(), v0.mMotionLayout.getHeight()));
                v5_2 = v0.mAnchorDpDt;
                v5_2[1] = v0.mTouchDirectionY * v3_1;
                v5_2[0] = v3_1 * v0.mTouchDirectionX;
            }

            v3_1 = v0.mTouchDirectionX;
            v5_2 = v0.mAnchorDpDt;
            float v4 = v5_2[0];
            v5_1 = v5_2[1];
            if(v3_1 != 0f) {
                v2_1 /= v4;
            }
            else {
                v2_1 = v1_1 / v5_1;
            }

            v1_1 = !Float.isNaN(v2_1) ? v2_1 / 3f + v12_1 : v12_1;
            if(v1_1 != 0f && v1_1 != v7) {
                v3 = v0.mOnTouchUp;
                if(v3 != 3) {
                    MotionLayout v4_1 = v0.mMotionLayout;
                    v1_1 = (((double)v1_1)) < 0.5 ? 0f : v7;
                    v4_1.touchAnimateTo(v3, v1_1, v2_1);
                    if(0f < v12_1 && v7 > v12_1) {
                        return;
                    }

                    v0.mMotionLayout.setState(TransitionState.FINISHED);
                    return;
                }
            }

            if(0f < v1_1) {
                if(v7 <= v1_1) {
                }
                else {
                    return;
                }
            }

            goto label_182;
        }
        else if(v3 != 2) {
        }
        else {
            v3_1 = v2.getRawY() - v0.mLastTouchY;
            float v10 = v2.getRawX() - v0.mLastTouchX;
            if(Math.abs(v0.mTouchDirectionX * v10 + v0.mTouchDirectionY * v3_1) <= v0.mDragThreshold && !v0.mDragStarted) {
                return;
            }

            float v14 = v0.mMotionLayout.getProgress();
            if(!v0.mDragStarted) {
                v0.mDragStarted = true;
                v0.mMotionLayout.setProgress(v14);
            }

            int v13 = v0.mTouchAnchorId;
            MotionLayout v12 = v0.mMotionLayout;
            if(v13 != v5) {
                v12.getAnchorDpDt(v13, v14, v0.mTouchAnchorX, v0.mTouchAnchorY, v0.mAnchorDpDt);
            }
            else {
                v5_1 = ((float)Math.min(v12.getWidth(), v0.mMotionLayout.getHeight()));
                v11 = v0.mAnchorDpDt;
                v11[1] = v0.mTouchDirectionY * v5_1;
                v11[0] = v5_1 * v0.mTouchDirectionX;
            }

            if((((double)Math.abs((v0.mTouchDirectionX * v0.mAnchorDpDt[0] + v0.mTouchDirectionY * v0.mAnchorDpDt[1]) * v0.mDragScale))) < 0.01) {
                v5_2 = v0.mAnchorDpDt;
                v5_2[0] = 0.01f;
                v5_2[1] = 0.01f;
            }

            v5 = Float.compare(v0.mTouchDirectionX, 0f);
            v11 = v0.mAnchorDpDt;
            if(v5 != 0) {
                v10 /= v11[0];
            }
            else {
                v10 = v3_1 / v11[1];
            }

            v3_1 = Math.max(Math.min(v14 + v10, v7), 0f);
            v5 = Float.compare(v3_1, v0.mMotionLayout.getProgress());
            MotionLayout v7_1 = v0.mMotionLayout;
            if(v5 != 0) {
                v7_1.setProgress(v3_1);
                v1.computeCurrentVelocity(v6);
                v3_1 = v1.getXVelocity();
                v1_1 = v1.getYVelocity();
                v5 = Float.compare(v0.mTouchDirectionX, 0f);
                float[] v6_1 = v0.mAnchorDpDt;
                if(v5 != 0) {
                    v3_1 /= v6_1[0];
                }
                else {
                    v3_1 = v1_1 / v6_1[1];
                }

                v0.mMotionLayout.mLastVelocity = v3_1;
            }
            else {
                v7_1.mLastVelocity = 0f;
            }

            v0.mLastTouchX = v2.getRawX();
            v0.mLastTouchY = v2.getRawY();
            return;
        }

        return;
    label_182:
        v0.mMotionLayout.setState(TransitionState.FINISHED);
        return;
    label_186:
        v0.mLastTouchX = v2.getRawX();
        v0.mLastTouchY = v2.getRawY();
        v0.mDragStarted = false;
    }

    void scrollMove(float arg9, float arg10) {
        float v3 = this.mMotionLayout.getProgress();
        if(!this.mDragStarted) {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(v3);
        }

        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, v3, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        if((((double)Math.abs(this.mTouchDirectionX * this.mAnchorDpDt[0] + this.mTouchDirectionY * this.mAnchorDpDt[1]))) < 0.01) {
            float[] v0 = this.mAnchorDpDt;
            v0[0] = 0.01f;
            v0[1] = 0.01f;
        }

        float v0_1 = this.mTouchDirectionX;
        arg9 = v0_1 != 0f ? arg9 * v0_1 / this.mAnchorDpDt[0] : arg10 * this.mTouchDirectionY / this.mAnchorDpDt[1];
        arg9 = Math.max(Math.min(v3 + arg9, 1f), 0f);
        if(arg9 != this.mMotionLayout.getProgress()) {
            this.mMotionLayout.setProgress(arg9);
        }
    }

    void scrollUp(float arg10, float arg11) {
        int v0 = 0;
        this.mDragStarted = false;
        float v4 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, v4, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float v1 = this.mTouchDirectionX;
        float[] v2 = this.mAnchorDpDt;
        float v3 = v2[0];
        float v5 = this.mTouchDirectionY;
        float v2_1 = v2[1];
        float v7 = 0f;
        arg10 = v1 != 0f ? arg10 * v1 / v3 : arg11 * v5 / v2_1;
        if(!Float.isNaN(arg10)) {
            v4 += arg10 / 3f;
        }

        if(v4 != 0f) {
            arg11 = 1f;
            int v1_1 = v4 != arg11 ? 1 : 0;
            int v2_2 = this.mOnTouchUp;
            if(v2_2 != 3) {
                v0 = 1;
            }

            if((v0 & v1_1) == 0) {
                return;
            }

            MotionLayout v9 = this.mMotionLayout;
            if((((double)v4)) < 0.5) {
            }
            else {
                v7 = arg11;
            }

            v9.touchAnimateTo(v2_2, v7, arg10);
        }
    }

    public void setAnchorId(int arg1) {
        this.mTouchAnchorId = arg1;
    }

    void setDown(float arg1, float arg2) {
        this.mLastTouchX = arg1;
        this.mLastTouchY = arg2;
    }

    public void setMaxAcceleration(float arg1) {
        this.mMaxAcceleration = arg1;
    }

    public void setMaxVelocity(float arg1) {
        this.mMaxVelocity = arg1;
    }

    public void setRTL(boolean arg8) {
        float[][] v1_1;
        float[][] v8;
        int v0 = 6;
        int v1 = 3;
        int v2 = 4;
        int v4 = 5;
        int v5 = 2;
        if(arg8) {
            v8 = TouchResponse.TOUCH_DIRECTION;
            v8[v2] = v8[v1];
            v8[v4] = v8[v5];
            v1_1 = TouchResponse.TOUCH_SIDES;
            v1_1[v4] = v1_1[v5];
            v1_1[v0] = v1_1[1];
        }
        else {
            v8 = TouchResponse.TOUCH_DIRECTION;
            v8[v2] = v8[v5];
            v8[v4] = v8[v1];
            v1_1 = TouchResponse.TOUCH_SIDES;
            v1_1[v4] = v1_1[1];
            v1_1[v0] = v1_1[v5];
        }

        float[] v0_1 = v1_1[this.mTouchAnchorSide];
        this.mTouchAnchorX = v0_1[0];
        this.mTouchAnchorY = v0_1[1];
        float[] v8_1 = v8[this.mTouchSide];
        this.mTouchDirectionX = v8_1[0];
        this.mTouchDirectionY = v8_1[1];
    }

    public void setTouchAnchorLocation(float arg1, float arg2) {
        this.mTouchAnchorX = arg1;
        this.mTouchAnchorY = arg2;
    }

    void setUpTouchEvent(float arg1, float arg2) {
        this.mLastTouchX = arg1;
        this.mLastTouchY = arg2;
        this.mDragStarted = false;
    }

    void setupTouch() {
        View v0_1;
        int v0 = this.mTouchAnchorId;
        if(v0 != -1) {
            v0_1 = this.mMotionLayout.findViewById(v0);
            if(v0_1 == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
            }
        }
        else {
            v0_1 = null;
        }

        if((v0_1 instanceof NestedScrollView)) {
            ((NestedScrollView)v0_1).setOnTouchListener(new View$OnTouchListener() {
                public boolean onTouch(View arg1, MotionEvent arg2) {
                    return 0;
                }
            });
            ((NestedScrollView)v0_1).setOnScrollChangeListener(new OnScrollChangeListener() {
                public void onScrollChange(NestedScrollView arg1, int arg2, int arg3, int arg4, int arg5) {
                }
            });
        }
    }

    public String toString() {
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }
}

