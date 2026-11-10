package androidx.compose.ui.text.platform.style;

import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u0013\u0010\u0005\u001A\u00020\u0006*\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2={"toAndroidJoin", "Landroid/graphics/Paint$Join;", "Landroidx/compose/ui/graphics/StrokeJoin;", "toAndroidJoin-Ww9F2mQ", "(I)Landroid/graphics/Paint$Join;", "toAndroidCap", "Landroid/graphics/Paint$Cap;", "Landroidx/compose/ui/graphics/StrokeCap;", "toAndroidCap-BeK7IIE", "(I)Landroid/graphics/Paint$Cap;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DrawStyleSpan_androidKt {
    public static final Paint$Cap toAndroidCap-BeK7IIE(int arg1) {
        if(StrokeCap.equals-impl0(arg1, StrokeCap.Companion.getButt-KaPHkGw())) {
            return Paint$Cap.BUTT;
        }

        if(StrokeCap.equals-impl0(arg1, StrokeCap.Companion.getRound-KaPHkGw())) {
            return Paint$Cap.ROUND;
        }

        if(StrokeCap.equals-impl0(arg1, StrokeCap.Companion.getSquare-KaPHkGw())) {
            return Paint$Cap.SQUARE;
        }

        return Paint$Cap.BUTT;
    }

    public static final Paint$Join toAndroidJoin-Ww9F2mQ(int arg1) {
        if(StrokeJoin.equals-impl0(arg1, StrokeJoin.Companion.getMiter-LxFBmk8())) {
            return Paint$Join.MITER;
        }

        if(StrokeJoin.equals-impl0(arg1, StrokeJoin.Companion.getRound-LxFBmk8())) {
            return Paint$Join.ROUND;
        }

        if(StrokeJoin.equals-impl0(arg1, StrokeJoin.Companion.getBevel-LxFBmk8())) {
            return Paint$Join.BEVEL;
        }

        return Paint$Join.MITER;
    }
}

