package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources$Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context arg2) {
        this(arg2, null);
    }

    public MaterialTextView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0x1010084);
    }

    public MaterialTextView(Context arg2, AttributeSet arg3, int arg4) {
        super(MaterialThemeOverlay.wrap(arg2, arg3, arg4, 0), arg3, arg4);
        this.initialize(arg3, arg4, 0);
    }

    @Deprecated public MaterialTextView(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        super(MaterialThemeOverlay.wrap(arg1, arg2, arg3, arg4), arg2, arg3);
        this.initialize(arg2, arg3, arg4);
    }

    private void applyLineHeightFromViewAppearance(Resources$Theme arg3, int arg4) {
        TypedArray v3 = arg3.obtainStyledAttributes(arg4, styleable.MaterialTextAppearance);
        arg4 = MaterialTextView.readFirstAvailableDimension(this.getContext(), v3, new int[]{styleable.MaterialTextAppearance_android_lineHeight, styleable.MaterialTextAppearance_lineHeight});
        v3.recycle();
        if(arg4 >= 0) {
            this.setLineHeight(arg4);
        }
    }

    private static boolean canApplyTextAppearanceLineHeight(Context arg2) {
        return MaterialAttributes.resolveBoolean(arg2, attr.textAppearanceLineHeightEnabled, true);
    }

    private static int findViewAppearanceResourceId(Resources$Theme arg1, AttributeSet arg2, int arg3, int arg4) {
        TypedArray v1 = arg1.obtainStyledAttributes(arg2, styleable.MaterialTextView, arg3, arg4);
        int v2 = v1.getResourceId(styleable.MaterialTextView_android_textAppearance, -1);
        v1.recycle();
        return v2;
    }

    private void initialize(AttributeSet arg3, int arg4, int arg5) {
        Context v0 = this.getContext();
        if(MaterialTextView.canApplyTextAppearanceLineHeight(v0)) {
            Resources$Theme v1 = v0.getTheme();
            if(!MaterialTextView.viewAttrsHasLineHeight(v0, v1, arg3, arg4, arg5)) {
                int v3 = MaterialTextView.findViewAppearanceResourceId(v1, arg3, arg4, arg5);
                if(v3 != -1) {
                    this.applyLineHeightFromViewAppearance(v1, v3);
                }
            }
        }
    }

    private static int readFirstAvailableDimension(Context arg4, TypedArray arg5, int[] arg6) {
        int v0 = -1;
        int v1 = 0;
        int v2 = v0;
        while(v1 < arg6.length) {
            if(v2 >= 0) {
                return v2;
            }

            v2 = MaterialResources.getDimensionPixelSize(arg4, arg5, arg6[v1], v0);
            ++v1;
        }

        return v2;
    }

    public void setTextAppearance(Context arg2, int arg3) {
        super.setTextAppearance(arg2, arg3);
        if(MaterialTextView.canApplyTextAppearanceLineHeight(arg2)) {
            this.applyLineHeightFromViewAppearance(arg2.getTheme(), arg3);
        }
    }

    private static boolean viewAttrsHasLineHeight(Context arg1, Resources$Theme arg2, AttributeSet arg3, int arg4, int arg5) {
        TypedArray v2 = arg2.obtainStyledAttributes(arg3, styleable.MaterialTextView, arg4, arg5);
        int v1 = MaterialTextView.readFirstAvailableDimension(arg1, v2, new int[]{styleable.MaterialTextView_android_lineHeight, styleable.MaterialTextView_lineHeight});
        v2.recycle();
        if(v1 != -1) {
            return 1;
        }

        return 0;
    }
}

