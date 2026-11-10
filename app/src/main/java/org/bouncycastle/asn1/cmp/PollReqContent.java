package org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PollReqContent extends ASN1Object {
    private final ASN1Sequence content;

    public PollReqContent(BigInteger arg2) {
        this(new ASN1Integer(arg2));
    }

    public PollReqContent(ASN1Integer arg3) {
        this(new DERSequence(new DERSequence(((ASN1Encodable)arg3))));
    }

    private PollReqContent(ASN1Sequence arg1) {
        super();
        this.content = arg1;
    }

    public PollReqContent(BigInteger[] arg1) {
        this(PollReqContent.intsToASN1(arg1));
    }

    public PollReqContent(ASN1Integer[] arg2) {
        this(new DERSequence(PollReqContent.intsToSequence(arg2)));
    }

    public BigInteger[] getCertReqIdValues() {
        int v0 = this.content.size();
        BigInteger[] v1 = new BigInteger[v0];
        int v3;
        for(v3 = 0; v3 != v0; ++v3) {
            v1[v3] = ASN1Integer.getInstance(ASN1Sequence.getInstance(this.content.getObjectAt(v3)).getObjectAt(0)).getValue();
        }

        return v1;
    }

    public ASN1Integer[][] getCertReqIds() {
        int v0 = this.content.size();
        ASN1Integer[][] v1 = new ASN1Integer[v0][];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = PollReqContent.sequenceToASN1IntegerArray(this.content.getObjectAt(v2));
        }

        return v1;
    }

    public static PollReqContent getInstance(Object arg1) {
        if((arg1 instanceof PollReqContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PollReqContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    private static ASN1Integer[] intsToASN1(BigInteger[] arg5) {
        int v0 = arg5.length;
        ASN1Integer[] v1 = new ASN1Integer[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = new ASN1Integer(arg5[v2]);
        }

        return v1;
    }

    private static DERSequence[] intsToSequence(ASN1Integer[] arg5) {
        int v0 = arg5.length;
        DERSequence[] v1 = new DERSequence[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = new DERSequence(arg5[v2]);
        }

        return v1;
    }

    private static ASN1Integer[] sequenceToASN1IntegerArray(ASN1Sequence arg4) {
        int v0 = arg4.size();
        ASN1Integer[] v1 = new ASN1Integer[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = ASN1Integer.getInstance(arg4.getObjectAt(v2));
        }

        return v1;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }
}

