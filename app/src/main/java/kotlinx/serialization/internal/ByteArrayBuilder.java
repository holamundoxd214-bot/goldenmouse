package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\bH\u0010¢\u0006\u0002\b\u000FJ\u0015\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001A\u00020\u0002H\u0010¢\u0006\u0002\b\u0015R\u000E\u0010\u0006\u001A\u00020\u0002X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\b@RX\u0090\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2={"Lkotlinx/serialization/internal/ByteArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "<init>", "([B)V", "buffer", "value", "", "position", "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", "", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "append", "c", "", "append$kotlinx_serialization_core", "build", "build$kotlinx_serialization_core", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ByteArrayBuilder extends PrimitiveArrayBuilder {
    private byte[] buffer;
    private int position;

    public ByteArrayBuilder(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "bufferWithData");
        super();
        this.buffer = arg2;
        this.position = arg2.length;
        this.ensureCapacity$kotlinx_serialization_core(10);
    }

    public final void append$kotlinx_serialization_core(byte arg5) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        byte[] v0 = this.buffer;
        int v1 = this.getPosition$kotlinx_serialization_core();
        this.position = v1 + 1;
        v0[v1] = arg5;
    }

    public Object build$kotlinx_serialization_core() {
        return this.build$kotlinx_serialization_core();
    }

    public byte[] build$kotlinx_serialization_core() {
        byte[] v1 = Arrays.copyOf(this.buffer, this.getPosition$kotlinx_serialization_core());
        Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
        return v1;
    }

    public void ensureCapacity$kotlinx_serialization_core(int arg3) {
        byte[] v0 = this.buffer;
        if(v0.length < arg3) {
            byte[] v3 = Arrays.copyOf(v0, RangesKt.coerceAtLeast(arg3, v0.length * 2));
            Intrinsics.checkNotNullExpressionValue(v3, "copyOf(...)");
            this.buffer = v3;
        }
    }

    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }
}

