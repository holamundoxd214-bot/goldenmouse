package androidx.compose.animation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001A\u00020\nH\u0016J\b\u0010\u000B\u001A\u00020\nH\u0016J#\u0010\u0010\u001A\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001A\u00020\nH\u0016J\f\u0010\u001A\u001A\u00020\n*\u00020\u001BH\u0016R$\u0010\u0005\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u0006@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\b¨\u0006\u001C"}, d2={"Landroidx/compose/animation/SharedTransitionScopeRootModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "sharedScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "<init>", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "onAttach", "", "onDetach", "newScope", "getSharedScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "setSharedScope", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "onObservedReadsChanged", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class SharedTransitionScopeRootModifierNode extends Node implements DrawModifierNode, LayoutModifierNode, ObserverModifierNode {
    private SharedTransitionScopeImpl sharedScope;

    public SharedTransitionScopeRootModifierNode(SharedTransitionScopeImpl arg1) {
        super();
        this.sharedScope = arg1;
    }

    public void draw(ContentDrawScope arg1) {
        arg1.drawContent();
        this.sharedScope.drawInOverlay$animation(arg1);
    }

    public final SharedTransitionScopeImpl getSharedScope() {
        return this.sharedScope;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        Placeable v9 = arg9.measure-BRTryo0(arg10);
        return MeasureScope.layout$default(arg8, v9.getWidth(), v9.getHeight(), null, new SharedTransitionScopeRootModifierNode$measure$1(arg8, this, v9), 4, null);
    }

    public void onAttach() {
        super.onAttach();
        ObserverModifierNodeKt.observeReads(this, this.sharedScope.getObserveAnimatingBlock$animation());
        this.sharedScope.setInvalidateOverlay(new SharedTransitionScopeRootModifierNode$onAttach$1(this));
    }

    public void onDetach() {
        this.sharedScope.setInvalidateOverlay(null);
    }

    public void onObservedReadsChanged() {
        this.sharedScope.updateTransitionActiveness$animation();
        ObserverModifierNodeKt.observeReads(this, this.sharedScope.getObserveAnimatingBlock$animation());
    }

    public final void setSharedScope(SharedTransitionScopeImpl arg3) {
        if(!Intrinsics.areEqual(arg3, this.sharedScope)) {
            ObserverModifierNodeKt.observeReads(this, arg3.getObserveAnimatingBlock$animation());
        }

        this.sharedScope = arg3;
    }
}

