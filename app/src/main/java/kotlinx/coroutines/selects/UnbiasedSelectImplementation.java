package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\n\u001A\u00020\u000B*\u00020\f2\u001C\u0010\r\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000EH\u0096\u0002¢\u0006\u0002\u0010\u0011JB\u0010\n\u001A\u00020\u000B\"\u0004\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\"\u0010\r\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014H\u0096\u0002¢\u0006\u0002\u0010\u0015JV\u0010\n\u001A\u00020\u000B\"\u0004\b\u0001\u0010\u0016\"\u0004\b\u0002\u0010\u0012*\u000E\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00120\u00172\u0006\u0010\u0018\u001A\u0002H\u00162\"\u0010\r\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u000E\u0010\u001A\u001A\u00028\u0000H\u0091@¢\u0006\u0002\u0010\u001BJ\b\u0010\u001C\u001A\u00020\u000BH\u0002R\u001E\u0010\u0007\u001A\u0012\u0012\u000E\u0012\f0\tR\b\u0012\u0004\u0012\u00028\u00000\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Lkotlinx/coroutines/selects/UnbiasedSelectImplementation;", "R", "Lkotlinx/coroutines/selects/SelectImplementation;", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "clausesToRegister", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "invoke", "", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "doSelect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shuffleAndRegisterClauses", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class UnbiasedSelectImplementation extends SelectImplementation {
    private final List clausesToRegister;

    public UnbiasedSelectImplementation(CoroutineContext arg1) {
        super(arg1);
        this.clausesToRegister = new ArrayList();
    }

    public Object doSelect(Continuation arg1) {
        return UnbiasedSelectImplementation.doSelect$suspendImpl(this, arg1);
    }

    static Object doSelect$suspendImpl(UnbiasedSelectImplementation arg0, Continuation arg1) {
        arg0.shuffleAndRegisterClauses();
        return super.doSelect(arg1);
    }

    public void invoke(SelectClause0 arg10, Function1 arg11) {
        this.clausesToRegister.add(new ClauseData(this, arg10.getClauseObject(), arg10.getRegFunc(), arg10.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), arg11, arg10.getOnCancellationConstructor()));
    }

    public void invoke(SelectClause1 arg10, Function2 arg11) {
        this.clausesToRegister.add(new ClauseData(this, arg10.getClauseObject(), arg10.getRegFunc(), arg10.getProcessResFunc(), null, arg11, arg10.getOnCancellationConstructor()));
    }

    public void invoke(SelectClause2 arg10, Object arg11, Function2 arg12) {
        this.clausesToRegister.add(new ClauseData(this, arg10.getClauseObject(), arg10.getRegFunc(), arg10.getProcessResFunc(), arg11, arg12, arg10.getOnCancellationConstructor()));
    }

    private final void shuffleAndRegisterClauses() {
        try {
            Collections.shuffle(this.clausesToRegister);
            Iterator v0_1 = this.clausesToRegister.iterator();
            while(v0_1.hasNext()) {
                SelectImplementation.register$default(this, v0_1.next(), false, 1, null);
            }
        }
        catch(Throwable v0) {
            goto label_18;
        }

        this.clausesToRegister.clear();
        return;
    label_18:
        this.clausesToRegister.clear();
        throw v0;
    }
}

