package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.mapper.GameProfileCompiler;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.profile.GameProfile;
import com.TryJeanPc.goldenmouse.profile.GameProfileKt;
import com.TryJeanPc.goldenmouse.profile.ProfileControl;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\n2\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f¨\u0006\u000F"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/VistaSettingsValidation;", "", "<init>", "()V", "conflict", "", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "ownerId", "settings", "Lcom/TryJeanPc/goldenmouse/profile/ViewComponent;", "matches", "Lkotlin/Function2;", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class VistaSettingsValidation {
    public static final int $stable;
    public static final VistaSettingsValidation INSTANCE;

    static {
        VistaSettingsValidation.INSTANCE = new VistaSettingsValidation();
    }

    private VistaSettingsValidation() {
        super();
    }

    public final String conflict(GameProfile arg24, String arg25, ViewComponent arg26, Function2 arg27) {
        Object v5_1;
        String v0_6;
        Function2 v4_1;
        int v9_1;
        boolean v11;
        int v10;
        GameProfile v1_2;
        ProfileControl v12_2;
        String v2 = arg25;
        ViewComponent v8 = arg26;
        GameProfile v9 = arg24;
        Intrinsics.checkNotNullParameter(v9, "profile");
        Intrinsics.checkNotNullParameter(v2, "ownerId");
        Intrinsics.checkNotNullParameter(v8, "settings");
        Intrinsics.checkNotNullParameter(arg27, "matches");
        long v0 = v8.getQuickChangeDelayMs();
        if(0 <= v0 && v0 < 5001) {
            float v1 = 3.402823E+38f;
            if(Math.abs(v8.getSniperMultiplier()) <= v1) {
                float v3 = 0f;
                if(v8.getSniperMultiplier() <= 0f) {
                }
                else {
                    ArrayList v0_1 = new ArrayList();
                    int v5 = 2;
                    Float[] v6 = new Float[v5];
                    v6[0] = Float.valueOf(v8.getSensitivityX());
                    v6[1] = Float.valueOf(v8.getSensitivityY());
                    Iterator v6_1 = CollectionsKt.listOf(((Object[])v6)).iterator();
                    while(v6_1.hasNext()) {
                        float v7 = GameProfileKt.normalizeViewSensitivity(v6_1.next().floatValue());
                        float v12 = v8.getSniperMultiplier() * v7;
                        float v13 = v8.getSpeed() * v12;
                        if(v8.getSniperEnabled()) {
                            if(Math.abs(v12) <= v1 && Math.abs(v13) <= v1) {
                                if(v7 <= v3) {
                                }
                                else if(v13 == v3) {
                                    return "El multiplicador no permite conservar una sensibilidad finita y precisa";
                                }

                                goto label_58;
                            }

                            return "El multiplicador no permite conservar una sensibilidad finita y precisa";
                        }

                    label_58:
                        v0_1.add(Float.valueOf((((float)((((double)v12)) * 2147483647))) * v8.getSpeed()));
                        v3 = 0f;
                    }

                    if(v8.getSniperEnabled()) {
                        double v0_2 = Math.hypot(((double)((List)v0_1).get(0).floatValue()), ((double)((List)v0_1).get(1).floatValue()));
                        double v6_2 = 1;
                        if(v8.getMouseAcceleration()) {
                            v6_2 += v0_2 / 12;
                        }

                        if(Math.abs(v0_2) <= 1.797693E+308 && v0_2 * v6_2 <= 3.402823E+38) {
                            goto label_93;
                        }

                        return "El multiplicador es demasiado alto para la configuración de cámara";
                    }

                label_93:
                    List v0_3 = v9.getControls();
                    int v3_1 = 10;
                    ArrayList v1_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_3), v3_1));
                    Iterator v0_4 = ((Iterable)v0_3).iterator();
                    while(v0_4.hasNext()) {
                        Object v12_1 = v0_4.next();
                        if(Intrinsics.areEqual(((ProfileControl)v12_1).getId(), v2)) {
                            v12_2 = ProfileControl.copy$default(((ProfileControl)v12_1), null, null, 0f, 0f, 0, 0, null, v8, 0x7F, null);
                        }

                        ((Collection)v1_1).add(v12_2);
                    }

                    int v16 = 0;
                    GameProfile v0_5 = GameProfile.copy$default(v9, null, null, v1_1, null, 11, null);
                    int v4 = v3_1;
                    InputBinding v3_2 = v8.getQuickChangeBinding();
                    if(v3_2 != null) {
                        v1_2 = v0_5;
                        v10 = v5;
                        v11 = true;
                        v9_1 = v4;
                        v4_1 = arg27;
                        v0_6 = Companion.conflict$default(VistaQuickChangeCoordinator.Companion, v1_2, v2, v3_2, v4_1, null, 16, null);
                        if(v0_6 != null) {
                            return v0_6;
                        }
                    }
                    else {
                        v11 = true;
                        v9_1 = v4;
                        v10 = v5;
                        v4_1 = arg27;
                        v1_2 = v0_5;
                    }

                    String v3_3 = null;
                    if(!v8.getSniperEnabled()) {
                        return v3_3;
                    }

                    v0_4 = v1_2.getControls().iterator();
                    do {
                        if(v0_4.hasNext()) {
                            v5_1 = v0_4.next();
                            if(!(v5_1.getComponent() instanceof ViewComponent)) {
                                continue;
                            }

                            break;
                        }
                        else {
                            goto label_166;
                        }
                    }
                    while(true);

                    goto label_167;
                label_166:
                    v5_1 = v3_3;
                label_167:
                    if(v5_1 != null) {
                        v0_6 = ((ProfileControl)v5_1).getId();
                    }
                    else {
                        Object v0_7 = v3_3;
                    }

                    if(Intrinsics.areEqual(v0_7, v2)) {
                        v0_3 = v1_2.getControls();
                        if(!(v0_3 instanceof Collection) || !v0_3.isEmpty()) {
                            v0_4 = ((Iterable)v0_3).iterator();
                            while(v0_4.hasNext()) {
                                if(!Intrinsics.areEqual(v0_4.next().getId(), v2)) {
                                    continue;
                                }

                                ++v16;
                                if(v16 >= 0) {
                                    continue;
                                }

                                CollectionsKt.throwCountOverflow();
                            }
                        }

                        int v0_8 = v16;
                        if((((boolean)v0_8)) != v11) {
                            return "Sniper corresponde a la primera VISTA del perfil";
                        }

                        InputBinding v0_9 = InputBinding.Companion.fromDisplayName(v8.getSniperKey());
                        if(v0_9 != null) {
                            if(VistaQuickChangeCoordinator.Companion.isBindingAllowed(v0_9)) {
                            }
                            else {
                                v0_9 = ((InputBinding)v3_3);
                            }

                            if(v0_9 == null) {
                                return "La tecla Sniper no es válida; LEFT está reservado para FIRE";
                            }

                            List v2_1 = v1_2.getControls();
                            ArrayList v5_2 = new ArrayList();
                            Iterator v2_2 = ((Iterable)v2_1).iterator();
                            while(v2_2.hasNext()) {
                                CollectionsKt.addAll(((Collection)v5_2), v2_2.next().getBindings().values());
                            }

                            List v1_3 = GameProfileCompiler.compile$default(GameProfileCompiler.INSTANCE, v1_2, ((Function1)v3_3), v10, v3_3);
                            ArrayList v2_3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v1_3), v9_1));
                            Iterator v1_4 = ((Iterable)v1_3).iterator();
                            while(v1_4.hasNext()) {
                                ((Collection)v2_3).add(v1_4.next().getInput());
                            }

                            v1_3 = CollectionsKt.plus(((Collection)v5_2), ((Iterable)v2_3));
                            if(!(v1_3 instanceof Collection) || !v1_3.isEmpty()) {
                                v1_4 = ((Iterable)v1_3).iterator();
                                do {
                                    if(v1_4.hasNext()) {
                                        if(!v4_1.invoke(v1_4.next(), v0_9).booleanValue()) {
                                            continue;
                                        }

                                        return "La tecla Sniper ya pertenece a PRIMARY u otro control";
                                    }

                                    goto label_243;
                                }
                                while(true);

                                return "La tecla Sniper ya pertenece a PRIMARY u otro control";
                            }
                            else {
                            }

                        label_243:
                            InputBinding v1_5 = v8.getQuickChangeBinding();
                            if(v1_5 != null && v4_1.invoke(v1_5, v0_9).booleanValue() == v11) {
                                return "Sniper y Cambio rápido necesitan teclas diferentes";
                            }

                            return v3_3;
                        }

                        return "La tecla Sniper no es válida; LEFT está reservado para FIRE";
                    }

                    return "Sniper corresponde a la primera VISTA del perfil";
                }
            }

            return "El multiplicador Sniper debe ser positivo y finito";
        }

        return "El tiempo debe estar entre 0 y 5 segundos";
    }
}

