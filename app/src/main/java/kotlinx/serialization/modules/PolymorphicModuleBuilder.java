package kotlinx.serialization.modules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0002B)\b\u0001\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\b\u0002\u0010\u0005\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u0012\u001A\u00020\u0013\"\b\b\u0001\u0010\u0014*\u00028\u00002\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u00140\u0006J3\u0010\u0016\u001A\u00020\u00132+\u0010\u000F\u001A\'\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\rJ5\u0010\u001A\u001A\u00020\u00132+\u0010\f\u001A\'\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\rH\u0007J\u0010\u0010\u001B\u001A\u00020\u00132\u0006\u0010\u001C\u001A\u00020\u001DH\u0001R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\t\u001A$\u0012 \u0012\u001E\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001A\u0018\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000E\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R&\u0010\u000F\u001A\u001A\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Base", "", "baseClass", "Lkotlin/reflect/KClass;", "baseSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "subclasses", "", "Lkotlin/Pair;", "defaultSerializerProvider", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "defaultDeserializerProvider", "", "Lkotlinx/serialization/DeserializationStrategy;", "subclass", "", "T", "serializer", "defaultDeserializer", "Lkotlin/ParameterName;", "name", "className", "default", "buildTo", "builder", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PolymorphicModuleBuilder {
    private final KClass baseClass;
    private final KSerializer baseSerializer;
    private Function1 defaultDeserializerProvider;
    private Function1 defaultSerializerProvider;
    private final List subclasses;

    public PolymorphicModuleBuilder(KClass arg2, KSerializer arg3) {
        Intrinsics.checkNotNullParameter(arg2, "baseClass");
        super();
        this.baseClass = arg2;
        this.baseSerializer = arg3;
        this.subclasses = new ArrayList();
    }

    public PolymorphicModuleBuilder(KClass arg1, KSerializer arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public final void buildTo(SerializersModuleBuilder arg10) {
        Intrinsics.checkNotNullParameter(arg10, "builder");
        KSerializer v4 = this.baseSerializer;
        if(v4 != null) {
            SerializersModuleBuilder.registerPolymorphicSerializer$default(arg10, this.baseClass, this.baseClass, v4, false, 8, null);
        }

        Iterator v8 = this.subclasses.iterator();
        while(v8.hasNext()) {
            Object v1 = v8.next();
            Object v3 = ((Pair)v1).component1();
            Object v4_1 = ((Pair)v1).component2();
            KClass v2 = this.baseClass;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder>");
            Intrinsics.checkNotNull(v4_1, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            SerializersModuleBuilder.registerPolymorphicSerializer$default(arg10, v2, ((KClass)v3), ((KSerializer)v4_1), false, 8, null);
        }

        Function1 v2_1 = this.defaultSerializerProvider;
        if(v2_1 != null) {
            arg10.registerDefaultPolymorphicSerializer(this.baseClass, v2_1, false);
        }

        v2_1 = this.defaultDeserializerProvider;
        if(v2_1 != null) {
            arg10.registerDefaultPolymorphicDeserializer(this.baseClass, v2_1, false);
        }
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Deprecated in favor of function with more precise name: defaultDeserializer", replaceWith="<_subannotation>") public final void default(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "defaultSerializerProvider");
        this.defaultDeserializer(arg2);
    }

    public final void defaultDeserializer(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "defaultDeserializerProvider");
        if(this.defaultDeserializerProvider == null) {
            this.defaultDeserializerProvider = arg2;
            return;
        }

        throw new IllegalArgumentException("Default deserializer provider is already registered for class " + this.baseClass + ": " + this.defaultDeserializerProvider.toString());
    }

    public final void subclass(KClass arg2, KSerializer arg3) {
        Intrinsics.checkNotNullParameter(arg2, "subclass");
        Intrinsics.checkNotNullParameter(arg3, "serializer");
        this.subclasses.add(TuplesKt.to(arg2, arg3));
    }
}

