package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001A\u00020\t*\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\f\u001A\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u0002H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u0019H\u0014J\'\u0010\u001A\u001A\u00020\u00132\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\tH\u0014¢\u0006\u0004\b\u001F\u0010 ¨\u0006!"}, d2={"Lkotlinx/serialization/internal/UByteArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UByteArray;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlin/UByte;", "Lkotlinx/serialization/internal/UByteArrayBuilder;", "<init>", "()V", "collectionSize", "", "collectionSize-GBYM_sE", "([B)I", "toBuilder", "toBuilder-GBYM_sE", "([B)Lkotlinx/serialization/internal/UByteArrayBuilder;", "empty", "empty-TcUX1vc", "()[B", "readElement", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "checkIndex", "", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "writeContent-Coi6ktg", "(Lkotlinx/serialization/encoding/CompositeEncoder;[BI)V", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @ExperimentalSerializationApi public final class UByteArraySerializer extends PrimitiveArraySerializer implements KSerializer {
    public static final UByteArraySerializer INSTANCE;

    static {
        UByteArraySerializer.INSTANCE = new UByteArraySerializer();
    }

    private UByteArraySerializer() {
        super(BuiltinSerializersKt.serializer(UByte.Companion));
    }

    public int collectionSize(Object arg1) {
        return this.collectionSize-GBYM_sE(((UByteArray)arg1).unbox-impl());
    }

    protected int collectionSize-GBYM_sE(byte[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$collectionSize");
        return UByteArray.getSize-impl(arg1);
    }

    public Object empty() {
        return UByteArray.box-impl(this.empty-TcUX1vc());
    }

    protected byte[] empty-TcUX1vc() {
        return UByteArray.constructor-impl(0);
    }

    public void readElement(CompositeDecoder arg1, int arg2, Object arg3, boolean arg4) {
        this.readElement(arg1, arg2, ((UByteArrayBuilder)arg3), arg4);
    }

    protected void readElement(CompositeDecoder arg1, int arg2, UByteArrayBuilder arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg1, "decoder");
        Intrinsics.checkNotNullParameter(arg3, "builder");
        arg3.append-7apg3OU$kotlinx_serialization_core(UByte.constructor-impl(arg1.decodeInlineElement(this.getDescriptor(), arg2).decodeByte()));
    }

    public void readElement(CompositeDecoder arg1, int arg2, PrimitiveArrayBuilder arg3, boolean arg4) {
        this.readElement(arg1, arg2, ((UByteArrayBuilder)arg3), arg4);
    }

    public Object toBuilder(Object arg1) {
        return this.toBuilder-GBYM_sE(((UByteArray)arg1).unbox-impl());
    }

    protected UByteArrayBuilder toBuilder-GBYM_sE(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "$this$toBuilder");
        return new UByteArrayBuilder(arg2, null);
    }

    public void writeContent(CompositeEncoder arg1, Object arg2, int arg3) {
        this.writeContent-Coi6ktg(arg1, ((UByteArray)arg2).unbox-impl(), arg3);
    }

    protected void writeContent-Coi6ktg(CompositeEncoder arg4, byte[] arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg4, "encoder");
        Intrinsics.checkNotNullParameter(arg5, "content");
        int v0;
        for(v0 = 0; v0 < arg6; ++v0) {
            arg4.encodeInlineElement(this.getDescriptor(), v0).encodeByte(UByteArray.get-w2LRezQ(arg5, v0));
        }
    }
}

