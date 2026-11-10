package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0005HÆ\u0003J\u000B\u0010\u001E\u001A\u0004\u0018\u00010\u0007HÆ\u0003J\u000B\u0010\u001F\u001A\u0004\u0018\u00010\tHÆ\u0003J5\u0010 \u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010!\u001A\u00020\u00052\b\u0010\"\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001A\u00020$HÖ\u0001J\t\u0010%\u001A\u00020&HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001C\u0010\b\u001A\u0004\u0018\u00010\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006\'"}, d2={"Landroidx/compose/foundation/layout/RowColumnParentData;", "", "weight", "", "fill", "", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "flowLayoutData", "Landroidx/compose/foundation/layout/FlowLayoutData;", "<init>", "(FZLandroidx/compose/foundation/layout/CrossAxisAlignment;Landroidx/compose/foundation/layout/FlowLayoutData;)V", "getWeight", "()F", "setWeight", "(F)V", "getFill", "()Z", "setFill", "(Z)V", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "setCrossAxisAlignment", "(Landroidx/compose/foundation/layout/CrossAxisAlignment;)V", "getFlowLayoutData", "()Landroidx/compose/foundation/layout/FlowLayoutData;", "setFlowLayoutData", "(Landroidx/compose/foundation/layout/FlowLayoutData;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RowColumnParentData {
    public static final int $stable = 8;
    private CrossAxisAlignment crossAxisAlignment;
    private boolean fill;
    private FlowLayoutData flowLayoutData;
    private float weight;

    static {
    }

    public RowColumnParentData(float arg2, boolean arg3, CrossAxisAlignment arg4, FlowLayoutData arg5, int arg6, DefaultConstructorMarker arg7) {
        CrossAxisAlignment v0 = null;
        if((arg6 & 4) != 0) {
            arg4 = v0;
        }

        if((arg6 & 8) != 0) {
            arg5 = ((FlowLayoutData)v0);
        }

        this(0f, true, arg4, arg5);
    }

    public RowColumnParentData() {
        this(0f, false, null, null, 15, null);
    }

    public RowColumnParentData(float arg1, boolean arg2, CrossAxisAlignment arg3, FlowLayoutData arg4) {
        super();
        this.weight = arg1;
        this.fill = arg2;
        this.crossAxisAlignment = arg3;
        this.flowLayoutData = arg4;
    }

    public final float component1() {
        return this.weight;
    }

    public final boolean component2() {
        return this.fill;
    }

    public final CrossAxisAlignment component3() {
        return this.crossAxisAlignment;
    }

    public final FlowLayoutData component4() {
        return this.flowLayoutData;
    }

    public final RowColumnParentData copy(float arg1, boolean arg2, CrossAxisAlignment arg3, FlowLayoutData arg4) {
        return new RowColumnParentData(arg1, arg2, arg3, arg4);
    }

    public static RowColumnParentData copy$default(RowColumnParentData arg0, float arg1, boolean arg2, CrossAxisAlignment arg3, FlowLayoutData arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.weight;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.fill;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.crossAxisAlignment;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.flowLayoutData;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((RowColumnParentData)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RowColumnParentData)) {
            return 0;
        }

        if(Float.compare(this.weight, ((RowColumnParentData)arg5).weight) != 0) {
            return 0;
        }

        if(this.fill != ((RowColumnParentData)arg5).fill) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.crossAxisAlignment, ((RowColumnParentData)arg5).crossAxisAlignment)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.flowLayoutData, ((RowColumnParentData)arg5).flowLayoutData)) {
            return 0;
        }

        return 1;
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final FlowLayoutData getFlowLayoutData() {
        return this.flowLayoutData;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int v0 = (Float.hashCode(this.weight) * 0x1F + Boolean.hashCode(this.fill)) * 0x1F;
        CrossAxisAlignment v1 = this.crossAxisAlignment;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        FlowLayoutData v3 = this.flowLayoutData;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public final void setCrossAxisAlignment(CrossAxisAlignment arg1) {
        this.crossAxisAlignment = arg1;
    }

    public final void setFill(boolean arg1) {
        this.fill = arg1;
    }

    public final void setFlowLayoutData(FlowLayoutData arg1) {
        this.flowLayoutData = arg1;
    }

    public final void setWeight(float arg1) {
        this.weight = arg1;
    }

    public String toString() {
        return "RowColumnParentData(weight=" + this.weight + ", fill=" + this.fill + ", crossAxisAlignment=" + this.crossAxisAlignment + ", flowLayoutData=" + this.flowLayoutData + ')';
    }
}

