package androidx.navigationevent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\b\u0010\t\u001A\u00020\u0005H\u0007J\b\u0010\n\u001A\u00020\u0005H\u0007J\u0010\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\f\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\b\u0010\r\u001A\u00020\u0005H\u0007J\b\u0010\u000E\u001A\u00020\u0005H\u0007¨\u0006\u000F"}, d2={"Landroidx/navigationevent/DirectNavigationEventInput;", "Landroidx/navigationevent/NavigationEventInput;", "<init>", "()V", "backStarted", "", "event", "Landroidx/navigationevent/NavigationEvent;", "backProgressed", "backCancelled", "backCompleted", "forwardStarted", "forwardProgressed", "forwardCancelled", "forwardCompleted", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DirectNavigationEventInput extends NavigationEventInput {
    public DirectNavigationEventInput() {
        super();
    }

    public final void backCancelled() {
        this.dispatchOnBackCancelled();
    }

    public final void backCompleted() {
        this.dispatchOnBackCompleted();
    }

    public final void backProgressed(NavigationEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "event");
        this.dispatchOnBackProgressed(arg2);
    }

    public final void backStarted(NavigationEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "event");
        this.dispatchOnBackStarted(arg2);
    }

    public final void forwardCancelled() {
        this.dispatchOnForwardCancelled();
    }

    public final void forwardCompleted() {
        this.dispatchOnForwardCompleted();
    }

    public final void forwardProgressed(NavigationEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "event");
        this.dispatchOnForwardProgressed(arg2);
    }

    public final void forwardStarted(NavigationEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "event");
        this.dispatchOnForwardStarted(arg2);
    }
}

