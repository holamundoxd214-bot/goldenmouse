package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001A\u00020\b*\u00028\u0001H$¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u000B*\u00028\u0001H$¢\u0006\u0002\u0010\fJ\r\u0010\r\u001A\u00028\u0002H$¢\u0006\u0002\u0010\u000EJ\u0011\u0010\u000F\u001A\u00020\b*\u00028\u0002H$¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001A\u00028\u0001*\u00028\u0002H$¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0012\u001A\u00028\u0002*\u00028\u0001H$¢\u0006\u0002\u0010\u0011J\u0019\u0010\u0013\u001A\u00020\u0014*\u00028\u00022\u0006\u0010\u0015\u001A\u00020\bH$¢\u0006\u0002\u0010\u0016J\u001D\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00028\u0001H&¢\u0006\u0002\u0010\u001BJ\u001F\u0010\u001C\u001A\u00028\u00012\u0006\u0010\u001D\u001A\u00020\u001E2\b\u0010\u001F\u001A\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0002\u0010 J\u0015\u0010!\u001A\u00028\u00012\u0006\u0010\u001D\u001A\u00020\u001EH\u0016¢\u0006\u0002\u0010\"J\u001D\u0010#\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020$2\u0006\u0010\r\u001A\u00028\u0002H\u0002¢\u0006\u0002\u0010%J/\u0010&\u001A\u00020\u00142\u0006\u0010\u001D\u001A\u00020$2\u0006\u0010\'\u001A\u00020\b2\u0006\u0010\r\u001A\u00028\u00022\b\b\u0002\u0010(\u001A\u00020)H$¢\u0006\u0002\u0010*J-\u0010+\u001A\u00020\u00142\u0006\u0010\u001D\u001A\u00020$2\u0006\u0010\r\u001A\u00028\u00022\u0006\u0010,\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\bH$¢\u0006\u0002\u0010-\u0082\u0001\u0002./¨\u00060"}, d2={"Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/KSerializer;", "<init>", "()V", "collectionSize", "", "(Ljava/lang/Object;)I", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "builder", "()Ljava/lang/Object;", "builderSize", "toResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "toBuilder", "checkCapacity", "", "size", "(Ljava/lang/Object;I)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "merge", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "previous", "(Lkotlinx/serialization/encoding/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "readSize", "Lkotlinx/serialization/encoding/CompositeDecoder;", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;)I", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "readAll", "startIndex", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "Lkotlinx/serialization/internal/MapLikeSerializer;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @InternalSerializationApi public abstract class AbstractCollectionSerializer implements KSerializer {
    private AbstractCollectionSerializer() {
        super();
    }

    public AbstractCollectionSerializer(DefaultConstructorMarker arg1) {
        this();
    }

    protected abstract Object builder();

    protected abstract int builderSize(Object arg1);

    protected abstract void checkCapacity(Object arg1, int arg2);

    protected abstract Iterator collectionIterator(Object arg1);

    protected abstract int collectionSize(Object arg1);

    public Object deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        return this.merge(arg2, null);
    }

    @InternalSerializationApi public final Object merge(Decoder arg8, Object arg9) {
        Intrinsics.checkNotNullParameter(arg8, "decoder");
        if(arg9 != null) {
            arg9 = this.toBuilder(arg9);
            if(arg9 == null) {
                goto label_5;
            }
        }
        else {
        label_5:
            arg9 = this.builder();
        }

        Object v3 = arg9;
        int v9 = this.builderSize(v3);
        CompositeDecoder v1 = arg8.beginStructure(this.getDescriptor());
        if(v1.decodeSequentially()) {
            this.readAll(v1, v3, v9, this.readSize(v1, v3));
        }
        else {
            while(true) {
                int v8 = v1.decodeElementIndex(this.getDescriptor());
                if(v8 != -1) {
                    AbstractCollectionSerializer.readElement$default(this, v1, v9 + v8, v3, false, 8, null);
                    continue;
                }

                break;
            }
        }

        v1.endStructure(this.getDescriptor());
        return this.toResult(v3);
    }

    protected abstract void readAll(CompositeDecoder arg1, Object arg2, int arg3, int arg4);

    protected abstract void readElement(CompositeDecoder arg1, int arg2, Object arg3, boolean arg4);

    public static void readElement$default(AbstractCollectionSerializer arg0, CompositeDecoder arg1, int arg2, Object arg3, boolean arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            arg0.readElement(arg1, arg2, arg3, true);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
    }

    private final int readSize(CompositeDecoder arg2, Object arg3) {
        int v2 = arg2.decodeCollectionSize(this.getDescriptor());
        this.checkCapacity(arg3, v2);
        return v2;
    }

    public abstract void serialize(Encoder arg1, Object arg2);

    protected abstract Object toBuilder(Object arg1);

    protected abstract Object toResult(Object arg1);
}

