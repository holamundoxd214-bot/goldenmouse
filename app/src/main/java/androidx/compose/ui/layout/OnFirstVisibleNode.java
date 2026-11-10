package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DelegatableNode$RegistrationHandle;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.spatial.RelativeLayoutBounds;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0004\b\f\u0010\rJ \u0010>\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010?\u001A\u0002022\b\u0010@\u001A\u0004\u0018\u000102J\u0006\u0010A\u001A\u00020\u000BJ\u0006\u0010B\u001A\u00020\u000BJ\u0006\u0010C\u001A\u00020\u000BJ\u0006\u0010D\u001A\u00020\u000BJ\u0006\u0010E\u001A\u00020\u000BJ\b\u0010F\u001A\u00020\u000BH\u0016J\b\u0010G\u001A\u00020\u000BH\u0016J\b\u0010H\u001A\u00020\u000BH\u0016J\b\u0010I\u001A\u00020\u000BH\u0016R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\u0010\u001A\u001A\u0004\u0018\u00010\b@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u001C\u0010\u001F\u001A\u0004\u0018\u00010 X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001C\u0010%\u001A\u0004\u0018\u00010&X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001A\u0010+\u001A\u00020,X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R\u001C\u00101\u001A\u0004\u0018\u000102X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b3\u00104\"\u0004\b5\u00106R(\u00107\u001A\u0004\u0018\u0001022\b\u0010\u001A\u001A\u0004\u0018\u000102@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b8\u00104\"\u0004\b9\u00106R\u001D\u0010:\u001A\u000E\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u000B0;¢\u0006\b\n\u0000\u001A\u0004\b<\u0010=¨\u0006J"}, d2={"Landroidx/compose/ui/layout/OnFirstVisibleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "minDurationMs", "", "minFractionVisible", "", "viewportBounds", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "callback", "Lkotlin/Function0;", "", "<init>", "(JFLandroidx/compose/ui/layout/LayoutBoundsHolder;Lkotlin/jvm/functions/Function0;)V", "getMinDurationMs", "()J", "setMinDurationMs", "(J)V", "getMinFractionVisible", "()F", "setMinFractionVisible", "(F)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "value", "getViewportBounds", "()Landroidx/compose/ui/layout/LayoutBoundsHolder;", "setViewportBounds", "(Landroidx/compose/ui/layout/LayoutBoundsHolder;)V", "handle", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "getHandle", "()Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "setHandle", "(Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;)V", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "lastResult", "", "getLastResult", "()Z", "setLastResult", "(Z)V", "lastBounds", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "getLastBounds", "()Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "setLastBounds", "(Landroidx/compose/ui/spatial/RelativeLayoutBounds;)V", "lastViewport", "getLastViewport", "setLastViewport", "rectChanged", "Lkotlin/Function1;", "getRectChanged", "()Lkotlin/jvm/functions/Function1;", "checkVisibility", "bounds", "viewport", "startTimer", "cancelTimer", "triggerCallback", "forceUpdate", "updateViewport", "onAttach", "onReset", "onDetach", "onObservedReadsChanged", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class OnFirstVisibleNode extends Node implements ObserverModifierNode {
    private Function0 callback;
    private RegistrationHandle handle;
    private Job job;
    private RelativeLayoutBounds lastBounds;
    private boolean lastResult;
    private RelativeLayoutBounds lastViewport;
    private long minDurationMs;
    private float minFractionVisible;
    private final Function1 rectChanged;
    private LayoutBoundsHolder viewportBounds;

    public OnFirstVisibleNode(long arg1, float arg3, LayoutBoundsHolder arg4, Function0 arg5) {
        super();
        this.minDurationMs = arg1;
        this.minFractionVisible = arg3;
        this.callback = arg5;
        this.viewportBounds = arg4;
        this.rectChanged = new OnFirstVisibleNode$rectChanged$1(this);
    }

    public final void cancelTimer() {
        Job v2 = this.job;
        if(v2 != null) {
            DefaultImpls.cancel$default(v2, null, 1, null);
        }
    }

    public final void checkVisibility(float arg2, RelativeLayoutBounds arg3, RelativeLayoutBounds arg4) {
        this.lastBounds = arg3;
        if(arg4 == null && this.viewportBounds != null) {
            return;
        }

        float v3 = arg4 != null ? arg3.fractionVisibleIn(arg4) : arg3.fractionVisibleInWindow();
        boolean v2 = v3 > arg2 || v3 == 1f ? true : false;
        if((v2) && !this.lastResult) {
            this.startTimer();
        }
        else if(!v2 && (this.lastResult)) {
            this.cancelTimer();
        }

        this.lastResult = v2;
    }

    public final void forceUpdate() {
        RelativeLayoutBounds v0 = this.lastBounds;
        if(v0 != null) {
            this.checkVisibility(this.minFractionVisible, v0, this.lastViewport);
        }
    }

    public final Function0 getCallback() {
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

        this.updateViewport();
        this.handle = OnLayoutRectChangedModifierKt.registerOnLayoutRectChanged(this, 0, 0, this.rectChanged);
    }

    public void onDetach() {
        RegistrationHandle v0 = this.handle;
        if(v0 != null) {
            v0.unregister();
        }
    }

    public void onObservedReadsChanged() {
        this.updateViewport();
    }

    public void onReset() {
        Job v0 = this.job;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        this.job = ((Job)v1);
        this.lastResult = false;
        this.lastBounds = ((RelativeLayoutBounds)v1);
        this.setLastViewport(((RelativeLayoutBounds)v1));
    }

    public final void setCallback(Function0 arg1) {
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

    public final void setLastResult(boolean arg1) {
        this.lastResult = arg1;
    }

    public final void setLastViewport(RelativeLayoutBounds arg2) {
        if(!Intrinsics.areEqual(this.lastViewport, arg2)) {
            this.lastViewport = arg2;
            this.forceUpdate();
        }
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

    public final void startTimer() {
        long v0 = this.minDurationMs;
        if(v0 == 0) {
            this.triggerCallback();
            return;
        }

        Job v2 = this.job;
        CancellationException v3 = null;
        if(v2 != null) {
            DefaultImpls.cancel$default(v2, v3, 1, v3);
        }

        this.job = BuildersKt.launch$default(this.getCoroutineScope(), null, null, new OnFirstVisibleNode$startTimer$1(v0, this, ((Continuation)v3)), 3, null);
    }

    public final void triggerCallback() {
        RegistrationHandle v0 = this.handle;
        if(v0 != null) {
            v0.unregister();
        }

        Job v0_1 = this.job;
        if(v0_1 != null) {
            DefaultImpls.cancel$default(v0_1, null, 1, null);
        }

        this.callback.invoke();
    }

    public final void updateViewport() {
        if(this.viewportBounds == null) {
            this.setLastViewport(null);
            return;
        }

        ObserverModifierNodeKt.observeReads(this, new OnFirstVisibleNode$updateViewport$1(this));
    }
}

