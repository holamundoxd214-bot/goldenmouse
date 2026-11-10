package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f\u0012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0016J\u0017\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0002¢\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001F\u001A\u00020\u000F2\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020\u001AH\u0016¢\u0006\u0004\b%\u0010&J\b\u0010\'\u001A\u00020\u000FH\u0016JQ\u0010(\u001A\u00020\u000F2\b\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\b\u0010\t\u001A\u0004\u0018\u00010\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0002\b)J\u0017\u0010*\u001A\u00020\u00072\u0006\u0010+\u001A\u00020,H\u0004¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001A\u00020\u00072\u0006\u0010+\u001A\u00020,H\u0004¢\u0006\u0004\b0\u0010.R\u0014\u0010\u0012\u001A\u00020\u0007X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u00061"}, d2={"Landroidx/compose/foundation/ClickableNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "isSuspendingPointerInputEnabled", "isSuspendingPointerInputEnabled$annotations", "()V", "createPointerInputNodeIfNeeded", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "getExtendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/unit/IntSize;", "getExtendedTouchPadding-hWWAJMo", "(J)J", "downEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "update", "update-O2vRcR0", "onClickKeyDownEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onClickKeyDownEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public class ClickableNode extends AbstractClickableNode {
    public static final int $stable = 8;
    private PointerInputChange downEvent;
    private final boolean isSuspendingPointerInputEnabled;

    static {
    }

    public ClickableNode(MutableInteractionSource arg1, IndicationNodeFactory arg2, boolean arg3, boolean arg4, String arg5, Role arg6, Function0 arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private ClickableNode(MutableInteractionSource arg10, IndicationNodeFactory arg11, boolean arg12, boolean arg13, String arg14, Role arg15, Function0 arg16) {
        super(arg10, arg11, arg12, arg13, arg14, arg15, arg16, null);
        boolean v10 = !ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled || !ComposeFoundationFlags.isNonSuspendingPointerInputInClickableEnabled ? true : false;
        this.isSuspendingPointerInputEnabled = v10;
    }

    public SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded() {
        if(this.isSuspendingPointerInputEnabled) {
            return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ClickableNode$createPointerInputNodeIfNeeded$1(this));
        }

        return null;
    }

    private final long getExtendedTouchPadding-hWWAJMo(long arg8) {
        long v0 = DelegatableNodeKt.requireDensity(((DelegatableNode)this)).toSize-XkaWNTQ(CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration()).getMinimumTouchTargetSize-MYxV2XQ());
        return Size.constructor-impl((((long)Float.floatToRawIntBits(Math.max(0f, Float.intBitsToFloat(((int)(v0 & 0xFFFFFFFFL))) - (((float)(((int)(arg8 & 0xFFFFFFFFL)))))) / 2f))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Math.max(0f, Float.intBitsToFloat(((int)(v0 >> 0x20))) - (((float)(((int)(arg8 >> 0x20)))))) / 2f))) << 0x20);
    }

    private static void isSuspendingPointerInputEnabled$annotations() {
    }

    public void onCancelPointerInput() {
        super.onCancelPointerInput();
        if(this.downEvent != null) {
            this.downEvent = null;
            this.handlePressInteractionCancel(false);
        }
    }

    protected final boolean onClickKeyDownEvent-ZmokQxo(KeyEvent arg1) {
        return 0;
    }

    protected final boolean onClickKeyUpEvent-ZmokQxo(KeyEvent arg1) {
        this.getOnClick().invoke();
        return 1;
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg8, PointerEventPass arg9, long arg10) {
        int v0_1;
        int v9_1;
        List v8_1;
        super.onPointerEvent-H0pRuoY(arg8, arg9, arg10);
        if(this.isSuspendingPointerInputEnabled) {
        }
        else {
            Object v1 = null;
            if(arg9 == PointerEventPass.Main) {
                PointerInputChange v9 = this.downEvent;
                if(v9 != null) {
                    List v0 = arg8.getChanges();
                    int v3 = v0.size();
                    int v4 = 0;
                    while(true) {
                        if(v4 >= v3) {
                            break;
                        }
                        else if(!PointerEventKt.changedToUp(v0.get(v4))) {
                            long v3_1 = this.getExtendedTouchPadding-hWWAJMo(arg10);
                            v8_1 = arg8.getChanges();
                            v9_1 = v8_1.size();
                            v0_1 = 0;
                            goto label_36;
                        }
                        else {
                            ++v4;
                            continue;
                        }
                    }

                    arg8.getChanges().get(0).consume();
                    if(this.getEnabled()) {
                        this.handlePressInteractionRelease-3MmeM6k(v9.getPosition-F1C5BW0(), false);
                        this.getOnClick().invoke();
                    }

                    this.downEvent = ((PointerInputChange)v1);
                    return;
                    while(true) {
                    label_36:
                        if(v0_1 < v9_1) {
                            Object v5 = v8_1.get(v0_1);
                            if(!((PointerInputChange)v5).isConsumed()) {
                                if(PointerEventKt.isOutOfBounds-jwHxaWs(((PointerInputChange)v5), arg10, v3_1)) {
                                }
                                else {
                                    ++v0_1;
                                    continue;
                                }
                            }

                            break;
                        }

                        return;
                    }

                    this.downEvent = ((PointerInputChange)v1);
                    this.handlePressInteractionCancel(false);
                    return;
                }
                else if(TapGestureDetectorKt.isChangedToDown$default(arg8, true, false, 2, v1)) {
                    Object v8 = arg8.getChanges().get(0);
                    ((PointerInputChange)v8).consume();
                    this.downEvent = ((PointerInputChange)v8);
                    if(this.getEnabled()) {
                        this.handlePressInteractionStart-3MmeM6k(((PointerInputChange)v8).getPosition-F1C5BW0(), false);
                        return;
                    }
                }
            }
            else {
                if(arg9 != PointerEventPass.Final) {
                    return;
                }

                if(this.downEvent == null) {
                    return;
                }

                v8_1 = arg8.getChanges();
                v9_1 = v8_1.size();
                int v10;
                for(v10 = 0; v10 < v9_1; ++v10) {
                    Object v11 = v8_1.get(v10);
                    if((((PointerInputChange)v11).isConsumed()) && !Intrinsics.areEqual(v11, this.downEvent)) {
                        this.downEvent = ((PointerInputChange)v1);
                        this.handlePressInteractionCancel(false);
                        return;
                    }
                }
            }
        }
    }

    public final void update-O2vRcR0(MutableInteractionSource arg1, IndicationNodeFactory arg2, boolean arg3, boolean arg4, String arg5, Role arg6, Function0 arg7) {
        this.updateCommon-O2vRcR0(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
}

