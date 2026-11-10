package com.TryJeanPc.goldenmouse.injector;

import android.util.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0001\u0018\u0000 42\u00020\u0001:\u00014B5\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0001\u0012\u000E\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u001B\u001A\u00020\bH\u0002J\u0013\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00100#H\u0000¢\u0006\u0002\b$J\u0010\u0010%\u001A\u00020\u00112\u0006\u0010&\u001A\u00020\'H\u0016J\u0010\u0010(\u001A\u00020\u00112\u0006\u0010&\u001A\u00020\'H\u0016J\u0018\u0010)\u001A\u00020\u00112\u0006\u0010&\u001A\u00020\'2\u0006\u0010*\u001A\u00020\u0011H\u0002J\u0010\u0010+\u001A\u00020\u00112\u0006\u0010&\u001A\u00020\'H\u0016J\b\u0010,\u001A\u00020\u0011H\u0002J\u0018\u0010-\u001A\u00020\u00112\u0006\u0010.\u001A\u00020\u00112\u0006\u0010/\u001A\u00020\u0005H\u0002J \u00100\u001A\u00020\t2\u0006\u0010&\u001A\u00020\'2\u0006\u00101\u001A\u00020\u00112\u0006\u0010/\u001A\u00020\u0005H\u0002J\u000E\u00102\u001A\u00020\u00112\u0006\u00103\u001A\u00020\u0011R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001A\u0004\u0018\u00010\b2\b\u0010\u0017\u001A\u0004\u0018\u00010\b@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001C\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010!¨\u00065"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/SessionInjectionBackend;", "Lcom/TryJeanPc/goldenmouse/injector/InjectionBackend;", "delegate", "now", "Lkotlin/Function0;", "", "onFailure", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/injector/InjectionBackend;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "contactLock", "", "contacts", "", "", "", "failureReported", "epoch", "Ljava/util/concurrent/atomic/AtomicLong;", "knownRegistry", "registryLost", "value", "recoveryError", "getRecoveryError", "()Ljava/lang/String;", "lostRegistryMessage", "confirmedCancelEpoch", "getConfirmedCancelEpoch", "()J", "supportsAsyncMoves", "getSupportsAsyncMoves", "()Z", "uncertainPointerIds", "", "uncertainPointerIds$app", "execute", "command", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "executeConfirmed", "dispatch", "confirmed", "executeMove", "registryMatches", "recordRegistryAfterExecute", "hadContacts", "generation", "recordResult", "accepted", "cancelSession", "backendReady", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class SessionInjectionBackend implements InjectionBackend {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/SessionInjectionBackend$Companion;", "", "<init>", "()V", "TAG", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Action.values().length];
            try {
                v0[Action.ACTION_DOWN.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Action.ACTION_UP.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Action.ACTION_MOVE.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[Action.ACTION_CANCEL.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 0;
    private static final Companion Companion = null;
    @Deprecated public static final String TAG = "GOLDEN_CONTROL_INPUT";
    private final Object contactLock;
    private final Map contacts;
    private final InjectionBackend delegate;
    private final AtomicLong epoch;
    private boolean failureReported;
    private Object knownRegistry;
    private final Function0 now;
    private final Function1 onFailure;
    private volatile String recoveryError;
    private boolean registryLost;

    static {
        SessionInjectionBackend.Companion = new Companion(null);
        SessionInjectionBackend.$stable = 8;
    }

    public SessionInjectionBackend(InjectionBackend arg1, Function0 arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        com.TryJeanPc.goldenmouse.injector.SessionInjectionBackend$1 v2;
        DefaultInjectionBackend v1;
        if((arg4 & 1) != 0) {
            v1 = DefaultInjectionBackend.INSTANCE;
        }

        if((arg4 & 2) != 0) {
            v2 = com.TryJeanPc.goldenmouse.injector.SessionInjectionBackend$1.INSTANCE;
        }

        this(((InjectionBackend)v1), ((Function0)v2), arg3);
    }

    public SessionInjectionBackend(InjectionBackend arg2, Function0 arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "delegate");
        Intrinsics.checkNotNullParameter(arg3, "now");
        Intrinsics.checkNotNullParameter(arg4, "onFailure");
        super();
        this.delegate = arg2;
        this.now = arg3;
        this.onFailure = arg4;
        this.contactLock = new Object();
        this.contacts = new LinkedHashMap();
        this.epoch = new AtomicLong();
    }

    public final boolean cancelSession(boolean arg15) {
        Object v0_1;
        TouchCommand v4;
        Throwable v15;
        boolean v1;
        __monitor_enter(this);
        try {
            v1 = false;
            if(this.registryMatches()) {
                goto label_6;
            }
        }
        catch(Throwable v0) {
            goto label_68;
        }

        __monitor_exit(this);
        return 0;
    label_6:
        Object v2 = this.contactLock;
        if(!arg15) {
            try {
                __monitor_enter(v2);
            }
            catch(Throwable v0) {
                goto label_68;
            }

            try {
                arg15 = this.contacts.isEmpty();
                goto label_11;
            }
            catch(Throwable v0) {
                v15 = v0;
                try {
                    __monitor_exit(v2);
                    throw v15;
                label_11:
                    __monitor_exit(v2);
                }
                catch(Throwable v0) {
                    goto label_68;
                }
            }

            __monitor_exit(this);
            return arg15;
        }

        try {
            __monitor_enter(v2);
        }
        catch(Throwable v0) {
            goto label_68;
        }

        try {
            int v15_1 = this.contacts.isEmpty() ^ 1;
            goto label_23;
        }
        catch(Throwable v0) {
            v15 = v0;
            try {
                __monitor_exit(v2);
                throw v15;
            label_23:
                __monitor_exit(v2);
                v4 = new TouchCommand(Action.ACTION_CANCEL, 0f, 0f, 0, this.now.invoke().longValue(), null, 0x20, null);
            }
            catch(Throwable v0) {
                goto label_68;
            }
        }

        try {
            v0_1 = Result.constructor-impl(Boolean.valueOf(this.delegate.execute(v4)));
            goto label_47;
        }
        catch(Throwable v0) {
            try {
                v0_1 = Result.constructor-impl(ResultKt.createFailure(v0));
            label_47:
                Boolean v2_1 = Boolean.valueOf(false);
                if(Result.isFailure-impl(v0_1)) {
                    Boolean v0_2 = v2_1;
                }

                if((v0_2.booleanValue()) && (this.recordRegistryAfterExecute(((boolean)v15_1), this.epoch.get()))) {
                    v1 = true;
                }

                this.recordResult(v4, v1, this.epoch.get());
                goto label_61;
            label_68:
                v15 = v0;
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_68;
            }
        }

        throw v15;
    label_61:
        __monitor_exit(this);
        return v1;
    }

    private final boolean dispatch(TouchCommand arg9, boolean arg10) {
        Object v10_1;
        boolean v2;
        Long v0 = arg9.getExpectedContactEpoch();
        boolean v1 = false;
        if(v0 != null && ((Number)v0).longValue() != this.epoch.get()) {
            return 0;
        }

        if(!this.registryMatches()) {
            return 0;
        }

        Object v0_1 = this.contactLock;
        __monitor_enter(v0_1);
        try {
            v2 = this.contacts.isEmpty();
        }
        catch(Throwable v8) {
            __monitor_exit(v0_1);
            throw v8;
        }

        int v2_1 = (((int)v2)) ^ 1;
        __monitor_exit(v0_1);
        v0_1 = this.contactLock;
        __monitor_enter(v0_1);
        try {
            if(arg9.getAction() == Action.ACTION_CANCEL) {
                Set v4 = this.contacts.keySet();
                if(((v4 instanceof Collection)) && (v4.isEmpty())) {
                    goto label_40;
                }

                Iterator v4_1 = ((Iterable)v4).iterator();
                do {
                    if(!v4_1.hasNext()) {
                        goto label_40;
                    }

                    if(v4_1.next().intValue() == arg9.getPointerId()) {
                        continue;
                    }

                    goto label_38;
                }
                while(true);
            }

            goto label_40;
        }
        catch(Throwable v8) {
            goto label_125;
        }

    label_38:
        __monitor_exit(v0_1);
        return 0;
        try {
        label_40:
            if(arg9.getAction() == Action.ACTION_DOWN) {
                if(this.contacts.containsKey(Integer.valueOf(arg9.getPointerId()))) {
                    goto label_48;
                }
                else {
                    goto label_50;
                }
            }

            goto label_55;
        }
        catch(Throwable v8) {
            goto label_125;
        }

    label_48:
        __monitor_exit(v0_1);
        return 0;
        try {
        label_50:
            this.contacts.put(Integer.valueOf(arg9.getPointerId()), Boolean.valueOf(true));
        label_55:
        }
        catch(Throwable v8) {
        label_125:
            __monitor_exit(v0_1);
            throw v8;
        }

        __monitor_exit(v0_1);
        if(arg9.getAction() != Action.ACTION_MOVE) {
            Log.d("GOLDEN_CONTROL_INPUT", "CONTROL enviado action=" + arg9.getAction() + " pointer=" + arg9.getPointerId());
        }

        try {
            InjectionBackend v0_2 = this.delegate;
            arg10 = arg10 ? v0_2.executeConfirmed(arg9) : v0_2.execute(arg9);
            v10_1 = Result.constructor-impl(Boolean.valueOf(arg10));
        }
        catch(Throwable v10) {
            v10_1 = Result.constructor-impl(ResultKt.createFailure(v10));
        }

        Boolean v0_3 = Boolean.valueOf(false);
        if(Result.isFailure-impl(v10_1)) {
            Boolean v10_2 = v0_3;
        }

        arg10 = ((Boolean)v10_1).booleanValue();
        boolean v0_4 = this.recordRegistryAfterExecute(((boolean)v2_1), this.epoch.get());
        v2 = !arg10 || !v0_4 ? false : true;
        this.recordResult(arg9, v2, this.epoch.get());
        if(arg9.getAction() != Action.ACTION_MOVE) {
            Log.d("GOLDEN_CONTROL_INPUT", "CONTROL resultado accepted=" + arg10 + " action=" + arg9.getAction() + " pointer=" + arg9.getPointerId());
        }

        if((arg10) && (v0_4)) {
            v1 = true;
        }

        return v1;
    }

    public boolean execute(TouchCommand arg2) {
        boolean v2_1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg2, "command");
            v2_1 = this.dispatch(arg2, false);
        }
        catch(Throwable v2) {
            try {
            label_8:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_8;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v2_1;
    }

    public boolean executeConfirmed(TouchCommand arg2) {
        boolean v2_1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg2, "command");
            v2_1 = this.dispatch(arg2, true);
        }
        catch(Throwable v2) {
            try {
            label_8:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_8;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v2_1;
    }

    public boolean executeMove(TouchCommand arg9) {
        Boolean v0_3;
        boolean v2;
        Intrinsics.checkNotNullParameter(arg9, "command");
        if(arg9.getAction() != Action.ACTION_MOVE) {
            return this.execute(arg9);
        }

        boolean v1 = false;
        if(!this.registryMatches()) {
            return 0;
        }

        Object v0 = this.contactLock;
        __monitor_enter(v0);
        try {
            v2 = this.contacts.isEmpty();
        }
        catch(Throwable v8) {
            __monitor_exit(v0);
            throw v8;
        }

        int v2_1 = (((int)v2)) ^ 1;
        __monitor_exit(v0);
        long v4 = this.epoch.get();
        Long v0_1 = arg9.getExpectedContactEpoch();
        if(v0_1 != null && ((Number)v0_1).longValue() != v4) {
            return 0;
        }

        try {
            v0 = Result.constructor-impl(Boolean.valueOf(this.delegate.executeMove(arg9)));
        }
        catch(Throwable v0_2) {
            v0 = Result.constructor-impl(ResultKt.createFailure(v0_2));
        }

        Boolean v6 = Boolean.valueOf(false);
        if(Result.isFailure-impl(v0)) {
            v0_3 = v6;
        }

        boolean v0_4 = v0_3.booleanValue();
        if(v4 != this.epoch.get()) {
            return 0;
        }

        v2 = this.recordRegistryAfterExecute(((boolean)v2_1), v4);
        boolean v6_1 = !v0_4 || !v2 ? false : true;
        this.recordResult(arg9, v6_1, v4);
        if((v0_4) && (v2)) {
            v1 = true;
        }

        return v1;
    }

    public long getConfirmedCancelEpoch() {
        return this.epoch.get();
    }

    public Object getContactRegistryIdentity() {
        return InjectionBackend.super.getContactRegistryIdentity();
    }

    public final String getRecoveryError() {
        return this.recoveryError;
    }

    public boolean getSupportsAsyncMoves() {
        return this.delegate.getSupportsAsyncMoves();
    }

    private final String lostRegistryMessage() {
        return "Registro remoto reemplazado con contactos pendientes. Recuperación automática bloqueada: falta confirmar la liberación en el backend original.";
    }

    private final boolean recordRegistryAfterExecute(boolean arg5, long arg6) {
        boolean v7;
        Object v0 = this.contactLock;
        __monitor_enter(v0);
        try {
            int v6 = Long.compare(arg6, this.epoch.get());
            v7 = false;
            if(v6 != 0) {
            }
            else {
                Object v6_1 = this.delegate.getContactRegistryIdentity();
                if(arg5) {
                    Object v5 = this.knownRegistry;
                    if(v5 != null && v5 != v6_1) {
                        this.registryLost = true;
                        this.recoveryError = this.lostRegistryMessage();
                        Iterator v5_1 = CollectionsKt.toList(this.contacts.keySet()).iterator();
                        while(true) {
                            if(v5_1.hasNext()) {
                                this.contacts.put(Integer.valueOf(v5_1.next().intValue()), Boolean.valueOf(true));
                                continue;
                            }
                            else {
                                goto label_35;
                            }
                        }
                    }
                }

                this.knownRegistry = v6_1;
                if(this.registryLost) {
                    goto label_35;
                }

                goto label_34;
            }

            goto label_35;
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

    label_34:
        v7 = true;
    label_35:
        __monitor_exit(v0);
        return v7;
    }

    private final void recordResult(TouchCommand arg5, boolean arg6, long arg7) {
        Object v0 = this.contactLock;
        __monitor_enter(v0);
        try {
            if(arg7 == this.epoch.get()) {
                goto label_7;
            }
        }
        catch(Throwable v4) {
            goto label_92;
        }

        __monitor_exit(v0);
        return;
    label_7:
        int v7 = 1;
        int v8 = 0;
        if(arg6) {
            try {
                int v6 = WhenMappings.$EnumSwitchMapping$0[arg5.getAction().ordinal()];
                if(v6 == 1) {
                    this.contacts.put(Integer.valueOf(arg5.getPointerId()), Boolean.valueOf(false));
                    goto label_74;
                label_47:
                    Action v6_1 = arg5.getAction();
                    Action v1 = Action.ACTION_CANCEL;
                    goto label_49;
                }
                else if(v6 == 2) {
                    this.contacts.remove(Integer.valueOf(arg5.getPointerId()));
                }
                else if(v6 == 3) {
                }
                else if(v6 == 4) {
                    this.contacts.clear();
                    this.knownRegistry = null;
                    this.failureReported = false;
                    Long.valueOf(this.epoch.incrementAndGet());
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            catch(Throwable v4) {
                goto label_92;
            }
        }
        else {
            goto label_47;
        label_49:
            Map v2 = this.contacts;
            if(v6_1 == v1) {
                try {
                    Iterator v6_2 = CollectionsKt.toList(v2.keySet()).iterator();
                    while(true) {
                        if(v6_2.hasNext()) {
                            this.contacts.put(Integer.valueOf(v6_2.next().intValue()), Boolean.valueOf(true));
                            continue;
                        }

                        goto label_67;
                    }

                label_63:
                    v2.put(Integer.valueOf(arg5.getPointerId()), Boolean.valueOf(true));
                label_67:
                    if(!this.failureReported) {
                        this.failureReported = true;
                    }
                    else {
                        v7 = 0;
                    }

                    v8 = v7;
                    goto label_74;
                }
                catch(Throwable v4) {
                label_92:
                    __monitor_exit(v0);
                    throw v4;
                }
            }
            else {
                goto label_63;
            }

            goto label_67;
        }

    label_74:
        __monitor_exit(v0);
        if(v8 != 0) {
            Function1 v6_3 = this.onFailure;
            String v4_1 = this.recoveryError;
            if(v4_1 == null) {
                v4_1 = "Inyección rechazada: " + arg5.getAction() + ", pointer=" + arg5.getPointerId();
            }

            v6_3.invoke(v4_1);
        }
    }

    private final boolean registryMatches() {
        int v1;
        boolean v2;
        Object v0 = this.contactLock;
        __monitor_enter(v0);
        try {
            v2 = false;
            if(this.registryLost) {
                v1 = 0;
            }
            else {
                if(!this.contacts.isEmpty()) {
                    Object v1_1 = this.knownRegistry;
                    if(v1_1 != null && v1_1 != this.delegate.getContactRegistryIdentity()) {
                        this.registryLost = true;
                        Iterator v1_2 = CollectionsKt.toList(this.contacts.keySet()).iterator();
                        while(v1_2.hasNext()) {
                            this.contacts.put(Integer.valueOf(v1_2.next().intValue()), Boolean.valueOf(true));
                        }

                        this.recoveryError = this.lostRegistryMessage();
                        v1 = this.failureReported ^ 1;
                        this.failureReported = true;
                        String v3 = "GOLDEN_CONTROL_INPUT";
                        String v4 = this.recoveryError;
                        if(v4 != null) {
                            Log.e(v3, v4);
                            goto label_47;
                        }
                        else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                }

                goto label_45;
            }

            goto label_47;
        }
        catch(Throwable v7) {
            __monitor_exit(v0);
            throw v7;
        }

    label_45:
        v1 = 0;
        v2 = true;
    label_47:
        __monitor_exit(v0);
        if(v1 != 0) {
            Function1 v0_1 = this.onFailure;
            String v7_1 = this.recoveryError;
            if(v7_1 != null) {
                v0_1.invoke(v7_1);
                return v2;
            }

            throw new IllegalArgumentException("Required value was null.".toString());
        }

        return v2;
    }

    public final Set uncertainPointerIds$app() {
        Set v4_3;
        Object v0 = this.contactLock;
        __monitor_enter(v0);
        try {
            Map v4_1 = this.contacts;
            LinkedHashMap v1 = new LinkedHashMap();
            Iterator v4_2 = v4_1.entrySet().iterator();
            while(v4_2.hasNext()) {
                Object v2 = v4_2.next();
                if(!((Map$Entry)v2).getValue().booleanValue()) {
                    continue;
                }

                v1.put(((Map$Entry)v2).getKey(), ((Map$Entry)v2).getValue());
            }

            v4_3 = CollectionsKt.toSet(((Map)v1).keySet());
        }
        catch(Throwable v4) {
            goto label_22;
        }

        __monitor_exit(v0);
        return v4_3;
    label_22:
        __monitor_exit(v0);
        throw v4;
    }
}

