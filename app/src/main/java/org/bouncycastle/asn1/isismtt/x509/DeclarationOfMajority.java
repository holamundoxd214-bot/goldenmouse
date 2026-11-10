package org.bouncycastle.asn1.isismtt.x509;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class DeclarationOfMajority extends ASN1Object implements ASN1Choice {
    public static final int dateOfBirth = 2;
    private ASN1TaggedObject declaration;
    public static final int fullAgeAtCountry = 1;
    public static final int notYoungerThan;

    public DeclarationOfMajority(int arg5) {
        super();
        this.declaration = new DERTaggedObject(false, 0, new ASN1Integer(((long)arg5)));
    }

    public DeclarationOfMajority(ASN1GeneralizedTime arg4) {
        super();
        this.declaration = new DERTaggedObject(false, 2, ((ASN1Encodable)arg4));
    }

    private DeclarationOfMajority(ASN1TaggedObject arg3) {
        super();
        if(arg3.getTagNo() <= 2) {
            this.declaration = arg3;
            return;
        }

        throw new IllegalArgumentException("Bad tag number: " + arg3.getTagNo());
    }

    public DeclarationOfMajority(boolean arg6, String arg7) {
        super();
        if(arg7.length() <= 2) {
            DERTaggedObject v6 = arg6 ? new DERTaggedObject(false, 1, new DERSequence(new DERPrintableString(arg7, true))) : new DERTaggedObject(false, 1, new DERSequence(ASN1Boolean.FALSE, new DERPrintableString(arg7, true)));
            this.declaration = ((ASN1TaggedObject)v6);
            return;
        }

        throw new IllegalArgumentException("country can only be 2 characters");
    }

    public ASN1Sequence fullAgeAtCountry() {
        if(this.declaration.getTagNo() != 1) {
            return null;
        }

        return ASN1Sequence.getInstance(this.declaration, false);
    }

    public ASN1GeneralizedTime getDateOfBirth() {
        if(this.declaration.getTagNo() != 2) {
            return null;
        }

        return ASN1GeneralizedTime.getInstance(this.declaration, false);
    }

    public static DeclarationOfMajority getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof DeclarationOfMajority)) {
            }
            else if((arg3 instanceof ASN1TaggedObject)) {
                return new DeclarationOfMajority(ASN1TaggedObject.getInstance(arg3, 0x80));
            }
            else {
                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public int getType() {
        return this.declaration.getTagNo();
    }

    public int notYoungerThan() {
        if(this.declaration.getTagNo() != 0) {
            return -1;
        }

        return ASN1Integer.getInstance(this.declaration, false).intValueExact();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.declaration;
    }
}

