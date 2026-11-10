package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u0010\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\b\u001A\u00020\tJ\u001D\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u000BH\u0001¢\u0006\u0002\b\u0010J\u0016\u0010\u0011\u001A\u00020\u00122\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0014H\u0007J\u0010\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u0017H\u0007J\b\u0010\u0018\u001A\u00020\u0012H\u0007J\u0016\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A2\u0006\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/window/embedding/ActivityEmbeddingController;", "", "backend", "Landroidx/window/embedding/EmbeddingBackend;", "<init>", "(Landroidx/window/embedding/EmbeddingBackend;)V", "isActivityEmbedded", "", "activity", "Landroid/app/Activity;", "getActivityStack", "Landroidx/window/embedding/ActivityStack;", "setLaunchingActivityStack", "Landroid/os/Bundle;", "options", "activityStack", "setLaunchingActivityStack$window_release", "finishActivityStacks", "", "activityStacks", "", "setEmbeddingConfiguration", "embeddingConfiguration", "Landroidx/window/embedding/EmbeddingConfiguration;", "invalidateVisibleActivityStacks", "embeddedActivityWindowInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ActivityEmbeddingController {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2={"Landroidx/window/embedding/ActivityEmbeddingController$Companion;", "", "<init>", "()V", "getInstance", "Landroidx/window/embedding/ActivityEmbeddingController;", "context", "Landroid/content/Context;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final ActivityEmbeddingController getInstance(Context arg1) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            return new ActivityEmbeddingController(EmbeddingBackend.Companion.getInstance(arg1));
        }
    }

    public static final Companion Companion;
    private final EmbeddingBackend backend;

    static {
        ActivityEmbeddingController.Companion = new Companion(null);
    }

    public ActivityEmbeddingController(EmbeddingBackend arg2) {
        Intrinsics.checkNotNullParameter(arg2, "backend");
        super();
        this.backend = arg2;
    }

    public static final EmbeddingBackend access$getBackend$p(ActivityEmbeddingController arg0) {
        return arg0.backend;
    }

    public final Flow embeddedActivityWindowInfo(Activity arg3) {
        Intrinsics.checkNotNullParameter(arg3, "activity");
        return FlowKt.callbackFlow(new ActivityEmbeddingController$embeddedActivityWindowInfo$1(this, arg3, null));
    }

    public final void finishActivityStacks(Set arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activityStacks");
        this.backend.finishActivityStacks(arg2);
    }

    public final ActivityStack getActivityStack(Activity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        return this.backend.getActivityStack(arg2);
    }

    @JvmStatic public static final ActivityEmbeddingController getInstance(Context arg1) {
        return ActivityEmbeddingController.Companion.getInstance(arg1);
    }

    public final void invalidateVisibleActivityStacks() {
        this.backend.invalidateVisibleActivityStacks();
    }

    public final boolean isActivityEmbedded(Activity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        return this.backend.isActivityEmbedded(arg2);
    }

    public final void setEmbeddingConfiguration(EmbeddingConfiguration arg2) {
        Intrinsics.checkNotNullParameter(arg2, "embeddingConfiguration");
        this.backend.setEmbeddingConfiguration(arg2);
    }

    public final Bundle setLaunchingActivityStack$window_release(Bundle arg2, ActivityStack arg3) {
        Intrinsics.checkNotNullParameter(arg2, "options");
        Intrinsics.checkNotNullParameter(arg3, "activityStack");
        return this.backend.setLaunchingActivityStack(arg2, arg3);
    }
}

