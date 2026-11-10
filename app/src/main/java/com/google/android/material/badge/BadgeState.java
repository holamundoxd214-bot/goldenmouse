package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.R$dimen;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import java.util.Locale$Category;
import java.util.Locale;

public final class BadgeState {
    public final class State implements Parcelable {
        class com.google.android.material.badge.BadgeState$State$1 implements Parcelable$Creator {
            com.google.android.material.badge.BadgeState$State$1() {
                super();
            }

            public State createFromParcel(Parcel arg1) {
                return new State(arg1);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public State[] newArray(int arg1) {
                return new State[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        private static final int BADGE_NUMBER_NONE = -1;
        public static final Parcelable$Creator CREATOR = null;
        private static final int NOT_SET = -2;
        private Integer additionalHorizontalOffset;
        private Integer additionalVerticalOffset;
        private int alpha;
        private Boolean autoAdjustToWithinGrandparentBounds;
        private Integer backgroundColor;
        private Integer badgeGravity;
        private Integer badgeHorizontalPadding;
        private int badgeResId;
        private Integer badgeShapeAppearanceOverlayResId;
        private Integer badgeShapeAppearanceResId;
        private Integer badgeTextAppearanceResId;
        private Integer badgeTextColor;
        private Integer badgeVerticalPadding;
        private Integer badgeWithTextShapeAppearanceOverlayResId;
        private Integer badgeWithTextShapeAppearanceResId;
        private int contentDescriptionExceedsMaxBadgeNumberRes;
        private CharSequence contentDescriptionForText;
        private CharSequence contentDescriptionNumberless;
        private int contentDescriptionQuantityStrings;
        private Integer horizontalOffsetWithText;
        private Integer horizontalOffsetWithoutText;
        private Boolean isVisible;
        private Integer largeFontVerticalOffsetAdjustment;
        private int maxCharacterCount;
        private int maxNumber;
        private int number;
        private Locale numberLocale;
        private String text;
        private Integer verticalOffsetWithText;
        private Integer verticalOffsetWithoutText;

        static {
            State.CREATOR = new com.google.android.material.badge.BadgeState$State$1();
        }

        public State() {
            super();
            this.alpha = 0xFF;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.maxNumber = -2;
            this.isVisible = Boolean.valueOf(true);
        }

        State(Parcel arg2) {
            super();
            this.alpha = 0xFF;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.maxNumber = -2;
            this.isVisible = Boolean.valueOf(true);
            this.badgeResId = arg2.readInt();
            this.backgroundColor = arg2.readSerializable();
            this.badgeTextColor = arg2.readSerializable();
            this.badgeTextAppearanceResId = arg2.readSerializable();
            this.badgeShapeAppearanceResId = arg2.readSerializable();
            this.badgeShapeAppearanceOverlayResId = arg2.readSerializable();
            this.badgeWithTextShapeAppearanceResId = arg2.readSerializable();
            this.badgeWithTextShapeAppearanceOverlayResId = arg2.readSerializable();
            this.alpha = arg2.readInt();
            this.text = arg2.readString();
            this.number = arg2.readInt();
            this.maxCharacterCount = arg2.readInt();
            this.maxNumber = arg2.readInt();
            this.contentDescriptionForText = arg2.readString();
            this.contentDescriptionNumberless = arg2.readString();
            this.contentDescriptionQuantityStrings = arg2.readInt();
            this.badgeGravity = arg2.readSerializable();
            this.badgeHorizontalPadding = arg2.readSerializable();
            this.badgeVerticalPadding = arg2.readSerializable();
            this.horizontalOffsetWithoutText = arg2.readSerializable();
            this.verticalOffsetWithoutText = arg2.readSerializable();
            this.horizontalOffsetWithText = arg2.readSerializable();
            this.verticalOffsetWithText = arg2.readSerializable();
            this.largeFontVerticalOffsetAdjustment = arg2.readSerializable();
            this.additionalHorizontalOffset = arg2.readSerializable();
            this.additionalVerticalOffset = arg2.readSerializable();
            this.isVisible = arg2.readSerializable();
            this.numberLocale = arg2.readSerializable();
            this.autoAdjustToWithinGrandparentBounds = arg2.readSerializable();
        }

        static int access$000(State arg0) {
            return arg0.badgeResId;
        }

        static int access$002(State arg0, int arg1) {
            arg0.badgeResId = arg1;
            return arg1;
        }

        static int access$100(State arg0) {
            return arg0.alpha;
        }

        static int access$1000(State arg0) {
            return arg0.maxNumber;
        }

        static int access$1002(State arg0, int arg1) {
            arg0.maxNumber = arg1;
            return arg1;
        }

        static int access$102(State arg0, int arg1) {
            arg0.alpha = arg1;
            return arg1;
        }

        static Integer access$1100(State arg0) {
            return arg0.badgeShapeAppearanceResId;
        }

        static Integer access$1102(State arg0, Integer arg1) {
            arg0.badgeShapeAppearanceResId = arg1;
            return arg1;
        }

        static Integer access$1200(State arg0) {
            return arg0.badgeShapeAppearanceOverlayResId;
        }

        static Integer access$1202(State arg0, Integer arg1) {
            arg0.badgeShapeAppearanceOverlayResId = arg1;
            return arg1;
        }

        static Integer access$1300(State arg0) {
            return arg0.badgeWithTextShapeAppearanceResId;
        }

        static Integer access$1302(State arg0, Integer arg1) {
            arg0.badgeWithTextShapeAppearanceResId = arg1;
            return arg1;
        }

        static Integer access$1400(State arg0) {
            return arg0.badgeWithTextShapeAppearanceOverlayResId;
        }

        static Integer access$1402(State arg0, Integer arg1) {
            arg0.badgeWithTextShapeAppearanceOverlayResId = arg1;
            return arg1;
        }

        static Integer access$1500(State arg0) {
            return arg0.backgroundColor;
        }

        static Integer access$1502(State arg0, Integer arg1) {
            arg0.backgroundColor = arg1;
            return arg1;
        }

        static Integer access$1600(State arg0) {
            return arg0.badgeTextAppearanceResId;
        }

        static Integer access$1602(State arg0, Integer arg1) {
            arg0.badgeTextAppearanceResId = arg1;
            return arg1;
        }

        static Integer access$1700(State arg0) {
            return arg0.badgeTextColor;
        }

        static Integer access$1702(State arg0, Integer arg1) {
            arg0.badgeTextColor = arg1;
            return arg1;
        }

        static Integer access$1800(State arg0) {
            return arg0.badgeGravity;
        }

        static Integer access$1802(State arg0, Integer arg1) {
            arg0.badgeGravity = arg1;
            return arg1;
        }

        static Integer access$1900(State arg0) {
            return arg0.badgeHorizontalPadding;
        }

        static Integer access$1902(State arg0, Integer arg1) {
            arg0.badgeHorizontalPadding = arg1;
            return arg1;
        }

        static int access$200(State arg0) {
            return arg0.number;
        }

        static Integer access$2000(State arg0) {
            return arg0.badgeVerticalPadding;
        }

        static Integer access$2002(State arg0, Integer arg1) {
            arg0.badgeVerticalPadding = arg1;
            return arg1;
        }

        static int access$202(State arg0, int arg1) {
            arg0.number = arg1;
            return arg1;
        }

        static Integer access$2100(State arg0) {
            return arg0.horizontalOffsetWithoutText;
        }

        static Integer access$2102(State arg0, Integer arg1) {
            arg0.horizontalOffsetWithoutText = arg1;
            return arg1;
        }

        static Integer access$2200(State arg0) {
            return arg0.verticalOffsetWithoutText;
        }

        static Integer access$2202(State arg0, Integer arg1) {
            arg0.verticalOffsetWithoutText = arg1;
            return arg1;
        }

        static Integer access$2300(State arg0) {
            return arg0.horizontalOffsetWithText;
        }

        static Integer access$2302(State arg0, Integer arg1) {
            arg0.horizontalOffsetWithText = arg1;
            return arg1;
        }

        static Integer access$2400(State arg0) {
            return arg0.verticalOffsetWithText;
        }

        static Integer access$2402(State arg0, Integer arg1) {
            arg0.verticalOffsetWithText = arg1;
            return arg1;
        }

        static Integer access$2500(State arg0) {
            return arg0.largeFontVerticalOffsetAdjustment;
        }

        static Integer access$2502(State arg0, Integer arg1) {
            arg0.largeFontVerticalOffsetAdjustment = arg1;
            return arg1;
        }

        static Integer access$2600(State arg0) {
            return arg0.additionalHorizontalOffset;
        }

        static Integer access$2602(State arg0, Integer arg1) {
            arg0.additionalHorizontalOffset = arg1;
            return arg1;
        }

        static Integer access$2700(State arg0) {
            return arg0.additionalVerticalOffset;
        }

        static Integer access$2702(State arg0, Integer arg1) {
            arg0.additionalVerticalOffset = arg1;
            return arg1;
        }

        static Boolean access$2800(State arg0) {
            return arg0.autoAdjustToWithinGrandparentBounds;
        }

        static Boolean access$2802(State arg0, Boolean arg1) {
            arg0.autoAdjustToWithinGrandparentBounds = arg1;
            return arg1;
        }

        static Locale access$2900(State arg0) {
            return arg0.numberLocale;
        }

        static Locale access$2902(State arg0, Locale arg1) {
            arg0.numberLocale = arg1;
            return arg1;
        }

        static String access$300(State arg0) {
            return arg0.text;
        }

        static String access$302(State arg0, String arg1) {
            arg0.text = arg1;
            return arg1;
        }

        static CharSequence access$400(State arg0) {
            return arg0.contentDescriptionForText;
        }

        static CharSequence access$402(State arg0, CharSequence arg1) {
            arg0.contentDescriptionForText = arg1;
            return arg1;
        }

        static CharSequence access$500(State arg0) {
            return arg0.contentDescriptionNumberless;
        }

        static CharSequence access$502(State arg0, CharSequence arg1) {
            arg0.contentDescriptionNumberless = arg1;
            return arg1;
        }

        static int access$600(State arg0) {
            return arg0.contentDescriptionQuantityStrings;
        }

        static int access$602(State arg0, int arg1) {
            arg0.contentDescriptionQuantityStrings = arg1;
            return arg1;
        }

        static int access$700(State arg0) {
            return arg0.contentDescriptionExceedsMaxBadgeNumberRes;
        }

        static int access$702(State arg0, int arg1) {
            arg0.contentDescriptionExceedsMaxBadgeNumberRes = arg1;
            return arg1;
        }

        static Boolean access$800(State arg0) {
            return arg0.isVisible;
        }

        static Boolean access$802(State arg0, Boolean arg1) {
            arg0.isVisible = arg1;
            return arg1;
        }

        static int access$900(State arg0) {
            return arg0.maxCharacterCount;
        }

        static int access$902(State arg0, int arg1) {
            arg0.maxCharacterCount = arg1;
            return arg1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            arg2.writeInt(this.badgeResId);
            arg2.writeSerializable(this.backgroundColor);
            arg2.writeSerializable(this.badgeTextColor);
            arg2.writeSerializable(this.badgeTextAppearanceResId);
            arg2.writeSerializable(this.badgeShapeAppearanceResId);
            arg2.writeSerializable(this.badgeShapeAppearanceOverlayResId);
            arg2.writeSerializable(this.badgeWithTextShapeAppearanceResId);
            arg2.writeSerializable(this.badgeWithTextShapeAppearanceOverlayResId);
            arg2.writeInt(this.alpha);
            arg2.writeString(this.text);
            arg2.writeInt(this.number);
            arg2.writeInt(this.maxCharacterCount);
            arg2.writeInt(this.maxNumber);
            CharSequence v3 = this.contentDescriptionForText;
            String v0 = null;
            String v3_1 = v3 != null ? v3.toString() : v0;
            arg2.writeString(v3_1);
            v3 = this.contentDescriptionNumberless;
            if(v3 != null) {
                v0 = v3.toString();
            }

            arg2.writeString(v0);
            arg2.writeInt(this.contentDescriptionQuantityStrings);
            arg2.writeSerializable(this.badgeGravity);
            arg2.writeSerializable(this.badgeHorizontalPadding);
            arg2.writeSerializable(this.badgeVerticalPadding);
            arg2.writeSerializable(this.horizontalOffsetWithoutText);
            arg2.writeSerializable(this.verticalOffsetWithoutText);
            arg2.writeSerializable(this.horizontalOffsetWithText);
            arg2.writeSerializable(this.verticalOffsetWithText);
            arg2.writeSerializable(this.largeFontVerticalOffsetAdjustment);
            arg2.writeSerializable(this.additionalHorizontalOffset);
            arg2.writeSerializable(this.additionalVerticalOffset);
            arg2.writeSerializable(this.isVisible);
            arg2.writeSerializable(this.numberLocale);
            arg2.writeSerializable(this.autoAdjustToWithinGrandparentBounds);
        }
    }

    private static final String BADGE_RESOURCE_TAG = "badge";
    final float badgeHeight;
    final float badgeRadius;
    final float badgeWidth;
    final float badgeWithTextHeight;
    final float badgeWithTextRadius;
    final float badgeWithTextWidth;
    private final State currentState;
    final int horizontalInset;
    final int horizontalInsetWithText;
    int offsetAlignmentMode;
    private final State overridingState;

    BadgeState(Context arg6, int arg7, int arg8, int arg9, State arg10) {
        CharSequence v9_1;
        super();
        State v0 = new State();
        this.currentState = v0;
        if(arg10 == null) {
            arg10 = new State();
        }

        if(arg7 != 0) {
            State.access$002(arg10, arg7);
        }

        TypedArray v7 = this.generateTypedArray(arg6, State.access$000(arg10), arg8, arg9);
        Resources v8 = arg6.getResources();
        int v1 = -1;
        this.badgeRadius = ((float)v7.getDimensionPixelSize(styleable.Badge_badgeRadius, v1));
        this.horizontalInset = arg6.getResources().getDimensionPixelSize(dimen.mtrl_badge_horizontal_edge_offset);
        this.horizontalInsetWithText = arg6.getResources().getDimensionPixelSize(dimen.mtrl_badge_text_horizontal_edge_offset);
        this.badgeWithTextRadius = ((float)v7.getDimensionPixelSize(styleable.Badge_badgeWithTextRadius, v1));
        this.badgeWidth = v7.getDimension(styleable.Badge_badgeWidth, v8.getDimension(dimen.m3_badge_size));
        this.badgeWithTextWidth = v7.getDimension(styleable.Badge_badgeWithTextWidth, v8.getDimension(dimen.m3_badge_with_text_size));
        this.badgeHeight = v7.getDimension(styleable.Badge_badgeHeight, v8.getDimension(dimen.m3_badge_size));
        this.badgeWithTextHeight = v7.getDimension(styleable.Badge_badgeWithTextHeight, v8.getDimension(dimen.m3_badge_with_text_size));
        boolean v2 = true;
        this.offsetAlignmentMode = v7.getInt(styleable.Badge_offsetAlignmentMode, 1);
        int v3 = -2;
        arg9 = State.access$100(arg10) == v3 ? 0xFF : State.access$100(arg10);
        State.access$102(v0, arg9);
        if(State.access$200(arg10) != v3) {
            State.access$202(v0, State.access$200(arg10));
        }
        else if(v7.hasValue(styleable.Badge_number)) {
            State.access$202(v0, v7.getInt(styleable.Badge_number, 0));
        }
        else {
            State.access$202(v0, v1);
        }

        if(State.access$300(arg10) != null) {
            State.access$302(v0, State.access$300(arg10));
        }
        else if(v7.hasValue(styleable.Badge_badgeText)) {
            State.access$302(v0, v7.getString(styleable.Badge_badgeText));
        }

        State.access$402(v0, State.access$400(arg10));
        if(State.access$500(arg10) == null) {
            String v9 = arg6.getString(string.mtrl_badge_numberless_content_description);
        }
        else {
            v9_1 = State.access$500(arg10);
        }

        State.access$502(v0, v9_1);
        arg9 = State.access$600(arg10) == 0 ? plurals.mtrl_badge_content_description : State.access$600(arg10);
        State.access$602(v0, arg9);
        arg9 = State.access$700(arg10) == 0 ? string.mtrl_exceed_max_badge_number_content_description : State.access$700(arg10);
        State.access$702(v0, arg9);
        if(State.access$800(arg10) != null) {
            if(State.access$800(arg10).booleanValue()) {
            }
            else {
                v2 = false;
            }
        }

        State.access$802(v0, Boolean.valueOf(v2));
        arg9 = State.access$900(arg10) == v3 ? v7.getInt(styleable.Badge_maxCharacterCount, v3) : State.access$900(arg10);
        State.access$902(v0, arg9);
        arg9 = State.access$1000(arg10) == v3 ? v7.getInt(styleable.Badge_maxNumber, v3) : State.access$1000(arg10);
        State.access$1002(v0, arg9);
        arg9 = State.access$1100(arg10) == null ? v7.getResourceId(styleable.Badge_badgeShapeAppearance, style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : State.access$1100(arg10).intValue();
        State.access$1102(v0, Integer.valueOf(arg9));
        arg9 = State.access$1200(arg10) == null ? v7.getResourceId(styleable.Badge_badgeShapeAppearanceOverlay, 0) : State.access$1200(arg10).intValue();
        State.access$1202(v0, Integer.valueOf(arg9));
        arg9 = State.access$1300(arg10) == null ? v7.getResourceId(styleable.Badge_badgeWithTextShapeAppearance, style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : State.access$1300(arg10).intValue();
        State.access$1302(v0, Integer.valueOf(arg9));
        arg9 = State.access$1400(arg10) == null ? v7.getResourceId(styleable.Badge_badgeWithTextShapeAppearanceOverlay, 0) : State.access$1400(arg10).intValue();
        State.access$1402(v0, Integer.valueOf(arg9));
        arg9 = State.access$1500(arg10) == null ? BadgeState.readColorFromAttributes(arg6, v7, styleable.Badge_backgroundColor) : State.access$1500(arg10).intValue();
        State.access$1502(v0, Integer.valueOf(arg9));
        arg9 = State.access$1600(arg10) == null ? v7.getResourceId(styleable.Badge_badgeTextAppearance, style.TextAppearance_MaterialComponents_Badge) : State.access$1600(arg10).intValue();
        State.access$1602(v0, Integer.valueOf(arg9));
        if(State.access$1700(arg10) != null) {
            State.access$1702(v0, State.access$1700(arg10));
        }
        else if(v7.hasValue(styleable.Badge_badgeTextColor)) {
            State.access$1702(v0, Integer.valueOf(BadgeState.readColorFromAttributes(arg6, v7, styleable.Badge_badgeTextColor)));
        }
        else {
            State.access$1702(v0, Integer.valueOf(new TextAppearance(arg6, State.access$1600(v0).intValue()).getTextColor().getDefaultColor()));
        }

        int v6 = State.access$1800(arg10) == null ? v7.getInt(styleable.Badge_badgeGravity, 0x800035) : State.access$1800(arg10).intValue();
        State.access$1802(v0, Integer.valueOf(v6));
        v6 = State.access$1900(arg10) == null ? v7.getDimensionPixelSize(styleable.Badge_badgeWidePadding, v8.getDimensionPixelSize(dimen.mtrl_badge_long_text_horizontal_padding)) : State.access$1900(arg10).intValue();
        State.access$1902(v0, Integer.valueOf(v6));
        v6 = State.access$2000(arg10) == null ? v7.getDimensionPixelSize(styleable.Badge_badgeVerticalPadding, v8.getDimensionPixelSize(dimen.m3_badge_with_text_vertical_padding)) : State.access$2000(arg10).intValue();
        State.access$2002(v0, Integer.valueOf(v6));
        v6 = State.access$2100(arg10) == null ? v7.getDimensionPixelOffset(styleable.Badge_horizontalOffset, 0) : State.access$2100(arg10).intValue();
        State.access$2102(v0, Integer.valueOf(v6));
        v6 = State.access$2200(arg10) == null ? v7.getDimensionPixelOffset(styleable.Badge_verticalOffset, 0) : State.access$2200(arg10).intValue();
        State.access$2202(v0, Integer.valueOf(v6));
        v6 = State.access$2300(arg10) == null ? v7.getDimensionPixelOffset(styleable.Badge_horizontalOffsetWithText, State.access$2100(v0).intValue()) : State.access$2300(arg10).intValue();
        State.access$2302(v0, Integer.valueOf(v6));
        v6 = State.access$2400(arg10) == null ? v7.getDimensionPixelOffset(styleable.Badge_verticalOffsetWithText, State.access$2200(v0).intValue()) : State.access$2400(arg10).intValue();
        State.access$2402(v0, Integer.valueOf(v6));
        v6 = State.access$2500(arg10) == null ? v7.getDimensionPixelOffset(styleable.Badge_largeFontVerticalOffsetAdjustment, 0) : State.access$2500(arg10).intValue();
        State.access$2502(v0, Integer.valueOf(v6));
        v6 = State.access$2600(arg10) == null ? 0 : State.access$2600(arg10).intValue();
        State.access$2602(v0, Integer.valueOf(v6));
        v6 = State.access$2700(arg10) == null ? 0 : State.access$2700(arg10).intValue();
        State.access$2702(v0, Integer.valueOf(v6));
        boolean v6_1 = State.access$2800(arg10) == null ? v7.getBoolean(styleable.Badge_autoAdjustToWithinGrandparentBounds, false) : State.access$2800(arg10).booleanValue();
        State.access$2802(v0, Boolean.valueOf(v6_1));
        v7.recycle();
        if(State.access$2900(arg10) == null) {
            State.access$2902(v0, Locale.getDefault(Locale$Category.FORMAT));
        }
        else {
            State.access$2902(v0, State.access$2900(arg10));
        }

        this.overridingState = arg10;
    }

    void clearNumber() {
        this.setNumber(-1);
    }

    void clearText() {
        this.setText(null);
    }

    private TypedArray generateTypedArray(Context arg7, int arg8, int arg9, int arg10) {
        int v0;
        AttributeSet v8;
        if(arg8 != 0) {
            v8 = DrawableUtils.parseDrawableXml(arg7, arg8, "badge");
            v0 = v8.getStyleAttribute();
        }
        else {
            v8 = null;
            v0 = 0;
        }

        AttributeSet v1 = v8;
        int v4 = v0 == 0 ? arg10 : v0;
        return ThemeEnforcement.obtainStyledAttributes(arg7, v1, styleable.Badge, arg9, v4, new int[0]);
    }

    int getAdditionalHorizontalOffset() {
        return State.access$2600(this.currentState).intValue();
    }

    int getAdditionalVerticalOffset() {
        return State.access$2700(this.currentState).intValue();
    }

    int getAlpha() {
        return State.access$100(this.currentState);
    }

    int getBackgroundColor() {
        return State.access$1500(this.currentState).intValue();
    }

    int getBadgeGravity() {
        return State.access$1800(this.currentState).intValue();
    }

    int getBadgeHorizontalPadding() {
        return State.access$1900(this.currentState).intValue();
    }

    int getBadgeShapeAppearanceOverlayResId() {
        return State.access$1200(this.currentState).intValue();
    }

    int getBadgeShapeAppearanceResId() {
        return State.access$1100(this.currentState).intValue();
    }

    int getBadgeTextColor() {
        return State.access$1700(this.currentState).intValue();
    }

    int getBadgeVerticalPadding() {
        return State.access$2000(this.currentState).intValue();
    }

    int getBadgeWithTextShapeAppearanceOverlayResId() {
        return State.access$1400(this.currentState).intValue();
    }

    int getBadgeWithTextShapeAppearanceResId() {
        return State.access$1300(this.currentState).intValue();
    }

    int getContentDescriptionExceedsMaxBadgeNumberStringResource() {
        return State.access$700(this.currentState);
    }

    CharSequence getContentDescriptionForText() {
        return State.access$400(this.currentState);
    }

    CharSequence getContentDescriptionNumberless() {
        return State.access$500(this.currentState);
    }

    int getContentDescriptionQuantityStrings() {
        return State.access$600(this.currentState);
    }

    int getHorizontalOffsetWithText() {
        return State.access$2300(this.currentState).intValue();
    }

    int getHorizontalOffsetWithoutText() {
        return State.access$2100(this.currentState).intValue();
    }

    int getLargeFontVerticalOffsetAdjustment() {
        return State.access$2500(this.currentState).intValue();
    }

    int getMaxCharacterCount() {
        return State.access$900(this.currentState);
    }

    int getMaxNumber() {
        return State.access$1000(this.currentState);
    }

    int getNumber() {
        return State.access$200(this.currentState);
    }

    Locale getNumberLocale() {
        return State.access$2900(this.currentState);
    }

    State getOverridingState() {
        return this.overridingState;
    }

    String getText() {
        return State.access$300(this.currentState);
    }

    int getTextAppearanceResId() {
        return State.access$1600(this.currentState).intValue();
    }

    int getVerticalOffsetWithText() {
        return State.access$2400(this.currentState).intValue();
    }

    int getVerticalOffsetWithoutText() {
        return State.access$2200(this.currentState).intValue();
    }

    boolean hasNumber() {
        if(State.access$200(this.currentState) != -1) {
            return 1;
        }

        return 0;
    }

    boolean hasText() {
        if(State.access$300(this.currentState) != null) {
            return 1;
        }

        return 0;
    }

    boolean isAutoAdjustedToGrandparentBounds() {
        return State.access$2800(this.currentState).booleanValue();
    }

    boolean isVisible() {
        return State.access$800(this.currentState).booleanValue();
    }

    private static int readColorFromAttributes(Context arg0, TypedArray arg1, int arg2) {
        return MaterialResources.getColorStateList(arg0, arg1, arg2).getDefaultColor();
    }

    void setAdditionalHorizontalOffset(int arg3) {
        State.access$2602(this.overridingState, Integer.valueOf(arg3));
        State.access$2602(this.currentState, Integer.valueOf(arg3));
    }

    void setAdditionalVerticalOffset(int arg3) {
        State.access$2702(this.overridingState, Integer.valueOf(arg3));
        State.access$2702(this.currentState, Integer.valueOf(arg3));
    }

    void setAlpha(int arg2) {
        State.access$102(this.overridingState, arg2);
        State.access$102(this.currentState, arg2);
    }

    void setAutoAdjustToGrandparentBounds(boolean arg3) {
        State.access$2802(this.overridingState, Boolean.valueOf(arg3));
        State.access$2802(this.currentState, Boolean.valueOf(arg3));
    }

    void setBackgroundColor(int arg3) {
        State.access$1502(this.overridingState, Integer.valueOf(arg3));
        State.access$1502(this.currentState, Integer.valueOf(arg3));
    }

    void setBadgeGravity(int arg3) {
        State.access$1802(this.overridingState, Integer.valueOf(arg3));
        State.access$1802(this.currentState, Integer.valueOf(arg3));
    }

    void setBadgeHorizontalPadding(int arg3) {
        State.access$1902(this.overridingState, Integer.valueOf(arg3));
        State.access$1902(this.currentState, Integer.valueOf(arg3));
    }

    void setBadgeShapeAppearanceOverlayResId(int arg3) {
        State.access$1202(this.overridingState, Integer.valueOf(arg3));
        State.access$1202(this.currentState, Integer.valueOf(arg3));
    }

    void setBadgeShapeAppearanceResId(int arg3) {
        State.access$1102(this.overridingState, Integer.valueOf(arg3));
        State.access$1102(this.currentState, Integer.valueOf(arg3));
    }

    void setBadgeTextColor(int arg3) {
        State.access$1702(this.overridingState, Integer.valueOf(arg3));
        State.access$1702(this.currentState, Integer.valueOf(arg3));
    }

    void setBadgeVerticalPadding(int arg3) {
        State.access$2002(this.overridingState, Integer.valueOf(arg3));
        State.access$2002(this.currentState, Integer.valueOf(arg3));
    }

    void setBadgeWithTextShapeAppearanceOverlayResId(int arg3) {
        State.access$1402(this.overridingState, Integer.valueOf(arg3));
        State.access$1402(this.currentState, Integer.valueOf(arg3));
    }

    void setBadgeWithTextShapeAppearanceResId(int arg3) {
        State.access$1302(this.overridingState, Integer.valueOf(arg3));
        State.access$1302(this.currentState, Integer.valueOf(arg3));
    }

    void setContentDescriptionExceedsMaxBadgeNumberStringResource(int arg2) {
        State.access$702(this.overridingState, arg2);
        State.access$702(this.currentState, arg2);
    }

    void setContentDescriptionForText(CharSequence arg2) {
        State.access$402(this.overridingState, arg2);
        State.access$402(this.currentState, arg2);
    }

    void setContentDescriptionNumberless(CharSequence arg2) {
        State.access$502(this.overridingState, arg2);
        State.access$502(this.currentState, arg2);
    }

    void setContentDescriptionQuantityStringsResource(int arg2) {
        State.access$602(this.overridingState, arg2);
        State.access$602(this.currentState, arg2);
    }

    void setHorizontalOffsetWithText(int arg3) {
        State.access$2302(this.overridingState, Integer.valueOf(arg3));
        State.access$2302(this.currentState, Integer.valueOf(arg3));
    }

    void setHorizontalOffsetWithoutText(int arg3) {
        State.access$2102(this.overridingState, Integer.valueOf(arg3));
        State.access$2102(this.currentState, Integer.valueOf(arg3));
    }

    void setLargeFontVerticalOffsetAdjustment(int arg3) {
        State.access$2502(this.overridingState, Integer.valueOf(arg3));
        State.access$2502(this.currentState, Integer.valueOf(arg3));
    }

    void setMaxCharacterCount(int arg2) {
        State.access$902(this.overridingState, arg2);
        State.access$902(this.currentState, arg2);
    }

    void setMaxNumber(int arg2) {
        State.access$1002(this.overridingState, arg2);
        State.access$1002(this.currentState, arg2);
    }

    void setNumber(int arg2) {
        State.access$202(this.overridingState, arg2);
        State.access$202(this.currentState, arg2);
    }

    void setNumberLocale(Locale arg2) {
        State.access$2902(this.overridingState, arg2);
        State.access$2902(this.currentState, arg2);
    }

    void setText(String arg2) {
        State.access$302(this.overridingState, arg2);
        State.access$302(this.currentState, arg2);
    }

    void setTextAppearanceResId(int arg3) {
        State.access$1602(this.overridingState, Integer.valueOf(arg3));
        State.access$1602(this.currentState, Integer.valueOf(arg3));
    }

    void setVerticalOffsetWithText(int arg3) {
        State.access$2402(this.overridingState, Integer.valueOf(arg3));
        State.access$2402(this.currentState, Integer.valueOf(arg3));
    }

    void setVerticalOffsetWithoutText(int arg3) {
        State.access$2202(this.overridingState, Integer.valueOf(arg3));
        State.access$2202(this.currentState, Integer.valueOf(arg3));
    }

    void setVisible(boolean arg3) {
        State.access$802(this.overridingState, Boolean.valueOf(arg3));
        State.access$802(this.currentState, Boolean.valueOf(arg3));
    }
}

