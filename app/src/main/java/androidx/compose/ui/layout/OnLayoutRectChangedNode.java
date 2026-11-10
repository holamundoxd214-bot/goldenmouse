package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DelegatableNode$RegistrationHandle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u001B\u001A\u00020\bJ\b\u0010\u001C\u001A\u00020\bH\u0016J\b\u0010\u001D\u001A\u00020\bH\u0016R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\f\"\u0004\b\u0010\u0010\u000ER&\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001C\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001E"}, d2={"Landroidx/compose/ui/layout/OnLayoutRectChangedNode;", "Landroidx/compose/ui/Modifier$Node;", "throttleMillis", "", "debounceMillis", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "<init>", "(JJLkotlin/jvm/functions/Function1;)V", "getThrottleMillis", "()J", "setThrottleMillis", "(J)V", "getDebounceMillis", "setDebounceMillis", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "handle", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "getHandle", "()Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "setHandle", "(Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;)V", "disposeAndRegister", "onAttach", "onDetach", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class OnLayoutRectChangedNode extends Node {
    private Function1 callback;
    private long debounceMillis;
    private RegistrationHandle handle;
    private long throttleMillis;

    public OnLayoutRectChangedNode(long arg1, long arg3, Function1 arg5) {
        super();
        this.throttleMillis = arg1;
        this.debounceMillis = arg3;
        this.callback = arg5;
    }

    public final void disposeAndRegister() {
        RegistrationHandle v0 = this.handle;
        if(v0 != null) {
            v0.unregister();
        }

        this.handle = OnLayoutRectChangedModifierKt.registerOnLayoutRectChanged(this, this.throttleMillis, this.debounceMillis, this.callback);
    }

    public final Function1 getCallback() {
        return this.callback;
    }

    public final long getDebounceMillis() {
        return this.debounceMillis;
    }

    public final RegistrationHandle getHandle() {
        return this.handle;
    }

    public final long getThrottleMillis() {
        return this.throttleMillis;
    }

    public void onAttach() {
        this.disposeAndRegister();
    }

    public void onDetach() {
        RegistrationHandle v0 = this.handle;
        if(v0 != null) {
            v0.unregister();
        }

        this.handle = null;
    }

    public final void setCallback(Function1 arg1) {
        this.callback = arg1;
    }

    public final void setDebounceMillis(long arg1) {
        this.debounceMillis = arg1;
    }

    public final void setHandle(RegistrationHandle arg1) {
        this.handle = arg1;
    }

    public final void setThrottleMillis(long arg1) {
        this.throttleMillis = arg1;
    }
}

