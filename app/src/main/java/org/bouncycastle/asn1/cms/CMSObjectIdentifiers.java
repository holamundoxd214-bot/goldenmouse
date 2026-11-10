package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;

public interface CMSObjectIdentifiers {
    public static final ASN1ObjectIdentifier authEnvelopedData;
    public static final ASN1ObjectIdentifier authenticatedData;
    public static final ASN1ObjectIdentifier compressedData;
    public static final ASN1ObjectIdentifier data;
    public static final ASN1ObjectIdentifier digestedData;
    public static final ASN1ObjectIdentifier encryptedData;
    public static final ASN1ObjectIdentifier envelopedData;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE128;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE256;
    public static final ASN1ObjectIdentifier id_alg;
    public static final ASN1ObjectIdentifier id_alg_cek_hkdf_sha256;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake128;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake256;
    public static final ASN1ObjectIdentifier id_ori;
    public static final ASN1ObjectIdentifier id_ori_kem;
    public static final ASN1ObjectIdentifier id_ri;
    public static final ASN1ObjectIdentifier id_ri_ocsp_response;
    public static final ASN1ObjectIdentifier id_ri_scvp;
    public static final ASN1ObjectIdentifier signedAndEnvelopedData;
    public static final ASN1ObjectIdentifier signedData;
    public static final ASN1ObjectIdentifier timestampedData;
    public static final ASN1ObjectIdentifier zlibCompress;

    static {
        CMSObjectIdentifiers.data = PKCSObjectIdentifiers.data;
        CMSObjectIdentifiers.signedData = PKCSObjectIdentifiers.signedData;
        CMSObjectIdentifiers.envelopedData = PKCSObjectIdentifiers.envelopedData;
        CMSObjectIdentifiers.signedAndEnvelopedData = PKCSObjectIdentifiers.signedAndEnvelopedData;
        CMSObjectIdentifiers.digestedData = PKCSObjectIdentifiers.digestedData;
        CMSObjectIdentifiers.encryptedData = PKCSObjectIdentifiers.encryptedData;
        CMSObjectIdentifiers.authenticatedData = PKCSObjectIdentifiers.id_ct_authData;
        CMSObjectIdentifiers.compressedData = PKCSObjectIdentifiers.id_ct_compressedData;
        CMSObjectIdentifiers.authEnvelopedData = PKCSObjectIdentifiers.id_ct_authEnvelopedData;
        CMSObjectIdentifiers.timestampedData = PKCSObjectIdentifiers.id_ct_timestampedData;
        CMSObjectIdentifiers.zlibCompress = PKCSObjectIdentifiers.id_alg_zlibCompress;
        ASN1ObjectIdentifier v0 = X509ObjectIdentifiers.id_pkix.branch("16");
        CMSObjectIdentifiers.id_ri = v0;
        CMSObjectIdentifiers.id_ri_ocsp_response = v0.branch("2");
        CMSObjectIdentifiers.id_ri_scvp = v0.branch("4");
        CMSObjectIdentifiers.id_alg = X509ObjectIdentifiers.pkix_algorithms;
        CMSObjectIdentifiers.id_RSASSA_PSS_SHAKE128 = X509ObjectIdentifiers.id_rsassa_pss_shake128;
        CMSObjectIdentifiers.id_RSASSA_PSS_SHAKE256 = X509ObjectIdentifiers.id_rsassa_pss_shake256;
        CMSObjectIdentifiers.id_ecdsa_with_shake128 = X509ObjectIdentifiers.id_ecdsa_with_shake128;
        CMSObjectIdentifiers.id_ecdsa_with_shake256 = X509ObjectIdentifiers.id_ecdsa_with_shake256;
        v0 = PKCSObjectIdentifiers.id_smime.branch("13");
        CMSObjectIdentifiers.id_ori = v0;
        CMSObjectIdentifiers.id_ori_kem = v0.branch("3");
        CMSObjectIdentifiers.id_alg_cek_hkdf_sha256 = PKCSObjectIdentifiers.smime_alg.branch("31");
    }
}

