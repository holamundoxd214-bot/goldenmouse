package androidx.compose.runtime.composer;

import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0016\u0010\u0007\u001A\u00020\u00032\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\tH&J\u0010\u0010\n\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u000BH&J\u0010\u0010\f\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u000BH&J\u0010\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000FH&J\u0010\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000FH&J\u0010\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000FH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2={"Landroidx/compose/runtime/composer/RememberManager;", "", "remembering", "", "instance", "Landroidx/compose/runtime/RememberObserverHolder;", "forgetting", "sideEffect", "effect", "Lkotlin/Function0;", "deactivating", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "releasing", "rememberPausingScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "startResumingScope", "endResumingScope", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface RememberManager {
    void deactivating(ComposeNodeLifecycleCallback arg1);

    void endResumingScope(RecomposeScopeImpl arg1);

    void forgetting(RememberObserverHolder arg1);

    void releasing(ComposeNodeLifecycleCallback arg1);

    void rememberPausingScope(RecomposeScopeImpl arg1);

    void remembering(RememberObserverHolder arg1);

    void sideEffect(Function0 arg1);

    void startResumingScope(RecomposeScopeImpl arg1);
}

