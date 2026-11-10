package com.TryJeanPc.goldenmouse.controls;

import android.widget.ImageView;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001A\u00020\rH&J\b\u0010\u000E\u001A\u00020\rH&J\u0010\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0011H&J\b\u0010\u0012\u001A\u00020\u0011H&R\u0018\u0010\u0002\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\u0013À\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/BotonEditable;", "", "estaEnModoEdicion", "", "getEstaEnModoEdicion", "()Z", "setEstaEnModoEdicion", "(Z)V", "botonCerrarX", "Landroid/widget/ImageView;", "getBotonCerrarX", "()Landroid/widget/ImageView;", "activarEdicion", "", "desactivarEdicion", "actualizarTecla", "nuevaTecla", "", "obtenerTeclaActual", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface BotonEditable {
    void activarEdicion();

    void actualizarTecla(String arg1);

    void desactivarEdicion();

    ImageView getBotonCerrarX();

    boolean getEstaEnModoEdicion();

    String obtenerTeclaActual();

    void setEstaEnModoEdicion(boolean arg1);
}

