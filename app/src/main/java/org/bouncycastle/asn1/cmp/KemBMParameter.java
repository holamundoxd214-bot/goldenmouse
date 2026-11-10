package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KemBMParameter extends ASN1Object {
    private final AlgorithmIdentifier kdf;
    private final ASN1Integer len;
    private final AlgorithmIdentifier mac;

    private KemBMParameter(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 3) {
            this.kdf = AlgorithmIdentifier.getInstance(arg3.getObjectAt(0));
            this.len = ASN1Integer.getInstance(arg3.getObjectAt(1));
            this.mac = AlgorithmIdentifier.getInstance(arg3.getObjectAt(2));
            return;
        }

        throw new IllegalArgumentException("sequence size should 3");
    }

    public KemBMParameter(AlgorithmIdentifier arg2, long arg3, AlgorithmIdentifier arg5) {
        this(arg2, new ASN1Integer(arg3), arg5);
    }

    public KemBMParameter(AlgorithmIdentifier arg1, ASN1Integer arg2, AlgorithmIdentifier arg3) {
        super();
        this.kdf = arg1;
        this.len = arg2;
        this.mac = arg3;
    }

    public static KemBMParameter getInstance(Object arg1) {
        if((arg1 instanceof KemBMParameter)) {
            return arg1;
        }

        if(arg1 != null) {
            return new KemBMParameter(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public AlgorithmIdentifier getKdf() {
        return this.kdf;
    }

    public ASN1Integer getLen() {
        return this.len;
    }

    public AlgorithmIdentifier getMac() {
        return this.mac;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.kdf);
        v0.add(this.len);
        v0.add(this.mac);
        return new DERSequence(v0);
    }
}

