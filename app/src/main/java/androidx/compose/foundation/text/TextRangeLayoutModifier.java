package androidx.compose.foundation.text;

import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001A\u00020\u0000*\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2={"Landroidx/compose/foundation/text/TextRangeLayoutModifier;", "Landroidx/compose/ui/layout/ParentDataModifier;", "measurePolicy", "Landroidx/compose/foundation/text/TextRangeScopeMeasurePolicy;", "<init>", "(Landroidx/compose/foundation/text/TextRangeScopeMeasurePolicy;)V", "getMeasurePolicy", "()Landroidx/compose/foundation/text/TextRangeScopeMeasurePolicy;", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextRangeLayoutModifier implements ParentDataModifier {
    public static final int $stable;
    private final TextRangeScopeMeasurePolicy measurePolicy;

    static {
    }

    public TextRangeLayoutModifier(TextRangeScopeMeasurePolicy arg1) {
        super();
        this.measurePolicy = arg1;
    }

    public final TextRangeScopeMeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    public TextRangeLayoutModifier modifyParentData(Density arg1, Object arg2) {
        return this;
    }

    public Object modifyParentData(Density arg1, Object arg2) {
        return this.modifyParentData(arg1, arg2);
    }
}

