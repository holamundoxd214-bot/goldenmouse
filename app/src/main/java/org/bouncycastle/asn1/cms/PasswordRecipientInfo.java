package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class PasswordRecipientInfo extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private AlgorithmIdentifier keyDerivationAlgorithm;
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private ASN1Integer version;

    private PasswordRecipientInfo(ASN1Sequence arg5) {
        ASN1Encodable v5;
        super();
        this.version = arg5.getObjectAt(0);
        int v3 = 2;
        if((arg5.getObjectAt(1) instanceof ASN1TaggedObject)) {
            this.keyDerivationAlgorithm = AlgorithmIdentifier.getInstance(arg5.getObjectAt(1), false);
            this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(arg5.getObjectAt(v3));
            v5 = arg5.getObjectAt(3);
        }
        else {
            this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(arg5.getObjectAt(1));
            v5 = arg5.getObjectAt(v3);
        }

        this.encryptedKey = ((ASN1OctetString)v5);
    }

    public PasswordRecipientInfo(AlgorithmIdentifier arg4, ASN1OctetString arg5) {
        super();
        this.version = new ASN1Integer(0);
        this.keyEncryptionAlgorithm = arg4;
        this.encryptedKey = arg5;
    }

    public PasswordRecipientInfo(AlgorithmIdentifier arg4, AlgorithmIdentifier arg5, ASN1OctetString arg6) {
        super();
        this.version = new ASN1Integer(0);
        this.keyDerivationAlgorithm = arg4;
        this.keyEncryptionAlgorithm = arg5;
        this.encryptedKey = arg6;
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public static PasswordRecipientInfo getInstance(Object arg1) {
        if((arg1 instanceof PasswordRecipientInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PasswordRecipientInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static PasswordRecipientInfo getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return PasswordRecipientInfo.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public AlgorithmIdentifier getKeyDerivationAlgorithm() {
        return this.keyDerivationAlgorithm;
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.version);
        if(this.keyDerivationAlgorithm != null) {
            v0.add(new DERTaggedObject(false, 0, this.keyDerivationAlgorithm));
        }

        v0.add(this.keyEncryptionAlgorithm);
        v0.add(this.encryptedKey);
        return new DERSequence(v0);
    }
}

