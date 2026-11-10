package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u000B\u001A\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\fH\u0016J.\u0010\u0015\u001A\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\fH\u0016J\u0010\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\u0010\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u001BH\u0016J\u0006\u0010\u001C\u001A\u00020\u0018J\u001E\u0010\u001D\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u001F2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00060\nH\u0016J\u0010\u0010!\u001A\u00020\u00182\u0006\u0010\u0012\u001A\u00020\u0013H\u0016R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2={"Landroidx/compose/ui/input/pointer/NodeParent;", "", "<init>", "()V", "children", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/Node;", "getChildren", "()Landroidx/compose/runtime/collection/MutableVector;", "removeMatchingPointerInputModifierNodeList", "Landroidx/collection/MutableObjectList;", "buildCache", "", "changes", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "dispatchMainEventPass", "dispatchFinalEventPass", "dispatchCancel", "", "removePointerInputModifierNode", "pointerInputModifierNode", "Landroidx/compose/ui/Modifier$Node;", "clear", "removeInvalidPointerIdsAndChanges", "pointerIdValue", "", "hitNodes", "cleanUpHits", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public class NodeParent {
    public static final int $stable = 8;
    private final MutableVector children;
    private final MutableObjectList removeMatchingPointerInputModifierNodeList;

    static {
    }

    public NodeParent() {
        super();
        this.children = new MutableVector(new Node[16], 0);
        this.removeMatchingPointerInputModifierNodeList = new MutableObjectList(10);
    }

    public boolean buildCache(LongSparseArray arg6, LayoutCoordinates arg7, InternalPointerEvent arg8, boolean arg9) {
        MutableVector v5 = this.children;
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        int v2 = 0;
        boolean v3 = false;
        while(v2 < v5_1) {
            v3 = (v0[v2].buildCache(arg6, arg7, arg8, arg9)) || (v3) ? true : false;
            ++v2;
        }

        return v3;
    }

    public void cleanUpHits(InternalPointerEvent arg2) {
        int v2;
        for(v2 = this.children.getSize() - 1; -1 < v2; --v2) {
            if(this.children.content[v2].getPointerIds().isEmpty()) {
                this.children.removeAt(v2);
            }
        }
    }

    public final void clear() {
        this.children.clear();
    }

    public void dispatchCancel() {
        MutableVector v3 = this.children;
        Object[] v0 = v3.content;
        int v3_1 = v3.getSize();
        int v1;
        for(v1 = 0; v1 < v3_1; ++v1) {
            v0[v1].dispatchCancel();
        }
    }

    public boolean dispatchFinalEventPass(InternalPointerEvent arg7) {
        MutableVector v0 = this.children;
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v3 = 0;
        boolean v4 = false;
        while(v3 < v0_1) {
            v4 = (v1[v3].dispatchFinalEventPass(arg7)) || (v4) ? true : false;
            ++v3;
        }

        this.cleanUpHits(arg7);
        return v4;
    }

    public boolean dispatchMainEventPass(LongSparseArray arg6, LayoutCoordinates arg7, InternalPointerEvent arg8, boolean arg9) {
        MutableVector v5 = this.children;
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        int v2 = 0;
        boolean v3 = false;
        while(v2 < v5_1) {
            v3 = (v0[v2].dispatchMainEventPass(arg6, arg7, arg8, arg9)) || (v3) ? true : false;
            ++v2;
        }

        return v3;
    }

    public final MutableVector getChildren() {
        return this.children;
    }

    public void removeInvalidPointerIdsAndChanges(long arg4, MutableObjectList arg6) {
        MutableVector v3 = this.children;
        Object[] v0 = v3.content;
        int v3_1 = v3.getSize();
        int v1;
        for(v1 = 0; v1 < v3_1; ++v1) {
            v0[v1].removeInvalidPointerIdsAndChanges(arg4, arg6);
        }
    }

    public void removePointerInputModifierNode(androidx.compose.ui.Modifier$Node arg5) {
        this.removeMatchingPointerInputModifierNodeList.clear();
        this.removeMatchingPointerInputModifierNodeList.add(this);
    label_4:
        if(this.removeMatchingPointerInputModifierNodeList.isNotEmpty()) {
            Object v0 = this.removeMatchingPointerInputModifierNodeList.removeAt(this.removeMatchingPointerInputModifierNodeList.getSize() - 1);
            int v1;
            for(v1 = 0; true; ++v1) {
            label_12:
                if(v1 >= ((NodeParent)v0).children.getSize()) {
                    goto label_4;
                }

                Object v2 = ((NodeParent)v0).children.content[v1];
                if(Intrinsics.areEqual(((Node)v2).getModifierNode(), arg5)) {
                    ((NodeParent)v0).children.remove(v2);
                    ((Node)v2).dispatchCancel();
                    goto label_12;
                }

                this.removeMatchingPointerInputModifierNodeList.add(v2);
            }
        }
    }
}

