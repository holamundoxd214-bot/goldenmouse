package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.GestureDetector$OnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;

@Deprecated public final class GestureDetectorCompat {
    private final GestureDetector mDetector;

    public GestureDetectorCompat(Context arg2, GestureDetector$OnGestureListener arg3) {
        this(arg2, arg3, null);
    }

    public GestureDetectorCompat(Context arg2, GestureDetector$OnGestureListener arg3, Handler arg4) {
        super();
        this.mDetector = new GestureDetector(arg2, arg3, arg4);
    }

    public boolean isLongpressEnabled() {
        return this.mDetector.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent arg1) {
        return this.mDetector.onTouchEvent(arg1);
    }

    public void setIsLongpressEnabled(boolean arg1) {
        this.mDetector.setIsLongpressEnabled(arg1);
    }

    public void setOnDoubleTapListener(GestureDetector$OnDoubleTapListener arg1) {
        this.mDetector.setOnDoubleTapListener(arg1);
    }
}

