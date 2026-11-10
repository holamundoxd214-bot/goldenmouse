package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BP\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0004\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\b\u0010\"\u001A\u00020\u0002H\u0016J\u0010\u0010#\u001A\u00020\r2\u0006\u0010$\u001A\u00020\u0002H\u0016J\b\u0010%\u001A\u00020&H\u0016J\u0013\u0010\'\u001A\u00020\t2\b\u0010(\u001A\u0004\u0018\u00010)H\u0096\u0002J\f\u0010*\u001A\u00020\r*\u00020\fH\u0016R\u001C\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0015\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001C\u0010\u0005\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0015\u001A\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001C\u0010\u0006\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0015\u001A\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u001C\u0010\u0007\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0015\u001A\u0004\b\u001A\u0010\u0012\"\u0004\b\u001B\u0010\u0014R\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\"\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\u000E¢\u0006\b\n\u0000\u001A\u0004\b \u0010!¨\u0006+"}, d2={"Landroidx/compose/foundation/layout/PaddingElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/PaddingNode;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM", "()F", "setStart-0680j_4", "(F)V", "F", "getTop-D9Ej5fM", "setTop-0680j_4", "getEnd-D9Ej5fM", "setEnd-0680j_4", "getBottom-D9Ej5fM", "setBottom-0680j_4", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class PaddingElement extends ModifierNodeElement {
    private float bottom;
    private float end;
    private final Function1 inspectorInfo;
    private boolean rtlAware;
    private float start;
    private float top;

    private PaddingElement(float arg1, float arg2, float arg3, float arg4, boolean arg5, Function1 arg6) {
        super();
        this.start = arg1;
        this.top = arg2;
        this.end = arg3;
        this.bottom = arg4;
        this.rtlAware = arg5;
        this.inspectorInfo = arg6;
        int v4 = 0;
        int v1 = Float.compare(arg1, 0f) >= 0 || (Float.isNaN(arg1)) ? 1 : 0;
        arg3 = this.top;
        int v3 = arg3 >= 0f || (Float.isNaN(arg3)) ? 1 : 0;
        v1 &= v3;
        arg3 = this.end;
        v3 = arg3 >= 0f || (Float.isNaN(arg3)) ? 1 : 0;
        v1 &= v3;
        float v0 = this.bottom;
        if(v0 >= 0f || (Float.isNaN(v0))) {
            v4 = 1;
        }

        if((v1 & v4) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
    }

    public PaddingElement(float arg11, float arg12, float arg13, float arg14, boolean arg15, Function1 arg16, int arg17, DefaultConstructorMarker arg18) {
        if((arg17 & 1) != 0) {
            arg11 = Dp.constructor-impl(0f);
        }

        float v3 = arg11;
        if((arg17 & 2) != 0) {
            arg12 = Dp.constructor-impl(0f);
        }

        float v4 = arg12;
        if((arg17 & 4) != 0) {
            arg13 = Dp.constructor-impl(0f);
        }

        float v5 = arg13;
        if((arg17 & 8) != 0) {
            arg14 = Dp.constructor-impl(0f);
        }

        this(v3, v4, v5, arg14, arg15, arg16, null);
    }

    public PaddingElement(float arg1, float arg2, float arg3, float arg4, boolean arg5, Function1 arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public PaddingNode create() {
        return new PaddingNode(this.start, this.top, this.end, this.bottom, this.rtlAware, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if((arg4 instanceof PaddingElement)) {
        }
        else {
            PaddingElement v4 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if((Dp.equals-impl0(this.start, v4.start)) && (Dp.equals-impl0(this.top, v4.top)) && (Dp.equals-impl0(this.end, v4.end)) && (Dp.equals-impl0(this.bottom, v4.bottom)) && this.rtlAware == v4.rtlAware) {
            return 1;
        }

        return 0;
    }

    public final float getBottom-D9Ej5fM() {
        return this.bottom;
    }

    public final float getEnd-D9Ej5fM() {
        return this.end;
    }

    public final Function1 getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    public final float getStart-D9Ej5fM() {
        return this.start;
    }

    public final float getTop-D9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return (((Dp.hashCode-impl(this.start) * 0x1F + Dp.hashCode-impl(this.top)) * 0x1F + Dp.hashCode-impl(this.end)) * 0x1F + Dp.hashCode-impl(this.bottom)) * 0x1F + Boolean.hashCode(this.rtlAware);
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public final void setBottom-0680j_4(float arg1) {
        this.bottom = arg1;
    }

    public final void setEnd-0680j_4(float arg1) {
        this.end = arg1;
    }

    public final void setRtlAware(boolean arg1) {
        this.rtlAware = arg1;
    }

    public final void setStart-0680j_4(float arg1) {
        this.start = arg1;
    }

    public final void setTop-0680j_4(float arg1) {
        this.top = arg1;
    }

    public void update(PaddingNode arg2) {
        arg2.setStart-0680j_4(this.start);
        arg2.setTop-0680j_4(this.top);
        arg2.setEnd-0680j_4(this.end);
        arg2.setBottom-0680j_4(this.bottom);
        arg2.setRtlAware(this.rtlAware);
    }

    public void update(Node arg1) {
        this.update(((PaddingNode)arg1));
    }
}

