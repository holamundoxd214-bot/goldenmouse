package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0007\u001A \u0010\u0007\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u0006H\u0007¨\u0006\u000B"}, d2={"throwMissingFieldException", "", "seen", "", "goldenMask", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "throwArrayMissingFieldException", "seenArray", "", "goldenMaskArray", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PluginExceptionsKt {
    @InternalSerializationApi public static final void throwArrayMissingFieldException(int[] arg8, int[] arg9, SerialDescriptor arg10) {
        Intrinsics.checkNotNullParameter(arg8, "seenArray");
        Intrinsics.checkNotNullParameter(arg9, "goldenMaskArray");
        Intrinsics.checkNotNullParameter(arg10, "descriptor");
        ArrayList v0 = new ArrayList();
        int v1 = arg9.length;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            int v4 = arg9[v3] & ~arg8[v3];
            if(v4 != 0) {
                int v5;
                for(v5 = 0; v5 < 0x20; ++v5) {
                    if((v4 & 1) != 0) {
                        v0.add(arg10.getElementName(v3 * 0x20 + v5));
                    }

                    v4 >>>= 1;
                }
            }
        }

        throw new MissingFieldException(((List)v0), arg10.getSerialName());
    }

    @InternalSerializationApi public static final void throwMissingFieldException(int arg3, int arg4, SerialDescriptor arg5) {
        Intrinsics.checkNotNullParameter(arg5, "descriptor");
        ArrayList v0 = new ArrayList();
        arg3 = ~arg3 & arg4;
        for(arg4 = 0; arg4 < 0x20; ++arg4) {
            if((arg3 & 1) != 0) {
                v0.add(arg5.getElementName(arg4));
            }

            arg3 >>>= 1;
        }

        throw new MissingFieldException(((List)v0), arg5.getSerialName());
    }
}

