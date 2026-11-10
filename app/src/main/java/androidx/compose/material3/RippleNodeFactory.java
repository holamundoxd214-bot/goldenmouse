package androidx.compose.material3;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B+\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BB!\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\n\u0010\fB!\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\rJ\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\u0013\u0010\u0014\u001A\u00020\u00032\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001A\u00020\u0018H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000ER\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000F¨\u0006\u0019"}, d2={"Landroidx/compose/material3/RippleNodeFactory;", "Landroidx/compose/foundation/IndicationNodeFactory;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "colorProducer", "Landroidx/compose/ui/graphics/ColorProducer;", "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(ZFLandroidx/compose/ui/graphics/ColorProducer;J)V", "(ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "J", "create", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "equals", "other", "", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class RippleNodeFactory implements IndicationNodeFactory {
    private final boolean bounded;
    private final long color;
    private final ColorProducer colorProducer;
    private final float radius;

    public RippleNodeFactory(boolean arg1, float arg2, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3);
    }

    public RippleNodeFactory(boolean arg1, float arg2, ColorProducer arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    private RippleNodeFactory(boolean arg7, float arg8, long arg9) {
        this(arg7, arg8, null, arg9);
    }

    private RippleNodeFactory(boolean arg1, float arg2, ColorProducer arg3, long arg4) {
        super();
        this.bounded = arg1;
        this.radius = arg2;
        this.colorProducer = arg3;
        this.color = arg4;
    }

    private RippleNodeFactory(boolean arg8, float arg9, ColorProducer arg10) {
        this(arg8, arg9, arg10, Color.Companion.getUnspecified-0d7_KjU());
    }

    public static final long access$getColor$p(RippleNodeFactory arg2) {
        return arg2.color;
    }

    public DelegatableNode create(InteractionSource arg8) {
        ColorProducer v0 = this.colorProducer;
        if(v0 == null) {
            RippleNodeFactory$create$colorProducer$1 v0_1 = new RippleNodeFactory$create$colorProducer$1(this);
        }

        return new DelegatingThemeAwareRippleNode(arg8, this.bounded, this.radius, v0, null);
    }

    public boolean equals(Object arg4) {
        if(this == (((RippleNodeFactory)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof RippleNodeFactory)) {
            return 0;
        }

        if(this.bounded != ((RippleNodeFactory)arg4).bounded) {
            return 0;
        }

        if(!Dp.equals-impl0(this.radius, ((RippleNodeFactory)arg4).radius)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.colorProducer, ((RippleNodeFactory)arg4).colorProducer)) {
            return 0;
        }

        return Color.equals-impl0(this.color, ((RippleNodeFactory)arg4).color);
    }

    public int hashCode() {
        int v0 = (Boolean.hashCode(this.bounded) * 0x1F + Dp.hashCode-impl(this.radius)) * 0x1F;
        ColorProducer v1 = this.colorProducer;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return (v0 + v1_1) * 0x1F + Color.hashCode-impl(this.color);
    }
}

