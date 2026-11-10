package com.TryJeanPc.goldenmouse.sharksettings;

import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.TryJeanPc.goldenmouse.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\f\u0010\u0011\u001A\b\u0018\u00010\u0012R\u00020\fH\u0016J\u0010\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\u0015H\u0014J\u0010\u0010\u0016\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\u0018H\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0015H\u0016J\b\u0010\u001C\u001A\u00020\u001DH\u0016J\b\u0010\u001E\u001A\u00020\u001DH\u0016J\u0010\u0010\u001F\u001A\u00020\n2\u0006\u0010 \u001A\u00020\u001DH\u0016J\u0012\u0010!\u001A\u00020\n2\b\u0010\"\u001A\u0004\u0018\u00010#H\u0016J\b\u0010$\u001A\u00020\u001DH\u0016R\u000E\u0010\u0004\u001A\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Lcom/TryJeanPc/goldenmouse/sharksettings/SharkBlueSelectionDrawable;", "Landroid/graphics/drawable/Drawable;", "<init>", "()V", "mask", "layerBounds", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "inflate", "", "resources", "Landroid/content/res/Resources;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "attrs", "Landroid/util/AttributeSet;", "theme", "Landroid/content/res/Resources$Theme;", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "draw", "canvas", "Landroid/graphics/Canvas;", "getPadding", "", "padding", "getIntrinsicWidth", "", "getIntrinsicHeight", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class SharkBlueSelectionDrawable extends Drawable {
    public static final int $stable = 8;
    private final RectF layerBounds;
    private Drawable mask;
    private final Paint paint;

    static {
    }

    public SharkBlueSelectionDrawable() {
        super();
        this.layerBounds = new RectF();
        Paint v0 = new Paint(1);
        v0.setXfermode(new PorterDuffXfermode(PorterDuff$Mode.SRC_IN));
        this.paint = v0;
    }

    public void draw(Canvas arg4) {
        Intrinsics.checkNotNullParameter(arg4, "canvas");
        if(this.getBounds().isEmpty()) {
            return;
        }

        Paint v1 = null;
        int v0 = arg4.saveLayer(this.layerBounds, v1);
        Drawable v2 = this.mask;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mask");
        }
        else {
            Drawable v1_1 = v2;
        }

        ((Drawable)v1).draw(arg4);
        arg4.drawRect(this.layerBounds, this.paint);
        arg4.restoreToCount(v0);
    }

    public int getIntrinsicHeight() {
        Drawable v0 = this.mask;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mask");
            v0 = null;
        }

        return v0.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable v0 = this.mask;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mask");
            v0 = null;
        }

        return v0.getIntrinsicWidth();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect arg2) {
        Intrinsics.checkNotNullParameter(arg2, "padding");
        Drawable v1 = this.mask;
        if(v1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mask");
            v1 = null;
        }

        return v1.getPadding(arg2);
    }

    public void inflate(Resources arg2, XmlPullParser arg3, AttributeSet arg4, Resources$Theme arg5) {
        Intrinsics.checkNotNullParameter(arg2, "resources");
        Intrinsics.checkNotNullParameter(arg3, "parser");
        Intrinsics.checkNotNullParameter(arg4, "attrs");
        super.inflate(arg2, arg3, arg4, arg5);
        Drawable v2 = arg2.getDrawable(drawable.shark_settings_ir4s_itemview_select_bg, arg5).mutate();
        Intrinsics.checkNotNullExpressionValue(v2, "mutate(...)");
        this.mask = v2;
    }

    protected void onBoundsChange(Rect arg9) {
        Intrinsics.checkNotNullParameter(arg9, "bounds");
        Drawable v0 = this.mask;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mask");
            v0 = null;
        }

        v0.setBounds(arg9);
        this.layerBounds.set(arg9);
        this.paint.setShader(new LinearGradient(0f, ((float)arg9.top), 0f, ((float)Math.max(arg9.bottom, arg9.top + 1)), new int[]{0xC792DCFF, 0xB578BFF2, -1386108702}, new float[]{0f, 0.42f, 1f}, Shader$TileMode.CLAMP));
    }

    public void setAlpha(int arg2) {
        this.paint.setAlpha(arg2);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter arg2) {
        this.paint.setColorFilter(arg2);
        this.invalidateSelf();
    }
}

