package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\bJ\u000E\u0010\r\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\bJ\u000E\u0010\u000F\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\bJ\u0006\u0010\u0010\u001A\u00020\bJ\u001F\u0010\u0011\u001A\u00020\u000E2\u0014\b\u0004\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000E0\u0013H\u0086\bJ\u0006\u0010\u0014\u001A\u00020\u0003J\t\u0010\u0015\u001A\u00020\u0003H\u0086\bJ\u000E\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u0017\u001A\u00020\u0018H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/compose/ui/node/DepthSortedSet;", "", "extraAssertions", "", "<init>", "(Z)V", "mapOfOriginalDepth", "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/node/LayoutNode;", "set", "Landroidx/compose/ui/node/SortedSet;", "contains", "node", "add", "", "remove", "pop", "popEach", "block", "Lkotlin/Function1;", "isEmpty", "isNotEmpty", "safeMapOfOriginalDepth", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DepthSortedSet {
    public static final int $stable = 8;
    private final boolean extraAssertions;
    private MutableObjectIntMap mapOfOriginalDepth;
    private final SortedSet set;

    static {
    }

    public DepthSortedSet(boolean arg2) {
        super();
        this.extraAssertions = arg2;
        this.set = new SortedSet(DepthSortedSetKt.access$getDepthComparator$p());
    }

    public final void add(LayoutNode arg4) {
        if(!arg4.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.add called on an unattached node");
        }

        if(this.extraAssertions) {
            MutableObjectIntMap v0 = this.safeMapOfOriginalDepth();
            int v2 = v0.getOrDefault(arg4, 0x7FFFFFFF);
            if(v2 == 0x7FFFFFFF) {
                v0.set(arg4, arg4.getDepth$ui());
            }
            else {
                int v0_1 = v2 == arg4.getDepth$ui() ? 1 : 0;
                if(v0_1 != 0) {
                    goto label_21;
                }

                InlineClassHelperKt.throwIllegalStateException("invalid node depth");
            }
        }

    label_21:
        this.set.add(arg4);
    }

    public final boolean contains(LayoutNode arg3) {
        boolean v0 = this.set.contains(arg3);
        if(this.extraAssertions) {
            int v2 = v0 == this.safeMapOfOriginalDepth().containsKey(arg3) ? 1 : 0;
            if(v2 != 0) {
                return v0;
            }

            InlineClassHelperKt.throwIllegalStateException("inconsistency in TreeSet");
        }

        return v0;
    }

    public final boolean isEmpty() {
        return this.set.isEmpty();
    }

    public final boolean isNotEmpty() {
        return this.isEmpty() ^ 1;
    }

    public final LayoutNode pop() {
        Object v0 = this.set.first();
        this.remove(((LayoutNode)v0));
        return ((LayoutNode)v0);
    }

    public final void popEach(Function1 arg2) {
        while(!this.isEmpty()) {
            arg2.invoke(this.pop());
        }
    }

    public final boolean remove(LayoutNode arg3) {
        if(!arg3.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.remove called on an unattached node");
        }

        boolean v0 = this.set.remove(arg3);
        if(this.extraAssertions) {
            MutableObjectIntMap v2 = this.safeMapOfOriginalDepth();
            if(v2.containsKey(arg3)) {
                int v1 = v2.get(arg3);
                v2.remove(arg3);
                int v2_1 = v0 ? arg3.getDepth$ui() : 0x7FFFFFFF;
                v2_1 = v1 == v2_1 ? 1 : 0;
                if(v2_1 != 0) {
                    return v0;
                }

                InlineClassHelperKt.throwIllegalStateException("invalid node depth");
            }
        }

        return v0;
    }

    private final MutableObjectIntMap safeMapOfOriginalDepth() {
        MutableObjectIntMap v0 = this.mapOfOriginalDepth;
        if(v0 == null) {
            v0 = ObjectIntMapKt.mutableObjectIntMapOf();
            this.mapOfOriginalDepth = v0;
        }

        Intrinsics.checkNotNull(v0);
        return v0;
    }

    public String toString() {
        return this.set.toString();
    }
}

