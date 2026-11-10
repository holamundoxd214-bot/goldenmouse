package com.TryJeanPc.goldenmouse.engine;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0015\b\u0001\u0018\u00002\u00020\u0001:\u0001%BM\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\t\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B\u0012\u0006\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u0006\u0010\u001C\u001A\u00020\tJ\u0016\u0010\u001D\u001A\u00020\t2\u0006\u0010\u001E\u001A\u00020\u00112\u0006\u0010\u001F\u001A\u00020\u0011J\u0006\u0010 \u001A\u00020\tJ\b\u0010!\u001A\u00020\tH\u0002J\b\u0010\"\u001A\u00020\tH\u0002J\u0018\u0010#\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010$\u001A\u00020\u0011H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0017\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u0011@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u001E\u0010\u001A\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u0011@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0019¨\u0006&"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/FreeLookGesture;", "", "centerX", "", "centerY", "width", "height", "sensitivity", "resetOnEdge", "", "jitter", "Lkotlin/Function0;", "touch", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookGesture$Touch;", "<init>", "(IIIIIZLkotlin/jvm/functions/Function0;Lcom/TryJeanPc/goldenmouse/engine/FreeLookGesture$Touch;)V", "right", "", "bottom", "gain", "enabled", "contact", "value", "x", "getX", "()F", "y", "getY", "start", "move", "dx", "dy", "stop", "beginContact", "endContact", "clamp", "maximum", "Touch", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class FreeLookGesture {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H&J\u0018\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H&J\u0018\u0010\b\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H&¨\u0006\tÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/FreeLookGesture$Touch;", "", "down", "", "x", "", "y", "move", "up", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface Touch {
        boolean down(float arg1, float arg2);

        boolean move(float arg1, float arg2);

        boolean up(float arg1, float arg2);
    }

    public static final int $stable = 8;
    private final float bottom;
    private final int centerX;
    private final int centerY;
    private boolean contact;
    private boolean enabled;
    private final float gain;
    private final Function0 jitter;
    private final boolean resetOnEdge;
    private final float right;
    private final Touch touch;
    private float x;
    private float y;

    static {
    }

    public FreeLookGesture(int arg2, int arg3, int arg4, int arg5, int arg6, boolean arg7, Function0 arg8, Touch arg9) {
        Intrinsics.checkNotNullParameter(arg8, "jitter");
        Intrinsics.checkNotNullParameter(arg9, "touch");
        super();
        this.centerX = arg2;
        this.centerY = arg3;
        this.resetOnEdge = arg7;
        this.jitter = arg8;
        this.touch = arg9;
        this.right = ((float)Math.max(arg4, arg5));
        this.bottom = ((float)Math.min(arg4, arg5));
        this.gain = (((float)arg6)) / 500f;
        if(arg4 > 0 && arg5 > 0 && 50 <= arg6 && arg6 < 1001) {
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final boolean beginContact() {
        this.x = this.clamp((((float)this.centerX)) + this.jitter.invoke().floatValue(), this.right);
        float v0 = this.clamp((((float)this.centerY)) + this.jitter.invoke().floatValue(), this.bottom);
        this.y = v0;
        boolean v0_1 = this.touch.down(this.x, v0);
        this.contact = v0_1;
        if(!v0_1) {
            this.enabled = false;
        }

        return v0_1;
    }

    private final float clamp(float arg1, float arg2) {
        return Math.max(0f, Math.min(arg2, arg1));
    }

    private final boolean endContact() {
        boolean v0 = this.touch.up(this.x, this.y);
        if(v0) {
            this.contact = false;
            return v0;
        }

        this.enabled = false;
        return v0;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final boolean move(float arg5, float arg6) {
        if(!this.enabled) {
            return 1;
        }

        float v2 = 3.402823E+38f;
        if(Float.compare(Math.abs(arg5), v2) <= 0 && Math.abs(arg6) <= v2) {
            arg5 *= this.gain;
            arg6 *= this.gain;
            v2 = 0.0001f;
            if(Math.abs(arg5) < v2 && Math.abs(arg6) < v2) {
                return 1;
            }

            if(!this.contact) {
                return this.beginContact();
            }

            float v0 = this.x + arg5;
            this.x = v0;
            arg5 = this.y + arg6;
            this.y = arg5;
            if(!this.resetOnEdge) {
                this.x = this.clamp(v0, this.right);
                arg5 = this.clamp(this.y, this.bottom);
                this.y = arg5;
            }
            else {
                if(v0 >= 0f && v0 <= this.right && arg5 >= 0f) {
                    if(arg5 > this.bottom) {
                    }
                    else {
                        goto label_48;
                    }
                }

                goto label_54;
            }

        label_48:
            boolean v5 = this.touch.move(this.x, arg5);
            if(!v5) {
                this.enabled = false;
            }

            return v5;
        label_54:
            return this.endContact();
        }

        return 0;
    }

    public final boolean start() {
        if(this.enabled) {
            return 1;
        }

        this.enabled = true;
        return this.beginContact();
    }

    public final boolean stop() {
        this.enabled = false;
        if(this.contact) {
            if(this.endContact()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

