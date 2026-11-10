package com.TryJeanPc.goldenmouse.graphics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u001E\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0000¨\u0006\u0006"}, d2={"graphicsPackagePids", "", "", "output", "", "pkg", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GoldenGraphicsBackendKt {
    public static final Set graphicsPackagePids(String arg10, String arg11) {
        Intrinsics.checkNotNullParameter(arg10, "output");
        Intrinsics.checkNotNullParameter(arg11, "pkg");
        if(!GraphicsProfileKt.validGraphicsPackage(arg11)) {
            goto label_101;
        }

        if(arg10.length() > 0x400000) {
            goto label_96;
        }

        List v10 = SequencesKt.toList(SequencesKt.filter(StringsKt.lineSequence(((CharSequence)arg10)), new GoldenGraphicsBackendKt$$ExternalSyntheticLambda0()));
        Object v0 = CollectionsKt.firstOrNull(v10);
        String v1 = "\\s+";
        Object v3 = null;
        if(v0 != null) {
            String v0_1 = StringsKt.trim(((CharSequence)v0)).toString();
            if(v0_1 != null) {
                List v0_2 = new Regex(v1).split(((CharSequence)v0_1), 0);
                if(v0_2 != null) {
                    v0 = CollectionsKt.firstOrNull(v0_2);
                }
                else {
                    goto label_28;
                }
            }
            else {
                goto label_28;
            }
        }
        else {
        label_28:
            v0 = v3;
        }

        if(!Intrinsics.areEqual(v0, "PID")) {
            goto label_91;
        }

        v10 = CollectionsKt.drop(((Iterable)v10), 1);
        ArrayList v4 = new ArrayList();
        Iterator v10_1 = ((Iterable)v10).iterator();
        while(true) {
            if(!v10_1.hasNext()) {
                goto label_89;
            }

            List v5 = new Regex(v1).split(StringsKt.trim(v10_1.next()).toString(), 3);
            int v7 = 2;
            if(v5.size() < v7) {
                goto label_84;
            }

            Integer v6 = StringsKt.toIntOrNull(v5.get(0));
            if(v6 != null) {
                if(v6.intValue() > 0) {
                }
                else {
                    v6 = ((Integer)v3);
                }

                if(v6 == null) {
                    break;
                }

                v6 = Integer.valueOf(v6.intValue());
                v6.intValue();
                if(!Intrinsics.areEqual(v5.get(1), arg11)) {
                    if(StringsKt.startsWith$default(v5.get(1), arg11 + ":", false, v7, v3)) {
                    }
                    else {
                        v6 = ((Integer)v3);
                    }
                }

                if(v6 == null) {
                    continue;
                }

                ((Collection)v4).add(v6);
                continue;
            }

            break;
        }

        throw new IllegalStateException("PID desconocido".toString());
    label_84:
        throw new IllegalStateException("Registro de proceso incompleto".toString());
    label_89:
        return CollectionsKt.toSet(((Iterable)v4));
    label_91:
        throw new IllegalStateException("Cabecera de procesos desconocida".toString());
    label_96:
        throw new IllegalStateException("Lista de procesos demasiado larga".toString());
    label_101:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    static final boolean graphicsPackagePids$lambda$1(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return StringsKt.isBlank(((CharSequence)arg1)) ^ 1;
    }
}

