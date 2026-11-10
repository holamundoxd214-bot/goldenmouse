package org.bouncycastle.asn1.isismtt.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x500.DirectoryString;

public class Restriction extends ASN1Object {
    private DirectoryString restriction;

    public Restriction(String arg2) {
        super();
        this.restriction = new DirectoryString(arg2);
    }

    private Restriction(DirectoryString arg1) {
        super();
        this.restriction = arg1;
    }

    public static Restriction getInstance(Object arg1) {
        if((arg1 instanceof Restriction)) {
            return arg1;
        }

        if(arg1 != null) {
            return new Restriction(DirectoryString.getInstance(arg1));
        }

        return null;
    }

    public DirectoryString getRestriction() {
        return this.restriction;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.restriction.toASN1Primitive();
    }
}

