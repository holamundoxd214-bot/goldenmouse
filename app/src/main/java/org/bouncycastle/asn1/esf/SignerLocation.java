package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.DirectoryString;

public class SignerLocation extends ASN1Object {
    private DirectoryString countryName;
    private DirectoryString localityName;
    private ASN1Sequence postalAddress;

    private SignerLocation(ASN1Sequence arg5) {
        super();
        Enumeration v5 = arg5.getObjects();
        while(v5.hasMoreElements()) {
            ASN1TaggedObject v0 = ASN1TaggedObject.getInstance(v5.nextElement(), 0x80);
            int v1 = v0.getTagNo();
            if(v1 != 0) {
                if(v1 != 1) {
                    if(v1 == 2) {
                        ASN1Sequence v0_1 = v0.isExplicit() ? ASN1Sequence.getInstance(v0, true) : ASN1Sequence.getInstance(v0, false);
                        this.postalAddress = v0_1;
                        if(v0_1 == null) {
                            continue;
                        }

                        if(v0_1.size() <= 6) {
                            continue;
                        }

                        throw new IllegalArgumentException("postal address must contain less than 6 strings");
                    }

                    throw new IllegalArgumentException("illegal tag");
                }

                this.localityName = DirectoryString.getInstance(v0, true);
                continue;
            }

            this.countryName = DirectoryString.getInstance(v0, true);
        }
    }

    public SignerLocation(ASN1UTF8String arg1, ASN1UTF8String arg2, ASN1Sequence arg3) {
        this(DirectoryString.getInstance(arg1), DirectoryString.getInstance(arg2), arg3);
    }

    private SignerLocation(DirectoryString arg3, DirectoryString arg4, ASN1Sequence arg5) {
        super();
        if(arg5 != null) {
            if(arg5.size() <= 6) {
            }
            else {
                throw new IllegalArgumentException("postal address must contain less than 6 strings");
            }
        }

        this.countryName = arg3;
        this.localityName = arg4;
        this.postalAddress = arg5;
    }

    public SignerLocation(DirectoryString arg2, DirectoryString arg3, DirectoryString[] arg4) {
        this(arg2, arg3, new DERSequence(((ASN1Encodable[])arg4)));
    }

    public DirectoryString getCountry() {
        return this.countryName;
    }

    public DERUTF8String getCountryName() {
        if(this.countryName == null) {
            return null;
        }

        return new DERUTF8String(this.getCountry().getString());
    }

    public static SignerLocation getInstance(Object arg1) {
        if(arg1 != null) {
            if((arg1 instanceof SignerLocation)) {
            }
            else {
                return new SignerLocation(ASN1Sequence.getInstance(arg1));
            }
        }

        return arg1;
    }

    public DirectoryString getLocality() {
        return this.localityName;
    }

    public DERUTF8String getLocalityName() {
        if(this.localityName == null) {
            return null;
        }

        return new DERUTF8String(this.getLocality().getString());
    }

    public DirectoryString[] getPostal() {
        ASN1Sequence v0 = this.postalAddress;
        if(v0 == null) {
            return null;
        }

        int v0_1 = v0.size();
        DirectoryString[] v1 = new DirectoryString[v0_1];
        int v2;
        for(v2 = 0; v2 != v0_1; ++v2) {
            v1[v2] = DirectoryString.getInstance(this.postalAddress.getObjectAt(v2));
        }

        return v1;
    }

    public ASN1Sequence getPostalAddress() {
        return this.postalAddress;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        if(this.countryName != null) {
            v0.add(new DERTaggedObject(true, 0, this.countryName));
        }

        if(this.localityName != null) {
            v0.add(new DERTaggedObject(true, 1, this.localityName));
        }

        if(this.postalAddress != null) {
            v0.add(new DERTaggedObject(true, 2, this.postalAddress));
        }

        return new DERSequence(v0);
    }
}

