package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;

class FragmentAnim {
    class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animation arg2) {
            super();
            this.animation = arg2;
            this.animator = null;
            if(arg2 != null) {
                return;
            }

            throw new IllegalStateException("Animation cannot be null");
        }

        AnimationOrAnimator(Animator arg2) {
            super();
            this.animation = null;
            this.animator = arg2;
            if(arg2 != null) {
                return;
            }

            throw new IllegalStateException("Animator cannot be null");
        }
    }

    class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        EndViewTransitionAnimation(Animation arg2, ViewGroup arg3, View arg4) {
            super(false);
            this.mAnimating = true;
            this.mParent = arg3;
            this.mChild = arg4;
            this.addAnimation(arg2);
            arg3.post(((Runnable)this));
        }

        public boolean getTransformation(long arg3, Transformation arg5) {
            this.mAnimating = true;
            if(this.mEnded) {
                return this.mTransitionEnded ^ 1;
            }

            if(!super.getTransformation(arg3, arg5)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, ((Runnable)this));
            }

            return 1;
        }

        public boolean getTransformation(long arg3, Transformation arg5, float arg6) {
            this.mAnimating = true;
            if(this.mEnded) {
                return this.mTransitionEnded ^ 1;
            }

            if(!super.getTransformation(arg3, arg5, arg6)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, ((Runnable)this));
            }

            return 1;
        }

        public void run() {
            if(!this.mEnded && (this.mAnimating)) {
                this.mAnimating = false;
                this.mParent.post(((Runnable)this));
                return;
            }

            this.mParent.endViewTransition(this.mChild);
            this.mTransitionEnded = true;
        }
    }

    private FragmentAnim() {
        super();
    }

    static void animateRemoveFragment(Fragment arg7, AnimationOrAnimator arg8, Callback arg9) {
        View v2 = arg7.mView;
        ViewGroup v1 = arg7.mContainer;
        v1.startViewTransition(v2);
        CancellationSignal v5 = new CancellationSignal();
        v5.setOnCancelListener(new OnCancelListener(arg7) {
            public void onCancel() {
                View v1 = null;
                if(this.val$fragment.getAnimatingAway() != null) {
                    View v0 = this.val$fragment.getAnimatingAway();
                    this.val$fragment.setAnimatingAway(v1);
                    v0.clearAnimation();
                }

                this.val$fragment.setAnimator(((Animator)v1));
            }
        });
        arg9.onStart(arg7, v5);
        if(arg8.animation != null) {
            EndViewTransitionAnimation v0 = new EndViewTransitionAnimation(arg8.animation, v1, v2);
            arg7.setAnimatingAway(arg7.mView);
            ((Animation)v0).setAnimationListener(new Animation$AnimationListener(v1, arg7, arg9, v5) {
                public void onAnimationEnd(Animation arg2) {
                    this.val$container.post(new Runnable() {
                        public void run() {
                            if(androidx.fragment.app.FragmentAnim$2.this.val$fragment.getAnimatingAway() != null) {
                                androidx.fragment.app.FragmentAnim$2.this.val$fragment.setAnimatingAway(null);
                                androidx.fragment.app.FragmentAnim$2.this.val$callback.onComplete(androidx.fragment.app.FragmentAnim$2.this.val$fragment, androidx.fragment.app.FragmentAnim$2.this.val$signal);
                            }
                        }
                    });
                }

                public void onAnimationRepeat(Animation arg1) {
                }

                public void onAnimationStart(Animation arg1) {
                }
            });
            arg7.mView.startAnimation(((Animation)v0));
            return;
        }

        Animator v6 = arg8.animator;
        arg7.setAnimator(arg8.animator);
        v6.addListener(new AnimatorListenerAdapter(v1, v2, arg7, arg9, v5) {
            public void onAnimationEnd(Animator arg3) {
                this.val$container.endViewTransition(this.val$viewToAnimate);
                arg3 = this.val$fragment.getAnimator();
                this.val$fragment.setAnimator(null);
                if(arg3 != null && this.val$container.indexOfChild(this.val$viewToAnimate) < 0) {
                    this.val$callback.onComplete(this.val$fragment, this.val$signal);
                }
            }
        });
        v6.setTarget(arg7.mView);
        v6.start();
    }

    private static int getNextAnim(Fragment arg0, boolean arg1, boolean arg2) {
        if(arg2) {
            if(arg1) {
                return arg0.getPopEnterAnim();
            }

            return arg0.getPopExitAnim();
        }

        if(arg1) {
            return arg0.getEnterAnim();
        }

        return arg0.getExitAnim();
    }

    static AnimationOrAnimator loadAnimation(Context arg4, Fragment arg5, boolean arg6, boolean arg7) {
        int v0 = arg5.getNextTransition();
        int v7 = FragmentAnim.getNextAnim(arg5, arg6, arg7);
        arg5.setAnimations(0, 0, 0, 0);
        Object v2 = null;
        if(arg5.mContainer != null && arg5.mContainer.getTag(id.visible_removing_fragment_view_tag) != null) {
            arg5.mContainer.setTag(id.visible_removing_fragment_view_tag, v2);
        }

        if(arg5.mContainer != null && arg5.mContainer.getLayoutTransition() != null) {
            return ((AnimationOrAnimator)v2);
        }

        Animation v1 = arg5.onCreateAnimation(v0, arg6, v7);
        if(v1 != null) {
            return new AnimationOrAnimator(v1);
        }

        Animator v5 = arg5.onCreateAnimator(v0, arg6, v7);
        if(v5 != null) {
            return new AnimationOrAnimator(v5);
        }

        if(v7 == 0 && v0 != 0) {
            v7 = FragmentAnim.transitToAnimResourceId(v0, arg6);
        }

        if(v7 != 0) {
            boolean v5_1 = "anim".equals(arg4.getResources().getResourceTypeName(v7));
            if(!v5_1) {
                goto label_46;
            }

            try {
                Animation v6 = AnimationUtils.loadAnimation(arg4, v7);
                if(v6 == null) {
                    goto label_59;
                }

                return new AnimationOrAnimator(v6);
            }
            catch(RuntimeException ) {
                try {
                label_46:
                    Animator v6_2 = AnimatorInflater.loadAnimator(arg4, v7);
                    if(v6_2 == null) {
                        goto label_59;
                    }

                    return new AnimationOrAnimator(v6_2);
                }
                catch(RuntimeException v6_1) {
                    if(!v5_1) {
                        Animation v4_1 = AnimationUtils.loadAnimation(arg4, v7);
                        if(v4_1 == null) {
                            goto label_59;
                        }

                        return new AnimationOrAnimator(v4_1);
                    }

                    throw v6_1;
                }
            }
            catch(Resources$NotFoundException v4) {
                throw v4;
            }
        }

    label_59:
        return ((AnimationOrAnimator)v2);
    }

    private static int transitToAnimResourceId(int arg1, boolean arg2) {
        if(arg1 != 0x1001) {
            if(arg1 != 0x1003) {
                if(arg1 != 0x2002) {
                    return -1;
                }

                if(arg2) {
                    return animator.fragment_close_enter;
                }

                return animator.fragment_close_exit;
            }

            if(arg2) {
                return animator.fragment_fade_enter;
            }

            return animator.fragment_fade_exit;
        }

        if(arg2) {
            return animator.fragment_open_enter;
        }

        return animator.fragment_open_exit;
    }
}

