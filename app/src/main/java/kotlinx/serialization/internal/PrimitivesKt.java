package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u001A\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0000\u001A\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u0007H\u0002\u001A\f\u0010\f\u001A\u00020\u0007*\u00020\u0007H\u0002\u001A$\u0010\r\u001A\n\u0012\u0004\u0012\u0002H\u000E\u0018\u00010\u0003\"\b\b\u0000\u0010\u000E*\u00020\u000F*\b\u0012\u0004\u0012\u0002H\u000E0\u0002H\u0000\"\"\u0010\u0000\u001A\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"BUILTIN_SERIALIZERS", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "PrimitiveDescriptorSafe", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "checkName", "", "capitalize", "builtinSerializerOrNull", "T", "", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PrimitivesKt {
    private static final Map BUILTIN_SERIALIZERS;

    static {
        PrimitivesKt.BUILTIN_SERIALIZERS = PlatformKt.initBuiltins();
    }

    public static final SerialDescriptor PrimitiveDescriptorSafe(String arg1, PrimitiveKind arg2) {
        Intrinsics.checkNotNullParameter(arg1, "serialName");
        Intrinsics.checkNotNullParameter(arg2, "kind");
        PrimitivesKt.checkName(arg1);
        return new PrimitiveSerialDescriptor(arg1, arg2);
    }

    public static final KSerializer builtinSerializerOrNull(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return PrimitivesKt.BUILTIN_SERIALIZERS.get(arg1);
    }

    private static final String capitalize(String arg3) {
        if(arg3.length() > 0) {
            StringBuilder v0 = new StringBuilder();
            char v1 = arg3.charAt(0);
            String v1_1 = Character.isLowerCase(v1) ? CharsKt.titlecase(v1) : String.valueOf(v1);
            v0 = v0.append(v1_1);
            arg3 = arg3.substring(1);
            Intrinsics.checkNotNullExpressionValue(arg3, "substring(...)");
            arg3 = v0.append(arg3).toString();
        }

        return arg3;
    }

    private static final void checkName(String arg4) {
        Object v1;
        Iterator v0 = PrimitivesKt.BUILTIN_SERIALIZERS.values().iterator();
        while(true) {
            if(!v0.hasNext()) {
                return;
            }

            v1 = v0.next();
            if(Intrinsics.areEqual(arg4, ((KSerializer)v1).getDescriptor().getSerialName())) {
                break;
            }
        }

        throw new IllegalArgumentException(StringsKt.trimIndent("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + arg4 + " there already exists " + Reflection.getOrCreateKotlinClass(v1.getClass()).getSimpleName() + ".\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
    }
}

