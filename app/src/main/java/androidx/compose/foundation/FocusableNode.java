package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.PinnableContainer$PinnedHandle;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001<B3\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f¢\u0006\u0004\b\u000F\u0010\u0010J\u0006\u0010 \u001A\u00020\rJ\u0010\u0010%\u001A\u00020\u000E2\b\u0010\u0007\u001A\u0004\u0018\u00010\bJ\u0018\u0010*\u001A\u00020\u000E2\u0006\u0010+\u001A\u00020\'2\u0006\u0010,\u001A\u00020\'H\u0002J\f\u0010-\u001A\u00020\u000E*\u00020.H\u0016J\b\u0010/\u001A\u00020\u000EH\u0016J\b\u00100\u001A\u00020\u000EH\u0016J\u0010\u00101\u001A\u00020\u000E2\u0006\u00102\u001A\u00020\u001DH\u0016J\n\u00103\u001A\u0004\u0018\u000104H\u0002J\b\u00105\u001A\u00020\u000EH\u0002J\u0010\u00106\u001A\u00020\u000E2\u0006\u00107\u001A\u00020\rH\u0002J\b\u00108\u001A\u00020\u000EH\u0002J\u0014\u00109\u001A\u00020\u000E*\u00020\b2\u0006\u0010:\u001A\u00020;H\u0002R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\u00020\rX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001A\u001A\u0004\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001A\u0004\u0018\u00010\"8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b#\u0010$R\u0011\u0010&\u001A\u00020\'8F¢\u0006\u0006\u001A\u0004\b(\u0010)¨\u0006="}, d2={"Landroidx/compose/foundation/FocusableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "focusability", "Landroidx/compose/ui/focus/Focusability;", "onFocusChange", "Lkotlin/Function1;", "", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "focusedInteraction", "Landroidx/compose/foundation/interaction/FocusInteraction$Focus;", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "globalLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusTargetNode", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "requestFocus", "focusedBoundsObserver", "Landroidx/compose/foundation/FocusedBoundsObserverNode;", "getFocusedBoundsObserver", "()Landroidx/compose/foundation/FocusedBoundsObserverNode;", "update", "focusState", "Landroidx/compose/ui/focus/FocusState;", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "onFocusStateChange", "previousState", "currentState", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "onReset", "onObservedReadsChanged", "onGloballyPositioned", "coordinates", "retrievePinnableContainer", "Landroidx/compose/ui/layout/PinnableContainer;", "notifyObserverWhenAttached", "emitInteraction", "isFocused", "disposeInteractionSource", "emitWithFallback", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "TraverseKey", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusableNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, ObserverModifierNode, SemanticsModifierNode, TraversableNode {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/foundation/FocusableNode$TraverseKey;", "", "<init>", "()V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TraverseKey {
        public TraverseKey(DefaultConstructorMarker arg1) {
            this();
        }

        private TraverseKey() {
            super();
        }
    }

    public static final int $stable;
    private static final TraverseKey TraverseKey;
    private final FocusTargetModifierNode focusTargetNode;
    private Focus focusedInteraction;
    private LayoutCoordinates globalLayoutCoordinates;
    private MutableInteractionSource interactionSource;
    private final Function1 onFocusChange;
    private PinnedHandle pinnedHandle;
    private final boolean shouldAutoInvalidate;

    static {
        FocusableNode.TraverseKey = new TraverseKey(null);
        FocusableNode.$stable = 8;
    }

    public FocusableNode(MutableInteractionSource arg1, int arg2, Function1 arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public FocusableNode(MutableInteractionSource arg1, int arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = Focusability.Companion.getAlways-LCbbffg();
        }

        arg5 = null;
        if((arg4 & 4) != 0) {
            arg3 = ((Function1)arg5);
        }

        this(arg1, arg2, arg3, arg5);
    }

    private FocusableNode(MutableInteractionSource arg1, int arg2, Function1 arg3) {
        super();
        this.interactionSource = arg1;
        this.onFocusChange = arg3;
        this.focusTargetNode = this.delegate(FocusTargetModifierNodeKt.FocusTargetModifierNode-PYyLHbc(arg2, new FocusableNode$focusTargetNode$1(this)));
    }

    public static final void access$onFocusStateChange(FocusableNode arg0, FocusState arg1, FocusState arg2) {
        arg0.onFocusStateChange(arg1, arg2);
    }

    public void applySemantics(SemanticsPropertyReceiver arg3) {
        SemanticsPropertiesKt.setFocused(arg3, this.focusTargetNode.getFocusState().isFocused());
        SemanticsPropertiesKt.requestFocus$default(arg3, null, new FocusableNode$applySemantics$1(this), 1, null);
    }

    private final void disposeInteractionSource() {
        MutableInteractionSource v0 = this.interactionSource;
        if(v0 != null) {
            Focus v1 = this.focusedInteraction;
            if(v1 != null) {
                v0.tryEmit(new Unfocus(v1));
            }
        }

        this.focusedInteraction = null;
    }

    private final void emitInteraction(boolean arg4) {
        MutableInteractionSource v0 = this.interactionSource;
        if(v0 != null) {
            Focus v1 = this.focusedInteraction;
            Focus v2 = null;
            if(arg4) {
                if(v1 != null) {
                    this.emitWithFallback(v0, new Unfocus(v1));
                    this.focusedInteraction = v2;
                }

                Focus v4 = new Focus();
                this.emitWithFallback(v0, v4);
                this.focusedInteraction = v4;
                return;
            }
            else {
                if(v1 == null) {
                    return;
                }

                this.emitWithFallback(v0, new Unfocus(v1));
                this.focusedInteraction = v2;
            }
        }
    }

    private final void emitWithFallback(MutableInteractionSource arg9, Interaction arg10) {
        if(this.isAttached()) {
            Element v0 = this.getCoroutineScope().getCoroutineContext().get(Job.Key);
            Continuation v1 = null;
            DisposableHandle v0_1 = v0 != null ? ((Job)v0).invokeOnCompletion(new FocusableNode$$ExternalSyntheticLambda0(arg9, arg10)) : ((DisposableHandle)v1);
            BuildersKt.launch$default(this.getCoroutineScope(), null, null, new FocusableNode$emitWithFallback$1(arg9, arg10, v0_1, v1), 3, null);
            return;
        }

        Boolean.valueOf(arg9.tryEmit(arg10));
    }

    static final Unit emitWithFallback$lambda$0(MutableInteractionSource arg0, Interaction arg1, Throwable arg2) {
        arg0.tryEmit(arg1);
        return Unit.INSTANCE;
    }

    public final FocusState getFocusState() {
        return this.focusTargetNode.getFocusState();
    }

    private final FocusedBoundsObserverNode getFocusedBoundsObserver() {
        FocusedBoundsObserverNode v1 = null;
        if(this.isAttached()) {
            TraversableNode v2 = TraversableNodeKt.findNearestAncestor(((DelegatableNode)this), FocusedBoundsObserverNode.TraverseKey);
            if((v2 instanceof FocusedBoundsObserverNode)) {
                return ((FocusedBoundsObserverNode)v2);
            }
        }

        return v1;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public Object getTraverseKey() {
        return FocusableNode.TraverseKey;
    }

    private final void notifyObserverWhenAttached() {
        LayoutCoordinates v0 = this.globalLayoutCoordinates;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            if(v0.isAttached()) {
                FocusedBoundsObserverNode v0_1 = this.getFocusedBoundsObserver();
                if(v0_1 != null) {
                    v0_1.onFocusBoundsChanged(this.globalLayoutCoordinates);
                }
            }
        }
    }

    private final void onFocusStateChange(FocusState arg7, FocusState arg8) {
        boolean v8;
        if(!this.isAttached()) {
        }
        else {
            v8 = arg8.isFocused();
            if(v8 == arg7.isFocused()) {
                return;
            }

            goto label_7;
        }

        return;
    label_7:
        Function1 v7 = this.onFocusChange;
        if(v7 != null) {
            v7.invoke(Boolean.valueOf(v8));
        }

        Continuation v7_1 = null;
        if(v8) {
            BuildersKt.launch$default(this.getCoroutineScope(), null, null, new FocusableNode$onFocusStateChange$1(this, v7_1), 3, null);
            PinnableContainer v0 = this.retrievePinnableContainer();
            if(v0 != null) {
                PinnedHandle v7_2 = v0.pin();
            }

            this.pinnedHandle = ((PinnedHandle)v7_1);
            this.notifyObserverWhenAttached();
        }
        else {
            PinnedHandle v0_1 = this.pinnedHandle;
            if(v0_1 != null) {
                v0_1.release();
            }

            this.pinnedHandle = ((PinnedHandle)v7_1);
            FocusedBoundsObserverNode v0_2 = this.getFocusedBoundsObserver();
            if(v0_2 == null) {
                goto label_35;
            }

            v0_2.onFocusBoundsChanged(((LayoutCoordinates)v7_1));
        }

    label_35:
        SemanticsModifierNodeKt.invalidateSemantics(this);
        this.emitInteraction(v8);
    }

    public void onGloballyPositioned(LayoutCoordinates arg2) {
        this.globalLayoutCoordinates = arg2;
        if(!this.focusTargetNode.getFocusState().isFocused()) {
        }
        else if(arg2.isAttached()) {
            this.notifyObserverWhenAttached();
            return;
        }
        else {
            FocusedBoundsObserverNode v1 = this.getFocusedBoundsObserver();
            if(v1 != null) {
                v1.onFocusBoundsChanged(null);
            }
        }
    }

    public void onObservedReadsChanged() {
        PinnableContainer v0 = this.retrievePinnableContainer();
        if(this.focusTargetNode.getFocusState().isFocused()) {
            PinnedHandle v1 = this.pinnedHandle;
            if(v1 != null) {
                v1.release();
            }

            PinnedHandle v0_1 = v0 != null ? v0.pin() : null;
            this.pinnedHandle = v0_1;
        }
    }

    public void onReset() {
        PinnedHandle v0 = this.pinnedHandle;
        if(v0 != null) {
            v0.release();
        }

        this.pinnedHandle = null;
    }

    public final boolean requestFocus() {
        return FocusTargetModifierNode.requestFocus-3ESFkO8$default(this.focusTargetNode, 0, 1, null);
    }

    private final PinnableContainer retrievePinnableContainer() {
        ObjectRef v0 = new ObjectRef();
        ObserverModifierNodeKt.observeReads(this, new FocusableNode$$ExternalSyntheticLambda1(v0, this));
        return v0.element;
    }

    static final Unit retrievePinnableContainer$lambda$0(ObjectRef arg1, FocusableNode arg2) {
        arg1.element = CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)arg2), PinnableContainerKt.getLocalPinnableContainer());
        return Unit.INSTANCE;
    }

    public final void update(MutableInteractionSource arg2) {
        if(!Intrinsics.areEqual(this.interactionSource, arg2)) {
            this.disposeInteractionSource();
            this.interactionSource = arg2;
        }
    }
}

