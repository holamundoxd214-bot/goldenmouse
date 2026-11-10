package org.bouncycastle.asn1.cms;

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

public class KeyAgreeRecipientInfo extends ASN1Object {
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private OriginatorIdentifierOrKey originator;
    private ASN1Sequence recipientEncryptedKeys;
    private ASN1OctetString ukm;
    private ASN1Integer version;

    private KeyAgreeRecipientInfo(ASN1Sequence arg4) {
        super();
        this.version = arg4.getObjectAt(0);
        this.originator = OriginatorIdentifierOrKey.getInstance(arg4.getObjectAt(1), true);
        int v1 = 2;
        if((arg4.getObjectAt(v1) instanceof ASN1TaggedObject)) {
            this.ukm = ASN1OctetString.getInstance(arg4.getObjectAt(v1), true);
            v1 = 3;
        }

        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(arg4.getObjectAt(v1));
        this.recipientEncryptedKeys = arg4.getObjectAt(v1 + 1);
    }

    public KeyAgreeRecipientInfo(OriginatorIdentifierOrKey arg4, ASN1OctetString arg5, AlgorithmIdentifier arg6, ASN1Sequence arg7) {
        super();
        this.version = new ASN1Integer(3);
        this.originator = arg4;
        this.ukm = arg5;
        this.keyEncryptionAlgorithm = arg6;
        this.recipientEncryptedKeys = arg7;
    }

    public static KeyAgreeRecipientInfo getInstance(Object arg1) {
        if((arg1 instanceof KeyAgreeRecipientInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new KeyAgreeRecipientInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static KeyAgreeRecipientInfo getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return KeyAgreeRecipientInfo.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public OriginatorIdentifierOrKey getOriginator() {
        return this.originator;
    }

    public ASN1Sequence getRecipientEncryptedKeys() {
        return this.recipientEncryptedKeys;
    }

    public ASN1OctetString getUserKeyingMaterial() {
        return this.ukm;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(5);
        v0.add(this.version);
        v0.add(new DERTaggedObject(true, 0, this.originator));
        if(this.ukm != null) {
            v0.add(new DERTaggedObject(true, 1, this.ukm));
        }

        v0.add(this.keyEncryptionAlgorithm);
        v0.add(this.recipientEncryptedKeys);
        return new DERSequence(v0);
    }
}

