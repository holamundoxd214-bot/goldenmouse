package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedContentInfo extends ASN1Object {
    private AlgorithmIdentifier contentEncryptionAlgorithm;
    private ASN1ObjectIdentifier contentType;
    private ASN1OctetString encryptedContent;

    public EncryptedContentInfo(ASN1ObjectIdentifier arg1, AlgorithmIdentifier arg2, ASN1OctetString arg3) {
        super();
        this.contentType = arg1;
        this.contentEncryptionAlgorithm = arg2;
        this.encryptedContent = arg3;
    }

    private EncryptedContentInfo(ASN1Sequence arg4) {
        super();
        int v1 = 2;
        if(arg4.size() >= v1) {
            this.contentType = arg4.getObjectAt(0);
            this.contentEncryptionAlgorithm = AlgorithmIdentifier.getInstance(arg4.getObjectAt(1));
            if(arg4.size() > v1) {
                this.encryptedContent = ASN1OctetString.getInstance(arg4.getObjectAt(v1), false);
            }

            return;
        }

        throw new IllegalArgumentException("Truncated Sequence Found");
    }

    public AlgorithmIdentifier getContentEncryptionAlgorithm() {
        return this.contentEncryptionAlgorithm;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    public ASN1OctetString getEncryptedContent() {
        return this.encryptedContent;
    }

    public static EncryptedContentInfo getInstance(Object arg1) {
        if((arg1 instanceof EncryptedContentInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new EncryptedContentInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.contentType);
        v0.add(this.contentEncryptionAlgorithm);
        if(this.encryptedContent != null) {
            v0.add(new BERTaggedObject(false, 0, this.encryptedContent));
        }

        return new BERSequence(v0);
    }
}

