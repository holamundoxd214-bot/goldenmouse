package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001A\u00028\u00012\u0006\u0010\u0007\u001A\u00028\u0000H¦À\u0004¢\u0006\u0002\u0010\bJ3\u0010\u0006\u001A\u0002H\t\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\t*\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\t0\u000B2\u0006\u0010\u0007\u001A\u0002H\nH¦À\u0004¢\u0006\u0002\u0010\fJ \u0010\r\u001A\u00020\u000E*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000B2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0003H\u0087\u0082\u0004\u0082\u0001\u0001\u000F¨\u0006\u0010"}, d2={"Lkotlin/DeepRecursiveScope;", "T", "R", "", "<init>", "()V", "callRecursive", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "S", "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "", "Lkotlin/DeepRecursiveScopeImpl;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class DeepRecursiveScope {
    private DeepRecursiveScope() {
        super();
    }

    public DeepRecursiveScope(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract Object callRecursive(Object arg1, Continuation arg2);

    public abstract Object callRecursive(DeepRecursiveFunction arg1, Object arg2, Continuation arg3);

    @Deprecated(level=DeprecationLevel.ERROR, message="\'invoke\' should not be called from DeepRecursiveScope. Use \'callRecursive\' to do recursion in the heap instead of the call stack.", replaceWith="<_subannotation>") public final Void invoke(DeepRecursiveFunction arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }
}

