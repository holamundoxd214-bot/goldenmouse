package androidx.compose.foundation.lazy.grid;

import androidx.collection.IntList;
import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
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

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\rH\u0016J\u0012\u0010\u0013\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001A\u00020\rH\u0016J\u001D\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u001A\u001A\u00020\u0011H\u0017¢\u0006\u0002\u0010\u001BJ\u0010\u0010 \u001A\u00020\r2\u0006\u0010\u001A\u001A\u00020\u0011H\u0016J\u0013\u0010!\u001A\u00020\"2\b\u0010#\u001A\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010$\u001A\u00020\rH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001C\u001A\u00020\u001D8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001F¨\u0006%"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridItemProviderImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "intervalContent", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "itemCount", "", "getItemCount", "()I", "getKey", "", "index", "getContentType", "headerIndexes", "Landroidx/collection/IntList;", "getHeaderIndexes", "()Landroidx/collection/IntList;", "Item", "", "key", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getSpanLayoutProvider", "()Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getIndex", "equals", "", "other", "hashCode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazyGridItemProviderImpl implements LazyGridItemProvider {
    private final LazyGridIntervalContent intervalContent;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    private final LazyGridState state;

    public LazyGridItemProviderImpl(LazyGridState arg1, LazyGridIntervalContent arg2, LazyLayoutKeyIndexMap arg3) {
        super();
        this.state = arg1;
        this.intervalContent = arg2;
        this.keyIndexMap = arg3;
    }

    public void Item(int arg8, Object arg9, Composer arg10, int arg11) {
        Object v1_2;
        int v2;
        int v1;
        int v10;
        int v0 = 0x5905C824;
        Composer v5 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(Item)N(index,key)80@3057L162,80@3003L216:LazyGridItemProvider.kt#7791vq");
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
                ComposerKt.traceEventStart(v0, v10, -1, "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl.Item (LazyGridItemProvider.kt:79)");
            }

            v2 = arg8;
            v1_2 = arg9;
            LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(v1_2, v2, this.state.getPinnedItems$foundation(), ComposableLambdaKt.rememberComposableLambda(0x2B48C518, true, new LazyGridItemProviderImpl$$ExternalSyntheticLambda0(this, arg8), v5, 54), v5, v10 >> 3 & 14 | 0xC00 | v10 << 3 & 0x70);
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
            v8.updateScope(new LazyGridItemProviderImpl$$ExternalSyntheticLambda1(this, v2, v1_2, arg11));
        }
    }

    static final Unit Item$lambda$0(LazyGridItemProviderImpl arg3, int arg4, Composer arg5, int arg6) {
        ComposerKt.sourceInformation(arg5, "C*82@3156L39:LazyGridItemProvider.kt#7791vq");
        boolean v0 = (arg6 & 3) != 2 ? true : false;
        if(arg5.shouldExecute(v0, arg6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x2B48C518, arg6, -1, "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl.Item.<anonymous> (LazyGridItemProvider.kt:81)");
            }

            Interval v3 = arg3.intervalContent.getIntervals().get(arg4);
            v3.getValue().getItem().invoke(LazyGridItemScopeImpl.INSTANCE, Integer.valueOf(arg4 - v3.getStartIndex()), arg5, Integer.valueOf(6));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_34;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg5.skipToGroupEnd();
        }

    label_34:
        return Unit.INSTANCE;
    }

    static final Unit Item$lambda$1(LazyGridItemProviderImpl arg0, int arg1, Object arg2, int arg3, Composer arg4, int arg5) {
        arg0.Item(arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public boolean equals(Object arg2) {
        if(this == (((LazyGridItemProviderImpl)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof LazyGridItemProviderImpl)) {
            return 0;
        }

        return Intrinsics.areEqual(this.intervalContent, ((LazyGridItemProviderImpl)arg2).intervalContent);
    }

    public Object getContentType(int arg1) {
        return this.intervalContent.getContentType(arg1);
    }

    public IntList getHeaderIndexes() {
        return this.intervalContent.getHeaderIndexes();
    }

    public int getIndex(Object arg1) {
        return this.getKeyIndexMap().getIndex(arg1);
    }

    public int getItemCount() {
        return this.intervalContent.getItemCount();
    }

    public Object getKey(int arg2) {
        Object v0 = this.getKeyIndexMap().getKey(arg2);
        if(v0 == null) {
            return this.intervalContent.getKey(arg2);
        }

        return v0;
    }

    public LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.keyIndexMap;
    }

    public LazyGridSpanLayoutProvider getSpanLayoutProvider() {
        return this.intervalContent.getSpanLayoutProvider$foundation();
    }

    public int hashCode() {
        return this.intervalContent.hashCode();
    }
}

