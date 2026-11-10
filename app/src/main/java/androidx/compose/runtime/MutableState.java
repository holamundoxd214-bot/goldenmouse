package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u000E\u0010\b\u001A\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u0005J\u0015\u0010\t\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000B0\nH¦\u0002R\u0018\u0010\u0003\u001A\u00028\u0000X¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2={"Landroidx/compose/runtime/MutableState;", "T", "Landroidx/compose/runtime/State;", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "component1", "component2", "Lkotlin/Function1;", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface MutableState extends State {
    Object component1();

    Function1 component2();

    Object getValue();

    void setValue(Object arg1);
}

