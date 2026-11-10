package kotlinx.serialization;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginHelperInterfacesKt;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B7\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\u0012\u0010\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\b¢\u0006\u0004\b\t\u0010\nB\u0017\b\u0016\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\t\u0010\u000BJ\u0016\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000E\u001A\u00020\u000FH\u0002J\u001D\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001A\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00020\u001CH\u0016¢\u0006\u0002\u0010\u001DR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001E"}, d2={"Lkotlinx/serialization/ContextualSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serializableClass", "Lkotlin/reflect/KClass;", "fallbackSerializer", "typeArgumentsSerializers", "", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;[Lkotlinx/serialization/KSerializer;)V", "(Lkotlin/reflect/KClass;)V", "", "serializer", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @ExperimentalSerializationApi public final class ContextualSerializer implements KSerializer {
    private final SerialDescriptor descriptor;
    private final KSerializer fallbackSerializer;
    private final KClass serializableClass;
    private final List typeArgumentsSerializers;

    public ContextualSerializer(KClass arg3) {
        Intrinsics.checkNotNullParameter(arg3, "serializableClass");
        this(arg3, null, PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY);
    }

    public ContextualSerializer(KClass arg3, KSerializer arg4, KSerializer[] arg5) {
        Intrinsics.checkNotNullParameter(arg3, "serializableClass");
        Intrinsics.checkNotNullParameter(arg5, "typeArgumentsSerializers");
        super();
        this.serializableClass = arg3;
        this.fallbackSerializer = arg4;
        this.typeArgumentsSerializers = ArraysKt.asList(((Object[])arg5));
        this.descriptor = ContextAwareKt.withContext(SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.ContextualSerializer", CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new ContextualSerializer$$ExternalSyntheticLambda0(this)), arg3);
    }

    static final Unit descriptor$lambda$0(ContextualSerializer arg1, ClassSerialDescriptorBuilder arg2) {
        List v1_2;
        Intrinsics.checkNotNullParameter(arg2, "$this$buildSerialDescriptor");
        KSerializer v1 = arg1.fallbackSerializer;
        if(v1 != null) {
            SerialDescriptor v1_1 = v1.getDescriptor();
            if(v1_1 != null) {
                v1_2 = v1_1.getAnnotations();
            }
            else {
                goto label_8;
            }
        }
        else {
        label_8:
            v1_2 = null;
        }

        if(v1_2 == null) {
            v1_2 = CollectionsKt.emptyList();
        }

        arg2.setAnnotations(v1_2);
        return Unit.INSTANCE;
    }

    public Object deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        return arg2.decodeSerializableValue(this.serializer(arg2.getSerializersModule()));
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(Encoder arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg2.encodeSerializableValue(this.serializer(arg2.getSerializersModule()), arg3);
    }

    private final KSerializer serializer(SerializersModule arg3) {
        KSerializer v3 = arg3.getContextual(this.serializableClass, this.typeArgumentsSerializers);
        if(v3 == null) {
            v3 = this.fallbackSerializer;
            if(v3 != null) {
                return v3;
            }

            Platform_commonKt.serializerNotRegistered(this.serializableClass);
            throw new KotlinNothingValueException();
        }

        return v3;
    }
}

