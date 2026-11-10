package kotlinx.serialization.encoding;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A3\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u001A;\u0010\t\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u000B2\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u001Ab\u0010\t\u001A\u00020\u0001\"\u0004\b\u0000\u0010\f*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\f0\u000E24\b\u0004\u0010\u0005\u001A.\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2={"encodeStructure", "", "Lkotlinx/serialization/encoding/Encoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "block", "Lkotlin/Function1;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "Lkotlin/ExtensionFunctionType;", "encodeCollection", "collectionSize", "", "E", "collection", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "index", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class EncodingKt {
    public static final void encodeCollection(Encoder arg1, SerialDescriptor arg2, int arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg4, "block");
        CompositeEncoder v1 = arg1.beginCollection(arg2, arg3);
        arg4.invoke(v1);
        v1.endStructure(arg2);
    }

    public static final void encodeCollection(Encoder arg3, SerialDescriptor arg4, Collection arg5, Function3 arg6) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "descriptor");
        Intrinsics.checkNotNullParameter(arg5, "collection");
        Intrinsics.checkNotNullParameter(arg6, "block");
        CompositeEncoder v3 = arg3.beginCollection(arg4, arg5.size());
        Iterator v5 = ((Iterable)arg5).iterator();
        int v0;
        for(v0 = 0; v5.hasNext(); v0 = v2) {
            Object v1 = v5.next();
            int v2 = v0 + 1;
            if(v0 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            arg6.invoke(v3, Integer.valueOf(v0), v1);
        }

        v3.endStructure(arg4);
    }

    public static final void encodeStructure(Encoder arg1, SerialDescriptor arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg3, "block");
        CompositeEncoder v1 = arg1.beginStructure(arg2);
        arg3.invoke(v1);
        v1.endStructure(arg2);
    }
}

