package androidx.savedstate;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001E\n\u0000\u001A*\u0010\u0000\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0005H\u0001¨\u0006\u0006"}, d2={"toArrayListUnsafe", "Ljava/util/ArrayList;", "T", "Lkotlin/collections/ArrayList;", "", "", "savedstate"}, k=5, mv={2, 0, 0}, xi=0x30, xs="androidx/savedstate/SavedStateWriterKt") final class SavedStateWriterKt__SavedStateWriter_androidKt {
    public static final ArrayList toArrayListUnsafe(Collection arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg1 instanceof ArrayList)) {
            return arg1;
        }

        return new ArrayList(arg1);
    }
}

