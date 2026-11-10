package androidx.compose.foundation.lazy.grid;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 32\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00013B \u0012\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJZ\u0010\u001E\u001A\u00020\u00062\b\u0010\u001F\u001A\u0004\u0018\u00010 2\u0019\u0010!\u001A\u0015\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010\u0005¢\u0006\u0002\b\u00072\b\u0010$\u001A\u0004\u0018\u00010 2\u001C\u0010\u0004\u001A\u0018\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b&¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010\'J³\u0001\u0010(\u001A\u00020\u00062\u0006\u0010)\u001A\u00020*2#\u0010\u001F\u001A\u001F\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020 \u0018\u00010\u00052\u001F\u0010!\u001A\u001B\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020#\u0018\u00010.¢\u0006\u0002\b\u00072#\u0010$\u001A\u001F\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0006\u0012\u0004\u0018\u00010 0\u000521\u0010/\u001A-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00060.¢\u0006\u0002\b&¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u00100JE\u00101\u001A\u00020\u00062\b\u0010\u001F\u001A\u0004\u0018\u00010 2\b\u0010$\u001A\u0004\u0018\u00010 2\"\u0010\u0004\u001A\u001E\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00060.¢\u0006\u0002\b&¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u00102R\u0014\u0010\n\u001A\u00020\u000BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u000FX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u00020\u0013X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u001A\u001A\u00020\u001B8F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u00064"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/grid/LazyGridInterval;", "content", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getSpanLayoutProvider$foundation", "()Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "hasCustomSpans", "", "getHasCustomSpans$foundation", "()Z", "setHasCustomSpans$foundation", "(Z)V", "_headerIndexes", "Landroidx/collection/MutableIntList;", "headerIndexes", "Landroidx/collection/IntList;", "getHeaderIndexes", "()Landroidx/collection/IntList;", "item", "key", "", "span", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "Lkotlin/Function2;", "itemContent", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyGridIntervalContent extends LazyLayoutIntervalContent implements LazyGridScope {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001A\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent$Companion;", "", "<init>", "()V", "DefaultSpan", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "getDefaultSpan", "()Lkotlin/jvm/functions/Function2;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Function2 getDefaultSpan() {
            return LazyGridIntervalContent.DefaultSpan;
        }
    }

    public static final int $stable;
    private static final Companion Companion;
    private static final Function2 DefaultSpan;
    private MutableIntList _headerIndexes;
    private boolean hasCustomSpans;
    private final MutableIntervalList intervals;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public static Object $r8$lambda$CFKBJpXUQSmnJk6aD_uasr7JIro(Object arg0, int arg1) {
        return LazyGridIntervalContent.item$lambda$0$0(arg0, arg1);
    }

    public static GridItemSpan $r8$lambda$ZuIUS0kkNQZOLv9hdV1sDoEFDMM(Function1 arg0, LazyGridItemSpanScope arg1, int arg2) {
        return LazyGridIntervalContent.item$lambda$1$0(arg0, arg1, arg2);
    }

    static {
        LazyGridIntervalContent.Companion = new Companion(null);
        LazyGridIntervalContent.$stable = 8;
        LazyGridIntervalContent.DefaultSpan = new LazyGridIntervalContent$$ExternalSyntheticLambda6();
    }

    public LazyGridIntervalContent(Function1 arg2) {
        super();
        this.spanLayoutProvider = new LazyGridSpanLayoutProvider(this);
        this.intervals = new MutableIntervalList();
        arg2.invoke(this);
    }

    static final GridItemSpan DefaultSpan$lambda$0(LazyGridItemSpanScope arg0, int arg1) {
        return GridItemSpan.box-impl(LazyGridSpanKt.GridItemSpan(1));
    }

    public static final Function2 access$getDefaultSpan$cp() {
        return LazyGridIntervalContent.DefaultSpan;
    }

    public final boolean getHasCustomSpans$foundation() {
        return this.hasCustomSpans;
    }

    public final IntList getHeaderIndexes() {
        MutableIntList v0 = this._headerIndexes;
        if(v0 != null) {
            return ((IntList)v0);
        }

        return IntListKt.emptyIntList();
    }

    public IntervalList getIntervals() {
        return this.getIntervals();
    }

    public MutableIntervalList getIntervals() {
        return this.intervals;
    }

    public final LazyGridSpanLayoutProvider getSpanLayoutProvider$foundation() {
        return this.spanLayoutProvider;
    }

    public void item(Object arg5, Function1 arg6, Object arg7, Function3 arg8) {
        Function2 v5_1;
        LazyGridIntervalContent$$ExternalSyntheticLambda2 v1;
        MutableIntervalList v0 = this.getIntervals();
        if(arg5 != null) {
            v1 = new LazyGridIntervalContent$$ExternalSyntheticLambda2(arg5);
        }
        else {
            Function1 v1_1 = null;
        }

        if(arg6 != null) {
            LazyGridIntervalContent$$ExternalSyntheticLambda3 v5 = new LazyGridIntervalContent$$ExternalSyntheticLambda3(arg6);
        }
        else {
            v5_1 = LazyGridIntervalContent.DefaultSpan;
        }

        v0.addInterval(1, new LazyGridInterval(((Function1)v1), v5_1, new LazyGridIntervalContent$$ExternalSyntheticLambda4(arg7), ComposableLambdaKt.composableLambdaInstance(0xEE9DDE35, true, new LazyGridIntervalContent$$ExternalSyntheticLambda5(arg8))));
        if(arg6 != null) {
            this.hasCustomSpans = true;
        }
    }

    private static final Object item$lambda$0$0(Object arg0, int arg1) {
        return arg0;
    }

    private static final GridItemSpan item$lambda$1$0(Function1 arg0, LazyGridItemSpanScope arg1, int arg2) {
        return arg0.invoke(arg1);
    }

    static final Object item$lambda$2(Object arg0, int arg1) {
        return arg0;
    }

    static final Unit item$lambda$3(Function3 arg2, LazyGridItemScope arg3, int arg4, Composer arg5, int arg6) {
        ComposerKt.sourceInformation(arg5, "CN(it)55@1985L9:LazyGridIntervalContent.kt#7791vq");
        if((arg6 & 6) == 0) {
            arg4 = arg5.changed(arg3) ? 4 : 2;
            arg6 |= arg4;
        }

        boolean v4 = (arg6 & 0x83) != 130 ? true : false;
        if(arg5.shouldExecute(v4, arg6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xEE9DDE35, arg6, -1, "androidx.compose.foundation.lazy.grid.LazyGridIntervalContent.item.<anonymous> (LazyGridIntervalContent.kt:55)");
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

    public void items(int arg4, Function1 arg5, Function2 arg6, Function1 arg7, Function4 arg8) {
        MutableIntervalList v0 = this.getIntervals();
        Function2 v2 = arg6 == null ? LazyGridIntervalContent.DefaultSpan : arg6;
        v0.addInterval(arg4, new LazyGridInterval(arg5, v2, arg7, arg8));
        if(arg6 != null) {
            this.hasCustomSpans = true;
        }
    }

    public final void setHasCustomSpans$foundation(boolean arg1) {
        this.hasCustomSpans = arg1;
    }

    public void stickyHeader(Object arg5, Object arg6, Function4 arg7) {
        MutableIntList v0 = this._headerIndexes;
        if(v0 == null) {
            v0 = new MutableIntList(0, 1, null);
            this._headerIndexes = v0;
        }

        int v2 = this.getIntervals().getSize();
        v0.add(v2);
        this.item(arg5, new LazyGridIntervalContent$$ExternalSyntheticLambda0(), arg6, ComposableLambdaKt.composableLambdaInstance(0x2C9FA4B, true, new LazyGridIntervalContent$$ExternalSyntheticLambda1(arg7, v2)));
    }

    static final GridItemSpan stickyHeader$lambda$1(LazyGridItemSpanScope arg2) {
        return GridItemSpan.box-impl(LazyGridSpanKt.GridItemSpan(arg2.getMaxLineSpan()));
    }

    static final Unit stickyHeader$lambda$2(Function4 arg3, int arg4, LazyGridItemScope arg5, Composer arg6, int arg7) {
        ComposerKt.sourceInformation(arg6, "C88@3043L25:LazyGridIntervalContent.kt#7791vq");
        if((arg7 & 6) == 0) {
            int v0 = arg6.changed(arg5) ? 4 : 2;
            arg7 |= v0;
        }

        boolean v0_1 = (arg7 & 19) != 18 ? true : false;
        if(arg6.shouldExecute(v0_1, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x2C9FA4B, arg7, -1, "androidx.compose.foundation.lazy.grid.LazyGridIntervalContent.stickyHeader.<anonymous> (LazyGridIntervalContent.kt:88)");
            }

            arg3.invoke(arg5, Integer.valueOf(arg4), arg6, Integer.valueOf(arg7 & 14));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_34;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_34:
        return Unit.INSTANCE;
    }
}

