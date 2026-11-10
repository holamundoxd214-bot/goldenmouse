package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R$styleable;

public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context arg2) {
        this(arg2, null);
    }

    public TabItem(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        TintTypedArray v2 = TintTypedArray.obtainStyledAttributes(arg2, arg3, styleable.TabItem);
        this.text = v2.getText(styleable.TabItem_android_text);
        this.icon = v2.getDrawable(styleable.TabItem_android_icon);
        this.customLayout = v2.getResourceId(styleable.TabItem_android_layout, 0);
        v2.recycle();
    }
}

