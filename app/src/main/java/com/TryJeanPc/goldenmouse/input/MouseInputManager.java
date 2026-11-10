package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001D\u0012\u0014\b\u0002\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001A\u00020\u0005H\u0016J\b\u0010\u000B\u001A\u00020\u0005H\u0016J\u0010\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u0004H\u0016J\u0006\u0010\u000E\u001A\u00020\tR\u001A\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MouseInputManager;", "Lcom/TryJeanPc/goldenmouse/input/InputBackend;", "eventCallback", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "active", "", "start", "stop", "onEvent", "evento", "isRunning", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseInputManager implements InputBackend {
    public static final int $stable = 8;
    private volatile boolean active;
    private final Function1 eventCallback;

    static {
    }

    public MouseInputManager() {
        this(null, 1, null);
    }

    public MouseInputManager(Function1 arg1, int arg2, DefaultConstructorMarker arg3) {
        MouseInputManager$$ExternalSyntheticLambda0 v1;
        if((arg2 & 1) != 0) {
            v1 = new MouseInputManager$$ExternalSyntheticLambda0();
        }

        this(((Function1)v1));
    }

    public MouseInputManager(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "eventCallback");
        super();
        this.eventCallback = arg2;
    }

    static final Unit _init_$lambda$0(InputEvent arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    public final boolean isRunning() {
        return this.active;
    }

    public void onEvent(InputEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "evento");
        if(!this.active) {
        }
        else if((arg2 instanceof MouseMove)) {
            this.eventCallback.invoke(arg2);
            return;
        }
        else if((arg2 instanceof MouseButton)) {
            this.eventCallback.invoke(arg2);
            return;
        }
        else if((arg2 instanceof Scroll)) {
            this.eventCallback.invoke(arg2);
        }
    }

    public void start() {
        this.active = true;
    }

    public void stop() {
        this.active = false;
    }
}

