package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/compose/ui/text/input/TransformedText;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/input/OffsetMapping;)V", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "equals", "", "other", "hashCode", "", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TransformedText {
    public static final int $stable = 8;
    private final OffsetMapping offsetMapping;
    private final AnnotatedString text;

    static {
    }

    public TransformedText(AnnotatedString arg1, OffsetMapping arg2) {
        super();
        this.text = arg1;
        this.offsetMapping = arg2;
    }

    public boolean equals(Object arg5) {
        if(this == (((TransformedText)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TransformedText)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.text, ((TransformedText)arg5).text)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.offsetMapping, ((TransformedText)arg5).offsetMapping)) {
            return 0;
        }

        return 1;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public int hashCode() {
        return this.text.hashCode() * 0x1F + this.offsetMapping.hashCode();
    }

    public String toString() {
        return "TransformedText(text=" + this.text + ", offsetMapping=" + this.offsetMapping + ')';
    }
}

