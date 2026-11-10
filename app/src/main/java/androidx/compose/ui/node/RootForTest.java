package androidx.compose.ui.node;

import android.view.KeyEvent;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001#J\u0017\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0018H\u0017J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0011H\u0016J\u0010\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001EH\u0016J\b\u0010\u001F\u001A\u00020\u001AH\u0016J\u0012\u0010 \u001A\u00020\u001A2\b\u0010!\u001A\u0004\u0018\u00010\"H\u0016R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000B8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000Fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2={"Landroidx/compose/ui/node/RootForTest;", "", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService$annotations", "()V", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "sendKeyEvent", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendIndirectPointerEvent", "indirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "forceAccessibilityForTesting", "", "enable", "setAccessibilityEventBatchIntervalMillis", "intervalMillis", "", "measureAndLayoutForTest", "setUncaughtExceptionHandler", "handler", "Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "UncaughtExceptionHandler", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface RootForTest {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2={"Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "", "onUncaughtException", "", "t", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface UncaughtExceptionHandler {
        void onUncaughtException(Throwable arg1);
    }

    default void forceAccessibilityForTesting(boolean arg1) {
    }

    Density getDensity();

    SemanticsOwner getSemanticsOwner();

    TextInputService getTextInputService();

    @Deprecated(message="Use PlatformTextInputModifierNode instead.") static void getTextInputService$annotations() {
    }

    default void measureAndLayoutForTest() {
    }

    default boolean sendIndirectPointerEvent(IndirectPointerEvent arg1) {
        return 0;
    }

    boolean sendKeyEvent-ZmokQxo(KeyEvent arg1);

    default void setAccessibilityEventBatchIntervalMillis(long arg1) {
    }

    default void setUncaughtExceptionHandler(UncaughtExceptionHandler arg1) {
    }
}

