package com.TryJeanPc.goldenmouse.mapper;

import android.util.Log;
import com.TryJeanPc.goldenmouse.input.InputEvent$Button;
import com.TryJeanPc.goldenmouse.profile.ControlComponent;
import com.TryJeanPc.goldenmouse.profile.GameProfile;
import com.TryJeanPc.goldenmouse.profile.JoystickComponent;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BJ:\u0010\f\u001A\u0004\u0018\u00010\r2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\u00072\u0018\u0010\u000F\u001A\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0010¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/mapper/FreeLookBindings;", "", "<init>", "()V", "isAllowed", "", "binding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "reservationCount", "", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "conflict", "", "ownerId", "matches", "Lkotlin/Function2;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class FreeLookBindings {
    public static final int $stable;
    public static final FreeLookBindings INSTANCE;

    static {
        FreeLookBindings.INSTANCE = new FreeLookBindings();
    }

    private FreeLookBindings() {
        super();
    }

    public final String conflict(GameProfile arg11, String arg12, InputBinding arg13, Function2 arg14) {
        Object v7_2;
        List v6_1;
        Iterator v0_2;
        int v0;
        Iterator v10_1;
        Intrinsics.checkNotNullParameter(arg11, "profile");
        Intrinsics.checkNotNullParameter(arg12, "ownerId");
        Intrinsics.checkNotNullParameter(arg13, "binding");
        Intrinsics.checkNotNullParameter(arg14, "matches");
        if(!this.isAllowed(arg13)) {
            return FreeLookBindings.conflict$reject(arg12, arg13, "Entrada no válida; LEFT está reservado para FIRE");
        }

        if(!StringsKt.isBlank(arg12)) {
            List v10 = arg11.getVisualControls();
            if(!(v10 instanceof Collection) || !v10.isEmpty()) {
                v10_1 = ((Iterable)v10).iterator();
                v0 = 0;
                while(v10_1.hasNext()) {
                    if(!Intrinsics.areEqual(v10_1.next().getId(), arg12)) {
                        continue;
                    }

                    ++v0;
                    if(v0 >= 0) {
                        continue;
                    }

                    CollectionsKt.throwCountOverflow();
                }
            }
            else {
                v0 = 0;
            }

            if(v0 != 1) {
                goto label_158;
            }

            List v0_1 = arg11.getControls();
            if(!(v0_1 instanceof Collection) || !v0_1.isEmpty()) {
                v0_2 = ((Iterable)v0_1).iterator();
                do {
                    if(v0_2.hasNext()) {
                        if(!Intrinsics.areEqual(v0_2.next().getId(), arg12)) {
                            continue;
                        }

                        break;
                    }

                    goto label_54;
                }
                while(true);

                goto label_158;
            }
            else {
            }

        label_54:
            Function1 v2 = null;
            int v3 = 2;
            v0_1 = GameProfileCompiler.compile$default(GameProfileCompiler.INSTANCE, arg11, v2, v3, v2);
            List v4 = arg11.getControls();
            ArrayList v5 = new ArrayList();
            Iterator v4_1 = ((Iterable)v4).iterator();
            while(v4_1.hasNext()) {
                CollectionsKt.addAll(((Collection)v5), v4_1.next().getBindings().values());
            }

            ArrayList v4_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_1), 10));
            v0_2 = ((Iterable)v0_1).iterator();
            while(v0_2.hasNext()) {
                ((Collection)v4_2).add(v0_2.next().getInput());
            }

            v0_1 = CollectionsKt.plus(((Collection)v5), ((Iterable)v4_2));
            v4 = arg11.getControls();
            v5 = new ArrayList();
            v4_1 = ((Iterable)v4).iterator();
            while(v4_1.hasNext()) {
                ControlComponent v6 = v4_1.next().getComponent();
                if((v6 instanceof ViewComponent)) {
                    InputBinding[] v7 = new InputBinding[v3];
                    v7[0] = ((ViewComponent)v6).getQuickChangeBinding();
                    InputBinding v8 = InputBinding.Companion.fromDisplayName(((ViewComponent)v6).getSniperKey());
                    if(((ViewComponent)v6).getSniperEnabled()) {
                    }
                    else {
                        v8 = ((InputBinding)v2);
                    }

                    v7[1] = v8;
                    v6_1 = CollectionsKt.listOfNotNull(((Object[])v7));
                }
                else {
                    if((v6 instanceof JoystickComponent)) {
                        InputBinding v7_1 = ((JoystickComponent)v6).getSprintBinding();
                        if(((JoystickComponent)v6).getSprintEnabled()) {
                        }
                        else {
                            v7_2 = v2;
                        }

                        v6_1 = CollectionsKt.listOfNotNull(v7_2);
                        goto label_114;
                    }

                    v6_1 = CollectionsKt.emptyList();
                }

            label_114:
                CollectionsKt.addAll(((Collection)v5), ((Iterable)v6_1));
            }

            v10 = CollectionsKt.plus(((Collection)v0_1), ((Iterable)v5));
            List v11 = arg11.getVisualControls();
            ArrayList v0_3 = new ArrayList();
            Iterator v11_1 = ((Iterable)v11).iterator();
            while(v11_1.hasNext()) {
                Object v1 = v11_1.next();
                if(Intrinsics.areEqual(v1.getId(), arg12)) {
                    continue;
                }

                ((Collection)v0_3).add(v1);
            }

            ArrayList v11_2 = new ArrayList();
            v0_2 = ((Iterable)v0_3).iterator();
            while(v0_2.hasNext()) {
                InputBinding v1_1 = v0_2.next().getActivationBinding();
                if(v1_1 == null) {
                    continue;
                }

                ((Collection)v11_2).add(v1_1);
            }

            v10 = CollectionsKt.plus(((Collection)v10), ((Iterable)v11_2));
            if(!(v10 instanceof Collection) || !v10.isEmpty()) {
                v10_1 = ((Iterable)v10).iterator();
                do {
                    if(v10_1.hasNext()) {
                        if(!arg14.invoke(v10_1.next(), arg13).booleanValue()) {
                            continue;
                        }

                        break;
                    }

                    goto label_157;
                }
                while(true);

                return FreeLookBindings.conflict$reject(arg12, arg13, "La tecla ya pertenece a otro control; no se reasignó");
            }
            else {
            }

        label_157:
            return ((String)v2);
        }

    label_158:
        return FreeLookBindings.conflict$reject(arg12, arg13, "El marcador Vista libre ya no está disponible");
    }

    private static final String conflict$reject(String arg2, InputBinding arg3, String arg4) {
        Log.w("GoldenFreeLook", "Binding rechazado marker=" + arg2 + " input=" + arg3.displayName() + ": " + arg4);
        return arg4;
    }

    public final boolean isAllowed(InputBinding arg3) {
        Intrinsics.checkNotNullParameter(arg3, "binding");
        if(!StringsKt.isBlank(arg3.getNormalizedCode()) && !Intrinsics.areEqual(arg3.getNormalizedCode(), "UNKNOWN") && (Intrinsics.areEqual(InputBinding.Companion.fromDisplayName(arg3.displayName()), arg3))) {
            if(arg3.getSource() != InputBindingSource.KEYBOARD) {
                EnumEntries v2 = Button.getEntries();
                if(((v2 instanceof Collection)) && (v2.isEmpty())) {
                    return 0;
                }

                Iterator v2_1 = ((Iterable)v2).iterator();
                do {
                    if(!v2_1.hasNext()) {
                        return 0;
                    }

                    Object v0 = v2_1.next();
                    if(v0 == Button.LEFT) {
                        continue;
                    }

                    if(v0 == Button.UNKNOWN) {
                        continue;
                    }

                    if(!Intrinsics.areEqual(((Button)v0).name(), arg3.getNormalizedCode())) {
                        continue;
                    }

                    return 1;
                }
                while(true);
            }

            return 1;
        }

        return 0;
    }

    public final int reservationCount(GameProfile arg3) {
        Intrinsics.checkNotNullParameter(arg3, "profile");
        List v2 = arg3.getVisualControls();
        int v0 = 0;
        if(!(v2 instanceof Collection) || !v2.isEmpty()) {
            Iterator v2_1 = ((Iterable)v2).iterator();
            do {
                if(v2_1.hasNext()) {
                    InputBinding v3 = v2_1.next().getActivationBinding();
                    if(v3 == null) {
                        continue;
                    }

                    if(!FreeLookBindings.INSTANCE.isAllowed(v3)) {
                        continue;
                    }

                    break;
                }

                return v0;
            }
            while(true);

            v0 = 1;
        }
        else {
        }

        return v0;
    }
}

