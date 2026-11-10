package okio;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u0004\u0018\u00010\bJ\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\bJ\u000E\u0010\u000E\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\bJ\u0018\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\bH\u0002J\u0018\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\bH\u0002J\u0015\u0010\u0012\u001A\u00020\u0005*\u00020\b2\u0006\u0010\u0013\u001A\u00020\bH\u0082\nR\u0012\u0010\u0004\u001A\u00020\u00058\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0000@\u0000X\u0081\u000E¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0014"}, d2={"Lokio/PriorityQueue;", "", "<init>", "()V", "size", "", "array", "", "Lokio/AsyncTimeout;", "[Lokio/AsyncTimeout;", "first", "add", "", "node", "remove", "heapifyUp", "vacantIndex", "heapifyDown", "compareTo", "other", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PriorityQueue {
    public AsyncTimeout[] array;
    public int size;

    public PriorityQueue() {
        super();
        this.array = new AsyncTimeout[8];
    }

    public final void add(AsyncTimeout arg9) {
        Intrinsics.checkNotNullParameter(arg9, "node");
        int v0 = this.size + 1;
        this.size = v0;
        AsyncTimeout[] v1 = this.array;
        if(v0 == v1.length) {
            AsyncTimeout[] v2 = new AsyncTimeout[v0 * 2];
            ArraysKt.copyInto$default(((Object[])v1), ((Object[])v2), 0, 0, 0, 14, null);
            this.array = v2;
        }

        this.heapifyUp(v0, arg9);
    }

    private final int compareTo(AsyncTimeout arg5, AsyncTimeout arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        return Intrinsics.compare(0, arg6.getTimeoutAt$okio() - arg5.getTimeoutAt$okio());
    }

    public final AsyncTimeout first() {
        return this.array[1];
    }

    private final void heapifyDown(int arg10, AsyncTimeout arg11) {
        AsyncTimeout v0_1;
        while(true) {
            int v0 = arg10 << 1;
            int v1 = v0 + 1;
            int v2 = this.size;
            long v3 = 0;
            if(v1 <= v2) {
                v0_1 = this.array[v0];
                Intrinsics.checkNotNull(v0_1);
                AsyncTimeout v1_1 = this.array[v1];
                Intrinsics.checkNotNull(v1_1);
                if(Intrinsics.compare(v3, v1_1.getTimeoutAt$okio() - v0_1.getTimeoutAt$okio()) < 0) {
                }
                else {
                    v0_1 = v1_1;
                }

                goto label_23;
            }
            else if(v0 <= v2) {
                v0_1 = this.array[v0];
                Intrinsics.checkNotNull(v0_1);
            label_23:
                if(Intrinsics.compare(v3, v0_1.getTimeoutAt$okio() - arg11.getTimeoutAt$okio()) > 0) {
                    v1 = v0_1.index;
                    v0_1.index = arg10;
                    this.array[arg10] = v0_1;
                    arg10 = v1;
                    continue;
                }
            }

            break;
        }

        this.array[arg10] = arg11;
        arg11.index = arg10;
    }

    private final void heapifyUp(int arg9, AsyncTimeout arg10) {
        while(true) {
            int v0 = arg9 >> 1;
            if(v0 != 0) {
                AsyncTimeout v1 = this.array[v0];
                Intrinsics.checkNotNull(v1);
                if(Intrinsics.compare(0, arg10.getTimeoutAt$okio() - v1.getTimeoutAt$okio()) > 0) {
                    v1.index = arg9;
                    this.array[arg9] = v1;
                    arg9 = v0;
                    continue;
                }
            }

            break;
        }

        this.array[arg9] = arg10;
        arg10.index = arg9;
    }

    public final void remove(AsyncTimeout arg9) {
        Intrinsics.checkNotNullParameter(arg9, "node");
        int v1 = -1;
        if(arg9.index != v1) {
            int v0 = this.size;
            int v2 = arg9.index;
            AsyncTimeout v3 = this.array[v0];
            Intrinsics.checkNotNull(v3);
            arg9.index = v1;
            this.array[v0] = null;
            this.size = v0 - 1;
            if(arg9 == v3) {
                return;
            }

            int v9 = Intrinsics.compare(0, v3.getTimeoutAt$okio() - arg9.getTimeoutAt$okio());
            if(v9 == 0) {
                this.array[v2] = v3;
                v3.index = v2;
                return;
            }

            if(v9 < 0) {
                this.heapifyDown(v2, v3);
                return;
            }

            this.heapifyUp(v2, v3);
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

