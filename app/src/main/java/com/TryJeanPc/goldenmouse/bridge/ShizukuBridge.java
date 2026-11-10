package com.TryJeanPc.goldenmouse.bridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import rikka.shizuku.Shizuku$OnRequestPermissionResultListener;
import rikka.shizuku.Shizuku;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001A\u00020\nJ\u0006\u0010\u000B\u001A\u00020\nJ\u0006\u0010\f\u001A\u00020\u0007J\u000E\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\u000FJ\u001A\u0010\u0010\u001A\u00020\u00112\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u0013J\u000E\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\u000FR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/bridge/ShizukuBridge;", "", "<init>", "()V", "REQUEST_CODE", "", "SHIZUKU_PACKAGE", "", "TUTORIAL_URL", "servidorActivo", "", "permisoConcedido", "modoServidor", "abrirShizuku", "context", "Landroid/content/Context;", "solicitarPermiso", "", "onResultado", "Lkotlin/Function1;", "abrirTutorial", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ShizukuBridge {
    public static final int $stable = 0;
    public static final ShizukuBridge INSTANCE = null;
    private static final int REQUEST_CODE = 2001;
    private static final String SHIZUKU_PACKAGE = "moe.shizuku.privileged.api";
    private static final String TUTORIAL_URL = "https://shizuku.rikka.app/guide/setup/";

    static {
        ShizukuBridge.INSTANCE = new ShizukuBridge();
    }

    private ShizukuBridge() {
        super();
    }

    public final boolean abrirShizuku(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        boolean v2 = false;
        try {
            Intent v0 = arg3.getPackageManager().getLaunchIntentForPackage("moe.shizuku.privileged.api");
            if(v0 == null) {
                return 0;
            }

            arg3.startActivity(v0);
            return true;
        }
        catch(Exception ) {
            return v2;
        }
    }

    public final void abrirTutorial(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        try {
            arg3.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://shizuku.rikka.app/guide/setup/")));
            return;
        }
        catch(Exception ) {
            return;
        }
    }

    public final String modoServidor() {
        String v0 = "UID ";
        if(!this.servidorActivo()) {
            return "APAGADO";
        }

        try {
            int v2 = Shizuku.getUid();
            if(v2 != 0) {
                if(v2 != 2000) {
                    return v0 + Shizuku.getUid();
                }

                return "ADB";
            }

            return "ROOT";
        }
        catch(Exception ) {
            return "DESCONOCIDO";
        }
    }

    public final boolean permisoConcedido() {
        if(!this.servidorActivo()) {
            return 0;
        }

        try {
            if(Shizuku.checkSelfPermission() != 0) {
                return 0;
            }
        }
        catch(Exception ) {
            return 0;
        }

        return 1;
    }

    public final boolean servidorActivo() {
        try {
            return Shizuku.pingBinder();
        }
        catch(Exception ) {
            return 0;
        }
    }

    public final void solicitarPermiso(Function1 arg5) {
        Object v0_2;
        Intrinsics.checkNotNullParameter(arg5, "onResultado");
        boolean v0 = this.servidorActivo();
        Boolean v1 = Boolean.valueOf(false);
        if(!v0) {
            arg5.invoke(v1);
            return;
        }

        if(this.permisoConcedido()) {
            arg5.invoke(Boolean.valueOf(true));
            return;
        }

        if(Shizuku.isPreV11()) {
            arg5.invoke(v1);
            return;
        }

        if(Shizuku.shouldShowRequestPermissionRationale()) {
            arg5.invoke(v1);
            return;
        }

        ObjectRef v4 = new ObjectRef();
        v4.element = new ShizukuBridge$$ExternalSyntheticLambda1(v4, arg5);
        OnRequestPermissionResultListener v2 = null;
        String v3 = "listener";
        if(v4.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v3);
            OnRequestPermissionResultListener v0_1 = v2;
        }
        else {
            v0_2 = v4.element;
        }

        Shizuku.addRequestPermissionResultListener(((OnRequestPermissionResultListener)v0_2));
        int v0_3 = 2001;
        try {
            Shizuku.requestPermission(v0_3);
            return;
        }
        catch(Exception ) {
            if(v4.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
            }
            else {
                Object v2_1 = v4.element;
            }

            Shizuku.removeRequestPermissionResultListener(v2);
            arg5.invoke(v1);
            return;
        }
    }

    static final void solicitarPermiso$lambda$1(ObjectRef arg1, Function1 arg2, int arg3, int arg4) {
        OnRequestPermissionResultListener v1;
        if(arg3 != 2001) {
            return;
        }

        if(arg1.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            v1 = null;
        }
        else {
            Object v1_1 = arg1.element;
        }

        Shizuku.removeRequestPermissionResultListener(v1);
        boolean v1_2 = arg4 == 0 ? true : false;
        new Handler(Looper.getMainLooper()).post(new ShizukuBridge$$ExternalSyntheticLambda0(arg2, v1_2));
    }

    static final void solicitarPermiso$lambda$1$lambda$0(Function1 arg0, boolean arg1) {
        arg0.invoke(Boolean.valueOf(arg1));
    }
}

