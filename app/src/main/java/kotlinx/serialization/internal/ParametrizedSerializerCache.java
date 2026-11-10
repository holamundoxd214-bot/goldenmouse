package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J;\u0010\u0003\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u00042\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00020\u00072\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "T", "", "get", "Lkotlin/Result;", "Lkotlinx/serialization/KSerializer;", "key", "Lkotlin/reflect/KClass;", "types", "", "Lkotlin/reflect/KType;", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ParametrizedSerializerCache {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static Object get-gIAlu-s$default(ParametrizedSerializerCache arg0, KClass arg1, List arg2, int arg3, Object arg4) {
            if(arg4 == null) {
                if((arg3 & 2) != 0) {
                    arg2 = CollectionsKt.emptyList();
                }

                return arg0.get-gIAlu-s(arg1, arg2);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get-gIAlu-s");
        }
    }

    Object get-gIAlu-s(KClass arg1, List arg2);
}

