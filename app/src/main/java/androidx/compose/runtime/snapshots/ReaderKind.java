package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0086\b¢\u0006\u0004\b\n\u0010\u000BJ\u0018\u0010\f\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\u0000H\u0086\b¢\u0006\u0004\b\u000E\u0010\u000FJ\u0014\u0010\u0010\u001A\u00020\r2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001A\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001A\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016"}, d2={"Landroidx/compose/runtime/snapshots/ReaderKind;", "", "mask", "", "constructor-impl", "(I)I", "getMask", "()I", "withReadIn", "reader", "withReadIn-3QSx2Dw", "(II)I", "isReadIn", "", "isReadIn-h_f27i8", "(II)Z", "equals", "other", "hashCode", "toString", "", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class ReaderKind {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2={"Landroidx/compose/runtime/snapshots/ReaderKind$Companion;", "", "<init>", "()V", "Composition", "Landroidx/compose/runtime/snapshots/ReaderKind;", "getComposition-6f8NoZ8", "()I", "SnapshotStateObserver", "getSnapshotStateObserver-6f8NoZ8", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getComposition-6f8NoZ8() {
            return ReaderKind.constructor-impl(1);
        }

        public final int getSnapshotStateObserver-6f8NoZ8() {
            return ReaderKind.constructor-impl(2);
        }
    }

    public static final Companion Companion;
    private final int mask;

    static {
        ReaderKind.Companion = new Companion(null);
    }

    private ReaderKind(int arg1) {
        super();
        this.mask = arg1;
    }

    public static final ReaderKind box-impl(int arg1) {
        return new ReaderKind(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public static int constructor-impl$default(int arg0, int arg1, DefaultConstructorMarker arg2) {
        return ReaderKind.constructor-impl(0);
    }

    public boolean equals(Object arg1) {
        return ReaderKind.equals-impl(this.mask, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof ReaderKind)) {
            return 0;
        }

        if(arg2 != ((ReaderKind)arg3).unbox-impl()) {
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
        return ReaderKind.hashCode-impl(this.mask);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public static final boolean isReadIn-h_f27i8(int arg0, int arg1) {
        if((arg0 & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return ReaderKind.toString-impl(this.mask);
    }

    public static String toString-impl(int arg2) {
        return "ReaderKind(mask=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.mask;
    }

    public static final int withReadIn-3QSx2Dw(int arg0, int arg1) {
        return ReaderKind.constructor-impl(arg0 | arg1);
    }
}

