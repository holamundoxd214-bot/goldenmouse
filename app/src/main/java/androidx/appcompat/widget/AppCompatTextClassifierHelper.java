package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper {
    final class Api26Impl {
        private Api26Impl() {
            super();
        }

        static TextClassifier getTextClassifier(TextView arg1) {
            Object v1 = arg1.getContext().getSystemService(TextClassificationManager.class);
            if(v1 != null) {
                return ((TextClassificationManager)v1).getTextClassifier();
            }

            return TextClassifier.NO_OP;
        }
    }

    private TextClassifier mTextClassifier;
    private TextView mTextView;

    AppCompatTextClassifierHelper(TextView arg1) {
        super();
        this.mTextView = Preconditions.checkNotNull(arg1);
    }

    public TextClassifier getTextClassifier() {
        TextClassifier v0 = this.mTextClassifier;
        if(v0 == null) {
            return Api26Impl.getTextClassifier(this.mTextView);
        }

        return v0;
    }

    public void setTextClassifier(TextClassifier arg1) {
        this.mTextClassifier = arg1;
    }
}

