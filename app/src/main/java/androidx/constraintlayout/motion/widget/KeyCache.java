package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

public class KeyCache {
    HashMap map;

    public KeyCache() {
        super();
        this.map = new HashMap();
    }

    float getFloatValue(Object arg3, String arg4, int arg5) {
        float v1 = NaNf;
        if(!this.map.containsKey(arg3)) {
            return v1;
        }

        Object v2 = this.map.get(arg3);
        if(!((HashMap)v2).containsKey(arg4)) {
            return v1;
        }

        v2 = ((HashMap)v2).get(arg4);
        if(v2.length > arg5) {
            return v2[arg5];
        }

        return v1;
    }

    void setFloatValue(Object arg3, String arg4, int arg5, float arg6) {
        float[] v1;
        if(!this.map.containsKey(arg3)) {
            HashMap v0 = new HashMap();
            v1 = new float[arg5 + 1];
            v1[arg5] = arg6;
            v0.put(arg4, v1);
            this.map.put(arg3, v0);
            return;
        }

        Object v0_1 = this.map.get(arg3);
        if(!((HashMap)v0_1).containsKey(arg4)) {
            v1 = new float[arg5 + 1];
            v1[arg5] = arg6;
            ((HashMap)v0_1).put(arg4, v1);
            this.map.put(arg3, v0_1);
            return;
        }

        Object v2 = ((HashMap)v0_1).get(arg4);
        if(v2.length <= arg5) {
            float[] v2_1 = Arrays.copyOf(((float[])v2), arg5 + 1);
        }

        v2[arg5] = arg6;
        ((HashMap)v0_1).put(arg4, v2);
    }
}

