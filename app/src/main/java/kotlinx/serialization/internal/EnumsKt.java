package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u001B\n\u0002\b\u0006\u001A9\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001A_\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00072\u000E\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\u0010\u000B\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00070\u0007H\u0001¢\u0006\u0002\u0010\r\u001Ao\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00072\u000E\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\u0010\u000F\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00070\u00072\u000E\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007H\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2={"createSimpleEnumSerializer", "Lkotlinx/serialization/KSerializer;", "T", "", "serialName", "", "values", "", "(Ljava/lang/String;[Ljava/lang/Enum;)Lkotlinx/serialization/KSerializer;", "createMarkedEnumSerializer", "names", "annotations", "", "(Ljava/lang/String;[Ljava/lang/Enum;[Ljava/lang/String;[[Ljava/lang/annotation/Annotation;)Lkotlinx/serialization/KSerializer;", "createAnnotatedEnumSerializer", "entryAnnotations", "classAnnotations", "(Ljava/lang/String;[Ljava/lang/Enum;[Ljava/lang/String;[[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class EnumsKt {
    public static final KSerializer createAnnotatedEnumSerializer(String arg9, Enum[] arg10, String[] arg11, Annotation[][] arg12, Annotation[] arg13) {
        String v6_1;
        int v2;
        Intrinsics.checkNotNullParameter(arg9, "serialName");
        Intrinsics.checkNotNullParameter(arg10, "values");
        Intrinsics.checkNotNullParameter(arg11, "names");
        Intrinsics.checkNotNullParameter(arg12, "entryAnnotations");
        EnumDescriptor v0 = new EnumDescriptor(arg9, arg10.length);
        if(arg13 != null) {
            v2 = arg13.length;
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                v0.pushClassAnnotation(arg13[v3]);
            }
        }

        int v13 = arg10.length;
        v2 = 0;
        for(v3 = 0; v2 < v13; v3 = v5) {
            Enum v4 = arg10[v2];
            int v5 = v3 + 1;
            Object v6 = ArraysKt.getOrNull(((Object[])arg11), v3);
            if(v6 == null) {
                v6_1 = v4.name();
            }

            PluginGeneratedSerialDescriptor.addElement$default(v0, v6_1, false, 2, null);
            Object v3_1 = ArraysKt.getOrNull(arg12, v3);
            if(v3_1 != null) {
                int v4_1 = v3_1.length;
                int v6_2;
                for(v6_2 = 0; v6_2 < v4_1; ++v6_2) {
                    v0.pushAnnotation(v3_1[v6_2]);
                }
            }

            ++v2;
        }

        return new EnumSerializer(arg9, arg10, ((SerialDescriptor)v0));
    }

    public static final KSerializer createMarkedEnumSerializer(String arg10, Enum[] arg11, String[] arg12, Annotation[][] arg13) {
        Intrinsics.checkNotNullParameter(arg10, "serialName");
        Intrinsics.checkNotNullParameter(arg11, "values");
        Intrinsics.checkNotNullParameter(arg12, "names");
        Intrinsics.checkNotNullParameter(arg13, "annotations");
        EnumDescriptor v0 = new EnumDescriptor(arg10, arg11.length);
        int v1 = arg11.length;
        int v3 = 0;
        int v4;
        for(v4 = 0; v3 < v1; v4 = v6) {
            Enum v5 = arg11[v3];
            int v6 = v4 + 1;
            Object v7 = ArraysKt.getOrNull(((Object[])arg12), v4);
            if(v7 == null) {
                String v7_1 = v5.name();
            }

            PluginGeneratedSerialDescriptor.addElement$default(v0, ((String)v7), false, 2, null);
            Object v4_1 = ArraysKt.getOrNull(arg13, v4);
            if(v4_1 != null) {
                int v5_1 = v4_1.length;
                int v7_2;
                for(v7_2 = 0; v7_2 < v5_1; ++v7_2) {
                    v0.pushAnnotation(v4_1[v7_2]);
                }
            }

            ++v3;
        }

        return new EnumSerializer(arg10, arg11, ((SerialDescriptor)v0));
    }

    public static final KSerializer createSimpleEnumSerializer(String arg1, Enum[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "serialName");
        Intrinsics.checkNotNullParameter(arg2, "values");
        return new EnumSerializer(arg1, arg2);
    }
}

