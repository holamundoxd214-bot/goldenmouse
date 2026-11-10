package com.TryJeanPc.goldenmouse.controls;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/EditorHitShapes;", "", "<init>", "()V", "Circle", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitShape;", "getCircle", "()Lcom/TryJeanPc/goldenmouse/controls/EditorHitShape;", "Oval", "getOval", "Rectangle", "getRectangle", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class EditorHitShapes {
    public static final int $stable;
    private static final EditorHitShape Circle;
    public static final EditorHitShapes INSTANCE;
    private static final EditorHitShape Oval;
    private static final EditorHitShape Rectangle;

    static {
        EditorHitShapes.INSTANCE = new EditorHitShapes();
        EditorHitShapes.Circle = new EditorHitShapes$$ExternalSyntheticLambda0();
        EditorHitShapes.Oval = new EditorHitShapes$$ExternalSyntheticLambda1();
        EditorHitShapes.Rectangle = new EditorHitShapes$$ExternalSyntheticLambda2();
    }

    private EditorHitShapes() {
        super();
    }

    static final float Circle$lambda$0(float arg4, float arg5, float arg6, float arg7) {
        if(arg6 > 0f) {
            if(arg7 <= 0f) {
            }
            else {
                return RangesKt.coerceAtLeast((((float)Math.hypot(((double)(arg4 - arg6 / 2f)), ((double)(arg5 - arg7 / 2f))))) - Math.min(arg6, arg7) / 2f, 0f);
            }
        }

        return Infinityf;
    }

    static final float Oval$lambda$1(float arg4, float arg5, float arg6, float arg7) {
        if(arg6 > 0f) {
            if(arg7 <= 0f) {
            }
            else {
                float v2 = arg6 / 2f;
                double v2_1 = ((double)((arg4 - v2) / v2));
                arg4 = arg7 / 2f;
                return RangesKt.coerceAtLeast((((float)Math.hypot(v2_1, ((double)((arg5 - arg4) / arg4))))) - 1f, 0f) * Math.min(arg6, arg7) / 2f;
            }
        }

        return Infinityf;
    }

    static final float Rectangle$lambda$2(float arg4, float arg5, float arg6, float arg7) {
        if(arg6 > 0f) {
            if(arg7 <= 0f) {
            }
            else {
                arg6 /= 2f;
                arg7 /= 2f;
                return ((float)Math.hypot(((double)RangesKt.coerceAtLeast(Math.abs(arg4 - arg6) - arg6, 0f)), ((double)RangesKt.coerceAtLeast(Math.abs(arg5 - arg7) - arg7, 0f))));
            }
        }

        return Infinityf;
    }

    public final EditorHitShape getCircle() {
        return EditorHitShapes.Circle;
    }

    public final EditorHitShape getOval() {
        return EditorHitShapes.Oval;
    }

    public final EditorHitShape getRectangle() {
        return EditorHitShapes.Rectangle;
    }
}

