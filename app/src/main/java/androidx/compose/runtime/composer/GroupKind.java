package androidx.compose.runtime.composer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u000E\u001A\u00020\t2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001A\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001A\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\r\u0010\u000B\u0088\u0001\u0002¨\u0006\u0014"}, d2={"Landroidx/compose/runtime/composer/GroupKind;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "isNode", "", "isNode-impl", "(I)Z", "isReusable", "isReusable-impl", "equals", "other", "hashCode", "toString", "", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class GroupKind {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/runtime/composer/GroupKind$Companion;", "", "<init>", "()V", "Group", "Landroidx/compose/runtime/composer/GroupKind;", "getGroup-9udXigM", "()I", "I", "Node", "getNode-9udXigM", "ReusableNode", "getReusableNode-9udXigM", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getGroup-9udXigM() {
            return GroupKind.Group;
        }

        public final int getNode-9udXigM() {
            return GroupKind.Node;
        }

        public final int getReusableNode-9udXigM() {
            return GroupKind.ReusableNode;
        }
    }

    public static final Companion Companion;
    private static final int Group;
    private static final int Node;
    private static final int ReusableNode;
    private final int value;

    static {
        GroupKind.Companion = new Companion(null);
        GroupKind.Group = GroupKind.constructor-impl(0);
        GroupKind.Node = GroupKind.constructor-impl(1);
        GroupKind.ReusableNode = GroupKind.constructor-impl(2);
    }

    private GroupKind(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getGroup$cp() {
        return GroupKind.Group;
    }

    public static final int access$getNode$cp() {
        return GroupKind.Node;
    }

    public static final int access$getReusableNode$cp() {
        return GroupKind.ReusableNode;
    }

    public static final GroupKind box-impl(int arg1) {
        return new GroupKind(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return GroupKind.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof GroupKind)) {
            return 0;
        }

        if(arg2 != ((GroupKind)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int arg0, int arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return GroupKind.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public static final boolean isNode-impl(int arg1) {
        if(arg1 != GroupKind.Companion.getGroup-9udXigM()) {
            return 1;
        }

        return 0;
    }

    public static final boolean isReusable-impl(int arg1) {
        if(arg1 != GroupKind.Companion.getNode-9udXigM()) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return GroupKind.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "GroupKind(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

