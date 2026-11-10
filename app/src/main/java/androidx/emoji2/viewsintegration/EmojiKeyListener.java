package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

final class EmojiKeyListener implements KeyListener {
    public class EmojiCompatHandleKeyDownHelper {
        public EmojiCompatHandleKeyDownHelper() {
            super();
        }

        public boolean handleKeyDown(Editable arg1, int arg2, KeyEvent arg3) {
            return EmojiCompat.handleOnKeyDown(arg1, arg2, arg3);
        }
    }

    private final EmojiCompatHandleKeyDownHelper mEmojiCompatHandleKeyDownHelper;
    private final KeyListener mKeyListener;

    EmojiKeyListener(KeyListener arg2) {
        this(arg2, new EmojiCompatHandleKeyDownHelper());
    }

    EmojiKeyListener(KeyListener arg1, EmojiCompatHandleKeyDownHelper arg2) {
        super();
        this.mKeyListener = arg1;
        this.mEmojiCompatHandleKeyDownHelper = arg2;
    }

    public void clearMetaKeyState(View arg1, Editable arg2, int arg3) {
        this.mKeyListener.clearMetaKeyState(arg1, arg2, arg3);
    }

    public int getInputType() {
        return this.mKeyListener.getInputType();
    }

    public boolean onKeyDown(View arg2, Editable arg3, int arg4, KeyEvent arg5) {
        if(!this.mEmojiCompatHandleKeyDownHelper.handleKeyDown(arg3, arg4, arg5)) {
            if(this.mKeyListener.onKeyDown(arg2, arg3, arg4, arg5)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean onKeyOther(View arg1, Editable arg2, KeyEvent arg3) {
        return this.mKeyListener.onKeyOther(arg1, arg2, arg3);
    }

    public boolean onKeyUp(View arg1, Editable arg2, int arg3, KeyEvent arg4) {
        return this.mKeyListener.onKeyUp(arg1, arg2, arg3, arg4);
    }
}

