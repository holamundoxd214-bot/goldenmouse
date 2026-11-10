package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.GeneralNames;

public class CRLSource extends ASN1Object implements ASN1Choice {
    private final DistributionPointName dpn;
    private final GeneralNames issuer;

    private CRLSource(ASN1TaggedObject arg4) {
        super();
        GeneralNames v1 = null;
        if(arg4.hasContextTag(0)) {
            this.dpn = DistributionPointName.getInstance(arg4, true);
            this.issuer = v1;
            return;
        }

        if(arg4.hasContextTag(1)) {
            this.dpn = ((DistributionPointName)v1);
            this.issuer = GeneralNames.getInstance(arg4, true);
            return;
        }

        throw new IllegalArgumentException("unknown tag " + ASN1Util.getTagText(arg4));
    }

    public CRLSource(DistributionPointName arg4, GeneralNames arg5) {
        super();
        int v0 = 1;
        int v2 = arg4 == null ? 1 : 0;
        if(arg5 == null) {
        }
        else {
            v0 = 0;
        }

        if(v2 != v0) {
            this.dpn = arg4;
            this.issuer = arg5;
            return;
        }

        throw new IllegalArgumentException("either dpn or issuer must be set");
    }

    public DistributionPointName getDpn() {
        return this.dpn;
    }

    public static CRLSource getInstance(Object arg1) {
        if((arg1 instanceof CRLSource)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CRLSource(ASN1TaggedObject.getInstance(arg1));
        }

        return null;
    }

    public GeneralNames getIssuer() {
        return this.issuer;
    }

    public ASN1Primitive toASN1Primitive() {
        if(this.dpn != null) {
            return new DERTaggedObject(true, 0, this.dpn);
        }

        return new DERTaggedObject(true, 1, this.issuer);
    }
}

