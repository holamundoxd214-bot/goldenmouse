package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\u0002H\u0016J\u0016\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\r\u001A\u00020\fH\u0002¨\u0006\u000E"}, d2={"Landroidx/compose/ui/focus/FocusableChildrenComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/focus/FocusTargetNode;", "Lkotlin/Comparator;", "<init>", "()V", "compare", "", "a", "b", "pathFromRoot", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusableChildrenComparator implements Comparator {
    public static final FocusableChildrenComparator INSTANCE;

    static {
        FocusableChildrenComparator.INSTANCE = new FocusableChildrenComparator();
    }

    private FocusableChildrenComparator() {
        super();
    }

    public int compare(FocusTargetNode arg4, FocusTargetNode arg5) {
        int v1 = 0;
        if(FocusTraversalKt.isEligibleForFocusSearch(arg4)) {
            if(!FocusTraversalKt.isEligibleForFocusSearch(arg5)) {
            }
            else {
                LayoutNode v4 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg4));
                LayoutNode v5 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg5));
                if(Intrinsics.areEqual(v4, v5)) {
                    return 0;
                }
                else {
                    MutableVector v4_1 = this.pathFromRoot(v4);
                    MutableVector v3 = this.pathFromRoot(v5);
                    int v5_1 = Math.min(v4_1.getSize() - 1, v3.getSize() - 1);
                    if(v5_1 >= 0) {
                        while(true) {
                            if(!Intrinsics.areEqual(v4_1.content[v1], v3.content[v1])) {
                                break;
                            }
                            else if(v1 != v5_1) {
                                ++v1;
                                continue;
                            }

                            goto label_37;
                        }

                        return Intrinsics.compare(v4_1.content[v1].getPlaceOrder$ui(), v3.content[v1].getPlaceOrder$ui());
                    }

                label_37:
                    throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.".toString());
                }
            }
        }

        if(FocusTraversalKt.isEligibleForFocusSearch(arg4)) {
            return -1;
        }

        if(FocusTraversalKt.isEligibleForFocusSearch(arg5)) {
            return 1;
        }

        return 0;
    }

    public int compare(Object arg1, Object arg2) {
        return this.compare(((FocusTargetNode)arg1), ((FocusTargetNode)arg2));
    }

    private final MutableVector pathFromRoot(LayoutNode arg3) {
        MutableVector v2 = new MutableVector(new LayoutNode[16], 0);
        while(arg3 != null) {
            v2.add(0, arg3);
            arg3 = arg3.getParent$ui();
        }

        return v2;
    }
}

