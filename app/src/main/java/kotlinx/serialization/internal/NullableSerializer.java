package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001A\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0018\u001A\u00020\u0019H\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u001A"}, d2={"Lkotlinx/serialization/internal/NullableSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NullableSerializer implements KSerializer {
    private final SerialDescriptor descriptor;
    private final KSerializer serializer;

    public NullableSerializer(KSerializer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "serializer");
        super();
        this.serializer = arg2;
        this.descriptor = new SerialDescriptorForNullable(arg2.getDescriptor());
    }

    public Object deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        if(arg2.decodeNotNullMark()) {
            return arg2.decodeSerializableValue(this.serializer);
        }

        return arg2.decodeNull();
    }

    public boolean equals(Object arg5) {
        if(this == (((NullableSerializer)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if(!Intrinsics.areEqual(this.serializer, ((NullableSerializer)arg5).serializer)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public int hashCode() {
        return this.serializer.hashCode();
    }

    public void serialize(Encoder arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        if(arg3 != null) {
            arg2.encodeNotNullMark();
            arg2.encodeSerializableValue(this.serializer, arg3);
            return;
        }

        arg2.encodeNull();
    }
}

