package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ToCharArray_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\u001A\b\u0002\u0010\t\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020\f0\u000Bj\u0002`\r\u0018\u00010\n\u0012\u001A\b\u0002\u0010\u000E\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020\f0\u000Bj\u0002`\r\u0018\u00010\n¢\u0006\u0004\b\u000F\u0010\u0010J\u0011\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u0015H\u0096\u0002J\u0018\u0010$\u001A\u00020\u00012\u0006\u0010%\u001A\u00020\u00152\u0006\u0010&\u001A\u00020\u0015H\u0016J\b\u0010\'\u001A\u00020(H\u0016J\u000E\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u0001J&\u0010,\u001A\u00020-2\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u00020\u00152\u0006\u00101\u001A\u00020\u00152\u0006\u00102\u001A\u00020\u0015J\u0006\u00103\u001A\u00020*J\u0013\u00104\u001A\u00020*2\b\u0010+\u001A\u0004\u0018\u000105H\u0096\u0002J\b\u00106\u001A\u00020\u0015H\u0016R#\u0010\t\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020\f0\u000Bj\u0002`\r\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R#\u0010\u000E\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020\f0\u000Bj\u0002`\r\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0003\u001A\u00020\u0004¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u001F\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 ¨\u00067"}, d2={"Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "", "text", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "composingAnnotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "outputAnnotations", "<init>", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Lkotlin/Pair;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getComposingAnnotations", "()Ljava/util/List;", "getOutputAnnotations", "length", "", "getLength", "()I", "getText", "()Ljava/lang/CharSequence;", "getSelection-d9O1mEE", "()J", "J", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getHighlight", "()Lkotlin/Pair;", "get", "", "index", "subSequence", "startIndex", "endIndex", "toString", "", "contentEquals", "", "other", "toCharArray", "", "destination", "", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "shouldShowSelection", "equals", "", "hashCode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldCharSequence implements CharSequence {
    public static final int $stable = 8;
    private final List composingAnnotations;
    private final TextRange composition;
    private final Pair highlight;
    private final List outputAnnotations;
    private final long selection;
    private final CharSequence text;

    static {
    }

    public TextFieldCharSequence(CharSequence arg9, long arg10, TextRange arg12, Pair arg13, List arg14, List arg15, int arg16, DefaultConstructorMarker arg17) {
        String v0;
        if((arg16 & 1) != 0) {
            v0 = "";
        }
        else {
            CharSequence v0_1 = arg9;
        }

        long v1 = (arg16 & 2) != 0 ? TextRange.Companion.getZero-d9O1mEE() : arg10;
        List v4 = null;
        TextRange v3 = (arg16 & 4) != 0 ? ((TextRange)v4) : arg12;
        Pair v5 = (arg16 & 8) != 0 ? ((Pair)v4) : arg13;
        List v6 = (arg16 & 16) != 0 ? v4 : arg14;
        if((arg16 & 0x20) != 0) {
        }
        else {
            v4 = arg15;
        }

        this(v0, v1, v3, v5, v6, v4, null);
    }

    private TextFieldCharSequence(CharSequence arg1, long arg2, TextRange arg4, Pair arg5, List arg6, List arg7) {
        Pair v2_1;
        super();
        this.composingAnnotations = arg6;
        this.outputAnnotations = arg7;
        CharSequence v6 = (arg1 instanceof TextFieldCharSequence) ? arg1.text : arg1;
        this.text = v6;
        this.selection = TextRangeKt.coerceIn-8ffj60Q(arg2, 0, arg1.length());
        Object v2 = null;
        TextRange v3 = arg4 != null ? TextRange.box-impl(TextRangeKt.coerceIn-8ffj60Q(arg4.unbox-impl(), 0, arg1.length())) : ((TextRange)v2);
        this.composition = v3;
        if(arg5 != null) {
            v2_1 = Pair.copy$default(arg5, v2, TextRange.box-impl(TextRangeKt.coerceIn-8ffj60Q(arg5.getSecond().unbox-impl(), 0, arg1.length())), 1, v2);
        }

        this.highlight = v2_1;
    }

    public TextFieldCharSequence(CharSequence arg1, long arg2, TextRange arg4, Pair arg5, List arg6, List arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg4, arg5, arg6, arg7);
    }

    public final char charAt(int arg1) {
        return this.get(arg1);
    }

    public final boolean contentEquals(CharSequence arg1) {
        return StringsKt.contentEquals(this.text, arg1);
    }

    public boolean equals(Object arg7) {
        if(this == (((TextFieldCharSequence)arg7))) {
            return 1;
        }

        if(arg7 == null) {
            return 0;
        }

        if(this.getClass() != arg7.getClass()) {
            return 0;
        }

        if(!TextRange.equals-impl0(this.selection, ((TextFieldCharSequence)arg7).selection)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.composition, ((TextFieldCharSequence)arg7).composition)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.highlight, ((TextFieldCharSequence)arg7).highlight)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.composingAnnotations, ((TextFieldCharSequence)arg7).composingAnnotations)) {
            return 0;
        }

        if(!this.contentEquals(((TextFieldCharSequence)arg7).text)) {
            return 0;
        }

        return 1;
    }

    public char get(int arg1) {
        return this.text.charAt(arg1);
    }

    public final List getComposingAnnotations() {
        return this.composingAnnotations;
    }

    public final TextRange getComposition-MzsxiRA() {
        return this.composition;
    }

    public final Pair getHighlight() {
        return this.highlight;
    }

    public int getLength() {
        return this.text.length();
    }

    public final List getOutputAnnotations() {
        return this.outputAnnotations;
    }

    public final long getSelection-d9O1mEE() {
        return this.selection;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public int hashCode() {
        int v0 = (this.text.hashCode() * 0x1F + TextRange.hashCode-impl(this.selection)) * 0x1F;
        TextRange v1 = this.composition;
        int v2 = 0;
        int v1_1 = v1 != null ? TextRange.hashCode-impl(v1.unbox-impl()) : 0;
        v0 = (v0 + v1_1) * 0x1F;
        Pair v1_2 = this.highlight;
        v1_1 = v1_2 != null ? v1_2.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        List v5 = this.composingAnnotations;
        if(v5 != null) {
            v2 = v5.hashCode();
        }

        return v0 + v2;
    }

    public final int length() {
        return this.getLength();
    }

    public final boolean shouldShowSelection() {
        if(this.highlight == null) {
            return 1;
        }

        return 0;
    }

    public CharSequence subSequence(int arg1, int arg2) {
        return this.text.subSequence(arg1, arg2);
    }

    public final void toCharArray(char[] arg1, int arg2, int arg3, int arg4) {
        ToCharArray_androidKt.toCharArray(this.text, arg1, arg2, arg3, arg4);
    }

    public String toString() {
        return this.text.toString();
    }
}

