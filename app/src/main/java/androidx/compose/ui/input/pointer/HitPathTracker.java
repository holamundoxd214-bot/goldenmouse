package androidx.compose.ui.input.pointer;

import androidx.collection.LongObjectMap;
import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\r0\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u0007¢\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001E\u001A\u00020\u00162\u0006\u0010\u001F\u001A\u00020\rH\u0002J\u001E\u0010 \u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020!2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00140\fH\u0002J\u0018\u0010#\u001A\u00020\u00072\u0006\u0010$\u001A\u00020%2\b\b\u0002\u0010&\u001A\u00020\u0007J\u0006\u0010\'\u001A\u00020\u0016J\u0006\u0010(\u001A\u00020\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u00020\u000FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"Landroidx/compose/ui/input/pointer/HitPathTracker;", "", "rootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "<init>", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "dispatchingEvent", "", "dispatchCancelAfterDispatchedEvent", "clearNodeCacheAfterDispatchedEvent", "removeSpecificNodesAfterDispatchedEvent", "nodesToRemove", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/Modifier$Node;", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui", "()Landroidx/compose/ui/input/pointer/NodeParent;", "hitPointerIdsAndNodesForPruningNonMatches", "Landroidx/collection/MutableLongObjectMap;", "Landroidx/compose/ui/input/pointer/Node;", "addHitPath", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerInputNodes", "", "prunePointerIdsAndChangesNotInNodesList", "addHitPath-QJqDSyo", "(JLjava/util/List;Z)V", "removePointerInputModifierNode", "pointerInputNode", "removeInvalidPointerIdsAndChanges", "", "hitNodes", "dispatchChanges", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "clearPreviouslyHitModifierNodeCache", "processCancel", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class HitPathTracker {
    public static final int $stable = 8;
    private boolean clearNodeCacheAfterDispatchedEvent;
    private boolean dispatchCancelAfterDispatchedEvent;
    private boolean dispatchingEvent;
    private final MutableLongObjectMap hitPointerIdsAndNodesForPruningNonMatches;
    private final MutableObjectList nodesToRemove;
    private boolean removeSpecificNodesAfterDispatchedEvent;
    private final NodeParent root;
    private final LayoutCoordinates rootCoordinates;

    static {
    }

    public HitPathTracker(LayoutCoordinates arg4) {
        super();
        this.rootCoordinates = arg4;
        this.nodesToRemove = new MutableObjectList(0, 1, null);
        this.root = new NodeParent();
        this.hitPointerIdsAndNodesForPruningNonMatches = new MutableLongObjectMap(10);
    }

    public static final void access$removePointerInputModifierNode(HitPathTracker arg0, Node arg1) {
        arg0.removePointerInputModifierNode(arg1);
    }

    public final void addHitPath-QJqDSyo(long arg18, List arg20, boolean arg21) {
        MutableObjectList v12_3;
        Object v15;
        int v12_1;
        HitPathTracker v0 = this;
        long v1 = arg18;
        List v3 = arg20;
        NodeParent v4 = v0.root;
        int v5 = v3.size();
        int v8 = 0;
        int v9 = 1;
        while(v8 < v5) {
            Object v10 = v3.get(v8);
            if(((Node)v10).isAttached()) {
                ((Node)v10).setDetachedListener$ui(new HitPathTracker$addHitPath$1(v0, ((Node)v10)));
                DefaultConstructorMarker v11 = null;
                if(v9 != 0) {
                    MutableVector v12 = v4.getChildren();
                    Object[] v13 = v12.content;
                    v12_1 = v12.getSize();
                    int v14 = 0;
                    while(true) {
                        if(v14 < v12_1) {
                            v15 = v13[v14];
                            if(Intrinsics.areEqual(v15.getModifierNode(), v10)) {
                            }
                            else {
                                ++v14;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_32;
                    }

                    v15 = v11;
                label_32:
                    if(v15 != null) {
                        ((androidx.compose.ui.input.pointer.Node)v15).markIsIn();
                        ((androidx.compose.ui.input.pointer.Node)v15).getPointerIds().add(v1);
                        if(arg21) {
                            MutableLongObjectMap v4_1 = v0.hitPointerIdsAndNodesForPruningNonMatches;
                            Object v6 = v4_1.get(v1);
                            if(v6 == null) {
                                MutableObjectList v6_1 = new MutableObjectList(0, 1, v11);
                                v4_1.set(v1, v6_1);
                            }

                            ((MutableObjectList)v6).add(v15);
                        }

                        Object v4_2 = v15;
                        goto label_70;
                    }

                    v9 = 0;
                }

                androidx.compose.ui.input.pointer.Node v6_2 = new androidx.compose.ui.input.pointer.Node(((Node)v10));
                v6_2.getPointerIds().add(v1);
                if(arg21) {
                    MutableLongObjectMap v10_1 = v0.hitPointerIdsAndNodesForPruningNonMatches;
                    Object v12_2 = v10_1.get(v1);
                    if(v12_2 == null) {
                        v12_3 = new MutableObjectList(0, 1, v11);
                        v10_1.set(v1, v12_3);
                    }

                    v12_3.add(v6_2);
                }

                v4.getChildren().add(v6_2);
                androidx.compose.ui.input.pointer.Node v4_3 = v6_2;
            }

        label_70:
            ++v8;
        }

        if(arg21) {
            MutableLongObjectMap v1_1 = v0.hitPointerIdsAndNodesForPruningNonMatches;
            long[] v2 = ((LongObjectMap)v1_1).keys;
            Object[] v3_1 = ((LongObjectMap)v1_1).values;
            long[] v1_2 = ((LongObjectMap)v1_1).metadata;
            int v4_4 = v1_2.length - 2;
            if(v4_4 >= 0) {
                for(v5 = 0; true; ++v5) {
                    long v8_1 = v1_2[v5];
                    if((~v8_1 << 7 & v8_1 & -9187201950435737472L) != -9187201950435737472L) {
                        int v10_2 = 8;
                        int v6_3 = 8 - (~(v5 - v4_4) >>> 0x1F);
                        int v11_1;
                        for(v11_1 = 0; v11_1 < v6_3; ++v11_1) {
                            if((0xFF & v8_1) < 0x80) {
                                v12_1 = (v5 << 3) + v11_1;
                                v0.removeInvalidPointerIdsAndChanges(v2[v12_1], v3_1[v12_1]);
                            }

                            v8_1 >>= v10_2;
                        }

                        if(v6_3 != v10_2) {
                            break;
                        }
                    }

                    if(v5 == v4_4) {
                        break;
                    }
                }
            }
        }

        v0.hitPointerIdsAndNodesForPruningNonMatches.clear();
    }

    public static void addHitPath-QJqDSyo$default(HitPathTracker arg0, long arg1, List arg3, boolean arg4, int arg5, Object arg6) {
        arg0.addHitPath-QJqDSyo(arg1, arg3, false);
    }

    public final void clearPreviouslyHitModifierNodeCache() {
        if(this.clearNodeCacheAfterDispatchedEvent) {
            this.clearNodeCacheAfterDispatchedEvent = true;
            return;
        }

        this.root.clear();
    }

    public final boolean dispatchChanges(InternalPointerEvent arg6, boolean arg7) {
        MutableObjectList v2;
        if(!this.root.buildCache(arg6.getChanges(), this.rootCoordinates, arg6, arg7)) {
            return 0;
        }

        boolean v0 = true;
        this.dispatchingEvent = true;
        arg7 = this.root.dispatchMainEventPass(arg6.getChanges(), this.rootCoordinates, arg6, arg7);
        if(!this.root.dispatchFinalEventPass(arg6)) {
            if(arg7) {
            }
            else {
                v0 = false;
            }
        }

        this.dispatchingEvent = false;
        if(this.removeSpecificNodesAfterDispatchedEvent) {
            this.removeSpecificNodesAfterDispatchedEvent = false;
            int v6 = this.nodesToRemove.getSize();
            int v7;
            for(v7 = 0; true; ++v7) {
                v2 = this.nodesToRemove;
                if(v7 >= v6) {
                    break;
                }

                this.removePointerInputModifierNode(v2.get(v7));
            }

            v2.clear();
        }

        if(this.dispatchCancelAfterDispatchedEvent) {
            this.dispatchCancelAfterDispatchedEvent = false;
            this.processCancel();
        }

        if(this.clearNodeCacheAfterDispatchedEvent) {
            this.clearNodeCacheAfterDispatchedEvent = false;
            this.clearPreviouslyHitModifierNodeCache();
        }

        return v0;
    }

    public static boolean dispatchChanges$default(HitPathTracker arg0, InternalPointerEvent arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.dispatchChanges(arg1, true);
    }

    public final NodeParent getRoot$ui() {
        return this.root;
    }

    public final void processCancel() {
        if(this.dispatchingEvent) {
            this.dispatchCancelAfterDispatchedEvent = true;
            return;
        }

        this.root.dispatchCancel();
        this.clearPreviouslyHitModifierNodeCache();
    }

    private final void removeInvalidPointerIdsAndChanges(long arg1, MutableObjectList arg3) {
        this.root.removeInvalidPointerIdsAndChanges(arg1, arg3);
    }

    private final void removePointerInputModifierNode(Node arg2) {
        if(this.dispatchingEvent) {
            this.removeSpecificNodesAfterDispatchedEvent = true;
            this.nodesToRemove.add(arg2);
            return;
        }

        this.root.removePointerInputModifierNode(arg2);
    }
}

