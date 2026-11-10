package com.TryJeanPc.goldenmouse.controls;

import android.view.KeyEvent;
import android.view.MotionEvent;
import com.TryJeanPc.goldenmouse.input.InputEvent$Button;
import com.TryJeanPc.goldenmouse.mapper.GameProfileCompiler;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\u0004J\u0006\u0010\f\u001A\u00020\u0005R\u001A\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/VistaActivationCapture;", "", "onSelected", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "open", "", "accept", "input", "close", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class VistaActivationCapture {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u001A\u0010\u0007\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t0\b2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\tJ\u0010\u0010\f\u001A\u0004\u0018\u00010\n2\u0006\u0010\r\u001A\u00020\u000EJ\u0010\u0010\u000F\u001A\u0004\u0018\u00010\n2\u0006\u0010\r\u001A\u00020\u0010¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/VistaActivationCapture$Companion;", "", "<init>", "()V", "captureRaw", "Lkotlin/Function0;", "", "slot", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "listener", "fromKeyEvent", "event", "Landroid/view/KeyEvent;", "fromMotionEvent", "Landroid/view/MotionEvent;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Function0 captureRaw(AtomicReference arg2, Function1 arg3) {
            Intrinsics.checkNotNullParameter(arg2, "slot");
            Intrinsics.checkNotNullParameter(arg3, "listener");
            return new VistaActivationCapture$Companion$$ExternalSyntheticLambda1(arg2, arg3, arg2.getAndSet(arg3));
        }

        static final Unit captureRaw$lambda$0(AtomicReference arg0, Function1 arg1, Function1 arg2) {
            VistaActivationCapture$Companion$$ExternalSyntheticBackportWithForwarding0.m(arg0, arg1, arg2);
            return Unit.INSTANCE;
        }

        public final InputBinding fromKeyEvent(KeyEvent arg2) {
            Intrinsics.checkNotNullParameter(arg2, "event");
            if(arg2.getAction() == 0 && arg2.getRepeatCount() == 0) {
                if(arg2.getKeyCode() == 0) {
                }
                else {
                    if(arg2.isFromSource(0x2002)) {
                        int v1 = arg2.getKeyCode();
                        if(v1 == 4) {
                            return InputBinding.Companion.mouse(Button.SIDE_1);
                        }
                        else if(v1 != 0x7D) {
                        }
                        else {
                            return InputBinding.Companion.mouse(Button.SIDE_2);
                        }
                    }

                    com.TryJeanPc.goldenmouse.mapper.InputBinding$Companion v1_1 = InputBinding.Companion;
                    String v2 = KeyEvent.keyCodeToString(arg2.getKeyCode());
                    Intrinsics.checkNotNullExpressionValue(v2, "keyCodeToString(...)");
                    return v1_1.keyboard(StringsKt.removePrefix(v2, "KEYCODE_"));
                }
            }

            return null;
        }

        public final InputBinding fromMotionEvent(MotionEvent arg3) {
            Intrinsics.checkNotNullParameter(arg3, "event");
            InputBinding v1 = null;
            if(arg3.getActionMasked() != 8 && arg3.getActionButton() == 0 && (arg3.getButtonState() & 1) != 0) {
                return v1;
            }

            String v2 = TeclaEditorView.Companion.resolverNombreBotonRaton(arg3);
            if(v2 == null) {
                v2 = TeclaEditorView.Companion.resolverNombreScroll(arg3);
            }

            if(v2 != null) {
                return InputBinding.Companion.fromDisplayName(v2);
            }

            return v1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final Function1 onSelected;
    private boolean open;

    static {
        VistaActivationCapture.Companion = new Companion(null);
        VistaActivationCapture.$stable = 8;
    }

    public VistaActivationCapture(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "onSelected");
        super();
        this.onSelected = arg2;
        this.open = true;
    }

    public final boolean accept(InputBinding arg4) {
        Intrinsics.checkNotNullParameter(arg4, "input");
        if((this.open) && (GameProfileCompiler.INSTANCE.isVistaInputAllowed(arg4))) {
            if(!Intrinsics.areEqual(InputBinding.Companion.fromDisplayName(arg4.displayName()), arg4)) {
            }
            else {
                this.open = false;
                this.onSelected.invoke(arg4);
                return 1;
            }
        }

        return 0;
    }

    public final void close() {
        this.open = false;
    }
}

