package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Placeable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001AF\u0010\u0014\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00020\u00172\u001D\u0010\u0018\u001A\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001A2\u0006\u0010\u001B\u001A\u00020\u00152\u0006\u0010\u001C\u001A\u00020\u0015H\u0082\b\u001Ae\u0010\u001D\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00020\u00172\u001D\u0010\u0018\u001A\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001A2\u001D\u0010\u001E\u001A\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001A2\u0006\u0010\u001F\u001A\u00020\u00152\u0006\u0010\u001C\u001A\u00020\u0015H\u0082\b\"\u001A\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u001A\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0006\"\u001A\u0010\u0007\u001A\u00020\b*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\n\"\u001A\u0010\u000B\u001A\u00020\f*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E\"\u001C\u0010\u000F\u001A\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012\"\u001A\u0010\u0013\u001A\u00020\f*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000E¨\u0006 "}, d2={"rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getRowColumnParentData", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/ui/layout/Placeable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "weight", "", "getWeight", "(Landroidx/compose/foundation/layout/RowColumnParentData;)F", "fill", "", "getFill", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Z", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisAlignment", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "isRelative", "intrinsicMainAxisSize", "", "children", "", "mainAxisSize", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "crossAxisAvailable", "mainAxisSpacing", "intrinsicCrossAxisSize", "crossAxisSize", "mainAxisAvailable", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RowColumnImplKt {
    public static final CrossAxisAlignment getCrossAxisAlignment(RowColumnParentData arg0) {
        if(arg0 != null) {
            return arg0.getCrossAxisAlignment();
        }

        return null;
    }

    public static final boolean getFill(RowColumnParentData arg0) {
        if(arg0 != null) {
            return arg0.getFill();
        }

        return 1;
    }

    public static final RowColumnParentData getRowColumnParentData(Placeable arg1) {
        Object v1 = arg1.getParentData();
        if((v1 instanceof RowColumnParentData)) {
            return ((RowColumnParentData)v1);
        }

        return null;
    }

    public static final RowColumnParentData getRowColumnParentData(IntrinsicMeasurable arg1) {
        Object v1 = arg1.getParentData();
        if((v1 instanceof RowColumnParentData)) {
            return ((RowColumnParentData)v1);
        }

        return null;
    }

    public static final float getWeight(RowColumnParentData arg0) {
        if(arg0 != null) {
            return arg0.getWeight();
        }

        return 0;
    }

    private static final int intrinsicCrossAxisSize(List arg11, Function2 arg12, Function2 arg13, int arg14, int arg15) {
        int v12;
        int v7;
        int v1 = 0;
        if(arg11.isEmpty()) {
            return 0;
        }

        arg15 = Math.min((arg11.size() - 1) * arg15, arg14);
        List v0 = arg11;
        int v2 = ((Collection)v0).size();
        int v4 = 0;
        int v6 = 0;
        float v5 = 0f;
        while(true) {
            v7 = 0x7FFFFFFF;
            if(v4 >= v2) {
                break;
            }

            Object v8 = arg11.get(v4);
            float v9 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v8)));
            if(v9 == 0f) {
                int v9_1 = arg14 == v7 ? v7 : arg14 - arg15;
                v7 = Math.min(arg12.invoke(v8, Integer.valueOf(v7)).intValue(), v9_1);
                arg15 += v7;
                v6 = Math.max(v6, arg13.invoke(v8, Integer.valueOf(v7)).intValue());
            }
            else {
                if(v9 <= 0f) {
                    goto label_36;
                }

                v5 += v9;
            }

        label_36:
            ++v4;
        }

        if(v5 == 0f) {
            v12 = 0;
        }
        else if(arg14 == v7) {
            v12 = v7;
        }
        else {
            v12 = Math.round((((float)Math.max(arg14 - arg15, 0))) / v5);
        }

        arg14 = ((Collection)v0).size();
        while(v1 < arg14) {
            Object v15 = arg11.get(v1);
            float v0_1 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v15)));
            if(v0_1 > 0f) {
                int v0_2 = v12 != v7 ? Math.round((((float)v12)) * v0_1) : v7;
                v6 = Math.max(v6, arg13.invoke(v15, Integer.valueOf(v0_2)).intValue());
            }

            ++v1;
        }

        return v6;
    }

    private static final int intrinsicMainAxisSize(List arg9, Function2 arg10, int arg11, int arg12) {
        int v1 = 0;
        if(arg9.isEmpty()) {
            return 0;
        }

        int v0 = arg9.size();
        int v3 = 0;
        int v4 = 0;
        float v5 = 0f;
        while(v1 < v0) {
            Object v6 = arg9.get(v1);
            float v7 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v6)));
            int v6_1 = arg10.invoke(v6, Integer.valueOf(arg11)).intValue();
            if(v7 == 0f) {
                v4 += v6_1;
            }
            else if(v7 > 0f) {
                v5 += v7;
                v3 = Math.max(v3, Math.round((((float)v6_1)) / v7));
            }

            ++v1;
        }

        return Math.round((((float)v3)) * v5) + v4 + (arg9.size() - 1) * arg12;
    }

    public static final boolean isRelative(RowColumnParentData arg0) {
        CrossAxisAlignment v0 = RowColumnImplKt.getCrossAxisAlignment(arg0);
        if(v0 != null) {
            return v0.isRelative$foundation_layout();
        }

        return 0;
    }
}

