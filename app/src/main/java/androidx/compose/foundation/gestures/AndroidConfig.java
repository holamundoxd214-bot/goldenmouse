package androidx.compose.foundation.gestures;

import android.os.Build$VERSION;
import android.view.ViewConfiguration;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001A\u00020\t*\u00020\nH\u0001¢\u0006\u0002\b\u000BJ\u0011\u0010\f\u001A\u00020\t*\u00020\nH\u0001¢\u0006\u0002\b\rJ#\u0010\u000E\u001A\u00020\u000F*\u00020\n2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/gestures/AndroidConfig;", "Landroidx/compose/foundation/gestures/ScrollConfig;", "viewConfiguration", "Landroid/view/ViewConfiguration;", "<init>", "(Landroid/view/ViewConfiguration;)V", "getViewConfiguration", "()Landroid/view/ViewConfiguration;", "getVerticalScrollFactor", "", "Landroidx/compose/ui/unit/Density;", "getVerticalScrollFactor$foundation", "getHorizontalScrollFactor", "getHorizontalScrollFactor$foundation", "calculateMouseWheelScroll", "Landroidx/compose/ui/geometry/Offset;", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "calculateMouseWheelScroll-8xgXZGE", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/input/pointer/PointerEvent;J)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidConfig implements ScrollConfig {
    public static final int $stable = 8;
    private final ViewConfiguration viewConfiguration;

    static {
    }

    public AndroidConfig(ViewConfiguration arg1) {
        super();
        this.viewConfiguration = arg1;
    }

    public long calculateMouseWheelScroll-8xgXZGE(Density arg7, PointerEvent arg8, long arg9) {
        float v9 = -this.getVerticalScrollFactor$foundation(arg7);
        float v6 = -this.getHorizontalScrollFactor$foundation(arg7);
        List v7 = arg8.getChanges();
        Offset v8 = Offset.box-impl(Offset.Companion.getZero-F1C5BW0());
        int v10 = v7.size();
        int v0;
        for(v0 = 0; v0 < v10; ++v0) {
            v8 = Offset.box-impl(Offset.plus-MK-Hz9U(v8.unbox-impl(), v7.get(v0).getScrollDelta-F1C5BW0()));
        }

        long v7_1 = v8.unbox-impl();
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v7_1 >> 0x20))) * v6))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v7_1 & 0xFFFFFFFFL))) * v9))) & 0xFFFFFFFFL);
    }

    public final float getHorizontalScrollFactor$foundation(Density arg3) {
        if(Build$VERSION.SDK_INT > 26) {
            return ViewConfigurationApi26Impl.INSTANCE.getHorizontalScrollFactor(this.viewConfiguration);
        }

        return arg3.toPx-0680j_4(Dp.constructor-impl(64f));
    }

    public final float getVerticalScrollFactor$foundation(Density arg3) {
        if(Build$VERSION.SDK_INT > 26) {
            return ViewConfigurationApi26Impl.INSTANCE.getVerticalScrollFactor(this.viewConfiguration);
        }

        return arg3.toPx-0680j_4(Dp.constructor-impl(64f));
    }

    public final ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }
}

