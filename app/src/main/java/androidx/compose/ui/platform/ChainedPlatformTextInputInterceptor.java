package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.node.Owner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\b\u001A\u00020\u0003J?\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\'\u0010\u0015\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016¢\u0006\u0002\b\u0019H\u0086@¢\u0006\u0002\u0010\u001AR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\u001B"}, d2={"Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;", "", "initialInterceptor", "Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "parent", "<init>", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;)V", "<set-?>", "interceptor", "getInterceptor", "()Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "setInterceptor", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;)V", "interceptor$delegate", "Landroidx/compose/runtime/MutableState;", "updateInterceptor", "", "textInputSession", "", "owner", "Landroidx/compose/ui/node/Owner;", "session", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/node/Owner;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class ChainedPlatformTextInputInterceptor {
    private final MutableState interceptor$delegate;
    private final ChainedPlatformTextInputInterceptor parent;

    public ChainedPlatformTextInputInterceptor(PlatformTextInputInterceptor arg2, ChainedPlatformTextInputInterceptor arg3) {
        super();
        this.parent = arg3;
        this.interceptor$delegate = SnapshotStateKt.mutableStateOf$default(arg2, null, 2, null);
    }

    public static final PlatformTextInputInterceptor access$getInterceptor(ChainedPlatformTextInputInterceptor arg0) {
        return arg0.getInterceptor();
    }

    private final PlatformTextInputInterceptor getInterceptor() {
        return this.interceptor$delegate.getValue();
    }

    private final void setInterceptor(PlatformTextInputInterceptor arg1) {
        this.interceptor$delegate.setValue(arg1);
    }

    public final Object textInputSession(Owner arg6, Function2 arg7, Continuation arg8) {
        ChainedPlatformTextInputInterceptor$textInputSession$1 v0_1;
        int v2;
        if((arg8 instanceof ChainedPlatformTextInputInterceptor$textInputSession$1)) {
            Continuation v0 = arg8;
            v2 = 0x80000000;
            if((((ChainedPlatformTextInputInterceptor$textInputSession$1)v0).label & v2) != 0) {
                ((ChainedPlatformTextInputInterceptor$textInputSession$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChainedPlatformTextInputInterceptor$textInputSession$1(this, arg8);
        }

        Object v8 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            ChainedPlatformTextInputInterceptor v8_1 = this.parent;
            ChainedPlatformTextInputInterceptor$textInputSession$2 v2_1 = new ChainedPlatformTextInputInterceptor$textInputSession$2(arg7, this, null);
            v0_1.label = 1;
            if(PlatformTextInputModifierNodeKt.access$interceptedTextInputSession(arg6, v8_1, ((Function2)v2_1), ((Continuation)v0_1)) == v1) {
                return v1;
            }
        }
        else if(v2 != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            ResultKt.throwOnFailure(v8);
        }

        throw new KotlinNothingValueException();
    }

    public final void updateInterceptor(PlatformTextInputInterceptor arg1) {
        this.setInterceptor(arg1);
    }
}

