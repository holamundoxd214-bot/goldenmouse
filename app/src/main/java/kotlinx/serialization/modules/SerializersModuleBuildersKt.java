package kotlinx.serialization.modules;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001A,\u0010\u0000\u001A\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001A#\u0010\u0000\u001A\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\b\u001A%\u0010\b\u001A\u00020\u00012\u0017\u0010\t\u001A\u0013\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086\bø\u0001\u0000\u001A\u0006\u0010\u000E\u001A\u00020\u0001\u001A\'\u0010\u000F\u001A\u00020\f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u000B2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\b\u001A[\u0010\u0010\u001A\u00020\f\"\b\b\u0000\u0010\u0011*\u00020\u0003*\u00020\u000B2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00110\u00052\u0010\b\u0002\u0010\u0013\u001A\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u00072\u001F\b\u0002\u0010\t\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2={"serializersModuleOf", "Lkotlinx/serialization/modules/SerializersModule;", "T", "", "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", "SerializersModule", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "", "Lkotlin/ExtensionFunctionType;", "EmptySerializersModule", "contextual", "polymorphic", "Base", "baseClass", "baseSerializer", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SerializersModuleBuildersKt {
    public static final SerializersModule EmptySerializersModule() {
        return SerializersModuleKt.getEmptySerializersModule();
    }

    public static final SerializersModule SerializersModule(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builderAction");
        SerializersModuleBuilder v0 = new SerializersModuleBuilder();
        arg1.invoke(v0);
        return v0.build();
    }

    public static final void contextual(SerializersModuleBuilder arg2, KSerializer arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "serializer");
        Intrinsics.reifiedOperationMarker(4, "T");
        arg2.contextual(Reflection.getOrCreateKotlinClass(Object.class), arg3);
    }

    public static final void polymorphic(SerializersModuleBuilder arg1, KClass arg2, KSerializer arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "baseClass");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        PolymorphicModuleBuilder v0 = new PolymorphicModuleBuilder(arg2, arg3);
        arg4.invoke(v0);
        v0.buildTo(arg1);
    }

    public static void polymorphic$default(SerializersModuleBuilder arg0, KClass arg1, KSerializer arg2, Function1 arg3, int arg4, Object arg5) {
        SerializersModuleBuildersKt$polymorphic$1 v3;
        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        if((arg4 & 4) != 0) {
            v3 = SerializersModuleBuildersKt$polymorphic$1.INSTANCE;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "baseClass");
        Intrinsics.checkNotNullParameter(v3, "builderAction");
        PolymorphicModuleBuilder v4 = new PolymorphicModuleBuilder(arg1, arg2);
        ((Function1)v3).invoke(v4);
        v4.buildTo(arg0);
    }

    public static final SerializersModule serializersModuleOf(KClass arg1, KSerializer arg2) {
        Intrinsics.checkNotNullParameter(arg1, "kClass");
        Intrinsics.checkNotNullParameter(arg2, "serializer");
        SerializersModuleBuilder v0 = new SerializersModuleBuilder();
        v0.contextual(arg1, arg2);
        return v0.build();
    }

    public static final SerializersModule serializersModuleOf(KSerializer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "serializer");
        Intrinsics.reifiedOperationMarker(4, "T");
        return SerializersModuleBuildersKt.serializersModuleOf(Reflection.getOrCreateKotlinClass(Object.class), arg2);
    }
}

