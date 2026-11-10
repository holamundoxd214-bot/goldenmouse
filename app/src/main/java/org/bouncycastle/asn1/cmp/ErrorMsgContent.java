package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ErrorMsgContent extends ASN1Object {
    private ASN1Integer errorCode;
    private PKIFreeText errorDetails;
    private final PKIStatusInfo pkiStatusInfo;

    private ErrorMsgContent(ASN1Sequence arg3) {
        super();
        Enumeration v3 = arg3.getObjects();
        this.pkiStatusInfo = PKIStatusInfo.getInstance(v3.nextElement());
        while(v3.hasMoreElements()) {
            Object v0 = v3.nextElement();
            if((v0 instanceof ASN1Integer)) {
                this.errorCode = ASN1Integer.getInstance(v0);
                continue;
            }

            this.errorDetails = PKIFreeText.getInstance(v0);
        }
    }

    public ErrorMsgContent(PKIStatusInfo arg2) {
        this(arg2, null, null);
    }

    public ErrorMsgContent(PKIStatusInfo arg1, ASN1Integer arg2, PKIFreeText arg3) {
        super();
        if(arg1 != null) {
            this.pkiStatusInfo = arg1;
            this.errorCode = arg2;
            this.errorDetails = arg3;
            return;
        }

        throw new IllegalArgumentException("\'pkiStatusInfo\' cannot be null");
    }

    private void addOptional(ASN1EncodableVector arg1, ASN1Encodable arg2) {
        if(arg2 != null) {
            arg1.add(arg2);
        }
    }

    public ASN1Integer getErrorCode() {
        return this.errorCode;
    }

    public PKIFreeText getErrorDetails() {
        return this.errorDetails;
    }

    public static ErrorMsgContent getInstance(Object arg1) {
        if((arg1 instanceof ErrorMsgContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ErrorMsgContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public PKIStatusInfo getPKIStatusInfo() {
        return this.pkiStatusInfo;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.pkiStatusInfo);
        this.addOptional(v0, this.errorCode);
        this.addOptional(v0, this.errorDetails);
        return new DERSequence(v0);
    }
}

