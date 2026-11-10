package com.google.android.material.carousel;

import androidx.core.math.MathUtils;

final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    int mediumCount;
    float mediumSize;
    final int priority;
    int smallCount;
    float smallSize;

    Arrangement(int arg1, float arg2, float arg3, float arg4, int arg5, float arg6, int arg7, float arg8, int arg9, float arg10) {
        super();
        this.priority = arg1;
        this.smallSize = MathUtils.clamp(arg2, arg3, arg4);
        this.smallCount = arg5;
        this.mediumSize = arg6;
        this.mediumCount = arg7;
        this.largeSize = arg8;
        this.largeCount = arg9;
        this.fit(arg10, arg3, arg4, arg8);
        this.cost = this.cost(arg8);
    }

    private float calculateLargeSize(float arg1, int arg2, float arg3, int arg4, int arg5) {
        float v0 = ((float)arg2);
        float v2 = (((float)arg4)) / 2f;
        return (arg1 - (v0 + v2) * 0f) / ((((float)arg5)) + v2);
    }

    private float cost(float arg2) {
        if(!this.isValid()) {
            return 3.402823E+38f;
        }

        return Math.abs(arg2 - this.largeSize) * (((float)this.priority));
    }

    static Arrangement findLowestCostArrangement(float arg22, float arg23, float arg24, float arg25, int[] arg26, float arg27, int[] arg28, float arg29, int[] arg30) {
        int v19;
        int[] v0 = arg26;
        int[] v1 = arg28;
        int[] v2 = arg30;
        int v3 = v2.length;
        Arrangement v4 = null;
        int v5 = 1;
        int v7;
        for(v7 = 0; v7 < v3; ++v7) {
            int v17 = v2[v7];
            int v8 = v1.length;
            int v9 = 0;
            while(v9 < v8) {
                int v15 = v1[v9];
                int v10 = v0.length;
                int v11 = 0;
                while(v11 < v10) {
                    int v14 = v9;
                    v9 = v5;
                    v5 = v14;
                    int v20 = v10;
                    int v21 = v11;
                    v19 = v8;
                    Arrangement v8_1 = new Arrangement(v9, arg23, arg24, arg25, v0[v11], arg27, v15, arg29, v17, arg22);
                    if(v4 == null || v8_1.cost < v4.cost) {
                        if(v8_1.cost == 0f) {
                            return v8_1;
                        }
                        else {
                            v4 = v8_1;
                        }
                    }

                    v8 = v9 + 1;
                    v11 = v21 + 1;
                    v9 = v5;
                    v5 = v8;
                    v8 = v19;
                    v10 = v20;
                }

                v19 = v9;
                v9 = v5;
                v5 = v19;
                v19 = v8;
                v8 = v9;
                v9 = v5 + 1;
                v5 = v8;
                v8 = v19;
            }
        }

        return v4;
    }

    private void fit(float arg10, float arg11, float arg12, float arg13) {
        float v0 = arg10 - this.getSpace();
        int v1 = this.smallCount;
        if(v1 > 0 && v0 > 0f) {
            this.smallSize += Math.min(v0 / (((float)v1)), arg12 - this.smallSize);
        }
        else if(v1 > 0 && v0 < 0f) {
            this.smallSize += Math.max(v0 / (((float)v1)), arg11 - this.smallSize);
        }

        int v5 = this.smallCount;
        float v6 = v5 > 0 ? this.smallSize : 0f;
        this.smallSize = v6;
        Arrangement v3 = this;
        float v9 = v3.calculateLargeSize(arg10, v5, v6, this.mediumCount, this.largeCount);
        v3.largeSize = v9;
        arg10 = (v3.smallSize + v9) / 2f;
        v3.mediumSize = arg10;
        int v11 = v3.mediumCount;
        if(v11 > 0 && v9 != arg13) {
            arg13 = (arg13 - v9) * (((float)v3.largeCount));
            v9 = Math.min(Math.abs(arg13), arg10 * 0.1f * (((float)v11)));
            int v10 = Float.compare(arg13, 0f);
            arg11 = v3.mediumSize;
            if(v10 > 0) {
                v3.mediumSize = arg11 - v9 / (((float)v3.mediumCount));
                v3.largeSize += v9 / (((float)v3.largeCount));
                return;
            }
            else {
                v3.mediumSize = arg11 + v9 / (((float)v3.mediumCount));
                v3.largeSize -= v9 / (((float)v3.largeCount));
            }
        }
    }

    int getItemCount() {
        return this.smallCount + this.mediumCount + this.largeCount;
    }

    private float getSpace() {
        return this.largeSize * (((float)this.largeCount)) + this.mediumSize * (((float)this.mediumCount)) + this.smallSize * (((float)this.smallCount));
    }

    private boolean isValid() {
        int v0 = this.largeCount;
        if(v0 > 0 && this.smallCount > 0 && this.mediumCount > 0) {
            float v0_1 = this.largeSize;
            float v3 = this.mediumSize;
            if(v0_1 > v3 && v3 > this.smallSize) {
                return 1;
            }

            return 0;
        }

        if(v0 > 0 && this.smallCount > 0) {
            if(this.largeSize > this.smallSize) {
                return 1;
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public String toString() {
        return "Arrangement [priority=" + this.priority + ", smallCount=" + this.smallCount + ", smallSize=" + this.smallSize + ", mediumCount=" + this.mediumCount + ", mediumSize=" + this.mediumSize + ", largeCount=" + this.largeCount + ", largeSize=" + this.largeSize + ", cost=" + this.cost + "]";
    }
}

