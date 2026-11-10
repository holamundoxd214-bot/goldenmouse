package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001A\u00020\u0005H\u0002J\u0011\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0005H\u0086\u0002J\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0005H\u0002J\u0018\u0010\u0014\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u0005H\u0002J\u001E\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u0019J\u0012\u0010\u001A\u001A\u00020\u00122\n\u0010\u001B\u001A\u00060\u001Cj\u0002`\u001DJ\u0006\u0010\u001E\u001A\u00020\u0005J\b\u0010\u001F\u001A\u00020\u0019H\u0016R\u000E\u0010\t\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/ui/text/input/GapBuffer;", "", "initBuffer", "", "initGapStart", "", "initGapEnd", "<init>", "([CII)V", "capacity", "buffer", "gapStart", "gapEnd", "gapLength", "get", "", "index", "makeSureAvailableSpace", "", "requestSize", "delete", "start", "end", "replace", "text", "", "append", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "length", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class GapBuffer {
    private char[] buffer;
    private int capacity;
    private int gapEnd;
    private int gapStart;

    public GapBuffer(char[] arg2, int arg3, int arg4) {
        super();
        this.capacity = arg2.length;
        this.buffer = arg2;
        this.gapStart = arg3;
        this.gapEnd = arg4;
    }

    public final void append(StringBuilder arg4) {
        Intrinsics.checkNotNullExpressionValue(arg4.append(this.buffer, 0, this.gapStart), "append(...)");
        Intrinsics.checkNotNullExpressionValue(arg4.append(this.buffer, this.gapEnd, this.capacity - this.gapEnd), "append(...)");
    }

    private final void delete(int arg5, int arg6) {
        int v0 = this.gapStart;
        if(arg5 < v0 && arg6 <= v0) {
            int v1 = v0 - arg6;
            ArraysKt.copyInto(this.buffer, this.buffer, this.gapEnd - v1, arg6, v0);
            this.gapStart = arg5;
            this.gapEnd -= v1;
            return;
        }

        if(arg5 < v0 && arg6 >= v0) {
            this.gapEnd = arg6 + this.gapLength();
            this.gapStart = arg5;
            return;
        }

        arg5 += this.gapLength();
        arg6 += this.gapLength();
        v0 = this.gapEnd;
        ArraysKt.copyInto(this.buffer, this.buffer, this.gapStart, v0, arg5);
        this.gapStart += arg5 - v0;
        this.gapEnd = arg6;
    }

    private final int gapLength() {
        return this.gapEnd - this.gapStart;
    }

    public final char get(int arg3) {
        int v0 = this.gapStart;
        char[] v1 = this.buffer;
        if(arg3 < v0) {
            return v1[arg3];
        }

        return v1[arg3 - v0 + this.gapEnd];
    }

    public final int length() {
        return this.capacity - this.gapLength();
    }

    private final void makeSureAvailableSpace(int arg6) {
        if(arg6 <= this.gapLength()) {
            return;
        }

        arg6 -= this.gapLength();
        int v0 = this.capacity;
        while(true) {
            v0 *= 2;
            if(v0 - this.capacity >= arg6) {
                break;
            }
        }

        char[] v6 = new char[v0];
        ArraysKt.copyInto(this.buffer, v6, 0, 0, this.gapStart);
        int v1 = this.capacity - this.gapEnd;
        int v3 = v0 - v1;
        ArraysKt.copyInto(this.buffer, v6, v3, this.gapEnd, v1 + this.gapEnd);
        this.buffer = v6;
        this.capacity = v0;
        this.gapEnd = v3;
    }

    public final void replace(int arg3, int arg4, String arg5) {
        this.makeSureAvailableSpace(arg5.length() - (arg4 - arg3));
        this.delete(arg3, arg4);
        GapBufferKt.access$toCharArray(arg5, this.buffer, this.gapStart);
        this.gapStart += arg5.length();
    }

    public String toString() {
        return v1;
    }
}

