package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

class AppCompatEmojiEditTextHelper {
    private final EmojiEditTextHelper mEmojiEditTextHelper;
    private final EditText mView;

    AppCompatEmojiEditTextHelper(EditText arg3) {
        super();
        this.mView = arg3;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(arg3, false);
    }

    KeyListener getKeyListener(KeyListener arg2) {
        if(this.isEmojiCapableKeyListener(arg2)) {
            return this.mEmojiEditTextHelper.getKeyListener(arg2);
        }

        return arg2;
    }

    boolean isEmojiCapableKeyListener(KeyListener arg1) {
        return arg1 instanceof NumberKeyListener ^ 1;
    }

    boolean isEnabled() {
        return this.mEmojiEditTextHelper.isEnabled();
    }

    void loadFromAttributes(AttributeSet arg4, int arg5) {
        boolean v0;
        TypedArray v4 = this.mView.getContext().obtainStyledAttributes(arg4, styleable.AppCompatTextView, arg5, 0);
        try {
            v0 = true;
            if(v4.hasValue(styleable.AppCompatTextView_emojiCompatEnabled)) {
                v0 = v4.getBoolean(styleable.AppCompatTextView_emojiCompatEnabled, true);
            }
        }
        catch(Throwable v3) {
            v4.recycle();
            throw v3;
        }

        v4.recycle();
        this.setEnabled(v0);
    }

    InputConnection onCreateInputConnection(InputConnection arg1, EditorInfo arg2) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(arg1, arg2);
    }

    void setEnabled(boolean arg1) {
        this.mEmojiEditTextHelper.setEnabled(arg1);
    }
}

