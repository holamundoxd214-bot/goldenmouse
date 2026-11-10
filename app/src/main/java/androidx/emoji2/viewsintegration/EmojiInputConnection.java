package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

final class EmojiInputConnection extends InputConnectionWrapper {
    public class EmojiCompatDeleteHelper {
        public EmojiCompatDeleteHelper() {
            super();
        }

        public boolean handleDeleteSurroundingText(InputConnection arg1, Editable arg2, int arg3, int arg4, boolean arg5) {
            return EmojiCompat.handleDeleteSurroundingText(arg1, arg2, arg3, arg4, arg5);
        }

        public void updateEditorInfoAttrs(EditorInfo arg1) {
            if(EmojiCompat.isConfigured()) {
                EmojiCompat.get().updateEditorInfo(arg1);
            }
        }
    }

    private final EmojiCompatDeleteHelper mEmojiCompatDeleteHelper;
    private final TextView mTextView;

    EmojiInputConnection(TextView arg2, InputConnection arg3, EditorInfo arg4) {
        this(arg2, arg3, arg4, new EmojiCompatDeleteHelper());
    }

    EmojiInputConnection(TextView arg2, InputConnection arg3, EditorInfo arg4, EmojiCompatDeleteHelper arg5) {
        super(arg3, false);
        this.mTextView = arg2;
        this.mEmojiCompatDeleteHelper = arg5;
        arg5.updateEditorInfoAttrs(arg4);
    }

    public boolean deleteSurroundingText(int arg7, int arg8) {
        EmojiInputConnection v1 = this;
        int v3 = arg7;
        int v4 = arg8;
        if(!this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(((InputConnection)v1), this.getEditable(), v3, v4, false)) {
            if(super.deleteSurroundingText(v3, v4)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean deleteSurroundingTextInCodePoints(int arg7, int arg8) {
        EmojiInputConnection v1 = this;
        int v3 = arg7;
        int v4 = arg8;
        if(!this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(((InputConnection)v1), this.getEditable(), v3, v4, true)) {
            if(super.deleteSurroundingTextInCodePoints(v3, v4)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private Editable getEditable() {
        return this.mTextView.getEditableText();
    }
}

