package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\b\u001A\u00020\t*\u00020\u0002H\u0014J\f\u0010\n\u001A\u00020\u0005*\u00020\u0002H\u0014J\b\u0010\u000B\u001A\u00020\u0002H\u0014J(\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0013H\u0014J \u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00022\u0006\u0010\u0018\u001A\u00020\tH\u0014¨\u0006\u0019"}, d2={"Lkotlinx/serialization/internal/FloatArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "", "Lkotlinx/serialization/internal/FloatArrayBuilder;", "<init>", "()V", "collectionSize", "", "toBuilder", "empty", "readElement", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "checkIndex", "", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FloatArraySerializer extends PrimitiveArraySerializer implements KSerializer {
    public static final FloatArraySerializer INSTANCE;

    static {
        FloatArraySerializer.INSTANCE = new FloatArraySerializer();
    }

    private FloatArraySerializer() {
        super(BuiltinSerializersKt.serializer(FloatCompanionObject.INSTANCE));
    }

    public int collectionSize(Object arg1) {
        return this.collectionSize(((float[])arg1));
    }

    protected int collectionSize(float[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.length;
    }

    public Object empty() {
        return this.empty();
    }

    protected float[] empty() {
        return new float[0];
    }

    public void readElement(CompositeDecoder arg1, int arg2, Object arg3, boolean arg4) {
        this.readElement(arg1, arg2, ((FloatArrayBuilder)arg3), arg4);
    }

    protected void readElement(CompositeDecoder arg1, int arg2, FloatArrayBuilder arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg1, "decoder");
        Intrinsics.checkNotNullParameter(arg3, "builder");
        arg3.append$kotlinx_serialization_core(arg1.decodeFloatElement(this.getDescriptor(), arg2));
    }

    public void readElement(CompositeDecoder arg1, int arg2, PrimitiveArrayBuilder arg3, boolean arg4) {
        this.readElement(arg1, arg2, ((FloatArrayBuilder)arg3), arg4);
    }

    public Object toBuilder(Object arg1) {
        return this.toBuilder(((float[])arg1));
    }

    protected FloatArrayBuilder toBuilder(float[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new FloatArrayBuilder(arg1);
    }

    public void writeContent(CompositeEncoder arg1, Object arg2, int arg3) {
        this.writeContent(arg1, ((float[])arg2), arg3);
    }

    protected void writeContent(CompositeEncoder arg4, float[] arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg4, "encoder");
        Intrinsics.checkNotNullParameter(arg5, "content");
        int v0;
        for(v0 = 0; v0 < arg6; ++v0) {
            arg4.encodeFloatElement(this.getDescriptor(), v0, arg5[v0]);
        }
    }
}

