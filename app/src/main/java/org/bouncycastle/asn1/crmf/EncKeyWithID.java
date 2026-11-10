package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.GeneralName;

public class EncKeyWithID extends ASN1Object {
    private final ASN1Encodable identifier;
    private final PrivateKeyInfo privKeyInfo;

    private EncKeyWithID(ASN1Sequence arg3) {
        GeneralName v3_1;
        ASN1Encodable v3;
        super();
        this.privKeyInfo = PrivateKeyInfo.getInstance(arg3.getObjectAt(0));
        if(arg3.size() > 1) {
            boolean v0 = arg3.getObjectAt(1) instanceof ASN1UTF8String;
            v3 = arg3.getObjectAt(1);
            if(!v0) {
                v3_1 = GeneralName.getInstance(v3);
            }
            else {
                this.identifier = v3;
                return;
            }
        }
        else {
            v3 = null;
        }

        this.identifier = ((ASN1Encodable)v3_1);
    }

    public EncKeyWithID(PrivateKeyInfo arg1) {
        super();
        this.privKeyInfo = arg1;
        this.identifier = null;
    }

    public EncKeyWithID(PrivateKeyInfo arg1, ASN1UTF8String arg2) {
        super();
        this.privKeyInfo = arg1;
        this.identifier = ((ASN1Encodable)arg2);
    }

    public EncKeyWithID(PrivateKeyInfo arg1, GeneralName arg2) {
        super();
        this.privKeyInfo = arg1;
        this.identifier = ((ASN1Encodable)arg2);
    }

    public ASN1Encodable getIdentifier() {
        return this.identifier;
    }

    public static EncKeyWithID getInstance(Object arg1) {
        if((arg1 instanceof EncKeyWithID)) {
            return arg1;
        }

        if(arg1 != null) {
            return new EncKeyWithID(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public PrivateKeyInfo getPrivateKey() {
        return this.privKeyInfo;
    }

    public boolean hasIdentifier() {
        if(this.identifier != null) {
            return 1;
        }

        return 0;
    }

    public boolean isIdentifierUTF8String() {
        return this.identifier instanceof ASN1UTF8String;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.privKeyInfo);
        ASN1Encodable v2 = this.identifier;
        if(v2 != null) {
            v0.add(v2);
        }

        return new DERSequence(v0);
    }
}

