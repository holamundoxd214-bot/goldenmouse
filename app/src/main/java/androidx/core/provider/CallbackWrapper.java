package androidx.core.provider;

import android.graphics.Typeface;
import java.util.concurrent.Executor;

class CallbackWrapper {
    private final FontRequestCallback mCallback;
    private final Executor mExecutor;

    CallbackWrapper(FontRequestCallback arg2) {
        this(arg2, RequestExecutor.createHandlerExecutor(CalleeHandler.create()));
    }

    CallbackWrapper(FontRequestCallback arg1, Executor arg2) {
        super();
        this.mCallback = arg1;
        this.mExecutor = arg2;
    }

    private void onTypefaceRequestFailed(int arg4) {
        this.mExecutor.execute(new Runnable(this.mCallback, arg4) {
            public void run() {
                this.val$callback.onTypefaceRequestFailed(this.val$reason);
            }
        });
    }

    void onTypefaceResult(TypefaceResult arg2) {
        if(arg2.isSuccess()) {
            this.onTypefaceRetrieved(arg2.mTypeface);
            return;
        }

        this.onTypefaceRequestFailed(arg2.mResult);
    }

    private void onTypefaceRetrieved(Typeface arg4) {
        this.mExecutor.execute(new Runnable(this.mCallback, arg4) {
            public void run() {
                this.val$callback.onTypefaceRetrieved(this.val$typeface);
            }
        });
    }
}

