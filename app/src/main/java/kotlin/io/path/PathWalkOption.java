package kotlin.io.path;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lkotlin/io/path/PathWalkOption;", "", "<init>", "(Ljava/lang/String;I)V", "INCLUDE_DIRECTORIES", "BREADTH_FIRST", "FOLLOW_LINKS", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) public enum PathWalkOption {
    public static final enum PathWalkOption BREADTH_FIRST;
    public static final enum PathWalkOption FOLLOW_LINKS;
    public static final enum PathWalkOption INCLUDE_DIRECTORIES;

    private static final PathWalkOption[] $values() {
        return new PathWalkOption[]{PathWalkOption.INCLUDE_DIRECTORIES, PathWalkOption.BREADTH_FIRST, PathWalkOption.FOLLOW_LINKS};
    }

    static {
        PathWalkOption.INCLUDE_DIRECTORIES = new PathWalkOption("INCLUDE_DIRECTORIES", 0);
        PathWalkOption.BREADTH_FIRST = new PathWalkOption("BREADTH_FIRST", 1);
        PathWalkOption.FOLLOW_LINKS = new PathWalkOption("FOLLOW_LINKS", 2);
        PathWalkOption[] v0 = PathWalkOption.$values();
        PathWalkOption.$VALUES = v0;
        PathWalkOption.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private PathWalkOption(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return PathWalkOption.$ENTRIES;
    }

    public static PathWalkOption valueOf(String arg1) {
        return Enum.valueOf(PathWalkOption.class, arg1);
    }

    public static PathWalkOption[] values() {
        return PathWalkOption.$VALUES.clone();
    }
}

