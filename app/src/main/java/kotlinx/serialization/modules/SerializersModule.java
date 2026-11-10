package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001A\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00060\bH\u0007J<\u0010\u0004\u001A\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00060\b2\u0012\b\u0002\u0010\n\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u000BH\'J7\u0010\f\u001A\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\r\"\b\b\u0000\u0010\u0006*\u00020\u00012\u000E\u0010\u000E\u001A\n\u0012\u0006\b\u0000\u0012\u0002H\u00060\b2\u0006\u0010\u000F\u001A\u0002H\u0006H\'¢\u0006\u0002\u0010\u0010J4\u0010\f\u001A\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0011\"\b\b\u0000\u0010\u0006*\u00020\u00012\u000E\u0010\u000E\u001A\n\u0012\u0006\b\u0000\u0012\u0002H\u00060\b2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\'J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\'R\u001A\u0010\u0018\u001A\u00020\u00198 X¡\u0004¢\u0006\f\u0012\u0004\b\u001A\u0010\u0003\u001A\u0004\b\u001B\u0010\u001C\u0082\u0001\u0001\u001D¨\u0006\u001E"}, d2={"Lkotlinx/serialization/modules/SerializersModule;", "", "<init>", "()V", "getContextual", "Lkotlinx/serialization/KSerializer;", "T", "kclass", "Lkotlin/reflect/KClass;", "kClass", "typeArgumentsSerializers", "", "getPolymorphic", "Lkotlinx/serialization/SerializationStrategy;", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/DeserializationStrategy;", "serializedClassName", "", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "hasInterfaceContextualSerializers", "", "getHasInterfaceContextualSerializers$kotlinx_serialization_core$annotations", "getHasInterfaceContextualSerializers$kotlinx_serialization_core", "()Z", "Lkotlinx/serialization/modules/SerialModuleImpl;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class SerializersModule {
    private SerializersModule() {
        super();
    }

    public SerializersModule(DefaultConstructorMarker arg1) {
        this();
    }

    @ExperimentalSerializationApi public abstract void dumpTo(SerializersModuleCollector arg1);

    @ExperimentalSerializationApi public abstract KSerializer getContextual(KClass arg1, List arg2);

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in favor of overload with default parameter", replaceWith="<_subannotation>") @ExperimentalSerializationApi public final KSerializer getContextual(KClass arg2) {
        Intrinsics.checkNotNullParameter(arg2, "kclass");
        return this.getContextual(arg2, CollectionsKt.emptyList());
    }

    public static KSerializer getContextual$default(SerializersModule arg0, KClass arg1, List arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = CollectionsKt.emptyList();
            }

            return arg0.getContextual(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
    }

    public abstract boolean getHasInterfaceContextualSerializers$kotlinx_serialization_core();

    @InternalSerializationApi public static void getHasInterfaceContextualSerializers$kotlinx_serialization_core$annotations() {
    }

    @ExperimentalSerializationApi public abstract DeserializationStrategy getPolymorphic(KClass arg1, String arg2);

    @ExperimentalSerializationApi public abstract SerializationStrategy getPolymorphic(KClass arg1, Object arg2);
}

