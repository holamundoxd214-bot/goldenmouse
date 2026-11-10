package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class PKIArchiveOptions extends ASN1Object implements ASN1Choice {
    public static final int archiveRemGenPrivKey = 2;
    public static final int encryptedPrivKey = 0;
    public static final int keyGenParameters = 1;
    private ASN1Encodable value;

    public PKIArchiveOptions(ASN1OctetString arg1) {
        super();
        this.value = ((ASN1Encodable)arg1);
    }

    private PKIArchiveOptions(ASN1TaggedObject arg4) {
        ASN1OctetString v4_1;
        super();
        int v0 = arg4.getTagNo();
        if(v0 == 0) {
            EncryptedKey v4_2 = EncryptedKey.getInstance(arg4.getExplicitBaseObject());
        }
        else if(v0 == 1) {
            v4_1 = ASN1OctetString.getInstance(arg4, false);
        }
        else if(v0 == 2) {
            ASN1Boolean v4 = ASN1Boolean.getInstance(arg4, false);
        }
        else {
            throw new IllegalArgumentException("unknown tag number: " + arg4.getTagNo());
        }

        this.value = ((ASN1Encodable)v4_1);
    }

    public PKIArchiveOptions(EncryptedKey arg1) {
        super();
        this.value = ((ASN1Encodable)arg1);
    }

    public PKIArchiveOptions(boolean arg1) {
        super();
        this.value = ASN1Boolean.getInstance(arg1);
    }

    public static PKIArchiveOptions getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof PKIArchiveOptions)) {
            }
            else if((arg3 instanceof ASN1TaggedObject)) {
                return new PKIArchiveOptions(ASN1TaggedObject.getInstance(arg3, 0x80));
            }
            else {
                throw new IllegalArgumentException("unknown object: " + arg3);
            }
        }

        return arg3;
    }

    public int getType() {
        ASN1Encodable v1 = this.value;
        if((v1 instanceof EncryptedKey)) {
            return 0;
        }

        if((v1 instanceof ASN1OctetString)) {
            return 1;
        }

        return 2;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1Encodable v0 = this.value;
        if((v0 instanceof EncryptedKey)) {
            return new DERTaggedObject(true, 0, this.value);
        }

        if((v0 instanceof ASN1OctetString)) {
            return new DERTaggedObject(false, 1, this.value);
        }

        return new DERTaggedObject(false, 2, this.value);
    }
}

