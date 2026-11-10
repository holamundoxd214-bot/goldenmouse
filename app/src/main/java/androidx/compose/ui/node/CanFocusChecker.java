package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001A\u00020\u0005J\u0006\u0010\u000E\u001A\u00020\u000FR\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0006R$\u0010\b\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00058V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\u0010"}, d2={"Landroidx/compose/ui/node/CanFocusChecker;", "Landroidx/compose/ui/focus/FocusProperties;", "<init>", "()V", "canFocusValue", "", "Ljava/lang/Boolean;", "value", "canFocus", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "isCanFocusSet", "reset", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class CanFocusChecker implements FocusProperties {
    public static final CanFocusChecker INSTANCE;
    private static Boolean canFocusValue;

    static {
        CanFocusChecker.INSTANCE = new CanFocusChecker();
    }

    private CanFocusChecker() {
        super();
    }

    public boolean getCanFocus() {
        Boolean v0 = CanFocusChecker.canFocusValue;
        if(v0 != null) {
            return v0.booleanValue();
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("canFocus is read before it is written");
        throw new KotlinNothingValueException();
    }

    public final boolean isCanFocusSet() {
        if(CanFocusChecker.canFocusValue != null) {
            return 1;
        }

        return 0;
    }

    public final void reset() {
        CanFocusChecker.canFocusValue = null;
    }

    public void setCanFocus(boolean arg1) {
        CanFocusChecker.canFocusValue = Boolean.valueOf(arg1);
    }
}

