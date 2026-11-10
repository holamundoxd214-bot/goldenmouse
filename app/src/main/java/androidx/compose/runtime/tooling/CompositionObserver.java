package androidx.compose.runtime.tooling;

import androidx.compose.runtime.RecomposeScope;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\bH&J\u0018\u0010\t\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u0001H&J\u0010\u0010\u000B\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\bH&J\u0010\u0010\f\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u001A\u0010\r\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\b2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H&J\u0010\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0001"}, d2={"Landroidx/compose/runtime/tooling/CompositionObserver;", "", "onBeginComposition", "", "composition", "Landroidx/compose/runtime/tooling/ObservableComposition;", "onScopeEnter", "scope", "Landroidx/compose/runtime/RecomposeScope;", "onReadInScope", "value", "onScopeExit", "onEndComposition", "onScopeInvalidated", "onScopeDisposed", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface CompositionObserver {
    void onBeginComposition(ObservableComposition arg1);

    void onEndComposition(ObservableComposition arg1);

    void onReadInScope(RecomposeScope arg1, Object arg2);

    void onScopeDisposed(RecomposeScope arg1);

    void onScopeEnter(RecomposeScope arg1);

    void onScopeExit(RecomposeScope arg1);

    void onScopeInvalidated(RecomposeScope arg1, Object arg2);
}

