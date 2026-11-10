package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class PKIMessage extends ASN1Object {
    private final PKIBody body;
    private final ASN1Sequence extraCerts;
    private final PKIHeader header;
    private final ASN1BitString protection;

    private PKIMessage(ASN1Sequence arg6) {
        super();
        Enumeration v6 = arg6.getObjects();
        this.header = PKIHeader.getInstance(v6.nextElement());
        if(v6.hasMoreElements()) {
            this.body = PKIBody.getInstance(v6.nextElement());
            ASN1BitString v0 = null;
            ASN1Sequence v1;
            for(v1 = ((ASN1Sequence)v0); v6.hasMoreElements(); v1 = ASN1Sequence.getInstance(((ASN1TaggedObject)v2), true)) {
                Object v2 = v6.nextElement();
                if(((ASN1TaggedObject)v2).getTagNo() == 0) {
                    v0 = ASN1BitString.getInstance(((ASN1TaggedObject)v2), true);
                    continue;
                }
            }

            this.protection = v0;
            this.extraCerts = v1;
            return;
        }

        throw new IllegalArgumentException("PKIMessage missing PKIBody structure");
    }

    public PKIMessage(PKIHeader arg2, PKIBody arg3) {
        this(arg2, arg3, null, null);
    }

    public PKIMessage(PKIHeader arg1, PKIBody arg2, ASN1BitString arg3, CMPCertificate[] arg4) {
        DERSequence v1;
        super();
        this.header = arg1;
        this.body = arg2;
        this.protection = arg3;
        if(arg4 != null) {
            v1 = new DERSequence(((ASN1Encodable[])arg4));
        }
        else {
            ASN1Sequence v1_1 = null;
        }

        this.extraCerts = ((ASN1Sequence)v1);
    }

    public PKIMessage(PKIHeader arg2, PKIBody arg3, ASN1BitString arg4) {
        this(arg2, arg3, arg4, null);
    }

    private void addOptional(ASN1EncodableVector arg2, int arg3, ASN1Encodable arg4) {
        if(arg4 != null) {
            arg2.add(new DERTaggedObject(true, arg3, arg4));
        }
    }

    public PKIBody getBody() {
        return this.body;
    }

    public CMPCertificate[] getExtraCerts() {
        ASN1Sequence v0 = this.extraCerts;
        if(v0 == null) {
            return null;
        }

        int v0_1 = v0.size();
        CMPCertificate[] v1 = new CMPCertificate[v0_1];
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            v1[v2] = CMPCertificate.getInstance(this.extraCerts.getObjectAt(v2));
        }

        return v1;
    }

    public PKIHeader getHeader() {
        return this.header;
    }

    public static PKIMessage getInstance(Object arg1) {
        if((arg1 instanceof PKIMessage)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PKIMessage(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1BitString getProtection() {
        return this.protection;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.header);
        v0.add(this.body);
        this.addOptional(v0, 0, this.protection);
        this.addOptional(v0, 1, this.extraCerts);
        return new DERSequence(v0);
    }
}

