package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001CBA\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0018\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\b\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001A\u00020\u0002H\u0016J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0002H\u0016J\f\u0010\u0016\u001A\u00020\u0014*\u00020\u0017H\u0016J\u0013\u0010\u0018\u001A\u00020\u00062\b\u0010\u0019\u001A\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/layout/WrapContentElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/WrapContentNode;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "align", "", "inspectorName", "", "<init>", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;Ljava/lang/Object;Ljava/lang/String;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "hashCode", "", "Companion", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class WrapContentElement extends ModifierNodeElement {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007J\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\tH\u0007J\u0018\u0010\f\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\tH\u0007¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/layout/WrapContentElement$Companion;", "", "<init>", "()V", "width", "Landroidx/compose/foundation/layout/WrapContentElement;", "align", "Landroidx/compose/ui/Alignment$Horizontal;", "unbounded", "", "height", "Landroidx/compose/ui/Alignment$Vertical;", "size", "Landroidx/compose/ui/Alignment;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final WrapContentElement height(Vertical arg7, boolean arg8) {
            return new WrapContentElement(Direction.Vertical, arg8, new WrapContentElement$Companion$$ExternalSyntheticLambda1(arg7), arg7, "wrapContentHeight");
        }

        static final IntOffset height$lambda$0(Vertical arg2, IntSize arg3, LayoutDirection arg4) {
            return IntOffset.box-impl(IntOffset.constructor-impl((((long)arg2.align(0, ((int)(arg3.unbox-impl() & 0xFFFFFFFFL))))) & 0xFFFFFFFFL));
        }

        public final WrapContentElement size(Alignment arg7, boolean arg8) {
            return new WrapContentElement(Direction.Both, arg8, new WrapContentElement$Companion$$ExternalSyntheticLambda2(arg7), arg7, "wrapContentSize");
        }

        static final IntOffset size$lambda$0(Alignment arg7, IntSize arg8, LayoutDirection arg9) {
            return IntOffset.box-impl(arg7.align-KFBX0sM(IntSize.Companion.getZero-YbymL2g(), arg8.unbox-impl(), arg9));
        }

        public final WrapContentElement width(Horizontal arg7, boolean arg8) {
            return new WrapContentElement(Direction.Horizontal, arg8, new WrapContentElement$Companion$$ExternalSyntheticLambda0(arg7), arg7, "wrapContentWidth");
        }

        static final IntOffset width$lambda$0(Horizontal arg2, IntSize arg3, LayoutDirection arg4) {
            return IntOffset.box-impl(IntOffset.constructor-impl((((long)arg2.align(0, ((int)(arg3.unbox-impl() >> 0x20)), arg4))) << 0x20));
        }
    }

    public static final Companion Companion;
    private final Object align;
    private final Function2 alignmentCallback;
    private final Direction direction;
    private final String inspectorName;
    private final boolean unbounded;

    static {
        WrapContentElement.Companion = new Companion(null);
    }

    public WrapContentElement(Direction arg1, boolean arg2, Function2 arg3, Object arg4, String arg5) {
        super();
        this.direction = arg1;
        this.unbounded = arg2;
        this.alignmentCallback = arg3;
        this.align = arg4;
        this.inspectorName = arg5;
    }

    public WrapContentNode create() {
        return new WrapContentNode(this.direction, this.unbounded, this.alignmentCallback);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((WrapContentElement)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(this.getClass() != arg5.getClass()) {
            return 0;
        }

        if(this.direction != ((WrapContentElement)arg5).direction) {
            return 0;
        }

        if(this.unbounded != ((WrapContentElement)arg5).unbounded) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.align, ((WrapContentElement)arg5).align)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return (this.direction.hashCode() * 0x1F + Boolean.hashCode(this.unbounded)) * 0x1F + this.align.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName(this.inspectorName);
        arg4.getProperties().set("align", this.align);
        arg4.getProperties().set("unbounded", Boolean.valueOf(this.unbounded));
    }

    public void update(WrapContentNode arg2) {
        arg2.setDirection(this.direction);
        arg2.setUnbounded(this.unbounded);
        arg2.setAlignmentCallback(this.alignmentCallback);
    }

    public void update(Node arg1) {
        this.update(((WrapContentNode)arg1));
    }
}

