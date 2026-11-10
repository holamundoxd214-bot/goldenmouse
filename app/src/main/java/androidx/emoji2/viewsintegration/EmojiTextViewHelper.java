package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

public final class EmojiTextViewHelper {
    class HelperInternal19 extends HelperInternal {
        private final EmojiInputFilter mEmojiInputFilter;
        private boolean mEnabled;
        private final TextView mTextView;

        HelperInternal19(TextView arg2) {
            super();
            this.mTextView = arg2;
            this.mEnabled = true;
            this.mEmojiInputFilter = new EmojiInputFilter(arg2);
        }

        private InputFilter[] addEmojiInputFilterIfMissing(InputFilter[] arg6) {
            int v0 = arg6.length;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                if(arg6[v2] == this.mEmojiInputFilter) {
                    return arg6;
                }
            }

            InputFilter[] v2_1 = new InputFilter[arg6.length + 1];
            System.arraycopy(arg6, 0, v2_1, 0, v0);
            v2_1[v0] = this.mEmojiInputFilter;
            return v2_1;
        }

        private SparseArray getEmojiInputFilterPositionArray(InputFilter[] arg4) {
            SparseArray v3 = new SparseArray(1);
            int v0;
            for(v0 = 0; v0 < arg4.length; ++v0) {
                InputFilter v1 = arg4[v0];
                if((v1 instanceof EmojiInputFilter)) {
                    v3.put(v0, v1);
                }
            }

            return v3;
        }

        InputFilter[] getFilters(InputFilter[] arg2) {
            if(!this.mEnabled) {
                return this.removeEmojiInputFilterIfPresent(arg2);
            }

            return this.addEmojiInputFilterIfMissing(arg2);
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        private InputFilter[] removeEmojiInputFilterIfPresent(InputFilter[] arg6) {
            SparseArray v5 = this.getEmojiInputFilterPositionArray(arg6);
            if(v5.size() == 0) {
                return arg6;
            }

            int v0 = arg6.length;
            InputFilter[] v1 = new InputFilter[arg6.length - v5.size()];
            int v2 = 0;
            int v3 = 0;
            while(v2 < v0) {
                if(v5.indexOfKey(v2) < 0) {
                    v1[v3] = arg6[v2];
                    ++v3;
                }

                ++v2;
            }

            return v1;
        }

        void setAllCaps(boolean arg1) {
            if(arg1) {
                this.updateTransformationMethod();
            }
        }

        void setEnabled(boolean arg1) {
            this.mEnabled = arg1;
            this.updateTransformationMethod();
            this.updateFilters();
        }

        void setEnabledUnsafe(boolean arg1) {
            this.mEnabled = arg1;
        }

        private TransformationMethod unwrapForDisabled(TransformationMethod arg1) {
            if((arg1 instanceof EmojiTransformationMethod)) {
                return ((EmojiTransformationMethod)arg1).getOriginalTransformationMethod();
            }

            return arg1;
        }

        private void updateFilters() {
            this.mTextView.setFilters(this.getFilters(this.mTextView.getFilters()));
        }

        void updateTransformationMethod() {
            this.mTextView.setTransformationMethod(this.wrapTransformationMethod(this.mTextView.getTransformationMethod()));
        }

        private TransformationMethod wrapForEnabled(TransformationMethod arg1) {
            if((arg1 instanceof EmojiTransformationMethod)) {
            }
            else {
                if((arg1 instanceof PasswordTransformationMethod)) {
                    return arg1;
                }

                goto label_6;
            }

            return arg1;
        label_6:
            return new EmojiTransformationMethod(arg1);
        }

        TransformationMethod wrapTransformationMethod(TransformationMethod arg2) {
            if(this.mEnabled) {
                return this.wrapForEnabled(arg2);
            }

            return this.unwrapForDisabled(arg2);
        }
    }

    class HelperInternal {
        HelperInternal() {
            super();
        }

        InputFilter[] getFilters(InputFilter[] arg1) {
            return arg1;
        }

        public boolean isEnabled() {
            return 0;
        }

        void setAllCaps(boolean arg1) {
        }

        void setEnabled(boolean arg1) {
        }

        void updateTransformationMethod() {
        }

        TransformationMethod wrapTransformationMethod(TransformationMethod arg1) {
            return arg1;
        }
    }

    class SkippingHelper19 extends HelperInternal {
        private final HelperInternal19 mHelperDelegate;

        SkippingHelper19(TextView arg2) {
            super();
            this.mHelperDelegate = new HelperInternal19(arg2);
        }

        InputFilter[] getFilters(InputFilter[] arg2) {
            if(this.skipBecauseEmojiCompatNotInitialized()) {
                return arg2;
            }

            return this.mHelperDelegate.getFilters(arg2);
        }

        public boolean isEnabled() {
            return this.mHelperDelegate.isEnabled();
        }

        void setAllCaps(boolean arg2) {
            if(this.skipBecauseEmojiCompatNotInitialized()) {
                return;
            }

            this.mHelperDelegate.setAllCaps(arg2);
        }

        void setEnabled(boolean arg2) {
            boolean v0 = this.skipBecauseEmojiCompatNotInitialized();
            HelperInternal19 v1 = this.mHelperDelegate;
            if(v0) {
                v1.setEnabledUnsafe(arg2);
                return;
            }

            v1.setEnabled(arg2);
        }

        private boolean skipBecauseEmojiCompatNotInitialized() {
            return EmojiCompat.isConfigured() ^ 1;
        }

        void updateTransformationMethod() {
            if(this.skipBecauseEmojiCompatNotInitialized()) {
                return;
            }

            this.mHelperDelegate.updateTransformationMethod();
        }

        TransformationMethod wrapTransformationMethod(TransformationMethod arg2) {
            if(this.skipBecauseEmojiCompatNotInitialized()) {
                return arg2;
            }

            return this.mHelperDelegate.wrapTransformationMethod(arg2);
        }
    }

    private final HelperInternal mHelper;

    public EmojiTextViewHelper(TextView arg2, boolean arg3) {
        super();
        Preconditions.checkNotNull(arg2, "textView cannot be null");
        if(!arg3) {
            this.mHelper = new SkippingHelper19(arg2);
            return;
        }

        this.mHelper = new HelperInternal19(arg2);
    }

    public EmojiTextViewHelper(TextView arg2) {
        this(arg2, true);
    }

    public InputFilter[] getFilters(InputFilter[] arg1) {
        return this.mHelper.getFilters(arg1);
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public void setAllCaps(boolean arg1) {
        this.mHelper.setAllCaps(arg1);
    }

    public void setEnabled(boolean arg1) {
        this.mHelper.setEnabled(arg1);
    }

    public void updateTransformationMethod() {
        this.mHelper.updateTransformationMethod();
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod arg1) {
        return this.mHelper.wrapTransformationMethod(arg1);
    }
}

