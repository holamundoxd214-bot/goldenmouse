package androidx.compose.foundation.lazy.layout;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003;<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B2\b\u0017\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u001B\b\u0002\u0010\u0006\u001A\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u0002\u0010\u000BB&\b\u0017\u0012\u001B\b\u0002\u0010\u0006\u001A\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u0002\u0010\fJ\u0010\u0010(\u001A\u00020)2\b\b\u0001\u0010*\u001A\u00020\u001DJ\u001D\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020\u001D2\u0006\u0010+\u001A\u00020,H\u0000¢\u0006\u0002\b-J<\u0010.\u001A\u00020)2\b\b\u0001\u0010*\u001A\u00020\u001D2\u0006\u0010/\u001A\u0002002\u001B\b\u0002\u00101\u001A\u0015\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b3\u00104JD\u0010.\u001A\u00020)2\u0006\u0010*\u001A\u00020\u001D2\u0006\u0010/\u001A\u0002002\u0006\u0010+\u001A\u00020,2\u001B\b\u0002\u00101\u001A\u0015\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nH\u0000¢\u0006\u0004\b5\u00106J\u0013\u00107\u001A\b\u0012\u0004\u0012\u00020908H\u0000¢\u0006\u0002\b:R\"\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\'\u0010\u0006\u001A\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nX\u0082\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0080\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0003\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001A\u0010\u001C\u001A\u00020\u001DX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R\u001A\u0010\"\u001A\u00020\u001DX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u001F\"\u0004\b$\u0010!R\u001A\u0010%\u001A\u00020\u001DX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u001F\"\u0004\b\'\u0010!¨\u0006>"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "", "<init>", "()V", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "onNestedPrefetch", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;Lkotlin/jvm/functions/Function1;)V", "(Lkotlin/jvm/functions/Function1;)V", "getPrefetchScheduler$foundation$annotations", "getPrefetchScheduler$foundation", "()Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "setPrefetchScheduler$foundation", "(Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "getOnNestedPrefetch$annotations", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "prefetchHandleProvider", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "getPrefetchHandleProvider$foundation$annotations", "getPrefetchHandleProvider$foundation", "()Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "setPrefetchHandleProvider$foundation", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;)V", "realizedNestedPrefetchCount", "", "getRealizedNestedPrefetchCount$foundation", "()I", "setRealizedNestedPrefetchCount$foundation", "(I)V", "idealNestedPrefetchCount", "getIdealNestedPrefetchCount$foundation", "setIdealNestedPrefetchCount$foundation", "lastNumberOfNestedPrefetchItems", "getLastNumberOfNestedPrefetchItems$foundation", "setLastNumberOfNestedPrefetchItems$foundation", "schedulePrecomposition", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "isHighPriority", "", "schedulePrecomposition$foundation", "schedulePrecompositionAndPremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "onItemPremeasured", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "schedulePrecompositionAndPremeasure-VKLhPVY", "(IJLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "schedulePrecompositionAndPremeasure-_EkL_-Y$foundation", "(IJZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "collectNestedPrefetchRequests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "collectNestedPrefetchRequests$foundation", "PrefetchHandle", "PrefetchResultScope", "NestedPrefetchScopeImpl", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutPrefetchState {
    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0003H\u0016J\u001F\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t8F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\n0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$NestedPrefetchScopeImpl;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "nestedPrefetchItemCount", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;I)V", "getNestedPrefetchItemCount", "()I", "requests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "getRequests", "()Ljava/util/List;", "_requests", "", "schedulePrecomposition", "", "index", "schedulePrecompositionAndPremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrecompositionAndPremeasure-0kLqBqw", "(IJ)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class NestedPrefetchScopeImpl implements NestedPrefetchScope {
        private final List _requests;
        private final int nestedPrefetchItemCount;

        public NestedPrefetchScopeImpl(LazyLayoutPrefetchState arg1, int arg2) {
            LazyLayoutPrefetchState.this = arg1;
            super();
            this.nestedPrefetchItemCount = arg2;
            this._requests = new ArrayList();
        }

        public int getNestedPrefetchItemCount() {
            return this.nestedPrefetchItemCount;
        }

        public final List getRequests() {
            return this._requests;
        }

        public void schedulePrecomposition(int arg3) {
            PrefetchHandleProvider v0 = LazyLayoutPrefetchState.this.getPrefetchHandleProvider$foundation();
            if(v0 == null) {
                return;
            }

            this._requests.add(v0.createNestedPrefetchRequest(arg3, LazyLayoutPrefetchState.this.prefetchMetrics));
        }

        public void schedulePrecompositionAndPremeasure-0kLqBqw(int arg3, long arg4) {
            PrefetchHandleProvider v0 = LazyLayoutPrefetchState.this.getPrefetchHandleProvider$foundation();
            if(v0 == null) {
                return;
            }

            this._requests.add(v0.createNestedPrefetchRequest-VKLhPVY(arg3, arg4, LazyLayoutPrefetchState.this.prefetchMetrics));
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\b\u0010\u0004\u001A\u00020\u0003H&\u0082\u0001\u0002\u0005\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "", "cancel", "", "markAsUrgent", "Landroidx/compose/foundation/lazy/layout/DummyHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PrefetchHandle {
        void cancel();

        void markAsUrgent();
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0019\u0010\b\u001A\u00020\t2\b\b\u0001\u0010\n\u001A\u00020\u0003H&¢\u0006\u0004\b\u000B\u0010\fR\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005\u0082\u0001\u0001\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "", "placeablesCount", "", "getPlaceablesCount", "()I", "index", "getIndex", "getSize", "Landroidx/compose/ui/unit/IntSize;", "placeableIndex", "getSize-YEO4UFw", "(I)J", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PrefetchResultScope {
        int getIndex();

        int getPlaceablesCount();

        long getSize-YEO4UFw(int arg1);
    }

    public static final int $stable;
    private int idealNestedPrefetchCount;
    private int lastNumberOfNestedPrefetchItems;
    private Function1 onNestedPrefetch;
    private PrefetchHandleProvider prefetchHandleProvider;
    private final PrefetchMetrics prefetchMetrics;
    private PrefetchScheduler prefetchScheduler;
    private int realizedNestedPrefetchCount;

    static {
    }

    @Deprecated(message="Please use overload without Prefetch Scheduler.") public LazyLayoutPrefetchState(PrefetchScheduler arg1, Function1 arg2) {
        this();
        this.prefetchScheduler = arg1;
        this.onNestedPrefetch = arg2;
    }

    public LazyLayoutPrefetchState() {
        super();
        this.prefetchMetrics = new PrefetchMetrics();
        this.realizedNestedPrefetchCount = -1;
        this.idealNestedPrefetchCount = -1;
    }

    public LazyLayoutPrefetchState(PrefetchScheduler arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        PrefetchScheduler v0 = null;
        if((arg4 & 1) != 0) {
            arg2 = v0;
        }

        if((arg4 & 2) != 0) {
            arg3 = ((Function1)v0);
        }

        this(arg2, arg3);
    }

    public LazyLayoutPrefetchState(Function1 arg1) {
        this();
        this.onNestedPrefetch = arg1;
    }

    public LazyLayoutPrefetchState(Function1 arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        this(arg1);
    }

    public static final PrefetchMetrics access$getPrefetchMetrics$p(LazyLayoutPrefetchState arg0) {
        return arg0.prefetchMetrics;
    }

    public final List collectNestedPrefetchRequests$foundation() {
        Function1 v0 = this.onNestedPrefetch;
        if(v0 == null) {
            return CollectionsKt.emptyList();
        }

        NestedPrefetchScopeImpl v1 = new NestedPrefetchScopeImpl(this, this.realizedNestedPrefetchCount);
        v0.invoke(v1);
        List v0_1 = v1.getRequests();
        this.lastNumberOfNestedPrefetchItems = v0_1.size();
        return v0_1;
    }

    public final int getIdealNestedPrefetchCount$foundation() {
        return this.idealNestedPrefetchCount;
    }

    public final int getLastNumberOfNestedPrefetchItems$foundation() {
        return this.lastNumberOfNestedPrefetchItems;
    }

    private static void getOnNestedPrefetch$annotations() {
    }

    public final PrefetchHandleProvider getPrefetchHandleProvider$foundation() {
        return this.prefetchHandleProvider;
    }

    public static void getPrefetchHandleProvider$foundation$annotations() {
    }

    public final PrefetchScheduler getPrefetchScheduler$foundation() {
        return this.prefetchScheduler;
    }

    public static void getPrefetchScheduler$foundation$annotations() {
    }

    public final int getRealizedNestedPrefetchCount$foundation() {
        return this.realizedNestedPrefetchCount;
    }

    public final PrefetchHandle schedulePrecomposition(int arg2) {
        return this.schedulePrecomposition$foundation(arg2, true);
    }

    public final PrefetchHandle schedulePrecomposition$foundation(int arg2, boolean arg3) {
        PrefetchHandleProvider v0 = this.prefetchHandleProvider;
        if(v0 != null) {
            PrefetchHandle v1 = v0.schedulePrecomposition(arg2, arg3, this.prefetchMetrics);
            if(v1 == null) {
            }
            else {
                return v1;
            }
        }

        return DummyHandle.INSTANCE;
    }

    public final PrefetchHandle schedulePrecompositionAndPremeasure-VKLhPVY(int arg7, long arg8, Function1 arg10) {
        return this.schedulePrecompositionAndPremeasure-_EkL_-Y$foundation(arg7, arg8, true, arg10);
    }

    public static PrefetchHandle schedulePrecompositionAndPremeasure-VKLhPVY$default(LazyLayoutPrefetchState arg0, int arg1, long arg2, Function1 arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg4 = null;
        }

        return arg0.schedulePrecompositionAndPremeasure-VKLhPVY(arg1, arg2, arg4);
    }

    public final PrefetchHandle schedulePrecompositionAndPremeasure-_EkL_-Y$foundation(int arg8, long arg9, boolean arg11, Function1 arg12) {
        PrefetchHandleProvider v0 = this.prefetchHandleProvider;
        if(v0 != null) {
            PrefetchHandle v7 = v0.schedulePremeasure-m8Kt_7k(arg8, arg9, this.prefetchMetrics, arg11, arg12);
            if(v7 == null) {
            }
            else {
                return v7;
            }
        }

        return DummyHandle.INSTANCE;
    }

    public static PrefetchHandle schedulePrecompositionAndPremeasure-_EkL_-Y$foundation$default(LazyLayoutPrefetchState arg6, int arg7, long arg8, boolean arg10, Function1 arg11, int arg12, Object arg13) {
        if((arg12 & 8) != 0) {
            arg11 = null;
        }

        return arg6.schedulePrecompositionAndPremeasure-_EkL_-Y$foundation(arg7, arg8, arg10, arg11);
    }

    public final void setIdealNestedPrefetchCount$foundation(int arg1) {
        this.idealNestedPrefetchCount = arg1;
    }

    public final void setLastNumberOfNestedPrefetchItems$foundation(int arg1) {
        this.lastNumberOfNestedPrefetchItems = arg1;
    }

    public final void setPrefetchHandleProvider$foundation(PrefetchHandleProvider arg1) {
        this.prefetchHandleProvider = arg1;
    }

    public final void setPrefetchScheduler$foundation(PrefetchScheduler arg1) {
        this.prefetchScheduler = arg1;
    }

    public final void setRealizedNestedPrefetchCount$foundation(int arg1) {
        this.realizedNestedPrefetchCount = arg1;
    }
}

