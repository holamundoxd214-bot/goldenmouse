package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\"\u001A\u00020 2\u0006\u0010#\u001A\u00020 H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001A\u00020 2\u0006\u0010\'\u001A\u00020 H\u0016¢\u0006\u0004\b(\u0010%J\u0017\u0010)\u001A\u00020 2\u0006\u0010*\u001A\u00020 H\u0016¢\u0006\u0004\b+\u0010%J\u0017\u0010,\u001A\u00020 2\u0006\u0010\'\u001A\u00020 H\u0016¢\u0006\u0004\b-\u0010%J\u0017\u0010.\u001A\u00020 2\u0006\u0010\'\u001A\u00020 H\u0016¢\u0006\u0004\b/\u0010%J\u001F\u00100\u001A\u00020 2\u0006\u00101\u001A\u00020\u00012\u0006\u00102\u001A\u00020 H\u0016¢\u0006\u0004\b3\u00104J\'\u00100\u001A\u00020 2\u0006\u00101\u001A\u00020\u00012\u0006\u00102\u001A\u00020 2\u0006\u00105\u001A\u00020\u001BH\u0016¢\u0006\u0004\b6\u00107J\u0018\u00108\u001A\u0002092\u0006\u00101\u001A\u00020\u00012\u0006\u0010:\u001A\u00020\u001BH\u0016J\u001F\u0010;\u001A\u00020<2\u0006\u00101\u001A\u00020\u00012\u0006\u0010=\u001A\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001A\u00020<2\u0006\u0010=\u001A\u00020>H\u0016¢\u0006\u0004\bB\u0010CJ\u0011\u0010D\u001A\u00020E2\u0006\u0010F\u001A\u00020\u0012H\u0096\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001A\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001A\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001A\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001CR\u0014\u0010\u001F\u001A\u00020 8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u000F¨\u0006G"}, d2={"Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "<init>", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentCoordinates", "getParentCoordinates", "isAttached", "", "()Z", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference", "lookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "getLookaheadOffset-F1C5BW0", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "(J)J", "localToScreen", "relativeToLocal", "localToScreen-MK-Hz9U", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "localToRoot", "localToRoot-MK-Hz9U", "localPositionOf", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "clipBounds", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "get", "", "alignmentLine", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LookaheadLayoutCoordinates implements LayoutCoordinates {
    public static final int $stable;
    private final LookaheadDelegate lookaheadDelegate;

    static {
    }

    public LookaheadLayoutCoordinates(LookaheadDelegate arg1) {
        super();
        this.lookaheadDelegate = arg1;
    }

    public int get(AlignmentLine arg1) {
        return this.lookaheadDelegate.get(arg1);
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    public boolean getIntroducesMotionFrameOfReference() {
        return this.lookaheadDelegate.isPlacedUnderMotionFrameOfReference();
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    private final long getLookaheadOffset-F1C5BW0() {
        LookaheadDelegate v0 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.minus-MK-Hz9U(this.localPositionOf-R5De75A(v0.getCoordinates(), Offset.Companion.getZero-F1C5BW0()), this.getCoordinator().localPositionOf-R5De75A(v0.getCoordinator(), Offset.Companion.getZero-F1C5BW0()));
    }

    public LayoutCoordinates getParentCoordinates() {
        if(!this.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }

        NodeCoordinator v1 = this.getCoordinator().getWrappedBy$ui();
        if(v1 != null) {
            LookaheadDelegate v1_1 = v1.getLookaheadDelegate();
            if(v1_1 != null) {
                return v1_1.getCoordinates();
            }
        }

        return null;
    }

    public LayoutCoordinates getParentLayoutCoordinates() {
        if(!this.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }

        NodeCoordinator v1 = this.getCoordinator().getLayoutNode().getOuterCoordinator$ui().getWrappedBy$ui();
        LayoutCoordinates v0 = null;
        if(v1 != null) {
            LookaheadDelegate v1_1 = v1.getLookaheadDelegate();
            if(v1_1 != null) {
                return v1_1.getCoordinates();
            }
        }

        return v0;
    }

    public Set getProvidedAlignmentLines() {
        return this.getCoordinator().getProvidedAlignmentLines();
    }

    public long getSize-YbymL2g() {
        return IntSize.constructor-impl((((long)this.lookaheadDelegate.getWidth())) << 0x20 | (((long)this.lookaheadDelegate.getHeight())) & 0xFFFFFFFFL);
    }

    public boolean isAttached() {
        return this.getCoordinator().isAttached();
    }

    public Rect localBoundingBoxOf(LayoutCoordinates arg1, boolean arg2) {
        return this.getCoordinator().localBoundingBoxOf(arg1, arg2);
    }

    public long localPositionOf-R5De75A(LayoutCoordinates arg2, long arg3) {
        return this.localPositionOf-S_NoaFU(arg2, arg3, true);
    }

    public long localPositionOf-S_NoaFU(LayoutCoordinates arg10, long arg11, boolean arg13) {
        long v9;
        LookaheadDelegate v0;
        long v1 = 0xFFFFFFFFL;
        int v3 = 0x20;
        if((arg10 instanceof LookaheadLayoutCoordinates)) {
            LookaheadDelegate v10 = ((LookaheadLayoutCoordinates)arg10).lookaheadDelegate;
            v10.getCoordinator().onCoordinatesUsed$ui();
            v0 = this.getCoordinator().findCommonAncestor$ui(v10.getCoordinator()).getLookaheadDelegate();
            if(v0 != null) {
                v9 = IntOffset.minus-qkQi6aY(IntOffset.plus-qkQi6aY(v10.positionIn-iSbpLlY$ui(v0, (((int)arg13)) ^ 1), IntOffsetKt.round-k-4lQ0M(arg11)), this.lookaheadDelegate.positionIn-iSbpLlY$ui(v0, (((int)arg13)) ^ 1));
                return Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)IntOffset.getX-impl(v9))))) << v3 | (((long)Float.floatToRawIntBits(((float)IntOffset.getY-impl(v9))))) & v1);
            }

            v0 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(v10);
            long v10_1 = IntOffset.plus-qkQi6aY(IntOffset.plus-qkQi6aY(v10.positionIn-iSbpLlY$ui(v0, (((int)arg13)) ^ 1), v0.getPosition-nOcc-ac()), IntOffsetKt.round-k-4lQ0M(arg11));
            LookaheadDelegate v12 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
            v9 = IntOffset.minus-qkQi6aY(v10_1, IntOffset.plus-qkQi6aY(this.lookaheadDelegate.positionIn-iSbpLlY$ui(v12, (((int)arg13)) ^ 1), v12.getPosition-nOcc-ac()));
            v9 = Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)IntOffset.getX-impl(v9))))) << v3 | v1 & (((long)Float.floatToRawIntBits(((float)IntOffset.getY-impl(v9))))));
            NodeCoordinator v11 = v12.getCoordinator().getWrappedBy$ui();
            Intrinsics.checkNotNull(v11);
            NodeCoordinator v12_1 = v0.getCoordinator().getWrappedBy$ui();
            Intrinsics.checkNotNull(v12_1);
            return v11.localPositionOf-S_NoaFU(((LayoutCoordinates)v12_1), v9, arg13);
        }

        v0 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        arg11 = this.localPositionOf-S_NoaFU(v0.getLookaheadLayoutCoordinates(), arg11, arg13);
        long v4 = v0.getPosition-nOcc-ac();
        arg11 = Offset.minus-MK-Hz9U(arg11, Offset.constructor-impl(v1 & (((long)Float.floatToRawIntBits(((float)IntOffset.getY-impl(v4))))) | (((long)Float.floatToRawIntBits(((float)IntOffset.getX-impl(v4))))) << v3));
        LayoutCoordinates v9_1 = v0.getCoordinator().getParentCoordinates();
        if(v9_1 == null) {
            v9_1 = v0.getCoordinator().getCoordinates();
        }

        return Offset.plus-MK-Hz9U(arg11, v9_1.localPositionOf-S_NoaFU(arg10, Offset.Companion.getZero-F1C5BW0(), arg13));
    }

    public long localToRoot-MK-Hz9U(long arg4) {
        return this.getCoordinator().localToRoot-MK-Hz9U(Offset.plus-MK-Hz9U(arg4, this.getLookaheadOffset-F1C5BW0()));
    }

    public long localToScreen-MK-Hz9U(long arg4) {
        return this.getCoordinator().localToScreen-MK-Hz9U(Offset.plus-MK-Hz9U(arg4, this.getLookaheadOffset-F1C5BW0()));
    }

    public long localToWindow-MK-Hz9U(long arg4) {
        return this.getCoordinator().localToWindow-MK-Hz9U(Offset.plus-MK-Hz9U(arg4, this.getLookaheadOffset-F1C5BW0()));
    }

    public long screenToLocal-MK-Hz9U(long arg3) {
        return Offset.plus-MK-Hz9U(this.getCoordinator().screenToLocal-MK-Hz9U(arg3), this.getLookaheadOffset-F1C5BW0());
    }

    public void transformFrom-EL8BTi8(LayoutCoordinates arg1, float[] arg2) {
        this.getCoordinator().transformFrom-EL8BTi8(arg1, arg2);
    }

    public void transformToScreen-58bKbWc(float[] arg1) {
        this.getCoordinator().transformToScreen-58bKbWc(arg1);
    }

    public long windowToLocal-MK-Hz9U(long arg3) {
        return Offset.plus-MK-Hz9U(this.getCoordinator().windowToLocal-MK-Hz9U(arg3), this.getLookaheadOffset-F1C5BW0());
    }
}

