package androidx.compose.runtime.composer.gapbuffer.changelist;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.internal.IntRef;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u0088\u00012\u00020\u0001:\u0002\u0088\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010#\u001A\u00020$H\u0002J\b\u0010%\u001A\u00020$H\u0002J\u0012\u0010&\u001A\u00020$2\b\b\u0002\u0010\'\u001A\u00020\u0011H\u0002J\u000E\u0010(\u001A\u00020$2\u0006\u0010)\u001A\u00020\u001AJ\u000E\u0010*\u001A\u00020$2\u0006\u0010)\u001A\u00020\u001AJ\u0006\u0010+\u001A\u00020$J\b\u0010,\u001A\u00020$H\u0002J\u0010\u0010-\u001A\u00020$2\u0006\u0010.\u001A\u00020/H\u0002J\u0012\u00100\u001A\u00020$2\b\b\u0002\u00101\u001A\u00020\u0011H\u0002J\u001F\u00104\u001A\u00020$2\u0006\u00105\u001A\u00020\u00052\f\u00106\u001A\b\u0012\u0004\u0012\u00020$07H\u0086\bJ\u0017\u00108\u001A\u00020$2\f\u00106\u001A\b\u0012\u0004\u0012\u00020$07H\u0086\bJ\u000E\u00109\u001A\u00020$2\u0006\u0010:\u001A\u00020;J\u000E\u0010<\u001A\u00020$2\u0006\u0010=\u001A\u00020>J\u000E\u0010?\u001A\u00020$2\u0006\u0010=\u001A\u00020>J\u000E\u0010@\u001A\u00020$2\u0006\u0010=\u001A\u00020>J\u0018\u0010A\u001A\u00020$2\b\u0010:\u001A\u0004\u0018\u00010\u00012\u0006\u0010B\u001A\u00020\u001AJ \u0010C\u001A\u00020$2\b\u0010:\u001A\u0004\u0018\u00010\u00012\u0006\u0010.\u001A\u00020/2\u0006\u0010B\u001A\u00020\u001AJ\u0018\u0010D\u001A\u00020$2\u0006\u0010.\u001A\u00020/2\b\u0010:\u001A\u0004\u0018\u00010\u0001J\u000E\u0010E\u001A\u00020$2\u0006\u0010F\u001A\u00020\u001AJ\u0006\u0010G\u001A\u00020$J\u0010\u0010H\u001A\u00020$2\b\u0010I\u001A\u0004\u0018\u00010\u0001J\u0006\u0010J\u001A\u00020$J\u0006\u0010K\u001A\u00020$J\u0006\u0010L\u001A\u00020$J\u0006\u0010M\u001A\u00020$J\u0016\u0010N\u001A\u00020$2\u0006\u0010.\u001A\u00020/2\u0006\u0010O\u001A\u00020PJ\u001E\u0010N\u001A\u00020$2\u0006\u0010.\u001A\u00020/2\u0006\u0010O\u001A\u00020P2\u0006\u0010Q\u001A\u00020RJ\u000E\u0010S\u001A\u00020$2\u0006\u0010T\u001A\u00020\u001AJ\"\u0010U\u001A\u00020$2\u0012\u0010V\u001A\u000E\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020$0W2\u0006\u0010Y\u001A\u00020XJ\u0010\u0010Z\u001A\u00020$2\b\u0010[\u001A\u0004\u0018\u00010\u0001J>\u0010\\\u001A\u00020$\"\u0004\b\u0000\u0010]\"\u0004\b\u0001\u0010^2\u0006\u0010:\u001A\u0002H^2\u001D\u00106\u001A\u0019\u0012\u0004\u0012\u0002H]\u0012\u0004\u0012\u0002H^\u0012\u0004\u0012\u00020$0_¢\u0006\u0002\b`¢\u0006\u0002\u0010aJ\u0016\u0010b\u001A\u00020$2\u0006\u0010c\u001A\u00020\u001A2\u0006\u0010F\u001A\u00020\u001AJ\u001E\u0010d\u001A\u00020$2\u0006\u0010O\u001A\u00020\u001A2\u0006\u0010e\u001A\u00020\u001A2\u0006\u0010F\u001A\u00020\u001AJ\u0006\u0010f\u001A\u00020$J\u0006\u0010g\u001A\u00020$J\u0016\u0010h\u001A\u00020$2\u0006\u0010c\u001A\u00020\u001A2\u0006\u0010i\u001A\u00020\u001AJ\b\u0010j\u001A\u00020$H\u0002J\u0018\u0010k\u001A\u00020$2\u0006\u0010\u001F\u001A\u00020\u001A2\u0006\u0010\"\u001A\u00020\u001AH\u0002J \u0010l\u001A\u00020$2\u0006\u0010e\u001A\u00020\u001A2\u0006\u0010O\u001A\u00020\u001A2\u0006\u0010F\u001A\u00020\u001AH\u0002J\u0006\u0010m\u001A\u00020$J\u0010\u0010n\u001A\u00020$2\b\u0010[\u001A\u0004\u0018\u00010\u0001J\b\u0010o\u001A\u00020$H\u0002J\u0014\u0010p\u001A\u00020$2\f\u0010q\u001A\b\u0012\u0004\u0012\u00020$07J\u0016\u0010r\u001A\u00020$2\u0006\u0010s\u001A\u00020t2\u0006\u0010.\u001A\u00020/J\u001E\u0010u\u001A\u00020$2\u000E\u0010v\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010w2\u0006\u0010x\u001A\u00020tJ(\u0010y\u001A\u00020$2\b\u0010z\u001A\u0004\u0018\u00010{2\u0006\u0010|\u001A\u00020}2\u0006\u0010O\u001A\u00020~2\u0006\u0010e\u001A\u00020~J \u0010\u007F\u001A\u00020$2\u0007\u0010Y\u001A\u00030\u0080\u00012\u0006\u0010|\u001A\u00020}2\u0007\u0010\u0081\u0001\u001A\u00020~J\u0007\u0010\u0082\u0001\u001A\u00020$J\u001C\u0010\u0083\u0001\u001A\u00020$2\u0007\u0010\u0084\u0001\u001A\u00020\u00052\n\b\u0002\u0010x\u001A\u0004\u0018\u00010tJ\u0007\u0010\u0085\u0001\u001A\u00020$J\u0007\u0010\u0086\u0001\u001A\u00020$J\u0007\u0010\u0087\u0001\u001A\u00020$R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0014\u001A\u00020\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\u001C\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001ER\u000E\u0010\u001F\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u00102\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b3\u0010\u0016¨\u0006\u0089\u0001"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/ComposerChangeListWriter;", "", "composer", "Landroidx/compose/runtime/GapComposer;", "changeList", "Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;", "<init>", "(Landroidx/compose/runtime/GapComposer;Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;)V", "getChangeList", "()Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;", "setChangeList", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;)V", "reader", "Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "getReader", "()Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "startedGroup", "", "startedGroups", "Landroidx/compose/runtime/IntStack;", "implicitRootStart", "getImplicitRootStart", "()Z", "setImplicitRootStart", "(Z)V", "writersReaderDelta", "", "pendingUps", "pendingDownNodes", "Landroidx/compose/runtime/Stack;", "Ljava/util/ArrayList;", "removeFrom", "moveFrom", "moveTo", "moveCount", "pushApplierOperationPreamble", "", "pushSlotEditingOperationPreamble", "pushSlotTableOperationPreamble", "useParentSlot", "moveReaderRelativeTo", "location", "moveReaderToAbsolute", "recordSlotEditing", "ensureRootStarted", "ensureGroupStarted", "anchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "realizeOperationLocation", "forParent", "pastParent", "getPastParent", "withChangeList", "newChangeList", "block", "Lkotlin/Function0;", "withoutImplicitRootStart", "remember", "value", "Landroidx/compose/runtime/RememberObserverHolder;", "rememberPausingScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "startResumingScope", "endResumingScope", "updateValue", "groupSlotIndex", "updateAnchoredValue", "appendValue", "trimValues", "count", "resetSlots", "updateAuxData", "data", "endRoot", "endCurrentGroup", "skipToEndOfCurrentGroup", "removeCurrentGroup", "insertSlots", "from", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "fixups", "Landroidx/compose/runtime/composer/gapbuffer/changelist/FixupList;", "moveCurrentGroup", "offset", "endCompositionScope", "action", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "composition", "useNode", "node", "updateNode", "T", "V", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeNode", "nodeIndex", "moveNode", "to", "releaseMovableContent", "endNodeMovement", "endNodeMovementAndDeleteNode", "group", "realizeNodeMovementOperations", "realizeRemoveNode", "realizeMoveNode", "moveUp", "moveDown", "pushPendingUpsAndDowns", "sideEffect", "effect", "determineMovableContentNodeIndex", "effectiveNodeIndexOut", "Landroidx/compose/runtime/internal/IntRef;", "copyNodesToNewAnchorLocation", "nodes", "", "effectiveNodeIndex", "copySlotTableToAnchorLocation", "resolvedState", "Landroidx/compose/runtime/MovableContentState;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/MovableContentStateReference;", "releaseMovableGroupAtCurrent", "Landroidx/compose/runtime/ControlledComposition;", "reference", "endMovableContentPlacement", "includeOperationsIn", "other", "finalizeComposition", "resetTransientState", "deactivateCurrentGroup", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ComposerChangeListWriter {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/ComposerChangeListWriter$Companion;", "", "<init>", "()V", "invalidGroupLocation", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private ChangeList changeList;
    private final GapComposer composer;
    private boolean implicitRootStart;
    private static final int invalidGroupLocation = -2;
    private int moveCount;
    private int moveFrom;
    private int moveTo;
    private final ArrayList pendingDownNodes;
    private int pendingUps;
    private int removeFrom;
    private boolean startedGroup;
    private final IntStack startedGroups;
    private int writersReaderDelta;

    static {
        ComposerChangeListWriter.Companion = new Companion(null);
        ComposerChangeListWriter.$stable = 8;
    }

    public ComposerChangeListWriter(GapComposer arg1, ChangeList arg2) {
        super();
        this.composer = arg1;
        this.changeList = arg2;
        this.startedGroups = new IntStack();
        this.implicitRootStart = true;
        this.pendingDownNodes = Stack.constructor-impl$default(null, 1, null);
        this.removeFrom = -1;
        this.moveFrom = -1;
        this.moveTo = -1;
    }

    public final void appendValue(GapAnchor arg1, Object arg2) {
        this.changeList.pushAppendValue(arg1, arg2);
    }

    public final void copyNodesToNewAnchorLocation(List arg1, IntRef arg2) {
        this.changeList.pushCopyNodesToNewAnchorLocation(arg1, arg2);
    }

    public final void copySlotTableToAnchorLocation(MovableContentState arg1, CompositionContext arg2, MovableContentStateReference arg3, MovableContentStateReference arg4) {
        this.changeList.pushCopySlotTableToAnchorLocation(arg1, arg2, arg3, arg4);
    }

    public final void deactivateCurrentGroup() {
        ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushDeactivateCurrentGroup();
    }

    public final void determineMovableContentNodeIndex(IntRef arg1, GapAnchor arg2) {
        this.pushPendingUpsAndDowns();
        this.changeList.pushDetermineMovableContentNodeIndex(arg1, arg2);
    }

    public final void endCompositionScope(Function1 arg1, Composition arg2) {
        this.changeList.pushEndCompositionScope(arg1, arg2);
    }

    public final void endCurrentGroup() {
        int v0 = this.getReader().getParent();
        int v2 = -1;
        int v1 = this.startedGroups.peekOr(v2) <= v0 ? 1 : 0;
        if(v1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup");
        }

        if(this.startedGroups.peekOr(v2) == v0) {
            ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, false, 1, null);
            this.startedGroups.pop();
            this.changeList.pushEndCurrentGroup();
        }
    }

    public final void endMovableContentPlacement() {
        this.pushPendingUpsAndDowns();
        this.changeList.pushEndMovableContentPlacement();
        this.writersReaderDelta = 0;
    }

    public final void endNodeMovement() {
        this.realizeNodeMovementOperations();
    }

    public final void endNodeMovementAndDeleteNode(int arg2, int arg3) {
        this.endNodeMovement();
        this.pushPendingUpsAndDowns();
        arg3 = this.getReader().isNode(arg3) ? 1 : this.getReader().nodeCount(arg3);
        if(arg3 > 0) {
            this.removeNode(arg2, arg3);
        }
    }

    public final void endResumingScope(RecomposeScopeImpl arg1) {
        this.changeList.pushEndResumingScope(arg1);
    }

    public final void endRoot() {
        if(this.startedGroup) {
            ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, false, 1, null);
            ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, false, 1, null);
            this.changeList.pushEndCurrentGroup();
            this.startedGroup = false;
        }
    }

    private final void ensureGroupStarted(GapAnchor arg4) {
        ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushEnsureGroupStarted(arg4);
        this.startedGroup = true;
    }

    private final void ensureRootStarted() {
        if(!this.startedGroup && (this.implicitRootStart)) {
            ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, false, 1, null);
            this.changeList.pushEnsureRootStarted();
            this.startedGroup = true;
        }
    }

    public final void finalizeComposition() {
        this.pushPendingUpsAndDowns();
        int v0 = this.startedGroups.tos == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup()");
        }
    }

    public final ChangeList getChangeList() {
        return this.changeList;
    }

    public final boolean getImplicitRootStart() {
        return this.implicitRootStart;
    }

    public final boolean getPastParent() {
        if(this.getReader().getParent() - this.writersReaderDelta < 0) {
            return 1;
        }

        return 0;
    }

    private final SlotReader getReader() {
        return this.composer.getReader$runtime();
    }

    public final void includeOperationsIn(ChangeList arg1, IntRef arg2) {
        this.changeList.pushExecuteOperationsIn(arg1, arg2);
    }

    public static void includeOperationsIn$default(ComposerChangeListWriter arg0, ChangeList arg1, IntRef arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        arg0.includeOperationsIn(arg1, arg2);
    }

    public final void insertSlots(GapAnchor arg1, SlotTable arg2) {
        this.pushPendingUpsAndDowns();
        this.pushSlotEditingOperationPreamble();
        this.realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(arg1, arg2);
    }

    public final void insertSlots(GapAnchor arg1, SlotTable arg2, FixupList arg3) {
        this.pushPendingUpsAndDowns();
        this.pushSlotEditingOperationPreamble();
        this.realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(arg1, arg2, arg3);
    }

    public final void moveCurrentGroup(int arg1) {
        this.pushSlotEditingOperationPreamble();
        this.changeList.pushMoveCurrentGroup(arg1);
    }

    public final void moveDown(Object arg1) {
        this.realizeNodeMovementOperations();
        Stack.push-impl(this.pendingDownNodes, arg1);
    }

    public final void moveNode(int arg4, int arg5, int arg6) {
        if(arg6 > 0) {
            int v0 = this.moveCount;
            if(v0 > 0 && this.moveFrom == arg4 - v0 && this.moveTo == arg5 - v0) {
                this.moveCount = v0 + arg6;
                return;
            }

            this.realizeNodeMovementOperations();
            this.moveFrom = arg4;
            this.moveTo = arg5;
            this.moveCount = arg6;
        }
    }

    public final void moveReaderRelativeTo(int arg3) {
        this.writersReaderDelta += arg3 - this.getReader().getCurrentGroup();
    }

    public final void moveReaderToAbsolute(int arg1) {
        this.writersReaderDelta = arg1;
    }

    public final void moveUp() {
        this.realizeNodeMovementOperations();
        if(Stack.isNotEmpty-impl(this.pendingDownNodes)) {
            Stack.pop-impl(this.pendingDownNodes);
            return;
        }

        int v0 = this.pendingUps;
        this.pendingUps = v0 + 1;
        Integer.valueOf(v0);
    }

    private final void pushApplierOperationPreamble() {
        this.pushPendingUpsAndDowns();
    }

    private final void pushPendingUpsAndDowns() {
        int v0 = this.pendingUps;
        if(v0 > 0) {
            this.changeList.pushUps(v0);
            this.pendingUps = 0;
        }

        if(Stack.isNotEmpty-impl(this.pendingDownNodes)) {
            this.changeList.pushDowns(Stack.toArray-impl(this.pendingDownNodes));
            Stack.clear-impl(this.pendingDownNodes);
        }
    }

    private final void pushSlotEditingOperationPreamble() {
        ComposerChangeListWriter.realizeOperationLocation$default(this, false, 1, null);
        this.recordSlotEditing();
    }

    private final void pushSlotTableOperationPreamble(boolean arg1) {
        this.realizeOperationLocation(arg1);
    }

    static void pushSlotTableOperationPreamble$default(ComposerChangeListWriter arg0, boolean arg1, int arg2, Object arg3) {
        arg0.pushSlotTableOperationPreamble(false);
    }

    private final void realizeMoveNode(int arg1, int arg2, int arg3) {
        this.pushApplierOperationPreamble();
        this.changeList.pushMoveNode(arg1, arg2, arg3);
    }

    private final void realizeNodeMovementOperations() {
        int v0 = this.moveCount;
        if(v0 > 0) {
            int v1 = this.removeFrom;
            int v2 = -1;
            if(v1 >= 0) {
                this.realizeRemoveNode(v1, v0);
                this.removeFrom = v2;
            }
            else {
                this.realizeMoveNode(this.moveTo, this.moveFrom, v0);
                this.moveFrom = v2;
                this.moveTo = v2;
            }

            this.moveCount = 0;
        }
    }

    private final void realizeOperationLocation(boolean arg3) {
        int v3 = arg3 ? this.getReader().getParent() : this.getReader().getCurrentGroup();
        int v0 = v3 - this.writersReaderDelta;
        int v1 = v0 >= 0 ? 1 : 0;
        if(v1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Tried to seek backward");
        }

        if(v0 > 0) {
            this.changeList.pushAdvanceSlotsBy(v0);
            this.writersReaderDelta = v3;
        }
    }

    static void realizeOperationLocation$default(ComposerChangeListWriter arg0, boolean arg1, int arg2, Object arg3) {
        arg0.realizeOperationLocation(false);
    }

    private final void realizeRemoveNode(int arg1, int arg2) {
        this.pushApplierOperationPreamble();
        this.changeList.pushRemoveNode(arg1, arg2);
    }

    public final void recordSlotEditing() {
        if(this.getReader().getSize() > 0) {
            SlotReader v0 = this.getReader();
            int v1 = v0.getParent();
            if(this.startedGroups.peekOr(-2) != v1) {
                this.ensureRootStarted();
                if(v1 > 0) {
                    GapAnchor v0_1 = v0.anchor(v1);
                    this.startedGroups.push(v1);
                    this.ensureGroupStarted(v0_1);
                }
            }
        }
    }

    public final void releaseMovableContent() {
        this.pushPendingUpsAndDowns();
        if(this.startedGroup) {
            this.skipToEndOfCurrentGroup();
            this.endRoot();
        }
    }

    public final void releaseMovableGroupAtCurrent(ControlledComposition arg1, CompositionContext arg2, MovableContentStateReference arg3) {
        this.changeList.pushReleaseMovableGroupAtCurrent(arg1, arg2, arg3);
    }

    public final void remember(RememberObserverHolder arg1) {
        this.changeList.pushRemember(arg1);
    }

    public final void rememberPausingScope(RecomposeScopeImpl arg1) {
        this.changeList.pushRememberPausingScope(arg1);
    }

    public final void removeCurrentGroup() {
        this.pushSlotEditingOperationPreamble();
        this.changeList.pushRemoveCurrentGroup();
        this.writersReaderDelta += this.getReader().getGroupSize();
    }

    public final void removeNode(int arg3, int arg4) {
        if(arg4 > 0) {
            int v0 = arg3 >= 0 ? 1 : 0;
            if(v0 == 0) {
                ComposerKt.composeImmediateRuntimeError("Invalid remove index " + arg3);
            }

            if(this.removeFrom == arg3) {
                this.moveCount += arg4;
                return;
            }

            this.realizeNodeMovementOperations();
            this.removeFrom = arg3;
            this.moveCount = arg4;
        }
    }

    public final void resetSlots() {
        this.changeList.pushResetSlots();
    }

    public final void resetTransientState() {
        this.startedGroup = false;
        this.startedGroups.clear();
        this.writersReaderDelta = 0;
        this.implicitRootStart = true;
        this.pendingUps = 0;
        Stack.clear-impl(this.pendingDownNodes);
        this.removeFrom = -1;
        this.moveFrom = -1;
        this.moveTo = -1;
        this.moveCount = 0;
    }

    public final void setChangeList(ChangeList arg1) {
        this.changeList = arg1;
    }

    public final void setImplicitRootStart(boolean arg1) {
        this.implicitRootStart = arg1;
    }

    public final void sideEffect(Function0 arg1) {
        this.changeList.pushSideEffect(arg1);
    }

    public final void skipToEndOfCurrentGroup() {
        this.changeList.pushSkipToEndOfCurrentGroup();
    }

    public final void startResumingScope(RecomposeScopeImpl arg1) {
        this.changeList.pushStartResumingScope(arg1);
    }

    public final void trimValues(int arg1) {
        if(arg1 > 0) {
            this.pushSlotEditingOperationPreamble();
            this.changeList.pushTrimValues(arg1);
        }
    }

    public final void updateAnchoredValue(Object arg1, GapAnchor arg2, int arg3) {
        this.changeList.pushUpdateAnchoredValue(arg1, arg2, arg3);
    }

    public final void updateAuxData(Object arg4) {
        ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushUpdateAuxData(arg4);
    }

    public final void updateNode(Object arg1, Function2 arg2) {
        this.pushApplierOperationPreamble();
        this.changeList.pushUpdateNode(arg1, arg2);
    }

    public final void updateValue(Object arg2, int arg3) {
        this.pushSlotTableOperationPreamble(true);
        this.changeList.pushUpdateValue(arg2, arg3);
    }

    public final void useNode(Object arg1) {
        this.pushApplierOperationPreamble();
        this.changeList.pushUseNode(arg1);
    }

    public final void withChangeList(ChangeList arg2, Function0 arg3) {
        ChangeList v0 = this.getChangeList();
        try {
            this.setChangeList(arg2);
            arg3.invoke();
        }
        catch(Throwable v2) {
            this.setChangeList(v0);
            throw v2;
        }

        this.setChangeList(v0);
    }

    public final void withoutImplicitRootStart(Function0 arg3) {
        boolean v0 = this.getImplicitRootStart();
        try {
            this.setImplicitRootStart(false);
            arg3.invoke();
        }
        catch(Throwable v3) {
            this.setImplicitRootStart(v0);
            throw v3;
        }

        this.setImplicitRootStart(v0);
    }
}

