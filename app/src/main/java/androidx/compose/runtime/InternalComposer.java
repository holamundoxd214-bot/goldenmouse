package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u001A\u001A\u00020\u001BH ¢\u0006\u0002\b\u001CJ\r\u0010\u001D\u001A\u00020\u001BH ¢\u0006\u0002\b\u001EJ\r\u0010\u001F\u001A\u00020\u001BH ¢\u0006\u0002\b J\r\u0010!\u001A\u00020\u0005H ¢\u0006\u0002\b\"J\r\u0010#\u001A\u00020\u001BH ¢\u0006\u0002\b$J\r\u0010%\u001A\u00020\u001BH ¢\u0006\u0002\b&J\r\u0010\'\u001A\u00020\u001BH ¢\u0006\u0002\b(J\r\u0010)\u001A\u00020*H ¢\u0006\u0002\b+J\u0017\u0010,\u001A\u00020-2\b\u0010.\u001A\u0004\u0018\u00010/H ¢\u0006\u0002\b0J\u0013\u00101\u001A\b\u0012\u0004\u0012\u00020302H ¢\u0006\u0002\b4J\u001B\u00105\u001A\u00020\u001B2\f\u00106\u001A\b\u0012\u0004\u0012\u00020\u001B07H ¢\u0006\u0002\b8J@\u00109\u001A\u00020\u001B2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020/0;2\u0011\u0010<\u001A\r\u0012\u0004\u0012\u00020\u001B07¢\u0006\u0002\b=2\b\u0010>\u001A\u0004\u0018\u00010?H ¢\u0006\u0004\b@\u0010AJ-\u0010B\u001A\u00020\u00052\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020/0;2\b\u0010>\u001A\u0004\u0018\u00010?H ¢\u0006\u0004\bC\u0010DJ\u001F\u0010E\u001A\u00020\u00052\u0006\u0010F\u001A\u00020\r2\b\u0010G\u001A\u0004\u0018\u00010/H ¢\u0006\u0002\bHJ#\u0010I\u001A\u00020\u001B2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020/0;H ¢\u0006\u0004\bJ\u0010KJ\r\u0010L\u001A\u00020*H!¢\u0006\u0002\bMR\u0012\u0010\u0004\u001A\u00020\u0005X \u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\u0005X \u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001A\u00020\u0005X \u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0007R\u0014\u0010\f\u001A\u0004\u0018\u00010\rX \u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u0004\u0018\u00010\u0011X \u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u0004\u0018\u00010\u0015X \u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001A\u00020\u0005X \u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0007¨\u0006N"}, d2={"Landroidx/compose/runtime/InternalComposer;", "Landroidx/compose/runtime/Composer;", "<init>", "()V", "areChildrenComposing", "", "getAreChildrenComposing$runtime", "()Z", "isComposing", "isComposing$runtime", "hasPendingChanges", "getHasPendingChanges$runtime", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "getErrorContext$runtime", "()Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "deferredChanges", "Landroidx/compose/runtime/Changes;", "getDeferredChanges$runtime", "()Landroidx/compose/runtime/Changes;", "sourceMarkersEnabled", "getSourceMarkersEnabled$runtime", "startReuseFromRoot", "", "startReuseFromRoot$runtime", "endReuseFromRoot", "endReuseFromRoot$runtime", "changesApplied", "changesApplied$runtime", "forceRecomposeScopes", "forceRecomposeScopes$runtime", "dispose", "dispose$runtime", "deactivate", "deactivate$runtime", "verifyConsistent", "verifyConsistent$runtime", "stacksSize", "", "stacksSize$runtime", "stackTraceForValue", "Landroidx/compose/runtime/tooling/ComposeStackTrace;", "value", "", "stackTraceForValue$runtime", "parentStackTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "parentStackTrace$runtime", "prepareCompose", "block", "Lkotlin/Function0;", "prepareCompose$runtime", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/ScopeMap;", "content", "Landroidx/compose/runtime/Composable;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeContent--ZbOJvo$runtime", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ShouldPauseCallback;)V", "recompose", "recompose-aFTiNEg$runtime", "(Landroidx/collection/MutableScatterMap;Landroidx/compose/runtime/ShouldPauseCallback;)Z", "tryImminentInvalidation", "scope", "instance", "tryImminentInvalidation$runtime", "updateComposerInvalidations", "updateComposerInvalidations-RY85e9Y$runtime", "(Landroidx/collection/MutableScatterMap;)V", "parentKey", "parentKey$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class InternalComposer implements Composer {
    public static final int $stable;

    static {
    }

    public InternalComposer() {
        super();
    }

    public abstract void changesApplied$runtime();

    public abstract void composeContent--ZbOJvo$runtime(MutableScatterMap arg1, Function2 arg2, ShouldPauseCallback arg3);

    public abstract void deactivate$runtime();

    public abstract void dispose$runtime();

    public abstract void endReuseFromRoot$runtime();

    public abstract boolean forceRecomposeScopes$runtime();

    public abstract boolean getAreChildrenComposing$runtime();

    public abstract RecomposeScopeImpl getCurrentRecomposeScope$runtime();

    public abstract Changes getDeferredChanges$runtime();

    public abstract CompositionErrorContextImpl getErrorContext$runtime();

    public abstract boolean getHasPendingChanges$runtime();

    public abstract boolean getSourceMarkersEnabled$runtime();

    public abstract boolean isComposing$runtime();

    public abstract int parentKey$runtime();

    public abstract List parentStackTrace$runtime();

    public abstract void prepareCompose$runtime(Function0 arg1);

    public abstract boolean recompose-aFTiNEg$runtime(MutableScatterMap arg1, ShouldPauseCallback arg2);

    public abstract ComposeStackTrace stackTraceForValue$runtime(Object arg1);

    public abstract int stacksSize$runtime();

    public abstract void startReuseFromRoot$runtime();

    public abstract boolean tryImminentInvalidation$runtime(RecomposeScopeImpl arg1, Object arg2);

    public abstract void updateComposerInvalidations-RY85e9Y$runtime(MutableScatterMap arg1);

    public abstract void verifyConsistent$runtime();
}

