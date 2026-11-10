package kotlinx.serialization.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b!\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\u0006H ¢\u0006\u0002\b\fJ\u000F\u0010\r\u001A\u00028\u0000H ¢\u0006\u0004\b\u000E\u0010\u000FR\u0012\u0010\u0005\u001A\u00020\u0006X \u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2={"Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Array", "", "<init>", "()V", "position", "", "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", "", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "build", "build$kotlinx_serialization_core", "()Ljava/lang/Object;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class PrimitiveArrayBuilder {
    public PrimitiveArrayBuilder() {
        super();
    }

    public abstract Object build$kotlinx_serialization_core();

    public abstract void ensureCapacity$kotlinx_serialization_core(int arg1);

    public static void ensureCapacity$kotlinx_serialization_core$default(PrimitiveArrayBuilder arg0, int arg1, int arg2, Object arg3) {
        if(arg3 == null) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.getPosition$kotlinx_serialization_core() + 1;
            }

            arg0.ensureCapacity$kotlinx_serialization_core(arg1);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
    }

    public abstract int getPosition$kotlinx_serialization_core();
}

