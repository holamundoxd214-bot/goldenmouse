package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class GostR3410KeyTransport extends ASN1Object {
    private final Gost2814789EncryptedKey sessionEncryptedKey;
    private final GostR3410TransportParameters transportParameters;

    private GostR3410KeyTransport(ASN1Sequence arg3) {
        super();
        this.sessionEncryptedKey = Gost2814789EncryptedKey.getInstance(arg3.getObjectAt(0));
        this.transportParameters = GostR3410TransportParameters.getInstance(ASN1TaggedObject.getInstance(arg3.getObjectAt(1)), false);
    }

    public GostR3410KeyTransport(Gost2814789EncryptedKey arg1, GostR3410TransportParameters arg2) {
        super();
        this.sessionEncryptedKey = arg1;
        this.transportParameters = arg2;
    }

    public static GostR3410KeyTransport getInstance(Object arg1) {
        if((arg1 instanceof GostR3410KeyTransport)) {
            return arg1;
        }

        if(arg1 != null) {
            return new GostR3410KeyTransport(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public Gost2814789EncryptedKey getSessionEncryptedKey() {
        return this.sessionEncryptedKey;
    }

    public GostR3410TransportParameters getTransportParameters() {
        return this.transportParameters;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.sessionEncryptedKey);
        if(this.transportParameters != null) {
            v0.add(new DERTaggedObject(false, 0, this.transportParameters));
        }

        return new DERSequence(v0);
    }
}

