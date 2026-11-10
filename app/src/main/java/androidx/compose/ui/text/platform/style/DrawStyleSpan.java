package androidx.compose.ui.text.platform.style;

import android.graphics.Paint$Style;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\r"}, d2={"Landroidx/compose/ui/text/platform/style/DrawStyleSpan;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "<init>", "(Landroidx/compose/ui/graphics/drawscope/DrawStyle;)V", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DrawStyleSpan extends CharacterStyle implements UpdateAppearance {
    public static final int $stable = 8;
    private final DrawStyle drawStyle;

    static {
    }

    public DrawStyleSpan(DrawStyle arg1) {
        super();
        this.drawStyle = arg1;
    }

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    public void updateDrawState(TextPaint arg3) {
        if(arg3 != null) {
            DrawStyle v0 = this.drawStyle;
            if(Intrinsics.areEqual(v0, Fill.INSTANCE)) {
                arg3.setStyle(Paint$Style.FILL);
                return;
            }

            if((v0 instanceof Stroke)) {
                arg3.setStyle(Paint$Style.STROKE);
                arg3.setStrokeWidth(this.drawStyle.getWidth());
                arg3.setStrokeMiter(this.drawStyle.getMiter());
                arg3.setStrokeJoin(DrawStyleSpan_androidKt.toAndroidJoin-Ww9F2mQ(this.drawStyle.getJoin-LxFBmk8()));
                arg3.setStrokeCap(DrawStyleSpan_androidKt.toAndroidCap-BeK7IIE(this.drawStyle.getCap-KaPHkGw()));
                PathEffect v2 = this.drawStyle.getPathEffect();
                android.graphics.PathEffect v2_1 = v2 != null ? AndroidPathEffect_androidKt.asAndroidPathEffect(v2) : null;
                arg3.setPathEffect(v2_1);
                return;
            }

            throw new NoWhenBranchMatchedException();
        }
    }
}

