package androidx.compose.foundation.lazy;

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

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u001D\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0018H\u0017¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u00182\u0006\u0010\u0016\u001A\u00020\u0011H\u0016J\u0012\u0010\u001B\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001A\u00020\u0011H\u0016J\u0010\u0010 \u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0018H\u0016J\u0013\u0010!\u001A\u00020\"2\b\u0010#\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010$\u001A\u00020\u0011H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\b\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u001C\u001A\u00020\u001D8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001F¨\u0006%"}, d2={"Landroidx/compose/foundation/lazy/LazyListItemProviderImpl;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "intervalContent", "Landroidx/compose/foundation/lazy/LazyListIntervalContent;", "itemScope", "Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "<init>", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListIntervalContent;Landroidx/compose/foundation/lazy/LazyItemScopeImpl;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "getItemScope", "()Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "itemCount", "", "getItemCount", "()I", "Item", "", "index", "key", "", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "getKey", "getContentType", "headerIndexes", "Landroidx/collection/IntList;", "getHeaderIndexes", "()Landroidx/collection/IntList;", "getIndex", "equals", "", "other", "hashCode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazyListItemProviderImpl implements LazyListItemProvider {
    private final LazyListIntervalContent intervalContent;
    private final LazyItemScopeImpl itemScope;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    private final LazyListState state;

    public LazyListItemProviderImpl(LazyListState arg1, LazyListIntervalContent arg2, LazyItemScopeImpl arg3, LazyLayoutKeyIndexMap arg4) {
        super();
        this.state = arg1;
        this.intervalContent = arg2;
        this.itemScope = arg3;
        this.keyIndexMap = arg4;
    }

    public void Item(int arg8, Object arg9, Composer arg10, int arg11) {
        Object v1_2;
        int v2;
        int v1;
        int v10;
        int v0 = 0xE46FF536;
        Composer v5 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(Item)N(index,key)77@2960L150,77@2906L204:LazyListItemProvider.kt#428nma");
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
                ComposerKt.traceEventStart(v0, v10, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:76)");
            }

            v2 = arg8;
            v1_2 = arg9;
            LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(v1_2, v2, this.state.getPinnedItems$foundation(), ComposableLambdaKt.rememberComposableLambda(0xCED7AFC2, true, new LazyListItemProviderImpl$$ExternalSyntheticLambda0(this, arg8), v5, 54), v5, v10 >> 3 & 14 | 0xC00 | v10 << 3 & 0x70);
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
            v8.updateScope(new LazyListItemProviderImpl$$ExternalSyntheticLambda1(this, v2, v1_2, arg11));
        }
    }

    static final Unit Item$lambda$0(LazyListItemProviderImpl arg4, int arg5, Composer arg6, int arg7) {
        ComposerKt.sourceInformation(arg6, "C*79@3059L27:LazyListItemProvider.kt#428nma");
        boolean v0 = (arg7 & 3) != 2 ? true : false;
        if(arg6.shouldExecute(v0, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xCED7AFC2, arg7, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item.<anonymous> (LazyListItemProvider.kt:78)");
            }

            Interval v7 = arg4.intervalContent.getIntervals().get(arg5);
            v7.getValue().getItem().invoke(arg4.getItemScope(), Integer.valueOf(arg5 - v7.getStartIndex()), arg6, Integer.valueOf(0));
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

    static final Unit Item$lambda$1(LazyListItemProviderImpl arg0, int arg1, Object arg2, int arg3, Composer arg4, int arg5) {
        arg0.Item(arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public boolean equals(Object arg2) {
        if(this == (((LazyListItemProviderImpl)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof LazyListItemProviderImpl)) {
            return 0;
        }

        return Intrinsics.areEqual(this.intervalContent, ((LazyListItemProviderImpl)arg2).intervalContent);
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

    public LazyItemScopeImpl getItemScope() {
        return this.itemScope;
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

    public int hashCode() {
        return this.intervalContent.hashCode();
    }
}

