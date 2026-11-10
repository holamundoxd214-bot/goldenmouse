package kotlin.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000E\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001B\bB\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0003\u001A\u00020\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0015\u0010\u0005\u001A\u00020\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2={"Lkotlin/text/RegexOption;", "Lkotlin/text/FlagEnum;", "", "value", "", "mask", "<init>", "(Ljava/lang/String;III)V", "getValue", "()I", "getMask", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum RegexOption implements FlagEnum {
    public static final enum RegexOption CANON_EQ;
    public static final enum RegexOption COMMENTS;
    public static final enum RegexOption DOT_MATCHES_ALL;
    public static final enum RegexOption IGNORE_CASE;
    public static final enum RegexOption LITERAL;
    public static final enum RegexOption MULTILINE;
    public static final enum RegexOption UNIX_LINES;
    private final int mask;
    private final int value;

    private static final RegexOption[] $values() {
        return new RegexOption[]{RegexOption.IGNORE_CASE, RegexOption.MULTILINE, RegexOption.LITERAL, RegexOption.UNIX_LINES, RegexOption.COMMENTS, RegexOption.DOT_MATCHES_ALL, RegexOption.CANON_EQ};
    }

    static {
        RegexOption.IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
        RegexOption.MULTILINE = new RegexOption("MULTILINE", 1, 8, 0, 2, null);
        RegexOption.LITERAL = new RegexOption("LITERAL", 2, 16, 0, 2, null);
        RegexOption.UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, 0, 2, null);
        RegexOption.COMMENTS = new RegexOption("COMMENTS", 4, 4, 0, 2, null);
        RegexOption.DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 0x20, 0, 2, null);
        RegexOption.CANON_EQ = new RegexOption("CANON_EQ", 6, 0x80, 0, 2, null);
        RegexOption[] v0 = RegexOption.$values();
        RegexOption.$VALUES = v0;
        RegexOption.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    RegexOption(String arg1, int arg2, int arg3, int arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 2) != 0) {
            arg4 = arg3;
        }

        this(arg1, arg2, arg3, arg4);
    }

    private RegexOption(String arg1, int arg2, int arg3, int arg4) {
        super(arg1, arg2);
        this.value = arg3;
        this.mask = arg4;
    }

    public static EnumEntries getEntries() {
        return RegexOption.$ENTRIES;
    }

    public int getMask() {
        return this.mask;
    }

    public int getValue() {
        return this.value;
    }

    public static RegexOption valueOf(String arg1) {
        return Enum.valueOf(RegexOption.class, arg1);
    }

    public static RegexOption[] values() {
        return RegexOption.$VALUES.clone();
    }
}

