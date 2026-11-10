package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.mapper.GameAction;
import com.TryJeanPc.goldenmouse.mapper.MappedControlBinding;
import com.TryJeanPc.goldenmouse.profile.JoystickComponent;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001A\u00020\u000BJ$\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u0010¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/JoystickVectorPolicy;", "", "<init>", "()V", "vector", "Lkotlin/Pair;", "", "directions", "", "Lcom/TryJeanPc/goldenmouse/mapper/GameAction;", "settings", "Lcom/TryJeanPc/goldenmouse/profile/JoystickComponent;", "target", "state", "Lcom/TryJeanPc/goldenmouse/engine/JoystickRuntimeState;", "activation", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class JoystickVectorPolicy {
    public static final int $stable;
    public static final JoystickVectorPolicy INSTANCE;

    static {
        JoystickVectorPolicy.INSTANCE = new JoystickVectorPolicy();
    }

    private JoystickVectorPolicy() {
        super();
    }

    public final Pair target(JoystickRuntimeState arg24, boolean arg25) {
        JoystickRuntimeState v1 = arg24;
        Intrinsics.checkNotNullParameter(v1, "state");
        MappedControlBinding v0 = v1.getBinding();
        JoystickComponent v2 = v0.getJoystick();
        if(v2 == null) {
            v2 = new JoystickComponent(0f, 0f, 0f, 0f, 0f, 0f, 0, 0f, false, 0f, 0, false, null, 0f, false, 0x7FFF, null);
        }

        Pair v3 = this.vector(v1.getDirections(), v2);
        float v4 = v3.component1().floatValue();
        float v3_1 = v3.component2().floatValue();
        float v5 = v1.getActivationPending() ? v0.getJoystickInitialRadius() : v0.getJoystickRadius();
        float v6 = 1f;
        float v7 = arg25 ? RangesKt.coerceIn(v2.getActivationSpeed(), 0.1f, 4f) : v6;
        if((v2.getSprintEnabled()) && (v1.getSprintPressed())) {
            v6 = v2.getSprintExpansion();
        }

        float v1_1 = RangesKt.coerceAtMost(v5 * v7 * v6, Math.min(v0.getWidth(), v0.getHeight()) / 2f);
        return TuplesKt.to(Float.valueOf(v0.getCenterX() + v4 * v1_1), Float.valueOf(v0.getCenterY() + v3_1 * v1_1));
    }

    public static Pair target$default(JoystickVectorPolicy arg0, JoystickRuntimeState arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.target(arg1, false);
    }

    public final Pair vector(Set arg5, JoystickComponent arg6) {
        Intrinsics.checkNotNullParameter(arg5, "directions");
        Intrinsics.checkNotNullParameter(arg6, "settings");
        float v4 = JoystickVectorPolicy.vector$axis(arg5, arg6, GameAction.MOVE_LEFT, GameAction.MOVE_RIGHT);
        float v5 = JoystickVectorPolicy.vector$axis(arg5, arg6, GameAction.MOVE_FORWARD, GameAction.MOVE_BACKWARD);
        if(v4 == 0f) {
        }
        else {
            if(v5 == 0f) {
                goto label_14;
            }

            goto label_18;
        }

    label_14:
        return TuplesKt.to(Float.valueOf(v4), Float.valueOf(v5));
    label_18:
        if(arg6.getDiagonalAngleDeg() == 45f) {
            return TuplesKt.to(Float.valueOf(v4 / (((float)Math.sqrt(2)))), Float.valueOf(v5 / (((float)Math.sqrt(2)))));
        }

        double v0 = Math.toRadians(((double)arg6.getDiagonalAngleDeg()));
        return TuplesKt.to(Float.valueOf(v4 * (((float)Math.cos(v0)))), Float.valueOf(v5 * (((float)Math.sin(v0)))));
    }

    private static final float vector$axis(Set arg5, JoystickComponent arg6, GameAction arg7, GameAction arg8) {
        float v1 = -1f;
        float v3 = 1f;
        if((arg5.contains(arg7)) && (arg5.contains(arg8))) {
            if(arg6.getSocdEnabled()) {
                return 0;
            }
            else {
                Iterator v5 = ((Iterable)arg5).iterator();
                GameAction v6 = null;
                int v0 = 0;
                while(v5.hasNext()) {
                    Object v2 = v5.next();
                    Object v4 = v2;
                    if((((GameAction)v4)) != arg7 && (((GameAction)v4)) != arg8) {
                        continue;
                    }

                    v0 = 1;
                    Object v6_1 = v2;
                }

                if(v0 != 0) {
                    if(v6 == arg8) {
                        return v3;
                    }

                    return v1;
                }

                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }

        if(arg5.contains(arg8)) {
            return v3;
        }

        if(arg5.contains(arg7)) {
            return v1;
        }

        return 0;
    }
}

