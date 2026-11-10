package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\u0011\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0081\b¨\u0006\b"}, d2={"checkOwnership", "", "Lkotlinx/coroutines/flow/internal/AbortFlowException;", "owner", "", "checkIndexOverflow", "", "index", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class FlowExceptions_commonKt {
    public static final int checkIndexOverflow(int arg1) {
        if(arg1 >= 0) {
            return arg1;
        }

        throw new ArithmeticException("Index overflow has happened");
    }

    public static final void checkOwnership(AbortFlowException arg1, Object arg2) {
        if(arg1.owner == arg2) {
            return;
        }

        throw arg1;
    }
}

