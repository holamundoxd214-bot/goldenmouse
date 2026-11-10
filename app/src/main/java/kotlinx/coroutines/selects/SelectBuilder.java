package kotlinx.coroutines.selects;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J0\u0010\u0003\u001A\u00020\u0004*\u00020\u00052\u001C\u0010\u0006\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H¦\u0002¢\u0006\u0002\u0010\tJB\u0010\u0003\u001A\u00020\u0004\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000B2\"\u0010\u0006\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH¦\u0002¢\u0006\u0002\u0010\rJV\u0010\u0003\u001A\u00020\u0004\"\u0004\b\u0001\u0010\u000E\"\u0004\b\u0002\u0010\n*\u000E\u0012\u0004\u0012\u0002H\u000E\u0012\u0004\u0012\u0002H\n0\u000F2\u0006\u0010\u0010\u001A\u0002H\u000E2\"\u0010\u0006\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH¦\u0002¢\u0006\u0002\u0010\u0011JP\u0010\u0003\u001A\u00020\u0004\"\u0004\b\u0001\u0010\u000E\"\u0004\b\u0002\u0010\n*\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u000E\u0012\u0004\u0012\u0002H\n0\u000F2\"\u0010\u0006\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u0096\u0002¢\u0006\u0002\u0010\u0012J3\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u00152\u001C\u0010\u0006\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H\u0017¢\u0006\u0002\u0010\u0016\u0082\u0001\u0001\u0017¨\u0006\u0018"}, d2={"Lkotlinx/coroutines/selects/SelectBuilder;", "R", "", "invoke", "", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Lkotlinx/coroutines/selects/SelectClause2;Lkotlin/jvm/functions/Function2;)V", "onTimeout", "timeMillis", "", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/selects/SelectImplementation;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface SelectBuilder {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        public static void invoke(SelectBuilder arg1, SelectClause2 arg2, Function2 arg3) {
            arg1.invoke(arg2, null, arg3);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Replaced with the same extension function", replaceWith="<_subannotation>") public static void onTimeout(SelectBuilder arg0, long arg1, Function1 arg3) {
            OnTimeoutKt.onTimeout(arg0, arg1, arg3);
        }
    }

    void invoke(SelectClause0 arg1, Function1 arg2);

    void invoke(SelectClause1 arg1, Function2 arg2);

    void invoke(SelectClause2 arg1, Object arg2, Function2 arg3);

    void invoke(SelectClause2 arg1, Function2 arg2);

    @Deprecated(level=DeprecationLevel.ERROR, message="Replaced with the same extension function", replaceWith="<_subannotation>") void onTimeout(long arg1, Function1 arg2);
}

