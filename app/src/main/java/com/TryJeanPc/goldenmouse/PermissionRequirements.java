package com.TryJeanPc.goldenmouse;

import android.content.Context;
import android.os.Build$VERSION;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\f\u001A\u00020\rJ\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\rH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/PermissionRequirements;", "", "<init>", "()V", "OVERLAY", "", "BACKGROUND", "BATTERY", "POWER_SAVER", "evaluate", "", "Lcom/TryJeanPc/goldenmouse/EvaluatedRequirement;", "context", "Landroid/content/Context;", "registry", "Lcom/TryJeanPc/goldenmouse/RequirementRegistry;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class PermissionRequirements {
    public static final int $stable = 0;
    public static final String BACKGROUND = "background";
    public static final String BATTERY = "battery_optimization";
    public static final PermissionRequirements INSTANCE = null;
    public static final String OVERLAY = "overlay";
    public static final String POWER_SAVER = "power_saver";

    static {
        PermissionRequirements.INSTANCE = new PermissionRequirements();
    }

    private PermissionRequirements() {
        super();
    }

    public final List evaluate(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        return this.registry(arg2).evaluate(Build$VERSION.SDK_INT);
    }

    private final RequirementRegistry registry(Context arg20) {
        PermissionState v1 = PermissionChecks.INSTANCE.read(arg20);
        return new RequirementRegistry(CollectionsKt.listOf(new RequirementDefinition[]{new RequirementDefinition("overlay", "Permiso de superposición", "Controles sobre los juegos", RequirementType.MANDATORY, 10, PermissionRequirements.registry$action(arg20, "CONFIGURAR", PermissionSettings.OVERLAY), null, new PermissionRequirements$$ExternalSyntheticLambda1(v1), 0x40, null), new RequirementDefinition("background", "Segundo plano", "No garantiza ejecución ilimitada", RequirementType.OPTIONAL, 20, PermissionRequirements.registry$action(arg20, "AJUSTES", PermissionSettings.BACKGROUND), new PermissionRequirements$$ExternalSyntheticLambda2(), new PermissionRequirements$$ExternalSyntheticLambda3(v1)), new RequirementDefinition("battery_optimization", "Restricciones de batería", "Optimización de Android (Doze)", RequirementType.OPTIONAL, 30, PermissionRequirements.registry$action(arg20, "REVISAR", PermissionSettings.BATTERY), null, new PermissionRequirements$$ExternalSyntheticLambda4(v1), 0x40, null), new RequirementDefinition("power_saver", "Ahorro de energía", "Configuración recomendada al jugar", RequirementType.RECOMMENDATION, 40, PermissionRequirements.registry$action(arg20, "VER AJUSTES", PermissionSettings.POWER_SAVER), null, new PermissionRequirements$$ExternalSyntheticLambda5(v1), 0x40, null)}));
    }

    private static final RequirementAction registry$action(Context arg2, String arg3, PermissionSettings arg4) {
        return new RequirementAction(arg3, new PermissionRequirements$$ExternalSyntheticLambda0(arg2, arg4));
    }

    static final boolean registry$action$lambda$0(Context arg7, PermissionSettings arg8) {
        return PermissionChecks.openSettings$default(PermissionChecks.INSTANCE, arg7, arg8, null, null, 12, null);
    }

    private static final RequirementStatus registry$checked(Boolean arg1, String arg2, String arg3) {
        if(Intrinsics.areEqual(arg1, Boolean.valueOf(true))) {
            return new RequirementStatus(RequirementState.SATISFIED, arg2);
        }

        if(Intrinsics.areEqual(arg1, Boolean.valueOf(false))) {
            return new RequirementStatus(RequirementState.PENDING, arg3);
        }

        if(arg1 == null) {
            return new RequirementStatus(RequirementState.UNVERIFIABLE, "NO SE PUDO COMPROBAR · REINTENTA");
        }

        throw new NoWhenBranchMatchedException();
    }

    static final RequirementStatus registry$lambda$1(PermissionState arg2) {
        return PermissionRequirements.registry$checked(arg2.getOverlayGranted(), "CONCEDIDO", "PENDIENTE");
    }

    static final boolean registry$lambda$2(int arg1) {
        if(arg1 >= 28) {
            return 1;
        }

        return 0;
    }

    static final RequirementStatus registry$lambda$3(PermissionState arg2) {
        if(Intrinsics.areEqual(arg2.getBackgroundRestricted(), Boolean.valueOf(true))) {
            return new RequirementStatus(RequirementState.PENDING, "RESTRINGIDA POR ANDROID");
        }

        return new RequirementStatus(RequirementState.UNVERIFIABLE, "REVISAR CONFIGURACIÓN");
    }

    static final RequirementStatus registry$lambda$4(PermissionState arg2) {
        return PermissionRequirements.registry$checked(arg2.getBatteryOptimizationExempt(), "EXENTA DE OPTIMIZACIÓN", "OPTIMIZACIÓN ACTIVA");
    }

    static final RequirementStatus registry$lambda$5(PermissionState arg2) {
        Boolean v2 = arg2.getPowerSaveMode();
        v2 = v2 != null ? Boolean.valueOf(v2.booleanValue() ^ 1) : null;
        return PermissionRequirements.registry$checked(v2, "Ahorro de energía desactivado", "Ahorro de energía activo");
    }
}

