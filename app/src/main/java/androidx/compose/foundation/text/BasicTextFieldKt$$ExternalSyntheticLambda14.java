package androidx.compose.foundation.text;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.TextStyle;
import kotlin.jvm.functions.Function2;

public final class BasicTextFieldKt$$ExternalSyntheticLambda14 implements Function2 {
    public BasicTextFieldKt$$ExternalSyntheticLambda14(TextFieldDecorator arg1, TextFieldLineLimits arg2, TextLayoutState arg3, TextStyle arg4, boolean arg5, boolean arg6, TransformedTextFieldState arg7, TextFieldSelectionState arg8, Brush arg9, boolean arg10, boolean arg11, ScrollState arg12, Orientation arg13, ToolbarRequesterImpl arg14, PlatformSelectionBehaviors arg15, boolean arg16, Function2 arg17, KeyboardOptions arg18) {
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
        this.f$10 = arg11;
        this.f$11 = arg12;
        this.f$12 = arg13;
        this.f$13 = arg14;
        this.f$14 = arg15;
        this.f$15 = arg16;
        this.f$16 = arg17;
        this.f$17 = arg18;
    }

    public final Object invoke(Object arg22, Object arg23) {
        return BasicTextFieldKt.$r8$lambda$U8IU3SJiT6XBfKDptRir9AlF148(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, this.f$14, this.f$15, this.f$16, this.f$17, arg22, arg23.intValue());
    }
}

