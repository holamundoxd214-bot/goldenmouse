package com.TryJeanPc.goldenmouse.controls;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class VistaActivationCapture$Companion$$ExternalSyntheticBackportWithForwarding0 {
    public static BigDecimal m(BigDecimal arg2) {
        if(arg2.signum() == 0) {
            return new BigDecimal(BigInteger.ZERO, 0);
        }

        return arg2.stripTrailingZeros();
    }

    public static boolean m(AtomicReference arg1, Object arg2, Object arg3) {
        do {
            if(arg1.compareAndSet(arg2, arg3)) {
                return 1;
            }
        }
        while(arg1.get() == arg2);

        return 0;
    }
}

