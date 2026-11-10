package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u0005J\u0006\u0010\u0019\u001A\u00020\u0017J\n\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0016J*\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00052\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00010\u001E2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020 0\u001EJ\b\u0010!\u001A\u00020\u0017H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0011@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\""}, d2={"Lcom/TryJeanPc/goldenmouse/input/DeviceCaptureSession;", "Lcom/TryJeanPc/goldenmouse/input/CaptureStream;", "descriptor", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;", "captureMode", "Lcom/TryJeanPc/goldenmouse/input/CaptureMode;", "streamFactory", "Lkotlin/Function1;", "<init>", "(Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;Lcom/TryJeanPc/goldenmouse/input/CaptureMode;Lkotlin/jvm/functions/Function1;)V", "getDescriptor", "()Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;", "getCaptureMode", "()Lcom/TryJeanPc/goldenmouse/input/CaptureMode;", "setCaptureMode", "(Lcom/TryJeanPc/goldenmouse/input/CaptureMode;)V", "value", "Lcom/TryJeanPc/goldenmouse/input/InputState;", "state", "getState", "()Lcom/TryJeanPc/goldenmouse/input/InputState;", "stream", "start", "", "mode", "stop", "readLine", "", "changeCaptureMode", "open", "Lkotlin/Function0;", "currentRequest", "", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class DeviceCaptureSession implements CaptureStream {
    public static final int $stable = 8;
    private volatile CaptureMode captureMode;
    private final InputDeviceDescriptor descriptor;
    private volatile InputState state;
    private volatile CaptureStream stream;
    private final Function1 streamFactory;

    static {
    }

    public DeviceCaptureSession(InputDeviceDescriptor arg2, CaptureMode arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg3, "captureMode");
        Intrinsics.checkNotNullParameter(arg4, "streamFactory");
        super();
        this.descriptor = arg2;
        this.captureMode = arg3;
        this.streamFactory = arg4;
        this.state = InputState.DISCONNECTED;
    }

    public DeviceCaptureSession(InputDeviceDescriptor arg1, CaptureMode arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = CaptureMode.SHARED;
        }

        this(arg1, arg2, arg3);
    }

    public final void changeCaptureMode(CaptureMode arg3, Function0 arg4, Function0 arg5) {
        Object v4_1;
        CaptureStream v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "mode");
            Intrinsics.checkNotNullParameter(arg4, "open");
            Intrinsics.checkNotNullParameter(arg5, "currentRequest");
            v0 = this.stream;
            if(v0 != null) {
                goto label_11;
            }
        }
        catch(Throwable v3) {
            goto label_33;
        }

        __monitor_exit(this);
        return;
        try {
        label_11:
            if(this.captureMode != arg3) {
                goto label_15;
            }
        }
        catch(Throwable v3) {
            goto label_33;
        }

        __monitor_exit(this);
        return;
        try {
        label_15:
            v4_1 = arg4.invoke();
            Object v5 = arg5.invoke();
            goto label_17;
        }
        catch(Exception v4) {
            try {
                if(arg3 == CaptureMode.SHARED) {
                    this.stop();
                }

                throw v4;
            label_17:
                if(((Boolean)v5).booleanValue()) {
                    goto label_22;
                }

                ((CaptureStream)v4_1).close();
            }
            catch(Throwable v3) {
                goto label_33;
            }
        }

        __monitor_exit(this);
        return;
        try {
        label_22:
            this.stream = ((CaptureStream)v4_1);
            this.captureMode = arg3;
            v0.close();
            goto label_25;
        label_33:
            __monitor_exit(this);
        }
        catch(Throwable v3) {
            goto label_33;
        }

        throw v3;
    label_25:
        __monitor_exit(this);
    }

    public void close() {
        this.stop();
    }

    public final CaptureMode getCaptureMode() {
        return this.captureMode;
    }

    public final InputDeviceDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final InputState getState() {
        return this.state;
    }

    public String readLine() {
        String v1;
        do {
        label_0:
            v1 = null;
            if(Thread.currentThread().isInterrupted()) {
                return v1;
            }

            CaptureStream v0 = this.stream;
            if(v0 == null) {
                return v1;
            }

            try {
                v1 = v0.readLine();
            }
            catch(Exception v1_1) {
                if(v0 != this.stream) {
                    goto label_0;
                }

                throw v1_1;
            }
        }
        while(v0 != this.stream);

        return v1;
    }

    public final void setCaptureMode(CaptureMode arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.captureMode = arg2;
    }

    public final void start(CaptureMode arg2) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg2, "mode");
            if(this.stream == null) {
                goto label_7;
            }
        }
        catch(Throwable v2) {
            goto label_25;
        }

        __monitor_exit(this);
        return;
        try {
        label_7:
            this.captureMode = arg2;
            this.state = InputState.WAITING;
        }
        catch(Throwable v2) {
            goto label_25;
        }

        try {
            this.stream = this.streamFactory.invoke(this.descriptor);
            this.state = InputState.CONNECTED;
            goto label_16;
        }
        catch(Throwable v2) {
            CaptureStream v0 = null;
            try {
                this.stream = v0;
                this.state = InputState.ERROR;
                throw v2;
            label_25:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_25;
            }
        }

        throw v2;
    label_16:
        __monitor_exit(this);
    }

    public static void start$default(DeviceCaptureSession arg0, CaptureMode arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.captureMode;
        }

        arg0.start(arg1);
    }

    public final void stop() {
        CaptureStream v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.stream;
            this.stream = null;
            if(v0_1 != null) {
                goto label_5;
            }

            goto label_11;
        }
        catch(Throwable v0) {
            goto label_16;
        }

        try {
        label_5:
            v0_1.close();
            goto label_11;
        }
        catch(Throwable v0) {
            try {
                this.state = InputState.DISCONNECTED;
                throw v0;
            label_11:
                this.state = InputState.DISCONNECTED;
            }
            catch(Throwable v0) {
                try {
                label_16:
                    __monitor_exit(this);
                }
                catch(Throwable v0) {
                    goto label_16;
                }

                throw v0;
            }
        }

        __monitor_exit(this);
    }
}

