package androidx.compose.ui.platform;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"Landroidx/compose/ui/platform/SemanticsNodeCopy;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "<init>", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/collection/IntObjectMap;)V", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "children", "Landroidx/collection/MutableIntSet;", "getChildren", "()Landroidx/collection/MutableIntSet;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SemanticsNodeCopy {
    public static final int $stable = 8;
    private final MutableIntSet children;
    private final SemanticsConfiguration unmergedConfig;

    static {
    }

    public SemanticsNodeCopy(SemanticsNode arg5, IntObjectMap arg6) {
        super();
        this.unmergedConfig = arg5.getUnmergedConfig$ui();
        this.children = new MutableIntSet(arg5.getReplacedChildren$ui().size());
        List v5 = arg5.getReplacedChildren$ui();
        int v0 = v5.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = v5.get(v1);
            if(arg6.containsKey(((SemanticsNode)v2).getId())) {
                this.children.add(((SemanticsNode)v2).getId());
            }
        }
    }

    public final MutableIntSet getChildren() {
        return this.children;
    }

    public final SemanticsConfiguration getUnmergedConfig() {
        return this.unmergedConfig;
    }
}

