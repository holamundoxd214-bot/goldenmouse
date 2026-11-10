package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ$\u0010\u0012\u001A\u00020\u00132\b\b\u0001\u0010\u0014\u001A\u00020\u00052\b\b\u0001\u0010\u0015\u001A\u00020\u0005H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000ER\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000E¨\u0006\u0018"}, d2={"Landroidx/compose/ui/graphics/PixelMap;", "", "buffer", "", "width", "", "height", "bufferOffset", "stride", "<init>", "([IIIII)V", "getBuffer", "()[I", "getWidth", "()I", "getHeight", "getBufferOffset", "getStride", "get", "Landroidx/compose/ui/graphics/Color;", "x", "y", "get-WaAFU9c", "(II)J", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PixelMap {
    public static final int $stable = 8;
    private final int[] buffer;
    private final int bufferOffset;
    private final int height;
    private final int stride;
    private final int width;

    static {
    }

    public PixelMap(int[] arg1, int arg2, int arg3, int arg4, int arg5) {
        super();
        this.buffer = arg1;
        this.width = arg2;
        this.height = arg3;
        this.bufferOffset = arg4;
        this.stride = arg5;
    }

    public final long get-WaAFU9c(int arg3, int arg4) {
        return ColorKt.Color(this.buffer[this.bufferOffset + arg4 * this.stride + arg3]);
    }

    public final int[] getBuffer() {
        return this.buffer;
    }

    public final int getBufferOffset() {
        return this.bufferOffset;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getStride() {
        return this.stride;
    }

    public final int getWidth() {
        return this.width;
    }
}

