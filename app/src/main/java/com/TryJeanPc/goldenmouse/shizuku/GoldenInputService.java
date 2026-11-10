package com.TryJeanPc.goldenmouse.shizuku;

import android.content.Context;
import android.os.Binder;
import android.os.Parcel;
import android.os.Process;
import android.util.Log;
import com.TryJeanPc.goldenmouse.bridge.InputManagerBridge;
import com.TryJeanPc.goldenmouse.injector.TouchCommand$Action;
import com.TryJeanPc.goldenmouse.injector.TouchCommand;
import com.TryJeanPc.goldenmouse.injector.TouchEventProcessor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u000B\u001A\u00020\fH\u0002J*\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001A\u00020\u0010H\u0014J\u0006\u0010\u0015\u001A\u00020\u0010J\u0006\u0010\u0016\u001A\u00020\u000ER\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/shizuku/GoldenInputService;", "Landroid/os/Binder;", "<init>", "()V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "inputManager", "Lcom/TryJeanPc/goldenmouse/bridge/InputManagerBridge;", "touchProcessor", "Lcom/TryJeanPc/goldenmouse/injector/TouchEventProcessor;", "initialize", "", "onTransact", "", "code", "", "data", "Landroid/os/Parcel;", "reply", "flags", "getRemoteUid", "isInputManagerReady", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenInputService extends Binder {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0080T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/shizuku/GoldenInputService$Companion;", "", "<init>", "()V", "TAG", "", "INJECTOR_TAG", "DESCRIPTOR", "TRANSACTION_EXECUTE_TOUCH", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final String DESCRIPTOR = "com.TryJeanPc.goldenmouse.shizuku.IGoldenInputService";
    public static final String INJECTOR_TAG = "GOLDEN_INJECTOR";
    public static final String TAG = "GOLDEN_SHIZUKU";
    public static final int TRANSACTION_EXECUTE_TOUCH = 1;
    private InputManagerBridge inputManager;
    private TouchEventProcessor touchProcessor;

    static {
        GoldenInputService.Companion = new Companion(null);
        GoldenInputService.$stable = 8;
    }

    public GoldenInputService() {
        super();
        Log.d("GOLDEN_SHIZUKU", "Constructor UserService sin Context");
        this.initialize();
    }

    public GoldenInputService(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        super();
        Log.d("GOLDEN_SHIZUKU", "Constructor UserService con Context: " + arg3.getClass().getName());
        this.initialize();
    }

    public final int getRemoteUid() {
        return Process.myUid();
    }

    private final void initialize() {
        InputManagerBridge v2_1;
        String v1 = "GOLDEN_SHIZUKU";
        Log.i(v1, "UserService conectado. UID remoto=" + Process.myUid());
        TouchEventProcessor v0 = null;
        try {
            v2_1 = new InputManagerBridge();
        }
        catch(Throwable v2) {
            Log.e(v1, "No se pudo obtener el servicio InputManager", v2);
            v2_1 = ((InputManagerBridge)v0);
        }

        this.inputManager = v2_1;
        if(v2_1 != null) {
            v0 = new TouchEventProcessor(new GoldenInputService$initialize$1$1(v2_1));
        }

        this.touchProcessor = v0;
        InputManagerBridge v4 = this.inputManager;
        boolean v0_1 = false;
        if(v4 != null && (v4.estaDisponible())) {
            v0_1 = true;
        }

        Log.i(v1, "InputManager preparado=" + v0_1);
    }

    public final boolean isInputManagerReady() {
        InputManagerBridge v2 = this.inputManager;
        if(v2 != null && (v2.estaDisponible())) {
            return 1;
        }

        return 0;
    }

    protected boolean onTransact(int arg17, Parcel arg18, Parcel arg19, int arg20) {
        int v0 = arg17;
        Parcel v1 = arg18;
        Parcel v2 = arg19;
        Intrinsics.checkNotNullParameter(v1, "data");
        String v4 = "com.TryJeanPc.goldenmouse.shizuku.IGoldenInputService";
        if(v0 == 0x5F4E5446) {
            if(v2 != null) {
                v2.writeString(v4);
            }

            return 1;
        }

        if(v0 == 1) {
            v1.enforceInterface(v4);
            Object v7 = CollectionsKt.getOrNull(Action.getEntries(), v1.readInt());
            v0 = 0;
            if(v7 == null) {
            }
            else {
                TouchCommand v6 = new TouchCommand(((Action)v7), v1.readFloat(), v1.readFloat(), v1.readInt(), v1.readLong(), null, 0x20, null);
                if(v6.getPointerId() == 0 && (SetsKt.setOf(new Action[]{Action.ACTION_DOWN, Action.ACTION_UP}).contains(v6.getAction()))) {
                    Log.i("GOLDEN_SHIZUKU", "received " + v6.getAction() + " pointer=0 x=" + v6.getX() + " y=" + v6.getY());
                }

                TouchEventProcessor v1_1 = this.touchProcessor;
                if(v1_1 == null) {
                    goto label_62;
                }

                boolean v0_1 = v1_1.execute(v6);
            }

        label_62:
            if(v2 != null) {
                v2.writeNoException();
            }

            if(v2 != null) {
                v2.writeInt(v0);
            }

            return 1;
        }

        return super.onTransact(arg17, arg18, arg19, arg20);
    }
}

