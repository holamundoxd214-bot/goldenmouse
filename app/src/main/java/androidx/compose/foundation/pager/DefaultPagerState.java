package androidx.compose.foundation.pager;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tR&\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/pager/DefaultPagerState;", "Landroidx/compose/foundation/pager/PagerState;", "currentPage", "", "currentPageOffsetFraction", "", "updatedPageCount", "Lkotlin/Function0;", "<init>", "(IFLkotlin/jvm/functions/Function0;)V", "pageCountState", "Landroidx/compose/runtime/MutableState;", "getPageCountState", "()Landroidx/compose/runtime/MutableState;", "setPageCountState", "(Landroidx/compose/runtime/MutableState;)V", "pageCount", "getPageCount", "()I", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultPagerState extends PagerState {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/foundation/pager/DefaultPagerState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/pager/DefaultPagerState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return DefaultPagerState.Saver;
        }
    }

    public static final Companion Companion;
    private static final Saver Saver;
    private MutableState pageCountState;

    public static int $r8$lambda$vLLEqP2vixzIOcDQyW9LvhQu97U(List arg0) {
        return DefaultPagerState.Saver$lambda$1$0(arg0);
    }

    static {
        DefaultPagerState.Companion = new Companion(null);
        DefaultPagerState.Saver = ListSaverKt.listSaver(new DefaultPagerState$$ExternalSyntheticLambda0(), new DefaultPagerState$$ExternalSyntheticLambda1());
    }

    public DefaultPagerState(int arg1, float arg2, Function0 arg3) {
        super(arg1, arg2);
        this.pageCountState = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
    }

    static final List Saver$lambda$0(SaverScope arg3, DefaultPagerState arg4) {
        return CollectionsKt.listOf(new Object[]{Integer.valueOf(arg4.getCurrentPage()), Float.valueOf(RangesKt.coerceIn(arg4.getCurrentPageOffsetFraction(), -0.5f, 0.5f)), Integer.valueOf(arg4.getPageCount())});
    }

    static final DefaultPagerState Saver$lambda$1(List arg4) {
        Object v1 = arg4.get(0);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Int");
        int v1_1 = ((Integer)v1).intValue();
        Object v2 = arg4.get(1);
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Float");
        return new DefaultPagerState(v1_1, ((Float)v2).floatValue(), new DefaultPagerState$$ExternalSyntheticLambda2(arg4));
    }

    private static final int Saver$lambda$1$0(List arg1) {
        Object v1 = arg1.get(2);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer)v1).intValue();
    }

    public static final Saver access$getSaver$cp() {
        return DefaultPagerState.Saver;
    }

    public int getPageCount() {
        return this.pageCountState.getValue().invoke().intValue();
    }

    public final MutableState getPageCountState() {
        return this.pageCountState;
    }

    public final void setPageCountState(MutableState arg1) {
        this.pageCountState = arg1;
    }
}

