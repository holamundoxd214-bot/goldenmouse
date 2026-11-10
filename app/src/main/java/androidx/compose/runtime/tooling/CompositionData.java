package androidx.compose.runtime.tooling;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\n\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000B\u001A\u00020\u0001H\u0016R\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2={"Landroidx/compose/runtime/tooling/CompositionData;", "", "compositionGroups", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "getCompositionGroups", "()Ljava/lang/Iterable;", "isEmpty", "", "()Z", "find", "identityToFind", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface CompositionData {
    default CompositionGroup find(Object arg1) {
        return null;
    }

    Iterable getCompositionGroups();

    boolean isEmpty();
}

