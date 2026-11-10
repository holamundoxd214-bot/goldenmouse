package com.TryJeanPc.goldenmouse.graphicsui;

import com.TryJeanPc.goldenmouse.graphics.GraphicsStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001A6\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001A\u00020\u0003H\u0000¨\u0006\u000B"}, d2={"graphicsButtons", "Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsButtonState;", "pkg", "", "state", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsStatus;", "checking", "", "reasons", "", "owner", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GraphicsButtonStateKt {
    public static final GraphicsButtonState graphicsButtons(String arg20, GraphicsStatus arg21, boolean arg22, List arg23, String arg24) {
        boolean v1_1;
        String v0 = arg20;
        List v1 = arg23;
        String v2 = arg24;
        Intrinsics.checkNotNullParameter(v0, "pkg");
        GraphicsStatus v4 = arg21;
        Intrinsics.checkNotNullParameter(v4, "state");
        Intrinsics.checkNotNullParameter(v1, "reasons");
        Intrinsics.checkNotNullParameter(v2, "owner");
        String v3 = v0;
        boolean v6 = true;
        int v5 = ((CharSequence)v3).length() <= 0 || (v4.getBusy()) || (arg22) ? 0 : 1;
        if(v4.getBusy()) {
            v0 = StringsKt.startsWith$default(v4.getMessage(), "RESTAURAR", false, 2, null) ? "Restaurando sesión…" : "Operación gráfica en curso…";
        }
        else if(arg22) {
            v0 = "Comprobando configuración…";
        }
        else if(v4.getRecoveryBlocked()) {
            v0 = "No se puede acreditar la sesión. Aplicar está bloqueado; conserva los originales y revisa el error de recuperación.";
        }
        else {
            String v9 = "Aplicar bloqueado: ";
            String v10 = "; ";
            if((v4.getSharedTexture()) && !v1.isEmpty()) {
                v0 = v9 + CollectionsKt.joinToString$default(v1, v10, null, null, 0, null, null, 62, null) + ". La sesión global conserva sus originales.";
                goto label_120;
            }

            if(v4.getSharedTexture()) {
                v0 = "Textura global lista para compartir con este juego. Otras apps ANGLE pueden recibir el efecto; restauración conjunta.";
                goto label_120;
            }

            if(v4.getPendingPackage() != null && !Intrinsics.areEqual(v4.getPendingPackage(), v0)) {
                v0 = "La optimización sigue activa para " + v2 + ". Primero restaura esa sesión.";
                goto label_120;
            }

            if((Intrinsics.areEqual(v4.getPendingPackage(), v0)) && (v1.isEmpty())) {
                v0 = "La optimización de este juego ya está preparada. Puedes Jugar.";
                goto label_120;
            }

            if(Intrinsics.areEqual(v4.getPendingPackage(), v0)) {
                v0 = "Este juego tiene una sesión pendiente. Restaura antes de cambiar su configuración.";
                goto label_120;
            }

            if(!v1.isEmpty()) {
                v0 = v9 + CollectionsKt.joinToString$default(v1, v10, null, null, 0, null, null, 62, null) + ".\nNo hay ninguna optimización pendiente de restaurar.";
                goto label_120;
            }

            if(((CharSequence)v3).length() == 0) {
                v0 = "Selecciona un juego desde el carrusel.";
                goto label_120;
            }

            v0 = "Configuración lista para aplicar.\nNo hay ninguna optimización pendiente de restaurar.";
        }

    label_120:
        if(v5 != 0) {
            if(v4.getPendingPackage() != null && !v4.getSharedTexture()) {
                goto label_132;
            }

            if(v4.getRecoveryBlocked()) {
                goto label_132;
            }

            if(!v1.isEmpty()) {
                goto label_132;
            }

            v1_1 = true;
        }
        else {
        label_132:
            v1_1 = false;
        }

        if((v4.getBusy()) || (arg22) || v4.getPendingPackage() == null) {
            v6 = false;
        }
        else {
        }

        return new GraphicsButtonState(v1_1, v6, v0);
    }
}

