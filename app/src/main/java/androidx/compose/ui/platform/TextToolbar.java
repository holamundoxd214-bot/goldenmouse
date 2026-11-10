package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Jj\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H\u0016JX\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&J\b\u0010\f\u001A\u00020\u0003H&R\u0012\u0010\r\u001A\u00020\u000EX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0003"}, d2={"Landroidx/compose/ui/platform/TextToolbar;", "", "showMenu", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "onAutofillRequested", "hide", "status", "Landroidx/compose/ui/platform/TextToolbarStatus;", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TextToolbar {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static void showMenu(TextToolbar arg0, Rect arg1, Function0 arg2, Function0 arg3, Function0 arg4, Function0 arg5, Function0 arg6) {
            arg0.showMenu(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public static void showMenu$default(TextToolbar arg0, Rect arg1, Function0 arg2, Function0 arg3, Function0 arg4, Function0 arg5, int arg6, Object arg7) {
            TextToolbar.showMenu$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public static void showMenu$default(TextToolbar arg0, Rect arg1, Function0 arg2, Function0 arg3, Function0 arg4, Function0 arg5, Function0 arg6, int arg7, Object arg8) {
            TextToolbar.showMenu$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        }
    }

    static void access$showMenu$jd(TextToolbar arg0, Rect arg1, Function0 arg2, Function0 arg3, Function0 arg4, Function0 arg5, Function0 arg6) {
        super.showMenu(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    TextToolbarStatus getStatus();

    void hide();

    default void showMenu(Rect arg1, Function0 arg2, Function0 arg3, Function0 arg4, Function0 arg5, Function0 arg6) {
        this.showMenu(arg1, arg2, arg3, arg4, arg5);
    }

    void showMenu(Rect arg1, Function0 arg2, Function0 arg3, Function0 arg4, Function0 arg5);

    static void showMenu$default(TextToolbar arg1, Rect arg2, Function0 arg3, Function0 arg4, Function0 arg5, Function0 arg6, Function0 arg7, int arg8, Object arg9) {
        if(arg9 == null) {
            Function0 v0 = null;
            if((arg8 & 2) != 0) {
                arg3 = v0;
            }

            if((arg8 & 4) != 0) {
                arg4 = v0;
            }

            if((arg8 & 8) != 0) {
                arg5 = v0;
            }

            if((arg8 & 16) != 0) {
                arg6 = v0;
            }

            if((arg8 & 0x20) != 0) {
                arg7 = v0;
            }

            arg1.showMenu(arg2, arg3, arg4, arg5, arg6, arg7);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
    }

    static void showMenu$default(TextToolbar arg1, Rect arg2, Function0 arg3, Function0 arg4, Function0 arg5, Function0 arg6, int arg7, Object arg8) {
        if(arg8 == null) {
            Function0 v0 = null;
            if((arg7 & 2) != 0) {
                arg3 = v0;
            }

            if((arg7 & 4) != 0) {
                arg4 = v0;
            }

            if((arg7 & 8) != 0) {
                arg5 = v0;
            }

            if((arg7 & 16) != 0) {
                arg6 = v0;
            }

            arg1.showMenu(arg2, arg3, arg4, arg5, arg6);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
    }
}

