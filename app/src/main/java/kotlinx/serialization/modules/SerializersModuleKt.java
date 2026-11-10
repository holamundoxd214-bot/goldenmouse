package kotlinx.serialization.modules;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0015\u0010\u0006\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0001H\u0086\u0002\u001A\u0015\u0010\b\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0001H\u0086\u0004\"\u001C\u0010\u0000\u001A\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001A\u0004\b\u0004\u0010\u0005*\\\b\u0000\u0010\t\u001A\u0004\b\u0000\u0010\n\"\'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00100\u000B2\'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00100\u000B*X\b\u0000\u0010\u0011\u001A\u0004\b\u0000\u0010\n\"%\u0012\u0013\u0012\u0011H\n¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00130\u000B2%\u0012\u0013\u0012\u0011H\n¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00130\u000B¨\u0006\u0014"}, d2={"EmptySerializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getEmptySerializersModule$annotations", "()V", "getEmptySerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "plus", "other", "overwriteWith", "PolymorphicDeserializerProvider", "Base", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "PolymorphicSerializerProvider", "value", "Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SerializersModuleKt {
    private static final SerializersModule EmptySerializersModule;

    static {
        SerializersModuleKt.EmptySerializersModule = new SerialModuleImpl(MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), false);
    }

    public static final SerializersModule getEmptySerializersModule() {
        return SerializersModuleKt.EmptySerializersModule;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Deprecated in the favour of \'EmptySerializersModule()\'", replaceWith="<_subannotation>") public static void getEmptySerializersModule$annotations() {
    }

    public static final SerializersModule overwriteWith(SerializersModule arg1, SerializersModule arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        SerializersModuleBuilder v0 = new SerializersModuleBuilder();
        v0.include(arg1);
        arg2.dumpTo(new SerializersModuleKt$overwriteWith$1$1(v0));
        return v0.build();
    }

    public static final SerializersModule plus(SerializersModule arg1, SerializersModule arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        SerializersModuleBuilder v0 = new SerializersModuleBuilder();
        v0.include(arg1);
        v0.include(arg2);
        return v0.build();
    }
}

