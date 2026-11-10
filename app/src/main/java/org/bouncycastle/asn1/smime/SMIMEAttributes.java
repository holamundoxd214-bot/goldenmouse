package org.bouncycastle.asn1.smime;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public interface SMIMEAttributes {
    public static final ASN1ObjectIdentifier encrypKeyPref;
    public static final ASN1ObjectIdentifier smimeCapabilities;

    static {
        SMIMEAttributes.smimeCapabilities = PKCSObjectIdentifiers.pkcs_9_at_smimeCapabilities;
        SMIMEAttributes.encrypKeyPref = PKCSObjectIdentifiers.id_aa_encrypKeyPref;
    }
}

