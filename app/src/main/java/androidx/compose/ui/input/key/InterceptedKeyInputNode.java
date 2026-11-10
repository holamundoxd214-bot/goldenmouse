package androidx.compose.ui.input.key;

import android.view.KeyEvent;
import androidx.compose.ui.Modifier$Node;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0014\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0013R(\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR(\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000B\"\u0004\b\u000F\u0010\r¨\u0006\u0016"}, d2={"Landroidx/compose/ui/input/key/InterceptedKeyInputNode;", "Landroidx/compose/ui/input/key/SoftKeyboardInterceptionModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreEvent", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnEvent", "()Lkotlin/jvm/functions/Function1;", "setOnEvent", "(Lkotlin/jvm/functions/Function1;)V", "getOnPreEvent", "setOnPreEvent", "onInterceptKeyBeforeSoftKeyboard", "event", "onInterceptKeyBeforeSoftKeyboard-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onPreInterceptKeyBeforeSoftKeyboard", "onPreInterceptKeyBeforeSoftKeyboard-ZmokQxo", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class InterceptedKeyInputNode extends Node implements SoftKeyboardInterceptionModifierNode {
    private Function1 onEvent;
    private Function1 onPreEvent;

    public InterceptedKeyInputNode(Function1 arg1, Function1 arg2) {
        super();
        this.onEvent = arg1;
        this.onPreEvent = arg2;
    }

    public final Function1 getOnEvent() {
        return this.onEvent;
    }

    public final Function1 getOnPreEvent() {
        return this.onPreEvent;
    }

    public boolean onInterceptKeyBeforeSoftKeyboard-ZmokQxo(KeyEvent arg1) {
        Function1 v0 = this.onEvent;
        if(v0 != null) {
            return v0.invoke(androidx.compose.ui.input.key.KeyEvent.box-impl(arg1)).booleanValue();
        }

        return 0;
    }

    public boolean onPreInterceptKeyBeforeSoftKeyboard-ZmokQxo(KeyEvent arg1) {
        Function1 v0 = this.onPreEvent;
        if(v0 != null) {
            return v0.invoke(androidx.compose.ui.input.key.KeyEvent.box-impl(arg1)).booleanValue();
        }

        return 0;
    }

    public final void setOnEvent(Function1 arg1) {
        this.onEvent = arg1;
    }

    public final void setOnPreEvent(Function1 arg1) {
        this.onPreEvent = arg1;
    }
}

