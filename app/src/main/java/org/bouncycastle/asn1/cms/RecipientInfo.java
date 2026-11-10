package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class RecipientInfo extends ASN1Object implements ASN1Choice {
    ASN1Encodable info;

    public RecipientInfo(ASN1Primitive arg1) {
        super();
        this.info = ((ASN1Encodable)arg1);
    }

    public RecipientInfo(KEKRecipientInfo arg4) {
        super();
        this.info = new DERTaggedObject(false, 2, ((ASN1Encodable)arg4));
    }

    public RecipientInfo(KeyAgreeRecipientInfo arg4) {
        super();
        this.info = new DERTaggedObject(false, 1, ((ASN1Encodable)arg4));
    }

    public RecipientInfo(KeyTransRecipientInfo arg1) {
        super();
        this.info = ((ASN1Encodable)arg1);
    }

    public RecipientInfo(OtherRecipientInfo arg4) {
        super();
        this.info = new DERTaggedObject(false, 4, ((ASN1Encodable)arg4));
    }

    public RecipientInfo(PasswordRecipientInfo arg4) {
        super();
        this.info = new DERTaggedObject(false, 3, ((ASN1Encodable)arg4));
    }

    public ASN1Encodable getInfo() {
        ASN1Encodable v0 = this.info;
        if(!(v0 instanceof ASN1TaggedObject)) {
            return KeyTransRecipientInfo.getInstance(v0);
        }

        if(((ASN1TaggedObject)v0).hasContextTag()) {
            int v1 = ((ASN1TaggedObject)v0).getTagNo();
            if(v1 == 1) {
                return KeyAgreeRecipientInfo.getInstance(((ASN1TaggedObject)v0), false);
            }
            else if(v1 == 2) {
                return this.getKEKInfo(((ASN1TaggedObject)v0));
            }
            else if(v1 == 3) {
                return PasswordRecipientInfo.getInstance(((ASN1TaggedObject)v0), false);
            }
            else if(v1 == 4) {
                return OtherRecipientInfo.getInstance(((ASN1TaggedObject)v0), false);
            }
        }

        throw new IllegalStateException("unknown tag");
    }

    public static RecipientInfo getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof RecipientInfo)) {
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new RecipientInfo(((ASN1Primitive)arg3));
            }
            else if((arg3 instanceof ASN1TaggedObject)) {
                return new RecipientInfo(((ASN1Primitive)arg3));
            }
            else {
                throw new IllegalArgumentException("unknown object in factory: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    private KEKRecipientInfo getKEKInfo(ASN1TaggedObject arg1) {
        return KEKRecipientInfo.getInstance(arg1, arg1.isExplicit());
    }

    public ASN1Integer getVersion() {
        ASN1Encodable v0 = this.info;
        if(!(v0 instanceof ASN1TaggedObject)) {
            return KeyTransRecipientInfo.getInstance(v0).getVersion();
        }

        if(((ASN1TaggedObject)v0).hasContextTag()) {
            int v1 = ((ASN1TaggedObject)v0).getTagNo();
            if(v1 == 1) {
                return KeyAgreeRecipientInfo.getInstance(((ASN1TaggedObject)v0), false).getVersion();
            }
            else if(v1 == 2) {
                return this.getKEKInfo(((ASN1TaggedObject)v0)).getVersion();
            }
            else if(v1 == 3) {
                return PasswordRecipientInfo.getInstance(((ASN1TaggedObject)v0), false).getVersion();
            }
            else if(v1 == 4) {
                return new ASN1Integer(0);
            }
        }

        throw new IllegalStateException("unknown tag");
    }

    boolean isKeyTransV0() {
        ASN1Encodable v2 = this.info;
        if((v2 instanceof ASN1TaggedObject)) {
            return 0;
        }

        return KeyTransRecipientInfo.getInstance(v2).getVersion().hasValue(0);
    }

    boolean isPasswordOrOther() {
        ASN1Encodable v1 = this.info;
        if(((v1 instanceof ASN1TaggedObject)) && (((ASN1TaggedObject)v1).hasContextTag())) {
            int v1_1 = ((ASN1TaggedObject)v1).getTagNo();
            if(v1_1 != 3 && v1_1 != 4) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public boolean isTagged() {
        return this.info instanceof ASN1TaggedObject;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.info.toASN1Primitive();
    }
}

