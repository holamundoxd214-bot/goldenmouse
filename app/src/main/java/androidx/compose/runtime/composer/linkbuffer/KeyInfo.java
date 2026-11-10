package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.JoinedKey;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001B7\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001\u0012\n\u0010\u0005\u001A\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003¢\u0006\u0004\b\n\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0015\u0010\u0005\u001A\u00060\u0006j\u0002`\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\rR\u0012\u0010\u0014\u001A\u00020\u00038Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001A\u00020\u00018F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u000F¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/KeyInfo;", "", "key", "", "objectKey", "handle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "nodes", "index", "<init>", "(ILjava/lang/Object;JII)V", "getKey", "()I", "getObjectKey", "()Ljava/lang/Object;", "getHandle", "()J", "getNodes", "getIndex", "address", "getAddress", "joinedKey", "getJoinedKey", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class KeyInfo {
    public static final int $stable = 8;
    private final long handle;
    private final int index;
    private final int key;
    private final int nodes;
    private final Object objectKey;

    static {
    }

    public KeyInfo(int arg1, Object arg2, long arg3, int arg5, int arg6) {
        super();
        this.key = arg1;
        this.objectKey = arg2;
        this.handle = arg3;
        this.nodes = arg5;
        this.index = arg6;
    }

    public final int getAddress() {
        return GroupHandleKt.getGroup(this.getHandle());
    }

    public final long getHandle() {
        return this.handle;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Object getJoinedKey() {
        if(this.objectKey != null) {
            return new JoinedKey(Integer.valueOf(this.key), this.objectKey);
        }

        return Integer.valueOf(this.key);
    }

    public final int getKey() {
        return this.key;
    }

    public final int getNodes() {
        return this.nodes;
    }

    public final Object getObjectKey() {
        return this.objectKey;
    }
}

