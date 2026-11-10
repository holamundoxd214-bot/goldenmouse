package com.TryJeanPc.goldenmouse.controls;

import com.TryJeanPc.goldenmouse.profile.GameProfileKt;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001A\u0018\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2={"F1_SENSITIVITY_STEP", "", "stepVistaSensitivity", "value", "delta", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class BotonVistaBlueStacksKt {
    private static final float F1_SENSITIVITY_STEP = 0.1f;

    public static final float stepVistaSensitivity(float arg1, float arg2) {
        BigDecimal v1 = new BigDecimal(String.valueOf(GameProfileKt.normalizeViewSensitivity(arg1))).add(new BigDecimal(String.valueOf(arg2)));
        Intrinsics.checkNotNullExpressionValue(v1, "add(...)");
        return v1.max(BigDecimal.ZERO).floatValue();
    }
}

