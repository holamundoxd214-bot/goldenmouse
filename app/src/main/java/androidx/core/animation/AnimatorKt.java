package androidx.core.animation;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator$AnimatorPauseListener;
import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001A5\u0010\u0000\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\t\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\n\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\u000B\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001A-\u0010\f\u001A\u00020\r*\u00020\u00022!\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001A-\u0010\u000E\u001A\u00020\r*\u00020\u00022!\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001A¤\u0001\u0010\u000F\u001A\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0010\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u0011\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u0012\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u0013\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001AT\u0010\u0014\u001A\u00020\r*\u00020\u00022#\b\u0002\u0010\u0015\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0002\u0010\u0016\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2={"doOnEnd", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "", "doOnStart", "doOnCancel", "doOnRepeat", "doOnResume", "Landroid/animation/Animator$AnimatorPauseListener;", "doOnPause", "addListener", "onEnd", "onStart", "onCancel", "onRepeat", "addPauseListener", "onResume", "onPause", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class AnimatorKt {
    public static final Animator$AnimatorListener addListener(Animator arg1, Function1 arg2, Function1 arg3, Function1 arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "onEnd");
        Intrinsics.checkNotNullParameter(arg3, "onStart");
        Intrinsics.checkNotNullParameter(arg4, "onCancel");
        Intrinsics.checkNotNullParameter(arg5, "onRepeat");
        AnimatorKt$addListener$listener$1 v0 = new AnimatorKt$addListener$listener$1(arg5, arg2, arg4, arg3);
        arg1.addListener(((Animator$AnimatorListener)v0));
        return ((Animator$AnimatorListener)v0);
    }

    public static Animator$AnimatorListener addListener$default(Animator arg0, Function1 arg1, Function1 arg2, Function1 arg3, Function1 arg4, int arg5, Object arg6) {
        AnimatorKt$addListener$4 v4;
        AnimatorKt$addListener$3 v3;
        AnimatorKt$addListener$2 v2;
        AnimatorKt$addListener$1 v1;
        if((arg5 & 1) != 0) {
            v1 = AnimatorKt$addListener$1.INSTANCE;
        }

        if((arg5 & 2) != 0) {
            v2 = AnimatorKt$addListener$2.INSTANCE;
        }

        if((arg5 & 4) != 0) {
            v3 = AnimatorKt$addListener$3.INSTANCE;
        }

        if((arg5 & 8) != 0) {
            v4 = AnimatorKt$addListener$4.INSTANCE;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(v1, "onEnd");
        Intrinsics.checkNotNullParameter(v2, "onStart");
        Intrinsics.checkNotNullParameter(v3, "onCancel");
        Intrinsics.checkNotNullParameter(v4, "onRepeat");
        AnimatorKt$addListener$listener$1 v5 = new AnimatorKt$addListener$listener$1(((Function1)v4), ((Function1)v1), ((Function1)v3), ((Function1)v2));
        arg0.addListener(((Animator$AnimatorListener)v5));
        return ((Animator$AnimatorListener)v5);
    }

    public static final Animator$AnimatorPauseListener addPauseListener(Animator arg1, Function1 arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "onResume");
        Intrinsics.checkNotNullParameter(arg3, "onPause");
        AnimatorKt$addPauseListener$listener$1 v0 = new AnimatorKt$addPauseListener$listener$1(arg3, arg2);
        arg1.addPauseListener(((Animator$AnimatorPauseListener)v0));
        return ((Animator$AnimatorPauseListener)v0);
    }

    public static Animator$AnimatorPauseListener addPauseListener$default(Animator arg0, Function1 arg1, Function1 arg2, int arg3, Object arg4) {
        AnimatorKt$$ExternalSyntheticLambda1 v2;
        AnimatorKt$$ExternalSyntheticLambda0 v1;
        if((arg3 & 1) != 0) {
            v1 = new AnimatorKt$$ExternalSyntheticLambda0();
        }

        if((arg3 & 2) != 0) {
            v2 = new AnimatorKt$$ExternalSyntheticLambda1();
        }

        return AnimatorKt.addPauseListener(arg0, ((Function1)v1), ((Function1)v2));
    }

    static final Unit addPauseListener$lambda$0(Animator arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    static final Unit addPauseListener$lambda$1(Animator arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    public static final Animator$AnimatorListener doOnCancel(Animator arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        AnimatorKt$doOnCancel$$inlined$addListener$default$1 v0 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(arg2);
        arg1.addListener(((Animator$AnimatorListener)v0));
        return ((Animator$AnimatorListener)v0);
    }

    public static final Animator$AnimatorListener doOnEnd(Animator arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        AnimatorKt$doOnEnd$$inlined$addListener$default$1 v0 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(arg2);
        arg1.addListener(((Animator$AnimatorListener)v0));
        return ((Animator$AnimatorListener)v0);
    }

    public static final Animator$AnimatorPauseListener doOnPause(Animator arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "action");
        return AnimatorKt.addPauseListener$default(arg2, null, arg3, 1, null);
    }

    public static final Animator$AnimatorListener doOnRepeat(Animator arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        AnimatorKt$doOnRepeat$$inlined$addListener$default$1 v0 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(arg2);
        arg1.addListener(((Animator$AnimatorListener)v0));
        return ((Animator$AnimatorListener)v0);
    }

    public static final Animator$AnimatorPauseListener doOnResume(Animator arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "action");
        return AnimatorKt.addPauseListener$default(arg2, arg3, null, 2, null);
    }

    public static final Animator$AnimatorListener doOnStart(Animator arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        AnimatorKt$doOnStart$$inlined$addListener$default$1 v0 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(arg2);
        arg1.addListener(((Animator$AnimatorListener)v0));
        return ((Animator$AnimatorListener)v0);
    }
}

