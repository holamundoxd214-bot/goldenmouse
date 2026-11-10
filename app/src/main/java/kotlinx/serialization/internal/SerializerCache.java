package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001E\u0010\u0003\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006H&J\u0014\u0010\u0007\u001A\u00020\b2\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0006H\u0016¨\u0006\t"}, d2={"Lkotlinx/serialization/internal/SerializerCache;", "T", "", "get", "Lkotlinx/serialization/KSerializer;", "key", "Lkotlin/reflect/KClass;", "isStored", "", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SerializerCache {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static boolean isStored(SerializerCache arg0, KClass arg1) {
            Intrinsics.checkNotNullParameter(arg1, "key");
            return 0;
        }
    }

    KSerializer get(KClass arg1);

    boolean isStored(KClass arg1);
}

