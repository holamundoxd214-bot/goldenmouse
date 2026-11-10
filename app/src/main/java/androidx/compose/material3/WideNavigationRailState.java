package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000E\u0010\u000B\u001A\u00020\fH¦@¢\u0006\u0002\u0010\rJ\u000E\u0010\u000E\u001A\u00020\fH¦@¢\u0006\u0002\u0010\rJ\u000E\u0010\u000F\u001A\u00020\fH¦@¢\u0006\u0002\u0010\rJ\u0016\u0010\u0010\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u0006H¦@¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001A\u00020\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001A\u00020\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2={"Landroidx/compose/material3/WideNavigationRailState;", "", "isAnimating", "", "()Z", "targetValue", "Landroidx/compose/material3/WideNavigationRailValue;", "getTargetValue", "()Landroidx/compose/material3/WideNavigationRailValue;", "currentValue", "getCurrentValue", "expand", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "toggle", "snapTo", "(Landroidx/compose/material3/WideNavigationRailValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface WideNavigationRailState {
    Object collapse(Continuation arg1);

    Object expand(Continuation arg1);

    WideNavigationRailValue getCurrentValue();

    WideNavigationRailValue getTargetValue();

    boolean isAnimating();

    Object snapTo(WideNavigationRailValue arg1, Continuation arg2);

    Object toggle(Continuation arg1);
}

