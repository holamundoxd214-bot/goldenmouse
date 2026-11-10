package com.flyfishxu.kadb.pair;

import com.flyfishxu.kadb.cert.AdbKeyPair;
import com.flyfishxu.kadb.cert.CertUtils;
import com.flyfishxu.kadb.cert.HostKeySet;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001:\u000212B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001A\u00020\u0014J\u000E\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u0017J\u000E\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00020\u0019J\u001C\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u001B2\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\u0015\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0016\u001A\u00020\u0017H\u0000¢\u0006\u0002\b\u001EJ\b\u0010\u001F\u001A\u00020 H\u0002J\u0010\u0010!\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u0017H\u0002JI\u0010\"\u001A\u0004\u0018\u00010\u00122\u0010\u0010#\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010$2\u0010\u0010%\u001A\f\u0012\u0006\b\u0001\u0012\u00020&\u0018\u00010$2\u0006\u0010\'\u001A\u00020\u00122\f\u0010(\u001A\b\u0012\u0004\u0012\u00020*0)H\u0002¢\u0006\u0002\u0010+J\u0012\u0010,\u001A\u00020\u00052\b\u0010-\u001A\u0004\u0018\u00010\u0012H\u0002J\u0017\u0010.\u001A\u0004\u0018\u00010\u00122\u0006\u0010/\u001A\u00020&H\u0000¢\u0006\u0002\b0R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u00063"}, d2={"Lcom/flyfishxu/kadb/pair/SslUtils;", "", "<init>", "()V", "customConscrypt", "", "getCustomConscrypt", "()Z", "setCustomConscrypt", "(Z)V", "lock", "cachedContext", "Lcom/flyfishxu/kadb/pair/SslUtils$CachedContext;", "newClientEngine", "Ljavax/net/ssl/SSLEngine;", "sslContext", "Ljavax/net/ssl/SSLContext;", "host", "", "port", "", "getSslContext", "hostKeySet", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "createSslContext", "Lkotlin/Pair;", "newClientKeyManager", "Ljavax/net/ssl/X509ExtendedKeyManager;", "newClientKeyManager$kadb", "getAllAcceptingTrustManager", "Ljavax/net/ssl/X509TrustManager;", "buildCacheKey", "chooseAlias", "keyTypes", "", "issuers", "Ljava/security/Principal;", "defaultAlias", "identities", "", "Lcom/flyfishxu/kadb/pair/SslUtils$ClientIdentity;", "([Ljava/lang/String;[Ljava/security/Principal;Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", "supportsKeyType", "keyType", "parseAdbKeyFingerprintHexFromIssuer", "issuer", "parseAdbKeyFingerprintHexFromIssuer$kadb", "CachedContext", "ClientIdentity", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class SslUtils {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001A\u00020\u00072\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001A\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001A\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0019"}, d2={"Lcom/flyfishxu/kadb/pair/SslUtils$CachedContext;", "", "hostKeyCacheKey", "", "context", "Ljavax/net/ssl/SSLContext;", "customConscrypt", "", "<init>", "(Ljava/lang/String;Ljavax/net/ssl/SSLContext;Z)V", "getHostKeyCacheKey", "()Ljava/lang/String;", "getContext", "()Ljavax/net/ssl/SSLContext;", "getCustomConscrypt", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) final class CachedContext {
        private final SSLContext context;
        private final boolean customConscrypt;
        private final String hostKeyCacheKey;

        public CachedContext(String arg2, SSLContext arg3, boolean arg4) {
            Intrinsics.checkNotNullParameter(arg2, "hostKeyCacheKey");
            Intrinsics.checkNotNullParameter(arg3, "context");
            super();
            this.hostKeyCacheKey = arg2;
            this.context = arg3;
            this.customConscrypt = arg4;
        }

        public final String component1() {
            return this.hostKeyCacheKey;
        }

        public final SSLContext component2() {
            return this.context;
        }

        public final boolean component3() {
            return this.customConscrypt;
        }

        public final CachedContext copy(String arg1, SSLContext arg2, boolean arg3) {
            Intrinsics.checkNotNullParameter(arg1, "hostKeyCacheKey");
            Intrinsics.checkNotNullParameter(arg2, "context");
            return new CachedContext(arg1, arg2, arg3);
        }

        public static CachedContext copy$default(CachedContext arg0, String arg1, SSLContext arg2, boolean arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.hostKeyCacheKey;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.context;
            }

            if((arg4 & 4) != 0) {
                arg3 = arg0.customConscrypt;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if(this == (((CachedContext)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof CachedContext)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.hostKeyCacheKey, ((CachedContext)arg5).hostKeyCacheKey)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.context, ((CachedContext)arg5).context)) {
                return 0;
            }

            if(this.customConscrypt != ((CachedContext)arg5).customConscrypt) {
                return 0;
            }

            return 1;
        }

        public final SSLContext getContext() {
            return this.context;
        }

        public final boolean getCustomConscrypt() {
            return this.customConscrypt;
        }

        public final String getHostKeyCacheKey() {
            return this.hostKeyCacheKey;
        }

        public int hashCode() {
            return (this.hostKeyCacheKey.hashCode() * 0x1F + this.context.hashCode()) * 0x1F + Boolean.hashCode(this.customConscrypt);
        }

        public String toString() {
            return "CachedContext(hostKeyCacheKey=" + this.hostKeyCacheKey + ", context=" + this.context + ", customConscrypt=" + this.customConscrypt + ")";
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001A\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001A\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u0018"}, d2={"Lcom/flyfishxu/kadb/pair/SslUtils$ClientIdentity;", "", "alias", "", "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "adbTlsFingerprintHex", "<init>", "(Ljava/lang/String;Lcom/flyfishxu/kadb/cert/AdbKeyPair;Ljava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "getKeyPair", "()Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "getAdbTlsFingerprintHex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) final class ClientIdentity {
        private final String adbTlsFingerprintHex;
        private final String alias;
        private final AdbKeyPair keyPair;

        public ClientIdentity(String arg2, AdbKeyPair arg3, String arg4) {
            Intrinsics.checkNotNullParameter(arg2, "alias");
            Intrinsics.checkNotNullParameter(arg3, "keyPair");
            Intrinsics.checkNotNullParameter(arg4, "adbTlsFingerprintHex");
            super();
            this.alias = arg2;
            this.keyPair = arg3;
            this.adbTlsFingerprintHex = arg4;
        }

        public final String component1() {
            return this.alias;
        }

        public final AdbKeyPair component2() {
            return this.keyPair;
        }

        public final String component3() {
            return this.adbTlsFingerprintHex;
        }

        public final ClientIdentity copy(String arg1, AdbKeyPair arg2, String arg3) {
            Intrinsics.checkNotNullParameter(arg1, "alias");
            Intrinsics.checkNotNullParameter(arg2, "keyPair");
            Intrinsics.checkNotNullParameter(arg3, "adbTlsFingerprintHex");
            return new ClientIdentity(arg1, arg2, arg3);
        }

        public static ClientIdentity copy$default(ClientIdentity arg0, String arg1, AdbKeyPair arg2, String arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.alias;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.keyPair;
            }

            if((arg4 & 4) != 0) {
                arg3 = arg0.adbTlsFingerprintHex;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if(this == (((ClientIdentity)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof ClientIdentity)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.alias, ((ClientIdentity)arg5).alias)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.keyPair, ((ClientIdentity)arg5).keyPair)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.adbTlsFingerprintHex, ((ClientIdentity)arg5).adbTlsFingerprintHex)) {
                return 0;
            }

            return 1;
        }

        public final String getAdbTlsFingerprintHex() {
            return this.adbTlsFingerprintHex;
        }

        public final String getAlias() {
            return this.alias;
        }

        public final AdbKeyPair getKeyPair() {
            return this.keyPair;
        }

        public int hashCode() {
            return (this.alias.hashCode() * 0x1F + this.keyPair.hashCode()) * 0x1F + this.adbTlsFingerprintHex.hashCode();
        }

        public String toString() {
            return "ClientIdentity(alias=" + this.alias + ", keyPair=" + this.keyPair + ", adbTlsFingerprintHex=" + this.adbTlsFingerprintHex + ")";
        }
    }

    public static final SslUtils INSTANCE;
    private static volatile CachedContext cachedContext;
    private static volatile boolean customConscrypt;
    private static final Object lock;

    static {
        SslUtils.INSTANCE = new SslUtils();
        SslUtils.lock = new Object();
    }

    private SslUtils() {
        super();
    }

    public static final String access$chooseAlias(SslUtils arg0, String[] arg1, Principal[] arg2, String arg3, List arg4) {
        return arg0.chooseAlias(arg1, arg2, arg3, arg4);
    }

    public static final boolean access$supportsKeyType(SslUtils arg0, String arg1) {
        return arg0.supportsKeyType(arg1);
    }

    private final String buildCacheKey(HostKeySet arg10) {
        return CollectionsKt.joinToString$default(arg10.getKeyPairs(), "|", null, null, 0, null, new SslUtils$$ExternalSyntheticLambda0(), 30, null);
    }

    static final CharSequence buildCacheKey$lambda$0(AdbKeyPair arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return CertUtils.INSTANCE.fingerprintSha256(arg1.getCertificate());
    }

    private final String chooseAlias(String[] arg7, Principal[] arg8, String arg9, List arg10) {
        Object v7_1;
        Object v4;
        int v0 = 0;
        if(arg7 != null) {
            if(arg7.length == 0) {
            }
            else {
                int v1 = arg7.length;
                int v2 = 0;
                while(true) {
                    if(v2 >= v1) {
                        break;
                    }
                    else if(this.supportsKeyType(arg7[v2])) {
                    }
                    else {
                        ++v2;
                        continue;
                    }

                    goto label_15;
                }

                arg10 = CollectionsKt.emptyList();
            }
        }

    label_15:
        String v1_1 = null;
        if(arg10.isEmpty()) {
            return v1_1;
        }

        if(arg8 != null) {
            if(arg8.length == 0) {
            }
            else {
                int v7 = arg8.length;
                while(v0 < v7) {
                    String v2_1 = this.parseAdbKeyFingerprintHexFromIssuer$kadb(arg8[v0]);
                    if(v2_1 == null) {
                    }
                    else {
                        Iterator v3 = arg10.iterator();
                        do {
                            if(v3.hasNext()) {
                                v4 = v3.next();
                                if(!Intrinsics.areEqual(v4.getAdbTlsFingerprintHex(), v2_1)) {
                                    continue;
                                }

                                break;
                            }
                            else {
                                goto label_39;
                            }
                        }
                        while(true);

                        goto label_40;
                    label_39:
                        v4 = v1_1;
                    label_40:
                        if(v4 == null) {
                            goto label_43;
                        }

                        return ((ClientIdentity)v4).getAlias();
                    }

                label_43:
                    ++v0;
                }
            }
        }

        Iterator v6 = arg10.iterator();
        do {
            if(v6.hasNext()) {
                v7_1 = v6.next();
                if(!Intrinsics.areEqual(v7_1.getAlias(), arg9)) {
                    continue;
                }

                break;
            }

            goto label_55;
        }
        while(true);

        Object v1_2 = v7_1;
    label_55:
        if(v1_1 != null) {
            String v6_1 = ((ClientIdentity)v1_1).getAlias();
            if(v6_1 == null) {
            }
            else {
                return v6_1;
            }
        }

        return CollectionsKt.first(arg10).getAlias();
    }

    private final Pair createSslContext(HostKeySet arg7) {
        boolean v0_1;
        SSLContext v4_1;
        String v0 = "getInstance(...)";
        String v1 = "TLSv1.3";
        try {
            Object v4 = Class.forName("org.conscrypt.OpenSSLProvider").getDeclaredConstructor().newInstance();
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type java.security.Provider");
            v4_1 = SSLContext.getInstance(v1, ((Provider)v4));
            Intrinsics.checkNotNullExpressionValue(v4_1, v0);
            v0 = null;
        }
        catch(Throwable ) {
            v4_1 = SSLContext.getInstance(v1);
            Intrinsics.checkNotNullExpressionValue(v4_1, v0);
            v0_1 = false;
        }
        catch(NoSuchAlgorithmException v6) {
            throw v6;
        }

        v4_1.init(new KeyManager[]{this.newClientKeyManager$kadb(arg7)}, new X509TrustManager[]{this.getAllAcceptingTrustManager()}, new SecureRandom());
        return TuplesKt.to(v4_1, Boolean.valueOf(v0_1));
    }

    private final X509TrustManager getAllAcceptingTrustManager() {
        return new SslUtils$getAllAcceptingTrustManager$1();
    }

    public final boolean getCustomConscrypt() {
        return SslUtils.customConscrypt;
    }

    public final SSLContext getSslContext(HostKeySet arg4) {
        SSLContext v3_2;
        CachedContext v1;
        Intrinsics.checkNotNullParameter(arg4, "hostKeySet");
        String v3 = this.buildCacheKey(arg4);
        CachedContext v0 = SslUtils.cachedContext;
        if(v0 != null && (Intrinsics.areEqual(v0.getHostKeyCacheKey(), v3))) {
            SslUtils.customConscrypt = v0.getCustomConscrypt();
            return v0.getContext();
        }

        Object v0_1 = SslUtils.lock;
        __monitor_enter(v0_1);
        try {
            v1 = SslUtils.cachedContext;
            if(v1 != null && (Intrinsics.areEqual(v1.getHostKeyCacheKey(), v3))) {
                SslUtils.customConscrypt = v1.getCustomConscrypt();
                v3_2 = v1.getContext();
                goto label_22;
            }

            goto label_24;
        }
        catch(Throwable v3_1) {
            goto label_38;
        }

    label_22:
        __monitor_exit(v0_1);
        return v3_2;
        try {
        label_24:
            Pair v4 = SslUtils.INSTANCE.createSslContext(arg4);
            v1 = new CachedContext(v3, v4.getFirst(), v4.getSecond().booleanValue());
            SslUtils.cachedContext = v1;
            SslUtils.customConscrypt = v1.getCustomConscrypt();
            v3_2 = v1.getContext();
        }
        catch(Throwable v3_1) {
        label_38:
            __monitor_exit(v0_1);
            throw v3_1;
        }

        __monitor_exit(v0_1);
        return v3_2;
    }

    public final SSLContext getSslContext(AdbKeyPair arg2) {
        Intrinsics.checkNotNullParameter(arg2, "keyPair");
        return this.getSslContext(HostKeySet.Companion.single(arg2));
    }

    public final SSLEngine newClientEngine(SSLContext arg1, String arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "sslContext");
        SSLEngine v0 = arg2 != null ? arg1.createSSLEngine(arg2, arg3) : arg1.createSSLEngine();
        v0.setUseClientMode(true);
        v0.setEnabledProtocols(new String[]{"TLSv1.3"});
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    public final X509ExtendedKeyManager newClientKeyManager$kadb(HostKeySet arg8) {
        Intrinsics.checkNotNullParameter(arg8, "hostKeySet");
        List v7 = arg8.getKeyPairs();
        int v0 = 10;
        ArrayList v8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v7), v0));
        Iterator v7_1 = ((Iterable)v7).iterator();
        int v1;
        for(v1 = 0; v7_1.hasNext(); v1 = v3) {
            Object v2 = v7_1.next();
            int v3 = v1 + 1;
            if(v1 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            ((Collection)v8).add(new ClientIdentity("key-" + v1, ((AdbKeyPair)v2), CertUtils.INSTANCE.adbTlsFingerprintHex(((AdbKeyPair)v2).getPublicKey())));
        }

        LinkedHashMap v1_1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(v8, v0)), 16));
        v7_1 = v8.iterator();
        while(v7_1.hasNext()) {
            Object v0_1 = v7_1.next();
            ((Map)v1_1).put(v0_1.getAlias(), v0_1);
        }

        return new SslUtils$newClientKeyManager$1(((List)v8), CollectionsKt.first(((List)v8)).getAlias(), ((Map)v1_1));
    }

    public final String parseAdbKeyFingerprintHexFromIssuer$kadb(Principal arg5) {
        Object v4_1;
        Intrinsics.checkNotNullParameter(arg5, "issuer");
        try {
            v4_1 = Result.constructor-impl(new X500Name(arg5.getName()));
        }
        catch(Throwable v4) {
            v4_1 = Result.constructor-impl(ResultKt.createFailure(v4));
        }

        String v0 = null;
        if(Result.isFailure-impl(v4_1)) {
            v4_1 = v0;
        }

        if(v4_1 == null) {
            return v0;
        }

        RDN[] v5 = ((X500Name)v4_1).getRDNs(BCStyle.O);
        String v1 = "getRDNs(...)";
        Intrinsics.checkNotNullExpressionValue(v5, v1);
        Object v5_1 = ArraysKt.firstOrNull(((Object[])v5));
        if(v5_1 != null) {
            AttributeTypeAndValue v5_2 = ((RDN)v5_1).getFirst();
            if(v5_2 != null) {
                ASN1Encodable v5_3 = v5_2.getValue();
                if(v5_3 != null) {
                    String v5_4 = v5_3.toString();
                    if(v5_4 == null) {
                    }
                    else if(!Intrinsics.areEqual(v5_4, "AdbKey-0")) {
                        return v0;
                    }
                    else {
                        RDN[] v4_2 = ((X500Name)v4_1).getRDNs(BCStyle.CN);
                        Intrinsics.checkNotNullExpressionValue(v4_2, v1);
                        v4_1 = ArraysKt.firstOrNull(((Object[])v4_2));
                        if(v4_1 != null) {
                            AttributeTypeAndValue v4_3 = ((RDN)v4_1).getFirst();
                            if(v4_3 != null) {
                                ASN1Encodable v4_4 = v4_3.getValue();
                                if(v4_4 != null) {
                                    String v4_5 = v4_4.toString();
                                    if(v4_5 == null) {
                                    }
                                    else if(v4_5.length() == 0x40) {
                                        v5_4 = v4_5;
                                        int v1_1;
                                        for(v1_1 = 0; v1_1 < ((CharSequence)v5_4).length(); ++v1_1) {
                                            char v2 = ((CharSequence)v5_4).charAt(v1_1);
                                            if(!Character.isDigit(v2) && (97 > v2 || v2 >= 103)) {
                                                if(65 > v2) {
                                                    return v0;
                                                }

                                                if(v2 >= 71) {
                                                    return v0;
                                                }
                                            }
                                        }

                                        Locale v5_5 = Locale.US;
                                        Intrinsics.checkNotNullExpressionValue(v5_5, "US");
                                        v4_5 = v4_5.toUpperCase(v5_5);
                                        Intrinsics.checkNotNullExpressionValue(v4_5, "toUpperCase(...)");
                                        return v4_5;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return v0;
    }

    public final void setCustomConscrypt(boolean arg1) {
        SslUtils.customConscrypt = arg1;
    }

    private final boolean supportsKeyType(String arg4) {
        if(arg4 == null) {
            return 1;
        }

        Locale v3 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(v3, "US");
        String v3_1 = arg4.toUpperCase(v3);
        Intrinsics.checkNotNullExpressionValue(v3_1, "toUpperCase(...)");
        return StringsKt.contains$default(((CharSequence)v3_1), "RSA", false, 2, null);
    }
}

