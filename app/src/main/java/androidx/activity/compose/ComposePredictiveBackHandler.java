package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.compose.internal.BackHandlerCompat;
import androidx.navigationevent.NavigationEventInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010$\u001A\u00020\u0012H\u0002J\u0010\u0010%\u001A\u00020\u00122\u0006\u0010&\u001A\u00020\rH\u0016J\u0010\u0010\'\u001A\u00020\u00122\u0006\u0010&\u001A\u00020\rH\u0016J\b\u0010(\u001A\u00020\u0012H\u0016J\b\u0010)\u001A\u00020\u0012H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tRM\u0010\n\u001A3\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000BX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0018\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0019\u001A\u00020\u001A8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u0016\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010!\u001A\u0004\u0018\u00010\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006*"}, d2={"Landroidx/activity/compose/ComposePredictiveBackHandler;", "Landroidx/activity/compose/internal/BackHandlerCompat;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "info", "Landroidx/activity/compose/PredictiveBackHandlerInfo;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/activity/compose/PredictiveBackHandlerInfo;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "currentOnBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", "name", "progress", "Lkotlin/coroutines/Continuation;", "", "", "getCurrentOnBack", "()Lkotlin/jvm/functions/Function2;", "setCurrentOnBack", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "value", "", "isBackEnabled", "()Z", "setBackEnabled", "(Z)V", "activeChannel", "Lkotlinx/coroutines/channels/Channel;", "activeJob", "Lkotlinx/coroutines/Job;", "isPredictiveBack", "launchNewGesture", "onBackStarted", "event", "onBackProgressed", "onBackCompleted", "onBackCancelled", "activity-compose"}, k=1, mv={2, 1, 0}, xi=0x30) final class ComposePredictiveBackHandler extends BackHandlerCompat {
    private Channel activeChannel;
    private Job activeJob;
    private Function2 currentOnBack;
    private boolean isPredictiveBack;
    private final CoroutineScope scope;

    public ComposePredictiveBackHandler(CoroutineScope arg1, PredictiveBackHandlerInfo arg2) {
        super(((NavigationEventInfo)arg2));
        this.scope = arg1;
        this.currentOnBack = new ComposePredictiveBackHandler$currentOnBack$1(null);
    }

    public static final Channel access$getActiveChannel$p(ComposePredictiveBackHandler arg0) {
        return arg0.activeChannel;
    }

    public final Function2 getCurrentOnBack() {
        return this.currentOnBack;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public boolean isBackEnabled() {
        return super.isBackEnabled();
    }

    private final void launchNewGesture() {
        this.activeChannel = ChannelKt.Channel$default(-2, BufferOverflow.SUSPEND, null, 4, null);
        this.activeJob = BuildersKt.launch$default(this.scope, null, null, new ComposePredictiveBackHandler$launchNewGesture$1(this, null), 3, null);
    }

    public void onBackCancelled() {
        Channel v0 = this.activeChannel;
        if(v0 != null) {
            v0.cancel(new CancellationException("onBack cancelled"));
        }

        Job v0_1 = this.activeJob;
        CancellationException v1 = null;
        if(v0_1 != null) {
            DefaultImpls.cancel$default(v0_1, v1, 1, v1);
        }

        this.activeChannel = ((Channel)v1);
        this.activeJob = ((Job)v1);
        this.isPredictiveBack = false;
    }

    public void onBackCompleted() {
        if(this.activeChannel != null && !this.isPredictiveBack) {
            this.onBackCancelled();
        }

        if(this.activeChannel == null) {
            this.isPredictiveBack = false;
            this.launchNewGesture();
        }

        Channel v0 = this.activeChannel;
        if(v0 != null) {
            kotlinx.coroutines.channels.SendChannel$DefaultImpls.close$default(((SendChannel)v0), null, 1, null);
        }

        this.isPredictiveBack = false;
    }

    public void onBackProgressed(BackEventCompat arg1) {
        Channel v0 = this.activeChannel;
        if(v0 != null) {
            ChannelResult.box-impl(v0.trySend-JP2dKIU(arg1));
        }
    }

    public void onBackStarted(BackEventCompat arg1) {
        this.onBackCancelled();
        if(this.isBackEnabled()) {
            this.isPredictiveBack = true;
            this.launchNewGesture();
        }
    }

    public void setBackEnabled(boolean arg2) {
        if(!arg2 && (super.isBackEnabled())) {
            Job v0 = this.activeJob;
            if(v0 != null && !v0.isActive()) {
                this.onBackCancelled();
            }
        }

        super.setBackEnabled(arg2);
    }

    public final void setCurrentOnBack(Function2 arg1) {
        this.currentOnBack = arg1;
    }
}

