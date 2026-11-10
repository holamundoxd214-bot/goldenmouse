package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class TextFieldKeyInput$$ExternalSyntheticLambda0 implements Function1 {
    public TextFieldKeyInput$$ExternalSyntheticLambda0(KeyCommand arg1, TextFieldKeyInput arg2, BooleanRef arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return TextFieldKeyInput.process_ZmokQxo$lambda$1(this.f$0, this.f$1, this.f$2, ((TextFieldPreparedSelection)arg3));
    }
}

