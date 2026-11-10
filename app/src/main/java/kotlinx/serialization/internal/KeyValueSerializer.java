package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder$DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B%\b\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\u0011\u001A\u00028\u00022\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\u000F\u001A\u00028\u0001H$¢\u0006\u0002\u0010\u0012J\u001D\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u000F\u001A\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001A\u00028\u00022\u0006\u0010\u0019\u001A\u00020\u001AH\u0016¢\u0006\u0002\u0010\u001BR\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001A\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0016\u0010\f\u001A\u00028\u0000*\u00028\u0002X¤\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0016\u0010\u000F\u001A\u00028\u0001*\u00028\u0002X¤\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u000E\u0082\u0001\u0002\u001C\u001D¨\u0006\u001E"}, d2={"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "key", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class KeyValueSerializer implements KSerializer {
    private final KSerializer keySerializer;
    private final KSerializer valueSerializer;

    private KeyValueSerializer(KSerializer arg1, KSerializer arg2) {
        super();
        this.keySerializer = arg1;
        this.valueSerializer = arg2;
    }

    public KeyValueSerializer(KSerializer arg1, KSerializer arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public Object deserialize(Decoder arg10) {
        Object v9;
        Intrinsics.checkNotNullParameter(arg10, "decoder");
        SerialDescriptor v0 = this.getDescriptor();
        CompositeDecoder v1 = arg10.beginStructure(v0);
        if(v1.decodeSequentially()) {
            v9 = this.toResult(DefaultImpls.decodeSerializableElement$default(v1, this.getDescriptor(), 0, this.getKeySerializer(), null, 8, null), DefaultImpls.decodeSerializableElement$default(v1, this.getDescriptor(), 1, this.getValueSerializer(), null, 8, null));
        }
        else {
            Object v10 = TuplesKt.access$getNULL$p();
            Object v8 = TuplesKt.access$getNULL$p();
            while(true) {
                int v2 = v1.decodeElementIndex(this.getDescriptor());
                if(v2 == -1) {
                    break;
                }
                else if(v2 == 0) {
                    v10 = DefaultImpls.decodeSerializableElement$default(v1, this.getDescriptor(), 0, this.getKeySerializer(), null, 8, null);
                    continue;
                }
                else if(v2 == 1) {
                    v8 = DefaultImpls.decodeSerializableElement$default(v1, this.getDescriptor(), 1, this.getValueSerializer(), null, 8, null);
                    continue;
                }
                else {
                    throw new SerializationException("Invalid index: " + v2);
                }

                goto label_62;
            }

            if(v10 == TuplesKt.access$getNULL$p()) {
                throw new SerializationException("Element \'key\' is missing");
            }
            else if(v8 != TuplesKt.access$getNULL$p()) {
                v9 = this.toResult(v10, v8);
            }
            else {
                throw new SerializationException("Element \'value\' is missing");
            }
        }

    label_62:
        v1.endStructure(v0);
        return v9;
    }

    protected abstract Object getKey(Object arg1);

    protected final KSerializer getKeySerializer() {
        return this.keySerializer;
    }

    protected abstract Object getValue(Object arg1);

    protected final KSerializer getValueSerializer() {
        return this.valueSerializer;
    }

    public void serialize(Encoder arg5, Object arg6) {
        Intrinsics.checkNotNullParameter(arg5, "encoder");
        CompositeEncoder v5 = arg5.beginStructure(this.getDescriptor());
        v5.encodeSerializableElement(this.getDescriptor(), 0, this.keySerializer, this.getKey(arg6));
        v5.encodeSerializableElement(this.getDescriptor(), 1, this.valueSerializer, this.getValue(arg6));
        v5.endStructure(this.getDescriptor());
    }

    protected abstract Object toResult(Object arg1, Object arg2);
}

