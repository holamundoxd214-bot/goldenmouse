package androidx.compose.ui.semantics;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u000026\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001j\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002`\u0006B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ<\u0010\t\u001A\u00020\n2\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0018\u0010\f\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0016¨\u0006\r"}, d2={"Landroidx/compose/ui/semantics/TopBottomBoundsComparator;", "Ljava/util/Comparator;", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "<init>", "()V", "compare", "", "a", "b", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class TopBottomBoundsComparator implements Comparator {
    public static final TopBottomBoundsComparator INSTANCE;

    static {
        TopBottomBoundsComparator.INSTANCE = new TopBottomBoundsComparator();
    }

    private TopBottomBoundsComparator() {
        super();
    }

    public int compare(Object arg1, Object arg2) {
        return this.compare(((Pair)arg1), ((Pair)arg2));
    }

    public int compare(Pair arg2, Pair arg3) {
        int v1 = Float.compare(arg2.getFirst().getTop(), arg3.getFirst().getTop());
        if(v1 != 0) {
            return v1;
        }

        return Float.compare(arg2.getFirst().getBottom(), arg3.getFirst().getBottom());
    }
}

