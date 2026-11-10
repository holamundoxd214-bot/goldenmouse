package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u000E\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B\u0017\b\u0000\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000E\u001A\u00020\u000F*\u00028\u0002H\u0004¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001A\u00028\u0001*\u00028\u0002H\u0004¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001A\u00020\u0014*\u00028\u00022\u0006\u0010\u0015\u001A\u00020\u000FH\u0004¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018*\u00028\u0001H\u0004¢\u0006\u0002\u0010\u0019J!\u0010\u001A\u001A\u00020\u0014*\u00028\u00022\u0006\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u001C\u001A\u00028\u0000H\u0004¢\u0006\u0002\u0010\u001DJ\r\u0010\u001E\u001A\u00028\u0002H\u0004¢\u0006\u0002\u0010\u001FJ\r\u0010 \u001A\u00028\u0001H$¢\u0006\u0002\u0010!J-\u0010\"\u001A\u00020\u00142\u0006\u0010#\u001A\u00020$2\u0006\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u001E\u001A\u00028\u00022\u0006\u0010%\u001A\u00020&H$¢\u0006\u0002\u0010\'J%\u0010(\u001A\u00020\u00142\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00028\u00012\u0006\u0010\u0015\u001A\u00020\u000FH$¢\u0006\u0002\u0010,J\u001B\u0010-\u001A\u00020\u00142\u0006\u0010)\u001A\u00020.2\u0006\u0010/\u001A\u00028\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001A\u00028\u00012\u0006\u0010#\u001A\u000202¢\u0006\u0002\u00103R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u00064"}, d2={"Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Element", "Array", "Builder", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "primitiveSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builderSize", "", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)I", "toResult", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)Ljava/lang/Object;", "checkCapacity", "", "size", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "insert", "index", "element", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;ILjava/lang/Object;)V", "builder", "()Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "empty", "()Ljava/lang/Object;", "readElement", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/PrimitiveArrayBuilder;Z)V", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", "content", "(Lkotlinx/serialization/encoding/CompositeEncoder;Ljava/lang/Object;I)V", "serialize", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class PrimitiveArraySerializer extends CollectionLikeSerializer {
    private final SerialDescriptor descriptor;

    public PrimitiveArraySerializer(KSerializer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "primitiveSerializer");
        super(arg2, null);
        this.descriptor = new PrimitiveArrayDescriptor(arg2.getDescriptor());
    }

    public Object builder() {
        return this.builder();
    }

    protected final PrimitiveArrayBuilder builder() {
        return this.toBuilder(this.empty());
    }

    public int builderSize(Object arg1) {
        return this.builderSize(((PrimitiveArrayBuilder)arg1));
    }

    protected final int builderSize(PrimitiveArrayBuilder arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getPosition$kotlinx_serialization_core();
    }

    public void checkCapacity(Object arg1, int arg2) {
        this.checkCapacity(((PrimitiveArrayBuilder)arg1), arg2);
    }

    protected final void checkCapacity(PrimitiveArrayBuilder arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.ensureCapacity$kotlinx_serialization_core(arg2);
    }

    protected final Iterator collectionIterator(Object arg1) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    public final Object deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        return this.merge(arg2, null);
    }

    protected abstract Object empty();

    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void insert(Object arg1, int arg2, Object arg3) {
        this.insert(((PrimitiveArrayBuilder)arg1), arg2, arg3);
    }

    protected final void insert(PrimitiveArrayBuilder arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    protected abstract void readElement(CompositeDecoder arg1, int arg2, PrimitiveArrayBuilder arg3, boolean arg4);

    public final void serialize(Encoder arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg3, "encoder");
        int v0 = this.collectionSize(arg4);
        SerialDescriptor v1 = this.descriptor;
        CompositeEncoder v3 = arg3.beginCollection(v1, v0);
        this.writeContent(v3, arg4, v0);
        v3.endStructure(v1);
    }

    public Object toResult(Object arg1) {
        return this.toResult(((PrimitiveArrayBuilder)arg1));
    }

    protected final Object toResult(PrimitiveArrayBuilder arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.build$kotlinx_serialization_core();
    }

    protected abstract void writeContent(CompositeEncoder arg1, Object arg2, int arg3);
}

