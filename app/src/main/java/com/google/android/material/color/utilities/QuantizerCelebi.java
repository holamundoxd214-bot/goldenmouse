package com.google.android.material.color.utilities;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class QuantizerCelebi {
    private QuantizerCelebi() {
        super();
    }

    public static Map quantize(int[] arg5, int arg6) {
        Set v0 = new QuantizerWu().quantize(arg5, arg6).colorToCount.keySet();
        int[] v1 = new int[v0.size()];
        Iterator v0_1 = v0.iterator();
        int v2;
        for(v2 = 0; v0_1.hasNext(); ++v2) {
            v1[v2] = v0_1.next().intValue();
        }

        return QuantizerWsmeans.quantize(arg5, v1, arg6);
    }
}

