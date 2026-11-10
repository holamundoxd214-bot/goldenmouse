package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\tH\u0010¢\u0006\u0002\b\u0010J\u0017\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0002H\u0010¢\u0006\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0006\u001A\u00020\u0002X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0007R\u001E\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t@RX\u0090\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0019"}, d2={"Lkotlinx/serialization/internal/UByteArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlin/UByteArray;", "bufferWithData", "<init>", "([BLkotlin/jvm/internal/DefaultConstructorMarker;)V", "buffer", "[B", "value", "", "position", "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", "", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "append", "c", "Lkotlin/UByte;", "append-7apg3OU$kotlinx_serialization_core", "(B)V", "build", "build-TcUX1vc$kotlinx_serialization_core", "()[B", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @ExperimentalSerializationApi public final class UByteArrayBuilder extends PrimitiveArrayBuilder {
    private byte[] buffer;
    private int position;

    private UByteArrayBuilder(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "bufferWithData");
        super();
        this.buffer = arg2;
        this.position = UByteArray.getSize-impl(arg2);
        this.ensureCapacity$kotlinx_serialization_core(10);
    }

    public UByteArrayBuilder(byte[] arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public final void append-7apg3OU$kotlinx_serialization_core(byte arg5) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        byte[] v0 = this.buffer;
        int v1 = this.getPosition$kotlinx_serialization_core();
        this.position = v1 + 1;
        UByteArray.set-VurrAj0(v0, v1, arg5);
    }

    public Object build$kotlinx_serialization_core() {
        return UByteArray.box-impl(this.build-TcUX1vc$kotlinx_serialization_core());
    }

    public byte[] build-TcUX1vc$kotlinx_serialization_core() {
        byte[] v1 = Arrays.copyOf(this.buffer, this.getPosition$kotlinx_serialization_core());
        Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
        return UByteArray.constructor-impl(v1);
    }

    public void ensureCapacity$kotlinx_serialization_core(int arg3) {
        if(UByteArray.getSize-impl(this.buffer) < arg3) {
            byte[] v3 = Arrays.copyOf(this.buffer, RangesKt.coerceAtLeast(arg3, UByteArray.getSize-impl(this.buffer) * 2));
            Intrinsics.checkNotNullExpressionValue(v3, "copyOf(...)");
            this.buffer = UByteArray.constructor-impl(v3);
        }
    }

    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }
}

