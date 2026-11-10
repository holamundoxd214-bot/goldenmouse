package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class RecipientEncryptedKey extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private KeyAgreeRecipientIdentifier identifier;

    private RecipientEncryptedKey(ASN1Sequence arg2) {
        super();
        this.identifier = KeyAgreeRecipientIdentifier.getInstance(arg2.getObjectAt(0));
        this.encryptedKey = arg2.getObjectAt(1);
    }

    public RecipientEncryptedKey(KeyAgreeRecipientIdentifier arg1, ASN1OctetString arg2) {
        super();
        this.identifier = arg1;
        this.encryptedKey = arg2;
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public KeyAgreeRecipientIdentifier getIdentifier() {
        return this.identifier;
    }

    public static RecipientEncryptedKey getInstance(Object arg1) {
        if((arg1 instanceof RecipientEncryptedKey)) {
            return arg1;
        }

        if(arg1 != null) {
            return new RecipientEncryptedKey(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static RecipientEncryptedKey getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return RecipientEncryptedKey.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.identifier, this.encryptedKey);
    }
}

