package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.X509Extensions;

public class TBSRequest extends ASN1Object {
    private static final ASN1Integer V1;
    Extensions requestExtensions;
    ASN1Sequence requestList;
    GeneralName requestorName;
    ASN1Integer version;
    boolean versionSet;

    static {
        TBSRequest.V1 = new ASN1Integer(0);
    }

    private TBSRequest(ASN1Sequence arg5) {
        super();
        int v0 = 0;
        if(!(arg5.getObjectAt(0) instanceof ASN1TaggedObject) || arg5.getObjectAt(0).getTagNo() != 0) {
            this.version = TBSRequest.V1;
        }
        else {
            this.versionSet = true;
            this.version = ASN1Integer.getInstance(arg5.getObjectAt(0), true);
            v0 = 1;
        }

        if((arg5.getObjectAt(v0) instanceof ASN1TaggedObject)) {
            this.requestorName = GeneralName.getInstance(arg5.getObjectAt(v0), true);
            ++v0;
        }

        int v1 = v0 + 1;
        this.requestList = arg5.getObjectAt(v0);
        if(arg5.size() == v0 + 2) {
            this.requestExtensions = Extensions.getInstance(arg5.getObjectAt(v1), true);
        }
    }

    public TBSRequest(GeneralName arg2, ASN1Sequence arg3, Extensions arg4) {
        super();
        this.version = TBSRequest.V1;
        this.requestorName = arg2;
        this.requestList = arg3;
        this.requestExtensions = arg4;
    }

    public TBSRequest(GeneralName arg2, ASN1Sequence arg3, X509Extensions arg4) {
        super();
        this.version = TBSRequest.V1;
        this.requestorName = arg2;
        this.requestList = arg3;
        this.requestExtensions = Extensions.getInstance(arg4);
    }

    public static TBSRequest getInstance(Object arg1) {
        if((arg1 instanceof TBSRequest)) {
            return arg1;
        }

        if(arg1 != null) {
            return new TBSRequest(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static TBSRequest getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return TBSRequest.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public Extensions getRequestExtensions() {
        return this.requestExtensions;
    }

    public ASN1Sequence getRequestList() {
        return this.requestList;
    }

    public GeneralName getRequestorName() {
        return this.requestorName;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        if(!this.version.equals(TBSRequest.V1) || (this.versionSet)) {
            v0.add(new DERTaggedObject(true, 0, this.version));
        }

        if(this.requestorName != null) {
            v0.add(new DERTaggedObject(true, 1, this.requestorName));
        }

        v0.add(this.requestList);
        if(this.requestExtensions != null) {
            v0.add(new DERTaggedObject(true, 2, this.requestExtensions));
        }

        return new DERSequence(v0);
    }
}

