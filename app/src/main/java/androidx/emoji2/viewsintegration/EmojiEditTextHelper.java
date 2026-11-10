package androidx.emoji2.viewsintegration;

import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.Preconditions;

public final class EmojiEditTextHelper {
    class HelperInternal19 extends HelperInternal {
        private final EditText mEditText;
        private final EmojiTextWatcher mTextWatcher;

        HelperInternal19(EditText arg2, boolean arg3) {
            super();
            this.mEditText = arg2;
            EmojiTextWatcher v0 = new EmojiTextWatcher(arg2, arg3);
            this.mTextWatcher = v0;
            arg2.addTextChangedListener(((TextWatcher)v0));
            arg2.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        KeyListener getKeyListener(KeyListener arg1) {
            if((arg1 instanceof EmojiKeyListener)) {
            }
            else if(arg1 == null) {
                return null;
            }
            else {
                if((arg1 instanceof NumberKeyListener)) {
                    return arg1;
                }

                goto label_9;
            }

            return arg1;
        label_9:
            return new EmojiKeyListener(arg1);
        }

        boolean isEnabled() {
            return this.mTextWatcher.isEnabled();
        }

        InputConnection onCreateInputConnection(InputConnection arg2, EditorInfo arg3) {
            if((arg2 instanceof EmojiInputConnection)) {
                return arg2;
            }

            return new EmojiInputConnection(this.mEditText, arg2, arg3);
        }

        void setEmojiReplaceStrategy(int arg1) {
            this.mTextWatcher.setEmojiReplaceStrategy(arg1);
        }

        void setEnabled(boolean arg1) {
            this.mTextWatcher.setEnabled(arg1);
        }

        void setMaxEmojiCount(int arg1) {
            this.mTextWatcher.setMaxEmojiCount(arg1);
        }
    }

    class HelperInternal {
        HelperInternal() {
            super();
        }

        KeyListener getKeyListener(KeyListener arg1) {
            return arg1;
        }

        boolean isEnabled() {
            return 0;
        }

        InputConnection onCreateInputConnection(InputConnection arg1, EditorInfo arg2) {
            return arg1;
        }

        void setEmojiReplaceStrategy(int arg1) {
        }

        void setEnabled(boolean arg1) {
        }

        void setMaxEmojiCount(int arg1) {
        }
    }

    private int mEmojiReplaceStrategy;
    private final HelperInternal mHelper;
    private int mMaxEmojiCount;

    public EmojiEditTextHelper(EditText arg2, boolean arg3) {
        super();
        this.mMaxEmojiCount = 0x7FFFFFFF;
        this.mEmojiReplaceStrategy = 0;
        Preconditions.checkNotNull(arg2, "editText cannot be null");
        this.mHelper = new HelperInternal19(arg2, arg3);
    }

    public EmojiEditTextHelper(EditText arg2) {
        this(arg2, true);
    }

    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    public KeyListener getKeyListener(KeyListener arg1) {
        return this.mHelper.getKeyListener(arg1);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public InputConnection onCreateInputConnection(InputConnection arg1, EditorInfo arg2) {
        if(arg1 == null) {
            return null;
        }

        return this.mHelper.onCreateInputConnection(arg1, arg2);
    }

    public void setEmojiReplaceStrategy(int arg1) {
        this.mEmojiReplaceStrategy = arg1;
        this.mHelper.setEmojiReplaceStrategy(arg1);
    }

    public void setEnabled(boolean arg1) {
        this.mHelper.setEnabled(arg1);
    }

    public void setMaxEmojiCount(int arg2) {
        Preconditions.checkArgumentNonnegative(arg2, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = arg2;
        this.mHelper.setMaxEmojiCount(arg2);
    }
}

