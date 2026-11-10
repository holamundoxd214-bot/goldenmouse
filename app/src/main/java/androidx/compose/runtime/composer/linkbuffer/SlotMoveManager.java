package androidx.compose.runtime.composer.linkbuffer;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\'\u0012\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u000EJ\u0013\u0010\u0017\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001A\u00020\u0013H\u0002R\u001B\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\bR$\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\t\u001A\u0004\b\n\u0010\b\"\u0004\b\u000B\u0010\fR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotMoveManager;", "", "source", "", "destination", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;)V", "getSource", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getDestination", "setDestination", "([Ljava/lang/Object;)V", "pendingMoveOffset", "", "pendingMoveStart", "pendingMoveEnd", "highest", "move", "", "destinationOffset", "startIndex", "endIndex", "done", "flush", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SlotMoveManager {
    public static final int $stable = 8;
    private Object[] destination;
    private int highest;
    private int pendingMoveEnd;
    private int pendingMoveOffset;
    private int pendingMoveStart;
    private final Object[] source;

    static {
    }

    public SlotMoveManager(Object[] arg1, Object[] arg2) {
        super();
        this.source = arg1;
        this.destination = arg2;
        this.pendingMoveOffset = -1;
        this.pendingMoveStart = -1;
        this.pendingMoveEnd = -1;
        this.highest = -1;
    }

    public final Object[] done() {
        this.flush();
        int v0 = this.highest;
        if(v0 >= 0) {
            Object[] v1 = this.destination;
            if(v0 < v1.length) {
                int v2 = v1.length;
                if(v2 == v0 + 1) {
                    v1[v0] = SlotTableAddresSpaceKt.access$getUnallocated$p();
                }
                else {
                    ArraysKt.fill(v1, SlotTableAddresSpaceKt.access$getUnallocated$p(), v0, v2);
                }
            }
        }

        return this.destination;
    }

    private final void flush() {
        int v0 = this.pendingMoveOffset;
        if(v0 >= 0) {
            Object[] v1 = this.source;
            ArraysKt.copyInto(v1, this.destination, v0, this.pendingMoveStart, this.pendingMoveEnd);
            if(v1 == this.destination) {
                ArraysKt.fill(v1, SlotTableAddresSpaceKt.access$getUnallocated$p(), this.pendingMoveStart, this.pendingMoveEnd);
            }

            v0 = this.pendingMoveOffset + (this.pendingMoveEnd - this.pendingMoveStart);
            this.pendingMoveOffset = -1;
            this.pendingMoveEnd = -1;
            if(v0 <= this.highest) {
                return;
            }

            this.highest = v0;
        }
    }

    public final Object[] getDestination() {
        return this.destination;
    }

    public final Object[] getSource() {
        return this.source;
    }

    public final void move(int arg6, int arg7, int arg8) {
        Object[] v0 = this.source;
        Object[] v1 = this.destination;
        if(v0 == v1) {
            if(arg7 == arg6) {
                return;
            }
            else {
                int v0_1 = arg8 - arg7 + arg6 + arg6;
                if(v0_1 >= v1.length) {
                }
                else {
                    int v2 = arg6;
                    while(true) {
                        if(v2 >= v0_1) {
                            goto label_25;
                        }
                        else if(v1[v2] == SlotTableAddresSpaceKt.access$getUnallocated$p()) {
                            ++v2;
                            continue;
                        }

                        break;
                    }
                }

                v0 = Arrays.copyOf(this.source, this.source.length);
                Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
                this.destination = v0;
            }
        }

    label_25:
        if(this.pendingMoveEnd == arg7) {
            this.pendingMoveEnd = arg8;
            return;
        }

        this.flush();
        this.pendingMoveOffset = arg6;
        this.pendingMoveStart = arg7;
        this.pendingMoveEnd = arg8;
    }

    public final void setDestination(Object[] arg1) {
        this.destination = arg1;
    }
}

