package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0096\u0002J\b\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "Landroidx/compose/ui/text/TtsAnnotation;", "verbatim", "", "<init>", "(Ljava/lang/String;)V", "getVerbatim", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VerbatimTtsAnnotation extends TtsAnnotation {
    public static final int $stable;
    private final String verbatim;

    static {
    }

    public VerbatimTtsAnnotation(String arg2) {
        super(null);
        this.verbatim = arg2;
    }

    public boolean equals(Object arg4) {
        if(this == (((VerbatimTtsAnnotation)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof VerbatimTtsAnnotation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.verbatim, ((VerbatimTtsAnnotation)arg4).verbatim)) {
            return 0;
        }

        return 1;
    }

    public final String getVerbatim() {
        return this.verbatim;
    }

    public int hashCode() {
        return this.verbatim.hashCode();
    }

    public String toString() {
        return "VerbatimTtsAnnotation(verbatim=" + this.verbatim + ')';
    }
}

