package kotlin.io;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lkotlin/io/FileWalkDirection;", "", "<init>", "(Ljava/lang/String;I)V", "TOP_DOWN", "BOTTOM_UP", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum FileWalkDirection {
    public static final enum FileWalkDirection BOTTOM_UP;
    public static final enum FileWalkDirection TOP_DOWN;

    private static final FileWalkDirection[] $values() {
        return new FileWalkDirection[]{FileWalkDirection.TOP_DOWN, FileWalkDirection.BOTTOM_UP};
    }

    static {
        FileWalkDirection.TOP_DOWN = new FileWalkDirection("TOP_DOWN", 0);
        FileWalkDirection.BOTTOM_UP = new FileWalkDirection("BOTTOM_UP", 1);
        FileWalkDirection[] v0 = FileWalkDirection.$values();
        FileWalkDirection.$VALUES = v0;
        FileWalkDirection.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private FileWalkDirection(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return FileWalkDirection.$ENTRIES;
    }

    public static FileWalkDirection valueOf(String arg1) {
        return Enum.valueOf(FileWalkDirection.class, arg1);
    }

    public static FileWalkDirection[] values() {
        return FileWalkDirection.$VALUES.clone();
    }
}

