package kotlinx.serialization.modules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.PlatformKt;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\b\u0001¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0018\u001A\u00020\u0019\"\b\b\u0000\u0010\u001A*\u00020\u001B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u001A0\u00062\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u001A0\tH\u0016JQ\u0010\u0018\u001A\u00020\u0019\"\b\b\u0000\u0010\u001A*\u00020\u001B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u001A0\u00062/\u0010\u001E\u001A+\u0012\u001D\u0012\u001B\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u001F¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b( \u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000BH\u0016JF\u0010!\u001A\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001B\"\b\b\u0001\u0010#*\u0002H\"2\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H\"0\u00062\f\u0010%\u001A\b\u0012\u0004\u0012\u0002H#0\u00062\f\u0010&\u001A\b\u0012\u0004\u0012\u0002H#0\tH\u0016JK\u0010\'\u001A\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001B2\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H\"0\u00062)\u0010(\u001A%\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b()\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\f0\u000BH\u0016JM\u0010*\u001A\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001B2\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H\"0\u00062+\u0010+\u001A\'\u0012\u0015\u0012\u0013\u0018\u00010\u000F¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\u00140\u000BH\u0016J\u000E\u0010,\u001A\u00020\u00192\u0006\u0010-\u001A\u00020.J2\u0010/\u001A\u00020\u0019\"\b\b\u0000\u0010\u001A*\u00020\u001B2\f\u00100\u001A\b\u0012\u0004\u0012\u0002H\u001A0\u00062\u0006\u0010\u001E\u001A\u00020\u00072\b\b\u0002\u00101\u001A\u00020\u0017H\u0001JS\u00102\u001A\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001B2\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H\"0\u00062)\u0010(\u001A%\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b()\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\f0\u000B2\u0006\u00101\u001A\u00020\u0017H\u0001JU\u00103\u001A\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001B2\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H\"0\u00062+\u0010+\u001A\'\u0012\u0015\u0012\u0013\u0018\u00010\u000F¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\u00140\u000B2\u0006\u00101\u001A\u00020\u0017H\u0001JP\u00104\u001A\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001B\"\b\b\u0001\u0010#*\u0002H\"2\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H\"0\u00062\f\u00105\u001A\b\u0012\u0004\u0012\u0002H#0\u00062\f\u00106\u001A\b\u0012\u0004\u0012\u0002H#0\t2\b\b\u0002\u00101\u001A\u00020\u0017H\u0001J\b\u00107\u001A\u00020.H\u0001R\u001E\u0010\u0004\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\b\u001A&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\n\u001A*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u001C\u0012\u001A\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\f0\u000Bj\u0006\u0012\u0002\b\u0003`\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000E\u001A\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000F\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RI\u0010\u0010\u001A=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\u000F¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00140\u000Bj\u0006\u0012\u0002\b\u0003`\u00150\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00068"}, d2={"Lkotlinx/serialization/modules/SerializersModuleBuilder;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "<init>", "()V", "class2ContextualProvider", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "polyBase2Serializers", "Lkotlinx/serialization/KSerializer;", "polyBase2DefaultSerializerProvider", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2NamedSerializers", "", "polyBase2DefaultDeserializerProvider", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "hasInterfaceContextualSerializers", "", "contextual", "", "T", "", "kClass", "serializer", "provider", "", "typeArgumentsSerializers", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", "include", "module", "Lkotlinx/serialization/modules/SerializersModule;", "registerSerializer", "forClass", "allowOverwrite", "registerDefaultPolymorphicSerializer", "registerDefaultPolymorphicDeserializer", "registerPolymorphicSerializer", "concreteClass", "concreteSerializer", "build", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SerializersModuleBuilder implements SerializersModuleCollector {
    private final Map class2ContextualProvider;
    private boolean hasInterfaceContextualSerializers;
    private final Map polyBase2DefaultDeserializerProvider;
    private final Map polyBase2DefaultSerializerProvider;
    private final Map polyBase2NamedSerializers;
    private final Map polyBase2Serializers;

    public SerializersModuleBuilder() {
        super();
        this.class2ContextualProvider = new HashMap();
        this.polyBase2Serializers = new HashMap();
        this.polyBase2DefaultSerializerProvider = new HashMap();
        this.polyBase2NamedSerializers = new HashMap();
        this.polyBase2DefaultDeserializerProvider = new HashMap();
    }

    public final SerializersModule build() {
        return new SerialModuleImpl(this.class2ContextualProvider, this.polyBase2Serializers, this.polyBase2DefaultSerializerProvider, this.polyBase2NamedSerializers, this.polyBase2DefaultDeserializerProvider, this.hasInterfaceContextualSerializers);
    }

    public void contextual(KClass arg8, KSerializer arg9) {
        Intrinsics.checkNotNullParameter(arg8, "kClass");
        Intrinsics.checkNotNullParameter(arg9, "serializer");
        SerializersModuleBuilder.registerSerializer$default(this, arg8, new Argless(arg9), false, 4, null);
    }

    public void contextual(KClass arg8, Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg8, "kClass");
        Intrinsics.checkNotNullParameter(arg9, "provider");
        SerializersModuleBuilder.registerSerializer$default(this, arg8, new WithTypeArguments(arg9), false, 4, null);
    }

    public final void include(SerializersModule arg2) {
        Intrinsics.checkNotNullParameter(arg2, "module");
        arg2.dumpTo(((SerializersModuleCollector)this));
    }

    public void polymorphic(KClass arg9, KClass arg10, KSerializer arg11) {
        Intrinsics.checkNotNullParameter(arg9, "baseClass");
        Intrinsics.checkNotNullParameter(arg10, "actualClass");
        Intrinsics.checkNotNullParameter(arg11, "actualSerializer");
        SerializersModuleBuilder.registerPolymorphicSerializer$default(this, arg9, arg10, arg11, false, 8, null);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith="<_subannotation>") public void polymorphicDefault(KClass arg1, Function1 arg2) {
        DefaultImpls.polymorphicDefault(((SerializersModuleCollector)this), arg1, arg2);
    }

    public void polymorphicDefaultDeserializer(KClass arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "baseClass");
        Intrinsics.checkNotNullParameter(arg3, "defaultDeserializerProvider");
        this.registerDefaultPolymorphicDeserializer(arg2, arg3, false);
    }

    public void polymorphicDefaultSerializer(KClass arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "baseClass");
        Intrinsics.checkNotNullParameter(arg3, "defaultSerializerProvider");
        this.registerDefaultPolymorphicSerializer(arg2, arg3, false);
    }

    public final void registerDefaultPolymorphicDeserializer(KClass arg3, Function1 arg4, boolean arg5) {
        Intrinsics.checkNotNullParameter(arg3, "baseClass");
        Intrinsics.checkNotNullParameter(arg4, "defaultDeserializerProvider");
        Object v0 = this.polyBase2DefaultDeserializerProvider.get(arg3);
        if(v0 != null && !Intrinsics.areEqual(v0, arg4)) {
            if(arg5) {
            }
            else {
                throw new IllegalArgumentException("Default deserializers provider for " + arg3 + " is already registered: " + v0);
            }
        }

        this.polyBase2DefaultDeserializerProvider.put(arg3, arg4);
    }

    public final void registerDefaultPolymorphicSerializer(KClass arg3, Function1 arg4, boolean arg5) {
        Intrinsics.checkNotNullParameter(arg3, "baseClass");
        Intrinsics.checkNotNullParameter(arg4, "defaultSerializerProvider");
        Object v0 = this.polyBase2DefaultSerializerProvider.get(arg3);
        if(v0 != null && !Intrinsics.areEqual(v0, arg4)) {
            if(arg5) {
            }
            else {
                throw new IllegalArgumentException("Default serializers provider for " + arg3 + " is already registered: " + v0);
            }
        }

        this.polyBase2DefaultSerializerProvider.put(arg3, arg4);
    }

    public final void registerPolymorphicSerializer(KClass arg6, KClass arg7, KSerializer arg8, boolean arg9) {
        Object v8;
        HashMap v4_1;
        Intrinsics.checkNotNullParameter(arg6, "baseClass");
        Intrinsics.checkNotNullParameter(arg7, "concreteClass");
        Intrinsics.checkNotNullParameter(arg8, "concreteSerializer");
        String v0 = arg8.getDescriptor().getSerialName();
        Map v1 = this.polyBase2Serializers;
        Object v2 = v1.get(arg6);
        if(v2 == null) {
            HashMap v2_1 = new HashMap();
            v1.put(arg6, v2_1);
        }

        Object v1_1 = ((Map)v2).get(arg7);
        Map v3 = this.polyBase2NamedSerializers;
        Object v4 = v3.get(arg6);
        if(v4 == null) {
            v4_1 = new HashMap();
            v3.put(arg6, v4_1);
        }

        if(arg9) {
            if(v1_1 != null) {
                ((Map)v4_1).remove(((KSerializer)v1_1).getDescriptor().getSerialName());
            }

            ((Map)v2).put(arg7, arg8);
            ((Map)v4_1).put(v0, arg8);
            return;
        }

        if(v1_1 != null) {
            if(Intrinsics.areEqual(v1_1, arg8)) {
                ((Map)v4_1).remove(((KSerializer)v1_1).getDescriptor().getSerialName());
            }
            else {
                throw new SerializerAlreadyRegisteredException(arg6, arg7);
            }
        }

        Object v9 = ((Map)v4_1).get(v0);
        if(v9 != null) {
            Object v5 = this.polyBase2Serializers.get(arg6);
            Intrinsics.checkNotNull(v5);
            Iterator v5_1 = MapsKt.asSequence(((Map)v5)).iterator();
            while(true) {
                if(v5_1.hasNext()) {
                    v8 = v5_1.next();
                    if(v8.getValue() != v9) {
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_54;
            }

            v8 = null;
        label_54:
            throw new IllegalArgumentException("Multiple polymorphic serializers for base class \'" + arg6 + "\' have the same serial name \'" + v0 + "\': \'" + arg7 + "\' and \'" + v8 + '\'');
        }

        ((Map)v2).put(arg7, arg8);
        ((Map)v4_1).put(v0, arg8);
    }

    public static void registerPolymorphicSerializer$default(SerializersModuleBuilder arg0, KClass arg1, KClass arg2, KSerializer arg3, boolean arg4, int arg5, Object arg6) {
        arg0.registerPolymorphicSerializer(arg1, arg2, arg3, false);
    }

    public final void registerSerializer(KClass arg2, ContextualProvider arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg2, "forClass");
        Intrinsics.checkNotNullParameter(arg3, "provider");
        if(!arg4) {
            Object v4 = this.class2ContextualProvider.get(arg2);
            if(v4 != null) {
                if(Intrinsics.areEqual(v4, arg3)) {
                }
                else {
                    throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + arg2 + " already registered in this module");
                }
            }
        }

        this.class2ContextualProvider.put(arg2, arg3);
        if(PlatformKt.isInterface(arg2)) {
            this.hasInterfaceContextualSerializers = true;
        }
    }

    public static void registerSerializer$default(SerializersModuleBuilder arg0, KClass arg1, ContextualProvider arg2, boolean arg3, int arg4, Object arg5) {
        arg0.registerSerializer(arg1, arg2, false);
    }
}

