package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A/\u0010\u0000\u001A\u00020\u00012\u001F\b\u0004\u0010\u0002\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0006H\u0087H¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"whileSelect", "", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class WhileSelectKt {
    public static final Object whileSelect(Function1 arg4, Continuation arg5) {
        Object v4;
        int v2;
        Continuation v0;
        if((arg5 instanceof WhileSelectKt$whileSelect$1)) {
            v0 = arg5;
            v2 = 0x80000000;
            if((((WhileSelectKt$whileSelect$1)v0).label & v2) != 0) {
                ((WhileSelectKt$whileSelect$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            WhileSelectKt$whileSelect$1 v0_1 = new WhileSelectKt$whileSelect$1(arg5);
        }

        Object v5 = ((WhileSelectKt$whileSelect$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((WhileSelectKt$whileSelect$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            goto label_27;
        label_36:
            if(!((Boolean)v5).booleanValue()) {
                return Unit.INSTANCE;
            }
        }
        else if(v2 == 1) {
            v4 = ((WhileSelectKt$whileSelect$1)v0).L$0;
            ResultKt.throwOnFailure(v5);
            goto label_36;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_27:
        SelectImplementation v5_1 = new SelectImplementation(v0.getContext());
        ((Function1)v4).invoke(v5_1);
        ((WhileSelectKt$whileSelect$1)v0).L$0 = v4;
        ((WhileSelectKt$whileSelect$1)v0).label = 1;
        v5 = v5_1.doSelect(v0);
        if(v5 != v1) {
            goto label_36;
        }

        return v1;
    }

    private static final Object whileSelect$$forInline(Function1 arg0, Continuation arg1) {
        null.getContext();
        throw null;
    }
}

