package androidx.compose.ui.platform;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionServiceKey;
import androidx.compose.runtime.CompositionServices;
import androidx.compose.ui.R$id;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u0016\u001A\u00020\u00132\u0011\u0010\u0017\u001A\r\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\b\u0014H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001A\u00020\u0013H\u0016J\u0018\u0010\u001E\u001A\u00020\u00132\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\"H\u0016J#\u0010#\u001A\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010$2\f\u0010%\u001A\b\u0012\u0004\u0012\u0002H$0&H\u0016¢\u0006\u0002\u0010\'R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\u0011\u001A\r\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\b\u0014X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u001A\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001C¨\u0006("}, d2={"Landroidx/compose/ui/platform/WrappedComposition;", "Landroidx/compose/runtime/Composition;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/compose/runtime/CompositionServices;", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "original", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/Composition;)V", "getOwner", "()Landroidx/compose/ui/platform/AndroidComposeView;", "getOriginal", "()Landroidx/compose/runtime/Composition;", "disposed", "", "addedToLifecycle", "Landroidx/lifecycle/Lifecycle;", "lastContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "setContent", "content", "(Lkotlin/jvm/functions/Function2;)V", "dispose", "hasInvalidations", "getHasInvalidations", "()Z", "isDisposed", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "getCompositionService", "T", "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class WrappedComposition implements Composition, CompositionServices, LifecycleEventObserver {
    private Lifecycle addedToLifecycle;
    private boolean disposed;
    private Function2 lastContent;
    private final Composition original;
    private final AndroidComposeView owner;

    public WrappedComposition(AndroidComposeView arg1, Composition arg2) {
        super();
        this.owner = arg1;
        this.original = arg2;
        this.lastContent = ComposableSingletons$Wrapper_androidKt.INSTANCE.getLambda$-1759434350$ui();
    }

    public static final Lifecycle access$getAddedToLifecycle$p(WrappedComposition arg0) {
        return arg0.addedToLifecycle;
    }

    public static final boolean access$getDisposed$p(WrappedComposition arg0) {
        return arg0.disposed;
    }

    public static final void access$setAddedToLifecycle$p(WrappedComposition arg0, Lifecycle arg1) {
        arg0.addedToLifecycle = arg1;
    }

    public static final void access$setLastContent$p(WrappedComposition arg0, Function2 arg1) {
        arg0.lastContent = arg1;
    }

    public void dispose() {
        if(!this.disposed) {
            this.disposed = true;
            this.owner.getView().setTag(id.wrapped_composition_tag, null);
            Lifecycle v0 = this.addedToLifecycle;
            if(v0 != null) {
                v0.removeObserver(this);
            }
        }

        this.original.dispose();
    }

    public Object getCompositionService(CompositionServiceKey arg3) {
        Composition v2 = this.original;
        Object v1 = null;
        if((v2 instanceof CompositionServices)) {
        }
        else {
            v2 = ((Composition)v1);
        }

        if(v2 != null) {
            return ((CompositionServices)v2).getCompositionService(arg3);
        }

        return v1;
    }

    public boolean getHasInvalidations() {
        return this.original.getHasInvalidations();
    }

    public final Composition getOriginal() {
        return this.original;
    }

    public final AndroidComposeView getOwner() {
        return this.owner;
    }

    public boolean isDisposed() {
        return this.original.isDisposed();
    }

    public void onStateChanged(LifecycleOwner arg1, Event arg2) {
        if(arg2 == Event.ON_DESTROY) {
            this.dispose();
            return;
        }

        if(arg2 == Event.ON_CREATE && !this.disposed) {
            this.setContent(this.lastContent);
        }
    }

    public void setContent(Function2 arg3) {
        this.owner.setOnViewTreeOwnersAvailable(new WrappedComposition$setContent$1(this, arg3));
    }
}

