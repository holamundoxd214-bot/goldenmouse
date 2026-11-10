package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DelegatableNode$RegistrationHandle;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.UnplacedAwareModifierNode;
import androidx.compose.ui.spatial.RelativeLayoutBounds;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0004\b\u000E\u0010\u000FJ \u0010@\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010A\u001A\u0002062\b\u0010B\u001A\u0004\u0018\u000106J\u0006\u0010C\u001A\u00020\rJ\u0006\u0010D\u001A\u00020\rJ\u0006\u0010E\u001A\u00020\rJ\b\u0010F\u001A\u00020\rH\u0016J\u0006\u0010G\u001A\u00020\rJ\b\u0010H\u001A\u00020\rH\u0016J\b\u0010I\u001A\u00020\rH\u0016J\b\u0010J\u001A\u00020\rH\u0016J\b\u0010K\u001A\u00020\rH\u0016R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR(\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\u001C\u001A\u0004\u0018\u00010\t@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R\u001C\u0010!\u001A\u0004\u0018\u00010\"X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001C\u0010\'\u001A\u0004\u0018\u00010(X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001A\u0010-\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R\u001A\u00102\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b3\u0010/\"\u0004\b4\u00101R\u001C\u00105\u001A\u0004\u0018\u000106X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b7\u00108\"\u0004\b9\u0010:R\u001C\u0010;\u001A\u0004\u0018\u000106X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b<\u00108\"\u0004\b=\u0010:R\u001D\u0010>\u001A\u000E\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\b\n\u0000\u001A\u0004\b?\u0010\u0019¨\u0006L"}, d2={"Landroidx/compose/ui/layout/OnVisibilityChangedNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/UnplacedAwareModifierNode;", "minDurationMs", "", "minFractionVisible", "", "viewportBounds", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "callback", "Lkotlin/Function1;", "", "", "<init>", "(JFLandroidx/compose/ui/layout/LayoutBoundsHolder;Lkotlin/jvm/functions/Function1;)V", "getMinDurationMs", "()J", "setMinDurationMs", "(J)V", "getMinFractionVisible", "()F", "setMinFractionVisible", "(F)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "value", "getViewportBounds", "()Landroidx/compose/ui/layout/LayoutBoundsHolder;", "setViewportBounds", "(Landroidx/compose/ui/layout/LayoutBoundsHolder;)V", "handle", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "getHandle", "()Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "setHandle", "(Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;)V", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "lastResult", "getLastResult", "()Z", "setLastResult", "(Z)V", "lastReportedResult", "getLastReportedResult", "setLastReportedResult", "lastBounds", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "getLastBounds", "()Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "setLastBounds", "(Landroidx/compose/ui/spatial/RelativeLayoutBounds;)V", "lastViewport", "getLastViewport", "setLastViewport", "rectChanged", "getRectChanged", "checkVisibility", "bounds", "viewport", "triggerCallback", "forceUpdate", "fireExitIfNeeded", "onReset", "updateViewport", "onAttach", "onDetach", "onObservedReadsChanged", "onUnplaced", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OnVisibilityChangedNode extends Node implements ObserverModifierNode, UnplacedAwareModifierNode {
    public static final int $stable = 8;
    private Function1 callback;
    private RegistrationHandle handle;
    private Job job;
    private RelativeLayoutBounds lastBounds;
    private boolean lastReportedResult;
    private boolean lastResult;
    private RelativeLayoutBounds lastViewport;
    private long minDurationMs;
    private float minFractionVisible;
    private final Function1 rectChanged;
    private LayoutBoundsHolder viewportBounds;

    static {
    }

    public OnVisibilityChangedNode(long arg1, float arg3, LayoutBoundsHolder arg4, Function1 arg5) {
        super();
        this.minDurationMs = arg1;
        this.minFractionVisible = arg3;
        this.callback = arg5;
        this.viewportBounds = arg4;
        this.rectChanged = new OnVisibilityChangedNode$rectChanged$1(this);
    }

    public final void checkVisibility(float arg8, RelativeLayoutBounds arg9, RelativeLayoutBounds arg10) {
        this.lastBounds = arg9;
        if(arg10 != null || this.viewportBounds == null) {
            float v9 = arg10 != null ? arg9.fractionVisibleIn(arg10) : arg9.fractionVisibleInWindow();
            boolean v8 = Float.compare(v9, arg8) > 0 || v9 == 1f ? true : false;
            if(v8 == this.lastResult) {
                return;
            }

            this.lastResult = v8;
            Job v9_1 = this.job;
            CancellationException v0 = null;
            if(v9_1 != null) {
                DefaultImpls.cancel$default(v9_1, v0, 1, v0);
            }

            this.job = ((Job)v0);
            if(v8 == this.lastReportedResult) {
                return;
            }

            if((v8) && this.minDurationMs > 0) {
                this.job = BuildersKt.launch$default(this.getCoroutineScope(), null, null, new OnVisibilityChangedNode$checkVisibility$1(this, ((Continuation)v0)), 3, null);
                return;
            }

            this.triggerCallback();
        }
        else {
        }
    }

    public final void fireExitIfNeeded() {
        Job v0 = this.job;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        this.job = ((Job)v1);
        this.lastResult = false;
        if(this.lastReportedResult) {
            this.triggerCallback();
        }
    }

    public final void forceUpdate() {
        RelativeLayoutBounds v0 = this.lastBounds;
        if(v0 != null) {
            this.checkVisibility(this.minFractionVisible, v0, this.lastViewport);
        }
    }

    public final Function1 getCallback() {
        return this.callback;
    }

    public final RegistrationHandle getHandle() {
        return this.handle;
    }

    public final Job getJob() {
        return this.job;
    }

    public final RelativeLayoutBounds getLastBounds() {
        return this.lastBounds;
    }

    public final boolean getLastReportedResult() {
        return this.lastReportedResult;
    }

    public final boolean getLastResult() {
        return this.lastResult;
    }

    public final RelativeLayoutBounds getLastViewport() {
        return this.lastViewport;
    }

    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    public final float getMinFractionVisible() {
        return this.minFractionVisible;
    }

    public final Function1 getRectChanged() {
        return this.rectChanged;
    }

    public final LayoutBoundsHolder getViewportBounds() {
        return this.viewportBounds;
    }

    public void onAttach() {
        RegistrationHandle v0 = this.handle;
        if(v0 != null) {
            v0.unregister();
        }

        this.handle = OnLayoutRectChangedModifierKt.registerOnLayoutRectChanged(this, 0, 0, this.rectChanged);
        this.updateViewport();
    }

    public void onDetach() {
        RegistrationHandle v0 = this.handle;
        if(v0 != null) {
            v0.unregister();
        }

        this.fireExitIfNeeded();
    }

    public void onObservedReadsChanged() {
        this.updateViewport();
    }

    public void onReset() {
        this.fireExitIfNeeded();
        Job v0 = this.job;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        this.job = ((Job)v1);
        this.lastResult = false;
        this.lastBounds = ((RelativeLayoutBounds)v1);
        this.lastViewport = ((RelativeLayoutBounds)v1);
    }

    public void onUnplaced() {
        this.fireExitIfNeeded();
    }

    public final void setCallback(Function1 arg1) {
        this.callback = arg1;
    }

    public final void setHandle(RegistrationHandle arg1) {
        this.handle = arg1;
    }

    public final void setJob(Job arg1) {
        this.job = arg1;
    }

    public final void setLastBounds(RelativeLayoutBounds arg1) {
        this.lastBounds = arg1;
    }

    public final void setLastReportedResult(boolean arg1) {
        this.lastReportedResult = arg1;
    }

    public final void setLastResult(boolean arg1) {
        this.lastResult = arg1;
    }

    public final void setLastViewport(RelativeLayoutBounds arg1) {
        this.lastViewport = arg1;
    }

    public final void setMinDurationMs(long arg1) {
        this.minDurationMs = arg1;
    }

    public final void setMinFractionVisible(float arg1) {
        this.minFractionVisible = arg1;
    }

    public final void setViewportBounds(LayoutBoundsHolder arg1) {
        this.viewportBounds = arg1;
        this.updateViewport();
    }

    public final void triggerCallback() {
        Job v0 = this.job;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        this.job = ((Job)v1);
        this.callback.invoke(Boolean.valueOf(this.lastResult));
        this.lastReportedResult = this.lastResult;
    }

    public final void updateViewport() {
        if(this.viewportBounds == null) {
            if(this.lastViewport != null) {
                this.lastViewport = null;
                this.forceUpdate();
            }

            return;
        }

        ObserverModifierNodeKt.observeReads(this, new OnVisibilityChangedNode$updateViewport$1(this));
    }
}

