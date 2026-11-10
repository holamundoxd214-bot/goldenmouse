package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000F\b\'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0006H\u0016J\b\u0010\u0007\u001A\u00020\bH\u0016J\n\u0010\t\u001A\u0004\u0018\u00010\nH\u0016J\b\u0010\u000B\u001A\u00020\bH\u0016J\b\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016J\b\u0010\u0014\u001A\u00020\u0015H\u0016J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\u0010\u0010\u001C\u001A\u00020\u00112\u0006\u0010\u001D\u001A\u00020\u001EH\u0016J\u0010\u0010\u001F\u001A\u00020\u00012\u0006\u0010 \u001A\u00020\u001EH\u0016J3\u0010!\u001A\u0002H\"\"\n\b\u0000\u0010\"*\u0004\u0018\u00010\u00062\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\"0$2\n\b\u0002\u0010%\u001A\u0004\u0018\u0001H\"H\u0016¢\u0006\u0002\u0010&J\u0010\u0010\'\u001A\u00020\u00022\u0006\u0010 \u001A\u00020\u001EH\u0016J\u0010\u0010(\u001A\u00020)2\u0006\u0010 \u001A\u00020\u001EH\u0016J\u0016\u0010*\u001A\u00020\b2\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u0011J\u0016\u0010,\u001A\u00020\r2\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u0011J\u0016\u0010-\u001A\u00020\u000F2\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u0011J\u0016\u0010.\u001A\u00020\u00112\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u0011J\u0016\u0010/\u001A\u00020\u00132\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u0011J\u0016\u00100\u001A\u00020\u00152\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u0011J\u0016\u00101\u001A\u00020\u00172\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u0011J\u0016\u00102\u001A\u00020\u00192\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u0011J\u0016\u00103\u001A\u00020\u001B2\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u0011J\u0018\u00104\u001A\u00020\u00012\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u0011H\u0016J;\u00105\u001A\u0002H\"\"\u0004\b\u0000\u0010\"2\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u00112\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\"0$2\b\u0010%\u001A\u0004\u0018\u0001H\"H\u0016¢\u0006\u0002\u00106JA\u00107\u001A\u0004\u0018\u0001H\"\"\b\b\u0000\u0010\"*\u00020\u00062\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\u00112\u000E\u0010#\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H\"0$2\b\u0010%\u001A\u0004\u0018\u0001H\"¢\u0006\u0002\u00106¨\u00068"}, d2={"Lkotlinx/serialization/encoding/AbstractDecoder;", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "<init>", "()V", "decodeValue", "", "decodeNotNullMark", "", "decodeNull", "", "decodeBoolean", "decodeByte", "", "decodeShort", "", "decodeInt", "", "decodeLong", "", "decodeFloat", "", "decodeDouble", "", "decodeChar", "", "decodeString", "", "decodeEnum", "enumDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeInline", "descriptor", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "beginStructure", "endStructure", "", "decodeBooleanElement", "index", "decodeByteElement", "decodeShortElement", "decodeIntElement", "decodeLongElement", "decodeFloatElement", "decodeDoubleElement", "decodeCharElement", "decodeStringElement", "decodeInlineElement", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @ExperimentalSerializationApi public abstract class AbstractDecoder implements CompositeDecoder, Decoder {
    public AbstractDecoder() {
        super();
    }

    public CompositeDecoder beginStructure(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this;
    }

    public boolean decodeBoolean() {
        Object v1 = this.decodeValue();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean)v1).booleanValue();
    }

    public final boolean decodeBooleanElement(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return this.decodeBoolean();
    }

    public byte decodeByte() {
        Object v1 = this.decodeValue();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte)v1).byteValue();
    }

    public final byte decodeByteElement(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return this.decodeByte();
    }

    public char decodeChar() {
        Object v1 = this.decodeValue();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Char");
        return ((Character)v1).charValue();
    }

    public final char decodeCharElement(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return this.decodeChar();
    }

    public int decodeCollectionSize(SerialDescriptor arg1) {
        return DefaultImpls.decodeCollectionSize(((CompositeDecoder)this), arg1);
    }

    public double decodeDouble() {
        Object v2 = this.decodeValue();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Double");
        return ((Double)v2).doubleValue();
    }

    public final double decodeDoubleElement(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return this.decodeDouble();
    }

    public int decodeEnum(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "enumDescriptor");
        Object v1 = this.decodeValue();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer)v1).intValue();
    }

    public float decodeFloat() {
        Object v1 = this.decodeValue();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Float");
        return ((Float)v1).floatValue();
    }

    public final float decodeFloatElement(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return this.decodeFloat();
    }

    public Decoder decodeInline(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this;
    }

    public Decoder decodeInlineElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeInline(arg2.getElementDescriptor(arg3));
    }

    public int decodeInt() {
        Object v1 = this.decodeValue();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer)v1).intValue();
    }

    public final int decodeIntElement(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return this.decodeInt();
    }

    public long decodeLong() {
        Object v2 = this.decodeValue();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Long");
        return ((Long)v2).longValue();
    }

    public final long decodeLongElement(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return this.decodeLong();
    }

    public boolean decodeNotNullMark() {
        return 1;
    }

    public Void decodeNull() {
        return null;
    }

    public final Object decodeNullableSerializableElement(SerialDescriptor arg1, int arg2, DeserializationStrategy arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        Intrinsics.checkNotNullParameter(arg3, "deserializer");
        AbstractDecoder v1 = this;
        if(!arg3.getDescriptor().isNullable()) {
            if(((Decoder)v1).decodeNotNullMark()) {
            }
            else {
                return ((Decoder)v1).decodeNull();
            }
        }

        return this.decodeSerializableValue(arg3, arg4);
    }

    @ExperimentalSerializationApi public Object decodeNullableSerializableValue(DeserializationStrategy arg1) {
        return kotlinx.serialization.encoding.Decoder$DefaultImpls.decodeNullableSerializableValue(((Decoder)this), arg1);
    }

    @ExperimentalSerializationApi public boolean decodeSequentially() {
        return DefaultImpls.decodeSequentially(((CompositeDecoder)this));
    }

    public Object decodeSerializableElement(SerialDescriptor arg1, int arg2, DeserializationStrategy arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        Intrinsics.checkNotNullParameter(arg3, "deserializer");
        return this.decodeSerializableValue(arg3, arg4);
    }

    public Object decodeSerializableValue(DeserializationStrategy arg1) {
        return kotlinx.serialization.encoding.Decoder$DefaultImpls.decodeSerializableValue(((Decoder)this), arg1);
    }

    public Object decodeSerializableValue(DeserializationStrategy arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "deserializer");
        return this.decodeSerializableValue(arg1);
    }

    public static Object decodeSerializableValue$default(AbstractDecoder arg0, DeserializationStrategy arg1, Object arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = null;
            }

            return arg0.decodeSerializableValue(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableValue");
    }

    public short decodeShort() {
        Object v1 = this.decodeValue();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Short");
        return ((Short)v1).shortValue();
    }

    public final short decodeShortElement(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return this.decodeShort();
    }

    public String decodeString() {
        Object v1 = this.decodeValue();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.String");
        return ((String)v1);
    }

    public final String decodeStringElement(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return this.decodeString();
    }

    public Object decodeValue() {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(this.getClass()) + " can\'t retrieve untyped values");
    }

    public void endStructure(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
    }
}

