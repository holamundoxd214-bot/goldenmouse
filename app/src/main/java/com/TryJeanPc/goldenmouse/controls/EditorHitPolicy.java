package com.TryJeanPc.goldenmouse.controls;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0005J/\u0010\b\u001A\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0012\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\f0\u000B2\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0002\u0010\u000F¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/EditorHitPolicy;", "", "<init>", "()V", "touchTolerance", "", "visibleSize", "minimumTarget", "resolve", "T", "candidates", "", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitCandidate;", "precise", "", "(Ljava/util/List;Z)Ljava/lang/Object;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class EditorHitPolicy {
    public static final int $stable;
    public static final EditorHitPolicy INSTANCE;

    static {
        EditorHitPolicy.INSTANCE = new EditorHitPolicy();
    }

    private EditorHitPolicy() {
        super();
    }

    public final Object resolve(List arg8, boolean arg9) {
        int v4;
        Intrinsics.checkNotNullParameter(arg8, "candidates");
        Iterator v7 = arg8.iterator();
        Object v8 = null;
        float v0 = Infinityf;
        int v1;
        for(v1 = 0x7FFFFFFF; v7.hasNext(); v1 = v4) {
            Object v2 = v7.next();
            float v3 = ((EditorHitCandidate)v2).getDistance();
            float v5 = 3.402823E+38f;
            if(Math.abs(v3) > v5) {
                continue;
            }

            int v6 = Float.compare(v3, 0f);
            if(v6 < 0) {
                continue;
            }

            if(v3 > 0f) {
                if(arg9) {
                    continue;
                }

                if(Math.abs(((EditorHitCandidate)v2).getTolerance()) > v5) {
                    continue;
                }

                if(v3 > ((EditorHitCandidate)v2).getTolerance()) {
                    continue;
                }
            }

            if(v6 != 0) {
                v4 = 2;
            }
            else if(((EditorHitCandidate)v2).getVisible()) {
                v4 = 0;
            }
            else {
                v4 = 1;
            }

            if(v4 >= v1) {
                if(v4 != v1) {
                    continue;
                }

                if(v3 < v0) {
                    goto label_36;
                }

                continue;
            }

        label_36:
            v8 = ((EditorHitCandidate)v2).getTarget();
            v0 = v3;
        }

        return v8;
    }

    public final float touchTolerance(float arg1, float arg2) {
        return RangesKt.coerceAtLeast((arg2 - arg1) / 2f, 0f);
    }
}

