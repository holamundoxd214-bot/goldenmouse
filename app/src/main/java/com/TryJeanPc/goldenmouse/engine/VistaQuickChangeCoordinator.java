package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.aim.AimModeTransition$Request;
import com.TryJeanPc.goldenmouse.aim.AimModeTransition$Result;
import com.TryJeanPc.goldenmouse.aim.AimModeTransition$Status;
import com.TryJeanPc.goldenmouse.input.InputEvent$Button;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyDown;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyUp;
import com.TryJeanPc.goldenmouse.input.InputEvent$MouseButton;
import com.TryJeanPc.goldenmouse.input.InputEvent;
import com.TryJeanPc.goldenmouse.mapper.GameProfileCompiler;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.mapper.InputBindingSource;
import com.TryJeanPc.goldenmouse.profile.ControlComponent;
import com.TryJeanPc.goldenmouse.profile.GameProfile;
import com.TryJeanPc.goldenmouse.profile.ProfileControl;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000B\b\u0001\u0018\u0000 B2\u00020\u0001:\u0003@ABB«\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0005\u0012$\u0010\t\u001A \u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n\u0012\u0018\u0010\u000E\u001A\u0014\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\b0\n\u0012\u0014\b\u0002\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0011\u0012(\b\u0002\u0010\u0012\u001A\"\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0005\u0018\u00010\n¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010)\u001A\u00020\u00142\b\u0010*\u001A\u0004\u0018\u00010+2\b\u0010,\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010-\u001A\u00020\u0013J\u0010\u0010.\u001A\u00020\u00142\b\b\u0002\u0010/\u001A\u00020\bJ\u000E\u00100\u001A\u00020\b2\u0006\u00101\u001A\u000202J\u000E\u00103\u001A\u00020\b2\u0006\u00101\u001A\u000202J\u0010\u00104\u001A\u00020\b2\u0006\u00105\u001A\u00020!H\u0002J\"\u00106\u001A\u00020\u00142\u0006\u00105\u001A\u00020!2\u0006\u00107\u001A\u0002082\b\u00109\u001A\u0004\u0018\u00010\rH\u0002J\u0018\u0010:\u001A\u00020\u00142\u0006\u00105\u001A\u00020!2\u0006\u00109\u001A\u00020\rH\u0002J\u0018\u0010;\u001A\u00020\u00142\u0006\u00105\u001A\u00020!2\u0006\u0010<\u001A\u00020\rH\u0002J\u0018\u0010=\u001A\u00020\b2\u0006\u0010>\u001A\u00020\u00062\u0006\u0010,\u001A\u00020\u000FH\u0002J\u0012\u0010?\u001A\u0004\u0018\u00010\u000F2\u0006\u00101\u001A\u000202H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\t\u001A \u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000E\u001A\u0014\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0012\u001A\"\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0005\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u000F0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001D\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010 \u001A\u0004\u0018\u00010!X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010#\u001A\u0004\u0018\u00010\r2\b\u0010\"\u001A\u0004\u0018\u00010\r@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0011\u0010&\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\'\u0010(¨\u0006C"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/VistaQuickChangeCoordinator;", "", "executor", "Ljava/util/concurrent/Executor;", "session", "Lkotlin/Function0;", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Snapshot;", "isAimActive", "", "request", "Lkotlin/Function2;", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;", "Ljava/util/concurrent/CompletableFuture;", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Result;", "matches", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "isConfirmationCurrent", "Lkotlin/Function1;", "schedule", "", "", "<init>", "(Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "lock", "epoch", "Ljava/util/concurrent/atomic/AtomicLong;", "sequenceIds", "held", "", "cancelWait", "configuration", "Lcom/TryJeanPc/goldenmouse/engine/VistaQuickChangeCoordinator$Configuration;", "activeSequence", "Lcom/TryJeanPc/goldenmouse/engine/VistaQuickChangeCoordinator$Sequence;", "value", "lastResult", "getLastResult", "()Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Result;", "busy", "getBusy", "()Z", "configure", "ownerId", "", "binding", "delayMs", "invalidate", "resetHeld", "isConfiguredFor", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "handle", "valid", "sequence", "issue", "phase", "", "previous", "restoreAfterInterval", "finish", "result", "admitted", "snapshot", "inputBinding", "Configuration", "Sequence", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class VistaQuickChangeCoordinator {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\n2\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\nJ\u000E\u0010\u000F\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\n¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/VistaQuickChangeCoordinator$Companion;", "", "<init>", "()V", "conflict", "", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "ownerId", "binding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "matches", "Lkotlin/Function2;", "", "primary", "isBindingAllowed", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final String conflict(GameProfile arg25, String arg26, InputBinding arg27, Function2 arg28, InputBinding arg29) {
            GameProfile v0_1;
            Object v6;
            Function1 v12;
            String v0 = arg26;
            InputBinding v1 = arg27;
            Function2 v2 = arg28;
            InputBinding v3 = arg29;
            GameProfile v5 = arg25;
            Intrinsics.checkNotNullParameter(v5, "profile");
            Intrinsics.checkNotNullParameter(v0, "ownerId");
            Intrinsics.checkNotNullParameter(v1, "binding");
            Intrinsics.checkNotNullParameter(v2, "matches");
            if(!this.isBindingAllowed(v1)) {
                return "Entrada no permitida para Cambio rápido";
            }

            Iterator v4 = v5.getControls().iterator();
            do {
                v12 = null;
                if(v4.hasNext()) {
                    v6 = v4.next();
                    if(!(v6.getComponent() instanceof ViewComponent)) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_29;
                }
            }
            while(true);

            goto label_30;
        label_29:
            v6 = v12;
        label_30:
            if(v6 == null) {
                return "No hay una VISTA propietaria de la cámara";
            }

            if(Intrinsics.areEqual(((ProfileControl)v6).getId(), v0)) {
                List v4_1 = v5.getControls();
                int v7 = 0;
                if(!(v4_1 instanceof Collection) || !v4_1.isEmpty()) {
                    v4 = ((Iterable)v4_1).iterator();
                    while(v4.hasNext()) {
                        if(!Intrinsics.areEqual(v4.next().getId(), v0)) {
                            continue;
                        }

                        ++v7;
                        if(v7 >= 0) {
                            continue;
                        }

                        CollectionsKt.throwCountOverflow();
                    }
                }
                else {
                }

                if(v7 != 1) {
                    return "Cambio rápido corresponde a la primera VISTA del perfil";
                }

                v4_1 = v5.getControls();
                if(!(v4_1 instanceof Collection) || !v4_1.isEmpty()) {
                    v4 = ((Iterable)v4_1).iterator();
                    do {
                        if(v4.hasNext()) {
                            v6 = v4.next();
                            if(Intrinsics.areEqual(((ProfileControl)v6).getId(), v0)) {
                                continue;
                            }

                            ControlComponent v6_1 = ((ProfileControl)v6).getComponent();
                            if((v6_1 instanceof ViewComponent)) {
                            }
                            else {
                                v6_1 = ((ControlComponent)v12);
                            }

                            InputBinding v6_2 = v6_1 != null ? ((ViewComponent)v6_1).getQuickChangeBinding() : ((InputBinding)v12);
                            if(v6_2 == null) {
                                continue;
                            }

                            return "Hay varias asignaciones de Cambio rápido; conserva solo la VISTA propietaria";
                        }

                        goto label_84;
                    }
                    while(true);

                    return "Hay varias asignaciones de Cambio rápido; conserva solo la VISTA propietaria";
                }
                else {
                }

            label_84:
                int v4_2 = 10;
                if(v3 == null) {
                    v0_1 = v5;
                }
                else {
                    List v6_3 = v5.getControls();
                    ArrayList v7_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v6_3), v4_2));
                    Iterator v6_4 = ((Iterable)v6_3).iterator();
                    while(v6_4.hasNext()) {
                        Object v13 = v6_4.next();
                        if(Intrinsics.areEqual(((ProfileControl)v13).getId(), v0)) {
                            ProfileControl v13_1 = ProfileControl.copy$default(((ProfileControl)v13), null, null, 0f, 0f, 0, 0, MapsKt.plus(((ProfileControl)v13).getBindings(), TuplesKt.to("PRIMARY", v3)), null, 0xBF, null);
                        }

                        ((Collection)v7_1).add(v13);
                    }

                    v0_1 = GameProfile.copy$default(v5, null, null, v7_1, null, 11, null);
                }

                List v3_1 = v0_1.getControls();
                ArrayList v5_1 = new ArrayList();
                Iterator v3_2 = ((Iterable)v3_1).iterator();
                while(v3_2.hasNext()) {
                    CollectionsKt.addAll(((Collection)v5_1), v3_2.next().getBindings().values());
                }

                List v0_2 = GameProfileCompiler.compile$default(GameProfileCompiler.INSTANCE, v0_1, v12, 2, v12);
                ArrayList v3_3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_2), v4_2));
                Iterator v0_3 = ((Iterable)v0_2).iterator();
                while(v0_3.hasNext()) {
                    ((Collection)v3_3).add(v0_3.next().getInput());
                }

                v0_2 = CollectionsKt.plus(((Collection)v5_1), ((Iterable)v3_3));
                if(!(v0_2 instanceof Collection) || !v0_2.isEmpty()) {
                    v0_3 = ((Iterable)v0_2).iterator();
                    do {
                        if(v0_3.hasNext()) {
                            if(!v2.invoke(v0_3.next(), v1).booleanValue()) {
                                continue;
                            }

                            return "La tecla ya está asignada al activador principal u otro control; Cambio rápido queda inactivo";
                        }

                        goto label_163;
                    }
                    while(true);

                    return "La tecla ya está asignada al activador principal u otro control; Cambio rápido queda inactivo";
                }
                else {
                }

            label_163:
                return ((String)v12);
            }

            return "Cambio rápido corresponde a la primera VISTA del perfil";
        }

        public static String conflict$default(Companion arg6, GameProfile arg7, String arg8, InputBinding arg9, Function2 arg10, InputBinding arg11, int arg12, Object arg13) {
            if((arg12 & 16) != 0) {
                arg11 = null;
            }

            return arg6.conflict(arg7, arg8, arg9, arg10, arg11);
        }

        public final boolean isBindingAllowed(InputBinding arg3) {
            Intrinsics.checkNotNullParameter(arg3, "binding");
            if((GameProfileCompiler.INSTANCE.isVistaInputAllowed(arg3)) && (Intrinsics.areEqual(InputBinding.Companion.fromDisplayName(arg3.displayName()), arg3)) && !StringsKt.isBlank(arg3.getNormalizedCode()) && !Intrinsics.areEqual(arg3.getNormalizedCode(), "UNKNOWN")) {
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
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/VistaQuickChangeCoordinator$Configuration;", "", "ownerId", "", "binding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "delayMs", "", "<init>", "(Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;J)V", "getOwnerId", "()Ljava/lang/String;", "getBinding", "()Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "getDelayMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Configuration {
        private final InputBinding binding;
        private final long delayMs;
        private final String ownerId;

        public Configuration(String arg2, InputBinding arg3, long arg4) {
            Intrinsics.checkNotNullParameter(arg2, "ownerId");
            Intrinsics.checkNotNullParameter(arg3, "binding");
            super();
            this.ownerId = arg2;
            this.binding = arg3;
            this.delayMs = arg4;
        }

        public final String component1() {
            return this.ownerId;
        }

        public final InputBinding component2() {
            return this.binding;
        }

        public final long component3() {
            return this.delayMs;
        }

        public final Configuration copy(String arg1, InputBinding arg2, long arg3) {
            Intrinsics.checkNotNullParameter(arg1, "ownerId");
            Intrinsics.checkNotNullParameter(arg2, "binding");
            return new Configuration(arg1, arg2, arg3);
        }

        public static Configuration copy$default(Configuration arg0, String arg1, InputBinding arg2, long arg3, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.ownerId;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.binding;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.delayMs;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg6) {
            if(this == (((Configuration)arg6))) {
                return 1;
            }

            if(!(arg6 instanceof Configuration)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.ownerId, ((Configuration)arg6).ownerId)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.binding, ((Configuration)arg6).binding)) {
                return 0;
            }

            if(this.delayMs != ((Configuration)arg6).delayMs) {
                return 0;
            }

            return 1;
        }

        public final InputBinding getBinding() {
            return this.binding;
        }

        public final long getDelayMs() {
            return this.delayMs;
        }

        public final String getOwnerId() {
            return this.ownerId;
        }

        public int hashCode() {
            return (this.ownerId.hashCode() * 0x1F + this.binding.hashCode()) * 0x1F + Long.hashCode(this.delayMs);
        }

        public String toString() {
            return "Configuration(ownerId=" + this.ownerId + ", binding=" + this.binding + ", delayMs=" + this.delayMs + ")";
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001A\u00020\tHÆ\u0003J;\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tHÆ\u0001J\u0013\u0010\u001A\u001A\u00020\t2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2={"Lcom/TryJeanPc/goldenmouse/engine/VistaQuickChangeCoordinator$Sequence;", "", "id", "", "epoch", "sessionId", "configuration", "Lcom/TryJeanPc/goldenmouse/engine/VistaQuickChangeCoordinator$Configuration;", "initial", "", "<init>", "(JJJLcom/TryJeanPc/goldenmouse/engine/VistaQuickChangeCoordinator$Configuration;Z)V", "getId", "()J", "getEpoch", "getSessionId", "getConfiguration", "()Lcom/TryJeanPc/goldenmouse/engine/VistaQuickChangeCoordinator$Configuration;", "getInitial", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Sequence {
        private final Configuration configuration;
        private final long epoch;
        private final long id;
        private final boolean initial;
        private final long sessionId;

        public Sequence(long arg2, long arg4, long arg6, Configuration arg8, boolean arg9) {
            Intrinsics.checkNotNullParameter(arg8, "configuration");
            super();
            this.id = arg2;
            this.epoch = arg4;
            this.sessionId = arg6;
            this.configuration = arg8;
            this.initial = arg9;
        }

        public final long component1() {
            return this.id;
        }

        public final long component2() {
            return this.epoch;
        }

        public final long component3() {
            return this.sessionId;
        }

        public final Configuration component4() {
            return this.configuration;
        }

        public final boolean component5() {
            return this.initial;
        }

        public final Sequence copy(long arg10, long arg12, long arg14, Configuration arg16, boolean arg17) {
            Intrinsics.checkNotNullParameter(arg16, "configuration");
            return new Sequence(arg10, arg12, arg14, arg16, arg17);
        }

        public static Sequence copy$default(Sequence arg9, long arg10, long arg12, long arg14, Configuration arg16, boolean arg17, int arg18, Object arg19) {
            if((arg18 & 1) != 0) {
                arg10 = arg9.id;
            }

            long v1 = arg10;
            if((arg18 & 2) != 0) {
                arg12 = arg9.epoch;
            }

            long v3 = arg12;
            if((arg18 & 4) != 0) {
                arg14 = arg9.sessionId;
            }

            long v5 = arg14;
            Configuration v7 = (arg18 & 8) != 0 ? arg9.configuration : arg16;
            boolean v8 = (arg18 & 16) != 0 ? arg9.initial : arg17;
            return arg9.copy(v1, v3, v5, v7, v8);
        }

        public boolean equals(Object arg8) {
            if(this == (((Sequence)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Sequence)) {
                return 0;
            }

            if(this.id != ((Sequence)arg8).id) {
                return 0;
            }

            if(this.epoch != ((Sequence)arg8).epoch) {
                return 0;
            }

            if(this.sessionId != ((Sequence)arg8).sessionId) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.configuration, ((Sequence)arg8).configuration)) {
                return 0;
            }

            if(this.initial != ((Sequence)arg8).initial) {
                return 0;
            }

            return 1;
        }

        public final Configuration getConfiguration() {
            return this.configuration;
        }

        public final long getEpoch() {
            return this.epoch;
        }

        public final long getId() {
            return this.id;
        }

        public final boolean getInitial() {
            return this.initial;
        }

        public final long getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            return (((Long.hashCode(this.id) * 0x1F + Long.hashCode(this.epoch)) * 0x1F + Long.hashCode(this.sessionId)) * 0x1F + this.configuration.hashCode()) * 0x1F + Boolean.hashCode(this.initial);
        }

        public String toString() {
            return "Sequence(id=" + this.id + ", epoch=" + this.epoch + ", sessionId=" + this.sessionId + ", configuration=" + this.configuration + ", initial=" + this.initial + ")";
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private volatile Sequence activeSequence;
    private Function0 cancelWait;
    private volatile Configuration configuration;
    private final AtomicLong epoch;
    private final Executor executor;
    private final Set held;
    private final Function0 isAimActive;
    private final Function1 isConfirmationCurrent;
    private volatile Result lastResult;
    private final Object lock;
    private final Function2 matches;
    private final Function2 request;
    private final Function2 schedule;
    private final AtomicLong sequenceIds;
    private final Function0 session;

    static {
        VistaQuickChangeCoordinator.Companion = new Companion(null);
        VistaQuickChangeCoordinator.$stable = 8;
    }

    public VistaQuickChangeCoordinator(Executor arg2, Function0 arg3, Function0 arg4, Function2 arg5, Function2 arg6, Function1 arg7, Function2 arg8) {
        Intrinsics.checkNotNullParameter(arg2, "executor");
        Intrinsics.checkNotNullParameter(arg3, "session");
        Intrinsics.checkNotNullParameter(arg4, "isAimActive");
        Intrinsics.checkNotNullParameter(arg5, "request");
        Intrinsics.checkNotNullParameter(arg6, "matches");
        Intrinsics.checkNotNullParameter(arg7, "isConfirmationCurrent");
        super();
        this.executor = arg2;
        this.session = arg3;
        this.isAimActive = arg4;
        this.request = arg5;
        this.matches = arg6;
        this.isConfirmationCurrent = arg7;
        this.schedule = arg8;
        this.lock = new Object();
        this.epoch = new AtomicLong();
        this.sequenceIds = new AtomicLong();
        this.held = new LinkedHashSet();
    }

    public VistaQuickChangeCoordinator(Executor arg9, Function0 arg10, Function0 arg11, Function2 arg12, Function2 arg13, Function1 arg14, Function2 arg15, int arg16, DefaultConstructorMarker arg17) {
        VistaQuickChangeCoordinator$$ExternalSyntheticLambda2 v14;
        if((arg16 & 0x20) != 0) {
            v14 = new VistaQuickChangeCoordinator$$ExternalSyntheticLambda2();
        }

        Function1 v6 = ((Function1)v14);
        Function2 v7 = (arg16 & 0x40) != 0 ? null : arg15;
        this(arg9, arg10, arg11, arg12, arg13, v6, v7);
    }

    static final boolean _init_$lambda$0(Result arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return 1;
    }

    private final boolean admitted(Snapshot arg2, InputBinding arg3) {
        if(arg2.getState() == State.ACTIVE && !arg2.getEditor() && !arg2.getCleanupPending() && (arg2.getMouseConnected()) && (arg2.getInjectorReady()) && arg2.getBackend() != Backend.NONE && (arg2.getProfileLoaded()) && (arg2.getMapperReady()) && (arg2.getCameraReady()) && (arg3.getSource() != InputBindingSource.KEYBOARD || (arg2.getKeyboardConnected()))) {
            return 1;
        }

        return 0;
    }

    public final void configure(String arg9, InputBinding arg10, long arg11) {
        Object v1 = this.lock;
        __monitor_enter(v1);
        try {
            this.invalidate(true);
            String v0_1 = arg9;
            Configuration v0_2 = v0_1 == null || (StringsKt.isBlank(((CharSequence)v0_1))) || arg10 == null || !VistaQuickChangeCoordinator.Companion.isBindingAllowed(arg10) ? null : new Configuration(arg9, arg10, RangesKt.coerceIn(arg11, 0, 5000));
            this.configuration = v0_2;
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
    }

    public static void configure$default(VistaQuickChangeCoordinator arg0, String arg1, InputBinding arg2, long arg3, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = 0;
        }

        arg0.configure(arg1, arg2, arg3);
    }

    private final void finish(Sequence arg3, Result arg4) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.activeSequence == arg3) {
                Function0 v3 = this.cancelWait;
                if(v3 != null) {
                    v3.invoke();
                }

                this.cancelWait = null;
                this.activeSequence = null;
                this.lastResult = arg4;
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public final boolean getBusy() {
        if(this.activeSequence != null) {
            return 1;
        }

        return 0;
    }

    public final Result getLastResult() {
        return this.lastResult;
    }

    public final boolean handle(InputEvent arg13) {
        Result v13_2;
        Sequence v1_1;
        Object v0_2;
        int v13;
        Intrinsics.checkNotNullParameter(arg13, "event");
        Configuration v8 = this.configuration;
        if(v8 == null) {
            return 0;
        }

        InputBinding v1 = this.inputBinding(arg13);
        if(v1 == null) {
            return 0;
        }

        if(!this.matches.invoke(v8.getBinding(), v1).booleanValue()) {
            return 0;
        }

        if(!(arg13 instanceof KeyDown)) {
            if(((arg13 instanceof MouseButton)) && (((MouseButton)arg13).getPressed())) {
                goto label_25;
            }

            v13 = 0;
        }
        else {
        label_25:
            v13 = 1;
        }

        Object v11 = this.lock;
        __monitor_enter(v11);
        try {
            if(this.configuration == v8) {
                goto label_32;
            }
        }
        catch(Throwable v0) {
            goto label_72;
        }

        __monitor_exit(v11);
        return 0;
    label_32:
        Set v0_1 = this.held;
        if(v13 == 0) {
            try {
                v0_1.remove(v1);
            }
            catch(Throwable v0) {
                goto label_72;
            }

            __monitor_exit(v11);
            return 1;
        }

        try {
            boolean v13_1 = ((Collection)v0_1).isEmpty();
            v0_2 = this.session.invoke();
            if((this.held.add(v1)) && (v13_1)) {
                if(!this.admitted(((Snapshot)v0_2), v8.getBinding())) {
                }
                else if(this.activeSequence != null) {
                    goto label_50;
                }
                else {
                    goto label_52;
                }
            }

            goto label_68;
        }
        catch(Throwable v0) {
            goto label_72;
        }

    label_50:
        __monitor_exit(v11);
        return 1;
        try {
        label_52:
            v1_1 = new Sequence(this.sequenceIds.incrementAndGet(), this.epoch.get(), ((Snapshot)v0_2).getSessionId(), v8, this.isAimActive.invoke().booleanValue());
            this.activeSequence = v1_1;
            v13_2 = null;
            this.lastResult = v13_2;
        }
        catch(Throwable v0) {
        label_72:
            __monitor_exit(v11);
            throw v0;
        }

        __monitor_exit(v11);
        this.issue(v1_1, 1, v13_2);
        return 1;
    label_68:
        __monitor_exit(v11);
        return 1;
    }

    private final InputBinding inputBinding(InputEvent arg1) {
        if((arg1 instanceof KeyDown)) {
            return InputBinding.Companion.keyboard(((KeyDown)arg1).getKeyName());
        }

        if((arg1 instanceof KeyUp)) {
            return InputBinding.Companion.keyboard(((KeyUp)arg1).getKeyName());
        }

        if((arg1 instanceof MouseButton)) {
            return InputBinding.Companion.mouse(((MouseButton)arg1).getButton());
        }

        return null;
    }

    public final void invalidate(boolean arg4) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.epoch.incrementAndGet();
            Sequence v1 = null;
            this.activeSequence = v1;
            Function0 v2 = this.cancelWait;
            if(v2 != null) {
                v2.invoke();
            }

            this.cancelWait = ((Function0)v1);
            if(arg4) {
                this.held.clear();
            }
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
    }

    public static void invalidate$default(VistaQuickChangeCoordinator arg0, boolean arg1, int arg2, Object arg3) {
        arg0.invalidate(false);
    }

    public final boolean isConfiguredFor(InputEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        Configuration v0 = this.configuration;
        if(v0 == null) {
            return 0;
        }

        InputBinding v3 = this.inputBinding(arg3);
        if(v3 != null && (this.matches.invoke(v0.getBinding(), v3).booleanValue())) {
            return 1;
        }

        return 0;
    }

    private final void issue(Sequence arg9, int arg10, Result arg11) {
        Object v10;
        boolean v6;
        int v5_1;
        long v1 = arg9.getId();
        long v3 = arg9.getSessionId();
        boolean v5 = true;
        if(arg10 != 1) {
            v5 = arg9.getInitial();
        label_13:
            v6 = v5;
            v5_1 = arg10;
        }
        else if(!arg9.getInitial()) {
            goto label_13;
        }
        else {
            v5_1 = arg10;
            v6 = false;
        }

        Request v0 = new Request(v1, v3, v5_1, v6);
        VistaQuickChangeCoordinator$$ExternalSyntheticLambda3 v1_1 = new VistaQuickChangeCoordinator$$ExternalSyntheticLambda3(this, arg9, new AtomicBoolean(false), arg11);
        long v2 = -1;
        if((this.valid(arg9)) && (arg11 == null || (this.isConfirmationCurrent.invoke(arg11).booleanValue()))) {
            try {
                v10 = this.request.invoke(v0, v1_1);
            }
            catch(Exception ) {
                this.finish(arg9, new Result(v0, v2, Status.FAILED));
                return;
            }

            ((CompletableFuture)v10).whenCompleteAsync(new VistaQuickChangeCoordinator$$ExternalSyntheticLambda5(new VistaQuickChangeCoordinator$$ExternalSyntheticLambda4(this, arg9, v0, v5_1)), this.executor);
            return;
        }

        this.finish(arg9, new Result(v0, v2, Status.CANCELLED));
    }

    static final boolean issue$lambda$6(VistaQuickChangeCoordinator arg1, Sequence arg2, AtomicBoolean arg3, Result arg4) {
        boolean v1;
        if(arg1.valid(arg2)) {
            if(!arg3.get() && arg4 != null && !arg1.isConfirmationCurrent.invoke(arg4).booleanValue()) {
                goto label_12;
            }

            v1 = true;
        }
        else {
        label_12:
            v1 = false;
        }

        if(v1) {
            arg3.set(true);
        }

        return v1;
    }

    static final Unit issue$lambda$7(VistaQuickChangeCoordinator arg7, Sequence arg8, Request arg9, int arg10, Result arg11, Throwable arg12) {
        if(arg7.activeSequence != arg8) {
            return Unit.INSTANCE;
        }

        if(arg12 != null || arg11 == null) {
            arg11 = new Result(arg9, -1, Status.FAILED);
        }
        else {
            if(Intrinsics.areEqual(arg11.getRequest(), arg9)) {
                if(!arg7.valid(arg8)) {
                }
                else {
                    if(arg11.getStatus() == Status.COMPLETED && (!arg7.isConfirmationCurrent.invoke(arg11).booleanValue() || arg7.isAimActive.invoke().booleanValue() != arg9.getActive())) {
                        arg11 = Result.copy$default(arg11, null, 0, Status.STALE, 3, null);
                        goto label_46;
                    }

                    arg11 = arg11;
                    goto label_46;
                }
            }

            arg11 = new Result(arg9, arg11.getCameraRevision(), Status.STALE);
        }

    label_46:
        if(arg11.getStatus() != Status.COMPLETED || arg10 != 1) {
            arg7.finish(arg8, arg11);
        }
        else {
            arg7.restoreAfterInterval(arg8, arg11);
        }

        return Unit.INSTANCE;
    }

    static final void issue$lambda$8(Function2 arg0, Object arg1, Object arg2) {
        arg0.invoke(arg1, arg2);
    }

    private final void restoreAfterInterval(Sequence arg10, Result arg11) {
        long v4;
        Request v3;
        Object v8;
        int v7;
        Status v6;
        Result v2;
        Object v1;
        if(arg10.getConfiguration().getDelayMs() == 0) {
            this.issue(arg10, 2, arg11);
            return;
        }

        try {
            v1 = this.lock;
            __monitor_enter(v1);
        }
        catch(Exception ) {
            v2 = arg11;
            goto label_47;
        }

        try {
            if(this.valid(arg10)) {
                goto label_21;
            }

            v6 = Status.CANCELLED;
            v7 = 3;
            v8 = null;
            v3 = null;
            v4 = 0;
            v2 = arg11;
        }
        catch(Throwable v0) {
            v2 = arg11;
            goto label_43;
        }

        try {
            this.finish(arg10, Result.copy$default(v2, v3, v4, v6, v7, v8));
        }
        catch(Throwable v0) {
            goto label_40;
        }

        try {
            __monitor_exit(v1);
            return;
        }
        catch(Exception ) {
            goto label_47;
        }

    label_21:
        v2 = arg11;
        try {
            Function2 v11 = this.schedule;
            if(v11 == null) {
                goto label_34;
            }

            this.cancelWait = v11.invoke(Long.valueOf(arg10.getConfiguration().getDelayMs()), new VistaQuickChangeCoordinator$$ExternalSyntheticLambda0(this, arg10, v2));
        }
        catch(Throwable v0) {
            goto label_40;
        }

        try {
            __monitor_exit(v1);
            return;
        }
        catch(Exception ) {
            goto label_47;
        }

        try {
        label_34:
            throw new IllegalArgumentException("Missing Vista interval scheduler".toString());
        }
        catch(Throwable v0) {
        label_40:
        }

    label_43:
        Throwable v11_1 = v0;
        try {
            __monitor_exit(v1);
            throw v11_1;
        }
        catch(Exception ) {
        label_47:
            this.finish(arg10, Result.copy$default(v2, null, 0, Status.FAILED, 3, null));
            return;
        }
    }

    static final Unit restoreAfterInterval$lambda$12$lambda$11(VistaQuickChangeCoordinator arg2, Sequence arg3, Result arg4) {
        arg2.executor.execute(new VistaQuickChangeCoordinator$$ExternalSyntheticLambda1(arg2, arg3, arg4));
        return Unit.INSTANCE;
    }

    static final void restoreAfterInterval$lambda$12$lambda$11$lambda$10(VistaQuickChangeCoordinator arg1, Sequence arg2, Result arg3) {
        if(arg1.activeSequence == arg2) {
            arg1.issue(arg2, 2, arg3);
        }
    }

    private final boolean valid(Sequence arg6) {
        Object v0 = this.session.invoke();
        if(this.activeSequence == arg6 && this.epoch.get() == arg6.getEpoch() && this.configuration == arg6.getConfiguration() && ((Snapshot)v0).getSessionId() == arg6.getSessionId() && (this.admitted(((Snapshot)v0), arg6.getConfiguration().getBinding()))) {
            return 1;
        }

        return 0;
    }
}

