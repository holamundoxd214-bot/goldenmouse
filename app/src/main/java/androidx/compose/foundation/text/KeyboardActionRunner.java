package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0014\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\u00020\rX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/text/KeyboardActionRunner;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "<init>", "(Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "setKeyboardActions", "(Landroidx/compose/foundation/text/KeyboardActions;)V", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "setFocusManager", "(Landroidx/compose/ui/focus/FocusManager;)V", "runAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "runAction-KlQnJC8", "(I)Z", "defaultKeyboardActionWithResult", "defaultKeyboardActionWithResult-KlQnJC8", "defaultKeyboardAction", "", "defaultKeyboardAction-KlQnJC8", "(I)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class KeyboardActionRunner implements KeyboardActionScope {
    public static final int $stable = 8;
    public FocusManager focusManager;
    public KeyboardActions keyboardActions;
    private final SoftwareKeyboardController keyboardController;

    static {
    }

    public KeyboardActionRunner(SoftwareKeyboardController arg1) {
        super();
        this.keyboardController = arg1;
    }

    public void defaultKeyboardAction-KlQnJC8(int arg1) {
        this.defaultKeyboardActionWithResult-KlQnJC8(arg1);
    }

    private final boolean defaultKeyboardActionWithResult-KlQnJC8(int arg3) {
        if(ImeAction.equals-impl0(arg3, ImeAction.Companion.getNext-eUduSuo())) {
            this.getFocusManager().moveFocus-3ESFkO8(FocusDirection.Companion.getNext-dhqQ-8s());
            return 1;
        }

        if(ImeAction.equals-impl0(arg3, ImeAction.Companion.getPrevious-eUduSuo())) {
            this.getFocusManager().moveFocus-3ESFkO8(FocusDirection.Companion.getPrevious-dhqQ-8s());
            return 1;
        }

        if(ImeAction.equals-impl0(arg3, ImeAction.Companion.getDone-eUduSuo())) {
            SoftwareKeyboardController v2 = this.keyboardController;
            if(v2 != null) {
                v2.hide();
                return 1;
            }
        }

        return 0;
    }

    public final FocusManager getFocusManager() {
        FocusManager v0 = this.focusManager;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions v0 = this.keyboardActions;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    public final boolean runAction-KlQnJC8(int arg2) {
        Function1 v0;
        if(ImeAction.equals-impl0(arg2, ImeAction.Companion.getDone-eUduSuo())) {
            v0 = this.getKeyboardActions().getOnDone();
        }
        else if(ImeAction.equals-impl0(arg2, ImeAction.Companion.getGo-eUduSuo())) {
            v0 = this.getKeyboardActions().getOnGo();
        }
        else if(ImeAction.equals-impl0(arg2, ImeAction.Companion.getNext-eUduSuo())) {
            v0 = this.getKeyboardActions().getOnNext();
        }
        else if(ImeAction.equals-impl0(arg2, ImeAction.Companion.getPrevious-eUduSuo())) {
            v0 = this.getKeyboardActions().getOnPrevious();
        }
        else if(ImeAction.equals-impl0(arg2, ImeAction.Companion.getSearch-eUduSuo())) {
            v0 = this.getKeyboardActions().getOnSearch();
        }
        else if(ImeAction.equals-impl0(arg2, ImeAction.Companion.getSend-eUduSuo())) {
            v0 = this.getKeyboardActions().getOnSend();
        }
        else {
            if(!ImeAction.equals-impl0(arg2, ImeAction.Companion.getDefault-eUduSuo())) {
                if(ImeAction.equals-impl0(arg2, ImeAction.Companion.getNone-eUduSuo())) {
                }
                else {
                    throw new IllegalStateException("invalid ImeAction".toString());
                }
            }

            v0 = null;
        }

        if(v0 != null) {
            v0.invoke(this);
            return 1;
        }

        return this.defaultKeyboardActionWithResult-KlQnJC8(arg2);
    }

    public final void setFocusManager(FocusManager arg1) {
        this.focusManager = arg1;
    }

    public final void setKeyboardActions(KeyboardActions arg1) {
        this.keyboardActions = arg1;
    }
}

