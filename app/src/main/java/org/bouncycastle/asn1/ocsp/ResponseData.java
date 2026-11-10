package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.X509Extensions;

public class ResponseData extends ASN1Object {
    private static final ASN1Integer V1;
    private ASN1GeneralizedTime producedAt;
    private ResponderID responderID;
    private Extensions responseExtensions;
    private ASN1Sequence responses;
    private ASN1Integer version;
    private boolean versionPresent;

    static {
        ResponseData.V1 = new ASN1Integer(0);
    }

    public ResponseData(ASN1Integer arg1, ResponderID arg2, ASN1GeneralizedTime arg3, ASN1Sequence arg4, Extensions arg5) {
        super();
        this.version = arg1;
        this.responderID = arg2;
        this.producedAt = arg3;
        this.responses = arg4;
        this.responseExtensions = arg5;
    }

    private ResponseData(ASN1Sequence arg5) {
        super();
        int v0 = 0;
        if(!(arg5.getObjectAt(0) instanceof ASN1TaggedObject) || arg5.getObjectAt(0).getTagNo() != 0) {
            this.version = ResponseData.V1;
        }
        else {
            this.versionPresent = true;
            this.version = ASN1Integer.getInstance(arg5.getObjectAt(0), true);
            v0 = 1;
        }

        this.responderID = ResponderID.getInstance(arg5.getObjectAt(v0));
        int v3 = v0 + 2;
        this.producedAt = ASN1GeneralizedTime.getInstance(arg5.getObjectAt(v0 + 1));
        v0 += 3;
        this.responses = arg5.getObjectAt(v3);
        if(arg5.size() > v0) {
            this.responseExtensions = Extensions.getInstance(arg5.getObjectAt(v0), true);
        }
    }

    public ResponseData(ResponderID arg7, ASN1GeneralizedTime arg8, ASN1Sequence arg9, Extensions arg10) {
        this(ResponseData.V1, arg7, arg8, arg9, arg10);
    }

    public ResponseData(ResponderID arg7, ASN1GeneralizedTime arg8, ASN1Sequence arg9, X509Extensions arg10) {
        this(ResponseData.V1, arg7, ASN1GeneralizedTime.getInstance(arg8), arg9, Extensions.getInstance(arg10));
    }

    public static ResponseData getInstance(Object arg1) {
        if((arg1 instanceof ResponseData)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ResponseData(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static ResponseData getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return ResponseData.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1GeneralizedTime getProducedAt() {
        return this.producedAt;
    }

    public ResponderID getResponderID() {
        return this.responderID;
    }

    public Extensions getResponseExtensions() {
        return this.responseExtensions;
    }

    public ASN1Sequence getResponses() {
        return this.responses;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(5);
        if((this.versionPresent) || !this.version.equals(ResponseData.V1)) {
            v0.add(new DERTaggedObject(true, 0, this.version));
        }

        v0.add(this.responderID);
        v0.add(this.producedAt);
        v0.add(this.responses);
        if(this.responseExtensions != null) {
            v0.add(new DERTaggedObject(true, 1, this.responseExtensions));
        }

        return new DERSequence(v0);
    }
}

