package com.google.android.material.textfield;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View$OnClickListener;
import android.view.View$OnLongClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView$ScaleType;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel$Builder;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout implements ViewTreeObserver$OnGlobalLayoutListener {
    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout arg1) {
            super();
            this.layout = arg1;
        }

        public void onInitializeAccessibilityNodeInfo(View arg12, AccessibilityNodeInfoCompat arg13) {
            Editable v0_1;
            super.onInitializeAccessibilityNodeInfo(arg12, arg13);
            EditText v0 = this.layout.getEditText();
            if(v0 != null) {
                v0_1 = v0.getText();
            }
            else {
                CharSequence v0_2 = null;
            }

            CharSequence v1 = this.layout.getHint();
            CharSequence v2 = this.layout.getError();
            CharSequence v3 = this.layout.getPlaceholderText();
            int v4 = this.layout.getCounterMaxLength();
            CharSequence v5 = this.layout.getCounterOverflowDescription();
            boolean v6 = TextUtils.isEmpty(((CharSequence)v0_1));
            boolean v7 = TextUtils.isEmpty(v1);
            boolean v8 = this.layout.isHintExpanded();
            boolean v9 = TextUtils.isEmpty(v2);
            int v10 = !v9 || !TextUtils.isEmpty(v5) ? 1 : 0;
            String v1_1 = !v7 ? v1.toString() : "";
            this.layout.startLayout.setupAccessibilityNodeInfo(arg13);
            if(!v6) {
                arg13.setText(((CharSequence)v0_1));
            }
            else if(!TextUtils.isEmpty(((CharSequence)v1_1))) {
                arg13.setText(((CharSequence)v1_1));
                if(!v8 && v3 != null) {
                    arg13.setText(v1_1 + ", " + v3);
                }
            }
            else if(v3 != null) {
                arg13.setText(v3);
            }

            if(!TextUtils.isEmpty(((CharSequence)v1_1))) {
                arg13.setHintText(((CharSequence)v1_1));
                arg13.setShowingHintText(v6);
            }

            if(v0_1 == null || ((CharSequence)v0_1).length() != v4) {
                v4 = -1;
            }
            else {
            }

            arg13.setMaxTextLength(v4);
            if(v10 != 0) {
                if(!v9) {
                }
                else {
                    v2 = v5;
                }

                arg13.setError(v2);
            }

            View v0_3 = this.layout.indicatorViewController.getHelperTextView();
            if(v0_3 != null) {
                arg13.setLabelFor(v0_3);
            }

            this.layout.endLayout.getEndIconDelegate().onInitializeAccessibilityNodeInfo(arg12, arg13);
        }

        public void onPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
            super.onPopulateAccessibilityEvent(arg1, arg2);
            this.layout.endLayout.getEndIconDelegate().onPopulateAccessibilityEvent(arg1, arg2);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface BoxBackgroundMode {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface EndIconMode {
    }

    public interface LengthCounter {
        int countLength(Editable arg1);
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(TextInputLayout arg1);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(TextInputLayout arg1, int arg2);
    }

    class SavedState extends AbsSavedState {
        class com.google.android.material.textfield.TextInputLayout$SavedState$1 implements Parcelable$ClassLoaderCreator {
            com.google.android.material.textfield.TextInputLayout$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg2) {
                return new SavedState(arg2, null);
            }

            public SavedState createFromParcel(Parcel arg1, ClassLoader arg2) {
                return new SavedState(arg1, arg2);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public Object createFromParcel(Parcel arg1, ClassLoader arg2) {
                return this.createFromParcel(arg1, arg2);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        CharSequence error;
        boolean isEndIconChecked;

        static {
            SavedState.CREATOR = new com.google.android.material.textfield.TextInputLayout$SavedState$1();
        }

        SavedState(Parcelable arg1) {
            super(arg1);
        }

        SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            this.error = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg1);
            boolean v2 = true;
            if(arg1.readInt() == 1) {
            }
            else {
                v2 = false;
            }

            this.isEndIconChecked = v2;
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + "}";
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            TextUtils.writeToParcel(this.error, arg2, arg3);
            arg2.writeInt(this.isEndIconChecked);
        }
    }

    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEFAULT_PLACEHOLDER_FADE_DURATION = 87;
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] EDIT_TEXT_BACKGROUND_RIPPLE_STATE = null;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 0xA7;
    private static final String LOG_TAG = "TextInputLayout";
    private static final int NO_WIDTH = -1;
    private static final int PLACEHOLDER_START_DELAY = 67;
    private ValueAnimator animator;
    private boolean areCornerRadiiRtl;
    private MaterialShapeDrawable boxBackground;
    private boolean boxBackgroundApplied;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    private MaterialShapeDrawable boxUnderlineDefault;
    private MaterialShapeDrawable boxUnderlineFocused;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    private ColorStateList counterTextColor;
    private TextView counterView;
    private ColorStateList cursorColor;
    private ColorStateList cursorErrorColor;
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;
    private int defaultStrokeColor;
    private int disabledColor;
    private int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet editTextAttachedListeners;
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final EndCompoundLayout endLayout;
    private boolean expandedHintEnabled;
    private StateListDrawable filledDropDownMenuBackground;
    private int focusedFilledBackgroundColor;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean globalLayoutListenerAdded;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private int hoveredFilledBackgroundColor;
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private LengthCounter lengthCounter;
    private int maxEms;
    private int maxWidth;
    private int minEms;
    private int minWidth;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private MaterialShapeDrawable outlinedDropDownMenuBackground;
    private boolean placeholderEnabled;
    private Fade placeholderFadeIn;
    private Fade placeholderFadeOut;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;
    private boolean restoringSavedState;
    private ShapeAppearanceModel shapeAppearanceModel;
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private final StartCompoundLayout startLayout;
    private ColorStateList strokeErrorColor;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    static {
        TextInputLayout.DEF_STYLE_RES = style.Widget_Design_TextInputLayout;
        TextInputLayout.EDIT_TEXT_BACKGROUND_RIPPLE_STATE = new int[][]{new int[]{0x10100A7}, new int[0]};
    }

    public TextInputLayout(Context arg2) {
        this(arg2, null);
    }

    public TextInputLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.textInputStyle);
    }

    public TextInputLayout(Context arg17, AttributeSet arg18, int arg19) {
        int v11_1;
        TextInputLayout v0 = this;
        AttributeSet v2 = arg18;
        int v4 = arg19;
        int v5 = TextInputLayout.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg17, v2, v4, v5), v2, v4);
        int v7 = -1;
        v0.minEms = v7;
        v0.maxEms = v7;
        v0.minWidth = v7;
        v0.maxWidth = v7;
        v0.indicatorViewController = new IndicatorViewController(v0);
        v0.lengthCounter = new TextInputLayout$$ExternalSyntheticLambda1();
        v0.tmpRect = new Rect();
        v0.tmpBoundsRect = new Rect();
        v0.tmpRectF = new RectF();
        v0.editTextAttachedListeners = new LinkedHashSet();
        CollapsingTextHelper v1 = new CollapsingTextHelper(((View)v0));
        v0.collapsingTextHelper = v1;
        v0.globalLayoutListenerAdded = false;
        Context v3 = v0.getContext();
        v0.setOrientation(1);
        v0.setWillNotDraw(false);
        v0.setAddStatesFromChildren(true);
        FrameLayout v10 = new FrameLayout(v3);
        v0.inputFrame = v10;
        v10.setAddStatesFromChildren(true);
        v1.setTextSizeInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        v1.setPositionInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        v1.setCollapsedTextGravity(0x800033);
        Context v1_1 = v3;
        TintTypedArray v3_1 = ThemeEnforcement.obtainTintedStyledAttributes(v1_1, v2, styleable.TextInputLayout, v4, v5, new int[]{styleable.TextInputLayout_counterTextAppearance, styleable.TextInputLayout_counterOverflowTextAppearance, styleable.TextInputLayout_errorTextAppearance, styleable.TextInputLayout_helperTextTextAppearance, styleable.TextInputLayout_hintTextAppearance});
        StartCompoundLayout v6 = new StartCompoundLayout(v0, v3_1);
        v0.startLayout = v6;
        v0.hintEnabled = v3_1.getBoolean(styleable.TextInputLayout_hintEnabled, true);
        v0.setHint(v3_1.getText(styleable.TextInputLayout_android_hint));
        v0.hintAnimationEnabled = v3_1.getBoolean(styleable.TextInputLayout_hintAnimationEnabled, true);
        v0.expandedHintEnabled = v3_1.getBoolean(styleable.TextInputLayout_expandedHintEnabled, true);
        if(v3_1.hasValue(styleable.TextInputLayout_android_minEms)) {
            v0.setMinEms(v3_1.getInt(styleable.TextInputLayout_android_minEms, v7));
        }
        else if(v3_1.hasValue(styleable.TextInputLayout_android_minWidth)) {
            v0.setMinWidth(v3_1.getDimensionPixelSize(styleable.TextInputLayout_android_minWidth, v7));
        }

        if(v3_1.hasValue(styleable.TextInputLayout_android_maxEms)) {
            v0.setMaxEms(v3_1.getInt(styleable.TextInputLayout_android_maxEms, v7));
        }
        else if(v3_1.hasValue(styleable.TextInputLayout_android_maxWidth)) {
            v0.setMaxWidth(v3_1.getDimensionPixelSize(styleable.TextInputLayout_android_maxWidth, v7));
        }

        v0.shapeAppearanceModel = ShapeAppearanceModel.builder(v1_1, v2, v4, v5).build();
        v0.boxLabelCutoutPaddingPx = v1_1.getResources().getDimensionPixelOffset(dimen.mtrl_textinput_box_label_cutout_padding);
        v0.boxCollapsedPaddingTopPx = v3_1.getDimensionPixelOffset(styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        v0.boxStrokeWidthDefaultPx = v3_1.getDimensionPixelSize(styleable.TextInputLayout_boxStrokeWidth, v1_1.getResources().getDimensionPixelSize(dimen.mtrl_textinput_box_stroke_width_default));
        v0.boxStrokeWidthFocusedPx = v3_1.getDimensionPixelSize(styleable.TextInputLayout_boxStrokeWidthFocused, v1_1.getResources().getDimensionPixelSize(dimen.mtrl_textinput_box_stroke_width_focused));
        v0.boxStrokeWidthPx = v0.boxStrokeWidthDefaultPx;
        float v2_1 = v3_1.getDimension(styleable.TextInputLayout_boxCornerRadiusTopStart, -1f);
        float v5_1 = v3_1.getDimension(styleable.TextInputLayout_boxCornerRadiusTopEnd, -1f);
        float v11 = v3_1.getDimension(styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1f);
        float v4_1 = v3_1.getDimension(styleable.TextInputLayout_boxCornerRadiusBottomStart, -1f);
        Builder v12 = v0.shapeAppearanceModel.toBuilder();
        if(v2_1 >= 0f) {
            v12.setTopLeftCornerSize(v2_1);
        }

        if(v5_1 >= 0f) {
            v12.setTopRightCornerSize(v5_1);
        }

        if(v11 >= 0f) {
            v12.setBottomRightCornerSize(v11);
        }

        if(v4_1 >= 0f) {
            v12.setBottomLeftCornerSize(v4_1);
        }

        v0.shapeAppearanceModel = v12.build();
        ColorStateList v2_2 = MaterialResources.getColorStateList(v1_1, v3_1, styleable.TextInputLayout_boxBackgroundColor);
        if(v2_2 != null) {
            v4 = v2_2.getDefaultColor();
            v0.defaultFilledBackgroundColor = v4;
            v0.boxBackgroundColor = v4;
            v5 = 0x1010367;
            v11_1 = 0xFEFEFF62;
            if(v2_2.isStateful()) {
                v0.disabledFilledBackgroundColor = v2_2.getColorForState(new int[]{v11_1}, v7);
                v0.focusedFilledBackgroundColor = v2_2.getColorForState(new int[]{0x101009C, 0x101009E}, v7);
                v0.hoveredFilledBackgroundColor = v2_2.getColorForState(new int[]{v5, 0x101009E}, v7);
            }
            else {
                v0.focusedFilledBackgroundColor = v0.defaultFilledBackgroundColor;
                v2_2 = AppCompatResources.getColorStateList(v1_1, color.mtrl_filled_background_color);
                v0.disabledFilledBackgroundColor = v2_2.getColorForState(new int[]{v11_1}, v7);
                v0.hoveredFilledBackgroundColor = v2_2.getColorForState(new int[]{v5}, v7);
            }
        }
        else {
            v0.boxBackgroundColor = 0;
            v0.defaultFilledBackgroundColor = 0;
            v0.disabledFilledBackgroundColor = 0;
            v0.focusedFilledBackgroundColor = 0;
            v0.hoveredFilledBackgroundColor = 0;
        }

        if(v3_1.hasValue(styleable.TextInputLayout_android_textColorHint)) {
            v2_2 = v3_1.getColorStateList(styleable.TextInputLayout_android_textColorHint);
            v0.focusedTextColor = v2_2;
            v0.defaultHintTextColor = v2_2;
        }

        v2_2 = MaterialResources.getColorStateList(v1_1, v3_1, styleable.TextInputLayout_boxStrokeColor);
        v0.focusedStrokeColor = v3_1.getColor(styleable.TextInputLayout_boxStrokeColor, 0);
        v0.defaultStrokeColor = ContextCompat.getColor(v1_1, color.mtrl_textinput_default_box_stroke_color);
        v0.disabledColor = ContextCompat.getColor(v1_1, color.mtrl_textinput_disabled_color);
        v0.hoveredStrokeColor = ContextCompat.getColor(v1_1, color.mtrl_textinput_hovered_box_stroke_color);
        if(v2_2 != null) {
            v0.setBoxStrokeColorStateList(v2_2);
        }

        if(v3_1.hasValue(styleable.TextInputLayout_boxStrokeErrorColor)) {
            v0.setBoxStrokeErrorColor(MaterialResources.getColorStateList(v1_1, v3_1, styleable.TextInputLayout_boxStrokeErrorColor));
        }

        if(v3_1.getResourceId(styleable.TextInputLayout_hintTextAppearance, v7) != v7) {
            v0.setHintTextAppearance(v3_1.getResourceId(styleable.TextInputLayout_hintTextAppearance, 0));
        }

        v0.cursorColor = v3_1.getColorStateList(styleable.TextInputLayout_cursorColor);
        v0.cursorErrorColor = v3_1.getColorStateList(styleable.TextInputLayout_cursorErrorColor);
        int v1_2 = v3_1.getResourceId(styleable.TextInputLayout_errorTextAppearance, 0);
        CharSequence v2_3 = v3_1.getText(styleable.TextInputLayout_errorContentDescription);
        v4 = v3_1.getInt(styleable.TextInputLayout_errorAccessibilityLiveRegion, 1);
        boolean v5_2 = v3_1.getBoolean(styleable.TextInputLayout_errorEnabled, false);
        v11_1 = v3_1.getResourceId(styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean v12_1 = v3_1.getBoolean(styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence v13 = v3_1.getText(styleable.TextInputLayout_helperText);
        int v14 = v3_1.getResourceId(styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence v15 = v3_1.getText(styleable.TextInputLayout_placeholderText);
        boolean v9 = v3_1.getBoolean(styleable.TextInputLayout_counterEnabled, false);
        v0.setCounterMaxLength(v3_1.getInt(styleable.TextInputLayout_counterMaxLength, v7));
        v0.counterTextAppearance = v3_1.getResourceId(styleable.TextInputLayout_counterTextAppearance, 0);
        v0.counterOverflowTextAppearance = v3_1.getResourceId(styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        v0.setBoxBackgroundMode(v3_1.getInt(styleable.TextInputLayout_boxBackgroundMode, 0));
        v0.setErrorContentDescription(v2_3);
        v0.setErrorAccessibilityLiveRegion(v4);
        v0.setCounterOverflowTextAppearance(v0.counterOverflowTextAppearance);
        v0.setHelperTextTextAppearance(v11_1);
        v0.setErrorTextAppearance(v1_2);
        v0.setCounterTextAppearance(v0.counterTextAppearance);
        v0.setPlaceholderText(v15);
        v0.setPlaceholderTextAppearance(v14);
        if(v3_1.hasValue(styleable.TextInputLayout_errorTextColor)) {
            v0.setErrorTextColor(v3_1.getColorStateList(styleable.TextInputLayout_errorTextColor));
        }

        if(v3_1.hasValue(styleable.TextInputLayout_helperTextTextColor)) {
            v0.setHelperTextColor(v3_1.getColorStateList(styleable.TextInputLayout_helperTextTextColor));
        }

        if(v3_1.hasValue(styleable.TextInputLayout_hintTextColor)) {
            v0.setHintTextColor(v3_1.getColorStateList(styleable.TextInputLayout_hintTextColor));
        }

        if(v3_1.hasValue(styleable.TextInputLayout_counterTextColor)) {
            v0.setCounterTextColor(v3_1.getColorStateList(styleable.TextInputLayout_counterTextColor));
        }

        if(v3_1.hasValue(styleable.TextInputLayout_counterOverflowTextColor)) {
            v0.setCounterOverflowTextColor(v3_1.getColorStateList(styleable.TextInputLayout_counterOverflowTextColor));
        }

        if(v3_1.hasValue(styleable.TextInputLayout_placeholderTextColor)) {
            v0.setPlaceholderTextColor(v3_1.getColorStateList(styleable.TextInputLayout_placeholderTextColor));
        }

        EndCompoundLayout v1_3 = new EndCompoundLayout(v0, v3_1);
        v0.endLayout = v1_3;
        boolean v2_4 = v3_1.getBoolean(styleable.TextInputLayout_android_enabled, true);
        v3_1.recycle();
        ViewCompat.setImportantForAccessibility(((View)v0), 2);
        ViewCompat.setImportantForAutofill(((View)v0), 1);
        v10.addView(((View)v6));
        v10.addView(((View)v1_3));
        v0.addView(((View)v10));
        v0.setEnabled(v2_4);
        v0.setHelperTextEnabled(v12_1);
        v0.setErrorEnabled(v5_2);
        v0.setCounterEnabled(v9);
        v0.setHelperText(v13);
    }

    static boolean access$000(TextInputLayout arg0) {
        return arg0.restoringSavedState;
    }

    static boolean access$100(TextInputLayout arg0) {
        return arg0.placeholderEnabled;
    }

    static void access$200(TextInputLayout arg0, Editable arg1) {
        arg0.updatePlaceholderText(arg1);
    }

    static EndCompoundLayout access$300(TextInputLayout arg0) {
        return arg0.endLayout;
    }

    static StartCompoundLayout access$400(TextInputLayout arg0) {
        return arg0.startLayout;
    }

    static IndicatorViewController access$500(TextInputLayout arg0) {
        return arg0.indicatorViewController;
    }

    public void addOnEditTextAttachedListener(OnEditTextAttachedListener arg2) {
        this.editTextAttachedListeners.add(arg2);
        if(this.editText != null) {
            arg2.onEditTextAttached(this);
        }
    }

    public void addOnEndIconChangedListener(OnEndIconChangedListener arg1) {
        this.endLayout.addOnEndIconChangedListener(arg1);
    }

    private void addPlaceholderTextView() {
        TextView v0 = this.placeholderTextView;
        if(v0 != null) {
            this.inputFrame.addView(((View)v0));
            this.placeholderTextView.setVisibility(0);
        }
    }

    public void addView(View arg2, int arg3, ViewGroup$LayoutParams arg4) {
        if((arg2 instanceof EditText)) {
            FrameLayout$LayoutParams v3 = new FrameLayout$LayoutParams(arg4);
            v3.gravity = v3.gravity & 0xFFFFFF8F | 16;
            this.inputFrame.addView(arg2, ((ViewGroup$LayoutParams)v3));
            this.inputFrame.setLayoutParams(arg4);
            this.updateInputLayoutMargins();
            this.setEditText(((EditText)arg2));
            return;
        }

        super.addView(arg2, arg3, arg4);
    }

    private void adjustFilledEditTextPaddingForLargeFont() {
        if(this.editText != null) {
            if(this.boxBackgroundMode != 1) {
            }
            else if(MaterialResources.isFontScaleAtLeast2_0(this.getContext())) {
                ViewCompat.setPaddingRelative(this.editText, ViewCompat.getPaddingStart(this.editText), this.getResources().getDimensionPixelSize(dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.editText), this.getResources().getDimensionPixelSize(dimen.material_filled_edittext_font_2_0_padding_bottom));
                return;
            }
            else if(MaterialResources.isFontScaleAtLeast1_3(this.getContext())) {
                ViewCompat.setPaddingRelative(this.editText, ViewCompat.getPaddingStart(this.editText), this.getResources().getDimensionPixelSize(dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.editText), this.getResources().getDimensionPixelSize(dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    void animateToExpansionFraction(float arg5) {
        if(this.collapsingTextHelper.getExpansionFraction() == arg5) {
            return;
        }

        if(this.animator == null) {
            ValueAnimator v0 = new ValueAnimator();
            this.animator = v0;
            v0.setInterpolator(MotionUtils.resolveThemeInterpolator(this.getContext(), attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            this.animator.setDuration(((long)MotionUtils.resolveThemeDuration(this.getContext(), attr.motionDurationMedium4, 0xA7)));
            this.animator.addUpdateListener(new ValueAnimator$AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator arg1) {
                    TextInputLayout.this.collapsingTextHelper.setExpansionFraction(arg1.getAnimatedValue().floatValue());
                }
            });
        }

        this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), arg5});
        this.animator.start();
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable v0 = this.boxBackground;
        if(v0 == null) {
            return;
        }

        ShapeAppearanceModel v0_1 = v0.getShapeAppearanceModel();
        ShapeAppearanceModel v1 = this.shapeAppearanceModel;
        if(v0_1 != v1) {
            this.boxBackground.setShapeAppearanceModel(v1);
        }

        if(this.canDrawOutlineStroke()) {
            this.boxBackground.setStroke(((float)this.boxStrokeWidthPx), this.boxStrokeColor);
        }

        int v0_2 = this.calculateBoxBackgroundColor();
        this.boxBackgroundColor = v0_2;
        this.boxBackground.setFillColor(ColorStateList.valueOf(v0_2));
        this.applyBoxUnderlineAttributes();
        this.updateEditTextBoxBackgroundIfNeeded();
    }

    private void applyBoxUnderlineAttributes() {
        if(this.boxUnderlineDefault != null) {
            if(this.boxUnderlineFocused == null) {
            }
            else {
                if(this.canDrawStroke()) {
                    MaterialShapeDrawable v0 = this.boxUnderlineDefault;
                    ColorStateList v1 = this.editText.isFocused() ? ColorStateList.valueOf(this.defaultStrokeColor) : ColorStateList.valueOf(this.boxStrokeColor);
                    v0.setFillColor(v1);
                    this.boxUnderlineFocused.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
                }

                this.invalidate();
            }
        }
    }

    private void applyCutoutPadding(RectF arg3) {
        arg3.left -= ((float)this.boxLabelCutoutPaddingPx);
        arg3.right += ((float)this.boxLabelCutoutPaddingPx);
    }

    private void assignBoxBackgroundByMode() {
        int v0 = this.boxBackgroundMode;
        MaterialShapeDrawable v1 = null;
        if(v0 != 0) {
            if(v0 != 1) {
                if(v0 == 2) {
                    this.boxBackground = !this.hintEnabled || ((this.boxBackground instanceof CutoutDrawable)) ? new MaterialShapeDrawable(this.shapeAppearanceModel) : CutoutDrawable.create(this.shapeAppearanceModel);
                    this.boxUnderlineDefault = v1;
                    this.boxUnderlineFocused = v1;
                    return;
                }

                throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
            }

            this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderlineDefault = new MaterialShapeDrawable();
            this.boxUnderlineFocused = new MaterialShapeDrawable();
            return;
        }

        this.boxBackground = v1;
        this.boxUnderlineDefault = v1;
        this.boxUnderlineFocused = v1;
    }

    private int calculateBoxBackgroundColor() {
        int v0 = this.boxBackgroundColor;
        if(this.boxBackgroundMode == 1) {
            return MaterialColors.layer(MaterialColors.getColor(((View)this), attr.colorSurface, 0), this.boxBackgroundColor);
        }

        return v0;
    }

    private Rect calculateCollapsedTextBounds(Rect arg5) {
        if(this.editText != null) {
            Rect v0 = this.tmpBoundsRect;
            boolean v1 = ViewUtils.isLayoutRtl(((View)this));
            v0.bottom = arg5.bottom;
            int v2 = this.boxBackgroundMode;
            if(v2 != 1) {
                if(v2 != 2) {
                    v0.left = this.getLabelLeftBoundAlignedWithPrefixAndSuffix(arg5.left, v1);
                    v0.top = this.getPaddingTop();
                    v0.right = this.getLabelRightBoundAlignedWithPrefixAndSuffix(arg5.right, v1);
                    return v0;
                }

                v0.left = arg5.left + this.editText.getPaddingLeft();
                v0.top = arg5.top - this.calculateLabelMarginTop();
                v0.right = arg5.right - this.editText.getPaddingRight();
                return v0;
            }

            v0.left = this.getLabelLeftBoundAlignedWithPrefixAndSuffix(arg5.left, v1);
            v0.top = arg5.top + this.boxCollapsedPaddingTopPx;
            v0.right = this.getLabelRightBoundAlignedWithPrefixAndSuffix(arg5.right, v1);
            return v0;
        }

        throw new IllegalStateException();
    }

    private int calculateExpandedLabelBottom(Rect arg2, Rect arg3, float arg4) {
        if(this.isSingleLineFilledTextField()) {
            return ((int)((((float)arg3.top)) + arg4));
        }

        return arg2.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(Rect arg2, float arg3) {
        if(this.isSingleLineFilledTextField()) {
            return ((int)((((float)arg2.centerY())) - arg3 / 2f));
        }

        return arg2.top + this.editText.getCompoundPaddingTop();
    }

    private Rect calculateExpandedTextBounds(Rect arg5) {
        if(this.editText != null) {
            Rect v0 = this.tmpBoundsRect;
            float v1 = this.collapsingTextHelper.getExpandedTextHeight();
            v0.left = arg5.left + this.editText.getCompoundPaddingLeft();
            v0.top = this.calculateExpandedLabelTop(arg5, v1);
            v0.right = arg5.right - this.editText.getCompoundPaddingRight();
            v0.bottom = this.calculateExpandedLabelBottom(arg5, v0, v1);
            return v0;
        }

        throw new IllegalStateException();
    }

    private int calculateLabelMarginTop() {
        float v3;
        if(!this.hintEnabled) {
            return 0;
        }

        int v0 = this.boxBackgroundMode;
        if(v0 == 0) {
            v3 = this.collapsingTextHelper.getCollapsedTextHeight();
        }
        else if(v0 != 2) {
            return 0;
        }
        else {
            v3 = this.collapsingTextHelper.getCollapsedTextHeight() / 2f;
        }

        return ((int)v3);
    }

    private boolean canDrawOutlineStroke() {
        if(this.boxBackgroundMode == 2 && (this.canDrawStroke())) {
            return 1;
        }

        return 0;
    }

    private boolean canDrawStroke() {
        if(this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0) {
            return 1;
        }

        return 0;
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endLayout.clearOnEndIconChangedListeners();
    }

    private void closeCutout() {
        if(this.cutoutEnabled()) {
            this.boxBackground.removeCutout();
        }
    }

    private void collapseHint(boolean arg2) {
        ValueAnimator v0 = this.animator;
        if(v0 != null && (v0.isRunning())) {
            this.animator.cancel();
        }

        float v0_1 = 1f;
        if(!arg2 || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(v0_1);
        }
        else {
            this.animateToExpansionFraction(v0_1);
        }

        this.hintExpanded = false;
        if(this.cutoutEnabled()) {
            this.openCutout();
        }

        this.updatePlaceholderText();
        this.startLayout.onHintStateChanged(false);
        this.endLayout.onHintStateChanged(false);
    }

    private Fade createPlaceholderFadeTransition() {
        Fade v0 = new Fade();
        v0.setDuration(((long)MotionUtils.resolveThemeDuration(this.getContext(), attr.motionDurationShort2, 87)));
        v0.setInterpolator(MotionUtils.resolveThemeInterpolator(this.getContext(), attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR));
        return v0;
    }

    private boolean cutoutEnabled() {
        if((this.hintEnabled) && !TextUtils.isEmpty(this.hint) && ((this.boxBackground instanceof CutoutDrawable))) {
            return 1;
        }

        return 0;
    }

    boolean cutoutIsOpen() {
        if((this.cutoutEnabled()) && (this.boxBackground.hasCutout())) {
            return 1;
        }

        return 0;
    }

    private void dispatchOnEditTextAttached() {
        Iterator v0 = this.editTextAttachedListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onEditTextAttached(this);
        }
    }

    public void dispatchProvideAutofillStructure(ViewStructure arg5, int arg6) {
        EditText v0 = this.editText;
        if(v0 == null) {
            super.dispatchProvideAutofillStructure(arg5, arg6);
            return;
        }

        int v2 = 0;
        if(this.originalHint != null) {
            boolean v1 = this.isProvidingHint;
            this.isProvidingHint = false;
            CharSequence v0_1 = v0.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(arg5, arg6);
            }
            catch(Throwable v5) {
                this.editText.setHint(v0_1);
                this.isProvidingHint = v1;
                throw v5;
            }

            this.editText.setHint(v0_1);
            this.isProvidingHint = v1;
            return;
        }

        arg5.setAutofillId(this.getAutofillId());
        this.onProvideAutofillStructure(arg5, arg6);
        this.onProvideAutofillVirtualStructure(arg5, arg6);
        arg5.setChildCount(this.inputFrame.getChildCount());
        while(v2 < this.inputFrame.getChildCount()) {
            View v0_2 = this.inputFrame.getChildAt(v2);
            ViewStructure v1_1 = arg5.newChild(v2);
            v0_2.dispatchProvideAutofillStructure(v1_1, arg6);
            if(v0_2 == this.editText) {
                v1_1.setHint(this.getHint());
            }

            ++v2;
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray arg2) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(arg2);
        this.restoringSavedState = false;
    }

    public void draw(Canvas arg1) {
        super.draw(arg1);
        this.drawHint(arg1);
        this.drawBoxUnderline(arg1);
    }

    private void drawBoxUnderline(Canvas arg6) {
        if(this.boxUnderlineFocused != null) {
            MaterialShapeDrawable v0 = this.boxUnderlineDefault;
            if(v0 != null) {
                v0.draw(arg6);
                if(this.editText.isFocused()) {
                    Rect v0_1 = this.boxUnderlineFocused.getBounds();
                    Rect v1 = this.boxUnderlineDefault.getBounds();
                    float v2 = this.collapsingTextHelper.getExpansionFraction();
                    int v3 = v1.centerX();
                    v0_1.left = AnimationUtils.lerp(v3, v1.left, v2);
                    v0_1.right = AnimationUtils.lerp(v3, v1.right, v2);
                    this.boxUnderlineFocused.draw(arg6);
                }
            }
        }
    }

    private void drawHint(Canvas arg2) {
        if(this.hintEnabled) {
            this.collapsingTextHelper.draw(arg2);
        }
    }

    protected void drawableStateChanged() {
        if(this.inDrawableStateChanged) {
            return;
        }

        boolean v0 = true;
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] v1 = this.getDrawableState();
        CollapsingTextHelper v2 = this.collapsingTextHelper;
        boolean v1_1 = v2 != null ? v2.setState(v1) : false;
        if(this.editText != null) {
            if(!ViewCompat.isLaidOut(((View)this)) || !this.isEnabled()) {
                v0 = false;
            }
            else {
            }

            this.updateLabelState(v0);
        }

        this.updateEditTextBackground();
        this.updateTextInputBoxState();
        if(v1_1) {
            this.invalidate();
        }

        this.inDrawableStateChanged = false;
    }

    private void expandHint(boolean arg2) {
        ValueAnimator v0 = this.animator;
        if(v0 != null && (v0.isRunning())) {
            this.animator.cancel();
        }

        if(!arg2 || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(0f);
        }
        else {
            this.animateToExpansionFraction(0f);
        }

        if((this.cutoutEnabled()) && (this.boxBackground.hasCutout())) {
            this.closeCutout();
        }

        this.hintExpanded = true;
        this.hidePlaceholderText();
        this.startLayout.onHintStateChanged(true);
        this.endLayout.onHintStateChanged(true);
    }

    public int getBaseline() {
        EditText v0 = this.editText;
        if(v0 != null) {
            return v0.getBaseline() + this.getPaddingTop() + this.calculateLabelMarginTop();
        }

        return super.getBaseline();
    }

    MaterialShapeDrawable getBoxBackground() {
        int v0 = this.boxBackgroundMode;
        if(v0 != 1) {
            if(v0 == 2) {
            }
            else {
                throw new IllegalStateException();
            }
        }

        return this.boxBackground;
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.boxCollapsedPaddingTopPx;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean v0 = ViewUtils.isLayoutRtl(((View)this));
        ShapeAppearanceModel v1 = this.shapeAppearanceModel;
        if(v0) {
            return v1.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
        }

        return v1.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean v0 = ViewUtils.isLayoutRtl(((View)this));
        ShapeAppearanceModel v1 = this.shapeAppearanceModel;
        if(v0) {
            return v1.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
        }

        return v1.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean v0 = ViewUtils.isLayoutRtl(((View)this));
        ShapeAppearanceModel v1 = this.shapeAppearanceModel;
        if(v0) {
            return v1.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
        }

        return v1.getTopRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean v0 = ViewUtils.isLayoutRtl(((View)this));
        ShapeAppearanceModel v1 = this.shapeAppearanceModel;
        if(v0) {
            return v1.getTopRightCornerSize().getCornerSize(this.tmpRectF);
        }

        return v1.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    CharSequence getCounterOverflowDescription() {
        if((this.counterEnabled) && (this.counterOverflowed)) {
            TextView v1 = this.counterView;
            if(v1 != null) {
                return v1.getContentDescription();
            }
        }

        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterOverflowTextColor;
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getCursorColor() {
        return this.cursorColor;
    }

    public ColorStateList getCursorErrorColor() {
        return this.cursorErrorColor;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    private MaterialShapeDrawable getDropDownMaterialShapeDrawable(boolean arg5) {
        float v0 = ((float)this.getResources().getDimensionPixelOffset(dimen.mtrl_shape_corner_size_small_component));
        float v5 = arg5 ? v0 : 0f;
        EditText v1 = this.editText;
        float v1_1 = (v1 instanceof MaterialAutoCompleteTextView) ? ((MaterialAutoCompleteTextView)v1).getPopupElevation() : ((float)this.getResources().getDimensionPixelOffset(dimen.m3_comp_outlined_autocomplete_menu_container_elevation));
        int v2 = this.getResources().getDimensionPixelOffset(dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ShapeAppearanceModel v5_1 = ShapeAppearanceModel.builder().setTopLeftCornerSize(v5).setTopRightCornerSize(v5).setBottomLeftCornerSize(v0).setBottomRightCornerSize(v0).build();
        EditText v0_1 = this.editText;
        ColorStateList v0_2 = (v0_1 instanceof MaterialAutoCompleteTextView) ? ((MaterialAutoCompleteTextView)v0_1).getDropDownBackgroundTintList() : null;
        MaterialShapeDrawable v4 = MaterialShapeDrawable.createWithElevationOverlay(this.getContext(), v1_1, v0_2);
        v4.setShapeAppearanceModel(v5_1);
        v4.setPadding(0, v2, 0, v2);
        return v4;
    }

    public EditText getEditText() {
        return this.editText;
    }

    private Drawable getEditTextBoxBackground() {
        EditText v0 = this.editText;
        if((v0 instanceof AutoCompleteTextView)) {
            if(EditTextUtils.isEditable(v0)) {
            }
            else {
                int v0_1 = MaterialColors.getColor(this.editText, attr.colorControlHighlight);
                int v1 = this.boxBackgroundMode;
                if(v1 == 2) {
                    return TextInputLayout.getOutlinedBoxBackgroundWithRipple(this.getContext(), this.boxBackground, v0_1, TextInputLayout.EDIT_TEXT_BACKGROUND_RIPPLE_STATE);
                }
                else if(v1 == 1) {
                    return TextInputLayout.getFilledBoxBackgroundWithRipple(this.boxBackground, this.boxBackgroundColor, v0_1, TextInputLayout.EDIT_TEXT_BACKGROUND_RIPPLE_STATE);
                }
                else {
                    return null;
                }
            }
        }

        return this.boxBackground;
    }

    public CharSequence getEndIconContentDescription() {
        return this.endLayout.getEndIconContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.endLayout.getEndIconDrawable();
    }

    public int getEndIconMinSize() {
        return this.endLayout.getEndIconMinSize();
    }

    public int getEndIconMode() {
        return this.endLayout.getEndIconMode();
    }

    public ImageView$ScaleType getEndIconScaleType() {
        return this.endLayout.getEndIconScaleType();
    }

    CheckableImageButton getEndIconView() {
        return this.endLayout.getEndIconView();
    }

    public CharSequence getError() {
        if(this.indicatorViewController.isErrorEnabled()) {
            return this.indicatorViewController.getErrorText();
        }

        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.indicatorViewController.getErrorAccessibilityLiveRegion();
    }

    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.getErrorContentDescription();
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public Drawable getErrorIconDrawable() {
        return this.endLayout.getErrorIconDrawable();
    }

    private static Drawable getFilledBoxBackgroundWithRipple(MaterialShapeDrawable arg1, int arg2, int arg3, int[][] arg4) {
        return new RippleDrawable(new ColorStateList(arg4, new int[]{MaterialColors.layer(arg3, arg2, 0.1f), arg2}), ((Drawable)arg1), ((Drawable)arg1));
    }

    public CharSequence getHelperText() {
        if(this.indicatorViewController.isHelperTextEnabled()) {
            return this.indicatorViewController.getHelperText();
        }

        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    public CharSequence getHint() {
        if(this.hintEnabled) {
            return this.hint;
        }

        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    private int getLabelLeftBoundAlignedWithPrefixAndSuffix(int arg2, boolean arg3) {
        int v1;
        if((arg3) || this.getPrefixText() == null) {
            if((arg3) && this.getSuffixText() != null) {
                v1 = this.endLayout.getSuffixTextEndOffset();
                goto label_5;
            }

            v1 = this.editText.getCompoundPaddingLeft();
        }
        else {
            v1 = this.startLayout.getPrefixTextStartOffset();
        }

    label_5:
        return arg2 + v1;
    }

    private int getLabelRightBoundAlignedWithPrefixAndSuffix(int arg2, boolean arg3) {
        int v1;
        if((arg3) || this.getSuffixText() == null) {
            if((arg3) && this.getPrefixText() != null) {
                v1 = this.startLayout.getPrefixTextStartOffset();
                goto label_5;
            }

            v1 = this.editText.getCompoundPaddingRight();
        }
        else {
            v1 = this.endLayout.getSuffixTextEndOffset();
        }

    label_5:
        return arg2 - v1;
    }

    public LengthCounter getLengthCounter() {
        return this.lengthCounter;
    }

    public int getMaxEms() {
        return this.maxEms;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMinEms() {
        return this.minEms;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if(this.filledDropDownMenuBackground == null) {
            StateListDrawable v0 = new StateListDrawable();
            this.filledDropDownMenuBackground = v0;
            v0.addState(new int[]{0x10100AA}, this.getOrCreateOutlinedDropDownMenuBackground());
            this.filledDropDownMenuBackground.addState(new int[0], this.getDropDownMaterialShapeDrawable(false));
        }

        return this.filledDropDownMenuBackground;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        MaterialShapeDrawable v0 = this.outlinedDropDownMenuBackground;
        if(v0 == null) {
            v0 = this.getDropDownMaterialShapeDrawable(true);
            this.outlinedDropDownMenuBackground = v0;
        }

        return ((Drawable)v0);
    }

    private static Drawable getOutlinedBoxBackgroundWithRipple(Context arg4, MaterialShapeDrawable arg5, int arg6, int[][] arg7) {
        int v4 = MaterialColors.getColor(arg4, attr.colorSurface, "TextInputLayout");
        MaterialShapeDrawable v0 = new MaterialShapeDrawable(arg5.getShapeAppearanceModel());
        arg6 = MaterialColors.layer(arg6, v4, 0.1f);
        v0.setFillColor(new ColorStateList(arg7, new int[]{arg6, 0}));
        v0.setTint(v4);
        ColorStateList v6 = new ColorStateList(arg7, new int[]{arg6, v4});
        MaterialShapeDrawable v4_1 = new MaterialShapeDrawable(arg5.getShapeAppearanceModel());
        v4_1.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(v6, ((Drawable)v0), ((Drawable)v4_1)), arg5});
    }

    @Deprecated public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endLayout.getPasswordVisibilityToggleContentDescription();
    }

    @Deprecated public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endLayout.getPasswordVisibilityToggleDrawable();
    }

    public CharSequence getPlaceholderText() {
        if(this.placeholderEnabled) {
            return this.placeholderText;
        }

        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    public CharSequence getPrefixText() {
        return this.startLayout.getPrefixText();
    }

    public ColorStateList getPrefixTextColor() {
        return this.startLayout.getPrefixTextColor();
    }

    public TextView getPrefixTextView() {
        return this.startLayout.getPrefixTextView();
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    public CharSequence getStartIconContentDescription() {
        return this.startLayout.getStartIconContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.startLayout.getStartIconDrawable();
    }

    public int getStartIconMinSize() {
        return this.startLayout.getStartIconMinSize();
    }

    public ImageView$ScaleType getStartIconScaleType() {
        return this.startLayout.getStartIconScaleType();
    }

    public CharSequence getSuffixText() {
        return this.endLayout.getSuffixText();
    }

    public ColorStateList getSuffixTextColor() {
        return this.endLayout.getSuffixTextColor();
    }

    public TextView getSuffixTextView() {
        return this.endLayout.getSuffixTextView();
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    private void hidePlaceholderText() {
        TextView v0 = this.placeholderTextView;
        if(v0 != null && (this.placeholderEnabled)) {
            v0.setText(null);
            TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeOut);
            this.placeholderTextView.setVisibility(4);
        }
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endLayout.isEndIconCheckable();
    }

    public boolean isEndIconVisible() {
        return this.endLayout.isEndIconVisible();
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    private boolean isOnError() {
        if(!this.shouldShowError() && (this.counterView == null || !this.counterOverflowed)) {
            return 0;
        }

        return 1;
    }

    @Deprecated public boolean isPasswordVisibilityToggleEnabled() {
        return this.endLayout.isPasswordVisibilityToggleEnabled();
    }

    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    private boolean isSingleLineFilledTextField() {
        if(this.boxBackgroundMode == 1 && this.editText.getMinLines() <= 1) {
            return 1;
        }

        return 0;
    }

    public boolean isStartIconCheckable() {
        return this.startLayout.isStartIconCheckable();
    }

    public boolean isStartIconVisible() {
        return this.startLayout.isStartIconVisible();
    }

    static int lambda$new$0(Editable arg0) {
        if(arg0 != null) {
            return arg0.length();
        }

        return 0;
    }

    void lambda$onGlobalLayout$1$com-google-android-material-textfield-TextInputLayout() {
        this.editText.requestLayout();
    }

    private void onApplyBoxBackgroundMode() {
        this.assignBoxBackgroundByMode();
        this.updateEditTextBoxBackgroundIfNeeded();
        this.updateTextInputBoxState();
        this.updateBoxCollapsedPaddingTop();
        this.adjustFilledEditTextPaddingForLargeFont();
        if(this.boxBackgroundMode != 0) {
            this.updateInputLayoutMargins();
        }

        this.setDropDownMenuBackgroundIfNeeded();
    }

    protected void onConfigurationChanged(Configuration arg1) {
        super.onConfigurationChanged(arg1);
        this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(arg1);
    }

    public void onGlobalLayout() {
        this.endLayout.getViewTreeObserver().removeOnGlobalLayoutListener(((ViewTreeObserver$OnGlobalLayoutListener)this));
        this.globalLayoutListenerAdded = false;
        boolean v0 = this.updateEditTextHeightBasedOnIcon();
        boolean v1 = this.updateDummyDrawables();
        if(!v0) {
            if(v1) {
            }
            else {
                return;
            }
        }

        this.editText.post(new TextInputLayout$$ExternalSyntheticLambda0(this));
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        EditText v1 = this.editText;
        if(v1 != null) {
            Rect v2 = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(((ViewGroup)this), ((View)v1), v2);
            this.updateBoxUnderlineBounds(v2);
            if(this.hintEnabled) {
                this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
                int v1_1 = this.editText.getGravity();
                this.collapsingTextHelper.setCollapsedTextGravity(v1_1 & 0xFFFFFF8F | 0x30);
                this.collapsingTextHelper.setExpandedTextGravity(v1_1);
                this.collapsingTextHelper.setCollapsedBounds(this.calculateCollapsedTextBounds(v2));
                this.collapsingTextHelper.setExpandedBounds(this.calculateExpandedTextBounds(v2));
                this.collapsingTextHelper.recalculate();
                if((this.cutoutEnabled()) && !this.hintExpanded) {
                    this.openCutout();
                }
            }
        }
    }

    protected void onMeasure(int arg1, int arg2) {
        super.onMeasure(arg1, arg2);
        if(!this.globalLayoutListenerAdded) {
            this.endLayout.getViewTreeObserver().addOnGlobalLayoutListener(((ViewTreeObserver$OnGlobalLayoutListener)this));
            this.globalLayoutListenerAdded = true;
        }

        this.updatePlaceholderMeasurementsBasedOnEditText();
        this.endLayout.updateSuffixTextViewPadding();
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.setError(((SavedState)arg2).error);
        if(((SavedState)arg2).isEndIconChecked) {
            this.post(new Runnable() {
                public void run() {
                    TextInputLayout.this.endLayout.checkEndIcon();
                }
            });
        }

        this.requestLayout();
    }

    public void onRtlPropertiesChanged(int arg10) {
        super.onRtlPropertiesChanged(arg10);
        boolean v0 = true;
        if(arg10 == 1) {
        }
        else {
            v0 = false;
        }

        if(v0 != this.areCornerRadiiRtl) {
            ShapeAppearanceModel v10 = ShapeAppearanceModel.builder().setTopLeftCorner(this.shapeAppearanceModel.getTopRightCorner()).setTopRightCorner(this.shapeAppearanceModel.getTopLeftCorner()).setBottomLeftCorner(this.shapeAppearanceModel.getBottomRightCorner()).setBottomRightCorner(this.shapeAppearanceModel.getBottomLeftCorner()).setTopLeftCornerSize(this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF)).setTopRightCornerSize(this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF)).setBottomLeftCornerSize(this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF)).setBottomRightCornerSize(this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF)).build();
            this.areCornerRadiiRtl = v0;
            this.setShapeAppearanceModel(v10);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        if(this.shouldShowError()) {
            v1.error = this.getError();
        }

        v1.isEndIconChecked = this.endLayout.isEndIconChecked();
        return ((Parcelable)v1);
    }

    private void openCutout() {
        if(!this.cutoutEnabled()) {
        }
        else {
            RectF v0 = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextActualBounds(v0, this.editText.getWidth(), this.editText.getGravity());
            if(v0.width() > 0f) {
                if(v0.height() <= 0f) {
                }
                else {
                    this.applyCutoutPadding(v0);
                    v0.offset(((float)(-this.getPaddingLeft())), (((float)(-this.getPaddingTop()))) - v0.height() / 2f + (((float)this.boxStrokeWidthPx)));
                    this.boxBackground.setCutout(v0);
                }
            }
        }
    }

    @Deprecated public void passwordVisibilityToggleRequested(boolean arg1) {
        this.endLayout.togglePasswordVisibilityToggle(arg1);
    }

    private void recalculateCutout() {
        if((this.cutoutEnabled()) && !this.hintExpanded) {
            this.closeCutout();
            this.openCutout();
        }
    }

    private static void recursiveSetEnabled(ViewGroup arg4, boolean arg5) {
        int v0 = arg4.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = arg4.getChildAt(v1);
            v2.setEnabled(arg5);
            if((v2 instanceof ViewGroup)) {
                TextInputLayout.recursiveSetEnabled(((ViewGroup)v2), arg5);
            }
        }
    }

    public void refreshEndIconDrawableState() {
        this.endLayout.refreshEndIconDrawableState();
    }

    public void refreshErrorIconDrawableState() {
        this.endLayout.refreshErrorIconDrawableState();
    }

    public void refreshStartIconDrawableState() {
        this.startLayout.refreshStartIconDrawableState();
    }

    public void removeOnEditTextAttachedListener(OnEditTextAttachedListener arg1) {
        this.editTextAttachedListeners.remove(arg1);
    }

    public void removeOnEndIconChangedListener(OnEndIconChangedListener arg1) {
        this.endLayout.removeOnEndIconChangedListener(arg1);
    }

    private void removePlaceholderTextView() {
        TextView v1 = this.placeholderTextView;
        if(v1 != null) {
            v1.setVisibility(8);
        }
    }

    public void setBoxBackgroundColor(int arg2) {
        if(this.boxBackgroundColor != arg2) {
            this.boxBackgroundColor = arg2;
            this.defaultFilledBackgroundColor = arg2;
            this.focusedFilledBackgroundColor = arg2;
            this.hoveredFilledBackgroundColor = arg2;
            this.applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(int arg2) {
        this.setBoxBackgroundColor(ContextCompat.getColor(this.getContext(), arg2));
    }

    public void setBoxBackgroundColorStateList(ColorStateList arg4) {
        int v0 = arg4.getDefaultColor();
        this.defaultFilledBackgroundColor = v0;
        this.boxBackgroundColor = v0;
        this.disabledFilledBackgroundColor = arg4.getColorForState(new int[]{0xFEFEFF62}, -1);
        this.focusedFilledBackgroundColor = arg4.getColorForState(new int[]{0x101009C, 0x101009E}, -1);
        this.hoveredFilledBackgroundColor = arg4.getColorForState(new int[]{0x1010367, 0x101009E}, -1);
        this.applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int arg2) {
        if(arg2 == this.boxBackgroundMode) {
        }
        else {
            this.boxBackgroundMode = arg2;
            if(this.editText != null) {
                this.onApplyBoxBackgroundMode();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int arg1) {
        this.boxCollapsedPaddingTopPx = arg1;
    }

    public void setBoxCornerFamily(int arg3) {
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCorner(arg3, this.shapeAppearanceModel.getTopLeftCornerSize()).setTopRightCorner(arg3, this.shapeAppearanceModel.getTopRightCornerSize()).setBottomLeftCorner(arg3, this.shapeAppearanceModel.getBottomLeftCornerSize()).setBottomRightCorner(arg3, this.shapeAppearanceModel.getBottomRightCornerSize()).build();
        this.applyBoxAttributes();
    }

    public void setBoxCornerRadii(float arg3, float arg4, float arg5, float arg6) {
        boolean v0 = ViewUtils.isLayoutRtl(((View)this));
        this.areCornerRadiiRtl = v0;
        float v1 = v0 ? arg4 : arg3;
        if(v0) {
        }
        else {
            arg3 = arg4;
        }

        arg4 = v0 ? arg6 : arg5;
        if(v0) {
        }
        else {
            arg5 = arg6;
        }

        MaterialShapeDrawable v6 = this.boxBackground;
        if(v6 != null && v6.getTopLeftCornerResolvedSize() == v1 && this.boxBackground.getTopRightCornerResolvedSize() == arg3 && this.boxBackground.getBottomLeftCornerResolvedSize() == arg4) {
            if(this.boxBackground.getBottomRightCornerResolvedSize() != arg5) {
            }
            else {
                return;
            }
        }

        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(v1).setTopRightCornerSize(arg3).setBottomLeftCornerSize(arg4).setBottomRightCornerSize(arg5).build();
        this.applyBoxAttributes();
    }

    public void setBoxCornerRadiiResources(int arg2, int arg3, int arg4, int arg5) {
        this.setBoxCornerRadii(this.getContext().getResources().getDimension(arg2), this.getContext().getResources().getDimension(arg3), this.getContext().getResources().getDimension(arg5), this.getContext().getResources().getDimension(arg4));
    }

    public void setBoxStrokeColor(int arg2) {
        if(this.focusedStrokeColor != arg2) {
            this.focusedStrokeColor = arg2;
            this.updateTextInputBoxState();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList arg4) {
        if(arg4.isStateful()) {
            this.defaultStrokeColor = arg4.getDefaultColor();
            this.disabledColor = arg4.getColorForState(new int[]{0xFEFEFF62}, -1);
            this.hoveredStrokeColor = arg4.getColorForState(new int[]{0x1010367, 0x101009E}, -1);
            this.focusedStrokeColor = arg4.getColorForState(new int[]{0x101009C, 0x101009E}, -1);
        }
        else if(this.focusedStrokeColor != arg4.getDefaultColor()) {
            this.focusedStrokeColor = arg4.getDefaultColor();
        }

        this.updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(ColorStateList arg2) {
        if(this.strokeErrorColor != arg2) {
            this.strokeErrorColor = arg2;
            this.updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidth(int arg1) {
        this.boxStrokeWidthDefaultPx = arg1;
        this.updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int arg1) {
        this.boxStrokeWidthFocusedPx = arg1;
        this.updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(int arg2) {
        this.setBoxStrokeWidthFocused(this.getResources().getDimensionPixelSize(arg2));
    }

    public void setBoxStrokeWidthResource(int arg2) {
        this.setBoxStrokeWidth(this.getResources().getDimensionPixelSize(arg2));
    }

    public void setCounterEnabled(boolean arg4) {
        if(this.counterEnabled != arg4) {
            int v0 = 2;
            if(arg4) {
                AppCompatTextView v1 = new AppCompatTextView(this.getContext());
                this.counterView = ((TextView)v1);
                ((TextView)v1).setId(id.textinput_counter);
                Typeface v1_1 = this.typeface;
                if(v1_1 != null) {
                    this.counterView.setTypeface(v1_1);
                }

                this.counterView.setMaxLines(1);
                this.indicatorViewController.addIndicator(this.counterView, v0);
                MarginLayoutParamsCompat.setMarginStart(this.counterView.getLayoutParams(), this.getResources().getDimensionPixelOffset(dimen.mtrl_textinput_counter_margin_start));
                this.updateCounterTextAppearanceAndColor();
                this.updateCounter();
            }
            else {
                this.indicatorViewController.removeIndicator(this.counterView, v0);
                this.counterView = null;
            }

            this.counterEnabled = arg4;
        }
    }

    public void setCounterMaxLength(int arg2) {
        if(this.counterMaxLength != arg2) {
            this.counterMaxLength = arg2 > 0 ? arg2 : -1;
            if(!this.counterEnabled) {
                return;
            }

            this.updateCounter();
        }
    }

    public void setCounterOverflowTextAppearance(int arg2) {
        if(this.counterOverflowTextAppearance != arg2) {
            this.counterOverflowTextAppearance = arg2;
            this.updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList arg2) {
        if(this.counterOverflowTextColor != arg2) {
            this.counterOverflowTextColor = arg2;
            this.updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int arg2) {
        if(this.counterTextAppearance != arg2) {
            this.counterTextAppearance = arg2;
            this.updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(ColorStateList arg2) {
        if(this.counterTextColor != arg2) {
            this.counterTextColor = arg2;
            this.updateCounterTextAppearanceAndColor();
        }
    }

    public void setCursorColor(ColorStateList arg2) {
        if(this.cursorColor != arg2) {
            this.cursorColor = arg2;
            this.updateCursorColor();
        }
    }

    public void setCursorErrorColor(ColorStateList arg2) {
        if(this.cursorErrorColor != arg2) {
            this.cursorErrorColor = arg2;
            if(this.isOnError()) {
                this.updateCursorColor();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList arg1) {
        this.defaultHintTextColor = arg1;
        this.focusedTextColor = arg1;
        if(this.editText != null) {
            this.updateLabelState(false);
        }
    }

    private void setDropDownMenuBackgroundIfNeeded() {
        EditText v0 = this.editText;
        if(!(v0 instanceof AutoCompleteTextView)) {
        }
        else if(((AutoCompleteTextView)v0).getDropDownBackground() == null) {
            int v1 = this.boxBackgroundMode;
            if(v1 == 2) {
                ((AutoCompleteTextView)v0).setDropDownBackgroundDrawable(this.getOrCreateOutlinedDropDownMenuBackground());
                return;
            }
            else if(v1 == 1) {
                ((AutoCompleteTextView)v0).setDropDownBackgroundDrawable(this.getOrCreateFilledDropDownMenuBackground());
            }
        }
    }

    private void setEditText(EditText arg5) {
        if(this.editText == null) {
            if(this.getEndIconMode() != 3 && !(arg5 instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }

            this.editText = arg5;
            int v0 = this.minEms;
            int v1 = -1;
            if(v0 != v1) {
                this.setMinEms(v0);
            }
            else {
                this.setMinWidth(this.minWidth);
            }

            v0 = this.maxEms;
            if(v0 != v1) {
                this.setMaxEms(v0);
            }
            else {
                this.setMaxWidth(this.maxWidth);
            }

            this.boxBackgroundApplied = false;
            this.onApplyBoxBackgroundMode();
            this.setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
            this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
            this.collapsingTextHelper.setExpandedLetterSpacing(this.editText.getLetterSpacing());
            v1 = this.editText.getGravity();
            this.collapsingTextHelper.setCollapsedTextGravity(v1 & 0xFFFFFF8F | 0x30);
            this.collapsingTextHelper.setExpandedTextGravity(v1);
            this.editText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable arg3) {
                    TextInputLayout.this.updateLabelState(TextInputLayout.this.restoringSavedState ^ 1);
                    if(TextInputLayout.this.counterEnabled) {
                        TextInputLayout.this.updateCounter(arg3);
                    }

                    if(TextInputLayout.this.placeholderEnabled) {
                        TextInputLayout.this.updatePlaceholderText(arg3);
                    }
                }

                public void beforeTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
                }

                public void onTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
                }
            });
            if(this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }

            if(this.hintEnabled) {
                if(TextUtils.isEmpty(this.hint)) {
                    CharSequence v1_1 = this.editText.getHint();
                    this.originalHint = v1_1;
                    this.setHint(v1_1);
                    this.editText.setHint(null);
                }

                this.isProvidingHint = true;
            }

            if(Build$VERSION.SDK_INT >= 29) {
                this.updateCursorColor();
            }

            if(this.counterView != null) {
                this.updateCounter(this.editText.getText());
            }

            this.updateEditTextBackground();
            this.indicatorViewController.adjustIndicatorPadding();
            this.startLayout.bringToFront();
            this.endLayout.bringToFront();
            this.dispatchOnEditTextAttached();
            this.endLayout.updateSuffixTextViewPadding();
            if(!this.isEnabled()) {
                arg5.setEnabled(false);
            }

            this.updateLabelState(false, true);
            return;
        }

        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    public void setEnabled(boolean arg1) {
        TextInputLayout.recursiveSetEnabled(((ViewGroup)this), arg1);
        super.setEnabled(arg1);
    }

    public void setEndIconActivated(boolean arg1) {
        this.endLayout.setEndIconActivated(arg1);
    }

    public void setEndIconCheckable(boolean arg1) {
        this.endLayout.setEndIconCheckable(arg1);
    }

    public void setEndIconContentDescription(int arg1) {
        this.endLayout.setEndIconContentDescription(arg1);
    }

    public void setEndIconContentDescription(CharSequence arg1) {
        this.endLayout.setEndIconContentDescription(arg1);
    }

    public void setEndIconDrawable(int arg1) {
        this.endLayout.setEndIconDrawable(arg1);
    }

    public void setEndIconDrawable(Drawable arg1) {
        this.endLayout.setEndIconDrawable(arg1);
    }

    public void setEndIconMinSize(int arg1) {
        this.endLayout.setEndIconMinSize(arg1);
    }

    public void setEndIconMode(int arg1) {
        this.endLayout.setEndIconMode(arg1);
    }

    public void setEndIconOnClickListener(View$OnClickListener arg1) {
        this.endLayout.setEndIconOnClickListener(arg1);
    }

    public void setEndIconOnLongClickListener(View$OnLongClickListener arg1) {
        this.endLayout.setEndIconOnLongClickListener(arg1);
    }

    public void setEndIconScaleType(ImageView$ScaleType arg1) {
        this.endLayout.setEndIconScaleType(arg1);
    }

    public void setEndIconTintList(ColorStateList arg1) {
        this.endLayout.setEndIconTintList(arg1);
    }

    public void setEndIconTintMode(PorterDuff$Mode arg1) {
        this.endLayout.setEndIconTintMode(arg1);
    }

    public void setEndIconVisible(boolean arg1) {
        this.endLayout.setEndIconVisible(arg1);
    }

    public void setError(CharSequence arg2) {
        if(!this.indicatorViewController.isErrorEnabled()) {
            if(TextUtils.isEmpty(arg2)) {
                return;
            }
            else {
                this.setErrorEnabled(true);
            }
        }

        boolean v0 = TextUtils.isEmpty(arg2);
        IndicatorViewController v1 = this.indicatorViewController;
        if(!v0) {
            v1.showError(arg2);
            return;
        }

        v1.hideError();
    }

    public void setErrorAccessibilityLiveRegion(int arg1) {
        this.indicatorViewController.setErrorAccessibilityLiveRegion(arg1);
    }

    public void setErrorContentDescription(CharSequence arg1) {
        this.indicatorViewController.setErrorContentDescription(arg1);
    }

    public void setErrorEnabled(boolean arg1) {
        this.indicatorViewController.setErrorEnabled(arg1);
    }

    public void setErrorIconDrawable(Drawable arg1) {
        this.endLayout.setErrorIconDrawable(arg1);
    }

    public void setErrorIconDrawable(int arg1) {
        this.endLayout.setErrorIconDrawable(arg1);
    }

    public void setErrorIconOnClickListener(View$OnClickListener arg1) {
        this.endLayout.setErrorIconOnClickListener(arg1);
    }

    public void setErrorIconOnLongClickListener(View$OnLongClickListener arg1) {
        this.endLayout.setErrorIconOnLongClickListener(arg1);
    }

    public void setErrorIconTintList(ColorStateList arg1) {
        this.endLayout.setErrorIconTintList(arg1);
    }

    public void setErrorIconTintMode(PorterDuff$Mode arg1) {
        this.endLayout.setErrorIconTintMode(arg1);
    }

    public void setErrorTextAppearance(int arg1) {
        this.indicatorViewController.setErrorTextAppearance(arg1);
    }

    public void setErrorTextColor(ColorStateList arg1) {
        this.indicatorViewController.setErrorViewTextColor(arg1);
    }

    public void setExpandedHintEnabled(boolean arg2) {
        if(this.expandedHintEnabled != arg2) {
            this.expandedHintEnabled = arg2;
            this.updateLabelState(false);
        }
    }

    public void setHelperText(CharSequence arg2) {
        if(TextUtils.isEmpty(arg2)) {
            if(this.isHelperTextEnabled()) {
                this.setHelperTextEnabled(false);
            }

            return;
        }

        if(!this.isHelperTextEnabled()) {
            this.setHelperTextEnabled(true);
        }

        this.indicatorViewController.showHelper(arg2);
    }

    public void setHelperTextColor(ColorStateList arg1) {
        this.indicatorViewController.setHelperTextViewTextColor(arg1);
    }

    public void setHelperTextEnabled(boolean arg1) {
        this.indicatorViewController.setHelperTextEnabled(arg1);
    }

    public void setHelperTextTextAppearance(int arg1) {
        this.indicatorViewController.setHelperTextAppearance(arg1);
    }

    public void setHint(CharSequence arg2) {
        if(this.hintEnabled) {
            this.setHintInternal(arg2);
            this.sendAccessibilityEvent(0x800);
        }
    }

    public void setHint(int arg2) {
        CharSequence v2 = arg2 != 0 ? this.getResources().getText(arg2) : null;
        this.setHint(v2);
    }

    public void setHintAnimationEnabled(boolean arg1) {
        this.hintAnimationEnabled = arg1;
    }

    public void setHintEnabled(boolean arg3) {
        if(arg3 != this.hintEnabled) {
            this.hintEnabled = arg3;
            CharSequence v0 = null;
            if(!arg3) {
                this.isProvidingHint = false;
                if(!TextUtils.isEmpty(this.hint) && (TextUtils.isEmpty(this.editText.getHint()))) {
                    this.editText.setHint(this.hint);
                }

                this.setHintInternal(v0);
            }
            else {
                CharSequence v3 = this.editText.getHint();
                if(!TextUtils.isEmpty(v3)) {
                    if(TextUtils.isEmpty(this.hint)) {
                        this.setHint(v3);
                    }

                    this.editText.setHint(v0);
                }

                this.isProvidingHint = true;
            }

            if(this.editText == null) {
                return;
            }

            this.updateInputLayoutMargins();
        }
    }

    private void setHintInternal(CharSequence arg2) {
        if(!TextUtils.equals(arg2, this.hint)) {
            this.hint = arg2;
            this.collapsingTextHelper.setText(arg2);
            if(!this.hintExpanded) {
                this.openCutout();
            }
        }
    }

    public void setHintTextAppearance(int arg2) {
        this.collapsingTextHelper.setCollapsedTextAppearance(arg2);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if(this.editText != null) {
            this.updateLabelState(false);
            this.updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(ColorStateList arg2) {
        if(this.focusedTextColor != arg2) {
            if(this.defaultHintTextColor == null) {
                this.collapsingTextHelper.setCollapsedTextColor(arg2);
            }

            this.focusedTextColor = arg2;
            if(this.editText == null) {
                return;
            }

            this.updateLabelState(false);
        }
    }

    public void setLengthCounter(LengthCounter arg1) {
        this.lengthCounter = arg1;
    }

    public void setMaxEms(int arg2) {
        this.maxEms = arg2;
        EditText v1 = this.editText;
        if(v1 != null && arg2 != -1) {
            v1.setMaxEms(arg2);
        }
    }

    public void setMaxWidth(int arg2) {
        this.maxWidth = arg2;
        EditText v1 = this.editText;
        if(v1 != null && arg2 != -1) {
            v1.setMaxWidth(arg2);
        }
    }

    public void setMaxWidthResource(int arg2) {
        this.setMaxWidth(this.getContext().getResources().getDimensionPixelSize(arg2));
    }

    public void setMinEms(int arg2) {
        this.minEms = arg2;
        EditText v1 = this.editText;
        if(v1 != null && arg2 != -1) {
            v1.setMinEms(arg2);
        }
    }

    public void setMinWidth(int arg2) {
        this.minWidth = arg2;
        EditText v1 = this.editText;
        if(v1 != null && arg2 != -1) {
            v1.setMinWidth(arg2);
        }
    }

    public void setMinWidthResource(int arg2) {
        this.setMinWidth(this.getContext().getResources().getDimensionPixelSize(arg2));
    }

    @Deprecated public void setPasswordVisibilityToggleContentDescription(int arg1) {
        this.endLayout.setPasswordVisibilityToggleContentDescription(arg1);
    }

    @Deprecated public void setPasswordVisibilityToggleContentDescription(CharSequence arg1) {
        this.endLayout.setPasswordVisibilityToggleContentDescription(arg1);
    }

    @Deprecated public void setPasswordVisibilityToggleDrawable(int arg1) {
        this.endLayout.setPasswordVisibilityToggleDrawable(arg1);
    }

    @Deprecated public void setPasswordVisibilityToggleDrawable(Drawable arg1) {
        this.endLayout.setPasswordVisibilityToggleDrawable(arg1);
    }

    @Deprecated public void setPasswordVisibilityToggleEnabled(boolean arg1) {
        this.endLayout.setPasswordVisibilityToggleEnabled(arg1);
    }

    @Deprecated public void setPasswordVisibilityToggleTintList(ColorStateList arg1) {
        this.endLayout.setPasswordVisibilityToggleTintList(arg1);
    }

    @Deprecated public void setPasswordVisibilityToggleTintMode(PorterDuff$Mode arg1) {
        this.endLayout.setPasswordVisibilityToggleTintMode(arg1);
    }

    public void setPlaceholderText(CharSequence arg4) {
        if(this.placeholderTextView == null) {
            AppCompatTextView v0 = new AppCompatTextView(this.getContext());
            this.placeholderTextView = ((TextView)v0);
            ((TextView)v0).setId(id.textinput_placeholder);
            ViewCompat.setImportantForAccessibility(this.placeholderTextView, 2);
            Fade v0_1 = this.createPlaceholderFadeTransition();
            this.placeholderFadeIn = v0_1;
            v0_1.setStartDelay(67);
            this.placeholderFadeOut = this.createPlaceholderFadeTransition();
            this.setPlaceholderTextAppearance(this.placeholderTextAppearance);
            this.setPlaceholderTextColor(this.placeholderTextColor);
        }

        if(TextUtils.isEmpty(arg4)) {
            this.setPlaceholderTextEnabled(false);
        }
        else {
            if(!this.placeholderEnabled) {
                this.setPlaceholderTextEnabled(true);
            }

            this.placeholderText = arg4;
        }

        this.updatePlaceholderText();
    }

    public void setPlaceholderTextAppearance(int arg1) {
        this.placeholderTextAppearance = arg1;
        TextView v0 = this.placeholderTextView;
        if(v0 != null) {
            TextViewCompat.setTextAppearance(v0, arg1);
        }
    }

    public void setPlaceholderTextColor(ColorStateList arg2) {
        if(this.placeholderTextColor != arg2) {
            this.placeholderTextColor = arg2;
            TextView v1 = this.placeholderTextView;
            if(v1 != null && arg2 != null) {
                v1.setTextColor(arg2);
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean arg2) {
        if(this.placeholderEnabled == arg2) {
            return;
        }

        if(arg2) {
            this.addPlaceholderTextView();
        }
        else {
            this.removePlaceholderTextView();
            this.placeholderTextView = null;
        }

        this.placeholderEnabled = arg2;
    }

    public void setPrefixText(CharSequence arg1) {
        this.startLayout.setPrefixText(arg1);
    }

    public void setPrefixTextAppearance(int arg1) {
        this.startLayout.setPrefixTextAppearance(arg1);
    }

    public void setPrefixTextColor(ColorStateList arg1) {
        this.startLayout.setPrefixTextColor(arg1);
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel arg2) {
        MaterialShapeDrawable v0 = this.boxBackground;
        if(v0 != null && v0.getShapeAppearanceModel() != arg2) {
            this.shapeAppearanceModel = arg2;
            this.applyBoxAttributes();
        }
    }

    public void setStartIconCheckable(boolean arg1) {
        this.startLayout.setStartIconCheckable(arg1);
    }

    public void setStartIconContentDescription(int arg2) {
        CharSequence v2 = arg2 != 0 ? this.getResources().getText(arg2) : null;
        this.setStartIconContentDescription(v2);
    }

    public void setStartIconContentDescription(CharSequence arg1) {
        this.startLayout.setStartIconContentDescription(arg1);
    }

    public void setStartIconDrawable(int arg2) {
        Drawable v2 = arg2 != 0 ? AppCompatResources.getDrawable(this.getContext(), arg2) : null;
        this.setStartIconDrawable(v2);
    }

    public void setStartIconDrawable(Drawable arg1) {
        this.startLayout.setStartIconDrawable(arg1);
    }

    public void setStartIconMinSize(int arg1) {
        this.startLayout.setStartIconMinSize(arg1);
    }

    public void setStartIconOnClickListener(View$OnClickListener arg1) {
        this.startLayout.setStartIconOnClickListener(arg1);
    }

    public void setStartIconOnLongClickListener(View$OnLongClickListener arg1) {
        this.startLayout.setStartIconOnLongClickListener(arg1);
    }

    public void setStartIconScaleType(ImageView$ScaleType arg1) {
        this.startLayout.setStartIconScaleType(arg1);
    }

    public void setStartIconTintList(ColorStateList arg1) {
        this.startLayout.setStartIconTintList(arg1);
    }

    public void setStartIconTintMode(PorterDuff$Mode arg1) {
        this.startLayout.setStartIconTintMode(arg1);
    }

    public void setStartIconVisible(boolean arg1) {
        this.startLayout.setStartIconVisible(arg1);
    }

    public void setSuffixText(CharSequence arg1) {
        this.endLayout.setSuffixText(arg1);
    }

    public void setSuffixTextAppearance(int arg1) {
        this.endLayout.setSuffixTextAppearance(arg1);
    }

    public void setSuffixTextColor(ColorStateList arg1) {
        this.endLayout.setSuffixTextColor(arg1);
    }

    void setTextAppearanceCompatWithErrorFallback(TextView arg2, int arg3) {
        try {
            TextViewCompat.setTextAppearance(arg2, arg3);
            if(arg2.getTextColors().getDefaultColor() != 0xFFFF00FF) {
                return;
            }
        }
        catch(Exception ) {
        }

        TextViewCompat.setTextAppearance(arg2, style.TextAppearance_AppCompat_Caption);
        arg2.setTextColor(ContextCompat.getColor(this.getContext(), color.design_error));
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate arg1) {
        EditText v0 = this.editText;
        if(v0 != null) {
            ViewCompat.setAccessibilityDelegate(((View)v0), ((AccessibilityDelegateCompat)arg1));
        }
    }

    public void setTypeface(Typeface arg2) {
        if(arg2 != this.typeface) {
            this.typeface = arg2;
            this.collapsingTextHelper.setTypefaces(arg2);
            this.indicatorViewController.setTypefaces(arg2);
            TextView v1 = this.counterView;
            if(v1 != null) {
                v1.setTypeface(arg2);
            }
        }
    }

    boolean shouldShowError() {
        return this.indicatorViewController.errorShouldBeShown();
    }

    private boolean shouldUpdateEndDummyDrawable() {
        if(!this.endLayout.isErrorIconVisible()) {
            if((this.endLayout.hasEndIcon()) && (this.isEndIconVisible())) {
                goto label_11;
            }

            if(this.endLayout.getSuffixText() == null) {
                return 0;
            }

            goto label_11;
        }
        else {
        label_11:
            if(this.endLayout.getMeasuredWidth() <= 0) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        if((this.getStartIconDrawable() != null || this.getPrefixText() != null && this.getPrefixTextView().getVisibility() == 0) && this.startLayout.getMeasuredWidth() > 0) {
            return 1;
        }

        return 0;
    }

    private void showPlaceholderText() {
        if(this.placeholderTextView != null && (this.placeholderEnabled) && !TextUtils.isEmpty(this.placeholderText)) {
            this.placeholderTextView.setText(this.placeholderText);
            TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeIn);
            this.placeholderTextView.setVisibility(0);
            this.placeholderTextView.bringToFront();
            this.announceForAccessibility(this.placeholderText);
        }
    }

    private void updateBoxCollapsedPaddingTop() {
        if(this.boxBackgroundMode == 1) {
            if(MaterialResources.isFontScaleAtLeast2_0(this.getContext())) {
                this.boxCollapsedPaddingTopPx = this.getResources().getDimensionPixelSize(dimen.material_font_2_0_box_collapsed_padding_top);
                return;
            }
            else if(MaterialResources.isFontScaleAtLeast1_3(this.getContext())) {
                this.boxCollapsedPaddingTopPx = this.getResources().getDimensionPixelSize(dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void updateBoxUnderlineBounds(Rect arg6) {
        if(this.boxUnderlineDefault != null) {
            this.boxUnderlineDefault.setBounds(arg6.left, arg6.bottom - this.boxStrokeWidthDefaultPx, arg6.right, arg6.bottom);
        }

        if(this.boxUnderlineFocused != null) {
            this.boxUnderlineFocused.setBounds(arg6.left, arg6.bottom - this.boxStrokeWidthFocusedPx, arg6.right, arg6.bottom);
        }
    }

    void updateCounter(Editable arg8) {
        int v8 = this.lengthCounter.countLength(arg8);
        boolean v0 = this.counterOverflowed;
        int v1 = this.counterMaxLength;
        if(v1 == -1) {
            this.counterView.setText(String.valueOf(v8));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        }
        else {
            boolean v1_1 = v8 > v1 ? true : false;
            this.counterOverflowed = v1_1;
            TextInputLayout.updateCounterContentDescription(this.getContext(), this.counterView, v8, this.counterMaxLength, this.counterOverflowed);
            if(v0 != this.counterOverflowed) {
                this.updateCounterTextAppearanceAndColor();
            }

            this.counterView.setText(BidiFormatter.getInstance().unicodeWrap(this.getContext().getString(string.character_counter_pattern, new Object[]{Integer.valueOf(v8), Integer.valueOf(this.counterMaxLength)})));
        }

        if(this.editText != null && v0 != this.counterOverflowed) {
            this.updateLabelState(false);
            this.updateTextInputBoxState();
            this.updateEditTextBackground();
        }
    }

    private void updateCounter() {
        if(this.counterView != null) {
            EditText v0 = this.editText;
            Editable v0_1 = v0 == null ? null : v0.getText();
            this.updateCounter(v0_1);
        }
    }

    private static void updateCounterContentDescription(Context arg0, TextView arg1, int arg2, int arg3, boolean arg4) {
        int v4 = arg4 ? string.character_counter_overflowed_content_description : string.character_counter_content_description;
        arg1.setContentDescription(arg0.getString(v4, new Object[]{Integer.valueOf(arg2), Integer.valueOf(arg3)}));
    }

    private void updateCounterTextAppearanceAndColor() {
        ColorStateList v0_1;
        TextView v0 = this.counterView;
        if(v0 != null) {
            int v1 = this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance;
            this.setTextAppearanceCompatWithErrorFallback(v0, v1);
            if(!this.counterOverflowed) {
                v0_1 = this.counterTextColor;
                if(v0_1 != null) {
                    this.counterView.setTextColor(v0_1);
                }
            }

            if(!this.counterOverflowed) {
                return;
            }

            v0_1 = this.counterOverflowTextColor;
            if(v0_1 == null) {
                return;
            }

            this.counterView.setTextColor(v0_1);
        }
    }

    private void updateCursorColor() {
        ColorStateList v0 = this.cursorColor;
        if(v0 != null) {
        }
        else {
            v0 = MaterialColors.getColorStateListOrNull(this.getContext(), attr.colorControlActivated);
        }

        EditText v1 = this.editText;
        if(v1 != null) {
            if(v1.getTextCursorDrawable() == null) {
            }
            else {
                Drawable v1_1 = DrawableCompat.wrap(this.editText.getTextCursorDrawable()).mutate();
                if(this.isOnError()) {
                    ColorStateList v3 = this.cursorErrorColor;
                    if(v3 != null) {
                        v0 = v3;
                    }
                }

                DrawableCompat.setTintList(v1_1, v0);
            }
        }
    }

    boolean updateDummyDrawables() {
        Drawable[] v6_3;
        boolean v0_2;
        Drawable v7;
        Drawable[] v0_1;
        if(this.editText == null) {
            return 0;
        }

        Drawable v2 = null;
        int v3 = 2;
        int v4 = 3;
        boolean v5 = true;
        if(this.shouldUpdateStartDummyDrawable()) {
            int v0 = this.startLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
            if(this.startDummyDrawable == null || this.startDummyDrawableWidth != v0) {
                ColorDrawable v6 = new ColorDrawable();
                this.startDummyDrawable = ((Drawable)v6);
                this.startDummyDrawableWidth = v0;
                ((Drawable)v6).setBounds(0, 0, v0, 1);
            }

            v0_1 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
            Drawable v6_1 = v0_1[0];
            v7 = this.startDummyDrawable;
            if(v6_1 == v7) {
                goto label_47;
            }

            TextViewCompat.setCompoundDrawablesRelative(this.editText, v7, v0_1[1], v0_1[v3], v0_1[v4]);
            goto label_45;
        }
        else {
            if(this.startDummyDrawable != null) {
                v0_1 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
                TextViewCompat.setCompoundDrawablesRelative(this.editText, v2, v0_1[1], v0_1[v3], v0_1[v4]);
                this.startDummyDrawable = v2;
            label_45:
                v0_2 = true;
                goto label_48;
            }

        label_47:
            v0_2 = false;
        }

    label_48:
        if(this.shouldUpdateEndDummyDrawable()) {
            int v2_1 = this.endLayout.getSuffixTextView().getMeasuredWidth() - this.editText.getPaddingRight();
            CheckableImageButton v6_2 = this.endLayout.getCurrentEndIconView();
            if(v6_2 != null) {
                v2_1 = v2_1 + ((View)v6_2).getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart(((View)v6_2).getLayoutParams());
            }

            v6_3 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
            v7 = this.endDummyDrawable;
            if(v7 != null && this.endDummyDrawableWidth != v2_1) {
                this.endDummyDrawableWidth = v2_1;
                v7.setBounds(0, 0, v2_1, 1);
                TextViewCompat.setCompoundDrawablesRelative(this.editText, v6_3[0], v6_3[1], this.endDummyDrawable, v6_3[v4]);
                return 1;
            }

            if(v7 == null) {
                ColorDrawable v7_1 = new ColorDrawable();
                this.endDummyDrawable = ((Drawable)v7_1);
                this.endDummyDrawableWidth = v2_1;
                ((Drawable)v7_1).setBounds(0, 0, v2_1, 1);
            }

            v2 = v6_3[v3];
            Drawable v3_1 = this.endDummyDrawable;
            if(v2 == v3_1) {
                return v0_2;
            }

            this.originalEditTextEndDrawable = v2;
            TextViewCompat.setCompoundDrawablesRelative(this.editText, v6_3[0], v6_3[1], v3_1, v6_3[v4]);
            return 1;
        }
        else {
            if(this.endDummyDrawable == null) {
                return v0_2;
            }

            v6_3 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
            if(v6_3[v3] == this.endDummyDrawable) {
                TextViewCompat.setCompoundDrawablesRelative(this.editText, v6_3[0], v6_3[1], this.originalEditTextEndDrawable, v6_3[v4]);
            }
            else {
                v5 = v0_2;
            }

            this.endDummyDrawable = v2;
            return v5;
        }

        return v0_2;
    }

    void updateEditTextBackground() {
        EditText v0 = this.editText;
        if(v0 != null) {
            if(this.boxBackgroundMode != 0) {
            }
            else {
                Drawable v0_1 = v0.getBackground();
                if(v0_1 == null) {
                }
                else {
                    if(DrawableUtils.canSafelyMutateDrawable(v0_1)) {
                        v0_1 = v0_1.mutate();
                    }

                    if(this.shouldShowError()) {
                        v0_1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.getErrorCurrentTextColors(), PorterDuff$Mode.SRC_IN));
                        return;
                    }

                    if(this.counterOverflowed) {
                        TextView v1 = this.counterView;
                        if(v1 != null) {
                            v0_1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(v1.getCurrentTextColor(), PorterDuff$Mode.SRC_IN));
                            return;
                        }
                    }

                    DrawableCompat.clearColorFilter(v0_1);
                    this.editText.refreshDrawableState();
                }
            }
        }
    }

    private void updateEditTextBoxBackground() {
        ViewCompat.setBackground(this.editText, this.getEditTextBoxBackground());
    }

    void updateEditTextBoxBackgroundIfNeeded() {
        EditText v0 = this.editText;
        if(v0 != null && this.boxBackground != null && ((this.boxBackgroundApplied) || v0.getBackground() == null) && this.boxBackgroundMode != 0) {
            this.updateEditTextBoxBackground();
            this.boxBackgroundApplied = true;
        }
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        if(this.editText == null) {
            return 0;
        }

        int v0 = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight());
        if(this.editText.getMeasuredHeight() < v0) {
            this.editText.setMinimumHeight(v0);
            return 1;
        }

        return 0;
    }

    private void updateInputLayoutMargins() {
        if(this.boxBackgroundMode != 1) {
            ViewGroup$LayoutParams v0 = this.inputFrame.getLayoutParams();
            int v1 = this.calculateLabelMarginTop();
            if(v1 != ((LinearLayout$LayoutParams)v0).topMargin) {
                ((LinearLayout$LayoutParams)v0).topMargin = v1;
                this.inputFrame.requestLayout();
            }
        }
    }

    void updateLabelState(boolean arg2) {
        this.updateLabelState(arg2, false);
    }

    private void updateLabelState(boolean arg6, boolean arg7) {
        ColorStateList v0_1;
        boolean v0 = this.isEnabled();
        EditText v1 = this.editText;
        int v2 = 1;
        int v1_1 = v1 == null || (TextUtils.isEmpty(v1.getText())) ? 0 : 1;
        EditText v4 = this.editText;
        if(v4 == null || !v4.hasFocus()) {
            v2 = 0;
        }
        else {
        }

        ColorStateList v3 = this.defaultHintTextColor;
        if(v3 != null) {
            this.collapsingTextHelper.setCollapsedAndExpandedTextColor(v3);
        }

        if(!v0) {
            v0_1 = this.defaultHintTextColor;
            int v3_1 = this.disabledColor;
            if(v0_1 != null) {
                v3_1 = v0_1.getColorForState(new int[]{0xFEFEFF62}, v3_1);
            }

            this.collapsingTextHelper.setCollapsedAndExpandedTextColor(ColorStateList.valueOf(v3_1));
        }
        else {
            if(this.shouldShowError()) {
                this.collapsingTextHelper.setCollapsedAndExpandedTextColor(this.indicatorViewController.getErrorViewTextColors());
                goto label_52;
            }

            if(this.counterOverflowed) {
                TextView v0_2 = this.counterView;
                if(v0_2 != null) {
                    this.collapsingTextHelper.setCollapsedAndExpandedTextColor(v0_2.getTextColors());
                    goto label_52;
                }
            }

            if(v2 == 0) {
                goto label_52;
            }

            v0_1 = this.focusedTextColor;
            if(v0_1 == null) {
                goto label_52;
            }

            this.collapsingTextHelper.setCollapsedTextColor(v0_1);
        }

    label_52:
        if(v1_1 != 0 || !this.expandedHintEnabled) {
        label_64:
            if(!arg7) {
                if(this.hintExpanded) {
                }
                else {
                    return;
                }
            }

            goto label_69;
        }
        else {
            if((this.isEnabled()) && v2 != 0) {
                goto label_64;
            }

            if(!arg7 && (this.hintExpanded)) {
                return;
            }

            this.expandHint(arg6);
            return;
        }

        return;
    label_69:
        this.collapseHint(arg6);
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        if(this.placeholderTextView != null) {
            EditText v0 = this.editText;
            if(v0 != null) {
                this.placeholderTextView.setGravity(v0.getGravity());
                this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
            }
        }
    }

    private void updatePlaceholderText(Editable arg2) {
        if(this.lengthCounter.countLength(arg2) == 0 && !this.hintExpanded) {
            this.showPlaceholderText();
            return;
        }

        this.hidePlaceholderText();
    }

    private void updatePlaceholderText() {
        EditText v0 = this.editText;
        Editable v0_1 = v0 == null ? null : v0.getText();
        this.updatePlaceholderText(v0_1);
    }

    private void updateStrokeErrorColor(boolean arg6, boolean arg7) {
        int v0 = this.strokeErrorColor.getDefaultColor();
        int v1 = this.strokeErrorColor.getColorForState(new int[]{0x1010367, 0x101009E}, v0);
        int v2 = this.strokeErrorColor.getColorForState(new int[]{0x10102FE, 0x101009E}, v0);
        if(arg6) {
            this.boxStrokeColor = v2;
            return;
        }

        if(arg7) {
            this.boxStrokeColor = v1;
            return;
        }

        this.boxStrokeColor = v0;
    }

    void updateTextInputBoxState() {
        int v4;
        boolean v0_1;
        if(this.boxBackground != null) {
            if(this.boxBackgroundMode == 0) {
            }
            else {
                boolean v1 = false;
                if(!this.isFocused()) {
                    EditText v0 = this.editText;
                    if(v0 != null && (v0.hasFocus())) {
                        goto label_16;
                    }

                    v0_1 = false;
                }
                else {
                label_16:
                    v0_1 = true;
                }

                if(!this.isHovered()) {
                    EditText v3 = this.editText;
                    if(v3 != null && (v3.isHovered())) {
                        goto label_23;
                    }
                }
                else {
                label_23:
                    v1 = true;
                }

                if(!this.isEnabled()) {
                    this.boxStrokeColor = this.disabledColor;
                }
                else if(!this.shouldShowError()) {
                    if(this.counterOverflowed) {
                        TextView v3_1 = this.counterView;
                        if(v3_1 != null) {
                            if(this.strokeErrorColor != null) {
                                this.updateStrokeErrorColor(v0_1, v1);
                            }
                            else {
                                this.boxStrokeColor = v3_1.getCurrentTextColor();
                            }

                            goto label_59;
                        }
                    }

                    if(v0_1) {
                        this.boxStrokeColor = this.focusedStrokeColor;
                        goto label_59;
                    }

                    if(v1) {
                        this.boxStrokeColor = this.hoveredStrokeColor;
                        goto label_59;
                    }

                    this.boxStrokeColor = this.defaultStrokeColor;
                }
                else if(this.strokeErrorColor != null) {
                    this.updateStrokeErrorColor(v0_1, v1);
                }
                else {
                    this.boxStrokeColor = this.getErrorCurrentTextColors();
                }

            label_59:
                if(Build$VERSION.SDK_INT >= 29) {
                    this.updateCursorColor();
                }

                this.endLayout.onTextInputBoxStateUpdated();
                this.refreshStartIconDrawableState();
                if(this.boxBackgroundMode == 2) {
                    int v3_2 = this.boxStrokeWidthPx;
                    if(!v0_1 || !this.isEnabled()) {
                        v4 = this.boxStrokeWidthDefaultPx;
                        this.boxStrokeWidthPx = v4;
                    }
                    else {
                        v4 = this.boxStrokeWidthFocusedPx;
                        this.boxStrokeWidthPx = v4;
                    }

                    if(v4 == v3_2) {
                        goto label_80;
                    }

                    this.recalculateCutout();
                }

            label_80:
                if(this.boxBackgroundMode == 1) {
                    if(!this.isEnabled()) {
                        this.boxBackgroundColor = this.disabledFilledBackgroundColor;
                    }
                    else {
                        if((v1) && !v0_1) {
                            this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
                            goto label_98;
                        }

                        if(v0_1) {
                            this.boxBackgroundColor = this.focusedFilledBackgroundColor;
                            goto label_98;
                        }

                        this.boxBackgroundColor = this.defaultFilledBackgroundColor;
                    }
                }

            label_98:
                this.applyBoxAttributes();
            }
        }
    }
}

