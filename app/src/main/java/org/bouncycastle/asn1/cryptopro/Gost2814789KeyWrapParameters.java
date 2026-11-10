package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class Gost2814789KeyWrapParameters extends ASN1Object {
    private final ASN1ObjectIdentifier encryptionParamSet;
    private final byte[] ukm;

    public Gost2814789KeyWrapParameters(ASN1ObjectIdentifier arg2) {
        this(arg2, null);
    }

    public Gost2814789KeyWrapParameters(ASN1ObjectIdentifier arg1, byte[] arg2) {
        super();
        this.encryptionParamSet = arg1;
        this.ukm = Arrays.clone(arg2);
    }

    private Gost2814789KeyWrapParameters(ASN1Sequence arg5) {
        super();
        if(arg5.size() == 2) {
            this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(arg5.getObjectAt(0));
            this.ukm = ASN1OctetString.getInstance(arg5.getObjectAt(1)).getOctets();
            return;
        }

        if(arg5.size() == 1) {
            this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(arg5.getObjectAt(0));
            this.ukm = null;
            return;
        }

        throw new IllegalArgumentException("unknown sequence length: " + arg5.size());
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public static Gost2814789KeyWrapParameters getInstance(Object arg1) {
        if((arg1 instanceof Gost2814789KeyWrapParameters)) {
            return arg1;
        }

        if(arg1 != null) {
            return new Gost2814789KeyWrapParameters(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public byte[] getUkm() {
        return Arrays.clone(this.ukm);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.encryptionParamSet);
        if(this.ukm != null) {
            v0.add(new DEROctetString(this.ukm));
        }

        return new DERSequence(v0);
    }
}

