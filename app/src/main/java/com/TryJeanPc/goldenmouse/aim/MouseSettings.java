package com.TryJeanPc.goldenmouse.aim;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/MouseSettings;", "", "<init>", "()V", "sensibilidadX", "", "getSensibilidadX", "()F", "setSensibilidadX", "(F)V", "sensibilidadY", "getSensibilidadY", "setSensibilidadY", "cambiarSensibilidad", "", "x", "y", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseSettings {
    public static final int $stable;
    public static final MouseSettings INSTANCE;
    private static float sensibilidadX;
    private static float sensibilidadY;

    static {
        MouseSettings.INSTANCE = new MouseSettings();
        MouseSettings.sensibilidadX = 2f;
        MouseSettings.sensibilidadY = 2f;
        MouseSettings.$stable = 8;
    }

    private MouseSettings() {
        super();
    }

    public final void cambiarSensibilidad(float arg1, float arg2) {
        MouseSettings.sensibilidadX = arg1;
        MouseSettings.sensibilidadY = arg2;
    }

    public final float getSensibilidadX() {
        return MouseSettings.sensibilidadX;
    }

    public final float getSensibilidadY() {
        return MouseSettings.sensibilidadY;
    }

    public final void setSensibilidadX(float arg1) {
        MouseSettings.sensibilidadX = arg1;
    }

    public final void setSensibilidadY(float arg1) {
        MouseSettings.sensibilidadY = arg1;
    }
}

