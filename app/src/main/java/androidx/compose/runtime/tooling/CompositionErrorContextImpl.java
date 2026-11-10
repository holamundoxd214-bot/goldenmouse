package androidx.compose.runtime.tooling;

import androidx.compose.runtime.InternalComposer;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element$DefaultImpls;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001AB\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001A\u00020\t*\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u001D\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001A\u0006\u0012\u0002\b\u00030\u00178VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "Landroidx/compose/runtime/tooling/CompositionErrorContext;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "Lkotlin/coroutines/CoroutineContext$Element;", "composer", "Landroidx/compose/runtime/InternalComposer;", "<init>", "(Landroidx/compose/runtime/InternalComposer;)V", "attachComposeStackTrace", "", "", "composeNode", "", "buildStackTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "currentOffset", "", "(Ljava/lang/Integer;)Ljava/util/List;", "sourceInformationEnabled", "getSourceInformationEnabled", "()Z", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CompositionErrorContextImpl implements OperationErrorContext, CompositionErrorContext, Element {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0006H\u0016¨\u0006\u0007"}, d2={"Landroidx/compose/runtime/tooling/CompositionErrorContextImpl$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "<init>", "()V", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Key implements kotlin.coroutines.CoroutineContext$Key {
        public Key(DefaultConstructorMarker arg1) {
            this();
        }

        private Key() {
            super();
        }

        public String toString() {
            return "CompositionErrorContext";
        }
    }

    public static final int $stable;
    public static final Key Key;
    private final InternalComposer composer;

    static {
        CompositionErrorContextImpl.Key = new Key(null);
    }

    public CompositionErrorContextImpl(InternalComposer arg1) {
        super();
        this.composer = arg1;
    }

    public boolean attachComposeStackTrace(Throwable arg2, Object arg3) {
        return ComposeStackTraceKt.tryAttachComposeStackTrace(arg2, new CompositionErrorContextImpl$$ExternalSyntheticLambda0(this, arg3));
    }

    static final ComposeStackTrace attachComposeStackTrace$lambda$0(CompositionErrorContextImpl arg0, Object arg1) {
        return arg0.composer.stackTraceForValue$runtime(arg1);
    }

    public List buildStackTrace(Integer arg1) {
        return this.composer.parentStackTrace$runtime();
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((Element)this), arg1, arg2);
    }

    public Element get(kotlin.coroutines.CoroutineContext$Key arg1) {
        return DefaultImpls.get(((Element)this), arg1);
    }

    public kotlin.coroutines.CoroutineContext$Key getKey() {
        return CompositionErrorContextImpl.Key;
    }

    public boolean getSourceInformationEnabled() {
        return this.composer.getSourceMarkersEnabled$runtime();
    }

    public CoroutineContext minusKey(kotlin.coroutines.CoroutineContext$Key arg1) {
        return DefaultImpls.minusKey(((Element)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((Element)this), arg1);
    }
}

