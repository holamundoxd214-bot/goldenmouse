package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder$DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0014\b\u0003\u0010\u0004*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00052 \u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006B%\b\u0004\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u000B\u0010\fJ)\u0010\u0010\u001A\u00020\u0011*\u00028\u00032\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00028\u00002\u0006\u0010\u0015\u001A\u00028\u0001H$¢\u0006\u0002\u0010\u0016J-\u0010\u001B\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00028\u00032\u0006\u0010\u001F\u001A\u00020\u00132\u0006\u0010 \u001A\u00020\u0013H\u0004¢\u0006\u0002\u0010!J-\u0010\"\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u001E\u001A\u00028\u00032\u0006\u0010#\u001A\u00020$H\u0004¢\u0006\u0002\u0010%J\u001D\u0010&\u001A\u00020\u00112\u0006\u0010\'\u001A\u00020(2\u0006\u0010\u0015\u001A\u00028\u0002H\u0016¢\u0006\u0002\u0010)R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0012\u0010\u0017\u001A\u00020\u0018X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A\u0082\u0001\u0002*+¨\u0006,"}, d2={"Lkotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", "Builder", "", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "insertKeyValuePair", "", "index", "", "key", "value", "(Ljava/util/Map;ILjava/lang/Object;Ljava/lang/Object;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "readAll", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/util/Map;II)V", "readElement", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/util/Map;Z)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/internal/HashMapSerializer;", "Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @InternalSerializationApi public abstract class MapLikeSerializer extends AbstractCollectionSerializer {
    private final KSerializer keySerializer;
    private final KSerializer valueSerializer;

    private MapLikeSerializer(KSerializer arg2, KSerializer arg3) {
        super(null);
        this.keySerializer = arg2;
        this.valueSerializer = arg3;
    }

    public MapLikeSerializer(KSerializer arg1, KSerializer arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public abstract SerialDescriptor getDescriptor();

    public final KSerializer getKeySerializer() {
        return this.keySerializer;
    }

    public final KSerializer getValueSerializer() {
        return this.valueSerializer;
    }

    protected abstract void insertKeyValuePair(Map arg1, int arg2, Object arg3, Object arg4);

    public void readAll(CompositeDecoder arg1, Object arg2, int arg3, int arg4) {
        this.readAll(arg1, ((Map)arg2), arg3, arg4);
    }

    protected final void readAll(CompositeDecoder arg5, Map arg6, int arg7, int arg8) {
        Intrinsics.checkNotNullParameter(arg5, "decoder");
        Intrinsics.checkNotNullParameter(arg6, "builder");
        if(arg8 >= 0) {
            IntProgression v8 = RangesKt.step(RangesKt.until(0, arg8 * 2), 2);
            int v0 = v8.getFirst();
            int v2 = v8.getLast();
            arg8 = v8.getStep();
            if(arg8 > 0 && v0 <= v2) {
                goto label_17;
            }
            else if(arg8 < 0 && v2 <= v0) {
                while(true) {
                label_17:
                    this.readElement(arg5, arg7 + v0, arg6, false);
                    if(v0 != v2) {
                        v0 += arg8;
                        continue;
                    }

                    return;
                }
            }

            return;
        }

        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
    }

    protected final void readElement(CompositeDecoder arg9, int arg10, Map arg11, boolean arg12) {
        Intrinsics.checkNotNullParameter(arg9, "decoder");
        Intrinsics.checkNotNullParameter(arg11, "builder");
        CompositeDecoder v1 = arg9;
        int v3 = arg10;
        Object v9 = DefaultImpls.decodeSerializableElement$default(v1, this.getDescriptor(), v3, this.keySerializer, null, 8, null);
        CompositeDecoder v0 = v1;
        if(arg12) {
            arg10 = v0.decodeElementIndex(this.getDescriptor());
            if(arg10 == v3 + 1) {
            }
            else {
                throw new IllegalArgumentException("Value must follow key in a map, index for key: " + v3 + ", returned index for value: " + arg10.toString());
            }
        }
        else {
            arg10 = v3 + 1;
        }

        int v2 = arg10;
        Object v8 = !arg11.containsKey(v9) || ((this.valueSerializer.getDescriptor().getKind() instanceof PrimitiveKind)) ? DefaultImpls.decodeSerializableElement$default(v0, this.getDescriptor(), v2, this.valueSerializer, null, 8, null) : v0.decodeSerializableElement(this.getDescriptor(), v2, this.valueSerializer, MapsKt.getValue(arg11, v9));
        arg11.put(v9, v8);
    }

    public void readElement(CompositeDecoder arg1, int arg2, Object arg3, boolean arg4) {
        this.readElement(arg1, arg2, ((Map)arg3), arg4);
    }

    public void serialize(Encoder arg8, Object arg9) {
        Intrinsics.checkNotNullParameter(arg8, "encoder");
        int v0 = this.collectionSize(arg9);
        SerialDescriptor v1 = this.getDescriptor();
        CompositeEncoder v8 = arg8.beginCollection(v1, v0);
        Iterator v9 = this.collectionIterator(arg9);
        v0 = 0;
        while(v9.hasNext()) {
            Object v2 = v9.next();
            Object v3 = ((Map$Entry)v2).getKey();
            v2 = ((Map$Entry)v2).getValue();
            int v5 = v0 + 1;
            v8.encodeSerializableElement(this.getDescriptor(), v0, this.getKeySerializer(), v3);
            v0 += 2;
            v8.encodeSerializableElement(this.getDescriptor(), v5, this.getValueSerializer(), v2);
        }

        v8.endStructure(v1);
    }
}

