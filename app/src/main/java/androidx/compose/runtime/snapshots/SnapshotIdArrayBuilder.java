package androidx.compose.runtime.snapshots;

import androidx.collection.LongList;
import androidx.collection.MutableLongList;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000E\u0010\u0002\u001A\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\t\u001A\u00020\n2\n\u0010\u000B\u001A\u00060\fj\u0002`\rJ\u000E\u0010\u000E\u001A\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotIdArrayBuilder;", "", "array", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "<init>", "([J)V", "list", "Landroidx/collection/MutableLongList;", "add", "", "id", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "toArray", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotIdArrayBuilder {
    public static final int $stable = 8;
    private final MutableLongList list;

    static {
    }

    public SnapshotIdArrayBuilder(long[] arg4) {
        MutableLongList v0;
        super();
        if(arg4 != null) {
            arg4 = Arrays.copyOf(arg4, arg4.length);
            v0 = new MutableLongList(arg4.length);
            v0.addAll(v0._size, arg4);
        }
        else {
            v0 = new MutableLongList(0, 1, null);
        }

        this.list = v0;
    }

    public final void add(long arg1) {
        this.list.add(arg1);
    }

    public final long[] toArray() {
        int v0 = this.list._size;
        if(v0 == 0) {
            return null;
        }

        long[] v0_1 = new long[v0];
        MutableLongList v5 = this.list;
        long[] v1 = ((LongList)v5).content;
        int v5_1 = ((LongList)v5)._size;
        int v2;
        for(v2 = 0; v2 < v5_1; ++v2) {
            v0_1[v2] = v1[v2];
        }

        return v0_1;
    }
}

