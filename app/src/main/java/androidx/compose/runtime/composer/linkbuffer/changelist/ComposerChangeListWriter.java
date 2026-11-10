package androidx.compose.runtime.composer.linkbuffer.changelist;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.LinkComposer;
import androidx.compose.runtime.LinkRememberObserverHolder;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.composer.linkbuffer.GroupHandleKt;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchor;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableReader;
import androidx.compose.runtime.internal.IntRef;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010(\u001A\u00020)H\u0002J\b\u0010*\u001A\u00020)H\u0002J\b\u0010+\u001A\u00020)H\u0002J\u0006\u0010,\u001A\u00020)J\u001C\u0010-\u001A\u00020)2\n\u0010.\u001A\u00060&j\u0002`\'2\b\b\u0002\u0010/\u001A\u00020\u0011J\u0017\u00101\u001A\u00020)2\f\u00102\u001A\b\u0012\u0004\u0012\u00020)03H\u0086\bJ#\u00104\u001A\u00020)2\n\u00105\u001A\u00060&j\u0002`\'2\f\u00102\u001A\b\u0012\u0004\u0012\u00020)03H\u0086\bJ\u001F\u00106\u001A\u00020)2\u0006\u00107\u001A\u00020 2\f\u00102\u001A\b\u0012\u0004\u0012\u00020)03H\u0082\bJ\u001F\u00108\u001A\u00020)2\u0006\u00109\u001A\u00020\u00052\f\u00102\u001A\b\u0012\u0004\u0012\u00020)03H\u0086\bJ\u0017\u0010:\u001A\u00020)2\f\u00102\u001A\b\u0012\u0004\u0012\u00020)03H\u0086\bJ\u000E\u0010;\u001A\u00020)2\u0006\u0010<\u001A\u00020=J\u000E\u0010>\u001A\u00020)2\u0006\u0010?\u001A\u00020@J\u000E\u0010A\u001A\u00020)2\u0006\u0010?\u001A\u00020@J\u000E\u0010B\u001A\u00020)2\u0006\u0010?\u001A\u00020@J\u0016\u0010C\u001A\u00020)2\u0006\u0010D\u001A\u00020E2\u0006\u0010F\u001A\u00020GJ\u0018\u0010H\u001A\u00020)2\u0006\u0010I\u001A\u00020\u00172\b\u0010<\u001A\u0004\u0018\u00010\u0001J\u0010\u0010J\u001A\u00020)2\b\u0010<\u001A\u0004\u0018\u00010\u0001J\u001A\u0010K\u001A\u00020)2\n\u0010L\u001A\u00060\u0017j\u0002`M2\u0006\u0010N\u001A\u00020\u0017J\u0006\u0010O\u001A\u00020)J\u0010\u0010P\u001A\u00020)2\b\u0010Q\u001A\u0004\u0018\u00010\u0001J\u0006\u0010R\u001A\u00020)J\u001A\u0010S\u001A\u00020)2\u0006\u0010T\u001A\u00020U2\n\u0010V\u001A\u00060&j\u0002`\'J\"\u0010S\u001A\u00020)2\u0006\u0010T\u001A\u00020U2\n\u0010V\u001A\u00060&j\u0002`\'2\u0006\u0010W\u001A\u00020XJ\u000E\u0010Y\u001A\u00020)2\u0006\u0010Z\u001A\u00020\u0017J\"\u0010[\u001A\u00020)2\u0012\u0010\\\u001A\u000E\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020)0]2\u0006\u0010_\u001A\u00020^J\u0010\u0010`\u001A\u00020)2\b\u0010a\u001A\u0004\u0018\u00010\u0001J>\u0010b\u001A\u00020)\"\u0004\b\u0000\u0010c\"\u0004\b\u0001\u0010d2\u0006\u0010<\u001A\u0002Hd2\u001D\u00102\u001A\u0019\u0012\u0004\u0012\u0002Hc\u0012\u0004\u0012\u0002Hd\u0012\u0004\u0012\u00020)0e¢\u0006\u0002\bf¢\u0006\u0002\u0010gJ\u0016\u0010h\u001A\u00020)2\u0006\u0010i\u001A\u00020\u00172\u0006\u0010N\u001A\u00020\u0017J\u001E\u0010j\u001A\u00020)2\u0006\u0010k\u001A\u00020\u00172\u0006\u0010l\u001A\u00020\u00172\u0006\u0010N\u001A\u00020\u0017J\u0006\u0010m\u001A\u00020)J\u001A\u0010n\u001A\u00020)2\u0006\u0010i\u001A\u00020\u00172\n\u0010o\u001A\u00060\u0017j\u0002`MJ\b\u0010p\u001A\u00020)H\u0002J\u0018\u0010q\u001A\u00020)2\u0006\u0010i\u001A\u00020\u00172\u0006\u0010r\u001A\u00020\u0017H\u0002J \u0010s\u001A\u00020)2\u0006\u0010t\u001A\u00020\u00172\u0006\u0010u\u001A\u00020\u00172\u0006\u0010N\u001A\u00020\u0017H\u0002J\u0006\u0010v\u001A\u00020)J\u0010\u0010w\u001A\u00020)2\b\u0010a\u001A\u0004\u0018\u00010\u0001J\b\u0010x\u001A\u00020)H\u0002J\u0014\u0010y\u001A\u00020)2\f\u0010z\u001A\b\u0012\u0004\u0012\u00020)03J\u001A\u0010{\u001A\u00020)2\u0006\u0010|\u001A\u00020}2\n\u0010.\u001A\u00060&j\u0002`\'J \u0010~\u001A\u00020)2\u000F\u0010\u007F\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0080\u00012\u0007\u0010\u0081\u0001\u001A\u00020}J/\u0010\u0082\u0001\u001A\u00020)2\n\u0010\u0083\u0001\u001A\u0005\u0018\u00010\u0084\u00012\b\u0010\u0085\u0001\u001A\u00030\u0086\u00012\u0007\u0010u\u001A\u00030\u0087\u00012\u0007\u0010t\u001A\u00030\u0087\u0001J$\u0010\u0088\u0001\u001A\u00020)2\u0007\u0010_\u001A\u00030\u0089\u00012\b\u0010\u0085\u0001\u001A\u00030\u0086\u00012\b\u0010\u008A\u0001\u001A\u00030\u0087\u0001J\u0007\u0010\u008B\u0001\u001A\u00020)J\u0013\u0010\u008C\u0001\u001A\u00020)2\n\u0010\u0083\u0001\u001A\u0005\u0018\u00010\u0084\u0001J\u001D\u0010\u008D\u0001\u001A\u00020)2\u0007\u0010\u008E\u0001\u001A\u00020\u00052\u000B\b\u0002\u0010\u0081\u0001\u001A\u0004\u0018\u00010}J\u0007\u0010\u008F\u0001\u001A\u00020)J\u0007\u0010\u0090\u0001\u001A\u00020)J\u0007\u0010\u0091\u0001\u001A\u00020)R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001AR\u000E\u0010\u001B\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u001F\u001A\u00020 X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0012\u0010%\u001A\u00060&j\u0002`\'X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u00100\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b0\u0010\u0013¨\u0006\u0092\u0001"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriter;", "", "composer", "Landroidx/compose/runtime/LinkComposer;", "changeList", "Landroidx/compose/runtime/composer/linkbuffer/changelist/ChangeList;", "<init>", "(Landroidx/compose/runtime/LinkComposer;Landroidx/compose/runtime/composer/linkbuffer/changelist/ChangeList;)V", "getChangeList", "()Landroidx/compose/runtime/composer/linkbuffer/changelist/ChangeList;", "setChangeList", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/ChangeList;)V", "reader", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "getReader", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "implicitRootStart", "", "getImplicitRootStart", "()Z", "setImplicitRootStart", "(Z)V", "pendingUps", "", "pendingDownNodes", "Landroidx/compose/runtime/Stack;", "Ljava/util/ArrayList;", "removeFromNodeIndex", "moveFromNodeIndex", "moveToNodeIndex", "moveCount", "addressMode", "Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriterAddressMode;", "getAddressMode$runtime", "()Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriterAddressMode;", "setAddressMode$runtime", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriterAddressMode;)V", "editorCurrentPosition", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "pushApplierOperationPreamble", "", "pushSlotOperationPreamble", "pushSlotOperationPreambleUnconditionally", "startComposition", "seekTo", "handle", "resetRelativeAddressing", "isInAnchorMode", "inAnchorMode", "block", "Lkotlin/Function0;", "inRelativeAddressMode", "relativeStart", "inMode", "newMode", "withChangeList", "newChangeList", "withoutImplicitRootStart", "remember", "value", "Landroidx/compose/runtime/RememberObserverHolder;", "rememberPausingScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "startResumingScope", "endResumingScope", "updateRememberOrdering", "holder", "Landroidx/compose/runtime/LinkRememberObserverHolder;", "after", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "updateValue", "slotIndex", "appendValue", "removeTailGroupsAndValues", "firstTailGroupToRemove", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "count", "resetSlots", "updateAuxData", "data", "removeGroup", "insertSlots", "sourceTable", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "source", "fixups", "Landroidx/compose/runtime/composer/linkbuffer/changelist/FixupList;", "moveGroup", "offset", "endCompositionScope", "action", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "composition", "useNode", "node", "updateNode", "T", "V", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeNode", "nodeIndex", "moveNode", "fromNodeIndex", "toNodeIndex", "endNodeMovement", "endNodeMovementAndDeleteNode", "group", "realizeNodeMovementOperations", "realizeRemoveNode", "removeCount", "realizeMoveNode", "to", "from", "moveUp", "moveDown", "pushPendingUpsAndDowns", "sideEffect", "effect", "determineMovableContentNodeIndex", "effectiveNodeIndexOut", "Landroidx/compose/runtime/internal/IntRef;", "copyNodesToNewAnchorLocation", "nodes", "", "effectiveNodeIndex", "copySlotTableToAnchorLocation", "resolvedState", "Landroidx/compose/runtime/MovableContentState;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/MovableContentStateReference;", "releaseMovableGroup", "Landroidx/compose/runtime/ControlledComposition;", "reference", "endMovableContentPlacement", "disposeResolvedMovableState", "includeOperationsIn", "other", "finalizeComposition", "resetTransientState", "deactivateCurrentGroup", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ComposerChangeListWriter {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ComposerChangeListWriterAddressMode.values().length];
            try {
                v0[ComposerChangeListWriterAddressMode.AbsoluteAddressing.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ComposerChangeListWriterAddressMode.AnchorAddressing.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[ComposerChangeListWriterAddressMode.RelativeAddressing.ordinal()] = 3;
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
    private ComposerChangeListWriterAddressMode addressMode;
    private ChangeList changeList;
    private final LinkComposer composer;
    private long editorCurrentPosition;
    private boolean implicitRootStart;
    private int moveCount;
    private int moveFromNodeIndex;
    private int moveToNodeIndex;
    private final ArrayList pendingDownNodes;
    private int pendingUps;
    private int removeFromNodeIndex;

    static {
    }

    public ComposerChangeListWriter(LinkComposer arg1, ChangeList arg2) {
        super();
        this.composer = arg1;
        this.changeList = arg2;
        this.implicitRootStart = true;
        this.pendingDownNodes = Stack.constructor-impl$default(null, 1, null);
        this.removeFromNodeIndex = -1;
        this.moveFromNodeIndex = -1;
        this.moveToNodeIndex = -1;
        this.moveCount = -1;
        this.addressMode = ComposerChangeListWriterAddressMode.AbsoluteAddressing;
        this.editorCurrentPosition = -1;
    }

    public static final long access$getEditorCurrentPosition$p(ComposerChangeListWriter arg2) {
        return arg2.editorCurrentPosition;
    }

    public static final void access$setEditorCurrentPosition$p(ComposerChangeListWriter arg0, long arg1) {
        arg0.editorCurrentPosition = arg1;
    }

    public final void appendValue(Object arg1) {
        this.pushSlotOperationPreamble();
        this.changeList.pushAppendValue(arg1);
    }

    public final void copyNodesToNewAnchorLocation(List arg1, IntRef arg2) {
        this.changeList.pushCopyNodesToNewAnchorLocation(arg1, arg2);
    }

    public final void copySlotTableToAnchorLocation(MovableContentState arg1, CompositionContext arg2, MovableContentStateReference arg3, MovableContentStateReference arg4) {
        this.changeList.pushCopySlotTableToAnchorLocation(arg1, arg2, arg3, arg4);
    }

    public final void deactivateCurrentGroup() {
        this.pushSlotOperationPreamble();
        this.changeList.pushDeactivateGroup();
    }

    public final void determineMovableContentNodeIndex(IntRef arg2, long arg3) {
        this.pushPendingUpsAndDowns();
        this.changeList.pushDetermineMovableContentNodeIndex(arg2, arg3);
        this.editorCurrentPosition = arg3;
    }

    public final void disposeResolvedMovableState(MovableContentState arg1) {
        if(arg1 != null) {
            this.changeList.pushDisposeDisposeMovableContentState(arg1);
        }
    }

    public final void endCompositionScope(Function1 arg1, Composition arg2) {
        this.changeList.pushEndCompositionScope(arg1, arg2);
    }

    public final void endMovableContentPlacement() {
        this.changeList.pushEndMovableContentPlacement();
        this.pendingUps = 0;
    }

    public final void endNodeMovement() {
        this.realizeNodeMovementOperations();
    }

    public final void endNodeMovementAndDeleteNode(int arg3, int arg4) {
        this.endNodeMovement();
        this.pushPendingUpsAndDowns();
        arg4 = this.getReader().flagsOf(arg4);
        if((arg4 & 0x800000) == 0x800000) {
            arg4 = 1;
        }
        else {
            arg4 &= 0x7FFFFF;
        }

        this.removeNode(arg3, arg4);
    }

    public final void endResumingScope(RecomposeScopeImpl arg1) {
        this.changeList.pushEndResumingScope(arg1);
    }

    public final void finalizeComposition() {
        this.pushPendingUpsAndDowns();
        this.changeList.pushClearAllRecompositionRequiredGroups();
        this.editorCurrentPosition = -1;
    }

    public final ComposerChangeListWriterAddressMode getAddressMode$runtime() {
        return this.addressMode;
    }

    public final ChangeList getChangeList() {
        return this.changeList;
    }

    public final boolean getImplicitRootStart() {
        return this.implicitRootStart;
    }

    private final SlotTableReader getReader() {
        return this.composer.getReader$runtime();
    }

    public final void inAnchorMode(Function0 arg7) {
        long v0 = -1;
        this.editorCurrentPosition = v0;
        ComposerChangeListWriterAddressMode v2 = ComposerChangeListWriterAddressMode.AnchorAddressing;
        ComposerChangeListWriterAddressMode v3 = this.getAddressMode$runtime();
        long v4 = this.editorCurrentPosition;
        this.setAddressMode$runtime(v2);
        try {
            arg7.invoke();
        }
        catch(Throwable v7) {
            this.setAddressMode$runtime(v3);
            if(v3 == ComposerChangeListWriterAddressMode.RelativeAddressing) {
                v0 = v4;
            }

            this.editorCurrentPosition = v0;
            throw v7;
        }

        this.setAddressMode$runtime(v3);
        if(v3 == ComposerChangeListWriterAddressMode.RelativeAddressing) {
            v0 = v4;
        }

        this.editorCurrentPosition = v0;
    }

    private final void inMode(ComposerChangeListWriterAddressMode arg6, Function0 arg7) {
        ComposerChangeListWriterAddressMode v0 = this.getAddressMode$runtime();
        long v1 = this.editorCurrentPosition;
        this.setAddressMode$runtime(arg6);
        long v3 = -1;
        try {
            arg7.invoke();
        }
        catch(Throwable v6) {
            this.setAddressMode$runtime(v0);
            if(v0 == ComposerChangeListWriterAddressMode.RelativeAddressing) {
            }
            else {
                v1 = v3;
            }

            this.editorCurrentPosition = v1;
            throw v6;
        }

        this.setAddressMode$runtime(v0);
        if(v0 == ComposerChangeListWriterAddressMode.RelativeAddressing) {
        }
        else {
            v1 = v3;
        }

        this.editorCurrentPosition = v1;
    }

    public final void inRelativeAddressMode(long arg5, Function0 arg7) {
        this.editorCurrentPosition = arg5;
        ComposerChangeListWriterAddressMode v5 = ComposerChangeListWriterAddressMode.RelativeAddressing;
        ComposerChangeListWriterAddressMode v6 = this.getAddressMode$runtime();
        long v0 = this.editorCurrentPosition;
        this.setAddressMode$runtime(v5);
        long v2 = -1;
        try {
            arg7.invoke();
        }
        catch(Throwable v5_1) {
            this.setAddressMode$runtime(v6);
            if(v6 == ComposerChangeListWriterAddressMode.RelativeAddressing) {
            }
            else {
                v0 = v2;
            }

            this.editorCurrentPosition = v0;
            throw v5_1;
        }

        this.setAddressMode$runtime(v6);
        if(v6 == ComposerChangeListWriterAddressMode.RelativeAddressing) {
        }
        else {
            v0 = v2;
        }

        this.editorCurrentPosition = v0;
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

    public final void insertSlots(SlotTable arg3, long arg4) {
        int v0 = arg4 != -1 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Tried moving from an unspecified position");
        }

        this.pushPendingUpsAndDowns();
        this.pushSlotOperationPreamble();
        this.realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(arg3, arg4);
    }

    public final void insertSlots(SlotTable arg3, long arg4, FixupList arg6) {
        int v0 = arg4 != -1 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Tried moving from an unspecified position");
        }

        this.pushPendingUpsAndDowns();
        this.pushSlotOperationPreamble();
        this.realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(arg3, arg4, arg6);
    }

    public final boolean isInAnchorMode() {
        if(this.addressMode == ComposerChangeListWriterAddressMode.AnchorAddressing) {
            return 1;
        }

        return 0;
    }

    public final void moveDown(Object arg1) {
        this.realizeNodeMovementOperations();
        Stack.push-impl(this.pendingDownNodes, arg1);
    }

    public final void moveGroup(int arg3) {
        int v0 = arg3 >= 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Offset must not be negative");
        }

        this.pushSlotOperationPreambleUnconditionally();
        this.changeList.pushMoveGroup(arg3);
        this.editorCurrentPosition = -1;
    }

    public final void moveNode(int arg3, int arg4, int arg5) {
        if(arg5 > 0) {
            int v0 = this.moveCount;
            if(v0 > 0 && this.moveFromNodeIndex == arg3 && this.moveToNodeIndex == arg4) {
                this.moveCount = v0 + arg5;
                return;
            }

            this.realizeNodeMovementOperations();
            this.moveToNodeIndex = arg4;
            this.moveFromNodeIndex = arg3;
            this.moveCount = arg5;
        }
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

    private final void pushSlotOperationPreamble() {
        long v2 = this.getReader().handle();
        if(this.editorCurrentPosition != v2) {
            ComposerChangeListWriter.seekTo$default(this, v2, false, 2, null);
        }
    }

    private final void pushSlotOperationPreambleUnconditionally() {
        ComposerChangeListWriter.seekTo$default(this, this.getReader().handle(), false, 2, null);
    }

    private final void realizeMoveNode(int arg1, int arg2, int arg3) {
        this.pushApplierOperationPreamble();
        this.changeList.pushMoveNode(arg1, arg2, arg3);
    }

    private final void realizeNodeMovementOperations() {
        int v0 = this.moveCount;
        if(v0 > 0) {
            int v1 = this.removeFromNodeIndex;
            int v2 = -1;
            if(v1 >= 0) {
                this.realizeRemoveNode(v1, v0);
                this.removeFromNodeIndex = v2;
            }
            else {
                this.realizeMoveNode(this.moveToNodeIndex, this.moveFromNodeIndex, v0);
                this.moveToNodeIndex = v2;
                this.moveFromNodeIndex = v2;
            }

            this.moveCount = 0;
        }
    }

    private final void realizeRemoveNode(int arg1, int arg2) {
        this.pushApplierOperationPreamble();
        this.changeList.pushRemoveNode(arg1, arg2);
    }

    public final void releaseMovableGroup(ControlledComposition arg2, CompositionContext arg3, MovableContentStateReference arg4) {
        this.changeList.pushReleaseMovableGroup(arg2, arg3, arg4);
        this.editorCurrentPosition = -1;
    }

    public final void remember(RememberObserverHolder arg1) {
        this.pushSlotOperationPreamble();
        this.changeList.pushRemember(arg1);
    }

    public final void rememberPausingScope(RecomposeScopeImpl arg1) {
        this.changeList.pushRememberPausingScope(arg1);
    }

    public final void removeGroup() {
        this.pushSlotOperationPreamble();
        this.changeList.pushRemoveGroup();
    }

    public final void removeNode(int arg2, int arg3) {
        if(arg3 > 0) {
            if(this.removeFromNodeIndex == arg2) {
                this.moveCount += arg3;
                return;
            }
            else {
                this.realizeNodeMovementOperations();
                this.removeFromNodeIndex = arg2;
                this.moveCount = arg3;
            }
        }
    }

    public final void removeTailGroupsAndValues(int arg1, int arg2) {
        if(arg1 < 0) {
            if(arg2 > 0) {
            }
            else {
                return;
            }
        }

        this.pushSlotOperationPreamble();
        this.changeList.pushRemoveTailGroupsAndValues(arg1, arg2);
    }

    public final void resetSlots() {
        this.changeList.pushResetSlots();
        this.editorCurrentPosition = -1;
    }

    public final void resetTransientState() {
        this.implicitRootStart = true;
        this.pendingUps = 0;
        Stack.clear-impl(this.pendingDownNodes);
        this.removeFromNodeIndex = -1;
        this.moveFromNodeIndex = -1;
        this.moveToNodeIndex = -1;
        this.moveCount = -1;
        this.editorCurrentPosition = -1;
    }

    public final void seekTo(long arg6, boolean arg8) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[this.addressMode.ordinal()];
        int v1 = 1;
        if(v0 == 1) {
            this.changeList.pushSeekToGroupHandle(arg6);
        }
        else if(v0 == 2) {
            this.changeList.pushSeekToAnchor(this.getReader().getTable().getAddressSpace(), arg6);
        }
        else if(v0 == 3) {
            v0 = GroupHandleKt.getGroup(arg6);
            int v2 = v0 == -1 ? GroupHandleKt.getContext(arg6) : this.getReader().parentOf(v0);
            if(v2 == GroupHandleKt.getGroup(this.editorCurrentPosition)) {
            }
            else {
                v1 = 0;
            }

            if(v1 == 0) {
                ComposerKt.composeImmediateRuntimeError("Relative addressing only supports navigating to a child of the current group");
            }

            this.changeList.pushStartGroup();
            for(v1 = this.getReader().firstChildOf(v2); v1 != v0; v1 = this.getReader().nextSiblingOf(v1)) {
                this.changeList.pushSkipGroup();
            }

            if(!arg8) {
                goto label_50;
            }

            this.addressMode = ComposerChangeListWriterAddressMode.AbsoluteAddressing;
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

    label_50:
        this.editorCurrentPosition = arg6;
    }

    public static void seekTo$default(ComposerChangeListWriter arg0, long arg1, boolean arg3, int arg4, Object arg5) {
        arg0.seekTo(arg1, false);
    }

    public final void setAddressMode$runtime(ComposerChangeListWriterAddressMode arg1) {
        this.addressMode = arg1;
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

    public final void startComposition() {
        Stack.clear-impl(this.pendingDownNodes);
        this.pendingUps = 0;
        this.removeFromNodeIndex = -1;
        this.moveFromNodeIndex = -1;
        this.moveToNodeIndex = -1;
        this.addressMode = ComposerChangeListWriterAddressMode.AbsoluteAddressing;
        this.editorCurrentPosition = -1;
    }

    public final void startResumingScope(RecomposeScopeImpl arg1) {
        this.changeList.pushStartResumingScope(arg1);
    }

    public final void updateAuxData(Object arg1) {
        this.pushSlotOperationPreamble();
        this.changeList.pushUpdateAuxData(arg1);
    }

    public final void updateNode(Object arg1, Function2 arg2) {
        this.pushApplierOperationPreamble();
        this.changeList.pushUpdateNode(arg1, arg2);
    }

    public final void updateRememberOrdering(LinkRememberObserverHolder arg2, LinkAnchor arg3) {
        if(!Intrinsics.areEqual(arg2.getAfter(), arg3)) {
            this.changeList.pushUpdateRememberObserverHolderOrdering(arg2, arg3);
        }
    }

    public final void updateValue(int arg1, Object arg2) {
        this.pushSlotOperationPreamble();
        this.changeList.pushUpdateRelativeValue(arg1, arg2);
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

