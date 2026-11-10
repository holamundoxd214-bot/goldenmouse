package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0015\u001A\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001C\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0007\u001A\u00020\u0006X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\b\u0013\u0010\u000F\"\u0004\b\u0014\u0010\u0011¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/layout/AlignmentLineOffsetTextUnitNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/TextUnit;", "after", "<init>", "(Landroidx/compose/ui/layout/AlignmentLine;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "setAlignmentLine", "(Landroidx/compose/ui/layout/AlignmentLine;)V", "getBefore-XSAIIZE", "()J", "setBefore--R2X_6o", "(J)V", "J", "getAfter-XSAIIZE", "setAfter--R2X_6o", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class AlignmentLineOffsetTextUnitNode extends Node implements LayoutModifierNode {
    private long after;
    private AlignmentLine alignmentLine;
    private long before;

    public AlignmentLineOffsetTextUnitNode(AlignmentLine arg1, long arg2, long arg4, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg4);
    }

    private AlignmentLineOffsetTextUnitNode(AlignmentLine arg1, long arg2, long arg4) {
        super();
        this.alignmentLine = arg1;
        this.before = arg2;
        this.after = arg4;
    }

    public final long getAfter-XSAIIZE() {
        return this.after;
    }

    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    public final long getBefore-XSAIIZE() {
        return this.before;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg9, Measurable arg10, long arg11) {
        AlignmentLine v1 = this.alignmentLine;
        long v4 = 0;
        float v0 = TextUnit.getRawType-impl(this.before) == v4 ? Dp.Companion.getUnspecified-D9Ej5fM() : arg9.toDp-GaN1DYA(this.before);
        float v2 = v0;
        float v8 = TextUnit.getRawType-impl(this.after) == v4 ? Dp.Companion.getUnspecified-D9Ej5fM() : arg9.toDp-GaN1DYA(this.after);
        float v3 = v8;
        MeasureScope v0_1 = arg9;
        Measurable v4_1 = arg10;
        long v5 = arg11;
        return AlignmentLineKt.alignmentLineOffsetMeasure-tjqqzMA(v0_1, v1, v2, v3, v4_1, v5);
    }

    public final void setAfter--R2X_6o(long arg1) {
        this.after = arg1;
    }

    public final void setAlignmentLine(AlignmentLine arg1) {
        this.alignmentLine = arg1;
    }

    public final void setBefore--R2X_6o(long arg1) {
        this.before = arg1;
    }
}

