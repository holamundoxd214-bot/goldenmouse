package androidx.compose.ui.focus;

import android.os.Trace;
import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\b\u001AJ!\u0010\u001D\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ\b\u0010 \u001A\u00020!H\u0016J\b\u0010\"\u001A\u00020!H\u0016J\u0010\u0010#\u001A\u00020!2\u0006\u0010$\u001A\u00020\u0015H\u0016J/\u0010#\u001A\u00020\u00152\u0006\u0010$\u001A\u00020\u00152\u0006\u0010%\u001A\u00020\u00152\u0006\u0010\"\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016¢\u0006\u0004\b&\u0010\'J\u0017\u0010(\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016¢\u0006\u0004\b)\u0010*J\u001A\u0010#\u001A\u00020\u00152\b\b\u0002\u0010+\u001A\u00020\u00152\u0006\u0010%\u001A\u00020\u0015H\u0002J\u0017\u0010,\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010*J\u001F\u0010,\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010.\u001A\u00020\u0015H\u0016¢\u0006\u0004\b/\u00100J7\u00101\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001A\u00020\u00172\b\u00102\u001A\u0004\u0018\u00010\u00192\u0012\u00103\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001504H\u0016¢\u0006\u0004\b5\u00106J%\u00107\u001A\u00020\u00152\u0006\u00108\u001A\u0002092\f\u0010:\u001A\b\u0012\u0004\u0012\u00020\u00150;H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001A\u00020\u00152\u0006\u00108\u001A\u000209H\u0016¢\u0006\u0004\b?\u0010@J\u001E\u0010A\u001A\u00020\u00152\u0006\u0010B\u001A\u00020C2\f\u0010:\u001A\b\u0012\u0004\u0012\u00020\u00150;H\u0016J\u0010\u0010D\u001A\u00020\u00152\u0006\u0010B\u001A\u00020EH\u0016J\b\u0010F\u001A\u00020!H\u0016J\b\u0010G\u001A\u00020!H\u0016J\u0010\u0010H\u001A\u00020!2\u0006\u0010I\u001A\u00020\tH\u0016J\u0010\u0010H\u001A\u00020!2\u0006\u0010I\u001A\u00020JH\u0016J\b\u0010K\u001A\u00020!H\u0016Jd\u0010L\u001A\u00020!\"\n\b\u0000\u0010M\u0018\u0001*\u00020N*\u00020N2\f\u0010O\u001A\b\u0012\u0004\u0012\u0002HM0P2\u0012\u0010Q\u001A\u000E\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u00020!042\f\u0010R\u001A\b\u0012\u0004\u0012\u00020!0;2\u0012\u0010S\u001A\u000E\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u00020!04H\u0082\b¢\u0006\u0004\bT\u0010UJ0\u0010V\u001A\u0004\u0018\u0001HM\"\n\b\u0000\u0010M\u0018\u0001*\u00020W*\u00020N2\f\u0010O\u001A\b\u0012\u0004\u0012\u0002HM0PH\u0082\b¢\u0006\u0004\bX\u0010YJ\n\u0010Z\u001A\u0004\u0018\u00010\u0019H\u0016J\b\u0010[\u001A\u00020\u0015H\u0016J\b\u0010\\\u001A\u00020\u0015H\u0016J\n\u0010]\u001A\u0004\u0018\u00010\tH\u0002J\u000E\u0010o\u001A\u0004\u0018\u00010p*\u00020NH\u0002J\u0017\u0010q\u001A\u00020\u00152\u0006\u00108\u001A\u000209H\u0002¢\u0006\u0004\br\u0010@R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u00020\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010^\u001A\u00020_8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b`\u0010aR\u001A\u0010b\u001A\b\u0012\u0004\u0012\u00020d0cX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\be\u0010fR*\u0010h\u001A\u0004\u0018\u00010\t2\b\u0010g\u001A\u0004\u0018\u00010\t8V@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bi\u0010\u000B\"\u0004\bj\u0010\rR$\u0010k\u001A\u00020\u00152\u0006\u0010g\u001A\u00020\u0015@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bk\u0010l\"\u0004\bm\u0010n¨\u0006s"}, d2={"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "platformFocusOwner", "Landroidx/compose/ui/focus/PlatformFocusOwner;", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroidx/compose/ui/focus/PlatformFocusOwner;Landroidx/compose/ui/node/Owner;)V", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "requestOwnerFocus", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "requestOwnerFocus-7o62pno", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "releaseFocus", "", "clearOwnerFocus", "clearFocus", "force", "refreshFocusEvents", "clearFocus-I7lrPNg", "(ZZZI)Z", "resetFocus", "resetFocus-3ESFkO8", "(I)Z", "forced", "moveFocus", "moveFocus-3ESFkO8", "wrapAroundForOneDimensionalFocus", "moveFocus-aToIllA", "(IZ)Z", "focusSearch", "focusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "dispatchKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onFocusedItem", "Lkotlin/Function0;", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchInterceptedSoftKeyboardEvent", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "dispatchIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "dispatchIndirectPointerCancel", "focusTargetAvailable", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "scheduleInvalidationForOwner", "traverseAncestorsIncludingSelf", "T", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "nearestAncestorIncludingSelf", "", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "getFocusRect", "hasFocusableContent", "hasNonInteropFocusableContent", "findFocusTargetNode", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "listeners", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/focus/FocusListener;", "getListeners", "()Landroidx/collection/MutableObjectList;", "value", "activeFocusTargetNode", "getActiveFocusTargetNode", "setActiveFocusTargetNode", "isFocusCaptured", "()Z", "setFocusCaptured", "(Z)V", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusOwnerImpl implements FocusOwner {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[CustomDestinationResult.values().length];
            try {
                v0[CustomDestinationResult.Redirected.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[CustomDestinationResult.Cancelled.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[CustomDestinationResult.None.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private FocusTargetNode activeFocusTargetNode;
    private final FocusInvalidationManager focusInvalidationManager;
    private boolean isFocusCaptured;
    private MutableLongSet keysCurrentlyDown;
    private final MutableObjectList listeners;
    private final Modifier modifier;
    private final Owner owner;
    private final PlatformFocusOwner platformFocusOwner;
    private FocusTargetNode rootFocusNode;

    static {
    }

    public FocusOwnerImpl(PlatformFocusOwner arg8, Owner arg9) {
        super();
        this.platformFocusOwner = arg8;
        this.owner = arg9;
        this.rootFocusNode = new FocusTargetNode(Focusability.Companion.getNever-LCbbffg(), false, null, null, 14, null);
        this.focusInvalidationManager = new FocusInvalidationManager(this, arg9);
        this.modifier = new FocusOwnerImpl$modifier$1(this);
        this.listeners = new MutableObjectList(1);
    }

    private final boolean clearFocus(boolean arg9, boolean arg10) {
        if(this.getActiveFocusTargetNode() == null) {
            return 1;
        }

        if((this.isFocusCaptured()) && !arg9) {
            return 0;
        }

        FocusTargetNode v9 = this.getActiveFocusTargetNode();
        FocusTargetNode v0 = null;
        this.setActiveFocusTargetNode(v0);
        if((arg10) && v9 != null) {
            FocusStateImpl v8 = this.isFocusCaptured() ? FocusStateImpl.Captured : FocusStateImpl.Active;
            v9.dispatchFocusCallbacks$ui(((FocusState)v8), FocusStateImpl.Inactive);
            int v8_1 = NodeKind.constructor-impl(0x400);
            if(!((DelegatableNode)v9).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }

            Node v10 = ((DelegatableNode)v9).getNode().getParent$ui();
            LayoutNode v9_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v9));
            while(v9_1 != null) {
                if((v9_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v8_1) != 0) {
                    while(v10 != null) {
                        if((v10.getKindSet$ui() & v8_1) != 0) {
                            Node v3 = v10;
                            MutableVector v4 = ((MutableVector)v0);
                            while(true) {
                            label_43:
                                if(v3 != null) {
                                    if((v3 instanceof FocusTargetNode)) {
                                        ((FocusTargetNode)v3).dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                                    }
                                    else if((v3.getKindSet$ui() & v8_1) != 0 && ((v3 instanceof DelegatingNode))) {
                                        Node v5 = v3.getDelegate$ui();
                                        int v6 = 0;
                                        while(v5 != null) {
                                            if((v5.getKindSet$ui() & v8_1) != 0) {
                                                ++v6;
                                                if(v6 == 1) {
                                                    v3 = v5;
                                                }
                                                else {
                                                    if(v4 == null) {
                                                        v4 = new MutableVector(new Node[16], 0);
                                                    }

                                                    if(v3 != null) {
                                                        if(v4 != null) {
                                                            v4.add(v3);
                                                        }

                                                        v3 = ((Node)v0);
                                                    }

                                                    if(v4 == null) {
                                                        goto label_77;
                                                    }

                                                    v4.add(v5);
                                                }
                                            }

                                        label_77:
                                            v5 = v5.getChild$ui();
                                        }

                                        if(v6 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                goto label_83;
                            }

                            v3 = DelegatableNodeKt.access$pop(v4);
                            goto label_43;
                        }

                    label_83:
                        v10 = v10.getParent$ui();
                    }
                }

                v9_1 = v9_1.getParent$ui();
                if(v9_1 != null) {
                    NodeChain v10_1 = v9_1.getNodes$ui();
                    if(v10_1 != null) {
                        v10 = v10_1.getTail$ui();
                        continue;
                    }
                }

                v10 = ((Node)v0);
            }
        }

        return 1;
    }

    public void clearFocus(boolean arg3) {
        this.clearFocus-I7lrPNg(arg3, true, true, FocusDirection.Companion.getExit-dhqQ-8s());
    }

    static boolean clearFocus$default(FocusOwnerImpl arg0, boolean arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.clearFocus(false, arg2);
    }

    public boolean clearFocus-I7lrPNg(boolean arg2, boolean arg3, boolean arg4, int arg5) {
        if(!arg2) {
            arg5 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.performCustomClearFocus-Mxy_nc0(this.rootFocusNode, arg5).ordinal()];
            if(arg5 != 1 && arg5 != 2 && arg5 != 3) {
                if(arg5 == 4) {
                    arg2 = this.clearFocus(arg2, arg3);
                    goto label_22;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            arg2 = false;
        }
        else {
            arg2 = this.clearFocus(arg2, arg3);
        }

    label_22:
        if((arg2) && (arg4)) {
            this.clearOwnerFocus();
        }

        return arg2;
    }

    public void clearOwnerFocus() {
        this.platformFocusOwner.clearOwnerFocus();
    }

    public void dispatchIndirectPointerCancel() {
        int v11;
        Node v10;
        Node v8;
        MutableVector v9;
        LayoutNode v13_1;
        Node v7;
        FocusTargetNode v13 = this.getActiveFocusTargetNode();
        int v0 = 16;
        String v1 = "visitAncestors called on an unattached node";
        int v2 = 0x200000;
        int v3 = 0;
        Node v5 = null;
        if(v13 != null) {
            int v6 = NodeKind.constructor-impl(v2);
            if(!((DelegatableNode)v13).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException(v1);
            }

            v7 = ((DelegatableNode)v13).getNode();
            v13_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v13));
            while(v13_1 != null) {
                if((v13_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v6) != 0) {
                    while(v7 != null) {
                        if((v7.getKindSet$ui() & v6) != 0) {
                            v9 = ((MutableVector)v5);
                            v8 = v7;
                            while(true) {
                            label_27:
                                if(v8 != null) {
                                    if((v8 instanceof IndirectPointerInputModifierNode)) {
                                        goto label_76;
                                    }
                                    else {
                                        if((v8.getKindSet$ui() & v6) != 0 && ((v8 instanceof DelegatingNode))) {
                                            v10 = v8.getDelegate$ui();
                                            v11 = 0;
                                            while(v10 != null) {
                                                if((v10.getKindSet$ui() & v6) != 0) {
                                                    ++v11;
                                                    if(v11 == 1) {
                                                        v8 = v10;
                                                    }
                                                    else {
                                                        if(v9 == null) {
                                                            v9 = new MutableVector(new Node[v0], 0);
                                                        }

                                                        if(v8 != null) {
                                                            if(v9 != null) {
                                                                v9.add(v8);
                                                            }

                                                            v8 = v5;
                                                        }

                                                        if(v9 == null) {
                                                            goto label_57;
                                                        }

                                                        v9.add(v10);
                                                    }
                                                }

                                            label_57:
                                                v10 = v10.getChild$ui();
                                            }

                                            if(v11 != 1) {
                                                break;
                                            }

                                            continue;
                                        }

                                        break;
                                    }
                                }

                                goto label_63;
                            }

                            v8 = DelegatableNodeKt.access$pop(v9);
                            goto label_27;
                        }

                    label_63:
                        v7 = v7.getParent$ui();
                    }
                }

                v13_1 = v13_1.getParent$ui();
                if(v13_1 != null) {
                    NodeChain v7_1 = v13_1.getNodes$ui();
                    if(v7_1 != null) {
                        v7 = v7_1.getTail$ui();
                        continue;
                    }
                }

                v7 = v5;
            }

            v8 = v5;
        }
        else {
            v8 = v5;
        }

    label_76:
        if(v8 != null) {
            Node v13_2 = v8;
            v2 = NodeKind.constructor-impl(v2);
            if(!((DelegatableNode)v13_2).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException(v1);
            }

            Node v1_1 = ((DelegatableNode)v13_2).getNode().getParent$ui();
            v13_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v13_2));
            ArrayList v6_1 = ((ArrayList)v5);
            while(v13_1 != null) {
                if((v13_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v2) != 0) {
                    while(v1_1 != null) {
                        if((v1_1.getKindSet$ui() & v2) != 0) {
                            v7 = v1_1;
                            v9 = ((MutableVector)v5);
                            while(true) {
                            label_99:
                                if(v7 != null) {
                                    if((v7 instanceof IndirectPointerInputModifierNode)) {
                                        if(v6_1 == null) {
                                            v6_1 = new ArrayList();
                                        }

                                        ((List)v6_1).add(v7);
                                    }
                                    else {
                                        if((v7.getKindSet$ui() & v2) == 0) {
                                            break;
                                        }

                                        if(!(v7 instanceof DelegatingNode)) {
                                            break;
                                        }

                                        v10 = v7.getDelegate$ui();
                                        v11 = 0;
                                        while(v10 != null) {
                                            if((v10.getKindSet$ui() & v2) != 0) {
                                                ++v11;
                                                if(v11 == 1) {
                                                    v7 = v10;
                                                }
                                                else {
                                                    if(v9 == null) {
                                                        v9 = new MutableVector(new Node[v0], 0);
                                                    }

                                                    if(v7 != null) {
                                                        if(v9 != null) {
                                                            v9.add(v7);
                                                        }

                                                        v7 = v5;
                                                    }

                                                    if(v9 == null) {
                                                        goto label_133;
                                                    }

                                                    v9.add(v10);
                                                }
                                            }

                                        label_133:
                                            v10 = v10.getChild$ui();
                                        }

                                        if(v11 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                goto label_139;
                            }

                            v7 = DelegatableNodeKt.access$pop(v9);
                            goto label_99;
                        }

                    label_139:
                        v1_1 = v1_1.getParent$ui();
                    }
                }

                v13_1 = v13_1.getParent$ui();
                if(v13_1 != null) {
                    NodeChain v1_2 = v13_1.getNodes$ui();
                    if(v1_2 != null) {
                        v1_1 = v1_2.getTail$ui();
                        continue;
                    }
                }

                v1_1 = v5;
            }

            ((IndirectPointerInputModifierNode)v8).onCancelIndirectPointerInput();
            if(v6_1 == null) {
                return;
            }

            int v13_3 = v6_1.size();
            while(v3 < v13_3) {
                ((List)v6_1).get(v3).onCancelIndirectPointerInput();
                ++v3;
            }
        }
    }

    public boolean dispatchIndirectPointerEvent(IndirectPointerEvent arg14) {
        int v13_3;
        int v11;
        Node v10;
        Node v8;
        MutableVector v9;
        LayoutNode v13_1;
        Node v7;
        if(this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println("FocusRelatedWarning: Dispatching indirect pointer event while the focus system is invalidated.");
            return 0;
        }

        FocusTargetNode v13 = this.getActiveFocusTargetNode();
        int v0 = 16;
        String v2 = "visitAncestors called on an unattached node";
        int v3 = 0x200000;
        Node v5 = null;
        if(v13 != null) {
            int v6 = NodeKind.constructor-impl(v3);
            if(!((DelegatableNode)v13).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException(v2);
            }

            v7 = ((DelegatableNode)v13).getNode();
            v13_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v13));
            while(v13_1 != null) {
                if((v13_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v6) != 0) {
                    while(v7 != null) {
                        if((v7.getKindSet$ui() & v6) != 0) {
                            v9 = ((MutableVector)v5);
                            v8 = v7;
                            while(true) {
                            label_34:
                                if(v8 != null) {
                                    if((v8 instanceof IndirectPointerInputModifierNode)) {
                                        goto label_83;
                                    }
                                    else {
                                        if((v8.getKindSet$ui() & v6) != 0 && ((v8 instanceof DelegatingNode))) {
                                            v10 = v8.getDelegate$ui();
                                            v11 = 0;
                                            while(v10 != null) {
                                                if((v10.getKindSet$ui() & v6) != 0) {
                                                    ++v11;
                                                    if(v11 == 1) {
                                                        v8 = v10;
                                                    }
                                                    else {
                                                        if(v9 == null) {
                                                            v9 = new MutableVector(new Node[v0], 0);
                                                        }

                                                        if(v8 != null) {
                                                            if(v9 != null) {
                                                                v9.add(v8);
                                                            }

                                                            v8 = v5;
                                                        }

                                                        if(v9 == null) {
                                                            goto label_64;
                                                        }

                                                        v9.add(v10);
                                                    }
                                                }

                                            label_64:
                                                v10 = v10.getChild$ui();
                                            }

                                            if(v11 != 1) {
                                                break;
                                            }

                                            continue;
                                        }

                                        break;
                                    }
                                }

                                goto label_70;
                            }

                            v8 = DelegatableNodeKt.access$pop(v9);
                            goto label_34;
                        }

                    label_70:
                        v7 = v7.getParent$ui();
                    }
                }

                v13_1 = v13_1.getParent$ui();
                if(v13_1 != null) {
                    NodeChain v7_1 = v13_1.getNodes$ui();
                    if(v7_1 != null) {
                        v7 = v7_1.getTail$ui();
                        continue;
                    }
                }

                v7 = v5;
            }

            v8 = v5;
        }
        else {
            v8 = v5;
        }

    label_83:
        if(v8 != null) {
            Node v13_2 = v8;
            v3 = NodeKind.constructor-impl(v3);
            if(!((DelegatableNode)v13_2).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException(v2);
            }

            Node v2_1 = ((DelegatableNode)v13_2).getNode().getParent$ui();
            v13_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v13_2));
            ArrayList v6_1 = ((ArrayList)v5);
            while(v13_1 != null) {
                if((v13_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v3) != 0) {
                    while(v2_1 != null) {
                        if((v2_1.getKindSet$ui() & v3) != 0) {
                            v7 = v2_1;
                            v9 = ((MutableVector)v5);
                            while(true) {
                            label_106:
                                if(v7 != null) {
                                    if((v7 instanceof IndirectPointerInputModifierNode)) {
                                        if(v6_1 == null) {
                                            v6_1 = new ArrayList();
                                        }

                                        ((List)v6_1).add(v7);
                                    }
                                    else {
                                        if((v7.getKindSet$ui() & v3) == 0) {
                                            break;
                                        }

                                        if(!(v7 instanceof DelegatingNode)) {
                                            break;
                                        }

                                        v10 = v7.getDelegate$ui();
                                        v11 = 0;
                                        while(v10 != null) {
                                            if((v10.getKindSet$ui() & v3) != 0) {
                                                ++v11;
                                                if(v11 == 1) {
                                                    v7 = v10;
                                                }
                                                else {
                                                    if(v9 == null) {
                                                        v9 = new MutableVector(new Node[v0], 0);
                                                    }

                                                    if(v7 != null) {
                                                        if(v9 != null) {
                                                            v9.add(v7);
                                                        }

                                                        v7 = v5;
                                                    }

                                                    if(v9 == null) {
                                                        goto label_140;
                                                    }

                                                    v9.add(v10);
                                                }
                                            }

                                        label_140:
                                            v10 = v10.getChild$ui();
                                        }

                                        if(v11 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                goto label_146;
                            }

                            v7 = DelegatableNodeKt.access$pop(v9);
                            goto label_106;
                        }

                    label_146:
                        v2_1 = v2_1.getParent$ui();
                    }
                }

                v13_1 = v13_1.getParent$ui();
                if(v13_1 != null) {
                    NodeChain v2_2 = v13_1.getNodes$ui();
                    if(v2_2 != null) {
                        v2_1 = v2_2.getTail$ui();
                        continue;
                    }
                }

                v2_1 = v5;
            }

            if(v6_1 != null) {
                v13_3 = v6_1.size() - 1;
                if(v13_3 < 0) {
                    goto label_169;
                }

                while(true) {
                    v0 = v13_3 - 1;
                    ((List)v6_1).get(v13_3).onIndirectPointerEvent(arg14, PointerEventPass.Initial);
                    if(v0 < 0) {
                        break;
                    }

                    v13_3 = v0;
                }
            }

        label_169:
            ((IndirectPointerInputModifierNode)v8).onIndirectPointerEvent(arg14, PointerEventPass.Initial);
            ((IndirectPointerInputModifierNode)v8).onIndirectPointerEvent(arg14, PointerEventPass.Main);
            if(v6_1 != null) {
                v13_3 = v6_1.size();
                for(v0 = 0; v0 < v13_3; ++v0) {
                    ((List)v6_1).get(v0).onIndirectPointerEvent(arg14, PointerEventPass.Main);
                }
            }

            if(v6_1 != null) {
                v13_3 = v6_1.size() - 1;
                if(v13_3 < 0) {
                    goto label_196;
                }

                while(true) {
                    v0 = v13_3 - 1;
                    ((List)v6_1).get(v13_3).onIndirectPointerEvent(arg14, PointerEventPass.Final);
                    if(v0 < 0) {
                        break;
                    }

                    v13_3 = v0;
                }
            }

        label_196:
            ((IndirectPointerInputModifierNode)v8).onIndirectPointerEvent(arg14, PointerEventPass.Final);
        }

        List v13_4 = arg14.getChanges();
        int v14 = v13_4.size();
        for(v0 = 0; v0 < v14; ++v0) {
            if(v13_4.get(v0).isConsumed()) {
                return 1;
            }
        }

        return 0;
    }

    public boolean dispatchInterceptedSoftKeyboardEvent-ZmokQxo(KeyEvent arg14) {
        int v11;
        Node v10;
        Node v8;
        MutableVector v9;
        Node v7;
        if(this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println("FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            return 0;
        }

        FocusTargetNode v13 = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        String v0 = "visitAncestors called on an unattached node";
        int v2 = 0x20000;
        int v3 = 16;
        Node v4 = null;
        if(v13 != null) {
            int v6 = NodeKind.constructor-impl(v2);
            if(!((DelegatableNode)v13).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException(v0);
            }

            v7 = ((DelegatableNode)v13).getNode();
            LayoutNode v13_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v13));
            while(v13_1 != null) {
                if((v13_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v6) != 0) {
                    while(v7 != null) {
                        if((v7.getKindSet$ui() & v6) != 0) {
                            v9 = ((MutableVector)v4);
                            v8 = v7;
                            while(true) {
                            label_35:
                                if(v8 != null) {
                                    if((v8 instanceof SoftKeyboardInterceptionModifierNode)) {
                                        goto label_84;
                                    }
                                    else {
                                        if((v8.getKindSet$ui() & v6) != 0 && ((v8 instanceof DelegatingNode))) {
                                            v10 = v8.getDelegate$ui();
                                            v11 = 0;
                                            while(v10 != null) {
                                                if((v10.getKindSet$ui() & v6) != 0) {
                                                    ++v11;
                                                    if(v11 == 1) {
                                                        v8 = v10;
                                                    }
                                                    else {
                                                        if(v9 == null) {
                                                            v9 = new MutableVector(new Node[v3], 0);
                                                        }

                                                        if(v8 != null) {
                                                            if(v9 != null) {
                                                                v9.add(v8);
                                                            }

                                                            v8 = v4;
                                                        }

                                                        if(v9 == null) {
                                                            goto label_65;
                                                        }

                                                        v9.add(v10);
                                                    }
                                                }

                                            label_65:
                                                v10 = v10.getChild$ui();
                                            }

                                            if(v11 != 1) {
                                                break;
                                            }

                                            continue;
                                        }

                                        break;
                                    }
                                }

                                goto label_71;
                            }

                            v8 = DelegatableNodeKt.access$pop(v9);
                            goto label_35;
                        }

                    label_71:
                        v7 = v7.getParent$ui();
                    }
                }

                v13_1 = v13_1.getParent$ui();
                if(v13_1 != null) {
                    NodeChain v7_1 = v13_1.getNodes$ui();
                    if(v7_1 != null) {
                        v7 = v7_1.getTail$ui();
                        continue;
                    }
                }

                v7 = v4;
            }

            v8 = v4;
        }
        else {
            v8 = v4;
        }

    label_84:
        if(v8 != null) {
            int v13_2 = NodeKind.constructor-impl(v2);
            if(!((DelegatableNode)v8).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException(v0);
            }

            Node v0_1 = ((DelegatableNode)v8).getNode().getParent$ui();
            LayoutNode v2_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v8));
            ArrayList v6_1 = ((ArrayList)v4);
            while(v2_1 != null) {
                if((v2_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v13_2) != 0) {
                    while(v0_1 != null) {
                        if((v0_1.getKindSet$ui() & v13_2) != 0) {
                            v7 = v0_1;
                            v9 = ((MutableVector)v4);
                            while(true) {
                            label_106:
                                if(v7 != null) {
                                    if((v7 instanceof SoftKeyboardInterceptionModifierNode)) {
                                        if(v6_1 == null) {
                                            v6_1 = new ArrayList();
                                        }

                                        ((List)v6_1).add(v7);
                                    }
                                    else {
                                        if((v7.getKindSet$ui() & v13_2) == 0) {
                                            break;
                                        }

                                        if(!(v7 instanceof DelegatingNode)) {
                                            break;
                                        }

                                        v10 = v7.getDelegate$ui();
                                        v11 = 0;
                                        while(v10 != null) {
                                            if((v10.getKindSet$ui() & v13_2) != 0) {
                                                ++v11;
                                                if(v11 == 1) {
                                                    v7 = v10;
                                                }
                                                else {
                                                    if(v9 == null) {
                                                        v9 = new MutableVector(new Node[v3], 0);
                                                    }

                                                    if(v7 != null) {
                                                        if(v9 != null) {
                                                            v9.add(v7);
                                                        }

                                                        v7 = v4;
                                                    }

                                                    if(v9 == null) {
                                                        goto label_140;
                                                    }

                                                    v9.add(v10);
                                                }
                                            }

                                        label_140:
                                            v10 = v10.getChild$ui();
                                        }

                                        if(v11 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                goto label_146;
                            }

                            v7 = DelegatableNodeKt.access$pop(v9);
                            goto label_106;
                        }

                    label_146:
                        v0_1 = v0_1.getParent$ui();
                    }
                }

                v2_1 = v2_1.getParent$ui();
                if(v2_1 != null) {
                    NodeChain v0_2 = v2_1.getNodes$ui();
                    if(v0_2 != null) {
                        v0_1 = v0_2.getTail$ui();
                        continue;
                    }
                }

                v0_1 = v4;
            }

            if(v6_1 != null) {
                int v0_3 = v6_1.size() - 1;
                if(v0_3 < 0) {
                    goto label_170;
                }

                while(true) {
                    v2 = v0_3 - 1;
                    if(((List)v6_1).get(v0_3).onPreInterceptKeyBeforeSoftKeyboard-ZmokQxo(arg14)) {
                        return 1;
                    }

                    if(v2 < 0) {
                        goto label_170;
                    }

                    v0_3 = v2;
                }

                return 1;
            }

        label_170:
            v0_1 = ((DelegatableNode)v8).getNode();
            MutableVector v2_2 = ((MutableVector)v4);
            while(true) {
            label_172:
                if(v0_1 == null) {
                    goto label_210;
                }

                if((v0_1 instanceof SoftKeyboardInterceptionModifierNode)) {
                    if(((SoftKeyboardInterceptionModifierNode)v0_1).onPreInterceptKeyBeforeSoftKeyboard-ZmokQxo(arg14)) {
                        return 1;
                    }
                }
                else if((v0_1.getKindSet$ui() & v13_2) != 0 && ((v0_1 instanceof DelegatingNode))) {
                    v7 = v0_1.getDelegate$ui();
                    int v9_1 = 0;
                    while(v7 != null) {
                        if((v7.getKindSet$ui() & v13_2) != 0) {
                            ++v9_1;
                            if(v9_1 == 1) {
                                v0_1 = v7;
                            }
                            else {
                                if(v2_2 == null) {
                                    v2_2 = new MutableVector(new Node[v3], 0);
                                }

                                if(v0_1 != null) {
                                    if(v2_2 != null) {
                                        v2_2.add(v0_1);
                                    }

                                    v0_1 = v4;
                                }

                                if(v2_2 == null) {
                                    goto label_204;
                                }

                                v2_2.add(v7);
                            }
                        }

                    label_204:
                        v7 = v7.getChild$ui();
                    }

                    if(v9_1 != 1) {
                        break;
                    }

                    continue;
                }

                break;
            }

            v0_1 = DelegatableNodeKt.access$pop(v2_2);
            goto label_172;
        label_210:
            v0_1 = ((DelegatableNode)v8).getNode();
            v2_2 = ((MutableVector)v4);
            while(true) {
            label_212:
                if(v0_1 == null) {
                    goto label_250;
                }

                if((v0_1 instanceof SoftKeyboardInterceptionModifierNode)) {
                    if(((SoftKeyboardInterceptionModifierNode)v0_1).onInterceptKeyBeforeSoftKeyboard-ZmokQxo(arg14)) {
                        return 1;
                    }
                }
                else if((v0_1.getKindSet$ui() & v13_2) != 0 && ((v0_1 instanceof DelegatingNode))) {
                    v7 = v0_1.getDelegate$ui();
                    int v8_1 = 0;
                    while(v7 != null) {
                        if((v7.getKindSet$ui() & v13_2) != 0) {
                            ++v8_1;
                            if(v8_1 == 1) {
                                v0_1 = v7;
                            }
                            else {
                                if(v2_2 == null) {
                                    v2_2 = new MutableVector(new Node[v3], 0);
                                }

                                if(v0_1 != null) {
                                    if(v2_2 != null) {
                                        v2_2.add(v0_1);
                                    }

                                    v0_1 = v4;
                                }

                                if(v2_2 == null) {
                                    goto label_244;
                                }

                                v2_2.add(v7);
                            }
                        }

                    label_244:
                        v7 = v7.getChild$ui();
                    }

                    if(v8_1 != 1) {
                        break;
                    }

                    continue;
                }

                break;
            }

            v0_1 = DelegatableNodeKt.access$pop(v2_2);
            goto label_212;
        label_250:
            if(v6_1 == null) {
                return 0;
            }

            v13_2 = v6_1.size();
            for(v0_3 = 0; v0_3 < v13_2; ++v0_3) {
                if(((List)v6_1).get(v0_3).onInterceptKeyBeforeSoftKeyboard-ZmokQxo(arg14)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public boolean dispatchKeyEvent-YhN2O0w(KeyEvent arg17, Function0 arg18) {
        MutableVector v4_3;
        int v4_2;
        ArrayList v5_1;
        Node v2_3;
        int v0_4;
        int v13_1;
        Node v12_1;
        MutableVector v11_1;
        int v2_2;
        Node v11;
        Node v10;
        Node v9;
        FocusTargetNode v2;
        FocusOwnerImpl v0 = this;
        KeyEvent v1 = arg17;
        Trace.beginSection("FocusOwnerImpl:dispatchKeyEvent");
        try {
            if(!v0.focusInvalidationManager.hasPendingInvalidation()) {
                goto label_13;
            }

            System.out.println("FocusRelatedWarning: Dispatching key event while focus system is invalidated.");
        }
        catch(Throwable v0_1) {
            goto label_376;
        }

        Trace.endSection();
        return 0;
        try {
        label_13:
            if(this.validateKeyEvent-ZmokQxo(arg17)) {
                goto label_17;
            }
        }
        catch(Throwable v0_1) {
            goto label_376;
        }

        Trace.endSection();
        return 0;
        try {
        label_17:
            v2 = v0.findFocusTargetNode();
        }
        catch(Throwable v0_1) {
            goto label_376;
        }

        String v4 = "visitAncestors called on an unattached node";
        int v5 = 0x2000;
        int v6 = 16;
        Node v7 = null;
        if(v2 != null) {
            try {
                v9 = v0.lastLocalKeyInputNode(v2);
                if(v9 == null) {
                label_27:
                    if(v2 != null) {
                        int v9_1 = NodeKind.constructor-impl(v5);
                        if(!((DelegatableNode)v2).getNode().isAttached()) {
                            InlineClassHelperKt.throwIllegalStateException(v4);
                        }

                        v10 = ((DelegatableNode)v2).getNode();
                        LayoutNode v2_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v2));
                        while(v2_1 != null) {
                            if((v2_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v9_1) != 0) {
                                while(v10 != null) {
                                    if((v10.getKindSet$ui() & v9_1) != 0) {
                                        MutableVector v12 = ((MutableVector)v7);
                                        v11 = v10;
                                        while(true) {
                                        label_47:
                                            if(v11 != null) {
                                                if((v11 instanceof KeyInputModifierNode)) {
                                                    goto label_97;
                                                }
                                                else {
                                                    if((v11.getKindSet$ui() & v9_1) != 0 && ((v11 instanceof DelegatingNode))) {
                                                        Node v13 = v11.getDelegate$ui();
                                                        int v14 = 0;
                                                        while(v13 != null) {
                                                            if((v13.getKindSet$ui() & v9_1) != 0) {
                                                                ++v14;
                                                                if(v14 == 1) {
                                                                    v11 = v13;
                                                                }
                                                                else {
                                                                    if(v12 == null) {
                                                                        v12 = new MutableVector(new Node[v6], 0);
                                                                    }

                                                                    if(v11 != null) {
                                                                        if(v12 != null) {
                                                                            Boolean.valueOf(v12.add(v11));
                                                                        }

                                                                        v11 = v7;
                                                                    }

                                                                    if(v12 == null) {
                                                                        goto label_80;
                                                                    }

                                                                    Boolean.valueOf(v12.add(v13));
                                                                }
                                                            }

                                                        label_80:
                                                            v13 = v13.getChild$ui();
                                                        }

                                                        if(v14 != 1) {
                                                            break;
                                                        }

                                                        continue;
                                                    }

                                                    break;
                                                }
                                            }

                                            goto label_86;
                                        }

                                        v11 = DelegatableNodeKt.access$pop(v12);
                                        goto label_47;
                                    }

                                label_86:
                                    v10 = v10.getParent$ui();
                                }
                            }

                            v2_1 = v2_1.getParent$ui();
                            if(v2_1 != null) {
                                NodeChain v10_1 = v2_1.getNodes$ui();
                                if(v10_1 != null) {
                                    v10 = v10_1.getTail$ui();
                                    continue;
                                }
                            }

                            v10 = v7;
                        }

                        v11 = v7;
                    label_97:
                        if(v11 == null) {
                            goto label_100;
                        }

                        v9 = ((KeyInputModifierNode)v11).getNode();
                        goto label_175;
                    }

                label_100:
                    FocusTargetNode v0_2 = v0.rootFocusNode;
                    v2_2 = NodeKind.constructor-impl(v5);
                    if(!((DelegatableNode)v0_2).getNode().isAttached()) {
                        InlineClassHelperKt.throwIllegalStateException(v4);
                    }

                    v9 = ((DelegatableNode)v0_2).getNode().getParent$ui();
                    LayoutNode v0_3 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v0_2));
                    while(v0_3 != null) {
                        if((v0_3.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v2_2) != 0) {
                            while(v9 != null) {
                                if((v9.getKindSet$ui() & v2_2) != 0) {
                                    v11_1 = ((MutableVector)v7);
                                    v10 = v9;
                                    while(true) {
                                    label_121:
                                        if(v10 != null) {
                                            if((v10 instanceof KeyInputModifierNode)) {
                                                goto label_171;
                                            }
                                            else {
                                                if((v10.getKindSet$ui() & v2_2) != 0 && ((v10 instanceof DelegatingNode))) {
                                                    v12_1 = v10.getDelegate$ui();
                                                    v13_1 = 0;
                                                    while(v12_1 != null) {
                                                        if((v12_1.getKindSet$ui() & v2_2) != 0) {
                                                            ++v13_1;
                                                            if(v13_1 == 1) {
                                                                v10 = v12_1;
                                                            }
                                                            else {
                                                                if(v11_1 == null) {
                                                                    v11_1 = new MutableVector(new Node[v6], 0);
                                                                }

                                                                if(v10 != null) {
                                                                    if(v11_1 != null) {
                                                                        Boolean.valueOf(v11_1.add(v10));
                                                                    }

                                                                    v10 = v7;
                                                                }

                                                                if(v11_1 == null) {
                                                                    goto label_154;
                                                                }

                                                                Boolean.valueOf(v11_1.add(v12_1));
                                                            }
                                                        }

                                                    label_154:
                                                        v12_1 = v12_1.getChild$ui();
                                                    }

                                                    if(v13_1 != 1) {
                                                        break;
                                                    }

                                                    continue;
                                                }

                                                break;
                                            }
                                        }

                                        goto label_160;
                                    }

                                    v10 = DelegatableNodeKt.access$pop(v11_1);
                                    goto label_121;
                                }

                            label_160:
                                v9 = v9.getParent$ui();
                            }
                        }

                        v0_3 = v0_3.getParent$ui();
                        if(v0_3 != null) {
                            NodeChain v9_2 = v0_3.getNodes$ui();
                            if(v9_2 != null) {
                                v9 = v9_2.getTail$ui();
                                continue;
                            }
                        }

                        v9 = v7;
                    }

                    v10 = v7;
                label_171:
                    if(v10 != null) {
                        v9 = ((KeyInputModifierNode)v10).getNode();
                        goto label_175;
                    }

                    v9 = v7;
                }

            label_175:
                if(v9 != null) {
                    v0_4 = NodeKind.constructor-impl(v5);
                    if(!((DelegatableNode)v9).getNode().isAttached()) {
                        InlineClassHelperKt.throwIllegalStateException(v4);
                    }

                    v2_3 = ((DelegatableNode)v9).getNode().getParent$ui();
                    LayoutNode v4_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v9));
                    v5_1 = ((ArrayList)v7);
                    while(v4_1 != null) {
                        if((v4_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v0_4) != 0) {
                            while(v2_3 != null) {
                                if((v2_3.getKindSet$ui() & v0_4) != 0) {
                                    v10 = v2_3;
                                    v11_1 = ((MutableVector)v7);
                                    while(true) {
                                    label_197:
                                        if(v10 != null) {
                                            if((v10 instanceof KeyInputModifierNode)) {
                                                if(v5_1 == null) {
                                                    v5_1 = new ArrayList();
                                                }

                                                ((List)v5_1).add(v10);
                                            }
                                            else {
                                                if((v10.getKindSet$ui() & v0_4) == 0) {
                                                    break;
                                                }

                                                if(!(v10 instanceof DelegatingNode)) {
                                                    break;
                                                }

                                                v12_1 = v10.getDelegate$ui();
                                                v13_1 = 0;
                                                while(v12_1 != null) {
                                                    if((v12_1.getKindSet$ui() & v0_4) != 0) {
                                                        ++v13_1;
                                                        if(v13_1 == 1) {
                                                            v10 = v12_1;
                                                        }
                                                        else {
                                                            if(v11_1 == null) {
                                                                v11_1 = new MutableVector(new Node[v6], 0);
                                                            }

                                                            if(v10 != null) {
                                                                if(v11_1 != null) {
                                                                    Boolean.valueOf(v11_1.add(v10));
                                                                }

                                                                v10 = v7;
                                                            }

                                                            if(v11_1 == null) {
                                                                goto label_234;
                                                            }

                                                            Boolean.valueOf(v11_1.add(v12_1));
                                                        }
                                                    }

                                                label_234:
                                                    v12_1 = v12_1.getChild$ui();
                                                }

                                                if(v13_1 != 1) {
                                                    break;
                                                }

                                                continue;
                                            }

                                            break;
                                        }

                                        goto label_240;
                                    }

                                    v10 = DelegatableNodeKt.access$pop(v11_1);
                                    goto label_197;
                                }

                            label_240:
                                v2_3 = v2_3.getParent$ui();
                            }
                        }

                        v4_1 = v4_1.getParent$ui();
                        if(v4_1 != null) {
                            NodeChain v2_4 = v4_1.getNodes$ui();
                            if(v2_4 != null) {
                                v2_3 = v2_4.getTail$ui();
                                continue;
                            }
                        }

                        v2_3 = v7;
                    }

                    if(v5_1 != null) {
                        v2_2 = v5_1.size() - 1;
                        if(v2_2 >= 0) {
                            while(true) {
                            label_255:
                                v4_2 = v2_2 - 1;
                                if(!((List)v5_1).get(v2_2).onPreKeyEvent-ZmokQxo(v1)) {
                                    goto label_261;
                                }
                                else {
                                    goto label_259;
                                }
                            }
                        }
                    }

                    goto label_266;
                }

                goto label_373;
            }
            catch(Throwable v0_1) {
                goto label_376;
            }
        }
        else {
            goto label_27;
        }

        goto label_175;
    label_261:
        if(v4_2 < 0) {
        }
        else {
            v2_2 = v4_2;
            goto label_255;
        label_259:
            Trace.endSection();
            return 1;
        }

        try {
        label_266:
            v2_3 = ((DelegatableNode)v9).getNode();
            v4_3 = ((MutableVector)v7);
            while(true) {
            label_268:
                if(v2_3 == null) {
                    goto label_310;
                }

                if(!(v2_3 instanceof KeyInputModifierNode)) {
                    goto label_275;
                }
                else if(((KeyInputModifierNode)v2_3).onPreKeyEvent-ZmokQxo(v1)) {
                    break;
                }

                goto label_308;
            }
        }
        catch(Throwable v0_1) {
            goto label_376;
        }

        Trace.endSection();
        return 1;
        try {
        label_275:
            if((v2_3.getKindSet$ui() & v0_4) != 0 && ((v2_3 instanceof DelegatingNode))) {
                v10 = v2_3.getDelegate$ui();
                int v11_2 = 0;
                while(v10 != null) {
                    if((v10.getKindSet$ui() & v0_4) != 0) {
                        ++v11_2;
                        if(v11_2 == 1) {
                            v2_3 = v10;
                        }
                        else {
                            if(v4_3 == null) {
                                v4_3 = new MutableVector(new Node[v6], 0);
                            }

                            if(v2_3 != null) {
                                if(v4_3 != null) {
                                    Boolean.valueOf(v4_3.add(v2_3));
                                }

                                v2_3 = v7;
                            }

                            if(v4_3 == null) {
                                goto label_304;
                            }

                            Boolean.valueOf(v4_3.add(v10));
                        }
                    }

                label_304:
                    v10 = v10.getChild$ui();
                }

                if(v11_2 != 1) {
                    goto label_308;
                }

                goto label_268;
            }

        label_308:
            v2_3 = DelegatableNodeKt.access$pop(v4_3);
            goto label_268;
        label_310:
            if(!arg18.invoke().booleanValue()) {
                goto label_315;
            }
        }
        catch(Throwable v0_1) {
            goto label_376;
        }

        Trace.endSection();
        return 1;
        try {
        label_315:
            v2_3 = ((DelegatableNode)v9).getNode();
            v4_3 = ((MutableVector)v7);
            while(true) {
            label_317:
                if(v2_3 == null) {
                    goto label_359;
                }

                if(!(v2_3 instanceof KeyInputModifierNode)) {
                    goto label_324;
                }
                else if(((KeyInputModifierNode)v2_3).onKeyEvent-ZmokQxo(v1)) {
                    break;
                }

                goto label_357;
            }
        }
        catch(Throwable v0_1) {
            goto label_376;
        }

        Trace.endSection();
        return 1;
        try {
        label_324:
            if((v2_3.getKindSet$ui() & v0_4) != 0 && ((v2_3 instanceof DelegatingNode))) {
                v9 = v2_3.getDelegate$ui();
                int v10_2 = 0;
                while(v9 != null) {
                    if((v9.getKindSet$ui() & v0_4) != 0) {
                        ++v10_2;
                        if(v10_2 == 1) {
                            v2_3 = v9;
                        }
                        else {
                            if(v4_3 == null) {
                                v4_3 = new MutableVector(new Node[v6], 0);
                            }

                            if(v2_3 != null) {
                                if(v4_3 != null) {
                                    Boolean.valueOf(v4_3.add(v2_3));
                                }

                                v2_3 = v7;
                            }

                            if(v4_3 == null) {
                                goto label_353;
                            }

                            Boolean.valueOf(v4_3.add(v9));
                        }
                    }

                label_353:
                    v9 = v9.getChild$ui();
                }

                if(v10_2 != 1) {
                    goto label_357;
                }

                goto label_317;
            }

        label_357:
            v2_3 = DelegatableNodeKt.access$pop(v4_3);
            goto label_317;
        label_359:
            if(v5_1 != null) {
                v0_4 = v5_1.size();
                v2_2 = 0;
                while(true) {
                label_363:
                    if(v2_2 >= v0_4) {
                    }
                    else if(((List)v5_1).get(v2_2).onKeyEvent-ZmokQxo(v1)) {
                        goto label_367;
                    }
                    else {
                        goto label_369;
                    }

                    goto label_373;
                }
            }

            goto label_373;
        }
        catch(Throwable v0_1) {
            goto label_376;
        }

    label_367:
        Trace.endSection();
        return 1;
    label_369:
        ++v2_2;
        goto label_363;
    label_373:
        Trace.endSection();
        return 0;
    label_376:
        Trace.endSection();
        throw v0_1;
    }

    public boolean dispatchRotaryEvent(RotaryScrollEvent arg14, Function0 arg15) {
        int v11;
        Node v10;
        Node v8;
        MutableVector v9;
        Node v7;
        if(this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println("FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
            return 0;
        }

        FocusTargetNode v13 = this.findFocusTargetNode();
        String v0 = "visitAncestors called on an unattached node";
        int v2 = 0x4000;
        int v3 = 16;
        Node v4 = null;
        if(v13 != null) {
            int v6 = NodeKind.constructor-impl(v2);
            if(!((DelegatableNode)v13).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException(v0);
            }

            v7 = ((DelegatableNode)v13).getNode();
            LayoutNode v13_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v13));
            while(v13_1 != null) {
                if((v13_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v6) != 0) {
                    while(v7 != null) {
                        if((v7.getKindSet$ui() & v6) != 0) {
                            v9 = ((MutableVector)v4);
                            v8 = v7;
                            while(true) {
                            label_34:
                                if(v8 != null) {
                                    if((v8 instanceof RotaryInputModifierNode)) {
                                        goto label_83;
                                    }
                                    else {
                                        if((v8.getKindSet$ui() & v6) != 0 && ((v8 instanceof DelegatingNode))) {
                                            v10 = v8.getDelegate$ui();
                                            v11 = 0;
                                            while(v10 != null) {
                                                if((v10.getKindSet$ui() & v6) != 0) {
                                                    ++v11;
                                                    if(v11 == 1) {
                                                        v8 = v10;
                                                    }
                                                    else {
                                                        if(v9 == null) {
                                                            v9 = new MutableVector(new Node[v3], 0);
                                                        }

                                                        if(v8 != null) {
                                                            if(v9 != null) {
                                                                v9.add(v8);
                                                            }

                                                            v8 = v4;
                                                        }

                                                        if(v9 == null) {
                                                            goto label_64;
                                                        }

                                                        v9.add(v10);
                                                    }
                                                }

                                            label_64:
                                                v10 = v10.getChild$ui();
                                            }

                                            if(v11 != 1) {
                                                break;
                                            }

                                            continue;
                                        }

                                        break;
                                    }
                                }

                                goto label_70;
                            }

                            v8 = DelegatableNodeKt.access$pop(v9);
                            goto label_34;
                        }

                    label_70:
                        v7 = v7.getParent$ui();
                    }
                }

                v13_1 = v13_1.getParent$ui();
                if(v13_1 != null) {
                    NodeChain v7_1 = v13_1.getNodes$ui();
                    if(v7_1 != null) {
                        v7 = v7_1.getTail$ui();
                        continue;
                    }
                }

                v7 = v4;
            }

            v8 = v4;
        }
        else {
            v8 = v4;
        }

    label_83:
        if(v8 != null) {
            int v13_2 = NodeKind.constructor-impl(v2);
            if(!((DelegatableNode)v8).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException(v0);
            }

            Node v0_1 = ((DelegatableNode)v8).getNode().getParent$ui();
            LayoutNode v2_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v8));
            ArrayList v6_1 = ((ArrayList)v4);
            while(v2_1 != null) {
                if((v2_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v13_2) != 0) {
                    while(v0_1 != null) {
                        if((v0_1.getKindSet$ui() & v13_2) != 0) {
                            v7 = v0_1;
                            v9 = ((MutableVector)v4);
                            while(true) {
                            label_105:
                                if(v7 != null) {
                                    if((v7 instanceof RotaryInputModifierNode)) {
                                        if(v6_1 == null) {
                                            v6_1 = new ArrayList();
                                        }

                                        ((List)v6_1).add(v7);
                                    }
                                    else {
                                        if((v7.getKindSet$ui() & v13_2) == 0) {
                                            break;
                                        }

                                        if(!(v7 instanceof DelegatingNode)) {
                                            break;
                                        }

                                        v10 = v7.getDelegate$ui();
                                        v11 = 0;
                                        while(v10 != null) {
                                            if((v10.getKindSet$ui() & v13_2) != 0) {
                                                ++v11;
                                                if(v11 == 1) {
                                                    v7 = v10;
                                                }
                                                else {
                                                    if(v9 == null) {
                                                        v9 = new MutableVector(new Node[v3], 0);
                                                    }

                                                    if(v7 != null) {
                                                        if(v9 != null) {
                                                            v9.add(v7);
                                                        }

                                                        v7 = v4;
                                                    }

                                                    if(v9 == null) {
                                                        goto label_139;
                                                    }

                                                    v9.add(v10);
                                                }
                                            }

                                        label_139:
                                            v10 = v10.getChild$ui();
                                        }

                                        if(v11 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                goto label_145;
                            }

                            v7 = DelegatableNodeKt.access$pop(v9);
                            goto label_105;
                        }

                    label_145:
                        v0_1 = v0_1.getParent$ui();
                    }
                }

                v2_1 = v2_1.getParent$ui();
                if(v2_1 != null) {
                    NodeChain v0_2 = v2_1.getNodes$ui();
                    if(v0_2 != null) {
                        v0_1 = v0_2.getTail$ui();
                        continue;
                    }
                }

                v0_1 = v4;
            }

            if(v6_1 != null) {
                int v0_3 = v6_1.size() - 1;
                if(v0_3 < 0) {
                    goto label_169;
                }

                while(true) {
                    v2 = v0_3 - 1;
                    if(((List)v6_1).get(v0_3).onPreRotaryScrollEvent(arg14)) {
                        return 1;
                    }

                    if(v2 < 0) {
                        goto label_169;
                    }

                    v0_3 = v2;
                }

                return 1;
            }

        label_169:
            v0_1 = ((DelegatableNode)v8).getNode();
            MutableVector v2_2 = ((MutableVector)v4);
            while(true) {
            label_171:
                if(v0_1 == null) {
                    goto label_209;
                }

                if((v0_1 instanceof RotaryInputModifierNode)) {
                    if(((RotaryInputModifierNode)v0_1).onPreRotaryScrollEvent(arg14)) {
                        return 1;
                    }
                }
                else if((v0_1.getKindSet$ui() & v13_2) != 0 && ((v0_1 instanceof DelegatingNode))) {
                    v7 = v0_1.getDelegate$ui();
                    int v9_1 = 0;
                    while(v7 != null) {
                        if((v7.getKindSet$ui() & v13_2) != 0) {
                            ++v9_1;
                            if(v9_1 == 1) {
                                v0_1 = v7;
                            }
                            else {
                                if(v2_2 == null) {
                                    v2_2 = new MutableVector(new Node[v3], 0);
                                }

                                if(v0_1 != null) {
                                    if(v2_2 != null) {
                                        v2_2.add(v0_1);
                                    }

                                    v0_1 = v4;
                                }

                                if(v2_2 == null) {
                                    goto label_203;
                                }

                                v2_2.add(v7);
                            }
                        }

                    label_203:
                        v7 = v7.getChild$ui();
                    }

                    if(v9_1 != 1) {
                        break;
                    }

                    continue;
                }

                break;
            }

            v0_1 = DelegatableNodeKt.access$pop(v2_2);
            goto label_171;
        label_209:
            if(arg15.invoke().booleanValue()) {
                return 1;
            }

            Node v15 = ((DelegatableNode)v8).getNode();
            MutableVector v0_4 = ((MutableVector)v4);
            while(true) {
            label_215:
                if(v15 == null) {
                    goto label_253;
                }

                if((v15 instanceof RotaryInputModifierNode)) {
                    if(((RotaryInputModifierNode)v15).onRotaryScrollEvent(arg14)) {
                        return 1;
                    }
                }
                else if((v15.getKindSet$ui() & v13_2) != 0 && ((v15 instanceof DelegatingNode))) {
                    Node v2_3 = v15.getDelegate$ui();
                    int v7_2 = 0;
                    while(v2_3 != null) {
                        if((v2_3.getKindSet$ui() & v13_2) != 0) {
                            ++v7_2;
                            if(v7_2 == 1) {
                                v15 = v2_3;
                            }
                            else {
                                if(v0_4 == null) {
                                    v0_4 = new MutableVector(new Node[v3], 0);
                                }

                                if(v15 != null) {
                                    if(v0_4 != null) {
                                        v0_4.add(v15);
                                    }

                                    v15 = v4;
                                }

                                if(v0_4 == null) {
                                    goto label_247;
                                }

                                v0_4.add(v2_3);
                            }
                        }

                    label_247:
                        v2_3 = v2_3.getChild$ui();
                    }

                    if(v7_2 != 1) {
                        break;
                    }

                    continue;
                }

                break;
            }

            v15 = DelegatableNodeKt.access$pop(v0_4);
            goto label_215;
        label_253:
            if(v6_1 == null) {
                return 0;
            }

            v13_2 = v6_1.size();
            int v15_1;
            for(v15_1 = 0; v15_1 < v13_2; ++v15_1) {
                if(((List)v6_1).get(v15_1).onRotaryScrollEvent(arg14)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private final FocusTargetNode findFocusTargetNode() {
        return FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
    }

    public Boolean focusSearch-ULY8qGw(int arg13, Rect arg14, Function1 arg15) {
        Node v3_1;
        MutableVector v8;
        FocusTargetNode v0 = this.findFocusTargetNode();
        Boolean v1 = null;
        if(v0 != null) {
            FocusRequester v2 = FocusTraversalKt.customFocusSearch--OM-vw8(v0, arg13, this.owner.getLayoutDirection());
            if(Intrinsics.areEqual(v2, FocusRequester.Companion.getCancel())) {
                return v1;
            }
            else if(Intrinsics.areEqual(v2, FocusRequester.Companion.getRedirect$ui())) {
                FocusTargetNode v12 = this.findFocusTargetNode();
                if(v12 != null) {
                    return arg15.invoke(v12);
                }
                else {
                    return v1;
                }
            }
            else if(!Intrinsics.areEqual(v2, FocusRequester.Companion.getDefault())) {
                if(ComposeUiFlags.isRequestFocusOnNonFocusableFocusTargetEnabled) {
                    String v13 = "\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n";
                    if(v2 == FocusRequester.Companion.getDefault()) {
                        throw new IllegalStateException(v13.toString());
                    }
                    else if(v2 != FocusRequester.Companion.getCancel()) {
                        boolean v13_1 = false;
                        if(v2.getFocusRequesterNodes$ui().getSize() == 0) {
                            System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
                        }
                        else {
                            MutableVector v12_1 = v2.getFocusRequesterNodes$ui();
                            Object[] v14 = v12_1.content;
                            int v12_2 = v12_1.getSize();
                            int v0_1 = 0;
                            boolean v2_1 = false;
                            while(v0_1 < v12_2) {
                                Object v3 = v14[v0_1];
                                int v4 = NodeKind.constructor-impl(0x400);
                                if(!((DelegatableNode)v3).getNode().isAttached()) {
                                    InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
                                }

                                int v6 = 16;
                                MutableVector v5 = new MutableVector(new Node[v6], 0);
                                Node v7 = ((DelegatableNode)v3).getNode().getChild$ui();
                                if(v7 == null) {
                                    DelegatableNodeKt.access$addLayoutNodeChildren(v5, ((DelegatableNode)v3).getNode(), false);
                                }
                                else {
                                    v5.add(v7);
                                }

                                while(true) {
                                label_66:
                                    if(v5.getSize() != 0) {
                                        v3 = v5.removeAt(v5.getSize() - 1);
                                        if((((Node)v3).getAggregateChildKindSet$ui() & v4) == 0) {
                                            DelegatableNodeKt.access$addLayoutNodeChildren(v5, ((Node)v3), false);
                                            continue;
                                        }

                                        break;
                                    }

                                    goto label_124;
                                }

                                while(true) {
                                    if(v3 == null) {
                                        goto label_66;
                                    }

                                    if((((Node)v3).getKindSet$ui() & v4) != 0) {
                                        v8 = ((MutableVector)v1);
                                        break;
                                    }

                                    v3_1 = ((Node)v3).getChild$ui();
                                }

                                while(true) {
                                label_82:
                                    if(v3 == null) {
                                        goto label_66;
                                    }

                                    if((v3 instanceof FocusTargetNode)) {
                                        if(arg15.invoke(v3).booleanValue()) {
                                            v2_1 = true;
                                            goto label_124;
                                        }
                                    }
                                    else if((((Node)v3).getKindSet$ui() & v4) != 0 && ((v3 instanceof DelegatingNode))) {
                                        Node v9 = v3.getDelegate$ui();
                                        int v10 = 0;
                                        while(v9 != null) {
                                            if((v9.getKindSet$ui() & v4) != 0) {
                                                ++v10;
                                                if(v10 == 1) {
                                                    v3_1 = v9;
                                                }
                                                else {
                                                    if(v8 == null) {
                                                        v8 = new MutableVector(new Node[v6], 0);
                                                    }

                                                    if(v3 != null) {
                                                        if(v8 != null) {
                                                            v8.add(v3);
                                                        }

                                                        v3 = v1;
                                                    }

                                                    if(v8 == null) {
                                                        goto label_116;
                                                    }

                                                    v8.add(v9);
                                                }
                                            }

                                        label_116:
                                            v9 = v9.getChild$ui();
                                        }

                                        if(v10 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                v3_1 = DelegatableNodeKt.access$pop(v8);
                                goto label_82;
                            label_124:
                                ++v0_1;
                            }

                            v13_1 = v2_1;
                        }

                        return Boolean.valueOf(v13_1);
                    }
                    else {
                        throw new IllegalStateException(v13.toString());
                    }
                }
                else {
                    return Boolean.valueOf(v2.findFocusTargetNode$ui(arg15));
                }
            }
        }
        else {
            v0 = ((FocusTargetNode)v1);
        }

        return FocusTraversalKt.focusSearch-0X8WOeE(this.rootFocusNode, arg13, this.owner.getLayoutDirection(), arg14, new FocusOwnerImpl$focusSearch$1(v0, this, arg15));
    }

    public void focusTargetAvailable() {
        this.platformFocusOwner.focusTargetAvailable();
    }

    public FocusTargetNode getActiveFocusTargetNode() {
        FocusTargetNode v0 = this.activeFocusTargetNode;
        if(v0 != null && (v0.isAttached())) {
            return this.activeFocusTargetNode;
        }

        return null;
    }

    public Rect getFocusRect() {
        FocusTargetNode v0 = this.findFocusTargetNode();
        if(v0 != null) {
            return FocusTraversalKt.focusRect(v0);
        }

        return null;
    }

    public MutableObjectList getListeners() {
        return this.listeners;
    }

    public Modifier getModifier() {
        return this.modifier;
    }

    public final FocusTargetNode getRootFocusNode$ui() {
        return this.rootFocusNode;
    }

    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    public boolean hasFocusableContent() {
        Node v7_1;
        if(!this.rootFocusNode.isAttached()) {
            return 0;
        }

        FocusTargetNode v12 = this.rootFocusNode;
        int v0 = NodeKind.constructor-impl(0x400);
        if(!((DelegatableNode)v12).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }

        int v3 = 16;
        MutableVector v2 = new MutableVector(new Node[v3], 0);
        Node v4 = ((DelegatableNode)v12).getNode().getChild$ui();
        if(v4 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v2, ((DelegatableNode)v12).getNode(), false);
        }
        else {
            v2.add(v4);
        }

        while(v2.getSize() != 0) {
            Object v12_1 = v2.removeAt(v2.getSize() - 1);
            if((((Node)v12_1).getAggregateChildKindSet$ui() & v0) != 0) {
                Object v5 = v12_1;
                while(v5 != null) {
                    if(!((Node)v5).isAttached()) {
                        break;
                    }

                    if((((Node)v5).getKindSet$ui() & v0) != 0) {
                        Object v6 = null;
                        Object v7 = v5;
                        MutableVector v8 = ((MutableVector)v6);
                        while(true) {
                        label_43:
                            if(v7 != null) {
                                if((v7 instanceof FocusTargetNode)) {
                                    if((((FocusTargetNode)v7).isAttached()) && (((FocusTargetNode)v7).fetchFocusProperties$ui().getCanFocus())) {
                                        return 1;
                                    }
                                }
                                else if((((Node)v7).getKindSet$ui() & v0) != 0 && ((v7 instanceof DelegatingNode))) {
                                    Node v9 = v7.getDelegate$ui();
                                    int v10 = 0;
                                    while(v9 != null) {
                                        if((v9.getKindSet$ui() & v0) != 0) {
                                            ++v10;
                                            if(v10 == 1) {
                                                v7_1 = v9;
                                            }
                                            else {
                                                if(v8 == null) {
                                                    v8 = new MutableVector(new Node[v3], 0);
                                                }

                                                if(v7 != null) {
                                                    if(v8 != null) {
                                                        v8.add(v7);
                                                    }

                                                    v7 = v6;
                                                }

                                                if(v8 == null) {
                                                    goto label_78;
                                                }

                                                v8.add(v9);
                                            }
                                        }

                                    label_78:
                                        v9 = v9.getChild$ui();
                                    }

                                    if(v10 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_84;
                        }

                        v7_1 = DelegatableNodeKt.access$pop(v8);
                        goto label_43;
                    }

                label_84:
                    Node v5_1 = v5_1.getChild$ui();
                }
            }

            DelegatableNodeKt.access$addLayoutNodeChildren(v2, ((Node)v12_1), false);
        }

        return 0;
    }

    public boolean hasNonInteropFocusableContent() {
        Node v7_1;
        if(!this.rootFocusNode.isAttached()) {
            return 0;
        }

        FocusTargetNode v12 = this.rootFocusNode;
        int v0 = NodeKind.constructor-impl(0x400);
        if(!((DelegatableNode)v12).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }

        int v3 = 16;
        MutableVector v2 = new MutableVector(new Node[v3], 0);
        Node v4 = ((DelegatableNode)v12).getNode().getChild$ui();
        if(v4 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v2, ((DelegatableNode)v12).getNode(), false);
        }
        else {
            v2.add(v4);
        }

        while(v2.getSize() != 0) {
            Object v12_1 = v2.removeAt(v2.getSize() - 1);
            if((((Node)v12_1).getAggregateChildKindSet$ui() & v0) != 0) {
                Object v5 = v12_1;
                while(v5 != null) {
                    if(!((Node)v5).isAttached()) {
                        break;
                    }

                    if((((Node)v5).getKindSet$ui() & v0) != 0) {
                        Object v6 = null;
                        Object v7 = v5;
                        MutableVector v8 = ((MutableVector)v6);
                        while(true) {
                        label_43:
                            if(v7 != null) {
                                if((v7 instanceof FocusTargetNode)) {
                                    if(!((FocusTargetNode)v7).isAttached()) {
                                    }
                                    else {
                                        FocusProperties v9 = ((FocusTargetNode)v7).fetchFocusProperties$ui();
                                        if((((FocusTargetNode)v7).isAttached()) && !((FocusTargetNode)v7).isInteropViewHost() && (v9.getCanFocus())) {
                                            return 1;
                                        }
                                    }
                                }
                                else if((((Node)v7).getKindSet$ui() & v0) != 0 && ((v7 instanceof DelegatingNode))) {
                                    Node v9_1 = v7.getDelegate$ui();
                                    int v10 = 0;
                                    while(v9_1 != null) {
                                        if((v9_1.getKindSet$ui() & v0) != 0) {
                                            ++v10;
                                            if(v10 == 1) {
                                                v7_1 = v9_1;
                                            }
                                            else {
                                                if(v8 == null) {
                                                    v8 = new MutableVector(new Node[v3], 0);
                                                }

                                                if(v7 != null) {
                                                    if(v8 != null) {
                                                        v8.add(v7);
                                                    }

                                                    v7 = v6;
                                                }

                                                if(v8 == null) {
                                                    goto label_83;
                                                }

                                                v8.add(v9_1);
                                            }
                                        }

                                    label_83:
                                        v9_1 = v9_1.getChild$ui();
                                    }

                                    if(v10 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_89;
                        }

                        v7_1 = DelegatableNodeKt.access$pop(v8);
                        goto label_43;
                    }

                label_89:
                    Node v5_1 = v5_1.getChild$ui();
                }
            }

            DelegatableNodeKt.access$addLayoutNodeChildren(v2, ((Node)v12_1), false);
        }

        return 0;
    }

    public boolean isFocusCaptured() {
        return this.isFocusCaptured;
    }

    private final Node lastLocalKeyInputNode(DelegatableNode arg5) {
        int v4 = 0x400;
        int v0 = NodeKind.constructor-impl(v4) | NodeKind.constructor-impl(0x2000);
        if(!arg5.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }

        Node v5 = arg5.getNode();
        Node v2 = null;
        if((v5.getAggregateChildKindSet$ui() & v0) != 0) {
            for(v5 = v5.getChild$ui(); v5 != null; v5 = v5.getChild$ui()) {
                if((v5.getKindSet$ui() & v0) != 0) {
                    if((NodeKind.constructor-impl(v4) & v5.getKindSet$ui()) != 0) {
                        return v2;
                    }
                    else {
                        v2 = v5;
                    }
                }
            }
        }

        return v2;
    }

    public boolean moveFocus-3ESFkO8(int arg2) {
        return this.moveFocus-aToIllA(arg2, true);
    }

    public boolean moveFocus-aToIllA(int arg7, boolean arg8) {
        if(ComposeUiFlags.isViewFocusFixEnabled) {
        label_9:
            if(this.platformFocusOwner.moveFocusInChildren-3ESFkO8(arg7)) {
                return 1;
            }
        }
        else if(ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            FocusTargetNode v0 = this.getActiveFocusTargetNode();
            if(v0 != null && (v0.isInteropViewHost())) {
                goto label_9;
            }
        }

        ObjectRef v0_1 = new ObjectRef();
        v0_1.element = Boolean.valueOf(false);
        FocusTargetNode v3 = this.getActiveFocusTargetNode();
        Boolean v4 = this.focusSearch-ULY8qGw(arg7, this.platformFocusOwner.getEmbeddedViewFocusRect(), new FocusOwnerImpl$moveFocus$focusSearchSuccess$1(v0_1, arg7));
        if((Intrinsics.areEqual(v4, Boolean.valueOf(true))) && v3 != this.getActiveFocusTargetNode()) {
            return 1;
        }

        if(v4 != null) {
            if(v0_1.element == null) {
            }
            else {
                if((v4.booleanValue()) && (v0_1.element.booleanValue())) {
                    return 1;
                }

                if((FocusOwnerImplKt.is1dFocusSearch-3ESFkO8(arg7)) && (arg8)) {
                    if((this.clearFocus-I7lrPNg(false, true, false, arg7)) && (this.takeFocus-aToIllA(arg7, null))) {
                        return 1;
                    }

                    return 0;
                }

                if(ComposeUiFlags.isViewFocusFixEnabled) {
                    return 0;
                }

                if(ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
                    return 0;
                }

                return this.platformFocusOwner.moveFocusInChildren-3ESFkO8(arg7);
            }
        }

        return 0;
    }

    private final Object nearestAncestorIncludingSelf-64DMado(DelegatableNode arg9, int arg10) {
        Node v0;
        if(!arg9.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v8 = arg9.getNode();
        LayoutNode v9 = DelegatableNodeKt.requireLayoutNode(arg9);
        while(true) {
            v0 = null;
            if(v9 == null) {
                return v0;
            }

            if((v9.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg10) != 0) {
                while(v8 != null) {
                    if((v8.getKindSet$ui() & arg10) != 0) {
                        Node v1 = v8;
                        MutableVector v2 = ((MutableVector)v0);
                        while(true) {
                        label_22:
                            if(v1 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if((v1 instanceof Object)) {
                                    return v1;
                                }
                                else {
                                    if((v1.getKindSet$ui() & arg10) != 0 && ((v1 instanceof DelegatingNode))) {
                                        Node v3 = v1.getDelegate$ui();
                                        int v5 = 0;
                                        while(v3 != null) {
                                            if((v3.getKindSet$ui() & arg10) != 0) {
                                                ++v5;
                                                if(v5 == 1) {
                                                    v1 = v3;
                                                }
                                                else {
                                                    if(v2 == null) {
                                                        v2 = new MutableVector(new Node[16], 0);
                                                    }

                                                    if(v1 != null) {
                                                        if(v2 != null) {
                                                            v2.add(v1);
                                                        }

                                                        v1 = v0;
                                                    }

                                                    if(v2 == null) {
                                                        goto label_65;
                                                    }

                                                    v2.add(v3);
                                                }
                                            }

                                        label_65:
                                            v3 = v3.getChild$ui();
                                        }

                                        if(v5 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }
                            }

                            goto label_72;
                        }

                        v1 = DelegatableNodeKt.access$pop(v2);
                        goto label_22;
                    }

                label_72:
                    v8 = v8.getParent$ui();
                }
            }

            v9 = v9.getParent$ui();
            if(v9 != null) {
                NodeChain v8_1 = v9.getNodes$ui();
                if(v8_1 != null) {
                    v8 = v8_1.getTail$ui();
                    continue;
                }
            }

            v8 = v0;
        }

        return v0;
    }

    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
        if((ComposeUiFlags.isOptimizedFocusEventDispatchEnabled) && this.getActiveFocusTargetNode() != null) {
            FocusTargetNode v0 = this.getActiveFocusTargetNode();
            this.setActiveFocusTargetNode(null);
            if(v0 != null) {
                v0.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
            }
        }
    }

    public boolean requestOwnerFocus-7o62pno(FocusDirection arg1, Rect arg2) {
        return this.platformFocusOwner.requestOwnerFocus-7o62pno(arg1, arg2);
    }

    public boolean resetFocus-3ESFkO8(int arg4) {
        boolean v1 = false;
        if(!this.clearFocus-I7lrPNg(false, true, false, arg4)) {
            return 0;
        }

        Boolean v4 = this.focusSearch-ULY8qGw(arg4, null, new FocusOwnerImpl$resetFocus$successfulReset$1(arg4));
        if(v4 != null) {
            v1 = v4.booleanValue();
        }

        if(!v1) {
            this.clearOwnerFocus();
        }

        return v1;
    }

    public void scheduleInvalidation(FocusEventModifierNode arg1) {
        this.focusInvalidationManager.scheduleInvalidation(arg1);
    }

    public void scheduleInvalidation(FocusTargetNode arg1) {
        this.focusInvalidationManager.scheduleInvalidation(arg1);
    }

    public void scheduleInvalidationForOwner() {
        this.focusInvalidationManager.scheduleInvalidation();
    }

    public void setActiveFocusTargetNode(FocusTargetNode arg7) {
        FocusTargetNode v0 = this.activeFocusTargetNode;
        this.activeFocusTargetNode = arg7;
        int v1 = 0;
        if(arg7 == null || v0 != arg7) {
            this.setFocusCaptured(false);
        }

        if(ComposeUiFlags.isSemanticAutofillEnabled) {
            MutableObjectList v6 = this.getListeners();
            Object[] v2 = ((ObjectList)v6).content;
            int v6_1 = ((ObjectList)v6)._size;
            while(v1 < v6_1) {
                v2[v1].onFocusChanged(v0, arg7);
                ++v1;
            }
        }
    }

    public void setFocusCaptured(boolean arg2) {
        int v0 = !arg2 || this.getActiveFocusTargetNode() != null ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot capture focus when the active focus target node is unset");
        }

        this.isFocusCaptured = arg2;
    }

    public final void setRootFocusNode$ui(FocusTargetNode arg1) {
        this.rootFocusNode = arg1;
    }

    public boolean takeFocus-aToIllA(int arg2, Rect arg3) {
        Boolean v1 = this.focusSearch-ULY8qGw(arg2, arg3, new FocusOwnerImpl$takeFocus$1(arg2));
        if(v1 != null) {
            return v1.booleanValue();
        }

        return 0;
    }

    private final void traverseAncestorsIncludingSelf-QFhIj7k(DelegatableNode arg17, int arg18, Function1 arg19, Function0 arg20, Function1 arg21) {
        Node v11;
        int v9;
        int v8;
        String v7;
        int v6;
        Function1 v0 = arg19;
        Function1 v1 = arg21;
        if(!arg17.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v2 = arg17.getNode().getParent$ui();
        LayoutNode v3 = DelegatableNodeKt.requireLayoutNode(arg17);
        Node v4 = null;
        ArrayList v5 = ((ArrayList)v4);
        while(true) {
            v6 = 16;
            v7 = "T";
            v8 = 3;
            v9 = 0;
            if(v3 == null) {
                break;
            }

            if((v3.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg18) != 0) {
                while(v2 != null) {
                    if((v2.getKindSet$ui() & arg18) != 0) {
                        v11 = v2;
                        MutableVector v12 = ((MutableVector)v4);
                        while(true) {
                        label_31:
                            if(v11 != null) {
                                Intrinsics.reifiedOperationMarker(v8, v7);
                                if((v11 instanceof Object)) {
                                    if(v5 == null) {
                                        v5 = new ArrayList();
                                    }

                                    ((List)v5).add(v11);
                                }
                                else {
                                    if((v11.getKindSet$ui() & arg18) == 0) {
                                        break;
                                    }

                                    if(!(v11 instanceof DelegatingNode)) {
                                        break;
                                    }

                                    Node v13 = v11.getDelegate$ui();
                                    int v14 = 0;
                                    while(v13 != null) {
                                        if((v13.getKindSet$ui() & arg18) != 0) {
                                            ++v14;
                                            if(v14 == 1) {
                                                v11 = v13;
                                            }
                                            else {
                                                if(v12 == null) {
                                                    v12 = new MutableVector(new Node[v6], 0);
                                                }

                                                if(v11 != null) {
                                                    if(v12 != null) {
                                                        v12.add(v11);
                                                    }

                                                    v11 = v4;
                                                }

                                                if(v12 == null) {
                                                    goto label_74;
                                                }

                                                v12.add(v13);
                                            }
                                        }

                                    label_74:
                                        v13 = v13.getChild$ui();
                                    }

                                    if(v14 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_81;
                        }

                        v11 = DelegatableNodeKt.access$pop(v12);
                        goto label_31;
                    }

                label_81:
                    v2 = v2.getParent$ui();
                }
            }

            v3 = v3.getParent$ui();
            if(v3 != null) {
                NodeChain v2_1 = v3.getNodes$ui();
                if(v2_1 != null) {
                    v2 = v2_1.getTail$ui();
                    continue;
                }
            }

            v2 = v4;
        }

        if(v5 != null) {
            int v2_2 = v5.size() - 1;
            if(v2_2 < 0) {
                goto label_104;
            }

            while(true) {
                int v3_1 = v2_2 - 1;
                v0.invoke(((List)v5).get(v2_2));
                if(v3_1 < 0) {
                    break;
                }

                v2_2 = v3_1;
            }
        }

    label_104:
        v2 = arg17.getNode();
        MutableVector v3_2 = ((MutableVector)v4);
        while(true) {
        label_106:
            if(v2 == null) {
                goto label_152;
            }

            Intrinsics.reifiedOperationMarker(v8, v7);
            if((v2 instanceof Object)) {
                v0.invoke(v2);
            }
            else if((v2.getKindSet$ui() & arg18) != 0 && ((v2 instanceof DelegatingNode))) {
                v11 = v2.getDelegate$ui();
                int v12_1 = 0;
                while(v11 != null) {
                    if((v11.getKindSet$ui() & arg18) != 0) {
                        ++v12_1;
                        if(v12_1 == 1) {
                            v2 = v11;
                        }
                        else {
                            if(v3_2 == null) {
                                v3_2 = new MutableVector(new Node[v6], 0);
                            }

                            if(v2 != null) {
                                if(v3_2 != null) {
                                    v3_2.add(v2);
                                }

                                v2 = v4;
                            }

                            if(v3_2 == null) {
                                goto label_145;
                            }

                            v3_2.add(v11);
                        }
                    }

                label_145:
                    v11 = v11.getChild$ui();
                }

                if(v12_1 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v2 = DelegatableNodeKt.access$pop(v3_2);
        goto label_106;
    label_152:
        arg20.invoke();
        Node v0_1 = arg17.getNode();
        MutableVector v2_3 = ((MutableVector)v4);
        while(true) {
        label_155:
            if(v0_1 == null) {
                goto label_201;
            }

            Intrinsics.reifiedOperationMarker(v8, v7);
            if((v0_1 instanceof Object)) {
                v1.invoke(v0_1);
            }
            else if((v0_1.getKindSet$ui() & arg18) != 0 && ((v0_1 instanceof DelegatingNode))) {
                Node v3_3 = v0_1.getDelegate$ui();
                int v11_1 = 0;
                while(v3_3 != null) {
                    if((v3_3.getKindSet$ui() & arg18) != 0) {
                        ++v11_1;
                        if(v11_1 == 1) {
                            v0_1 = v3_3;
                        }
                        else {
                            if(v2_3 == null) {
                                v2_3 = new MutableVector(new Node[v6], 0);
                            }

                            if(v0_1 != null) {
                                if(v2_3 != null) {
                                    v2_3.add(v0_1);
                                }

                                v0_1 = v4;
                            }

                            if(v2_3 == null) {
                                goto label_194;
                            }

                            v2_3.add(v3_3);
                        }
                    }

                label_194:
                    v3_3 = v3_3.getChild$ui();
                }

                if(v11_1 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v0_1 = DelegatableNodeKt.access$pop(v2_3);
        goto label_155;
    label_201:
        if(v5 != null) {
            int v0_2 = v5.size();
            while(v9 < v0_2) {
                v1.invoke(((List)v5).get(v9));
                ++v9;
            }
        }
    }

    private final boolean validateKeyEvent-ZmokQxo(KeyEvent arg5) {
        MutableLongSet v5_1;
        long v0 = KeyEvent_androidKt.getKey-ZmokQxo(arg5);
        int v5 = KeyEvent_androidKt.getType-ZmokQxo(arg5);
        if(KeyEventType.equals-impl0(v5, KeyEventType.Companion.getKeyDown-CS__XNY())) {
            v5_1 = this.keysCurrentlyDown;
            if(v5_1 == null) {
                v5_1 = new MutableLongSet(3);
                this.keysCurrentlyDown = v5_1;
            }

            v5_1.plusAssign(v0);
        }
        else {
            if(!KeyEventType.equals-impl0(v5, KeyEventType.Companion.getKeyUp-CS__XNY())) {
                return 1;
            }

            v5_1 = this.keysCurrentlyDown;
            if(v5_1 != null && (v5_1.contains(v0))) {
                MutableLongSet v4 = this.keysCurrentlyDown;
                if(v4 != null) {
                    v4.remove(v0);
                }
                else {
                }

                return 1;
            }

            return 0;
        }

        return 1;
    }
}

