package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

class EmojiTransformationMethod implements TransformationMethod {
    private final TransformationMethod mTransformationMethod;

    EmojiTransformationMethod(TransformationMethod arg1) {
        super();
        this.mTransformationMethod = arg1;
    }

    public TransformationMethod getOriginalTransformationMethod() {
        return this.mTransformationMethod;
    }

    public CharSequence getTransformation(CharSequence arg2, View arg3) {
        if(arg3.isInEditMode()) {
            return arg2;
        }

        TransformationMethod v1 = this.mTransformationMethod;
        if(v1 != null) {
            arg2 = v1.getTransformation(arg2, arg3);
        }

        if(arg2 != null) {
            if(EmojiCompat.get().getLoadState() != 1) {
            }
            else {
                return EmojiCompat.get().process(arg2);
            }
        }

        return arg2;
    }

    public void onFocusChanged(View arg1, CharSequence arg2, boolean arg3, int arg4, Rect arg5) {
        TransformationMethod v0 = this.mTransformationMethod;
        if(v0 != null) {
            v0.onFocusChanged(arg1, arg2, arg3, arg4, arg5);
        }
    }
}

