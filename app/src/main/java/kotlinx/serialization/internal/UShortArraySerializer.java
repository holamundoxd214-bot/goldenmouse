package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001A\u00020\t*\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\f\u001A\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u0002H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u0019H\u0014J\'\u0010\u001A\u001A\u00020\u00132\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\tH\u0014¢\u0006\u0004\b\u001F\u0010 ¨\u0006!"}, d2={"Lkotlinx/serialization/internal/UShortArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UShortArray;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlin/UShort;", "Lkotlinx/serialization/internal/UShortArrayBuilder;", "<init>", "()V", "collectionSize", "", "collectionSize-rL5Bavg", "([S)I", "toBuilder", "toBuilder-rL5Bavg", "([S)Lkotlinx/serialization/internal/UShortArrayBuilder;", "empty", "empty-amswpOA", "()[S", "readElement", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "checkIndex", "", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "writeContent-eny0XGE", "(Lkotlinx/serialization/encoding/CompositeEncoder;[SI)V", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @ExperimentalSerializationApi public final class UShortArraySerializer extends PrimitiveArraySerializer implements KSerializer {
    public static final UShortArraySerializer INSTANCE;

    static {
        UShortArraySerializer.INSTANCE = new UShortArraySerializer();
    }

    private UShortArraySerializer() {
        super(BuiltinSerializersKt.serializer(UShort.Companion));
    }

    public int collectionSize(Object arg1) {
        return this.collectionSize-rL5Bavg(((UShortArray)arg1).unbox-impl());
    }

    protected int collectionSize-rL5Bavg(short[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$collectionSize");
        return UShortArray.getSize-impl(arg1);
    }

    public Object empty() {
        return UShortArray.box-impl(this.empty-amswpOA());
    }

    protected short[] empty-amswpOA() {
        return UShortArray.constructor-impl(0);
    }

    public void readElement(CompositeDecoder arg1, int arg2, Object arg3, boolean arg4) {
        this.readElement(arg1, arg2, ((UShortArrayBuilder)arg3), arg4);
    }

    protected void readElement(CompositeDecoder arg1, int arg2, UShortArrayBuilder arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg1, "decoder");
        Intrinsics.checkNotNullParameter(arg3, "builder");
        arg3.append-xj2QHRw$kotlinx_serialization_core(UShort.constructor-impl(arg1.decodeInlineElement(this.getDescriptor(), arg2).decodeShort()));
    }

    public void readElement(CompositeDecoder arg1, int arg2, PrimitiveArrayBuilder arg3, boolean arg4) {
        this.readElement(arg1, arg2, ((UShortArrayBuilder)arg3), arg4);
    }

    public Object toBuilder(Object arg1) {
        return this.toBuilder-rL5Bavg(((UShortArray)arg1).unbox-impl());
    }

    protected UShortArrayBuilder toBuilder-rL5Bavg(short[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "$this$toBuilder");
        return new UShortArrayBuilder(arg2, null);
    }

    public void writeContent(CompositeEncoder arg1, Object arg2, int arg3) {
        this.writeContent-eny0XGE(arg1, ((UShortArray)arg2).unbox-impl(), arg3);
    }

    protected void writeContent-eny0XGE(CompositeEncoder arg4, short[] arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg4, "encoder");
        Intrinsics.checkNotNullParameter(arg5, "content");
        int v0;
        for(v0 = 0; v0 < arg6; ++v0) {
            arg4.encodeInlineElement(this.getDescriptor(), v0).encodeShort(UShortArray.get-Mh2AYeg(arg5, v0));
        }
    }
}

