package androidx.compose.ui.text.platform.style;

import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0015\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0017H\u0016Jp\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\u001E\u001A\u00020\u00132\u0006\u0010\u001F\u001A\u00020\u00132\u0006\u0010 \u001A\u00020\u00132\u0006\u0010!\u001A\u00020\u00132\u0006\u0010\"\u001A\u00020\u00132\b\u0010#\u001A\u0004\u0018\u00010$2\u0006\u0010%\u001A\u00020\u00132\u0006\u0010&\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u00172\b\u0010\'\u001A\u0004\u0018\u00010(H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"Landroidx/compose/ui/text/platform/style/CustomBulletSpan;", "Landroid/text/style/LeadingMarginSpan;", "shape", "Landroidx/compose/ui/graphics/Shape;", "bulletWidthPx", "", "bulletHeightPx", "gapWidthPx", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "density", "Landroidx/compose/ui/unit/Density;", "textIndentPx", "<init>", "(Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/unit/Density;F)V", "minimumRequiredIndent", "", "diff", "getLeadingMargin", "first", "", "drawLeadingMargin", "", "c", "Landroid/graphics/Canvas;", "p", "Landroid/graphics/Paint;", "x", "dir", "top", "baseline", "bottom", "text", "", "start", "end", "layout", "Landroid/text/Layout;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CustomBulletSpan implements LeadingMarginSpan {
    public static final int $stable;
    private final float alpha;
    private final Brush brush;
    private final float bulletHeightPx;
    private final float bulletWidthPx;
    private final Density density;
    private final int diff;
    private final DrawStyle drawStyle;
    private final int minimumRequiredIndent;
    private final Shape shape;

    public static Unit $r8$lambda$oULVl-FUQ73Gsq6SJmIijOCV3-E(CustomBulletSpan arg0, long arg1, int arg3, Canvas arg4, Paint arg5, int arg6, float arg7) {
        return CustomBulletSpan.drawLeadingMargin$lambda$0$0(arg0, arg1, arg3, arg4, arg5, arg6, arg7);
    }

    static {
        CustomBulletSpan.$stable = DrawStyle.$stable;
    }

    public CustomBulletSpan(Shape arg1, float arg2, float arg3, float arg4, Brush arg5, float arg6, DrawStyle arg7, Density arg8, float arg9) {
        super();
        this.shape = arg1;
        this.bulletWidthPx = arg2;
        this.bulletHeightPx = arg3;
        this.brush = arg5;
        this.alpha = arg6;
        this.drawStyle = arg7;
        this.density = arg8;
        int v1 = MathKt.roundToInt(arg2 + arg4);
        this.minimumRequiredIndent = v1;
        this.diff = MathKt.roundToInt(arg9) - v1;
    }

    public void drawLeadingMargin(Canvas arg13, Paint arg14, int arg15, int arg16, int arg17, int arg18, int arg19, CharSequence arg20, int arg21, int arg22, boolean arg23, Layout arg24) {
        CharSequence v0 = arg20;
        if(arg13 == null) {
        }
        else {
            float v11 = (((float)(arg17 + arg19))) / 2f;
            int v10 = RangesKt.coerceAtLeast(arg15 - this.minimumRequiredIndent, 0);
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type android.text.Spanned");
            if(v0.getSpanStart(this) == arg21 && arg14 != null) {
                Paint$Style v15 = arg14.getStyle();
                BulletSpan_androidKt.setDrawStyle(arg14, this.drawStyle);
                long v5 = Size.constructor-impl((((long)Float.floatToRawIntBits(this.bulletHeightPx))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(this.bulletWidthPx))) << 0x20);
                BulletSpan_androidKt.setBrushAndDraw-yzxVdVo(arg14, this.brush, this.alpha, v5, new CustomBulletSpan$$ExternalSyntheticLambda0(this, v5, arg16, arg13, arg14, v10, v11));
                arg14.setStyle(v15);
            }
        }
    }

    private static final Unit drawLeadingMargin$lambda$0$0(CustomBulletSpan arg2, long arg3, int arg5, Canvas arg6, Paint arg7, int arg8, float arg9) {
        Shape v0 = arg2.shape;
        LayoutDirection v1 = arg5 > 0 ? LayoutDirection.Ltr : LayoutDirection.Rtl;
        BulletSpan_androidKt.draw(v0.createOutline-Pq9zytI(arg3, v1, arg2.density), arg6, arg7, ((float)arg8), arg9, arg5);
        return Unit.INSTANCE;
    }

    public int getLeadingMargin(boolean arg1) {
        int v0 = this.diff;
        if(v0 >= 0) {
            return 0;
        }

        return Math.abs(v0);
    }
}

