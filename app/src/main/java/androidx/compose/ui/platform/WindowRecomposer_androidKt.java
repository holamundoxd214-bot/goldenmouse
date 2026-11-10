package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.provider.Settings$Global;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.R$id;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.core.os.HandlerCompat;
import androidx.core.viewtree.ViewTree;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted$Companion;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\b\u001A\u0004\u0018\u00010\u0001*\u00020\u0003\u001A\u0016\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000F\u001A\u00020\u000BH\u0002\u001A \u0010\u0019\u001A\u00020\u0014*\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\",\u0010\u0002\u001A\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0000\u001A\u0004\u0018\u00010\u00018F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\" \u0010\t\u001A\u0014\u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0010\u001A\u00020\u0003*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012\"\u001E\u0010\u0013\u001A\u00020\u0014*\u00020\u00038@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001E"}, d2={"value", "Landroidx/compose/runtime/CompositionContext;", "compositionContext", "Landroid/view/View;", "getCompositionContext", "(Landroid/view/View;)Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroid/view/View;Landroidx/compose/runtime/CompositionContext;)V", "findViewTreeCompositionContext", "animationScale", "", "Landroid/content/Context;", "Lkotlinx/coroutines/flow/StateFlow;", "", "getAnimationScaleFlowFor", "applicationContext", "contentChild", "getContentChild", "(Landroid/view/View;)Landroid/view/View;", "windowRecomposer", "Landroidx/compose/runtime/Recomposer;", "getWindowRecomposer$annotations", "(Landroid/view/View;)V", "getWindowRecomposer", "(Landroid/view/View;)Landroidx/compose/runtime/Recomposer;", "createLifecycleAwareWindowRecomposer", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowRecomposer_androidKt {
    private static final Map animationScale;

    static {
        WindowRecomposer_androidKt.animationScale = new LinkedHashMap();
    }

    public static final StateFlow access$getAnimationScaleFlowFor(Context arg0) {
        return WindowRecomposer_androidKt.getAnimationScaleFlowFor(arg0);
    }

    public static final Recomposer createLifecycleAwareWindowRecomposer(View arg9, CoroutineContext arg10, Lifecycle arg11) {
        EmptyCoroutineContext v2_1;
        PausableMonotonicFrameClock v5;
        PausableMonotonicFrameClock v2;
        if(arg10.get(ContinuationInterceptor.Key) == null || arg10.get(MonotonicFrameClock.Key) == null) {
            arg10 = AndroidUiDispatcher.Companion.getCurrentThread().plus(arg10);
        }

        Element v0 = arg10.get(MonotonicFrameClock.Key);
        PausableMonotonicFrameClock v1 = null;
        if(v0 != null) {
            v2 = new PausableMonotonicFrameClock(((MonotonicFrameClock)v0));
            v2.pause();
            v5 = v2;
        }
        else {
            v5 = v1;
        }

        ObjectRef v7 = new ObjectRef();
        v0 = arg10.get(MotionDurationScale.Key);
        if(v0 == null) {
            MotionDurationScaleImpl v0_1 = new MotionDurationScaleImpl();
            v7.element = v0_1;
        }

        if(v5 != null) {
            v2 = v5;
        }
        else {
            v2_1 = EmptyCoroutineContext.INSTANCE;
        }

        arg10 = arg10.plus(((CoroutineContext)v2_1)).plus(((CoroutineContext)v0));
        Recomposer v6 = new Recomposer(arg10);
        v6.pauseCompositionFrameClock();
        CoroutineScope v4 = CoroutineScopeKt.CoroutineScope(arg10);
        if(arg11 == null) {
            LifecycleOwner v10 = ViewTreeLifecycleOwner.get(arg9);
            arg11 = v10 != null ? v10.getLifecycle() : ((Lifecycle)v1);
        }

        if(arg11 != null) {
            arg9.addOnAttachStateChangeListener(new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1(arg9, v6));
            arg11.addObserver(new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2(v4, v5, v6, v7, arg9));
            return v6;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("ViewTreeLifecycleOwner not found from " + arg9);
        throw new KotlinNothingValueException();
    }

    public static Recomposer createLifecycleAwareWindowRecomposer$default(View arg0, CoroutineContext arg1, Lifecycle arg2, int arg3, Object arg4) {
        EmptyCoroutineContext v1;
        if((arg3 & 1) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        return WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer(arg0, ((CoroutineContext)v1), arg2);
    }

    public static final CompositionContext findViewTreeCompositionContext(View arg2) {
        CompositionContext v0 = WindowRecomposer_androidKt.getCompositionContext(arg2);
        if(v0 != null) {
            return v0;
        }

        ViewParent v2;
        for(v2 = arg2.getParent(); v0 == null; v2 = ViewTree.getParentOrViewTreeDisjointParent(((View)v2))) {
            if(!(v2 instanceof View)) {
                return v0;
            }

            v0 = WindowRecomposer_androidKt.getCompositionContext(((View)v2));
        }

        return v0;
    }

    private static final StateFlow getAnimationScaleFlowFor(Context arg15) {
        StateFlow v0_2;
        Map v1 = WindowRecomposer_androidKt.animationScale;
        __monitor_enter(v1);
        try {
            Object v0_1 = v1.get(arg15);
            if(v0_1 == null) {
                ContentResolver v3 = arg15.getContentResolver();
                Uri v4 = Settings$Global.getUriFor("animator_duration_scale");
                Channel v6 = ChannelKt.Channel$default(-1, null, null, 6, null);
                v0_2 = FlowKt.stateIn(FlowKt.flow(new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(v3, v4, new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1(v6, HandlerCompat.createAsync(Looper.getMainLooper())), v6, arg15, null)), CoroutineScopeKt.MainScope(), Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), Float.valueOf(Settings$Global.getFloat(arg15.getContentResolver(), "animator_duration_scale", 1f)));
                v1.put(arg15, v0_2);
            }

            __monitor_exit(v1);
            return v0_2;
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }
    }

    public static final CompositionContext getCompositionContext(View arg1) {
        Object v1 = arg1.getTag(id.androidx_compose_ui_view_composition_context);
        if((v1 instanceof CompositionContext)) {
            return ((CompositionContext)v1);
        }

        return null;
    }

    private static final View getContentChild(View arg4) {
        ViewParent v4;
        ViewParent v0 = arg4.getParent();
        while((v0 instanceof View)) {
            if(((View)v0).getId() == 0x1020002) {
            }
            else {
                ViewParent v3 = v0;
                v0 = ((View)v0).getParent();
                v4 = v3;
                continue;
            }

            break;
        }

        return ((View)v4);
    }

    public static final Recomposer getWindowRecomposer(View arg2) {
        if(!arg2.isAttachedToWindow()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot locate windowRecomposer; View " + arg2 + " is not attached to a window");
        }

        arg2 = WindowRecomposer_androidKt.getContentChild(arg2);
        CompositionContext v0 = WindowRecomposer_androidKt.getCompositionContext(arg2);
        if(v0 == null) {
            return WindowRecomposerPolicy.INSTANCE.createAndInstallWindowRecomposer$ui(arg2);
        }

        if((v0 instanceof Recomposer)) {
            return ((Recomposer)v0);
        }

        throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString());
    }

    public static void getWindowRecomposer$annotations(View arg0) {
    }

    public static final void setCompositionContext(View arg1, CompositionContext arg2) {
        arg1.setTag(id.androidx_compose_ui_view_composition_context, arg2);
    }
}

