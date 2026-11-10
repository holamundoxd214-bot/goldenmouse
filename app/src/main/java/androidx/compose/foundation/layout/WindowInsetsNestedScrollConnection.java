package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u001F\u001A\u00020 H\u0002J\u0010\u0010#\u001A\u0004\u0018\u00010\u0016H\u0082@¢\u0006\u0002\u0010$J\u001F\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020&2\u0006\u0010(\u001A\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\'\u0010,\u001A\u00020&2\u0006\u0010-\u001A\u00020&2\u0006\u0010\'\u001A\u00020&2\u0006\u0010(\u001A\u00020)H\u0016¢\u0006\u0004\b.\u0010/J\u001F\u00100\u001A\u00020&2\u0006\u0010\'\u001A\u00020&2\u0006\u00101\u001A\u00020\u001CH\u0002¢\u0006\u0004\b2\u00103J\u0018\u00104\u001A\u0002052\u0006\u0010\'\u001A\u000205H\u0096@¢\u0006\u0004\b6\u00107J \u00108\u001A\u0002052\u0006\u0010-\u001A\u0002052\u0006\u0010\'\u001A\u000205H\u0096@¢\u0006\u0004\b9\u0010:J(\u0010;\u001A\u0002052\u0006\u0010\'\u001A\u0002052\u0006\u0010<\u001A\u00020\u001C2\u0006\u0010=\u001A\u00020\u0018H\u0082@¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001A\u00020 2\u0006\u0010A\u001A\u00020\u001CH\u0002J\u0018\u0010B\u001A\u00020 2\u0006\u0010C\u001A\u00020\u00162\u0006\u0010D\u001A\u00020EH\u0016J\u0006\u0010F\u001A\u00020 J\u0010\u0010G\u001A\u00020 2\u0006\u0010C\u001A\u00020\u0016H\u0016J\u0012\u0010H\u001A\u00020 2\b\u0010C\u001A\u0004\u0018\u00010\u0016H\u0016J\b\u0010I\u001A\u00020 H\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010!\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\"X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006J"}, d2={"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "getView", "()Landroid/view/View;", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "animationController", "Landroid/view/WindowInsetsAnimationController;", "isControllerRequested", "", "cancellationSignal", "Landroid/os/CancellationSignal;", "partialConsumption", "", "animationJob", "Lkotlinx/coroutines/Job;", "requestAnimationController", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "scroll", "scrollAmount", "scroll-8S9VItk", "(JF)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fling", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adjustInsets", "inset", "onReady", "controller", "types", "", "dispose", "onFinished", "onCancelled", "animationEnded", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class WindowInsetsNestedScrollConnection implements WindowInsetsAnimationControlListener, NestedScrollConnection {
    private WindowInsetsAnimationController animationController;
    private Job animationJob;
    private final CancellationSignal cancellationSignal;
    private CancellableContinuation continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets arg1, View arg2, SideCalculator arg3, Density arg4) {
        super();
        this.windowInsets = arg1;
        this.view = arg2;
        this.sideCalculator = arg3;
        this.density = arg4;
        this.cancellationSignal = new CancellationSignal();
    }

    public static final void access$adjustInsets(WindowInsetsNestedScrollConnection arg0, float arg1) {
        arg0.adjustInsets(arg1);
    }

    public static final Object access$fling-huYlsQE(WindowInsetsNestedScrollConnection arg0, long arg1, float arg3, boolean arg4, Continuation arg5) {
        return arg0.fling-huYlsQE(arg1, arg3, arg4, arg5);
    }

    public static final Object access$getAnimationController(WindowInsetsNestedScrollConnection arg0, Continuation arg1) {
        return arg0.getAnimationController(arg1);
    }

    public static final Job access$getAnimationJob$p(WindowInsetsNestedScrollConnection arg0) {
        return arg0.animationJob;
    }

    public static final void access$requestAnimationController(WindowInsetsNestedScrollConnection arg0) {
        arg0.requestAnimationController();
    }

    public static final void access$setAnimationController$p(WindowInsetsNestedScrollConnection arg0, WindowInsetsAnimationController arg1) {
        arg0.animationController = arg1;
    }

    public static final void access$setAnimationJob$p(WindowInsetsNestedScrollConnection arg0, Job arg1) {
        arg0.animationJob = arg1;
    }

    public static final void access$setContinuation$p(WindowInsetsNestedScrollConnection arg0, CancellableContinuation arg1) {
        arg0.continuation = arg1;
    }

    private final void adjustInsets(float arg3) {
        WindowInsetsAnimationController v0 = this.animationController;
        if(v0 != null) {
            v0.setInsetsAndAlpha(this.sideCalculator.adjustInsets(v0.getCurrentInsets(), Math.round(arg3)), 1f, 0f);
        }
    }

    private final void animationEnded() {
        WindowInsetsAnimationController v0 = this.animationController;
        if(v0 != null && (v0.isReady())) {
            v0 = this.animationController;
            if(v0 != null) {
                v0.finish(this.windowInsets.isVisible());
            }
        }

        v0 = null;
        this.animationController = v0;
        CancellableContinuation v1 = this.continuation;
        if(v1 != null) {
            v1.resume(v0, WindowInsetsNestedScrollConnection$animationEnded$1.INSTANCE);
        }

        this.continuation = ((CancellableContinuation)v0);
        Job v1_1 = this.animationJob;
        if(v1_1 != null) {
            v1_1.cancel(new WindowInsetsAnimationCancelledException());
        }

        this.animationJob = ((Job)v0);
        this.partialConsumption = 0f;
        this.isControllerRequested = false;
    }

    public final void dispose() {
        CancellableContinuation v0 = this.continuation;
        Object v1 = null;
        if(v0 != null) {
            v0.resume(v1, WindowInsetsNestedScrollConnection$dispose$1.INSTANCE);
        }

        Job v0_1 = this.animationJob;
        if(v0_1 != null) {
            DefaultImpls.cancel$default(v0_1, ((CancellationException)v1), 1, v1);
        }

        WindowInsetsAnimationController v3 = this.animationController;
        if(v3 != null) {
            v3.finish(Intrinsics.areEqual(v3.getCurrentInsets(), v3.getHiddenStateInsets()) ^ 1);
        }
    }

    private final Object fling-huYlsQE(long arg19, float arg21, boolean arg22, Continuation arg23) {
        long v4_3;
        Object v4_4;
        long v14;
        FloatRef v0_5;
        int v6;
        Continuation v4;
        WindowInsetsNestedScrollConnection v1 = this;
        float v0 = arg21;
        boolean v2 = arg22;
        Continuation v3 = arg23;
        if((v3 instanceof WindowInsetsNestedScrollConnection$fling$1)) {
            v4 = v3;
            v6 = 0x80000000;
            if((((WindowInsetsNestedScrollConnection$fling$1)v4).label & v6) != 0) {
                ((WindowInsetsNestedScrollConnection$fling$1)v4).label -= v6;
            }
            else {
                goto label_15;
            }
        }
        else {
        label_15:
            WindowInsetsNestedScrollConnection$fling$1 v4_1 = new WindowInsetsNestedScrollConnection$fling$1(v1, v3);
        }

        Continuation v11 = v4;
        Object v3_1 = ((WindowInsetsNestedScrollConnection$fling$1)v11).result;
        Object v12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v4_2 = ((WindowInsetsNestedScrollConnection$fling$1)v11).label;
        Job v5 = null;
        int v8 = 3;
        int v13 = 2;
        boolean v6_1 = true;
        if(v4_2 == 0) {
            ResultKt.throwOnFailure(v3_1);
            Job v3_2 = v1.animationJob;
            if(v3_2 != null) {
                v3_2.cancel(new WindowInsetsAnimationCancelledException());
            }

            v1.animationJob = v5;
            v1.partialConsumption = 0f;
            if(v0 == 0f && !v2 || v1.animationController == null && v1.windowInsets.isVisible() == v2) {
                return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
            }

            long v2_1 = arg19;
            ((WindowInsetsNestedScrollConnection$fling$1)v11).J$0 = v2_1;
            ((WindowInsetsNestedScrollConnection$fling$1)v11).F$0 = v0;
            ((WindowInsetsNestedScrollConnection$fling$1)v11).label = 1;
            v4_4 = v1.getAnimationController(v11);
            if(v4_4 == v12) {
                return v12;
            }

            v14 = v2_1;
        label_45:
            float v3_3 = v0;
            if(v4_4 == null) {
                return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
            }

            int v0_2 = v1.sideCalculator.valueOf(((WindowInsetsAnimationController)v4_4).getHiddenStateInsets());
            int v2_2 = v1.sideCalculator.valueOf(((WindowInsetsAnimationController)v4_4).getShownStateInsets());
            int v7 = v1.sideCalculator.valueOf(((WindowInsetsAnimationController)v4_4).getCurrentInsets());
            boolean v16 = false;
            if(Float.compare(v3_3, 0f) <= 0 && v7 == v0_2 || v3_3 >= 0f && v7 == v2_2) {
                if(v7 == v2_2) {
                }
                else {
                    v6_1 = false;
                }

                ((WindowInsetsAnimationController)v4_4).finish(v6_1);
                v1.animationController = ((WindowInsetsAnimationController)v5);
                return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
            }

            Object v5_1 = v4_4;
            SplineBasedFloatDecayAnimationSpec v4_5 = new SplineBasedFloatDecayAnimationSpec(v1.density);
            float v10 = (((float)v7)) + v4_5.flingDistance(v3_3);
            float v6_2 = ((float)v0_2);
            if((v10 - v6_2) / (((float)(v2_2 - v0_2))) > 0.5f) {
                v16 = true;
            }

            SplineBasedFloatDecayAnimationSpec v13_1 = v4_5;
            float v4_6 = v3_3;
            int v3_4 = v16 ? v2_2 : v0_2;
            if(v10 <= (((float)v2_2))) {
                if(v10 < v6_2) {
                }
                else {
                    WindowInsetsNestedScrollConnection$fling$3 v0_3 = new WindowInsetsNestedScrollConnection$fling$3(v1, v7, v3_4, v4_6, ((WindowInsetsAnimationController)v5_1), v16, null);
                    ((WindowInsetsNestedScrollConnection$fling$1)v11).J$0 = v14;
                    ((WindowInsetsNestedScrollConnection$fling$1)v11).label = v8;
                    if(CoroutineScopeKt.coroutineScope(((Function2)v0_3), v11) == v12) {
                        return v12;
                    }
                    else {
                        v4_3 = v14;
                    label_140:
                        return Velocity.box-impl(v1.sideCalculator.consumedVelocity-QWom1Mo(v4_3, 0f));
                    }
                }
            }

            v6 = v2_2;
            v2_2 = v7;
            FloatRef v7_1 = new FloatRef();
            WindowInsetsNestedScrollConnection$fling$2 v0_4 = new WindowInsetsNestedScrollConnection$fling$2(v1, v2_2, v4_6, v13_1, v0_2, v6, v7_1, v5_1, v16, null);
            ((WindowInsetsNestedScrollConnection$fling$1)v11).L$0 = v7_1;
            ((WindowInsetsNestedScrollConnection$fling$1)v11).J$0 = v14;
            ((WindowInsetsNestedScrollConnection$fling$1)v11).label = 2;
            if(CoroutineScopeKt.coroutineScope(((Function2)v0_4), v11) == v12) {
                return v12;
            }

            v0_5 = v7_1;
            v4_3 = v14;
        }
        else if(v4_2 == 1) {
            v0 = ((WindowInsetsNestedScrollConnection$fling$1)v11).F$0;
            v14 = ((WindowInsetsNestedScrollConnection$fling$1)v11).J$0;
            ResultKt.throwOnFailure(v3_1);
            v4_4 = v3_1;
            goto label_45;
        }
        else if(v4_2 == v13) {
            v4_3 = ((WindowInsetsNestedScrollConnection$fling$1)v11).J$0;
            Object v0_1 = ((WindowInsetsNestedScrollConnection$fling$1)v11).L$0;
            ResultKt.throwOnFailure(v3_1);
        }
        else if(v4_2 == v8) {
            v4_3 = ((WindowInsetsNestedScrollConnection$fling$1)v11).J$0;
            ResultKt.throwOnFailure(v3_1);
            goto label_140;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Velocity.box-impl(v1.sideCalculator.consumedVelocity-QWom1Mo(v4_3, v0_5.element));
    }

    private final Object getAnimationController(Continuation arg4) {
        WindowInsetsAnimationController v0 = this.animationController;
        if(v0 == null) {
            CancellableContinuationImpl v0_1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg4), 1);
            v0_1.initCancellability();
            this.continuation = v0_1;
            this.requestAnimationController();
            Object v3 = v0_1.getResult();
            if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(arg4);
            }

            return v3;
        }

        return v0;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final View getView() {
        return this.view;
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    public void onCancelled(WindowInsetsAnimationController arg1) {
        this.animationEnded();
    }

    public void onFinished(WindowInsetsAnimationController arg1) {
        this.animationEnded();
    }

    public Object onPostFling-RZ2iAVY(long arg8, long arg10, Continuation arg12) {
        return this.fling-huYlsQE(arg10, this.sideCalculator.showMotion(Velocity.getX-impl(arg10), Velocity.getY-impl(arg10)), true, arg12);
    }

    public long onPostScroll-DzOQY0M(long arg3, long arg5, int arg7) {
        return this.scroll-8S9VItk(arg5, this.sideCalculator.showMotion(Float.intBitsToFloat(((int)(arg5 >> 0x20))), Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg5)))));
    }

    public Object onPreFling-QWom1Mo(long arg10, Continuation arg12) {
        return this.fling-huYlsQE(arg10, this.sideCalculator.hideMotion(Velocity.getX-impl(arg10), Velocity.getY-impl(arg10)), false, arg12);
    }

    public long onPreScroll-OzD1aCk(long arg4, int arg6) {
        return this.scroll-8S9VItk(arg4, this.sideCalculator.hideMotion(Float.intBitsToFloat(((int)(arg4 >> 0x20))), Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg4)))));
    }

    public void onReady(WindowInsetsAnimationController arg2, int arg3) {
        this.animationController = arg2;
        this.isControllerRequested = false;
        CancellableContinuation v3 = this.continuation;
        if(v3 != null) {
            v3.resume(arg2, new WindowInsetsNestedScrollConnection$$ExternalSyntheticLambda0());
        }

        this.continuation = null;
    }

    static final Unit onReady$lambda$0(Throwable arg0, WindowInsetsAnimationController arg1, CoroutineContext arg2) {
        return Unit.INSTANCE;
    }

    private final void requestAnimationController() {
        if(!this.isControllerRequested) {
            this.isControllerRequested = true;
            WindowInsetsController v1 = this.view.getWindowInsetsController();
            if(v1 != null) {
                v1.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout(), -1, null, this.cancellationSignal, this);
            }
        }
    }

    private final long scroll-8S9VItk(long arg8, float arg10) {
        int v3;
        Job v0 = this.animationJob;
        if(v0 != null) {
            v0.cancel(new WindowInsetsAnimationCancelledException());
            this.animationJob = null;
        }

        WindowInsetsAnimationController v0_1 = this.animationController;
        if(arg10 == 0f) {
        }
        else {
            boolean v2 = this.windowInsets.isVisible();
            v3 = Float.compare(arg10, 0f);
            boolean v4 = v3 > 0 ? true : false;
            if(v2 == v4 && v0_1 == null) {
                goto label_20;
            }

            goto label_23;
        }

    label_20:
        return Offset.Companion.getZero-F1C5BW0();
    label_23:
        if(v0_1 == null) {
            this.partialConsumption = 0f;
            this.requestAnimationController();
            return this.sideCalculator.consumedOffsets-MK-Hz9U(arg8);
        }

        int v2_1 = this.sideCalculator.valueOf(v0_1.getHiddenStateInsets());
        int v4_1 = this.sideCalculator.valueOf(v0_1.getShownStateInsets());
        Insets v5 = v0_1.getCurrentInsets();
        int v6 = this.sideCalculator.valueOf(v5);
        v3 = v3 > 0 ? v4_1 : v2_1;
        if(v6 == v3) {
            this.partialConsumption = 0f;
            return Offset.Companion.getZero-F1C5BW0();
        }

        float v3_1 = (((float)v6)) + arg10 + this.partialConsumption;
        int v10 = RangesKt.coerceIn(Math.round(v3_1), v2_1, v4_1);
        this.partialConsumption = v3_1 - (((float)Math.round(v3_1)));
        if(v10 != v6) {
            v0_1.setInsetsAndAlpha(this.sideCalculator.adjustInsets(v5, v10), 1f, 0f);
        }

        return this.sideCalculator.consumedOffsets-MK-Hz9U(arg8);
    }
}

