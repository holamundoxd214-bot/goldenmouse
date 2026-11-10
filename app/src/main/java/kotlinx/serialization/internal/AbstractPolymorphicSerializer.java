package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder$DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\t\b\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001B\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00028\u0000¢\u0006\u0002\u0010\u000FJ\u0013\u0010\u0010\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001A\u00028\u00002\u0006\u0010\u0015\u001A\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0017J\"\u0010\u0018\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00192\u0006\u0010\u0011\u001A\u00020\u00162\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0017J%\u0010\u0018\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001C2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00028\u0000H\u0017¢\u0006\u0002\u0010\u001DR\u0018\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u001E"}, d2={"Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "<init>", "()V", "baseClass", "Lkotlin/reflect/KClass;", "getBaseClass", "()Lkotlin/reflect/KClass;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "decodeSequentially", "compositeDecoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Ljava/lang/Object;", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "klassName", "", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @InternalSerializationApi public abstract class AbstractPolymorphicSerializer implements KSerializer {
    public AbstractPolymorphicSerializer() {
        super();
    }

    public static final Object access$decodeSequentially(AbstractPolymorphicSerializer arg0, CompositeDecoder arg1) {
        return arg0.decodeSequentially(arg1);
    }

    private final Object decodeSequentially(CompositeDecoder arg9) {
        return DefaultImpls.decodeSerializableElement$default(arg9, this.getDescriptor(), 1, PolymorphicSerializerKt.findPolymorphicSerializer(this, arg9, arg9.decodeStringElement(this.getDescriptor(), 0)), null, 8, null);
    }

    public final Object deserialize(Decoder arg9) {
        String v9_2;
        Object v8;
        Intrinsics.checkNotNullParameter(arg9, "decoder");
        SerialDescriptor v0 = this.getDescriptor();
        CompositeDecoder v1 = arg9.beginStructure(v0);
        ObjectRef v9 = new ObjectRef();
        if(v1.decodeSequentially()) {
            v8 = this.decodeSequentially(v1);
        }
        else {
            Object v2 = null;
            while(true) {
                int v3 = v1.decodeElementIndex(this.getDescriptor());
                if(v3 == -1) {
                    break;
                }
                else if(v3 == 0) {
                    v9.element = v1.decodeStringElement(this.getDescriptor(), v3);
                    continue;
                }
                else if(v3 != 1) {
                    StringBuilder v0_1 = new StringBuilder("Invalid index in polymorphic deserialization of ");
                    Object v9_1 = v9.element;
                    if(v9_1 == null) {
                        v9_2 = "unknown class";
                    }

                    throw new SerializationException(v0_1.append(v9_2).append("\n Expected 0, 1 or DECODE_DONE(-1), but found ").append(v3).toString());
                }
                else {
                    v2 = v9.element;
                    if(v2 != null) {
                        v9.element = v2;
                        v2 = DefaultImpls.decodeSerializableElement$default(v1, this.getDescriptor(), v3, PolymorphicSerializerKt.findPolymorphicSerializer(this, v1, v9.element), null, 8, null);
                        continue;
                    }

                    throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                }

                goto label_56;
            }

            if(v2 != null) {
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer");
                v8 = v2;
                goto label_56;
            }

            throw new IllegalArgumentException("Polymorphic value has not been read for class " + v9.element.toString());
        }

    label_56:
        v1.endStructure(v0);
        return v8;
    }

    @InternalSerializationApi public DeserializationStrategy findPolymorphicSerializerOrNull(CompositeDecoder arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        return arg2.getSerializersModule().getPolymorphic(this.getBaseClass(), arg3);
    }

    @InternalSerializationApi public SerializationStrategy findPolymorphicSerializerOrNull(Encoder arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        Intrinsics.checkNotNullParameter(arg3, "value");
        return arg2.getSerializersModule().getPolymorphic(this.getBaseClass(), arg3);
    }

    public abstract KClass getBaseClass();

    public final void serialize(Encoder arg6, Object arg7) {
        Intrinsics.checkNotNullParameter(arg6, "encoder");
        Intrinsics.checkNotNullParameter(arg7, "value");
        SerializationStrategy v0 = PolymorphicSerializerKt.findPolymorphicSerializer(this, arg6, arg7);
        SerialDescriptor v1 = this.getDescriptor();
        CompositeEncoder v6 = arg6.beginStructure(v1);
        v6.encodeStringElement(this.getDescriptor(), 0, v0.getDescriptor().getSerialName());
        SerialDescriptor v5 = this.getDescriptor();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        v6.encodeSerializableElement(v5, 1, v0, arg7);
        v6.endStructure(v1);
    }
}

