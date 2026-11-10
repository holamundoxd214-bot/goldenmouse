package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialKind;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001AN\u0010\u0000\u001A\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052!\u0010\u0006\u001A\u001D\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u000B\u001A\u001F\u0010\f\u001A\u00020\r*\u00020\u00032\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u000FH\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2={"equalsImpl", "", "SD", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "other", "", "typeParamsAreEqual", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "otherDescriptor", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "hashCodeImpl", "", "typeParams", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PluginGeneratedSerialDescriptorKt {
    public static final boolean equalsImpl(SerialDescriptor arg5, Object arg6, Function1 arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "typeParamsAreEqual");
        if(arg5 == (((SerialDescriptor)arg6))) {
            return 1;
        }

        Intrinsics.reifiedOperationMarker(3, "SD");
        if(!(arg6 instanceof SerialDescriptor)) {
            return 0;
        }

        Object v3 = arg6;
        if(!Intrinsics.areEqual(arg5.getSerialName(), ((SerialDescriptor)v3).getSerialName())) {
            return 0;
        }

        if(!arg7.invoke(arg6).booleanValue()) {
            return 0;
        }

        if(arg5.getElementsCount() != ((SerialDescriptor)v3).getElementsCount()) {
            return 0;
        }

        int v6 = arg5.getElementsCount();
        int v7;
        for(v7 = 0; v7 < v6; ++v7) {
            if(!Intrinsics.areEqual(arg5.getElementDescriptor(v7).getSerialName(), ((SerialDescriptor)v3).getElementDescriptor(v7).getSerialName())) {
                return 0;
            }

            if(!Intrinsics.areEqual(arg5.getElementDescriptor(v7).getKind(), ((SerialDescriptor)v3).getElementDescriptor(v7).getKind())) {
                return 0;
            }
        }

        return 1;
    }

    public static final int hashCodeImpl(SerialDescriptor arg5, SerialDescriptor[] arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "typeParams");
        int v0 = arg5.getSerialName().hashCode() * 0x1F + Arrays.hashCode(((Object[])arg6));
        Iterable v5 = SerialDescriptorKt.getElementDescriptors(arg5);
        Iterator v6 = v5.iterator();
        int v1 = 1;
        int v2;
        for(v2 = 1; true; v2 += v4) {
            int v4 = 0;
            if(!v6.hasNext()) {
                break;
            }

            v2 *= 0x1F;
            String v3 = v6.next().getSerialName();
            if(v3 != null) {
                v4 = v3.hashCode();
            }
        }

        Iterator v5_1 = v5.iterator();
        while(v5_1.hasNext()) {
            v1 *= 0x1F;
            SerialKind v6_1 = v5_1.next().getKind();
            int v6_2 = v6_1 != null ? v6_1.hashCode() : 0;
            v1 += v6_2;
        }

        return (v0 * 0x1F + v2) * 0x1F + v1;
    }
}

