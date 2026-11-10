package org.bouncycastle.asn1.dvcs;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class DVCSResponse extends ASN1Object implements ASN1Choice {
    private DVCSCertInfo dvCertInfo;
    private DVCSErrorNotice dvErrorNote;

    public DVCSResponse(DVCSCertInfo arg1) {
        super();
        this.dvCertInfo = arg1;
    }

    public DVCSResponse(DVCSErrorNotice arg1) {
        super();
        this.dvErrorNote = arg1;
    }

    public DVCSCertInfo getCertInfo() {
        return this.dvCertInfo;
    }

    public DVCSErrorNotice getErrorNotice() {
        return this.dvErrorNote;
    }

    public static DVCSResponse getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof DVCSResponse)) {
            }
            else if((arg3 instanceof byte[])) {
                try {
                    return DVCSResponse.getInstance(ASN1Primitive.fromByteArray(((byte[])arg3)));
                }
                catch(IOException v3) {
                    throw new IllegalArgumentException("failed to construct sequence from byte[]: " + v3.getMessage());
                }
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new DVCSResponse(DVCSCertInfo.getInstance(arg3));
            }
            else if((arg3 instanceof ASN1TaggedObject)) {
                return new DVCSResponse(DVCSErrorNotice.getInstance(ASN1TaggedObject.getInstance(arg3), false));
            }
            else {
                throw new IllegalArgumentException("Couldn\'t convert from object to DVCSResponse: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static DVCSResponse getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return DVCSResponse.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Primitive toASN1Primitive() {
        DVCSCertInfo v0 = this.dvCertInfo;
        if(v0 != null) {
            return v0.toASN1Primitive();
        }

        return new DERTaggedObject(false, 0, this.dvErrorNote);
    }

    public String toString() {
        String v3;
        StringBuilder v0;
        String v1 = "}\n";
        if(this.dvCertInfo != null) {
            v0 = new StringBuilder("DVCSResponse {\ndvCertInfo: ");
            v3 = this.dvCertInfo.toString();
        }
        else {
            v0 = new StringBuilder("DVCSResponse {\ndvErrorNote: ");
            v3 = this.dvErrorNote.toString();
        }

        return v0.append(v3).append(v1).toString();
    }
}

