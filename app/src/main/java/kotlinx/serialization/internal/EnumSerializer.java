package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001D\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tB\'\b\u0010\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\b\u0010\fJ\u0010\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u0005H\u0002J\u001D\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001A\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00020\u001CH\u0016¢\u0006\u0002\u0010\u001DJ\b\u0010\u001E\u001A\u00020\u0005H\u0016R\u0016\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\n\u001A\u00020\u000B8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001F"}, d2={"Lkotlinx/serialization/internal/EnumSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "values", "", "<init>", "(Ljava/lang/String;[Ljava/lang/Enum;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Ljava/lang/String;[Ljava/lang/Enum;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "[Ljava/lang/Enum;", "overriddenDescriptor", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "createUnmarkedDescriptor", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "toString", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EnumSerializer implements KSerializer {
    private final Lazy descriptor$delegate;
    private SerialDescriptor overriddenDescriptor;
    private final Enum[] values;

    public EnumSerializer(String arg2, Enum[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        Intrinsics.checkNotNullParameter(arg3, "values");
        super();
        this.values = arg3;
        this.descriptor$delegate = LazyKt.lazy(new EnumSerializer$$ExternalSyntheticLambda0(this, arg2));
    }

    public EnumSerializer(String arg2, Enum[] arg3, SerialDescriptor arg4) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        Intrinsics.checkNotNullParameter(arg3, "values");
        Intrinsics.checkNotNullParameter(arg4, "descriptor");
        this(arg2, arg3);
        this.overriddenDescriptor = arg4;
    }

    private final SerialDescriptor createUnmarkedDescriptor(String arg8) {
        EnumDescriptor v0 = new EnumDescriptor(arg8, this.values.length);
        Enum[] v7 = this.values;
        int v8 = v7.length;
        int v2;
        for(v2 = 0; v2 < v8; ++v2) {
            PluginGeneratedSerialDescriptor.addElement$default(v0, v7[v2].name(), false, 2, null);
        }

        return ((SerialDescriptor)v0);
    }

    static final SerialDescriptor descriptor_delegate$lambda$0(EnumSerializer arg1, String arg2) {
        SerialDescriptor v0 = arg1.overriddenDescriptor;
        if(v0 == null) {
            return arg1.createUnmarkedDescriptor(arg2);
        }

        return v0;
    }

    public Enum deserialize(Decoder arg3) {
        Intrinsics.checkNotNullParameter(arg3, "decoder");
        int v3 = arg3.decodeEnum(this.getDescriptor());
        if(v3 >= 0) {
            Enum[] v0 = this.values;
            if(v3 < v0.length) {
                return v0[v3];
            }
        }

        throw new SerializationException(v3 + " is not among valid " + this.getDescriptor().getSerialName() + " enum values, values size is " + this.values.length);
    }

    public Object deserialize(Decoder arg1) {
        return this.deserialize(arg1);
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor$delegate.getValue();
    }

    public void serialize(Encoder arg3, Enum arg4) {
        Intrinsics.checkNotNullParameter(arg3, "encoder");
        Intrinsics.checkNotNullParameter(arg4, "value");
        int v0 = ArraysKt.indexOf(this.values, arg4);
        if(v0 != -1) {
            arg3.encodeEnum(this.getDescriptor(), v0);
            return;
        }

        StringBuilder v4 = new StringBuilder().append(arg4).append(" is not a valid enum ").append(this.getDescriptor().getSerialName()).append(", must be one of ");
        String v2 = Arrays.toString(this.values);
        Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
        throw new SerializationException(v4.append(v2).toString());
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((Enum)arg2));
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + this.getDescriptor().getSerialName() + '>';
    }
}

