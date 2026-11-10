package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\"$\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006\"$\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001A\u0004\b\n\u0010\u0006¨\u0006\u000B"}, d2={"elementDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getElementDescriptors", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/lang/Iterable;", "elementNames", "", "getElementNames$annotations", "getElementNames", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SerialDescriptorKt {
    public static final Iterable getElementDescriptors(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new SerialDescriptorKt$special$$inlined$Iterable$1(arg1);
    }

    @ExperimentalSerializationApi public static void getElementDescriptors$annotations(SerialDescriptor arg0) {
    }

    public static final Iterable getElementNames(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new SerialDescriptorKt$special$$inlined$Iterable$2(arg1);
    }

    @ExperimentalSerializationApi public static void getElementNames$annotations(SerialDescriptor arg0) {
    }
}

