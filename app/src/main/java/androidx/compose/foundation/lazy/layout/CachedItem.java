package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0002\u001A\u00020\u0001X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/lazy/layout/CachedItem;", "", "key", "mainAxisSize", "", "<init>", "(Ljava/lang/Object;I)V", "getKey", "()Ljava/lang/Object;", "setKey", "(Ljava/lang/Object;)V", "getMainAxisSize", "()I", "setMainAxisSize", "(I)V", "NoKey", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CachedItem {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/foundation/lazy/layout/CachedItem$NoKey;", "", "<init>", "()V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NoKey {
        public NoKey(DefaultConstructorMarker arg1) {
            this();
        }

        private NoKey() {
            super();
        }
    }

    public static final int $stable;
    public static final NoKey NoKey;
    private Object key;
    private int mainAxisSize;

    static {
        CachedItem.NoKey = new NoKey(null);
        CachedItem.$stable = 8;
    }

    public CachedItem(Object arg1, int arg2) {
        super();
        this.key = arg1;
        this.mainAxisSize = arg2;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final void setKey(Object arg1) {
        this.key = arg1;
    }

    public final void setMainAxisSize(int arg1) {
        this.mainAxisSize = arg1;
    }
}

