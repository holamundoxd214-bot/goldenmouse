package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$dimen;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    @Retention(value=RetentionPolicy.SOURCE) @public interface GravityFlag {
    }

    private static final int DEFAULT_DISTANCE = -1;
    private int slideDistance;
    private int slideEdge;

    public SlideDistanceProvider(int arg2) {
        super();
        this.slideDistance = -1;
        this.slideEdge = arg2;
    }

    public Animator createAppear(ViewGroup arg3, View arg4) {
        return SlideDistanceProvider.createTranslationAppearAnimator(((View)arg3), arg4, this.slideEdge, this.getSlideDistanceOrDefault(arg4.getContext()));
    }

    public Animator createDisappear(ViewGroup arg3, View arg4) {
        return SlideDistanceProvider.createTranslationDisappearAnimator(((View)arg3), arg4, this.slideEdge, this.getSlideDistanceOrDefault(arg4.getContext()));
    }

    private static Animator createTranslationAppearAnimator(View arg3, View arg4, int arg5, int arg6) {
        float v3;
        float v0 = arg4.getTranslationX();
        float v1 = arg4.getTranslationY();
        if(arg5 != 3) {
            if(arg5 != 5) {
                if(arg5 != 0x30) {
                    if(arg5 != 80) {
                        if(arg5 != 0x800003) {
                            if(arg5 == 0x800005) {
                                v3 = SlideDistanceProvider.isRtl(arg3) ? v0 - (((float)arg6)) : (((float)arg6)) + v0;
                                return SlideDistanceProvider.createTranslationXAnimator(arg4, v3, v0, v0);
                            }

                            throw new IllegalArgumentException("Invalid slide direction: " + arg5);
                        }

                        v3 = SlideDistanceProvider.isRtl(arg3) ? (((float)arg6)) + v0 : v0 - (((float)arg6));
                        return SlideDistanceProvider.createTranslationXAnimator(arg4, v3, v0, v0);
                    }

                    return SlideDistanceProvider.createTranslationYAnimator(arg4, (((float)arg6)) + v1, v1, v1);
                }

                return SlideDistanceProvider.createTranslationYAnimator(arg4, v1 - (((float)arg6)), v1, v1);
            }

            return SlideDistanceProvider.createTranslationXAnimator(arg4, v0 - (((float)arg6)), v0, v0);
        }

        return SlideDistanceProvider.createTranslationXAnimator(arg4, (((float)arg6)) + v0, v0, v0);
    }

    private static Animator createTranslationDisappearAnimator(View arg3, View arg4, int arg5, int arg6) {
        float v3;
        float v0 = arg4.getTranslationX();
        float v1 = arg4.getTranslationY();
        if(arg5 != 3) {
            if(arg5 != 5) {
                if(arg5 != 0x30) {
                    if(arg5 != 80) {
                        if(arg5 != 0x800003) {
                            if(arg5 == 0x800005) {
                                v3 = SlideDistanceProvider.isRtl(arg3) ? (((float)arg6)) + v0 : v0 - (((float)arg6));
                                return SlideDistanceProvider.createTranslationXAnimator(arg4, v0, v3, v0);
                            }

                            throw new IllegalArgumentException("Invalid slide direction: " + arg5);
                        }

                        v3 = SlideDistanceProvider.isRtl(arg3) ? v0 - (((float)arg6)) : (((float)arg6)) + v0;
                        return SlideDistanceProvider.createTranslationXAnimator(arg4, v0, v3, v0);
                    }

                    return SlideDistanceProvider.createTranslationYAnimator(arg4, v1, v1 - (((float)arg6)), v1);
                }

                return SlideDistanceProvider.createTranslationYAnimator(arg4, v1, (((float)arg6)) + v1, v1);
            }

            return SlideDistanceProvider.createTranslationXAnimator(arg4, v0, (((float)arg6)) + v0, v0);
        }

        return SlideDistanceProvider.createTranslationXAnimator(arg4, v0, v0 - (((float)arg6)), v0);
    }

    private static Animator createTranslationXAnimator(View arg5, float arg6, float arg7, float arg8) {
        ObjectAnimator v6 = ObjectAnimator.ofPropertyValuesHolder(arg5, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{arg6, arg7})});
        v6.addListener(new AnimatorListenerAdapter(arg5, arg8) {
            public void onAnimationEnd(Animator arg1) {
                this.val$view.setTranslationX(this.val$originalTranslation);
            }
        });
        return ((Animator)v6);
    }

    private static Animator createTranslationYAnimator(View arg5, float arg6, float arg7, float arg8) {
        ObjectAnimator v6 = ObjectAnimator.ofPropertyValuesHolder(arg5, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{arg6, arg7})});
        v6.addListener(new AnimatorListenerAdapter(arg5, arg8) {
            public void onAnimationEnd(Animator arg1) {
                this.val$view.setTranslationY(this.val$originalTranslation);
            }
        });
        return ((Animator)v6);
    }

    public int getSlideDistance() {
        return this.slideDistance;
    }

    private int getSlideDistanceOrDefault(Context arg2) {
        int v1 = this.slideDistance;
        if(v1 != -1) {
            return v1;
        }

        return arg2.getResources().getDimensionPixelSize(dimen.mtrl_transition_shared_axis_slide_distance);
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    private static boolean isRtl(View arg1) {
        if(ViewCompat.getLayoutDirection(arg1) == 1) {
            return 1;
        }

        return 0;
    }

    public void setSlideDistance(int arg1) {
        if(arg1 >= 0) {
            this.slideDistance = arg1;
            return;
        }

        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int arg1) {
        this.slideEdge = arg1;
    }
}

