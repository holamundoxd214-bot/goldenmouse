package androidx.emoji2.viewsintegration;

import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat$InitCallback;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class EmojiTextWatcher implements TextWatcher {
    class InitCallbackImpl extends InitCallback implements Runnable {
        private final Reference mViewRef;

        InitCallbackImpl(EditText arg2) {
            super();
            this.mViewRef = new WeakReference(arg2);
        }

        public void onInitialized() {
            Handler v0_1;
            super.onInitialized();
            Object v0 = this.mViewRef.get();
            if(v0 == null) {
            }
            else {
                v0_1 = ((EditText)v0).getHandler();
                if(v0_1 == null) {
                    return;
                }

                goto label_8;
            }

            return;
        label_8:
            v0_1.post(((Runnable)this));
        }

        public void run() {
            EmojiTextWatcher.processTextOnEnablingEvent(this.mViewRef.get(), 1);
        }
    }

    private final EditText mEditText;
    private int mEmojiReplaceStrategy;
    private boolean mEnabled;
    private final boolean mExpectInitializedEmojiCompat;
    private InitCallback mInitCallback;
    private int mMaxEmojiCount;

    EmojiTextWatcher(EditText arg2, boolean arg3) {
        super();
        this.mMaxEmojiCount = 0x7FFFFFFF;
        this.mEmojiReplaceStrategy = 0;
        this.mEditText = arg2;
        this.mExpectInitializedEmojiCompat = arg3;
        this.mEnabled = true;
    }

    public void afterTextChanged(Editable arg1) {
    }

    public void beforeTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
    }

    int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    InitCallback getInitCallback() {
        if(this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(this.mEditText);
        }

        return this.mInitCallback;
    }

    int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void onTextChanged(CharSequence arg7, int arg8, int arg9, int arg10) {
        if(!this.mEditText.isInEditMode()) {
            if(this.shouldSkipForDisabledOrNotConfigured()) {
            }
            else if(arg9 <= arg10 && ((arg7 instanceof Spannable))) {
                arg9 = EmojiCompat.get().getLoadState();
                if(arg9 != 0) {
                    if(arg9 == 1) {
                        EmojiCompat.get().process(arg7, arg8, arg8 + arg10, this.mMaxEmojiCount, this.mEmojiReplaceStrategy);
                        return;
                    }
                    else if(arg9 != 3) {
                        return;
                    }
                }

                EmojiCompat.get().registerInitCallback(this.getInitCallback());
            }
        }
    }

    static void processTextOnEnablingEvent(EditText arg2, int arg3) {
        if(arg3 == 1 && arg2 != null && (arg2.isAttachedToWindow())) {
            Editable v2 = arg2.getEditableText();
            arg3 = Selection.getSelectionStart(((CharSequence)v2));
            int v0 = Selection.getSelectionEnd(((CharSequence)v2));
            EmojiCompat.get().process(((CharSequence)v2));
            EmojiInputFilter.updateSelection(((Spannable)v2), arg3, v0);
        }
    }

    void setEmojiReplaceStrategy(int arg1) {
        this.mEmojiReplaceStrategy = arg1;
    }

    public void setEnabled(boolean arg3) {
        if(this.mEnabled != arg3) {
            if(this.mInitCallback != null) {
                EmojiCompat.get().unregisterInitCallback(this.mInitCallback);
            }

            this.mEnabled = arg3;
            if(!arg3) {
                return;
            }

            EmojiTextWatcher.processTextOnEnablingEvent(this.mEditText, EmojiCompat.get().getLoadState());
        }
    }

    void setMaxEmojiCount(int arg1) {
        this.mMaxEmojiCount = arg1;
    }

    private boolean shouldSkipForDisabledOrNotConfigured() {
        if((this.mEnabled) && ((this.mExpectInitializedEmojiCompat) || (EmojiCompat.isConfigured()))) {
            return 0;
        }

        return 1;
    }
}

