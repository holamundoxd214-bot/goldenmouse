package androidx.compose.runtime.composer.gapbuffer.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.ComposeStackTraceBuilderKt;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001A(\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001A\u00020\u0001H\u0002\u001A\u0010\u0010\n\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005H\u0002\u001A(\u0010\u000B\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002\u001A3\u0010\u000E\u001A\u00020\u00032\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001A\u00020\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010\r2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0082\b\u001A(\u0010\u0015\u001A\u00020\u0016*\u00020\u00162\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001A\u00020\u00052\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0002\u001A\u0014\u0010\u000E\u001A\u00020\u0010*\u00020\u00102\u0006\u0010\u0004\u001A\u00020\u0005H\u0002*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0017"}, d2={"IntParameter", "", "positionToParentOf", "", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "applier", "Landroidx/compose/runtime/Applier;", "", "index", "currentNodeIndex", "positionToInsert", "anchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "withCurrentStackTrace", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "writer", "location", "block", "Lkotlin/Function0;", "attachComposeStackTrace", "", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class OperationKt {
    public static final Throwable access$attachComposeStackTrace(Throwable arg0, OperationErrorContext arg1, SlotWriter arg2, GapAnchor arg3) {
        return OperationKt.attachComposeStackTrace(arg0, arg1, arg2, arg3);
    }

    public static final int access$positionToInsert(SlotWriter arg0, GapAnchor arg1, Applier arg2) {
        return OperationKt.positionToInsert(arg0, arg1, arg2);
    }

    public static final void access$positionToParentOf(SlotWriter arg0, Applier arg1, int arg2) {
        OperationKt.positionToParentOf(arg0, arg1, arg2);
    }

    public static final OperationErrorContext access$withCurrentStackTrace(OperationErrorContext arg0, SlotWriter arg1) {
        return OperationKt.withCurrentStackTrace(arg0, arg1);
    }

    private static final Throwable attachComposeStackTrace(Throwable arg1, OperationErrorContext arg2, SlotWriter arg3, GapAnchor arg4) {
        if(arg2 == null) {
            return arg1;
        }

        return ComposeStackTraceKt.attachComposeStackTrace(arg1, new OperationKt$$ExternalSyntheticLambda0(arg4, arg3, arg2));
    }

    static final ComposeStackTrace attachComposeStackTrace$lambda$0(GapAnchor arg6, SlotWriter arg7, OperationErrorContext arg8) {
        if(arg6 != null) {
            arg7.seek(arg6);
        }

        List v6 = ComposeStackTraceBuilderKt.buildTrace$default(arg7, null, 0, null, 7, null);
        Object v7 = CollectionsKt.lastOrNull(v6);
        Integer v7_1 = v7 != null ? ((ComposeStackTraceFrame)v7).getGroupOffset() : null;
        Integer v3 = v7_1;
        List v7_2 = arg8.buildStackTrace(v3);
        if(v3 != null) {
            if(v7_2.isEmpty()) {
            }
            else {
                v7_2 = CollectionsKt.plus(CollectionsKt.listOf(ComposeStackTraceFrame.copy$default(CollectionsKt.first(v7_2), 0, null, v3, 3, null)), CollectionsKt.drop(((Iterable)v7_2), 1));
            }
        }

        return new ComposeStackTrace(CollectionsKt.plus(((Collection)v6), ((Iterable)v7_2)), arg8.getSourceInformationEnabled());
    }

    private static final int currentNodeIndex(SlotWriter arg6) {
        int v0 = arg6.getCurrentGroup();
        int v1;
        for(v1 = arg6.getParent(); v1 >= 0; v1 = arg6.parent(v1)) {
            if(arg6.isNode(v1)) {
                break;
            }
        }

        ++v1;
        int v4 = 0;
        while(v1 < v0) {
            if(arg6.indexInGroup(v0, v1)) {
                if(arg6.isNode(v1)) {
                    v4 = 0;
                }

                ++v1;
                continue;
            }

            int v5 = arg6.isNode(v1) ? 1 : arg6.nodeCount(v1);
            v4 += v5;
            v1 += arg6.groupSize(v1);
        }

        return v4;
    }

    private static final int positionToInsert(SlotWriter arg5, GapAnchor arg6, Applier arg7) {
        int v6 = arg5.anchorIndex(arg6);
        int v1 = 1;
        int v0 = arg5.getCurrentGroup() < v6 ? 1 : 0;
        String v3 = "Check failed";
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError(v3);
        }

        OperationKt.positionToParentOf(arg5, arg7, v6);
        for(v0 = OperationKt.currentNodeIndex(arg5); arg5.getCurrentGroup() < v6; v0 += arg5.skipGroup()) {
            if(arg5.indexInCurrentGroup(v6)) {
                if(arg5.isNode()) {
                    arg7.down(arg5.node(arg5.getCurrentGroup()));
                    v0 = 0;
                }

                arg5.startGroup();
                continue;
            }
        }

        if(arg5.getCurrentGroup() == v6) {
        }
        else {
            v1 = 0;
        }

        if(v1 == 0) {
            ComposerKt.composeImmediateRuntimeError(v3);
        }

        return v0;
    }

    private static final void positionToParentOf(SlotWriter arg1, Applier arg2, int arg3) {
        while(!arg1.indexInParent(arg3)) {
            arg1.skipToGroupEnd();
            if(arg1.isNode(arg1.getParent())) {
                arg2.up();
            }

            arg1.endGroup();
        }
    }

    private static final OperationErrorContext withCurrentStackTrace(OperationErrorContext arg1, SlotWriter arg2) {
        return new OperationKt$withCurrentStackTrace$1(arg1, arg2);
    }

    private static final void withCurrentStackTrace(OperationErrorContext arg0, SlotWriter arg1, GapAnchor arg2, Function0 arg3) {
        try {
            arg3.invoke();
            return;
        }
        catch(Throwable v3) {
            throw OperationKt.attachComposeStackTrace(v3, arg0, arg1, arg2);
        }
    }
}

