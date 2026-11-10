package com.TryJeanPc.goldenmouse.service;

import android.app.AlertDialog$Builder;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.TryJeanPc.goldenmouse.profile.GameProfileStorage$IdRepairPlan;
import com.TryJeanPc.goldenmouse.profile.GameProfileStorage;
import com.TryJeanPc.goldenmouse.profile.ProfileIdentities;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\t\u0012\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\u000F\u0012\u0014\u0010\u0010\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u000F¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u001B\u001A\u00020\u0012J\u0018\u0010\u001C\u001A\u00020\u00122\u0006\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001E\u001A\u00020\u0011H\u0002J\u001E\u0010\u001F\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u00182\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00120\tH\u0002J\u0010\u0010\"\u001A\u00020\u00122\u0006\u0010#\u001A\u00020$H\u0002J\u0010\u0010\u001B\u001A\u00020\r2\u0006\u0010%\u001A\u00020\u0018H\u0002J\u0006\u0010&\u001A\u00020\u0012R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0010\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/service/ProfileIdentityRepairDialog;", "", "context", "Landroid/content/Context;", "storage", "Lcom/TryJeanPc/goldenmouse/profile/GameProfileStorage;", "windowType", "", "prepare", "Lkotlin/Function0;", "Lcom/TryJeanPc/goldenmouse/profile/GameProfileStorage$IdRepairPlan;", "awaitCleanup", "Ljava/util/concurrent/CompletableFuture;", "", "isCurrent", "Lkotlin/Function1;", "reload", "", "", "<init>", "(Landroid/content/Context;Lcom/TryJeanPc/goldenmouse/profile/GameProfileStorage;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "handler", "Landroid/os/Handler;", "dialog", "Landroid/app/AlertDialog;", "isOpen", "()Z", "show", "showResult", "plan", "backupKey", "runAfterCleanup", "owner", "operation", "notifyFailure", "error", "", "next", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ProfileIdentityRepairDialog {
    public static final int $stable = 8;
    private final Function0 awaitCleanup;
    private final Context context;
    private AlertDialog dialog;
    private final Handler handler;
    private final Function1 isCurrent;
    private final Function0 prepare;
    private final Function1 reload;
    private final GameProfileStorage storage;
    private final int windowType;

    static {
    }

    public ProfileIdentityRepairDialog(Context arg2, GameProfileStorage arg3, int arg4, Function0 arg5, Function0 arg6, Function1 arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "storage");
        Intrinsics.checkNotNullParameter(arg5, "prepare");
        Intrinsics.checkNotNullParameter(arg6, "awaitCleanup");
        Intrinsics.checkNotNullParameter(arg7, "isCurrent");
        Intrinsics.checkNotNullParameter(arg8, "reload");
        super();
        this.context = arg2;
        this.storage = arg3;
        this.windowType = arg4;
        this.prepare = arg5;
        this.awaitCleanup = arg6;
        this.isCurrent = arg7;
        this.reload = arg8;
        this.handler = new Handler(Looper.getMainLooper());
    }

    public final void close() {
        AlertDialog v0 = this.dialog;
        if(v0 != null) {
            v0.dismiss();
        }

        this.dialog = null;
    }

    public final boolean isOpen() {
        if(this.dialog != null) {
            return 1;
        }

        return 0;
    }

    private final void notifyFailure(Throwable arg3) {
        Toast.makeText(this.context, "No se completó la recuperación: " + arg3.getMessage(), 1).show();
    }

    private final void runAfterCleanup(AlertDialog arg5, Function0 arg6) {
        arg5.setCancelable(false);
        Iterator v1 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(-1), Integer.valueOf(-2), Integer.valueOf(-3)}).iterator();
        while(v1.hasNext()) {
            Button v2 = arg5.getButton(v1.next().intValue());
            if(v2 == null) {
                continue;
            }

            v2.setEnabled(false);
        }

        this.awaitCleanup.invoke().whenComplete(new ProfileIdentityRepairDialog$$ExternalSyntheticLambda3(new ProfileIdentityRepairDialog$$ExternalSyntheticLambda2(this, arg5, arg6)));
    }

    static final Unit runAfterCleanup$lambda$12(ProfileIdentityRepairDialog arg7, AlertDialog arg8, Function0 arg9, Boolean arg10, Throwable arg11) {
        arg7.handler.post(new ProfileIdentityRepairDialog$$ExternalSyntheticLambda6(arg7, arg8, arg11, arg10, arg9));
        return Unit.INSTANCE;
    }

    static final void runAfterCleanup$lambda$12$lambda$11(ProfileIdentityRepairDialog arg2, AlertDialog arg3, Throwable arg4, Boolean arg5, Function0 arg6) {
        Object v4;
        if(arg2.dialog == arg3) {
            try {
                if(arg4 == null && (Intrinsics.areEqual(arg5, Boolean.valueOf(true)))) {
                    arg6.invoke();
                    v4 = Result.constructor-impl(Unit.INSTANCE);
                    goto label_22;
                }

                throw new IllegalStateException("No se confirmó el cierre de contactos; no se modificó el perfil".toString());
            }
            catch(Throwable arg4) {
                v4 = Result.constructor-impl(ResultKt.createFailure(arg4));
            }

        label_22:
            arg4 = Result.exceptionOrNull-impl(v4);
            if(arg4 != null) {
                arg2.notifyFailure(arg4);
            }

            arg3.setCancelable(true);
            Iterator v2 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(-1), Integer.valueOf(-2), Integer.valueOf(-3)}).iterator();
            while(v2.hasNext()) {
                Button v4_1 = arg3.getButton(v2.next().intValue());
                if(v4_1 == null) {
                    continue;
                }

                v4_1.setEnabled(true);
            }
        }
    }

    static final void runAfterCleanup$lambda$13(Function2 arg0, Object arg1, Object arg2) {
        arg0.invoke(arg1, arg2);
    }

    public final void show() {
        Object v0_2;
        if(this.dialog != null) {
            return;
        }

        Function0 v0 = this.prepare;
        try {
            v0_2 = Result.constructor-impl(v0.invoke());
        }
        catch(Throwable v0_1) {
            v0_2 = Result.constructor-impl(ResultKt.createFailure(v0_1));
        }

        Throwable v1 = Result.exceptionOrNull-impl(v0_2);
        if(v1 == null) {
            if(((IdRepairPlan)v0_2).getChangedIds() == 0) {
                return;
            }

            AlertDialog v1_1 = new AlertDialog$Builder(this.context).setTitle("Reparar identificadores de controles").setMessage(((IdRepairPlan)v0_2).getTargetPackage() + "\nSe corregirán " + ((IdRepairPlan)v0_2).getChangedIds() + " identificadores. Se conservarán todos los controles, teclas, posiciones y ediciones pendientes. Primero se verificará una copia de seguridad del perfil original y de la edición.\nCancelar no guarda ni repara el perfil.").setNegativeButton("Cancelar", null).setPositiveButton("Respaldar y reparar", null).create();
            Intrinsics.checkNotNull(v1_1);
            if(!this.show(v1_1)) {
                return;
            }

            v1_1.getButton(-1).setOnClickListener(new ProfileIdentityRepairDialog$$ExternalSyntheticLambda0(this, v1_1, ((IdRepairPlan)v0_2)));
            return;
        }

        this.notifyFailure(v1);
    }

    private final boolean show(AlertDialog arg3) {
        Boolean v0_3;
        Object v0_2;
        this.dialog = arg3;
        Window v0 = arg3.getWindow();
        if(v0 != null) {
            v0.setType(this.windowType);
        }

        arg3.setOnDismissListener(new ProfileIdentityRepairDialog$$ExternalSyntheticLambda1(this, arg3));
        try {
            SessionOverlayWindowsKt.showSessionDialog(arg3);
            v0_2 = Result.constructor-impl(Boolean.valueOf(true));
        }
        catch(Throwable v0_1) {
            v0_2 = Result.constructor-impl(ResultKt.createFailure(v0_1));
        }

        Throwable v1 = Result.exceptionOrNull-impl(v0_2);
        if(v1 == null) {
        }
        else {
            arg3.dismiss();
            this.notifyFailure(v1);
            v0_3 = Boolean.valueOf(false);
        }

        return v0_3.booleanValue();
    }

    static final void show$lambda$14(ProfileIdentityRepairDialog arg0, AlertDialog arg1, DialogInterface arg2) {
        if(arg0.dialog == arg1) {
            arg0.dialog = null;
        }
    }

    static final void show$lambda$3(ProfileIdentityRepairDialog arg0, AlertDialog arg1, IdRepairPlan arg2, View arg3) {
        Intrinsics.checkNotNull(arg1);
        arg0.runAfterCleanup(arg1, new ProfileIdentityRepairDialog$$ExternalSyntheticLambda5(arg0, arg2, arg1));
    }

    static final Unit show$lambda$3$lambda$2(ProfileIdentityRepairDialog arg3, IdRepairPlan arg4, AlertDialog arg5) {
        if(arg3.isCurrent.invoke(arg4).booleanValue()) {
            Object v0 = arg3.storage.repairIds-IoAF18A(arg4);
            ResultKt.throwOnFailure(v0);
            arg3.reload.invoke(arg4.getRepairedJson());
            arg5.dismiss();
            arg3.showResult(arg4, ((String)v0));
            return Unit.INSTANCE;
        }

        throw new IllegalStateException("El perfil o la edición cambió; vuelve a confirmar la recuperación".toString());
    }

    private final void showResult(IdRepairPlan arg5, String arg6) {
        AlertDialog v0 = new AlertDialog$Builder(this.context).setTitle("Identificadores reparados").setMessage("Se corrigieron " + arg5.getChangedIds() + " IDs sin eliminar controles. Respaldo verificado: " + arg6 + ". Restaurar devuelve el perfil guardado anterior; la edición pendiente también permanece en el respaldo.").setPositiveButton("Continuar", null).setNeutralButton("Restaurar anterior", null).create();
        Intrinsics.checkNotNull(v0);
        if(!this.show(v0)) {
            return;
        }

        v0.getButton(-3).setOnClickListener(new ProfileIdentityRepairDialog$$ExternalSyntheticLambda4(this, v0, arg5, arg6));
    }

    static final void showResult$lambda$6(ProfileIdentityRepairDialog arg0, AlertDialog arg1, IdRepairPlan arg2, String arg3, View arg4) {
        Intrinsics.checkNotNull(arg1);
        arg0.runAfterCleanup(arg1, new ProfileIdentityRepairDialog$$ExternalSyntheticLambda7(arg0, arg2, arg3, arg1));
    }

    static final Unit showResult$lambda$6$lambda$5(ProfileIdentityRepairDialog arg4, IdRepairPlan arg5, String arg6, AlertDialog arg7) {
        Object v0 = arg4.prepare.invoke();
        if((Intrinsics.areEqual(((IdRepairPlan)v0).getOriginalJson(), arg5.getRepairedJson())) && (ProfileIdentities.INSTANCE.same(new JSONObject(((IdRepairPlan)v0).getPendingJson()), new JSONObject(arg5.getRepairedJson())))) {
            ResultKt.throwOnFailure(arg4.storage.restoreIdentityBackup-gIAlu-s(arg6, arg5.getRepairedJson()));
            Function1 v4 = arg4.reload;
            arg6 = arg5.getOriginalJson();
            if(arg6 == null) {
                arg6 = arg5.getPendingJson();
            }

            v4.invoke(arg6);
            arg7.dismiss();
            return Unit.INSTANCE;
        }

        throw new IllegalStateException("Hay ediciones posteriores; no se sobrescribieron".toString());
    }
}

