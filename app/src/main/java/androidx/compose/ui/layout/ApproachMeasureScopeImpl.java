package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutModifierNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\u001D\u001A\u00020\u001E*\u00020\u001EH\u0016J`\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020&2\u0012\u0010(\u001A\u000E\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020&0)2\u0019\u0010+\u001A\u0015\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.\u0018\u00010,¢\u0006\u0002\b/2\u0017\u00100\u001A\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020.0,¢\u0006\u0002\b/H\u0016JF\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020&2\u0012\u0010(\u001A\u000E\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020&0)2\u0017\u00100\u001A\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020.0,¢\u0006\u0002\b/H\u0096\u0001J\u0014\u00102\u001A\u00020&*\u000203H\u0097\u0001¢\u0006\u0004\b4\u00105J\u0014\u00102\u001A\u00020&*\u000206H\u0097\u0001¢\u0006\u0004\b7\u00108J\u0014\u00109\u001A\u000203*\u00020&H\u0097\u0001¢\u0006\u0004\b:\u0010;J\u0014\u00109\u001A\u000203*\u00020<H\u0097\u0001¢\u0006\u0004\b:\u0010=J\u0014\u00109\u001A\u000203*\u000206H\u0097\u0001¢\u0006\u0004\b>\u0010?J\u0014\u0010@\u001A\u00020A*\u00020BH\u0097\u0001¢\u0006\u0004\bC\u0010DJ\u0014\u0010E\u001A\u00020<*\u000203H\u0097\u0001¢\u0006\u0004\bF\u0010=J\u0014\u0010E\u001A\u00020<*\u000206H\u0097\u0001¢\u0006\u0004\bG\u0010?J\r\u0010H\u001A\u00020I*\u00020JH\u0097\u0001J\u0014\u0010K\u001A\u00020B*\u00020AH\u0097\u0001¢\u0006\u0004\bL\u0010DJ\u0014\u0010M\u001A\u000206*\u00020&H\u0097\u0001¢\u0006\u0004\bN\u0010OJ\u0014\u0010M\u001A\u000206*\u00020<H\u0097\u0001¢\u0006\u0004\bN\u0010PJ\u0014\u0010M\u001A\u000206*\u000203H\u0097\u0001¢\u0006\u0004\bQ\u0010PR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0013R\u001A\u0010\u0017\u001A\u00020\u0018X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u0018\u0010\u001F\u001A\u00020\u001E*\u00020 8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0014\u00101\u001A\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b1\u0010\u001AR\u0014\u0010R\u001A\u00020<8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\bS\u0010TR\u0014\u0010U\u001A\u00020<8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\bV\u0010TR\u0012\u0010W\u001A\u00020XX\u0096\u0005¢\u0006\u0006\u001A\u0004\bY\u0010Z¨\u0006["}, d2={"Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "coordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "approachNode", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "<init>", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;Landroidx/compose/ui/layout/ApproachLayoutModifierNode;)V", "getCoordinator", "()Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "getApproachNode", "()Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "setApproachNode", "(Landroidx/compose/ui/layout/ApproachLayoutModifierNode;)V", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-msEJaDk", "()J", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", "approachMeasureRequired", "", "getApproachMeasureRequired$ui", "()Z", "setApproachMeasureRequired$ui", "(Z)V", "toLookaheadCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "isLookingAhead", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "density", "getDensity", "()F", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ApproachMeasureScopeImpl implements ApproachMeasureScope, LookaheadScope, MeasureScope {
    public static final int $stable;
    private boolean approachMeasureRequired;
    private ApproachLayoutModifierNode approachNode;
    private final LayoutModifierNodeCoordinator coordinator;

    static {
    }

    public ApproachMeasureScopeImpl(LayoutModifierNodeCoordinator arg1, ApproachLayoutModifierNode arg2) {
        super();
        this.coordinator = arg1;
        this.approachNode = arg2;
    }

    public final boolean getApproachMeasureRequired$ui() {
        return this.approachMeasureRequired;
    }

    public final ApproachLayoutModifierNode getApproachNode() {
        return this.approachNode;
    }

    public final LayoutModifierNodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    public float getDensity() {
        return this.coordinator.getDensity();
    }

    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    public long getLookaheadConstraints-msEJaDk() {
        Constraints v2 = this.coordinator.getLookaheadConstraints-DWUhwKw$ui();
        if(v2 != null) {
            return v2.unbox-impl();
        }

        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Error: Lookahead constraints requested before lookahead measure.");
        throw new KotlinNothingValueException();
    }

    public LayoutCoordinates getLookaheadScopeCoordinates(PlacementScope arg1) {
        NodeCoordinator v1_1;
        LayoutNode v0 = this.coordinator.getLayoutNode().getLookaheadRoot$ui();
        if(v0 != null) {
            if(v0.isVirtualLookaheadRoot$ui()) {
                LayoutNode v1 = v0.getParent$ui();
                if(v1 != null) {
                    v1_1 = v1.getInnerCoordinator$ui();
                    if(v1_1 == null) {
                        goto label_10;
                    }
                }
                else {
                label_10:
                    v1_1 = v0.getChildren$ui().get(0).getOuterCoordinator$ui();
                }

                return ((LayoutCoordinates)v1_1);
            }

            return v0.getOuterCoordinator$ui();
        }

        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Error: Requesting LookaheadScopeCoordinates is not permitted from outside of a LookaheadScope.");
        throw new KotlinNothingValueException();
    }

    public long getLookaheadSize-YbymL2g() {
        LookaheadDelegate v6 = this.coordinator.getLookaheadDelegate();
        Intrinsics.checkNotNull(v6);
        MeasureResult v6_1 = v6.getMeasureResult$ui();
        return IntSize.constructor-impl((((long)v6_1.getWidth())) << 0x20 | (((long)v6_1.getHeight())) & 0xFFFFFFFFL);
    }

    public boolean isLookingAhead() {
        return 0;
    }

    public MeasureResult layout(int arg1, int arg2, Map arg3, Function1 arg4) {
        return this.coordinator.layout(arg1, arg2, arg3, arg4);
    }

    public MeasureResult layout(int arg9, int arg10, Map arg11, Function1 arg12, Function1 arg13) {
        int v0 = 0xFF000000;
        v0 = (arg9 & v0) != 0 || (v0 & arg10) != 0 ? 0 : 1;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + arg9 + " x " + arg10 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }

        return new ApproachMeasureScopeImpl$layout$1(arg9, arg10, arg11, arg12, arg13, this);
    }

    public int roundToPx--R2X_6o(long arg1) {
        return this.coordinator.roundToPx--R2X_6o(arg1);
    }

    public int roundToPx-0680j_4(float arg1) {
        return this.coordinator.roundToPx-0680j_4(arg1);
    }

    public final void setApproachMeasureRequired$ui(boolean arg1) {
        this.approachMeasureRequired = arg1;
    }

    public final void setApproachNode(ApproachLayoutModifierNode arg1) {
        this.approachNode = arg1;
    }

    public float toDp-GaN1DYA(long arg1) {
        return this.coordinator.toDp-GaN1DYA(arg1);
    }

    public float toDp-u2uoSUM(float arg1) {
        return this.coordinator.toDp-u2uoSUM(arg1);
    }

    public float toDp-u2uoSUM(int arg1) {
        return this.coordinator.toDp-u2uoSUM(arg1);
    }

    public long toDpSize-k-rfVVM(long arg1) {
        return this.coordinator.toDpSize-k-rfVVM(arg1);
    }

    public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates arg1) {
        if((arg1 instanceof LookaheadLayoutCoordinates)) {
        }
        else if((arg1 instanceof NodeCoordinator)) {
            LookaheadDelegate v0 = arg1.getLookaheadDelegate();
            if(v0 != null) {
                LookaheadLayoutCoordinates v0_1 = v0.getLookaheadLayoutCoordinates();
                if(v0_1 != null) {
                    return ((LayoutCoordinates)v0_1);
                }
            }
        }
        else {
            goto label_12;
        }

        return arg1;
    label_12:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Unsupported LayoutCoordinates");
        throw new KotlinNothingValueException();
    }

    public float toPx--R2X_6o(long arg1) {
        return this.coordinator.toPx--R2X_6o(arg1);
    }

    public float toPx-0680j_4(float arg1) {
        return this.coordinator.toPx-0680j_4(arg1);
    }

    public Rect toRect(DpRect arg1) {
        return this.coordinator.toRect(arg1);
    }

    public long toSize-XkaWNTQ(long arg1) {
        return this.coordinator.toSize-XkaWNTQ(arg1);
    }

    public long toSp-0xMU5do(float arg1) {
        return this.coordinator.toSp-0xMU5do(arg1);
    }

    public long toSp-kPz2Gy4(float arg1) {
        return this.coordinator.toSp-kPz2Gy4(arg1);
    }

    public long toSp-kPz2Gy4(int arg1) {
        return this.coordinator.toSp-kPz2Gy4(arg1);
    }
}

