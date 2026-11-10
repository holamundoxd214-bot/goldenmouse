package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0006J\u000E\u0010\u000F\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0006J\u000E\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0006J\u0006\u0010\u0012\u001A\u00020\rJ\u0010\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\u0006H\u0002R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\bX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0016"}, d2={"Landroidx/compose/ui/node/OnPositionedDispatcher;", "", "<init>", "()V", "layoutNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "cachedNodes", "", "[Landroidx/compose/ui/node/LayoutNode;", "isNotEmpty", "", "onNodePositioned", "", "node", "remove", "onRootNodePositioned", "rootNode", "dispatch", "dispatchHierarchy", "layoutNode", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OnPositionedDispatcher {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/compose/ui/node/OnPositionedDispatcher$Companion;", "", "<init>", "()V", "MinArraySize", "", "DepthComparator", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\u0002H\u0016¨\u0006\n"}, d2={"Landroidx/compose/ui/node/OnPositionedDispatcher$Companion$DepthComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "<init>", "()V", "compare", "", "a", "b", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class DepthComparator implements Comparator {
            public static final DepthComparator INSTANCE;

            static {
                DepthComparator.INSTANCE = new DepthComparator();
            }

            private DepthComparator() {
                super();
            }

            public int compare(LayoutNode arg2, LayoutNode arg3) {
                int v1 = Intrinsics.compare(arg3.getDepth$ui(), arg2.getDepth$ui());
                if(v1 != 0) {
                    return v1;
                }

                return Intrinsics.compare(arg2.hashCode(), arg3.hashCode());
            }

            public int compare(Object arg1, Object arg2) {
                return this.compare(((LayoutNode)arg1), ((LayoutNode)arg2));
            }
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final int MinArraySize = 16;
    private LayoutNode[] cachedNodes;
    private final MutableVector layoutNodes;

    static {
        OnPositionedDispatcher.Companion = new Companion(null);
        OnPositionedDispatcher.$stable = 8;
    }

    public OnPositionedDispatcher() {
        super();
        this.layoutNodes = new MutableVector(new LayoutNode[16], 0);
    }

    public final void dispatch() {
        MutableVector v4;
        this.layoutNodes.sortWith(DepthComparator.INSTANCE);
        int v0 = this.layoutNodes.getSize();
        LayoutNode[] v1 = this.cachedNodes;
        if(v1 == null || v1.length < v0) {
            v1 = new LayoutNode[Math.max(16, this.layoutNodes.getSize())];
        }

        LayoutNode[] v2 = null;
        this.cachedNodes = v2;
        int v3;
        for(v3 = 0; true; ++v3) {
            v4 = this.layoutNodes;
            if(v3 >= v0) {
                break;
            }

            v1[v3] = v4.content[v3];
        }

        v4.clear();
        --v0;
        while(-1 < v0) {
            LayoutNode v3_1 = v1[v0];
            Intrinsics.checkNotNull(v3_1);
            if(v3_1.getNeedsOnGloballyPositionedDispatch$ui()) {
                this.dispatchHierarchy(v3_1);
            }

            v1[v0] = ((LayoutNode)v2);
            --v0;
        }

        this.cachedNodes = v1;
    }

    private final void dispatchHierarchy(LayoutNode arg4) {
        if(arg4.getGloballyPositionedObservers() > 0) {
            arg4.dispatchOnPositionedCallbacks$ui();
            int v0 = 0;
            arg4.setNeedsOnGloballyPositionedDispatch$ui(false);
            MutableVector v4 = arg4.get_children$ui();
            Object[] v1 = v4.content;
            int v4_1 = v4.getSize();
            while(v0 < v4_1) {
                this.dispatchHierarchy(v1[v0]);
                ++v0;
            }
        }
    }

    public final boolean isNotEmpty() {
        if(this.layoutNodes.getSize() != 0) {
            return 1;
        }

        return 0;
    }

    public final void onNodePositioned(LayoutNode arg2) {
        if(arg2.getGloballyPositionedObservers() > 0) {
            this.layoutNodes.add(arg2);
            arg2.setNeedsOnGloballyPositionedDispatch$ui(true);
        }
    }

    public final void onRootNodePositioned(LayoutNode arg2) {
        if(arg2.getGloballyPositionedObservers() > 0) {
            this.layoutNodes.clear();
            this.layoutNodes.add(arg2);
            arg2.setNeedsOnGloballyPositionedDispatch$ui(true);
        }
    }

    public final void remove(LayoutNode arg1) {
        this.layoutNodes.remove(arg1);
    }
}

