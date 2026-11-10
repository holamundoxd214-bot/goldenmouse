package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/animation/core/RepeatMode;", "", "<init>", "(Ljava/lang/String;I)V", "Restart", "Reverse", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public enum RepeatMode {
    public static final enum RepeatMode Restart;
    public static final enum RepeatMode Reverse;

    private static final RepeatMode[] $values() {
        return new RepeatMode[]{RepeatMode.Restart, RepeatMode.Reverse};
    }

    static {
        RepeatMode.Restart = new RepeatMode("Restart", 0);
        RepeatMode.Reverse = new RepeatMode("Reverse", 1);
        RepeatMode[] v0 = RepeatMode.$values();
        RepeatMode.$VALUES = v0;
        RepeatMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RepeatMode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RepeatMode.$ENTRIES;
    }

    public static RepeatMode valueOf(String arg1) {
        return Enum.valueOf(RepeatMode.class, arg1);
    }

    public static RepeatMode[] values() {
        return RepeatMode.$VALUES.clone();
    }
}

