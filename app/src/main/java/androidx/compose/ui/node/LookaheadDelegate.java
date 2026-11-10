package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000E\b!\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010J\u001A\u00020\u001A2\u0006\u0010K\u001A\u00020\u0019H\u0000¢\u0006\u0002\bLJ\r\u0010M\u001A\u00020NH\u0010¢\u0006\u0002\bOJ:\u0010P\u001A\u00020N2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010Q\u001A\u00020%2\u0019\u0010R\u001A\u0015\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020N\u0018\u00010S¢\u0006\u0002\bUH\u0004¢\u0006\u0004\bV\u0010WJ\u0017\u0010X\u001A\u00020N2\u0006\u0010\u0010\u001A\u00020\u0011H\u0002¢\u0006\u0004\bY\u0010\u0015J\u0017\u0010Z\u001A\u00020N2\u0006\u0010\u0010\u001A\u00020\u0011H\u0000¢\u0006\u0004\b[\u0010\u0015J\b\u0010\\\u001A\u00020NH\u0014J&\u0010]\u001A\u00020^2\u0006\u00107\u001A\u0002082\f\u0010_\u001A\b\u0012\u0004\u0012\u00020\u001C0`H\u0086\b¢\u0006\u0004\ba\u0010bJ\u0010\u0010g\u001A\u00020\u001A2\u0006\u0010h\u001A\u00020\u001AH\u0016J\u0010\u0010i\u001A\u00020\u001A2\u0006\u0010h\u001A\u00020\u001AH\u0016J\u0010\u0010j\u001A\u00020\u001A2\u0006\u0010k\u001A\u00020\u001AH\u0016J\u0010\u0010l\u001A\u00020\u001A2\u0006\u0010k\u001A\u00020\u001AH\u0016J\u001F\u0010m\u001A\u00020\u00112\u0006\u0010n\u001A\u00020\u00002\u0006\u0010o\u001A\u00020\rH\u0000¢\u0006\u0004\bp\u0010qR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001A\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0010\u001A\u00020\u0011X\u0096\u000E¢\u0006\u0010\n\u0002\u0010\u0016\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001C\u0010\u0017\u001A\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\u00020\u001C8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u000FR\u0014\u0010 \u001A\u00020!8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020%8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020%8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b)\u0010\'R\u0016\u0010*\u001A\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b+\u0010\u000BR\u0014\u0010,\u001A\u00020-8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b.\u0010/R\u0014\u00100\u001A\u0002018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b2\u00103R\u0014\u00104\u001A\u0002058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b6\u0010\u0013R\u0014\u00107\u001A\u0002088@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b9\u0010\u0013R\u0011\u0010:\u001A\u00020;¢\u0006\b\n\u0000\u001A\u0004\b<\u0010=R\u0014\u0010>\u001A\u00020?8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b@\u0010AR\"\u0010C\u001A\u0004\u0018\u00010\u001C2\b\u0010B\u001A\u0004\u0018\u00010\u001C@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\bD\u0010ER\u001A\u0010F\u001A\b\u0012\u0004\u0012\u00020\u00190GX\u0084\u0004¢\u0006\b\n\u0000\u001A\u0004\bH\u0010IR\u0016\u0010c\u001A\u0004\u0018\u00010d8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\be\u0010f¨\u0006r"}, d2={"Landroidx/compose/ui/node/LookaheadDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "<init>", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "setPosition--gyyYBs", "(J)V", "J", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui", "()Landroidx/compose/ui/layout/MeasureResult;", "isLookingAhead", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "parent", "getParent", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g$ui", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk$ui", "lookaheadLayoutCoordinates", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "getLookaheadLayoutCoordinates", "()Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "result", "_measureResult", "set_measureResult", "(Landroidx/compose/ui/layout/MeasureResult;)V", "cachedAlignmentLinesMap", "Landroidx/collection/MutableObjectIntMap;", "getCachedAlignmentLinesMap", "()Landroidx/collection/MutableObjectIntMap;", "getCachedAlignmentLine", "alignmentLine", "getCachedAlignmentLine$ui", "replace", "", "replace$ui", "placeAt", "zIndex", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeSelf", "placeSelf--gyyYBs", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset--gyyYBs$ui", "placeChildren", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "block", "Lkotlin/Function0;", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "minIntrinsicWidth", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "positionIn", "ancestor", "excludingAgnosticOffset", "positionIn-iSbpLlY$ui", "(Landroidx/compose/ui/node/LookaheadDelegate;Z)J", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class LookaheadDelegate extends LookaheadCapablePlaceable implements Measurable {
    public static final int $stable;
    private MeasureResult _measureResult;
    private final MutableObjectIntMap cachedAlignmentLinesMap;
    private final NodeCoordinator coordinator;
    private final LookaheadLayoutCoordinates lookaheadLayoutCoordinates;
    private Map oldAlignmentLines;
    private long position;

    static {
    }

    public LookaheadDelegate(NodeCoordinator arg3) {
        super();
        this.coordinator = arg3;
        this.position = IntOffset.Companion.getZero-nOcc-ac();
        this.lookaheadLayoutCoordinates = new LookaheadLayoutCoordinates(this);
        this.cachedAlignmentLinesMap = ObjectIntMapKt.mutableObjectIntMapOf();
    }

    public static final void access$setMeasurementConstraints-BRTryo0(LookaheadDelegate arg0, long arg1) {
        arg0.setMeasurementConstraints-BRTryo0(arg1);
    }

    public static final void access$set_measureResult(LookaheadDelegate arg0, MeasureResult arg1) {
        arg0.set_measureResult(arg1);
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        AlignmentLinesOwner v0 = this.coordinator.getLayoutNode().getLayoutDelegate$ui().getLookaheadAlignmentLinesOwner$ui();
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    public final int getCachedAlignmentLine$ui(AlignmentLine arg2) {
        return this.cachedAlignmentLinesMap.getOrDefault(arg2, 0x80000000);
    }

    protected final MutableObjectIntMap getCachedAlignmentLinesMap() {
        return this.cachedAlignmentLinesMap;
    }

    public LookaheadCapablePlaceable getChild() {
        LookaheadCapablePlaceable v0_1;
        NodeCoordinator v0 = this.coordinator.getWrapped$ui();
        if(v0 != null) {
            this = v0.getLookaheadDelegate();
        }
        else {
            v0_1 = null;
        }

        return v0_1;
    }

    public final long getConstraints-msEJaDk$ui() {
        return this.getMeasurementConstraints-msEJaDk();
    }

    public LayoutCoordinates getCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    public final NodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    public float getDensity() {
        return this.coordinator.getDensity();
    }

    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    public boolean getHasMeasureResult() {
        if(this._measureResult != null) {
            return 1;
        }

        return 0;
    }

    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    public LayoutNode getLayoutNode() {
        return this.coordinator.getLayoutNode();
    }

    public final LookaheadLayoutCoordinates getLookaheadLayoutCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    public MeasureResult getMeasureResult$ui() {
        MeasureResult v0 = this._measureResult;
        if(v0 != null) {
            return v0;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("LookaheadDelegate has not been measured yet when measureResult is requested.");
        throw new KotlinNothingValueException();
    }

    public LookaheadCapablePlaceable getParent() {
        LookaheadCapablePlaceable v0_1;
        NodeCoordinator v0 = this.coordinator.getWrappedBy$ui();
        if(v0 != null) {
            this = v0.getLookaheadDelegate();
        }
        else {
            v0_1 = null;
        }

        return v0_1;
    }

    public Object getParentData() {
        return this.coordinator.getParentData();
    }

    public long getPosition-nOcc-ac() {
        return this.position;
    }

    public final long getSize-YbymL2g$ui() {
        return IntSize.constructor-impl((((long)this.getWidth())) << 0x20 | (((long)this.getHeight())) & 0xFFFFFFFFL);
    }

    public boolean isLookingAhead() {
        return 1;
    }

    public int maxIntrinsicHeight(int arg1) {
        NodeCoordinator v0 = this.coordinator.getWrapped$ui();
        Intrinsics.checkNotNull(v0);
        this = v0.getLookaheadDelegate();
        Intrinsics.checkNotNull(this);
        return this.maxIntrinsicHeight(arg1);
    }

    public int maxIntrinsicWidth(int arg1) {
        NodeCoordinator v0 = this.coordinator.getWrapped$ui();
        Intrinsics.checkNotNull(v0);
        this = v0.getLookaheadDelegate();
        Intrinsics.checkNotNull(this);
        return this.maxIntrinsicWidth(arg1);
    }

    public int minIntrinsicHeight(int arg1) {
        NodeCoordinator v0 = this.coordinator.getWrapped$ui();
        Intrinsics.checkNotNull(v0);
        this = v0.getLookaheadDelegate();
        Intrinsics.checkNotNull(this);
        return this.minIntrinsicHeight(arg1);
    }

    public int minIntrinsicWidth(int arg1) {
        NodeCoordinator v0 = this.coordinator.getWrapped$ui();
        Intrinsics.checkNotNull(v0);
        this = v0.getLookaheadDelegate();
        Intrinsics.checkNotNull(this);
        return this.minIntrinsicWidth(arg1);
    }

    public final Placeable performingMeasure-K40F9xA(long arg1, Function0 arg3) {
        this.setMeasurementConstraints-BRTryo0(arg1);
        this.set_measureResult(arg3.invoke());
        return this;
    }

    protected final void placeAt-f8xVGno(long arg1, float arg3, Function1 arg4) {
        this.placeSelf--gyyYBs(arg1);
        if(this.isShallowPlacing$ui()) {
            return;
        }

        this.placeChildren();
    }

    protected void placeChildren() {
        this.getMeasureResult$ui().placeChildren();
    }

    private final void placeSelf--gyyYBs(long arg3) {
        if(!IntOffset.equals-impl0(this.getPosition-nOcc-ac(), arg3)) {
            this.setPosition--gyyYBs(arg3);
            LookaheadPassDelegate v3 = this.getLayoutNode().getLayoutDelegate$ui().getLookaheadPassDelegate$ui();
            if(v3 != null) {
                v3.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
            }

            this.invalidateAlignmentLinesFromPositionChange(this.coordinator);
        }

        if(!this.isPlacingForAlignment$ui()) {
            this.captureRulersIfNeeded$ui(this.getMeasureResult$ui());
        }
    }

    public final void placeSelfApparentToRealOffset--gyyYBs$ui(long arg3) {
        this.placeSelf--gyyYBs(IntOffset.plus-qkQi6aY(arg3, this.getApparentToRealOffset-nOcc-ac()));
    }

    public final long positionIn-iSbpLlY$ui(LookaheadDelegate arg5, boolean arg6) {
        long v0 = IntOffset.Companion.getZero-nOcc-ac();
        while(!Intrinsics.areEqual(this, arg5)) {
            if(!this.isPlacedUnderMotionFrameOfReference() || !arg6) {
                v0 = IntOffset.plus-qkQi6aY(v0, this.getPosition-nOcc-ac());
            }

            NodeCoordinator v4 = ((LookaheadDelegate)v4).coordinator.getWrappedBy$ui();
            Intrinsics.checkNotNull(v4);
            this = v4.getLookaheadDelegate();
            Intrinsics.checkNotNull(this);
        }

        return v0;
    }

    public void replace$ui() {
        this.placeAt-f8xVGno(this.getPosition-nOcc-ac(), 0f, null);
    }

    public void setPosition--gyyYBs(long arg1) {
        this.position = arg1;
    }

    private final void set_measureResult(MeasureResult arg7) {
        LinkedHashMap v0_1;
        if(arg7 != null) {
            this.setMeasuredSize-ozmzZPI(IntSize.constructor-impl((((long)arg7.getHeight())) & 0xFFFFFFFFL | (((long)arg7.getWidth())) << 0x20));
        }
        else {
            this.setMeasuredSize-ozmzZPI(IntSize.Companion.getZero-YbymL2g());
        }

        if(!Intrinsics.areEqual(this._measureResult, arg7) && arg7 != null) {
            Map v0 = this.oldAlignmentLines;
            if((v0 == null || (v0.isEmpty())) && (arg7.getAlignmentLines().isEmpty())) {
                goto label_43;
            }

            if(Intrinsics.areEqual(arg7.getAlignmentLines(), this.oldAlignmentLines)) {
                goto label_43;
            }

            this.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            v0 = this.oldAlignmentLines;
            if(v0 == null) {
                v0_1 = new LinkedHashMap();
                this.oldAlignmentLines = ((Map)v0_1);
            }

            ((Map)v0_1).clear();
            ((Map)v0_1).putAll(arg7.getAlignmentLines());
        }

    label_43:
        this._measureResult = arg7;
    }
}

