package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00000\u001CH\u0016J.\u0010\u001D\u001A\u00020\u00142\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u000E0\r2\u0006\u0010\u001F\u001A\u00020\u00102\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u0014H\u0016J\u0010\u0010#\u001A\u00020\u00142\u0006\u0010 \u001A\u00020!H\u0016J.\u0010$\u001A\u00020\u00142\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u000E0\r2\u0006\u0010\u001F\u001A\u00020\u00102\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u0014H\u0016J\u001A\u0010%\u001A\u00020\u00142\b\u0010&\u001A\u0004\u0018\u00010\u00122\u0006\u0010\'\u001A\u00020\u0012H\u0002J\b\u0010(\u001A\u00020\u0018H\u0002J\u0017\u0010)\u001A\u00020\u00142\f\u0010*\u001A\b\u0012\u0004\u0012\u00020\u00180+H\u0082\bJ\b\u0010,\u001A\u00020\u0018H\u0016J\u0006\u0010-\u001A\u00020\u0018J\u0010\u0010.\u001A\u00020\u00182\u0006\u0010 \u001A\u00020!H\u0016J\b\u0010/\u001A\u000200H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00061"}, d2={"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "<init>", "(Landroidx/compose/ui/Modifier$Node;)V", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "wasIn", "", "isIn", "hasExited", "removeInvalidPointerIdsAndChanges", "", "pointerIdValue", "", "hitNodes", "Landroidx/collection/MutableObjectList;", "dispatchMainEventPass", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "dispatchFinalEventPass", "buildCache", "hasPositionChanged", "oldEvent", "newEvent", "clearCache", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchCancel", "markIsIn", "cleanUpHits", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Node extends NodeParent {
    public static final int $stable = 8;
    private LayoutCoordinates coordinates;
    private boolean hasExited;
    private boolean isIn;
    private final androidx.compose.ui.Modifier$Node modifierNode;
    private PointerEvent pointerEvent;
    private final PointerIdArray pointerIds;
    private final LongSparseArray relevantChanges;
    private boolean wasIn;

    static {
    }

    public Node(androidx.compose.ui.Modifier$Node arg2) {
        super();
        this.modifierNode = arg2;
        this.pointerIds = new PointerIdArray();
        this.relevantChanges = new LongSparseArray(2);
        this.isIn = true;
        this.hasExited = true;
    }

    public boolean buildCache(LongSparseArray arg46, LayoutCoordinates arg47, InternalPointerEvent arg48, boolean arg49) {
        boolean v1_3;
        Object v9;
        int v44;
        int v35;
        int v4_1;
        boolean v34;
        boolean v33;
        Node v0 = this;
        LongSparseArray v1 = arg46;
        LayoutCoordinates v2 = arg47;
        InternalPointerEvent v3 = arg48;
        boolean v4 = super.buildCache(arg46, arg47, arg48, arg49);
        boolean v6 = true;
        if(!v0.modifierNode.isAttached()) {
            return 1;
        }

        androidx.compose.ui.Modifier$Node v5 = v0.modifierNode;
        int v7 = 16;
        int v8 = NodeKind.constructor-impl(v7);
        MutableVector v10 = null;
        while(true) {
        label_14:
            if(v5 == null) {
                goto label_53;
            }

            if((v5 instanceof PointerInputModifierNode)) {
                v0.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates(((PointerInputModifierNode)v5));
            }
            else if((v5.getKindSet$ui() & v8) != 0 && ((v5 instanceof DelegatingNode))) {
                androidx.compose.ui.Modifier$Node v12 = v5.getDelegate$ui();
                int v13 = 0;
                while(v12 != null) {
                    if((v12.getKindSet$ui() & v8) != 0) {
                        ++v13;
                        if(v13 == 1) {
                            v5 = v12;
                        }
                        else {
                            if(v10 == null) {
                                v10 = new MutableVector(new androidx.compose.ui.Modifier$Node[v7], 0);
                            }

                            if(v5 != null) {
                                if(v10 != null) {
                                    v10.add(v5);
                                }

                                v5 = null;
                            }

                            if(v10 == null) {
                                goto label_47;
                            }

                            v10.add(v12);
                        }
                    }

                label_47:
                    v12 = v12.getChild$ui();
                }

                if(v13 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v5 = DelegatableNodeKt.access$pop(v10);
        goto label_14;
    label_53:
        if(v0.coordinates == null) {
            return 1;
        }

        int v5_1 = v1.size();
        v7 = 0;
        while(v7 < v5_1) {
            long v12_1 = v1.keyAt(v7);
            Object v14 = v1.valueAt(v7);
            if(v0.pointerIds.contains(v12_1)) {
                boolean v8_1 = v6;
                int v10_1 = v7;
                long v6_1 = ((PointerInputChange)v14).getPreviousPosition-F1C5BW0();
                v33 = v8_1;
                long v8_2 = ((PointerInputChange)v14).getPosition-F1C5BW0();
                long v15 = 0x7FFFFFFF7FFFFFFFL;
                long v19 = 0x7FFFFF007FFFFFL;
                long v21 = -9223372034707292160L;
                long v23 = 0;
                if(((v6_1 & v15) + v19 & v21) == v23 && ((v8_2 & v15) + v19 & v21) == v23) {
                    long v17 = v15;
                    ArrayList v15_1 = new ArrayList(((PointerInputChange)v14).getHistorical().size());
                    List v11 = ((PointerInputChange)v14).getHistorical();
                    v34 = v4;
                    v4_1 = v11.size();
                    v35 = v5_1;
                    v5_1 = 0;
                    while(v5_1 < v4_1) {
                        Object v16 = v11.get(v5_1);
                        int v25 = v4_1;
                        int v26 = v5_1;
                        long v4_2 = ((HistoricalChange)v16).getPosition-F1C5BW0();
                        if(((v4_2 & v17) + v19 & v21) == v23) {
                            long v37 = ((HistoricalChange)v16).getUptimeMillis();
                            v44 = v10_1;
                            LayoutCoordinates v10_2 = v0.coordinates;
                            Intrinsics.checkNotNull(v10_2);
                            v15_1.add(new HistoricalChange(v37, v10_2.localPositionOf-R5De75A(v2, v4_2), ((HistoricalChange)v16).getOriginalEventPosition-F1C5BW0$ui(), null));
                        }
                        else {
                            v44 = v10_1;
                        }

                        v5_1 = v26 + 1;
                        v4_1 = v25;
                        v10_1 = v44;
                    }

                    v44 = v10_1;
                    LongSparseArray v4_3 = v0.relevantChanges;
                    LayoutCoordinates v5_2 = v0.coordinates;
                    Intrinsics.checkNotNull(v5_2);
                    long v24 = v5_2.localPositionOf-R5De75A(v2, v6_1);
                    v5_2 = v0.coordinates;
                    Intrinsics.checkNotNull(v5_2);
                    v4_3.put(v12_1, PointerInputChange.copy-OHpmEuE$default(((PointerInputChange)v14), 0, 0, v5_2.localPositionOf-R5De75A(v2, v8_2), false, 0, v24, false, 0, v15_1, 0, 731, null));
                    goto label_148;
                }

                v34 = v4;
                v35 = v5_1;
                v44 = v10_1;
            }
            else {
                v34 = v4;
                v35 = v5_1;
                v33 = v6;
                v44 = v7;
            }

        label_148:
            v7 = v44 + 1;
            v6 = v33;
            v4 = v34;
            v5_1 = v35;
        }

        v34 = v4;
        v33 = v6;
        boolean v2_1 = v0.relevantChanges.isEmpty();
        PointerIdArray v4_4 = v0.pointerIds;
        if(v2_1) {
            v4_4.clear();
            v0.getChildren().clear();
            return v33;
        }

        int v2_2;
        for(v2_2 = v4_4.getSize() - 1; -1 < v2_2; --v2_2) {
            if(!v1.containsKey(v0.pointerIds.get-_I2yYro(v2_2))) {
                v0.pointerIds.removeAt(v2_2);
            }
        }

        ArrayList v1_1 = new ArrayList(v0.relevantChanges.size());
        v2_2 = v0.relevantChanges.size();
        for(v4_1 = 0; v4_1 < v2_2; ++v4_1) {
            v1_1.add(v0.relevantChanges.valueAt(v4_1));
        }

        PointerEvent v2_3 = new PointerEvent(((List)v1_1), v3);
        List v1_2 = v2_3.getChanges();
        v4_1 = v1_2.size();
        v5_1 = 0;
        while(true) {
            if(v5_1 < v4_1) {
                Object v6_2 = v1_2.get(v5_1);
                if(v3.activeHoverEvent-0FcD4WY(v6_2.getId-J3iCeTQ())) {
                    v9 = v6_2;
                }
                else {
                    ++v5_1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_206;
        }

        v9 = null;
    label_206:
        if(v9 != null) {
            if(!arg49) {
                v1_3 = false;
                v0.isIn = false;
            }
            else {
                v1_3 = false;
                if(!v0.isIn) {
                    if(!((PointerInputChange)v9).getPressed() && !((PointerInputChange)v9).getPreviousPressed()) {
                        goto label_224;
                    }

                    LayoutCoordinates v3_1 = v0.coordinates;
                    Intrinsics.checkNotNull(v3_1);
                    v0.isIn = PointerEventKt.isOutOfBounds-O0kMr_c(((PointerInputChange)v9), v3_1.getSize-YbymL2g()) ^ 1;
                }
            }

        label_224:
            if(v0.isIn != v0.wasIn && ((PointerEventType.equals-impl0(v2_3.getType-7fucELk(), PointerEventType.Companion.getMove-7fucELk())) || (PointerEventType.equals-impl0(v2_3.getType-7fucELk(), PointerEventType.Companion.getEnter-7fucELk())) || (PointerEventType.equals-impl0(v2_3.getType-7fucELk(), PointerEventType.Companion.getExit-7fucELk())))) {
                int v3_2 = v0.isIn ? PointerEventType.Companion.getEnter-7fucELk() : PointerEventType.Companion.getExit-7fucELk();
                v2_3.setType-EhbLWgg$ui(v3_2);
                goto label_278;
            }

            if((PointerEventType.equals-impl0(v2_3.getType-7fucELk(), PointerEventType.Companion.getEnter-7fucELk())) && (v0.wasIn) && !v0.hasExited) {
                v2_3.setType-EhbLWgg$ui(PointerEventType.Companion.getMove-7fucELk());
                goto label_278;
            }

            if(!PointerEventType.equals-impl0(v2_3.getType-7fucELk(), PointerEventType.Companion.getExit-7fucELk())) {
                goto label_278;
            }

            if(!v0.isIn) {
                goto label_278;
            }

            if(!((PointerInputChange)v9).getPressed()) {
                goto label_278;
            }

            v2_3.setType-EhbLWgg$ui(PointerEventType.Companion.getMove-7fucELk());
        }
        else {
            v1_3 = false;
        }

    label_278:
        v6 = (v34) || !PointerEventType.equals-impl0(v2_3.getType-7fucELk(), PointerEventType.Companion.getMove-7fucELk()) || (v0.hasPositionChanged(v0.pointerEvent, v2_3)) ? v33 : v1_3;
        v0.pointerEvent = v2_3;
        return v6;
    }

    public void cleanUpHits(InternalPointerEvent arg10) {
        super.cleanUpHits(arg10);
        PointerEvent v0 = this.pointerEvent;
        if(v0 == null) {
            return;
        }

        this.wasIn = this.isIn;
        List v1 = v0.getChanges();
        int v2 = v1.size();
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            Object v5 = v1.get(v4);
            boolean v6 = ((PointerInputChange)v5).getPressed();
            boolean v7 = arg10.activeHoverEvent-0FcD4WY(((PointerInputChange)v5).getId-J3iCeTQ());
            boolean v8 = this.isIn;
            if(!v6 && !v7 || !v6 && !v8) {
                this.pointerIds.remove(((PointerInputChange)v5).getId-J3iCeTQ());
            }
        }

        this.isIn = false;
        this.hasExited = PointerEventType.equals-impl0(v0.getType-7fucELk(), PointerEventType.Companion.getExit-7fucELk());
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    public void dispatchCancel() {
        MutableVector v0 = this.getChildren();
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v3;
        for(v3 = 0; v3 < v0_1; ++v3) {
            v1[v3].dispatchCancel();
        }

        androidx.compose.ui.Modifier$Node v9 = this.modifierNode;
        v0_1 = 16;
        int v1_1 = NodeKind.constructor-impl(v0_1);
        androidx.compose.ui.Modifier$Node v3_1 = null;
        MutableVector v4 = ((MutableVector)v3_1);
        while(true) {
        label_15:
            if(v9 == null) {
                return;
            }

            if((v9 instanceof PointerInputModifierNode)) {
                ((PointerInputModifierNode)v9).onCancelPointerInput();
            }
            else if((v9.getKindSet$ui() & v1_1) != 0 && ((v9 instanceof DelegatingNode))) {
                androidx.compose.ui.Modifier$Node v5 = v9.getDelegate$ui();
                int v6 = 0;
                while(v5 != null) {
                    if((v5.getKindSet$ui() & v1_1) != 0) {
                        ++v6;
                        if(v6 == 1) {
                            v9 = v5;
                        }
                        else {
                            if(v4 == null) {
                                v4 = new MutableVector(new androidx.compose.ui.Modifier$Node[v0_1], 0);
                            }

                            if(v9 != null) {
                                if(v4 != null) {
                                    v4.add(v9);
                                }

                                v9 = v3_1;
                            }

                            if(v4 == null) {
                                goto label_47;
                            }

                            v4.add(v5);
                        }
                    }

                label_47:
                    v5 = v5.getChild$ui();
                }

                if(v6 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v9 = DelegatableNodeKt.access$pop(v4);
        goto label_15;
    }

    public boolean dispatchFinalEventPass(InternalPointerEvent arg14) {
        boolean v1_1;
        int v1 = 0;
        if(this.relevantChanges.isEmpty()) {
        }
        else if(!this.modifierNode.isAttached()) {
        }
        else {
            PointerEvent v0 = this.pointerEvent;
            Intrinsics.checkNotNull(v0);
            LayoutCoordinates v2 = this.coordinates;
            Intrinsics.checkNotNull(v2);
            long v2_1 = v2.getSize-YbymL2g();
            androidx.compose.ui.Modifier$Node v4 = this.modifierNode;
            int v5 = 16;
            int v6 = NodeKind.constructor-impl(v5);
            androidx.compose.ui.Modifier$Node v7 = null;
            MutableVector v8 = ((MutableVector)v7);
            while(true) {
            label_19:
                if(v4 != null) {
                    if((v4 instanceof PointerInputModifierNode)) {
                        ((PointerInputModifierNode)v4).onPointerEvent-H0pRuoY(v0, PointerEventPass.Final, v2_1);
                    }
                    else if((v4.getKindSet$ui() & v6) != 0 && ((v4 instanceof DelegatingNode))) {
                        androidx.compose.ui.Modifier$Node v10 = v4.getDelegate$ui();
                        int v11 = 0;
                        while(v10 != null) {
                            if((v10.getKindSet$ui() & v6) != 0) {
                                ++v11;
                                if(v11 == 1) {
                                    v4 = v10;
                                }
                                else {
                                    if(v8 == null) {
                                        v8 = new MutableVector(new androidx.compose.ui.Modifier$Node[v5], 0);
                                    }

                                    if(v4 != null) {
                                        if(v8 != null) {
                                            v8.add(v4);
                                        }

                                        v4 = v7;
                                    }

                                    if(v8 == null) {
                                        goto label_52;
                                    }

                                    v8.add(v10);
                                }
                            }

                        label_52:
                            v10 = v10.getChild$ui();
                        }

                        if(v11 != 1) {
                            break;
                        }

                        continue;
                    }

                    break;
                }
                else {
                    goto label_58;
                }
            }

            v4 = DelegatableNodeKt.access$pop(v8);
            goto label_19;
        label_58:
            if(this.modifierNode.isAttached()) {
                MutableVector v0_1 = this.getChildren();
                Object[] v2_2 = v0_1.content;
                int v0_2 = v0_1.getSize();
                while(v1 < v0_2) {
                    v2_2[v1].dispatchFinalEventPass(arg14);
                    ++v1;
                }
            }

            v1_1 = true;
        }

        this.cleanUpHits(arg14);
        this.clearCache();
        return v1_1;
    }

    private final boolean dispatchIfNeeded(Function0 arg3) {
        if(this.relevantChanges.isEmpty()) {
            return 0;
        }

        if(!this.modifierNode.isAttached()) {
            return 0;
        }

        arg3.invoke();
        return 1;
    }

    public boolean dispatchMainEventPass(LongSparseArray arg12, LayoutCoordinates arg13, InternalPointerEvent arg14, boolean arg15) {
        if(this.relevantChanges.isEmpty()) {
            return 0;
        }

        if(!this.modifierNode.isAttached()) {
            return 0;
        }

        PointerEvent v12 = this.pointerEvent;
        Intrinsics.checkNotNull(v12);
        LayoutCoordinates v0 = this.coordinates;
        Intrinsics.checkNotNull(v0);
        long v0_1 = v0.getSize-YbymL2g();
        androidx.compose.ui.Modifier$Node v2 = this.modifierNode;
        int v3 = 16;
        int v4 = NodeKind.constructor-impl(v3);
        androidx.compose.ui.Modifier$Node v5 = null;
        MutableVector v6 = ((MutableVector)v5);
        while(true) {
        label_19:
            if(v2 == null) {
                goto label_58;
            }

            if((v2 instanceof PointerInputModifierNode)) {
                ((PointerInputModifierNode)v2).onPointerEvent-H0pRuoY(v12, PointerEventPass.Initial, v0_1);
            }
            else if((v2.getKindSet$ui() & v4) != 0 && ((v2 instanceof DelegatingNode))) {
                androidx.compose.ui.Modifier$Node v8 = v2.getDelegate$ui();
                int v9 = 0;
                while(v8 != null) {
                    if((v8.getKindSet$ui() & v4) != 0) {
                        ++v9;
                        if(v9 == 1) {
                            v2 = v8;
                        }
                        else {
                            if(v6 == null) {
                                v6 = new MutableVector(new androidx.compose.ui.Modifier$Node[v3], 0);
                            }

                            if(v2 != null) {
                                if(v6 != null) {
                                    v6.add(v2);
                                }

                                v2 = v5;
                            }

                            if(v6 == null) {
                                goto label_52;
                            }

                            v6.add(v8);
                        }
                    }

                label_52:
                    v8 = v8.getChild$ui();
                }

                if(v9 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v2 = DelegatableNodeKt.access$pop(v6);
        goto label_19;
    label_58:
        if(this.modifierNode.isAttached()) {
            MutableVector v2_1 = this.getChildren();
            Object[] v4_1 = v2_1.content;
            int v2_2 = v2_1.getSize();
            int v6_1;
            for(v6_1 = 0; v6_1 < v2_2; ++v6_1) {
                Object v8_1 = v4_1[v6_1];
                LongSparseArray v9_1 = this.relevantChanges;
                LayoutCoordinates v10 = this.coordinates;
                Intrinsics.checkNotNull(v10);
                ((Node)v8_1).dispatchMainEventPass(v9_1, v10, arg14, arg15);
            }
        }

        if(this.modifierNode.isAttached()) {
            androidx.compose.ui.Modifier$Node v11 = this.modifierNode;
            int v14 = NodeKind.constructor-impl(v3);
            MutableVector v15 = ((MutableVector)v5);
            while(true) {
            label_79:
                if(v11 != null) {
                    if((v11 instanceof PointerInputModifierNode)) {
                        ((PointerInputModifierNode)v11).onPointerEvent-H0pRuoY(v12, PointerEventPass.Main, v0_1);
                    }
                    else if((v11.getKindSet$ui() & v14) != 0 && ((v11 instanceof DelegatingNode))) {
                        v2 = v11.getDelegate$ui();
                        v4 = 0;
                        while(v2 != null) {
                            if((v2.getKindSet$ui() & v14) != 0) {
                                ++v4;
                                if(v4 == 1) {
                                    v11 = v2;
                                }
                                else {
                                    if(v15 == null) {
                                        v15 = new MutableVector(new androidx.compose.ui.Modifier$Node[v3], 0);
                                    }

                                    if(v11 != null) {
                                        if(v15 != null) {
                                            v15.add(v11);
                                        }

                                        v11 = v5;
                                    }

                                    if(v15 == null) {
                                        goto label_111;
                                    }

                                    v15.add(v2);
                                }
                            }

                        label_111:
                            v2 = v2.getChild$ui();
                        }

                        if(v4 != 1) {
                            break;
                        }

                        continue;
                    }

                    break;
                }

                return 1;
            }

            v11 = DelegatableNodeKt.access$pop(v15);
            goto label_79;
        }

        return 1;
    }

    public final androidx.compose.ui.Modifier$Node getModifierNode() {
        return this.modifierNode;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    private final boolean hasPositionChanged(PointerEvent arg8, PointerEvent arg9) {
        if(arg8 != null) {
            if(arg8.getChanges().size() != arg9.getChanges().size()) {
            }
            else {
                int v0 = arg9.getChanges().size();
                int v2 = 0;
                while(true) {
                    if(v2 >= v0) {
                        return 0;
                    }
                    else if(!Offset.equals-impl0(arg8.getChanges().get(v2).getPosition-F1C5BW0(), arg9.getChanges().get(v2).getPosition-F1C5BW0())) {
                        return 1;
                    }
                    else {
                        ++v2;
                        continue;
                    }

                    return 1;
                }

                return 0;
            }
        }

        return 1;
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    public void removeInvalidPointerIdsAndChanges(long arg4, MutableObjectList arg6) {
        if((this.pointerIds.contains(arg4)) && !arg6.contains(this)) {
            this.pointerIds.remove(arg4);
            this.relevantChanges.remove(arg4);
        }

        MutableVector v3 = this.getChildren();
        Object[] v0 = v3.content;
        int v3_1 = v3.getSize();
        int v1;
        for(v1 = 0; v1 < v3_1; ++v1) {
            v0[v1].removeInvalidPointerIdsAndChanges(arg4, arg6);
        }
    }

    public String toString() {
        return "Node(modifierNode=" + this.modifierNode + ", children=" + this.getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }
}

