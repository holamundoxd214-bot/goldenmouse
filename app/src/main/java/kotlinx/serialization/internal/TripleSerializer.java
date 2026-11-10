package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder$DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B1\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0018\u0010\u0013\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\u0016J\"\u0010\u0014\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\"\u0010\u0017\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u0019H\u0002J\"\u0010\u001A\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u0019H\u0002R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u001B"}, d2={"Lkotlinx/serialization/internal/TripleSerializer;", "A", "B", "C", "Lkotlinx/serialization/KSerializer;", "Lkotlin/Triple;", "aSerializer", "bSerializer", "cSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "decodeSequentially", "composite", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeStructure", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TripleSerializer implements KSerializer {
    private final KSerializer aSerializer;
    private final KSerializer bSerializer;
    private final KSerializer cSerializer;
    private final SerialDescriptor descriptor;

    public TripleSerializer(KSerializer arg2, KSerializer arg3, KSerializer arg4) {
        Intrinsics.checkNotNullParameter(arg2, "aSerializer");
        Intrinsics.checkNotNullParameter(arg3, "bSerializer");
        Intrinsics.checkNotNullParameter(arg4, "cSerializer");
        super();
        this.aSerializer = arg2;
        this.bSerializer = arg3;
        this.cSerializer = arg4;
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlin.Triple", new SerialDescriptor[0], new TripleSerializer$$ExternalSyntheticLambda0(this));
    }

    private final Triple decodeSequentially(CompositeDecoder arg9) {
        CompositeDecoder v0 = arg9;
        Object v9 = DefaultImpls.decodeSerializableElement$default(v0, this.getDescriptor(), 0, this.aSerializer, null, 8, null);
        Object v7 = DefaultImpls.decodeSerializableElement$default(v0, this.getDescriptor(), 1, this.bSerializer, null, 8, null);
        Object v1 = DefaultImpls.decodeSerializableElement$default(v0, this.getDescriptor(), 2, this.cSerializer, null, 8, null);
        v0.endStructure(this.getDescriptor());
        return new Triple(v9, v7, v1);
    }

    private final Triple decodeStructure(CompositeDecoder arg12) {
        CompositeDecoder v3_1;
        Object v0 = TuplesKt.access$getNULL$p();
        Object v1 = TuplesKt.access$getNULL$p();
        Object v2 = TuplesKt.access$getNULL$p();
        while(true) {
            int v3 = arg12.decodeElementIndex(this.getDescriptor());
            if(v3 == -1) {
                break;
            }

            if(v3 == 0) {
                v3_1 = arg12;
                v0 = DefaultImpls.decodeSerializableElement$default(v3_1, this.getDescriptor(), 0, this.aSerializer, null, 8, null);
            }
            else if(v3 == 1) {
                v3_1 = arg12;
                v1 = DefaultImpls.decodeSerializableElement$default(v3_1, this.getDescriptor(), 1, this.bSerializer, null, 8, null);
            }
            else if(v3 == 2) {
                v2 = DefaultImpls.decodeSerializableElement$default(arg12, this.getDescriptor(), 2, this.cSerializer, null, 8, null);
                continue;
            }
            else {
                throw new SerializationException("Unexpected index " + v3);
            }

            arg12 = v3_1;
        }

        arg12.endStructure(this.getDescriptor());
        if(v0 != TuplesKt.access$getNULL$p()) {
            if(v1 != TuplesKt.access$getNULL$p()) {
                if(v2 != TuplesKt.access$getNULL$p()) {
                    return new Triple(v0, v1, v2);
                }

                throw new SerializationException("Element \'third\' is missing");
            }

            throw new SerializationException("Element \'second\' is missing");
        }

        throw new SerializationException("Element \'first\' is missing");
    }

    static final Unit descriptor$lambda$0(TripleSerializer arg9, ClassSerialDescriptorBuilder arg10) {
        Intrinsics.checkNotNullParameter(arg10, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(arg10, "first", arg9.aSerializer.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(arg10, "second", arg9.bSerializer.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(arg10, "third", arg9.cSerializer.getDescriptor(), null, false, 12, null);
        return Unit.INSTANCE;
    }

    public Object deserialize(Decoder arg1) {
        return this.deserialize(arg1);
    }

    public Triple deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        CompositeDecoder v2 = arg2.beginStructure(this.getDescriptor());
        if(v2.decodeSequentially()) {
            return this.decodeSequentially(v2);
        }

        return this.decodeStructure(v2);
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((Triple)arg2));
    }

    public void serialize(Encoder arg5, Triple arg6) {
        Intrinsics.checkNotNullParameter(arg5, "encoder");
        Intrinsics.checkNotNullParameter(arg6, "value");
        CompositeEncoder v5 = arg5.beginStructure(this.getDescriptor());
        v5.encodeSerializableElement(this.getDescriptor(), 0, this.aSerializer, arg6.getFirst());
        v5.encodeSerializableElement(this.getDescriptor(), 1, this.bSerializer, arg6.getSecond());
        v5.encodeSerializableElement(this.getDescriptor(), 2, this.cSerializer, arg6.getThird());
        v5.endStructure(this.getDescriptor());
    }
}

