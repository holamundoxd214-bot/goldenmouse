package androidx.compose.ui.input;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u000E\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0011\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\n\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00038V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0014"}, d2={"Landroidx/compose/ui/input/InputModeManagerImpl;", "Landroidx/compose/ui/input/InputModeManager;", "initialInputMode", "Landroidx/compose/ui/input/InputMode;", "onRequestInputModeChange", "Lkotlin/Function1;", "", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "inputMode", "getInputMode-aOaMEAU", "()I", "setInputMode-iuPiT84", "(I)V", "inputMode$delegate", "Landroidx/compose/runtime/MutableState;", "requestInputMode", "requestInputMode-iuPiT84", "(I)Z", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InputModeManagerImpl implements InputModeManager {
    public static final int $stable;
    private final MutableState inputMode$delegate;
    private final Function1 onRequestInputModeChange;

    static {
    }

    private InputModeManagerImpl(int arg2, Function1 arg3) {
        super();
        this.onRequestInputModeChange = arg3;
        this.inputMode$delegate = SnapshotStateKt.mutableStateOf$default(InputMode.box-impl(arg2), null, 2, null);
    }

    public InputModeManagerImpl(int arg1, Function1 arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public int getInputMode-aOaMEAU() {
        return this.inputMode$delegate.getValue().unbox-impl();
    }

    public boolean requestInputMode-iuPiT84(int arg1) {
        return this.onRequestInputModeChange.invoke(InputMode.box-impl(arg1)).booleanValue();
    }

    public void setInputMode-iuPiT84(int arg1) {
        this.inputMode$delegate.setValue(InputMode.box-impl(arg1));
    }
}

