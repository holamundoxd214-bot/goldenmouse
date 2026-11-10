package com.TryJeanPc.goldenmouse;

import android.content.Context;
import kotlin.jvm.functions.Function0;

public final class PermissionRequirements$$ExternalSyntheticLambda0 implements Function0 {
    public PermissionRequirements$$ExternalSyntheticLambda0(Context arg1, PermissionSettings arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return Boolean.valueOf(PermissionRequirements.registry$action$lambda$0(this.f$0, this.f$1));
    }
}

