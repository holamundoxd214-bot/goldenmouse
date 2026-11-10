package com.TryJeanPc.goldenmouse.graphicsui;

import android.app.AlertDialog$Builder;
import android.app.AlertDialog;
import android.content.Context;
import androidx.activity.ComponentActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"confirmGraphicsRestart", "", "activity", "Landroidx/activity/ComponentActivity;", "pkg", "", "(Landroidx/activity/ComponentActivity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GraphicsRestartDialogKt {
    public static final Object confirmGraphicsRestart(ComponentActivity arg3, String arg4, Continuation arg5) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg5), 1);
        v0.initCancellability();
        AlertDialog v3 = new AlertDialog$Builder(((Context)arg3)).setTitle("Reiniciar juego para Textura Ligera").setMessage(arg4 + " ya está abierto. ANGLE/LOD requiere un proceso nuevo para acreditar la configuración. Reiniciar puede perder progreso no guardado.\n\nSe cerrará solo este juego, se confirmará ANGLE/LOD y después se abrirá mediante Golden. Puedes cancelar sin modificar la partida.").setPositiveButton("Reiniciar y jugar", new GraphicsRestartDialogKt$confirmGraphicsRestart$2$dialog$1(v0)).setNegativeButton("Cancelar", null).create();
        v3.setOnDismissListener(new GraphicsRestartDialogKt$confirmGraphicsRestart$2$1(v0));
        v0.invokeOnCancellation(new GraphicsRestartDialogKt$confirmGraphicsRestart$2$2(v3));
        if(v0.isActive()) {
            v3.show();
        }

        Object v3_1 = v0.getResult();
        if(v3_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg5);
        }

        return v3_1;
    }
}

