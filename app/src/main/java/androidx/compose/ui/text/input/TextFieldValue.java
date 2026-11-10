package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.NonNullValueClassSaver;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB)\b\u0016\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\u000BJ-\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0015\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\u0018J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001C\u001A\u00020\u001DH\u0016J\b\u0010\u001E\u001A\u00020\nH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\t\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2={"Landroidx/compose/ui/text/input/TextFieldValue;", "", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "text", "", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getText", "()Ljava/lang/String;", "getSelection-d9O1mEE", "()J", "J", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "copy", "copy-3r_uNRQ", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "equals", "", "other", "hashCode", "", "toString", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldValue {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/text/input/TextFieldValue$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return TextFieldValue.Saver;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Saver Saver;
    private final AnnotatedString annotatedString;
    private final TextRange composition;
    private final long selection;

    static {
        TextFieldValue.Companion = new Companion(null);
        TextFieldValue.Saver = SaverKt.Saver(new TextFieldValue$$ExternalSyntheticLambda0(), new TextFieldValue$$ExternalSyntheticLambda1());
    }

    public TextFieldValue(String arg7, long arg8, TextRange arg10, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 1) != 0) {
            arg7 = "";
        }

        String v1 = arg7;
        if((arg11 & 2) != 0) {
            arg8 = TextRange.Companion.getZero-d9O1mEE();
        }

        long v2 = arg8;
        if((arg11 & 4) != 0) {
            arg10 = null;
        }

        this(v1, v2, arg10, null);
    }

    public TextFieldValue(AnnotatedString arg7, long arg8, TextRange arg10, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 2) != 0) {
            arg8 = TextRange.Companion.getZero-d9O1mEE();
        }

        long v2 = arg8;
        if((arg11 & 4) != 0) {
            arg10 = null;
        }

        this(arg7, v2, arg10, null);
    }

    public TextFieldValue(AnnotatedString arg1, long arg2, TextRange arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg4);
    }

    private TextFieldValue(AnnotatedString arg2, long arg3, TextRange arg5) {
        super();
        this.annotatedString = arg2;
        this.selection = TextRangeKt.coerceIn-8ffj60Q(arg3, 0, this.getText().length());
        TextRange v2 = arg5 != null ? TextRange.box-impl(TextRangeKt.coerceIn-8ffj60Q(arg5.unbox-impl(), 0, this.getText().length())) : null;
        this.composition = v2;
    }

    private TextFieldValue(String arg7, long arg8, TextRange arg10) {
        this(new AnnotatedString(arg7, null, 2, null), arg8, arg10, null);
    }

    public TextFieldValue(String arg1, long arg2, TextRange arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg4);
    }

    static final Object Saver$lambda$0(SaverScope arg3, TextFieldValue arg4) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(arg4.annotatedString, SaversKt.getAnnotatedStringSaver(), arg3), SaversKt.save(TextRange.box-impl(arg4.selection), SaversKt.getSaver(TextRange.Companion), arg3)});
    }

    static final TextFieldValue Saver$lambda$1(Object arg7) {
        Intrinsics.checkNotNull(arg7, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        Boolean v2 = Boolean.valueOf(false);
        Object v1 = ((List)arg7).get(0);
        Saver v3 = SaversKt.getAnnotatedStringSaver();
        Object v5 = null;
        if((Intrinsics.areEqual(v1, v2)) && !(v3 instanceof NonNullValueClassSaver)) {
            goto label_16;
        }
        else if(v1 != null) {
            v1 = v3.restore(v1);
        }
        else {
        label_16:
            v1 = v5;
        }

        Intrinsics.checkNotNull(v1);
        arg7 = ((List)arg7).get(1);
        v3 = SaversKt.getSaver(TextRange.Companion);
        if((Intrinsics.areEqual(arg7, v2)) && !(v3 instanceof NonNullValueClassSaver)) {
        }
        else if(arg7 != null) {
            v5 = v3.restore(arg7);
        }

        Intrinsics.checkNotNull(v5);
        return new TextFieldValue(((AnnotatedString)v1), ((TextRange)v5).unbox-impl(), null, 4, null);
    }

    public static final Saver access$getSaver$cp() {
        return TextFieldValue.Saver;
    }

    public final TextFieldValue copy-3r_uNRQ(AnnotatedString arg7, long arg8, TextRange arg10) {
        return new TextFieldValue(arg7, arg8, arg10, null);
    }

    public final TextFieldValue copy-3r_uNRQ(String arg7, long arg8, TextRange arg10) {
        return new TextFieldValue(new AnnotatedString(arg7, null, 2, null), arg8, arg10, null);
    }

    public static TextFieldValue copy-3r_uNRQ$default(TextFieldValue arg0, String arg1, long arg2, TextRange arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg2 = arg0.selection;
        }

        if((arg5 & 4) != 0) {
            arg4 = arg0.composition;
        }

        return arg0.copy-3r_uNRQ(arg1, arg2, arg4);
    }

    public static TextFieldValue copy-3r_uNRQ$default(TextFieldValue arg0, AnnotatedString arg1, long arg2, TextRange arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.annotatedString;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.selection;
        }

        if((arg5 & 4) != 0) {
            arg4 = arg0.composition;
        }

        return arg0.copy-3r_uNRQ(arg1, arg2, arg4);
    }

    public boolean equals(Object arg8) {
        if(this == (((TextFieldValue)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof TextFieldValue)) {
            return 0;
        }

        if((TextRange.equals-impl0(this.selection, ((TextFieldValue)arg8).selection)) && (Intrinsics.areEqual(this.composition, ((TextFieldValue)arg8).composition)) && (Intrinsics.areEqual(this.annotatedString, ((TextFieldValue)arg8).annotatedString))) {
            return 1;
        }

        return 0;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final TextRange getComposition-MzsxiRA() {
        return this.composition;
    }

    public final long getSelection-d9O1mEE() {
        return this.selection;
    }

    public final String getText() {
        return this.annotatedString.getText();
    }

    public int hashCode() {
        int v0 = (this.annotatedString.hashCode() * 0x1F + TextRange.hashCode-impl(this.selection)) * 0x1F;
        TextRange v3 = this.composition;
        int v3_1 = v3 != null ? TextRange.hashCode-impl(v3.unbox-impl()) : 0;
        return v0 + v3_1;
    }

    public String toString() {
        return "TextFieldValue(text=\'" + this.annotatedString + "\', selection=" + TextRange.toString-impl(this.selection) + ", composition=" + this.composition + ')';
    }
}

