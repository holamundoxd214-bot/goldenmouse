package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMap;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u001C\u0010+\u001A\u00020,2\u0012\u0010-\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,0.H\u0016J\u0012\u0010/\u001A\u00020\u000B2\b\u00100\u001A\u0004\u0018\u00010\u0001H\u0016J\u0010\u00101\u001A\u00020\u000B2\u0006\u00100\u001A\u00020\u0000H\u0002J\u0016\u00102\u001A\b\u0012\u0004\u0012\u00020\r032\u0006\u00104\u001A\u00020\rH\u0016J2\u00105\u001A\u00020,*\b\u0012\u0004\u0012\u00020\r062\u0006\u00104\u001A\u00020\r2\u0006\u00107\u001A\u00020\u00062\u0006\u00108\u001A\u00020\b2\u0006\u00109\u001A\u00020\bH\u0002J\b\u0010:\u001A\u00020;H\u0016J\u0018\u0010<\u001A\u00020\b2\u0006\u0010=\u001A\u00020\b2\u0006\u0010>\u001A\u00020\u000BH\u0002J\u0018\u0010?\u001A\u00020\b2\u0006\u0010=\u001A\u00020\b2\u0006\u0010@\u001A\u00020\u000BH\u0002J\u0010\u0010A\u001A\u00020\b2\u0006\u0010B\u001A\u00020CH\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\t\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0015R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u0017R\u0016\u0010\f\u001A\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0015R\u0014\u0010\u001C\u001A\u00020\u001D8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b$\u0010\"R\u0014\u0010%\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b&\u0010\"R\u0014\u0010\'\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b(\u0010\"R\u0014\u0010)\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b*\u0010\"¨\u0006D"}, d2={"Landroidx/compose/foundation/text/selection/MultiSelectionLayout;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "selectableIdToInfoListIndex", "Landroidx/collection/LongIntMap;", "infoList", "", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "startSlot", "", "endSlot", "isStartHandle", "", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "<init>", "(Landroidx/collection/LongIntMap;Ljava/util/List;IIZLandroidx/compose/foundation/text/selection/Selection;)V", "getSelectableIdToInfoListIndex", "()Landroidx/collection/LongIntMap;", "getInfoList", "()Ljava/util/List;", "getStartSlot", "()I", "getEndSlot", "()Z", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "size", "getSize", "crossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "startInfo", "getStartInfo", "()Landroidx/compose/foundation/text/selection/SelectableInfo;", "endInfo", "getEndInfo", "currentInfo", "getCurrentInfo", "firstInfo", "getFirstInfo", "lastInfo", "getLastInfo", "forEachMiddleInfo", "", "block", "Lkotlin/Function1;", "shouldRecomputeSelection", "other", "shouldAnyInfoRecomputeSelection", "createSubSelections", "Landroidx/collection/LongObjectMap;", "selection", "createAndPutSubSelection", "Landroidx/collection/MutableLongObjectMap;", "info", "minOffset", "maxOffset", "toString", "", "startOrEndSlotToIndex", "slot", "isStartSlot", "slotToIndex", "isMinimumSlot", "getInfoListIndexBySelectableId", "id", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class MultiSelectionLayout implements SelectionLayout {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[CrossStatus.values().length];
            try {
                v0[CrossStatus.COLLAPSED.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[CrossStatus.NOT_CROSSED.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[CrossStatus.CROSSED.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    private final int endSlot;
    private final List infoList;
    private final boolean isStartHandle;
    private final Selection previousSelection;
    private final LongIntMap selectableIdToInfoListIndex;
    private final int startSlot;

    public static Unit $r8$lambda$pajnAe26Gsbv6PeF8wRLc1rNhPY(MultiSelectionLayout arg0, MutableLongObjectMap arg1, Selection arg2, SelectableInfo arg3) {
        return MultiSelectionLayout.createSubSelections$lambda$1$1(arg0, arg1, arg2, arg3);
    }

    public MultiSelectionLayout(LongIntMap arg1, List arg2, int arg3, int arg4, boolean arg5, Selection arg6) {
        super();
        this.selectableIdToInfoListIndex = arg1;
        this.infoList = arg2;
        this.startSlot = arg3;
        this.endSlot = arg4;
        this.isStartHandle = arg5;
        this.previousSelection = arg6;
        int v1 = 1;
        if(arg2.size() > 1) {
        }
        else {
            v1 = 0;
        }

        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalStateException("MultiSelectionLayout requires an infoList size greater than 1, was " + arg2.size() + '.');
        }
    }

    private final void createAndPutSubSelection(MutableLongObjectMap arg1, Selection arg2, SelectableInfo arg3, int arg4, int arg5) {
        Selection v0 = arg2.getHandlesCrossed() ? arg3.makeSingleLayoutSelection(arg5, arg4) : arg3.makeSingleLayoutSelection(arg4, arg5);
        int v2 = arg4 <= arg5 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalStateException("minOffset should be less than or equal to maxOffset: " + v0);
        }

        arg1.put(arg3.getSelectableId(), v0);
    }

    public LongObjectMap createSubSelections(Selection arg7) {
        int v6;
        if(arg7.getStart().getSelectableId() == arg7.getEnd().getSelectableId()) {
            if(!arg7.getHandlesCrossed() || arg7.getStart().getOffset() < arg7.getEnd().getOffset()) {
                if(!arg7.getHandlesCrossed() && arg7.getStart().getOffset() <= arg7.getEnd().getOffset()) {
                label_19:
                    v6 = 1;
                    goto label_22;
                }

                v6 = 0;
            }
            else {
                goto label_19;
            }

        label_22:
            if(v6 == 0) {
                InlineClassHelperKt.throwIllegalStateException("unexpectedly miss-crossed selection: " + arg7);
            }

            return LongObjectMapKt.longObjectMapOf(arg7.getStart().getSelectableId(), arg7);
        }

        MutableLongObjectMap v1 = LongObjectMapKt.mutableLongObjectMapOf();
        AnchorInfo v0 = arg7.getHandlesCrossed() ? arg7.getEnd() : arg7.getStart();
        SelectableInfo v3 = this.getFirstInfo();
        int v4 = v0.getOffset();
        MultiSelectionLayout v0_1 = this;
        Selection v2 = arg7;
        v0_1.createAndPutSubSelection(v1, v2, v3, v4, this.getFirstInfo().getTextLength());
        v0_1.forEachMiddleInfo(new MultiSelectionLayout$$ExternalSyntheticLambda0(v0_1, v1, v2));
        AnchorInfo v6_1 = v2.getHandlesCrossed() ? v2.getStart() : v2.getEnd();
        v0_1.createAndPutSubSelection(v1, v2, v0_1.getLastInfo(), 0, v6_1.getOffset());
        return ((LongObjectMap)v1);
    }

    private static final Unit createSubSelections$lambda$1$1(MultiSelectionLayout arg6, MutableLongObjectMap arg7, Selection arg8, SelectableInfo arg9) {
        arg6.createAndPutSubSelection(arg7, arg8, arg9, 0, arg9.getTextLength());
        return Unit.INSTANCE;
    }

    public void forEachMiddleInfo(Function1 arg4) {
        int v0 = this.getInfoListIndexBySelectableId(this.getFirstInfo().getSelectableId());
        int v1 = this.getInfoListIndexBySelectableId(this.getLastInfo().getSelectableId());
        ++v0;
        if(v0 >= v1) {
        }
        else {
            while(v0 < v1) {
                arg4.invoke(this.infoList.get(v0));
                ++v0;
            }
        }
    }

    public CrossStatus getCrossStatus() {
        if(this.getStartSlot() < this.getEndSlot()) {
            return CrossStatus.NOT_CROSSED;
        }

        if(this.getStartSlot() > this.getEndSlot()) {
            return CrossStatus.CROSSED;
        }

        return this.infoList.get(this.getStartSlot() / 2).getRawCrossStatus();
    }

    public SelectableInfo getCurrentInfo() {
        if(this.isStartHandle()) {
            return this.getStartInfo();
        }

        return this.getEndInfo();
    }

    public SelectableInfo getEndInfo() {
        return this.infoList.get(this.startOrEndSlotToIndex(this.getEndSlot(), false));
    }

    public int getEndSlot() {
        return this.endSlot;
    }

    public SelectableInfo getFirstInfo() {
        if(this.getCrossStatus() == CrossStatus.CROSSED) {
            return this.getEndInfo();
        }

        return this.getStartInfo();
    }

    public final List getInfoList() {
        return this.infoList;
    }

    private final int getInfoListIndexBySelectableId(long arg4) {
        try {
            return this.selectableIdToInfoListIndex.get(arg4);
        }
        catch(NoSuchElementException v3) {
            throw new IllegalStateException("Invalid selectableId: " + arg4, ((Throwable)v3));
        }
    }

    public SelectableInfo getLastInfo() {
        if(this.getCrossStatus() == CrossStatus.CROSSED) {
            return this.getStartInfo();
        }

        return this.getEndInfo();
    }

    public Selection getPreviousSelection() {
        return this.previousSelection;
    }

    public final LongIntMap getSelectableIdToInfoListIndex() {
        return this.selectableIdToInfoListIndex;
    }

    public int getSize() {
        return this.infoList.size();
    }

    public SelectableInfo getStartInfo() {
        return this.infoList.get(this.startOrEndSlotToIndex(this.getStartSlot(), true));
    }

    public int getStartSlot() {
        return this.startSlot;
    }

    public boolean isStartHandle() {
        return this.isStartHandle;
    }

    private final boolean shouldAnyInfoRecomputeSelection(MultiSelectionLayout arg7) {
        if(this.getSize() != arg7.getSize()) {
            return 1;
        }

        int v0 = this.infoList.size();
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            if(this.infoList.get(v3).shouldRecomputeSelection(arg7.infoList.get(v3))) {
                return 1;
            }
        }

        return 0;
    }

    public boolean shouldRecomputeSelection(SelectionLayout arg3) {
        if(this.getPreviousSelection() != null && arg3 != null && ((arg3 instanceof MultiSelectionLayout)) && this.isStartHandle() == ((MultiSelectionLayout)arg3).isStartHandle() && this.getStartSlot() == ((MultiSelectionLayout)arg3).getStartSlot() && this.getEndSlot() == ((MultiSelectionLayout)arg3).getEndSlot()) {
            if(this.shouldAnyInfoRecomputeSelection(((MultiSelectionLayout)arg3))) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final int slotToIndex(int arg1, boolean arg2) {
        return (arg1 - ((((int)arg2)) ^ 1)) / 2;
    }

    private final int startOrEndSlotToIndex(int arg4, boolean arg5) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[this.getCrossStatus().ordinal()];
        if(v0 == 1) {
        label_17:
            arg5 = true;
        }
        else if(v0 != 2) {
            if(v0 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            else if(!arg5) {
                goto label_17;
            }
            else {
                arg5 = false;
            }
        }

        return this.slotToIndex(arg4, arg5);
    }

    public String toString() {
        int v2 = 1;
        StringBuilder v0 = new StringBuilder("MultiSelectionLayout(isStartHandle=").append(this.isStartHandle()).append(", startPosition=").append((((float)(this.getStartSlot() + 1))) / 2f).append(", endPosition=").append((((float)(this.getEndSlot() + 1))) / 2f).append(", crossed=").append(this.getCrossStatus()).append(", infos=");
        StringBuilder v1 = new StringBuilder("[\n\t");
        List v9 = this.infoList;
        int v3 = v9.size();
        int v5 = 0;
        while(v5 < v3) {
            Object v6 = v9.get(v5);
            if(v2 != 0) {
                v2 = 0;
            }
            else {
                v1.append(",\n\t");
            }

            ++v5;
            v1.append(v5 + " -> " + v6);
        }

        v1.append("\n]");
        String v9_1 = v1.toString();
        Intrinsics.checkNotNullExpressionValue(v9_1, "toString(...)");
        return v0.append(v9_1).append(')').toString();
    }
}

