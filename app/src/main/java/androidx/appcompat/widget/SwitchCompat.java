package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.Region$Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.text.InputFilter;
import android.text.Layout$Alignment;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode$Callback;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.emoji2.text.EmojiCompat$InitCallback;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class SwitchCompat extends CompoundButton implements EmojiCompatConfigurationView {
    class androidx.appcompat.widget.SwitchCompat$1 extends Property {
        androidx.appcompat.widget.SwitchCompat$1(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Float get(SwitchCompat arg1) {
            return Float.valueOf(arg1.mThumbPosition);
        }

        public Object get(Object arg1) {
            return this.get(((SwitchCompat)arg1));
        }

        public void set(SwitchCompat arg1, Float arg2) {
            arg1.setThumbPosition(arg2.floatValue());
        }

        public void set(Object arg1, Object arg2) {
            this.set(((SwitchCompat)arg1), ((Float)arg2));
        }
    }

    class Api18Impl {
        private Api18Impl() {
            super();
        }

        static void setAutoCancel(ObjectAnimator arg0, boolean arg1) {
            arg0.setAutoCancel(arg1);
        }
    }

    class EmojiCompatInitCallback extends InitCallback {
        private final Reference mOuterWeakRef;

        EmojiCompatInitCallback(SwitchCompat arg2) {
            super();
            this.mOuterWeakRef = new WeakReference(arg2);
        }

        public void onFailed(Throwable arg1) {
            Object v0 = this.mOuterWeakRef.get();
            if(v0 != null) {
                ((SwitchCompat)v0).onEmojiCompatInitializedForSwitchText();
            }
        }

        public void onInitialized() {
            Object v0 = this.mOuterWeakRef.get();
            if(v0 != null) {
                ((SwitchCompat)v0).onEmojiCompatInitializedForSwitchText();
            }
        }
    }

    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int[] CHECKED_STATE_SET = null;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 0xFA;
    private static final Property THUMB_POS = null;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE;
    private AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    private EmojiCompatInitCallback mEmojiCompatInitCallback;
    private boolean mEnforceSwitchWidth;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private final AppCompatTextHelper mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOffTransformed;
    private CharSequence mTextOn;
    private CharSequence mTextOnTransformed;
    private final TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff$Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff$Mode mTrackTintMode;
    private VelocityTracker mVelocityTracker;

    static {
        SwitchCompat.THUMB_POS = new androidx.appcompat.widget.SwitchCompat$1(Float.class, "thumbPos");
        SwitchCompat.CHECKED_STATE_SET = new int[]{0x10100A0};
    }

    public SwitchCompat(Context arg2) {
        this(arg2, null);
    }

    public SwitchCompat(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.switchStyle);
    }

    public SwitchCompat(Context arg12, AttributeSet arg13, int arg14) {
        super(arg12, arg13, arg14);
        ColorStateList v0 = null;
        this.mThumbTintList = v0;
        this.mThumbTintMode = ((PorterDuff$Mode)v0);
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = v0;
        this.mTrackTintMode = ((PorterDuff$Mode)v0);
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mEnforceSwitchWidth = true;
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(((View)this), this.getContext());
        TextPaint v3 = new TextPaint(1);
        this.mTextPaint = v3;
        v3.density = this.getResources().getDisplayMetrics().density;
        TintTypedArray v3_1 = TintTypedArray.obtainStyledAttributes(arg12, arg13, styleable.SwitchCompat, arg14, 0);
        SwitchCompat v4 = this;
        Context v5 = arg12;
        AttributeSet v7 = arg13;
        int v9 = arg14;
        ViewCompat.saveAttributeDataForStyleable(((View)v4), v5, styleable.SwitchCompat, v7, v3_1.getWrappedTypeArray(), v9, 0);
        Drawable v11 = v3_1.getDrawable(styleable.SwitchCompat_android_thumb);
        v4.mThumbDrawable = v11;
        if(v11 != null) {
            v11.setCallback(((Drawable$Callback)v4));
        }

        v11 = v3_1.getDrawable(styleable.SwitchCompat_track);
        v4.mTrackDrawable = v11;
        if(v11 != null) {
            v11.setCallback(((Drawable$Callback)v4));
        }

        v4.setTextOnInternal(v3_1.getText(styleable.SwitchCompat_android_textOn));
        v4.setTextOffInternal(v3_1.getText(styleable.SwitchCompat_android_textOff));
        v4.mShowText = v3_1.getBoolean(styleable.SwitchCompat_showText, true);
        v4.mThumbTextPadding = v3_1.getDimensionPixelSize(styleable.SwitchCompat_thumbTextPadding, 0);
        v4.mSwitchMinWidth = v3_1.getDimensionPixelSize(styleable.SwitchCompat_switchMinWidth, 0);
        v4.mSwitchPadding = v3_1.getDimensionPixelSize(styleable.SwitchCompat_switchPadding, 0);
        v4.mSplitTrack = v3_1.getBoolean(styleable.SwitchCompat_splitTrack, false);
        ColorStateList v11_1 = v3_1.getColorStateList(styleable.SwitchCompat_thumbTint);
        if(v11_1 != null) {
            v4.mThumbTintList = v11_1;
            v4.mHasThumbTint = true;
        }

        int v12 = -1;
        PorterDuff$Mode v11_2 = DrawableUtils.parseTintMode(v3_1.getInt(styleable.SwitchCompat_thumbTintMode, v12), ((PorterDuff$Mode)v0));
        if(v4.mThumbTintMode != v11_2) {
            v4.mThumbTintMode = v11_2;
            v4.mHasThumbTintMode = true;
        }

        if((v4.mHasThumbTint) || (v4.mHasThumbTintMode)) {
            v4.applyThumbTint();
        }

        v11_1 = v3_1.getColorStateList(styleable.SwitchCompat_trackTint);
        if(v11_1 != null) {
            v4.mTrackTintList = v11_1;
            v4.mHasTrackTint = true;
        }

        v11_2 = DrawableUtils.parseTintMode(v3_1.getInt(styleable.SwitchCompat_trackTintMode, v12), ((PorterDuff$Mode)v0));
        if(v4.mTrackTintMode != v11_2) {
            v4.mTrackTintMode = v11_2;
            v4.mHasTrackTintMode = true;
        }

        if((v4.mHasTrackTint) || (v4.mHasTrackTintMode)) {
            v4.applyTrackTint();
        }

        int v11_3 = v3_1.getResourceId(styleable.SwitchCompat_switchTextAppearance, 0);
        if(v11_3 != 0) {
            v4.setSwitchTextAppearance(v5, v11_3);
        }

        AppCompatTextHelper v11_4 = new AppCompatTextHelper(((TextView)v4));
        v4.mTextHelper = v11_4;
        v11_4.loadFromAttributes(v7, v9);
        v3_1.recycle();
        ViewConfiguration v11_5 = ViewConfiguration.get(v5);
        v4.mTouchSlop = v11_5.getScaledTouchSlop();
        v4.mMinFlingVelocity = v11_5.getScaledMinimumFlingVelocity();
        v4.getEmojiTextViewHelper().loadFromAttributes(v7, v9);
        v4.refreshDrawableState();
        v4.setChecked(v4.isChecked());
    }

    private void animateThumbToCheckedState(boolean arg5) {
        float v5 = arg5 ? 1f : 0f;
        ObjectAnimator v5_1 = ObjectAnimator.ofFloat(this, SwitchCompat.THUMB_POS, new float[]{v5});
        this.mPositionAnimator = v5_1;
        v5_1.setDuration(0xFA);
        Api18Impl.setAutoCancel(this.mPositionAnimator, true);
        this.mPositionAnimator.start();
    }

    private void applyThumbTint() {
        Drawable v0 = this.mThumbDrawable;
        if(v0 != null && ((this.mHasThumbTint) || (this.mHasThumbTintMode))) {
            v0 = DrawableCompat.wrap(v0).mutate();
            this.mThumbDrawable = v0;
            if(this.mHasThumbTint) {
                DrawableCompat.setTintList(v0, this.mThumbTintList);
            }

            if(this.mHasThumbTintMode) {
                DrawableCompat.setTintMode(this.mThumbDrawable, this.mThumbTintMode);
            }

            if(!this.mThumbDrawable.isStateful()) {
                return;
            }

            this.mThumbDrawable.setState(this.getDrawableState());
        }
    }

    private void applyTrackTint() {
        Drawable v0 = this.mTrackDrawable;
        if(v0 != null && ((this.mHasTrackTint) || (this.mHasTrackTintMode))) {
            v0 = DrawableCompat.wrap(v0).mutate();
            this.mTrackDrawable = v0;
            if(this.mHasTrackTint) {
                DrawableCompat.setTintList(v0, this.mTrackTintList);
            }

            if(this.mHasTrackTintMode) {
                DrawableCompat.setTintMode(this.mTrackDrawable, this.mTrackTintMode);
            }

            if(!this.mTrackDrawable.isStateful()) {
                return;
            }

            this.mTrackDrawable.setState(this.getDrawableState());
        }
    }

    private void cancelPositionAnimator() {
        ObjectAnimator v0 = this.mPositionAnimator;
        if(v0 != null) {
            v0.cancel();
        }
    }

    private void cancelSuperTouch(MotionEvent arg2) {
        arg2 = MotionEvent.obtain(arg2);
        arg2.setAction(3);
        super.onTouchEvent(arg2);
        arg2.recycle();
    }

    private static float constrain(float arg1, float arg2, float arg3) {
        if(arg1 < arg2) {
            return arg2;
        }

        if(arg1 > arg3) {
            return arg3;
        }

        return arg1;
    }

    private CharSequence doTransformForOnOffText(CharSequence arg3) {
        TransformationMethod v0 = this.getEmojiTextViewHelper().wrapTransformationMethod(this.mSwitchTransformationMethod);
        if(v0 != null) {
            return v0.getTransformation(arg3, ((View)this));
        }

        return arg3;
    }

    public void draw(Canvas arg11) {
        int v6_2;
        int v7_1;
        Rect v0 = this.mTempRect;
        int v1 = this.mSwitchLeft;
        int v2 = this.mSwitchTop;
        int v3 = this.mSwitchRight;
        int v4 = this.mSwitchBottom;
        int v5 = this.getThumbOffset() + v1;
        Drawable v6 = this.mThumbDrawable;
        Rect v6_1 = v6 != null ? DrawableUtils.getOpticalBounds(v6) : DrawableUtils.INSETS_NONE;
        Drawable v7 = this.mTrackDrawable;
        if(v7 != null) {
            v7.getPadding(v0);
            v5 += v0.left;
            if(v6_1 != null) {
                if(v6_1.left > v0.left) {
                    v1 += v6_1.left - v0.left;
                }

                v7_1 = v6_1.top > v0.top ? v6_1.top - v0.top + v2 : v2;
                if(v6_1.right > v0.right) {
                    v3 -= v6_1.right - v0.right;
                }

                if(v6_1.bottom <= v0.bottom) {
                    goto label_50;
                }

                v6_2 = v4 - (v6_1.bottom - v0.bottom);
            }
            else {
                v7_1 = v2;
            label_50:
                v6_2 = v4;
            }

            this.mTrackDrawable.setBounds(v1, v7_1, v3, v6_2);
        }

        Drawable v1_1 = this.mThumbDrawable;
        if(v1_1 != null) {
            v1_1.getPadding(v0);
            v1 = v5 - v0.left;
            v5 = v5 + this.mThumbWidth + v0.right;
            this.mThumbDrawable.setBounds(v1, v2, v5, v4);
            Drawable v0_1 = this.getBackground();
            if(v0_1 != null) {
                DrawableCompat.setHotspotBounds(v0_1, v1, v2, v5, v4);
            }
        }

        super.draw(arg11);
    }

    public void drawableHotspotChanged(float arg2, float arg3) {
        super.drawableHotspotChanged(arg2, arg3);
        Drawable v0 = this.mThumbDrawable;
        if(v0 != null) {
            DrawableCompat.setHotspot(v0, arg2, arg3);
        }

        Drawable v1 = this.mTrackDrawable;
        if(v1 != null) {
            DrawableCompat.setHotspot(v1, arg2, arg3);
        }
    }

    protected void drawableStateChanged() {
        boolean v1_1;
        int v1_2;
        super.drawableStateChanged();
        int[] v0 = this.getDrawableState();
        Drawable v1 = this.mThumbDrawable;
        if(v1 == null || !v1.isStateful()) {
            v1_2 = 0;
        }
        else {
            v1_1 = v1.setState(v0);
        }

        Drawable v2 = this.mTrackDrawable;
        if(v2 != null && (v2.isStateful())) {
            v1_2 = (((int)v1_1)) | v2.setState(v0);
        }

        if(v1_1) {
            this.invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if(!ViewUtils.isLayoutRtl(((View)this))) {
            return super.getCompoundPaddingLeft();
        }

        int v0 = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if(!TextUtils.isEmpty(this.getText())) {
            v0 += this.mSwitchPadding;
        }

        return v0;
    }

    public int getCompoundPaddingRight() {
        if(ViewUtils.isLayoutRtl(((View)this))) {
            return super.getCompoundPaddingRight();
        }

        int v0 = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if(!TextUtils.isEmpty(this.getText())) {
            v0 += this.mSwitchPadding;
        }

        return v0;
    }

    public ActionMode$Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        AppCompatEmojiTextHelper v0 = this.mAppCompatEmojiTextHelper;
        if(v0 == null) {
            v0 = new AppCompatEmojiTextHelper(((TextView)this));
            this.mAppCompatEmojiTextHelper = v0;
        }

        return v0;
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    private boolean getTargetCheckedState() {
        if(this.mThumbPosition > 0.5f) {
            return 1;
        }

        return 0;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    private int getThumbOffset() {
        boolean v0 = ViewUtils.isLayoutRtl(((View)this));
        float v1 = this.mThumbPosition;
        if(v0) {
            v1 = 1f - v1;
        }

        return ((int)(v1 * (((float)this.getThumbScrollRange())) + 0.5f));
    }

    protected final float getThumbPosition() {
        return this.mThumbPosition;
    }

    private int getThumbScrollRange() {
        Drawable v0 = this.mTrackDrawable;
        if(v0 != null) {
            Rect v1 = this.mTempRect;
            v0.getPadding(v1);
            v0 = this.mThumbDrawable;
            Rect v0_1 = v0 != null ? DrawableUtils.getOpticalBounds(v0) : DrawableUtils.INSETS_NONE;
            return this.mSwitchWidth - this.mThumbWidth - v1.left - v1.right - v0_1.left - v0_1.right;
        }

        return 0;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public PorterDuff$Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public PorterDuff$Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    private boolean hitThumb(float arg6, float arg7) {
        if(this.mThumbDrawable == null) {
            return 0;
        }

        int v0 = this.getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int v2 = this.mSwitchTop - this.mTouchSlop;
        int v4 = this.mSwitchLeft + v0 - this.mTouchSlop;
        v0 = this.mThumbWidth + v4 + this.mTempRect.left + this.mTempRect.right + this.mTouchSlop;
        int v5 = this.mSwitchBottom + this.mTouchSlop;
        if(arg6 > (((float)v4)) && arg6 < (((float)v0)) && arg7 > (((float)v2)) && arg7 < (((float)v5))) {
            return 1;
        }

        return 0;
    }

    public boolean isEmojiCompatEnabled() {
        return this.getEmojiTextViewHelper().isEnabled();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable v0 = this.mThumbDrawable;
        if(v0 != null) {
            v0.jumpToCurrentState();
        }

        v0 = this.mTrackDrawable;
        if(v0 != null) {
            v0.jumpToCurrentState();
        }

        ObjectAnimator v0_1 = this.mPositionAnimator;
        if(v0_1 != null && (v0_1.isStarted())) {
            this.mPositionAnimator.end();
            this.mPositionAnimator = null;
        }
    }

    private Layout makeLayout(CharSequence arg9) {
        TextPaint v2 = this.mTextPaint;
        int v8 = arg9 != null ? ((int)Math.ceil(((double)Layout.getDesiredWidth(arg9, v2)))) : 0;
        return new StaticLayout(arg9, v2, v8, Layout$Alignment.ALIGN_NORMAL, 1f, 0f, true);
    }

    protected int[] onCreateDrawableState(int arg1) {
        int[] v1 = super.onCreateDrawableState(arg1 + 1);
        if(this.isChecked()) {
            SwitchCompat.mergeDrawableStates(v1, SwitchCompat.CHECKED_STATE_SET);
        }

        return v1;
    }

    protected void onDraw(Canvas arg10) {
        int v4_1;
        super.onDraw(arg10);
        Rect v0 = this.mTempRect;
        Drawable v1 = this.mTrackDrawable;
        if(v1 != null) {
            v1.getPadding(v0);
        }
        else {
            v0.setEmpty();
        }

        int v2 = this.mSwitchTop;
        int v3 = this.mSwitchBottom;
        v2 += v0.top;
        v3 -= v0.bottom;
        Drawable v4 = this.mThumbDrawable;
        if(v1 != null) {
            if((this.mSplitTrack) && v4 != null) {
                Rect v5 = DrawableUtils.getOpticalBounds(v4);
                v4.copyBounds(v0);
                v0.left += v5.left;
                v0.right -= v5.right;
                int v5_1 = arg10.save();
                arg10.clipRect(v0, Region$Op.DIFFERENCE);
                v1.draw(arg10);
                arg10.restoreToCount(v5_1);
                goto label_35;
            }

            v1.draw(arg10);
        }

    label_35:
        int v0_1 = arg10.save();
        if(v4 != null) {
            v4.draw(arg10);
        }

        Layout v1_1 = this.getTargetCheckedState() ? this.mOnLayout : this.mOffLayout;
        if(v1_1 != null) {
            int[] v5_2 = this.getDrawableState();
            ColorStateList v6 = this.mTextColors;
            if(v6 != null) {
                this.mTextPaint.setColor(v6.getColorForState(v5_2, 0));
            }

            this.mTextPaint.drawableState = v5_2;
            if(v4 != null) {
                Rect v9 = v4.getBounds();
                v4_1 = v9.left + v9.right;
            }
            else {
                v4_1 = this.getWidth();
            }

            arg10.translate(((float)(v4_1 / 2 - v1_1.getWidth() / 2)), ((float)((v2 + v3) / 2 - v1_1.getHeight() / 2)));
            v1_1.draw(arg10);
        }

        arg10.restoreToCount(v0_1);
    }

    void onEmojiCompatInitializedForSwitchText() {
        this.setTextOnInternal(this.mTextOn);
        this.setTextOffInternal(this.mTextOff);
        this.requestLayout();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent arg1) {
        super.onInitializeAccessibilityEvent(arg1);
        arg1.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg4) {
        super.onInitializeAccessibilityNodeInfo(arg4);
        arg4.setClassName("android.widget.Switch");
        if(Build$VERSION.SDK_INT < 30) {
            CharSequence v3 = this.isChecked() ? this.mTextOn : this.mTextOff;
            if(TextUtils.isEmpty(v3)) {
                return;
            }

            CharSequence v0 = arg4.getText();
            if(TextUtils.isEmpty(v0)) {
                arg4.setText(v3);
                return;
            }

            StringBuilder v1 = new StringBuilder();
            v1.append(v0).append(' ').append(v3);
            arg4.setText(((CharSequence)v1));
        }
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        int v1_1;
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        arg2 = 0;
        if(this.mThumbDrawable != null) {
            Rect v1 = this.mTempRect;
            Drawable v3 = this.mTrackDrawable;
            if(v3 != null) {
                v3.getPadding(v1);
            }
            else {
                v1.setEmpty();
            }

            Rect v3_1 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
            arg4 = Math.max(0, v3_1.left - v1.left);
            arg2 = Math.max(0, v3_1.right - v1.right);
        }
        else {
            arg4 = 0;
        }

        if(ViewUtils.isLayoutRtl(((View)this))) {
            v1_1 = this.getPaddingLeft() + arg4;
            arg3 = this.mSwitchWidth + v1_1 - arg4 - arg2;
        }
        else {
            arg3 = this.getWidth() - this.getPaddingRight() - arg2;
            v1_1 = arg3 - this.mSwitchWidth + arg4 + arg2;
        }

        arg2 = this.getGravity() & 0x70;
        if(arg2 == 16) {
            arg2 = (this.getPaddingTop() + this.getHeight() - this.getPaddingBottom()) / 2;
            arg4 = this.mSwitchHeight;
            arg2 -= arg4 / 2;
        label_63:
            arg4 += arg2;
        }
        else if(arg2 != 80) {
            arg2 = this.getPaddingTop();
            arg4 = this.mSwitchHeight;
            goto label_63;
        }
        else {
            arg4 = this.getHeight() - this.getPaddingBottom();
            arg2 = arg4 - this.mSwitchHeight;
        }

        this.mSwitchLeft = v1_1;
        this.mSwitchTop = arg2;
        this.mSwitchBottom = arg4;
        this.mSwitchRight = arg3;
    }

    public void onMeasure(int arg7, int arg8) {
        int v3;
        int v1_1;
        if(this.mShowText) {
            if(this.mOnLayout == null) {
                this.mOnLayout = this.makeLayout(this.mTextOnTransformed);
            }

            if(this.mOffLayout != null) {
                goto label_12;
            }

            this.mOffLayout = this.makeLayout(this.mTextOffTransformed);
        }

    label_12:
        Rect v0 = this.mTempRect;
        Drawable v1 = this.mThumbDrawable;
        int v2 = 0;
        if(v1 != null) {
            v1.getPadding(v0);
            v1_1 = this.mThumbDrawable.getIntrinsicWidth() - v0.left - v0.right;
            v3 = this.mThumbDrawable.getIntrinsicHeight();
        }
        else {
            v1_1 = 0;
            v3 = 0;
        }

        int v4 = this.mShowText ? Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + this.mThumbTextPadding * 2 : 0;
        this.mThumbWidth = Math.max(v4, v1_1);
        v1 = this.mTrackDrawable;
        if(v1 != null) {
            v1.getPadding(v0);
            v2 = this.mTrackDrawable.getIntrinsicHeight();
        }
        else {
            v0.setEmpty();
        }

        v1_1 = v0.left;
        int v0_1 = v0.right;
        Drawable v4_1 = this.mThumbDrawable;
        if(v4_1 != null) {
            Rect v4_2 = DrawableUtils.getOpticalBounds(v4_1);
            v1_1 = Math.max(v1_1, v4_2.left);
            v0_1 = Math.max(v0_1, v4_2.right);
        }

        boolean v4_3 = this.mEnforceSwitchWidth;
        int v5 = this.mSwitchMinWidth;
        if(v4_3) {
            v5 = Math.max(v5, this.mThumbWidth * 2 + v1_1 + v0_1);
        }

        v0_1 = Math.max(v2, v3);
        this.mSwitchWidth = v5;
        this.mSwitchHeight = v0_1;
        super.onMeasure(arg7, arg8);
        if(this.getMeasuredHeight() < v0_1) {
            this.setMeasuredDimension(this.getMeasuredWidthAndState(), v0_1);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent arg2) {
        super.onPopulateAccessibilityEvent(arg2);
        CharSequence v1 = this.isChecked() ? this.mTextOn : this.mTextOff;
        if(v1 != null) {
            arg2.getText().add(v1);
        }
    }

    public boolean onTouchEvent(MotionEvent arg7) {
        float v0_1;
        float v3;
        float v2_1;
        this.mVelocityTracker.addMovement(arg7);
        int v0 = arg7.getActionMasked();
        if(v0 != 0) {
            int v2 = 2;
            if(v0 != 1) {
                if(v0 == v2) {
                    v0 = this.mTouchMode;
                    if(v0 == 1) {
                        v0_1 = arg7.getX();
                        v3 = arg7.getY();
                        if(Math.abs(v0_1 - this.mTouchX) <= (((float)this.mTouchSlop)) && Math.abs(v3 - this.mTouchY) <= (((float)this.mTouchSlop))) {
                            goto label_80;
                        }

                        this.mTouchMode = v2;
                        this.getParent().requestDisallowInterceptTouchEvent(true);
                        this.mTouchX = v0_1;
                        this.mTouchY = v3;
                        return 1;
                    }
                    else if(v0 != v2) {
                        goto label_80;
                    }
                    else {
                        float v7 = arg7.getX();
                        v0 = this.getThumbScrollRange();
                        v2_1 = v7 - this.mTouchX;
                        v3 = 1f;
                        if(v0 != 0) {
                            v2_1 /= ((float)v0);
                        }
                        else if(v2_1 > 0f) {
                            v2_1 = v3;
                        }
                        else {
                            v2_1 = -1f;
                        }

                        if(ViewUtils.isLayoutRtl(((View)this))) {
                            v2_1 = -v2_1;
                        }

                        v0_1 = SwitchCompat.constrain(this.mThumbPosition + v2_1, 0f, v3);
                        if(v0_1 != this.mThumbPosition) {
                            this.mTouchX = v7;
                            this.setThumbPosition(v0_1);
                        }

                        return 1;
                    }
                }
                else if(v0 != 3) {
                    goto label_80;
                }
            }

            if(this.mTouchMode == v2) {
                this.stopDrag(arg7);
                super.onTouchEvent(arg7);
                return 1;
            }

            this.mTouchMode = 0;
            this.mVelocityTracker.clear();
        }
        else {
            v0_1 = arg7.getX();
            v2_1 = arg7.getY();
            if(!this.isEnabled()) {
                goto label_80;
            }

            if(!this.hitThumb(v0_1, v2_1)) {
                goto label_80;
            }

            this.mTouchMode = 1;
            this.mTouchX = v0_1;
            this.mTouchY = v2_1;
        }

    label_80:
        return super.onTouchEvent(arg7);
    }

    public void setAllCaps(boolean arg1) {
        super.setAllCaps(arg1);
        this.getEmojiTextViewHelper().setAllCaps(arg1);
    }

    public void setChecked(boolean arg2) {
        super.setChecked(arg2);
        arg2 = this.isChecked();
        if(arg2) {
            this.setOnStateDescriptionOnRAndAbove();
        }
        else {
            this.setOffStateDescriptionOnRAndAbove();
        }

        if(this.getWindowToken() != null && (ViewCompat.isLaidOut(((View)this)))) {
            this.animateThumbToCheckedState(arg2);
            return;
        }

        this.cancelPositionAnimator();
        float v2 = arg2 ? 1f : 0f;
        this.setThumbPosition(v2);
    }

    public void setCustomSelectionActionModeCallback(ActionMode$Callback arg1) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(((TextView)this), arg1));
    }

    public void setEmojiCompatEnabled(boolean arg2) {
        this.getEmojiTextViewHelper().setEnabled(arg2);
        this.setTextOnInternal(this.mTextOn);
        this.setTextOffInternal(this.mTextOff);
        this.requestLayout();
    }

    protected final void setEnforceSwitchWidth(boolean arg1) {
        this.mEnforceSwitchWidth = arg1;
        this.invalidate();
    }

    public void setFilters(InputFilter[] arg2) {
        super.setFilters(this.getEmojiTextViewHelper().getFilters(arg2));
    }

    private void setOffStateDescriptionOnRAndAbove() {
        String v0_1;
        if(Build$VERSION.SDK_INT >= 30) {
            CharSequence v0 = this.mTextOff;
            if(v0 == null) {
                v0_1 = this.getResources().getString(string.abc_capital_off);
            }

            ViewCompat.setStateDescription(((View)this), ((CharSequence)v0_1));
        }
    }

    private void setOnStateDescriptionOnRAndAbove() {
        if(Build$VERSION.SDK_INT >= 30) {
            CharSequence v0 = this.mTextOn;
            if(v0 == null) {
                String v0_1 = this.getResources().getString(string.abc_capital_on);
            }

            ViewCompat.setStateDescription(((View)this), v0);
        }
    }

    public void setShowText(boolean arg2) {
        if(this.mShowText != arg2) {
            this.mShowText = arg2;
            this.requestLayout();
            if(arg2) {
                this.setupEmojiCompatLoadCallback();
            }
        }
    }

    public void setSplitTrack(boolean arg1) {
        this.mSplitTrack = arg1;
        this.invalidate();
    }

    public void setSwitchMinWidth(int arg1) {
        this.mSwitchMinWidth = arg1;
        this.requestLayout();
    }

    public void setSwitchPadding(int arg1) {
        this.mSwitchPadding = arg1;
        this.requestLayout();
    }

    public void setSwitchTextAppearance(Context arg4, int arg5) {
        TintTypedArray v4 = TintTypedArray.obtainStyledAttributes(arg4, arg5, styleable.TextAppearance);
        ColorStateList v5 = v4.getColorStateList(styleable.TextAppearance_android_textColor);
        this.mTextColors = v5 != null ? v5 : this.getTextColors();
        arg5 = v4.getDimensionPixelSize(styleable.TextAppearance_android_textSize, 0);
        if(arg5 != 0) {
            float v5_1 = ((float)arg5);
            if(v5_1 != this.mTextPaint.getTextSize()) {
                this.mTextPaint.setTextSize(v5_1);
                this.requestLayout();
            }
        }

        this.setSwitchTypefaceByIndex(v4.getInt(styleable.TextAppearance_android_typeface, -1), v4.getInt(styleable.TextAppearance_android_textStyle, -1));
        this.mSwitchTransformationMethod = v4.getBoolean(styleable.TextAppearance_textAllCaps, false) ? new AllCapsTransformationMethod(this.getContext()) : null;
        this.setTextOnInternal(this.mTextOn);
        this.setTextOffInternal(this.mTextOff);
        v4.recycle();
    }

    public void setSwitchTypeface(Typeface arg4, int arg5) {
        float v0 = 0f;
        boolean v1 = false;
        if(arg5 > 0) {
            arg4 = arg4 == null ? Typeface.defaultFromStyle(arg5) : Typeface.create(arg4, arg5);
            this.setSwitchTypeface(arg4);
            int v4 = arg4 != null ? arg4.getStyle() : 0;
            v4 = ~v4 & arg5;
            TextPaint v5 = this.mTextPaint;
            if((v4 & 1) != 0) {
                v1 = true;
            }

            v5.setFakeBoldText(v1);
            TextPaint v3 = this.mTextPaint;
            if((v4 & 2) != 0) {
                v0 = -0.25f;
            }

            v3.setTextSkewX(v0);
            return;
        }

        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0f);
        this.setSwitchTypeface(arg4);
    }

    public void setSwitchTypeface(Typeface arg2) {
        if(this.mTextPaint.getTypeface() != null && !this.mTextPaint.getTypeface().equals(arg2) || this.mTextPaint.getTypeface() == null && arg2 != null) {
            this.mTextPaint.setTypeface(arg2);
            this.requestLayout();
            this.invalidate();
        }
    }

    private void setSwitchTypefaceByIndex(int arg2, int arg3) {
        Typeface v2;
        if(arg2 == 1) {
            v2 = Typeface.SANS_SERIF;
        }
        else if(arg2 == 2) {
            v2 = Typeface.SERIF;
        }
        else if(arg2 != 3) {
            v2 = null;
        }
        else {
            v2 = Typeface.MONOSPACE;
        }

        this.setSwitchTypeface(v2, arg3);
    }

    public void setTextOff(CharSequence arg1) {
        this.setTextOffInternal(arg1);
        this.requestLayout();
        if(!this.isChecked()) {
            this.setOffStateDescriptionOnRAndAbove();
        }
    }

    private void setTextOffInternal(CharSequence arg1) {
        this.mTextOff = arg1;
        this.mTextOffTransformed = this.doTransformForOnOffText(arg1);
        this.mOffLayout = null;
        if(this.mShowText) {
            this.setupEmojiCompatLoadCallback();
        }
    }

    public void setTextOn(CharSequence arg1) {
        this.setTextOnInternal(arg1);
        this.requestLayout();
        if(this.isChecked()) {
            this.setOnStateDescriptionOnRAndAbove();
        }
    }

    private void setTextOnInternal(CharSequence arg1) {
        this.mTextOn = arg1;
        this.mTextOnTransformed = this.doTransformForOnOffText(arg1);
        this.mOnLayout = null;
        if(this.mShowText) {
            this.setupEmojiCompatLoadCallback();
        }
    }

    public void setThumbDrawable(Drawable arg3) {
        Drawable v0 = this.mThumbDrawable;
        if(v0 != null) {
            v0.setCallback(null);
        }

        this.mThumbDrawable = arg3;
        if(arg3 != null) {
            arg3.setCallback(((Drawable$Callback)this));
        }

        this.requestLayout();
    }

    void setThumbPosition(float arg1) {
        this.mThumbPosition = arg1;
        this.invalidate();
    }

    public void setThumbResource(int arg2) {
        this.setThumbDrawable(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setThumbTextPadding(int arg1) {
        this.mThumbTextPadding = arg1;
        this.requestLayout();
    }

    public void setThumbTintList(ColorStateList arg1) {
        this.mThumbTintList = arg1;
        this.mHasThumbTint = true;
        this.applyThumbTint();
    }

    public void setThumbTintMode(PorterDuff$Mode arg1) {
        this.mThumbTintMode = arg1;
        this.mHasThumbTintMode = true;
        this.applyThumbTint();
    }

    public void setTrackDrawable(Drawable arg3) {
        Drawable v0 = this.mTrackDrawable;
        if(v0 != null) {
            v0.setCallback(null);
        }

        this.mTrackDrawable = arg3;
        if(arg3 != null) {
            arg3.setCallback(((Drawable$Callback)this));
        }

        this.requestLayout();
    }

    public void setTrackResource(int arg2) {
        this.setTrackDrawable(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setTrackTintList(ColorStateList arg1) {
        this.mTrackTintList = arg1;
        this.mHasTrackTint = true;
        this.applyTrackTint();
    }

    public void setTrackTintMode(PorterDuff$Mode arg1) {
        this.mTrackTintMode = arg1;
        this.mHasTrackTintMode = true;
        this.applyTrackTint();
    }

    private void setupEmojiCompatLoadCallback() {
        if(this.mEmojiCompatInitCallback == null) {
            if(!this.mAppCompatEmojiTextHelper.isEnabled()) {
            }
            else if(EmojiCompat.isConfigured()) {
                EmojiCompat v0 = EmojiCompat.get();
                int v1 = v0.getLoadState();
                if(v1 != 3 && v1 != 0) {
                    return;
                }

                EmojiCompatInitCallback v1_1 = new EmojiCompatInitCallback(this);
                this.mEmojiCompatInitCallback = v1_1;
                v0.registerInitCallback(((InitCallback)v1_1));
            }
        }
    }

    private void stopDrag(MotionEvent arg7) {
        this.mTouchMode = 0;
        boolean v2 = true;
        int v1 = arg7.getAction() != 1 || !this.isEnabled() ? 0 : 1;
        boolean v3 = this.isChecked();
        if(v1 != 0) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float v1_1 = this.mVelocityTracker.getXVelocity();
            if(Math.abs(v1_1) > (((float)this.mMinFlingVelocity))) {
                if(ViewUtils.isLayoutRtl(((View)this))) {
                    if(v1_1 < 0f) {
                        goto label_33;
                    }
                }
                else if(v1_1 > 0f) {
                    goto label_33;
                }

                v2 = false;
            }
            else {
                v2 = this.getTargetCheckedState();
            }
        }
        else {
            v2 = v3;
        }

    label_33:
        if(v2 != v3) {
            this.playSoundEffect(0);
        }

        this.setChecked(v2);
        this.cancelSuperTouch(arg7);
    }

    public void toggle() {
        this.setChecked(this.isChecked() ^ 1);
    }

    protected boolean verifyDrawable(Drawable arg2) {
        if(!super.verifyDrawable(arg2) && arg2 != this.mThumbDrawable) {
            if(arg2 == this.mTrackDrawable) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

