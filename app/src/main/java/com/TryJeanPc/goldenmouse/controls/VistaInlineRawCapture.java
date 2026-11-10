package com.TryJeanPc.goldenmouse.controls;

import com.TryJeanPc.goldenmouse.input.InputEvent$KeyDown;
import com.TryJeanPc.goldenmouse.input.InputEvent$MouseButton;
import com.TryJeanPc.goldenmouse.input.InputEvent;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.mapper.InputBindingSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u0002H\u0096\u0002J\u000E\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\rR\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/VistaInlineRawCapture;", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "", "listener", "afterReleaseNanos", "", "<init>", "(Lkotlin/jvm/functions/Function1;J)V", "invoke", "binding", "acceptEvent", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class VistaInlineRawCapture implements Function1 {
    public static final int $stable;
    private final long afterReleaseNanos;
    private final Function1 listener;

    static {
    }

    public VistaInlineRawCapture(Function1 arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        super();
        this.listener = arg2;
        this.afterReleaseNanos = arg3;
    }

    public VistaInlineRawCapture(Function1 arg1, long arg2, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = System.nanoTime();
        }

        this(arg1, arg2);
    }

    public final void acceptEvent(InputEvent arg5) {
        Intrinsics.checkNotNullParameter(arg5, "event");
        if(arg5.getTimestampNanos() > this.afterReleaseNanos) {
            if(!(arg5 instanceof KeyDown)) {
                if(!(arg5 instanceof MouseButton)) {
                    return;
                }
                else if(!arg5.getPressed()) {
                    return;
                }
            }

            InputBinding v5 = InputBinding.Companion.fromEvent(arg5);
            if(v5 == null) {
                return;
            }

            if(v5.getSource() == InputBindingSource.KEYBOARD && (SetsKt.setOf(new String[]{"SCROLL_UP", "SCROLL_DOWN"}).contains(v5.getNormalizedCode()))) {
                return;
            }

            this.listener.invoke(v5);
        }
    }

    public Object invoke(Object arg1) {
        this.invoke(((InputBinding)arg1));
        return Unit.INSTANCE;
    }

    public void invoke(InputBinding arg2) {
        Intrinsics.checkNotNullParameter(arg2, "binding");
        this.listener.invoke(arg2);
    }
}

