package kotlin.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0081\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lkotlin/internal/RequireKotlinVersionKind;", "", "<init>", "(Ljava/lang/String;I)V", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum RequireKotlinVersionKind {
    public static final enum RequireKotlinVersionKind API_VERSION;
    public static final enum RequireKotlinVersionKind COMPILER_VERSION;
    public static final enum RequireKotlinVersionKind LANGUAGE_VERSION;

    private static final RequireKotlinVersionKind[] $values() {
        return new RequireKotlinVersionKind[]{RequireKotlinVersionKind.LANGUAGE_VERSION, RequireKotlinVersionKind.COMPILER_VERSION, RequireKotlinVersionKind.API_VERSION};
    }

    static {
        RequireKotlinVersionKind.LANGUAGE_VERSION = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);
        RequireKotlinVersionKind.COMPILER_VERSION = new RequireKotlinVersionKind("COMPILER_VERSION", 1);
        RequireKotlinVersionKind.API_VERSION = new RequireKotlinVersionKind("API_VERSION", 2);
        RequireKotlinVersionKind[] v0 = RequireKotlinVersionKind.$values();
        RequireKotlinVersionKind.$VALUES = v0;
        RequireKotlinVersionKind.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RequireKotlinVersionKind(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RequireKotlinVersionKind.$ENTRIES;
    }

    public static RequireKotlinVersionKind valueOf(String arg1) {
        return Enum.valueOf(RequireKotlinVersionKind.class, arg1);
    }

    public static RequireKotlinVersionKind[] values() {
        return RequireKotlinVersionKind.$VALUES.clone();
    }
}

