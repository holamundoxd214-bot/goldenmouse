package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B1\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\u001C\u0010$\u001A\u00020%2\u0012\u0010&\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0\'H\u0016J\u0012\u0010(\u001A\u00020\u00032\b\u0010)\u001A\u0004\u0018\u00010\u0001H\u0016J\u0016\u0010*\u001A\b\u0012\u0004\u0012\u00020\b0+2\u0006\u0010,\u001A\u00020\bH\u0016J\b\u0010-\u001A\u00020.H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\rR\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0006\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0016\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u000FR\u0014\u0010\u0015\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001BR\u0014\u0010\u001E\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u001BR\u0014\u0010 \u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u001BR\u0014\u0010\"\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u001B¨\u00060"}, d2={"Landroidx/compose/foundation/text/selection/SingleSelectionLayout;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "isStartHandle", "", "startSlot", "", "endSlot", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "info", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "<init>", "(ZIILandroidx/compose/foundation/text/selection/Selection;Landroidx/compose/foundation/text/selection/SelectableInfo;)V", "()Z", "getStartSlot", "()I", "getEndSlot", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "size", "getSize", "crossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "startInfo", "getStartInfo", "()Landroidx/compose/foundation/text/selection/SelectableInfo;", "endInfo", "getEndInfo", "currentInfo", "getCurrentInfo", "firstInfo", "getFirstInfo", "lastInfo", "getLastInfo", "forEachMiddleInfo", "", "block", "Lkotlin/Function1;", "shouldRecomputeSelection", "other", "createSubSelections", "Landroidx/collection/LongObjectMap;", "selection", "toString", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class SingleSelectionLayout implements SelectionLayout {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/compose/foundation/text/selection/SingleSelectionLayout$Companion;", "", "<init>", "()V", "DEFAULT_SLOT", "", "DEFAULT_SELECTABLE_ID", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    public static final long DEFAULT_SELECTABLE_ID = 1;
    public static final int DEFAULT_SLOT = 1;
    private final int endSlot;
    private final SelectableInfo info;
    private final boolean isStartHandle;
    private final Selection previousSelection;
    private final int startSlot;

    static {
        SingleSelectionLayout.Companion = new Companion(null);
    }

    public SingleSelectionLayout(boolean arg1, int arg2, int arg3, Selection arg4, SelectableInfo arg5) {
        super();
        this.isStartHandle = arg1;
        this.startSlot = arg2;
        this.endSlot = arg3;
        this.previousSelection = arg4;
        this.info = arg5;
    }

    public LongObjectMap createSubSelections(Selection arg8) {
        if((arg8.getHandlesCrossed()) || arg8.getStart().getOffset() <= arg8.getEnd().getOffset()) {
            if((arg8.getHandlesCrossed()) && arg8.getStart().getOffset() <= arg8.getEnd().getOffset()) {
            label_14:
                arg8 = Selection.copy$default(arg8, null, null, arg8.getHandlesCrossed() ^ 1, 3, null);
                goto label_25;
            }

            arg8 = arg8;
        }
        else {
            goto label_14;
        }

    label_25:
        return LongObjectMapKt.longObjectMapOf(this.info.getSelectableId(), arg8);
    }

    public void forEachMiddleInfo(Function1 arg1) {
    }

    public CrossStatus getCrossStatus() {
        if(this.getStartSlot() < this.getEndSlot()) {
            return CrossStatus.NOT_CROSSED;
        }

        if(this.getStartSlot() > this.getEndSlot()) {
            return CrossStatus.CROSSED;
        }

        return this.info.getRawCrossStatus();
    }

    public SelectableInfo getCurrentInfo() {
        return this.info;
    }

    public SelectableInfo getEndInfo() {
        return this.info;
    }

    public int getEndSlot() {
        return this.endSlot;
    }

    public SelectableInfo getFirstInfo() {
        return this.info;
    }

    public SelectableInfo getLastInfo() {
        return this.info;
    }

    public Selection getPreviousSelection() {
        return this.previousSelection;
    }

    public int getSize() {
        return 1;
    }

    public SelectableInfo getStartInfo() {
        return this.info;
    }

    public int getStartSlot() {
        return this.startSlot;
    }

    public boolean isStartHandle() {
        return this.isStartHandle;
    }

    public boolean shouldRecomputeSelection(SelectionLayout arg3) {
        if(this.getPreviousSelection() != null && arg3 != null && ((arg3 instanceof SingleSelectionLayout)) && this.getStartSlot() == ((SingleSelectionLayout)arg3).getStartSlot() && this.getEndSlot() == ((SingleSelectionLayout)arg3).getEndSlot() && this.isStartHandle() == ((SingleSelectionLayout)arg3).isStartHandle()) {
            if(this.info.shouldRecomputeSelection(((SingleSelectionLayout)arg3).info)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public String toString() {
        return "SingleSelectionLayout(isStartHandle=" + this.isStartHandle() + ", crossed=" + this.getCrossStatus() + ", info=\n\t" + this.info + ')';
    }
}

