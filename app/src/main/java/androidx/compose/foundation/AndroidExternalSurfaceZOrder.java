package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u0005J\u0010\u0010\u000F\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "", "zOrder", "", "constructor-impl", "(I)I", "getZOrder", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class AndroidExternalSurfaceZOrder {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/foundation/AndroidExternalSurfaceZOrder$Companion;", "", "<init>", "()V", "Behind", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "getBehind-B_4ceCc", "()I", "I", "MediaOverlay", "getMediaOverlay-B_4ceCc", "OnTop", "getOnTop-B_4ceCc", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getBehind-B_4ceCc() {
            return AndroidExternalSurfaceZOrder.Behind;
        }

        public final int getMediaOverlay-B_4ceCc() {
            return AndroidExternalSurfaceZOrder.MediaOverlay;
        }

        public final int getOnTop-B_4ceCc() {
            return AndroidExternalSurfaceZOrder.OnTop;
        }
    }

    private static final int Behind;
    public static final Companion Companion;
    private static final int MediaOverlay;
    private static final int OnTop;
    private final int zOrder;

    static {
        AndroidExternalSurfaceZOrder.Companion = new Companion(null);
        AndroidExternalSurfaceZOrder.Behind = AndroidExternalSurfaceZOrder.constructor-impl(0);
        AndroidExternalSurfaceZOrder.MediaOverlay = AndroidExternalSurfaceZOrder.constructor-impl(1);
        AndroidExternalSurfaceZOrder.OnTop = AndroidExternalSurfaceZOrder.constructor-impl(2);
    }

    private AndroidExternalSurfaceZOrder(int arg1) {
        super();
        this.zOrder = arg1;
    }

    public static final int access$getBehind$cp() {
        return AndroidExternalSurfaceZOrder.Behind;
    }

    public static final int access$getMediaOverlay$cp() {
        return AndroidExternalSurfaceZOrder.MediaOverlay;
    }

    public static final int access$getOnTop$cp() {
        return AndroidExternalSurfaceZOrder.OnTop;
    }

    public static final AndroidExternalSurfaceZOrder box-impl(int arg1) {
        return new AndroidExternalSurfaceZOrder(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return AndroidExternalSurfaceZOrder.equals-impl(this.zOrder, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof AndroidExternalSurfaceZOrder)) {
            return 0;
        }

        if(arg2 != ((AndroidExternalSurfaceZOrder)arg3).unbox-impl()) {
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

    public final int getZOrder() {
        return this.zOrder;
    }

    public int hashCode() {
        return AndroidExternalSurfaceZOrder.hashCode-impl(this.zOrder);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return AndroidExternalSurfaceZOrder.toString-impl(this.zOrder);
    }

    public static String toString-impl(int arg2) {
        return "AndroidExternalSurfaceZOrder(zOrder=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.zOrder;
    }
}

