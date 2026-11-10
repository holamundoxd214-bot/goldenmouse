package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Cancel;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\b!\u0018\u0000 x2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002wxBM\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013\u0012\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\b\u00104\u001A\u00020\u000EH\u0002J\n\u00107\u001A\u0004\u0018\u00010$H&J\f\u00108\u001A\u00020\u0016*\u000209H\u0016JS\u0010:\u001A\u00020\u00162\b\u0010\t\u001A\u0004\u0018\u00010\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0004¢\u0006\u0002\b;J\u0018\u0010<\u001A\u00020\u00162\u0006\u0010=\u001A\u00020>2\u0006\u0010?\u001A\u00020@H\u0016J\b\u0010A\u001A\u00020\u0016H\u0016J\u0006\u0010B\u001A\u00020\u0016J\b\u0010C\u001A\u00020\u0016H\u0016J\u0006\u0010D\u001A\u00020\u0016J\b\u0010E\u001A\u00020\u0016H\u0004J\u0010\u0010F\u001A\u00020\u00162\u0006\u0010G\u001A\u00020\u000EH\u0002J\b\u0010H\u001A\u00020\u0016H\u0002J\b\u0010I\u001A\u00020\u0016H\u0002J\'\u0010J\u001A\u00020\u00162\u0006\u0010K\u001A\u00020L2\u0006\u0010?\u001A\u00020@2\u0006\u0010M\u001A\u00020NH\u0016¢\u0006\u0004\bO\u0010PJ\b\u0010Q\u001A\u00020\u0016H\u0016J\u0015\u0010R\u001A\u00020\u000E2\u0006\u0010=\u001A\u00020S¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001A\u00020\u000E2\u0006\u0010=\u001A\u00020SH$¢\u0006\u0004\bW\u0010UJ\u0017\u0010X\u001A\u00020\u000E2\u0006\u0010=\u001A\u00020SH$¢\u0006\u0004\bY\u0010UJ\b\u0010Z\u001A\u00020\u0016H\u0014J\u0015\u0010[\u001A\u00020\u000E2\u0006\u0010=\u001A\u00020S¢\u0006\u0004\b\\\u0010UJ\n\u0010_\u001A\u00020\u0016*\u000209J\u000F\u0010`\u001A\u0004\u0018\u00010\u0016H\u0004¢\u0006\u0002\u0010aJ\u001F\u0010d\u001A\u00020\u00162\u0006\u0010e\u001A\u00020.2\u0006\u0010f\u001A\u00020\u000EH\u0004¢\u0006\u0004\bg\u0010hJ\u001F\u0010i\u001A\u00020\u00162\u0006\u0010e\u001A\u00020.2\u0006\u0010f\u001A\u00020\u000EH\u0004¢\u0006\u0004\bj\u0010hJ\u0010\u0010k\u001A\u00020\u00162\u0006\u0010f\u001A\u00020\u000EH\u0004J\u001C\u0010l\u001A\u00020\u0016*\u00020m2\u0006\u0010e\u001A\u00020.H\u0084@¢\u0006\u0004\bn\u0010oJ\b\u0010p\u001A\u00020\u000EH\u0002J\b\u0010q\u001A\u00020\u0016H\u0002J\b\u0010r\u001A\u00020\u0016H\u0002R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0019\u001A\u00020\u000E@BX\u0084\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR*\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015@BX\u0084\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u000EX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u001BR\u000E\u0010 \u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010#\u001A\u0004\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\'\u001A\u0004\u0018\u00010(X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010)\u001A\u0004\u0018\u00010*X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010+\u001A\b\u0012\u0004\u0012\u00020(0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001A\u00020.X\u0082\u000E¢\u0006\u0004\n\u0002\u0010/R\u0010\u00100\u001A\u0004\u0018\u00010(X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00101\u001A\u0004\u0018\u00010.X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00102\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00103\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00105\u001A\u0004\u0018\u000106X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010]\u001A\u00020\u000E8F¢\u0006\u0006\u001A\u0004\b^\u0010\u001BR\u0010\u0010b\u001A\u0004\u0018\u00010cX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010s\u001A\u00020tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bu\u0010v¨\u0006y"}, d2={"Landroidx/compose/foundation/AbstractClickableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "value", "getEnabled", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "focusableNode", "Landroidx/compose/foundation/FocusableNode;", "localIndicationNodeFactory", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "indicationNode", "Landroidx/compose/ui/node/DelegatableNode;", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "currentKeyPressInteractions", "Landroidx/collection/MutableLongObjectMap;", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "J", "indirectPointerPressInteraction", "indirectPointerEventPressPosition", "userProvidedInteractionSource", "lazilyCreateIndication", "shouldLazilyCreateIndication", "indirectPointerClickDetector", "Landroidx/compose/foundation/AbstractClickableNode$IndirectPointerClickDetector;", "createPointerInputNodeIfNeeded", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "updateCommon", "updateCommon-O2vRcR0", "onIndirectPointerEvent", "event", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "onCancelIndirectPointerInput", "onAttach", "onObservedReadsChanged", "onDetach", "disposeInteractions", "onFocusChange", "isFocused", "recreateIndicationIfNeeded", "initializeIndicationAndInteractionSourceIfNeeded", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onKeyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyDownEvent", "onClickKeyDownEvent-ZmokQxo", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "onCancelKeyInput", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "resetPointerInputHandler", "()Lkotlin/Unit;", "delayJob", "Lkotlinx/coroutines/Job;", "handlePressInteractionStart", "offset", "indirectPointer", "handlePressInteractionStart-3MmeM6k", "(JZ)V", "handlePressInteractionRelease", "handlePressInteractionRelease-3MmeM6k", "handlePressInteractionCancel", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "handlePressInteraction-d-4ec7I", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delayPressInteraction", "emitHoverEnter", "emitHoverExit", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "IndirectPointerClickDetector", "TraverseKey", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class AbstractClickableNode extends DelegatingNode implements IndirectPointerInputModifierNode, KeyInputModifierNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, PointerInputModifierNode, SemanticsModifierNode, TraversableNode {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0011J\u0006\u0010\u0012\u001A\u00020\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/AbstractClickableNode$IndirectPointerClickDetector;", "", "node", "Landroidx/compose/foundation/AbstractClickableNode;", "<init>", "(Landroidx/compose/foundation/AbstractClickableNode;)V", "getNode", "()Landroidx/compose/foundation/AbstractClickableNode;", "downEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "processRawEvent", "", "pointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "onClick", "Lkotlin/Function0;", "resetDetector", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IndirectPointerClickDetector {
        public static final int $stable = 8;
        private IndirectPointerInputChange downEvent;
        private final AbstractClickableNode node;

        static {
        }

        public IndirectPointerClickDetector(AbstractClickableNode arg1) {
            super();
            this.node = arg1;
        }

        public final AbstractClickableNode getNode() {
            return this.node;
        }

        public final void processRawEvent(IndirectPointerEvent arg7, PointerEventPass arg8, Function0 arg9) {
            int v8_2;
            List v7_1;
            int v1 = 0;
            if(arg8 == PointerEventPass.Main) {
                IndirectPointerInputChange v8 = this.downEvent;
                if(v8 == null) {
                    List v8_1 = arg7.getChanges();
                    int v9 = v8_1.size();
                    int v2 = 0;
                    while(true) {
                        if(v2 >= v9) {
                            return;
                        }
                        else if(ClickableKt.access$changedToDownIgnoreConsumed(v8_1.get(v2))) {
                            Object v7 = arg7.getChanges().get(0);
                            this.downEvent = ((IndirectPointerInputChange)v7);
                            this.node.handlePressInteractionStart-3MmeM6k(((IndirectPointerInputChange)v7).getPosition-F1C5BW0(), true);
                            ((IndirectPointerInputChange)v7).consume();
                            return;
                        }
                        else {
                            ++v2;
                            continue;
                        }

                        return;
                    }

                    return;
                }
                else {
                    List v2_1 = arg7.getChanges();
                    int v3 = v2_1.size();
                    int v4 = 0;
                    while(true) {
                        if(v4 >= v3) {
                            break;
                        }
                        else if(!ClickableKt.access$isMovingIgnoreConsumed(v2_1.get(v4))) {
                            ++v4;
                            continue;
                        }
                        else if(Math.abs(Offset.getDistance-impl(Offset.minus-MK-Hz9U(arg7.getChanges().get(0).getPosition-F1C5BW0(), v8.getPosition-F1C5BW0()))) > CompositionLocalConsumerModifierNodeKt.currentValueOf(this.node, CompositionLocalsKt.getLocalViewConfiguration()).getTouchSlop()) {
                            this.resetDetector();
                            return;
                        }

                        return;
                    }

                    v2_1 = arg7.getChanges();
                    v3 = v2_1.size();
                    v4 = 0;
                    while(true) {
                        if(v4 >= v3) {
                            break;
                        }
                        else if(!ClickableKt.access$changedToUp(v2_1.get(v4))) {
                            v7_1 = arg7.getChanges();
                            v8_2 = v7_1.size();
                            goto label_60;
                        }
                        else {
                            ++v4;
                            continue;
                        }
                    }

                    arg7.getChanges().get(0).consume();
                    this.node.handlePressInteractionRelease-3MmeM6k(v8.getPosition-F1C5BW0(), true);
                    arg9.invoke();
                    this.downEvent = null;
                    return;
                    while(true) {
                    label_60:
                        if(v1 >= v8_2) {
                            return;
                        }
                        else if(v7_1.get(v1).isConsumed()) {
                            this.resetDetector();
                            return;
                        }
                        else {
                            ++v1;
                            continue;
                        }

                        return;
                    }

                    return;
                }
            }
            else if(arg8 == PointerEventPass.Final && this.downEvent != null) {
                v7_1 = arg7.getChanges();
                v8_2 = v7_1.size();
                while(v1 < v8_2) {
                    Object v9_1 = v7_1.get(v1);
                    if((((IndirectPointerInputChange)v9_1).isConsumed()) && !Intrinsics.areEqual(v9_1, this.downEvent)) {
                        this.resetDetector();
                        return;
                    }

                    ++v1;
                }
            }
        }

        public final void resetDetector() {
            if(this.downEvent != null) {
                this.downEvent = null;
                this.node.handlePressInteractionCancel(true);
            }
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/foundation/AbstractClickableNode$TraverseKey;", "", "<init>", "()V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TraverseKey {
        public TraverseKey(DefaultConstructorMarker arg1) {
            this();
        }

        private TraverseKey() {
            super();
        }
    }

    public static final int $stable;
    public static final TraverseKey TraverseKey;
    private long centerOffset;
    private final MutableLongObjectMap currentKeyPressInteractions;
    private Job delayJob;
    private boolean enabled;
    private final FocusableNode focusableNode;
    private Enter hoverInteraction;
    private DelegatableNode indicationNode;
    private IndicationNodeFactory indicationNodeFactory;
    private IndirectPointerClickDetector indirectPointerClickDetector;
    private Offset indirectPointerEventPressPosition;
    private Press indirectPointerPressInteraction;
    private MutableInteractionSource interactionSource;
    private boolean lazilyCreateIndication;
    private IndicationNodeFactory localIndicationNodeFactory;
    private Function0 onClick;
    private String onClickLabel;
    private SuspendingPointerInputModifierNode pointerInputNode;
    private Press pressInteraction;
    private Role role;
    private final boolean shouldAutoInvalidate;
    private final Object traverseKey;
    private boolean useLocalIndication;
    private MutableInteractionSource userProvidedInteractionSource;

    public static Unit $r8$lambda$TLuHyIGlRCsgukITQ5Vb9Ul5ad0(MutableInteractionSource arg0, Cancel arg1, Throwable arg2) {
        return AbstractClickableNode.handlePressInteractionCancel$lambda$0$0$0(arg0, arg1, arg2);
    }

    static {
        AbstractClickableNode.TraverseKey = new TraverseKey(null);
        AbstractClickableNode.$stable = 8;
    }

    private AbstractClickableNode(MutableInteractionSource arg1, IndicationNodeFactory arg2, boolean arg3, boolean arg4, String arg5, Role arg6, Function0 arg7) {
        super();
        this.interactionSource = arg1;
        this.indicationNodeFactory = arg2;
        this.useLocalIndication = arg3;
        this.onClickLabel = arg5;
        this.role = arg6;
        this.enabled = arg4;
        this.onClick = arg7;
        this.focusableNode = new FocusableNode(this.interactionSource, Focusability.Companion.getSystemDefined-LCbbffg(), new AbstractClickableNode$focusableNode$1(this), null);
        this.currentKeyPressInteractions = LongObjectMapKt.mutableLongObjectMapOf();
        this.centerOffset = Offset.Companion.getZero-F1C5BW0();
        this.userProvidedInteractionSource = this.interactionSource;
        this.lazilyCreateIndication = this.shouldLazilyCreateIndication();
        this.traverseKey = AbstractClickableNode.TraverseKey;
    }

    public AbstractClickableNode(MutableInteractionSource arg1, IndicationNodeFactory arg2, boolean arg3, boolean arg4, String arg5, Role arg6, Function0 arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static final boolean access$delayPressInteraction(AbstractClickableNode arg0) {
        return arg0.delayPressInteraction();
    }

    public static final void access$emitHoverEnter(AbstractClickableNode arg0) {
        arg0.emitHoverEnter();
    }

    public static final void access$emitHoverExit(AbstractClickableNode arg0) {
        arg0.emitHoverExit();
    }

    public static final MutableInteractionSource access$getInteractionSource$p(AbstractClickableNode arg0) {
        return arg0.interactionSource;
    }

    public static final Press access$getPressInteraction$p(AbstractClickableNode arg0) {
        return arg0.pressInteraction;
    }

    public static final void access$onFocusChange(AbstractClickableNode arg0, boolean arg1) {
        arg0.onFocusChange(arg1);
    }

    public static final void access$setIndirectPointerPressInteraction$p(AbstractClickableNode arg0, Press arg1) {
        arg0.indirectPointerPressInteraction = arg1;
    }

    public static final void access$setPressInteraction$p(AbstractClickableNode arg0, Press arg1) {
        arg0.pressInteraction = arg1;
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver arg1) {
    }

    public final void applySemantics(SemanticsPropertyReceiver arg3) {
        Role v0 = this.role;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            SemanticsPropertiesKt.setRole-kuIjeqM(arg3, v0.unbox-impl());
        }

        SemanticsPropertiesKt.onClick(arg3, this.onClickLabel, new AbstractClickableNode$$ExternalSyntheticLambda2(this));
        if(this.enabled) {
            this.focusableNode.applySemantics(arg3);
        }
        else {
            SemanticsPropertiesKt.disabled(arg3);
        }

        this.applyAdditionalSemantics(arg3);
    }

    static final boolean applySemantics$lambda$0(AbstractClickableNode arg0) {
        arg0.onClick.invoke();
        return 1;
    }

    public abstract SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded();

    private final boolean delayPressInteraction() {
        if(!ClickableKt.hasScrollableContainer(this)) {
            if(Clickable_androidKt.isComposeRootInScrollableContainer(((DelegatableNode)this))) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    protected final void disposeInteractions() {
        MutableInteractionSource v0 = this.interactionSource;
        if(v0 != null) {
            Press v1 = this.pressInteraction;
            if(v1 != null) {
                v0.tryEmit(new Cancel(v1));
            }

            v1 = this.indirectPointerPressInteraction;
            if(v1 != null) {
                v0.tryEmit(new Cancel(v1));
            }

            Enter v1_1 = this.hoverInteraction;
            if(v1_1 != null) {
                v0.tryEmit(new Exit(v1_1));
            }

            MutableLongObjectMap v1_2 = this.currentKeyPressInteractions;
            Object[] v2 = ((LongObjectMap)v1_2).values;
            long[] v1_3 = ((LongObjectMap)v1_2).metadata;
            int v3 = v1_3.length - 2;
            if(v3 < 0) {
                goto label_57;
            }

            int v5;
            for(v5 = 0; true; ++v5) {
                long v6 = v1_3[v5];
                if((~v6 << 7 & v6 & -9187201950435737472L) != -9187201950435737472L) {
                    int v9 = 8;
                    int v8 = 8 - (~(v5 - v3) >>> 0x1F);
                    int v10;
                    for(v10 = 0; v10 < v8; ++v10) {
                        if((0xFF & v6) < 0x80) {
                            v0.tryEmit(new Cancel(v2[(v5 << 3) + v10]));
                        }

                        v6 >>= v9;
                    }

                    if(v8 != v9) {
                        break;
                    }
                }

                if(v5 == v3) {
                    break;
                }
            }
        }

    label_57:
        this.pressInteraction = null;
        this.indirectPointerPressInteraction = null;
        this.indirectPointerEventPressPosition = null;
        this.hoverInteraction = null;
        this.currentKeyPressInteractions.clear();
    }

    private final void emitHoverEnter() {
        if(this.hoverInteraction == null) {
            Enter v0 = new Enter();
            MutableInteractionSource v1 = this.interactionSource;
            if(v1 != null) {
                BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverEnter$1$1(v1, v0, null), 3, null);
            }

            this.hoverInteraction = v0;
        }
    }

    private final void emitHoverExit() {
        Enter v0 = this.hoverInteraction;
        if(v0 != null) {
            Exit v1 = new Exit(v0);
            MutableInteractionSource v0_1 = this.interactionSource;
            Continuation v2 = null;
            if(v0_1 != null) {
                BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverExit$1$1$1(v0_1, v1, v2), 3, null);
            }

            this.hoverInteraction = ((Enter)v2);
        }
    }

    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final Function0 getOnClick() {
        return this.onClick;
    }

    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public final boolean getShouldMergeDescendantSemantics() {
        return 1;
    }

    public Object getTraverseKey() {
        return this.traverseKey;
    }

    protected final Object handlePressInteraction-d-4ec7I(PressGestureScope arg8, long arg9, Continuation arg11) {
        MutableInteractionSource v4 = this.interactionSource;
        if(v4 != null) {
            Object v7 = CoroutineScopeKt.coroutineScope(new AbstractClickableNode$handlePressInteraction$2$1(arg8, arg9, v4, this, null), arg11);
            if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v7;
            }
        }

        return Unit.INSTANCE;
    }

    protected final void handlePressInteractionCancel(boolean arg11) {
        MutableInteractionSource v0 = this.interactionSource;
        if(v0 != null) {
            Job v1 = this.delayJob;
            CancellationException v2 = null;
            if(v1 == null || !v1.isActive()) {
                Press v1_1 = arg11 ? this.indirectPointerPressInteraction : this.pressInteraction;
                if(v1_1 == null) {
                    goto label_38;
                }

                Cancel v3 = new Cancel(v1_1);
                Element v1_2 = this.getCoroutineScope().getCoroutineContext().get(Job.Key);
                DisposableHandle v1_3 = v1_2 != null ? ((Job)v1_2).invokeOnCompletion(new AbstractClickableNode$$ExternalSyntheticLambda1(v0, v3)) : ((DisposableHandle)v2);
                BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionCancel$1$1$1(v0, v3, v1_3, ((Continuation)v2)), 3, null);
            }
            else {
                Job v0_1 = this.delayJob;
                if(v0_1 != null) {
                    DefaultImpls.cancel$default(v0_1, v2, 1, v2);
                }
            }

        label_38:
            if(arg11) {
                this.indirectPointerPressInteraction = ((Press)v2);
                return;
            }

            this.pressInteraction = ((Press)v2);
        }
    }

    private static final Unit handlePressInteractionCancel$lambda$0$0$0(MutableInteractionSource arg0, Cancel arg1, Throwable arg2) {
        arg0.tryEmit(((Interaction)arg1));
        return Unit.INSTANCE;
    }

    protected final void handlePressInteractionRelease-3MmeM6k(long arg14, boolean arg16) {
        MutableInteractionSource v4 = this.interactionSource;
        if(v4 != null) {
            Job v1 = this.delayJob;
            CancellationException v6 = null;
            if(v1 == null || !v1.isActive()) {
                Press v14 = arg16 ? this.indirectPointerPressInteraction : this.pressInteraction;
                if(v14 == null) {
                    goto label_35;
                }

                BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$2$1(v14, v4, ((Continuation)v6)), 3, null);
            }
            else {
                DefaultImpls.cancel$default(v1, v6, 1, v6);
                BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$1(v1, arg14, v4, null), 3, null);
            }

        label_35:
            if(arg16) {
                this.indirectPointerPressInteraction = ((Press)v6);
                return;
            }

            this.pressInteraction = ((Press)v6);
        }
    }

    protected final void handlePressInteractionStart-3MmeM6k(long arg10, boolean arg12) {
        MutableInteractionSource v1 = this.interactionSource;
        if(v1 != null) {
            DefaultConstructorMarker v0 = null;
            Press v2 = new Press(arg10, v0);
            if(this.delayPressInteraction()) {
                this.delayJob = BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$1(v1, v2, arg12, this, null), 3, null);
                return;
            }
            else {
                if(arg12) {
                    this.indirectPointerPressInteraction = v2;
                }
                else {
                    this.pressInteraction = v2;
                }

                BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$2(v1, v2, ((Continuation)v0)), 3, null);
            }
        }
    }

    private final void initializeIndicationAndInteractionSourceIfNeeded() {
        if(this.indicationNode != null) {
        }
        else {
            IndicationNodeFactory v0 = this.useLocalIndication ? this.localIndicationNodeFactory : this.indicationNodeFactory;
            if(v0 == null) {
                return;
            }

            MutableInteractionSource v1 = this.interactionSource;
            if(v1 == null) {
                v1 = InteractionSourceKt.MutableInteractionSource();
                this.interactionSource = v1;
            }

            this.focusableNode.update(v1);
            v1 = this.interactionSource;
            Intrinsics.checkNotNull(v1);
            DelegatableNode v0_1 = v0.create(((InteractionSource)v1));
            this.delegate(v0_1);
            this.indicationNode = v0_1;
        }
    }

    public final void onAttach() {
        this.onObservedReadsChanged();
        if(!this.lazilyCreateIndication) {
            this.initializeIndicationAndInteractionSourceIfNeeded();
        }

        if(this.enabled) {
            this.delegate(this.focusableNode);
        }
    }

    public void onCancelIndirectPointerInput() {
        IndirectPointerClickDetector v0 = this.indirectPointerClickDetector;
        if(v0 != null) {
            v0.resetDetector();
        }
    }

    protected void onCancelKeyInput() {
    }

    public void onCancelPointerInput() {
        MutableInteractionSource v0 = this.interactionSource;
        if(v0 != null) {
            Enter v1 = this.hoverInteraction;
            if(v1 != null) {
                v0.tryEmit(new Exit(v1));
            }
        }

        this.hoverInteraction = null;
        SuspendingPointerInputModifierNode v3 = this.pointerInputNode;
        if(v3 != null) {
            v3.onCancelPointerInput();
        }
    }

    protected abstract boolean onClickKeyDownEvent-ZmokQxo(KeyEvent arg1);

    protected abstract boolean onClickKeyUpEvent-ZmokQxo(KeyEvent arg1);

    public final void onDetach() {
        this.disposeInteractions();
        MutableInteractionSource v1 = null;
        if(this.userProvidedInteractionSource == null) {
            this.interactionSource = v1;
        }

        DelegatableNode v0 = this.indicationNode;
        if(v0 != null) {
            this.undelegate(v0);
        }

        this.indicationNode = ((DelegatableNode)v1);
    }

    private final void onFocusChange(boolean arg20) {
        AbstractClickableNode v0 = this;
        if(arg20) {
            v0.initializeIndicationAndInteractionSourceIfNeeded();
            return;
        }

        Continuation v2 = null;
        if(v0.interactionSource != null) {
            MutableLongObjectMap v1 = v0.currentKeyPressInteractions;
            Object[] v3 = ((LongObjectMap)v1).values;
            long[] v1_1 = ((LongObjectMap)v1).metadata;
            int v4 = v1_1.length - 2;
            if(v4 >= 0) {
                int v6;
                for(v6 = 0; true; ++v6) {
                    long v7 = v1_1[v6];
                    if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                        int v10 = 8;
                        int v9 = 8 - (~(v6 - v4) >>> 0x1F);
                        int v11;
                        for(v11 = 0; v11 < v9; ++v11) {
                            if((0xFF & v7) < 0x80) {
                                BuildersKt.launch$default(v0.getCoroutineScope(), null, null, new AbstractClickableNode$onFocusChange$1$1(v0, v3[(v6 << 3) + v11], v2), 3, null);
                            }

                            v7 >>= v10;
                        }

                        if(v9 != v10) {
                            break;
                        }
                    }

                    if(v6 == v4) {
                        break;
                    }
                }
            }

            Press v1_2 = v0.indirectPointerPressInteraction;
            if(v1_2 == null) {
                goto label_64;
            }

            BuildersKt.launch$default(v0.getCoroutineScope(), null, null, new AbstractClickableNode$onFocusChange$2$1(v0, v1_2, v2), 3, null);
        }

    label_64:
        v0.currentKeyPressInteractions.clear();
        v0.indirectPointerPressInteraction = ((Press)v2);
        v0.onCancelKeyInput();
    }

    public void onIndirectPointerEvent(IndirectPointerEvent arg2, PointerEventPass arg3) {
        this.initializeIndicationAndInteractionSourceIfNeeded();
        if(this.enabled) {
            IndirectPointerClickDetector v0 = this.indirectPointerClickDetector;
            if(v0 == null) {
                v0 = new IndirectPointerClickDetector(this);
                this.indirectPointerClickDetector = v0;
            }

            if(v0 == null) {
                return;
            }

            v0.processRawEvent(arg2, arg3, this.onClick);
        }
    }

    public final boolean onKeyEvent-ZmokQxo(KeyEvent arg13) {
        int v0_1;
        this.initializeIndicationAndInteractionSourceIfNeeded();
        long v0 = KeyEvent_androidKt.getKey-ZmokQxo(arg13);
        DefaultConstructorMarker v4 = null;
        if((this.enabled) && (ClickableKt.access$isPress-ZmokQxo(arg13))) {
            if(!this.currentKeyPressInteractions.containsKey(v0)) {
                Press v2 = new Press(this.centerOffset, v4);
                this.currentKeyPressInteractions.set(v0, v2);
                if(this.interactionSource != null) {
                    BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, v2, ((Continuation)v4)), 3, null);
                }

                v0_1 = 1;
            }
            else {
                v0_1 = 0;
            }

            if(!this.onClickKeyDownEvent-ZmokQxo(arg13)) {
                if(v0_1 != 0) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        if((this.enabled) && (ClickableKt.access$isClick-ZmokQxo(arg13))) {
            Object v0_2 = this.currentKeyPressInteractions.remove(v0);
            if(v0_2 != null) {
                if(this.interactionSource != null) {
                    BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$2(this, ((Press)v0_2), ((Continuation)v4)), 3, null);
                }

                this.onClickKeyUpEvent-ZmokQxo(arg13);
            }

            if(v0_2 == null) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public void onObservedReadsChanged() {
        if(this.useLocalIndication) {
            ObserverModifierNodeKt.observeReads(this, new AbstractClickableNode$$ExternalSyntheticLambda0(this));
        }
    }

    static final Unit onObservedReadsChanged$lambda$0(AbstractClickableNode arg2) {
        Object v0 = CompositionLocalConsumerModifierNodeKt.currentValueOf(arg2, IndicationKt.getLocalIndication());
        if(!(v0 instanceof IndicationNodeFactory)) {
            InlineClassHelperKt.throwIllegalArgumentException(ClickableKt.access$unsupportedIndicationExceptionMessage(((Indication)v0)));
        }

        IndicationNodeFactory v1 = arg2.localIndicationNodeFactory;
        arg2.localIndicationNodeFactory = ((IndicationNodeFactory)v0);
        if(v1 != null && !Intrinsics.areEqual(v0, v1)) {
            arg2.recreateIndicationIfNeeded();
        }

        return Unit.INSTANCE;
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg10, PointerEventPass arg11, long arg12) {
        long v0 = IntSizeKt.getCenter-ozmzZPI(arg12);
        this.centerOffset = Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)IntOffset.getX-impl(v0))))) << 0x20 | (((long)Float.floatToRawIntBits(((float)IntOffset.getY-impl(v0))))) & 0xFFFFFFFFL);
        this.initializeIndicationAndInteractionSourceIfNeeded();
        if((this.enabled) && arg11 == PointerEventPass.Main) {
            int v0_1 = arg10.getType-7fucELk();
            Continuation v2 = null;
            if(PointerEventType.equals-impl0(v0_1, PointerEventType.Companion.getEnter-7fucELk())) {
                BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$1(this, v2), 3, null);
            }
            else if(PointerEventType.equals-impl0(v0_1, PointerEventType.Companion.getExit-7fucELk())) {
                BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$2(this, v2), 3, null);
            }
        }

        if(this.pointerInputNode == null) {
            SuspendingPointerInputModifierNode v0_2 = this.createPointerInputNodeIfNeeded();
            if(v0_2 != null) {
                this.pointerInputNode = this.delegate(((DelegatableNode)v0_2));
            }
        }

        SuspendingPointerInputModifierNode v9 = this.pointerInputNode;
        if(v9 != null) {
            v9.onPointerEvent-H0pRuoY(arg10, arg11, arg12);
        }
    }

    public final boolean onPreKeyEvent-ZmokQxo(KeyEvent arg1) {
        return 0;
    }

    private final void recreateIndicationIfNeeded() {
        DelegatableNode v0 = this.indicationNode;
        if(v0 == null) {
            if(!this.lazilyCreateIndication) {
            }
            else {
                return;
            }
        }

        if(v0 != null) {
            this.undelegate(v0);
        }

        this.indicationNode = null;
        this.initializeIndicationAndInteractionSourceIfNeeded();
    }

    protected final Unit resetPointerInputHandler() {
        SuspendingPointerInputModifierNode v0 = this.pointerInputNode;
        if(v0 != null) {
            v0.resetPointerInputHandler();
            return Unit.INSTANCE;
        }

        return null;
    }

    private final boolean shouldLazilyCreateIndication() {
        if(this.userProvidedInteractionSource == null) {
            return 1;
        }

        return 0;
    }

    protected final void updateCommon-O2vRcR0(MutableInteractionSource arg3, IndicationNodeFactory arg4, boolean arg5, boolean arg6, String arg7, Role arg8, Function0 arg9) {
        int v3;
        int v1 = 1;
        if(!Intrinsics.areEqual(this.userProvidedInteractionSource, arg3)) {
            this.disposeInteractions();
            this.userProvidedInteractionSource = arg3;
            this.interactionSource = arg3;
            v3 = 1;
        }
        else {
            v3 = 0;
        }

        if(!Intrinsics.areEqual(this.indicationNodeFactory, arg4)) {
            this.indicationNodeFactory = arg4;
            v3 = 1;
        }

        if(this.useLocalIndication != arg5) {
            this.useLocalIndication = arg5;
            if(arg5) {
                this.onObservedReadsChanged();
            }

            v3 = 1;
        }

        if(this.enabled != arg6) {
            FocusableNode v4 = this.focusableNode;
            if(arg6) {
                this.delegate(((DelegatableNode)v4));
            }
            else {
                this.undelegate(((DelegatableNode)v4));
                this.disposeInteractions();
            }

            SemanticsModifierNodeKt.invalidateSemantics(this);
            this.enabled = arg6;
        }

        if(!Intrinsics.areEqual(this.onClickLabel, arg7)) {
            this.onClickLabel = arg7;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }

        if(!Intrinsics.areEqual(this.role, arg8)) {
            this.role = arg8;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }

        this.onClick = arg9;
        if(this.lazilyCreateIndication != this.shouldLazilyCreateIndication()) {
            boolean v4_1 = this.shouldLazilyCreateIndication();
            this.lazilyCreateIndication = v4_1;
            if(v4_1) {
                goto label_54;
            }
            else if(this.indicationNode == null) {
            }
            else {
                goto label_54;
            }
        }
        else {
        label_54:
            v1 = v3;
        }

        if(v1 != 0) {
            this.recreateIndicationIfNeeded();
        }

        this.focusableNode.update(this.interactionSource);
    }
}

