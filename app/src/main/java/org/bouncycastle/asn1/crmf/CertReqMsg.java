package org.bouncycastle.asn1.crmf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class CertReqMsg extends ASN1Object {
    private CertRequest certReq;
    private ProofOfPossession pop;
    private ASN1Sequence regInfo;

    private CertReqMsg(ASN1Sequence arg3) {
        super();
        Enumeration v3 = arg3.getObjects();
        this.certReq = CertRequest.getInstance(v3.nextElement());
        while(v3.hasMoreElements()) {
            Object v0 = v3.nextElement();
            if(!(v0 instanceof ASN1TaggedObject)) {
                if((v0 instanceof ProofOfPossession)) {
                }
                else {
                    this.regInfo = ASN1Sequence.getInstance(v0);
                    continue;
                }
            }

            this.pop = ProofOfPossession.getInstance(v0);
        }
    }

    public CertReqMsg(CertRequest arg1, ProofOfPossession arg2, AttributeTypeAndValue[] arg3) {
        super();
        if(arg1 != null) {
            this.certReq = arg1;
            this.pop = arg2;
            if(arg3 != null) {
                this.regInfo = new DERSequence(((ASN1Encodable[])arg3));
            }

            return;
        }

        throw new IllegalArgumentException("\'certReq\' cannot be null");
    }

    private void addOptional(ASN1EncodableVector arg1, ASN1Encodable arg2) {
        if(arg2 != null) {
            arg1.add(arg2);
        }
    }

    public CertRequest getCertReq() {
        return this.certReq;
    }

    public static CertReqMsg getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return CertReqMsg.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public static CertReqMsg getInstance(Object arg1) {
        if((arg1 instanceof CertReqMsg)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertReqMsg(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ProofOfPossession getPop() {
        return this.pop;
    }

    public ProofOfPossession getPopo() {
        return this.pop;
    }

    public AttributeTypeAndValue[] getRegInfo() {
        ASN1Sequence v0 = this.regInfo;
        if(v0 == null) {
            return null;
        }

        int v0_1 = v0.size();
        AttributeTypeAndValue[] v1 = new AttributeTypeAndValue[v0_1];
        int v2;
        for(v2 = 0; v2 != v0_1; ++v2) {
            v1[v2] = AttributeTypeAndValue.getInstance(this.regInfo.getObjectAt(v2));
        }

        return v1;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.certReq);
        this.addOptional(v0, this.pop);
        this.addOptional(v0, this.regInfo);
        return new DERSequence(v0);
    }
}

