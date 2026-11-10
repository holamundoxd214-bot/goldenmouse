package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.emoji2.text.EmojiCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001A\b\u0010\f\u001A\u00020\rH\u0000\u001A\f\u0010\u000E\u001A\u00020\u000F*\u00020\u0010H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"0\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\u0011"}, d2={"DEBUG_CLASS", "", "inputMethodManagerFactory", "Lkotlin/Function1;", "Landroid/view/View;", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "getInputMethodManagerFactory$annotations", "()V", "getInputMethodManagerFactory", "()Lkotlin/jvm/functions/Function1;", "setInputMethodManagerFactory", "(Lkotlin/jvm/functions/Function1;)V", "createLegacyPlatformTextInputServiceAdapter", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "updateWithEmojiCompat", "", "Landroid/view/inputmethod/EditorInfo;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LegacyPlatformTextInputServiceAdapter_androidKt {
    private static final String DEBUG_CLASS = "AndroidLegacyPlatformTextInputServiceAdapter";
    private static Function1 inputMethodManagerFactory;

    static {
        LegacyPlatformTextInputServiceAdapter_androidKt.inputMethodManagerFactory = LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1.INSTANCE;
    }

    public static final void access$updateWithEmojiCompat(EditorInfo arg0) {
        LegacyPlatformTextInputServiceAdapter_androidKt.updateWithEmojiCompat(arg0);
    }

    public static final LegacyPlatformTextInputServiceAdapter createLegacyPlatformTextInputServiceAdapter() {
        return new AndroidLegacyPlatformTextInputServiceAdapter();
    }

    public static final Function1 getInputMethodManagerFactory() {
        return LegacyPlatformTextInputServiceAdapter_androidKt.inputMethodManagerFactory;
    }

    public static void getInputMethodManagerFactory$annotations() {
    }

    public static final void setInputMethodManagerFactory(Function1 arg0) {
        LegacyPlatformTextInputServiceAdapter_androidKt.inputMethodManagerFactory = arg0;
    }

    private static final void updateWithEmojiCompat(EditorInfo arg1) {
        if(!EmojiCompat.isConfigured()) {
            return;
        }

        EmojiCompat.get().updateEditorInfo(arg1);
    }
}

