package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A(\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\u0007H\u0000\u001A \u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\tH\u0000\u001A\u0010\u0010\u0011\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u0001H\u0000¨\u0006\u0012"}, d2={"stretchFailureCode", "", "error", "", "requireStretchShizuku", "", "running", "", "version", "", "uid", "permitted", "stretchRestoreClosureVerified", "code", "read", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "ownerUid", "stretchCompatibilityMessage", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class StretchCompatibilityKt {
    public static final void requireStretchShizuku(boolean arg0, int arg1, int arg2, boolean arg3) {
        String v0;
        if(!arg0) {
            v0 = "SHIZUKU_NOT_RUNNING";
        }
        else if(!arg3) {
            v0 = "SHIZUKU_PERMISSION_DENIED";
        }
        else if(arg1 < 13) {
            v0 = "SHIZUKU_VERSION_UNSUPPORTED";
        }
        else if(arg2 == 0) {
            v0 = "SHIZUKU_ROOT_UNSUPPORTED";
        }
        else if(arg2 == 2000) {
            return;
        }
        else {
            v0 = "SHIZUKU_UID_UNSUPPORTED";
        }

        throw new StretchCompatibilityFailure(v0, null, 2, null);
    }

    public static final String stretchCompatibilityMessage(String arg4) {
        Intrinsics.checkNotNullParameter(arg4, "code");
        int v2 = 2;
        Object v3 = null;
        if(StringsKt.contains$default(((CharSequence)arg4), "SHIZUKU_NOT_RUNNING", false, v2, v3)) {
            return "Shizuku no responde. Inícialo antes de usar Stretch.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "SHIZUKU_PERMISSION_DENIED", false, v2, v3)) {
            return "Falta autorizar Golden en Shizuku.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "SHIZUKU_ROOT_UNSUPPORTED", false, v2, v3)) {
            return "Esta ruta de Stretch requiere Shizuku en modo shell (UID 2000); su modo Root no está admitido.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "SHIZUKU_VERSION_UNSUPPORTED", false, v2, v3)) {
            return "La API de Shizuku debe ser 13 o posterior.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "SHIZUKU_UID_UNSUPPORTED", false, v2, v3)) {
            return "El agente no tiene la identidad shell requerida.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "AGENT_CONNECT_TIMEOUT", false, v2, v3)) {
            return "Shizuku está disponible, pero el UserService no terminó de iniciar o autenticarse. Revisa la etapa del agente.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "AGENT_DISCONNECTED", false, v2, v3)) {
            return "Se perdió la conexión con el agente de pantalla.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "AGENT_NULL_BINDING", false, v2, v3)) {
            return "El sistema devolvió un enlace vacío para el agente de pantalla.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "AGENT_BINDING_DIED", false, v2, v3)) {
            return "El enlace del agente murió durante la conexión. Se conserva la recuperación pendiente.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "DISPLAY_TOKEN_UNAVAILABLE", false, v2, v3)) {
            return "No se pudo obtener y verificar el token de esta pantalla con los contratos del sistema disponibles.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "DISPLAY_CONTRACT_UNSUPPORTED", false, v2, v3)) {
            return "Este sistema no ofrece todos los métodos de lectura y restauración requeridos.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "COMPOSITOR_", false, v2, v3)) {
            return "La proyección original no pudo leerse de forma completa y estable; no es seguro aplicar.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "OVERRIDE_UNKNOWN", false, v2, v3)) {
            return "No se pudo determinar el tamaño original ni si existía un override.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "SCALING_UNKNOWN", false, v2, v3)) {
            return "No se pudo leer el escalado original necesario para restaurar.";
        }

        if(StringsKt.contains$default(((CharSequence)arg4), "DENSITY_READBACK_UNAVAILABLE", false, v2, v3)) {
            return "No se pudo verificar la densidad original.";
        }

        if(!StringsKt.contains$default(((CharSequence)arg4), "DISPLAY_TARGET_CHANGED", false, v2, v3)) {
            if(StringsKt.contains$default(((CharSequence)arg4), "PROJECTION_TARGET_CHANGED", false, v2, v3)) {
            }
            else if(StringsKt.contains$default(((CharSequence)arg4), "READBACK_DID_NOT_CONVERGE", false, v2, v3)) {
                return "Android respondió, pero el estado leído no coincidió dentro del plazo.";
            }
            else if(StringsKt.contains$default(((CharSequence)arg4), "DENSITY_CHANGED", false, v2, v3)) {
                return "La densidad cambió fuera de Stretch. La recuperación sigue pendiente; no se sobrescribirá el DPI.";
            }
            else if(StringsKt.contains$default(((CharSequence)arg4), "JOURNAL_BUSY", false, v2, v3)) {
                return "Otro ejecutor conserva la sesión. No borres datos ni reinicies servicios mientras se verifica la recuperación.";
            }
            else if(StringsKt.contains$default(((CharSequence)arg4), "JOURNAL_CORRUPT", false, v2, v3)) {
                return "El registro de recuperación no se puede verificar. Se conserva y APLICAR permanece bloqueado.";
            }
            else if(StringsKt.contains$default(((CharSequence)arg4), "GEOMETRY_UNSUPPORTED", false, v2, v3)) {
                return "La geometría actual no admite este factor FULL en horizontal sobre display 0.";
            }
            else if(StringsKt.contains$default(((CharSequence)arg4), "PREVIOUS_ORIGINAL_CHANGED", false, v2, v3)) {
                return "La configuración cambió desde la sesión anterior. Se conserva el original; no se reutilizará como una base nueva.";
            }
            else if(StringsKt.contains$default(((CharSequence)arg4), "EXECUTOR_PROBE_FAILED", false, v2, v3)) {
                return "El ejecutor de rescate no pudo reafirmar y verificar el original. No se autoriza el estiramiento.";
            }
            else {
                return "No se pudo completar la verificación de Stretch. Conserva el código y la etapa para el diagnóstico.";
            }
        }

        return "La identidad, orientación o modo de pantalla cambió. No se usarán originales de otro destino.";
    }

    public static final String stretchFailureCode(Throwable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "error");
        Sequence v0 = SequencesKt.filter(SequencesKt.generateSequence(arg2, new StretchCompatibilityKt$$ExternalSyntheticLambda0()), StretchCompatibilityKt$stretchFailureCode$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Object v0_1 = SequencesKt.firstOrNull(v0);
        if(v0_1 != null) {
            String v0_2 = ((StretchCompatibilityFailure)v0_1).getCode();
            if(v0_2 == null) {
            }
            else {
                return v0_2;
            }
        }

        String v2 = SequencesKt.last(SequencesKt.generateSequence(arg2, new StretchCompatibilityKt$$ExternalSyntheticLambda1())).getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(v2, "getSimpleName(...)");
        return v2;
    }

    static final Throwable stretchFailureCode$lambda$0(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.getCause();
    }

    static final Throwable stretchFailureCode$lambda$1(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.getCause();
    }

    public static final boolean stretchRestoreClosureVerified(String arg2, CandidateJournalRead arg3, int arg4) {
        Present v3;
        Intrinsics.checkNotNullParameter(arg2, "code");
        Intrinsics.checkNotNullParameter(arg3, "read");
        if((arg3 instanceof Present)) {
        }
        else {
            v3 = null;
        }

        if(0 != 0) {
            StretchCandidateRecord v3_1 = v3.getRecord();
            if(v3_1 == null) {
            }
            else if(v3_1.getOwnerUid() == arg4) {
                if(!StretchCandidateRecordCodec.INSTANCE.valid(v3_1)) {
                }
                else {
                    switch(arg2.hashCode()) {
                        case 1485316181: {
                            goto label_23;
                        }
                        case -1412748558: {
                            goto label_40;
                        }
                        case -1258692490: {
                            goto label_31;
                        }
                        case -1098224316: {
                            goto label_27;
                        }
                    }

                    return 0;
                label_23:
                    if(!arg2.equals("ORIGINAL_VERIFIED_CLOSED")) {
                        return 0;
                    label_40:
                        if(!arg2.equals("RESTORE_VERIFIED_CLOSED")) {
                        }
                        else {
                            goto label_44;
                        }
                    }
                    else {
                    label_44:
                        if(v3_1.getPhase() == CandidatePhase.RESTORED_VERIFIED) {
                            return 1;
                        label_27:
                            if(!arg2.equals("NO_MUTATION_CLOSED")) {
                                return 0;
                            label_31:
                                if(!arg2.equals("NO_MUTATION_REQUESTED")) {
                                }
                                else {
                                    goto label_35;
                                }
                            }
                            else {
                            label_35:
                                if(v3_1.getPhase() == CandidatePhase.CLOSED_WITHOUT_MUTATION) {
                                    return 1;
                                }
                                else {
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }
}

