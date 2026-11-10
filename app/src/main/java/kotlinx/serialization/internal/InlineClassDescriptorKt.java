package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A$\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007¨\u0006\u0007"}, d2={"InlinePrimitiveDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "T", "name", "", "primitiveSerializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InlineClassDescriptorKt {
    @InternalSerializationApi public static final SerialDescriptor InlinePrimitiveDescriptor(String arg2, KSerializer arg3) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        Intrinsics.checkNotNullParameter(arg3, "primitiveSerializer");
        return new InlineClassDescriptor(arg2, new InlineClassDescriptorKt$InlinePrimitiveDescriptor$1(arg3));
    }
}

