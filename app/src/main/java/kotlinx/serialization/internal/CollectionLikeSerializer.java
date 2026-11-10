package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder$DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004B\u0017\b\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001A\u00020\n*\u00028\u00022\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0000H$¢\u0006\u0002\u0010\u000EJ\u001D\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00028\u00022\u0006\u0010\u001C\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\fH\u0004¢\u0006\u0002\u0010\u001EJ-\u0010\u001F\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00028\u00022\u0006\u0010 \u001A\u00020!H\u0014¢\u0006\u0002\u0010\"R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000F\u001A\u00020\u0010X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012\u0082\u0001\u0003#$%¨\u0006&"}, d2={"Lkotlinx/serialization/internal/CollectionLikeSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "elementSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "insert", "", "index", "", "element", "(Ljava/lang/Object;ILjava/lang/Object;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "readAll", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "Lkotlinx/serialization/internal/CollectionSerializer;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlinx/serialization/internal/ReferenceArraySerializer;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class CollectionLikeSerializer extends AbstractCollectionSerializer {
    private final KSerializer elementSerializer;

    private CollectionLikeSerializer(KSerializer arg2) {
        super(null);
        this.elementSerializer = arg2;
    }

    public CollectionLikeSerializer(KSerializer arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public static final KSerializer access$getElementSerializer$p(CollectionLikeSerializer arg0) {
        return arg0.elementSerializer;
    }

    public abstract SerialDescriptor getDescriptor();

    protected abstract void insert(Object arg1, int arg2, Object arg3);

    protected final void readAll(CompositeDecoder arg4, Object arg5, int arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg4, "decoder");
        if(arg7 >= 0) {
            int v1;
            for(v1 = 0; v1 < arg7; ++v1) {
                this.readElement(arg4, arg6 + v1, arg5, false);
            }

            return;
        }

        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
    }

    protected void readElement(CompositeDecoder arg8, int arg9, Object arg10, boolean arg11) {
        Intrinsics.checkNotNullParameter(arg8, "decoder");
        this.insert(arg10, arg9, DefaultImpls.decodeSerializableElement$default(arg8, this.getDescriptor(), arg9, this.elementSerializer, null, 8, null));
    }

    public void serialize(Encoder arg7, Object arg8) {
        Intrinsics.checkNotNullParameter(arg7, "encoder");
        int v0 = this.collectionSize(arg8);
        SerialDescriptor v1 = this.getDescriptor();
        CompositeEncoder v7 = arg7.beginCollection(v1, v0);
        Iterator v8 = this.collectionIterator(arg8);
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v7.encodeSerializableElement(this.getDescriptor(), v2, this.elementSerializer, v8.next());
        }

        v7.endStructure(v1);
    }
}

