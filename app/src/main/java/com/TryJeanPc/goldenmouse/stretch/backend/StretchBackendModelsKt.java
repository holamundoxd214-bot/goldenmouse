package com.TryJeanPc.goldenmouse.stretch.backend;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001A \u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001A\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0006"}, d2={"selectStretchBackend", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "statuses", "", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendStatus;", "preferred", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class StretchBackendModelsKt {
    public static final StretchBackendType selectStretchBackend(List arg7, StretchBackendType arg8) {
        List v3;
        Object v0;
        List v8;
        Intrinsics.checkNotNullParameter(arg7, "statuses");
        Boolean v1 = Boolean.valueOf(false);
        if(arg8 != null) {
            v8 = CollectionsKt.listOf(arg8);
            if(v8 == null) {
                goto label_7;
            }
        }
        else {
        label_7:
            v8 = CollectionsKt.listOf(new StretchBackendType[]{StretchBackendType.SHIZUKU, StretchBackendType.KADB});
        }

        Iterator v8_1 = ((Iterable)v8).iterator();
        while(true) {
        label_16:
            if(v8_1.hasNext()) {
                v0 = v8_1.next();
                Object v2 = v0;
                if(v2 == StretchBackendType.NONE) {
                    continue;
                }

                v3 = arg7;
                if(((v3 instanceof Collection)) && (v3.isEmpty())) {
                    continue;
                }

                break;
            }
            else {
                goto label_45;
            }
        }

        Iterator v3_1 = ((Iterable)v3).iterator();
        goto label_30;
    label_45:
        v0 = null;
        goto label_46;
        do {
        label_30:
            if(!v3_1.hasNext()) {
                goto label_16;
            }

            Object v4 = v3_1.next();
            if(((StretchBackendStatus)v4).getBackend() != v2) {
                goto label_30;
            }

            if(((StretchBackendStatus)v4).getState() != StretchBackendState.AVAILABLE) {
                goto label_30;
            }

            if(Intrinsics.areEqual(((StretchBackendStatus)v4).getConnected(), v1)) {
                goto label_30;
            }
        }
        while(Intrinsics.areEqual(((StretchBackendStatus)v4).getAuthorized(), v1));

    label_46:
        if(v0 == null) {
            return StretchBackendType.NONE;
        }

        return ((StretchBackendType)v0);
    }
}

