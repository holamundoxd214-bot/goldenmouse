package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2$AnimationCallback;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

public interface Animatable2Compat extends Animatable {
    public abstract class AnimationCallback {
        Animatable2$AnimationCallback mPlatformCallback;

        public AnimationCallback() {
            super();
        }

        Animatable2$AnimationCallback getPlatformCallback() {
            if(this.mPlatformCallback == null) {
                this.mPlatformCallback = new Animatable2$AnimationCallback() {
                    public void onAnimationEnd(Drawable arg1) {
                        AnimationCallback.this.onAnimationEnd(arg1);
                    }

                    public void onAnimationStart(Drawable arg1) {
                        AnimationCallback.this.onAnimationStart(arg1);
                    }
                };
            }

            return this.mPlatformCallback;
        }

        public void onAnimationEnd(Drawable arg1) {
        }

        public void onAnimationStart(Drawable arg1) {
        }
    }

    void clearAnimationCallbacks();

    void registerAnimationCallback(AnimationCallback arg1);

    boolean unregisterAnimationCallback(AnimationCallback arg1);
}

