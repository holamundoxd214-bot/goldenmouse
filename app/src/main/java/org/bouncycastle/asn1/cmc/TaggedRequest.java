package org.bouncycastle.asn1.cmc;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertReqMsg;

public class TaggedRequest extends ASN1Object implements ASN1Choice {
    public static final int CRM = 1;
    public static final int ORM = 2;
    public static final int TCR;
    private final int tagNo;
    private final ASN1Encodable value;

    private TaggedRequest(ASN1Sequence arg2) {
        super();
        this.tagNo = 2;
        this.value = ((ASN1Encodable)arg2);
    }

    public TaggedRequest(TaggedCertificationRequest arg2) {
        super();
        this.tagNo = 0;
        this.value = ((ASN1Encodable)arg2);
    }

    public TaggedRequest(CertReqMsg arg2) {
        super();
        this.tagNo = 1;
        this.value = ((ASN1Encodable)arg2);
    }

    public static TaggedRequest getInstance(Object arg3) {
        if((arg3 instanceof TaggedRequest)) {
            return arg3;
        }

        if(arg3 != null) {
            if((arg3 instanceof ASN1Encodable)) {
                ASN1TaggedObject v3 = ASN1TaggedObject.getInstance(((ASN1Encodable)arg3).toASN1Primitive());
                int v0 = v3.getTagNo();
                if(v0 != 0) {
                    if(v0 != 1) {
                        if(v0 == 2) {
                            return new TaggedRequest(ASN1Sequence.getInstance(v3, false));
                        }

                        throw new IllegalArgumentException("unknown tag in getInstance(): " + v3.getTagNo());
                    }

                    return new TaggedRequest(CertReqMsg.getInstance(v3, false));
                }

                return new TaggedRequest(TaggedCertificationRequest.getInstance(v3, false));
            }

            if((arg3 instanceof byte[])) {
                try {
                    return TaggedRequest.getInstance(ASN1Primitive.fromByteArray(((byte[])arg3)));
                }
                catch(IOException ) {
                    throw new IllegalArgumentException("unknown encoding in getInstance()");
                }
            }

            throw new IllegalArgumentException("unknown object in getInstance(): " + arg3.getClass().getName());
        }

        return null;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, this.value);
    }
}

