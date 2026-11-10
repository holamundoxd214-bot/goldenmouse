package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;

public class CardView extends FrameLayout {
    class androidx.cardview.widget.CardView$1 implements CardViewDelegate {
        private Drawable mCardBackground;

        androidx.cardview.widget.CardView$1(CardView arg1) {
            CardView.this = arg1;
            super();
        }

        public Drawable getCardBackground() {
            return this.mCardBackground;
        }

        public View getCardView() {
            return CardView.this;
        }

        public boolean getPreventCornerOverlap() {
            return CardView.this.getPreventCornerOverlap();
        }

        public boolean getUseCompatPadding() {
            return CardView.this.getUseCompatPadding();
        }

        public void setCardBackground(Drawable arg1) {
            this.mCardBackground = arg1;
            CardView.this.setBackgroundDrawable(arg1);
        }

        public void setMinWidthHeightInternal(int arg2, int arg3) {
            if(arg2 > CardView.this.mUserSetMinWidth) {
                CardView.access$101(CardView.this, arg2);
            }

            if(arg3 > CardView.this.mUserSetMinHeight) {
                CardView.access$201(CardView.this, arg3);
            }
        }

        public void setShadowPadding(int arg3, int arg4, int arg5, int arg6) {
            CardView.this.mShadowBounds.set(arg3, arg4, arg5, arg6);
            CardView.access$001(CardView.this, arg3 + CardView.this.mContentPadding.left, arg4 + CardView.this.mContentPadding.top, arg5 + CardView.this.mContentPadding.right, arg6 + CardView.this.mContentPadding.bottom);
        }
    }

    private static final int[] COLOR_BACKGROUND_ATTR;
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    static {
        CardView.COLOR_BACKGROUND_ATTR = new int[]{0x1010031};
        CardViewApi21Impl v0 = new CardViewApi21Impl();
        CardView.IMPL = ((CardViewImpl)v0);
        ((CardViewImpl)v0).initStatic();
    }

    public CardView(Context arg2) {
        this(arg2, null);
    }

