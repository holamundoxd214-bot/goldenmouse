package kotlin.annotation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lkotlin/annotation/AnnotationRetention;", "", "<init>", "(Ljava/lang/String;I)V", "SOURCE", "BINARY", "RUNTIME", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum AnnotationRetention {
    public static final enum AnnotationRetention BINARY;
    public static final enum AnnotationRetention RUNTIME;
    public static final enum AnnotationRetention SOURCE;

    private static final AnnotationRetention[] $values() {
        return new AnnotationRetention[]{AnnotationRetention.SOURCE, AnnotationRetention.BINARY, AnnotationRetention.RUNTIME};
    }

    static {
        AnnotationRetention.SOURCE = new AnnotationRetention("SOURCE", 0);
        AnnotationRetention.BINARY = new AnnotationRetention("BINARY", 1);
        AnnotationRetention.RUNTIME = new AnnotationRetention("RUNTIME", 2);
        AnnotationRetention[] v0 = AnnotationRetention.$values();
        AnnotationRetention.$VALUES = v0;
        AnnotationRetention.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private AnnotationRetention(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return AnnotationRetention.$ENTRIES;
    }

    public static AnnotationRetention valueOf(String arg1) {
        return Enum.valueOf(AnnotationRetention.class, arg1);
    }

    public static AnnotationRetention[] values() {
        return AnnotationRetention.$VALUES.clone();
    }
}

