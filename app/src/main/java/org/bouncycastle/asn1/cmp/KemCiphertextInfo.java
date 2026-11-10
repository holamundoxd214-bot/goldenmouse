package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KemCiphertextInfo extends ASN1Object {
    private final ASN1OctetString ct;
    private final AlgorithmIdentifier kem;

    private KemCiphertextInfo(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.kem = AlgorithmIdentifier.getInstance(arg3.getObjectAt(0));
            this.ct = ASN1OctetString.getInstance(arg3.getObjectAt(1));
            return;
        }

        throw new IllegalArgumentException("sequence size should 2");
    }

    public KemCiphertextInfo(AlgorithmIdentifier arg1, ASN1OctetString arg2) {
        super();
        this.kem = arg1;
        this.ct = arg2;
    }

    public ASN1OctetString getCt() {
        return this.ct;
    }

    public static KemCiphertextInfo getInstance(Object arg1) {
        if((arg1 instanceof KemCiphertextInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new KemCiphertextInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public AlgorithmIdentifier getKem() {
        return this.kem;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.kem, this.ct);
    }
}

