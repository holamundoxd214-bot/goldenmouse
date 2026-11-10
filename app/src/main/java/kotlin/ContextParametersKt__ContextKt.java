package kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AV\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0003\u001A\u0002H\u00022!\u0010\u0004\u001A\u001D\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\b\u001Aj\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u00012\u0006\u0010\u000B\u001A\u0002H\t2\u0006\u0010\f\u001A\u0002H\n2\'\u0010\u0004\u001A#\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u00010\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0004H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001¢\u0006\u0002\u0010\u000E\u001A~\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000F\"\u0004\b\u0003\u0010\u00012\u0006\u0010\u000B\u001A\u0002H\t2\u0006\u0010\f\u001A\u0002H\n2\u0006\u0010\u0010\u001A\u0002H\u000F2-\u0010\u0004\u001A)\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000F\u0012\u0004\u0012\u0002H\u00010\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0006H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0004 \u0001¢\u0006\u0002\u0010\u0012\u001A\u0092\u0001\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000F\"\u0004\b\u0003\u0010\u0013\"\u0004\b\u0004\u0010\u00012\u0006\u0010\u000B\u001A\u0002H\t2\u0006\u0010\f\u001A\u0002H\n2\u0006\u0010\u0010\u001A\u0002H\u000F2\u0006\u0010\u0014\u001A\u0002H\u001323\u0010\u0004\u001A/\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000F\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00010\u0015¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\bH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0005 \u0001¢\u0006\u0002\u0010\u0016\u001A¦\u0001\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000F\"\u0004\b\u0003\u0010\u0013\"\u0004\b\u0004\u0010\u0017\"\u0004\b\u0005\u0010\u00012\u0006\u0010\u000B\u001A\u0002H\t2\u0006\u0010\f\u001A\u0002H\n2\u0006\u0010\u0010\u001A\u0002H\u000F2\u0006\u0010\u0014\u001A\u0002H\u00132\u0006\u0010\u0018\u001A\u0002H\u001729\u0010\u0004\u001A5\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000F\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00010\u0019¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\nH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0006 \u0001¢\u0006\u0002\u0010\u001A\u001Aº\u0001\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000F\"\u0004\b\u0003\u0010\u0013\"\u0004\b\u0004\u0010\u0017\"\u0004\b\u0005\u0010\u001B\"\u0004\b\u0006\u0010\u00012\u0006\u0010\u000B\u001A\u0002H\t2\u0006\u0010\f\u001A\u0002H\n2\u0006\u0010\u0010\u001A\u0002H\u000F2\u0006\u0010\u0014\u001A\u0002H\u00132\u0006\u0010\u0018\u001A\u0002H\u00172\u0006\u0010\u001C\u001A\u0002H\u001B2?\u0010\u0004\u001A;\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000F\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001B\u0012\u0004\u0012\u0002H\u00010\u001D¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\fH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0007 \u0001¢\u0006\u0002\u0010\u001E\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001F"}, d2={"context", "R", "T", "with", "block", "Lkotlin/Function1;", "Lkotlin/ContextFunctionTypeParams;", "count", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "A", "B", "a", "b", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "C", "c", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "D", "d", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "E", "e", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "F", "f", "Lkotlin/Function6;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function6;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/ContextParametersKt") class ContextParametersKt__ContextKt {
    public ContextParametersKt__ContextKt() {
        super();
    }

    private static final Object context(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Function6 arg8) {
        Intrinsics.checkNotNullParameter(arg8, "block");
        return arg8.invoke(arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private static final Object context(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Function5 arg7) {
        Intrinsics.checkNotNullParameter(arg7, "block");
        return arg7.invoke(arg2, arg3, arg4, arg5, arg6);
    }

    private static final Object context(Object arg1, Object arg2, Object arg3, Object arg4, Function4 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "block");
        return arg5.invoke(arg1, arg2, arg3, arg4);
    }

    private static final Object context(Object arg1, Object arg2, Object arg3, Function3 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "block");
        return arg4.invoke(arg1, arg2, arg3);
    }

    private static final Object context(Object arg1, Object arg2, Function2 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "block");
        return arg3.invoke(arg1, arg2);
    }

    private static final Object context(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "block");
        return arg2.invoke(arg1);
    }
}

