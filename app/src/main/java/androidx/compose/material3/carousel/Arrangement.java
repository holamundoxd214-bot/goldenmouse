package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0001\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u0015\u001A\u00020\u0016H\u0002J\u0010\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u0005H\u0002J\u0006\u0010\u0019\u001A\u00020\u0003R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000ER\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000ER\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0010¨\u0006\u001B"}, d2={"Landroidx/compose/material3/carousel/Arrangement;", "", "priority", "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "<init>", "(IFIFIFI)V", "getSmallSize", "()F", "getSmallCount", "()I", "getMediumSize", "getMediumCount", "getLargeSize", "getLargeCount", "isValid", "", "cost", "targetLargeSize", "itemCount", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Arrangement {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JX\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u000EJ`\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u0005H\u0002J0\u0010\u001C\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u001A\u001A\u00020\u0015H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "<init>", "()V", "MediumItemFlexPercentage", "", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "availableSpace", "itemSpacing", "targetSmallSize", "minSmallSize", "maxSmallSize", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", "priority", "", "smallCount", "smallSize", "mediumCount", "mediumSize", "largeCount", "largeSize", "calculateLargeSize", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        private final float calculateLargeSize(float arg1, int arg2, float arg3, int arg4, int arg5) {
            float v0 = ((float)arg2);
            float v2 = (((float)arg4)) / 2f;
            return (arg1 - (v0 + v2) * arg3) / ((((float)arg5)) + v2);
        }

        public final Arrangement findLowestCostArrangement(float arg23, float arg24, float arg25, float arg26, float arg27, int[] arg28, float arg29, int[] arg30, float arg31, int[] arg32) {
            int[] v0 = arg28;
            int[] v1 = arg30;
            int[] v14 = arg32;
            int v15 = v14.length;
            Arrangement v2 = null;
            int v3 = 1;
            int v4 = 0;
            while(v4 < v15) {
                int v12 = v14[v4];
                int v5 = v1.length;
                int v6 = 0;
                while(v6 < v5) {
                    int v10 = v1[v6];
                    int v7 = v0.length;
                    int v8 = 0;
                    while(v8 < v7) {
                        int v9 = v6;
                        v6 = v0[v8];
                        float v13 = arg31;
                        Arrangement v0_1 = v2;
                        int v17 = v4;
                        int v18 = v5;
                        int v20 = v7;
                        int v21 = v8;
                        int v19 = v9;
                        Arrangement v6_1 = this.fit(v3, arg23, arg24, v6, arg25, arg26, arg27, v10, arg29, v12, v13);
                        if(v0_1 != null && v6_1.cost(v13) >= v0_1.cost(v13)) {
                            v2 = v0_1;
                        }
                        else if(v6_1.cost(v13) == 0f) {
                            return v6_1;
                        }
                        else {
                            v2 = v6_1;
                        }

                        ++v3;
                        v8 = v21 + 1;
                        v0 = arg28;
                        v4 = v17;
                        v5 = v18;
                        v6 = v19;
                        v7 = v20;
                    }

                    ++v6;
                    v0 = arg28;
                }

                ++v4;
                v0 = arg28;
            }

            return v2;
        }

        private final Arrangement fit(int arg9, float arg10, float arg11, int arg12, float arg13, float arg14, float arg15, int arg16, float arg17, int arg18, float arg19) {
            int v4 = arg16;
            int v5 = arg18;
            float v1 = arg10 - (((float)(v5 + v4 + arg12 - 1))) * arg11;
            arg10 = RangesKt.coerceIn(arg13, arg14, arg15);
            arg11 = ((float)v5);
            float v6 = ((float)v4);
            float v2 = ((float)arg12);
            float v0 = v1 - (arg19 * arg11 + arg17 * v6 + arg10 * v2);
            if(arg12 > 0 && v0 > 0f) {
                v0 = Math.min(v0 / v2, arg15 - arg10);
                goto label_24;
            }
            else if(arg12 > 0 && v0 < 0f) {
                v0 = Math.max(v0 / v2, arg14 - arg10);
            label_24:
                arg10 += v0;
            }

            float v3 = arg12 > 0 ? arg10 : 0f;
            float v8 = this.calculateLargeSize(v1, arg12, v3, v4, v5);
            v2 = v3;
            v3 = (v8 + v2) / 2f;
            if(arg16 > 0) {
                if(v8 == arg19) {
                }
                else {
                    arg10 = (arg19 - v8) * arg11;
                    v0 = Math.min(Math.abs(arg10), 0.1f * v3 * v6);
                    if(arg10 > 0f) {
                        v3 -= v0 / v6;
                        v8 += v0 / arg11;
                    }
                    else {
                        v3 += v0 / v6;
                        v8 -= v0 / arg11;
                    }
                }
            }

            return new Arrangement(arg9, v2, arg12, v3, arg16, v8, arg18);
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    static {
        Arrangement.Companion = new Companion(null);
    }

    public Arrangement(int arg1, float arg2, int arg3, float arg4, int arg5, float arg6, int arg7) {
        super();
        this.priority = arg1;
        this.smallSize = arg2;
        this.smallCount = arg3;
        this.mediumSize = arg4;
        this.mediumCount = arg5;
        this.largeSize = arg6;
        this.largeCount = arg7;
    }

    public static final float access$cost(Arrangement arg0, float arg1) {
        return arg0.cost(arg1);
    }

    private final float cost(float arg2) {
        if(!this.isValid()) {
            return 3.402823E+38f;
        }

        return Math.abs(arg2 - this.largeSize) * (((float)this.priority));
    }

    public final int getLargeCount() {
        return this.largeCount;
    }

    public final float getLargeSize() {
        return this.largeSize;
    }

    public final int getMediumCount() {
        return this.mediumCount;
    }

    public final float getMediumSize() {
        return this.mediumSize;
    }

    public final int getSmallCount() {
        return this.smallCount;
    }

    public final float getSmallSize() {
        return this.smallSize;
    }

    private final boolean isValid() {
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

    public final int itemCount() {
        return this.largeCount + this.mediumCount + this.smallCount;
    }
}

