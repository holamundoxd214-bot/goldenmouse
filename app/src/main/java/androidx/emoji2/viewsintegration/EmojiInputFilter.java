package androidx.emoji2.viewsintegration;

import android.os.Handler;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat$InitCallback;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class EmojiInputFilter implements InputFilter {
    class InitCallbackImpl extends InitCallback implements Runnable {
        private final Reference mEmojiInputFilterReference;
        private final Reference mViewRef;

        InitCallbackImpl(TextView arg2, EmojiInputFilter arg3) {
            super();
            this.mViewRef = new WeakReference(arg2);
            this.mEmojiInputFilterReference = new WeakReference(arg3);
        }

        private boolean isInputFilterCurrentlyRegisteredOnTextView(TextView arg3, InputFilter arg4) {
            if(arg4 != null) {
                if(arg3 == null) {
                }
                else {
                    InputFilter[] v3 = arg3.getFilters();
                    if(v3 == null) {
                        return 0;
                    }
                    else {
                        int v0 = 0;
                        while(v0 < v3.length) {
                            if(v3[v0] == arg4) {
                                return 1;
                            }
                            else {
                                ++v0;
                                continue;
                            }

                            return 0;
                        }
                    }
                }
            }

            return 0;
        }

        public void onInitialized() {
            super.onInitialized();
            Object v0 = this.mViewRef.get();
            if(v0 == null) {
            }
            else {
                Handler v0_1 = ((TextView)v0).getHandler();
                if(v0_1 != null) {
                    v0_1.post(((Runnable)this));
                }
            }
        }

        public void run() {
            Object v0 = this.mViewRef.get();
            if(!this.isInputFilterCurrentlyRegisteredOnTextView(((TextView)v0), this.mEmojiInputFilterReference.get())) {
            }
            else if(((TextView)v0).isAttachedToWindow()) {
                CharSequence v3 = ((TextView)v0).getText();
                CharSequence v1 = EmojiCompat.get().process(v3);
                if(v3 == v1) {
                }
                else {
                    int v3_1 = Selection.getSelectionStart(v1);
                    int v2 = Selection.getSelectionEnd(v1);
                    ((TextView)v0).setText(v1);
                    if((v1 instanceof Spannable)) {
                        EmojiInputFilter.updateSelection(((Spannable)v1), v3_1, v2);
                    }
                }
            }
        }
    }

    private InitCallback mInitCallback;
    private final TextView mTextView;

    EmojiInputFilter(TextView arg1) {
        super();
        this.mTextView = arg1;
    }

    public CharSequence filter(CharSequence arg3, int arg4, int arg5, Spanned arg6, int arg7, int arg8) {
        if(this.mTextView.isInEditMode()) {
        }
        else {
            int v0 = EmojiCompat.get().getLoadState();
            if(v0 != 0) {
                if(v0 == 1) {
                    if(arg8 == 0 && arg7 == 0 && arg6.length() == 0 && arg3 == this.mTextView.getText()) {
                        return arg3;
                    }

                    if(arg3 == null) {
                        return arg3;
                    }

                    if(arg4 != 0 || arg5 != arg3.length()) {
                        arg3 = arg3.subSequence(arg4, arg5);
                    }
                    else {
                    }

                    return EmojiCompat.get().process(arg3, 0, arg3.length());
                }
                else if(v0 != 3) {
                    return arg3;
                }
            }

            goto label_32;
        }

        return arg3;
    label_32:
        EmojiCompat.get().registerInitCallback(this.getInitCallback());
        return arg3;
    }

    InitCallback getInitCallback() {
        if(this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(this.mTextView, this);
        }

        return this.mInitCallback;
    }

    static void updateSelection(Spannable arg0, int arg1, int arg2) {
        if(arg1 >= 0 && arg2 >= 0) {
            Selection.setSelection(arg0, arg1, arg2);
            return;
        }

        if(arg1 >= 0) {
            Selection.setSelection(arg0, arg1);
            return;
        }

        if(arg2 >= 0) {
            Selection.setSelection(arg0, arg2);
        }
    }
}

