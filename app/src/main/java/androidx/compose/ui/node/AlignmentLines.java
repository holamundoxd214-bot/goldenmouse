package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\"\u001A\u00020#J\u0012\u0010(\u001A\u000E\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\'0)J\u0014\u0010.\u001A\u00020\'*\u00020+2\u0006\u0010/\u001A\u00020&H$J \u00100\u001A\u00020#2\u0006\u0010/\u001A\u00020&2\u0006\u00101\u001A\u00020\'2\u0006\u00102\u001A\u00020+H\u0002J\u0006\u00103\u001A\u00020#J\r\u00104\u001A\u00020#H\u0000¢\u0006\u0002\b5J\u0006\u00106\u001A\u00020#J\u001B\u00107\u001A\u000208*\u00020+2\u0006\u00109\u001A\u000208H$¢\u0006\u0004\b:\u0010;R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u000B\"\u0004\b\u0010\u0010\rR\u001A\u0010\u0011\u001A\u00020\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000B\"\u0004\b\u0013\u0010\rR\u001A\u0010\u0014\u001A\u00020\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u000B\"\u0004\b\u0016\u0010\rR\u001A\u0010\u0017\u001A\u00020\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u000B\"\u0004\b\u0019\u0010\rR\u001A\u0010\u001A\u001A\u00020\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u000B\"\u0004\b\u001C\u0010\rR\u0014\u0010\u001D\u001A\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u000BR\u0010\u0010\u001F\u001A\u0004\u0018\u00010\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010 \u001A\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u000BR\u001A\u0010$\u001A\u000E\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\'0%X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010*\u001A\u000E\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\'0)*\u00020+X¤\u0004¢\u0006\u0006\u001A\u0004\b,\u0010-\u0082\u0001\u0002<=¨\u0006>"}, d2={"Landroidx/compose/ui/node/AlignmentLines;", "", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "<init>", "(Landroidx/compose/ui/node/AlignmentLinesOwner;)V", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "dirty", "", "getDirty$ui", "()Z", "setDirty$ui", "(Z)V", "usedDuringParentMeasurement", "getUsedDuringParentMeasurement$ui", "setUsedDuringParentMeasurement$ui", "usedDuringParentLayout", "getUsedDuringParentLayout$ui", "setUsedDuringParentLayout$ui", "previousUsedDuringParentLayout", "getPreviousUsedDuringParentLayout$ui", "setPreviousUsedDuringParentLayout$ui", "usedByModifierMeasurement", "getUsedByModifierMeasurement$ui", "setUsedByModifierMeasurement$ui", "usedByModifierLayout", "getUsedByModifierLayout$ui", "setUsedByModifierLayout$ui", "queried", "getQueried$ui", "queryOwner", "required", "getRequired$ui", "recalculateQueryOwner", "", "alignmentLineMap", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getLastCalculation", "", "alignmentLinesMap", "Landroidx/compose/ui/node/NodeCoordinator;", "getAlignmentLinesMap", "(Landroidx/compose/ui/node/NodeCoordinator;)Ljava/util/Map;", "getPositionFor", "alignmentLine", "addAlignmentLine", "initialPosition", "initialCoordinator", "recalculate", "reset", "reset$ui", "onAlignmentsChanged", "calculatePositionInParent", "Landroidx/compose/ui/geometry/Offset;", "position", "calculatePositionInParent-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "Landroidx/compose/ui/node/LookaheadAlignmentLines;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class AlignmentLines {
    public static final int $stable = 8;
    private final Map alignmentLineMap;
    private final AlignmentLinesOwner alignmentLinesOwner;
    private boolean dirty;
    private boolean previousUsedDuringParentLayout;
    private AlignmentLinesOwner queryOwner;
    private boolean usedByModifierLayout;
    private boolean usedByModifierMeasurement;
    private boolean usedDuringParentLayout;
    private boolean usedDuringParentMeasurement;

    static {
    }

    private AlignmentLines(AlignmentLinesOwner arg1) {
        super();
        this.alignmentLinesOwner = arg1;
        this.dirty = true;
        this.alignmentLineMap = new HashMap();
    }

    public AlignmentLines(AlignmentLinesOwner arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public static final void access$addAlignmentLine(AlignmentLines arg0, AlignmentLine arg1, int arg2, NodeCoordinator arg3) {
        arg0.addAlignmentLine(arg1, arg2, arg3);
    }

    public static final Map access$getAlignmentLineMap$p(AlignmentLines arg0) {
        return arg0.alignmentLineMap;
    }

    private final void addAlignmentLine(AlignmentLine arg9, int arg10, NodeCoordinator arg11) {
        float v10 = ((float)arg10);
        long v0 = ((long)Float.floatToRawIntBits(v10));
        long v2 = ((long)Float.floatToRawIntBits(v10));
        arg10 = 0x20;
        long v4 = 0xFFFFFFFFL;
        for(v0 = Offset.constructor-impl(v0 << arg10 | v2 & v4); true; v0 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v0_1))) << arg10 | (((long)Float.floatToRawIntBits(v0_1))) & v4)) {
        label_11:
            v0 = this.calculatePositionInParent-R5De75A(arg11, v0);
            arg11 = arg11.getWrappedBy$ui();
            Intrinsics.checkNotNull(arg11);
            if(Intrinsics.areEqual(arg11, this.alignmentLinesOwner.getInnerCoordinator())) {
                break;
            }

            if(!this.getAlignmentLinesMap(arg11).containsKey(arg9)) {
                goto label_11;
            }

            float v0_1 = ((float)this.getPositionFor(arg11, arg9));
        }

        v10 = (arg9 instanceof HorizontalAlignmentLine) ? Float.intBitsToFloat(((int)(v0 & v4))) : Float.intBitsToFloat(((int)(v0 >> arg10)));
        arg10 = Math.round(v10);
        Map v11 = this.alignmentLineMap;
        if(v11.containsKey(arg9)) {
            arg10 = AlignmentLineKt.merge(arg9, MapsKt.getValue(this.alignmentLineMap, arg9).intValue(), arg10);
        }

        v11.put(arg9, Integer.valueOf(arg10));
    }

    protected abstract long calculatePositionInParent-R5De75A(NodeCoordinator arg1, long arg2);

    protected abstract Map getAlignmentLinesMap(NodeCoordinator arg1);

    public final AlignmentLinesOwner getAlignmentLinesOwner() {
        return this.alignmentLinesOwner;
    }

    public final boolean getDirty$ui() {
        return this.dirty;
    }

    public final Map getLastCalculation() {
        return this.alignmentLineMap;
    }

    protected abstract int getPositionFor(NodeCoordinator arg1, AlignmentLine arg2);

    public final boolean getPreviousUsedDuringParentLayout$ui() {
        return this.previousUsedDuringParentLayout;
    }

    public final boolean getQueried$ui() {
        if(!this.usedDuringParentMeasurement && !this.previousUsedDuringParentLayout && !this.usedByModifierMeasurement) {
            if(this.usedByModifierLayout) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean getRequired$ui() {
        this.recalculateQueryOwner();
        if(this.queryOwner != null) {
            return 1;
        }

        return 0;
    }

    public final boolean getUsedByModifierLayout$ui() {
        return this.usedByModifierLayout;
    }

    public final boolean getUsedByModifierMeasurement$ui() {
        return this.usedByModifierMeasurement;
    }

    public final boolean getUsedDuringParentLayout$ui() {
        return this.usedDuringParentLayout;
    }

    public final boolean getUsedDuringParentMeasurement$ui() {
        return this.usedDuringParentMeasurement;
    }

    public final void onAlignmentsChanged() {
        this.dirty = true;
        AlignmentLinesOwner v0 = this.alignmentLinesOwner.getParentAlignmentLinesOwner();
        if(v0 == null) {
            return;
        }

        if(this.usedDuringParentMeasurement) {
            v0.requestMeasure();
        }
        else {
            if(!this.previousUsedDuringParentLayout && !this.usedDuringParentLayout) {
                goto label_15;
            }

            v0.requestLayout();
        }

    label_15:
        if(this.usedByModifierMeasurement) {
            this.alignmentLinesOwner.requestMeasure();
        }

        if(this.usedByModifierLayout) {
            this.alignmentLinesOwner.requestLayout();
        }

        v0.getAlignmentLines().onAlignmentsChanged();
    }

    public final void recalculate() {
        this.alignmentLineMap.clear();
        this.alignmentLinesOwner.forEachChildAlignmentLinesOwner(new AlignmentLines$recalculate$1(this));
        this.alignmentLineMap.putAll(this.getAlignmentLinesMap(this.alignmentLinesOwner.getInnerCoordinator()));
        this.dirty = false;
    }

    public final void recalculateQueryOwner() {
        boolean v0 = this.getQueried$ui();
        AlignmentLinesOwner v1 = this.alignmentLinesOwner;
        if(v0) {
            goto label_32;
        }
        else {
            AlignmentLinesOwner v0_1 = v1.getParentAlignmentLinesOwner();
            if(v0_1 == null) {
            }
            else {
                v1 = v0_1.getAlignmentLines().queryOwner;
                if(v1 == null || !v1.getAlignmentLines().getQueried$ui()) {
                    v0_1 = this.queryOwner;
                    if(v0_1 == null) {
                        return;
                    }

                    if(v0_1.getAlignmentLines().getQueried$ui()) {
                        return;
                    }

                    v1 = v0_1.getParentAlignmentLinesOwner();
                    if(v1 != null) {
                        AlignmentLines v1_1 = v1.getAlignmentLines();
                        if(v1_1 != null) {
                            v1_1.recalculateQueryOwner();
                        }
                    }

                    v0_1 = v0_1.getParentAlignmentLinesOwner();
                    if(v0_1 != null) {
                        AlignmentLines v0_2 = v0_1.getAlignmentLines();
                        if(v0_2 != null) {
                            v1 = v0_2.queryOwner;
                            goto label_32;
                        }
                    }

                    v1 = null;
                }

            label_32:
                this.queryOwner = v1;
            }
        }
    }

    public final void reset$ui() {
        this.dirty = true;
        this.usedDuringParentMeasurement = false;
        this.previousUsedDuringParentLayout = false;
        this.usedDuringParentLayout = false;
        this.usedByModifierMeasurement = false;
        this.usedByModifierLayout = false;
        this.queryOwner = null;
    }

    public final void setDirty$ui(boolean arg1) {
        this.dirty = arg1;
    }

    public final void setPreviousUsedDuringParentLayout$ui(boolean arg1) {
        this.previousUsedDuringParentLayout = arg1;
    }

    public final void setUsedByModifierLayout$ui(boolean arg1) {
        this.usedByModifierLayout = arg1;
    }

    public final void setUsedByModifierMeasurement$ui(boolean arg1) {
        this.usedByModifierMeasurement = arg1;
    }

    public final void setUsedDuringParentLayout$ui(boolean arg1) {
        this.usedDuringParentLayout = arg1;
    }

    public final void setUsedDuringParentMeasurement$ui(boolean arg1) {
        this.usedDuringParentMeasurement = arg1;
    }
}

