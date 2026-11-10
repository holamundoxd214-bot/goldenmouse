package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\u0017\u001A\u00020\u0018*\u00020\u0019H\u0014J\u0010\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u0013\u001A\u00020\u0014H\u0014J\u0012\u0010 \u001A\u00020\u001F2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0014J\u001F\u0010!\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001A\u00020\u001F2\b\u0010%\u001A\u0004\u0018\u00010&H\u0096\u0002J\b\u0010\'\u001A\u00020(H\u0016J\b\u0010)\u001A\u00020*H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001C\u0010\u000B\u001A\u00020\fX\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0011\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u0010\u0010\u0012\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001A\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u0006+"}, d2={"Landroidx/compose/ui/graphics/painter/BitmapPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I$ui_graphics", "()I", "setFilterQuality-vDHp3xo$ui_graphics", "(I)V", "I", "size", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "applyAlpha", "", "applyColorFilter", "validateSize", "validateSize-N5eqBDc", "(JJ)J", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BitmapPainter extends Painter {
    public static final int $stable = 8;
    private float alpha;
    private ColorFilter colorFilter;
    private int filterQuality;
    private final ImageBitmap image;
    private final long size;
    private final long srcOffset;
    private final long srcSize;

    static {
    }

    public BitmapPainter(ImageBitmap arg8, long arg9, long arg11, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 2) != 0) {
            arg9 = IntOffset.Companion.getZero-nOcc-ac();
        }

        long v2 = arg9;
        if((arg13 & 4) != 0) {
            arg11 = IntSize.constructor-impl((((long)arg8.getHeight())) & 0xFFFFFFFFL | (((long)arg8.getWidth())) << 0x20);
        }

        this(arg8, v2, arg11, null);
    }

    private BitmapPainter(ImageBitmap arg1, long arg2, long arg4) {
        super();
        this.image = arg1;
        this.srcOffset = arg2;
        this.srcSize = arg4;
        this.filterQuality = FilterQuality.Companion.getLow-f-v9h1I();
        this.size = this.validateSize-N5eqBDc(arg2, arg4);
        this.alpha = 1f;
    }

    public BitmapPainter(ImageBitmap arg1, long arg2, long arg4, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg4);
    }

    protected boolean applyAlpha(float arg1) {
        this.alpha = arg1;
        return 1;
    }

    protected boolean applyColorFilter(ColorFilter arg1) {
        this.colorFilter = arg1;
        return 1;
    }

    public boolean equals(Object arg8) {
        if(this == (((BitmapPainter)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof BitmapPainter)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.image, ((BitmapPainter)arg8).image)) {
            return 0;
        }

        if(!IntOffset.equals-impl0(this.srcOffset, ((BitmapPainter)arg8).srcOffset)) {
            return 0;
        }

        if(!IntSize.equals-impl0(this.srcSize, ((BitmapPainter)arg8).srcSize)) {
            return 0;
        }

        if(!FilterQuality.equals-impl0(this.filterQuality, ((BitmapPainter)arg8).filterQuality)) {
            return 0;
        }

        return 1;
    }

    public final int getFilterQuality-f-v9h1I$ui_graphics() {
        return this.filterQuality;
    }

    public long getIntrinsicSize-NH-jbRc() {
        return IntSizeKt.toSize-ozmzZPI(this.size);
    }

    public int hashCode() {
        return ((this.image.hashCode() * 0x1F + IntOffset.hashCode-impl(this.srcOffset)) * 0x1F + IntSize.hashCode-impl(this.srcSize)) * 0x1F + FilterQuality.hashCode-impl(this.filterQuality);
    }

    protected void onDraw(DrawScope arg18) {
        DrawScope.drawImage-AZ2fEMs$default(arg18, this.image, this.srcOffset, this.srcSize, 0, IntSize.constructor-impl((((long)Math.round(Float.intBitsToFloat(((int)(arg18.getSize-NH-jbRc() & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | (((long)Math.round(Float.intBitsToFloat(((int)(arg18.getSize-NH-jbRc() >> 0x20)))))) << 0x20), this.alpha, null, this.colorFilter, 0, this.filterQuality, 328, null);
    }

    public final void setFilterQuality-vDHp3xo$ui_graphics(int arg1) {
        this.filterQuality = arg1;
    }

    public String toString() {
        return "BitmapPainter(image=" + this.image + ", srcOffset=" + IntOffset.toString-impl(this.srcOffset) + ", srcSize=" + IntSize.toString-impl(this.srcSize) + ", filterQuality=" + FilterQuality.toString-impl(this.filterQuality) + ')';
    }

    private final long validateSize-N5eqBDc(long arg3, long arg5) {
        if(IntOffset.getX-impl(arg3) >= 0 && IntOffset.getY-impl(arg3) >= 0) {
            int v3 = ((int)(arg5 >> 0x20));
            if(v3 >= 0) {
                int v4 = ((int)(0xFFFFFFFFL & arg5));
                if(v4 >= 0 && v3 <= this.image.getWidth() && v4 <= this.image.getHeight()) {
                    return arg5;
                }
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

