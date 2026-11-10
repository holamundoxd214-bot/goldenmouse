package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;

public interface CRMFObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_alg;
    public static final ASN1ObjectIdentifier id_alg_dh_pop;
    public static final ASN1ObjectIdentifier id_ct_encKeyWithID;
    public static final ASN1ObjectIdentifier id_dh_sig_hmac_sha1;
    public static final ASN1ObjectIdentifier id_pkip;
    public static final ASN1ObjectIdentifier id_pkix;
    public static final ASN1ObjectIdentifier id_regCtrl;
    public static final ASN1ObjectIdentifier id_regCtrl_authenticator;
    public static final ASN1ObjectIdentifier id_regCtrl_oldCertID;
    public static final ASN1ObjectIdentifier id_regCtrl_pkiArchiveOptions;
    public static final ASN1ObjectIdentifier id_regCtrl_pkiPublicationInfo;
    public static final ASN1ObjectIdentifier id_regCtrl_protocolEncrKey;
    public static final ASN1ObjectIdentifier id_regCtrl_regToken;
    public static final ASN1ObjectIdentifier id_regInfo;
    public static final ASN1ObjectIdentifier id_regInfo_certReq;
    public static final ASN1ObjectIdentifier id_regInfo_utf8Pairs;
    public static final ASN1ObjectIdentifier passwordBasedMac;

    static {
        CRMFObjectIdentifiers.passwordBasedMac = MiscObjectIdentifiers.entrust.branch("66.13");
        ASN1ObjectIdentifier v0 = X509ObjectIdentifiers.id_pkix;
        CRMFObjectIdentifiers.id_pkix = v0;
        v0 = v0.branch("5");
        CRMFObjectIdentifiers.id_pkip = v0;
        ASN1ObjectIdentifier v3 = v0.branch("1");
        CRMFObjectIdentifiers.id_regCtrl = v3;
        CRMFObjectIdentifiers.id_regCtrl_regToken = v3.branch("1");
        CRMFObjectIdentifiers.id_regCtrl_authenticator = v3.branch("2");
        CRMFObjectIdentifiers.id_regCtrl_pkiPublicationInfo = v3.branch("3");
        CRMFObjectIdentifiers.id_regCtrl_pkiArchiveOptions = v3.branch("4");
        CRMFObjectIdentifiers.id_regCtrl_oldCertID = v3.branch("5");
        CRMFObjectIdentifiers.id_regCtrl_protocolEncrKey = v3.branch("6");
        v0 = v0.branch("2");
        CRMFObjectIdentifiers.id_regInfo = v0;
        CRMFObjectIdentifiers.id_regInfo_utf8Pairs = v0.branch("1");
        CRMFObjectIdentifiers.id_regInfo_certReq = v0.branch("2");
        CRMFObjectIdentifiers.id_ct_encKeyWithID = PKCSObjectIdentifiers.id_ct.branch("21");
        v0 = X509ObjectIdentifiers.pkix_algorithms;
        CRMFObjectIdentifiers.id_alg = v0;
        CRMFObjectIdentifiers.id_dh_sig_hmac_sha1 = v0.branch("3");
        CRMFObjectIdentifiers.id_alg_dh_pop = v0.branch("4");
    }
}

