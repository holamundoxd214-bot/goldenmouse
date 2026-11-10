package org.bouncycastle.asn1.icao;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface ICAOObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_icao;
    public static final ASN1ObjectIdentifier id_icao_aaProtocolObject;
    public static final ASN1ObjectIdentifier id_icao_cscaMasterList;
    public static final ASN1ObjectIdentifier id_icao_cscaMasterListSigningKey;
    public static final ASN1ObjectIdentifier id_icao_documentTypeList;
    public static final ASN1ObjectIdentifier id_icao_extensions;
    public static final ASN1ObjectIdentifier id_icao_extensions_namechangekeyrollover;
    public static final ASN1ObjectIdentifier id_icao_ldsSecurityObject;
    public static final ASN1ObjectIdentifier id_icao_mrtd;
    public static final ASN1ObjectIdentifier id_icao_mrtd_security;

    static {
        ASN1ObjectIdentifier v0 = new ASN1ObjectIdentifier("2.23.136");
        ICAOObjectIdentifiers.id_icao = v0;
        v0 = v0.branch("1");
        ICAOObjectIdentifiers.id_icao_mrtd = v0;
        v0 = v0.branch("1");
        ICAOObjectIdentifiers.id_icao_mrtd_security = v0;
        ICAOObjectIdentifiers.id_icao_ldsSecurityObject = v0.branch("1");
        ICAOObjectIdentifiers.id_icao_cscaMasterList = v0.branch("2");
        ICAOObjectIdentifiers.id_icao_cscaMasterListSigningKey = v0.branch("3");
        ICAOObjectIdentifiers.id_icao_documentTypeList = v0.branch("4");
        ICAOObjectIdentifiers.id_icao_aaProtocolObject = v0.branch("5");
        v0 = v0.branch("6");
        ICAOObjectIdentifiers.id_icao_extensions = v0;
        ICAOObjectIdentifiers.id_icao_extensions_namechangekeyrollover = v0.branch("1");
    }
}

