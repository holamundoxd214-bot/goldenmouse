package org.bouncycastle.asn1.cmp;

import java.util.Iterator;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class RootCaKeyUpdateContent extends ASN1Object {
    private final CMPCertificate newWithNew;
    private final CMPCertificate newWithOld;
    private final CMPCertificate oldWithNew;

    private RootCaKeyUpdateContent(ASN1Sequence arg7) {
        super();
        if(arg7.size() >= 1 && arg7.size() <= 3) {
            Iterator v7 = arg7.iterator();
            CMPCertificate v0 = CMPCertificate.getInstance(v7.next());
            CMPCertificate v2 = null;
            CMPCertificate v3 = v2;
            while(v7.hasNext()) {
                ASN1TaggedObject v4 = ASN1TaggedObject.getInstance(v7.next());
                if(v4.hasContextTag(0)) {
                    v2 = CMPCertificate.getInstance(v4, true);
                }
                else {
                    if(!v4.hasContextTag(1)) {
                        continue;
                    }

                    v3 = CMPCertificate.getInstance(v4, true);
                }
            }

            this.newWithNew = v0;
            this.newWithOld = v2;
            this.oldWithNew = v3;
            return;
        }

        throw new IllegalArgumentException("expected sequence of 1 to 3 elements only");
    }

    public RootCaKeyUpdateContent(CMPCertificate arg1, CMPCertificate arg2, CMPCertificate arg3) {
        super();
        if(arg1 != null) {
            this.newWithNew = arg1;
            this.newWithOld = arg2;
            this.oldWithNew = arg3;
            return;
        }

        throw new NullPointerException("\'newWithNew\' cannot be null");
    }

    public static RootCaKeyUpdateContent getInstance(Object arg1) {
        if((arg1 instanceof RootCaKeyUpdateContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new RootCaKeyUpdateContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public CMPCertificate getNewWithNew() {
        return this.newWithNew;
    }

    public CMPCertificate getNewWithOld() {
        return this.newWithOld;
    }

    public CMPCertificate getOldWithNew() {
        return this.oldWithNew;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.newWithNew);
        if(this.newWithOld != null) {
            v0.add(new DERTaggedObject(true, 0, this.newWithOld));
        }

        if(this.oldWithNew != null) {
            v0.add(new DERTaggedObject(true, 1, this.oldWithNew));
        }

        return new DERSequence(v0);
    }
}

