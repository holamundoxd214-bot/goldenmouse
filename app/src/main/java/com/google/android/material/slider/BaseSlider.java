package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region$Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View$BaseSavedState;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$RangeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

abstract class BaseSlider extends View {
    class AccessibilityEventSender implements Runnable {
        int virtualViewId;

        AccessibilityEventSender(BaseSlider arg1, com.google.android.material.slider.BaseSlider$1 arg2) {
            this(arg1);
        }

        private AccessibilityEventSender(BaseSlider arg1) {
            BaseSlider.this = arg1;
            super();
            this.virtualViewId = -1;
        }

        public void run() {
            BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }

        void setVirtualViewId(int arg1) {
            this.virtualViewId = arg1;
        }
    }

    class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider slider;
        final Rect virtualViewBounds;

        AccessibilityHelper(BaseSlider arg2) {
            super(((View)arg2));
            this.virtualViewBounds = new Rect();
            this.slider = arg2;
        }

        protected int getVirtualViewAt(float arg5, float arg6) {
            int v0;
            for(v0 = 0; v0 < this.slider.getValues().size(); ++v0) {
                this.slider.updateBoundsForVirtualViewId(v0, this.virtualViewBounds);
                if(this.virtualViewBounds.contains(((int)arg5), ((int)arg6))) {
                    return v0;
                }
            }

            return -1;
        }

        protected void getVisibleVirtualViews(List arg3) {
            int v0;
            for(v0 = 0; v0 < this.slider.getValues().size(); ++v0) {
                arg3.add(Integer.valueOf(v0));
            }
        }

