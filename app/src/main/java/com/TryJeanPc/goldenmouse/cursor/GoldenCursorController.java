package com.TryJeanPc.goldenmouse.cursor;

import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u0005J\u0006\u0010\r\u001A\u00020\nJ\u0006\u0010\u000E\u001A\u00020\nJ\u0006\u0010\u000F\u001A\u00020\u0005J\u0006\u0010\u0010\u001A\u00020\u0005J\u0006\u0010\u0011\u001A\u00020\bR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/GoldenCursorController;", "", "<init>", "()V", "x", "", "y", "visible", "", "mover", "", "nuevoX", "nuevoY", "mostrar", "ocultar", "obtenerX", "obtenerY", "estaVisible", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenCursorController {
    public static final int $stable = 8;
    private boolean visible;
    private float x;
    private float y;

    static {
    }

    public GoldenCursorController() {
        super();
    }

    public final boolean estaVisible() {
        return this.visible;
    }

    public final void mostrar() {
        this.visible = true;
    }

    public final void mover(float arg1, float arg2) {
        this.x = arg1;
        this.y = arg2;
    }

    public final float obtenerX() {
        return this.x;
    }

    public final float obtenerY() {
        return this.y;
    }

    public final void ocultar() {
        this.visible = false;
    }
}

