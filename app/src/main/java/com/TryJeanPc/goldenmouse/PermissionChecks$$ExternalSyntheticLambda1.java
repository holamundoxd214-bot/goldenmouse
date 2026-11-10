package com.TryJeanPc.goldenmouse;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.functions.Function1;

public final class PermissionChecks$$ExternalSyntheticLambda1 implements Function1 {
    public PermissionChecks$$ExternalSyntheticLambda1(Context arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return PermissionChecks.openSettings$lambda$7(this.f$0, ((Intent)arg1));
    }
}

