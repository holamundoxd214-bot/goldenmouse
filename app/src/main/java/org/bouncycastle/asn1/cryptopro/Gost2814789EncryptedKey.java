package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Arrays;

public class Gost2814789EncryptedKey extends ASN1Object {
    private final byte[] encryptedKey;
    private final byte[] macKey;
    private final byte[] maskKey;

    private Gost2814789EncryptedKey(ASN1Sequence arg6) {
        super();
        int v3 = 2;
        if(arg6.size() == v3) {
            this.encryptedKey = Arrays.clone(ASN1OctetString.getInstance(arg6.getObjectAt(0)).getOctets());
            this.macKey = Arrays.clone(ASN1OctetString.getInstance(arg6.getObjectAt(1)).getOctets());
            this.maskKey = null;
            return;
        }

        if(arg6.size() == 3) {
            this.encryptedKey = Arrays.clone(ASN1OctetString.getInstance(arg6.getObjectAt(0)).getOctets());
            this.maskKey = Arrays.clone(ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(arg6.getObjectAt(1)), false).getOctets());
            this.macKey = Arrays.clone(ASN1OctetString.getInstance(arg6.getObjectAt(v3)).getOctets());
            return;
        }

        throw new IllegalArgumentException("unknown sequence length: " + arg6.size());
    }

    public Gost2814789EncryptedKey(byte[] arg2, byte[] arg3) {
        this(arg2, null, arg3);
    }

    public Gost2814789EncryptedKey(byte[] arg1, byte[] arg2, byte[] arg3) {
        super();
        this.encryptedKey = Arrays.clone(arg1);
        this.maskKey = Arrays.clone(arg2);
        this.macKey = Arrays.clone(arg3);
    }

    public byte[] getEncryptedKey() {
        return Arrays.clone(this.encryptedKey);
    }

    public static Gost2814789EncryptedKey getInstance(Object arg1) {
        if((arg1 instanceof Gost2814789EncryptedKey)) {
            return arg1;
        }

        if(arg1 != null) {
            return new Gost2814789EncryptedKey(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public byte[] getMacKey() {
        return Arrays.clone(this.macKey);
    }

    public byte[] getMaskKey() {
        return Arrays.clone(this.maskKey);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(new DEROctetString(this.encryptedKey));
        if(this.maskKey != null) {
            v0.add(new DERTaggedObject(false, 0, new DEROctetString(this.encryptedKey)));
        }

        v0.add(new DEROctetString(this.macKey));
        return new DERSequence(v0);
    }
}

