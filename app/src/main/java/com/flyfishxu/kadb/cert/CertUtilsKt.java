package com.flyfishxu.kadb.cert;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"KEY_BEGIN", "", "KEY_END", "CERT_BEGIN", "CERT_END", "providers", "", "Ljava/io/Serializable;", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class CertUtilsKt {
    private static final String CERT_BEGIN = "-----BEGIN CERTIFICATE-----";
    private static final String CERT_END = "-----END CERTIFICATE-----";
    private static final String KEY_BEGIN = "-----BEGIN PRIVATE KEY-----";
    private static final String KEY_END = "-----END PRIVATE KEY-----";
    private static final List providers;

    static {
        CertUtilsKt.providers = CollectionsKt.listOf(new Serializable[]{null, new BouncyCastleProvider(), "AndroidOpenSSL"});
    }

    public static final List access$getProviders$p() {
        return CertUtilsKt.providers;
    }
}

