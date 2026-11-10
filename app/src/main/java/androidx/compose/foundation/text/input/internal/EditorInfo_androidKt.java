package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A=\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001A\u0018\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0002¨\u0006\u0013"}, d2={"update", "", "Landroid/view/inputmethod/EditorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "contentMimeTypes", "", "", "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "hasFlag", "", "bits", "", "flag", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class EditorInfo_androidKt {
    private static final boolean hasFlag(int arg0, int arg1) {
        if((arg0 & arg1) == arg1) {
            return 1;
        }

        return 0;
    }

    public static final void update-pLxbY9I(EditorInfo arg7, CharSequence arg8, long arg9, ImeOptions arg11, String[] arg12) {
        int v0 = arg11.getImeAction-eUduSuo();
        int v2 = 3;
        int v3 = 2;
        int v4 = 6;
        if(ImeAction.equals-impl0(v0, ImeAction.Companion.getDefault-eUduSuo())) {
            if(arg11.getSingleLine()) {
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
                goto label_55;
            }

            goto label_206;
        }

    label_55:
        arg7.imeOptions = v4;
        PlatformImeOptions v0_1 = arg11.getPlatformImeOptions();
        if(v0_1 != null) {
            String v0_2 = v0_1.getPrivateImeOptions();
            if(v0_2 != null) {
                arg7.privateImeOptions = v0_2;
            }
        }

        LocaleListHelper.INSTANCE.setHintLocales(arg7, arg11.getHintLocales());
        v0 = arg11.getKeyboardType-PjHm6EE();
        if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getText-PjHm6EE())) {
        label_69:
            v2 = 1;
            goto label_120;
        label_80:
            if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getNumber-PjHm6EE())) {
                v2 = v3;
            }
            else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getPhone-PjHm6EE())) {
            }
            else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getUri-PjHm6EE())) {
                v2 = 17;
            }
            else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getEmail-PjHm6EE())) {
                v2 = 33;
            }
            else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getPassword-PjHm6EE())) {
                v2 = 0x81;
            }
            else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getNumberPassword-PjHm6EE())) {
                v2 = 18;
            }
            else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getDecimal-PjHm6EE())) {
                v2 = 0x2002;
            }
            else {
                goto label_201;
            }
        }
        else if(KeyboardType.equals-impl0(v0, KeyboardType.Companion.getAscii-PjHm6EE())) {
            arg7.imeOptions |= 0x80000000;
            goto label_69;
        }
        else {
            goto label_80;
        }

    label_120:
        arg7.inputType = v2;
        if(!arg11.getSingleLine() && (EditorInfo_androidKt.hasFlag(arg7.inputType, 1))) {
            arg7.inputType |= 0x20000;
            if(ImeAction.equals-impl0(arg11.getImeAction-eUduSuo(), ImeAction.Companion.getDefault-eUduSuo())) {
                arg7.imeOptions |= 0x40000000;
            }
        }

        if(EditorInfo_androidKt.hasFlag(arg7.inputType, 1)) {
            v0 = arg11.getCapitalization-IUNYP9k();
            if(KeyboardCapitalization.equals-impl0(v0, KeyboardCapitalization.Companion.getCharacters-IUNYP9k())) {
                arg7.inputType |= 0x1000;
            }
            else if(KeyboardCapitalization.equals-impl0(v0, KeyboardCapitalization.Companion.getWords-IUNYP9k())) {
                arg7.inputType |= 0x2000;
            }
            else if(KeyboardCapitalization.equals-impl0(v0, KeyboardCapitalization.Companion.getSentences-IUNYP9k())) {
                arg7.inputType |= 0x4000;
            }

            if(!arg11.getAutoCorrect()) {
                goto label_172;
            }

            arg7.inputType |= 0x8000;
        }

    label_172:
        arg7.initialSelStart = TextRange.getStart-impl(arg9);
        arg7.initialSelEnd = TextRange.getEnd-impl(arg9);
        EditorInfoCompat.setInitialSurroundingText(arg7, arg8);
        if(arg12 != null) {
            EditorInfoCompat.setContentMimeTypes(arg7, arg12);
        }

        arg7.imeOptions |= 0x2000000;
        if((StylusHandwriting_androidKt.isStylusHandwritingSupported()) && !KeyboardType.equals-impl0(arg11.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getPassword-PjHm6EE()) && !KeyboardType.equals-impl0(arg11.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getNumberPassword-PjHm6EE())) {
            EditorInfoCompat.setStylusHandwritingEnabled(arg7, true);
            EditorInfoApi34.INSTANCE.setHandwritingGestures(arg7);
            return;
        }

        EditorInfoCompat.setStylusHandwritingEnabled(arg7, false);
        return;
    label_201:
        throw new IllegalStateException("Invalid Keyboard Type".toString());
    label_206:
        throw new IllegalStateException("invalid ImeAction".toString());
    }

    public static void update-pLxbY9I$default(EditorInfo arg6, CharSequence arg7, long arg8, ImeOptions arg10, String[] arg11, int arg12, Object arg13) {
        if((arg12 & 8) != 0) {
            arg11 = null;
        }

        EditorInfo_androidKt.update-pLxbY9I(arg6, arg7, arg8, arg10, arg11);
    }
}

