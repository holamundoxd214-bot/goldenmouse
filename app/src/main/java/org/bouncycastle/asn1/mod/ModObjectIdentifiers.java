package org.bouncycastle.asn1.mod;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface ModObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_mod;
    public static final ASN1ObjectIdentifier id_mod_algorithmInformation_02;

    static {
        ASN1ObjectIdentifier v0 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.0");
        ModObjectIdentifiers.id_mod = v0;
        ModObjectIdentifiers.id_mod_algorithmInformation_02 = v0.branch("58");
    }
}

