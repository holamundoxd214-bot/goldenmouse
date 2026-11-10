package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.ReusableRememberObserverHolder;
import androidx.compose.runtime.composer.RememberManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\u0014\u0010\u0005\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A(\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00022\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000B\u001A\u00020\fH\u0000¨\u0006\r"}, d2={"removeGroupAndForgetSlots", "", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "deactivateGroup", "buildTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "child", "", "group", "", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SlotTableEditorKt {
    public static final List buildTrace(SlotTableEditor arg2, Object arg3, int arg4) {
        if(!arg2.isClosed() && !arg2.isEmpty()) {
            return SlotTableAddresSpaceKt.buildTrace(arg2.getTable().getAddressSpace(), arg4, arg3, new EditorTraceBuilder(arg2));
        }

        return CollectionsKt.emptyList();
    }

    public static List buildTrace$default(SlotTableEditor arg0, Object arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.getCurrentGroup();
        }

        return SlotTableEditorKt.buildTrace(arg0, arg1, arg2);
    }

    public static final void deactivateGroup(SlotTableEditor arg2, RememberManager arg3) {
        arg2.visitSlotsInRememberOrder(arg2.getCurrentGroup(), new SlotTableEditorKt$$ExternalSyntheticLambda0(arg2, arg3));
    }

    static final boolean deactivateGroup$lambda$0(SlotTableEditor arg1, RememberManager arg2, int arg3, int arg4, Object arg5) {
        if((arg5 instanceof ComposeNodeLifecycleCallback)) {
            arg1.flagsOf(arg3);
            if(arg4 == 0) {
                arg2.deactivating(((ComposeNodeLifecycleCallback)arg5));
            }
        }
        else if(!(arg5 instanceof ReusableRememberObserverHolder)) {
            if((arg5 instanceof RememberObserverHolder)) {
                arg2.forgetting(((RememberObserverHolder)arg5));
                return 1;
            }
            else if((arg5 instanceof RecomposeScopeImpl)) {
                ((RecomposeScopeImpl)arg5).release();
                return 1;
            }
        }

        return 0;
    }

    public static final void removeGroupAndForgetSlots(SlotTableEditor arg2, RememberManager arg3) {
        arg2.visitSlotsInRememberOrder(arg2.getCurrentGroup(), new SlotTableEditorKt$$ExternalSyntheticLambda1(arg3));
        SlotTableEditor.removeGroup$default(arg2, false, 1, null);
    }

    static final boolean removeGroupAndForgetSlots$lambda$0(RememberManager arg0, int arg1, int arg2, Object arg3) {
        if((arg3 instanceof ComposeNodeLifecycleCallback)) {
            arg0.releasing(arg3);
        }

        if((arg3 instanceof RememberObserverHolder)) {
            arg0.forgetting(arg3);
        }

        if((arg3 instanceof RecomposeScopeImpl)) {
            ((RecomposeScopeImpl)arg3).release();
        }

        return 0;
    }
}

