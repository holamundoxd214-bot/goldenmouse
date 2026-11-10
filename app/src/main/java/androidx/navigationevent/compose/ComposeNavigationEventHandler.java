package androidx.navigationevent.compose;

import androidx.navigationevent.NavigationEvent;
import androidx.navigationevent.NavigationEventHandler;
import androidx.navigationevent.NavigationEventInfo;
import androidx.navigationevent.NavigationEventTransitionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u0014\b\u0002\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001CH\u0014J\u0010\u0010\u001D\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001CH\u0014J\b\u0010\u001E\u001A\u00020\bH\u0014J\b\u0010\u001F\u001A\u00020\bH\u0014J\u0010\u0010 \u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001CH\u0014J\u0010\u0010!\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001CH\u0014J\b\u0010\"\u001A\u00020\bH\u0014J\b\u0010#\u001A\u00020\bH\u0014R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\b0\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R \u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\b0\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\b0\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u000E\"\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\b0\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u000E\"\u0004\b\u0019\u0010\u0010¨\u0006$"}, d2={"Landroidx/navigationevent/compose/ComposeNavigationEventHandler;", "T", "Landroidx/navigationevent/NavigationEventInfo;", "Landroidx/navigationevent/NavigationEventHandler;", "initialInfo", "onTransitionStateChanged", "Lkotlin/Function1;", "Landroidx/navigationevent/NavigationEventTransitionState;", "", "<init>", "(Landroidx/navigationevent/NavigationEventInfo;Lkotlin/jvm/functions/Function1;)V", "currentOnForwardCancelled", "Lkotlin/Function0;", "getCurrentOnForwardCancelled", "()Lkotlin/jvm/functions/Function0;", "setCurrentOnForwardCancelled", "(Lkotlin/jvm/functions/Function0;)V", "currentOnForwardCompleted", "getCurrentOnForwardCompleted", "setCurrentOnForwardCompleted", "currentOnBackCancelled", "getCurrentOnBackCancelled", "setCurrentOnBackCancelled", "currentOnBackCompleted", "getCurrentOnBackCompleted", "setCurrentOnBackCompleted", "onForwardStarted", "event", "Landroidx/navigationevent/NavigationEvent;", "onForwardProgressed", "onForwardCancelled", "onForwardCompleted", "onBackStarted", "onBackProgressed", "onBackCancelled", "onBackCompleted", "navigationevent-compose"}, k=1, mv={2, 0, 0}, xi=0x30) final class ComposeNavigationEventHandler extends NavigationEventHandler {
    private Function0 currentOnBackCancelled;
    private Function0 currentOnBackCompleted;
    private Function0 currentOnForwardCancelled;
    private Function0 currentOnForwardCompleted;
    private final Function1 onTransitionStateChanged;

    public ComposeNavigationEventHandler(NavigationEventInfo arg2, Function1 arg3) {
        super(arg2, false, false);
        this.onTransitionStateChanged = arg3;
        this.currentOnForwardCancelled = new ComposeNavigationEventHandler$$ExternalSyntheticLambda1();
        this.currentOnForwardCompleted = new ComposeNavigationEventHandler$$ExternalSyntheticLambda2();
        this.currentOnBackCancelled = new ComposeNavigationEventHandler$$ExternalSyntheticLambda3();
        this.currentOnBackCompleted = new ComposeNavigationEventHandler$$ExternalSyntheticLambda4();
    }

    public ComposeNavigationEventHandler(NavigationEventInfo arg1, Function1 arg2, int arg3, DefaultConstructorMarker arg4) {
        ComposeNavigationEventHandler$$ExternalSyntheticLambda0 v2;
        if((arg3 & 2) != 0) {
            v2 = new ComposeNavigationEventHandler$$ExternalSyntheticLambda0();
        }

        this(arg1, ((Function1)v2));
    }

    static final Unit _init_$lambda$0(NavigationEventTransitionState arg0) {
        return Unit.INSTANCE;
    }

    static final Unit currentOnBackCancelled$lambda$3() {
        return Unit.INSTANCE;
    }

    static final Unit currentOnBackCompleted$lambda$4() {
        return Unit.INSTANCE;
    }

    static final Unit currentOnForwardCancelled$lambda$1() {
        return Unit.INSTANCE;
    }

    static final Unit currentOnForwardCompleted$lambda$2() {
        return Unit.INSTANCE;
    }

    public final Function0 getCurrentOnBackCancelled() {
        return this.currentOnBackCancelled;
    }

    public final Function0 getCurrentOnBackCompleted() {
        return this.currentOnBackCompleted;
    }

    public final Function0 getCurrentOnForwardCancelled() {
        return this.currentOnForwardCancelled;
    }

    public final Function0 getCurrentOnForwardCompleted() {
        return this.currentOnForwardCompleted;
    }

    protected void onBackCancelled() {
        this.onTransitionStateChanged.invoke(this.getTransitionState());
        this.currentOnBackCancelled.invoke();
    }

    protected void onBackCompleted() {
        this.onTransitionStateChanged.invoke(this.getTransitionState());
        this.currentOnBackCompleted.invoke();
    }

    protected void onBackProgressed(NavigationEvent arg1) {
        this.onTransitionStateChanged.invoke(this.getTransitionState());
    }

    protected void onBackStarted(NavigationEvent arg1) {
        this.onTransitionStateChanged.invoke(this.getTransitionState());
    }

    protected void onForwardCancelled() {
        this.onTransitionStateChanged.invoke(this.getTransitionState());
        this.currentOnForwardCancelled.invoke();
    }

    protected void onForwardCompleted() {
        this.onTransitionStateChanged.invoke(this.getTransitionState());
        this.currentOnForwardCompleted.invoke();
    }

    protected void onForwardProgressed(NavigationEvent arg1) {
        this.onTransitionStateChanged.invoke(this.getTransitionState());
    }

    protected void onForwardStarted(NavigationEvent arg1) {
        this.onTransitionStateChanged.invoke(this.getTransitionState());
    }

    public final void setCurrentOnBackCancelled(Function0 arg1) {
        this.currentOnBackCancelled = arg1;
    }

    public final void setCurrentOnBackCompleted(Function0 arg1) {
        this.currentOnBackCompleted = arg1;
    }

    public final void setCurrentOnForwardCancelled(Function0 arg1) {
        this.currentOnForwardCancelled = arg1;
    }

    public final void setCurrentOnForwardCompleted(Function0 arg1) {
        this.currentOnForwardCompleted = arg1;
    }
}

