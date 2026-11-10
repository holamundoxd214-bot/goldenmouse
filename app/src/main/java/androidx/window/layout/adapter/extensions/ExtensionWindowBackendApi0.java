package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0016J\u0016\u0010\r\u001A\u00020\u00052\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0016J\u0010\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u0007H\u0016R\u001A\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2={"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi0;", "Landroidx/window/layout/adapter/WindowBackend;", "<init>", "()V", "registerLayoutChangeCallback", "", "context", "Landroid/content/Context;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "unregisterLayoutChangeCallback", "supportedPostures", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "getCurrentWindowLayoutInfo", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public class ExtensionWindowBackendApi0 implements WindowBackend {
    public ExtensionWindowBackendApi0() {
        super();
    }

    public WindowLayoutInfo getCurrentWindowLayoutInfo(Context arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        throw new UnsupportedOperationException("Extensions version must be at least 9");
    }

    public List getSupportedPostures() {
        throw new UnsupportedOperationException("Extensions version must be at least 6");
    }

    public void registerLayoutChangeCallback(Context arg1, Executor arg2, Consumer arg3) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        Intrinsics.checkNotNullParameter(arg2, "executor");
        Intrinsics.checkNotNullParameter(arg3, "callback");
        arg2.execute(new ExtensionWindowBackendApi0$$ExternalSyntheticLambda0(arg3));
    }

    static final void registerLayoutChangeCallback$lambda$0(Consumer arg2) {
        arg2.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));
    }

    public void unregisterLayoutChangeCallback(Consumer arg1) {
        Intrinsics.checkNotNullParameter(arg1, "callback");
    }
}

