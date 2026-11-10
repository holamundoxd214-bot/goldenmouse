package org.bouncycastle.asn1.eac;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Integers;

public class CertificateHolderAuthorization extends ASN1Object {
    static BidirectionalMap AuthorizationRole = null;
    public static final int CVCA = 0xC0;
    public static final int DV_DOMESTIC = 0x80;
    public static final int DV_FOREIGN = 0x40;
    public static final int IS = 0;
    public static final int RADG3 = 1;
    public static final int RADG4 = 2;
    static Map RightsDecodeMap;
    private byte accessRights;
    public static final ASN1ObjectIdentifier id_role_EAC;
    private ASN1ObjectIdentifier oid;

    static {
        CertificateHolderAuthorization.id_role_EAC = EACObjectIdentifiers.bsi_de.branch("3.1.2.1");
        CertificateHolderAuthorization.RightsDecodeMap = new HashMap();
        CertificateHolderAuthorization.AuthorizationRole = new BidirectionalMap();
        CertificateHolderAuthorization.RightsDecodeMap.put(Integers.valueOf(2), "RADG4");
        CertificateHolderAuthorization.RightsDecodeMap.put(Integers.valueOf(1), "RADG3");
        CertificateHolderAuthorization.AuthorizationRole.put(Integers.valueOf(0xC0), "CVCA");
        CertificateHolderAuthorization.AuthorizationRole.put(Integers.valueOf(0x80), "DV_DOMESTIC");
        CertificateHolderAuthorization.AuthorizationRole.put(Integers.valueOf(0x40), "DV_FOREIGN");
        CertificateHolderAuthorization.AuthorizationRole.put(Integers.valueOf(0), "IS");
    }

    public CertificateHolderAuthorization(ASN1TaggedObject arg3) throws IOException {
        super();
        if(arg3.hasTag(0x40, 76)) {
            this.setPrivateData(ASN1Sequence.getInstance(arg3.getBaseUniversal(false, 16)));
            return;
        }

        throw new IllegalArgumentException("Unrecognized object in CerticateHolderAuthorization");
    }

    public CertificateHolderAuthorization(ASN1ObjectIdentifier arg1, int arg2) throws IOException {
        super();
        this.setOid(arg1);
        this.setAccessRights(((byte)arg2));
    }

    public int getAccessRights() {
        return this.accessRights & 0xFF;
    }

    public static int getFlag(String arg3) {
        Object v0 = CertificateHolderAuthorization.AuthorizationRole.getReverse(arg3);
        if(v0 != null) {
            return ((Integer)v0).intValue();
        }

        throw new IllegalArgumentException("Unknown value " + arg3);
    }

    public ASN1ObjectIdentifier getOid() {
        return this.oid;
    }

    public static String getRoleDescription(int arg1) {
        return CertificateHolderAuthorization.AuthorizationRole.get(Integers.valueOf(arg1));
    }

    private void setAccessRights(byte arg1) {
        this.accessRights = arg1;
    }

    private void setOid(ASN1ObjectIdentifier arg1) {
        this.oid = arg1;
    }

    private void setPrivateData(ASN1Sequence arg4) {
        ASN1Encodable v1 = arg4.getObjectAt(0);
        if((v1 instanceof ASN1ObjectIdentifier)) {
            this.oid = ((ASN1ObjectIdentifier)v1);
            ASN1Encodable v4 = arg4.getObjectAt(1);
            if((v4 instanceof ASN1TaggedObject)) {
                this.accessRights = ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(v4, 0x40, 19).getBaseUniversal(false, 4)).getOctets()[0];
                return;
            }

            throw new IllegalArgumentException("No access rights in CerticateHolderAuthorization");
        }

        throw new IllegalArgumentException("no Oid in CerticateHolderAuthorization");
    }

    public ASN1Primitive toASN1Primitive() {
        return EACTagged.create(76, new DERSequence(this.oid, EACTagged.create(19, new byte[]{this.accessRights})));
    }
}

