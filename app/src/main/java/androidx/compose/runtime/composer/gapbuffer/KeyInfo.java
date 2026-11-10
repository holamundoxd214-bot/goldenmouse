package androidx.compose.runtime.composer.gapbuffer;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000E\b\u0001\u0018\u00002\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000BR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000B¨\u0006\u0011"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/KeyInfo;", "", "key", "", "objectKey", "location", "nodes", "index", "<init>", "(ILjava/lang/Object;III)V", "getKey", "()I", "getObjectKey", "()Ljava/lang/Object;", "getLocation", "getNodes", "getIndex", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class KeyInfo {
    public static final int $stable = 8;
    private final int index;
    private final int key;
    private final int location;
    private final int nodes;
    private final Object objectKey;

    static {
    }

    public KeyInfo(int arg1, Object arg2, int arg3, int arg4, int arg5) {
        super();
        this.key = arg1;
        this.objectKey = arg2;
        this.location = arg3;
        this.nodes = arg4;
        this.index = arg5;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getKey() {
        return this.key;
    }

    public final int getLocation() {
        return this.location;
    }

    public final int getNodes() {
        return this.nodes;
    }

    public final Object getObjectKey() {
        return this.objectKey;
    }
}

