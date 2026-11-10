package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.input.pointer.PointerId;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0005H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u000EH\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J\u000E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u0018J\u000E\u0010\u0019\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u0005J\u0006\u0010\u001A\u001A\u00020\u0013J\u000E\u0010\u001B\u001A\u00020\u00132\u0006\u0010\u0004\u001A\u00020\u0018J\u0018\u0010\u001B\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u000EH\u0086\b¢\u0006\u0004\b\u001C\u0010\u0016J\u0019\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0018H\u0086\u0002J\u0010\u0010\u001F\u001A\u00020\f2\u0006\u0010 \u001A\u00020\u0005H\u0002J \u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u000EH\u0086\n¢\u0006\u0004\b!\u0010\"J\u0006\u0010#\u001A\u00020\u001EJ\u0018\u0010$\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u000EH\u0086\b¢\u0006\u0004\b%\u0010\u0016J\u000E\u0010$\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u0018R\u001E\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\n\u0010\bR\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "", "<init>", "()V", "value", "", "size", "getSize", "()I", "lastIndex", "getLastIndex", "internalArray", "", "get", "Landroidx/compose/ui/input/pointer/PointerId;", "index", "get-_I2yYro", "(I)J", "remove", "", "pointerId", "remove-0FcD4WY", "(J)Z", "pointerIdValue", "", "removeAt", "isEmpty", "add", "add-0FcD4WY", "set", "", "resizeStorage", "minSize", "set-DmW0f2w", "(IJ)V", "clear", "contains", "contains-0FcD4WY", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PointerIdArray {
    public static final int $stable = 8;
    private long[] internalArray;
    private int size;

    static {
    }

    public PointerIdArray() {
        super();
        this.internalArray = new long[2];
    }

    public final boolean add(long arg2) {
        if(!this.contains(arg2)) {
            this.set(this.size, arg2);
            return 1;
        }

        return 0;
    }

    public final boolean add-0FcD4WY(long arg1) {
        return this.add(arg1);
    }

    public final void clear() {
        this.size = 0;
    }

    public final boolean contains(long arg7) {
        int v0 = this.size;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(this.internalArray[v2] == arg7) {
                return 1;
            }
        }

        return 0;
    }

    public final boolean contains-0FcD4WY(long arg1) {
        return this.contains(arg1);
    }

    public final long get-_I2yYro(int arg3) {
        return PointerId.constructor-impl(this.internalArray[arg3]);
    }

    public final int getLastIndex() {
        return this.getSize() - 1;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean isEmpty() {
        if(this.size == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean remove(long arg7) {
        int v0 = this.size;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(arg7 == this.internalArray[v2]) {
                int v7 = this.size - 1;
                goto label_10;
            }
        }

        return 0;
    label_10:
        while(v2 < v7) {
            int v1 = v2 + 1;
            this.internalArray[v2] = this.internalArray[v1];
            v2 = v1;
        }

        --this.size;
        return 1;
    }

    public final boolean remove-0FcD4WY(long arg1) {
        return this.remove(arg1);
    }

    public final boolean removeAt(int arg7) {
        int v0 = this.size;
        if(arg7 < v0) {
            --v0;
            while(arg7 < v0) {
                int v3 = arg7 + 1;
                this.internalArray[arg7] = this.internalArray[v3];
                arg7 = v3;
            }

            --this.size;
            return 1;
        }

        return 0;
    }

    private final long[] resizeStorage(int arg3) {
        long[] v3 = Arrays.copyOf(this.internalArray, Math.max(arg3, this.internalArray.length * 2));
        Intrinsics.checkNotNullExpressionValue(v3, "copyOf(...)");
        this.internalArray = v3;
        return v3;
    }

    public final void set(int arg3, long arg4) {
        long[] v0 = this.internalArray;
        if(arg3 >= v0.length) {
            v0 = this.resizeStorage(arg3 + 1);
        }

        v0[arg3] = arg4;
        if(arg3 >= this.size) {
            this.size = arg3 + 1;
        }
    }

    public final void set-DmW0f2w(int arg1, long arg2) {
        this.set(arg1, arg2);
    }
}

