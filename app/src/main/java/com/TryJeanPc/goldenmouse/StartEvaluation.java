package com.TryJeanPc.goldenmouse;

import com.TryJeanPc.goldenmouse.activation.ActivationStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\'\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000B\u0010\u001A\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000F\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001C\u001A\u00020\bHÆ\u0003J/\u0010\u001D\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0013\u0010\u001E\u001A\u00020\b2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001A\u00020!HÖ\u0001J\t\u0010\"\u001A\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0011\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u000ER\u0011\u0010\u0015\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00180\u00058F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u000E¨\u0006#"}, d2={"Lcom/TryJeanPc/goldenmouse/StartEvaluation;", "", "coreStatus", "Lcom/TryJeanPc/goldenmouse/activation/ActivationStatus;", "requirements", "", "Lcom/TryJeanPc/goldenmouse/EvaluatedRequirement;", "gameSelected", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/activation/ActivationStatus;Ljava/util/List;Z)V", "getCoreStatus", "()Lcom/TryJeanPc/goldenmouse/activation/ActivationStatus;", "getRequirements", "()Ljava/util/List;", "getGameSelected", "()Z", "coreActive", "getCoreActive", "blockedRequirements", "getBlockedRequirements", "canStart", "getCanStart", "explanations", "", "getExplanations", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StartEvaluation {
    public static final int $stable = 8;
    private final ActivationStatus coreStatus;
    private final boolean gameSelected;
    private final List requirements;

    static {
    }

    public StartEvaluation(ActivationStatus arg2, List arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg3, "requirements");
        super();
        this.coreStatus = arg2;
        this.requirements = arg3;
        this.gameSelected = arg4;
    }

    public final ActivationStatus component1() {
        return this.coreStatus;
    }

    public final List component2() {
        return this.requirements;
    }

    public final boolean component3() {
        return this.gameSelected;
    }

    public final StartEvaluation copy(ActivationStatus arg1, List arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "requirements");
        return new StartEvaluation(arg1, arg2, arg3);
    }

    public static StartEvaluation copy$default(StartEvaluation arg0, ActivationStatus arg1, List arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.coreStatus;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.requirements;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.gameSelected;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((StartEvaluation)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StartEvaluation)) {
            return 0;
        }

        if(this.coreStatus != ((StartEvaluation)arg5).coreStatus) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.requirements, ((StartEvaluation)arg5).requirements)) {
            return 0;
        }

        if(this.gameSelected != ((StartEvaluation)arg5).gameSelected) {
            return 0;
        }

        return 1;
    }

    public final List getBlockedRequirements() {
        List v3 = this.requirements;
        ArrayList v0 = new ArrayList();
        Iterator v3_1 = ((Iterable)v3).iterator();
        while(v3_1.hasNext()) {
            Object v1 = v3_1.next();
            if(!v1.getBlocksStart()) {
                continue;
            }

            ((Collection)v0).add(v1);
        }

        return ((List)v0);
    }

    public final boolean getCanStart() {
        if((this.getCoreActive()) && (this.gameSelected) && (this.getBlockedRequirements().isEmpty())) {
            return 1;
        }

        return 0;
    }

    public final boolean getCoreActive() {
        if(this.coreStatus != ActivationStatus.ACTIVE_KADB) {
            if(this.coreStatus == ActivationStatus.ACTIVE_SHIZUKU) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final ActivationStatus getCoreStatus() {
        return this.coreStatus;
    }

    public final List getExplanations() {
        List v0 = CollectionsKt.createListBuilder();
        if(!this.getCoreActive()) {
            String v1 = this.coreStatus == null ? "No se pudo comprobar Golden Core. Revisa Activación y vuelve a pulsar Iniciar." : "Primero debes activar Golden Core.";
            v0.add(v1);
        }

        Iterator v1_1 = this.getBlockedRequirements().iterator();
        while(v1_1.hasNext()) {
            Object v2 = v1_1.next();
            v0.add(((EvaluatedRequirement)v2).getDefinition().getName() + ": " + ((EvaluatedRequirement)v2).getStatus().getMessage() + ". Revisa su configuración y vuelve a intentar.");
        }

        if(!this.gameSelected) {
            v0.add("Selecciona un juego válido antes de iniciar.");
        }

        return CollectionsKt.build(v0);
    }

    public final boolean getGameSelected() {
        return this.gameSelected;
    }

    public final List getRequirements() {
        return this.requirements;
    }

    public int hashCode() {
        ActivationStatus v0 = this.coreStatus;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        return (v0_1 * 0x1F + this.requirements.hashCode()) * 0x1F + Boolean.hashCode(this.gameSelected);
    }

    public String toString() {
        return "StartEvaluation(coreStatus=" + this.coreStatus + ", requirements=" + this.requirements + ", gameSelected=" + this.gameSelected + ")";
    }
}

