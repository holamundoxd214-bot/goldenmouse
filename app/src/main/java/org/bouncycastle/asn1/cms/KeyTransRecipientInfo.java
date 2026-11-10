package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KeyTransRecipientInfo extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private RecipientIdentifier rid;
    private ASN1Integer version;

    private KeyTransRecipientInfo(ASN1Sequence arg2) {
        super();
        this.version = arg2.getObjectAt(0);
        this.rid = RecipientIdentifier.getInstance(arg2.getObjectAt(1));
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(arg2.getObjectAt(2));
        this.encryptedKey = arg2.getObjectAt(3);
    }

    public KeyTransRecipientInfo(RecipientIdentifier arg4, AlgorithmIdentifier arg5, ASN1OctetString arg6) {
        super();
        ASN1Integer v0 = (arg4.toASN1Primitive() instanceof ASN1TaggedObject) ? new ASN1Integer(2) : new ASN1Integer(0);
        this.version = v0;
        this.rid = arg4;
        this.keyEncryptionAlgorithm = arg5;
        this.encryptedKey = arg6;
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public static KeyTransRecipientInfo getInstance(Object arg1) {
        if((arg1 instanceof KeyTransRecipientInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new KeyTransRecipientInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public RecipientIdentifier getRecipientIdentifier() {
        return this.rid;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.version);
        v0.add(this.rid);
        v0.add(this.keyEncryptionAlgorithm);
        v0.add(this.encryptedKey);
        return new DERSequence(v0);
    }
}

