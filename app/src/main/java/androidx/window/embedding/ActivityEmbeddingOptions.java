package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0007\u001A\u001C\u0010\u0006\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0007¨\u0006\u000B"}, d2={"setLaunchingActivityStack", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "activityStack", "Landroidx/window/embedding/ActivityStack;", "setOverlayCreateParams", "activity", "Landroid/app/Activity;", "overlayCreateParams", "Landroidx/window/embedding/OverlayCreateParams;", "window_release"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ActivityEmbeddingOptions {
    public static final Bundle setLaunchingActivityStack(Bundle arg1, Context arg2, ActivityStack arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "activityStack");
        return ActivityEmbeddingController.Companion.getInstance(arg2).setLaunchingActivityStack$window_release(arg1, arg3);
    }

    public static final Bundle setOverlayCreateParams(Bundle arg1, Activity arg2, OverlayCreateParams arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "activity");
        Intrinsics.checkNotNullParameter(arg3, "overlayCreateParams");
        return OverlayController.Companion.getInstance(((Context)arg2)).setOverlayCreateParams$window_release(arg1, arg3);
    }
}

