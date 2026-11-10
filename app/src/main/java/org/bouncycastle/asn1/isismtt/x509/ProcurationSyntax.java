package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1PrintableString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.DirectoryString;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.IssuerSerial;

public class ProcurationSyntax extends ASN1Object {
    private IssuerSerial certRef;
    private String country;
    private GeneralName thirdPerson;
    private DirectoryString typeOfSubstitution;

    public ProcurationSyntax(String arg1, DirectoryString arg2, GeneralName arg3) {
        super();
        this.country = arg1;
        this.typeOfSubstitution = arg2;
        this.thirdPerson = arg3;
        this.certRef = null;
    }

    public ProcurationSyntax(String arg1, DirectoryString arg2, IssuerSerial arg3) {
        super();
        this.country = arg1;
        this.typeOfSubstitution = arg2;
        this.thirdPerson = null;
        this.certRef = arg3;
    }

    private ProcurationSyntax(ASN1Sequence arg6) {
        super();
        if(arg6.size() >= 1) {
            int v2 = 3;
            if(arg6.size() <= v2) {
                Enumeration v6 = arg6.getObjects();
                while(true) {
                    if(v6.hasMoreElements()) {
                        ASN1TaggedObject v0 = ASN1TaggedObject.getInstance(v6.nextElement(), 0x80);
                        int v3 = v0.getTagNo();
                        if(v3 == 1) {
                            this.country = ASN1PrintableString.getInstance(v0, true).getString();
                            continue;
                        }
                        else if(v3 == 2) {
                            this.typeOfSubstitution = DirectoryString.getInstance(v0, true);
                            continue;
                        }
                        else if(v3 == v2) {
                            ASN1Object v0_1 = v0.getExplicitBaseObject();
                            if((v0_1 instanceof ASN1TaggedObject)) {
                                this.thirdPerson = GeneralName.getInstance(v0_1);
                            }
                            else {
                                this.certRef = IssuerSerial.getInstance(v0_1);
                            }

                            continue;
                        }
                        else {
                            throw new IllegalArgumentException("Bad tag number: " + v0.getTagNo());
                        }
                    }
                    else {
                        return;
                    }

                    goto label_44;
                }

                return;
            }
        }

    label_44:
        throw new IllegalArgumentException("Bad sequence size: " + arg6.size());
    }

    public IssuerSerial getCertRef() {
        return this.certRef;
    }

    public String getCountry() {
        return this.country;
    }

    public static ProcurationSyntax getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ProcurationSyntax)) {
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new ProcurationSyntax(((ASN1Sequence)arg3));
            }
            else {
                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public GeneralName getThirdPerson() {
        return this.thirdPerson;
    }

    public DirectoryString getTypeOfSubstitution() {
        return this.typeOfSubstitution;
    }

    public ASN1Primitive toASN1Primitive() {
        int v1 = 3;
        ASN1EncodableVector v0 = new ASN1EncodableVector(v1);
        if(this.country != null) {
            v0.add(new DERTaggedObject(true, 1, new DERPrintableString(this.country, true)));
        }

        if(this.typeOfSubstitution != null) {
            v0.add(new DERTaggedObject(true, 2, this.typeOfSubstitution));
        }

        DERTaggedObject v2 = this.thirdPerson != null ? new DERTaggedObject(true, v1, this.thirdPerson) : new DERTaggedObject(true, v1, this.certRef);
        v0.add(((ASN1Encodable)v2));
        return new DERSequence(v0);
    }
}

