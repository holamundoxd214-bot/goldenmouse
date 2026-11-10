package androidx.compose.ui.platform;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.WeakReference;
import androidx.compose.ui.text.input.NullableInputConnectionWrapper;
import androidx.compose.ui.text.input.NullableInputConnectionWrapper_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001A\u00020\u0015J\u0006\u0010\u0016\u001A\u00020\u0006R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001A\u00020\u000F8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2={"Landroidx/compose/ui/platform/InputMethodSession;", "", "request", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "onAllConnectionsClosed", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Lkotlin/jvm/functions/Function0;)V", "lock", "connections", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/WeakReference;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "disposed", "", "isActive", "()Z", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "dispose", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class InputMethodSession {
    private MutableVector connections;
    private boolean disposed;
    private final Object lock;
    private final Function0 onAllConnectionsClosed;
    private final PlatformTextInputMethodRequest request;

    public InputMethodSession(PlatformTextInputMethodRequest arg2, Function0 arg3) {
        super();
        this.request = arg2;
        this.onAllConnectionsClosed = arg3;
        this.lock = new Object();
        this.connections = new MutableVector(new WeakReference[16], 0);
    }

    public static final MutableVector access$getConnections$p(InputMethodSession arg0) {
        return arg0.connections;
    }

    public static final Function0 access$getOnAllConnectionsClosed$p(InputMethodSession arg0) {
        return arg0.onAllConnectionsClosed;
    }

    public final InputConnection createInputConnection(EditorInfo arg3) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(!this.disposed) {
                goto label_7;
            }
        }
        catch(Throwable v2) {
            goto label_19;
        }

        __monitor_exit(v0);
        return null;
        try {
        label_7:
            NullableInputConnectionWrapper v3 = NullableInputConnectionWrapper_androidKt.NullableInputConnectionWrapper(this.request.createInputConnection(arg3), new InputMethodSession$createInputConnection$1$1(this));
            this.connections.add(new WeakReference(v3));
            __monitor_exit(v0);
            return ((InputConnection)v3);
        }
        catch(Throwable v2) {
        label_19:
            __monitor_exit(v0);
            throw v2;
        }
    }

    public final void dispose() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.disposed = true;
            MutableVector v1 = this.connections;
            Object[] v2 = v1.content;
            int v1_1 = v1.getSize();
            int v3;
            for(v3 = 0; v3 < v1_1; ++v3) {
                Object v4 = v2[v3].get();
                if(v4 != null) {
                    ((NullableInputConnectionWrapper)v4).disposeDelegate();
                }
            }

            this.connections.clear();
        }
        catch(Throwable v5) {
            goto label_21;
        }

        __monitor_exit(v0);
        return;
    label_21:
        __monitor_exit(v0);
        throw v5;
    }

    public final boolean isActive() {
        return this.disposed ^ 1;
    }
}

