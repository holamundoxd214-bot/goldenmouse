package androidx.compose.material3.internal;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\'\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0019\b\u0002\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0000\u001A%\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0000¨\u0006\b"}, d2={"childSemantics", "Landroidx/compose/ui/Modifier;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "parentSemantics", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ChildParentSemanticsKt {
    public static final Modifier childSemantics(Modifier arg1, Function1 arg2) {
        return arg1.then(new ChildSemanticsNodeElement(arg2));
    }

    public static Modifier childSemantics$default(Modifier arg0, Function1 arg1, int arg2, Object arg3) {
        ChildParentSemanticsKt$$ExternalSyntheticLambda0 v1;
        if((arg2 & 1) != 0) {
            v1 = new ChildParentSemanticsKt$$ExternalSyntheticLambda0();
        }

        return ChildParentSemanticsKt.childSemantics(arg0, ((Function1)v1));
    }

    static final Unit childSemantics$lambda$0(SemanticsPropertyReceiver arg0) {
        return Unit.INSTANCE;
    }

    public static final Modifier parentSemantics(Modifier arg1, Function1 arg2) {
        return arg1.then(new ParentSemanticsNodeElement(arg2));
    }
}

