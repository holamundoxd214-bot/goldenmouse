package com.flyfishxu.kadb.cert;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nJ\u0006\u0010\u0010\u001A\u00020\u0011J\u0006\u0010\u0012\u001A\u00020\u0011J\u001A\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u000B2\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u000BJ\u000E\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u000BJ\b\u0010\u0017\u001A\u0004\u0018\u00010\u0011J\b\u0010\u0018\u001A\u0004\u0018\u00010\u000BJ\u0006\u0010\u0019\u001A\u00020\u000FJ\r\u0010\u001A\u001A\u00020\u001BH\u0000¢\u0006\u0002\b\u001CJ\r\u0010\u001D\u001A\u00020\u001EH\u0000¢\u0006\u0002\b\u001FJ\b\u0010 \u001A\u00020!H\u0002J\b\u0010\"\u001A\u00020!H\u0002J\b\u0010#\u001A\u00020!H\u0002J\u001A\u0010$\u001A\u00020%2\u0006\u0010\u0014\u001A\u00020\u000B2\b\u0010\u0015\u001A\u0004\u0018\u00010\u000BH\u0002J\u0010\u0010&\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u000BH\u0002J\n\u0010\'\u001A\u0004\u0018\u00010\u000BH\u0002J\u0010\u0010(\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u000BH\u0002J\u0010\u0010)\u001A\u00020\u001E2\u0006\u0010*\u001A\u00020\u001BH\u0002J\u0010\u0010+\u001A\u00020\u000F2\u0006\u0010\u0007\u001A\u00020\bH\u0002J\u0010\u0010,\u001A\u00020-2\u0006\u0010.\u001A\u00020/H\u0002R\u000E\u0010\u0004\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u00061"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCert;", "", "<init>", "()V", "lock", "store", "Lcom/flyfishxu/kadb/cert/KadbPrivateKeyStore;", "policy", "Lcom/flyfishxu/kadb/cert/KadbCertPolicy;", "additionalPrivateKeysPem", "", "", "state", "Lcom/flyfishxu/kadb/cert/KadbCert$State;", "configure", "", "ensureReady", "Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", "rotate", "importIdentity", "privateKeyPem", "certificatePem", "importPrivateKey", "exportIdentityOrNull", "exportPrivateKeyOrNull", "clear", "currentKeyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "currentKeyPair$kadb", "currentKeySet", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "currentKeySet$kadb", "ensureReadyStateLocked", "Lcom/flyfishxu/kadb/cert/KadbCert$State$Ready;", "loadOrGenerateState", "regenerateAndPersistState", "resolveImportedIdentity", "Lcom/flyfishxu/kadb/cert/ResolvedIdentity;", "validatePrivateKeyOrThrow", "readPrivateKeyFromStoreOrThrow", "writePrivateKeyOrThrow", "resolveHostKeySet", "defaultKeyPair", "validatePolicy", "toKadbCertException", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "error", "", "State", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class KadbCert {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCert$State;", "", "Uninitialized", "Ready", "Broken", "Lcom/flyfishxu/kadb/cert/KadbCert$State$Broken;", "Lcom/flyfishxu/kadb/cert/KadbCert$State$Ready;", "Lcom/flyfishxu/kadb/cert/KadbCert$State$Uninitialized;", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) interface State {
        @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000E\u001A\u00020\u000FHÖ\u0081\u0004J\n\u0010\u0010\u001A\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCert$State$Broken;", "Lcom/flyfishxu/kadb/cert/KadbCert$State;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Broken implements State {
            private final Throwable cause;

            public Broken(Throwable arg2) {
                Intrinsics.checkNotNullParameter(arg2, "cause");
                super();
                this.cause = arg2;
            }

            public final Throwable component1() {
                return this.cause;
            }

            public final Broken copy(Throwable arg1) {
                Intrinsics.checkNotNullParameter(arg1, "cause");
                return new Broken(arg1);
            }

            public static Broken copy$default(Broken arg0, Throwable arg1, int arg2, Object arg3) {
                if((arg2 & 1) != 0) {
                    arg1 = arg0.cause;
                }

                return arg0.copy(arg1);
            }

            public boolean equals(Object arg4) {
                if(this == (((Broken)arg4))) {
                    return 1;
                }

                if(!(arg4 instanceof Broken)) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.cause, ((Broken)arg4).cause)) {
                    return 0;
                }

                return 1;
            }

            public final Throwable getCause() {
                return this.cause;
            }

            public int hashCode() {
                return this.cause.hashCode();
            }

            public String toString() {
                return "Broken(cause=" + this.cause + ")";
            }
        }

        @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0014\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001A\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001A\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0017"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCert$State$Ready;", "Lcom/flyfishxu/kadb/cert/KadbCert$State;", "snapshot", "Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", "keySet", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "<init>", "(Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;Lcom/flyfishxu/kadb/cert/HostKeySet;)V", "getSnapshot", "()Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", "getKeySet", "()Lcom/flyfishxu/kadb/cert/HostKeySet;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Ready implements State {
            private final HostKeySet keySet;
            private final KadbIdentitySnapshot snapshot;

            public Ready(KadbIdentitySnapshot arg2, HostKeySet arg3) {
                Intrinsics.checkNotNullParameter(arg2, "snapshot");
                Intrinsics.checkNotNullParameter(arg3, "keySet");
                super();
                this.snapshot = arg2;
                this.keySet = arg3;
            }

            public final KadbIdentitySnapshot component1() {
                return this.snapshot;
            }

            public final HostKeySet component2() {
                return this.keySet;
            }

            public final Ready copy(KadbIdentitySnapshot arg1, HostKeySet arg2) {
                Intrinsics.checkNotNullParameter(arg1, "snapshot");
                Intrinsics.checkNotNullParameter(arg2, "keySet");
                return new Ready(arg1, arg2);
            }

            public static Ready copy$default(Ready arg0, KadbIdentitySnapshot arg1, HostKeySet arg2, int arg3, Object arg4) {
                if((arg3 & 1) != 0) {
                    arg1 = arg0.snapshot;
                }

                if((arg3 & 2) != 0) {
                    arg2 = arg0.keySet;
                }

                return arg0.copy(arg1, arg2);
            }

            public boolean equals(Object arg5) {
                if(this == (((Ready)arg5))) {
                    return 1;
                }

                if(!(arg5 instanceof Ready)) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.snapshot, ((Ready)arg5).snapshot)) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.keySet, ((Ready)arg5).keySet)) {
                    return 0;
                }

                return 1;
            }

            public final HostKeySet getKeySet() {
                return this.keySet;
            }

            public final KadbIdentitySnapshot getSnapshot() {
                return this.snapshot;
            }

            public int hashCode() {
                return this.snapshot.hashCode() * 0x1F + this.keySet.hashCode();
            }

            public String toString() {
                return "Ready(snapshot=" + this.snapshot + ", keySet=" + this.keySet + ")";
            }
        }

        @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001A\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001A\u00020\u000BHÖ\u0081\u0004¨\u0006\f"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCert$State$Uninitialized;", "Lcom/flyfishxu/kadb/cert/KadbCert$State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Uninitialized implements State {
            public static final Uninitialized INSTANCE;

            static {
                Uninitialized.INSTANCE = new Uninitialized();
            }

            private Uninitialized() {
                super();
            }

            public boolean equals(Object arg2) {
                if(this == (((Uninitialized)arg2))) {
                    return 1;
                }

                if(!(arg2 instanceof Uninitialized)) {
                    return 0;
                }

                return 1;
            }

            public int hashCode() {
                return 895384043;
            }

            public String toString() {
                return "Uninitialized";
            }
        }

    }

    public static final KadbCert INSTANCE;
    private static volatile List additionalPrivateKeysPem;
    private static final Object lock;
    private static volatile KadbCertPolicy policy;
    private static volatile State state;
    private static volatile KadbPrivateKeyStore store;

    static {
        KadbCert.INSTANCE = new KadbCert();
        KadbCert.lock = new Object();
        KadbCert.store = new InMemoryPrivateKeyStore();
        KadbCert.policy = new KadbCertPolicy(0, 0, false, null, 15, null);
        KadbCert.additionalPrivateKeysPem = CollectionsKt.emptyList();
        KadbCert.state = Uninitialized.INSTANCE;
    }

    private KadbCert() {
        super();
    }

    public final void clear() {
        Object v2 = KadbCert.lock;
        __monitor_enter(v2);
        try {
            KadbCert.store.clear();
            KadbCert.state = Uninitialized.INSTANCE;
            goto label_6;
        }
        catch(Throwable v0) {
            try {
                throw new StoreWriteFailed(v0);
            label_6:
            }
            catch(Throwable v0) {
                __monitor_exit(v2);
                throw v0;
            }
        }

        __monitor_exit(v2);
    }

    public final void configure(KadbPrivateKeyStore arg2, KadbCertPolicy arg3, List arg4) {
        Object v4;
        Intrinsics.checkNotNullParameter(arg2, "store");
        Intrinsics.checkNotNullParameter(arg3, "policy");
        Intrinsics.checkNotNullParameter(arg4, "additionalPrivateKeysPem");
        this.validatePolicy(arg3);
        Object v1 = KadbCert.lock;
        __monitor_enter(v1);
        try {
            KadbCert.store = arg2;
            KadbCert.policy = arg3;
            ArrayList v2_1 = new ArrayList();
            Iterator v3 = ((Iterable)arg4).iterator();
            while(v3.hasNext()) {
                v4 = v3.next();
                int v0 = v4.length == 0 ? 1 : 0;
                if(v0 != 0) {
                    continue;
                }

                ((Collection)v2_1).add(v4);
            }

            ArrayList v3_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v2_1), 10));
            Iterator v2_2 = ((Iterable)v2_1).iterator();
            while(v2_2.hasNext()) {
                v4 = v2_2.next();
                byte[] v4_1 = Arrays.copyOf(((byte[])v4), v4.length);
                Intrinsics.checkNotNullExpressionValue(v4_1, "copyOf(...)");
                ((Collection)v3_1).add(v4_1);
            }

            KadbCert.additionalPrivateKeysPem = ((List)v3_1);
            KadbCert.state = Uninitialized.INSTANCE;
        }
        catch(Throwable v2) {
            goto label_47;
        }

        __monitor_exit(v1);
        return;
    label_47:
        __monitor_exit(v1);
        throw v2;
    }

    public static void configure$default(KadbCert arg7, KadbPrivateKeyStore arg8, KadbCertPolicy arg9, List arg10, int arg11, Object arg12) {
        if((arg11 & 2) != 0) {
            arg9 = new KadbCertPolicy(0, 0, false, null, 15, null);
        }

        if((arg11 & 4) != 0) {
            arg10 = CollectionsKt.emptyList();
        }

        arg7.configure(arg8, arg9, arg10);
    }

    public final AdbKeyPair currentKeyPair$kadb() {
        AdbKeyPair v0_1;
        Object v1 = KadbCert.lock;
        __monitor_enter(v1);
        try {
            v0_1 = KadbCert.INSTANCE.ensureReadyStateLocked().getKeySet().getDefaultKeyPair();
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v0_1;
    }

    public final HostKeySet currentKeySet$kadb() {
        HostKeySet v0_1;
        Object v1 = KadbCert.lock;
        __monitor_enter(v1);
        try {
            v0_1 = KadbCert.INSTANCE.ensureReadyStateLocked().getKeySet();
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v0_1;
    }

    public final KadbIdentitySnapshot ensureReady() {
        KadbIdentitySnapshot v0_1;
        Object v1 = KadbCert.lock;
        __monitor_enter(v1);
        try {
            v0_1 = KadbCert.INSTANCE.ensureReadyStateLocked().getSnapshot().deepCopy$kadb();
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v0_1;
    }

    private final Ready ensureReadyStateLocked() {
        State v0 = KadbCert.state;
        if((v0 instanceof Ready)) {
            return ((Ready)v0);
        }

        try {
            Ready v0_2 = this.loadOrGenerateState();
            KadbCert.state = v0_2;
            return v0_2;
        }
        catch(Throwable v0_1) {
            KadbCert.state = new Broken(v0_1);
            throw this.toKadbCertException(v0_1);
        }
    }

    public final KadbIdentitySnapshot exportIdentityOrNull() {
        KadbIdentitySnapshot v2;
        KadbIdentitySnapshot v0_2;
        Object v4 = KadbCert.lock;
        __monitor_enter(v4);
        try {
            State v0_1 = KadbCert.state;
            if((v0_1 instanceof Ready)) {
                v0_2 = ((Ready)v0_1).getSnapshot().deepCopy$kadb();
                goto label_22;
            }
            else {
                KadbCert v0_3 = KadbCert.INSTANCE;
                byte[] v1 = v0_3.readPrivateKeyFromStoreOrThrow();
                v2 = null;
                if(v1 == null) {
                }
                else if(v1.length == 0) {
                }
                else {
                    v0_3.validatePrivateKeyOrThrow(v1);
                    v0_2 = CertUtils.INSTANCE.identityFromPrivateKey(v1, KadbCert.policy).getSnapshot().deepCopy$kadb();
                    goto label_22;
                }
            }

            goto label_23;
        }
        catch(Throwable v0) {
            __monitor_exit(v4);
            throw v0;
        }

    label_22:
        v2 = v0_2;
    label_23:
        __monitor_exit(v4);
        return v2;
    }

    public final byte[] exportPrivateKeyOrNull() {
        byte[] v0_2;
        Object v2 = KadbCert.lock;
        __monitor_enter(v2);
        try {
            State v0_1 = KadbCert.state;
            if((v0_1 instanceof Ready)) {
                v0_2 = ((Ready)v0_1).getSnapshot().getPrivateKeyPem();
                v0_2 = Arrays.copyOf(v0_2, v0_2.length);
                Intrinsics.checkNotNullExpressionValue(v0_2, "copyOf(...)");
            }
            else {
                v0_2 = KadbCert.INSTANCE.readPrivateKeyFromStoreOrThrow();
                if(v0_2 != null) {
                    v0_2 = Arrays.copyOf(v0_2, v0_2.length);
                    Intrinsics.checkNotNullExpressionValue(v0_2, "copyOf(...)");
                }
                else {
                    goto label_20;
                }
            }

            goto label_21;
        }
        catch(Throwable v0) {
            __monitor_exit(v2);
            throw v0;
        }

    label_20:
        v0_2 = null;
    label_21:
        __monitor_exit(v2);
        return v0_2;
    }

    public final KadbIdentitySnapshot importIdentity(byte[] arg4, byte[] arg5) {
        KadbIdentitySnapshot v4_2;
        State v0;
        Intrinsics.checkNotNullParameter(arg4, "privateKeyPem");
        Object v3 = KadbCert.lock;
        __monitor_enter(v3);
        try {
            v0 = KadbCert.state;
            if((v0 instanceof Ready)) {
            }
            else {
                goto label_8;
            }

            goto label_9;
        }
        catch(Throwable v4) {
            goto label_36;
        }

    label_8:
        v0 = null;
        try {
        label_9:
            KadbCert v1 = KadbCert.INSTANCE;
            ResolvedIdentity v4_1 = v1.resolveImportedIdentity(arg4, arg5);
            v1.writePrivateKeyOrThrow(v4_1.getPrivateKeyPem());
            Ready v5 = new Ready(v4_1.getSnapshot().deepCopy$kadb(), v1.resolveHostKeySet(v4_1.getKeyPair()));
            KadbCert.state = v5;
            v4_2 = v5.getSnapshot().deepCopy$kadb();
        }
        catch(Throwable v4) {
            if(v0 != null) {
                try {
                    goto label_31;
                label_28:
                    Broken v0_1 = new Broken(v4);
                label_31:
                    KadbCert.state = ((State)v0_1);
                    throw KadbCert.INSTANCE.toKadbCertException(v4);
                }
                catch(Throwable v4) {
                label_36:
                    __monitor_exit(v3);
                    throw v4;
                }
            }
            else {
                goto label_28;
            }

            goto label_31;
        }

        __monitor_exit(v3);
        return v4_2;
    }

    public static KadbIdentitySnapshot importIdentity$default(KadbCert arg0, byte[] arg1, byte[] arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        return arg0.importIdentity(arg1, arg2);
    }

    public final KadbIdentitySnapshot importPrivateKey(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "privateKeyPem");
        return this.importIdentity(arg2, null);
    }

    private final Ready loadOrGenerateState() {
        byte[] v0 = this.readPrivateKeyFromStoreOrThrow();
        if(v0 != null) {
            if(v0.length == 0) {
            }
            else {
                try {
                    this.validatePrivateKeyOrThrow(v0);
                    ResolvedIdentity v0_2 = CertUtils.INSTANCE.identityFromPrivateKey(v0, KadbCert.policy);
                    return new Ready(v0_2.getSnapshot().deepCopy$kadb(), this.resolveHostKeySet(v0_2.getKeyPair()));
                }
                catch(PrivateKeyParseFailed v0_1) {
                    if(KadbCert.policy.getAutoHealInvalidPrivateKey()) {
                        return this.regenerateAndPersistState();
                    }
                    else {
                        throw v0_1;
                    }
                }
            }
        }

        return this.regenerateAndPersistState();
    }

    private final byte[] readPrivateKeyFromStoreOrThrow() {
        try {
            return KadbCert.store.readPrivateKeyPem();
        }
        catch(Throwable v1) {
            throw new StoreReadFailed(v1);
        }
    }

    private final Ready regenerateAndPersistState() {
        ResolvedIdentity v0 = CertUtils.INSTANCE.generateNewIdentity(KadbCert.policy);
        this.writePrivateKeyOrThrow(v0.getPrivateKeyPem());
        return new Ready(v0.getSnapshot().deepCopy$kadb(), this.resolveHostKeySet(v0.getKeyPair()));
    }

    private final HostKeySet resolveHostKeySet(AdbKeyPair arg7) {
        List v1 = CollectionsKt.mutableListOf(new AdbKeyPair[]{arg7});
        Set v0 = SetsKt.mutableSetOf(new String[]{CertUtils.INSTANCE.fingerprintSha256(arg7.getPublicKey())});
        Iterator v2 = KadbCert.additionalPrivateKeysPem.iterator();
        while(v2.hasNext()) {
            Object v3 = v2.next();
            try {
                v3 = Result.constructor-impl(CertUtils.INSTANCE.identityFromPrivateKey(((byte[])v3), KadbCert.policy).getKeyPair());
            }
            catch(Throwable v3_1) {
                v3 = Result.constructor-impl(ResultKt.createFailure(v3_1));
            }

            if(Result.isFailure-impl(v3)) {
                v3 = null;
            }

            if(v3 == null) {
                continue;
            }

            if(!v0.add(CertUtils.INSTANCE.fingerprintSha256(((AdbKeyPair)v3).getPublicKey()))) {
                continue;
            }

            v1.add(v3);
        }

        return new HostKeySet(arg7, v1);
    }

    private final ResolvedIdentity resolveImportedIdentity(byte[] arg4, byte[] arg5) {
        Object v3_1;
        Object v5_1;
        this.validatePrivateKeyOrThrow(arg4);
        if(arg5 != null) {
            if(arg5.length == 0) {
            }
            else {
                try {
                    v5_1 = Result.constructor-impl(CertUtils.INSTANCE.identityFromPrivateKeyAndCertificate(arg4, arg5));
                }
                catch(Throwable v5) {
                    v5_1 = Result.constructor-impl(ResultKt.createFailure(v5));
                }

                Certificate v1 = null;
                if(Result.isFailure-impl(v5_1)) {
                    v5_1 = v1;
                }

                if(v5_1 != null) {
                    Certificate v0 = ((ResolvedIdentity)v5_1).getKeyPair().getCertificate();
                    if((v0 instanceof X509Certificate)) {
                        v1 = v0;
                    }

                    if(v1 == null) {
                        goto label_45;
                    }

                    try {
                        CertUtils.INSTANCE.validateCertificate(((X509Certificate)v1));
                        v3_1 = Result.constructor-impl(Boolean.valueOf(true));
                    }
                    catch(Throwable v3) {
                        v3_1 = Result.constructor-impl(ResultKt.createFailure(v3));
                    }

                    if(Result.exceptionOrNull-impl(v3_1) == null) {
                    }
                    else {
                        Boolean v3_2 = Boolean.valueOf(false);
                    }

                    if(!v3_2.booleanValue()) {
                        goto label_45;
                    }

                    return ((ResolvedIdentity)v5_1);
                }

            label_45:
                return CertUtils.INSTANCE.identityFromPrivateKey(arg4, KadbCert.policy);
            }
        }

        return CertUtils.INSTANCE.identityFromPrivateKey(arg4, KadbCert.policy);
    }

    public final KadbIdentitySnapshot rotate() {
        KadbIdentitySnapshot v0_1;
        Object v5 = KadbCert.lock;
        __monitor_enter(v5);
        try {
            if((KadbCert.state instanceof Ready)) {
            }
        }
        catch(Throwable v0) {
            goto label_36;
        }

        try {
            ResolvedIdentity v1_1 = CertUtils.INSTANCE.generateNewIdentity(KadbCert.policy);
            KadbCert v2 = KadbCert.INSTANCE;
            v2.writePrivateKeyOrThrow(v1_1.getPrivateKeyPem());
            Ready v3 = new Ready(v1_1.getSnapshot().deepCopy$kadb(), v2.resolveHostKeySet(v1_1.getKeyPair()));
            KadbCert.state = v3;
            v0_1 = v3.getSnapshot().deepCopy$kadb();
        }
        catch(Throwable v1) {
            if(v0_1 == null) {
                try {
                    Broken v0_2 = new Broken(v1);
                label_31:
                    KadbCert.state = ((State)v0_1);
                    throw KadbCert.INSTANCE.toKadbCertException(v1);
                }
                catch(Throwable v0) {
                label_36:
                    __monitor_exit(v5);
                    throw v0;
                }
            }

            goto label_31;
        }

        __monitor_exit(v5);
        return v0_1;
    }

    private final KadbCertException toKadbCertException(Throwable arg2) {
        if((arg2 instanceof KadbCertException)) {
            return arg2;
        }

        return new PolicyViolation("Unexpected KadbCert error", arg2);
    }

    private final void validatePolicy(KadbCertPolicy arg4) {
        int v1 = 2;
        Throwable v2 = null;
        if(arg4.getKeySizeBits() == 0x800) {
            if(arg4.getCertValidityDays() > 0) {
                return;
            }

            throw new PolicyViolation("Certificate validity must be greater than 0", v2, v1, ((DefaultConstructorMarker)v2));
        }

        throw new PolicyViolation("Only RSA 2048 is supported", v2, v1, ((DefaultConstructorMarker)v2));
    }

    private final void validatePrivateKeyOrThrow(byte[] arg1) {
        try {
            CertUtils.INSTANCE.parsePrivateKeyPem(arg1);
            return;
        }
        catch(Throwable v0) {
            throw KadbCertException.Companion.fromPrivateKeyParseError$kadb(v0);
        }
    }

    private final void writePrivateKeyOrThrow(byte[] arg1) {
        try {
            KadbCert.store.writePrivateKeyPemAtomic(arg1);
            return;
        }
        catch(Throwable v0) {
            throw new StoreWriteFailed(v0);
        }
    }
}

