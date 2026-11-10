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

public class KEKRecipientInfo extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private KEKIdentifier kekid;
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private ASN1Integer version;

    public KEKRecipientInfo(ASN1Sequence arg2) {
        super();
        this.version = arg2.getObjectAt(0);
        this.kekid = KEKIdentifier.getInstance(arg2.getObjectAt(1));
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(arg2.getObjectAt(2));
        this.encryptedKey = arg2.getObjectAt(3);
    }

    public KEKRecipientInfo(KEKIdentifier arg4, AlgorithmIdentifier arg5, ASN1OctetString arg6) {
        super();
        this.version = new ASN1Integer(4);
        this.kekid = arg4;
        this.keyEncryptionAlgorithm = arg5;
        this.encryptedKey = arg6;
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public static KEKRecipientInfo getInstance(Object arg1) {
        if((arg1 instanceof KEKRecipientInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new KEKRecipientInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static KEKRecipientInfo getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return KEKRecipientInfo.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public KEKIdentifier getKekid() {
        return this.kekid;
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
        v0.add(this.kekid);
        v0.add(this.keyEncryptionAlgorithm);
        v0.add(this.encryptedKey);
        return new DERSequence(v0);
    }
}

