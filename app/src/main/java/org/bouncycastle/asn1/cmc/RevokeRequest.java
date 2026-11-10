package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.CRLReason;
import org.bouncycastle.util.Arrays;

public class RevokeRequest extends ASN1Object {
    private ASN1UTF8String comment;
    private ASN1GeneralizedTime invalidityDate;
    private final X500Name name;
    private ASN1OctetString passphrase;
    private final CRLReason reason;
    private final ASN1Integer serialNumber;

    private RevokeRequest(ASN1Sequence arg4) {
        super();
        int v1 = 3;
        if(arg4.size() >= v1 && arg4.size() <= 6) {
            this.name = X500Name.getInstance(arg4.getObjectAt(0));
            this.serialNumber = ASN1Integer.getInstance(arg4.getObjectAt(1));
            this.reason = CRLReason.getInstance(arg4.getObjectAt(2));
            if(arg4.size() > v1 && ((arg4.getObjectAt(v1).toASN1Primitive() instanceof ASN1GeneralizedTime))) {
                this.invalidityDate = ASN1GeneralizedTime.getInstance(arg4.getObjectAt(v1));
                v1 = 4;
            }

            if(arg4.size() > v1 && ((arg4.getObjectAt(v1).toASN1Primitive() instanceof ASN1OctetString))) {
                this.passphrase = ASN1OctetString.getInstance(arg4.getObjectAt(v1));
                ++v1;
            }

            if(arg4.size() > v1 && ((arg4.getObjectAt(v1).toASN1Primitive() instanceof ASN1UTF8String))) {
                this.comment = ASN1UTF8String.getInstance(arg4.getObjectAt(v1));
            }

            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public RevokeRequest(X500Name arg1, ASN1Integer arg2, CRLReason arg3, ASN1GeneralizedTime arg4, ASN1OctetString arg5, ASN1UTF8String arg6) {
        super();
        this.name = arg1;
        this.serialNumber = arg2;
        this.reason = arg3;
        this.invalidityDate = arg4;
        this.passphrase = arg5;
        this.comment = arg6;
    }

    public DERUTF8String getComment() {
        ASN1UTF8String v0 = this.comment;
        if(v0 != null) {
            if((v0 instanceof DERUTF8String)) {
            }
            else {
                return new DERUTF8String(this.comment.getString());
            }
        }

        return ((DERUTF8String)v0);
    }

    public ASN1UTF8String getCommentUTF8() {
        return this.comment;
    }

    public static RevokeRequest getInstance(Object arg1) {
        if((arg1 instanceof RevokeRequest)) {
            return arg1;
        }

        if(arg1 != null) {
            return new RevokeRequest(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1GeneralizedTime getInvalidityDate() {
        return this.invalidityDate;
    }

    public X500Name getName() {
        return this.name;
    }

    public byte[] getPassPhrase() {
        ASN1OctetString v0 = this.passphrase;
        if(v0 != null) {
            return Arrays.clone(v0.getOctets());
        }

        return null;
    }

    public ASN1OctetString getPassphrase() {
        return this.passphrase;
    }

    public CRLReason getReason() {
        return this.reason;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber.getValue();
    }

    public void setComment(ASN1UTF8String arg1) {
        this.comment = arg1;
    }

    public void setInvalidityDate(ASN1GeneralizedTime arg1) {
        this.invalidityDate = arg1;
    }

    public void setPassphrase(ASN1OctetString arg1) {
        this.passphrase = arg1;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(6);
        v0.add(this.name);
        v0.add(this.serialNumber);
        v0.add(this.reason);
        ASN1GeneralizedTime v1 = this.invalidityDate;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        ASN1OctetString v1_1 = this.passphrase;
        if(v1_1 != null) {
            v0.add(((ASN1Encodable)v1_1));
        }

        ASN1UTF8String v2 = this.comment;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

