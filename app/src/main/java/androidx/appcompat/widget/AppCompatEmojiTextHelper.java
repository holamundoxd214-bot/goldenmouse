package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

class AppCompatEmojiTextHelper {
    private final EmojiTextViewHelper mEmojiTextViewHelper;
    private final TextView mView;

    AppCompatEmojiTextHelper(TextView arg3) {
        super();
        this.mView = arg3;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(arg3, false);
    }

    InputFilter[] getFilters(InputFilter[] arg1) {
        return this.mEmojiTextViewHelper.getFilters(arg1);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.isEnabled();
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

    void setAllCaps(boolean arg1) {
        this.mEmojiTextViewHelper.setAllCaps(arg1);
    }

    void setEnabled(boolean arg1) {
        this.mEmojiTextViewHelper.setEnabled(arg1);
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod arg1) {
        return this.mEmojiTextViewHelper.wrapTransformationMethod(arg1);
    }
}

