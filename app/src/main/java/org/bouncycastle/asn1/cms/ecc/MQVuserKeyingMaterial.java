package org.bouncycastle.asn1.cms.ecc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.OriginatorPublicKey;

public class MQVuserKeyingMaterial extends ASN1Object {
    private ASN1OctetString addedukm;
    private OriginatorPublicKey ephemeralPublicKey;

    private MQVuserKeyingMaterial(ASN1Sequence arg4) {
        super();
        if(arg4.size() != 1) {
            if(arg4.size() == 2) {
            }
            else {
                throw new IllegalArgumentException("Sequence has incorrect number of elements");
            }
        }

        this.ephemeralPublicKey = OriginatorPublicKey.getInstance(arg4.getObjectAt(0));
        if(arg4.size() > 1) {
            this.addedukm = ASN1OctetString.getInstance(arg4.getObjectAt(1), true);
        }
    }

    public MQVuserKeyingMaterial(OriginatorPublicKey arg1, ASN1OctetString arg2) {
        super();
        if(arg1 != null) {
            this.ephemeralPublicKey = arg1;
            this.addedukm = arg2;
            return;
        }

        throw new IllegalArgumentException("Ephemeral public key cannot be null");
    }

    public ASN1OctetString getAddedukm() {
        return this.addedukm;
    }

    public OriginatorPublicKey getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public static MQVuserKeyingMaterial getInstance(Object arg1) {
        if((arg1 instanceof MQVuserKeyingMaterial)) {
            return arg1;
        }

        if(arg1 != null) {
            return new MQVuserKeyingMaterial(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static MQVuserKeyingMaterial getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return MQVuserKeyingMaterial.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.ephemeralPublicKey);
        if(this.addedukm != null) {
            v0.add(new DERTaggedObject(true, 0, this.addedukm));
        }

        return new DERSequence(v0);
    }
}

