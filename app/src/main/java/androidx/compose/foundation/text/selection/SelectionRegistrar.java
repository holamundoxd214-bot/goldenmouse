package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\r\b`\u0018\u0000 $2\u00020\u0001:\u0001$J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\bH&J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\t\u001A\u00020\bH&J\b\u0010\f\u001A\u00020\rH&J\u0010\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\rH&J/\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001AJ\u0018\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\u0018H&J?\u0010\u001C\u001A\u00020\u00182\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u001D\u001A\u00020\u00142\u0006\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020\u00182\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H&¢\u0006\u0004\b \u0010!J\b\u0010\"\u001A\u00020\u000BH&J\u0010\u0010#\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\rH&R\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006%À\u0006\u0001"}, d2={"Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "", "subselections", "Landroidx/collection/LongObjectMap;", "Landroidx/compose/foundation/text/selection/Selection;", "getSubselections", "()Landroidx/collection/LongObjectMap;", "subscribe", "Landroidx/compose/foundation/text/selection/Selectable;", "selectable", "unsubscribe", "", "nextSelectableId", "", "notifyPositionChange", "selectableId", "notifySelectionUpdateStart", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "startPosition", "Landroidx/compose/ui/geometry/Offset;", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isInTouchMode", "", "notifySelectionUpdateStart-ubNVwUQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)V", "notifySelectionUpdateSelectAll", "notifySelectionUpdate", "newPosition", "previousPosition", "isStartHandle", "notifySelectionUpdate-njBpvok", "(Landroidx/compose/ui/layout/LayoutCoordinates;JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)Z", "notifySelectionUpdateEnd", "notifySelectableChange", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SelectionRegistrar {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/text/selection/SelectionRegistrar$Companion;", "", "<init>", "()V", "InvalidSelectableId", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public static final long InvalidSelectableId;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion;
    public static final long InvalidSelectableId;

    static {
        SelectionRegistrar.Companion = Companion.$$INSTANCE;
    }

    LongObjectMap getSubselections();

    long nextSelectableId();

    void notifyPositionChange(long arg1);

    void notifySelectableChange(long arg1);

    boolean notifySelectionUpdate-njBpvok(LayoutCoordinates arg1, long arg2, long arg3, boolean arg4, SelectionAdjustment arg5, boolean arg6);

    void notifySelectionUpdateEnd();

    void notifySelectionUpdateSelectAll(long arg1, boolean arg2);

    void notifySelectionUpdateStart-ubNVwUQ(LayoutCoordinates arg1, long arg2, SelectionAdjustment arg3, boolean arg4);

    Selectable subscribe(Selectable arg1);

    void unsubscribe(Selectable arg1);
}

