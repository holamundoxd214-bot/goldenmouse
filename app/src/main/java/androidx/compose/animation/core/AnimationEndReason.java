package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/animation/core/AnimationEndReason;", "", "<init>", "(Ljava/lang/String;I)V", "BoundReached", "Finished", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public enum AnimationEndReason {
    public static final enum AnimationEndReason BoundReached;
    public static final enum AnimationEndReason Finished;

    private static final AnimationEndReason[] $values() {
        return new AnimationEndReason[]{AnimationEndReason.BoundReached, AnimationEndReason.Finished};
    }

    static {
        AnimationEndReason.BoundReached = new AnimationEndReason("BoundReached", 0);
        AnimationEndReason.Finished = new AnimationEndReason("Finished", 1);
        AnimationEndReason[] v0 = AnimationEndReason.$values();
        AnimationEndReason.$VALUES = v0;
        AnimationEndReason.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private AnimationEndReason(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return AnimationEndReason.$ENTRIES;
    }

    public static AnimationEndReason valueOf(String arg1) {
        return Enum.valueOf(AnimationEndReason.class, arg1);
    }

    public static AnimationEndReason[] values() {
        return AnimationEndReason.$VALUES.clone();
    }
}

