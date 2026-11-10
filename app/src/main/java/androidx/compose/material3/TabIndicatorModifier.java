package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0012\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000E\u0010\u000FJ\b\u0010\u0018\u001A\u00020\u0002H\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0002H\u0016J\f\u0010\u001C\u001A\u00020\u001A*\u00020\u001DH\u0016J\u0015\u0010\u001E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004HÆ\u0003J\t\u0010\u001F\u001A\u00020\bHÆ\u0003J\t\u0010 \u001A\u00020\nHÆ\u0003J\u000F\u0010!\u001A\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003JC\u0010\"\u001A\u00020\u00002\u0014\b\u0002\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\u000E\b\u0002\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010#\u001A\u00020\n2\b\u0010$\u001A\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001A\u00020\bHÖ\u0001J\t\u0010\'\u001A\u00020(HÖ\u0001R\u001D\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2={"Landroidx/compose/material3/TabIndicatorModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/TabIndicatorOffsetNode;", "tabPositionsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/material3/TabPosition;", "selectedTabIndex", "", "followContentSize", "", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Landroidx/compose/runtime/State;IZLandroidx/compose/animation/core/FiniteAnimationSpec;)V", "getTabPositionsState", "()Landroidx/compose/runtime/State;", "getSelectedTabIndex", "()I", "getFollowContentSize", "()Z", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TabIndicatorModifier extends ModifierNodeElement {
    public static final int $stable;
    private final FiniteAnimationSpec animationSpec;
    private final boolean followContentSize;
    private final int selectedTabIndex;
    private final State tabPositionsState;

    static {
    }

    public TabIndicatorModifier(State arg1, int arg2, boolean arg3, FiniteAnimationSpec arg4) {
        super();
        this.tabPositionsState = arg1;
        this.selectedTabIndex = arg2;
        this.followContentSize = arg3;
        this.animationSpec = arg4;
    }

    public final State component1() {
        return this.tabPositionsState;
    }

    public final int component2() {
        return this.selectedTabIndex;
    }

    public final boolean component3() {
        return this.followContentSize;
    }

    public final FiniteAnimationSpec component4() {
        return this.animationSpec;
    }

    public final TabIndicatorModifier copy(State arg1, int arg2, boolean arg3, FiniteAnimationSpec arg4) {
        return new TabIndicatorModifier(arg1, arg2, arg3, arg4);
    }

    public static TabIndicatorModifier copy$default(TabIndicatorModifier arg0, State arg1, int arg2, boolean arg3, FiniteAnimationSpec arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.tabPositionsState;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.selectedTabIndex;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.followContentSize;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.animationSpec;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public TabIndicatorOffsetNode create() {
        return new TabIndicatorOffsetNode(this.tabPositionsState, this.selectedTabIndex, this.followContentSize, this.animationSpec);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((TabIndicatorModifier)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TabIndicatorModifier)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.tabPositionsState, ((TabIndicatorModifier)arg5).tabPositionsState)) {
            return 0;
        }

        if(this.selectedTabIndex != ((TabIndicatorModifier)arg5).selectedTabIndex) {
            return 0;
        }

        if(this.followContentSize != ((TabIndicatorModifier)arg5).followContentSize) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.animationSpec, ((TabIndicatorModifier)arg5).animationSpec)) {
            return 0;
        }

        return 1;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getFollowContentSize() {
        return this.followContentSize;
    }

    public final int getSelectedTabIndex() {
        return this.selectedTabIndex;
    }

    public final State getTabPositionsState() {
        return this.tabPositionsState;
    }

    public int hashCode() {
        return ((this.tabPositionsState.hashCode() * 0x1F + Integer.hashCode(this.selectedTabIndex)) * 0x1F + Boolean.hashCode(this.followContentSize)) * 0x1F + this.animationSpec.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public String toString() {
        return "TabIndicatorModifier(tabPositionsState=" + this.tabPositionsState + ", selectedTabIndex=" + this.selectedTabIndex + ", followContentSize=" + this.followContentSize + ", animationSpec=" + this.animationSpec + ')';
    }

    public void update(TabIndicatorOffsetNode arg2) {
        arg2.setTabPositionsState(this.tabPositionsState);
        arg2.setSelectedTabIndex(this.selectedTabIndex);
        arg2.setFollowContentSize(this.followContentSize);
        arg2.setAnimationSpec(this.animationSpec);
    }

    public void update(Node arg1) {
        this.update(((TabIndicatorOffsetNode)arg1));
    }
}

