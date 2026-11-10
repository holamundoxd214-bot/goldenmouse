package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
    private final WeakReference mView;

    ViewPropertyAnimatorCompat(View arg2) {
        super();
        this.mView = new WeakReference(arg2);
    }

    public ViewPropertyAnimatorCompat alpha(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().alpha(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().alphaBy(arg2);
        }

        return this;
    }

    public void cancel() {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().cancel();
        }
    }

    public long getDuration() {
        Object v2 = this.mView.get();
        if(v2 != null) {
            return ((View)v2).animate().getDuration();
        }

        return 0;
    }

    public Interpolator getInterpolator() {
        Object v0 = this.mView.get();
        if(v0 != null) {
            return ((View)v0).animate().getInterpolator();
        }

        return null;
    }

    public long getStartDelay() {
        Object v2 = this.mView.get();
        if(v2 != null) {
            return ((View)v2).animate().getStartDelay();
        }

        return 0;
    }

    static void lambda$setUpdateListener$0(ViewPropertyAnimatorUpdateListener arg0, View arg1, ValueAnimator arg2) {
        arg0.onAnimationUpdate(arg1);
    }

    public ViewPropertyAnimatorCompat rotation(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().rotation(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().rotationBy(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().rotationX(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().rotationXBy(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().rotationY(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().rotationYBy(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().scaleX(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().scaleXBy(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().scaleY(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().scaleYBy(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().setDuration(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().setInterpolator(((TimeInterpolator)arg2));
        }

        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            this.setListenerInternal(((View)v0), arg2);
        }

        return this;
    }

    private void setListenerInternal(View arg3, ViewPropertyAnimatorListener arg4) {
        if(arg4 != null) {
            arg3.animate().setListener(new AnimatorListenerAdapter(arg4, arg3) {
                public void onAnimationCancel(Animator arg1) {
                    this.val$listener.onAnimationCancel(this.val$view);
                }

                public void onAnimationEnd(Animator arg1) {
                    this.val$listener.onAnimationEnd(this.val$view);
                }

                public void onAnimationStart(Animator arg1) {
                    this.val$listener.onAnimationStart(this.val$view);
                }
            });
            return;
        }

        arg3.animate().setListener(null);
    }

    public ViewPropertyAnimatorCompat setStartDelay(long arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().setStartDelay(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener arg3) {
        ValueAnimator$AnimatorUpdateListener v1_1;
        Object v0 = this.mView.get();
        if(v0 != null) {
            if(arg3 != null) {
                ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0 v1 = new ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(arg3, ((View)v0));
            }
            else {
                v1_1 = null;
            }

            ((View)v0).animate().setUpdateListener(v1_1);
        }

        return this;
    }

    public void start() {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().start();
        }
    }

    public ViewPropertyAnimatorCompat translationX(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().translationX(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().translationXBy(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().translationY(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().translationYBy(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().translationZ(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().translationZBy(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().withEndAction(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().withLayer();
        }

        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().withStartAction(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat x(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().x(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().xBy(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat y(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().y(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().yBy(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat z(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().z(arg2);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float arg2) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ((View)v0).animate().zBy(arg2);
        }

        return this;
    }
}

