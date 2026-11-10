package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001B\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001A\u00020\nH\u0016J\u0012\u0010\u000B\u001A\u00020\n2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0002J\u000B\u0010\r\u001A\u0004\u0018\u00010\u0001HÆ\u0003J\u000B\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÆ\u0003J!\u0010\u000F\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0001HÆ\u0001J\u0014\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001A\u00020\u0014HÖ\u0081\u0004R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0003\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2={"Landroidx/compose/runtime/JoinedKey;", "", "left", "right", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getLeft", "()Ljava/lang/Object;", "getRight", "hashCode", "", "hashCodeOf", "value", "component1", "component2", "copy", "equals", "", "other", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class JoinedKey {
    public static final int $stable = 8;
    private final Object left;
    private final Object right;

    static {
    }

    public JoinedKey(Object arg1, Object arg2) {
        super();
        this.left = arg1;
        this.right = arg2;
    }

    public final Object component1() {
        return this.left;
    }

    public final Object component2() {
        return this.right;
    }

    public final JoinedKey copy(Object arg1, Object arg2) {
        return new JoinedKey(arg1, arg2);
    }

    public static JoinedKey copy$default(JoinedKey arg0, Object arg1, Object arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.left;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.right;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((JoinedKey)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof JoinedKey)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.left, ((JoinedKey)arg5).left)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.right, ((JoinedKey)arg5).right)) {
            return 0;
        }

        return 1;
    }

    public final Object getLeft() {
        return this.left;
    }

    public final Object getRight() {
        return this.right;
    }

    public int hashCode() {
        return this.hashCodeOf(this.left) * 0x1F + this.hashCodeOf(this.right);
    }

    private final int hashCodeOf(Object arg1) {
        if((arg1 instanceof Enum)) {
            return ((Enum)arg1).ordinal();
        }

        if(arg1 != null) {
            return arg1.hashCode();
        }

        return 0;
    }

    public String toString() {
        return "JoinedKey(left=" + this.left + ", right=" + this.right + ')';
    }
}

