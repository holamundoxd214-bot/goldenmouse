package androidx.compose.material3.internal;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A\u0014\u0010\f\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\r\u001A\u00020\u0006H\u0000\"\u001A\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u001A\u0010\u0005\u001A\u00020\u0006*\u0004\u0018\u00010\u00078@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t\"\u001A\u0010\n\u001A\u00020\u0006*\u0004\u0018\u00010\u00078@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\t¨\u0006\u000E"}, d2={"layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "widthOrZero", "", "Landroidx/compose/ui/layout/Placeable;", "getWidthOrZero", "(Landroidx/compose/ui/layout/Placeable;)I", "heightOrZero", "getHeightOrZero", "subtractConstraintSafely", "other", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutUtilKt {
    public static final int getHeightOrZero(Placeable arg0) {
        if(arg0 != null) {
            return arg0.getHeight();
        }

        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable arg2) {
        Object v2 = arg2.getParentData();
        Object v1 = null;
        if((v2 instanceof LayoutIdParentData)) {
        }
        else {
            v2 = v1;
        }

        if(v2 != null) {
            return ((LayoutIdParentData)v2).getLayoutId();
        }

        return v1;
    }

    public static final int getWidthOrZero(Placeable arg0) {
        if(arg0 != null) {
            return arg0.getWidth();
        }

        return 0;
    }

    public static final int subtractConstraintSafely(int arg1, int arg2) {
        if(arg1 == 0x7FFFFFFF) {
            return arg1;
        }

        return RangesKt.coerceAtLeast(arg1 - arg2, 0);
    }
}