    public CardView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.cardViewStyle);
    }

    public CardView(Context arg10, AttributeSet arg11, int arg12) {
        int v2;
        ColorStateList v12;
        super(arg10, arg11, arg12);
        Rect v0 = new Rect();
        this.mContentPadding = v0;
        this.mShadowBounds = new Rect();
        androidx.cardview.widget.CardView$1 v3 = new androidx.cardview.widget.CardView$1(this);
        this.mCardViewDelegate = ((CardViewDelegate)v3);
        TypedArray v11 = arg10.obtainStyledAttributes(arg11, styleable.CardView, arg12, style.CardView);
        if(v11.hasValue(styleable.CardView_cardBackgroundColor)) {
            v12 = v11.getColorStateList(styleable.CardView_cardBackgroundColor);
        }
        else {
            TypedArray v12_1 = this.getContext().obtainStyledAttributes(CardView.COLOR_BACKGROUND_ATTR);
            v2 = v12_1.getColor(0, 0);
            v12_1.recycle();
            float[] v12_2 = new float[3];
            Color.colorToHSV(v2, v12_2);
            arg12 = v12_2[2] > 0.5f ? this.getResources().getColor(color.cardview_light_background) : this.getResources().getColor(color.cardview_dark_background);
            v12 = ColorStateList.valueOf(arg12);
        }

        ColorStateList v5 = v12;
        float v6 = v11.getDimension(styleable.CardView_cardCornerRadius, 0f);
        float v7 = v11.getDimension(styleable.CardView_cardElevation, 0f);
        float v12_3 = v11.getDimension(styleable.CardView_cardMaxElevation, 0f);
        this.mCompatPadding = v11.getBoolean(styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = v11.getBoolean(styleable.CardView_cardPreventCornerOverlap, true);
        v2 = v11.getDimensionPixelSize(styleable.CardView_contentPadding, 0);
        v0.left = v11.getDimensionPixelSize(styleable.CardView_contentPaddingLeft, v2);
        v0.top = v11.getDimensionPixelSize(styleable.CardView_contentPaddingTop, v2);
        v0.right = v11.getDimensionPixelSize(styleable.CardView_contentPaddingRight, v2);
        v0.bottom = v11.getDimensionPixelSize(styleable.CardView_contentPaddingBottom, v2);
        float v8 = v7 > v12_3 ? v7 : v12_3;
        this.mUserSetMinWidth = v11.getDimensionPixelSize(styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = v11.getDimensionPixelSize(styleable.CardView_android_minHeight, 0);
        v11.recycle();
        CardView.IMPL.initialize(((CardViewDelegate)v3), arg10, v5, v6, v7, v8);
    }

    static void access$001(CardView arg0, int arg1, int arg2, int arg3, int arg4) {
        super.setPadding(arg1, arg2, arg3, arg4);
    }

    static void access$101(CardView arg0, int arg1) {
        super.setMinimumWidth(arg1);
    }

    static void access$201(CardView arg0, int arg1) {
        super.setMinimumHeight(arg1);
    }

    public ColorStateList getCardBackgroundColor() {
        return CardView.IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return CardView.IMPL.getElevation(this.mCardViewDelegate);
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return CardView.IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return CardView.IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    protected void onMeasure(int arg7, int arg8) {
        CardViewImpl v0 = CardView.IMPL;
        if(!(v0 instanceof CardViewApi21Impl)) {
            int v1 = View$MeasureSpec.getMode(arg7);
            int v2 = 0x40000000;
            int v3 = 0x80000000;
            if(v1 == v3 || v1 == v2) {
                arg7 = View$MeasureSpec.makeMeasureSpec(Math.max(((int)Math.ceil(((double)v0.getMinWidth(this.mCardViewDelegate)))), View$MeasureSpec.getSize(arg7)), v1);
            }
            else {
            }

            v1 = View$MeasureSpec.getMode(arg8);
            if(v1 == v3 || v1 == v2) {
                arg8 = View$MeasureSpec.makeMeasureSpec(Math.max(((int)Math.ceil(((double)v0.getMinHeight(this.mCardViewDelegate)))), View$MeasureSpec.getSize(arg8)), v1);
            }
            else {
            }

            super.onMeasure(arg7, arg8);
            return;
        }

        super.onMeasure(arg7, arg8);
    }

    public void setCardBackgroundColor(int arg2) {
        CardView.IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(arg2));
    }

    public void setCardBackgroundColor(ColorStateList arg2) {
        CardView.IMPL.setBackgroundColor(this.mCardViewDelegate, arg2);
    }

    public void setCardElevation(float arg2) {
        CardView.IMPL.setElevation(this.mCardViewDelegate, arg2);
    }

    public void setContentPadding(int arg2, int arg3, int arg4, int arg5) {
        this.mContentPadding.set(arg2, arg3, arg4, arg5);
        CardView.IMPL.updatePadding(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float arg2) {
        CardView.IMPL.setMaxElevation(this.mCardViewDelegate, arg2);
    }

    public void setMinimumHeight(int arg1) {
        this.mUserSetMinHeight = arg1;
        super.setMinimumHeight(arg1);
    }

    public void setMinimumWidth(int arg1) {
        this.mUserSetMinWidth = arg1;
        super.setMinimumWidth(arg1);
    }

    public void setPadding(int arg1, int arg2, int arg3, int arg4) {
    }

    public void setPaddingRelative(int arg1, int arg2, int arg3, int arg4) {
    }

    public void setPreventCornerOverlap(boolean arg2) {
        if(arg2 != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = arg2;
            CardView.IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        }
    }

    public void setRadius(float arg2) {
        CardView.IMPL.setRadius(this.mCardViewDelegate, arg2);
    }

    public void setUseCompatPadding(boolean arg2) {
        if(this.mCompatPadding != arg2) {
            this.mCompatPadding = arg2;
            CardView.IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        }
    }
}

