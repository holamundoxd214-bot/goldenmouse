package androidx.activity;

import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0017¨\u0006\b"}, d2={"Landroidx/activity/EdgeToEdgeApi30;", "Landroidx/activity/EdgeToEdgeApi29;", "<init>", "()V", "adjustLayoutInDisplayCutoutMode", "", "window", "Landroid/view/Window;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) class EdgeToEdgeApi30 extends EdgeToEdgeApi29 {
    public EdgeToEdgeApi30() {
        super();
    }

    public void adjustLayoutInDisplayCutoutMode(Window arg1) {
        Intrinsics.checkNotNullParameter(arg1, "window");
        arg1.getAttributes().layoutInDisplayCutoutMode = 3;
    }
}

