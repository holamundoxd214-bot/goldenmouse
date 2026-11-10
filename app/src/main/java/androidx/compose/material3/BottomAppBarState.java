package androidx.compose.material3;

import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000E\bg\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010R\u0018\u0010\u0002\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000B\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u0012\u0010\u000E\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2={"Landroidx/compose/material3/BottomAppBarState;", "", "heightOffsetLimit", "", "getHeightOffsetLimit", "()F", "setHeightOffsetLimit", "(F)V", "heightOffset", "getHeightOffset", "setHeightOffset", "contentOffset", "getContentOffset", "setContentOffset", "collapsedFraction", "getCollapsedFraction", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface BottomAppBarState {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/material3/BottomAppBarState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/BottomAppBarState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final Saver Saver;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.Saver = ListSaverKt.listSaver(new BottomAppBarState$Companion$$ExternalSyntheticLambda0(), new BottomAppBarState$Companion$$ExternalSyntheticLambda1());
        }

        private Companion() {
            super();
        }

        static final List Saver$lambda$0(SaverScope arg2, BottomAppBarState arg3) {
            return CollectionsKt.listOf(new Float[]{Float.valueOf(arg3.getHeightOffsetLimit()), Float.valueOf(arg3.getHeightOffset()), Float.valueOf(arg3.getContentOffset())});
        }

        static final BottomAppBarState Saver$lambda$1(List arg3) {
            return AppBarKt.BottomAppBarState(arg3.get(0).floatValue(), arg3.get(1).floatValue(), arg3.get(2).floatValue());
        }

        public final Saver getSaver() {
            return Companion.Saver;
        }
    }

    public static final Companion Companion;

    static {
        BottomAppBarState.Companion = Companion.$$INSTANCE;
    }

    float getCollapsedFraction();

    float getContentOffset();

    float getHeightOffset();

    float getHeightOffsetLimit();

    void setContentOffset(float arg1);

    void setHeightOffset(float arg1);

    void setHeightOffsetLimit(float arg1);
}

