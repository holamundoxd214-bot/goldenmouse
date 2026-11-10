package androidx.compose.ui.layout;

import androidx.collection.IntList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000E\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u000E\u001A\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/ui/layout/SubcomposeLayoutPausableCompositionException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "operations", "Landroidx/collection/IntList;", "slotId", "", "cause", "", "<init>", "(Landroidx/collection/IntList;Ljava/lang/Object;Ljava/lang/Throwable;)V", "operationsList", "", "", "message", "getMessage$annotations", "()V", "getMessage", "()Ljava/lang/String;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class SubcomposeLayoutPausableCompositionException extends IllegalStateException {
    private final IntList operations;
    private final Object slotId;

    public SubcomposeLayoutPausableCompositionException(IntList arg1, Object arg2, Throwable arg3) {
        super(arg3);
        this.operations = arg1;
        this.slotId = arg2;
    }

    public String getMessage() {
        return StringsKt.trimMargin$default("\n            |slotid=" + this.slotId + ". Last operations:\n            |" + CollectionsKt.joinToString$default(this.operationsList(), "\n", null, null, 0, null, null, 62, null) + "\n            ", null, 1, null);
    }

    public static void getMessage$annotations() {
    }

    private final List operationsList() {
        String v2_1;
        List v0 = CollectionsKt.createListBuilder();
        int v1;
        for(v1 = this.operations._size - 1; v1 >= 0; --v1) {
            int v2 = this.operations.get(v1);
            int v3 = SLOperation.constructor-impl(v2);
            if(SLOperation.equals-impl0(v3, SLOperation.Companion.getCancelPausedPrecomposition-NjRlDlw())) {
                v2_1 = "CancelPausedPrecomposition";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getReuseForceSyncDeactivation-NjRlDlw())) {
                v2_1 = "ReuseForceSyncDeactivation";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getReuseScheduleOutOfFrameDeactivation-NjRlDlw())) {
                v2_1 = "ReuseScheduleOutOfFrameDeactivation";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getReuseSyncDeactivation-NjRlDlw())) {
                v2_1 = "ReuseSyncDeactivation";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getReuseDeactivationViaHost-NjRlDlw())) {
                v2_1 = "ReuseDeactivationViaHost";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getTookFromPrecomposeMap-NjRlDlw())) {
                v2_1 = "TookFromPrecomposeMap";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getSubcompose-NjRlDlw())) {
                v2_1 = "Subcompose";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getSubcomposeNew-NjRlDlw())) {
                v2_1 = "SubcomposeNew";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getSubcomposePausable-NjRlDlw())) {
                v2_1 = "SubcomposePausable";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getSubcomposeForceReuse-NjRlDlw())) {
                v2_1 = "SubcomposeForceReuse";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getDeactivateOutOfFrame-NjRlDlw())) {
                v2_1 = "DeactivateOutOfFrame";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getDeactivateOutOfFrameCancelled-NjRlDlw())) {
                v2_1 = "DeactivateOutOfFrameCancelled";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getSlotToReusedFromOnDeactivate-NjRlDlw())) {
                v2_1 = "SlotToReusedFromOnDeactivate";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getSlotToReusedFromOnReuse-NjRlDlw())) {
                v2_1 = "SlotToReusedFromOnReuse";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getReused-NjRlDlw())) {
                v2_1 = "Reused";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getResumePaused-NjRlDlw())) {
                v2_1 = "ResumePaused";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getPausePaused-NjRlDlw())) {
                v2_1 = "PausePaused";
            }
            else if(SLOperation.equals-impl0(v3, SLOperation.Companion.getApplyPaused-NjRlDlw())) {
                v2_1 = "ApplyPaused";
            }
            else {
                v2_1 = "Unexpected " + v2;
            }

            v0.add(v1 + ": " + v2_1);
        }

        return CollectionsKt.build(v0);
    }
}

