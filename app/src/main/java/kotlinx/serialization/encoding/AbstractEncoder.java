package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.NoOpEncoder;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0016J\u0010\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\tH\u0016J\u0010\u0010\u0012\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000BH\u0016J\u0010\u0010\u0013\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0014H\u0016J\u0010\u0010\u0015\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0016H\u0016J\u0010\u0010\u0017\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\rH\u0016J\u0010\u0010\u0018\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0019H\u0016J\u0010\u0010\u001A\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u001BH\u0016J\u0010\u0010\u001C\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u001DH\u0016J\u0010\u0010\u001E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u001FH\u0016J\u0010\u0010 \u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020!H\u0016J\u0018\u0010\"\u001A\u00020\t2\u0006\u0010#\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0016J\u0010\u0010$\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u001E\u0010%\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u000BJ\u001E\u0010&\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0014J\u001E\u0010\'\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0016J\u001E\u0010(\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\rJ\u001E\u0010)\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0019J\u001E\u0010*\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u001BJ\u001E\u0010+\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u001DJ\u001E\u0010,\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u001FJ\u001E\u0010-\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020!J\u0016\u0010.\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rJ?\u0010/\u001A\u00020\t\"\n\b\u0000\u00100*\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\f\u00101\u001A\b\u0012\u0004\u0012\u0002H0022\u0006\u0010\u000F\u001A\u0002H0H\u0016¢\u0006\u0002\u00103J?\u00104\u001A\u00020\t\"\b\b\u0000\u00100*\u00020\u00102\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\f\u00101\u001A\b\u0012\u0004\u0012\u0002H0022\b\u0010\u000F\u001A\u0004\u0018\u0001H0H\u0016¢\u0006\u0002\u00103¨\u00065"}, d2={"Lkotlinx/serialization/encoding/AbstractEncoder;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "<init>", "()V", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "endStructure", "", "encodeElement", "", "index", "", "encodeValue", "value", "", "encodeNull", "encodeBoolean", "encodeByte", "", "encodeShort", "", "encodeInt", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "", "encodeEnum", "enumDescriptor", "encodeInline", "encodeBooleanElement", "encodeByteElement", "encodeShortElement", "encodeIntElement", "encodeLongElement", "encodeFloatElement", "encodeDoubleElement", "encodeCharElement", "encodeStringElement", "encodeInlineElement", "encodeSerializableElement", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @ExperimentalSerializationApi public abstract class AbstractEncoder implements CompositeEncoder, Encoder {
    public AbstractEncoder() {
        super();
    }

    public CompositeEncoder beginCollection(SerialDescriptor arg1, int arg2) {
        return DefaultImpls.beginCollection(((Encoder)this), arg1, arg2);
    }

    public CompositeEncoder beginStructure(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this;
    }

    public void encodeBoolean(boolean arg1) {
        this.encodeValue(Boolean.valueOf(arg1));
    }

    public final void encodeBooleanElement(SerialDescriptor arg2, int arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeBoolean(arg4);
        }
    }

    public void encodeByte(byte arg1) {
        this.encodeValue(Byte.valueOf(arg1));
    }

    public final void encodeByteElement(SerialDescriptor arg2, int arg3, byte arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeByte(arg4);
        }
    }

    public void encodeChar(char arg1) {
        this.encodeValue(Character.valueOf(arg1));
    }

    public final void encodeCharElement(SerialDescriptor arg2, int arg3, char arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeChar(arg4);
        }
    }

    public void encodeDouble(double arg1) {
        this.encodeValue(Double.valueOf(arg1));
    }

    public final void encodeDoubleElement(SerialDescriptor arg2, int arg3, double arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeDouble(arg4);
        }
    }

    public boolean encodeElement(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return 1;
    }

    public void encodeEnum(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "enumDescriptor");
        this.encodeValue(Integer.valueOf(arg3));
    }

    public void encodeFloat(float arg1) {
        this.encodeValue(Float.valueOf(arg1));
    }

    public final void encodeFloatElement(SerialDescriptor arg2, int arg3, float arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeFloat(arg4);
        }
    }

    public Encoder encodeInline(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this;
    }

    public final Encoder encodeInlineElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        if(this.encodeElement(arg2, arg3)) {
            return this.encodeInline(arg2.getElementDescriptor(arg3));
        }

        return NoOpEncoder.INSTANCE;
    }

    public void encodeInt(int arg1) {
        this.encodeValue(Integer.valueOf(arg1));
    }

    public final void encodeIntElement(SerialDescriptor arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeInt(arg4);
        }
    }

    public void encodeLong(long arg1) {
        this.encodeValue(Long.valueOf(arg1));
    }

    public final void encodeLongElement(SerialDescriptor arg2, int arg3, long arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeLong(arg4);
        }
    }

    @ExperimentalSerializationApi public void encodeNotNullMark() {
        DefaultImpls.encodeNotNullMark(((Encoder)this));
    }

    public void encodeNull() {
        throw new SerializationException("\'null\' is not supported by default");
    }

    public void encodeNullableSerializableElement(SerialDescriptor arg2, int arg3, SerializationStrategy arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg4, "serializer");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeNullableSerializableValue(arg4, arg5);
        }
    }

    @ExperimentalSerializationApi public void encodeNullableSerializableValue(SerializationStrategy arg1, Object arg2) {
        DefaultImpls.encodeNullableSerializableValue(((Encoder)this), arg1, arg2);
    }

    public void encodeSerializableElement(SerialDescriptor arg2, int arg3, SerializationStrategy arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg4, "serializer");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeSerializableValue(arg4, arg5);
        }
    }

    public void encodeSerializableValue(SerializationStrategy arg1, Object arg2) {
        DefaultImpls.encodeSerializableValue(((Encoder)this), arg1, arg2);
    }

    public void encodeShort(short arg1) {
        this.encodeValue(Short.valueOf(arg1));
    }

    public final void encodeShortElement(SerialDescriptor arg2, int arg3, short arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeShort(arg4);
        }
    }

    public void encodeString(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        this.encodeValue(arg2);
    }

    public final void encodeStringElement(SerialDescriptor arg2, int arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg4, "value");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeString(arg4);
        }
    }

    public void encodeValue(Object arg4) {
        Intrinsics.checkNotNullParameter(arg4, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(arg4.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(this.getClass()) + " encoder");
    }

    public void endStructure(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
    }

    @ExperimentalSerializationApi public boolean shouldEncodeElementDefault(SerialDescriptor arg1, int arg2) {
        return kotlinx.serialization.encoding.CompositeEncoder$DefaultImpls.shouldEncodeElementDefault(((CompositeEncoder)this), arg1, arg2);
    }
}

