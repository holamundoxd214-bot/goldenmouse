package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001A\u00020\bH\u0016J\u001A\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\bH\u0016J\n\u0010\r\u001A\u0004\u0018\u00010\bH\u0005R\u0012\u0010\u0004\u001A\u00020\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "toString", "", "limitedParallelism", "parallelism", "", "name", "toStringInternalImpl", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public MainCoroutineDispatcher() {
        super();
    }

    public abstract MainCoroutineDispatcher getImmediate();

    public CoroutineDispatcher limitedParallelism(int arg1, String arg2) {
        LimitedDispatcherKt.checkParallelism(arg1);
        return LimitedDispatcherKt.namedOrThis(((CoroutineDispatcher)this), arg2);
    }

    public String toString() {
        String v0 = this.toStringInternalImpl();
        if(v0 == null) {
            return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this);
        }

        return v0;
    }

    protected final String toStringInternalImpl() {
        MainCoroutineDispatcher v0 = Dispatchers.getMain();
        if(this == v0) {
            return "Dispatchers.Main";
        }

        String v1 = null;
        try {
            v0 = v0.getImmediate();
        }
        catch(UnsupportedOperationException ) {
            v0 = ((MainCoroutineDispatcher)v1);
        }

        if(this == v0) {
            return "Dispatchers.Main.immediate";
        }

        return v1;
    }
}

