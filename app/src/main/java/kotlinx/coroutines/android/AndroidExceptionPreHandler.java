package kotlinx.coroutines.android;

import android.os.Build$VERSION;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0002J\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "_preHandler", "", "preHandler", "Ljava/lang/reflect/Method;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-android"}, k=1, mv={2, 1, 0}, xi=0x30) public final class AndroidExceptionPreHandler extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.Key);
        this._preHandler = this;
    }

    public void handleException(CoroutineContext arg2, Throwable arg3) {
        if(Build$VERSION.SDK_INT < 28) {
            Method v1 = this.preHandler();
            Object v2 = null;
            Object v1_1 = v1 != null ? v1.invoke(v2) : v2;
            if((v1_1 instanceof Thread$UncaughtExceptionHandler)) {
                v2 = v1_1;
            }

            if(v2 == null) {
                return;
            }

            ((Thread$UncaughtExceptionHandler)v2).uncaughtException(Thread.currentThread(), arg3);
        }
    }

    private final Method preHandler() {
        Method v1;
        Object v0 = this._preHandler;
        if((((AndroidExceptionPreHandler)v0)) != this) {
            return ((Method)v0);
        }

        v0 = null;
        try {
            v1 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler");
            if((Modifier.isPublic(v1.getModifiers())) && (Modifier.isStatic(v1.getModifiers()))) {
                goto label_15;
            }
        }
        catch(Throwable ) {
        }

        goto label_16;
    label_15:
        Method v0_1 = v1;
    label_16:
        this._preHandler = v0_1;
        return v0_1;
    }
}

