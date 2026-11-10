package kotlin.collections.jdk8;

import java.util.Map;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000\u001C\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\u0010%\n\u0002\b\u0003\u001AB\u0010\u0000\u001A\u0002H\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00042\u0006\u0010\u0005\u001A\u0002H\u00022\u0006\u0010\u0006\u001A\u0002H\u0001H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0007\u001AI\u0010\b\u001A\u00020\t\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003\"\t\b\u0001\u0010\u0001¢\u0006\u0002\b\u0003*\u0012\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0006\b\u0001\u0012\u0002H\u00010\n2\u0006\u0010\u0005\u001A\u0002H\u00022\u0006\u0010\u000B\u001A\u0002H\u0001H\u0087\u0088\b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2={"getOrDefault", "V", "K", "Lkotlin/internal/OnlyInputTypes;", "", "key", "defaultValue", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "", "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlin-stdlib-jdk8"}, k=2, mv={2, 3, 0}, pn="kotlin.collections", xi=0x30) public final class CollectionsJDK8Kt {
    private static final Object getOrDefault(Map arg1, Object arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getOrDefault(arg2, arg3);
    }

    @IgnorableReturnValue private static final boolean remove(Map arg1, Object arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return TypeIntrinsics.asMutableMap(arg1).remove(arg2, arg3);
    }
}

