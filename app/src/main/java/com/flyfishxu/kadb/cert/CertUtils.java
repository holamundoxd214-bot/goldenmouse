package com.flyfishxu.kadb.cert;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.encoding.Base64$Default;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.bc.BcX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001A\u00020\u0005J\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BJ\u0016\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\u000BJ\u0016\u0010\u000F\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000EJ\u000E\u0010\u0011\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u000EJ\u000E\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0010\u001A\u00020\u000EJ\u000E\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u0012J\u000E\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0018\u001A\u00020\u0019J\u000E\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DJ\u000E\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0018\u001A\u00020\u0019J\u000E\u0010\u001E\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DJ\u000E\u0010\u001F\u001A\u00020 2\u0006\u0010\u0018\u001A\u00020\u0014J \u0010!\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u0014H\u0002J\u0010\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020%H\u0002J\u0018\u0010&\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u00122\u0006\u0010\n\u001A\u00020\u000BH\u0002J\u0010\u0010\'\u001A\u00020\u001D2\u0006\u0010\u0016\u001A\u00020\u0012H\u0002J\u0010\u0010(\u001A\u00020\u001B2\u0006\u0010)\u001A\u00020*H\u0002J&\u0010+\u001A\u00020 2\f\u0010,\u001A\b\u0012\u0004\u0012\u00020\u001B0-2\u0006\u0010.\u001A\u00020\u001B2\u0006\u0010/\u001A\u00020\u001BH\u0002¨\u00060"}, d2={"Lcom/flyfishxu/kadb/cert/CertUtils;", "", "<init>", "()V", "loadKeyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "loadKeySet", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "generateNewIdentity", "Lcom/flyfishxu/kadb/cert/ResolvedIdentity;", "policy", "Lcom/flyfishxu/kadb/cert/KadbCertPolicy;", "identityFromPrivateKey", "privateKeyPem", "", "identityFromPrivateKeyAndCertificate", "certificatePem", "parsePrivateKeyPem", "Ljava/security/PrivateKey;", "parseCertificatePem", "Ljava/security/cert/X509Certificate;", "encodePrivateKeyPem", "privateKey", "encodeCertificatePem", "certificate", "Ljava/security/cert/Certificate;", "fingerprintSha256", "", "publicKey", "Ljava/security/PublicKey;", "adbTlsFingerprintHex", "validateCertificate", "", "toResolvedIdentity", "generateKeyPair", "Ljava/security/KeyPair;", "keySizeBits", "", "generateCertificateFromPrivateKey", "derivePublicKey", "buildSubjectName", "subject", "Lcom/flyfishxu/kadb/cert/KadbCertPolicy$Subject;", "appendSubjectEntry", "entries", "", "key", "value", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class CertUtils {
    public static final CertUtils INSTANCE;

    static {
        CertUtils.INSTANCE = new CertUtils();
    }

    private CertUtils() {
        super();
    }

    public final String adbTlsFingerprintHex(PublicKey arg8) {
        Intrinsics.checkNotNullParameter(arg8, "publicKey");
        byte[] v7 = MessageDigest.getInstance("SHA-256").digest(arg8.getEncoded());
        char[] v8 = new char[v7.length * 2];
        Intrinsics.checkNotNull(v7);
        int v0 = v7.length;
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < v0; v2 = v4) {
            int v3 = v7[v1];
            int v4 = v2 + 1;
            v2 *= 2;
            v8[v2] = "0123456789ABCDEF".charAt((v3 & 0xFF) >>> 4);
            v8[v2 + 1] = "0123456789ABCDEF".charAt(v3 & 15);
            ++v1;
        }

        String v7_1 = new String(v8);
        Locale v8_1 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(v8_1, "US");
        v7_1 = v7_1.toUpperCase(v8_1);
        Intrinsics.checkNotNullExpressionValue(v7_1, "toUpperCase(...)");
        return v7_1;
    }

    private final void appendSubjectEntry(List arg1, String arg2, String arg3) {
        if(!StringsKt.isBlank(arg3)) {
            ((Collection)arg1).add(arg2 + "=" + arg3);
        }
    }

    private final String buildSubjectName(Subject arg11) {
        ArrayList v0 = new ArrayList();
        this.appendSubjectEntry(((List)v0), "C", arg11.getC());
        this.appendSubjectEntry(((List)v0), "O", arg11.getO());
        this.appendSubjectEntry(((List)v0), "CN", arg11.getCn());
        this.appendSubjectEntry(((List)v0), "OU", arg11.getOu());
        this.appendSubjectEntry(((List)v0), "L", arg11.getL());
        this.appendSubjectEntry(((List)v0), "ST", arg11.getSt());
        if(((List)v0).isEmpty()) {
            v0.add("C=US");
            v0.add("O=Android");
            v0.add("CN=Adb");
        }

        return CollectionsKt.joinToString$default(v0, ", ", null, null, 0, null, null, 62, null);
    }

    private final PublicKey derivePublicKey(PrivateKey arg3) {
        Throwable v0 = null;
        if((arg3 instanceof RSAPrivateCrtKey)) {
        }
        else {
            arg3 = ((PrivateKey)v0);
        }

        if(arg3 != null) {
            PublicKey v2 = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(((RSAPrivateCrtKey)arg3).getModulus(), ((RSAPrivateCrtKey)arg3).getPublicExponent()));
            Intrinsics.checkNotNullExpressionValue(v2, "generatePublic(...)");
            return v2;
        }

        throw new PolicyViolation("Only RSA private keys with CRT parameters are supported", v0, 2, ((DefaultConstructorMarker)v0));
    }

    public final byte[] encodeCertificatePem(Certificate arg7) {
        Intrinsics.checkNotNullParameter(arg7, "certificate");
        Default v0 = Base64.Default;
        byte[] v1 = arg7.getEncoded();
        Intrinsics.checkNotNullExpressionValue(v1, "getEncoded(...)");
        String v6 = Base64.encode$default(((Base64)v0), v1, 0, 0, 6, null);
        Buffer v7 = new Buffer();
        Buffer v1_1 = v7;
        try {
            v1_1.writeUtf8("-----BEGIN CERTIFICATE-----");
            v1_1.writeByte(10);
            v1_1.writeUtf8(v6);
            v1_1.writeByte(10);
            v1_1.writeUtf8("-----END CERTIFICATE-----");
        }
        catch(Throwable v0_1) {
            Throwable v6_1 = v0_1;
            try {
                throw v6_1;
            }
            catch(Throwable v0_1) {
                CloseableKt.closeFinally(((Closeable)v1_1), v6_1);
                throw v0_1;
            }
        }

        CloseableKt.closeFinally(((Closeable)v1_1), null);
        return v7.readByteArray();
    }

    public final byte[] encodePrivateKeyPem(PrivateKey arg7) {
        Intrinsics.checkNotNullParameter(arg7, "privateKey");
        Default v0 = Base64.Default;
        byte[] v1 = arg7.getEncoded();
        Intrinsics.checkNotNullExpressionValue(v1, "getEncoded(...)");
        String v6 = Base64.encode$default(((Base64)v0), v1, 0, 0, 6, null);
        Buffer v7 = new Buffer();
        Buffer v1_1 = v7;
        try {
            v1_1.writeUtf8("-----BEGIN PRIVATE KEY-----");
            v1_1.writeByte(10);
            v1_1.writeUtf8(v6);
            v1_1.writeByte(10);
            v1_1.writeUtf8("-----END PRIVATE KEY-----");
        }
        catch(Throwable v0_1) {
            Throwable v6_1 = v0_1;
            try {
                throw v6_1;
            }
            catch(Throwable v0_1) {
                CloseableKt.closeFinally(((Closeable)v1_1), v6_1);
                throw v0_1;
            }
        }

        CloseableKt.closeFinally(((Closeable)v1_1), null);
        return v7.readByteArray();
    }

    public final String fingerprintSha256(Certificate arg7) {
        Intrinsics.checkNotNullParameter(arg7, "certificate");
        byte[] v1 = MessageDigest.getInstance("SHA-256").digest(arg7.getEncoded());
        Default v0 = Base64.Default;
        Intrinsics.checkNotNull(v1);
        return Base64.encode$default(((Base64)v0), v1, 0, 0, 6, null);
    }

    public final String fingerprintSha256(PublicKey arg7) {
        Intrinsics.checkNotNullParameter(arg7, "publicKey");
        byte[] v1 = MessageDigest.getInstance("SHA-256").digest(arg7.getEncoded());
        Default v0 = Base64.Default;
        Intrinsics.checkNotNull(v1);
        return Base64.encode$default(((Base64)v0), v1, 0, 0, 6, null);
    }

    private final X509Certificate generateCertificateFromPrivateKey(PrivateKey arg10, KadbCertPolicy arg11) {
        X509Certificate v11_1;
        PublicKey v6 = this.derivePublicKey(arg10);
        long v0 = System.currentTimeMillis();
        Time v3 = new Time(new Date(v0));
        Time v4 = new Time(new Date(v0 + TimeUnit.DAYS.toMillis(((long)arg11.getCertValidityDays()))));
        X500Name v1 = new X500Name(this.buildSubjectName(arg11.getSubject()));
        JcaX509v3CertificateBuilder v0_1 = new JcaX509v3CertificateBuilder(v1, BigInteger.ONE, v3, v4, v1, v6);
        ((X509v3CertificateBuilder)v0_1).addExtension(Extension.basicConstraints, true, new BasicConstraints(true));
        ((X509v3CertificateBuilder)v0_1).addExtension(Extension.keyUsage, true, new KeyUsage(0x86));
        ((X509v3CertificateBuilder)v0_1).addExtension(Extension.subjectKeyIdentifier, false, new BcX509ExtensionUtils().createSubjectKeyIdentifier(SubjectPublicKeyInfo.getInstance(v6.getEncoded())));
        X509CertificateHolder v9 = ((X509v3CertificateBuilder)v0_1).build(new JcaContentSignerBuilder("SHA256withRSA").build(arg10));
        Iterator v10 = CertUtilsKt.access$getProviders$p().iterator();
    label_48:
        if(v10.hasNext()) {
            Object v11 = v10.next();
            try {
                boolean v0_2 = v11 instanceof Provider;
            }
            catch(Throwable ) {
                goto label_48;
            }

            String v1_1 = "getCertificate(...)";
            if(v0_2) {
                try {
                    v11_1 = new JcaX509CertificateConverter().setProvider(((Provider)v11)).getCertificate(v9);
                    Intrinsics.checkNotNullExpressionValue(v11_1, v1_1);
                    return v11_1;
                label_60:
                    if((v11 instanceof String)) {
                        v11_1 = new JcaX509CertificateConverter().setProvider(((String)v11)).getCertificate(v9);
                        Intrinsics.checkNotNullExpressionValue(v11_1, v1_1);
                    }
                    else {
                        v11_1 = new JcaX509CertificateConverter().getCertificate(v9);
                        Intrinsics.checkNotNullExpressionValue(v11_1, v1_1);
                    }
                }
                catch(Throwable ) {
                    goto label_48;
                }
            }
            else {
                goto label_60;
            }

            return v11_1;
        }

        throw new CertificateException("All certificate providers failed to generate a certificate.");
    }

    private final KeyPair generateKeyPair(int arg2) {
        KeyPairGenerator v1 = KeyPairGenerator.getInstance("RSA");
        v1.initialize(arg2, SecureRandom.getInstance("SHA1PRNG"));
        KeyPair v1_1 = v1.generateKeyPair();
        Intrinsics.checkNotNullExpressionValue(v1_1, "generateKeyPair(...)");
        return v1_1;
    }

    public final ResolvedIdentity generateNewIdentity(KadbCertPolicy arg3) {
        Intrinsics.checkNotNullParameter(arg3, "policy");
        PrivateKey v0 = this.generateKeyPair(arg3.getKeySizeBits()).getPrivate();
        Intrinsics.checkNotNullExpressionValue(v0, "getPrivate(...)");
        return this.identityFromPrivateKey(this.encodePrivateKeyPem(v0), arg3);
    }

    public final ResolvedIdentity identityFromPrivateKey(byte[] arg2, KadbCertPolicy arg3) {
        Intrinsics.checkNotNullParameter(arg2, "privateKeyPem");
        Intrinsics.checkNotNullParameter(arg3, "policy");
        PrivateKey v0 = this.parsePrivateKeyPem(arg2);
        return this.toResolvedIdentity(arg2, v0, this.generateCertificateFromPrivateKey(v0, arg3));
    }

    public final ResolvedIdentity identityFromPrivateKeyAndCertificate(byte[] arg4, byte[] arg5) {
        Intrinsics.checkNotNullParameter(arg4, "privateKeyPem");
        Intrinsics.checkNotNullParameter(arg5, "certificatePem");
        PrivateKey v0 = this.parsePrivateKeyPem(arg4);
        X509Certificate v5 = this.parseCertificatePem(arg5);
        if(Arrays.equals(v5.getPublicKey().getEncoded(), this.derivePublicKey(v0).getEncoded())) {
            return this.toResolvedIdentity(arg4, v0, v5);
        }

        throw new PolicyViolation("Certificate does not match private key", null, 2, null);
    }

    public final AdbKeyPair loadKeyPair() {
        return KadbCert.INSTANCE.currentKeyPair$kadb();
    }

    public final HostKeySet loadKeySet() {
        return KadbCert.INSTANCE.currentKeySet$kadb();
    }

    public final X509Certificate parseCertificatePem(byte[] arg13) {
        Intrinsics.checkNotNullParameter(arg13, "certificatePem");
        byte[] v12 = Base64.decode$default(Base64.Default, StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.decodeToString(arg13), "-----BEGIN CERTIFICATE-----", "", false, 4, null), "-----END CERTIFICATE-----", "", false, 4, null), "\r", "", false, 4, null), "\n", "", false, 4, null)).toString(), 0, 0, 6, null);
        Iterator v13 = CertUtilsKt.access$getProviders$p().iterator();
    label_31:
        if(v13.hasNext()) {
            Object v0 = v13.next();
            try {
                boolean v1 = v0 instanceof Provider;
            }
            catch(Throwable ) {
                goto label_31;
            }

            String v2 = "X.509";
            if(v1) {
                try {
                    CertificateFactory v0_1 = CertificateFactory.getInstance(v2, ((Provider)v0));
                    goto label_44;
                label_39:
                    v0_1 = (v0 instanceof String) ? CertificateFactory.getInstance(v2, ((String)v0)) : CertificateFactory.getInstance(v2);
                label_44:
                    Certificate v0_2 = v0_1.generateCertificate(new ByteArrayInputStream(v12));
                    Intrinsics.checkNotNull(v0_2, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    return ((X509Certificate)v0_2);
                }
                catch(Throwable ) {
                    goto label_31;
                }
            }
            else {
                goto label_39;
            }

            goto label_44;
        }

        throw new CertificateException("All certificate providers failed to parse certificate.");
    }

    public final PrivateKey parsePrivateKeyPem(byte[] arg13) {
        Intrinsics.checkNotNullParameter(arg13, "privateKeyPem");
        PrivateKey v12 = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode$default(Base64.Default, StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.decodeToString(arg13), "-----BEGIN PRIVATE KEY-----", "", false, 4, null), "-----END PRIVATE KEY-----", "", false, 4, null), "\r", "", false, 4, null), "\n", "", false, 4, null)).toString(), 0, 0, 6, null)));
        Intrinsics.checkNotNullExpressionValue(v12, "generatePrivate(...)");
        return v12;
    }

    private final ResolvedIdentity toResolvedIdentity(byte[] arg10, PrivateKey arg11, X509Certificate arg12) {
        PublicKey v1 = arg12.getPublicKey();
        Intrinsics.checkNotNullExpressionValue(v1, "getPublicKey(...)");
        AdbKeyPair v0 = new AdbKeyPair(arg11, v1, arg12);
        byte[] v4 = Arrays.copyOf(arg10, arg10.length);
        Intrinsics.checkNotNullExpressionValue(v4, "copyOf(...)");
        KadbIdentitySnapshot v3 = new KadbIdentitySnapshot(v4, this.encodeCertificatePem(arg12), this.fingerprintSha256(arg12), arg12.getNotAfter().getTime());
        arg10 = Arrays.copyOf(arg10, arg10.length);
        Intrinsics.checkNotNullExpressionValue(arg10, "copyOf(...)");
        return new ResolvedIdentity(arg10, v0, v3);
    }

    public final void validateCertificate(X509Certificate arg1) {
        Intrinsics.checkNotNullParameter(arg1, "certificate");
        arg1.checkValidity();
    }
}

