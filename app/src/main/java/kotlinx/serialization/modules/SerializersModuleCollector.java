package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001A\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00040\bH\u0016JQ\u0010\u0002\u001A\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00062/\u0010\t\u001A+\u0012\u001D\u0012\u001B\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000B¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\nH&JF\u0010\u000F\u001A\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u0001\"\b\b\u0001\u0010\u0011*\u0002H\u00102\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00100\u00062\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00110\u00062\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00110\bH&JK\u0010\u0015\u001A\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00100\u00062)\u0010\u0016\u001A%\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0017\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u00180\nH&JM\u0010\u0019\u001A\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00100\u00062+\u0010\u001A\u001A\'\u0012\u0015\u0012\u0013\u0018\u00010\u001B¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001C\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u001D0\nH&JM\u0010\u001E\u001A\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00100\u00062+\u0010\u001A\u001A\'\u0012\u0015\u0012\u0013\u0018\u00010\u001B¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001C\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u001D0\nH\u0017¨\u0006\u001F"}, d2={"Lkotlinx/serialization/modules/SerializersModuleCollector;", "", "contextual", "", "T", "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", "provider", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "typeArgumentsSerializers", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "Lkotlinx/serialization/SerializationStrategy;", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", "", "className", "Lkotlinx/serialization/DeserializationStrategy;", "polymorphicDefault", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @ExperimentalSerializationApi public interface SerializersModuleCollector {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static void contextual(SerializersModuleCollector arg1, KClass arg2, KSerializer arg3) {
            Intrinsics.checkNotNullParameter(arg2, "kClass");
            Intrinsics.checkNotNullParameter(arg3, "serializer");
            arg1.contextual(arg2, new SerializersModuleCollector$DefaultImpls$$ExternalSyntheticLambda0(arg3));
        }

        static KSerializer contextual$lambda$0(KSerializer arg1, List arg2) {
            Intrinsics.checkNotNullParameter(arg2, "it");
            return arg1;
        }

        @Deprecated(level=DeprecationLevel.WARNING, message="Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith="<_subannotation>") public static void polymorphicDefault(SerializersModuleCollector arg1, KClass arg2, Function1 arg3) {
            Intrinsics.checkNotNullParameter(arg2, "baseClass");
            Intrinsics.checkNotNullParameter(arg3, "defaultDeserializerProvider");
            arg1.polymorphicDefaultDeserializer(arg2, arg3);
        }
    }

    void contextual(KClass arg1, KSerializer arg2);

    void contextual(KClass arg1, Function1 arg2);

    void polymorphic(KClass arg1, KClass arg2, KSerializer arg3);

    @Deprecated(level=DeprecationLevel.WARNING, message="Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith="<_subannotation>") void polymorphicDefault(KClass arg1, Function1 arg2);

    void polymorphicDefaultDeserializer(KClass arg1, Function1 arg2);

    void polymorphicDefaultSerializer(KClass arg1, Function1 arg2);
}

