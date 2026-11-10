package com.google.android.material.color.utilities;

import java.util.LinkedHashMap;
import java.util.Map;

public final class QuantizerMap implements Quantizer {
    Map colorToCount;

    public QuantizerMap() {
        super();
    }

    public Map getColorToCount() {
        return this.colorToCount;
    }

    public QuantizerResult quantize(int[] arg6, int arg7) {
        LinkedHashMap v7 = new LinkedHashMap();
        int v0 = arg6.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            int v2 = arg6[v1];
            Object v3 = ((Map)v7).get(Integer.valueOf(v2));
            int v4 = 1;
            if(v3 == null) {
            }
            else {
                v4 = 1 + ((Integer)v3).intValue();
            }

            ((Map)v7).put(Integer.valueOf(v2), Integer.valueOf(v4));
        }

        this.colorToCount = ((Map)v7);
        return new QuantizerResult(((Map)v7));
    }
}