        protected boolean onPerformActionForVirtualView(int arg5, int arg6, Bundle arg7) {
            if(!this.slider.isEnabled()) {
                return 0;
            }

            int v3 = 0x2000;
            if(arg6 != 0x1000 && arg6 != v3) {
                if(arg6 != 0x102003D) {
                    return 0;
                }
                else {
                    if(arg7 != null) {
                        String v6 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
                        if(!arg7.containsKey(v6)) {
                        }
                        else if(this.slider.snapThumbToValue(arg5, arg7.getFloat(v6))) {
                            this.slider.updateHaloHotspot();
                            this.slider.postInvalidate();
                            this.invalidateVirtualView(arg5);
                            return 1;
                        }
                    }

                    return 0;
                }
            }

            float v7 = this.slider.calculateStepIncrement(20);
            if(arg6 == v3) {
                v7 = -v7;
            }

            if(this.slider.isRtl()) {
                v7 = -v7;
            }

            if(this.slider.snapThumbToValue(arg5, MathUtils.clamp(this.slider.getValues().get(arg5).floatValue() + v7, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                this.slider.updateHaloHotspot();
                this.slider.postInvalidate();
                this.invalidateVirtualView(arg5);
                return 1;
            }

            return 0;
        }

        protected void onPopulateNodeForVirtualView(int arg7, AccessibilityNodeInfoCompat arg8) {
            arg8.addAction(AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List v0 = this.slider.getValues();
            float v1 = v0.get(arg7).floatValue();
            float v2 = this.slider.getValueFrom();
            float v3 = this.slider.getValueTo();
            if(this.slider.isEnabled()) {
                if(v1 > v2) {
                    arg8.addAction(0x2000);
                }

                if(v1 >= v3) {
                    goto label_19;
                }

                arg8.addAction(0x1000);
            }

        label_19:
            arg8.setRangeInfo(RangeInfoCompat.obtain(1, v2, v3, v1));
            arg8.setClassName(SeekBar.class.getName());
            StringBuilder v2_1 = new StringBuilder();
            if(this.slider.getContentDescription() != null) {
                v2_1.append(this.slider.getContentDescription()).append(",");
            }

            String v1_1 = this.slider.formatValue(v1);
            String v3_1 = this.slider.getContext().getString(string.material_slider_value);
            if(v0.size() > 1) {
                v3_1 = this.startOrEndDescription(arg7);
            }

            v2_1.append(String.format(Locale.US, "%s, %s", v3_1, v1_1));
            arg8.setContentDescription(v2_1.toString());
            this.slider.updateBoundsForVirtualViewId(arg7, this.virtualViewBounds);
            arg8.setBoundsInParent(this.virtualViewBounds);
        }

        private String startOrEndDescription(int arg2) {
            if(arg2 == this.slider.getValues().size() - 1) {
                return this.slider.getContext().getString(string.material_slider_range_end);
            }

            if(arg2 == 0) {
                return this.slider.getContext().getString(string.material_slider_range_start);
            }

            return "";
        }
    }

    class SliderState extends View$BaseSavedState {
        class com.google.android.material.slider.BaseSlider$SliderState$1 implements Parcelable$Creator {
            com.google.android.material.slider.BaseSlider$SliderState$1() {
                super();
            }

            public SliderState createFromParcel(Parcel arg2) {
                return new SliderState(arg2, null);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public SliderState[] newArray(int arg1) {
                return new SliderState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList values;

        static {
            SliderState.CREATOR = new com.google.android.material.slider.BaseSlider$SliderState$1();
        }

        SliderState(Parcelable arg1) {
            super(arg1);
        }

        private SliderState(Parcel arg3) {
            super(arg3);
            this.valueFrom = arg3.readFloat();
            this.valueTo = arg3.readFloat();
            ArrayList v0 = new ArrayList();
            this.values = v0;
            arg3.readList(((List)v0), Float.class.getClassLoader());
            this.stepSize = arg3.readFloat();
            this.hasFocus = arg3.createBooleanArray()[0];
        }

        SliderState(Parcel arg1, com.google.android.material.slider.BaseSlider$1 arg2) {
            this(arg1);
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            arg2.writeFloat(this.valueFrom);
            arg2.writeFloat(this.valueTo);
            arg2.writeList(this.values);
            arg2.writeFloat(this.stepSize);
            arg2.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    private static final int DEFAULT_LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final int DEFAULT_LABEL_ANIMATION_EXIT_DURATION = 0x75;
    static final int DEF_STYLE_RES = 0;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION = "minSeparation(%s) must be greater or equal to 0";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE = "minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT = "minSeparation(%s) cannot be set as a dimension when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final int HALO_ALPHA = 0x3F;
    private static final int LABEL_ANIMATION_ENTER_DURATION_ATTR = 0;
    private static final int LABEL_ANIMATION_ENTER_EASING_ATTR = 0;
    private static final int LABEL_ANIMATION_EXIT_DURATION_ATTR = 0;
    private static final int LABEL_ANIMATION_EXIT_EASING_ATTR = 0;
    private static final int MIN_TOUCH_TARGET_DP = 0x30;
    private static final String TAG = "BaseSlider";
    private static final double THRESHOLD = 0.0001;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    static final int UNIT_PX = 0;
    static final int UNIT_VALUE = 1;
    private static final String WARNING_FLOATING_POINT_ERROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";
    private AccessibilityEventSender accessibilityEventSender;
    private final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;
    private final Paint activeTicksPaint;
    private final Paint activeTrackPaint;
    private final List changeListeners;
    private Drawable customThumbDrawable;
    private List customThumbDrawablesForValues;
    private final MaterialShapeDrawable defaultThumbDrawable;
    private int defaultThumbRadius;
    private int defaultTickActiveRadius;
    private int defaultTickInactiveRadius;
    private int defaultTrackHeight;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;
    private ColorStateList haloColor;
    private final Paint haloPaint;
    private int haloRadius;
    private final Paint inactiveTicksPaint;
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;
    private int labelPadding;
    private int labelStyle;
    private final List labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;
    private int minTouchTargetSize;
    private int minTrackSidePadding;
    private int minWidgetHeight;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;
    private boolean thumbIsPressed;
    private final Paint thumbPaint;
    private int thumbRadius;
    private int tickActiveRadius;
    private ColorStateList tickColorActive;
    private ColorStateList tickColorInactive;
    private int tickInactiveRadius;
    private boolean tickVisible;
    private float[] ticksCoordinates;
    private float touchDownX;
    private final List touchListeners;
    private float touchPosition;
    private ColorStateList trackColorActive;
    private ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList values;
    private int widgetHeight;

    static {
        BaseSlider.DEF_STYLE_RES = style.Widget_MaterialComponents_Slider;
        BaseSlider.LABEL_ANIMATION_ENTER_DURATION_ATTR = attr.motionDurationMedium4;
        BaseSlider.LABEL_ANIMATION_EXIT_DURATION_ATTR = attr.motionDurationShort3;
        BaseSlider.LABEL_ANIMATION_ENTER_EASING_ATTR = attr.motionEasingEmphasizedInterpolator;
        BaseSlider.LABEL_ANIMATION_EXIT_EASING_ATTR = attr.motionEasingEmphasizedAccelerateInterpolator;
    }

    public BaseSlider(Context arg2) {
        this(arg2, null);
    }

    public BaseSlider(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.sliderStyle);
    }

    public BaseSlider(Context arg6, AttributeSet arg7, int arg8) {
        super(MaterialThemeOverlay.wrap(arg6, arg7, arg8, BaseSlider.DEF_STYLE_RES), arg7, arg8);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.thumbIsPressed = false;
        this.values = new ArrayList();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0f;
        this.tickVisible = true;
        this.isLongPress = false;
        MaterialShapeDrawable v1 = new MaterialShapeDrawable();
        this.defaultThumbDrawable = v1;
        this.customThumbDrawablesForValues = Collections.emptyList();
        this.separationUnit = 0;
        arg6 = this.getContext();
        Paint v2 = new Paint();
        this.inactiveTrackPaint = v2;
        v2.setStyle(Paint$Style.STROKE);
        v2.setStrokeCap(Paint$Cap.ROUND);
        v2 = new Paint();
        this.activeTrackPaint = v2;
        v2.setStyle(Paint$Style.STROKE);
        v2.setStrokeCap(Paint$Cap.ROUND);
        v2 = new Paint(1);
        this.thumbPaint = v2;
        v2.setStyle(Paint$Style.FILL);
        v2.setXfermode(new PorterDuffXfermode(PorterDuff$Mode.CLEAR));
        v2 = new Paint(1);
        this.haloPaint = v2;
        v2.setStyle(Paint$Style.FILL);
        v2 = new Paint();
        this.inactiveTicksPaint = v2;
        v2.setStyle(Paint$Style.STROKE);
        v2.setStrokeCap(Paint$Cap.ROUND);
        v2 = new Paint();
        this.activeTicksPaint = v2;
        v2.setStyle(Paint$Style.STROKE);
        v2.setStrokeCap(Paint$Cap.ROUND);
        this.loadResources(arg6.getResources());
        this.processAttributes(arg6, arg7, arg8);
        this.setFocusable(true);
        this.setClickable(true);
        v1.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(arg6).getScaledTouchSlop();
        AccessibilityHelper v6 = new AccessibilityHelper(this);
        this.accessibilityHelper = v6;
        ViewCompat.setAccessibilityDelegate(((View)this), ((AccessibilityDelegateCompat)v6));
        this.accessibilityManager = this.getContext().getSystemService("accessibility");
    }

    static List access$000(BaseSlider arg0) {
        return arg0.labels;
    }

    static AccessibilityHelper access$200(BaseSlider arg0) {
        return arg0.accessibilityHelper;
    }

    static String access$400(BaseSlider arg0, float arg1) {
        return arg0.formatValue(arg1);
    }

    static boolean access$500(BaseSlider arg0, int arg1, float arg2) {
        return arg0.snapThumbToValue(arg1, arg2);
    }

    static void access$600(BaseSlider arg0) {
        arg0.updateHaloHotspot();
    }

    static float access$700(BaseSlider arg0, int arg1) {
        return arg0.calculateStepIncrement(arg1);
    }

    public void addOnChangeListener(BaseOnChangeListener arg1) {
        this.changeListeners.add(arg1);
    }

    public void addOnSliderTouchListener(BaseOnSliderTouchListener arg1) {
        this.touchListeners.add(arg1);
    }

    private void adjustCustomThumbDrawableBounds(Drawable arg5) {
        int v4 = this.thumbRadius * 2;
        int v0 = arg5.getIntrinsicWidth();
        int v1 = arg5.getIntrinsicHeight();
        int v3 = -1;
        if(v0 == v3 && v1 == v3) {
            arg5.setBounds(0, 0, v4, v4);
            return;
        }

        float v4_1 = (((float)v4)) / (((float)Math.max(v0, v1)));
        arg5.setBounds(0, 0, ((int)((((float)v0)) * v4_1)), ((int)((((float)v1)) * v4_1)));
    }

    private void attachLabelToContentView(TooltipDrawable arg1) {
        arg1.setRelativeToView(ViewUtils.getContentView(((View)this)));
    }

    private Float calculateIncrementForKey(int arg3) {
        float v0 = this.isLongPress ? this.calculateStepIncrement(20) : this.calculateStepIncrement();
        if(arg3 != 21) {
            if(arg3 != 22) {
                if(arg3 != 69) {
                    if(arg3 != 70 && arg3 != 81) {
                        return null;
                    }

                    return Float.valueOf(v0);
                }

                return Float.valueOf(-v0);
            }

            if(this.isRtl()) {
                v0 = -v0;
            }

            return Float.valueOf(v0);
        }

        if(this.isRtl()) {
        }
        else {
            v0 = -v0;
        }

        return Float.valueOf(v0);
    }

    private float calculateStepIncrement(int arg3) {
        float v0 = this.calculateStepIncrement();
        float v1 = (this.valueTo - this.valueFrom) / v0;
        float v2 = ((float)arg3);
        if(v1 <= v2) {
            return v0;
        }

        return (((float)Math.round(v1 / v2))) * v0;
    }

    private float calculateStepIncrement() {
        float v1 = this.stepSize;
        if(v1 == 0f) {
            v1 = 1f;
        }

        return v1;
    }

    private int calculateTrackCenter() {
        int v0 = this.widgetHeight / 2;
        int v3 = 0;
        if(this.labelBehavior == 1 || (this.shouldAlwaysShowLabel())) {
            v3 = this.labels.get(0).getIntrinsicHeight();
        }

        return v0 + v3;
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    private ValueAnimator createLabelAnimator(boolean arg5) {
        TimeInterpolator v1_1;
        int v5;
        float v0 = 0f;
        float v1 = 1f;
        float v2 = arg5 ? 0f : v1;
        ValueAnimator v3 = arg5 ? this.labelsOutAnimator : this.labelsInAnimator;
        v2 = BaseSlider.getAnimatorCurrentValueOrDefault(v3, v2);
        if(arg5) {
            v0 = v1;
        }

        ValueAnimator v0_1 = ValueAnimator.ofFloat(new float[]{v2, v0});
        if(arg5) {
            v5 = MotionUtils.resolveThemeDuration(this.getContext(), BaseSlider.LABEL_ANIMATION_ENTER_DURATION_ATTR, 83);
            v1_1 = MotionUtils.resolveThemeInterpolator(this.getContext(), BaseSlider.LABEL_ANIMATION_ENTER_EASING_ATTR, AnimationUtils.DECELERATE_INTERPOLATOR);
        }
        else {
            v5 = MotionUtils.resolveThemeDuration(this.getContext(), BaseSlider.LABEL_ANIMATION_EXIT_DURATION_ATTR, 0x75);
            v1_1 = MotionUtils.resolveThemeInterpolator(this.getContext(), BaseSlider.LABEL_ANIMATION_EXIT_EASING_ATTR, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        }

        v0_1.setDuration(((long)v5));
        v0_1.setInterpolator(v1_1);
        v0_1.addUpdateListener(new ValueAnimator$AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator arg3) {
                float v3 = arg3.getAnimatedValue().floatValue();
                Iterator v0 = BaseSlider.this.labels.iterator();
                while(v0.hasNext()) {
                    v0.next().setRevealFraction(v3);
                }

                ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
            }
        });
        return v0_1;
    }

    private void createLabelPool() {
        int v2_1;
        if(this.labels.size() > this.values.size()) {
            List v0 = this.labels.subList(this.values.size(), this.labels.size());
            Iterator v1 = v0.iterator();
            while(v1.hasNext()) {
                Object v2 = v1.next();
                if(!ViewCompat.isAttachedToWindow(((View)this))) {
                    continue;
                }

                this.detachLabelFromContentView(((TooltipDrawable)v2));
            }

            v0.clear();
        }

        while(true) {
            v2_1 = 0;
            if(this.labels.size() >= this.values.size()) {
                break;
            }

            TooltipDrawable v0_1 = TooltipDrawable.createFromAttributes(this.getContext(), null, 0, this.labelStyle);
            this.labels.add(v0_1);
            if(!ViewCompat.isAttachedToWindow(((View)this))) {
                continue;
            }

            this.attachLabelToContentView(v0_1);
        }

        if(this.labels.size() == 1) {
        }
        else {
            v2_1 = 1;
        }

        Iterator v4 = this.labels.iterator();
        while(v4.hasNext()) {
            v4.next().setStrokeWidth(((float)v2_1));
        }
    }

    private void detachLabelFromContentView(TooltipDrawable arg2) {
        ViewOverlayImpl v0 = ViewUtils.getContentViewOverlay(((View)this));
        if(v0 != null) {
            v0.remove(((Drawable)arg2));
            arg2.detachView(ViewUtils.getContentView(((View)this)));
        }
    }

    private float dimenToValue(float arg3) {
        if(arg3 == 0f) {
            return 0;
        }

        return (arg3 - (((float)this.trackSidePadding))) / (((float)this.trackWidth)) * (this.valueFrom - this.valueTo) + this.valueFrom;
    }

    public boolean dispatchHoverEvent(MotionEvent arg2) {
        if(!this.accessibilityHelper.dispatchHoverEvent(arg2)) {
            if(super.dispatchHoverEvent(arg2)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean dispatchKeyEvent(KeyEvent arg1) {
        return super.dispatchKeyEvent(arg1);
    }

    private void dispatchOnChangedFromUser(int arg5) {
        Iterator v0 = this.changeListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onValueChange(this, this.values.get(arg5).floatValue(), true);
        }

        AccessibilityManager v0_1 = this.accessibilityManager;
        if(v0_1 != null && (v0_1.isEnabled())) {
            this.scheduleAccessibilityEventSender(arg5);
        }
    }

    private void dispatchOnChangedProgrammatically() {
        Iterator v0 = this.changeListeners.iterator();
    label_2:
        if(v0.hasNext()) {
            Object v1 = v0.next();
            Iterator v2 = this.values.iterator();
            while(true) {
                if(!v2.hasNext()) {
                    goto label_2;
                }

                ((BaseOnChangeListener)v1).onValueChange(this, v2.next().floatValue(), false);
            }
        }
    }

    private void drawActiveTrack(Canvas arg11, int arg12, int arg13) {
        float[] v0 = this.getActiveRange();
        float v12 = ((float)arg12);
        float v6 = ((float)arg13);
        arg11.drawLine((((float)this.trackSidePadding)) + v0[0] * v12, v6, (((float)this.trackSidePadding)) + v0[1] * v12, v6, this.activeTrackPaint);
    }

    private void drawInactiveTrack(Canvas arg21, int arg22, int arg23) {
        BaseSlider v0 = this;
        int v1 = arg22;
        int v2 = arg23;
        float[] v3 = v0.getActiveRange();
        int v4 = v0.trackSidePadding;
        float v7 = ((float)v1);
        float v9 = (((float)v4)) + v3[1] * v7;
        if(v9 < (((float)(v4 + v1)))) {
            float v10 = ((float)v2);
            arg21.drawLine(v9, v10, ((float)(v4 + v1)), v10, v0.inactiveTrackPaint);
        }

        v1 = v0.trackSidePadding;
        float v17 = (((float)v1)) + v3[0] * v7;
        if(v17 > (((float)v1))) {
            float v15 = ((float)v1);
            float v1_1 = ((float)v2);
            arg21.drawLine(v15, v1_1, v17, v1_1, v0.inactiveTrackPaint);
        }
    }

    private void drawThumbDrawable(Canvas arg2, int arg3, int arg4, float arg5, Drawable arg6) {
        arg2.save();
        arg2.translate((((float)(this.trackSidePadding + (((int)(this.normalizeValue(arg5) * (((float)arg3)))))))) - (((float)arg6.getBounds().width())) / 2f, (((float)arg4)) - (((float)arg6.getBounds().height())) / 2f);
        arg6.draw(arg2);
        arg2.restore();
    }

    private void drawThumbs(Canvas arg9, int arg10, int arg11) {
        int v5;
        int v4;
        Canvas v3;
        BaseSlider v2;
        int v0 = 0;
        while(v0 < this.values.size()) {
            float v6 = this.values.get(v0).floatValue();
            Drawable v7 = this.customThumbDrawable;
            if(v7 != null) {
                v2 = this;
                v3 = arg9;
                v4 = arg10;
                v5 = arg11;
                v2.drawThumbDrawable(v3, v4, v5, v6, v7);
            }
            else {
                v2 = this;
                v3 = arg9;
                v4 = arg10;
                v5 = arg11;
                if(v0 < v2.customThumbDrawablesForValues.size()) {
                    v2.drawThumbDrawable(v3, v4, v5, v6, v2.customThumbDrawablesForValues.get(v0));
                }
                else {
                    if(!v2.isEnabled()) {
                        v3.drawCircle((((float)v2.trackSidePadding)) + v2.normalizeValue(v6) * (((float)v4)), ((float)v5), ((float)v2.thumbRadius), v2.thumbPaint);
                    }

                    v2.drawThumbDrawable(v3, v4, v5, v6, v2.defaultThumbDrawable);
                }
            }

            ++v0;
            this = v2;
            arg9 = v3;
            arg10 = v4;
            arg11 = v5;
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(this.getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(this.getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(this.getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(this.getColorForState(this.tickColorActive));
        Iterator v0 = this.labels.iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            if(!((TooltipDrawable)v1).isStateful()) {
                continue;
            }

            ((TooltipDrawable)v1).setState(this.getDrawableState());
        }

        if(this.defaultThumbDrawable.isStateful()) {
            this.defaultThumbDrawable.setState(this.getDrawableState());
        }

        this.haloPaint.setColor(this.getColorForState(this.haloColor));
        this.haloPaint.setAlpha(0x3F);
    }

    private void ensureLabelsAdded() {
        if(this.labelBehavior == 2) {
            return;
        }

        if(!this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = true;
            ValueAnimator v0 = this.createLabelAnimator(true);
            this.labelsInAnimator = v0;
            this.labelsOutAnimator = null;
            v0.start();
        }

        Iterator v0_1 = this.labels.iterator();
        int v1;
        for(v1 = 0; v1 < this.values.size(); ++v1) {
            if(!v0_1.hasNext()) {
                break;
            }

            if(v1 == this.focusedThumbIdx) {
            }
            else {
                this.setValueForLabel(v0_1.next(), this.values.get(v1).floatValue());
            }
        }

        if(v0_1.hasNext()) {
            this.setValueForLabel(v0_1.next(), this.values.get(this.focusedThumbIdx).floatValue());
            return;
        }

        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())));
    }

    private void ensureLabelsRemoved() {
        if(this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            ValueAnimator v0 = this.createLabelAnimator(false);
            this.labelsOutAnimator = v0;
            this.labelsInAnimator = null;
            v0.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator arg2) {
                    super.onAnimationEnd(arg2);
                    ViewOverlayImpl v2 = ViewUtils.getContentViewOverlay(BaseSlider.this);
                    Iterator v1 = BaseSlider.this.labels.iterator();
                    while(v1.hasNext()) {
                        v2.remove(v1.next());
                    }
                }
            });
            this.labelsOutAnimator.start();
        }
    }

    private void focusThumbOnFocusGained(int arg4) {
        int v1 = 0x7FFFFFFF;
        if(arg4 != 1) {
            int v2 = 0x80000000;
            if(arg4 != 2) {
                if(arg4 != 17) {
                    if(arg4 != 66) {
                        return;
                    }

                    this.moveFocusInAbsoluteDirection(v2);
                    return;
                }

                this.moveFocusInAbsoluteDirection(v1);
                return;
            }

            this.moveFocus(v2);
            return;
        }

        this.moveFocus(v1);
    }

    void forceDrawCompatHalo(boolean arg1) {
        this.forceDrawCompatHalo = arg1;
    }

    private String formatValue(float arg2) {
        if(this.hasLabelFormatter()) {
            return this.formatter.getFormattedValue(arg2);
        }

        String v1 = (((float)(((int)arg2)))) == arg2 ? "%.0f" : "%.2f";
        return String.format(v1, Float.valueOf(arg2));
    }

    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    private float[] getActiveRange() {
        float[] v5;
        float v0 = Collections.max(this.getValues()).floatValue();
        float v1 = Collections.min(this.getValues()).floatValue();
        if(this.values.size() == 1) {
            v1 = this.valueFrom;
        }

        v1 = this.normalizeValue(v1);
        v0 = this.normalizeValue(v0);
        int v4 = 2;
        if(this.isRtl()) {
            v5 = new float[v4];
            v5[0] = v0;
            v5[1] = v1;
            return v5;
        }

        v5 = new float[v4];
        v5[0] = v1;
        v5[1] = v0;
        return v5;
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    private static float getAnimatorCurrentValueOrDefault(ValueAnimator arg1, float arg2) {
        if(arg1 != null && (arg1.isRunning())) {
            arg2 = arg1.getAnimatedValue().floatValue();
            arg1.cancel();
        }

        return arg2;
    }

    private float getClampedValue(int arg4, float arg5) {
        float v0 = this.getMinSeparation();
        if(this.separationUnit == 0) {
            v0 = this.dimenToValue(v0);
        }

        if(this.isRtl()) {
            v0 = -v0;
        }

        int v1 = arg4 + 1;
        float v1_1 = v1 >= this.values.size() ? this.valueTo : this.values.get(v1).floatValue() - v0;
        --arg4;
        float v3 = arg4 < 0 ? this.valueFrom : this.values.get(arg4).floatValue() + v0;
        return MathUtils.clamp(arg5, v3, v1_1);
    }

    private int getColorForState(ColorStateList arg2) {
        return arg2.getColorForState(this.getDrawableState(), arg2.getDefaultColor());
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    public int getHaloRadius() {
        return this.haloRadius;
    }

    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    protected float getMinSeparation() {
        return 0;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.defaultThumbDrawable.getElevation();
    }

    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.defaultThumbDrawable.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.defaultThumbDrawable.getStrokeWidth();
    }

    public ColorStateList getThumbTintList() {
        return this.defaultThumbDrawable.getFillColor();
    }

    public int getTickActiveRadius() {
        return this.tickActiveRadius;
    }

    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    public int getTickInactiveRadius() {
        return this.tickInactiveRadius;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    public ColorStateList getTickTintList() {
        if(this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }

        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    public int getTrackHeight() {
        return this.trackHeight;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public ColorStateList getTrackTintList() {
        if(this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }

        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    private float getValueOfTouchPosition() {
        double v0 = this.snapPosition(this.touchPosition);
        if(this.isRtl()) {
            v0 = 1 - v0;
        }

        return ((float)(v0 * (((double)(this.valueTo - this.valueFrom))) + (((double)this.valueFrom))));
    }

    private float getValueOfTouchPositionAbsolute() {
        float v0 = this.touchPosition;
        if(this.isRtl()) {
            v0 = 1f - v0;
        }

        return v0 * (this.valueTo - this.valueFrom) + this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    List getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        if(this.formatter != null) {
            return 1;
        }

        return 0;
    }

    private Drawable initializeCustomThumbDrawable(Drawable arg1) {
        arg1 = arg1.mutate().getConstantState().newDrawable();
        this.adjustCustomThumbDrawableBounds(arg1);
        return arg1;
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(((float)this.trackHeight));
        this.activeTrackPaint.setStrokeWidth(((float)this.trackHeight));
    }

    private boolean isInVerticalScrollingContainer() {
        ViewParent v3;
        for(v3 = this.getParent(); (v3 instanceof ViewGroup); v3 = v3.getParent()) {
            ViewParent v0 = v3;
            if(((((ViewGroup)v0).canScrollVertically(1)) || (((ViewGroup)v0).canScrollVertically(-1))) && (((ViewGroup)v0).shouldDelayChildPressedState())) {
                return 1;
            }
        }

        return 0;
    }

    private static boolean isMouseEvent(MotionEvent arg2) {
        if(arg2.getToolType(0) == 3) {
            return 1;
        }

        return 0;
    }

    private boolean isMultipleOfStepSize(float arg3) {
        double v2 = new BigDecimal(Float.toString(arg3)).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        if(Math.abs((((double)Math.round(v2))) - v2) < 0.0001) {
            return 1;
        }

        return 0;
    }

    private boolean isPotentialVerticalScroll(MotionEvent arg1) {
        if(!BaseSlider.isMouseEvent(arg1) && (this.isInVerticalScrollingContainer())) {
            return 1;
        }

        return 0;
    }

    final boolean isRtl() {
        if(ViewCompat.getLayoutDirection(((View)this)) == 1) {
            return 1;
        }

        return 0;
    }

    public boolean isTickVisible() {
        return this.tickVisible;
    }

    private void loadResources(Resources arg2) {
        this.minWidgetHeight = arg2.getDimensionPixelSize(dimen.mtrl_slider_widget_height);
        int v0 = arg2.getDimensionPixelOffset(dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = v0;
        this.trackSidePadding = v0;
        this.defaultThumbRadius = arg2.getDimensionPixelSize(dimen.mtrl_slider_thumb_radius);
        this.defaultTrackHeight = arg2.getDimensionPixelSize(dimen.mtrl_slider_track_height);
        this.defaultTickActiveRadius = arg2.getDimensionPixelSize(dimen.mtrl_slider_tick_radius);
        this.defaultTickInactiveRadius = arg2.getDimensionPixelSize(dimen.mtrl_slider_tick_radius);
        this.labelPadding = arg2.getDimensionPixelSize(dimen.mtrl_slider_label_padding);
    }

    private void maybeCalculateTicksCoordinates() {
        if(this.stepSize <= 0f) {
        }
        else {
            this.validateConfigurationIfDirty();
            int v0 = Math.min(((int)((this.valueTo - this.valueFrom) / this.stepSize + 1f)), this.trackWidth / (this.trackHeight * 2) + 1);
            float[] v1 = this.ticksCoordinates;
            if(v1 == null || v1.length != v0 * 2) {
                this.ticksCoordinates = new float[v0 * 2];
            }

            float v1_1 = (((float)this.trackWidth)) / (((float)(v0 - 1)));
            int v2;
            for(v2 = 0; v2 < v0 * 2; v2 += 2) {
                float[] v3 = this.ticksCoordinates;
                v3[v2] = (((float)this.trackSidePadding)) + (((float)v2)) / 2f * v1_1;
                v3[v2 + 1] = ((float)this.calculateTrackCenter());
            }
        }
    }

    private void maybeDrawCompatHalo(Canvas arg9, int arg10, int arg11) {
        Canvas v2;
        if(this.shouldDrawCompatHalo()) {
            arg10 = ((int)((((float)this.trackSidePadding)) + this.normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * (((float)arg10))));
            if(Build$VERSION.SDK_INT < 28) {
                v2 = arg9;
                v2.clipRect(((float)(arg10 - this.haloRadius)), ((float)(arg11 - this.haloRadius)), ((float)(arg10 + this.haloRadius)), ((float)(this.haloRadius + arg11)), Region$Op.UNION);
            }
            else {
                v2 = arg9;
            }

            v2.drawCircle(((float)arg10), ((float)arg11), ((float)this.haloRadius), this.haloPaint);
        }
    }

    private void maybeDrawTicks(Canvas arg6) {
        if(this.tickVisible) {
            if(this.stepSize <= 0f) {
            }
            else {
                float[] v0 = this.getActiveRange();
                int v1 = BaseSlider.pivotIndex(this.ticksCoordinates, v0[0]);
                int v0_1 = BaseSlider.pivotIndex(this.ticksCoordinates, v0[1]);
                v1 *= 2;
                arg6.drawPoints(this.ticksCoordinates, 0, v1, this.inactiveTicksPaint);
                v0_1 *= 2;
                arg6.drawPoints(this.ticksCoordinates, v1, v0_1 - v1, this.activeTicksPaint);
                arg6.drawPoints(this.ticksCoordinates, v0_1, this.ticksCoordinates.length - v0_1, this.inactiveTicksPaint);
            }
        }
    }

    private boolean maybeIncreaseTrackSidePadding() {
        int v5 = this.minTrackSidePadding + Math.max(Math.max(Math.max(this.thumbRadius - this.defaultThumbRadius, 0), Math.max((this.trackHeight - this.defaultTrackHeight) / 2, 0)), Math.max(Math.max(this.tickActiveRadius - this.defaultTickActiveRadius, 0), Math.max(this.tickInactiveRadius - this.defaultTickInactiveRadius, 0)));
        if(this.trackSidePadding == v5) {
            return 0;
        }

        this.trackSidePadding = v5;
        if(ViewCompat.isLaidOut(((View)this))) {
            this.updateTrackWidth(this.getWidth());
        }

        return 1;
    }

    private boolean maybeIncreaseWidgetHeight() {
        int v0 = Math.max(this.minWidgetHeight, Math.max(this.trackHeight + (this.getPaddingTop() + this.getPaddingBottom()), this.thumbRadius * 2 + this.getPaddingTop() + this.getPaddingBottom()));
        if(v0 == this.widgetHeight) {
            return 0;
        }

        this.widgetHeight = v0;
        return 1;
    }

    private boolean moveFocus(int arg12) {
        int v0 = this.focusedThumbIdx;
        arg12 = ((int)MathUtils.clamp((((long)v0)) + (((long)arg12)), 0, ((long)(this.values.size() - 1))));
        this.focusedThumbIdx = arg12;
        if(arg12 == v0) {
            return 0;
        }

        if(this.activeThumbIdx != -1) {
            this.activeThumbIdx = arg12;
        }

        this.updateHaloHotspot();
        this.postInvalidate();
        return 1;
    }

    private boolean moveFocusInAbsoluteDirection(int arg2) {
        if(this.isRtl()) {
            arg2 = arg2 == 0x80000000 ? 0x7FFFFFFF : -arg2;
        }

        return this.moveFocus(arg2);
    }

    private float normalizeValue(float arg3) {
        arg3 = (arg3 - this.valueFrom) / (this.valueTo - this.valueFrom);
        if(this.isRtl()) {
            return 1f - arg3;
        }

        return arg3;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator v0 = this.labels.iterator();
        while(v0.hasNext()) {
            this.attachLabelToContentView(v0.next());
        }
    }

    protected void onDetachedFromWindow() {
        AccessibilityEventSender v0 = this.accessibilityEventSender;
        if(v0 != null) {
            this.removeCallbacks(((Runnable)v0));
        }

        this.labelsAreAnimatedIn = false;
        Iterator v0_1 = this.labels.iterator();
        while(v0_1.hasNext()) {
            this.detachLabelFromContentView(v0_1.next());
        }

        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas arg4) {
        if(this.dirtyConfig) {
            this.validateConfigurationIfDirty();
            this.maybeCalculateTicksCoordinates();
        }

        super.onDraw(arg4);
        int v0 = this.calculateTrackCenter();
        this.drawInactiveTrack(arg4, this.trackWidth, v0);
        if(Collections.max(this.getValues()).floatValue() > this.valueFrom) {
            this.drawActiveTrack(arg4, this.trackWidth, v0);
        }

        this.maybeDrawTicks(arg4);
        if(((this.thumbIsPressed) || (this.isFocused())) && (this.isEnabled())) {
            this.maybeDrawCompatHalo(arg4, this.trackWidth, v0);
        }

        if(this.activeThumbIdx == -1 && !this.shouldAlwaysShowLabel()) {
            goto label_33;
        }
        else if(this.isEnabled()) {
            this.ensureLabelsAdded();
        }
        else {
        label_33:
            this.ensureLabelsRemoved();
        }

        this.drawThumbs(arg4, this.trackWidth, v0);
    }

    protected void onFocusChanged(boolean arg1, int arg2, Rect arg3) {
        super.onFocusChanged(arg1, arg2, arg3);
        if(!arg1) {
            this.activeThumbIdx = -1;
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
            return;
        }

        this.focusThumbOnFocusGained(arg2);
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    public boolean onKeyDown(int arg6, KeyEvent arg7) {
        if(!this.isEnabled()) {
            return super.onKeyDown(arg6, arg7);
        }

        if(this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }

        int v3 = -1;
        if(this.activeThumbIdx == v3) {
            Boolean v0 = this.onKeyDownNoActiveThumb(arg6, arg7);
            if(v0 != null) {
                return v0.booleanValue();
            }

            return super.onKeyDown(arg6, arg7);
        }

        this.isLongPress |= arg7.isLongPress();
        Float v0_1 = this.calculateIncrementForKey(arg6);
        if(v0_1 != null) {
            if(this.snapActiveThumbToValue(this.values.get(this.activeThumbIdx).floatValue() + v0_1.floatValue())) {
                this.updateHaloHotspot();
                this.postInvalidate();
            }

            return 1;
        }

        if(arg6 != 23) {
            if(arg6 != 61) {
                if(arg6 != 66) {
                    return super.onKeyDown(arg6, arg7);
                }
            }
            else if(arg7.hasNoModifiers()) {
                return this.moveFocus(1);
            }
            else if(arg7.isShiftPressed()) {
                return this.moveFocus(v3);
            }
            else {
                return 0;
            }
        }

        this.activeThumbIdx = v3;
        this.postInvalidate();
        return 1;
    }

    private Boolean onKeyDownNoActiveThumb(int arg5, KeyEvent arg6) {
        int v1 = -1;
        Boolean v3 = Boolean.valueOf(true);
        if(arg5 != 61) {
            if(arg5 != 66) {
                if(arg5 != 81) {
                    if(arg5 == 69) {
                        this.moveFocus(v1);
                        return v3;
                    }
                    else if(arg5 != 70) {
                        switch(arg5) {
                            case 21: {
                                goto label_18;
                            }
                            case 22: {
                                goto label_16;
                            }
                            case 23: {
                                goto label_24;
                            }
                        }

                        return null;
                    label_18:
                        this.moveFocusInAbsoluteDirection(v1);
                        return v3;
                    label_16:
                        this.moveFocusInAbsoluteDirection(1);
                        return v3;
                    }
                }

                this.moveFocus(1);
                return v3;
            }

        label_24:
            this.activeThumbIdx = this.focusedThumbIdx;
            this.postInvalidate();
            return v3;
        }

        if(arg6.hasNoModifiers()) {
            return Boolean.valueOf(this.moveFocus(1));
        }

        if(arg6.isShiftPressed()) {
            return Boolean.valueOf(this.moveFocus(v1));
        }

        return Boolean.valueOf(false);
    }

    public boolean onKeyUp(int arg2, KeyEvent arg3) {
        this.isLongPress = false;
        return super.onKeyUp(arg2, arg3);
    }

    protected void onMeasure(int arg4, int arg5) {
        arg5 = this.widgetHeight;
        int v2 = 0;
        if(this.labelBehavior == 1 || (this.shouldAlwaysShowLabel())) {
            v2 = this.labels.get(0).getIntrinsicHeight();
        }

        super.onMeasure(arg4, View$MeasureSpec.makeMeasureSpec(arg5 + v2, 0x40000000));
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        super.onRestoreInstanceState(((SliderState)arg2).getSuperState());
        this.valueFrom = ((SliderState)arg2).valueFrom;
        this.valueTo = ((SliderState)arg2).valueTo;
        this.setValuesInternal(((SliderState)arg2).values);
        this.stepSize = ((SliderState)arg2).stepSize;
        if(((SliderState)arg2).hasFocus) {
            this.requestFocus();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SliderState v1 = new SliderState(super.onSaveInstanceState());
        v1.valueFrom = this.valueFrom;
        v1.valueTo = this.valueTo;
        v1.values = new ArrayList(this.values);
        v1.stepSize = this.stepSize;
        v1.hasFocus = this.hasFocus();
        return ((Parcelable)v1);
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        this.updateTrackWidth(arg1);
        this.updateHaloHotspot();
    }

    private void onStartTrackingTouch() {
        Iterator v0 = this.touchListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        Iterator v0 = this.touchListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onStopTrackingTouch(this);
        }
    }

    public boolean onTouchEvent(MotionEvent arg6) {
        if(!this.isEnabled()) {
            return 0;
        }

        float v0 = arg6.getX();
        float v2 = (v0 - (((float)this.trackSidePadding))) / (((float)this.trackWidth));
        this.touchPosition = v2;
        v2 = Math.max(0f, v2);
        this.touchPosition = v2;
        this.touchPosition = Math.min(1f, v2);
        int v2_1 = arg6.getActionMasked();
        if(v2_1 != 0) {
            if(v2_1 != 1) {
                if(v2_1 == 2) {
                    if(!this.thumbIsPressed) {
                        if((this.isPotentialVerticalScroll(arg6)) && Math.abs(v0 - this.touchDownX) < (((float)this.scaledTouchSlop))) {
                            return 0;
                        }

                        this.getParent().requestDisallowInterceptTouchEvent(true);
                        this.onStartTrackingTouch();
                    }

                    if(!this.pickActiveThumb()) {
                        goto label_97;
                    }

                    this.thumbIsPressed = true;
                    this.snapTouchPosition();
                    this.updateHaloHotspot();
                    this.invalidate();
                    goto label_97;
                }
                else if(v2_1 != 3) {
                    goto label_97;
                }
            }

            this.thumbIsPressed = false;
            MotionEvent v0_1 = this.lastEvent;
            if(v0_1 != null && v0_1.getActionMasked() == 0 && Math.abs(this.lastEvent.getX() - arg6.getX()) <= (((float)this.scaledTouchSlop)) && Math.abs(this.lastEvent.getY() - arg6.getY()) <= (((float)this.scaledTouchSlop)) && (this.pickActiveThumb())) {
                this.onStartTrackingTouch();
            }

            int v1 = -1;
            if(this.activeThumbIdx != v1) {
                this.snapTouchPosition();
                this.updateHaloHotspot();
                this.activeThumbIdx = v1;
                this.onStopTrackingTouch();
            }

            this.invalidate();
        }
        else {
            this.touchDownX = v0;
            if(this.isPotentialVerticalScroll(arg6)) {
                goto label_97;
            }

            this.getParent().requestDisallowInterceptTouchEvent(true);
            if(!this.pickActiveThumb()) {
                goto label_97;
            }

            this.requestFocus();
            this.thumbIsPressed = true;
            this.snapTouchPosition();
            this.updateHaloHotspot();
            this.invalidate();
            this.onStartTrackingTouch();
        }

    label_97:
        this.setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(arg6);
        return 1;
    }

    protected void onVisibilityChanged(View arg1, int arg2) {
        super.onVisibilityChanged(arg1, arg2);
        if(arg2 != 0) {
            ViewOverlayImpl v1 = ViewUtils.getContentViewOverlay(((View)this));
            if(v1 == null) {
            }
            else {
                Iterator v0 = this.labels.iterator();
                while(v0.hasNext()) {
                    v1.remove(v0.next());
                }
            }
        }
    }

    protected boolean pickActiveThumb() {
        int v9;
        int v2 = -1;
        if(this.activeThumbIdx != v2) {
            return 1;
        }

        float v0 = this.getValueOfTouchPositionAbsolute();
        float v3 = this.valueToX(v0);
        this.activeThumbIdx = 0;
        float v5 = Math.abs(this.values.get(0).floatValue() - v0);
        int v6 = 1;
        while(v6 < this.values.size()) {
            float v7 = Math.abs(this.values.get(v6).floatValue() - v0);
            float v8 = this.valueToX(this.values.get(v6).floatValue());
            if(Float.compare(v7, v5) > 1) {
            }
            else {
                if(this.isRtl()) {
                    if(v8 - v3 > 0f) {
                        goto label_38;
                    }
                    else {
                        goto label_40;
                    }
                }
                else if(v8 - v3 < 0f) {
                label_38:
                    v9 = 1;
                }
                else {
                label_40:
                    v9 = 0;
                }

                if(Float.compare(v7, v5) < 0) {
                    this.activeThumbIdx = v6;
                    goto label_56;
                }
                else if(Float.compare(v7, v5) == 0) {
                    if(Math.abs(v8 - v3) < (((float)this.scaledTouchSlop))) {
                        this.activeThumbIdx = v2;
                        return 0;
                    }
                    else if(v9 != 0) {
                        this.activeThumbIdx = v6;
                    label_56:
                        v5 = v7;
                    }
                }

                ++v6;
                continue;
            }

            break;
        }

        if(this.activeThumbIdx != v2) {
            return 1;
        }

        return 0;
    }

    private static int pivotIndex(float[] arg0, float arg1) {
        return Math.round(arg1 * (((float)(arg0.length / 2 - 1))));
    }

    private void processAttributes(Context arg8, AttributeSet arg9, int arg10) {
        Context v0 = arg8;
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(v0, arg9, styleable.Slider, arg10, BaseSlider.DEF_STYLE_RES, new int[0]);
        this.labelStyle = v8.getResourceId(styleable.Slider_labelStyle, style.Widget_MaterialComponents_Tooltip);
        this.valueFrom = v8.getFloat(styleable.Slider_android_valueFrom, 0f);
        this.valueTo = v8.getFloat(styleable.Slider_android_valueTo, 1f);
        this.setValues(new Float[]{Float.valueOf(this.valueFrom)});
        this.stepSize = v8.getFloat(styleable.Slider_android_stepSize, 0f);
        this.minTouchTargetSize = ((int)Math.ceil(((double)v8.getDimension(styleable.Slider_minTouchTargetSize, ((float)Math.ceil(((double)ViewUtils.dpToPx(this.getContext(), 0x30))))))));
        boolean v1 = v8.hasValue(styleable.Slider_trackColor);
        int v2 = v1 ? styleable.Slider_trackColor : styleable.Slider_trackColorInactive;
        int v1_1 = v1 ? styleable.Slider_trackColor : styleable.Slider_trackColorActive;
        ColorStateList v2_1 = MaterialResources.getColorStateList(v0, v8, v2);
        if(v2_1 != null) {
        }
        else {
            v2_1 = AppCompatResources.getColorStateList(v0, color.material_slider_inactive_track_color);
        }

        this.setTrackInactiveTintList(v2_1);
        ColorStateList v1_2 = MaterialResources.getColorStateList(v0, v8, v1_1);
        if(v1_2 != null) {
        }
        else {
            v1_2 = AppCompatResources.getColorStateList(v0, color.material_slider_active_track_color);
        }

        this.setTrackActiveTintList(v1_2);
        this.defaultThumbDrawable.setFillColor(MaterialResources.getColorStateList(v0, v8, styleable.Slider_thumbColor));
        if(v8.hasValue(styleable.Slider_thumbStrokeColor)) {
            this.setThumbStrokeColor(MaterialResources.getColorStateList(v0, v8, styleable.Slider_thumbStrokeColor));
        }

        this.setThumbStrokeWidth(v8.getDimension(styleable.Slider_thumbStrokeWidth, 0f));
        v1_2 = MaterialResources.getColorStateList(v0, v8, styleable.Slider_haloColor);
        if(v1_2 != null) {
        }
        else {
            v1_2 = AppCompatResources.getColorStateList(v0, color.material_slider_halo_color);
        }

        this.setHaloTintList(v1_2);
        this.tickVisible = v8.getBoolean(styleable.Slider_tickVisible, true);
        v1 = v8.hasValue(styleable.Slider_tickColor);
        v2 = v1 ? styleable.Slider_tickColor : styleable.Slider_tickColorInactive;
        v1_1 = v1 ? styleable.Slider_tickColor : styleable.Slider_tickColorActive;
        v2_1 = MaterialResources.getColorStateList(v0, v8, v2);
        if(v2_1 != null) {
        }
        else {
            v2_1 = AppCompatResources.getColorStateList(v0, color.material_slider_inactive_tick_marks_color);
        }

        this.setTickInactiveTintList(v2_1);
        v1_2 = MaterialResources.getColorStateList(v0, v8, v1_1);
        if(v1_2 != null) {
        }
        else {
            v1_2 = AppCompatResources.getColorStateList(v0, color.material_slider_active_tick_marks_color);
        }

        this.setTickActiveTintList(v1_2);
        this.setThumbRadius(v8.getDimensionPixelSize(styleable.Slider_thumbRadius, 0));
        this.setHaloRadius(v8.getDimensionPixelSize(styleable.Slider_haloRadius, 0));
        this.setThumbElevation(v8.getDimension(styleable.Slider_thumbElevation, 0f));
        this.setTrackHeight(v8.getDimensionPixelSize(styleable.Slider_trackHeight, 0));
        this.setTickActiveRadius(v8.getDimensionPixelSize(styleable.Slider_tickRadiusActive, 0));
        this.setTickInactiveRadius(v8.getDimensionPixelSize(styleable.Slider_tickRadiusInactive, 0));
        this.setLabelBehavior(v8.getInt(styleable.Slider_labelBehavior, 0));
        if(!v8.getBoolean(styleable.Slider_android_enabled, true)) {
            this.setEnabled(false);
        }

        v8.recycle();
    }

    public void removeOnChangeListener(BaseOnChangeListener arg1) {
        this.changeListeners.remove(arg1);
    }

    public void removeOnSliderTouchListener(BaseOnSliderTouchListener arg1) {
        this.touchListeners.remove(arg1);
    }

    private void scheduleAccessibilityEventSender(int arg3) {
        AccessibilityEventSender v0 = this.accessibilityEventSender;
        if(v0 == null) {
            this.accessibilityEventSender = new AccessibilityEventSender(this, null);
        }
        else {
            this.removeCallbacks(((Runnable)v0));
        }

        this.accessibilityEventSender.setVirtualViewId(arg3);
        this.postDelayed(this.accessibilityEventSender, 200);
    }

    protected void setActiveThumbIndex(int arg1) {
        this.activeThumbIdx = arg1;
    }

    void setCustomThumbDrawable(int arg2) {
        this.setCustomThumbDrawable(this.getResources().getDrawable(arg2));
    }

    void setCustomThumbDrawable(Drawable arg1) {
        this.customThumbDrawable = this.initializeCustomThumbDrawable(arg1);
        this.customThumbDrawablesForValues.clear();
        this.postInvalidate();
    }

    void setCustomThumbDrawablesForValues(int[] arg5) {
        Drawable[] v0 = new Drawable[arg5.length];
        int v1;
        for(v1 = 0; v1 < arg5.length; ++v1) {
            v0[v1] = this.getResources().getDrawable(arg5[v1]);
        }

        this.setCustomThumbDrawablesForValues(v0);
    }

    void setCustomThumbDrawablesForValues(Drawable[] arg5) {
        this.customThumbDrawable = null;
        this.customThumbDrawablesForValues = new ArrayList();
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.customThumbDrawablesForValues.add(this.initializeCustomThumbDrawable(arg5[v1]));
        }

        this.postInvalidate();
    }

    public void setEnabled(boolean arg2) {
        super.setEnabled(arg2);
        int v2 = arg2 ? 0 : 2;
        this.setLayerType(v2, null);
    }

    public void setFocusedThumbIndex(int arg2) {
        if(arg2 >= 0 && arg2 < this.values.size()) {
            this.focusedThumbIdx = arg2;
            this.accessibilityHelper.requestKeyboardFocusForVirtualView(arg2);
            this.postInvalidate();
            return;
        }

        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(int arg2) {
        if(arg2 == this.haloRadius) {
            return;
        }

        this.haloRadius = arg2;
        Drawable v2 = this.getBackground();
        if(!this.shouldDrawCompatHalo() && ((v2 instanceof RippleDrawable))) {
            DrawableUtils.setRippleDrawableRadius(((RippleDrawable)v2), this.haloRadius);
            return;
        }

        this.postInvalidate();
    }

    public void setHaloRadiusResource(int arg2) {
        this.setHaloRadius(this.getResources().getDimensionPixelSize(arg2));
    }

    public void setHaloTintList(ColorStateList arg3) {
        if(arg3.equals(this.haloColor)) {
            return;
        }

        this.haloColor = arg3;
        Drawable v0 = this.getBackground();
        if(!this.shouldDrawCompatHalo() && ((v0 instanceof RippleDrawable))) {
            ((RippleDrawable)v0).setColor(arg3);
            return;
        }

        this.haloPaint.setColor(this.getColorForState(arg3));
        this.haloPaint.setAlpha(0x3F);
        this.invalidate();
    }

    public void setLabelBehavior(int arg2) {
        if(this.labelBehavior != arg2) {
            this.labelBehavior = arg2;
            this.requestLayout();
        }
    }

    public void setLabelFormatter(LabelFormatter arg1) {
        this.formatter = arg1;
    }

    protected void setSeparationUnit(int arg1) {
        this.separationUnit = arg1;
        this.dirtyConfig = true;
        this.postInvalidate();
    }

    public void setStepSize(float arg3) {
        if(arg3 >= 0f) {
            if(this.stepSize != arg3) {
                this.stepSize = arg3;
                this.dirtyConfig = true;
                this.postInvalidate();
            }

            return;
        }

        throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(arg3), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
    }

    public void setThumbElevation(float arg1) {
        this.defaultThumbDrawable.setElevation(arg1);
    }

    public void setThumbElevationResource(int arg2) {
        this.setThumbElevation(this.getResources().getDimension(arg2));
    }

    public void setThumbRadius(int arg4) {
        if(arg4 == this.thumbRadius) {
            return;
        }

        this.thumbRadius = arg4;
        this.defaultThumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, ((float)this.thumbRadius)).build());
        this.defaultThumbDrawable.setBounds(0, 0, this.thumbRadius * 2, this.thumbRadius * 2);
        Drawable v4 = this.customThumbDrawable;
        if(v4 != null) {
            this.adjustCustomThumbDrawableBounds(v4);
        }

        Iterator v4_1 = this.customThumbDrawablesForValues.iterator();
        while(v4_1.hasNext()) {
            this.adjustCustomThumbDrawableBounds(v4_1.next());
        }

        this.updateWidgetLayout();
    }

    public void setThumbRadiusResource(int arg2) {
        this.setThumbRadius(this.getResources().getDimensionPixelSize(arg2));
    }

    public void setThumbStrokeColor(ColorStateList arg2) {
        this.defaultThumbDrawable.setStrokeColor(arg2);
        this.postInvalidate();
    }

    public void setThumbStrokeColorResource(int arg2) {
        if(arg2 != 0) {
            this.setThumbStrokeColor(AppCompatResources.getColorStateList(this.getContext(), arg2));
        }
    }

    public void setThumbStrokeWidth(float arg2) {
        this.defaultThumbDrawable.setStrokeWidth(arg2);
        this.postInvalidate();
    }

    public void setThumbStrokeWidthResource(int arg2) {
        if(arg2 != 0) {
            this.setThumbStrokeWidth(this.getResources().getDimension(arg2));
        }
    }

    public void setThumbTintList(ColorStateList arg2) {
        if(arg2.equals(this.defaultThumbDrawable.getFillColor())) {
            return;
        }

        this.defaultThumbDrawable.setFillColor(arg2);
        this.invalidate();
    }

    public void setTickActiveRadius(int arg2) {
        if(this.tickActiveRadius != arg2) {
            this.tickActiveRadius = arg2;
            this.activeTicksPaint.setStrokeWidth(((float)(arg2 * 2)));
            this.updateWidgetLayout();
        }
    }

    public void setTickActiveTintList(ColorStateList arg2) {
        if(arg2.equals(this.tickColorActive)) {
            return;
        }

        this.tickColorActive = arg2;
        this.activeTicksPaint.setColor(this.getColorForState(arg2));
        this.invalidate();
    }

    public void setTickInactiveRadius(int arg2) {
        if(this.tickInactiveRadius != arg2) {
            this.tickInactiveRadius = arg2;
            this.inactiveTicksPaint.setStrokeWidth(((float)(arg2 * 2)));
            this.updateWidgetLayout();
        }
    }

    public void setTickInactiveTintList(ColorStateList arg2) {
        if(arg2.equals(this.tickColorInactive)) {
            return;
        }

        this.tickColorInactive = arg2;
        this.inactiveTicksPaint.setColor(this.getColorForState(arg2));
        this.invalidate();
    }

    public void setTickTintList(ColorStateList arg1) {
        this.setTickInactiveTintList(arg1);
        this.setTickActiveTintList(arg1);
    }

    public void setTickVisible(boolean arg2) {
        if(this.tickVisible != arg2) {
            this.tickVisible = arg2;
            this.postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList arg2) {
        if(arg2.equals(this.trackColorActive)) {
            return;
        }

        this.trackColorActive = arg2;
        this.activeTrackPaint.setColor(this.getColorForState(arg2));
        this.invalidate();
    }

    public void setTrackHeight(int arg2) {
        if(this.trackHeight != arg2) {
            this.trackHeight = arg2;
            this.invalidateTrack();
            this.updateWidgetLayout();
        }
    }

    public void setTrackInactiveTintList(ColorStateList arg2) {
        if(arg2.equals(this.trackColorInactive)) {
            return;
        }

        this.trackColorInactive = arg2;
        this.inactiveTrackPaint.setColor(this.getColorForState(arg2));
        this.invalidate();
    }

    public void setTrackTintList(ColorStateList arg1) {
        this.setTrackInactiveTintList(arg1);
        this.setTrackActiveTintList(arg1);
    }

    private void setValueForLabel(TooltipDrawable arg4, float arg5) {
        arg4.setText(this.formatValue(arg5));
        int v0 = this.trackSidePadding + (((int)(this.normalizeValue(arg5) * (((float)this.trackWidth))))) - arg4.getIntrinsicWidth() / 2;
        int v5 = this.calculateTrackCenter() - (this.labelPadding + this.thumbRadius);
        arg4.setBounds(v0, v5 - arg4.getIntrinsicHeight(), arg4.getIntrinsicWidth() + v0, v5);
        Rect v5_1 = new Rect(arg4.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(((View)this)), ((View)this), v5_1);
        arg4.setBounds(v5_1);
        ViewUtils.getContentViewOverlay(((View)this)).add(((Drawable)arg4));
    }

    public void setValueFrom(float arg1) {
        this.valueFrom = arg1;
        this.dirtyConfig = true;
        this.postInvalidate();
    }

    public void setValueTo(float arg1) {
        this.valueTo = arg1;
        this.dirtyConfig = true;
        this.postInvalidate();
    }

    void setValues(Float[] arg2) {
        ArrayList v0 = new ArrayList();
        Collections.addAll(((Collection)v0), ((Object[])arg2));
        this.setValuesInternal(v0);
    }

    void setValues(List arg2) {
        this.setValuesInternal(new ArrayList(((Collection)arg2)));
    }

    private void setValuesInternal(ArrayList arg3) {
        if(!arg3.isEmpty()) {
            Collections.sort(((List)arg3));
            if(this.values.size() == arg3.size() && (this.values.equals(arg3))) {
                return;
            }

            this.values = arg3;
            this.dirtyConfig = true;
            this.focusedThumbIdx = 0;
            this.updateHaloHotspot();
            this.createLabelPool();
            this.dispatchOnChangedProgrammatically();
            this.postInvalidate();
            return;
        }

        throw new IllegalArgumentException("At least one value must be set");
    }

    private boolean shouldAlwaysShowLabel() {
        if(this.labelBehavior == 3) {
            return 1;
        }

        return 0;
    }

    private boolean shouldDrawCompatHalo() {
        if(!this.forceDrawCompatHalo) {
            if(!(this.getBackground() instanceof RippleDrawable)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private boolean snapActiveThumbToValue(float arg2) {
        return this.snapThumbToValue(this.activeThumbIdx, arg2);
    }

    private double snapPosition(float arg3) {
        float v0 = this.stepSize;
        if(v0 > 0f) {
            int v2 = ((int)((this.valueTo - this.valueFrom) / v0));
            return (((double)Math.round(arg3 * (((float)v2))))) / (((double)v2));
        }

        return ((double)arg3);
    }

    private boolean snapThumbToValue(int arg5, float arg6) {
        this.focusedThumbIdx = arg5;
        if((((double)Math.abs(arg6 - this.values.get(arg5).floatValue()))) < 0.0001) {
            return 0;
        }

        this.values.set(arg5, Float.valueOf(this.getClampedValue(arg5, arg6)));
        this.dispatchOnChangedFromUser(arg5);
        return 1;
    }

    private boolean snapTouchPosition() {
        return this.snapActiveThumbToValue(this.getValueOfTouchPosition());
    }

    void updateBoundsForVirtualViewId(int arg4, Rect arg5) {
        int v0 = this.trackSidePadding + (((int)(this.normalizeValue(this.getValues().get(arg4).floatValue()) * (((float)this.trackWidth)))));
        arg4 = this.calculateTrackCenter();
        int v1 = this.thumbRadius;
        int v3 = this.minTouchTargetSize;
        if(v1 > v3) {
        }
        else {
            v1 = v3;
        }

        v1 /= 2;
        arg5.set(v0 - v1, arg4 - v1, v0 + v1, arg4 + v1);
    }

    private void updateHaloHotspot() {
        if(!this.shouldDrawCompatHalo() && this.getMeasuredWidth() > 0) {
            Drawable v0 = this.getBackground();
            if((v0 instanceof RippleDrawable)) {
                int v1 = ((int)(this.normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * (((float)this.trackWidth)) + (((float)this.trackSidePadding))));
                int v2 = this.calculateTrackCenter();
                DrawableCompat.setHotspotBounds(v0, v1 - this.haloRadius, v2 - this.haloRadius, v1 + this.haloRadius, v2 + this.haloRadius);
            }
        }
    }

    private void updateTrackWidth(int arg2) {
        this.trackWidth = Math.max(arg2 - this.trackSidePadding * 2, 0);
        this.maybeCalculateTicksCoordinates();
    }

    private void updateWidgetLayout() {
        boolean v0 = this.maybeIncreaseWidgetHeight();
        boolean v1 = this.maybeIncreaseTrackSidePadding();
        if(v0) {
            this.requestLayout();
            return;
        }

        if(v1) {
            this.postInvalidate();
        }
    }

    private void validateConfigurationIfDirty() {
        if(this.dirtyConfig) {
            this.validateValueFrom();
            this.validateValueTo();
            this.validateStepSize();
            this.validateValues();
            this.validateMinSeparation();
            this.warnAboutFloatingPointError();
            this.dirtyConfig = false;
        }
    }

    private void validateMinSeparation() {
        float v0 = this.getMinSeparation();
        if(v0 >= 0f) {
            float v2 = this.stepSize;
            if(v2 > 0f && v0 > 0f) {
                if(this.separationUnit == 1) {
                    if(v0 >= v2 && (this.isMultipleOfStepSize(v0))) {
                        return;
                    }

                    throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", Float.valueOf(v0), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)));
                }
                else {
                    throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", Float.valueOf(v0), Float.valueOf(this.stepSize)));
                }
            }

            return;
        }

        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", Float.valueOf(v0)));
    }

    private void validateStepSize() {
        if(this.stepSize > 0f) {
            if(this.valueLandsOnTick(this.valueTo)) {
            }
            else {
                throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(this.stepSize), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
            }
        }
    }

    private void validateValueFrom() {
        if(this.valueFrom < this.valueTo) {
            return;
        }

        throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
    }

    private void validateValueTo() {
        if(this.valueTo > this.valueFrom) {
            return;
        }

        throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.valueOf(this.valueTo), Float.valueOf(this.valueFrom)));
    }

    private void validateValues() {
        Object v1;
        Iterator v0 = this.values.iterator();
        while(true) {
            if(!v0.hasNext()) {
                return;
            }

            v1 = v0.next();
            if(((Float)v1).floatValue() >= this.valueFrom && ((Float)v1).floatValue() <= this.valueTo) {
                if(this.stepSize <= 0f) {
                    continue;
                }

                if(this.valueLandsOnTick(((Float)v1).floatValue())) {
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_30;
        }

        throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", v1, Float.valueOf(this.valueFrom), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)));
    label_30:
        throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", v1, Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
    }

    private boolean valueLandsOnTick(float arg2) {
        return this.isMultipleOfStepSize(arg2 - this.valueFrom);
    }

    private float valueToX(float arg2) {
        return this.normalizeValue(arg2) * (((float)this.trackWidth)) + (((float)this.trackSidePadding));
    }

    private void warnAboutFloatingPointError() {
        float v0 = this.stepSize;
        if(v0 == 0f) {
        }
        else {
            String v2 = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";
            if(Float.compare(((float)(((int)v0))), v0) != 0) {
                Log.w(BaseSlider.TAG, String.format(v2, "stepSize", Float.valueOf(v0)));
            }

            v0 = this.valueFrom;
            if((((float)(((int)v0)))) != v0) {
                Log.w(BaseSlider.TAG, String.format(v2, "valueFrom", Float.valueOf(v0)));
            }

            float v4 = this.valueTo;
            if((((float)(((int)v4)))) == v4) {
                return;
            }

            Log.w(BaseSlider.TAG, String.format(v2, "valueTo", Float.valueOf(v4)));
        }
    }
}

