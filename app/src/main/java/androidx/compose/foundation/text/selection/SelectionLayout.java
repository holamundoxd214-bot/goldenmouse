package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001C\u0010\u001A\u001A\u00020\u001B2\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u001B0\u001DH&J\u0012\u0010%\u001A\u00020\u001F2\b\u0010&\u001A\u0004\u0018\u00010\u0000H&J\u0016\u0010\'\u001A\b\u0012\u0004\u0012\u00020\"0(2\u0006\u0010)\u001A\u00020\"H&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0012\u0010\u000E\u001A\u00020\u000FX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001A\u00020\u000FX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001A\u00020\u000FX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0011R\u0012\u0010\u0016\u001A\u00020\u000FX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0011R\u0012\u0010\u0018\u001A\u00020\u000FX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0011R\u0012\u0010\u001E\u001A\u00020\u001FX¦\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010 R\u0014\u0010!\u001A\u0004\u0018\u00010\"X¦\u0004¢\u0006\u0006\u001A\u0004\b#\u0010$ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0001"}, d2={"Landroidx/compose/foundation/text/selection/SelectionLayout;", "", "size", "", "getSize", "()I", "startSlot", "getStartSlot", "endSlot", "getEndSlot", "crossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "startInfo", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "getStartInfo", "()Landroidx/compose/foundation/text/selection/SelectableInfo;", "endInfo", "getEndInfo", "currentInfo", "getCurrentInfo", "firstInfo", "getFirstInfo", "lastInfo", "getLastInfo", "forEachMiddleInfo", "", "block", "Lkotlin/Function1;", "isStartHandle", "", "()Z", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "shouldRecomputeSelection", "other", "createSubSelections", "Landroidx/collection/LongObjectMap;", "selection", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SelectionLayout {
    LongObjectMap createSubSelections(Selection arg1);

    void forEachMiddleInfo(Function1 arg1);

    CrossStatus getCrossStatus();

    SelectableInfo getCurrentInfo();

    SelectableInfo getEndInfo();

    int getEndSlot();

    SelectableInfo getFirstInfo();

    SelectableInfo getLastInfo();

    Selection getPreviousSelection();

    int getSize();

    SelectableInfo getStartInfo();

    int getStartSlot();

    boolean isStartHandle();

    boolean shouldRecomputeSelection(SelectionLayout arg1);
}

