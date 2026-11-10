package androidx.compose.foundation.text.selection;

import android.view.textclassifier.TextClassification;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJ\t\u0010\u0014\u001A\u00020\u0007HÆ\u0003J.\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/text/selection/TextClassificationResult;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "textClassification", "Landroid/view/textclassifier/TextClassification;", "<init>", "(Ljava/lang/CharSequence;JLandroid/view/textclassifier/TextClassification;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Ljava/lang/CharSequence;", "getSelection-d9O1mEE", "()J", "J", "getTextClassification", "()Landroid/view/textclassifier/TextClassification;", "component1", "component2", "component2-d9O1mEE", "component3", "copy", "copy-Sb-Bc2M", "(Ljava/lang/CharSequence;JLandroid/view/textclassifier/TextClassification;)Landroidx/compose/foundation/text/selection/TextClassificationResult;", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextClassificationResult {
    private final long selection;
    private final CharSequence text;
    private final TextClassification textClassification;

    public TextClassificationResult(CharSequence arg1, long arg2, TextClassification arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg4);
    }

    private TextClassificationResult(CharSequence arg1, long arg2, TextClassification arg4) {
        super();
        this.text = arg1;
        this.selection = arg2;
        this.textClassification = arg4;
    }

    public final CharSequence component1() {
        return this.text;
    }

    public final long component2-d9O1mEE() {
        return this.selection;
    }

    public final TextClassification component3() {
        return this.textClassification;
    }

    public final TextClassificationResult copy-Sb-Bc2M(CharSequence arg7, long arg8, TextClassification arg10) {
        return new TextClassificationResult(arg7, arg8, arg10, null);
    }

    public static TextClassificationResult copy-Sb-Bc2M$default(TextClassificationResult arg0, CharSequence arg1, long arg2, TextClassification arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.text;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.selection;
        }

        if((arg5 & 4) != 0) {
            arg4 = arg0.textClassification;
        }

        return arg0.copy-Sb-Bc2M(arg1, arg2, arg4);
    }

    public boolean equals(Object arg8) {
        if(this == (((TextClassificationResult)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof TextClassificationResult)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.text, ((TextClassificationResult)arg8).text)) {
            return 0;
        }

        if(!TextRange.equals-impl0(this.selection, ((TextClassificationResult)arg8).selection)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textClassification, ((TextClassificationResult)arg8).textClassification)) {
            return 0;
        }

        return 1;
    }

    public final long getSelection-d9O1mEE() {
        return this.selection;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final TextClassification getTextClassification() {
        return this.textClassification;
    }

    public int hashCode() {
        return (this.text.hashCode() * 0x1F + TextRange.hashCode-impl(this.selection)) * 0x1F + this.textClassification.hashCode();
    }

    public String toString() {
        return "TextClassificationResult(text=" + this.text + ", selection=" + TextRange.toString-impl(this.selection) + ", textClassification=" + this.textClassification + ')';
    }
}

