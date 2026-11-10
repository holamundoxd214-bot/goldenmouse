package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MouseCaptureSession;", "", "deviceSession", "Lcom/TryJeanPc/goldenmouse/input/DeviceCaptureSession;", "eventConsumer", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/input/DeviceCaptureSession;Lkotlin/jvm/functions/Function1;)V", "getDeviceSession", "()Lcom/TryJeanPc/goldenmouse/input/DeviceCaptureSession;", "descriptor", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;", "getDescriptor", "()Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;", "state", "Lcom/TryJeanPc/goldenmouse/input/InputState;", "getState", "()Lcom/TryJeanPc/goldenmouse/input/InputState;", "onEvent", "", "event", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseCaptureSession {
    public static final int $stable = 8;
    private final DeviceCaptureSession deviceSession;
    private final Function1 eventConsumer;

    static {
    }

    public MouseCaptureSession(DeviceCaptureSession arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "deviceSession");
        Intrinsics.checkNotNullParameter(arg3, "eventConsumer");
        super();
        this.deviceSession = arg2;
        this.eventConsumer = arg3;
    }

    public final InputDeviceDescriptor getDescriptor() {
        return this.deviceSession.getDescriptor();
    }

    public final DeviceCaptureSession getDeviceSession() {
        return this.deviceSession;
    }

    public final InputState getState() {
        return this.deviceSession.getState();
    }

    public final boolean onEvent(InputEvent arg4) {
        Intrinsics.checkNotNullParameter(arg4, "event");
        if(arg4.getSourceRole() == InputDeviceRole.MOUSE && (arg4.getDevicePath() == null || (Intrinsics.areEqual(arg4.getDevicePath(), this.getDescriptor().getPath())))) {
            if(!(arg4 instanceof MouseMove) && !(arg4 instanceof MouseButton)) {
                if((arg4 instanceof Scroll)) {
                }
                else {
                    return 0;
                }
            }

            this.eventConsumer.invoke(arg4);
            return 1;
        }

        return 0;
    }
}

