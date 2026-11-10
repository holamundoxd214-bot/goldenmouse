package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Rect;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\u0002H\u0016¨\u0006\n"}, d2={"Landroidx/compose/ui/semantics/LtrBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "<init>", "()V", "compare", "", "a", "b", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class LtrBoundsComparator implements Comparator {
    public static final LtrBoundsComparator INSTANCE;

    static {
        LtrBoundsComparator.INSTANCE = new LtrBoundsComparator();
    }

    private LtrBoundsComparator() {
        super();
    }

    public int compare(SemanticsNode arg2, SemanticsNode arg3) {
        Rect v1 = arg2.getBoundsInWindow();
        Rect v2 = arg3.getBoundsInWindow();
        int v3 = Float.compare(v1.getLeft(), v2.getLeft());
        if(v3 != 0) {
            return v3;
        }

        v3 = Float.compare(v1.getTop(), v2.getTop());
        if(v3 != 0) {
            return v3;
        }

        v3 = Float.compare(v1.getBottom(), v2.getBottom());
        if(v3 != 0) {
            return v3;
        }

        return Float.compare(v1.getRight(), v2.getRight());
    }

    public int compare(Object arg1, Object arg2) {
        return this.compare(((SemanticsNode)arg1), ((SemanticsNode)arg2));
    }
}

