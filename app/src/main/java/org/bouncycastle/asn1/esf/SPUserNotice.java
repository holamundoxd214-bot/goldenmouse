package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.DisplayText;
import org.bouncycastle.asn1.x509.NoticeReference;

public class SPUserNotice extends ASN1Object {
    private DisplayText explicitText;
    private NoticeReference noticeRef;

    private SPUserNotice(ASN1Sequence arg3) {
        super();
        Enumeration v3 = arg3.getObjects();
        while(v3.hasMoreElements()) {
            Object v0 = v3.nextElement();
            if(!(v0 instanceof DisplayText)) {
                if((v0 instanceof ASN1String)) {
                }
                else {
                    if(!(v0 instanceof NoticeReference)) {
                        if((v0 instanceof ASN1Sequence)) {
                        }
                        else {
                            throw new IllegalArgumentException("Invalid element in \'SPUserNotice\': " + v0.getClass().getName());
                        }
                    }

                    this.noticeRef = NoticeReference.getInstance(v0);
                    continue;
                }
            }

            this.explicitText = DisplayText.getInstance(v0);
        }
    }

    public SPUserNotice(NoticeReference arg1, DisplayText arg2) {
        super();
        this.noticeRef = arg1;
        this.explicitText = arg2;
    }

    public DisplayText getExplicitText() {
        return this.explicitText;
    }

    public static SPUserNotice getInstance(Object arg1) {
        if((arg1 instanceof SPUserNotice)) {
            return arg1;
        }

        if(arg1 != null) {
            return new SPUserNotice(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public NoticeReference getNoticeRef() {
        return this.noticeRef;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        NoticeReference v1 = this.noticeRef;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        DisplayText v2 = this.explicitText;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

