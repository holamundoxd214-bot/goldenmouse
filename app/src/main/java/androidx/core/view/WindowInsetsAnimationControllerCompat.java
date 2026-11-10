package androidx.core.view;

import android.view.WindowInsetsAnimationController;
import androidx.core.graphics.Insets;

public final class WindowInsetsAnimationControllerCompat {
    class Impl30 extends Impl {
        private final WindowInsetsAnimationController mController;

        Impl30(WindowInsetsAnimationController arg1) {
            super();
            this.mController = arg1;
        }

        void finish(boolean arg1) {
            this.mController.finish(arg1);
        }

        public float getCurrentAlpha() {
            return this.mController.getCurrentAlpha();
        }

        public float getCurrentFraction() {
            return this.mController.getCurrentFraction();
        }

        public Insets getCurrentInsets() {
            return Insets.toCompatInsets(this.mController.getCurrentInsets());
        }

        public Insets getHiddenStateInsets() {
            return Insets.toCompatInsets(this.mController.getHiddenStateInsets());
        }

        public Insets getShownStateInsets() {
            return Insets.toCompatInsets(this.mController.getShownStateInsets());
        }

        public int getTypes() {
            return this.mController.getTypes();
        }

        boolean isCancelled() {
            return this.mController.isCancelled();
        }

        boolean isFinished() {
            return this.mController.isFinished();
        }

        public void setInsetsAndAlpha(Insets arg1, float arg2, float arg3) {
            WindowInsetsAnimationController v0 = this.mController;
            android.graphics.Insets v1 = arg1 == null ? null : arg1.toPlatformInsets();
            v0.setInsetsAndAlpha(v1, arg2, arg3);
        }
    }

    class Impl {
        Impl() {
            super();
        }

        void finish(boolean arg1) {
        }

        public float getCurrentAlpha() {
            return 0;
        }

        public float getCurrentFraction() {
            return 0;
        }

        public Insets getCurrentInsets() {
            return Insets.NONE;
        }

        public Insets getHiddenStateInsets() {
            return Insets.NONE;
        }

        public Insets getShownStateInsets() {
            return Insets.NONE;
        }

        public int getTypes() {
            return 0;
        }

        boolean isCancelled() {
            return 1;
        }

        boolean isFinished() {
            return 0;
        }

        public void setInsetsAndAlpha(Insets arg1, float arg2, float arg3) {
        }
    }

    private final Impl mImpl;

    WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController arg2) {
        super();
        this.mImpl = new Impl30(arg2);
    }

    public void finish(boolean arg1) {
        this.mImpl.finish(arg1);
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    public Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    public Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    public Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isReady() {
        if(!this.isFinished() && !this.isCancelled()) {
            return 1;
        }

        return 0;
    }

    public void setInsetsAndAlpha(Insets arg1, float arg2, float arg3) {
        this.mImpl.setInsetsAndAlpha(arg1, arg2, arg3);
    }
}

