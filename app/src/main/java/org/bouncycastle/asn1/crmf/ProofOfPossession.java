package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERTaggedObject;

public class ProofOfPossession extends ASN1Object implements ASN1Choice {
    public static final int TYPE_KEY_AGREEMENT = 3;
    public static final int TYPE_KEY_ENCIPHERMENT = 2;
    public static final int TYPE_RA_VERIFIED = 0;
    public static final int TYPE_SIGNING_KEY = 1;
    private ASN1Encodable obj;
    private int tagNo;

    public ProofOfPossession() {
        super();
        this.tagNo = 0;
        this.obj = DERNull.INSTANCE;
    }

    public ProofOfPossession(int arg1, POPOPrivKey arg2) {
        super();
        this.tagNo = arg1;
        this.obj = ((ASN1Encodable)arg2);
    }

    private ProofOfPossession(ASN1TaggedObject arg4) {
        POPOSigningKey v4_1;
        super();
        int v0 = arg4.getTagNo();
        this.tagNo = v0;
        if(v0 == 0) {
            DERNull v4_2 = DERNull.INSTANCE;
        }
        else if(v0 != 1) {
            if(v0 != 2) {
                if(v0 == 3) {
                }
                else {
                    throw new IllegalArgumentException("unknown tag: " + this.tagNo);
                }
            }

            POPOPrivKey v4 = POPOPrivKey.getInstance(arg4, true);
        }
        else {
            v4_1 = POPOSigningKey.getInstance(arg4, false);
        }

        this.obj = ((ASN1Encodable)v4_1);
    }

    public ProofOfPossession(POPOSigningKey arg2) {
        super();
        this.tagNo = 1;
        this.obj = ((ASN1Encodable)arg2);
    }

    public static ProofOfPossession getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ProofOfPossession)) {
            }
            else if((arg3 instanceof ASN1TaggedObject)) {
                return new ProofOfPossession(((ASN1TaggedObject)arg3));
            }
            else {
                throw new IllegalArgumentException("Invalid object: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public ASN1Encodable getObject() {
        return this.obj;
    }

    public int getType() {
        return this.tagNo;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, this.obj);
    }
}

