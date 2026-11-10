package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.node.RootForTest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\b\u0010\u000B\u001A\u00020\fH&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/node/RootForTest;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "isLifecycleInResumedState", "", "()Z", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "invalidateDescendants", "", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ViewRootForTest extends RootForTest {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0003\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/ui/platform/ViewRootForTest$Companion;", "", "<init>", "()V", "onViewCreatedCallback", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/ViewRootForTest;", "", "getOnViewCreatedCallback$annotations", "getOnViewCreatedCallback", "()Lkotlin/jvm/functions/Function1;", "setOnViewCreatedCallback", "(Lkotlin/jvm/functions/Function1;)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static Function1 onViewCreatedCallback;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final Function1 getOnViewCreatedCallback() {
            return Companion.onViewCreatedCallback;
        }

        public static void getOnViewCreatedCallback$annotations() {
        }

        public final void setOnViewCreatedCallback(Function1 arg1) {
            Companion.onViewCreatedCallback = arg1;
        }
    }

    public static final Companion Companion;

    static {
        ViewRootForTest.Companion = Companion.$$INSTANCE;
    }

    boolean getHasPendingMeasureOrLayout();

    View getView();

    void invalidateDescendants();

    boolean isLifecycleInResumedState();
}

