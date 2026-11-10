package com.TryJeanPc.goldenmouse.gamespace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u0005J\u000E\u0010\r\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u0005J\u0016\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005J\u0016\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0012J\u0016\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0014\u001A\u00020\u0012J\u0016\u0010\u0018\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u0005J\u001C\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00120\u001C2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0014\u001A\u00020\u0012J6\u0010\u001D\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u001F\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u0012J*\u0010 \u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050!2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u0005J\u001E\u0010#\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u00052\u0006\u0010$\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/CarouselGeometry;", "", "<init>", "()V", "WIDTH", "", "HEIGHT", "CARD_WIDTH", "CARD_HEIGHT", "CARD_CENTER_Y", "GAP", "scale", "offset", "rotation", "fit", "width", "height", "wrap", "", "index", "count", "wrapPosition", "", "position", "sideStride", "viewportWidth", "cardWidth", "layoutSlots", "", "cardLeft", "stride", "sceneScale", "projectedEdges", "Lkotlin/Pair;", "left", "translation", "cameraDistance", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class CarouselGeometry {
    public static final int $stable = 0;
    public static final float CARD_CENTER_Y = 550f;
    public static final float CARD_HEIGHT = 570f;
    public static final float CARD_WIDTH = 1056f;
    public static final float GAP = 54f;
    public static final float HEIGHT = 1080f;
    public static final CarouselGeometry INSTANCE = null;
    public static final float WIDTH = 2340f;

    static {
        CarouselGeometry.INSTANCE = new CarouselGeometry();
    }

    private CarouselGeometry() {
        super();
    }

    public final float cardLeft(float arg5, float arg6, float arg7, float arg8, float arg9, int arg10) {
        float v1 = 2f;
        float v2 = 1728f * arg9;
        float v0 = (arg6 - arg7) / v1 + arg8 * arg5 + this.translation(arg5, arg7, v2);
        if(arg10 == 3) {
            float v3 = 1f;
            if(Math.abs(arg5) > v3) {
                arg6 = RangesKt.coerceAtLeast((arg6 + arg7) / v1 + arg9 * 18f - arg8 * 1.5f - this.translation(1.5f, arg7, v2), 0f);
                float v4 = RangesKt.coerceIn((Math.abs(arg5) - v3) / 0.5f, 0f, v3);
                v0 += Math.signum(arg5) * arg6 * v4 * v4;
            }
        }

        return v0;
    }

    public final float fit(float arg1, float arg2) {
        return Math.min(arg1 / 2340f, arg2 / 1080f);
    }

    public final List layoutSlots(double arg9, int arg11) {
        Object v1;
        if(arg11 == 0) {
            return CollectionsKt.emptyList();
        }

        if(arg11 < 3) {
            return CollectionsKt.toList(RangesKt.until(0, arg11));
        }

        int v8 = ((int)Math.floor(0.5 + arg9));
        IntRange v0 = new IntRange(v8 - 2, v8 + 2);
        LinkedHashMap v8_1 = new LinkedHashMap();
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            v1 = v0_1.next();
            Integer v2 = Integer.valueOf(CarouselGeometry.INSTANCE.wrap(v1.intValue(), arg11));
            Object v3 = ((Map)v8_1).get(v2);
            if(v3 == null) {
                ArrayList v3_1 = new ArrayList();
                ((Map)v8_1).put(v2, v3_1);
            }

            ((List)v3).add(v1);
        }

        Collection v8_2 = ((Map)v8_1).values();
        ArrayList v11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v8_2), 10));
        Iterator v8_3 = ((Iterable)v8_2).iterator();
        while(true) {
            if(!v8_3.hasNext()) {
                goto label_75;
            }

            v0_1 = v8_3.next().iterator();
            if(!v0_1.hasNext()) {
                break;
            }

            v1 = v0_1.next();
            if(!v0_1.hasNext()) {
            }
            else {
                double v2_1 = Math.abs((((double)v1.intValue())) - arg9);
                do {
                    Object v4 = v0_1.next();
                    double v5 = Math.abs((((double)v4.intValue())) - arg9);
                    if(Double.compare(v2_1, v5) > 0) {
                        v1 = v4;
                        v2_1 = v5;
                    }

                    if(v0_1.hasNext()) {
                        continue;
                    }

                    break;
                }
                while(true);
            }

            ((Collection)v11).add(Integer.valueOf(((Number)v1).intValue()));
        }

        throw new NoSuchElementException();
    label_75:
        return ((List)v11);
    }

    public final Pair projectedEdges(float arg7, float arg8, float arg9) {
        double v0 = Math.toRadians(((double)Math.abs(this.rotation(arg7))));
        float v6 = ((float)((((double)(this.scale(arg7) * arg9))) * Math.cos(v0) / (1056 * Math.sin(v0) / 1728 + 1)));
        if(arg7 > 0f) {
            return TuplesKt.to(Float.valueOf(arg8), Float.valueOf(arg8 + v6));
        }

        arg8 += arg9;
        return TuplesKt.to(Float.valueOf(arg8 - v6), Float.valueOf(arg8));
    }

    public final float rotation(float arg1) {
        return arg1 * 33f;
    }

    public final float scale(float arg3) {
        float v2 = Math.abs(arg3);
        arg3 = 1f;
        if(v2 <= arg3) {
        }
        else {
            v2 += (v2 - arg3) * 2.5f;
        }

        return ((float)Math.pow(0.89, ((double)v2)));
    }

    public final float sideStride(float arg6, float arg7) {
        double v1 = Math.toRadians(((double)this.rotation(1f)));
        return (arg6 + arg7) / 2f - this.scale(1f) * arg7 * (((float)Math.cos(v1))) / ((((float)Math.sin(v1))) * 1056f / 1728f + 1f);
    }

    public final float translation(float arg15, float arg16, float arg17) {
        float v0 = arg17;
        float v2 = 1f;
        float v1 = Math.abs(arg15) - v2;
        float v4 = 0f;
        while(v1 > 0f) {
            float v5 = this.scale(v1) * arg16;
            double v6 = Math.toRadians(((double)Math.abs(this.rotation(v1))));
            v4 += arg16 - (((float)((((double)(v0 * v5))) * Math.cos(v6) / ((((double)v0)) + (((double)v5)) * Math.sin(v6)))));
            v1 -= v2;
        }

        return -Math.signum(arg15) * v4;
    }

    public final int wrap(int arg1, int arg2) {
        return Math.floorMod(arg1, arg2);
    }

    public final double wrapPosition(double arg3, int arg5) {
        double v0 = ((double)arg5);
        return (arg3 % v0 + v0) % v0;
    }
}

