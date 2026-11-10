package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect$Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(d1={"\u0000l\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010\u0005\u001A\u00020\u0006*\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\b\u0010\t\"\u0015\u0010\u0005\u001A\u00020\n*\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\b\u0010\f\"\u0015\u0010\u0005\u001A\u00020\r*\u00020\u000E8F¢\u0006\u0006\u001A\u0004\b\b\u0010\u000F\"\u0015\u0010\u0005\u001A\u00020\u0010*\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\b\u0010\u0012\"\u0015\u0010\u0005\u001A\u00020\u0013*\u00020\u00148F¢\u0006\u0006\u001A\u0004\b\b\u0010\u0015\"\u0015\u0010\u0005\u001A\u00020\u0016*\u00020\u00178F¢\u0006\u0006\u001A\u0004\b\b\u0010\u0018\"\u0015\u0010\u0005\u001A\u00020\u0019*\u00020\u001A8F¢\u0006\u0006\u001A\u0004\b\b\u0010\u001B\"\u0015\u0010\u0005\u001A\u00020\u0004*\u00020\u001C8F¢\u0006\u0006\u001A\u0004\b\b\u0010\u001D\".\u0010\u001E\u001A\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 \u0012\u0004\u0012\u00020\u00010\u001FX\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b!\u0010\"\u001A\u0004\b#\u0010$¨\u0006%"}, d2={"DpVisibilityThreshold", "", "PxVisibilityThreshold", "RectVisibilityThreshold", "Landroidx/compose/ui/geometry/Rect;", "VisibilityThreshold", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/IntOffset$Companion;", "getVisibilityThreshold", "(Landroidx/compose/ui/unit/IntOffset$Companion;)J", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Offset$Companion;", "(Landroidx/compose/ui/geometry/Offset$Companion;)J", "", "Lkotlin/Int$Companion;", "(Lkotlin/jvm/internal/IntCompanionObject;)I", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/Dp$Companion;", "(Landroidx/compose/ui/unit/Dp$Companion;)F", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/ui/unit/DpOffset$Companion;", "(Landroidx/compose/ui/unit/DpOffset$Companion;)J", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/geometry/Size$Companion;", "(Landroidx/compose/ui/geometry/Size$Companion;)J", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/IntSize$Companion;", "(Landroidx/compose/ui/unit/IntSize$Companion;)J", "Landroidx/compose/ui/geometry/Rect$Companion;", "(Landroidx/compose/ui/geometry/Rect$Companion;)Landroidx/compose/ui/geometry/Rect;", "VisibilityThresholdMap", "", "Landroidx/compose/animation/core/TwoWayConverter;", "getVisibilityThresholdMap$annotations", "()V", "getVisibilityThresholdMap", "()Ljava/util/Map;", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class VisibilityThresholdsKt {
    private static final float DpVisibilityThreshold = 0.4f;
    private static final float PxVisibilityThreshold = 1f;
    private static final Rect RectVisibilityThreshold;
    private static final Map VisibilityThresholdMap;

    static {
        Float v2 = Float.valueOf(1f);
        VisibilityThresholdsKt.RectVisibilityThreshold = new Rect(1f, 1f, 1f, 1f);
        Pair[] v0 = new Pair[9];
        v0[0] = TuplesKt.to(VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), v2);
        v0[1] = TuplesKt.to(VectorConvertersKt.getVectorConverter(IntSize.Companion), v2);
        v0[2] = TuplesKt.to(VectorConvertersKt.getVectorConverter(IntOffset.Companion), v2);
        v0[3] = TuplesKt.to(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(0.01f));
        v0[4] = TuplesKt.to(VectorConvertersKt.getVectorConverter(Rect.Companion), v2);
        v0[5] = TuplesKt.to(VectorConvertersKt.getVectorConverter(Size.Companion), v2);
        v0[6] = TuplesKt.to(VectorConvertersKt.getVectorConverter(Offset.Companion), v2);
        TwoWayConverter v1 = VectorConvertersKt.getVectorConverter(Dp.Companion);
        v2 = Float.valueOf(0.4f);
        v0[7] = TuplesKt.to(v1, v2);
        v0[8] = TuplesKt.to(VectorConvertersKt.getVectorConverter(DpOffset.Companion), v2);
        VisibilityThresholdsKt.VisibilityThresholdMap = MapsKt.mapOf(v0);
    }

    public static final Rect getVisibilityThreshold(Companion arg0) {
        return VisibilityThresholdsKt.RectVisibilityThreshold;
    }

    public static final long getVisibilityThreshold(androidx.compose.ui.unit.IntOffset$Companion arg2) {
        return IntOffset.constructor-impl(0x100000001L);
    }

    public static final long getVisibilityThreshold(androidx.compose.ui.unit.IntSize$Companion arg2) {
        return IntSize.constructor-impl(0x100000001L);
    }

    public static final float getVisibilityThreshold(androidx.compose.ui.unit.Dp$Companion arg0) {
        return Dp.constructor-impl(0.4f);
    }

    public static final long getVisibilityThreshold(androidx.compose.ui.geometry.Size$Companion arg6) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(1f))) << 0x20 | (((long)Float.floatToRawIntBits(1f))) & 0xFFFFFFFFL);
    }

    public static final long getVisibilityThreshold(androidx.compose.ui.geometry.Offset$Companion arg6) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(1f))) << 0x20 | (((long)Float.floatToRawIntBits(1f))) & 0xFFFFFFFFL);
    }

    public static final int getVisibilityThreshold(IntCompanionObject arg0) {
        return 1;
    }

    public static final long getVisibilityThreshold(androidx.compose.ui.unit.DpOffset$Companion arg7) {
        return DpOffset.constructor-impl((((long)Float.floatToRawIntBits(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)))) << 0x20 | (((long)Float.floatToRawIntBits(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)))) & 0xFFFFFFFFL);
    }

    public static final Map getVisibilityThresholdMap() {
        return VisibilityThresholdsKt.VisibilityThresholdMap;
    }

    public static void getVisibilityThresholdMap$annotations() {
    }
}

