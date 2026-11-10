package androidx.compose.foundation.pager;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nJ0\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/pager/PagerSnapDistance;", "", "calculateTargetPage", "", "startPage", "suggestedTargetPage", "velocity", "", "pageSize", "pageSpacing", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PagerSnapDistance {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/pager/PagerSnapDistance$Companion;", "", "<init>", "()V", "atMost", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "pages", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final PagerSnapDistance atMost(int arg2) {
            int v1 = arg2 >= 0 ? 1 : 0;
            if(v1 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("pages should be greater than or equal to 0. You have used " + arg2 + '.');
            }

            return new PagerSnapDistanceMaxPages(arg2);
        }
    }

    public static final Companion Companion;

    static {
        PagerSnapDistance.Companion = Companion.$$INSTANCE;
    }

    int calculateTargetPage(int arg1, int arg2, float arg3, int arg4, int arg5);
}

