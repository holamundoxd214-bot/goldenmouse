package androidx.compose.ui.node;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010;\u001A\u00020<H\u0000¢\u0006\u0002\b=J\r\u0010>\u001A\u00020<H\u0000¢\u0006\u0002\b?J\r\u0010@\u001A\u00020<H\u0000¢\u0006\u0002\bAJ\r\u0010B\u001A\u00020<H\u0000¢\u0006\u0002\bCJ\u0006\u0010e\u001A\u00020<J\u0017\u0010f\u001A\u00020<2\u0006\u0010g\u001A\u00020\rH\u0000¢\u0006\u0004\bh\u0010iJ\r\u0010j\u001A\u00020<H\u0000¢\u0006\u0002\bkJ\u0006\u0010l\u001A\u00020<J\u0006\u0010m\u001A\u00020<J\u0006\u0010n\u001A\u00020<J\u0006\u0010o\u001A\u00020<J\u0006\u0010p\u001A\u00020<R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\f\u001A\u0004\u0018\u00010\r8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0010\u001A\u0004\u0018\u00010\r8F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000FR\u0014\u0010\u0012\u001A\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0015R\u001A\u0010\u0018\u001A\u00020\u0019X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001E\u001A\u00020\u0019X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\u001B\"\u0004\b \u0010\u001DR\u001A\u0010!\u001A\u00020\"X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010\'\u001A\u00020\u00198@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b(\u0010\u001BR\u0014\u0010)\u001A\u00020\u00198@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b*\u0010\u001BR\u001A\u0010+\u001A\u00020\u0019X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\u001B\"\u0004\b-\u0010\u001DR\u001A\u0010.\u001A\u00020\u0019X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b/\u0010\u001B\"\u0004\b0\u0010\u001DR\u001A\u00101\u001A\u00020\u0019X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b2\u0010\u001B\"\u0004\b3\u0010\u001DR\u001A\u00104\u001A\u00020\u0013X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b5\u0010\u0015\"\u0004\b6\u00107R\u001A\u00108\u001A\u00020\u0013X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b9\u0010\u0015\"\u0004\b:\u00107R\u0014\u0010D\u001A\u00020E8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bF\u0010GR\u0016\u0010H\u001A\u0004\u0018\u00010E8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bI\u0010GR$\u0010K\u001A\u00020\u00192\u0006\u0010J\u001A\u00020\u0019@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bL\u0010\u001B\"\u0004\bM\u0010\u001DR$\u0010N\u001A\u00020\u00192\u0006\u0010J\u001A\u00020\u0019@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bO\u0010\u001B\"\u0004\bP\u0010\u001DR$\u0010Q\u001A\u00020\u00132\u0006\u0010J\u001A\u00020\u0013@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bR\u0010\u0015\"\u0004\bS\u00107R$\u0010T\u001A\u00020\u00192\u0006\u0010J\u001A\u00020\u0019@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bU\u0010\u001B\"\u0004\bV\u0010\u001DR$\u0010W\u001A\u00020\u00192\u0006\u0010J\u001A\u00020\u0019@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bX\u0010\u001B\"\u0004\bY\u0010\u001DR$\u0010Z\u001A\u00020\u00132\u0006\u0010J\u001A\u00020\u0013@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b[\u0010\u0015\"\u0004\b\\\u00107R\u0014\u0010]\u001A\u00020^X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b_\u0010`R\"\u0010b\u001A\u0004\u0018\u00010a2\b\u0010J\u001A\u0004\u0018\u00010a@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\bc\u0010d¨\u0006q"}, d2={"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "getLayoutNode$ui", "()Landroidx/compose/ui/node/LayoutNode;", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLookaheadConstraints", "getLastLookaheadConstraints-DWUhwKw", "height", "", "getHeight$ui", "()I", "width", "getWidth$ui", "detachedFromParentLookaheadPass", "", "getDetachedFromParentLookaheadPass$ui", "()Z", "setDetachedFromParentLookaheadPass$ui", "(Z)V", "detachedFromParentLookaheadPlacement", "getDetachedFromParentLookaheadPlacement$ui", "setDetachedFromParentLookaheadPlacement$ui", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "setLayoutState$ui", "(Landroidx/compose/ui/node/LayoutNode$LayoutState;)V", "measurePending", "getMeasurePending$ui", "layoutPending", "getLayoutPending$ui", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui", "setLookaheadMeasurePending$ui", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui", "setLookaheadLayoutPending$ui", "lookaheadLayoutPendingForAlignment", "getLookaheadLayoutPendingForAlignment$ui", "setLookaheadLayoutPendingForAlignment$ui", "nextChildLookaheadPlaceOrder", "getNextChildLookaheadPlaceOrder$ui", "setNextChildLookaheadPlaceOrder$ui", "(I)V", "nextChildPlaceOrder", "getNextChildPlaceOrder$ui", "setNextChildPlaceOrder$ui", "markLayoutPending", "", "markLayoutPending$ui", "markMeasurePending", "markMeasurePending$ui", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner$ui", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "lookaheadAlignmentLinesOwner", "getLookaheadAlignmentLinesOwner$ui", "value", "coordinatesAccessedDuringPlacement", "getCoordinatesAccessedDuringPlacement", "setCoordinatesAccessedDuringPlacement", "coordinatesAccessedDuringModifierPlacement", "getCoordinatesAccessedDuringModifierPlacement", "setCoordinatesAccessedDuringModifierPlacement", "childrenAccessingCoordinatesDuringPlacement", "getChildrenAccessingCoordinatesDuringPlacement", "setChildrenAccessingCoordinatesDuringPlacement", "lookaheadCoordinatesAccessedDuringPlacement", "getLookaheadCoordinatesAccessedDuringPlacement", "setLookaheadCoordinatesAccessedDuringPlacement", "lookaheadCoordinatesAccessedDuringModifierPlacement", "getLookaheadCoordinatesAccessedDuringModifierPlacement", "setLookaheadCoordinatesAccessedDuringModifierPlacement", "childrenAccessingLookaheadCoordinatesDuringPlacement", "getChildrenAccessingLookaheadCoordinatesDuringPlacement", "setChildrenAccessingLookaheadCoordinatesDuringPlacement", "measurePassDelegate", "Landroidx/compose/ui/node/MeasurePassDelegate;", "getMeasurePassDelegate$ui", "()Landroidx/compose/ui/node/MeasurePassDelegate;", "Landroidx/compose/ui/node/LookaheadPassDelegate;", "lookaheadPassDelegate", "getLookaheadPassDelegate$ui", "()Landroidx/compose/ui/node/LookaheadPassDelegate;", "onCoordinatesUsed", "performLookaheadMeasure", "constraints", "performLookaheadMeasure-BRTryo0$ui", "(J)V", "ensureLookaheadDelegateCreated", "ensureLookaheadDelegateCreated$ui", "updateParentData", "invalidateParentData", "resetAlignmentLines", "markChildrenDirty", "onRemovedFromLookaheadScope", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutNodeLayoutDelegate {
    public static final int $stable = 8;
    private int childrenAccessingCoordinatesDuringPlacement;
    private int childrenAccessingLookaheadCoordinatesDuringPlacement;
    private boolean coordinatesAccessedDuringModifierPlacement;
    private boolean coordinatesAccessedDuringPlacement;
    private boolean detachedFromParentLookaheadPass;
    private boolean detachedFromParentLookaheadPlacement;
    private final LayoutNode layoutNode;
    private LayoutState layoutState;
    private boolean lookaheadCoordinatesAccessedDuringModifierPlacement;
    private boolean lookaheadCoordinatesAccessedDuringPlacement;
    private boolean lookaheadLayoutPending;
    private boolean lookaheadLayoutPendingForAlignment;
    private boolean lookaheadMeasurePending;
    private LookaheadPassDelegate lookaheadPassDelegate;
    private final MeasurePassDelegate measurePassDelegate;
    private int nextChildLookaheadPlaceOrder;
    private int nextChildPlaceOrder;

    static {
    }

    public LayoutNodeLayoutDelegate(LayoutNode arg1) {
        super();
        this.layoutNode = arg1;
        this.layoutState = LayoutState.Idle;
        this.measurePassDelegate = new MeasurePassDelegate(this);
    }

    public final void ensureLookaheadDelegateCreated$ui() {
        if(this.lookaheadPassDelegate == null) {
            this.lookaheadPassDelegate = new LookaheadPassDelegate(this);
        }
    }

    public final AlignmentLinesOwner getAlignmentLinesOwner$ui() {
        return this.measurePassDelegate;
    }

    public final int getChildrenAccessingCoordinatesDuringPlacement() {
        return this.childrenAccessingCoordinatesDuringPlacement;
    }

    public final int getChildrenAccessingLookaheadCoordinatesDuringPlacement() {
        return this.childrenAccessingLookaheadCoordinatesDuringPlacement;
    }

    public final boolean getCoordinatesAccessedDuringModifierPlacement() {
        return this.coordinatesAccessedDuringModifierPlacement;
    }

    public final boolean getCoordinatesAccessedDuringPlacement() {
        return this.coordinatesAccessedDuringPlacement;
    }

    public final boolean getDetachedFromParentLookaheadPass$ui() {
        return this.detachedFromParentLookaheadPass;
    }

    public final boolean getDetachedFromParentLookaheadPlacement$ui() {
        return this.detachedFromParentLookaheadPlacement;
    }

    public final int getHeight$ui() {
        return this.measurePassDelegate.getHeight();
    }

    public final Constraints getLastConstraints-DWUhwKw() {
        return this.measurePassDelegate.getLastConstraints-DWUhwKw();
    }

    public final Constraints getLastLookaheadConstraints-DWUhwKw() {
        LookaheadPassDelegate v0 = this.lookaheadPassDelegate;
        if(v0 != null) {
            return v0.getLastConstraints-DWUhwKw();
        }

        return null;
    }

    public final LayoutNode getLayoutNode$ui() {
        return this.layoutNode;
    }

    public final boolean getLayoutPending$ui() {
        return this.measurePassDelegate.getLayoutPending$ui();
    }

    public final LayoutState getLayoutState$ui() {
        return this.layoutState;
    }

    public final AlignmentLinesOwner getLookaheadAlignmentLinesOwner$ui() {
        return this.lookaheadPassDelegate;
    }

    public final boolean getLookaheadCoordinatesAccessedDuringModifierPlacement() {
        return this.lookaheadCoordinatesAccessedDuringModifierPlacement;
    }

    public final boolean getLookaheadCoordinatesAccessedDuringPlacement() {
        return this.lookaheadCoordinatesAccessedDuringPlacement;
    }

    public final boolean getLookaheadLayoutPending$ui() {
        return this.lookaheadLayoutPending;
    }

    public final boolean getLookaheadLayoutPendingForAlignment$ui() {
        return this.lookaheadLayoutPendingForAlignment;
    }

    public final boolean getLookaheadMeasurePending$ui() {
        return this.lookaheadMeasurePending;
    }

    public final LookaheadPassDelegate getLookaheadPassDelegate$ui() {
        return this.lookaheadPassDelegate;
    }

    public final MeasurePassDelegate getMeasurePassDelegate$ui() {
        return this.measurePassDelegate;
    }

    public final boolean getMeasurePending$ui() {
        return this.measurePassDelegate.getMeasurePending$ui();
    }

    public final int getNextChildLookaheadPlaceOrder$ui() {
        return this.nextChildLookaheadPlaceOrder;
    }

    public final int getNextChildPlaceOrder$ui() {
        return this.nextChildPlaceOrder;
    }

    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNode.getNodes$ui().getOuterCoordinator$ui();
    }

    public final int getWidth$ui() {
        return this.measurePassDelegate.getWidth();
    }

    public final void invalidateParentData() {
        this.measurePassDelegate.invalidateParentData();
        LookaheadPassDelegate v1 = this.lookaheadPassDelegate;
        if(v1 != null) {
            v1.invalidateParentData();
        }
    }

    public final void markChildrenDirty() {
        this.measurePassDelegate.setChildDelegatesDirty$ui(true);
        LookaheadPassDelegate v2 = this.lookaheadPassDelegate;
        if(v2 != null) {
            v2.setChildDelegatesDirty$ui(true);
        }
    }

    public final void markLayoutPending$ui() {
        this.measurePassDelegate.markLayoutPending();
    }

    public final void markLookaheadLayoutPending$ui() {
        this.lookaheadLayoutPending = true;
        this.lookaheadLayoutPendingForAlignment = true;
    }

    public final void markLookaheadMeasurePending$ui() {
        this.lookaheadMeasurePending = true;
    }

    public final void markMeasurePending$ui() {
        this.measurePassDelegate.markMeasurePending$ui();
    }

    public final void onCoordinatesUsed() {
        LayoutState v0 = this.layoutNode.getLayoutState$ui();
        if(v0 == LayoutState.LayingOut || v0 == LayoutState.LookaheadLayingOut) {
            if(this.measurePassDelegate.getLayingOutChildren()) {
                this.setCoordinatesAccessedDuringPlacement(true);
            }
            else {
                this.setCoordinatesAccessedDuringModifierPlacement(true);
            }
        }

        if(v0 == LayoutState.LookaheadLayingOut) {
            LookaheadPassDelegate v0_1 = this.lookaheadPassDelegate;
            if(v0_1 != null && (v0_1.getLayingOutChildren())) {
                this.setLookaheadCoordinatesAccessedDuringPlacement(true);
                return;
            }

            this.setLookaheadCoordinatesAccessedDuringModifierPlacement(true);
        }
    }

    public final void onRemovedFromLookaheadScope() {
        this.lookaheadPassDelegate = null;
        this.lookaheadLayoutPending = false;
        this.lookaheadMeasurePending = false;
    }

    public final void performLookaheadMeasure-BRTryo0$ui(long arg1) {
        LookaheadPassDelegate v0 = this.lookaheadPassDelegate;
        if(v0 != null) {
            v0.performMeasure-BRTryo0$ui(arg1);
        }
    }

    public final void resetAlignmentLines() {
        this.measurePassDelegate.getAlignmentLines().reset$ui();
        LookaheadPassDelegate v1 = this.lookaheadPassDelegate;
        if(v1 != null) {
            AlignmentLines v1_1 = v1.getAlignmentLines();
            if(v1_1 != null) {
                v1_1.reset$ui();
            }
        }
    }

    public final void setChildrenAccessingCoordinatesDuringPlacement(int arg4) {
        int v0 = this.childrenAccessingCoordinatesDuringPlacement;
        this.childrenAccessingCoordinatesDuringPlacement = arg4;
        int v1 = 0;
        v0 = v0 == 0 ? 1 : 0;
        if(arg4 == 0) {
            v1 = 1;
        }

        if(v0 != v1) {
            LayoutNode v3 = this.layoutNode.getParent$ui();
            this = v3 != null ? v3.getLayoutDelegate$ui() : null;
            if(this == null) {
                return;
            }

            if(arg4 == 0) {
                this.setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
                return;
            }

            this.setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
        }
    }

    public final void setChildrenAccessingLookaheadCoordinatesDuringPlacement(int arg4) {
        int v0 = this.childrenAccessingLookaheadCoordinatesDuringPlacement;
        this.childrenAccessingLookaheadCoordinatesDuringPlacement = arg4;
        int v1 = 0;
        v0 = v0 == 0 ? 1 : 0;
        if(arg4 == 0) {
            v1 = 1;
        }

        if(v0 != v1) {
            LayoutNode v3 = this.layoutNode.getParent$ui();
            this = v3 != null ? v3.getLayoutDelegate$ui() : null;
            if(this == null) {
                return;
            }

            if(arg4 == 0) {
                this.setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement - 1);
                return;
            }

            this.setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement + 1);
        }
    }

    public final void setCoordinatesAccessedDuringModifierPlacement(boolean arg2) {
        if(this.coordinatesAccessedDuringModifierPlacement != arg2) {
            this.coordinatesAccessedDuringModifierPlacement = arg2;
            if((arg2) && !this.coordinatesAccessedDuringPlacement) {
                this.setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
                return;
            }

            if(arg2) {
                return;
            }

            if(this.coordinatesAccessedDuringPlacement) {
                return;
            }

            this.setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
        }
    }

    public final void setCoordinatesAccessedDuringPlacement(boolean arg2) {
        if(this.coordinatesAccessedDuringPlacement != arg2) {
            this.coordinatesAccessedDuringPlacement = arg2;
            if((arg2) && !this.coordinatesAccessedDuringModifierPlacement) {
                this.setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
                return;
            }

            if(arg2) {
                return;
            }

            if(this.coordinatesAccessedDuringModifierPlacement) {
                return;
            }

            this.setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
        }
    }

    public final void setDetachedFromParentLookaheadPass$ui(boolean arg1) {
        this.detachedFromParentLookaheadPass = arg1;
    }

    public final void setDetachedFromParentLookaheadPlacement$ui(boolean arg1) {
        this.detachedFromParentLookaheadPlacement = arg1;
    }

    public final void setLayoutState$ui(LayoutState arg1) {
        this.layoutState = arg1;
    }

    public final void setLookaheadCoordinatesAccessedDuringModifierPlacement(boolean arg2) {
        if(this.lookaheadCoordinatesAccessedDuringModifierPlacement != arg2) {
            this.lookaheadCoordinatesAccessedDuringModifierPlacement = arg2;
            if((arg2) && !this.lookaheadCoordinatesAccessedDuringPlacement) {
                this.setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement + 1);
                return;
            }

            if(arg2) {
                return;
            }

            if(this.lookaheadCoordinatesAccessedDuringPlacement) {
                return;
            }

            this.setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement - 1);
        }
    }

    public final void setLookaheadCoordinatesAccessedDuringPlacement(boolean arg2) {
        if(this.lookaheadCoordinatesAccessedDuringPlacement != arg2) {
            this.lookaheadCoordinatesAccessedDuringPlacement = arg2;
            if((arg2) && !this.lookaheadCoordinatesAccessedDuringModifierPlacement) {
                this.setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement + 1);
                return;
            }

            if(arg2) {
                return;
            }

            if(this.lookaheadCoordinatesAccessedDuringModifierPlacement) {
                return;
            }

            this.setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement - 1);
        }
    }

    public final void setLookaheadLayoutPending$ui(boolean arg1) {
        this.lookaheadLayoutPending = arg1;
    }

    public final void setLookaheadLayoutPendingForAlignment$ui(boolean arg1) {
        this.lookaheadLayoutPendingForAlignment = arg1;
    }

    public final void setLookaheadMeasurePending$ui(boolean arg1) {
        this.lookaheadMeasurePending = arg1;
    }

    public final void setNextChildLookaheadPlaceOrder$ui(int arg1) {
        this.nextChildLookaheadPlaceOrder = arg1;
    }

    public final void setNextChildPlaceOrder$ui(int arg1) {
        this.nextChildPlaceOrder = arg1;
    }

    public final void updateParentData() {
        LayoutNode v1;
        if(this.measurePassDelegate.updateParentData()) {
            v1 = this.layoutNode.getParent$ui();
            if(v1 != null) {
                LayoutNode.requestRemeasure$ui$default(v1, false, false, false, 7, null);
            }
        }

        LookaheadPassDelegate v0 = this.lookaheadPassDelegate;
        if(v0 != null && (v0.updateParentData())) {
            boolean v0_1 = LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.layoutNode);
            LayoutNode v13 = this.layoutNode;
            if(v0_1) {
                v1 = v13.getParent$ui();
                if(v1 != null) {
                    LayoutNode.requestRemeasure$ui$default(v1, false, false, false, 7, null);
                    return;
                }
            }
            else {
                LayoutNode v7 = v13.getParent$ui();
                if(v7 != null) {
                    LayoutNode.requestLookaheadRemeasure$ui$default(v7, false, false, false, 7, null);
                }
            }
        }
    }
}

