package org.bouncycastle.asn1.cms.ecc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class ECCCMSSharedInfo extends ASN1Object {
    private final byte[] entityUInfo;
    private final AlgorithmIdentifier keyInfo;
    private final byte[] suppPubInfo;

    private ECCCMSSharedInfo(ASN1Sequence arg4) {
        super();
        this.keyInfo = AlgorithmIdentifier.getInstance(arg4.getObjectAt(0));
        int v2 = 2;
        if(arg4.size() == v2) {
            this.entityUInfo = null;
            this.suppPubInfo = ASN1OctetString.getInstance(arg4.getObjectAt(1), true).getOctets();
            return;
        }

        this.entityUInfo = ASN1OctetString.getInstance(arg4.getObjectAt(1), true).getOctets();
        this.suppPubInfo = ASN1OctetString.getInstance(arg4.getObjectAt(v2), true).getOctets();
    }

    public ECCCMSSharedInfo(AlgorithmIdentifier arg1, byte[] arg2) {
        super();
        this.keyInfo = arg1;
        this.entityUInfo = null;
        this.suppPubInfo = Arrays.clone(arg2);
    }

    public ECCCMSSharedInfo(AlgorithmIdentifier arg1, byte[] arg2, byte[] arg3) {
        super();
        this.keyInfo = arg1;
        this.entityUInfo = Arrays.clone(arg2);
        this.suppPubInfo = Arrays.clone(arg3);
    }

    public static ECCCMSSharedInfo getInstance(Object arg1) {
        if((arg1 instanceof ECCCMSSharedInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ECCCMSSharedInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static ECCCMSSharedInfo getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return ECCCMSSharedInfo.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.keyInfo);
        if(this.entityUInfo != null) {
            v0.add(new DERTaggedObject(true, 0, new DEROctetString(this.entityUInfo)));
        }

        v0.add(new DERTaggedObject(true, 2, new DEROctetString(this.suppPubInfo)));
        return new DERSequence(v0);
    }
}

