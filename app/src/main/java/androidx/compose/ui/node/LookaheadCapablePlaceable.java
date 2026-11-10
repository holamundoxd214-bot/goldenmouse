package androidx.compose.ui.node;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterSet;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u0000 p2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002opB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\'\u001A\u00020 2\u0006\u0010(\u001A\u00020\u0010H\u0016J\u0011\u0010,\u001A\u00020-2\u0006\u0010.\u001A\u00020/H\u0086\u0002J\u0010\u00100\u001A\u00020-2\u0006\u0010.\u001A\u00020/H&J\r\u00108\u001A\u00020 H ¢\u0006\u0002\b9J\f\u0010E\u001A\u00020 *\u00020FH\u0004J\u0016\u0010O\u001A\u00020P2\u0006\u0010Q\u001A\u00020L2\u0006\u0010R\u001A\u00020PJ\u0018\u0010S\u001A\u00020 2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010Q\u001A\u00020LH\u0002J\u0010\u0010T\u001A\u00020\u00002\u0006\u0010Q\u001A\u00020LH\u0002J\u0014\u0010U\u001A\u00020\u0010*\u00020\u00142\u0006\u0010V\u001A\u00020\u0014H\u0002J\u0015\u0010W\u001A\u00020 2\u0006\u0010Q\u001A\u00020LH\u0000¢\u0006\u0002\bXJ`\u0010Y\u001A\u0002052\u0006\u0010Z\u001A\u00020-2\u0006\u0010[\u001A\u00020-2\u0012\u0010\\\u001A\u000E\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020-0]2\u0019\u0010^\u001A\u0015\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020 \u0018\u00010\u001E¢\u0006\u0002\b!2\u0017\u0010_\u001A\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020 0\u001E¢\u0006\u0002\b!H\u0016J\u0017\u0010`\u001A\u00020 2\b\u0010a\u001A\u0004\u0018\u000105H\u0000¢\u0006\u0002\bbJ+\u0010c\u001A\u00020 2\u0006\u0010d\u001A\u00020#2\b\b\u0002\u0010e\u001A\u00020\u00072\b\b\u0002\u0010f\u001A\u00020gH\u0002¢\u0006\u0004\bh\u0010iJ\u0010\u0010`\u001A\u00020 2\u0006\u0010d\u001A\u00020#H\u0002J\u001C\u0010j\u001A\u00020 2\u0012\u0010k\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140N0MH\u0002J\u0016\u0010l\u001A\u00020 2\u0006\u0010Q\u001A\u00020L2\u0006\u0010m\u001A\u00020PJ\u0016\u0010n\u001A\u00020 2\u0006\u0010Q\u001A\u00020L2\u0006\u0010m\u001A\u00020PR\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\fR\u0012\u0010\u000F\u001A\u00020\u0010X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001A\u00020\u0014X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001A\u00020\u0018X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\b\u0018\u00010\u001CR\u00020\u0000X\u0082\u000E¢\u0006\u0002\n\u0000R!\u0010\u001D\u001A\u0015\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020 \u0018\u00010\u001E¢\u0006\u0002\b!X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001A\u0004\u0018\u00010#X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010$\u001A\u00020\u0010X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b$\u0010\u0012\"\u0004\b%\u0010&R\u0018\u0010)\u001A\u00060\u001CR\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b*\u0010+R\u001A\u00101\u001A\u00020\u0010X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b2\u0010\u0012\"\u0004\b3\u0010&R\u0012\u00104\u001A\u000205X \u0004¢\u0006\u0006\u001A\u0004\b6\u00107R\u0012\u0010:\u001A\u00020;X¦\u0004¢\u0006\u0006\u001A\u0004\b<\u0010=R\u001A\u0010>\u001A\u00020\u0010X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b?\u0010\u0012\"\u0004\b@\u0010&R\u0011\u0010A\u001A\u00020B¢\u0006\b\n\u0000\u001A\u0004\bC\u0010DR\u0014\u0010G\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bG\u0010\u0012R\u0010\u0010H\u001A\u0004\u0018\u00010IX\u0082\u000E¢\u0006\u0002\n\u0000R(\u0010J\u001A\u001C\u0012\u0004\u0012\u00020L\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140N0M\u0018\u00010KX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006q"}, d2={"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "<init>", "()V", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "parent", "getParent", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "_rulerScope", "Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "rulersLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "cachedRulerPlaceableResult", "Landroidx/compose/ui/node/PlaceableResult;", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "(Z)V", "updatePlacedUnderMotionFrameOfReference", "newMFR", "rulerScope", "getRulerScope", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "get", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "calculateAlignmentLine", "isShallowPlacing", "isShallowPlacing$ui", "setShallowPlacing$ui", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui", "()Landroidx/compose/ui/layout/MeasureResult;", "replace", "replace$ui", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "isPlacingForAlignment", "isPlacingForAlignment$ui", "setPlacingForAlignment$ui", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invalidateAlignmentLinesFromPositionChange", "Landroidx/compose/ui/node/NodeCoordinator;", "isLookingAhead", "rulerValues", "Landroidx/compose/ui/node/RulerTrackingMap;", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/Ruler;", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/node/WeakReference;", "findRulerValue", "", "ruler", "defaultValue", "addRulerReader", "findAncestorRulerDefiner", "isLayoutNodeAncestor", "ancestor", "invalidateChildrenOfDefiningRuler", "invalidateChildrenOfDefiningRuler$ui", "layout", "width", "height", "alignmentLines", "", "rulers", "placementBlock", "captureRulersIfNeeded", "result", "captureRulersIfNeeded$ui", "captureRulers", "placeableResult", "positionOnScreen", "size", "Landroidx/compose/ui/unit/IntSize;", "captureRulers-OSxE8f4", "(Landroidx/compose/ui/node/PlaceableResult;JJ)V", "notifyRulerValueChange", "layoutNodes", "provideRulerValue", "value", "provideRelativeRulerValue", "ResettableRulerScope", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode, MotionReferencePlacementDelegate {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/compose/ui/node/LookaheadCapablePlaceable$Companion;", "", "<init>", "()V", "onCommitAffectingRuler", "Lkotlin/Function1;", "Landroidx/compose/ui/node/PlaceableResult;", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0019\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DH\u0096\u0004J\u0015\u0010\u001E\u001A\u00020\u001A*\u00020\u001F2\u0006\u0010\u001C\u001A\u00020\u001DH\u0096\u0004R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0011\u001A\u00020\u0012X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000FR\u0014\u0010\u0015\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010 \u001A\u00020\u001D8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\u001D8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b$\u0010\"¨\u0006%"}, d2={"Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "Landroidx/compose/ui/layout/RulerScope;", "<init>", "(Landroidx/compose/ui/node/LookaheadCapablePlaceable;)V", "coordinatesAccessed", "", "getCoordinatesAccessed", "()Z", "setCoordinatesAccessed", "(Z)V", "positionOnScreen", "Landroidx/compose/ui/unit/IntOffset;", "getPositionOnScreen-nOcc-ac", "()J", "setPositionOnScreen--gyyYBs", "(J)V", "J", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "setSize-ozmzZPI", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "provides", "", "Landroidx/compose/ui/layout/Ruler;", "value", "", "providesRelative", "Landroidx/compose/ui/layout/VerticalRuler;", "density", "getDensity", "()F", "fontScale", "getFontScale", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class ResettableRulerScope implements RulerScope {
        private boolean coordinatesAccessed;
        private long positionOnScreen;
        private long size;

        public ResettableRulerScope(LookaheadCapablePlaceable arg3) {
            LookaheadCapablePlaceable.this = arg3;
            super();
            this.positionOnScreen = IntOffset.Companion.getMax-nOcc-ac();
            this.size = IntSize.Companion.getZero-YbymL2g();
        }

        public LayoutCoordinates getCoordinates() {
            this.coordinatesAccessed = true;
            LayoutCoordinates v0 = LookaheadCapablePlaceable.this.getCoordinates();
            if(IntOffset.equals-impl0(this.positionOnScreen, IntOffset.Companion.getMax-nOcc-ac())) {
                this.positionOnScreen = IntOffsetKt.round-k-4lQ0M(LayoutCoordinatesKt.positionOnScreen(v0));
                this.size = v0.getSize-YbymL2g();
            }

            LookaheadCapablePlaceable.this.getLayoutNode().getLayoutDelegate$ui().onCoordinatesUsed();
            return v0;
        }

        public final boolean getCoordinatesAccessed() {
            return this.coordinatesAccessed;
        }

        public float getDensity() {
            return LookaheadCapablePlaceable.this.getDensity();
        }

        public float getFontScale() {
            return LookaheadCapablePlaceable.this.getFontScale();
        }

        public final long getPositionOnScreen-nOcc-ac() {
            return this.positionOnScreen;
        }

        public final long getSize-YbymL2g() {
            return this.size;
        }

        public void provides(Ruler arg1, float arg2) {
            LookaheadCapablePlaceable.this.provideRulerValue(arg1, arg2);
        }

        public void providesRelative(VerticalRuler arg1, float arg2) {
            LookaheadCapablePlaceable.this.provideRelativeRulerValue(((Ruler)arg1), arg2);
        }

        public final void setCoordinatesAccessed(boolean arg1) {
            this.coordinatesAccessed = arg1;
        }

        public final void setPositionOnScreen--gyyYBs(long arg1) {
            this.positionOnScreen = arg1;
        }

        public final void setSize-ozmzZPI(long arg1) {
            this.size = arg1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private ResettableRulerScope _rulerScope;
    private PlaceableResult cachedRulerPlaceableResult;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private static final Function1 onCommitAffectingRuler;
    private final PlacementScope placementScope;
    private MutableScatterMap rulerReaders;
    private RulerTrackingMap rulerValues;
    private Function1 rulersLambda;

    static {
        LookaheadCapablePlaceable.Companion = new Companion(null);
        LookaheadCapablePlaceable.onCommitAffectingRuler = LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1.INSTANCE;
    }

    public LookaheadCapablePlaceable() {
        super();
        this.placementScope = PlaceableKt.PlacementScope(this);
    }

    public static final void access$captureRulersIfNeeded(LookaheadCapablePlaceable arg0, PlaceableResult arg1) {
        arg0.captureRulersIfNeeded(arg1);
    }

    public static final ResettableRulerScope access$getRulerScope(LookaheadCapablePlaceable arg0) {
        return arg0.getRulerScope();
    }

    private final void addRulerReader(LayoutNode arg32, Ruler arg33) {
        MutableScatterSet v0_2;
        int v29_1;
        int v30;
        int v4;
        int v3_1;
        long v27;
        long[] v26;
        long v22;
        int v21;
        int v6;
        int v5;
        long v18;
        long v16;
        LookaheadCapablePlaceable v0 = this;
        Ruler v1 = arg33;
        MutableScatterMap v2 = v0.rulerReaders;
        int v7 = 7;
        long v8 = -9187201950435737472L;
        int v10 = 8;
        if(v2 != null) {
            Object[] v13 = ((ScatterMap)v2).values;
            long[] v2_1 = ((ScatterMap)v2).metadata;
            int v14 = v2_1.length - 2;
            if(v14 >= 0) {
                int v15 = 0;
                v16 = 0x80;
                while(true) {
                    long v3 = v2_1[v15];
                    v18 = 0xFF;
                    if((~v3 << v7 & v3 & v8) != v8) {
                        v5 = 8 - (~(v15 - v14) >>> 0x1F);
                        v6 = 0;
                        while(v6 < v5) {
                            if((v3 & v18) < v16) {
                                v21 = v7;
                                Object v7_1 = v13[(v15 << 3) + v6];
                                v22 = v8;
                                Object[] v8_1 = ((MutableScatterSet)v7_1).elements;
                                long[] v9 = v7_1.metadata;
                                int v12 = v9.length - 2;
                                if(v12 >= 0) {
                                    int v24 = v10;
                                    v10 = 0;
                                    while(true) {
                                        int v25 = v12;
                                        long v11 = v9[v10];
                                        v26 = v2_1;
                                        v27 = v3;
                                        if((~v11 << v21 & v11 & v22) != v22) {
                                            int v2_2 = 8 - (~(v10 - v25) >>> 0x1F);
                                            v3_1 = 0;
                                            while(v3_1 < v2_2) {
                                                if((v11 & v18) < v16) {
                                                    v4 = (v10 << 3) + v3_1;
                                                    Object v29 = v8_1[v4].get();
                                                    v30 = v3_1;
                                                    if(v29 != null) {
                                                        boolean v3_2 = ((LayoutNode)v29).isAttached();
                                                        v29_1 = v6;
                                                        if(v3_2) {
                                                            v6 = 1;
                                                        }
                                                        else {
                                                            goto label_73;
                                                        }
                                                    }
                                                    else {
                                                        v29_1 = v6;
                                                    label_73:
                                                        v6 = 0;
                                                    }

                                                    if(v6 != 0) {
                                                        goto label_79;
                                                    }

                                                    ((MutableScatterSet)v7_1).removeElementAt(v4);
                                                }
                                                else {
                                                    v30 = v3_1;
                                                    v29_1 = v6;
                                                }

                                            label_79:
                                                v11 >>= v24;
                                                v3_1 = v30 + 1;
                                                v6 = v29_1;
                                            }

                                            v29_1 = v6;
                                            if(v2_2 != v24) {
                                                break;
                                            }
                                        }
                                        else {
                                            v29_1 = v6;
                                        }

                                        v12 = v25;
                                        if(v10 == v12) {
                                            break;
                                        }

                                        ++v10;
                                        v2_1 = v26;
                                        v3 = v27;
                                        v6 = v29_1;
                                        v24 = 8;
                                    }
                                }
                                else {
                                    v26 = v2_1;
                                    v27 = v3;
                                    v29_1 = v6;
                                }

                                v3_1 = 8;
                            }
                            else {
                                v26 = v2_1;
                                v27 = ((long)v3_1);
                                v29_1 = v6;
                                v21 = v7;
                                v22 = v8;
                                v3_1 = v10;
                            }

                            v10 = v3_1;
                            v3 = v27 >> v3_1;
                            v7 = v21;
                            v8 = v22;
                            v6 = v29_1 + 1;
                            v2_1 = v26;
                        }

                        v26 = v2_1;
                        v21 = v7;
                        v22 = v8;
                        if(v5 != v10) {
                            break;
                        }
                    }
                    else {
                        v26 = v2_1;
                        v21 = v7;
                        v22 = v8;
                    }

                    if(v15 == v14) {
                        break;
                    }

                    ++v15;
                    v7 = v21;
                    v8 = v22;
                    v2_1 = v26;
                    v10 = 8;
                }
            }
            else {
                goto label_132;
            }
        }
        else {
        label_132:
            v21 = v7;
            v22 = v8;
            v16 = 0x80;
            v18 = 0xFF;
        }

        v2 = v0.rulerReaders;
        if(v2 != null) {
            long[] v3_3 = v2.metadata;
            v4 = v3_3.length - 2;
            if(v4 >= 0) {
                for(v5 = 0; true; ++v5) {
                    long v6_1 = v3_3[v5];
                    if((~v6_1 << v21 & v6_1 & v22) != v22) {
                        v10 = 8 - (~(v5 - v4) >>> 0x1F);
                        int v8_2;
                        for(v8_2 = 0; v8_2 < v10; ++v8_2) {
                            if((v6_1 & v18) < v16) {
                                int v9_1 = (v5 << 3) + v8_2;
                                if(v2.values[v9_1].isEmpty()) {
                                    v2.removeValueAt(v9_1);
                                }
                            }

                            v6_1 >>= 8;
                        }

                        if(v10 != 8) {
                            break;
                        }
                    }

                    if(v5 == v4) {
                        break;
                    }
                }
            }
        }

        v2 = v0.rulerReaders;
        DefaultConstructorMarker v3_4 = null;
        if(v2 == null) {
            v4 = 0;
            v6 = 1;
            v2 = new MutableScatterMap(0, 1, v3_4);
            v0.rulerReaders = v2;
        }
        else {
            v4 = 0;
            v6 = 1;
        }

        Object v0_1 = v2.get(v1);
        if(v0_1 == null) {
            v0_2 = new MutableScatterSet(v4, v6, v3_4);
            v2.set(v1, v0_2);
        }

        v0_2.plusAssign(new WeakReference(arg32));
    }

    public abstract int calculateAlignmentLine(AlignmentLine arg1);

    private final void captureRulers-OSxE8f4(PlaceableResult arg13, long arg14, long arg16) {
        MutableScatterMap v0 = this.rulerReaders;
        RulerTrackingMap v1 = this.rulerValues;
        if(v1 == null) {
            v1 = new RulerTrackingMap();
            this.rulerValues = v1;
        }

        Owner v2 = this.getLayoutNode().getOwner$ui();
        if(v2 != null) {
            OwnerSnapshotObserver v2_1 = v2.getSnapshotObserver();
            if(v2_1 != null) {
                OwnerSnapshotObserver.access$getObserver$p(v2_1).observeReads(arg13, LookaheadCapablePlaceable.onCommitAffectingRuler, new LookaheadCapablePlaceable$captureRulers$1(this, arg14, arg16, arg13));
            }
        }

        v1.notifyChanged(this.isLookingAhead(), this, v0);
    }

    static void captureRulers-OSxE8f4$default(LookaheadCapablePlaceable arg6, PlaceableResult arg7, long arg8, long arg10, int arg12, Object arg13) {
        if(arg13 == null) {
            if((arg12 & 2) != 0) {
                arg8 = IntOffset.Companion.getMax-nOcc-ac();
            }

            long v2 = arg8;
            if((arg12 & 4) != 0) {
                arg10 = IntSize.Companion.getZero-YbymL2g();
            }

            arg6.captureRulers-OSxE8f4(arg7, v2, arg10);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: captureRulers-OSxE8f4");
    }

    private final void captureRulersIfNeeded(PlaceableResult arg15) {
        Function1 v0;
        if(this.isPlacingForAlignment) {
        }
        else {
            v0 = arg15.getResult().getRulers();
            MutableScatterMap v1 = this.rulerReaders;
            if(v0 != null) {
                goto label_48;
            }
            else if(v1 != null) {
                Object[] v0_1 = v1.values;
                long[] v15 = v1.metadata;
                int v2 = v15.length - 2;
                if(v2 >= 0) {
                    int v4;
                    for(v4 = 0; true; ++v4) {
                        long v5 = v15[v4];
                        if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                            int v8 = 8;
                            int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                            int v9;
                            for(v9 = 0; v9 < v7; ++v9) {
                                if((0xFF & v5) < 0x80) {
                                    this.notifyRulerValueChange(v0_1[(v4 << 3) + v9]);
                                }

                                v5 >>= v8;
                            }

                            if(v7 != v8) {
                                break;
                            }
                        }

                        if(v4 == v2) {
                            break;
                        }
                    }
                }

                v1.clear();
            }
        }

        return;
    label_48:
        LookaheadCapablePlaceable.captureRulers-OSxE8f4$default(this, arg15, 0, 0, 6, null);
        this.rulersLambda = v0;
    }

    public final void captureRulersIfNeeded$ui(MeasureResult arg24) {
        int v20;
        int v5;
        int v4;
        long v17;
        long v2;
        long v15;
        int v13;
        LookaheadCapablePlaceable v0 = this;
        MeasureResult v6 = arg24;
        MutableScatterMap v1 = v0.rulerReaders;
        int v7 = 7;
        long v8 = -9187201950435737472L;
        int v10 = 8;
        int v11 = 0;
        if(v6 == null) {
            v20 = v7;
            v15 = 0x80;
            v17 = 0xFF;
            if(v1 != null) {
                Object[] v3_1 = v1.values;
                long[] v2_1 = v1.metadata;
                v4 = v2_1.length - 2;
                if(v4 >= 0) {
                    for(v5 = 0; true; ++v5) {
                        long v6_2 = v2_1[v5];
                        if((~v6_2 << v20 & v6_2 & v8) != v8) {
                            int v12_2 = 8 - (~(v5 - v4) >>> 0x1F);
                            for(v13 = 0; v13 < v12_2; ++v13) {
                                if((v6_2 & v17) < v15) {
                                    v0.notifyRulerValueChange(v3_1[(v5 << 3) + v13]);
                                }

                                v6_2 >>= v10;
                            }

                            if(v12_2 != v10) {
                                break;
                            }
                        }

                        if(v5 == v4) {
                            break;
                        }
                    }
                }
            }

            if(v1 != null) {
                v1.clear();
            }

            RulerTrackingMap v0_1 = v0.rulerValues;
            if(v0_1 == null) {
                return;
            }

            v0_1.clear();
        }
        else if(v0.isPlacingForAlignment) {
        }
        else {
            Function1 v12 = v6.getRulers();
            if(v12 != null) {
                int v1_1 = v0.rulersLambda != v12 ? 1 : 0;
                long v3 = IntOffset.Companion.getMax-nOcc-ac();
                long v7_1 = IntSize.Companion.getZero-YbymL2g();
                if(v1_1 == 0 && (v0.getRulerScope().getCoordinatesAccessed())) {
                    LayoutCoordinates v1_2 = v0.getCoordinates();
                    v3 = IntOffsetKt.round-k-4lQ0M(LayoutCoordinatesKt.positionOnScreen(v1_2));
                    v7_1 = v1_2.getSize-YbymL2g();
                    if(!IntOffset.equals-impl0(v3, v0.getRulerScope().getPositionOnScreen-nOcc-ac()) || !IntSize.equals-impl0(v7_1, v0.getRulerScope().getSize-YbymL2g())) {
                        v11 = 1;
                    }

                    v1_1 = v11;
                }

                v2 = v3;
                long v4_1 = v7_1;
                if(v1_1 == 0) {
                    return;
                }

                PlaceableResult v1_3 = v0.cachedRulerPlaceableResult;
                if(v1_3 != null) {
                    v1_3.setResult(v6);
                }
                else {
                    v1_3 = new PlaceableResult(v6, v0);
                    v0.cachedRulerPlaceableResult = v1_3;
                }

                v0.captureRulers-OSxE8f4(v1_3, v2, v4_1);
                v0.rulersLambda = v6.getRulers();
                return;
            }
            else if(v1 != null) {
                Object[] v12_1 = v1.values;
                long[] v6_1 = v1.metadata;
                v13 = v6_1.length - 2;
                if(v13 >= 0) {
                    int v14 = 0;
                    v15 = 0x80;
                    while(true) {
                        v2 = v6_1[v14];
                        v17 = 0xFF;
                        if((~v2 << v7 & v2 & v8) != v8) {
                            v4 = 8 - (~(v14 - v13) >>> 0x1F);
                            v5 = 0;
                            while(v5 < v4) {
                                if((v2 & v17) < v15) {
                                    v20 = v7;
                                    v0.notifyRulerValueChange(v12_1[(v14 << 3) + v5]);
                                }
                                else {
                                    v20 = v7;
                                }

                                v2 >>= v10;
                                ++v5;
                                v7 = v20;
                            }

                            v20 = v7;
                            if(v4 != v10) {
                                break;
                            }
                        }
                        else {
                            v20 = v7;
                        }

                        if(v14 == v13) {
                            break;
                        }

                        ++v14;
                        v7 = v20;
                    }
                }

                v1.clear();
                return;
            }
        }
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler arg3) {
        while(true) {
            RulerTrackingMap v0 = this.rulerValues;
            if(v0 != null && (v0.contains(arg3))) {
                return this;
            }

            LookaheadCapablePlaceable v0_1 = this.getParent();
            if(v0_1 == null) {
                return this;
            }

            this = v0_1;
        }
    }

    public final float findRulerValue(Ruler arg4, float arg5) {
        if(this.isPlacingForAlignment) {
            return arg5;
        }

        LookaheadCapablePlaceable v0;
        for(v0 = this; true; v0 = v1_1) {
            RulerTrackingMap v1 = v0.rulerValues;
            float v2 = NaNf;
            if(v1 != null) {
                v2 = v1.getOrDefault(arg4, v2);
            }

            if(!Float.isNaN(v2)) {
                v0.addRulerReader(this.getLayoutNode(), arg4);
                return arg4.calculateCoordinate$ui(v2, v0.getCoordinates(), this.getCoordinates());
            }

            LookaheadCapablePlaceable v1_1 = v0.getParent();
            if(v1_1 == null) {
                v0.addRulerReader(this.getLayoutNode(), arg4);
                return arg5;
            }
        }
    }

    public final int get(AlignmentLine arg3) {
        int v1 = 0x80000000;
        if(!this.getHasMeasureResult()) {
            return v1;
        }

        int v0 = this.calculateAlignmentLine(arg3);
        if(v0 == v1) {
            return v1;
        }

        int v2 = (arg3 instanceof VerticalAlignmentLine) ? IntOffset.getX-impl(this.getApparentToRealOffset-nOcc-ac()) : IntOffset.getY-impl(this.getApparentToRealOffset-nOcc-ac());
        return v0 + v2;
    }

    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui();

    public abstract LookaheadCapablePlaceable getParent();

    public final PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    public abstract long getPosition-nOcc-ac();

    private final ResettableRulerScope getRulerScope() {
        ResettableRulerScope v0 = this._rulerScope;
        if(v0 == null) {
            v0 = new ResettableRulerScope(this);
            this._rulerScope = v0;
        }

        return v0;
    }

    protected final void invalidateAlignmentLinesFromPositionChange(NodeCoordinator arg2) {
        NodeCoordinator v1 = arg2.getWrapped$ui();
        if(v1 != null) {
            LayoutNode v1_1 = v1.getLayoutNode();
        }
        else {
            Object v1_2 = null;
        }

        if(!Intrinsics.areEqual(v1_2, arg2.getLayoutNode())) {
            arg2.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }

        AlignmentLinesOwner v1_3 = arg2.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if(v1_3 != null) {
            AlignmentLines v1_4 = v1_3.getAlignmentLines();
            if(v1_4 != null) {
                v1_4.onAlignmentsChanged();
            }
        }
    }

    public final void invalidateChildrenOfDefiningRuler$ui(Ruler arg2) {
        MutableScatterMap v0 = this.findAncestorRulerDefiner(arg2).rulerReaders;
        Object v2 = v0 != null ? v0.remove(arg2) : null;
        if(v2 != null) {
            this.notifyRulerValueChange(((MutableScatterSet)v2));
        }
    }

    private final boolean isLayoutNodeAncestor(LayoutNode arg1, LayoutNode arg2) {
        if(arg1 == arg2) {
            return 1;
        }

        arg1 = arg1.getParent$ui();
        if(arg1 != null) {
            return this.isLayoutNodeAncestor(arg1, arg2);
        }

        return 0;
    }

    public boolean isLookingAhead() {
        return 0;
    }

    public boolean isPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    public final boolean isPlacingForAlignment$ui() {
        return this.isPlacingForAlignment;
    }

    public final boolean isShallowPlacing$ui() {
        return this.isShallowPlacing;
    }

    public MeasureResult layout(int arg9, int arg10, Map arg11, Function1 arg12, Function1 arg13) {
        int v0 = 0xFF000000;
        v0 = (arg9 & v0) != 0 || (v0 & arg10) != 0 ? 0 : 1;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + arg9 + " x " + arg10 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }

        return new LookaheadCapablePlaceable$layout$1(arg9, arg10, arg11, arg12, arg13, this);
    }

    private final void notifyRulerValueChange(MutableScatterSet arg14) {
        Object[] v0 = ((ScatterSet)arg14).elements;
        long[] v14 = ((ScatterSet)arg14).metadata;
        int v1 = v14.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v14[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            Object v9 = v0[(v3 << 3) + v8].get();
                            if(v9 != null) {
                                if(this.isLookingAhead()) {
                                    ((LayoutNode)v9).requestLookaheadRelayout$ui(false);
                                }
                                else {
                                    ((LayoutNode)v9).requestRelayout$ui(false);
                                }
                            }
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        return;
                    }
                }

                if(v3 == v1) {
                    return;
                }
            }
        }
    }

    public final void provideRelativeRulerValue(Ruler arg4, float arg5) {
        RulerTrackingMap v0 = this.rulerValues;
        if(v0 == null) {
            v0 = new RulerTrackingMap();
            this.rulerValues = v0;
        }

        if(this.getLayoutDirection() == LayoutDirection.Ltr) {
        }
        else {
            arg5 = (((float)this.getWidth())) - arg5;
        }

        v0.set(arg4, arg5);
    }

    public final void provideRulerValue(Ruler arg2, float arg3) {
        RulerTrackingMap v0 = this.rulerValues;
        if(v0 == null) {
            v0 = new RulerTrackingMap();
            this.rulerValues = v0;
        }

        v0.set(arg2, arg3);
    }

    public abstract void replace$ui();

    public void setPlacedUnderMotionFrameOfReference(boolean arg1) {
        this.isPlacedUnderMotionFrameOfReference = arg1;
    }

    public final void setPlacingForAlignment$ui(boolean arg1) {
        this.isPlacingForAlignment = arg1;
    }

    public final void setShallowPlacing$ui(boolean arg1) {
        this.isShallowPlacing = arg1;
    }

    public void updatePlacedUnderMotionFrameOfReference(boolean arg5) {
        LayoutNode v0_1;
        LookaheadCapablePlaceable v0 = this.getParent();
        LayoutState v1 = null;
        if(v0 != null) {
            v0_1 = v0.getLayoutNode();
        }
        else {
            Object v0_2 = v1;
        }

        if(Intrinsics.areEqual(v0_1, this.getLayoutNode())) {
            this.setPlacedUnderMotionFrameOfReference(arg5);
            return;
        }

        LayoutState v2 = v0_1 != null ? v0_1.getLayoutState$ui() : v1;
        if(v2 != LayoutState.LayingOut) {
            if(v0_1 != null) {
                v1 = v0_1.getLayoutState$ui();
            }

            if(v1 == LayoutState.LookaheadLayingOut) {
                goto label_23;
            }

            return;
        }

    label_23:
        this.setPlacedUnderMotionFrameOfReference(arg5);
    }
}

