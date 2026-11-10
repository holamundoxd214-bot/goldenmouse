package com.TryJeanPc.goldenmouse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000B\u001A\u00020\fR\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/RequirementRegistry;", "", "definitions", "", "Lcom/TryJeanPc/goldenmouse/RequirementDefinition;", "<init>", "(Ljava/util/List;)V", "getDefinitions", "()Ljava/util/List;", "evaluate", "Lcom/TryJeanPc/goldenmouse/EvaluatedRequirement;", "apiLevel", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RequirementRegistry {
    public static final int $stable = 8;
    private final List definitions;

    static {
    }

    public RequirementRegistry(List arg3) {
        Intrinsics.checkNotNullParameter(arg3, "definitions");
        super();
        List v0 = arg3;
        this.definitions = CollectionsKt.sortedWith(((Iterable)v0), new RequirementRegistry$special$$inlined$sortedBy$1());
        if(!(v0 instanceof Collection) || !v0.isEmpty()) {
            Iterator v2 = ((Iterable)v0).iterator();
            while(true) {
                if(v2.hasNext()) {
                    if(!StringsKt.isBlank(v2.next().getId())) {
                        continue;
                    }
                    else {
                        break;
                    }
                }

                goto label_27;
            }

            throw new IllegalArgumentException("Cada requisito necesita un ID estable".toString());
        }
        else {
        }

    label_27:
        ArrayList v2_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0), 10));
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            ((Collection)v2_1).add(v0_1.next().getId());
        }

        if(CollectionsKt.distinct(((Iterable)v2_1)).size() == arg3.size()) {
            return;
        }

        throw new IllegalArgumentException("ID de requisito duplicado".toString());
    }

    public final List evaluate(int arg7) {
        RequirementStatus v3;
        List v6 = this.definitions;
        ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v6), 10));
        Iterator v6_1 = ((Iterable)v6).iterator();
        while(v6_1.hasNext()) {
            Object v1 = v6_1.next();
            boolean v2 = ((RequirementDefinition)v1).isApplicable().invoke(Integer.valueOf(arg7)).booleanValue();
            if(!v2) {
                v3 = new RequirementStatus(RequirementState.UNAVAILABLE, "NO DISPONIBLE EN ESTA VERSIÓN");
                goto label_26;
            }

            try {
                Object v3_1 = ((RequirementDefinition)v1).getCheck().invoke();
            }
            catch(RuntimeException ) {
                v3 = new RequirementStatus(RequirementState.UNVERIFIABLE, "NO SE PUDO COMPROBAR · REINTENTA");
            }

        label_26:
            ((Collection)v0).add(new EvaluatedRequirement(((RequirementDefinition)v1), v3, v2));
        }

        return ((List)v0);
    }

    public final List getDefinitions() {
        return this.definitions;
    }
}

