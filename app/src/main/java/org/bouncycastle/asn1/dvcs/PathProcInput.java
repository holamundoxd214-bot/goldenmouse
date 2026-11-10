package org.bouncycastle.asn1.dvcs;

import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.PolicyInformation;

public class PathProcInput extends ASN1Object {
    private PolicyInformation[] acceptablePolicySet;
    private boolean explicitPolicyReqd;
    private boolean inhibitAnyPolicy;
    private boolean inhibitPolicyMapping;

    public PathProcInput(PolicyInformation[] arg2) {
        super();
        this.inhibitPolicyMapping = false;
        this.explicitPolicyReqd = false;
        this.inhibitAnyPolicy = false;
        this.acceptablePolicySet = this.copy(arg2);
    }

    public PathProcInput(PolicyInformation[] arg2, boolean arg3, boolean arg4, boolean arg5) {
        super();
        this.inhibitPolicyMapping = false;
        this.explicitPolicyReqd = false;
        this.inhibitAnyPolicy = false;
        this.acceptablePolicySet = this.copy(arg2);
        this.inhibitPolicyMapping = arg3;
        this.explicitPolicyReqd = arg4;
        this.inhibitAnyPolicy = arg5;
    }

    private PolicyInformation[] copy(PolicyInformation[] arg3) {
        int v2 = arg3.length;
        PolicyInformation[] v0 = new PolicyInformation[v2];
        System.arraycopy(arg3, 0, v0, 0, v2);
        return v0;
    }

    private static PolicyInformation[] fromSequence(ASN1Sequence arg4) {
        int v0 = arg4.size();
        PolicyInformation[] v1 = new PolicyInformation[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = PolicyInformation.getInstance(arg4.getObjectAt(v2));
        }

        return v1;
    }

    public PolicyInformation[] getAcceptablePolicySet() {
        return this.copy(this.acceptablePolicySet);
    }

    public static PathProcInput getInstance(Object arg6) {
        if((arg6 instanceof PathProcInput)) {
            return arg6;
        }

        if(arg6 != null) {
            ASN1Sequence v6 = ASN1Sequence.getInstance(arg6);
            PathProcInput v2 = new PathProcInput(PathProcInput.fromSequence(ASN1Sequence.getInstance(v6.getObjectAt(0))));
            int v3;
            for(v3 = 1; v3 < v6.size(); ++v3) {
                ASN1Encodable v4 = v6.getObjectAt(v3);
                if((v4 instanceof ASN1Boolean)) {
                    v2.setInhibitPolicyMapping(ASN1Boolean.getInstance(v4).isTrue());
                }
                else if((v4 instanceof ASN1TaggedObject)) {
                    ASN1TaggedObject v4_1 = ASN1TaggedObject.getInstance(v4);
                    int v5 = v4_1.getTagNo();
                    if(v5 == 0) {
                        v2.setExplicitPolicyReqd(ASN1Boolean.getInstance(v4_1, false).isTrue());
                    }
                    else if(v5 == 1) {
                        v2.setInhibitAnyPolicy(ASN1Boolean.getInstance(v4_1, false).isTrue());
                    }
                    else {
                        throw new IllegalArgumentException("Unknown tag encountered: " + v4_1.getTagNo());
                    }
                }
            }

            return v2;
        }

        return null;
    }

    public static PathProcInput getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return PathProcInput.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public boolean isExplicitPolicyReqd() {
        return this.explicitPolicyReqd;
    }

    public boolean isInhibitAnyPolicy() {
        return this.inhibitAnyPolicy;
    }

    public boolean isInhibitPolicyMapping() {
        return this.inhibitPolicyMapping;
    }

    private void setExplicitPolicyReqd(boolean arg1) {
        this.explicitPolicyReqd = arg1;
    }

    private void setInhibitAnyPolicy(boolean arg1) {
        this.inhibitAnyPolicy = arg1;
    }

    private void setInhibitPolicyMapping(boolean arg1) {
        this.inhibitPolicyMapping = arg1;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        ASN1EncodableVector v1 = new ASN1EncodableVector(this.acceptablePolicySet.length);
        int v3;
        for(v3 = 0; true; ++v3) {
            PolicyInformation[] v4 = this.acceptablePolicySet;
            if(v3 == v4.length) {
                break;
            }

            v1.add(v4[v3]);
        }

        v0.add(new DERSequence(v1));
        boolean v1_1 = this.inhibitPolicyMapping;
        if(v1_1) {
            v0.add(ASN1Boolean.getInstance(v1_1));
        }

        if(this.explicitPolicyReqd) {
            v0.add(new DERTaggedObject(false, 0, ASN1Boolean.getInstance(this.explicitPolicyReqd)));
        }

        if(this.inhibitAnyPolicy) {
            v0.add(new DERTaggedObject(false, 1, ASN1Boolean.getInstance(this.inhibitAnyPolicy)));
        }

        return new DERSequence(v0);
    }

    public String toString() {
        return "PathProcInput: {\nacceptablePolicySet: " + Arrays.asList(this.acceptablePolicySet) + "\ninhibitPolicyMapping: " + this.inhibitPolicyMapping + "\nexplicitPolicyReqd: " + this.explicitPolicyReqd + "\ninhibitAnyPolicy: " + this.inhibitAnyPolicy + "\n}\n";
    }
}

