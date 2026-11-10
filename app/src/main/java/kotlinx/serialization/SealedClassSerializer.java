package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind$SEALED;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001B\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BI\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000B0\t¢\u0006\u0004\b\f\u0010\rBY\b\u0011\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000B0\t\u0012\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u000F0\t¢\u0006\u0004\b\f\u0010\u0010J\"\u0010\u001E\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001F2\u0006\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010\u0005H\u0016J%\u0010\u001E\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#2\u0006\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\'R\u001A\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u000F0\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\u0015\u001A\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u0017\u0010\u0018R*\u0010\u001B\u001A\u001E\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000B0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001D\u001A\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000B0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2={"Lkotlinx/serialization/SealedClassSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "serialName", "", "baseClass", "Lkotlin/reflect/KClass;", "subclasses", "", "subclassSerializers", "Lkotlinx/serialization/KSerializer;", "<init>", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)V", "classAnnotations", "", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;[Ljava/lang/annotation/Annotation;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "_annotations", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "class2Serializer", "", "serialName2Serializer", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "klassName", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @InternalSerializationApi public final class SealedClassSerializer extends AbstractPolymorphicSerializer {
    private List _annotations;
    private final KClass baseClass;
    private final Map class2Serializer;
    private final Lazy descriptor$delegate;
    private final Map serialName2Serializer;

    public SealedClassSerializer(String arg4, KClass arg5, KClass[] arg6, KSerializer[] arg7) {
        Object v2;
        Object v1;
        Object v7;
        Intrinsics.checkNotNullParameter(arg4, "serialName");
        Intrinsics.checkNotNullParameter(arg5, "baseClass");
        Intrinsics.checkNotNullParameter(arg6, "subclasses");
        Intrinsics.checkNotNullParameter(arg7, "subclassSerializers");
        super();
        this.baseClass = arg5;
        this._annotations = CollectionsKt.emptyList();
        this.descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new SealedClassSerializer$$ExternalSyntheticLambda0(arg4, this));
        if(arg6.length != arg7.length) {
            goto label_79;
        }

        Map v4 = MapsKt.toMap(ArraysKt.zip(((Object[])arg6), ((Object[])arg7)));
        this.class2Serializer = v4;
        SealedClassSerializer$special$$inlined$groupingBy$1 v5 = new SealedClassSerializer$special$$inlined$groupingBy$1(v4.entrySet());
        LinkedHashMap v4_1 = new LinkedHashMap();
        Iterator v6 = ((Grouping)v5).sourceIterator();
        while(true) {
            if(!v6.hasNext()) {
                goto label_63;
            }

            v7 = v6.next();
            Object v0 = ((Grouping)v5).keyOf(v7);
            v1 = ((Map)v4_1).get(v0);
            if(v1 == null) {
                ((Map)v4_1).containsKey(v0);
            }

            v2 = v0;
            if(v1 != null) {
                break;
            }

            ((Map)v4_1).put(v0, v7);
        }

        throw new IllegalStateException("Multiple sealed subclasses of \'" + this.getBaseClass() + "\' have the same serial name \'" + (((String)v2)) + "\': \'" + ((Map$Entry)v1).getKey() + "\', \'" + ((Map$Entry)v7).getKey() + '\''.toString());
    label_63:
        LinkedHashMap v5_1 = new LinkedHashMap(MapsKt.mapCapacity(((Map)v4_1).size()));
        Iterator v4_2 = ((Map)v4_1).entrySet().iterator();
        while(v4_2.hasNext()) {
            Object v6_1 = v4_2.next();
            ((Map)v5_1).put(((Map$Entry)v6_1).getKey(), ((Map$Entry)v6_1).getValue().getValue());
        }

        this.serialName2Serializer = ((Map)v5_1);
        return;
    label_79:
        throw new IllegalArgumentException("All subclasses of sealed class " + this.getBaseClass().getSimpleName() + " should be marked @Serializable");
    }

    public SealedClassSerializer(String arg2, KClass arg3, KClass[] arg4, KSerializer[] arg5, Annotation[] arg6) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        Intrinsics.checkNotNullParameter(arg3, "baseClass");
        Intrinsics.checkNotNullParameter(arg4, "subclasses");
        Intrinsics.checkNotNullParameter(arg5, "subclassSerializers");
        Intrinsics.checkNotNullParameter(arg6, "classAnnotations");
        this(arg2, arg3, arg4, arg5);
        this._annotations = ArraysKt.asList(((Object[])arg6));
    }

    static final SerialDescriptor descriptor_delegate$lambda$3(String arg3, SealedClassSerializer arg4) {
        return SerialDescriptorsKt.buildSerialDescriptor(arg3, SEALED.INSTANCE, new SerialDescriptor[0], new SealedClassSerializer$$ExternalSyntheticLambda1(arg4));
    }

    static final Unit descriptor_delegate$lambda$3$lambda$2(SealedClassSerializer arg8, ClassSerialDescriptorBuilder arg9) {
        Intrinsics.checkNotNullParameter(arg9, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(arg9, "type", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(arg9, "value", SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Sealed<" + arg8.getBaseClass().getSimpleName() + '>', CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new SealedClassSerializer$$ExternalSyntheticLambda2(arg8)), null, false, 12, null);
        arg9.setAnnotations(arg8._annotations);
        return Unit.INSTANCE;
    }

    static final Unit descriptor_delegate$lambda$3$lambda$2$lambda$1(SealedClassSerializer arg9, ClassSerialDescriptorBuilder arg10) {
        Intrinsics.checkNotNullParameter(arg10, "$this$buildSerialDescriptor");
        Iterator v9 = arg9.serialName2Serializer.entrySet().iterator();
        while(v9.hasNext()) {
            Object v0 = v9.next();
            ClassSerialDescriptorBuilder.element$default(arg10, ((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue().getDescriptor(), null, false, 12, null);
        }

        return Unit.INSTANCE;
    }

    public DeserializationStrategy findPolymorphicSerializerOrNull(CompositeDecoder arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        Object v0 = this.serialName2Serializer.get(arg3);
        if(v0 != null) {
            return ((DeserializationStrategy)v0);
        }

        return super.findPolymorphicSerializerOrNull(arg2, arg3);
    }

    public SerializationStrategy findPolymorphicSerializerOrNull(Encoder arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg3, "encoder");
        Intrinsics.checkNotNullParameter(arg4, "value");
        Object v0 = this.class2Serializer.get(Reflection.getOrCreateKotlinClass(arg4.getClass()));
        if(v0 != null) {
        }
        else {
            SerializationStrategy v0_1 = super.findPolymorphicSerializerOrNull(arg3, arg4);
        }

        if(v0 != null) {
            return ((SerializationStrategy)v0);
        }

        return null;
    }

    public KClass getBaseClass() {
        return this.baseClass;
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor$delegate.getValue();
    }
}

