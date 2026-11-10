package com.TryJeanPc.goldenmouse.controls;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.engine.VistaQuickChangeCoordinator;
import com.TryJeanPc.goldenmouse.input.InputEvent$Button;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.mapper.InputBindingSource;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001!B1\u0012(\b\u0002\u0010\u0002\u001A\"\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ8\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00142\u0014\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00032\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003J\u0010\u0010\u0018\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u0004H\u0002J\u000E\u0010\u001A\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u001CJ\u000E\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u001EJ\u0006\u0010\u001F\u001A\u00020\u0005J\u0006\u0010 \u001A\u00020\u0005R.\u0010\u0002\u001A\"\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2={"Lcom/TryJeanPc/goldenmouse/controls/VistaInlineBindingCapture;", "", "captureRaw", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "waiting", "Lcom/TryJeanPc/goldenmouse/controls/VistaInlineBindingCapture$Waiting;", "closed", "", "consumedKeys", "", "", "handler", "Landroid/os/Handler;", "start", "box", "Landroid/widget/TextView;", "validate", "", "selected", "accept", "binding", "onKeyEvent", "event", "Landroid/view/KeyEvent;", "onMotionEvent", "Landroid/view/MotionEvent;", "cancel", "close", "Waiting", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class VistaInlineBindingCapture {
    @Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0014\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u001F\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001D\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0019\u0010\u0011\u001A\n \u0013*\u0004\u0018\u00010\u00120\u0012¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001A\n \u0013*\u0004\u0018\u00010\u00120\u0012¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0015R\u001C\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\"\u0010\u001E\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001C\u0010$\u001A\u0004\u0018\u00010%X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u0011\u0010*\u001A\u00020+¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-¨\u0006."}, d2={"Lcom/TryJeanPc/goldenmouse/controls/VistaInlineBindingCapture$Waiting;", "", "box", "Landroid/widget/TextView;", "validate", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "", "selected", "", "<init>", "(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getBox", "()Landroid/widget/TextView;", "getValidate", "()Lkotlin/jvm/functions/Function1;", "getSelected", "previousText", "", "kotlin.jvm.PlatformType", "getPreviousText", "()Ljava/lang/CharSequence;", "previousDescription", "getPreviousDescription", "capture", "Lcom/TryJeanPc/goldenmouse/controls/VistaActivationCapture;", "getCapture", "()Lcom/TryJeanPc/goldenmouse/controls/VistaActivationCapture;", "setCapture", "(Lcom/TryJeanPc/goldenmouse/controls/VistaActivationCapture;)V", "stopRaw", "Lkotlin/Function0;", "getStopRaw", "()Lkotlin/jvm/functions/Function0;", "setStopRaw", "(Lkotlin/jvm/functions/Function0;)V", "restorePrompt", "Ljava/lang/Runnable;", "getRestorePrompt", "()Ljava/lang/Runnable;", "setRestorePrompt", "(Ljava/lang/Runnable;)V", "startedAtMillis", "", "getStartedAtMillis", "()J", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Waiting {
        private final TextView box;
        private VistaActivationCapture capture;
        private final CharSequence previousDescription;
        private final CharSequence previousText;
        private Runnable restorePrompt;
        private final Function1 selected;
        private final long startedAtMillis;
        private Function0 stopRaw;
        private final Function1 validate;

        public Waiting(TextView arg2, Function1 arg3, Function1 arg4) {
            Intrinsics.checkNotNullParameter(arg2, "box");
            Intrinsics.checkNotNullParameter(arg3, "validate");
            Intrinsics.checkNotNullParameter(arg4, "selected");
            super();
            this.box = arg2;
            this.validate = arg3;
            this.selected = arg4;
            this.previousText = arg2.getText();
            this.previousDescription = arg2.getContentDescription();
            this.startedAtMillis = SystemClock.uptimeMillis();
        }

        public final TextView getBox() {
            return this.box;
        }

        public final VistaActivationCapture getCapture() {
            return this.capture;
        }

        public final CharSequence getPreviousDescription() {
            return this.previousDescription;
        }

        public final CharSequence getPreviousText() {
            return this.previousText;
        }

        public final Runnable getRestorePrompt() {
            return this.restorePrompt;
        }

        public final Function1 getSelected() {
            return this.selected;
        }

        public final long getStartedAtMillis() {
            return this.startedAtMillis;
        }

        public final Function0 getStopRaw() {
            return this.stopRaw;
        }

        public final Function1 getValidate() {
            return this.validate;
        }

        public final void setCapture(VistaActivationCapture arg1) {
            this.capture = arg1;
        }

        public final void setRestorePrompt(Runnable arg1) {
            this.restorePrompt = arg1;
        }

        public final void setStopRaw(Function0 arg1) {
            this.stopRaw = arg1;
        }
    }

    public static final int $stable = 8;
    private final Function1 captureRaw;
    private boolean closed;
    private final Set consumedKeys;
    private final Handler handler;
    private Waiting waiting;

    static {
    }

    public VistaInlineBindingCapture(Function1 arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        this(arg1);
    }

    public VistaInlineBindingCapture(Function1 arg2) {
        super();
        this.captureRaw = arg2;
        this.consumedKeys = new LinkedHashSet();
        this.handler = new Handler(Looper.getMainLooper());
    }

    public VistaInlineBindingCapture() {
        this(null, 1, null);
    }

    private final void accept(InputBinding arg5) {
        String v1;
        Waiting v0 = this.waiting;
        if(v0 == null) {
        }
        else {
            if(arg5.getSource() == InputBindingSource.KEYBOARD && (SetsKt.setOf(new String[]{"ESC", "ESCAPE"}).contains(arg5.getNormalizedCode()))) {
                this.cancel();
                return;
            }

            if(Intrinsics.areEqual(arg5, InputBinding.Companion.mouse(Button.LEFT))) {
                v1 = "LEFT RESERVADO PARA FIRE. REINTENTA...";
            }
            else if(!VistaQuickChangeCoordinator.Companion.isBindingAllowed(arg5)) {
                v1 = "TECLA NO VÁLIDA. REINTENTA...";
            }
            else if(v0.getValidate().invoke(arg5) != null) {
                v1 = "TECLA EN USO O NO VÁLIDA. REINTENTA...";
            }
            else {
                v1 = null;
            }

            if(v1 != null) {
                Runnable v5 = v0.getRestorePrompt();
                if(v5 != null) {
                    this.handler.removeCallbacks(v5);
                }

                v0.getBox().setText(((CharSequence)v1));
                VistaInlineBindingCapture$$ExternalSyntheticLambda0 v5_1 = new VistaInlineBindingCapture$$ExternalSyntheticLambda0(this, v0);
                this.handler.postDelayed(((Runnable)v5_1), 1200);
                v0.setRestorePrompt(((Runnable)v5_1));
                return;
            }

            VistaActivationCapture v4 = v0.getCapture();
            if(v4 == null) {
                return;
            }

            v4.accept(arg5);
        }
    }

    static final void accept$lambda$4(VistaInlineBindingCapture arg0, Waiting arg1) {
        if(arg0.waiting == arg1) {
            arg1.getBox().setText("ESPERANDO TECLA...");
        }
    }

    public final void cancel() {
        Waiting v0 = this.waiting;
        if(v0 == null) {
            return;
        }

        Waiting v1 = null;
        this.waiting = v1;
        VistaActivationCapture v2 = v0.getCapture();
        if(v2 != null) {
            v2.close();
        }

        Function0 v2_1 = v0.getStopRaw();
        if(v2_1 != null) {
            v2_1.invoke();
        }

        this.handler.removeCallbacksAndMessages(v1);
        v0.getBox().setText(v0.getPreviousText());
        v0.getBox().setContentDescription(v0.getPreviousDescription());
    }

    public final void close() {
        this.cancel();
        this.closed = true;
        this.consumedKeys.clear();
    }

    public final boolean onKeyEvent(KeyEvent arg6) {
        Intrinsics.checkNotNullParameter(arg6, "event");
        int v0 = arg6.getAction();
        Set v1 = this.consumedKeys;
        if(v0 == 1) {
            return v1.remove(Integer.valueOf(arg6.getKeyCode()));
        }

        if(v1.contains(Integer.valueOf(arg6.getKeyCode()))) {
            return 1;
        }

        Waiting v0_1 = this.waiting;
        if(v0_1 == null) {
            return 0;
        }

        if(arg6.getAction() != 0) {
            return 0;
        }

        this.consumedKeys.add(Integer.valueOf(arg6.getKeyCode()));
        if(arg6.getEventTime() >= v0_1.getStartedAtMillis()) {
            InputBinding v0_2 = VistaActivationCapture.Companion.fromKeyEvent(arg6);
            if(v0_2 != null) {
                this.accept(v0_2);
            }

            if(arg6.getKeyCode() != 0) {
                return 1;
            }

            if(arg6.getRepeatCount() != 0) {
                return 1;
            }

            this.accept(InputBinding.Companion.keyboard("UNKNOWN"));
        }

        return 1;
    }

    public final boolean onMotionEvent(MotionEvent arg7) {
        Intrinsics.checkNotNullParameter(arg7, "event");
        Waiting v0 = this.waiting;
        if(v0 == null) {
            return 0;
        }

        if(arg7.getEventTime() >= v0.getStartedAtMillis()) {
            if(!SetsKt.setOf(new Integer[]{Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(11)}).contains(Integer.valueOf(arg7.getActionMasked()))) {
            }
            else {
                if(arg7.getActionButton() != 1 && (arg7.getActionButton() != 0 || arg7.getButtonState() != 1)) {
                    InputBinding v7 = VistaActivationCapture.Companion.fromMotionEvent(arg7);
                    if(v7 == null) {
                        return 0;
                    }

                    this.accept(v7);
                    return 1;
                }

                this.accept(InputBinding.Companion.mouse(Button.LEFT));
            }
        }

        return 0;
    }

    public final void start(TextView arg2, Function1 arg3, Function1 arg4) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg2, "box");
        Intrinsics.checkNotNullParameter(arg3, "validate");
        Intrinsics.checkNotNullParameter(arg4, "selected");
        if(this.closed) {
            return;
        }

        this.cancel();
        Waiting v0 = new Waiting(arg2, arg3, arg4);
        this.waiting = v0;
        arg2.setText("ESPERANDO TECLA...");
        v0.setCapture(new VistaActivationCapture(new VistaInlineBindingCapture$$ExternalSyntheticLambda2(this, v0, arg4)));
        Function1 v2 = this.captureRaw;
        if(v2 != null) {
            v1 = v2.invoke(new VistaInlineBindingCapture$$ExternalSyntheticLambda3(this, v0));
        }
        else {
            Function0 v1_1 = null;
        }

        v0.setStopRaw(((Function0)v1));
    }

    static final Unit start$lambda$0(VistaInlineBindingCapture arg1, Waiting arg2, Function1 arg3, InputBinding arg4) {
        Intrinsics.checkNotNullParameter(arg4, "binding");
        if(arg1.waiting == arg2) {
            arg1.cancel();
            arg3.invoke(arg4);
        }

        return Unit.INSTANCE;
    }

    static final Unit start$lambda$2(VistaInlineBindingCapture arg2, Waiting arg3, InputBinding arg4) {
        Intrinsics.checkNotNullParameter(arg4, "binding");
        arg2.handler.post(new VistaInlineBindingCapture$$ExternalSyntheticLambda1(arg2, arg3, arg4));
        return Unit.INSTANCE;
    }

    static final void start$lambda$2$lambda$1(VistaInlineBindingCapture arg1, Waiting arg2, InputBinding arg3) {
        if(arg1.waiting == arg2) {
            arg1.accept(arg3);
        }
    }
}

