package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001C\u0010\t\u001A\u00020\u00042\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u0000H\u0086\f¢\u0006\u0004\b\u000B\u0010\fJ\u0018\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u0004H\u0086\f¢\u0006\u0004\b\r\u0010\fJ\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\n\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0004HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b\u0088\u0001\u0003¨\u0006\u0013"}, d2={"Landroidx/compose/ui/node/NodeKind;", "T", "", "mask", "", "constructor-impl", "(I)I", "getMask", "()I", "or", "other", "or-H91voCI", "(II)I", "or-impl", "equals", "", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class NodeKind {
    private final int mask;

    private NodeKind(int arg1) {
        super();
        this.mask = arg1;
    }

    public static final NodeKind box-impl(int arg1) {
        return new NodeKind(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return NodeKind.equals-impl(this.mask, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof NodeKind)) {
            return 0;
        }

        if(arg2 != ((NodeKind)arg3).unbox-impl()) {
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

    public final int getMask() {
        return this.mask;
    }

    public int hashCode() {
        return NodeKind.hashCode-impl(this.mask);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public static final int or-H91voCI(int arg0, int arg1) {
        return arg0 | arg1;
    }

    public static final int or-impl(int arg0, int arg1) {
        return arg0 | arg1;
    }

    public String toString() {
        return NodeKind.toString-impl(this.mask);
    }

    public static String toString-impl(int arg2) {
        return "NodeKind(mask=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.mask;
    }
}

