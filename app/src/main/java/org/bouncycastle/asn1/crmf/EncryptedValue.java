package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedValue extends ASN1Object {
    private ASN1BitString encSymmKey;
    private ASN1BitString encValue;
    private AlgorithmIdentifier intendedAlg;
    private AlgorithmIdentifier keyAlg;
    private AlgorithmIdentifier symmAlg;
    private ASN1OctetString valueHint;

    private EncryptedValue(ASN1Sequence arg6) {
        super();
        int v1;
        for(v1 = 0; (arg6.getObjectAt(v1) instanceof ASN1TaggedObject); ++v1) {
            ASN1Encodable v2 = arg6.getObjectAt(v1);
            int v3 = ((ASN1TaggedObject)v2).getTagNo();
            if(v3 == 0) {
                this.intendedAlg = AlgorithmIdentifier.getInstance(((ASN1TaggedObject)v2), false);
            }
            else if(v3 == 1) {
                this.symmAlg = AlgorithmIdentifier.getInstance(((ASN1TaggedObject)v2), false);
            }
            else if(v3 == 2) {
                this.encSymmKey = ASN1BitString.getInstance(((ASN1TaggedObject)v2), false);
            }
            else if(v3 == 3) {
                this.keyAlg = AlgorithmIdentifier.getInstance(((ASN1TaggedObject)v2), false);
            }
            else if(v3 == 4) {
                this.valueHint = ASN1OctetString.getInstance(((ASN1TaggedObject)v2), false);
            }
            else {
                throw new IllegalArgumentException("Unknown tag encountered: " + ((ASN1TaggedObject)v2).getTagNo());
            }
        }

        this.encValue = ASN1BitString.getInstance(arg6.getObjectAt(v1));
    }

    public EncryptedValue(AlgorithmIdentifier arg1, AlgorithmIdentifier arg2, ASN1BitString arg3, AlgorithmIdentifier arg4, ASN1OctetString arg5, ASN1BitString arg6) {
        super();
        if(arg6 != null) {
            this.intendedAlg = arg1;
            this.symmAlg = arg2;
            this.encSymmKey = arg3;
            this.keyAlg = arg4;
            this.valueHint = arg5;
            this.encValue = arg6;
            return;
        }

        throw new IllegalArgumentException("\'encValue\' cannot be null");
    }

    private void addOptional(ASN1EncodableVector arg2, int arg3, ASN1Encodable arg4) {
        if(arg4 != null) {
            arg2.add(new DERTaggedObject(false, arg3, arg4));
        }
    }

    public ASN1BitString getEncSymmKey() {
        return this.encSymmKey;
    }

    public ASN1BitString getEncValue() {
        return this.encValue;
    }

    public static EncryptedValue getInstance(Object arg1) {
        if((arg1 instanceof EncryptedValue)) {
            return arg1;
        }

        if(arg1 != null) {
            return new EncryptedValue(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public AlgorithmIdentifier getIntendedAlg() {
        return this.intendedAlg;
    }

    public AlgorithmIdentifier getKeyAlg() {
        return this.keyAlg;
    }

    public AlgorithmIdentifier getSymmAlg() {
        return this.symmAlg;
    }

    public ASN1OctetString getValueHint() {
        return this.valueHint;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(6);
        this.addOptional(v0, 0, this.intendedAlg);
        this.addOptional(v0, 1, this.symmAlg);
        this.addOptional(v0, 2, this.encSymmKey);
        this.addOptional(v0, 3, this.keyAlg);
        this.addOptional(v0, 4, this.valueHint);
        v0.add(this.encValue);
        return new DERSequence(v0);
    }
}

