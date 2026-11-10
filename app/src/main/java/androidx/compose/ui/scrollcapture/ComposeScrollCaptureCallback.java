package androidx.compose.ui.scrollcapture;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import android.view.View;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.graphics.Color$Companion;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.unit.IntRect;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001%B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u001E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J \u0010\u0019\u001A\u00020\u00132\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u001CH\u0016J.\u0010\u001D\u001A\u00020\u00132\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u001E\u001A\u00020\u00182\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u001E\u0010\u001D\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u0005H\u0082@¢\u0006\u0002\u0010 J\u0010\u0010!\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u001CH\u0016J\f\u0010\"\u001A\u00020\u0013*\u00020#H\u0002J\f\u0010$\u001A\u00020\u0013*\u00020#H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback;", "Landroid/view/ScrollCaptureCallback;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "viewportBoundsInWindow", "Landroidx/compose/ui/unit/IntRect;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "listener", "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "composeView", "Landroid/view/View;", "<init>", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/unit/IntRect;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;Landroid/view/View;)V", "scrollTracker", "Landroidx/compose/ui/scrollcapture/RelativeScroller;", "requestCount", "", "onScrollCaptureSearch", "", "signal", "Landroid/os/CancellationSignal;", "onReady", "Ljava/util/function/Consumer;", "Landroid/graphics/Rect;", "onScrollCaptureStart", "session", "Landroid/view/ScrollCaptureSession;", "Ljava/lang/Runnable;", "onScrollCaptureImageRequest", "captureArea", "onComplete", "(Landroid/view/ScrollCaptureSession;Landroidx/compose/ui/unit/IntRect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onScrollCaptureEnd", "drawDebugBackground", "Landroid/graphics/Canvas;", "drawDebugOverlay", "ScrollCaptureSessionListener", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\b\u0010\u0004\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2={"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "", "onSessionStarted", "", "onSessionEnded", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ScrollCaptureSessionListener {
        void onSessionEnded();

        void onSessionStarted();
    }

    public static final int $stable = 8;
    private final View composeView;
    private final CoroutineScope coroutineScope;
    private final ScrollCaptureSessionListener listener;
    private final SemanticsNode node;
    private int requestCount;
    private final RelativeScroller scrollTracker;
    private final IntRect viewportBoundsInWindow;

    static {
    }

    public ComposeScrollCaptureCallback(SemanticsNode arg1, IntRect arg2, CoroutineScope arg3, ScrollCaptureSessionListener arg4, View arg5) {
        super();
        this.node = arg1;
        this.viewportBoundsInWindow = arg2;
        this.listener = arg4;
        this.composeView = arg5;
        this.coroutineScope = CoroutineScopeKt.plus(arg3, DisableAnimationMotionDurationScale.INSTANCE);
        this.scrollTracker = new RelativeScroller(arg2.getHeight(), new ComposeScrollCaptureCallback$scrollTracker$1(this, null));
    }

    public static final ScrollCaptureSessionListener access$getListener$p(ComposeScrollCaptureCallback arg0) {
        return arg0.listener;
    }

    public static final SemanticsNode access$getNode$p(ComposeScrollCaptureCallback arg0) {
        return arg0.node;
    }

    public static final RelativeScroller access$getScrollTracker$p(ComposeScrollCaptureCallback arg0) {
        return arg0.scrollTracker;
    }

    public static final Object access$onScrollCaptureImageRequest(ComposeScrollCaptureCallback arg0, ScrollCaptureSession arg1, IntRect arg2, Continuation arg3) {
        return arg0.onScrollCaptureImageRequest(arg1, arg2, arg3);
    }

    private final void drawDebugBackground(Canvas arg9) {
        arg9.drawColor(ColorKt.toArgb-8_81llA(Companion.hsl-JlNiLsg$default(Color.Companion, 360f * Random.Default.nextFloat(), 0.75f, 0.5f, 1f, null, 16, null)));
    }

    private final void drawDebugOverlay(Canvas arg6) {
        Paint v0 = new Paint();
        v0.setColor(0xFFFF0000);
        v0.setTextSize(48f);
        arg6.drawCircle(0f, 0f, 20f, v0);
        arg6.drawCircle(((float)arg6.getWidth()), 0f, 20f, v0);
        arg6.drawCircle(((float)arg6.getWidth()), ((float)arg6.getHeight()), 20f, v0);
        arg6.drawCircle(0f, ((float)arg6.getHeight()), 20f, v0);
        arg6.drawText(String.valueOf(this.requestCount), (((float)arg6.getWidth())) / 2f, (((float)arg6.getHeight())) / 2f, v0);
        ++this.requestCount;
    }

    public void onScrollCaptureEnd(Runnable arg7) {
        BuildersKt.launch$default(this.coroutineScope, NonCancellable.INSTANCE, null, new ComposeScrollCaptureCallback$onScrollCaptureEnd$1(this, arg7, null), 2, null);
    }

    private final Object onScrollCaptureImageRequest(ScrollCaptureSession arg10, IntRect arg11, Continuation arg12) {
        IntRect v0_3;
        Object v10_1;
        Object v11_1;
        int v12_1;
        int v11;
        int v10;
        int v2;
        Continuation v0;
        if((arg12 instanceof ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)) {
            v0 = arg12;
            v2 = 0x80000000;
            if((((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).label & v2) != 0) {
                ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2 v0_1 = new ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2(this, arg12);
        }

        Object v12 = ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).label;
        int v3 = 3;
        int v4 = 2;
        if(v2 != 0) {
            if(v2 != 1 && v2 != v4) {
                if(v2 == v3) {
                    v10 = ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).I$1;
                    v11 = ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).I$0;
                    v1 = ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).L$1;
                    Object v0_2 = ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).L$0;
                    ResultKt.throwOnFailure(v12);
                    v12 = v0_2;
                    v0_2 = v1;
                    goto label_83;
                }
                else {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }

            v10 = ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).I$1;
            v11 = ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).I$0;
            Object v2_1 = ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).L$1;
            Object v4_1 = ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).L$0;
            ResultKt.throwOnFailure(v12);
            v12_1 = v11;
            v11_1 = v2_1;
            v2 = v10;
            v10_1 = v4_1;
            goto label_59;
        }
        else {
            ResultKt.throwOnFailure(v12);
            v12_1 = arg11.getTop();
            v2 = arg11.getBottom();
            boolean v6 = ComposeUiFlags.isScrollCaptureCenteringEnabled;
            RelativeScroller v7 = this.scrollTracker;
            if(v6) {
                ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).L$0 = arg10;
                ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).L$1 = arg11;
                ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).I$0 = v12_1;
                ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).I$1 = v2;
                ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).label = 1;
                if(v7.scrollRangeToCenter(v12_1, v2, v0) != v1) {
                    goto label_59;
                }

                return v1;
            }

            ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).L$0 = arg10;
            ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).L$1 = arg11;
            ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).I$0 = v12_1;
            ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).I$1 = v2;
            ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).label = v4;
            if(v7.scrollRangeIntoView(v12_1, v2, v0) == v1) {
                return v1;
            }

        label_59:
            int v8 = v12_1;
            ScrollCaptureSession v12_2 = ((ScrollCaptureSession)v10_1);
            v10 = v2;
            IntRect v2_2 = ((IntRect)v11_1);
            v11 = v8;
            ComposeScrollCaptureCallback$onScrollCaptureImageRequest$3 v4_2 = ComposeScrollCaptureCallback$onScrollCaptureImageRequest$3.INSTANCE;
            ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).L$0 = v12_2;
            ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).L$1 = v2_2;
            ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).I$0 = v11;
            ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).I$1 = v10;
            ((ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2)v0).label = v3;
            if(MonotonicFrameClockKt.withFrameNanos(((Function1)v4_2), v0) == v1) {
                return v1;
            }

            v0_3 = v2_2;
        }

    label_83:
        v2 = this.scrollTracker.mapOffsetToViewport(v11);
        v4 = this.scrollTracker.mapOffsetToViewport(v10);
        IntRect v10_2 = IntRect.copy$default(v0_3, 0, v2, 0, v4, 5, null);
        if(v2 == v4) {
            return IntRect.Companion.getZero();
        }

        Canvas v11_2 = ((ScrollCaptureSession)v12).getSurface().lockHardwareCanvas();
        try {
            v11_2.save();
            v11_2.translate(-(((float)v10_2.getLeft())), -(((float)v10_2.getTop())));
            v11_2.translate(-(((float)this.viewportBoundsInWindow.getLeft())), -(((float)this.viewportBoundsInWindow.getTop())));
            this.composeView.getRootView().draw(v11_2);
        }
        catch(Throwable v0_4) {
            ((ScrollCaptureSession)v12).getSurface().unlockCanvasAndPost(v11_2);
            throw v0_4;
        }

        ((ScrollCaptureSession)v12).getSurface().unlockCanvasAndPost(v11_2);
        return v10_2.translate(0, MathKt.roundToInt(this.scrollTracker.getScrollAmount()));
    }

    public void onScrollCaptureImageRequest(ScrollCaptureSession arg8, CancellationSignal arg9, Rect arg10, Consumer arg11) {
        ComposeScrollCaptureCallback_androidKt.access$launchWithCancellationSignal(this.coroutineScope, arg9, new ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1(this, arg8, arg10, arg11, null));
    }

    public void onScrollCaptureSearch(CancellationSignal arg1, Consumer arg2) {
        arg2.accept(RectHelper_androidKt.toAndroidRect(this.viewportBoundsInWindow));
    }

    public void onScrollCaptureStart(ScrollCaptureSession arg1, CancellationSignal arg2, Runnable arg3) {
        this.scrollTracker.reset();
        this.requestCount = 0;
        this.listener.onSessionStarted();
        arg3.run();
    }
}

