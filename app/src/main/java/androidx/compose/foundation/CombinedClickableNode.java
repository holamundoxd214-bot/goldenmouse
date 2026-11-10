package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u00010B\u007F\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u000B\u0012\u0006\u0010\u0011\u001A\u00020\u000B\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010 \u001A\u00020!H\u0016J{\u0010\"\u001A\u00020\u00052\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u000B2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00072\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014¢\u0006\u0002\b#J\f\u0010$\u001A\u00020\u0005*\u00020%H\u0016J\u0017\u0010&\u001A\u00020\u000B2\u0006\u0010\'\u001A\u00020(H\u0014¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001A\u00020\u000B2\u0006\u0010\'\u001A\u00020(H\u0014¢\u0006\u0004\b,\u0010*J\b\u0010-\u001A\u00020\u0005H\u0014J\b\u0010.\u001A\u00020\u0005H\u0016J\b\u0010/\u001A\u00020\u0005H\u0002R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u001F0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2={"Landroidx/compose/foundation/CombinedClickableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "hapticFeedbackEnabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "enabled", "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHapticFeedbackEnabled", "()Z", "setHapticFeedbackEnabled", "(Z)V", "longKeyPressJobs", "Landroidx/collection/MutableLongObjectMap;", "Lkotlinx/coroutines/Job;", "doubleKeyClickStates", "Landroidx/compose/foundation/CombinedClickableNode$DoubleKeyClickState;", "createPointerInputNodeIfNeeded", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "update", "update-2tQrsxU", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "onClickKeyDownEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onClickKeyDownEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "onCancelKeyInput", "onReset", "resetKeyPressState", "DoubleKeyClickState", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class CombinedClickableNode extends AbstractClickableNode implements CompositionLocalConsumerModifierNode {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/CombinedClickableNode$DoubleKeyClickState;", "", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", "doubleTapMinTimeMillisElapsed", "", "getDoubleTapMinTimeMillisElapsed", "()Z", "setDoubleTapMinTimeMillisElapsed", "(Z)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DoubleKeyClickState {
        public static final int $stable = 8;
        private boolean doubleTapMinTimeMillisElapsed;
        private final Job job;

        static {
        }

        public DoubleKeyClickState(Job arg1) {
            super();
            this.job = arg1;
        }

        public final boolean getDoubleTapMinTimeMillisElapsed() {
            return this.doubleTapMinTimeMillisElapsed;
        }

        public final Job getJob() {
            return this.job;
        }

        public final void setDoubleTapMinTimeMillisElapsed(boolean arg1) {
            this.doubleTapMinTimeMillisElapsed = arg1;
        }
    }

    private final MutableLongObjectMap doubleKeyClickStates;
    private boolean hapticFeedbackEnabled;
    private final MutableLongObjectMap longKeyPressJobs;
    private Function0 onDoubleClick;
    private Function0 onLongClick;
    private String onLongClickLabel;

    public CombinedClickableNode(Function0 arg1, String arg2, Function0 arg3, Function0 arg4, boolean arg5, MutableInteractionSource arg6, IndicationNodeFactory arg7, boolean arg8, boolean arg9, String arg10, Role arg11, DefaultConstructorMarker arg12) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    private CombinedClickableNode(Function0 arg10, String arg11, Function0 arg12, Function0 arg13, boolean arg14, MutableInteractionSource arg15, IndicationNodeFactory arg16, boolean arg17, boolean arg18, String arg19, Role arg20) {
        super(arg15, arg16, arg17, arg18, arg19, arg20, arg10, null);
        this.onLongClickLabel = arg11;
        this.onLongClick = arg12;
        this.onDoubleClick = arg13;
        this.hapticFeedbackEnabled = arg14;
        this.longKeyPressJobs = LongObjectMapKt.mutableLongObjectMapOf();
        this.doubleKeyClickStates = LongObjectMapKt.mutableLongObjectMapOf();
    }

    public static final MutableLongObjectMap access$getDoubleKeyClickStates$p(CombinedClickableNode arg0) {
        return arg0.doubleKeyClickStates;
    }

    public static final Function0 access$getOnDoubleClick$p(CombinedClickableNode arg0) {
        return arg0.onDoubleClick;
    }

    public static final Function0 access$getOnLongClick$p(CombinedClickableNode arg0) {
        return arg0.onLongClick;
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver arg3) {
        if(this.onLongClick != null) {
            SemanticsPropertiesKt.onLongClick(arg3, this.onLongClickLabel, new CombinedClickableNode$$ExternalSyntheticLambda0(this));
        }
    }

    static final boolean applyAdditionalSemantics$lambda$0(CombinedClickableNode arg0) {
        Function0 v0 = arg0.onLongClick;
        if(v0 != null) {
            v0.invoke();
        }

        return 1;
    }

    public SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded() {
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new CombinedClickableNode$createPointerInputNodeIfNeeded$1(this));
    }

    public final boolean getHapticFeedbackEnabled() {
        return this.hapticFeedbackEnabled;
    }

    protected void onCancelKeyInput() {
        this.resetKeyPressState();
    }

    protected boolean onClickKeyDownEvent-ZmokQxo(KeyEvent arg11) {
        boolean v11;
        long v0 = KeyEvent_androidKt.getKey-ZmokQxo(arg11);
        Continuation v3 = null;
        if(this.onLongClick == null || this.longKeyPressJobs.get(v0) != null) {
            v11 = false;
        }
        else {
            this.longKeyPressJobs.set(v0, BuildersKt.launch$default(this.getCoroutineScope(), null, null, new CombinedClickableNode$onClickKeyDownEvent$1(this, v3), 3, null));
            v11 = true;
        }

        Object v4 = this.doubleKeyClickStates.get(v0);
        if(v4 != null) {
            if(((DoubleKeyClickState)v4).getJob().isActive()) {
                DefaultImpls.cancel$default(((DoubleKeyClickState)v4).getJob(), ((CancellationException)v3), 1, v3);
                if(!((DoubleKeyClickState)v4).getDoubleTapMinTimeMillisElapsed()) {
                    this.getOnClick().invoke();
                    this.doubleKeyClickStates.remove(v0);
                    return v11;
                }
            }
            else {
                this.doubleKeyClickStates.remove(v0);
            }
        }

        return v11;
    }

    protected boolean onClickKeyUpEvent-ZmokQxo(KeyEvent arg12) {
        long v0 = KeyEvent_androidKt.getKey-ZmokQxo(arg12);
        CancellationException v2 = null;
        int v4 = 0;
        if(this.longKeyPressJobs.get(v0) != null) {
            Object v12 = this.longKeyPressJobs.get(v0);
            if(v12 != null) {
                if(((Job)v12).isActive()) {
                    DefaultImpls.cancel$default(((Job)v12), v2, 1, v2);
                }
                else {
                    v4 = 1;
                }
            }

            this.longKeyPressJobs.remove(v0);
        }

        if(this.onDoubleClick == null) {
            if(v4 != 0) {
                return 1;
            }

            this.getOnClick().invoke();
        }
        else if(this.doubleKeyClickStates.get(v0) != null) {
            if(v4 == 0) {
                Function0 v12_1 = this.onDoubleClick;
                if(v12_1 != null) {
                    v12_1.invoke();
                }
            }

            this.doubleKeyClickStates.remove(v0);
        }
        else if(v4 == 0) {
            this.doubleKeyClickStates.set(v0, new DoubleKeyClickState(BuildersKt.launch$default(this.getCoroutineScope(), null, null, new CombinedClickableNode$onClickKeyUpEvent$2(this, v0, ((Continuation)v2)), 3, null)));
        }

        return 1;
    }

    public void onReset() {
        super.onReset();
        this.resetKeyPressState();
    }

    private final void resetKeyPressState() {
        long v20;
        long v18;
        long v16;
        CombinedClickableNode v0 = this;
        MutableLongObjectMap v1 = v0.longKeyPressJobs;
        Object[] v3 = v1.values;
        long[] v2 = v1.metadata;
        int v4 = v2.length - 2;
        int v9 = 7;
        CancellationException v10 = null;
        int v14 = 8;
        if(v4 >= 0) {
            int v5 = 0;
            v16 = 0x80;
            v18 = 0xFF;
            while(true) {
                long v7 = v2[v5];
                v20 = -9187201950435737472L;
                if((~v7 << v9 & v7 & v20) != v20) {
                    int v6 = 8 - (~(v5 - v4) >>> 0x1F);
                    int v11;
                    for(v11 = 0; v11 < v6; ++v11) {
                        if((v7 & v18) < v16) {
                            DefaultImpls.cancel$default(v3[(v5 << 3) + v11], v10, 1, v10);
                        }

                        v7 >>= v14;
                    }

                    if(v6 != v14) {
                        break;
                    }
                }

                if(v5 == v4) {
                    break;
                }

                ++v5;
            }
        }
        else {
            v16 = 0x80;
            v18 = 0xFF;
            v20 = -9187201950435737472L;
        }

        v1.clear();
        MutableLongObjectMap v0_1 = v0.doubleKeyClickStates;
        Object[] v2_1 = v0_1.values;
        long[] v1_1 = v0_1.metadata;
        int v3_1 = v1_1.length - 2;
        if(v3_1 >= 0) {
            for(v4 = 0; true; ++v4) {
                long v5_1 = v1_1[v4];
                if((~v5_1 << v9 & v5_1 & v20) != v20) {
                    int v7_1 = 8 - (~(v4 - v3_1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v7_1; ++v8) {
                        if((v5_1 & v18) < v16) {
                            DefaultImpls.cancel$default(v2_1[(v4 << 3) + v8].getJob(), v10, 1, v10);
                        }

                        v5_1 >>= v14;
                    }

                    if(v7_1 != v14) {
                        break;
                    }
                }

                if(v4 == v3_1) {
                    break;
                }
            }
        }

        v0_1.clear();
    }

    public final void setHapticFeedbackEnabled(boolean arg1) {
        this.hapticFeedbackEnabled = arg1;
    }

    public final void update-2tQrsxU(Function0 arg4, String arg5, Function0 arg6, Function0 arg7, MutableInteractionSource arg8, IndicationNodeFactory arg9, boolean arg10, boolean arg11, String arg12, Role arg13) {
        if(!Intrinsics.areEqual(this.onLongClickLabel, arg5)) {
            this.onLongClickLabel = arg5;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }

        int v0 = 1;
        int v1 = 0;
        int v5 = this.onLongClick == null ? 1 : 0;
        int v2 = arg6 == null ? 1 : 0;
        if(v5 != v2) {
            this.disposeInteractions();
            SemanticsModifierNodeKt.invalidateSemantics(this);
            v5 = 1;
        }
        else {
            v5 = 0;
        }

        this.onLongClick = arg6;
        int v6 = this.onDoubleClick == null ? 1 : 0;
        if(arg7 == null) {
            v1 = 1;
        }

        if(v6 != v1) {
            v5 = 1;
        }

        this.onDoubleClick = arg7;
        if(this.getEnabled() != arg11) {
        }
        else {
            v0 = v5;
        }

        this.updateCommon-O2vRcR0(arg8, arg9, arg10, arg11, arg12, arg13, arg4);
        if(v0 != 0) {
            this.resetPointerInputHandler();
        }
    }
}

