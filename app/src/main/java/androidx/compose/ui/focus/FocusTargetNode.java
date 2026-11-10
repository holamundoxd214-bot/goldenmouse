package androidx.compose.ui.focus;

import android.os.Trace;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001VBo\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012:\b\u0002\u0010\u000B\u001A4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f\u0012\u0016\b\u0002\u0010\u0013\u001A\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010!\u001A\u00020\nH\u0017J\u0017\u0010!\u001A\u00020\n2\u0006\u0010\"\u001A\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001A\u00020\n2\u0006\u0010\"\u001A\u00020#H\u0002¢\u0006\u0004\b\'\u0010%J\b\u00106\u001A\u00020\u0012H\u0016J\b\u00107\u001A\u00020\u0012H\u0016J\b\u00108\u001A\u00020\u0012H\u0016J\u0010\u00109\u001A\u00020\u00122\u0006\u0010:\u001A\u00020;H\u0016J\r\u0010<\u001A\u00020=H\u0000¢\u0006\u0002\b>J\u0019\u0010?\u001A\u00020@2\n\b\u0002\u0010A\u001A\u0004\u0018\u00010;H\u0000¢\u0006\u0002\bBJK\u0010C\u001A\u00020\u00122\u0006\u0010\"\u001A\u00020#2\u0012\u0010D\u001A\u000E\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00120\u00142\u001D\u0010F\u001A\u0019\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\bHH\u0082\b¢\u0006\u0004\bI\u0010JJ,\u0010K\u001A\u00020\u00122\u0006\u0010\"\u001A\u00020#2\u0012\u0010D\u001A\u000E\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\b¢\u0006\u0004\bL\u0010MJ,\u0010N\u001A\u00020\u00122\u0006\u0010\"\u001A\u00020#2\u0012\u0010D\u001A\u000E\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\b¢\u0006\u0004\bO\u0010MJ\r\u0010P\u001A\u00020\u0012H\u0000¢\u0006\u0002\bQJ\u001D\u0010R\u001A\u00020\u00122\u0006\u0010S\u001A\u00020\r2\u0006\u0010T\u001A\u00020\rH\u0000¢\u0006\u0002\bUR\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0017R@\u0010\u000B\u001A4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0013\u001A\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001A\u001A\u0004\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001C\u001A\u00020\nX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0017R\u0014\u0010\u001E\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R&\u0010\u0007\u001A\u00020\b2\u0006\u0010(\u001A\u00020\b@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010-\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001A\u0010.\u001A\u00020/X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b0\u0010*\"\u0004\b1\u0010,R\u0013\u00102\u001A\u0004\u0018\u0001038F¢\u0006\u0006\u001A\u0004\b4\u00105¨\u0006W"}, d2={"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "focusability", "Landroidx/compose/ui/focus/Focusability;", "isInteropViewHost", "", "onFocusChange", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusState;", "Lkotlin/ParameterName;", "name", "previous", "current", "", "onDispatchEventsCompleted", "Lkotlin/Function1;", "<init>", "(IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "isProcessingCustomExit", "isProcessingCustomEnter", "committedFocusState", "Landroidx/compose/ui/focus/FocusStateImpl;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "focusState", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "requestFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "requestFocus-3ESFkO8", "(I)Z", "assignFocus", "assignFocus-3ESFkO8", "value", "getFocusability-LCbbffg", "()I", "setFocusability-josRg5g", "(I)V", "I", "previouslyFocusedChildHash", "", "getPreviouslyFocusedChildHash", "setPreviouslyFocusedChildHash", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "onObservedReadsChanged", "onReset", "onDetach", "onPlaced", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "fetchFocusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "fetchFocusProperties$ui", "fetchFocusRect", "Landroidx/compose/ui/geometry/Rect;", "relativeCoordinates", "fetchFocusRect$ui", "fetchCustomEnterOrExit", "block", "Landroidx/compose/ui/focus/FocusRequester;", "enterOrExit", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "Lkotlin/ExtensionFunctionType;", "fetchCustomEnterOrExit-ULY8qGw", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "fetchCustomEnter", "fetchCustomEnter-aToIllA$ui", "(ILkotlin/jvm/functions/Function1;)V", "fetchCustomExit", "fetchCustomExit-aToIllA$ui", "invalidateFocus", "invalidateFocus$ui", "dispatchFocusCallbacks", "previousState", "newState", "dispatchFocusCallbacks$ui", "FocusTargetElement", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusTargetNode extends Node implements FocusTargetModifierNode, ModifierLocalModifierNode, CompositionLocalConsumerModifierNode, LayoutAwareModifierNode, ObserverModifierNode {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0002H\u0016J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0002H\u0016J\f\u0010\t\u001A\u00020\u0007*\u00020\nH\u0016J\b\u0010\u000B\u001A\u00020\fH\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/ui/focus/FocusTargetNode$FocusTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "<init>", "()V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "", "other", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusTargetElement extends ModifierNodeElement {
        public static final int $stable;
        public static final FocusTargetElement INSTANCE;

        static {
            FocusTargetElement.INSTANCE = new FocusTargetElement();
        }

        private FocusTargetElement() {
            super();
        }

        public Node create() {
            return this.create();
        }

        public FocusTargetNode create() {
            return new FocusTargetNode(0, false, null, null, 15, null);
        }

        public boolean equals(Object arg1) {
            if((((FocusTargetElement)arg1)) == this) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return "focusTarget".hashCode();
        }

        public void inspectableProperties(InspectorInfo arg1) {
            arg1.setName("focusTarget");
        }

        public void update(Node arg1) {
            this.update(((FocusTargetNode)arg1));
        }

        public void update(FocusTargetNode arg1) {
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[CustomDestinationResult.values().length];
            try {
                v0[CustomDestinationResult.None.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                int v2 = 2;
                try {
                    v0[CustomDestinationResult.Redirected.ordinal()] = v2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    int v3 = 3;
                    try {
                        v0[CustomDestinationResult.Cancelled.ordinal()] = v3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        int v4 = 4;
                        try {
                            v0[CustomDestinationResult.RedirectCancelled.ordinal()] = v4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            v0 = new int[FocusStateImpl.values().length];
                            try {
                                v0[FocusStateImpl.Active.ordinal()] = 1;
                                goto label_26;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_26:
                                    v0[FocusStateImpl.Captured.ordinal()] = v2;
                                    goto label_29;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_29:
                                        v0[FocusStateImpl.ActiveParent.ordinal()] = v3;
                                        goto label_32;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_32:
                                            v0[FocusStateImpl.Inactive.ordinal()] = v4;
                                            goto label_35;
                                        }
                                        catch(NoSuchFieldError ) {
                                        label_35:
                                            WhenMappings.$EnumSwitchMapping$1 = v0;
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private FocusStateImpl committedFocusState;
    private int focusability;
    private final boolean isInteropViewHost;
    private boolean isProcessingCustomEnter;
    private boolean isProcessingCustomExit;
    private final Function1 onDispatchEventsCompleted;
    private final Function2 onFocusChange;
    private int previouslyFocusedChildHash;
    private final boolean shouldAutoInvalidate;

    static {
    }

    public FocusTargetNode(int arg7, boolean arg8, Function2 arg9, Function1 arg10, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 1) != 0) {
            arg7 = Focusability.Companion.getAlways-LCbbffg();
        }

        int v1 = arg7;
        Function2 v8 = null;
        Function2 v3 = (arg11 & 4) != 0 ? v8 : arg9;
        Function1 v4 = (arg11 & 8) != 0 ? ((Function1)v8) : arg10;
        this(v1, false, v3, v4, null);
    }

    private FocusTargetNode(int arg1, boolean arg2, Function2 arg3, Function1 arg4) {
        super();
        this.isInteropViewHost = arg2;
        this.onFocusChange = arg3;
        this.onDispatchEventsCompleted = arg4;
        this.focusability = arg1;
    }

    public FocusTargetNode(int arg1, boolean arg2, Function2 arg3, Function1 arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public static final boolean access$assignFocus-3ESFkO8(FocusTargetNode arg0, int arg1) {
        return arg0.assignFocus-3ESFkO8(arg1);
    }

    public static final boolean access$isProcessingCustomEnter$p(FocusTargetNode arg0) {
        return arg0.isProcessingCustomEnter;
    }

    public static final boolean access$isProcessingCustomExit$p(FocusTargetNode arg0) {
        return arg0.isProcessingCustomExit;
    }

    public static final void access$setProcessingCustomEnter$p(FocusTargetNode arg0, boolean arg1) {
        arg0.isProcessingCustomEnter = arg1;
    }

    public static final void access$setProcessingCustomExit$p(FocusTargetNode arg0, boolean arg1) {
        arg0.isProcessingCustomExit = arg1;
    }

    private final boolean assignFocus-3ESFkO8(int arg2) {
        arg2 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.performCustomRequestFocus-Mxy_nc0(this, arg2).ordinal()];
        if(arg2 != 1) {
            if(arg2 != 2) {
                if(arg2 != 3) {
                    if(arg2 == 4) {
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }
                }

                return 0;
            }

            return 1;
        }

        return FocusTransactionsKt.performRequestFocus(this);
    }

    public final void dispatchFocusCallbacks$ui(FocusState arg18, FocusState arg19) {
        FocusTargetNode v0 = this;
        FocusState v1 = arg19;
        FocusTargetNode v2 = v0;
        FocusOwner v3 = DelegatableNodeKt.requireOwner(((DelegatableNode)v2)).getFocusOwner();
        FocusTargetNode v4 = v3.getActiveFocusTargetNode();
        if(!Intrinsics.areEqual(arg18, arg19)) {
            Function2 v5 = v0.onFocusChange;
            if(v5 != null) {
                v5.invoke(arg18, v1);
            }
        }

        int v5_1 = NodeKind.constructor-impl(0x1000);
        int v6 = NodeKind.constructor-impl(0x400);
        Node v7 = ((DelegatableNode)v2).getNode();
        int v8 = v5_1 | v6;
        if(!((DelegatableNode)v2).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v9 = ((DelegatableNode)v2).getNode();
        LayoutNode v2_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v2));
        while(v2_1 != null) {
            if((v2_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v8) != 0) {
                while(v9 != null) {
                    if((v9.getKindSet$ui() & v8) != 0) {
                        if(v9 != v7 && (v9.getKindSet$ui() & v6) != 0) {
                            goto label_98;
                        }

                        if((v9.getKindSet$ui() & v5_1) == 0) {
                            goto label_88;
                        }

                        Node v10 = v9;
                        MutableVector v12 = null;
                        while(true) {
                        label_45:
                            if(v10 == null) {
                                goto label_88;
                            }

                            if((v10 instanceof FocusEventModifierNode)) {
                                if(v4 != v3.getActiveFocusTargetNode()) {
                                }
                                else {
                                    ((FocusEventModifierNode)v10).onFocusEvent(v1);
                                }
                            }
                            else if((v10.getKindSet$ui() & v5_1) != 0 && ((v10 instanceof DelegatingNode))) {
                                Node v13 = v10.getDelegate$ui();
                                int v15 = 0;
                                while(v13 != null) {
                                    if((v13.getKindSet$ui() & v5_1) != 0) {
                                        ++v15;
                                        if(v15 == 1) {
                                            v10 = v13;
                                        }
                                        else {
                                            if(v12 == null) {
                                                v12 = new MutableVector(new Node[16], 0);
                                            }

                                            if(v10 != null) {
                                                if(v12 != null) {
                                                    v12.add(v10);
                                                }

                                                v10 = null;
                                            }

                                            if(v12 == null) {
                                                goto label_82;
                                            }

                                            v12.add(v13);
                                        }
                                    }

                                label_82:
                                    v13 = v13.getChild$ui();
                                }

                                if(v15 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        v10 = DelegatableNodeKt.access$pop(v12);
                        goto label_45;
                    }

                label_88:
                    v9 = v9.getParent$ui();
                }
            }

            v2_1 = v2_1.getParent$ui();
            if(v2_1 != null) {
                NodeChain v9_1 = v2_1.getNodes$ui();
                if(v9_1 != null) {
                    v9 = v9_1.getTail$ui();
                    continue;
                }
            }

            v9 = null;
        }

    label_98:
        Function1 v1_1 = v0.onDispatchEventsCompleted;
        if(v1_1 != null) {
            v1_1.invoke(v0);
        }
    }

    public final void fetchCustomEnter-aToIllA$ui(int arg6, Function1 arg7) {
        if(!this.isProcessingCustomEnter) {
            this.isProcessingCustomEnter = true;
            try {
                FocusProperties v1 = this.fetchFocusProperties$ui();
                CancelIndicatingFocusBoundaryScope v2 = new CancelIndicatingFocusBoundaryScope(arg6, null);
                FocusOwner v6_1 = DelegatableNodeKt.requireOwner(this).getFocusOwner();
                FocusTargetNode v3 = v6_1.getActiveFocusTargetNode();
                v1.getOnEnter().invoke(v2);
                FocusTargetNode v6_2 = v6_1.getActiveFocusTargetNode();
                if(v2.isCanceled()) {
                    arg7.invoke(FocusRequester.Companion.getCancel());
                }
                else if(v3 != v6_2 && v6_2 != null) {
                    arg7.invoke(FocusRequester.Companion.getRedirect$ui());
                }
            }
            catch(Throwable v6) {
                this.isProcessingCustomEnter = false;
                throw v6;
            }

            this.isProcessingCustomEnter = false;
            return;
        }
    }

    private final void fetchCustomEnterOrExit-ULY8qGw(int arg4, Function1 arg5, Function2 arg6) {
        FocusProperties v0 = this.fetchFocusProperties$ui();
        CancelIndicatingFocusBoundaryScope v1 = new CancelIndicatingFocusBoundaryScope(arg4, null);
        FocusOwner v3 = DelegatableNodeKt.requireOwner(((DelegatableNode)this)).getFocusOwner();
        FocusTargetNode v4 = v3.getActiveFocusTargetNode();
        arg6.invoke(v0, v1);
        this = v3.getActiveFocusTargetNode();
        if(v1.isCanceled()) {
            arg5.invoke(FocusRequester.Companion.getCancel());
            return;
        }

        if(v4 != this && this != null) {
            arg5.invoke(FocusRequester.Companion.getRedirect$ui());
        }
    }

    public final void fetchCustomExit-aToIllA$ui(int arg6, Function1 arg7) {
        if(!this.isProcessingCustomExit) {
            this.isProcessingCustomExit = true;
            try {
                FocusProperties v1 = this.fetchFocusProperties$ui();
                CancelIndicatingFocusBoundaryScope v2 = new CancelIndicatingFocusBoundaryScope(arg6, null);
                FocusOwner v6_1 = DelegatableNodeKt.requireOwner(this).getFocusOwner();
                FocusTargetNode v3 = v6_1.getActiveFocusTargetNode();
                v1.getOnExit().invoke(v2);
                FocusTargetNode v6_2 = v6_1.getActiveFocusTargetNode();
                if(v2.isCanceled()) {
                    arg7.invoke(FocusRequester.Companion.getCancel());
                }
                else if(v3 != v6_2 && v6_2 != null) {
                    arg7.invoke(FocusRequester.Companion.getRedirect$ui());
                }
            }
            catch(Throwable v6) {
                this.isProcessingCustomExit = false;
                throw v6;
            }

            this.isProcessingCustomExit = false;
            return;
        }
    }

    public final FocusProperties fetchFocusProperties$ui() {
        FocusPropertiesImpl v0 = new FocusPropertiesImpl();
        v0.setCanFocus(Focusability.canFocus-impl$ui(this.getFocusability-LCbbffg(), this));
        int v1 = NodeKind.constructor-impl(0x800);
        int v2 = NodeKind.constructor-impl(0x400);
        Node v3 = ((DelegatableNode)this).getNode();
        int v4 = v1 | v2;
        if(!((DelegatableNode)this).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v5 = ((DelegatableNode)this).getNode();
        LayoutNode v14 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)this));
        while(v14 != null) {
            Node v7 = null;
            if((v14.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v4) != 0) {
                while(v5 != null) {
                    if((v5.getKindSet$ui() & v4) != 0) {
                        if(v5 != v3 && (v5.getKindSet$ui() & v2) != 0) {
                            goto label_91;
                        }

                        if((v5.getKindSet$ui() & v1) == 0) {
                            goto label_81;
                        }

                        Node v6 = v5;
                        MutableVector v8 = ((MutableVector)v7);
                        while(true) {
                        label_40:
                            if(v6 == null) {
                                goto label_81;
                            }

                            if((v6 instanceof FocusPropertiesModifierNode)) {
                                ((FocusPropertiesModifierNode)v6).applyFocusProperties(v0);
                            }
                            else if((v6.getKindSet$ui() & v1) != 0 && ((v6 instanceof DelegatingNode))) {
                                Node v9 = v6.getDelegate$ui();
                                int v11 = 0;
                                while(v9 != null) {
                                    if((v9.getKindSet$ui() & v1) != 0) {
                                        ++v11;
                                        if(v11 == 1) {
                                            v6 = v9;
                                        }
                                        else {
                                            if(v8 == null) {
                                                v8 = new MutableVector(new Node[16], 0);
                                            }

                                            if(v6 != null) {
                                                if(v8 != null) {
                                                    v8.add(v6);
                                                }

                                                v6 = v7;
                                            }

                                            if(v8 == null) {
                                                goto label_75;
                                            }

                                            v8.add(v9);
                                        }
                                    }

                                label_75:
                                    v9 = v9.getChild$ui();
                                }

                                if(v11 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        v6 = DelegatableNodeKt.access$pop(v8);
                        goto label_40;
                    }

                label_81:
                    v5 = v5.getParent$ui();
                }
            }

            v14 = v14.getParent$ui();
            if(v14 != null) {
                NodeChain v5_1 = v14.getNodes$ui();
                if(v5_1 != null) {
                    v5 = v5_1.getTail$ui();
                    continue;
                }
            }

            v5 = v7;
        }

    label_91:
        return ((FocusProperties)v0);
    }

    public final Rect fetchFocusRect$ui(LayoutCoordinates arg9) {
        Rect v0 = this.fetchFocusProperties$ui().getFocusRect();
        if(v0 != FocusProperties.Companion.getUnsetFocusRect()) {
            if(arg9 == null) {
                return v0;
            }

            return v0.translate-k-4lQ0M(LayoutCoordinates.localPositionOf-S_NoaFU$default(arg9, DelegatableNodeKt.requireLayoutCoordinates(((DelegatableNode)this)), 0, false, 6, null));
        }

        LayoutCoordinates v1 = arg9;
        if(v1 != null) {
            Rect v9 = v1.localBoundingBoxOf(DelegatableNodeKt.requireLayoutCoordinates(this), false);
            if(v9 != null) {
                return v9;
            }
        }

        return RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), IntSizeKt.toSize-ozmzZPI(DelegatableNodeKt.requireLayoutCoordinates(((DelegatableNode)this)).getSize-YbymL2g()));
    }

    public static Rect fetchFocusRect$ui$default(FocusTargetNode arg0, LayoutCoordinates arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        return arg0.fetchFocusRect$ui(arg1);
    }

    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return DelegatableNodeKt.findNearestBeyondBoundsLayoutAncestor(((DelegatableNode)this));
    }

    public FocusStateImpl getFocusState() {
        if(!this.isAttached()) {
            return FocusStateImpl.Inactive;
        }

        FocusOwner v0 = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        FocusTargetNode v1 = v0.getActiveFocusTargetNode();
        if(v1 == null) {
            return FocusStateImpl.Inactive;
        }

        if(this == v1) {
            if(v0.isFocusCaptured()) {
                return FocusStateImpl.Captured;
            }

            return FocusStateImpl.Active;
        }

        if(v1.isAttached()) {
            int v0_1 = NodeKind.constructor-impl(0x400);
            if(!((DelegatableNode)v1).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }

            Node v2 = ((DelegatableNode)v1).getNode().getParent$ui();
            LayoutNode v1_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v1));
            while(v1_1 != null) {
                Node v4 = null;
                if((v1_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v0_1) != 0) {
                    while(v2 != null) {
                        if((v2.getKindSet$ui() & v0_1) != 0) {
                            Node v3 = v2;
                            MutableVector v5 = ((MutableVector)v4);
                            while(true) {
                            label_43:
                                if(v3 != null) {
                                    if((v3 instanceof FocusTargetNode)) {
                                        if(this == (((FocusTargetNode)v3))) {
                                            return FocusStateImpl.ActiveParent;
                                        }
                                    }
                                    else if((v3.getKindSet$ui() & v0_1) != 0 && ((v3 instanceof DelegatingNode))) {
                                        Node v6 = v3.getDelegate$ui();
                                        int v8 = 0;
                                        while(v6 != null) {
                                            if((v6.getKindSet$ui() & v0_1) != 0) {
                                                ++v8;
                                                if(v8 == 1) {
                                                    v3 = v6;
                                                }
                                                else {
                                                    if(v5 == null) {
                                                        v5 = new MutableVector(new Node[16], 0);
                                                    }

                                                    if(v3 != null) {
                                                        if(v5 != null) {
                                                            v5.add(v3);
                                                        }

                                                        v3 = v4;
                                                    }

                                                    if(v5 == null) {
                                                        goto label_78;
                                                    }

                                                    v5.add(v6);
                                                }
                                            }

                                        label_78:
                                            v6 = v6.getChild$ui();
                                        }

                                        if(v8 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                goto label_84;
                            }

                            v3 = DelegatableNodeKt.access$pop(v5);
                            goto label_43;
                        }

                    label_84:
                        v2 = v2.getParent$ui();
                    }
                }

                v1_1 = v1_1.getParent$ui();
                if(v1_1 != null) {
                    NodeChain v2_1 = v1_1.getNodes$ui();
                    if(v2_1 != null) {
                        v2 = v2_1.getTail$ui();
                        continue;
                    }
                }

                v2 = v4;
            }
        }

        return FocusStateImpl.Inactive;
    }

    public FocusState getFocusState() {
        return this.getFocusState();
    }

    public int getFocusability-LCbbffg() {
        return this.focusability;
    }

    public final int getPreviouslyFocusedChildHash() {
        return this.previouslyFocusedChildHash;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public final void invalidateFocus$ui() {
        int v0 = WhenMappings.$EnumSwitchMapping$1[this.getFocusState().ordinal()];
        if(v0 == 1 || v0 == 2) {
            ObjectRef v0_1 = new ObjectRef();
            ObserverModifierNodeKt.observeReads(this, new FocusTargetNode$invalidateFocus$1(v0_1, this));
            if(v0_1.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
                FocusProperties v0_2 = null;
            }
            else {
                Object v0_3 = v0_1.element;
            }

            if(v0_2.getCanFocus()) {
                return;
            }

            DelegatableNodeKt.requireOwner(((DelegatableNode)this)).getFocusOwner().clearFocus(true);
        }
        else if(v0 != 3) {
            if(v0 == 4) {
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final boolean isInteropViewHost() {
        return this.isInteropViewHost;
    }

    public void onDetach() {
        FocusOwner v0_1;
        int v0 = WhenMappings.$EnumSwitchMapping$1[this.getFocusState().ordinal()];
        FocusDirection v1 = null;
        if(v0 == 1 || v0 == 2) {
            v0_1 = DelegatableNodeKt.requireOwner(this).getFocusOwner();
            v0_1.clearFocus-I7lrPNg(true, true, false, FocusDirection.Companion.getExit-dhqQ-8s());
            if(this.isInteropViewHost) {
                v0_1.requestOwnerFocus-7o62pno(v1, ((Rect)v1));
            }

            v0_1.scheduleInvalidationForOwner();
        }
        else if(v0 == 3) {
            v0_1 = DelegatableNodeKt.requireOwner(this).getFocusOwner();
            FocusTargetNode v3 = FocusTraversalKt.findActiveFocusNode(this);
            if(v3 != null && (v3.isInteropViewHost)) {
                v0_1.requestOwnerFocus-7o62pno(v1, ((Rect)v1));
                v0_1.scheduleInvalidationForOwner();
            }
        }
        else if(v0 == 4) {
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

        this.committedFocusState = ((FocusStateImpl)v1);
    }

    public void onObservedReadsChanged() {
        this.invalidateFocus$ui();
    }

    public void onPlaced(LayoutCoordinates arg1) {
        if(ComposeUiFlags.isInitialFocusOnFocusableAvailable) {
            DelegatableNodeKt.requireOwner(this.getNode()).getFocusOwner().focusTargetAvailable();
        }
    }

    public void onReset() {
        if(this.getFocusState().isFocused()) {
            DelegatableNodeKt.requireOwner(((DelegatableNode)this)).getFocusOwner().clearFocus-I7lrPNg(true, true, true, FocusDirection.Companion.getExit-dhqQ-8s());
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the version accepting FocusDirection", replaceWith="<_subannotation>") public boolean requestFocus() {
        return this.requestFocus-3ESFkO8(FocusDirection.Companion.getEnter-dhqQ-8s());
    }

    public boolean requestFocus-3ESFkO8(int arg2) {
        boolean v1_1;
        Trace.beginSection("FocusTransactions:requestFocus");
        try {
            if(!ComposeUiFlags.isRequestFocusOnNonFocusableFocusTargetEnabled) {
                if(this.fetchFocusProperties$ui().getCanFocus()) {
                    if(!this.assignFocus-3ESFkO8(arg2)) {
                        goto label_20;
                    }

                    goto label_18;
                }

                goto label_20;
            }
            else if(this.fetchFocusProperties$ui().getCanFocus()) {
                v1_1 = this.assignFocus-3ESFkO8(arg2);
            }
            else {
                v1_1 = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(this, arg2, new FocusTargetNode$requestFocus$1$1(arg2));
            }

            goto label_21;
        }
        catch(Throwable v1) {
            Trace.endSection();
            throw v1;
        }

    label_18:
        v1_1 = true;
        goto label_21;
    label_20:
        v1_1 = false;
    label_21:
        Trace.endSection();
        return v1_1;
    }

    public void setFocusability-josRg5g(int arg3) {
        if(!Focusability.equals-impl0(this.focusability, arg3)) {
            this.focusability = arg3;
            if(this.isAttached()) {
                FocusTargetNode v3 = this;
                if(this == DelegatableNodeKt.requireOwner(((DelegatableNode)v3)).getFocusOwner().getActiveFocusTargetNode() && !Focusability.canFocus-impl$ui(this.focusability, this)) {
                    if(!ComposeUiFlags.isOptimizedFocusEventDispatchEnabled) {
                        FocusTransactionsKt.clearFocus(this, true, true);
                    }
                    else if(FocusTransactionsKt.clearFocus(this, true, true)) {
                        this = DelegatableNodeKt.requireOwner(((DelegatableNode)v3)).getFocusOwner().getActiveFocusTargetNode();
                        DelegatableNodeKt.requireOwner(((DelegatableNode)v3)).getFocusOwner().setActiveFocusTargetNode(null);
                        if(this != null) {
                            this.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void setPreviouslyFocusedChildHash(int arg1) {
        this.previouslyFocusedChildHash = arg1;
    }
}

