package androidx.window.embedding;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001D\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nH\u0001¢\u0006\u0002\b\u000BJ\u001C\u0010\f\u001A\u00020\r2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000FH\u0007J\b\u0010\u0012\u001A\u00020\rH\u0007J\u0018\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0011H\u0007J\u0016\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0014\u001A\u00020\u0015H\u0007R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/window/embedding/OverlayController;", "", "backend", "Landroidx/window/embedding/EmbeddingBackend;", "<init>", "(Landroidx/window/embedding/EmbeddingBackend;)V", "setOverlayCreateParams", "Landroid/os/Bundle;", "options", "overlayCreateParams", "Landroidx/window/embedding/OverlayCreateParams;", "setOverlayCreateParams$window_release", "setOverlayAttributesCalculator", "", "calculator", "Lkotlin/Function1;", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "Landroidx/window/embedding/OverlayAttributes;", "clearOverlayAttributesCalculator", "updateOverlayAttributes", "overlayTag", "", "overlayAttributes", "overlayInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/embedding/OverlayInfo;", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OverlayController {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/window/embedding/OverlayController$Companion;", "", "<init>", "()V", "OVERLAY_FEATURE_VERSION", "", "getInstance", "Landroidx/window/embedding/OverlayController;", "context", "Landroid/content/Context;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final OverlayController getInstance(Context arg1) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            return new OverlayController(EmbeddingBackend.Companion.getInstance(arg1));
        }
    }

    public static final Companion Companion = null;
    public static final int OVERLAY_FEATURE_VERSION = 8;
    private final EmbeddingBackend backend;

    static {
        OverlayController.Companion = new Companion(null);
    }

    public OverlayController(EmbeddingBackend arg2) {
        Intrinsics.checkNotNullParameter(arg2, "backend");
        super();
        this.backend = arg2;
    }

    public static final EmbeddingBackend access$getBackend$p(OverlayController arg0) {
        return arg0.backend;
    }

    public final void clearOverlayAttributesCalculator() {
        this.backend.clearOverlayAttributesCalculator();
    }

    @JvmStatic public static final OverlayController getInstance(Context arg1) {
        return OverlayController.Companion.getInstance(arg1);
    }

    public final Flow overlayInfo(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "overlayTag");
        return FlowKt.callbackFlow(new OverlayController$overlayInfo$1(this, arg3, null));
    }

    public final void setOverlayAttributesCalculator(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "calculator");
        this.backend.setOverlayAttributesCalculator(arg2);
    }

    public final Bundle setOverlayCreateParams$window_release(Bundle arg2, OverlayCreateParams arg3) {
        Intrinsics.checkNotNullParameter(arg2, "options");
        Intrinsics.checkNotNullParameter(arg3, "overlayCreateParams");
        return this.backend.setOverlayCreateParams(arg2, arg3);
    }

    public final void updateOverlayAttributes(String arg2, OverlayAttributes arg3) {
        Intrinsics.checkNotNullParameter(arg2, "overlayTag");
        Intrinsics.checkNotNullParameter(arg3, "overlayAttributes");
        this.backend.updateOverlayAttributes(arg2, arg3);
    }
}

