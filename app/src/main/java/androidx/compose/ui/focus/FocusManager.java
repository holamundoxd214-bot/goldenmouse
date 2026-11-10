package androidx.compose.ui.focus;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H&J\u0017\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bH&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/focus/FocusManager;", "", "clearFocus", "", "force", "", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface FocusManager {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static void clearFocus$default(FocusManager arg0, boolean arg1, int arg2, Object arg3) {
            FocusManager.clearFocus$default(arg0, arg1, arg2, arg3);
        }
    }

    void clearFocus(boolean arg1);

    static void clearFocus$default(FocusManager arg0, boolean arg1, int arg2, Object arg3) {
        if(arg3 == null) {
            arg0.clearFocus(false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearFocus");
    }

    boolean moveFocus-3ESFkO8(int arg1);
}

