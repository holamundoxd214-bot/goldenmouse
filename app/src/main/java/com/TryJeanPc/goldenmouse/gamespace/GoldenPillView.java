package com.TryJeanPc.goldenmouse.gamespace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader$TileMode;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u000FH\u0014J\b\u0010\u0013\u001A\u00020\rH\u0014J\u0010\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u0016H\u0014R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenPillView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/RectF;", "onSizeChanged", "", "w", "", "h", "oldw", "oldh", "drawableStateChanged", "onDraw", "canvas", "Landroid/graphics/Canvas;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenPillView extends TextView {
    public static final int $stable = 8;
    private final Paint paint;
    private final RectF rect;

    static {
    }

    public GoldenPillView(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenPillView(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenPillView(Context arg2, AttributeSet arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super(arg2, arg3);
        this.paint = new Paint(1);
        this.rect = new RectF();
        this.setGravity(17);
        this.setClickable(false);
        this.setFocusable(false);
        this.setMaxLines(1);
        this.setHorizontallyScrolling(false);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int v0 = this.isSelected() ? -1 : 0xFFA6A198;
        this.setTextColor(v0);
    }

    protected void onDraw(Canvas arg12) {
        Intrinsics.checkNotNullParameter(arg12, "canvas");
        arg12.save();
        arg12.scale((((float)this.getWidth())) / 300f, (((float)this.getHeight())) / 72f);
        this.rect.set(2f, 2f, 298f, 70f);
        this.paint.setStyle(Paint$Style.FILL);
        Paint v0 = this.paint;
        int v2 = this.isSelected() ? 0xFF4A3820 : -15001323;
        int v6 = v2;
        v2 = this.isSelected() ? 0xFF272117 : 0xFF111214;
        v0.setShader(new LinearGradient(0f, 0f, 0f, 72f, v6, v2, Shader$TileMode.CLAMP));
        arg12.drawRoundRect(this.rect, 36f, 36f, this.paint);
        this.paint.setStyle(Paint$Style.STROKE);
        this.paint.setStrokeWidth(2.5f);
        this.paint.setShader(new LinearGradient(0f, 0f, 300f, 72f, new int[]{-2704515, 0xFFA08048, 0xFF75603B}, null, Shader$TileMode.CLAMP));
        arg12.drawRoundRect(this.rect, 36f, 36f, this.paint);
        arg12.restore();
        super.onDraw(arg12);
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        this.setTextSize(0, (((float)arg2)) * 30f / 72f);
    }
}

