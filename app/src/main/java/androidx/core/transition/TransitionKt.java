package androidx.core.transition;

import android.transition.Transition$TransitionListener;
import android.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000B\u001A5\u0010\u0000\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\t\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\n\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\u000B\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\f\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u001AÉ\u0001\u0010\r\u001A\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u000E\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000F\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u0010\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u0011\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u0012\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2={"doOnEnd", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "doOnStart", "doOnCancel", "doOnResume", "doOnPause", "addListener", "onEnd", "onStart", "onCancel", "onResume", "onPause", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class TransitionKt {
    public static final Transition$TransitionListener addListener(Transition arg7, Function1 arg8, Function1 arg9, Function1 arg10, Function1 arg11, Function1 arg12) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "onEnd");
        Intrinsics.checkNotNullParameter(arg9, "onStart");
        Intrinsics.checkNotNullParameter(arg10, "onCancel");
        Intrinsics.checkNotNullParameter(arg11, "onResume");
        Intrinsics.checkNotNullParameter(arg12, "onPause");
        TransitionKt$addListener$listener$1 v1 = new TransitionKt$addListener$listener$1(arg8, arg11, arg12, arg10, arg9);
        arg7.addListener(((Transition$TransitionListener)v1));
        return ((Transition$TransitionListener)v1);
    }

    public static Transition$TransitionListener addListener$default(Transition arg0, Function1 arg1, Function1 arg2, Function1 arg3, Function1 arg4, Function1 arg5, int arg6, Object arg7) {
        TransitionKt$addListener$5 v5;
        TransitionKt$addListener$4 v4;
        TransitionKt$addListener$3 v3;
        TransitionKt$addListener$2 v2;
        TransitionKt$addListener$1 v1;
        if((arg6 & 1) != 0) {
            v1 = TransitionKt$addListener$1.INSTANCE;
        }

        if((arg6 & 2) != 0) {
            v2 = TransitionKt$addListener$2.INSTANCE;
        }

        Function1 v7 = ((Function1)v2);
        if((arg6 & 4) != 0) {
            v3 = TransitionKt$addListener$3.INSTANCE;
        }

        if((arg6 & 8) != 0) {
            v4 = TransitionKt$addListener$4.INSTANCE;
        }

        if((arg6 & 16) != 0) {
            v5 = TransitionKt$addListener$5.INSTANCE;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(v1, "onEnd");
        Intrinsics.checkNotNullParameter(v7, "onStart");
        Intrinsics.checkNotNullParameter(v3, "onCancel");
        Intrinsics.checkNotNullParameter(v4, "onResume");
        Intrinsics.checkNotNullParameter(v5, "onPause");
        TransitionKt$addListener$listener$1 v2_1 = new TransitionKt$addListener$listener$1(((Function1)v1), ((Function1)v4), ((Function1)v5), ((Function1)v3), v7);
        arg0.addListener(((Transition$TransitionListener)v2_1));
        return ((Transition$TransitionListener)v2_1);
    }

    public static final Transition$TransitionListener doOnCancel(Transition arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        TransitionKt$doOnCancel$$inlined$addListener$default$1 v0 = new TransitionKt$doOnCancel$$inlined$addListener$default$1(arg2);
        arg1.addListener(((Transition$TransitionListener)v0));
        return ((Transition$TransitionListener)v0);
    }

    public static final Transition$TransitionListener doOnEnd(Transition arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        TransitionKt$doOnEnd$$inlined$addListener$default$1 v0 = new TransitionKt$doOnEnd$$inlined$addListener$default$1(arg2);
        arg1.addListener(((Transition$TransitionListener)v0));
        return ((Transition$TransitionListener)v0);
    }

    public static final Transition$TransitionListener doOnPause(Transition arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        TransitionKt$doOnPause$$inlined$addListener$default$1 v0 = new TransitionKt$doOnPause$$inlined$addListener$default$1(arg2);
        arg1.addListener(((Transition$TransitionListener)v0));
        return ((Transition$TransitionListener)v0);
    }

    public static final Transition$TransitionListener doOnResume(Transition arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        TransitionKt$doOnResume$$inlined$addListener$default$1 v0 = new TransitionKt$doOnResume$$inlined$addListener$default$1(arg2);
        arg1.addListener(((Transition$TransitionListener)v0));
        return ((Transition$TransitionListener)v0);
    }

    public static final Transition$TransitionListener doOnStart(Transition arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        TransitionKt$doOnStart$$inlined$addListener$default$1 v0 = new TransitionKt$doOnStart$$inlined$addListener$default$1(arg2);
        arg1.addListener(((Transition$TransitionListener)v0));
        return ((Transition$TransitionListener)v0);
    }
}

