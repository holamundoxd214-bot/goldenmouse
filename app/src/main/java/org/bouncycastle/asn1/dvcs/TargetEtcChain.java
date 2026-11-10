package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class TargetEtcChain extends ASN1Object {
    private ASN1Sequence chain;
    private PathProcInput pathProcInput;
    private CertEtcToken target;

    private TargetEtcChain(ASN1Sequence arg3) {
        super();
        this.target = CertEtcToken.getInstance(arg3.getObjectAt(0));
        if(arg3.size() > 1) {
            ASN1Encodable v0 = arg3.getObjectAt(1);
            if((v0 instanceof ASN1TaggedObject)) {
                this.extractPathProcInput(v0);
                return;
            }
            else {
                this.chain = ASN1Sequence.getInstance(v0);
                int v1 = 2;
                if(arg3.size() > v1) {
                    this.extractPathProcInput(arg3.getObjectAt(v1));
                }
            }
        }
    }

    public TargetEtcChain(CertEtcToken arg2) {
        this(arg2, null, null);
    }

    public TargetEtcChain(CertEtcToken arg1, CertEtcToken[] arg2, PathProcInput arg3) {
        super();
        this.target = arg1;
        if(arg2 != null) {
            this.chain = new DERSequence(((ASN1Encodable[])arg2));
        }

        this.pathProcInput = arg3;
    }

    public TargetEtcChain(CertEtcToken arg2, PathProcInput arg3) {
        this(arg2, null, arg3);
    }

    public TargetEtcChain(CertEtcToken arg2, CertEtcToken[] arg3) {
        this(arg2, arg3, null);
    }

    public static TargetEtcChain[] arrayFromSequence(ASN1Sequence arg4) {
        int v0 = arg4.size();
        TargetEtcChain[] v1 = new TargetEtcChain[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = TargetEtcChain.getInstance(arg4.getObjectAt(v2));
        }

        return v1;
    }

    private void extractPathProcInput(ASN1Encodable arg3) {
        ASN1TaggedObject v3 = ASN1TaggedObject.getInstance(arg3);
        if(v3.getTagNo() == 0) {
            this.pathProcInput = PathProcInput.getInstance(v3, false);
            return;
        }

        throw new IllegalArgumentException("Unknown tag encountered: " + v3.getTagNo());
    }

    public CertEtcToken[] getChain() {
        ASN1Sequence v0 = this.chain;
        if(v0 != null) {
            return CertEtcToken.arrayFromSequence(v0);
        }

        return null;
    }

    public static TargetEtcChain getInstance(Object arg1) {
        if((arg1 instanceof TargetEtcChain)) {
            return arg1;
        }

        if(arg1 != null) {
            return new TargetEtcChain(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static TargetEtcChain getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return TargetEtcChain.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public PathProcInput getPathProcInput() {
        return this.pathProcInput;
    }

    public CertEtcToken getTarget() {
        return this.target;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.target);
        ASN1Sequence v1 = this.chain;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        if(this.pathProcInput != null) {
            v0.add(new DERTaggedObject(false, 0, this.pathProcInput));
        }

        return new DERSequence(v0);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("TargetEtcChain {\n");
        String v2 = "\n";
        v0.append("target: " + this.target + v2);
        if(this.chain != null) {
            v0.append("chain: " + this.chain + v2);
        }

        if(this.pathProcInput != null) {
            v0.append("pathProcInput: " + this.pathProcInput + v2);
        }

        v0.append("}\n");
        return v0.toString();
    }
}

