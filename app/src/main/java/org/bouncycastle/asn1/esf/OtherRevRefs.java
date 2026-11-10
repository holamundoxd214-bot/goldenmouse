package org.bouncycastle.asn1.esf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class OtherRevRefs extends ASN1Object {
    private ASN1ObjectIdentifier otherRevRefType;
    private ASN1Encodable otherRevRefs;

    public OtherRevRefs(ASN1ObjectIdentifier arg1, ASN1Encodable arg2) {
        super();
        this.otherRevRefType = arg1;
        this.otherRevRefs = arg2;
    }

    private OtherRevRefs(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.otherRevRefType = new ASN1ObjectIdentifier(arg3.getObjectAt(0).getId());
            try {
                this.otherRevRefs = ASN1Primitive.fromByteArray(arg3.getObjectAt(1).toASN1Primitive().getEncoded("DER"));
                return;
            }
            catch(IOException ) {
                throw new IllegalStateException();
            }
        }

        throw new IllegalArgumentException("Bad sequence size: " + arg3.size());
    }

    public static OtherRevRefs getInstance(Object arg1) {
        if((arg1 instanceof OtherRevRefs)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OtherRevRefs(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1ObjectIdentifier getOtherRevRefType() {
        return this.otherRevRefType;
    }

    public ASN1Encodable getOtherRevRefs() {
        return this.otherRevRefs;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.otherRevRefType, this.otherRevRefs);
    }
}

