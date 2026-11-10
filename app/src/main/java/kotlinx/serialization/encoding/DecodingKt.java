package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u00000\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AA\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u00052\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001A>\u0010\t\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00032\u0006\u0010\n\u001A\u00020\u000B2\u0019\b\u0004\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00010\f¢\u0006\u0002\b\u000EH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000F\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2={"decodeIfNullable", "T", "", "Lkotlinx/serialization/encoding/Decoder;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "block", "Lkotlin/Function0;", "(Lkotlinx/serialization/encoding/Decoder;Lkotlinx/serialization/DeserializationStrategy;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "decodeStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlin/Function1;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/encoding/Decoder;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DecodingKt {
    public static final Object decodeIfNullable(Decoder arg1, DeserializationStrategy arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "deserializer");
        Intrinsics.checkNotNullParameter(arg3, "block");
        if(!arg2.getDescriptor().isNullable()) {
            if(arg1.decodeNotNullMark()) {
            }
            else {
                return arg1.decodeNull();
            }
        }

        return arg3.invoke();
    }

    public static final Object decodeStructure(Decoder arg1, SerialDescriptor arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg3, "block");
        CompositeDecoder v1 = arg1.beginStructure(arg2);
        Object v3 = arg3.invoke(v1);
        v1.endStructure(arg2);
        return v3;
    }
}

