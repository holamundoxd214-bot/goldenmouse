package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/ui/platform/WindowRecomposerFactory;", "", "createRecomposer", "Landroidx/compose/runtime/Recomposer;", "windowRootView", "Landroid/view/View;", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface WindowRecomposerFactory {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/platform/WindowRecomposerFactory$Companion;", "", "<init>", "()V", "LifecycleAware", "Landroidx/compose/ui/platform/WindowRecomposerFactory;", "getLifecycleAware", "()Landroidx/compose/ui/platform/WindowRecomposerFactory;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final WindowRecomposerFactory LifecycleAware;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.LifecycleAware = new WindowRecomposerFactory$Companion$$ExternalSyntheticLambda0();
        }

        private Companion() {
            super();
        }

        static final Recomposer LifecycleAware$lambda$0(View arg2) {
            return WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer$default(arg2, null, null, 3, null);
        }

        public final WindowRecomposerFactory getLifecycleAware() {
            return Companion.LifecycleAware;
        }
    }

    public static final Companion Companion;

    static {
        WindowRecomposerFactory.Companion = Companion.$$INSTANCE;
    }

    Recomposer createRecomposer(View arg1);
}

