package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

public class SinglePubInfo extends ASN1Object {
    public static final ASN1Integer dontCare;
    public static final ASN1Integer ldap;
    private GeneralName pubLocation;
    private ASN1Integer pubMethod;
    public static final ASN1Integer web;
    public static final ASN1Integer x500;

    static {
        SinglePubInfo.dontCare = new ASN1Integer(0);
        SinglePubInfo.x500 = new ASN1Integer(1);
        SinglePubInfo.web = new ASN1Integer(2);
        SinglePubInfo.ldap = new ASN1Integer(3);
    }

    public SinglePubInfo(ASN1Integer arg1, GeneralName arg2) {
        super();
        this.pubMethod = arg1;
        this.pubLocation = arg2;
    }

    private SinglePubInfo(ASN1Sequence arg3) {
        super();
        this.pubMethod = ASN1Integer.getInstance(arg3.getObjectAt(0));
        if(arg3.size() == 2) {
            this.pubLocation = GeneralName.getInstance(arg3.getObjectAt(1));
        }
    }

    public static SinglePubInfo getInstance(Object arg1) {
        if((arg1 instanceof SinglePubInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new SinglePubInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public GeneralName getPubLocation() {
        return this.pubLocation;
    }

    public ASN1Integer getPubMethod() {
        return this.pubMethod;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.pubMethod);
        GeneralName v2 = this.pubLocation;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

