package kotlinx.serialization.modules;

import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001Bî\u0001\u0012\u0016\u0010\u0002\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012*\u0010\u0006\u001A&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012.\u0010\b\u001A*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u001C\u0012\u001A\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\n0\tj\u0006\u0012\u0002\b\u0003`\u000B0\u0003\u0012&\u0010\f\u001A\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012A\u0010\u000E\u001A=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\tj\u0006\u0012\u0002\b\u0003`\u00130\u0003\u0012\u0006\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u001A\u001A\n\u0012\u0004\u0012\u0002H\u001B\u0018\u00010\n\"\b\b\u0000\u0010\u001B*\u00020\u001C2\u000E\u0010\u001D\u001A\n\u0012\u0006\b\u0000\u0012\u0002H\u001B0\u00042\u0006\u0010\u001E\u001A\u0002H\u001BH\u0016¢\u0006\u0002\u0010\u001FJ4\u0010\u001A\u001A\n\u0012\u0004\u0012\u0002H\u001B\u0018\u00010\u0012\"\b\b\u0000\u0010\u001B*\u00020\u001C2\u000E\u0010\u001D\u001A\n\u0012\u0006\b\u0000\u0012\u0002H\u001B0\u00042\b\u0010 \u001A\u0004\u0018\u00010\rH\u0016J:\u0010!\u001A\n\u0012\u0004\u0012\u0002H\u001B\u0018\u00010\u0007\"\b\b\u0000\u0010\u001B*\u00020\u001C2\f\u0010\"\u001A\b\u0012\u0004\u0012\u0002H\u001B0\u00042\u0010\u0010#\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070$H\u0016J\u0010\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020(H\u0016R\u001E\u0010\u0002\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0006\u001A&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R6\u0010\b\u001A*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u001C\u0012\u001A\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\n0\tj\u0006\u0012\u0002\b\u0003`\u000B0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\f\u001A\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RI\u0010\u000E\u001A=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\tj\u0006\u0012\u0002\b\u0003`\u00130\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\u00020\u0015X\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2={"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerializersModule;", "class2ContextualFactory", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "polyBase2Serializers", "Lkotlinx/serialization/KSerializer;", "polyBase2DefaultSerializerProvider", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2NamedSerializers", "", "polyBase2DefaultDeserializerProvider", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "hasInterfaceContextualSerializers", "", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)V", "getHasInterfaceContextualSerializers$kotlinx_serialization_core", "()Z", "getPolymorphic", "T", "", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serializedClassName", "getContextual", "kClass", "typeArgumentsSerializers", "", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SerialModuleImpl extends SerializersModule {
    private final Map class2ContextualFactory;
    private final boolean hasInterfaceContextualSerializers;
    private final Map polyBase2DefaultDeserializerProvider;
    private final Map polyBase2DefaultSerializerProvider;
    private final Map polyBase2NamedSerializers;
    public final Map polyBase2Serializers;

    public SerialModuleImpl(Map arg2, Map arg3, Map arg4, Map arg5, Map arg6, boolean arg7) {
        Intrinsics.checkNotNullParameter(arg2, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(arg3, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(arg4, "polyBase2DefaultSerializerProvider");
        Intrinsics.checkNotNullParameter(arg5, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(arg6, "polyBase2DefaultDeserializerProvider");
        super(null);
        this.class2ContextualFactory = arg2;
        this.polyBase2Serializers = arg3;
        this.polyBase2DefaultSerializerProvider = arg4;
        this.polyBase2NamedSerializers = arg5;
        this.polyBase2DefaultDeserializerProvider = arg6;
        this.hasInterfaceContextualSerializers = arg7;
    }

    public void dumpTo(SerializersModuleCollector arg8) {
        Object v4;
        Object v3;
        Object v1;
        String v2;
        Intrinsics.checkNotNullParameter(arg8, "collector");
        Iterator v0 = this.class2ContextualFactory.entrySet().iterator();
        while(true) {
            v2 = "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>";
            if(!v0.hasNext()) {
                goto label_27;
            }

            v1 = v0.next();
            v3 = ((Map$Entry)v1).getKey();
            v1 = ((Map$Entry)v1).getValue();
            if((v1 instanceof Argless)) {
                Intrinsics.checkNotNull(v3, v2);
                KSerializer v1_1 = ((Argless)v1).getSerializer();
                Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                arg8.contextual(((KClass)v3), v1_1);
                continue;
            }

            if(!(v1 instanceof WithTypeArguments)) {
                break;
            }

            arg8.contextual(((KClass)v3), ((WithTypeArguments)v1).getProvider());
        }

        throw new NoWhenBranchMatchedException();
    label_27:
        v0 = this.polyBase2Serializers.entrySet().iterator();
    label_30:
        if(v0.hasNext()) {
            v1 = v0.next();
            v3 = ((Map$Entry)v1).getKey();
            Iterator v1_2 = ((Map$Entry)v1).getValue().entrySet().iterator();
            while(true) {
                if(!v1_2.hasNext()) {
                    goto label_30;
                }

                v4 = v1_2.next();
                Object v5 = ((Map$Entry)v4).getKey();
                v4 = ((Map$Entry)v4).getValue();
                Intrinsics.checkNotNull(v3, v2);
                Intrinsics.checkNotNull(v5, v2);
                Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                arg8.polymorphic(((KClass)v3), ((KClass)v5), ((KSerializer)v4));
            }
        }

        v0 = this.polyBase2DefaultSerializerProvider.entrySet().iterator();
        while(v0.hasNext()) {
            v1 = v0.next();
            v4 = ((Map$Entry)v1).getKey();
            v1 = ((Map$Entry)v1).getValue();
            Intrinsics.checkNotNull(v4, v2);
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            arg8.polymorphicDefaultSerializer(((KClass)v4), TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 1));
        }

        Iterator v7 = this.polyBase2DefaultDeserializerProvider.entrySet().iterator();
        while(v7.hasNext()) {
            Object v0_1 = v7.next();
            v1 = ((Map$Entry)v0_1).getKey();
            v0_1 = ((Map$Entry)v0_1).getValue();
            Intrinsics.checkNotNull(v1, v2);
            Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            arg8.polymorphicDefaultDeserializer(((KClass)v1), TypeIntrinsics.beforeCheckcastToFunctionOfArity(v0_1, 1));
        }
    }

    public KSerializer getContextual(KClass arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg2, "kClass");
        Intrinsics.checkNotNullParameter(arg3, "typeArgumentsSerializers");
        Object v1 = this.class2ContextualFactory.get(arg2);
        KSerializer v2 = null;
        KSerializer v1_1 = v1 != null ? ((ContextualProvider)v1).invoke(arg3) : v2;
        if((v1_1 instanceof KSerializer)) {
            return v1_1;
        }

        return v2;
    }

    public boolean getHasInterfaceContextualSerializers$kotlinx_serialization_core() {
        return this.hasInterfaceContextualSerializers;
    }

    public DeserializationStrategy getPolymorphic(KClass arg4, String arg5) {
        Intrinsics.checkNotNullParameter(arg4, "baseClass");
        Object v0 = this.polyBase2NamedSerializers.get(arg4);
        DeserializationStrategy v1 = null;
        v0 = v0 != null ? ((Map)v0).get(arg5) : v1;
        if((v0 instanceof KSerializer)) {
        }
        else {
            v0 = v1;
        }

        if(v0 != null) {
            return ((DeserializationStrategy)v0);
        }

        Object v3 = this.polyBase2DefaultDeserializerProvider.get(arg4);
        if(TypeIntrinsics.isFunctionOfArity(v3, 1)) {
        }
        else {
            v3 = v1;
        }

        if(v3 != null) {
            return ((Function1)v3).invoke(arg5);
        }

        return v1;
    }

    public SerializationStrategy getPolymorphic(KClass arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg4, "baseClass");
        Intrinsics.checkNotNullParameter(arg5, "value");
        SerializationStrategy v1 = null;
        if(!arg4.isInstance(arg5)) {
            return v1;
        }

        Object v0 = this.polyBase2Serializers.get(arg4);
        v0 = v0 != null ? ((Map)v0).get(Reflection.getOrCreateKotlinClass(arg5.getClass())) : v1;
        if((v0 instanceof SerializationStrategy)) {
        }
        else {
            v0 = v1;
        }

        if(v0 != null) {
            return ((SerializationStrategy)v0);
        }

        Object v3 = this.polyBase2DefaultSerializerProvider.get(arg4);
        if(TypeIntrinsics.isFunctionOfArity(v3, 1)) {
        }
        else {
            v3 = v1;
        }

        if(v3 != null) {
            return ((Function1)v3).invoke(arg5);
        }

        return v1;
    }
}

