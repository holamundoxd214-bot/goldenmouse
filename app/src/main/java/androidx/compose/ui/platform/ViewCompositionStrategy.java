package androidx.compose.ui.platform;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.poolingcontainer.PoolingContainerListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00072\u00020\u0001:\u0005\u0007\b\t\n\u000BJ\u0016\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/platform/ViewCompositionStrategy;", "", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "Companion", "DisposeOnDetachedFromWindowOrReleasedFromPool", "DisposeOnDetachedFromWindow", "DisposeOnLifecycleDestroyed", "DisposeOnViewTreeLifecycleDestroyed", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ViewCompositionStrategy {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/platform/ViewCompositionStrategy$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "getDefault", "()Landroidx/compose/ui/platform/ViewCompositionStrategy;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final ViewCompositionStrategy getDefault() {
            return DisposeOnDetachedFromWindowOrReleasedFromPool.INSTANCE;
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001A\u00020\bH\u0016¨\u0006\t"}, d2={"Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnDetachedFromWindow;", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "<init>", "()V", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DisposeOnDetachedFromWindow implements ViewCompositionStrategy {
        public static final int $stable;
        public static final DisposeOnDetachedFromWindow INSTANCE;

        static {
            DisposeOnDetachedFromWindow.INSTANCE = new DisposeOnDetachedFromWindow();
        }

        private DisposeOnDetachedFromWindow() {
            super();
        }

        public Function0 installFor(AbstractComposeView arg2) {
            ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1 v1 = new ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1(arg2);
            arg2.addOnAttachStateChangeListener(v1);
            return new ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$1(arg2, v1);
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001A\u00020\bH\u0016¨\u0006\t"}, d2={"Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool;", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "<init>", "()V", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DisposeOnDetachedFromWindowOrReleasedFromPool implements ViewCompositionStrategy {
        public static final int $stable;
        public static final DisposeOnDetachedFromWindowOrReleasedFromPool INSTANCE;

        static {
            DisposeOnDetachedFromWindowOrReleasedFromPool.INSTANCE = new DisposeOnDetachedFromWindowOrReleasedFromPool();
        }

        private DisposeOnDetachedFromWindowOrReleasedFromPool() {
            super();
        }

        public Function0 installFor(AbstractComposeView arg3) {
            ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$listener$1 v2 = new ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$listener$1(arg3);
            arg3.addOnAttachStateChangeListener(v2);
            ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 v0 = new ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0(arg3);
            PoolingContainer.addPoolingContainerListener(arg3, ((PoolingContainerListener)v0));
            return new ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$1(arg3, v2, ((PoolingContainerListener)v0));
        }

        static final void installFor$lambda$0(AbstractComposeView arg0) {
            arg0.disposeComposition();
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0016\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\f\u001A\u00020\rH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnLifecycleDestroyed;", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "<init>", "(Landroidx/lifecycle/Lifecycle;)V", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DisposeOnLifecycleDestroyed implements ViewCompositionStrategy {
        public static final int $stable = 8;
        private final Lifecycle lifecycle;

        static {
        }

        public DisposeOnLifecycleDestroyed(Lifecycle arg1) {
            super();
            this.lifecycle = arg1;
        }

        public DisposeOnLifecycleDestroyed(LifecycleOwner arg1) {
            this(arg1.getLifecycle());
        }

        public Function0 installFor(AbstractComposeView arg1) {
            return ViewCompositionStrategy_androidKt.access$installForLifecycle(arg1, this.lifecycle);
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001A\u00020\bH\u0016¨\u0006\t"}, d2={"Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed;", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "<init>", "()V", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DisposeOnViewTreeLifecycleDestroyed implements ViewCompositionStrategy {
        public static final int $stable;
        public static final DisposeOnViewTreeLifecycleDestroyed INSTANCE;

        static {
            DisposeOnViewTreeLifecycleDestroyed.INSTANCE = new DisposeOnViewTreeLifecycleDestroyed();
        }

        private DisposeOnViewTreeLifecycleDestroyed() {
            super();
        }

        public Function0 installFor(AbstractComposeView arg3) {
            if(arg3.isAttachedToWindow()) {
                LifecycleOwner v2 = ViewTreeLifecycleOwner.get(arg3);
                if(v2 != null) {
                    return ViewCompositionStrategy_androidKt.access$installForLifecycle(arg3, v2.getLifecycle());
                }

                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("View tree for " + arg3 + " has no ViewTreeLifecycleOwner");
                throw new KotlinNothingValueException();
            }

            ObjectRef v2_1 = new ObjectRef();
            ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1 v0 = new ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1(arg3, v2_1);
            arg3.addOnAttachStateChangeListener(v0);
            v2_1.element = new ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$1(arg3, v0);
            return new ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$2(v2_1);
        }
    }

    public static final Companion Companion;

    static {
        ViewCompositionStrategy.Companion = Companion.$$INSTANCE;
    }

    Function0 installFor(AbstractComposeView arg1);
}

