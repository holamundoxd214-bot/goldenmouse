package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class PBMParameter extends ASN1Object {
    private final ASN1Integer iterationCount;
    private final AlgorithmIdentifier mac;
    private final AlgorithmIdentifier owf;
    private final ASN1OctetString salt;

    public PBMParameter(ASN1OctetString arg1, AlgorithmIdentifier arg2, ASN1Integer arg3, AlgorithmIdentifier arg4) {
        super();
        this.salt = arg1;
        this.owf = arg2;
        this.iterationCount = arg3;
        this.mac = arg4;
    }

    private PBMParameter(ASN1Sequence arg2) {
        super();
        this.salt = ASN1OctetString.getInstance(arg2.getObjectAt(0));
        this.owf = AlgorithmIdentifier.getInstance(arg2.getObjectAt(1));
        this.iterationCount = ASN1Integer.getInstance(arg2.getObjectAt(2));
        this.mac = AlgorithmIdentifier.getInstance(arg2.getObjectAt(3));
    }

    public PBMParameter(byte[] arg4, AlgorithmIdentifier arg5, int arg6, AlgorithmIdentifier arg7) {
        this(new DEROctetString(arg4), arg5, new ASN1Integer(((long)arg6)), arg7);
    }

    public static PBMParameter getInstance(Object arg1) {
        if((arg1 instanceof PBMParameter)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PBMParameter(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Integer getIterationCount() {
        return this.iterationCount;
    }

    public AlgorithmIdentifier getMac() {
        return this.mac;
    }

    public AlgorithmIdentifier getOwf() {
        return this.owf;
    }

    public ASN1OctetString getSalt() {
        return this.salt;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.salt);
        v0.add(this.owf);
        v0.add(this.iterationCount);
        v0.add(this.mac);
        return new DERSequence(v0);
    }
}

