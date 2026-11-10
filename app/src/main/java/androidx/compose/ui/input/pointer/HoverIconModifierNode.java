package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.TouchBoundsExpansion;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\fJ\'\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020&H\u0016¢\u0006\u0004\b\'\u0010(J\b\u0010)\u001A\u00020 H\u0002J\b\u0010*\u001A\u00020 H\u0002J\b\u0010+\u001A\u00020 H\u0016J\b\u0010,\u001A\u00020 H\u0016J\u0017\u00101\u001A\u00020\b2\u0006\u00102\u001A\u000203H&¢\u0006\u0004\b4\u00105J\u0012\u00106\u001A\u00020 2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H&J\b\u00106\u001A\u00020 H\u0002J\b\u00107\u001A\u00020 H\u0002J\n\u00108\u001A\u0004\u0018\u00010\u0000H\u0002J\b\u00109\u001A\u00020 H\u0002J\n\u0010:\u001A\u0004\u0018\u00010\u0000H\u0002J\b\u0010;\u001A\u00020 H\u0002R\u001C\u0010\t\u001A\u0004\u0018\u00010\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R$\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u0006@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\b@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001A\u001A\u0004\u0018\u00010\u001B8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u000E\u0010\u001E\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010-\u001A\u00020.8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b/\u00100¨\u0006<"}, d2={"Landroidx/compose/ui/input/pointer/HoverIconModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "dpTouchBoundsExpansion", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "<init>", "(Landroidx/compose/ui/input/pointer/PointerIcon;ZLandroidx/compose/ui/node/DpTouchBoundsExpansion;)V", "getDpTouchBoundsExpansion", "()Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "setDpTouchBoundsExpansion", "(Landroidx/compose/ui/node/DpTouchBoundsExpansion;)V", "value", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "setIcon", "(Landroidx/compose/ui/input/pointer/PointerIcon;)V", "getOverrideDescendants", "()Z", "setOverrideDescendants", "(Z)V", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "cursorInBoundsOfNode", "onPointerEvent", "", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onEnter", "onExit", "onCancelPointerInput", "onDetach", "touchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "getTouchBoundsExpansion-RZrCHBk", "()J", "isRelevantPointerType", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isRelevantPointerType-uerMTgs", "(I)Z", "displayIcon", "displayIconIfDescendantsDoNotHavePriority", "findDescendantNodeWithCursorInBounds", "displayIconFromCurrentNodeOrDescendantsWithCursorInBounds", "findOverridingAncestorNode", "displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class HoverIconModifierNode extends Node implements CompositionLocalConsumerModifierNode, PointerInputModifierNode, TraversableNode {
    public static final int $stable = 8;
    private boolean cursorInBoundsOfNode;
    private DpTouchBoundsExpansion dpTouchBoundsExpansion;
    private PointerIcon icon;
    private boolean overrideDescendants;

    static {
    }

    public HoverIconModifierNode(PointerIcon arg1, boolean arg2, DpTouchBoundsExpansion arg3) {
        super();
        this.dpTouchBoundsExpansion = arg3;
        this.icon = arg1;
        this.overrideDescendants = arg2;
    }

    public HoverIconModifierNode(PointerIcon arg1, boolean arg2, DpTouchBoundsExpansion arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, false, arg3);
    }

    public static final boolean access$getCursorInBoundsOfNode$p(HoverIconModifierNode arg0) {
        return arg0.cursorInBoundsOfNode;
    }

    private final void displayIcon() {
        PointerIcon v0_1;
        HoverIconModifierNode v0 = this.findOverridingAncestorNode();
        if(v0 != null) {
            v0_1 = v0.icon;
            if(v0_1 == null) {
                goto label_4;
            }
        }
        else {
        label_4:
            v0_1 = this.icon;
        }

        this.displayIcon(v0_1);
    }

    public abstract void displayIcon(PointerIcon arg1);

    private final void displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon() {
        ObjectRef v0 = new ObjectRef();
        TraversableNodeKt.traverseAncestors(this, new HoverIconModifierNode$displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon$1(v0));
        Object v0_1 = v0.element;
        if(v0_1 != null) {
            ((HoverIconModifierNode)v0_1).displayIcon();
            return;
        }

        this.displayIcon(null);
    }

    private final void displayIconFromCurrentNodeOrDescendantsWithCursorInBounds() {
        if(!this.cursorInBoundsOfNode) {
            return;
        }

        if(!this.overrideDescendants) {
            HoverIconModifierNode v0 = this.findDescendantNodeWithCursorInBounds();
            if(v0 != null) {
                this = v0;
            }
        }

        this.displayIcon();
    }

    private final void displayIconIfDescendantsDoNotHavePriority() {
        BooleanRef v0 = new BooleanRef();
        v0.element = true;
        if(!this.overrideDescendants) {
            TraversableNodeKt.traverseDescendants(this, new HoverIconModifierNode$displayIconIfDescendantsDoNotHavePriority$1(v0));
        }

        if(v0.element) {
            this.displayIcon();
        }
    }

    private final HoverIconModifierNode findDescendantNodeWithCursorInBounds() {
        ObjectRef v0 = new ObjectRef();
        TraversableNodeKt.traverseDescendants(((TraversableNode)this), new HoverIconModifierNode$findDescendantNodeWithCursorInBounds$1(v0));
        return v0.element;
    }

    private final HoverIconModifierNode findOverridingAncestorNode() {
        ObjectRef v0 = new ObjectRef();
        TraversableNodeKt.traverseAncestors(((TraversableNode)this), new HoverIconModifierNode$findOverridingAncestorNode$1(v0));
        return v0.element;
    }

    public final DpTouchBoundsExpansion getDpTouchBoundsExpansion() {
        return this.dpTouchBoundsExpansion;
    }

    public final PointerIcon getIcon() {
        return this.icon;
    }

    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    protected final PointerIconService getPointerIconService() {
        return CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), CompositionLocalsKt.getLocalPointerIconService());
    }

    public long getTouchBoundsExpansion-RZrCHBk() {
        DpTouchBoundsExpansion v0 = this.dpTouchBoundsExpansion;
        if(v0 != null) {
            return v0.roundToTouchBoundsExpansion-TW6G1oQ(DelegatableNodeKt.requireDensity(((DelegatableNode)this)));
        }

        return TouchBoundsExpansion.Companion.getNone-RZrCHBk();
    }

    public abstract boolean isRelevantPointerType-uerMTgs(int arg1);

    public void onCancelPointerInput() {
        this.onExit();
    }

    public void onDetach() {
        this.onExit();
        super.onDetach();
    }

    private final void onEnter() {
        this.cursorInBoundsOfNode = true;
        this.displayIconIfDescendantsDoNotHavePriority();
    }

    private final void onExit() {
        if(this.cursorInBoundsOfNode) {
            this.cursorInBoundsOfNode = false;
            if(this.isAttached()) {
                this.displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon();
            }
        }
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg2, PointerEventPass arg3, long arg4) {
        if(arg3 == PointerEventPass.Main) {
            List v3 = arg2.getChanges();
            int v4 = v3.size();
            int v5 = 0;
            while(v5 < v4) {
                if(!this.isRelevantPointerType-uerMTgs(v3.get(v5).getType-T8wyACA())) {
                    ++v5;
                    continue;
                }
                else if(PointerEventType.equals-impl0(arg2.getType-7fucELk(), PointerEventType.Companion.getEnter-7fucELk())) {
                    this.onEnter();
                    return;
                }
                else if(PointerEventType.equals-impl0(arg2.getType-7fucELk(), PointerEventType.Companion.getExit-7fucELk())) {
                    this.onExit();
                    return;
                }

                return;
            }
        }
    }

    public final void setDpTouchBoundsExpansion(DpTouchBoundsExpansion arg1) {
        this.dpTouchBoundsExpansion = arg1;
    }

    public final void setIcon(PointerIcon arg2) {
        if(!Intrinsics.areEqual(this.icon, arg2)) {
            this.icon = arg2;
            if(this.cursorInBoundsOfNode) {
                this.displayIconIfDescendantsDoNotHavePriority();
            }
        }
    }

    public final void setOverrideDescendants(boolean arg2) {
        if(this.overrideDescendants != arg2) {
            this.overrideDescendants = arg2;
            boolean v0 = this.cursorInBoundsOfNode;
            if(arg2) {
                if(v0) {
                    this.displayIcon();
                    return;
                }
            }
            else if(v0) {
                this.displayIconFromCurrentNodeOrDescendantsWithCursorInBounds();
            }
        }
    }
}

