package androidx.compose.foundation;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableNode;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BW\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f\u0012\b\u0010\r\u001A\u0004\u0018\u00010\u000E\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001A\u00020\t\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010!\u001A\u0004\u0018\u00010\u0013J\b\u0010\"\u001A\u00020#H\u0016J\b\u0010$\u001A\u00020#H\u0016J\b\u0010%\u001A\u00020#H\u0016JV\u0010&\u001A\u00020#2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\t2\b\u0010\'\u001A\u0004\u0018\u00010\u00132\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010J\u0006\u0010 \u001A\u00020\tJ\b\u0010(\u001A\u00020#H\u0002J\b\u0010)\u001A\u00020#H\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001A\u00020\tX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001F\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006*"}, d2={"Landroidx/compose/foundation/ScrollableAreaNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseScrolling", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "useLocalOverscrollFactory", "userProvidedOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;ZLandroidx/compose/foundation/OverscrollEffect;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "scrollableNode", "Landroidx/compose/foundation/gestures/ScrollableNode;", "overscrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "localOverscrollFactory", "Landroidx/compose/foundation/OverscrollFactory;", "localOverscrollFactoryCreatedOverscrollEffect", "shouldReverseDirection", "getOverscrollEffect", "onAttach", "", "onDetach", "onLayoutDirectionChange", "update", "overscrollEffect", "attachOverscrollNodeIfNeeded", "onObservedReadsChanged", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ScrollableAreaNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {
    private BringIntoViewSpec bringIntoViewSpec;
    private boolean enabled;
    private FlingBehavior flingBehavior;
    private MutableInteractionSource interactionSource;
    private OverscrollFactory localOverscrollFactory;
    private OverscrollEffect localOverscrollFactoryCreatedOverscrollEffect;
    private Orientation orientation;
    private DelegatableNode overscrollNode;
    private boolean reverseScrolling;
    private ScrollableNode scrollableNode;
    private final boolean shouldAutoInvalidate;
    private boolean shouldReverseDirection;
    private ScrollableState state;
    private boolean useLocalOverscrollFactory;
    private OverscrollEffect userProvidedOverscrollEffect;

    public ScrollableAreaNode(ScrollableState arg1, Orientation arg2, boolean arg3, boolean arg4, FlingBehavior arg5, MutableInteractionSource arg6, BringIntoViewSpec arg7, boolean arg8, OverscrollEffect arg9) {
        super();
        this.state = arg1;
        this.orientation = arg2;
        this.enabled = arg3;
        this.reverseScrolling = arg4;
        this.flingBehavior = arg5;
        this.interactionSource = arg6;
        this.bringIntoViewSpec = arg7;
        this.useLocalOverscrollFactory = arg8;
        this.userProvidedOverscrollEffect = arg9;
    }

    private final void attachOverscrollNodeIfNeeded() {
        DelegatableNode v0 = this.overscrollNode;
        if(v0 == null) {
            if(this.useLocalOverscrollFactory) {
                ObserverModifierNodeKt.observeReads(this, new ScrollableAreaNode$$ExternalSyntheticLambda0(this));
            }

            OverscrollEffect v0_1 = this.getOverscrollEffect();
            if(v0_1 == null) {
                return;
            }

            v0 = v0_1.getNode();
            if(v0.getNode().isAttached()) {
                return;
            }

            this.overscrollNode = this.delegate(v0);
            return;
        }
        else {
            if(v0 == null) {
                return;
            }

            if(v0.getNode().isAttached()) {
                return;
            }

            this.delegate(v0);
        }
    }

    static final Unit attachOverscrollNodeIfNeeded$lambda$0(ScrollableAreaNode arg2) {
        Object v0 = CompositionLocalConsumerModifierNodeKt.currentValueOf(arg2, OverscrollKt.getLocalOverscrollFactory());
        arg2.localOverscrollFactory = ((OverscrollFactory)v0);
        OverscrollEffect v0_1 = v0 != null ? ((OverscrollFactory)v0).createOverscrollEffect() : null;
        arg2.localOverscrollFactoryCreatedOverscrollEffect = v0_1;
        return Unit.INSTANCE;
    }

    public final OverscrollEffect getOverscrollEffect() {
        if(this.useLocalOverscrollFactory) {
            return this.localOverscrollFactoryCreatedOverscrollEffect;
        }

        return this.userProvidedOverscrollEffect;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public void onAttach() {
        this.shouldReverseDirection = this.shouldReverseDirection();
        this.attachOverscrollNodeIfNeeded();
        if(this.scrollableNode == null) {
            this.scrollableNode = this.delegate(new ScrollableNode(this.state, this.getOverscrollEffect(), this.flingBehavior, this.orientation, this.enabled, this.shouldReverseDirection, this.interactionSource, this.bringIntoViewSpec));
        }
    }

    public void onDetach() {
        DelegatableNode v0 = this.overscrollNode;
        if(v0 != null) {
            this.undelegate(v0);
        }
    }

    public void onLayoutDirectionChange() {
        boolean v0 = this.shouldReverseDirection();
        if(this.shouldReverseDirection != v0) {
            this.shouldReverseDirection = v0;
            this.update(this.state, this.orientation, this.useLocalOverscrollFactory, this.getOverscrollEffect(), this.enabled, this.reverseScrolling, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec);
        }
    }

    public void onObservedReadsChanged() {
        Object v0 = CompositionLocalConsumerModifierNodeKt.currentValueOf(this, OverscrollKt.getLocalOverscrollFactory());
        if(!Intrinsics.areEqual(v0, this.localOverscrollFactory)) {
            this.localOverscrollFactory = ((OverscrollFactory)v0);
            OverscrollEffect v0_1 = null;
            this.localOverscrollFactoryCreatedOverscrollEffect = v0_1;
            DelegatableNode v1 = this.overscrollNode;
            if(v1 != null) {
                this.undelegate(v1);
            }

            this.overscrollNode = ((DelegatableNode)v0_1);
            this.attachOverscrollNodeIfNeeded();
            ScrollableNode v2 = this.scrollableNode;
            if(v2 == null) {
                return;
            }

            v2.update(this.state, this.orientation, this.getOverscrollEffect(), this.enabled, this.shouldReverseDirection, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec);
        }
    }

    public final boolean shouldReverseDirection() {
        LayoutDirection v0 = LayoutDirection.Ltr;
        if(this.isAttached()) {
            v0 = DelegatableNodeKt.requireLayoutDirection(this);
        }

        return ScrollableDefaults.INSTANCE.reverseDirection(v0, this.orientation, this.reverseScrolling);
    }

    public final void update(ScrollableState arg10, Orientation arg11, boolean arg12, OverscrollEffect arg13, boolean arg14, boolean arg15, FlingBehavior arg16, MutableInteractionSource arg17, BringIntoViewSpec arg18) {
        int v0;
        this.state = arg10;
        this.orientation = arg11;
        int v1 = 1;
        if(this.useLocalOverscrollFactory != arg12) {
            this.useLocalOverscrollFactory = arg12;
            v0 = 1;
        }
        else {
            v0 = 0;
        }

        if(!Intrinsics.areEqual(this.userProvidedOverscrollEffect, arg13)) {
            this.userProvidedOverscrollEffect = arg13;
        }
        else {
            v1 = 0;
        }

        if(v0 != 0 || v1 != 0 && !arg12) {
            DelegatableNode v12 = this.overscrollNode;
            if(v12 != null) {
                this.undelegate(v12);
            }

            this.overscrollNode = null;
            this.attachOverscrollNodeIfNeeded();
        }

        this.enabled = arg14;
        this.reverseScrolling = arg15;
        FlingBehavior v6 = arg16;
        this.flingBehavior = v6;
        MutableInteractionSource v7 = arg17;
        this.interactionSource = v7;
        BringIntoViewSpec v8 = arg18;
        this.bringIntoViewSpec = v8;
        this.shouldReverseDirection = this.shouldReverseDirection();
        ScrollableNode v0_1 = this.scrollableNode;
        if(v0_1 != null) {
            v0_1.update(arg10, arg11, this.getOverscrollEffect(), arg14, this.shouldReverseDirection, v6, v7, v8);
        }
    }
}

