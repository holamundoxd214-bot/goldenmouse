package com.TryJeanPc.goldenmouse.shizuku;

import android.content.ComponentName;
import android.os.IBinder;
import android.os.Parcel;
import android.os.SystemClock;
import android.util.Log;
import com.TryJeanPc.goldenmouse.injector.TouchCommand;
import com.TryJeanPc.goldenmouse.license.LicenseManager;
import com.TryJeanPc.goldenmouse.transport.TransportDeadline;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import rikka.shizuku.Shizuku$UserServiceArgs;
import rikka.shizuku.Shizuku;

@Metadata(d1={"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001B\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\f\u001A\u00020\u0001H\u0000¢\u0006\u0002\b\rJ\u0006\u0010\u001D\u001A\u00020\u000FJ\u0006\u0010\u001E\u001A\u00020\u000FJ\u0010\u0010!\u001A\u00020\u000F2\b\b\u0002\u0010\"\u001A\u00020#J\u000E\u0010%\u001A\u00020\u000F2\u0006\u0010&\u001A\u00020\'J\u0018\u0010(\u001A\u00020\u000F2\u0006\u0010&\u001A\u00020\'2\u0006\u0010)\u001A\u00020\nH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0013\u001A\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001CR\u000E\u0010\u001F\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020#X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2={"Lcom/TryJeanPc/goldenmouse/shizuku/GoldenInputServiceConnection;", "", "<init>", "()V", "APPLICATION_ID", "", "INJECT_EVENTS_PERMISSION", "SHELL_UID", "", "remoteBinder", "Landroid/os/IBinder;", "disconnectedRegistry", "contactRegistryIdentity", "contactRegistryIdentity$app", "bindingRequested", "", "connected", "connectionMonitor", "Ljava/lang/Object;", "userServiceArgs", "Lrikka/shizuku/Shizuku$UserServiceArgs;", "kotlin.jvm.PlatformType", "getUserServiceArgs", "()Lrikka/shizuku/Shizuku$UserServiceArgs;", "userServiceArgs$delegate", "Lkotlin/Lazy;", "serviceConnection", "com/TryJeanPc/goldenmouse/shizuku/GoldenInputServiceConnection$serviceConnection$1", "Lcom/TryJeanPc/goldenmouse/shizuku/GoldenInputServiceConnection$serviceConnection$1;", "connect", "isConnected", "bindingCalls", "Lcom/TryJeanPc/goldenmouse/transport/TransportDeadline;", "awaitConnected", "timeoutMillis", "", "transactions", "execute", "command", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "executeOnBinder", "binder", "CONNECTION_TIMEOUT_MILLIS", "USER_SERVICE_VERSION", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenInputServiceConnection {
    public static final int $stable = 0;
    private static final String APPLICATION_ID = "com.TryJeanPc.goldenmouse";
    private static final long CONNECTION_TIMEOUT_MILLIS = 5000;
    private static final String INJECT_EVENTS_PERMISSION = "android.permission.INJECT_EVENTS";
    public static final GoldenInputServiceConnection INSTANCE = null;
    private static final int SHELL_UID = 2000;
    private static final int USER_SERVICE_VERSION = 9;
    private static final TransportDeadline bindingCalls;
    private static volatile boolean bindingRequested;
    private static volatile boolean connected;
    private static final Object connectionMonitor;
    private static final Object disconnectedRegistry;
    private static volatile IBinder remoteBinder;
    private static final GoldenInputServiceConnection$serviceConnection$1 serviceConnection;
    private static final TransportDeadline transactions;
    private static final Lazy userServiceArgs$delegate;

    static {
        GoldenInputServiceConnection.INSTANCE = new GoldenInputServiceConnection();
        GoldenInputServiceConnection.disconnectedRegistry = new Object();
        GoldenInputServiceConnection.connectionMonitor = new Object();
        GoldenInputServiceConnection.userServiceArgs$delegate = LazyKt.lazy(new GoldenInputServiceConnection$$ExternalSyntheticLambda0());
        GoldenInputServiceConnection.serviceConnection = new GoldenInputServiceConnection$serviceConnection$1();
        GoldenInputServiceConnection.bindingCalls = new TransportDeadline("GoldenBinderConnect");
        GoldenInputServiceConnection.transactions = new TransportDeadline("GoldenBinder");
        GoldenInputServiceConnection.$stable = 8;
    }

    private GoldenInputServiceConnection() {
        super();
    }

    public static final Object access$getConnectionMonitor$p() {
        return GoldenInputServiceConnection.connectionMonitor;
    }

    public static final void access$setBindingRequested$p(boolean arg0) {
        GoldenInputServiceConnection.bindingRequested = arg0;
    }

    public static final void access$setConnected$p(boolean arg0) {
        GoldenInputServiceConnection.connected = arg0;
    }

    public static final void access$setRemoteBinder$p(IBinder arg0) {
        GoldenInputServiceConnection.remoteBinder = arg0;
    }

    public final boolean awaitConnected(long arg12) {
        long v4_1;
        Object v11;
        long v5;
        Function0 v7;
        Object v10;
        int v9;
        GoldenInputServiceConnection$$ExternalSyntheticLambda1 v8;
        TransportDeadline v4;
        if(this.isConnected()) {
            return 1;
        }

        long v2 = SystemClock.uptimeMillis();
        try {
            v4 = GoldenInputServiceConnection.bindingCalls;
            v8 = new GoldenInputServiceConnection$$ExternalSyntheticLambda1(this);
            v9 = 2;
            v10 = null;
            v7 = null;
            v5 = arg12;
        }
        catch(Throwable v0) {
            v5 = arg12;
            goto label_23;
        }

        try {
            v11 = Result.constructor-impl(Boolean.valueOf(TransportDeadline.call$default(v4, v5, v7, ((Function0)v8), v9, v10).booleanValue()));
            goto label_27;
        }
        catch(Throwable v0) {
        }

    label_23:
        v11 = Result.constructor-impl(ResultKt.createFailure(v0));
    label_27:
        Boolean v13 = Boolean.valueOf(false);
        if(Result.isFailure-impl(v11)) {
            Boolean v11_1 = v13;
        }

        if(!v11_1.booleanValue()) {
            return 0;
        }

        Log.d("GOLDEN_SHIZUKU", "Esperando conexión UserService");
        v2 += v5;
        v11 = GoldenInputServiceConnection.connectionMonitor;
        __monitor_enter(v11);
        try {
            while(true) {
            label_41:
                if(GoldenInputServiceConnection.connected) {
                    IBinder v13_1 = GoldenInputServiceConnection.remoteBinder;
                    if(v13_1 != null && (v13_1.isBinderAlive())) {
                        break;
                    }
                }

                goto label_50;
            }
        }
        catch(Throwable v0) {
            goto label_71;
        }

        __monitor_exit(v11);
        return 1;
        try {
        label_50:
            v4_1 = v2 - SystemClock.uptimeMillis();
            if(v4_1 > 0) {
                goto label_59;
            }

            Log.e("GOLDEN_SHIZUKU", "Tiempo agotado esperando UserService");
        }
        catch(Throwable v0) {
            goto label_71;
        }

        __monitor_exit(v11);
        return 0;
        try {
        label_59:
            GoldenInputServiceConnection.connectionMonitor.wait(v4_1);
            goto label_41;
        }
        catch(InterruptedException ) {
            Thread.currentThread().interrupt();
            Log.e("GOLDEN_SHIZUKU", "Espera de UserService interrumpida");
            __monitor_exit(v11);
            return 0;
        }

    label_71:
        __monitor_exit(v11);
        throw v0;
    }

    public static boolean awaitConnected$default(GoldenInputServiceConnection arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = 5000;
        }

        return arg0.awaitConnected(arg1);
    }

    static final boolean awaitConnected$lambda$2$lambda$1(GoldenInputServiceConnection arg0) {
        return arg0.connect();
    }

    public final boolean connect() {
        boolean v3;
        String v0 = "UID remoto esperado=2000, actual=";
        String v1 = "Shizuku ADB confirmado. UID remoto=";
        __monitor_enter(this);
        try {
            v3 = true;
            if(GoldenInputServiceConnection.connected) {
                IBinder v2 = GoldenInputServiceConnection.remoteBinder;
                if(v2 != null && (v2.isBinderAlive())) {
                    goto label_10;
                }
            }

            goto label_12;
        }
        catch(Throwable v0_1) {
            goto label_82;
        }

    label_10:
        __monitor_exit(this);
        return 1;
        try {
        label_12:
            if(!GoldenInputServiceConnection.bindingRequested) {
                goto label_17;
            }
        }
        catch(Throwable v0_1) {
            goto label_82;
        }

        __monitor_exit(this);
        return 1;
        try {
        label_17:
            if(LicenseManager.authorizeSession()) {
                goto label_21;
            }
        }
        catch(Throwable v0_1) {
            goto label_74;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_21:
            if(Shizuku.pingBinder()) {
                goto label_28;
            }

            Log.e("GOLDEN_SHIZUKU", "Shizuku no está activo");
        }
        catch(Throwable v0_1) {
            goto label_74;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_28:
            if(Shizuku.checkSelfPermission() == 0) {
                goto label_35;
            }

            Log.e("GOLDEN_SHIZUKU", "Permiso de Shizuku no concedido");
        }
        catch(Throwable v0_1) {
            goto label_74;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_35:
            if(Shizuku.checkRemotePermission("android.permission.INJECT_EVENTS") == 0) {
                goto label_43;
            }

            Log.e("GOLDEN_SHIZUKU", "UID remoto sin permiso INJECT_EVENTS");
        }
        catch(Throwable v0_1) {
            goto label_74;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_43:
            int v4 = Shizuku.getUid();
            if(v4 != 2000) {
                Log.w("GOLDEN_SHIZUKU", v0 + v4);
            }
            else {
                Log.i("GOLDEN_SHIZUKU", v1 + v4);
            }

            UserServiceArgs v0_2 = this.getUserServiceArgs();
            Log.d("GOLDEN_SHIZUKU", "Antes de Shizuku.bindUserService");
            Shizuku.bindUserService(v0_2, GoldenInputServiceConnection.serviceConnection);
            Log.d("GOLDEN_SHIZUKU", "bindUserService retornó sin excepción");
            GoldenInputServiceConnection.bindingRequested = true;
            Log.i("GOLDEN_SHIZUKU", "Conexión UserService solicitada");
        }
        catch(Throwable v0_1) {
            try {
            label_74:
                GoldenInputServiceConnection.bindingRequested = false;
                Log.e("GOLDEN_SHIZUKU", "No se pudo conectar el UserService", v0_1);
                v3 = false;
            }
            catch(Throwable v0_1) {
                try {
                label_82:
                    __monitor_exit(this);
                }
                catch(Throwable v0_1) {
                    goto label_82;
                }

                throw v0_1;
            }
        }

        __monitor_exit(this);
        return v3;
    }

    public final Object contactRegistryIdentity$app() {
        IBinder v0 = GoldenInputServiceConnection.remoteBinder;
        if(v0 == null) {
            Object v0_1 = GoldenInputServiceConnection.disconnectedRegistry;
        }

        return v0;
    }

    public final boolean execute(TouchCommand arg5) {
        Intrinsics.checkNotNullParameter(arg5, "command");
        IBinder v4 = GoldenInputServiceConnection.remoteBinder;
        if(v4 == null) {
            return 0;
        }

        try {
            return GoldenInputServiceConnection.transactions.call(2000, new GoldenInputServiceConnection$$ExternalSyntheticLambda2(v4), new GoldenInputServiceConnection$$ExternalSyntheticLambda3(arg5, v4)).booleanValue();
        }
        catch(Exception v4_1) {
            Log.e("GOLDEN_INJECTOR", "Transacción Shizuku incierta o fuera de plazo", ((Throwable)v4_1));
            return 0;
        }
    }

    static final Unit execute$lambda$5(IBinder arg2) {
        Object v0 = GoldenInputServiceConnection.connectionMonitor;
        __monitor_enter(v0);
        try {
            if(GoldenInputServiceConnection.remoteBinder == arg2) {
                GoldenInputServiceConnection.remoteBinder = null;
                GoldenInputServiceConnection.connected = false;
                GoldenInputServiceConnection.bindingRequested = false;
                v0.notifyAll();
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        return Unit.INSTANCE;
    }

    static final boolean execute$lambda$6(TouchCommand arg1, IBinder arg2) {
        return GoldenInputServiceConnection.INSTANCE.executeOnBinder(arg1, arg2);
    }

    private final boolean executeOnBinder(TouchCommand arg5, IBinder arg6) {
        Object v2;
        boolean v0 = false;
        if(!this.isConnected()) {
            Log.e("GOLDEN_INJECTOR", "Inyección omitida: UserService no conectado");
            return 0;
        }

        Parcel v4 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v4, "obtain(...)");
        Parcel v1 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v1, "obtain(...)");
        try {
            v4.writeInterfaceToken("com.TryJeanPc.goldenmouse.shizuku.IGoldenInputService");
            v4.writeInt(arg5.getAction().ordinal());
            v4.writeFloat(arg5.getX());
            v4.writeFloat(arg5.getY());
            v4.writeInt(arg5.getPointerId());
            v4.writeLong(arg5.getTimestamp());
            if(arg6.transact(1, v4, v1, 0)) {
                goto label_32;
            }
        }
        catch(Throwable v5) {
            goto label_40;
        }

        v1.recycle();
        v4.recycle();
        return 0;
        try {
        label_32:
            v1.readException();
            int v6 = v1.readInt();
            if(v6 != 1) {
                goto label_36;
            }
        }
        catch(Throwable v5) {
            try {
            label_40:
                v2 = GoldenInputServiceConnection.connectionMonitor;
                __monitor_enter(v2);
            }
            catch(Throwable v5) {
                goto label_61;
            }

            try {
                if(GoldenInputServiceConnection.remoteBinder == (((IBinder)v6))) {
                    GoldenInputServiceConnection.remoteBinder = null;
                    GoldenInputServiceConnection.connected = false;
                    GoldenInputServiceConnection.bindingRequested = false;
                    v2.notifyAll();
                }

                goto label_50;
            }
            catch(Throwable v5) {
                try {
                    __monitor_exit(v2);
                    throw v5;
                label_50:
                    __monitor_exit(v2);
                    Log.e("GOLDEN_INJECTOR", "Falló el envío al UserService", v5);
                }
                catch(Throwable v5) {
                label_61:
                    v1.recycle();
                    v4.recycle();
                    throw v5;
                }
            }

            v1.recycle();
            v4.recycle();
            return 0;
        }

        v0 = true;
    label_36:
        v1.recycle();
        v4.recycle();
        return v0;
    }

    private final UserServiceArgs getUserServiceArgs() {
        return GoldenInputServiceConnection.userServiceArgs$delegate.getValue();
    }

    public final boolean isConnected() {
        if(GoldenInputServiceConnection.connected) {
            IBinder v1 = GoldenInputServiceConnection.remoteBinder;
            if(v1 != null && (v1.isBinderAlive())) {
                return 1;
            }
        }

        return 0;
    }

    static final UserServiceArgs userServiceArgs_delegate$lambda$0() {
        Log.d("GOLDEN_SHIZUKU", "Antes de crear UserServiceArgs");
        Class v3 = GoldenInputService.class;
        UserServiceArgs v0 = new UserServiceArgs(new ComponentName("com.TryJeanPc.goldenmouse", v3.getName())).processNameSuffix("golden_input").tag("golden_input").version(9).debuggable(true).daemon(false);
        Log.d("GOLDEN_SHIZUKU", "UserServiceArgs creado: componente=com.TryJeanPc.goldenmouse/" + v3.getName() + ", version=9, debuggable=true, daemon=false");
        return v0;
    }
}

