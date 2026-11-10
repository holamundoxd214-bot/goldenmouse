package androidx.compose.ui.text.style;

import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0002\u001A\u0010\u0010\u0005\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0001H\u0002\u001A\u0010\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0001H\u0002\u001A\u0010\u0010\b\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0001H\u0002¨\u0006\t"}, d2={"packBytes", "", "i1", "i2", "i3", "unpackByte1", "mask", "unpackByte2", "unpackByte3", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LineBreak_androidKt {
    public static final int access$packBytes(int arg0, int arg1, int arg2) {
        return LineBreak_androidKt.packBytes(arg0, arg1, arg2);
    }

    public static final int access$unpackByte1(int arg0) {
        return LineBreak_androidKt.unpackByte1(arg0);
    }

    public static final int access$unpackByte2(int arg0) {
        return LineBreak_androidKt.unpackByte2(arg0);
    }

    public static final int access$unpackByte3(int arg0) {
        return LineBreak_androidKt.unpackByte3(arg0);
    }

    private static final int packBytes(int arg0, int arg1, int arg2) {
        return arg0 | arg1 << 8 | arg2 << 16;
    }

    private static final int unpackByte1(int arg0) {
        return arg0 & 0xFF;
    }

    private static final int unpackByte2(int arg0) {
        return arg0 >> 8 & 0xFF;
    }

    private static final int unpackByte3(int arg0) {
        return arg0 >> 16 & 0xFF;
    }
}

