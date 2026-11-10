package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMap;
import androidx.collection.LongIntMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\u0016\u0010\u000B\u001A\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\b\u0010%\u001A\u0004\u0018\u00010&JN\u0010\'\u001A\u00020 2\u0006\u0010(\u001A\u00020\r2\u0006\u0010)\u001A\u00020\"2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020+2\u0006\u0010-\u001A\u00020\"2\u0006\u0010.\u001A\u00020+2\u0006\u0010/\u001A\u00020+2\u0006\u00100\u001A\u00020\"2\u0006\u00101\u001A\u000202J \u00103\u001A\u00020\"2\u0006\u00104\u001A\u00020\"2\u0006\u00105\u001A\u00020+2\u0006\u00106\u001A\u00020+H\u0002R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\u0017R\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R!\u0010\u000B\u001A\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020 0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\"X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00067"}, d2={"Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "", "currentPosition", "Landroidx/compose/ui/geometry/Offset;", "previousHandlePosition", "containerCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "isStartHandle", "", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "<init>", "(JJLandroidx/compose/ui/layout/LayoutCoordinates;ZLandroidx/compose/foundation/text/selection/Selection;Ljava/util/Comparator;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCurrentPosition-F1C5BW0", "()J", "J", "getPreviousHandlePosition-F1C5BW0", "getContainerCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "()Z", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "getSelectableIdOrderingComparator", "()Ljava/util/Comparator;", "selectableIdToInfoListIndex", "Landroidx/collection/MutableLongIntMap;", "infoList", "", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "startSlot", "", "endSlot", "currentSlot", "build", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "appendInfo", "selectableId", "rawStartHandleOffset", "startXHandleDirection", "Landroidx/compose/foundation/text/selection/Direction;", "startYHandleDirection", "rawEndHandleOffset", "endXHandleDirection", "endYHandleDirection", "rawPreviousHandleOffset", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "updateSlot", "slot", "xPositionDirection", "yPositionDirection", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SelectionLayoutBuilder {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Direction.values().length];
            try {
                v0[Direction.BEFORE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Direction.ON.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Direction.AFTER.ordinal()] = 3;
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

    public static final int $stable = 8;
    private final LayoutCoordinates containerCoordinates;
    private final long currentPosition;
    private int currentSlot;
    private int endSlot;
    private final List infoList;
    private final boolean isStartHandle;
    private final long previousHandlePosition;
    private final Selection previousSelection;
    private final Comparator selectableIdOrderingComparator;
    private final MutableLongIntMap selectableIdToInfoListIndex;
    private int startSlot;

    static {
    }

    private SelectionLayoutBuilder(long arg1, long arg3, LayoutCoordinates arg5, boolean arg6, Selection arg7, Comparator arg8) {
        super();
        this.currentPosition = arg1;
        this.previousHandlePosition = arg3;
        this.containerCoordinates = arg5;
        this.isStartHandle = arg6;
        this.previousSelection = arg7;
        this.selectableIdOrderingComparator = arg8;
        this.selectableIdToInfoListIndex = LongIntMapKt.mutableLongIntMapOf();
        this.infoList = new ArrayList();
        this.startSlot = -1;
        this.endSlot = -1;
        this.currentSlot = -1;
    }

    public SelectionLayoutBuilder(long arg1, long arg3, LayoutCoordinates arg5, boolean arg6, Selection arg7, Comparator arg8, DefaultConstructorMarker arg9) {
        this(arg1, arg3, arg5, arg6, arg7, arg8);
    }

    public final SelectableInfo appendInfo(long arg10, int arg12, Direction arg13, Direction arg14, int arg15, Direction arg16, Direction arg17, int arg18, TextLayoutResult arg19) {
        this.currentSlot += 2;
        SelectableInfo v1 = new SelectableInfo(arg10, this.currentSlot, arg12, arg15, arg18, arg19);
        this.startSlot = this.updateSlot(this.startSlot, arg13, arg14);
        this.endSlot = this.updateSlot(this.endSlot, arg16, arg17);
        this.selectableIdToInfoListIndex.set(arg10, this.infoList.size());
        this.infoList.add(v1);
        return v1;
    }

    public final SelectionLayout build() {
        int v7;
        int v1;
        int v0 = this.currentSlot + 1;
        int v2 = this.infoList.size();
        if(v2 != 0) {
            int v3 = -1;
            if(v2 != 1) {
                MutableLongIntMap v5 = this.selectableIdToInfoListIndex;
                List v6 = this.infoList;
                v1 = this.startSlot;
                v7 = v1 == v3 ? v0 : v1;
                v1 = this.endSlot;
                int v8 = v1 == v3 ? v0 : v1;
                return new MultiSelectionLayout(((LongIntMap)v5), v6, v7, v8, this.isStartHandle, this.previousSelection);
            }

            Object v9 = CollectionsKt.single(this.infoList);
            v1 = this.startSlot;
            int v6_1 = v1 == v3 ? v0 : v1;
            v1 = this.endSlot;
            v7 = v1 == v3 ? v0 : v1;
            return new SingleSelectionLayout(this.isStartHandle, v6_1, v7, this.previousSelection, ((SelectableInfo)v9));
        }

        return null;
    }

    public final LayoutCoordinates getContainerCoordinates() {
        return this.containerCoordinates;
    }

    public final long getCurrentPosition-F1C5BW0() {
        return this.currentPosition;
    }

    public final long getPreviousHandlePosition-F1C5BW0() {
        return this.previousHandlePosition;
    }

    public final Selection getPreviousSelection() {
        return this.previousSelection;
    }

    public final Comparator getSelectableIdOrderingComparator() {
        return this.selectableIdOrderingComparator;
    }

    public final boolean isStartHandle() {
        return this.isStartHandle;
    }

    private final int updateSlot(int arg2, Direction arg3, Direction arg4) {
        if(arg2 != -1) {
        }
        else {
            int v3 = WhenMappings.$EnumSwitchMapping$0[SelectionLayoutKt.resolve2dDirection(arg3, arg4).ordinal()];
            if(v3 == 1) {
                goto label_19;
            }
            else if(v3 != 2) {
                if(v3 == 3) {
                    return arg2;
                }

                goto label_14;
            }
            else {
                goto label_17;
            }
        }

        return arg2;
    label_14:
        throw new NoWhenBranchMatchedException();
    label_17:
        return this.currentSlot;
    label_19:
        return this.currentSlot - 1;
    }
}

