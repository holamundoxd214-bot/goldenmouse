package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A\f\u0010\u0002\u001A\u00020\u0003*\u00020\u0004H\u0002\u001A\u001C\u0010\u0005\u001A\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0000\u001A\f\u0010\n\u001A\u00020\u000B*\u00020\fH\u0000\u001A\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"DEBUG_CLASS", "", "updateWithEmojiCompat", "", "Landroid/view/inputmethod/EditorInfo;", "update", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "hasFlag", "", "bits", "", "flag", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    public static void $r8$lambda$hZGhA0UmhfiIXsIUlX7d0MFuDJQ(Runnable arg0, long arg1) {
        TextInputServiceAndroid_androidKt.asExecutor$lambda$0$0(arg0, arg1);
    }

    public static final void access$updateWithEmojiCompat(EditorInfo arg0) {
        TextInputServiceAndroid_androidKt.updateWithEmojiCompat(arg0);
    }

    public static final Executor asExecutor(Choreographer arg1) {
        return new TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0(arg1);
    }

    static final void asExecutor$lambda$0(Choreographer arg1, Runnable arg2) {
        arg1.postFrameCallback(new TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1(arg2));
    }

    private static final void asExecutor$lambda$0$0(Runnable arg0, long arg1) {
        arg0.run();
    }

    private static final boolean hasFlag(int arg0, int arg1) {
        if((arg0 & arg1) == arg1) {
            return 1;
        }

        return 0;
    }

    public static final void update(EditorInfo arg6, ImeOptions arg7, TextFieldValue arg8) {
        int v0 = arg7.getImeAction-eUduSuo();
        int v2 = 3;
        int v3 = 2;
        int v4 = 6;
        if(ImeAction.equals-impl0(v0, ImeAction.Companion.getDefault-eUduSuo())) {
            if(arg7.getSingleLine()) {
            }
            else {
                v4 = 0;
            }
        }
        else if(ImeAction.equals-impl0(v0, ImeAction.Companion.getNone-eUduSuo())) {
            v4 = 1;
        }
        else if(ImeAction.equals-impl0(v0, ImeAction.Companion.getGo-eUduSuo())) {
            v4 = v3;
        }
        else if(ImeAction.equals-impl0(v0, ImeAction.Companion.getNext-eUduSuo())) {
            v4 = 5;
        }
        else if(ImeAction.equals-impl0(v0, ImeAction.Companion.getPrevious-eUduSuo())) {
            v4 = 7;
        }
        else if(ImeAction.equals-impl0(v0, ImeAction.Companion.getSearch-eUduSuo())) {
            v4 = v2;
        }
        else if(ImeAction.equals-impl0(v0, ImeAction.Companion.getSend-eUduSuo())) {
            v4 = 4;
        }
        else {
            if(ImeAction.equals-impl0(v0, ImeAction.Companion.getDone-eUduSuo())) {
                goto label_54;
            }

            goto label_192;
        }

    label_54:
        arg6.imeOptions = v4;
        PlatformImeOptions v0_1 = arg7.getPlatformImeOptions();
        if(v0_1 != null) {
            String v0_2 = v0_1.getPrivateImeOptions();
            if(v0_2 != null) {
                arg6.privateImeOptions = v0_2;
            }
        }

        v0 = arg7.getKeyboardType-PjHm6EE();
        if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getText-PjHm6EE())) {
            arg6.inputType = 1;
        }
        else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getAscii-PjHm6EE())) {
            arg6.inputType = 1;
            arg6.imeOptions |= 0x80000000;
        }
        else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getNumber-PjHm6EE())) {
            arg6.inputType = v3;
        }
        else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getPhone-PjHm6EE())) {
            arg6.inputType = v2;
        }
        else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getUri-PjHm6EE())) {
            arg6.inputType = 17;
        }
        else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getEmail-PjHm6EE())) {
            arg6.inputType = 33;
        }
        else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getPassword-PjHm6EE())) {
            arg6.inputType = 0x81;
        }
        else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getNumberPassword-PjHm6EE())) {
            arg6.inputType = 18;
        }
        else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getDecimal-PjHm6EE())) {
            arg6.inputType = 0x2002;
        }
        else {
            goto label_187;
        }

        if(!arg7.getSingleLine() && (TextInputServiceAndroid_androidKt.hasFlag(arg6.inputType, 1))) {
            arg6.inputType |= 0x20000;
            if(ImeAction.equals-impl0(arg7.getImeAction-eUduSuo(), ImeAction.Companion.getDefault-eUduSuo())) {
                arg6.imeOptions |= 0x40000000;
            }
        }

        if(TextInputServiceAndroid_androidKt.hasFlag(arg6.inputType, 1)) {
            v0 = arg7.getCapitalization-IUNYP9k();
            if(KeyboardCapitalization.equals-impl0(v0, KeyboardCapitalization.Companion.getCharacters-IUNYP9k())) {
                arg6.inputType |= 0x1000;
            }
            else if(KeyboardCapitalization.equals-impl0(v0, KeyboardCapitalization.Companion.getWords-IUNYP9k())) {
                arg6.inputType |= 0x2000;
            }
            else if(KeyboardCapitalization.equals-impl0(v0, KeyboardCapitalization.Companion.getSentences-IUNYP9k())) {
                arg6.inputType |= 0x4000;
            }

            if(!arg7.getAutoCorrect()) {
                goto label_174;
            }

            arg6.inputType |= 0x8000;
        }

    label_174:
        arg6.initialSelStart = TextRange.getStart-impl(arg8.getSelection-d9O1mEE());
        arg6.initialSelEnd = TextRange.getEnd-impl(arg8.getSelection-d9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(arg6, arg8.getText());
        arg6.imeOptions |= 0x2000000;
        return;
    label_187:
        throw new IllegalStateException("Invalid Keyboard Type".toString());
    label_192:
        throw new IllegalStateException("invalid ImeAction".toString());
    }

    private static final void updateWithEmojiCompat(EditorInfo arg1) {
        if(!EmojiCompat.isConfigured()) {
            return;
        }

        EmojiCompat.get().updateEditorInfo(arg1);
    }
}

