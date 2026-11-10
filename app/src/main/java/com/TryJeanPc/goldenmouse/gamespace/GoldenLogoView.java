package com.TryJeanPc.goldenmouse.gamespace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint$Align;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader$TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.TryJeanPc.goldenmouse.R$string;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0014R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001A\n \u000E*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenLogoView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "plate", "Landroid/graphics/Path;", "face", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenLogoView extends View {
    public static final int $stable = 8;
    private final Typeface face;
    private final Paint paint;
    private final Path plate;

    static {
    }

    public GoldenLogoView(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenLogoView(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenLogoView(Context arg4, AttributeSet arg5) {
        Intrinsics.checkNotNullParameter(arg4, "context");
        super(arg4, arg5);
        this.paint = new Paint(1);
        Path v4 = new Path();
        v4.moveTo(1f, 0f);
        v4.lineTo(929f, 0f);
        v4.lineTo(747f, 128f);
        v4.quadTo(735f, 137f, 715f, 137f);
        v4.lineTo(215f, 137f);
        v4.quadTo(195f, 137f, 183f, 128f);
        v4.close();
        this.plate = v4;
        this.face = Typeface.create("sans-serif-condensed", 3);
    }

    protected void onDraw(Canvas arg13) {
        Intrinsics.checkNotNullParameter(arg13, "canvas");
        super.onDraw(arg13);
        arg13.save();
        arg13.scale((((float)this.getWidth())) / 930f, (((float)this.getHeight())) / 138f);
        this.paint.setStyle(Paint$Style.FILL);
        this.paint.setShader(new LinearGradient(0f, 0f, 0f, 138f, new int[]{0xFF111214, 0xFF191919, -14081513}, null, Shader$TileMode.CLAMP));
        arg13.drawPath(this.plate, this.paint);
        this.paint.setStyle(Paint$Style.STROKE);
        this.paint.setStrokeWidth(3f);
        this.paint.setShader(new LinearGradient(0f, 0f, 930f, 138f, GoldenChromeViewsKt.edgeColors, null, Shader$TileMode.CLAMP));
        arg13.drawPath(this.plate, this.paint);
        this.paint.setTypeface(this.face);
        this.paint.setTextSize(72f);
        this.paint.setTextAlign(Paint$Align.CENTER);
        String v0 = this.getContext().getString(string.gspace_brand);
        Intrinsics.checkNotNullExpressionValue(v0, "getString(...)");
        arg13.translate(465f, 0f);
        arg13.scale(550f / this.paint.measureText(v0), 1f);
        this.paint.setShader(null);
        this.paint.setColor(0xFF08090A);
        this.paint.setStrokeWidth(9f);
        arg13.drawText(v0, 0f, 100f, this.paint);
        this.paint.setStrokeWidth(3f);
        this.paint.setColor(-7572407);
        arg13.drawText(v0, 0f, 98f, this.paint);
        this.paint.setStyle(Paint$Style.FILL);
        this.paint.setShader(new LinearGradient(0f, 43f, 0f, 102f, new int[]{-3109, 0xFFDDC99B, 0xFF736044, -3109, 0xFFB99B60}, new float[]{0f, 0.42f, 0.52f, 0.6f, 1f}, Shader$TileMode.CLAMP));
        arg13.drawText(v0, 0f, 98f, this.paint);
        arg13.restore();
    }
}

