package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.input.ImeOptions;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$$ExternalSyntheticLambda0 implements PlatformTextInputMethodRequest {
    public AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$$ExternalSyntheticLambda0(TransformedTextFieldState arg1, ImeOptions arg2, ReceiveContentConfiguration arg3, ComposeInputMethodManager arg4, Function1 arg5, CursorAnchorInfoController arg6, TextLayoutState arg7, Function0 arg8, ViewConfiguration arg9, Function1 arg10) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
        this.f$8 = arg9;
        this.f$9 = arg10;
    }

    public final InputConnection createInputConnection(EditorInfo arg12) {
        return AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3.invokeSuspend$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, arg12);
    }
}

