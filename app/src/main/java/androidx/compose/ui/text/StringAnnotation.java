package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BHÖ\u0003J\t\u0010\f\u001A\u00020\rHÖ\u0001J\t\u0010\u000E\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/StringAnnotation;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class StringAnnotation implements Annotation {
    private final String value;

    private StringAnnotation(String arg1) {
        super();
        this.value = arg1;
    }

    public static final StringAnnotation box-impl(String arg1) {
        return new StringAnnotation(arg1);
    }

    public static String constructor-impl(String arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return StringAnnotation.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(String arg2, Object arg3) {
        if(!(arg3 instanceof StringAnnotation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((StringAnnotation)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(String arg0, String arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return StringAnnotation.hashCode-impl(this.value);
    }

    public static int hashCode-impl(String arg0) {
        return arg0.hashCode();
    }

    public String toString() {
        return StringAnnotation.toString-impl(this.value);
    }

    public static String toString-impl(String arg2) {
        return "StringAnnotation(value=" + arg2 + ')';
    }

    public final String unbox-impl() {
        return this.value;
    }
}

