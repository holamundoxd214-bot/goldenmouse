package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BP\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0004\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\b\u0010\u0012\u001A\u00020\u0002H\u0016J\u0010\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\u0002H\u0016J\f\u0010\u0015\u001A\u00020\r*\u00020\fH\u0016J\u0013\u0010\u0016\u001A\u00020\t2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016R\u0010\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0005\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0006\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0007\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001F\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\u000EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/layout/SizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/SizeNode;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "create", "update", "node", "inspectableProperties", "equals", "other", "", "hashCode", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class SizeElement extends ModifierNodeElement {
    private final boolean enforceIncoming;
    private final Function1 inspectorInfo;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    private SizeElement(float arg1, float arg2, float arg3, float arg4, boolean arg5, Function1 arg6) {
        super();
        this.minWidth = arg1;
        this.minHeight = arg2;
        this.maxWidth = arg3;
        this.maxHeight = arg4;
        this.enforceIncoming = arg5;
        this.inspectorInfo = arg6;
    }

    public SizeElement(float arg9, float arg10, float arg11, float arg12, boolean arg13, Function1 arg14, int arg15, DefaultConstructorMarker arg16) {
        if((arg15 & 1) != 0) {
            arg9 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        float v1 = arg9;
        if((arg15 & 2) != 0) {
            arg10 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        float v2 = arg10;
        if((arg15 & 4) != 0) {
            arg11 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        float v3 = arg11;
        if((arg15 & 8) != 0) {
            arg12 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        this(v1, v2, v3, arg12, arg13, arg14, null);
    }

    public SizeElement(float arg1, float arg2, float arg3, float arg4, boolean arg5, Function1 arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public SizeNode create() {
        return new SizeNode(this.minWidth, this.minHeight, this.maxWidth, this.maxHeight, this.enforceIncoming, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((SizeElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SizeElement)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.minWidth, ((SizeElement)arg5).minWidth)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.minHeight, ((SizeElement)arg5).minHeight)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.maxWidth, ((SizeElement)arg5).maxWidth)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.maxHeight, ((SizeElement)arg5).maxHeight)) {
            return 0;
        }

        if(this.enforceIncoming != ((SizeElement)arg5).enforceIncoming) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return (((Dp.hashCode-impl(this.minWidth) * 0x1F + Dp.hashCode-impl(this.minHeight)) * 0x1F + Dp.hashCode-impl(this.maxWidth)) * 0x1F + Dp.hashCode-impl(this.maxHeight)) * 0x1F + Boolean.hashCode(this.enforceIncoming);
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(SizeNode arg2) {
        arg2.setMinWidth-0680j_4(this.minWidth);
        arg2.setMinHeight-0680j_4(this.minHeight);
        arg2.setMaxWidth-0680j_4(this.maxWidth);
        arg2.setMaxHeight-0680j_4(this.maxHeight);
        arg2.setEnforceIncoming(this.enforceIncoming);
    }

    public void update(Node arg1) {
        this.update(((SizeNode)arg1));
    }
}

