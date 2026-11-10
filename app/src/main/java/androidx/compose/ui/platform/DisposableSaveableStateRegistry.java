package androidx.compose.ui.platform;

import androidx.compose.runtime.saveable.SaveableStateRegistry$Entry;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001A\u00020\u0005J\u0011\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0096\u0001J\u0013\u0010\r\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000E\u001A\u00020\u000FH\u0096\u0001J\u001D\u0010\u0010\u001A\u0016\u0012\u0004\u0012\u00020\u000F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00120\u0011H\u0096\u0001J!\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u000E\u001A\u00020\u000F2\u000E\u0010\u0015\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004H\u0096\u0001R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/ui/platform/DisposableSaveableStateRegistry;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "saveableStateRegistry", "onDispose", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;Lkotlin/jvm/functions/Function0;)V", "dispose", "canBeSaved", "", "value", "", "consumeRestored", "key", "", "performSave", "", "", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DisposableSaveableStateRegistry implements SaveableStateRegistry {
    public static final int $stable = 8;
    private final Function0 onDispose;

    static {
    }

    public DisposableSaveableStateRegistry(SaveableStateRegistry arg1, Function0 arg2) {
        super();
        this.$$delegate_0 = arg1;
        this.onDispose = arg2;
    }

    public boolean canBeSaved(Object arg1) {
        return this.$$delegate_0.canBeSaved(arg1);
    }

    public Object consumeRestored(String arg1) {
        return this.$$delegate_0.consumeRestored(arg1);
    }

    public final void dispose() {
        this.onDispose.invoke();
    }

    public Map performSave() {
        return this.$$delegate_0.performSave();
    }

    public Entry registerProvider(String arg1, Function0 arg2) {
        return this.$$delegate_0.registerProvider(arg1, arg2);
    }
}

