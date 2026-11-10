package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u000E\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\u0004\b\u000B\u0010\fJ#\u0010\u0015\u001A\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\t\u0010\u001E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001F\u001A\u00020\u0005HÆ\u0003J\t\u0010 \u001A\u00020\u0007HÆ\u0003J\u0011\u0010!\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0003J9\u0010\"\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0010\b\u0002\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0001J\u0013\u0010#\u001A\u00020$2\b\u0010%\u001A\u0004\u0018\u00010&HÖ\u0003J\t\u0010\'\u001A\u00020\u0005HÖ\u0001J\t\u0010(\u001A\u00020)HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2={"Landroidx/compose/foundation/text/HorizontalScrollLayoutModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "<init>", "(Landroidx/compose/foundation/text/TextFieldScrollerPosition;ILandroidx/compose/ui/text/input/TransformedText;Lkotlin/jvm/functions/Function0;)V", "getScrollerPosition", "()Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "getCursorOffset", "()I", "getTransformedText", "()Landroidx/compose/ui/text/input/TransformedText;", "getTextLayoutResultProvider", "()Lkotlin/jvm/functions/Function0;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class HorizontalScrollLayoutModifier implements LayoutModifier {
    private final int cursorOffset;
    private final TextFieldScrollerPosition scrollerPosition;
    private final Function0 textLayoutResultProvider;
    private final TransformedText transformedText;

    public HorizontalScrollLayoutModifier(TextFieldScrollerPosition arg1, int arg2, TransformedText arg3, Function0 arg4) {
        super();
        this.scrollerPosition = arg1;
        this.cursorOffset = arg2;
        this.transformedText = arg3;
        this.textLayoutResultProvider = arg4;
    }

    public final TextFieldScrollerPosition component1() {
        return this.scrollerPosition;
    }

    public final int component2() {
        return this.cursorOffset;
    }

    public final TransformedText component3() {
        return this.transformedText;
    }

    public final Function0 component4() {
        return this.textLayoutResultProvider;
    }

    public final HorizontalScrollLayoutModifier copy(TextFieldScrollerPosition arg1, int arg2, TransformedText arg3, Function0 arg4) {
        return new HorizontalScrollLayoutModifier(arg1, arg2, arg3, arg4);
    }

    public static HorizontalScrollLayoutModifier copy$default(HorizontalScrollLayoutModifier arg0, TextFieldScrollerPosition arg1, int arg2, TransformedText arg3, Function0 arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.scrollerPosition;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.cursorOffset;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.transformedText;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.textLayoutResultProvider;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((HorizontalScrollLayoutModifier)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof HorizontalScrollLayoutModifier)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.scrollerPosition, ((HorizontalScrollLayoutModifier)arg5).scrollerPosition)) {
            return 0;
        }

        if(this.cursorOffset != ((HorizontalScrollLayoutModifier)arg5).cursorOffset) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.transformedText, ((HorizontalScrollLayoutModifier)arg5).transformedText)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textLayoutResultProvider, ((HorizontalScrollLayoutModifier)arg5).textLayoutResultProvider)) {
            return 0;
        }

        return 1;
    }

    public final int getCursorOffset() {
        return this.cursorOffset;
    }

    public final TextFieldScrollerPosition getScrollerPosition() {
        return this.scrollerPosition;
    }

    public final Function0 getTextLayoutResultProvider() {
        return this.textLayoutResultProvider;
    }

    public final TransformedText getTransformedText() {
        return this.transformedText;
    }

    public int hashCode() {
        return ((this.scrollerPosition.hashCode() * 0x1F + Integer.hashCode(this.cursorOffset)) * 0x1F + this.transformedText.hashCode()) * 0x1F + this.textLayoutResultProvider.hashCode();
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg11, Measurable arg12, long arg13) {
        long v2;
        if(arg12.maxIntrinsicWidth(Constraints.getMaxHeight-impl(arg13)) < Constraints.getMaxWidth-impl(arg13)) {
            v2 = arg13;
        }
        else {
            v2 = arg13;
            arg13 = Constraints.copy-Zbe2FdA$default(v2, 0, 0x7FFFFFFF, 0, 0, 13, null);
        }

        Placeable v12 = arg12.measure-BRTryo0(arg13);
        int v1 = Math.min(v12.getWidth(), Constraints.getMaxWidth-impl(v2));
        return MeasureScope.layout$default(arg11, v1, v12.getHeight(), null, new HorizontalScrollLayoutModifier$$ExternalSyntheticLambda0(this, arg11, v12, v1), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(HorizontalScrollLayoutModifier arg7, MeasureScope arg8, Placeable arg9, int arg10, PlacementScope arg11) {
        PlacementScope v0 = arg11;
        int v1 = arg7.cursorOffset;
        TransformedText v2 = arg7.transformedText;
        Object v3 = arg7.textLayoutResultProvider.invoke();
        TextLayoutResult v3_1 = v3 != null ? ((TextLayoutResultProxy)v3).getValue() : null;
        boolean v8 = arg8.getLayoutDirection() == LayoutDirection.Rtl ? true : false;
        arg7.scrollerPosition.update(Orientation.Horizontal, TextFieldScrollKt.access$getCursorRectInScroller(((Density)v0), v1, v2, v3_1, v8, arg9.getWidth()), arg10, arg9.getWidth());
        PlacementScope.placeRelative$default(arg11, arg9, Math.round(-arg7.scrollerPosition.getOffset()), 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public String toString() {
        return "HorizontalScrollLayoutModifier(scrollerPosition=" + this.scrollerPosition + ", cursorOffset=" + this.cursorOffset + ", transformedText=" + this.transformedText + ", textLayoutResultProvider=" + this.textLayoutResultProvider + ')';
    }
}

