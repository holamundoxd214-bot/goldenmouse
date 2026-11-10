package com.TryJeanPc.goldenmouse.bridge;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import rikka.shizuku.Shizuku$OnRequestPermissionResultListener;

public final class ShizukuBridge$$ExternalSyntheticLambda1 implements OnRequestPermissionResultListener {
    public ShizukuBridge$$ExternalSyntheticLambda1(ObjectRef arg1, Function1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onRequestPermissionResult(int arg2, int arg3) {
        ShizukuBridge.solicitarPermiso$lambda$1(this.f$0, this.f$1, arg2, arg3);
    }
}

