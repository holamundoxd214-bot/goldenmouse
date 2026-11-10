package androidx.compose.ui.contentcapture;

import android.util.LongSparseArray;

public final class AndroidContentCaptureManager$ViewTranslationHelperMethods$$ExternalSyntheticLambda0 implements Runnable {
    public AndroidContentCaptureManager$ViewTranslationHelperMethods$$ExternalSyntheticLambda0(AndroidContentCaptureManager arg1, LongSparseArray arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        ViewTranslationHelperMethods.onVirtualViewTranslationResponses$lambda$0(this.f$0, this.f$1);
    }
}

