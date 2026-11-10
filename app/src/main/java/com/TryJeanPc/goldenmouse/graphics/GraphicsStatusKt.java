package com.TryJeanPc.goldenmouse.graphics;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A<\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u000E\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00042\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\tH\u0000\u001A&\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\tH\u0000\u001A \u0010\u0011\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u000BH\u0000¨\u0006\u0013"}, d2={"recoverGraphicsStatus", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsStatus;", "previous", "journal", "Lkotlin/Function0;", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecord;", "history", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttempt;", "message", "", "beginGraphicsOperation", "", "gate", "Ljava/util/concurrent/atomic/AtomicBoolean;", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "operation", "completedGraphicsOperation", "confirmed", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GraphicsStatusKt {
    public static final boolean beginGraphicsOperation(AtomicBoolean arg16, MutableStateFlow arg17, String arg18) {
        MutableStateFlow v1 = arg17;
        String v12 = arg18;
        Intrinsics.checkNotNullParameter(arg16, "gate");
        Intrinsics.checkNotNullParameter(v1, "state");
        Intrinsics.checkNotNullParameter(v12, "operation");
        if(!arg16.compareAndSet(false, true)) {
            return 0;
        }

        v1.setValue(GraphicsStatus.copy$default(v1.getValue(), true, v12 + " · preparando", null, null, null, 0, false, null, v12, false, 0x2FC, null));
        return 1;
    }

    public static final GraphicsStatus completedGraphicsOperation(GraphicsStatus arg14, String arg15, boolean arg16) {
        Intrinsics.checkNotNullParameter(arg14, "state");
        Intrinsics.checkNotNullParameter(arg15, "operation");
        if(arg16) {
            if(arg14.getRecoveryBlocked()) {
            }
            else {
                if(Intrinsics.areEqual(arg15, "APLICAR")) {
                    arg15 = arg14.getPendingPackage() == null ? "Configuración comprobada · no hay cambios externos registrados." : "Optimización aplicada · configuración confirmada; efecto visual indicado aparte.";
                }
                else if(!Intrinsics.areEqual(arg15, "RESTAURAR")) {
                    return arg14;
                }
                else if(arg14.getPendingPackage() == null) {
                    arg15 = "Sesión restaurada · originales verificados.";
                }
                else {
                    return arg14;
                }

                arg14 = GraphicsStatus.copy$default(arg14, false, arg15 + "\n" + arg14.getMessage(), null, null, null, 0, false, null, null, false, 0x3FD, null);
            }
        }

        return arg14;
    }

    public static final GraphicsStatus recoverGraphicsStatus(GraphicsStatus arg23, Function0 arg24, Function0 arg25, String arg26) {
        String v0_2;
        String v10;
        boolean v9;
        String v4_1;
        Object v0_1;
        String v1 = arg26;
        GraphicsStatus v2 = arg23;
        Intrinsics.checkNotNullParameter(v2, "previous");
        Function0 v3 = arg24;
        Intrinsics.checkNotNullParameter(v3, "journal");
        Function0 v4 = arg25;
        Intrinsics.checkNotNullParameter(v4, "history");
        try {
            v0_1 = Result.constructor-impl(v3.invoke());
        }
        catch(Throwable v0) {
            v0_1 = Result.constructor-impl(ResultKt.createFailure(v0));
        }

        Object v3_1 = v0_1;
        try {
            v0_1 = Result.constructor-impl(v4.invoke());
        }
        catch(Throwable v0) {
            v0_1 = Result.constructor-impl(ResultKt.createFailure(v0));
        }

        Object v5 = null;
        if(Result.isFailure-impl(v3_1)) {
            v4_1 = "Desconocido";
        }
        else {
            Object v4_2 = Result.isFailure-impl(v3_1) ? v5 : v3_1;
            if(v4_2 != null) {
                v4_1 = ((GraphicsRecord)v4_2).getPkg();
                goto label_41;
            }

            v4_1 = ((String)v5);
        }

    label_41:
        boolean v7 = true;
        if(!Result.isFailure-impl(v3_1)) {
            Object v6 = Result.isFailure-impl(v3_1) ? v5 : v3_1;
            if(v6 != null && (((GraphicsRecord)v6).getUncertain())) {
                goto label_56;
            }

            v9 = false;
        }
        else {
        label_56:
            v9 = true;
        }

        if(v1 == null) {
            v10 = v2.getOperationError();
        }
        else {
            int v10_1 = 2;
            if(!StringsKt.startsWith$default(v1, "ERROR", false, v10_1, v5)) {
                if(StringsKt.startsWith$default(v1, "CANCELADO", false, v10_1, v5)) {
                }
                else {
                    v10 = ((String)v5);
                    goto label_72;
                }
            }

            v10 = v1;
        }

    label_72:
        List v6_1 = CollectionsKt.createListBuilder();
        String v11 = "\n";
        if(v1 == null) {
            if(v10 == null) {
                Object v1_1 = Result.isFailure-impl(v0_1) ? v5 : v0_1;
                v1 = v1_1 != null ? ((GraphicsAttempt)v1_1).getPhase() + " · " + ((GraphicsAttempt)v1_1).getPkg() + v11 + ((GraphicsAttempt)v1_1).getMessage() : ((String)v5);
                if(v1 != null) {
                    goto label_100;
                }

                v1 = "SIN INTERVENCIÓN ACREDITADA EN EL HISTORIAL";
            }
            else {
                v1 = v10;
            }
        }

    label_100:
        v6_1.add(v1);
        if(Result.isFailure-impl(v0_1)) {
            v0 = Result.exceptionOrNull-impl(v0_1);
            v0_2 = v0 != null ? v0.getMessage() : ((String)v5);
            v6_1.add("No se pudo leer el historial: " + v0_2 + ". Esto no determina si existe una sesión; conserva los archivos de recuperación.");
        }

        if(Result.isFailure-impl(v3_1)) {
            v0 = Result.exceptionOrNull-impl(v3_1);
            v0_2 = v0 != null ? v0.getMessage() : ((String)v5);
            v6_1.add("No se pudo leer la sesión: " + v0_2 + ". Aplicar permanece bloqueado; conserva el journal y sus originales para recuperarlos.");
        }
        else {
            if(v9) {
                v6_1.add("La sesión tiene un resultado incierto. No apliques otra configuración; conserva los originales para reconciliar la operación.");
                goto label_177;
            }

            if(v4_1 == null) {
                goto label_177;
            }

            v6_1.add("SESIÓN CONSERVADA · restauración manual");
            v0_1 = Result.isFailure-impl(v3_1) ? v5 : v3_1;
            List v0_3 = v0_1 != null ? ((GraphicsRecord)v0_1).getTextureFeatures() : ((List)v5);
            if(v0_3 == null) {
                goto label_177;
            }

            v0_1 = Result.isFailure-impl(v3_1) ? v5 : v3_1;
            if(v0_1 != null) {
                Set v0_4 = ((GraphicsRecord)v0_1).getPackages();
                if(v0_4 != null) {
                    v0_2 = CollectionsKt.joinToString$default(v0_4, null, null, null, 0, null, null, 0x3F, null);
                }
                else {
                    goto label_168;
                }
            }
            else {
            label_168:
                v0_2 = ((String)v5);
            }

            v6_1.add("Textura GLOBAL compartida: " + v0_2 + ". Otras apps ANGLE pueden recibir el efecto; RESTAURAR recupera la sesión completa.");
        }

    label_177:
        v0_2 = CollectionsKt.joinToString$default(CollectionsKt.build(v6_1), v11, null, null, 0, null, null, 62, null);
        long v11_1 = v2.getRevision() + 1;
        if(Result.isFailure-impl(v3_1)) {
            v3_1 = v5;
        }

        if(v3_1 != null) {
            List v5_1 = ((GraphicsRecord)v3_1).getTextureFeatures();
        }

        if((((List)v5)) != null) {
        }
        else {
            v7 = false;
        }

        return GraphicsStatus.copy$default(arg23, false, v0_2, v4_1, null, null, v11_1, v9, v10, null, v7, 24, null);
    }

    public static GraphicsStatus recoverGraphicsStatus$default(GraphicsStatus arg0, Function0 arg1, Function0 arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 8) != 0) {
            arg3 = null;
        }

        return GraphicsStatusKt.recoverGraphicsStatus(arg0, arg1, arg2, arg3);
    }
}

