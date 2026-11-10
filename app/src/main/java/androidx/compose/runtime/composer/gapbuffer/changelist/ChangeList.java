package androidx.compose.runtime.composer.gapbuffer.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Changes;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0016J.\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0016J,\u0010\u0017\u001A\u00020\r2\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u001AJ\u000E\u0010\u001B\u001A\u00020\r2\u0006\u0010\u001C\u001A\u00020\u001DJ\u000E\u0010\u001E\u001A\u00020\r2\u0006\u0010\u001F\u001A\u00020 J\u000E\u0010!\u001A\u00020\r2\u0006\u0010\u001F\u001A\u00020 J\u000E\u0010\"\u001A\u00020\r2\u0006\u0010\u001F\u001A\u00020 J\u0018\u0010#\u001A\u00020\r2\b\u0010\u001C\u001A\u0004\u0018\u00010$2\u0006\u0010%\u001A\u00020\u0007J \u0010&\u001A\u00020\r2\b\u0010\u001C\u001A\u0004\u0018\u00010$2\u0006\u0010\'\u001A\u00020(2\u0006\u0010%\u001A\u00020\u0007J\u0018\u0010)\u001A\u00020\r2\u0006\u0010\'\u001A\u00020(2\b\u0010\u001C\u001A\u0004\u0018\u00010$J\u000E\u0010*\u001A\u00020\r2\u0006\u0010+\u001A\u00020\u0007J\u0006\u0010,\u001A\u00020\rJ\u0006\u0010-\u001A\u00020\rJ\u0010\u0010.\u001A\u00020\r2\b\u0010/\u001A\u0004\u0018\u00010$J\u0006\u00100\u001A\u00020\rJ\u000E\u00101\u001A\u00020\r2\u0006\u0010\'\u001A\u00020(J\u0006\u00102\u001A\u00020\rJ\u0006\u00103\u001A\u00020\rJ\u0006\u00104\u001A\u00020\rJ\u0016\u00105\u001A\u00020\r2\u0006\u0010\'\u001A\u00020(2\u0006\u00106\u001A\u000207J\u001E\u00105\u001A\u00020\r2\u0006\u0010\'\u001A\u00020(2\u0006\u00106\u001A\u0002072\u0006\u00108\u001A\u000209J\u000E\u0010:\u001A\u00020\r2\u0006\u0010;\u001A\u00020\u0007J\"\u0010<\u001A\u00020\r2\u0012\u0010=\u001A\u000E\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\r0>2\u0006\u0010@\u001A\u00020?J\u0010\u0010A\u001A\u00020\r2\b\u0010B\u001A\u0004\u0018\u00010$J>\u0010C\u001A\u00020\r\"\u0004\b\u0000\u0010D\"\u0004\b\u0001\u0010E2\u0006\u0010\u001C\u001A\u0002HE2\u001D\u0010F\u001A\u0019\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE\u0012\u0004\u0012\u00020\r0G¢\u0006\u0002\bH¢\u0006\u0002\u0010IJ\u0016\u0010J\u001A\u00020\r2\u0006\u0010K\u001A\u00020\u00072\u0006\u0010L\u001A\u00020\u0007J\u001E\u0010M\u001A\u00020\r2\u0006\u0010N\u001A\u00020\u00072\u0006\u00106\u001A\u00020\u00072\u0006\u0010+\u001A\u00020\u0007J\u000E\u0010O\u001A\u00020\r2\u0006\u0010P\u001A\u00020\u0007J\u000E\u0010Q\u001A\u00020\r2\u0006\u0010+\u001A\u00020\u0007J\u001B\u0010R\u001A\u00020\r2\u000E\u0010S\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010$0T¢\u0006\u0002\u0010UJ\u0014\u0010V\u001A\u00020\r2\f\u0010W\u001A\b\u0012\u0004\u0012\u00020\r0XJ\u0016\u0010Y\u001A\u00020\r2\u0006\u0010Z\u001A\u00020[2\u0006\u0010\'\u001A\u00020(J\u001E\u0010\\\u001A\u00020\r2\u000E\u0010S\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010$0]2\u0006\u0010^\u001A\u00020[J(\u0010_\u001A\u00020\r2\b\u0010`\u001A\u0004\u0018\u00010a2\u0006\u0010b\u001A\u00020c2\u0006\u00106\u001A\u00020d2\u0006\u0010N\u001A\u00020dJ\u001E\u0010e\u001A\u00020\r2\u0006\u0010@\u001A\u00020f2\u0006\u0010b\u001A\u00020c2\u0006\u0010g\u001A\u00020dJ\u0006\u0010h\u001A\u00020\rJ\u001A\u0010i\u001A\u00020\r2\u0006\u0010j\u001A\u00020\u00002\n\b\u0002\u0010^\u001A\u0004\u0018\u00010[J\u0010\u0010k\u001A\u00020l2\u0006\u0010m\u001A\u00020lH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006n"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;", "Landroidx/compose/runtime/Changes;", "<init>", "()V", "operations", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;", "size", "", "getSize", "()I", "isEmpty", "", "clear", "", "execute", "slotStorage", "Landroidx/compose/runtime/SlotStorage;", "applier", "Landroidx/compose/runtime/Applier;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "executeAndFlushAllPendingChanges", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "pushRemember", "value", "Landroidx/compose/runtime/RememberObserverHolder;", "pushRememberPausingScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "pushStartResumingScope", "pushEndResumingScope", "pushUpdateValue", "", "groupSlotIndex", "pushUpdateAnchoredValue", "anchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "pushAppendValue", "pushTrimValues", "count", "pushResetSlots", "pushDeactivateCurrentGroup", "pushUpdateAuxData", "data", "pushEnsureRootStarted", "pushEnsureGroupStarted", "pushEndCurrentGroup", "pushSkipToEndOfCurrentGroup", "pushRemoveCurrentGroup", "pushInsertSlots", "from", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "fixups", "Landroidx/compose/runtime/composer/gapbuffer/changelist/FixupList;", "pushMoveCurrentGroup", "offset", "pushEndCompositionScope", "action", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "composition", "pushUseNode", "node", "pushUpdateNode", "T", "V", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "pushRemoveNode", "removeFrom", "moveCount", "pushMoveNode", "to", "pushAdvanceSlotsBy", "distance", "pushUps", "pushDowns", "nodes", "", "([Ljava/lang/Object;)V", "pushSideEffect", "effect", "Lkotlin/Function0;", "pushDetermineMovableContentNodeIndex", "effectiveNodeIndexOut", "Landroidx/compose/runtime/internal/IntRef;", "pushCopyNodesToNewAnchorLocation", "", "effectiveNodeIndex", "pushCopySlotTableToAnchorLocation", "resolvedState", "Landroidx/compose/runtime/MovableContentState;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/MovableContentStateReference;", "pushReleaseMovableGroupAtCurrent", "Landroidx/compose/runtime/ControlledComposition;", "reference", "pushEndMovableContentPlacement", "pushExecuteOperationsIn", "changeList", "toDebugString", "", "linePrefix", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ChangeList extends Changes {
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
        SlotWriter v1 = SlotTableKt.asGapBufferSlotTable(arg1).openWriter();
        try {
            this.executeAndFlushAllPendingChanges(arg2, v1, arg3, ((OperationErrorContext)arg4));
        }
        catch(Throwable v0) {
            v1.close(false);
            throw v0;
        }

        v1.close(true);
    }

    public final void executeAndFlushAllPendingChanges(Applier arg1, SlotWriter arg2, RememberManager arg3, OperationErrorContext arg4) {
        this.operations.executeAndFlushAllPendingOperations(arg1, arg2, arg3, arg4);
    }

    public final int getSize() {
        return this.operations.getSize();
    }

    public boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final void pushAdvanceSlotsBy(int arg6) {
        Operations v5 = this.operations;
        AdvanceSlotsBy v0 = AdvanceSlotsBy.INSTANCE;
        v5.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v5);
        v1.intArgs[v1.intArgsSize - v1.opCodes[v1.opCodesSize - 1].getInts()] = arg6;
        v5.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushAppendValue(GapAnchor arg5, Object arg6) {
        Operations v4 = this.operations;
        AppendValue v0 = AppendValue.INSTANCE;
        v4.pushOp(((Operation)v0));
        WriteScope.setObjects-EsEZvaA(WriteScope.constructor-impl(v4), ObjectParameter.constructor-impl(0), arg5, ObjectParameter.constructor-impl(1), arg6);
        v4.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushCopyNodesToNewAnchorLocation(List arg5, IntRef arg6) {
        if(!arg5.isEmpty()) {
            Operations v4 = this.operations;
            CopyNodesToNewAnchorLocation v0 = CopyNodesToNewAnchorLocation.INSTANCE;
            v4.pushOp(((Operation)v0));
            WriteScope.setObjects-EsEZvaA(WriteScope.constructor-impl(v4), ObjectParameter.constructor-impl(1), arg5, ObjectParameter.constructor-impl(0), arg6);
            v4.ensureAllArgumentsPushedFor(((Operation)v0));
        }
    }

    public final void pushCopySlotTableToAnchorLocation(MovableContentState arg11, CompositionContext arg12, MovableContentStateReference arg13, MovableContentStateReference arg14) {
        Operations v10 = this.operations;
        CopySlotTableToAnchorLocation v0 = CopySlotTableToAnchorLocation.INSTANCE;
        v10.pushOp(((Operation)v0));
        WriteScope.setObjects-fiWQlIY(WriteScope.constructor-impl(v10), ObjectParameter.constructor-impl(0), arg11, ObjectParameter.constructor-impl(1), arg12, ObjectParameter.constructor-impl(3), arg14, ObjectParameter.constructor-impl(2), arg13);
        v10.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushDeactivateCurrentGroup() {
        this.operations.push(DeactivateCurrentGroup.INSTANCE);
    }

    public final void pushDetermineMovableContentNodeIndex(IntRef arg5, GapAnchor arg6) {
        Operations v4 = this.operations;
        DetermineMovableContentNodeIndex v0 = DetermineMovableContentNodeIndex.INSTANCE;
        v4.pushOp(((Operation)v0));
        WriteScope.setObjects-EsEZvaA(WriteScope.constructor-impl(v4), ObjectParameter.constructor-impl(0), arg5, ObjectParameter.constructor-impl(1), arg6);
        v4.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushDowns(Object[] arg5) {
        int v0 = arg5.length == 0 ? 1 : 0;
        if(v0 == 0) {
            Operations v4 = this.operations;
            Downs v0_1 = Downs.INSTANCE;
            v4.pushOp(((Operation)v0_1));
            WriteScope.setObject-sGr0YRc(WriteScope.constructor-impl(v4), ObjectParameter.constructor-impl(0), arg5);
            v4.ensureAllArgumentsPushedFor(((Operation)v0_1));
        }
    }

    public final void pushEndCompositionScope(Function1 arg5, Composition arg6) {
        Operations v4 = this.operations;
        EndCompositionScope v0 = EndCompositionScope.INSTANCE;
        v4.pushOp(((Operation)v0));
        WriteScope.setObjects-EsEZvaA(WriteScope.constructor-impl(v4), ObjectParameter.constructor-impl(0), arg5, ObjectParameter.constructor-impl(1), arg6);
        v4.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushEndCurrentGroup() {
        this.operations.push(EndCurrentGroup.INSTANCE);
    }

    public final void pushEndMovableContentPlacement() {
        this.operations.push(EndMovableContentPlacement.INSTANCE);
    }

    public final void pushEndResumingScope(RecomposeScopeImpl arg4) {
        Operations v3 = this.operations;
        EndResumingScope v0 = EndResumingScope.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-sGr0YRc(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushEnsureGroupStarted(GapAnchor arg4) {
        Operations v3 = this.operations;
        EnsureGroupStarted v0 = EnsureGroupStarted.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-sGr0YRc(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushEnsureRootStarted() {
        this.operations.push(EnsureRootGroupStarted.INSTANCE);
    }

    public final void pushExecuteOperationsIn(ChangeList arg5, IntRef arg6) {
        if(arg5.isNotEmpty()) {
            Operations v4 = this.operations;
            ApplyChangeList v0 = ApplyChangeList.INSTANCE;
            v4.pushOp(((Operation)v0));
            WriteScope.setObjects-EsEZvaA(WriteScope.constructor-impl(v4), ObjectParameter.constructor-impl(0), arg5, ObjectParameter.constructor-impl(1), arg6);
            v4.ensureAllArgumentsPushedFor(((Operation)v0));
        }
    }

    public static void pushExecuteOperationsIn$default(ChangeList arg0, ChangeList arg1, IntRef arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        arg0.pushExecuteOperationsIn(arg1, arg2);
    }

    public final void pushInsertSlots(GapAnchor arg5, SlotTable arg6) {
        Operations v4 = this.operations;
        InsertSlots v0 = InsertSlots.INSTANCE;
        v4.pushOp(((Operation)v0));
        WriteScope.setObjects-EsEZvaA(WriteScope.constructor-impl(v4), ObjectParameter.constructor-impl(0), arg5, ObjectParameter.constructor-impl(1), arg6);
        v4.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushInsertSlots(GapAnchor arg9, SlotTable arg10, FixupList arg11) {
        Operations v8 = this.operations;
        InsertSlotsWithFixups v0 = InsertSlotsWithFixups.INSTANCE;
        v8.pushOp(((Operation)v0));
        WriteScope.setObjects-JOGOPjs(WriteScope.constructor-impl(v8), ObjectParameter.constructor-impl(0), arg9, ObjectParameter.constructor-impl(1), arg10, ObjectParameter.constructor-impl(2), arg11);
        v8.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushMoveCurrentGroup(int arg6) {
        Operations v5 = this.operations;
        MoveCurrentGroup v0 = MoveCurrentGroup.INSTANCE;
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

    public final void pushReleaseMovableGroupAtCurrent(ControlledComposition arg9, CompositionContext arg10, MovableContentStateReference arg11) {
        Operations v8 = this.operations;
        ReleaseMovableGroupAtCurrent v0 = ReleaseMovableGroupAtCurrent.INSTANCE;
        v8.pushOp(((Operation)v0));
        WriteScope.setObjects-JOGOPjs(WriteScope.constructor-impl(v8), ObjectParameter.constructor-impl(0), arg9, ObjectParameter.constructor-impl(1), arg10, ObjectParameter.constructor-impl(2), arg11);
        v8.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushRemember(RememberObserverHolder arg4) {
        Operations v3 = this.operations;
        Remember v0 = Remember.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-sGr0YRc(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushRememberPausingScope(RecomposeScopeImpl arg4) {
        Operations v3 = this.operations;
        RememberPausingScope v0 = RememberPausingScope.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-sGr0YRc(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushRemoveCurrentGroup() {
        this.operations.push(RemoveCurrentGroup.INSTANCE);
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

    public final void pushResetSlots() {
        this.operations.push(ResetSlots.INSTANCE);
    }

    public final void pushSideEffect(Function0 arg4) {
        Operations v3 = this.operations;
        SideEffect v0 = SideEffect.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-sGr0YRc(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushSkipToEndOfCurrentGroup() {
        this.operations.push(SkipToEndOfCurrentGroup.INSTANCE);
    }

    public final void pushStartResumingScope(RecomposeScopeImpl arg4) {
        Operations v3 = this.operations;
        StartResumingScope v0 = StartResumingScope.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-sGr0YRc(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushTrimValues(int arg6) {
        Operations v5 = this.operations;
        TrimParentValues v0 = TrimParentValues.INSTANCE;
        v5.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v5);
        v1.intArgs[v1.intArgsSize - v1.opCodes[v1.opCodesSize - 1].getInts()] = arg6;
        v5.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushUpdateAnchoredValue(Object arg6, GapAnchor arg7, int arg8) {
        Operations v5 = this.operations;
        UpdateAnchoredValue v0 = UpdateAnchoredValue.INSTANCE;
        v5.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v5);
        WriteScope.setObjects-EsEZvaA(v1, ObjectParameter.constructor-impl(0), arg6, ObjectParameter.constructor-impl(1), arg7);
        v1.intArgs[v1.intArgsSize - v1.opCodes[v1.opCodesSize - 1].getInts()] = arg8;
        v5.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushUpdateAuxData(Object arg4) {
        Operations v3 = this.operations;
        UpdateAuxData v0 = UpdateAuxData.INSTANCE;
        v3.pushOp(((Operation)v0));
        WriteScope.setObject-sGr0YRc(WriteScope.constructor-impl(v3), ObjectParameter.constructor-impl(0), arg4);
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
        WriteScope.setObjects-EsEZvaA(v1, v2, arg6, v3, TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg7, 2));
        v5.ensureAllArgumentsPushedFor(((Operation)v0));
    }

    public final void pushUpdateValue(Object arg5, int arg6) {
        Operations v4 = this.operations;
        UpdateValue v0 = UpdateValue.INSTANCE;
        v4.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v4);
        WriteScope.setObject-sGr0YRc(v1, ObjectParameter.constructor-impl(0), arg5);
        v1.intArgs[v1.intArgsSize - v1.opCodes[v1.opCodesSize - 1].getInts()] = arg6;
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

