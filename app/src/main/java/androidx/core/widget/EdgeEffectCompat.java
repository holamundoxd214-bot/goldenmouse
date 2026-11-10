package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

public final class EdgeEffectCompat {
    class Api31Impl {
        private Api31Impl() {
            super();
        }

        public static EdgeEffect create(Context arg1, AttributeSet arg2) {
            try {
                return new EdgeEffect(arg1, arg2);
            }
            catch(Throwable ) {
                return new EdgeEffect(arg1);
            }
        }

        public static float getDistance(EdgeEffect arg0) {
            try {
                return arg0.getDistance();
            }
            catch(Throwable ) {
                return 0;
            }
        }

        public static float onPullDistance(EdgeEffect arg0, float arg1, float arg2) {
            float v0;
            try {
                v0 = arg0.onPullDistance(arg1, arg2);
                return v0;
            }
            catch(Throwable ) {
                ((EdgeEffect)v0).onPull(arg1, arg2);
                return 0;
            }
        }
    }

    private final EdgeEffect mEdgeEffect;

    @Deprecated public EdgeEffectCompat(Context arg2) {
        super();
        this.mEdgeEffect = new EdgeEffect(arg2);
    }

    public static EdgeEffect create(Context arg2, AttributeSet arg3) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.create(arg2, arg3);
        }

        return new EdgeEffect(arg2);
    }

    @Deprecated public boolean draw(Canvas arg1) {
        return this.mEdgeEffect.draw(arg1);
    }

    @Deprecated public void finish() {
        this.mEdgeEffect.finish();
    }

    public static float getDistance(EdgeEffect arg2) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.getDistance(arg2);
        }

        return 0;
    }

    @Deprecated public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated public boolean onAbsorb(int arg1) {
        this.mEdgeEffect.onAbsorb(arg1);
        return 1;
    }

    public static void onPull(EdgeEffect arg0, float arg1, float arg2) {
        arg0.onPull(arg1, arg2);
    }

    @Deprecated public boolean onPull(float arg1) {
        this.mEdgeEffect.onPull(arg1);
        return 1;
    }

    @Deprecated public boolean onPull(float arg1, float arg2) {
        EdgeEffectCompat.onPull(this.mEdgeEffect, arg1, arg2);
        return 1;
    }

    public static float onPullDistance(EdgeEffect arg2, float arg3, float arg4) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.onPullDistance(arg2, arg3, arg4);
        }

        EdgeEffectCompat.onPull(arg2, arg3, arg4);
        return arg3;
    }

    @Deprecated public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated public void setSize(int arg1, int arg2) {
        this.mEdgeEffect.setSize(arg1, arg2);
    }
}

