package androidx.compose.ui.draganddrop;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0001\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001EBD\u0012!\b\u0002\u0010\u0007\u001A\u001B\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\b¢\u0006\u0002\b\f\u0012\u0018\b\u0002\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000E¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010&\u001A\u00020\u000BH\u0016J\u0017\u0010\'\u001A\u00020\u000B2\u0006\u0010\u001F\u001A\u00020 H\u0016¢\u0006\u0004\b(\u0010$J\u0017\u0010*\u001A\u00020\u000B2\u0006\u0010+\u001A\u00020\nH\u0016¢\u0006\u0004\b,\u0010$J\'\u0010-\u001A\u00020\u000B*\u00020\t2\u0006\u0010+\u001A\u00020\n2\f\u0010.\u001A\b\u0012\u0004\u0012\u00020\u001D0/¢\u0006\u0004\b0\u00101J8\u00102\u001A\u00020\u000B2\u0006\u00103\u001A\u0002042\u0006\u00105\u001A\u0002062\u0017\u00107\u001A\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u000B0\u000E¢\u0006\u0002\b\fH\u0017¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001A\u00020\u001D2\u0006\u0010<\u001A\u00020\u000FH\u0016J\u0010\u0010=\u001A\u00020\u000B2\u0006\u0010>\u001A\u00020\u000FH\u0016J\u0010\u0010?\u001A\u00020\u000B2\u0006\u0010>\u001A\u00020\u000FH\u0016J\u0010\u0010@\u001A\u00020\u000B2\u0006\u0010>\u001A\u00020\u000FH\u0016J\u0010\u0010A\u001A\u00020\u000B2\u0006\u0010>\u001A\u00020\u000FH\u0016J\u0010\u0010B\u001A\u00020\u000B2\u0006\u0010>\u001A\u00020\u000FH\u0016J\u0010\u0010C\u001A\u00020\u001D2\u0006\u0010>\u001A\u00020\u000FH\u0016J\u0010\u0010D\u001A\u00020\u000B2\u0006\u0010>\u001A\u00020\u000FH\u0016R\'\u0010\u0007\u001A\u001B\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\b¢\u0006\u0002\b\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001A\u001A\u0004\u0018\u00010\u0000X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u001C\u001A\u00020\u001D8G¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001ER\u001C\u0010\u001F\u001A\u00020 X\u0080\u000E¢\u0006\u0010\n\u0002\u0010%\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010)\u001A\u00020\u001D8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b)\u0010\u001E¨\u0006F"}, d2={"Landroidx/compose/ui/draganddrop/DragAndDropNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "Landroidx/compose/ui/draganddrop/DragAndDropSourceModifierNode;", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "onStartTransfer", "Lkotlin/Function2;", "Landroidx/compose/ui/draganddrop/DragAndDropStartTransferScope;", "Landroidx/compose/ui/geometry/Offset;", "", "Lkotlin/ExtensionFunctionType;", "onDropTargetValidate", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "lastChildDragAndDropModifierNode", "thisDragAndDropTarget", "hasEligibleDropTarget", "", "()Z", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g$ui", "()J", "setSize-ozmzZPI$ui", "(J)V", "J", "onDetach", "onRemeasured", "onRemeasured-ozmzZPI", "isRequestDragAndDropTransferRequired", "requestDragAndDropTransfer", "offset", "requestDragAndDropTransfer-k-4lQ0M", "startDragAndDropTransfer", "isTransferStarted", "Lkotlin/Function0;", "startDragAndDropTransfer-d-4ec7I", "(Landroidx/compose/ui/draganddrop/DragAndDropStartTransferScope;JLkotlin/jvm/functions/Function0;)V", "drag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)V", "acceptDragAndDropTransfer", "startEvent", "onStarted", "event", "onEntered", "onMoved", "onChanged", "onExited", "onDrop", "onEnded", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragAndDropNode extends Node implements DragAndDropModifierNode, DragAndDropSourceModifierNode, DragAndDropTarget, DragAndDropTargetModifierNode, TraversableNode {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2={"Landroidx/compose/ui/draganddrop/DragAndDropNode$Companion;", "", "<init>", "()V", "DragAndDropTraversableKey", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/ui/draganddrop/DragAndDropNode$Companion$DragAndDropTraversableKey;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class DragAndDropTraversableKey {
            public static final DragAndDropTraversableKey INSTANCE;

            static {
                DragAndDropTraversableKey.INSTANCE = new DragAndDropTraversableKey();
            }

            private DragAndDropTraversableKey() {
                super();
            }
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable;
    private static final Companion Companion;
    private DragAndDropNode lastChildDragAndDropModifierNode;
    private final Function1 onDropTargetValidate;
    private Function2 onStartTransfer;
    private long size;
    private DragAndDropTarget thisDragAndDropTarget;
    private final Object traverseKey;

    static {
        DragAndDropNode.Companion = new Companion(null);
        DragAndDropNode.$stable = 8;
    }

    public DragAndDropNode(Function2 arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        Function2 v0 = null;
        if((arg4 & 1) != 0) {
            arg2 = v0;
        }

        if((arg4 & 2) != 0) {
            arg3 = ((Function1)v0);
        }

        this(arg2, arg3);
    }

    public DragAndDropNode() {
        this(null, null, 3, null);
    }

    public DragAndDropNode(Function2 arg1, Function1 arg2) {
        super();
        this.onStartTransfer = arg1;
        this.onDropTargetValidate = arg2;
        this.traverseKey = DragAndDropTraversableKey.INSTANCE;
        this.size = IntSize.Companion.getZero-YbymL2g();
    }

    public boolean acceptDragAndDropTransfer(DragAndDropEvent arg4) {
        BooleanRef v0 = new BooleanRef();
        DragAndDropNodeKt.access$traverseSelfAndDescendants(this, new DragAndDropNode$acceptDragAndDropTransfer$1(arg4, this, v0));
        return v0.element;
    }

    public static final DragAndDropManager access$getDragAndDropManager(DragAndDropNode arg0) {
        return arg0.getDragAndDropManager();
    }

    public static final Function1 access$getOnDropTargetValidate$p(DragAndDropNode arg0) {
        return arg0.onDropTargetValidate;
    }

    public static final Function2 access$getOnStartTransfer$p(DragAndDropNode arg0) {
        return arg0.onStartTransfer;
    }

    public static final DragAndDropTarget access$getThisDragAndDropTarget$p(DragAndDropNode arg0) {
        return arg0.thisDragAndDropTarget;
    }

    public static final void access$setLastChildDragAndDropModifierNode$p(DragAndDropNode arg0, DragAndDropNode arg1) {
        arg0.lastChildDragAndDropModifierNode = arg1;
    }

    public static final void access$setThisDragAndDropTarget$p(DragAndDropNode arg0, DragAndDropTarget arg1) {
        arg0.thisDragAndDropTarget = arg1;
    }

    @Deprecated(message="Use DragAndDropSourceModifierNode.requestDragAndDropTransfer instead") public void drag-12SF9DM(DragAndDropTransferData arg2, long arg3, Function1 arg5) {
        int v0 = this.onStartTransfer == null ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }

        this.onStartTransfer = new DragAndDropNode$drag$1(arg2, arg3, arg5);
        this.getDragAndDropManager().requestDragAndDropTransfer-Uv8p0NA(this, Offset.Companion.getUnspecified-F1C5BW0());
        this.onStartTransfer = null;
    }

    private final DragAndDropManager getDragAndDropManager() {
        return DelegatableNodeKt.requireOwner(((DelegatableNode)this)).getDragAndDropManager();
    }

    public final long getSize-YbymL2g$ui() {
        return this.size;
    }

    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public final boolean hasEligibleDropTarget() {
        if(this.lastChildDragAndDropModifierNode == null) {
            if(this.thisDragAndDropTarget != null) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isRequestDragAndDropTransferRequired() {
        return this.getDragAndDropManager().isRequestDragAndDropTransferRequired();
    }

    public void onChanged(DragAndDropEvent arg2) {
        DragAndDropTarget v0 = this.thisDragAndDropTarget;
        if(v0 == null) {
            this = this.lastChildDragAndDropModifierNode;
            if(this != null) {
                this.onChanged(arg2);
            }

            return;
        }

        v0.onChanged(arg2);
    }

    public void onDetach() {
        this.thisDragAndDropTarget = null;
        this.lastChildDragAndDropModifierNode = null;
    }

    public boolean onDrop(DragAndDropEvent arg2) {
        DragAndDropNode v0 = this.lastChildDragAndDropModifierNode;
        if(v0 == null) {
            DragAndDropTarget v1 = this.thisDragAndDropTarget;
            if(v1 != null) {
                return v1.onDrop(arg2);
            }

            return 0;
        }

        return v0.onDrop(arg2);
    }

    public void onEnded(DragAndDropEvent arg2) {
        DragAndDropNodeKt.access$traverseSelfAndDescendants(((TraversableNode)this), new DragAndDropNode$onEnded$1(arg2));
    }

    public void onEntered(DragAndDropEvent arg2) {
        DragAndDropTarget v0 = this.thisDragAndDropTarget;
        if(v0 == null) {
            this = this.lastChildDragAndDropModifierNode;
            if(this != null) {
                this.onEntered(arg2);
            }

            return;
        }

        v0.onEntered(arg2);
    }

    public void onExited(DragAndDropEvent arg2) {
        DragAndDropTarget v0 = this.thisDragAndDropTarget;
        if(v0 != null) {
            v0.onExited(arg2);
        }

        DragAndDropNode v0_1 = this.lastChildDragAndDropModifierNode;
        if(v0_1 != null) {
            v0_1.onExited(arg2);
        }

        this.lastChildDragAndDropModifierNode = null;
    }

    public void onMoved(DragAndDropEvent arg5) {
        DragAndDropTarget v0_1;
        DragAndDropNode v1;
        DragAndDropNode v0 = this.lastChildDragAndDropModifierNode;
        if(v0 == null || !DragAndDropNodeKt.access$contains-Uv8p0NA(v0, DragAndDrop_androidKt.getPositionInRoot(arg5))) {
            v1 = this;
            if(!v1.getNode().isAttached()) {
                v1 = null;
            }
            else {
                ObjectRef v2 = new ObjectRef();
                TraversableNodeKt.traverseDescendants(((TraversableNode)v1), new DragAndDropNode$onMoved$$inlined$firstDescendantOrNull$1(v2, this, arg5));
                Object v1_1 = v2.element;
            }
        }
        else {
            v1 = v0;
        }

        if(v1 == null || v0 != null) {
            if(v1 == null && v0 != null) {
                DragAndDropTarget v2_1 = this.thisDragAndDropTarget;
                if(v2_1 != null) {
                    DragAndDropNodeKt.access$dispatchEntered(v2_1, arg5);
                }

                v0.onExited(arg5);
                goto label_50;
            }

            if(!Intrinsics.areEqual(v1, v0)) {
                if(v1 != null) {
                    DragAndDropNodeKt.access$dispatchEntered(v1, arg5);
                }

                if(v0 == null) {
                    goto label_50;
                }

                v0.onExited(arg5);
                goto label_50;
            }

            if(v1 != null) {
                v1.onMoved(arg5);
                goto label_50;
            }

            v0_1 = this.thisDragAndDropTarget;
            if(v0_1 == null) {
                goto label_50;
            }

            v0_1.onMoved(arg5);
        }
        else {
            DragAndDropNodeKt.access$dispatchEntered(v1, arg5);
            v0_1 = this.thisDragAndDropTarget;
            if(v0_1 != null) {
                v0_1.onExited(arg5);
            }
        }

    label_50:
        this.lastChildDragAndDropModifierNode = v1;
    }

    public void onRemeasured-ozmzZPI(long arg1) {
        this.size = arg1;
    }

    public void onStarted(DragAndDropEvent arg2) {
        DragAndDropTarget v0 = this.thisDragAndDropTarget;
        if(v0 == null) {
            this = this.lastChildDragAndDropModifierNode;
            if(this != null) {
                this.onStarted(arg2);
            }

            return;
        }

        v0.onStarted(arg2);
    }

    public void requestDragAndDropTransfer-k-4lQ0M(long arg2) {
        int v0 = this.onStartTransfer != null ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }

        this.getDragAndDropManager().requestDragAndDropTransfer-Uv8p0NA(this, arg2);
    }

    public final void setSize-ozmzZPI$ui(long arg1) {
        this.size = arg1;
    }

    public final void startDragAndDropTransfer-d-4ec7I(DragAndDropStartTransferScope arg8, long arg9, Function0 arg11) {
        DragAndDropNodeKt.access$traverseSelfAndDescendants(((TraversableNode)this), new DragAndDropNode$startDragAndDropTransfer$1(arg9, DelegatableNodeKt.requireLayoutNode(this).getCoordinates(), arg8, arg11));
    }
}

