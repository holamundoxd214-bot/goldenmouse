package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\f\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\t¨\u0006\u0017"}, d2={"Landroidx/compose/material3/internal/DateInputFormat;", "", "patternWithDelimiters", "", "delimiter", "", "<init>", "(Ljava/lang/String;C)V", "getPatternWithDelimiters", "()Ljava/lang/String;", "getDelimiter", "()C", "patternWithoutDelimiters", "getPatternWithoutDelimiters", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DateInputFormat {
    public static final int $stable;
    private final char delimiter;
    private final String patternWithDelimiters;
    private final String patternWithoutDelimiters;

    static {
    }

    public DateInputFormat(String arg7, char arg8) {
        super();
        this.patternWithDelimiters = arg7;
        this.delimiter = arg8;
        this.patternWithoutDelimiters = StringsKt.replace$default(arg7, String.valueOf(arg8), "", false, 4, null);
    }

    public final String component1() {
        return this.patternWithDelimiters;
    }

    public final char component2() {
        return this.delimiter;
    }

    public final DateInputFormat copy(String arg1, char arg2) {
        return new DateInputFormat(arg1, arg2);
    }

    public static DateInputFormat copy$default(DateInputFormat arg0, String arg1, char arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.patternWithDelimiters;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.delimiter;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((DateInputFormat)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DateInputFormat)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.patternWithDelimiters, ((DateInputFormat)arg5).patternWithDelimiters)) {
            return 0;
        }

        if(this.delimiter != ((DateInputFormat)arg5).delimiter) {
            return 0;
        }

        return 1;
    }

    public final char getDelimiter() {
        return this.delimiter;
    }

    public final String getPatternWithDelimiters() {
        return this.patternWithDelimiters;
    }

    public final String getPatternWithoutDelimiters() {
        return this.patternWithoutDelimiters;
    }

    public int hashCode() {
        return this.patternWithDelimiters.hashCode() * 0x1F + Character.hashCode(this.delimiter);
    }

    public String toString() {
        return "DateInputFormat(patternWithDelimiters=" + this.patternWithDelimiters + ", delimiter=" + this.delimiter + ')';
    }
}

