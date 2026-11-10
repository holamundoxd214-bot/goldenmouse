package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0012\u001A\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\u0015\u0010\u0016\u001A\u00020\u0013*\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u0018H\u0097\u0001J\u0015\u0010\u0019\u001A\u00020\u0013*\u00020\u00132\u0006\u0010\u001A\u001A\u00020\u001BH\u0097\u0001J!\u0010\u0019\u001A\u00020\u0013*\u00020\u00132\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\u00040\u001DH\u0097\u0001J\u001F\u0010\u001F\u001A\u00020\u0013*\u00020\u00132\b\b\u0001\u0010\u001F\u001A\u00020\u00152\u0006\u0010 \u001A\u00020!H\u0097\u0001R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\u0005\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0016\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000FR\u0016\u0010\b\u001A\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u0011\u0010\u000F¨\u0006\""}, d2={"Landroidx/compose/foundation/layout/ContextualFlowColumnScopeImpl;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "lineIndex", "", "indexInLine", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "maxHeightInLine", "<init>", "(IIFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineIndex", "()I", "getIndexInLine", "getMaxWidth-D9Ej5fM", "()F", "F", "getMaxHeightInLine-D9Ej5fM", "fillMaxColumnWidth", "Landroidx/compose/ui/Modifier;", "fraction", "", "align", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "weight", "fill", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContextualFlowColumnScopeImpl implements ColumnScope, ContextualFlowColumnScope {
    public static final int $stable;
    private final int indexInLine;
    private final int lineIndex;
    private final float maxHeightInLine;
    private final float maxWidth;

    static {
    }

    private ContextualFlowColumnScopeImpl(int arg2, int arg3, float arg4, float arg5) {
        super();
        this.$$delegate_0 = ColumnScopeInstance.INSTANCE;
        this.lineIndex = arg2;
        this.indexInLine = arg3;
        this.maxWidth = arg4;
        this.maxHeightInLine = arg5;
    }

    public ContextualFlowColumnScopeImpl(int arg1, int arg2, float arg3, float arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public Modifier align(Modifier arg1, Horizontal arg2) {
        return this.$$delegate_0.align(arg1, arg2);
    }

    public Modifier alignBy(Modifier arg1, VerticalAlignmentLine arg2) {
        return this.$$delegate_0.alignBy(arg1, arg2);
    }

    public Modifier alignBy(Modifier arg1, Function1 arg2) {
        return this.$$delegate_0.alignBy(arg1, arg2);
    }

    public Modifier fillMaxColumnWidth(Modifier arg2, float arg3) {
        int v0 = 0;
        if(Float.compare(0f, arg3) <= 0 && arg3 <= 1f) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid fraction " + arg3 + "; must be >= 0 and <= 1.0");
        }

        return arg2.then(new FillCrossAxisSizeElement(arg3));
    }

    public int getIndexInLine() {
        return this.indexInLine;
    }

    public int getLineIndex() {
        return this.lineIndex;
    }

    public float getMaxHeightInLine-D9Ej5fM() {
        return this.maxHeightInLine;
    }

    public float getMaxWidth-D9Ej5fM() {
        return this.maxWidth;
    }

    public Modifier weight(Modifier arg1, float arg2, boolean arg3) {
        return this.$$delegate_0.weight(arg1, arg2, arg3);
    }
}

