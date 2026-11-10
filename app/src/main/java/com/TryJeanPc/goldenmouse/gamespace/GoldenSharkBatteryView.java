package com.TryJeanPc.goldenmouse.gamespace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.TryJeanPc.goldenmouse.R$color;
import com.TryJeanPc.goldenmouse.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\fJ\u0010\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0012H\u0014R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenSharkBatteryView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "outline", "Landroid/graphics/drawable/Drawable;", "progress", "percent", "", "setPercent", "", "value", "onDraw", "canvas", "Landroid/graphics/Canvas;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenSharkBatteryView extends View {
    public static final int $stable = 8;
    private final Drawable outline;
    private int percent;
    private final Drawable progress;

    static {
    }

    public GoldenSharkBatteryView(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenSharkBatteryView(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenSharkBatteryView(Context arg2, AttributeSet arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super(arg2, arg3);
        Drawable v3 = arg2.getDrawable(drawable.gspace_shark_battery_outline);
        String v0 = "Required value was null.";
        if(v3 != null) {
            this.outline = v3;
            v3 = arg2.getDrawable(drawable.gspace_shark_battery_progress);
            if(v3 != null) {
                v3 = v3.mutate();
                v3.setTint(arg2.getColor(color.gspace_shark_battery_fill));
                Intrinsics.checkNotNullExpressionValue(v3, "apply(...)");
                this.progress = v3;
                return;
            }

            throw new IllegalArgumentException(v0.toString());
        }

        throw new IllegalArgumentException(v0.toString());
    }

    protected void onDraw(Canvas arg7) {
        Intrinsics.checkNotNullParameter(arg7, "canvas");
        super.onDraw(arg7);
        arg7.save();
        arg7.scale((((float)this.getWidth())) / 76f, (((float)this.getHeight())) / 30f);
        this.outline.setBounds(0, 0, 76, 30);
        this.progress.setBounds(0, 0, 76, 30);
        arg7.save();
        arg7.clipRect(69f - (((float)this.percent)) * 59f / 100f, 0f, 76f, 30f);
        if(this.percent > 0) {
            this.progress.draw(arg7);
        }

        arg7.restore();
        this.outline.draw(arg7);
        arg7.restore();
    }

    public final void setPercent(int arg2) {
        if(this.percent == arg2) {
            return;
        }

        this.percent = arg2;
        this.invalidate();
    }
}

