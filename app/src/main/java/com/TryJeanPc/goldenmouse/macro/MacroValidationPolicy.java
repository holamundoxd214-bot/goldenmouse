package com.TryJeanPc.goldenmouse.macro;

import com.TryJeanPc.goldenmouse.macro.editor.MacroActionType;
import com.TryJeanPc.goldenmouse.macro.editor.MacroDraft;
import com.TryJeanPc.goldenmouse.macro.editor.MacroEditAction;
import com.TryJeanPc.goldenmouse.macro.editor.MacroPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BJ\u000E\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\rJ\u001D\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0013J#\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u00162\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0000¢\u0006\u0002\b\u001AR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/MacroValidationPolicy;", "", "<init>", "()V", "MAX_TIME_MS", "", "requireValid", "", "draft", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "requireActions", "", "MAPPED_CONTACT_LIMIT", "", "requireContactBudget", "peakContacts", "validTimes", "start", "duration", "validTimes$app", "validPoints", "type", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroActionType;", "points", "", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroPoint;", "validPoints$app", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroValidationPolicy {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[MacroActionType.values().length];
            try {
                v0[MacroActionType.DELAY.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[MacroActionType.SWIPE.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final int $stable = 0;
    public static final MacroValidationPolicy INSTANCE = null;
    public static final int MAPPED_CONTACT_LIMIT = 14;
    public static final long MAX_TIME_MS = 86400000;

    static {
        MacroValidationPolicy.INSTANCE = new MacroValidationPolicy();
    }

    private MacroValidationPolicy() {
        super();
    }

    public final void requireContactBudget(int arg2) {
        if(arg2 <= 14) {
            return;
        }

        throw new IllegalArgumentException("Macro necesita " + arg2 + " contactos simultáneos; límite 14".toString());
    }

    public final void requireValid(MacroDraft arg9, boolean arg10) {
        List v0_5;
        Object v1_1;
        ArrayList v2_2;
        Object v0_4;
        boolean v0_3;
        String v4;
        Object v10_1;
        Iterator v8_1;
        Intrinsics.checkNotNullParameter(arg9, "draft");
        if(!StringsKt.isBlank(arg9.getName())) {
            if(arg9.getRepetitions() >= 0) {
                long v0 = arg9.getIntervalMs();
                long v2 = 0;
                if(v2 <= v0 && v0 < 86400001) {
                    if(!arg9.getTracks().isEmpty()) {
                        List v8 = arg9.getTracks();
                        if(!(v8 instanceof Collection) || !v8.isEmpty()) {
                            v8_1 = ((Iterable)v8).iterator();
                            while(v8_1.hasNext()) {
                                int v0_1 = v8_1.next().intValue();
                                if(v0_1 <= 0) {
                                    goto label_259;
                                }
                                else if(v0_1 < 0x7FFFFFFF) {
                                    continue;
                                }
                                else {
                                    goto label_259;
                                }
                            }
                        }
                        else {
                        }

                        if(CollectionsKt.distinct(arg9.getTracks()).size() != arg9.getTracks().size()) {
                            goto label_259;
                        }

                        if(arg10) {
                            if(!arg9.getActions().isEmpty()) {
                            }
                            else {
                                throw new IllegalArgumentException("Añade al menos una acción".toString());
                            }
                        }

                        v8 = arg9.getActions();
                        ArrayList v10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v8), 10));
                        v8_1 = ((Iterable)v8).iterator();
                        while(v8_1.hasNext()) {
                            ((Collection)v10).add(Long.valueOf(v8_1.next().getId()));
                        }

                        if(CollectionsKt.distinct(((Iterable)v10)).size() == arg9.getActions().size()) {
                            v8_1 = arg9.getActions().iterator();
                            goto label_67;
                        }

                        throw new IllegalArgumentException("IDs de acciones repetidos".toString());
                        while(true) {
                        label_67:
                            if(!v8_1.hasNext()) {
                                goto label_144;
                            }

                            v10_1 = v8_1.next();
                            if(((MacroEditAction)v10_1).getId() > v2 && ((MacroEditAction)v10_1).getId() < 0x7FFFFFFFFFFFFFFFL) {
                                MacroValidationPolicy v0_2 = MacroValidationPolicy.INSTANCE;
                                v4 = "Acción ";
                                if(!v0_2.validTimes$app(((MacroEditAction)v10_1).getStartMs(), ((MacroEditAction)v10_1).getDurationMs())) {
                                    goto label_123;
                                }
                                else if(v0_2.validPoints$app(((MacroEditAction)v10_1).getType(), ((MacroEditAction)v10_1).getPoints())) {
                                    if(((MacroEditAction)v10_1).getTrack() != null) {
                                        v0_3 = arg9.getTracks().contains(((MacroEditAction)v10_1).getTrack());
                                    }
                                    else if(((MacroEditAction)v10_1).getType() == MacroActionType.DELAY) {
                                        v0_3 = true;
                                    }
                                    else {
                                        v0_3 = false;
                                    }

                                    if(!v0_3) {
                                        break;
                                    }

                                    continue;
                                }
                                else {
                                    goto label_110;
                                }
                            }

                            goto label_134;
                        }

                        throw new IllegalArgumentException(v4 + ((MacroEditAction)v10_1).getId() + ": pista inválida".toString());
                    label_110:
                        throw new IllegalArgumentException(v4 + ((MacroEditAction)v10_1).getId() + ": puntos o coordenadas inválidos para " + ((MacroEditAction)v10_1).getType().toString());
                    label_123:
                        throw new IllegalArgumentException(v4 + ((MacroEditAction)v10_1).getId() + ": inicio o duración inválidos".toString());
                    label_134:
                        throw new IllegalArgumentException("ID de acción inválido: " + ((MacroEditAction)v10_1).getId().toString());
                    label_144:
                        v8 = arg9.getActions();
                        LinkedHashMap v10_2 = new LinkedHashMap();
                        v8_1 = ((Iterable)v8).iterator();
                        while(v8_1.hasNext()) {
                            v0_4 = v8_1.next();
                            Integer v1 = v0_4.getTrack();
                            Object v2_1 = ((Map)v10_2).get(v1);
                            if(v2_1 == null) {
                                v2_2 = new ArrayList();
                                ((Map)v10_2).put(v1, v2_2);
                            }

                            ((List)v2_2).add(v0_4);
                        }

                        v8_1 = ((Map)v10_2).values().iterator();
                    label_162:
                        if(v8_1.hasNext()) {
                            Iterator v10_3 = CollectionsKt.zipWithNext(CollectionsKt.sortedWith(v8_1.next(), new MacroValidationPolicy$requireValid$lambda$16$$inlined$sortedBy$1())).iterator();
                            while(true) {
                                if(!v10_3.hasNext()) {
                                    goto label_162;
                                }

                                v0_4 = v10_3.next();
                                v1_1 = ((Pair)v0_4).component1();
                                v0_4 = ((Pair)v0_4).component2();
                                if(((MacroEditAction)v1_1).getEndMs() > ((MacroEditAction)v0_4).getStartMs()) {
                                    break;
                                }
                            }

                            throw new IllegalArgumentException("Acciones " + ((MacroEditAction)v1_1).getId() + "/" + ((MacroEditAction)v0_4).getId() + " superpuestas en pista " + ((MacroEditAction)v1_1).getTrack().toString());
                        }

                        v8 = arg9.getActions();
                        v10 = new ArrayList();
                        v8_1 = ((Iterable)v8).iterator();
                        while(v8_1.hasNext()) {
                            v0_4 = v8_1.next();
                            v1_1 = v0_4;
                            if(((MacroEditAction)v1_1).getType() != MacroActionType.DELAY) {
                                continue;
                            }

                            if(((MacroEditAction)v1_1).getTrack() != null) {
                                continue;
                            }

                            ((Collection)v10).add(v0_4);
                        }

                        v8_1 = ((Iterable)v10).iterator();
                        while(true) {
                        label_213:
                            if(!v8_1.hasNext()) {
                                return;
                            }

                            v10_1 = v8_1.next();
                            v0_5 = arg9.getActions();
                            if(((v0_5 instanceof Collection)) && (v0_5.isEmpty())) {
                                continue;
                            }

                            break;
                        }

                        Iterator v0_6 = ((Iterable)v0_5).iterator();
                        goto label_224;
                        return;
                        while(true) {
                        label_224:
                            if(!v0_6.hasNext()) {
                                goto label_213;
                            }

                            v1_1 = v0_6.next();
                            if(((MacroEditAction)v1_1).getType() == MacroActionType.DELAY) {
                                continue;
                            }

                            if(((MacroEditAction)v1_1).getStartMs() < ((MacroEditAction)v10_1).getStartMs()) {
                                continue;
                            }

                            if(((MacroEditAction)v1_1).getStartMs() < ((MacroEditAction)v10_1).getEndMs()) {
                                break;
                            }
                        }

                        throw new IllegalArgumentException("Delay global " + ((MacroEditAction)v10_1).getId() + ": sitúa el inicio de las acciones después de " + ((MacroEditAction)v10_1).getEndMs() + " ms".toString());
                    }

                label_259:
                    throw new IllegalArgumentException("Pistas inválidas".toString());
                }
            }

            throw new IllegalArgumentException("Parámetros de Bucle inválidos".toString());
        }

        throw new IllegalArgumentException("La macro necesita un nombre".toString());
    }

    public static void requireValid$default(MacroValidationPolicy arg0, MacroDraft arg1, boolean arg2, int arg3, Object arg4) {
        arg0.requireValid(arg1, true);
    }

    public final boolean validPoints$app(MacroActionType arg4, List arg5) {
        int v1;
        Intrinsics.checkNotNullParameter(arg4, "type");
        Intrinsics.checkNotNullParameter(arg5, "points");
        int v3 = WhenMappings.$EnumSwitchMapping$0[arg4.ordinal()];
        if(v3 != 1) {
            v1 = 2;
            if(v3 != v1) {
                v1 = 1;
            }
        }
        else {
            v1 = 0;
        }

        if(arg5.size() == v1) {
            if(!(arg5 instanceof Collection) || !arg5.isEmpty()) {
                Iterator v3_1 = ((Iterable)arg5).iterator();
                while(v3_1.hasNext()) {
                    Object v5 = v3_1.next();
                    float v2 = 3.402823E+38f;
                    if(Math.abs(((MacroPoint)v5).getX()) > v2) {
                        return 0;
                    }
                    else if(Math.abs(((MacroPoint)v5).getY()) > v2) {
                        return 0;
                    }
                    else if(((MacroPoint)v5).getX() < 0f) {
                        return 0;
                    }
                    else if(((MacroPoint)v5).getY() >= 0f) {
                        continue;
                    }
                    else {
                        return 0;
                    }
                }
            }
            else {
            }

            return 1;
        }

        return 0;
    }

    public final boolean validTimes$app(long arg3, long arg5) {
        if(arg3 >= 0 && arg5 >= 1) {
            long v0 = 86400000;
            if(arg5 <= v0 && arg3 <= v0 - arg5) {
                return 1;
            }
        }

        return 0;
    }
}

