package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B \u0012\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJI\u0010\u0012\u001A\u00020\u00062\b\u0010\u0013\u001A\u0004\u0018\u00010\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u001C\u0010\u0004\u001A\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010\u001AJ·\u0001\u0010\u001B\u001A\u00020\u00062\u0006\u0010\u001C\u001A\u00020\u001D2#\u0010\u0013\u001A\u001F\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u001E\u0012\b\b\u001F\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00052#\u0010\u0015\u001A\u001F\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u001E\u0012\b\b\u001F\u0012\u0004\b\b( \u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00052#\u0010\u0016\u001A\u001F\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u001E\u0012\b\b\u001F\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000521\u0010!\u001A-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u001E\u0012\b\b\u001F\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00060\"¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010#R\u001A\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridInterval;", "content", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "spanProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "getSpanProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "item", "key", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridIntervalContent extends LazyLayoutIntervalContent implements LazyStaggeredGridScope {
    public static final int $stable = 8;
    private final MutableIntervalList intervals;
    private final LazyStaggeredGridSpanProvider spanProvider;

    public static StaggeredGridItemSpan $r8$lambda$SCtqITRHYbTQISzxktx_eftYcdc(StaggeredGridItemSpan arg0, int arg1) {
        return LazyStaggeredGridIntervalContent.item$lambda$2$0(arg0, arg1);
    }

    public static Object $r8$lambda$dH_7n_L3eknQuPr4ePoUnYZP4QI(Object arg0, int arg1) {
        return LazyStaggeredGridIntervalContent.item$lambda$0$0(arg0, arg1);
    }

    static {
    }

    public LazyStaggeredGridIntervalContent(Function1 arg3) {
        super();
        this.intervals = new MutableIntervalList();
        this.spanProvider = new LazyStaggeredGridSpanProvider(this.getIntervals());
        arg3.invoke(this);
    }

    public MutableIntervalList getIntervals() {
        return this.intervals;
    }

    public IntervalList getIntervals() {
        return this.getIntervals();
    }

    public final LazyStaggeredGridSpanProvider getSpanProvider() {
        return this.spanProvider;
    }

    public void item(Object arg9, Object arg10, StaggeredGridItemSpan arg11, Function3 arg12) {
        Function1 v4_1;
        LazyStaggeredGridIntervalContent$$ExternalSyntheticLambda2 v0 = null;
        if(arg9 != null) {
            LazyStaggeredGridIntervalContent$$ExternalSyntheticLambda0 v4 = new LazyStaggeredGridIntervalContent$$ExternalSyntheticLambda0(arg9);
        }
        else {
            v4_1 = ((Function1)v0);
        }

        LazyStaggeredGridIntervalContent$$ExternalSyntheticLambda1 v5 = new LazyStaggeredGridIntervalContent$$ExternalSyntheticLambda1(arg10);
        if(arg11 != null) {
            v0 = new LazyStaggeredGridIntervalContent$$ExternalSyntheticLambda2(arg11);
        }

        this.items(1, v4_1, ((Function1)v5), v0, ComposableLambdaKt.composableLambdaInstance(0x3F53B917, true, new LazyStaggeredGridIntervalContent$$ExternalSyntheticLambda3(arg12)));
    }

    private static final Object item$lambda$0$0(Object arg0, int arg1) {
        return arg0;
    }

    static final Object item$lambda$1(Object arg0, int arg1) {
        return arg0;
    }

    private static final StaggeredGridItemSpan item$lambda$2$0(StaggeredGridItemSpan arg0, int arg1) {
        return arg0;
    }

    static final Unit item$lambda$3(Function3 arg2, LazyStaggeredGridItemScope arg3, int arg4, Composer arg5, int arg6) {
        ComposerKt.sourceInformation(arg5, "CN(it)44@1597L9:LazyStaggeredGridIntervalContent.kt#fzvcnm");
        if((arg6 & 6) == 0) {
            arg4 = arg5.changed(arg3) ? 4 : 2;
            arg6 |= arg4;
        }

        boolean v4 = (arg6 & 0x83) != 130 ? true : false;
        if(arg5.shouldExecute(v4, arg6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x3F53B917, arg6, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridIntervalContent.item.<anonymous> (LazyStaggeredGridIntervalContent.kt:44)");
            }

            arg2.invoke(arg3, arg5, Integer.valueOf(arg6 & 14));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_33;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg5.skipToGroupEnd();
        }

    label_33:
        return Unit.INSTANCE;
    }

    public void items(int arg2, Function1 arg3, Function1 arg4, Function1 arg5, Function4 arg6) {
        this.getIntervals().addInterval(arg2, new LazyStaggeredGridInterval(arg3, arg4, arg5, arg6));
    }
}

