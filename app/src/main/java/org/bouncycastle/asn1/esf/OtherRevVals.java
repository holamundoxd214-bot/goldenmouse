package org.bouncycastle.asn1.esf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class OtherRevVals extends ASN1Object {
    private ASN1ObjectIdentifier otherRevValType;
    private ASN1Encodable otherRevVals;

    public OtherRevVals(ASN1ObjectIdentifier arg1, ASN1Encodable arg2) {
        super();
        this.otherRevValType = arg1;
        this.otherRevVals = arg2;
    }

    private OtherRevVals(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.otherRevValType = arg3.getObjectAt(0);
            try {
                this.otherRevVals = ASN1Primitive.fromByteArray(arg3.getObjectAt(1).toASN1Primitive().getEncoded("DER"));
                return;
            }
            catch(IOException ) {
                throw new IllegalStateException();
            }
        }

        throw new IllegalArgumentException("Bad sequence size: " + arg3.size());
    }

    public static OtherRevVals getInstance(Object arg1) {
        if((arg1 instanceof OtherRevVals)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OtherRevVals(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1ObjectIdentifier getOtherRevValType() {
        return this.otherRevValType;
    }

    public ASN1Encodable getOtherRevVals() {
        return this.otherRevVals;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.otherRevValType, this.otherRevVals);
    }
}

