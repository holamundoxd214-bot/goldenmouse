package androidx.compose.foundation.lazy;

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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B \u0012\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u0092\u0001\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u00162#\u0010\u0017\u001A\u001F\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001A\u0012\u0004\u0012\u00020\u001B\u0018\u00010\u00052#\u0010\u001C\u001A\u001F\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001A\u0012\u0006\u0012\u0004\u0018\u00010\u001B0\u000521\u0010\u001D\u001A-\u0012\u0004\u0012\u00020\u001F\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001A\u0012\u0004\u0012\u00020\u00060\u001E¢\u0006\u0002\b ¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010!J?\u0010\"\u001A\u00020\u00062\b\u0010\u0017\u001A\u0004\u0018\u00010\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\u001C\u0010\u0004\u001A\u0018\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b ¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010#JE\u0010$\u001A\u00020\u00062\b\u0010\u0017\u001A\u0004\u0018\u00010\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\"\u0010\u0004\u001A\u001E\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u001E¢\u0006\u0002\b ¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010%R\u001A\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2={"Landroidx/compose/foundation/lazy/LazyListIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/LazyListInterval;", "Landroidx/compose/foundation/lazy/LazyListScope;", "content", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "_headerIndexes", "Landroidx/collection/MutableIntList;", "headerIndexes", "Landroidx/collection/IntList;", "getHeaderIndexes", "()Landroidx/collection/IntList;", "items", "count", "", "key", "Lkotlin/ParameterName;", "name", "index", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "item", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "stickyHeader", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyListIntervalContent extends LazyLayoutIntervalContent implements LazyListScope {
    public static final int $stable = 8;
    private MutableIntList _headerIndexes;
    private final MutableIntervalList intervals;

    static {
    }

    public LazyListIntervalContent(Function1 arg2) {
        super();
        this.intervals = new MutableIntervalList();
        arg2.invoke(this);
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

    public void item(Object arg4, Object arg5, Function3 arg6) {
        Function1 v1_1;
        MutableIntervalList v3 = this.getIntervals();
        if(arg4 != null) {
            LazyListIntervalContent$$ExternalSyntheticLambda0 v1 = new LazyListIntervalContent$$ExternalSyntheticLambda0(arg4);
        }
        else {
            v1_1 = null;
        }

        v3.addInterval(1, new LazyListInterval(v1_1, new LazyListIntervalContent$$ExternalSyntheticLambda1(arg5), ComposableLambdaKt.composableLambdaInstance(0xCCE40D79, true, new LazyListIntervalContent$$ExternalSyntheticLambda2(arg6))));
    }

    static final Object item$lambda$0(Object arg0, int arg1) {
        return arg0;
    }

    static final Object item$lambda$1(Object arg0, int arg1) {
        return arg0;
    }

    static final Unit item$lambda$2(Function3 arg2, LazyItemScope arg3, int arg4, Composer arg5, int arg6) {
        ComposerKt.sourceInformation(arg5, "CN(it)56@2074L9:LazyListIntervalContent.kt#428nma");
        if((arg6 & 6) == 0) {
            arg4 = arg5.changed(arg3) ? 4 : 2;
            arg6 |= arg4;
        }

        boolean v4 = (arg6 & 0x83) != 130 ? true : false;
        if(arg5.shouldExecute(v4, arg6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xCCE40D79, arg6, -1, "androidx.compose.foundation.lazy.LazyListIntervalContent.item.<anonymous> (LazyListIntervalContent.kt:56)");
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

    public void items(int arg2, Function1 arg3, Function1 arg4, Function4 arg5) {
        this.getIntervals().addInterval(arg2, new LazyListInterval(arg3, arg4, arg5));
    }

    public void stickyHeader(Object arg5, Object arg6, Function4 arg7) {
        MutableIntList v0 = this._headerIndexes;
        if(v0 == null) {
            v0 = new MutableIntList(0, 1, null);
            this._headerIndexes = v0;
        }

        v0.add(this.getIntervals().getSize());
        this.item(arg5, arg6, ComposableLambdaKt.composableLambdaInstance(-1588696110, true, new LazyListIntervalContent$$ExternalSyntheticLambda3(arg7, this.getIntervals().getSize())));
    }

    static final Unit stickyHeader$lambda$1(Function4 arg3, int arg4, LazyItemScope arg5, Composer arg6, int arg7) {
        ComposerKt.sourceInformation(arg6, "C70@2475L20:LazyListIntervalContent.kt#428nma");
        if((arg7 & 6) == 0) {
            int v0 = arg6.changed(arg5) ? 4 : 2;
            arg7 |= v0;
        }

        boolean v0_1 = (arg7 & 19) != 18 ? true : false;
        if(arg6.shouldExecute(v0_1, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1588696110, arg7, -1, "androidx.compose.foundation.lazy.LazyListIntervalContent.stickyHeader.<anonymous> (LazyListIntervalContent.kt:70)");
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

