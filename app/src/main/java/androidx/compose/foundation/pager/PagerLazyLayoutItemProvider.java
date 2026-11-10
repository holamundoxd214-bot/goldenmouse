package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001D\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0013\u001A\u00020\u000EH\u0016J\u0010\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u001C\u001A\u00020\u000EH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/pager/PagerIntervalContent;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "<init>", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "pagerScopeImpl", "Landroidx/compose/foundation/pager/PagerScopeImpl;", "itemCount", "", "getItemCount", "()I", "Item", "", "index", "key", "", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "getKey", "getIndex", "equals", "", "other", "hashCode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PagerLazyLayoutItemProvider implements LazyLayoutItemProvider {
    public static final int $stable;
    private final LazyLayoutIntervalContent intervalContent;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    private final PagerScopeImpl pagerScopeImpl;
    private final PagerState state;

    static {
    }

    public PagerLazyLayoutItemProvider(PagerState arg1, LazyLayoutIntervalContent arg2, LazyLayoutKeyIndexMap arg3) {
        super();
        this.state = arg1;
        this.intervalContent = arg2;
        this.keyIndexMap = arg3;
        this.pagerScopeImpl = PagerScopeImpl.INSTANCE;
    }

    public void Item(int arg8, Object arg9, Composer arg10, int arg11) {
        Object v1_2;
        int v2;
        int v1;
        int v10;
        int v0 = -1201380429;
        Composer v5 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(Item)N(index,key)209@9044L155,209@8990L209:LazyLayoutPager.kt#g6yjnt");
        if((arg11 & 6) == 0) {
            v10 = v5.changed(arg8) ? 4 : 2;
            v10 |= arg11;
        }
        else {
            v10 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v1 = v5.changedInstance(arg9) ? 0x20 : 16;
            v10 |= v1;
        }

        if((arg11 & 0x180) == 0) {
            v1 = v5.changed(this) ? 0x100 : 0x80;
            v10 |= v1;
        }

        boolean v1_1 = (v10 & 0x93) != 0x92 ? true : false;
        if(v5.shouldExecute(v1_1, v10 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v10, -1, "androidx.compose.foundation.pager.PagerLazyLayoutItemProvider.Item (LazyLayoutPager.kt:208)");
            }

            v2 = arg8;
            v1_2 = arg9;
            LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(v1_2, v2, this.state.getPinnedPages$foundation(), ComposableLambdaKt.rememberComposableLambda(1142237095, true, new PagerLazyLayoutItemProvider$$ExternalSyntheticLambda0(this, arg8), v5, 54), v5, v10 >> 3 & 14 | 0xC00 | v10 << 3 & 0x70);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_70;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v2 = arg8;
            v1_2 = arg9;
            v5.skipToGroupEnd();
        }

    label_70:
        ScopeUpdateScope v8 = v5.endRestartGroup();
        if(v8 != null) {
            v8.updateScope(new PagerLazyLayoutItemProvider$$ExternalSyntheticLambda1(this, v2, v1_2, arg11));
        }
    }

    static final Unit Item$lambda$0(PagerLazyLayoutItemProvider arg4, int arg5, Composer arg6, int arg7) {
        ComposerKt.sourceInformation(arg6, "C*211@9143L32:LazyLayoutPager.kt#g6yjnt");
        boolean v0 = (arg7 & 3) != 2 ? true : false;
        if(arg6.shouldExecute(v0, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1142237095, arg7, -1, "androidx.compose.foundation.pager.PagerLazyLayoutItemProvider.Item.<anonymous> (LazyLayoutPager.kt:210)");
            }

            Interval v7 = arg4.intervalContent.getIntervals().get(arg5);
            v7.getValue().getItem().invoke(arg4.pagerScopeImpl, Integer.valueOf(arg5 - v7.getStartIndex()), arg6, Integer.valueOf(0));
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

    static final Unit Item$lambda$1(PagerLazyLayoutItemProvider arg0, int arg1, Object arg2, int arg3, Composer arg4, int arg5) {
        arg0.Item(arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public boolean equals(Object arg2) {
        if(this == (((PagerLazyLayoutItemProvider)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof PagerLazyLayoutItemProvider)) {
            return 0;
        }

        return Intrinsics.areEqual(this.intervalContent, ((PagerLazyLayoutItemProvider)arg2).intervalContent);
    }

    public int getIndex(Object arg1) {
        return this.keyIndexMap.getIndex(arg1);
    }

    public int getItemCount() {
        return this.intervalContent.getItemCount();
    }

    public Object getKey(int arg2) {
        Object v0 = this.keyIndexMap.getKey(arg2);
        if(v0 == null) {
            return this.intervalContent.getKey(arg2);
        }

        return v0;
    }

    public int hashCode() {
        return this.intervalContent.hashCode();
    }
}

