package com.TryJeanPc.goldenmouse.controls;

import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\b\u0010\u0004\u001A\u00020\u0005H&J\b\u0010\u0006\u001A\u00020\u0005H&J\b\u0010\u0007\u001A\u00020\bH&J\u001F\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000E¨\u0006\u000FÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/ControlVisual;", "", "obtenerTipo", "", "seleccionar", "", "deseleccionar", "obtenerEstado", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisualState;", "aplicarEstiloVisual", "escala", "", "colorTema", "", "(FLjava/lang/Integer;)V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface ControlVisual {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static void aplicarEstiloVisual(ControlVisual arg0, float arg1, Integer arg2) {
            arg0.aplicarEstiloVisual(arg1, arg2);
        }
    }

    static void access$aplicarEstiloVisual$jd(ControlVisual arg0, float arg1, Integer arg2) {
        super.aplicarEstiloVisual(arg1, arg2);
    }

    default void aplicarEstiloVisual(float arg1, Integer arg2) {
    }

    void deseleccionar();

    ControlVisualState obtenerEstado();

    String obtenerTipo();

    void seleccionar();
}

