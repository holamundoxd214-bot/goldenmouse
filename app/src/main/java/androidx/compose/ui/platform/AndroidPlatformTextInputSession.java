package androidx.compose.ui.platform;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.text.input.TextInputService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u001A\u001A\u00020\u001BR\u0014\u0010\u0003\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0012R\u0012\u0010\u001C\u001A\u00020\u001DX\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2={"Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlinx/coroutines/CoroutineScope;", "view", "Landroid/view/View;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "coroutineScope", "<init>", "(Landroid/view/View;Landroidx/compose/ui/text/input/TextInputService;Lkotlinx/coroutines/CoroutineScope;)V", "getView", "()Landroid/view/View;", "methodSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/InputMethodSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "isReadyForConnection", "", "()Z", "startInputMethod", "", "request", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidPlatformTextInputSession implements PlatformTextInputSessionScope, CoroutineScope {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    private final AtomicReference methodSessionMutex;
    private final TextInputService textInputService;
    private final View view;

    static {
    }

    public AndroidPlatformTextInputSession(View arg1, TextInputService arg2, CoroutineScope arg3) {
        super();
        this.view = arg1;
        this.textInputService = arg2;
        this.coroutineScope = arg3;
        this.methodSessionMutex = SessionMutex.constructor-impl();
    }

    public static final CoroutineScope access$getCoroutineScope$p(AndroidPlatformTextInputSession arg0) {
        return arg0.coroutineScope;
    }

    public static final TextInputService access$getTextInputService$p(AndroidPlatformTextInputSession arg0) {
        return arg0.textInputService;
    }

    public final InputConnection createInputConnection(EditorInfo arg1) {
        Object v0 = SessionMutex.getCurrentSession-impl(this.methodSessionMutex);
        if(v0 != null) {
            return ((InputMethodSession)v0).createInputConnection(arg1);
        }

        return null;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineScope.getCoroutineContext();
    }

    public View getView() {
        return this.view;
    }

    public final boolean isReadyForConnection() {
        Object v2 = SessionMutex.getCurrentSession-impl(this.methodSessionMutex);
        if(v2 != null && (((InputMethodSession)v2).isActive())) {
            return 1;
        }

        return 0;
    }

    public Object startInputMethod(PlatformTextInputMethodRequest arg6, Continuation arg7) {
        AndroidPlatformTextInputSession$startInputMethod$1 v0_1;
        int v2;
        if((arg7 instanceof AndroidPlatformTextInputSession$startInputMethod$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((AndroidPlatformTextInputSession$startInputMethod$1)v0).label & v2) != 0) {
                ((AndroidPlatformTextInputSession$startInputMethod$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new AndroidPlatformTextInputSession$startInputMethod$1(this, arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            AtomicReference v7_1 = this.methodSessionMutex;
            AndroidPlatformTextInputSession$startInputMethod$2 v2_1 = new AndroidPlatformTextInputSession$startInputMethod$2(arg6, this);
            AndroidPlatformTextInputSession$startInputMethod$3 v6 = new AndroidPlatformTextInputSession$startInputMethod$3(this, null);
            v0_1.label = 1;
            if(SessionMutex.withSessionCancellingPrevious-impl(v7_1, ((Function1)v2_1), ((Function2)v6), ((Continuation)v0_1)) == v1) {
                return v1;
            }
        }
        else if(v2 != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            ResultKt.throwOnFailure(v7);
        }

        throw new KotlinNothingValueException();
    }
}

