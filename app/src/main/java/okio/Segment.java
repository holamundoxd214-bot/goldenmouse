package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u0002\u0010\fJ\u0006\u0010\u000F\u001A\u00020\u0000J\u0006\u0010\u0010\u001A\u00020\u0000J\b\u0010\u0011\u001A\u0004\u0018\u00010\u0000J\u000E\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0013\u001A\u00020\u0000J\u000E\u0010\u0014\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u0007J\u0006\u0010\u0016\u001A\u00020\u0017J\u0016\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u0007R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u00020\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001A\u00020\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u00020\n8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u000B\u001A\u00020\n8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Lokio/Segment;", "", "<init>", "()V", "data", "", "pos", "", "limit", "shared", "", "owner", "([BIIZZ)V", "next", "prev", "sharedCopy", "unsharedCopy", "pop", "push", "segment", "split", "byteCount", "compact", "", "writeTo", "sink", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Segment {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Lokio/Segment$Companion;", "", "<init>", "()V", "SIZE", "", "SHARE_MINIMUM", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    public static final int SHARE_MINIMUM = 0x400;
    public static final int SIZE = 0x2000;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    static {
        Segment.Companion = new Companion(null);
    }

    public Segment() {
        super();
        this.data = new byte[0x2000];
        this.owner = true;
        this.shared = false;
    }

    public Segment(byte[] arg2, int arg3, int arg4, boolean arg5, boolean arg6) {
        Intrinsics.checkNotNullParameter(arg2, "data");
        super();
        this.data = arg2;
        this.pos = arg3;
        this.limit = arg4;
        this.shared = arg5;
        this.owner = arg6;
    }

    public final void compact() {
        int v2_1;
        Segment v1;
        int v0_1;
        Segment v0 = this.prev;
        if(v0 == this) {
            goto label_31;
        }

        Intrinsics.checkNotNull(v0);
        if(!v0.owner) {
        }
        else {
            v0_1 = this.limit - this.pos;
            v1 = this.prev;
            Intrinsics.checkNotNull(v1);
            int v1_1 = 0x2000 - v1.limit;
            Segment v2 = this.prev;
            Intrinsics.checkNotNull(v2);
            if(v2.shared) {
                v2_1 = 0;
            }
            else {
                v2 = this.prev;
                Intrinsics.checkNotNull(v2);
                v2_1 = v2.pos;
            }

            if(v0_1 <= v1_1 + v2_1) {
                goto label_25;
            }
        }

        return;
    label_25:
        v1 = this.prev;
        Intrinsics.checkNotNull(v1);
        this.writeTo(v1, v0_1);
        this.pop();
        SegmentPool.recycle(this);
        return;
    label_31:
        throw new IllegalStateException("cannot compact".toString());
    }

    public final Segment pop() {
        Segment v0 = this.next;
        Segment v1 = null;
        if(v0 != this) {
        }
        else {
            v0 = v1;
        }

        Segment v2 = this.prev;
        Intrinsics.checkNotNull(v2);
        v2.next = this.next;
        v2 = this.next;
        Intrinsics.checkNotNull(v2);
        v2.prev = this.prev;
        this.next = v1;
        this.prev = v1;
        return v0;
    }

    public final Segment push(Segment arg2) {
        Intrinsics.checkNotNullParameter(arg2, "segment");
        arg2.prev = this;
        arg2.next = this.next;
        Segment v0 = this.next;
        Intrinsics.checkNotNull(v0);
        v0.prev = arg2;
        this.next = arg2;
        return arg2;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int arg9) {
        Segment v0;
        if(arg9 > 0 && arg9 <= this.limit - this.pos) {
            if(arg9 >= 0x400) {
                v0 = this.sharedCopy();
            }
            else {
                v0 = SegmentPool.take();
                ArraysKt.copyInto$default(this.data, v0.data, 0, this.pos, this.pos + arg9, 2, null);
            }

            v0.limit = v0.pos + arg9;
            this.pos += arg9;
            this = this.prev;
            Intrinsics.checkNotNull(this);
            this.push(v0);
            return v0;
        }

        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final Segment unsharedCopy() {
        byte[] v1 = Arrays.copyOf(this.data, this.data.length);
        Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
        return new Segment(v1, this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg9, "sink");
        if(arg9.owner) {
            int v5 = arg9.limit;
            int v1 = 0x2000;
            if(v5 + arg10 > v1) {
                if(!arg9.shared) {
                    int v4 = arg9.pos;
                    if(v5 + arg10 - v4 <= v1) {
                        ArraysKt.copyInto$default(arg9.data, arg9.data, 0, v4, v5, 2, null);
                        v5 = arg9.limit - arg9.pos;
                        arg9.limit = v5;
                        arg9.pos = 0;
                    }
                    else {
                        throw new IllegalArgumentException();
                    }
                }
                else {
                    throw new IllegalArgumentException();
                }
            }

            ArraysKt.copyInto(this.data, arg9.data, v5, this.pos, this.pos + arg10);
            arg9.limit += arg10;
            this.pos += arg10;
            return;
        }

        throw new IllegalStateException("only owner can write".toString());
    }
}

