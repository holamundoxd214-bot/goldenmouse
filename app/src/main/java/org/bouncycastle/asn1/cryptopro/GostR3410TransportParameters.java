package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.util.Arrays;

public class GostR3410TransportParameters extends ASN1Object {
    private final ASN1ObjectIdentifier encryptionParamSet;
    private final SubjectPublicKeyInfo ephemeralPublicKey;
    private final byte[] ukm;

    public GostR3410TransportParameters(ASN1ObjectIdentifier arg1, SubjectPublicKeyInfo arg2, byte[] arg3) {
        super();
        this.encryptionParamSet = arg1;
        this.ephemeralPublicKey = arg2;
        this.ukm = Arrays.clone(arg3);
    }

    private GostR3410TransportParameters(ASN1Sequence arg6) {
        super();
        int v3 = 2;
        if(arg6.size() == v3) {
            this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(arg6.getObjectAt(0));
            this.ukm = ASN1OctetString.getInstance(arg6.getObjectAt(1)).getOctets();
            this.ephemeralPublicKey = null;
            return;
        }

        if(arg6.size() == 3) {
            this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(arg6.getObjectAt(0));
            this.ephemeralPublicKey = SubjectPublicKeyInfo.getInstance(ASN1TaggedObject.getInstance(arg6.getObjectAt(1)), false);
            this.ukm = ASN1OctetString.getInstance(arg6.getObjectAt(v3)).getOctets();
            return;
        }

        throw new IllegalArgumentException("unknown sequence length: " + arg6.size());
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public SubjectPublicKeyInfo getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public static GostR3410TransportParameters getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return new GostR3410TransportParameters(ASN1Sequence.getInstance(arg1, arg2));
    }

    public static GostR3410TransportParameters getInstance(Object arg1) {
        if((arg1 instanceof GostR3410TransportParameters)) {
            return arg1;
        }

        if(arg1 != null) {
            return new GostR3410TransportParameters(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public byte[] getUkm() {
        return Arrays.clone(this.ukm);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.encryptionParamSet);
        if(this.ephemeralPublicKey != null) {
            v0.add(new DERTaggedObject(false, 0, this.ephemeralPublicKey));
        }

        v0.add(new DEROctetString(this.ukm));
        return new DERSequence(v0);
    }
}

