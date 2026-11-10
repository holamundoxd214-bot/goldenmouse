package androidx.compose.runtime.composer.linkbuffer;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001A>\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b¢\u0006\u0002\u0010\u0007\u001A7\u0010\b\u001A\u00020\t\"\u0004\b\u0000\u0010\u0001*\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b¨\u0006\n"}, d2={"fastLastOrNull", "T", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "predicate", "Lkotlin/Function1;", "", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fastIndexOf", "", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LinkGroupSourceInformationKt {
    private static final int fastIndexOf(ArrayList arg3, Function1 arg4) {
        int v0 = arg3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(arg4.invoke(arg3.get(v1)).booleanValue()) {
                return v1;
            }
        }

        return -1;
    }

    private static final Object fastLastOrNull(ArrayList arg3, Function1 arg4) {
        int v0;
        for(v0 = arg3.size() - 1; v0 >= 0; --v0) {
            Object v1 = arg3.get(v0);
            if(arg4.invoke(v1).booleanValue()) {
                return v1;
            }
        }

        return null;
    }
}

