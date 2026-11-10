package androidx.compose.runtime.composer.linkbuffer.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Changes;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.LinkRememberObserverHolder;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchor;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchorKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableAddressSpace;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016J\u0006\u0010\f\u001A\u00020\u000BJ\b\u0010\r\u001A\u00020\u000EH\u0016J.\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u00112\n\u0010\u0012\u001A\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0016J,\u0010\u0018\u001A\u00020\u000E2\n\u0010\u0012\u001A\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u001BJ\u000E\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001D\u001A\u00020\u001EJ\u000E\u0010\u001F\u001A\u00020\u000E2\u0006\u0010 \u001A\u00020!J\u000E\u0010\"\u001A\u00020\u000E2\u0006\u0010 \u001A\u00020!J\u000E\u0010#\u001A\u00020\u000E2\u0006\u0010 \u001A\u00020!J\u0016\u0010$\u001A\u00020\u000E2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020(J\u0018\u0010)\u001A\u00020\u000E2\u0006\u0010*\u001A\u00020\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010+J\u001C\u0010,\u001A\u00020\u000E2\n\u0010-\u001A\u00060\u0007j\u0002`.2\b\u0010\u001D\u001A\u0004\u0018\u00010+J\u0010\u0010/\u001A\u00020\u000E2\b\u0010\u001D\u001A\u0004\u0018\u00010+J\u001A\u00100\u001A\u00020\u000E2\n\u00101\u001A\u00060\u0007j\u0002`22\u0006\u00103\u001A\u00020\u0007J\u0006\u00104\u001A\u00020\u000EJ\u0006\u00105\u001A\u00020\u000EJ\u0010\u00106\u001A\u00020\u000E2\b\u00107\u001A\u0004\u0018\u00010+J\u0006\u00108\u001A\u00020\u000EJ\u001A\u00109\u001A\u00020\u000E2\u0006\u0010:\u001A\u00020;2\n\u0010<\u001A\u00060=j\u0002`>J\"\u00109\u001A\u00020\u000E2\u0006\u0010:\u001A\u00020;2\n\u0010<\u001A\u00060=j\u0002`>2\u0006\u0010?\u001A\u00020@J\u000E\u0010A\u001A\u00020\u000E2\u0006\u0010B\u001A\u00020\u0007J\u0006\u0010C\u001A\u00020\u000EJ\"\u0010D\u001A\u00020\u000E2\u0012\u0010E\u001A\u000E\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u000E0F2\u0006\u0010H\u001A\u00020GJ\u0010\u0010I\u001A\u00020\u000E2\b\u0010J\u001A\u0004\u0018\u00010+J>\u0010K\u001A\u00020\u000E\"\u0004\b\u0000\u0010L\"\u0004\b\u0001\u0010M2\u0006\u0010\u001D\u001A\u0002HM2\u001D\u0010N\u001A\u0019\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u00020\u000E0O¢\u0006\u0002\bP¢\u0006\u0002\u0010QJ\u0016\u0010R\u001A\u00020\u000E2\u0006\u0010S\u001A\u00020\u00072\u0006\u0010T\u001A\u00020\u0007J\u001E\u0010U\u001A\u00020\u000E2\u0006\u0010V\u001A\u00020\u00072\u0006\u0010W\u001A\u00020\u00072\u0006\u00103\u001A\u00020\u0007J\u0012\u0010X\u001A\u00020\u000E2\n\u0010Y\u001A\u00060=j\u0002`>J\u001A\u0010Z\u001A\u00020\u000E2\u0006\u0010[\u001A\u00020\\2\n\u0010Y\u001A\u00060=j\u0002`>J\u0006\u0010]\u001A\u00020\u000EJ\u0006\u0010^\u001A\u00020\u000EJ\u000E\u0010_\u001A\u00020\u000E2\u0006\u00103\u001A\u00020\u0007J\u001B\u0010`\u001A\u00020\u000E2\u000E\u0010a\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010+0b¢\u0006\u0002\u0010cJ\u0014\u0010d\u001A\u00020\u000E2\f\u0010e\u001A\b\u0012\u0004\u0012\u00020\u000E0fJ\u001A\u0010g\u001A\u00020\u000E2\u0006\u0010h\u001A\u00020i2\n\u0010j\u001A\u00060=j\u0002`>J\u001E\u0010k\u001A\u00020\u000E2\u000E\u0010a\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010+0l2\u0006\u0010m\u001A\u00020iJ(\u0010n\u001A\u00020\u000E2\b\u0010o\u001A\u0004\u0018\u00010p2\u0006\u0010q\u001A\u00020r2\u0006\u0010W\u001A\u00020s2\u0006\u0010V\u001A\u00020sJ\u001E\u0010t\u001A\u00020\u000E2\u0006\u0010H\u001A\u00020u2\u0006\u0010q\u001A\u00020r2\u0006\u0010v\u001A\u00020sJ\u0006\u0010w\u001A\u00020\u000EJ\u000E\u0010x\u001A\u00020\u000E2\u0006\u0010o\u001A\u00020pJ\u001A\u0010y\u001A\u00020\u000E2\u0006\u0010z\u001A\u00020\u00002\n\b\u0002\u0010m\u001A\u0004\u0018\u00010iJ\u0010\u0010{\u001A\u00020|2\u0006\u0010}\u001A\u00020|H\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006~"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/changelist/ChangeList;", "Landroidx/compose/runtime/Changes;", "<init>", "()V", "operations", "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;", "size", "", "getSize", "()I", "isEmpty", "", "hasChangesRequiringApplication", "clear", "", "execute", "slotStorage", "Landroidx/compose/runtime/SlotStorage;", "applier", "Landroidx/compose/runtime/Applier;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "executeAndFlushAllPendingChanges", "slots", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "pushRemember", "value", "Landroidx/compose/runtime/RememberObserverHolder;", "pushRememberPausingScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "pushStartResumingScope", "pushEndResumingScope", "pushUpdateRememberObserverHolderOrdering", "holder", "Landroidx/compose/runtime/LinkRememberObserverHolder;", "after", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "pushUpdateRelativeValue", "slotIndex", "", "pushUpdateValue", "groupSlotAddress", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "pushAppendValue", "pushRemoveTailGroupsAndValues", "firstTailGroupToRemove", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "count", "pushResetSlots", "pushDeactivateGroup", "pushUpdateAuxData", "data", "pushRemoveGroup", "pushInsertSlots", "sourceTable", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "source", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "fixups", "Landroidx/compose/runtime/composer/linkbuffer/changelist/FixupList;", "pushMoveGroup", "offset", "pushClearAllRecompositionRequiredGroups", "pushEndCompositionScope", "action", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "composition", "pushUseNode", "node", "pushUpdateNode", "T", "V", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "pushRemoveNode", "nodeIndex", "removeCount", "pushMoveNode", "to", "from", "pushSeekToGroupHandle", "handle", "pushSeekToAnchor", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "pushStartGroup", "pushSkipGroup", "pushUps", "pushDowns", "nodes", "", "([Ljava/lang/Object;)V", "pushSideEffect", "effect", "Lkotlin/Function0;", "pushDetermineMovableContentNodeIndex", "effectiveNodeIndexOut", "Landroidx/compose/runtime/internal/IntRef;", "groupHandle", "pushCopyNodesToNewAnchorLocation", "", "effectiveNodeIndex", "pushCopySlotTableToAnchorLocation", "resolvedState", "Landroidx/compose/runtime/MovableContentState;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/MovableContentStateReference;", "pushReleaseMovableGroup", "Landroidx/compose/runtime/ControlledComposition;", "reference", "pushEndMovableContentPlacement", "pushDisposeDisposeMovableContentState", "pushExecuteOperationsIn", "changeList", "toDebugString", "", "linePrefix", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ChangeList extends Changes {
    public static final int $stable = 8;
    private final Operations operations;

    static {
    }

    public ChangeList() {
        super();
        this.operations = new Operations();
    }

    public void clear() {
        this.operations.clear();
    }

    public void execute(SlotStorage arg1, Applier arg2, RememberManager arg3, CompositionErrorContextImpl arg4) {
        SlotTableEditor v1 = SlotTableKt.asLinkBufferSlotTable(arg1).openEditor();
        try {
            this.executeAndFlushAllPendingChanges(arg2, v1, arg3, ((OperationErrorContext)arg4));
        }
        catch(Throwable v0) {
            v1.close();
            throw v0;
        }

        v1.close();
    }

    public final void executeAndFlushAllPendingChanges(Applier arg1, SlotTableEditor arg2, RememberManager arg3, OperationErrorContext arg4) {
        this.operations.executeAndFlushAllPendingOperations(arg1, arg2, arg3, arg4);
    }

    public final int getSize() {
        return this.operations.getSize();
    }

    public final boolean hasChangesRequiringApplication() {
        return this.operations.getRequiresApplication();
    }

    public boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final void pushAppendValue(Object arg4) {
        Operations v3 = this.operations;
        AppendValue v0 = AppendValue.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-aWHcuVo(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushClearAllRecompositionRequiredGroups() {
        this.operations.push(ClearAllRecompositionRequired.INSTANCE);
    }

    public final void pushCopyNodesToNewAnchorLocation(List arg5, IntRef arg6) {
        if(!arg5.isEmpty()) {
            Operations v4 = this.operations;
            CopyNodesToNewAnchorLocation v0 = CopyNodesToNewAnchorLocation.INSTANCE;
            v4.pushOp(((Operation)v0));
            WriteScope.setObjects-EykTJF8(WriteScope.constructor-impl(v4), ObjectParameter.constructor-impl(1), arg5, ObjectParameter.constructor-impl(0), arg6);
            v4.ensureAllArgumentsPushedFor(((Operation)v0));
        }
    }

    public final void pushCopySlotTableToAnchorLocation(MovableContentState arg11, CompositionContext arg12, MovableContentStateReference arg13, MovableContentStateReference arg14) {
        Operations v10 = this.operations;
        CopySlotTableToHandleLocation v0 = CopySlotTableToHandleLocation.INSTANCE;
        v10.pushOp(((Operation)v0));
        WriteScope.setObjects-UOUgNZM(WriteScope.constructor-impl(v10), ObjectParameter.constructor-impl(0), arg11, ObjectParameter.constructor-impl(1), arg12, ObjectParameter.constructor-impl(3), arg14, ObjectParameter.constructor-impl(2), arg13);
        v10.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushDeactivateGroup() {
        this.operations.push(DeactivateGroup.INSTANCE);
    }

    public final void pushDetermineMovableContentNodeIndex(IntRef arg5, long arg6) {
        Operations v4 = this.operations;
        DetermineMovableContentNodeIndex v0 = DetermineMovableContentNodeIndex.INSTANCE;
        v4.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v4);
        WriteScope.setObject-aWHcuVo(v1, ObjectParameter.constructor-impl(0), arg5);
        WriteScope.setLong-impl(v1, 1, 0, arg6);
        v4.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushDisposeDisposeMovableContentState(MovableContentState arg4) {
        Operations v3 = this.operations;
        DisposeMovableContentState v0 = DisposeMovableContentState.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-aWHcuVo(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushDowns(Object[] arg5) {
        int v0 = arg5.length == 0 ? 1 : 0;
        if(v0 == 0) {
            Operations v4 = this.operations;
            Downs v0_1 = Downs.INSTANCE;
            v4.pushOp(((Operation)v0_1));
            WriteScope.setObject-aWHcuVo(WriteScope.constructor-impl(v4), ObjectParameter.constructor-impl(0), arg5);
            v4.ensureAllArgumentsPushedFor(((Operation)v0_1));
        }
    }

    public final void pushEndCompositionScope(Function1 arg5, Composition arg6) {
        Operations v4 = this.operations;
        EndCompositionScope v0 = EndCompositionScope.INSTANCE;
        v4.pushOp(((Operation)v0));
        WriteScope.setObjects-EykTJF8(WriteScope.constructor-impl(v4), ObjectParameter.constructor-impl(0), arg5, ObjectParameter.constructor-impl(1), arg6);
        v4.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushEndMovableContentPlacement() {
        this.operations.push(EndMovableContentPlacement.INSTANCE);
    }

    public final void pushEndResumingScope(RecomposeScopeImpl arg4) {
        Operations v3 = this.operations;
        EndResumingScope v0 = EndResumingScope.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-aWHcuVo(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushExecuteOperationsIn(ChangeList arg5, IntRef arg6) {
        if(arg5.isNotEmpty()) {
            Operations v4 = this.operations;
            ApplyChangeList v0 = ApplyChangeList.INSTANCE;
            v4.pushOp(((Operation)v0));
            Operations v1 = WriteScope.constructor-impl(v4);
            WriteScope.setObjects-EykTJF8(v1, ObjectParameter.constructor-impl(0), arg5, ObjectParameter.constructor-impl(1), arg6);
            if(arg5.operations.getRequiresApplication()) {
                WriteScope.requireApplication-impl(v1);
            }

            v4.ensureAllArgumentsPushedFor(((Operation)v0));
        }
    }

    public static void pushExecuteOperationsIn$default(ChangeList arg0, ChangeList arg1, IntRef arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        arg0.pushExecuteOperationsIn(arg1, arg2);
    }

    public final void pushInsertSlots(SlotTable arg5, long arg6) {
        Operations v4 = this.operations;
        InsertSlots v0 = InsertSlots.INSTANCE;
        v4.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v4);
        WriteScope.setLong-impl(v1, 0, 1, arg6);
        WriteScope.setObject-aWHcuVo(v1, ObjectParameter.constructor-impl(0), arg5);
        v4.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushInsertSlots(SlotTable arg5, long arg6, FixupList arg8) {
        Operations v4 = this.operations;
        InsertSlotsWithFixups v0 = InsertSlotsWithFixups.INSTANCE;
        v4.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v4);
        WriteScope.setLong-impl(v1, 0, 1, arg6);
        WriteScope.setObjects-EykTJF8(v1, ObjectParameter.constructor-impl(0), arg5, ObjectParameter.constructor-impl(1), arg8);
        v4.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushMoveGroup(int arg6) {
        Operations v5 = this.operations;
        MoveGroup v0 = MoveGroup.INSTANCE;
        v5.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v5);
        v1.intArgs[v1.intArgsSize - v1.opCodes[v1.opCodesSize - 1].getInts()] = arg6;
        v5.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushMoveNode(int arg6, int arg7, int arg8) {
        Operations v5 = this.operations;
        MoveNode v0 = MoveNode.INSTANCE;
        v5.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v5);
        int v2 = v1.intArgsSize - v1.opCodes[v1.opCodesSize - 1].getInts();
        int[] v1_1 = v1.intArgs;
        v1_1[v2 + 1] = arg6;
        v1_1[v2] = arg7;
        v1_1[v2 + 2] = arg8;
        v5.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushReleaseMovableGroup(ControlledComposition arg9, CompositionContext arg10, MovableContentStateReference arg11) {
        Operations v8 = this.operations;
        ReleaseMovableGroup v0 = ReleaseMovableGroup.INSTANCE;
        v8.pushOp(((Operation)v0));
        WriteScope.setObjects-Gn0XI2A(WriteScope.constructor-impl(v8), ObjectParameter.constructor-impl(0), arg9, ObjectParameter.constructor-impl(1), arg10, ObjectParameter.constructor-impl(2), arg11);
        v8.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushRemember(RememberObserverHolder arg4) {
        Operations v3 = this.operations;
        Remember v0 = Remember.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-aWHcuVo(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushRememberPausingScope(RecomposeScopeImpl arg4) {
        Operations v3 = this.operations;
        RememberPausingScope v0 = RememberPausingScope.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-aWHcuVo(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushRemoveGroup() {
        this.operations.push(RemoveGroup.INSTANCE);
    }

    public final void pushRemoveNode(int arg6, int arg7) {
        Operations v5 = this.operations;
        RemoveNode v0 = RemoveNode.INSTANCE;
        v5.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v5);
        int v2 = v1.intArgsSize - v1.opCodes[v1.opCodesSize - 1].getInts();
        int[] v1_1 = v1.intArgs;
        v1_1[v2] = arg6;
        v1_1[v2 + 1] = arg7;
        v5.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushRemoveTailGroupsAndValues(int arg6, int arg7) {
        Operations v5 = this.operations;
        RemoveTailGroupsAndValues v0 = RemoveTailGroupsAndValues.INSTANCE;
        v5.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v5);
        int v2 = v1.intArgsSize - v1.opCodes[v1.opCodesSize - 1].getInts();
        int[] v1_1 = v1.intArgs;
        v1_1[v2] = arg6;
        v1_1[v2 + 1] = arg7;
        v5.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushResetSlots() {
        this.operations.push(ResetSlots.INSTANCE);
    }

    public final void pushSeekToAnchor(SlotTableAddressSpace arg4, long arg5) {
        Operations v3 = this.operations;
        SeekToAnchor v0 = SeekToAnchor.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-aWHcuVo(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), LinkAnchorKt.anchorHandle(arg4, arg5));
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushSeekToGroupHandle(long arg5) {
        Operations v4 = this.operations;
        SeekToGroupHandle v0 = SeekToGroupHandle.INSTANCE;
        v4.pushOp(((Operation)v0));
        WriteScope.setLong-impl(WriteScope.constructor-impl(v4), 0, 1, arg5);
        v4.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushSideEffect(Function0 arg4) {
        Operations v3 = this.operations;
        SideEffect v0 = SideEffect.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-aWHcuVo(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushSkipGroup() {
        this.operations.push(SkipGroup.INSTANCE);
    }

    public final void pushStartGroup() {
        this.operations.push(StartGroup.INSTANCE);
    }

    public final void pushStartResumingScope(RecomposeScopeImpl arg4) {
        Operations v3 = this.operations;
        StartResumingScope v0 = StartResumingScope.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-aWHcuVo(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushUpdateAuxData(Object arg4) {
        Operations v3 = this.operations;
        UpdateAuxData v0 = UpdateAuxData.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-aWHcuVo(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushUpdateNode(Object arg6, Function2 arg7) {
        Operations v5 = this.operations;
        UpdateNode v0 = UpdateNode.INSTANCE;
        v5.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v5);
        int v2 = ObjectParameter.constructor-impl(0);
        int v3 = ObjectParameter.constructor-impl(1);
        Intrinsics.checkNotNull(arg7, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        WriteScope.setObjects-EykTJF8(v1, v2, arg6, v3, TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg7, 2));
        v5.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushUpdateRelativeValue(int arg7, Object arg8) {
        Operations v6 = this.operations;
        UpdateValueRelative v0 = UpdateValueRelative.INSTANCE;
        v6.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v6);
        v1.intArgs[v1.intArgsSize - v1.opCodes[v1.opCodesSize - 1].getInts()] = arg7;
        WriteScope.setObject-aWHcuVo(v1, ObjectParameter.constructor-impl(0), arg8);
        v6.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushUpdateRememberObserverHolderOrdering(LinkRememberObserverHolder arg4, LinkAnchor arg5) {
        Operations v3 = this.operations;
        UpdateRememberObserverHolderOrdering v0 = UpdateRememberObserverHolderOrdering.INSTANCE;
        v3.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v3);
        WriteScope.setObject-aWHcuVo(v1, ObjectParameter.constructor-impl(1), arg4);
        WriteScope.setObject-aWHcuVo(v1, ObjectParameter.constructor-impl(0), arg5);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushUpdateValue(int arg5, Object arg6) {
        Operations v4 = this.operations;
        UpdateValue v0 = UpdateValue.INSTANCE;
        v4.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v4);
        WriteScope.setObject-aWHcuVo(v1, ObjectParameter.constructor-impl(0), arg6);
        v1.intArgs[v1.intArgsSize - v1.opCodes[v1.opCodesSize - 1].getInts()] = arg5;
        v4.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushUps(int arg6) {
        Operations v5 = this.operations;
        Ups v0 = Ups.INSTANCE;
        v5.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v5);
        v1.intArgs[v1.intArgsSize - v1.opCodes[v1.opCodesSize - 1].getInts()] = arg6;
        v5.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushUseNode(Object arg1) {
        if((arg1 instanceof ComposeNodeLifecycleCallback)) {
            this.operations.push(UseCurrentNode.INSTANCE);
        }
    }

    public String toDebugString(String arg3) {
        StringBuilder v0 = new StringBuilder();
        v0.append("ChangeList instance containing ");
        v0.append(this.getSize());
        v0.append(" operations");
        if(v0.length() > 0) {
            v0.append(":\n");
            v0.append(this.operations.toDebugString(arg3));
        }

        return v0.toString();
    }
}

