package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.Recomposer;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.android.HandlerDispatcherKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0004\u001A\u00020\u0006H\u0001J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00062\u0006\u0010\u0004\u001A\u00020\u0006H\u0001J\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0004\u001A\u00020\u0006J*\u0010\r\u001A\u0002H\u000E\"\u0004\b\u0000\u0010\u000E2\u0006\u0010\u0004\u001A\u00020\u00062\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u000E0\u0010H\u0086\b¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0000¢\u0006\u0002\b\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/ui/platform/WindowRecomposerPolicy;", "", "<init>", "()V", "factory", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/platform/WindowRecomposerFactory;", "getAndSetFactory", "compareAndSetFactory", "", "expected", "setFactory", "", "withFactory", "R", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/WindowRecomposerFactory;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "createAndInstallWindowRecomposer", "Landroidx/compose/runtime/Recomposer;", "rootView", "Landroid/view/View;", "createAndInstallWindowRecomposer$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowRecomposerPolicy {
    public static final int $stable;
    public static final WindowRecomposerPolicy INSTANCE;
    private static final AtomicReference factory;

    static {
        WindowRecomposerPolicy.INSTANCE = new WindowRecomposerPolicy();
        WindowRecomposerPolicy.factory = new AtomicReference(WindowRecomposerFactory.Companion.getLifecycleAware());
        WindowRecomposerPolicy.$stable = 8;
    }

    private WindowRecomposerPolicy() {
        super();
    }

    public final boolean compareAndSetFactory(WindowRecomposerFactory arg1, WindowRecomposerFactory arg2) {
        return MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(WindowRecomposerPolicy.factory, arg1, arg2);
    }

    public final Recomposer createAndInstallWindowRecomposer$ui(View arg8) {
        Recomposer v7 = WindowRecomposerPolicy.factory.get().createRecomposer(arg8);
        WindowRecomposer_androidKt.setCompositionContext(arg8, v7);
        arg8.addOnAttachStateChangeListener(new WindowRecomposerPolicy$createAndInstallWindowRecomposer$1(BuildersKt.launch$default(GlobalScope.INSTANCE, HandlerDispatcherKt.from(arg8.getHandler(), "windowRecomposer cleanup").getImmediate(), null, new WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(v7, arg8, null), 2, null)));
        return v7;
    }

    public final WindowRecomposerFactory getAndSetFactory(WindowRecomposerFactory arg1) {
        return WindowRecomposerPolicy.factory.getAndSet(arg1);
    }

    public final void setFactory(WindowRecomposerFactory arg1) {
        WindowRecomposerPolicy.factory.set(arg1);
    }

    public final Object withFactory(WindowRecomposerFactory arg4, Function0 arg5) {
        Object v5_1;
        String v0 = "WindowRecomposerFactory was set to unexpected value; cannot safely restore old state";
        WindowRecomposerFactory v1 = this.getAndSetFactory(arg4);
        try {
            v5_1 = arg5.invoke();
        }
        catch(Throwable v5) {
            try {
                throw v5;
            }
            catch(Throwable v2) {
                if(!this.compareAndSetFactory(arg4, v1)) {
                    ExceptionsKt.addSuppressed(v5, new IllegalStateException(v0));
                    throw v5;
                }

                throw v2;
            }
        }

        if(this.compareAndSetFactory(arg4, v1)) {
            return v5_1;
        }

        throw new IllegalStateException(v0);
    }
}

