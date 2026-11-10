package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View$MeasureSpec;
import android.view.View;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialToolbar extends Toolbar {
    private static final int DEF_STYLE_RES;
    private static final ImageView$ScaleType[] LOGO_SCALE_TYPE_ARRAY;
    private Boolean logoAdjustViewBounds;
    private ImageView$ScaleType logoScaleType;
    private Integer navigationIconTint;
    private boolean subtitleCentered;
    private boolean titleCentered;

    static {
        MaterialToolbar.DEF_STYLE_RES = style.Widget_MaterialComponents_Toolbar;
        MaterialToolbar.LOGO_SCALE_TYPE_ARRAY = new ImageView$ScaleType[]{ImageView$ScaleType.MATRIX, ImageView$ScaleType.FIT_XY, ImageView$ScaleType.FIT_START, ImageView$ScaleType.FIT_CENTER, ImageView$ScaleType.FIT_END, ImageView$ScaleType.CENTER, ImageView$ScaleType.CENTER_CROP, ImageView$ScaleType.CENTER_INSIDE};
    }

    public MaterialToolbar(Context arg2) {
        this(arg2, null);
    }

    public MaterialToolbar(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.toolbarStyle);
    }

    public MaterialToolbar(Context arg7, AttributeSet arg8, int arg9) {
        int v4 = MaterialToolbar.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg7, arg8, arg9, v4), arg8, arg9);
        Context v0 = this.getContext();
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(v0, arg8, styleable.MaterialToolbar, arg9, v4, new int[0]);
        int v1 = -1;
        if(v8.hasValue(styleable.MaterialToolbar_navigationIconTint)) {
            this.setNavigationIconTint(v8.getColor(styleable.MaterialToolbar_navigationIconTint, v1));
        }

        this.titleCentered = v8.getBoolean(styleable.MaterialToolbar_titleCentered, false);
        this.subtitleCentered = v8.getBoolean(styleable.MaterialToolbar_subtitleCentered, false);
        arg9 = v8.getInt(styleable.MaterialToolbar_logoScaleType, v1);
        if(arg9 >= 0) {
            ImageView$ScaleType[] v1_1 = MaterialToolbar.LOGO_SCALE_TYPE_ARRAY;
            if(arg9 < v1_1.length) {
                this.logoScaleType = v1_1[arg9];
            }
        }

        if(v8.hasValue(styleable.MaterialToolbar_logoAdjustViewBounds)) {
            this.logoAdjustViewBounds = Boolean.valueOf(v8.getBoolean(styleable.MaterialToolbar_logoAdjustViewBounds, false));
        }

        v8.recycle();
        this.initBackground(v0);
    }

    private Pair calculateTitleBoundLimits(TextView arg8, TextView arg9) {
        int v0 = this.getMeasuredWidth();
        int v1 = v0 / 2;
        int v2 = this.getPaddingLeft();
        v0 -= this.getPaddingRight();
        int v3;
        for(v3 = 0; v3 < this.getChildCount(); ++v3) {
            View v4 = this.getChildAt(v3);
            if(v4.getVisibility() != 8 && (((TextView)v4)) != arg8 && (((TextView)v4)) != arg9) {
                if(v4.getRight() < v1 && v4.getRight() > v2) {
                    v2 = v4.getRight();
                }

                if(v4.getLeft() <= v1) {
                    goto label_24;
                }

                if(v4.getLeft() >= v0) {
                    goto label_24;
                }

                v0 = v4.getLeft();
            }

        label_24:
        }

        return new Pair(Integer.valueOf(v2), Integer.valueOf(v0));
    }

    public void clearNavigationIconTint() {
        Integer v0 = null;
        this.navigationIconTint = v0;
        Drawable v1 = this.getNavigationIcon();
        if(v1 != null) {
            DrawableCompat.setTintList(DrawableCompat.wrap(v1.mutate()), ((ColorStateList)v0));
            this.setNavigationIcon(v1);
        }
    }

    public ImageView$ScaleType getLogoScaleType() {
        return this.logoScaleType;
    }

    public Integer getNavigationIconTint() {
        return this.navigationIconTint;
    }

    public void inflateMenu(int arg4) {
        Menu v0 = this.getMenu();
        boolean v1 = v0 instanceof MenuBuilder;
        if(v1) {
            v0.stopDispatchingItemsChanged();
        }

        super.inflateMenu(arg4);
        if(v1) {
            ((MenuBuilder)v0).startDispatchingItemsChanged();
        }
    }

    private void initBackground(Context arg3) {
        Drawable v0 = this.getBackground();
        ColorStateList v0_1 = v0 == null ? ColorStateList.valueOf(0) : DrawableUtils.getColorStateListOrNull(v0);
        if(v0_1 != null) {
            MaterialShapeDrawable v1 = new MaterialShapeDrawable();
            v1.setFillColor(v0_1);
            v1.initializeElevationOverlay(arg3);
            v1.setElevation(ViewCompat.getElevation(((View)this)));
            ViewCompat.setBackground(((View)this), ((Drawable)v1));
        }
    }

    public boolean isLogoAdjustViewBounds() {
        Boolean v0 = this.logoAdjustViewBounds;
        if(v0 != null && (v0.booleanValue())) {
            return 1;
        }

        return 0;
    }

    public boolean isSubtitleCentered() {
        return this.subtitleCentered;
    }

    public boolean isTitleCentered() {
        return this.titleCentered;
    }

    private void layoutTitleCenteredHorizontally(View arg4, Pair arg5) {
        int v3 = this.getMeasuredWidth();
        int v0 = arg4.getMeasuredWidth();
        v3 = v3 / 2 - v0 / 2;
        v0 += v3;
        int v5 = Math.max(Math.max(arg5.first.intValue() - v3, 0), Math.max(v0 - arg5.second.intValue(), 0));
        if(v5 > 0) {
            v3 += v5;
            v0 -= v5;
            arg4.measure(View$MeasureSpec.makeMeasureSpec(v0 - v3, 0x40000000), arg4.getMeasuredHeightAndState());
        }

        arg4.layout(v3, arg4.getTop(), v0, arg4.getBottom());
    }

    private void maybeCenterTitleViews() {
        if((this.titleCentered) || (this.subtitleCentered)) {
            TextView v0 = ToolbarUtils.getTitleTextView(((Toolbar)this));
            TextView v1 = ToolbarUtils.getSubtitleTextView(((Toolbar)this));
            if(v0 == null && v1 == null) {
                return;
            }

            Pair v2 = this.calculateTitleBoundLimits(v0, v1);
            if((this.titleCentered) && v0 != null) {
                this.layoutTitleCenteredHorizontally(((View)v0), v2);
            }

            if(!this.subtitleCentered) {
                return;
            }

            if(v1 == null) {
                return;
            }

            this.layoutTitleCenteredHorizontally(((View)v1), v2);
        }
        else {
        }
    }

    private Drawable maybeTintNavigationIcon(Drawable arg2) {
        if(arg2 != null && this.navigationIconTint != null) {
            arg2 = DrawableCompat.wrap(arg2.mutate());
            DrawableCompat.setTint(arg2, this.navigationIconTint.intValue());
        }

        return arg2;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(((View)this));
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        this.maybeCenterTitleViews();
        this.updateLogoImageView();
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        MaterialShapeUtils.setElevation(((View)this), arg1);
    }

    public void setLogoAdjustViewBounds(boolean arg2) {
        Boolean v0 = this.logoAdjustViewBounds;
        if(v0 != null) {
            if(v0.booleanValue() != arg2) {
            }
            else {
                return;
            }
        }

        this.logoAdjustViewBounds = Boolean.valueOf(arg2);
        this.requestLayout();
    }

    public void setLogoScaleType(ImageView$ScaleType arg2) {
        if(this.logoScaleType != arg2) {
            this.logoScaleType = arg2;
            this.requestLayout();
        }
    }

    public void setNavigationIcon(Drawable arg1) {
        super.setNavigationIcon(this.maybeTintNavigationIcon(arg1));
    }

    public void setNavigationIconTint(int arg1) {
        this.navigationIconTint = Integer.valueOf(arg1);
        Drawable v1 = this.getNavigationIcon();
        if(v1 != null) {
            this.setNavigationIcon(v1);
        }
    }

    public void setSubtitleCentered(boolean arg2) {
        if(this.subtitleCentered != arg2) {
            this.subtitleCentered = arg2;
            this.requestLayout();
        }
    }

    public void setTitleCentered(boolean arg2) {
        if(this.titleCentered != arg2) {
            this.titleCentered = arg2;
            this.requestLayout();
        }
    }

    private void updateLogoImageView() {
        ImageView v0 = ToolbarUtils.getLogoImageView(((Toolbar)this));
        if(v0 != null) {
            Boolean v1 = this.logoAdjustViewBounds;
            if(v1 != null) {
                v0.setAdjustViewBounds(v1.booleanValue());
            }

            ImageView$ScaleType v2 = this.logoScaleType;
            if(v2 == null) {
                return;
            }

            v0.setScaleType(v2);
        }
    }
}

