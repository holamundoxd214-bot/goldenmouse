package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000F\u001A\u00020\u0002H\u0016J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0002H\u0016J\f\u0010\u0013\u001A\u00020\u0011*\u00020\u0014H\u0016J\t\u0010\u0015\u001A\u00020\u0004HÂ\u0003J\t\u0010\u0016\u001A\u00020\u0006HÂ\u0003J\u0010\u0010\u0017\u001A\u00020\bHÂ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u000B0\nHÂ\u0003J>\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nHÆ\u0001¢\u0006\u0004\b\u001C\u0010\u001DJ\u0013\u0010\u001E\u001A\u00020\u00062\b\u0010\u001F\u001A\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001A\u00020\"HÖ\u0001J\t\u0010#\u001A\u00020$HÖ\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000ER\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Landroidx/compose/material3/ClockDialModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/ClockDialNode;", "state", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material3/AnalogTimePickerState;ZILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component3-yecRtBI", "()I", "component4", "copy", "copy-JwYzU44", "(Landroidx/compose/material3/AnalogTimePickerState;ZILandroidx/compose/animation/core/AnimationSpec;)Landroidx/compose/material3/ClockDialModifier;", "equals", "other", "", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ClockDialModifier extends ModifierNodeElement {
    public static final int $stable;
    private final AnimationSpec animationSpec;
    private final boolean autoSwitchToMinute;
    private final int selection;
    private final AnalogTimePickerState state;

    static {
    }

    private ClockDialModifier(AnalogTimePickerState arg1, boolean arg2, int arg3, AnimationSpec arg4) {
        super();
        this.state = arg1;
        this.autoSwitchToMinute = arg2;
        this.selection = arg3;
        this.animationSpec = arg4;
    }

    public ClockDialModifier(AnalogTimePickerState arg1, boolean arg2, int arg3, AnimationSpec arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    private final AnalogTimePickerState component1() {
        return this.state;
    }

    private final boolean component2() {
        return this.autoSwitchToMinute;
    }

    private final int component3-yecRtBI() {
        return this.selection;
    }

    private final AnimationSpec component4() {
        return this.animationSpec;
    }

    public final ClockDialModifier copy-JwYzU44(AnalogTimePickerState arg7, boolean arg8, int arg9, AnimationSpec arg10) {
        return new ClockDialModifier(arg7, arg8, arg9, arg10, null);
    }

    public static ClockDialModifier copy-JwYzU44$default(ClockDialModifier arg0, AnalogTimePickerState arg1, boolean arg2, int arg3, AnimationSpec arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.state;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.autoSwitchToMinute;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.selection;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.animationSpec;
        }

        return arg0.copy-JwYzU44(arg1, arg2, arg3, arg4);
    }

    public ClockDialNode create() {
        return new ClockDialNode(this.state, this.autoSwitchToMinute, this.selection, this.animationSpec, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((ClockDialModifier)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ClockDialModifier)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((ClockDialModifier)arg5).state)) {
            return 0;
        }

        if(this.autoSwitchToMinute != ((ClockDialModifier)arg5).autoSwitchToMinute) {
            return 0;
        }

        if(!TimePickerSelectionMode.equals-impl0(this.selection, ((ClockDialModifier)arg5).selection)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.animationSpec, ((ClockDialModifier)arg5).animationSpec)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return ((this.state.hashCode() * 0x1F + Boolean.hashCode(this.autoSwitchToMinute)) * 0x1F + TimePickerSelectionMode.hashCode-impl(this.selection)) * 0x1F + this.animationSpec.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public String toString() {
        return "ClockDialModifier(state=" + this.state + ", autoSwitchToMinute=" + this.autoSwitchToMinute + ", selection=" + TimePickerSelectionMode.toString-impl(this.selection) + ", animationSpec=" + this.animationSpec + ')';
    }

    public void update(ClockDialNode arg4) {
        arg4.updateNode-JwYzU44(this.state, this.autoSwitchToMinute, this.selection, this.animationSpec);
    }

    public void update(Node arg1) {
        this.update(((ClockDialNode)arg1));
    }
}

