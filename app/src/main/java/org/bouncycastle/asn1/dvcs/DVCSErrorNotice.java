package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.x509.GeneralName;

public class DVCSErrorNotice extends ASN1Object {
    private GeneralName transactionIdentifier;
    private PKIStatusInfo transactionStatus;

    private DVCSErrorNotice(ASN1Sequence arg3) {
        super();
        this.transactionStatus = PKIStatusInfo.getInstance(arg3.getObjectAt(0));
        if(arg3.size() > 1) {
            this.transactionIdentifier = GeneralName.getInstance(arg3.getObjectAt(1));
        }
    }

    public DVCSErrorNotice(PKIStatusInfo arg2) {
        this(arg2, null);
    }

    public DVCSErrorNotice(PKIStatusInfo arg1, GeneralName arg2) {
        super();
        this.transactionStatus = arg1;
        this.transactionIdentifier = arg2;
    }

    public static DVCSErrorNotice getInstance(Object arg1) {
        if((arg1 instanceof DVCSErrorNotice)) {
            return arg1;
        }

        if(arg1 != null) {
            return new DVCSErrorNotice(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static DVCSErrorNotice getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return DVCSErrorNotice.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public GeneralName getTransactionIdentifier() {
        return this.transactionIdentifier;
    }

    public PKIStatusInfo getTransactionStatus() {
        return this.transactionStatus;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.transactionStatus);
        GeneralName v2 = this.transactionIdentifier;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }

    public String toString() {
        String v1 = "\n";
        StringBuilder v0 = new StringBuilder("DVCSErrorNotice {\ntransactionStatus: ").append(this.transactionStatus).append(v1);
        String v4 = this.transactionIdentifier != null ? "transactionIdentifier: " + this.transactionIdentifier + v1 : "";
        return v0.append(v4).append("}\n").toString();
    }
}

