package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000j\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001AB\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001F\b\u0004\u0010\u0002\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0007\u001Ac\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00050\u001B2O\u0010\u001C\u001AK\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u001D\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u001E\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0002\u001A\u0010\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020!H\u0002\"]\u0010\u0017\u001AQ\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000F\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010 \u001A\u00020!X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\"\u001A\u00020!X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010#\u001A\u00020!X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010$\u001A\u00020!X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010(\u001A\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010*\u001A\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010+\u001A\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010,\u001A\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010-\u001A\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b.\u0010/*¦\u0001\b\u0007\u0010\b\"M\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000E¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u0000\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00050\t2M\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000E¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u0000\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00050\tB\u0002\b\u0010*¦\u0001\b\u0007\u0010\u0011\"M\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000F\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2M\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000F\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\tB\u0002\b\u0010*Þ\u0001\b\u0007\u0010\u0013\"i\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000E¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u0000\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000F\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u0014\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\t0\t2i\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000E¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u0000\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000F\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u0014\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\t0\tB\u0002\b\u0010¨\u00060"}, d2={"select", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RegistrationFunction", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "clauseObject", "Lkotlinx/coroutines/selects/SelectInstance;", "param", "Lkotlinx/coroutines/InternalCoroutinesApi;", "ProcessResultFunction", "clauseResult", "OnCancellationConstructor", "internalResult", "", "Lkotlin/coroutines/CoroutineContext;", "DUMMY_PROCESS_RESULT_FUNCTION", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "tryResume", "", "Lkotlinx/coroutines/CancellableContinuation;", "onCancellation", "cause", "value", "context", "TRY_SELECT_SUCCESSFUL", "", "TRY_SELECT_REREGISTER", "TRY_SELECT_CANCELLED", "TRY_SELECT_ALREADY_SELECTED", "TrySelectDetailedResult", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectInternalResult", "STATE_REG", "Lkotlinx/coroutines/internal/Symbol;", "STATE_COMPLETED", "STATE_CANCELLED", "NO_RESULT", "PARAM_CLAUSE_0", "getPARAM_CLAUSE_0", "()Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SelectKt {
    private static final Function3 DUMMY_PROCESS_RESULT_FUNCTION = null;
    private static final Symbol NO_RESULT = null;
    private static final Symbol PARAM_CLAUSE_0 = null;
    private static final Symbol STATE_CANCELLED = null;
    private static final Symbol STATE_COMPLETED = null;
    private static final Symbol STATE_REG = null;
    private static final int TRY_SELECT_ALREADY_SELECTED = 3;
    private static final int TRY_SELECT_CANCELLED = 2;
    private static final int TRY_SELECT_REREGISTER = 1;
    private static final int TRY_SELECT_SUCCESSFUL;

    static {
        SelectKt.DUMMY_PROCESS_RESULT_FUNCTION = SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1.INSTANCE;
        SelectKt.STATE_REG = new Symbol("STATE_REG");
        SelectKt.STATE_COMPLETED = new Symbol("STATE_COMPLETED");
        SelectKt.STATE_CANCELLED = new Symbol("STATE_CANCELLED");
        SelectKt.NO_RESULT = new Symbol("NO_RESULT");
        SelectKt.PARAM_CLAUSE_0 = new Symbol("PARAM_CLAUSE_0");
    }

    public static void OnCancellationConstructor$annotations() {
    }

    public static void ProcessResultFunction$annotations() {
    }

    public static void RegistrationFunction$annotations() {
    }

    private static final TrySelectDetailedResult TrySelectDetailedResult(int arg3) {
        if(arg3 != 0) {
            if(arg3 != 1) {
                if(arg3 != 2) {
                    if(arg3 == 3) {
                        return TrySelectDetailedResult.ALREADY_SELECTED;
                    }

                    throw new IllegalStateException("Unexpected internal result: " + arg3.toString());
                }

                return TrySelectDetailedResult.CANCELLED;
            }

            return TrySelectDetailedResult.REREGISTER;
        }

        return TrySelectDetailedResult.SUCCESSFUL;
    }

    public static final TrySelectDetailedResult access$TrySelectDetailedResult(int arg0) {
        return SelectKt.TrySelectDetailedResult(arg0);
    }

    public static final Function3 access$getDUMMY_PROCESS_RESULT_FUNCTION$p() {
        return SelectKt.DUMMY_PROCESS_RESULT_FUNCTION;
    }

    public static final Symbol access$getNO_RESULT$p() {
        return SelectKt.NO_RESULT;
    }

    public static final Symbol access$getSTATE_CANCELLED$p() {
        return SelectKt.STATE_CANCELLED;
    }

    public static final Symbol access$getSTATE_COMPLETED$p() {
        return SelectKt.STATE_COMPLETED;
    }

    public static final Symbol access$getSTATE_REG$p() {
        return SelectKt.STATE_REG;
    }

    public static final boolean access$tryResume(CancellableContinuation arg0, Function3 arg1) {
        return SelectKt.tryResume(arg0, arg1);
    }

    public static final Symbol getPARAM_CLAUSE_0() {
        return SelectKt.PARAM_CLAUSE_0;
    }

    public static final Object select(Function1 arg2, Continuation arg3) {
        SelectImplementation v0 = new SelectImplementation(arg3.getContext());
        arg2.invoke(v0);
        return v0.doSelect(arg3);
    }

    private static final Object select$$forInline(Function1 arg0, Continuation arg1) {
        null.getContext();
        throw null;
    }

    private static final boolean tryResume(CancellableContinuation arg2, Function3 arg3) {
        Object v3 = arg2.tryResume(Unit.INSTANCE, null, arg3);
        if(v3 == null) {
            return 0;
        }

        arg2.completeResume(v3);
        return 1;
    }
}

