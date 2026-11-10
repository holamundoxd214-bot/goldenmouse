package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class ContentHints extends ASN1Object {
    private ASN1UTF8String contentDescription;
    private ASN1ObjectIdentifier contentType;

    public ContentHints(ASN1ObjectIdentifier arg1) {
        super();
        this.contentType = arg1;
        this.contentDescription = null;
    }

    public ContentHints(ASN1ObjectIdentifier arg1, ASN1UTF8String arg2) {
        super();
        this.contentType = arg1;
        this.contentDescription = arg2;
    }

    private ContentHints(ASN1Sequence arg4) {
        super();
        int v0 = 0;
        ASN1Encodable v1 = arg4.getObjectAt(0);
        if((v1.toASN1Primitive() instanceof ASN1UTF8String)) {
            this.contentDescription = ASN1UTF8String.getInstance(v1);
            v0 = 1;
        }

        this.contentType = ASN1ObjectIdentifier.getInstance(arg4.getObjectAt(v0));
    }

    public DERUTF8String getContentDescription() {
        ASN1UTF8String v0 = this.contentDescription;
        if(v0 != null) {
            if((v0 instanceof DERUTF8String)) {
            }
            else {
                return new DERUTF8String(this.contentDescription.getString());
            }
        }

        return ((DERUTF8String)v0);
    }

    public ASN1UTF8String getContentDescriptionUTF8() {
        return this.contentDescription;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    public static ContentHints getInstance(Object arg1) {
        if((arg1 instanceof ContentHints)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ContentHints(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        ASN1UTF8String v1 = this.contentDescription;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        v0.add(this.contentType);
        return new DERSequence(v0);
    }
}

