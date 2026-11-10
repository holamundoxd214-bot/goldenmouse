package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class OtherHash extends ASN1Object implements ASN1Choice {
    private OtherHashAlgAndValue otherHash;
    private ASN1OctetString sha1Hash;

    private OtherHash(ASN1OctetString arg1) {
        super();
        this.sha1Hash = arg1;
    }

    public OtherHash(OtherHashAlgAndValue arg1) {
        super();
        this.otherHash = arg1;
    }

    public OtherHash(byte[] arg2) {
        super();
        this.sha1Hash = new DEROctetString(arg2);
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        OtherHashAlgAndValue v1 = this.otherHash;
        if(v1 == null) {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
        }

        return v1.getHashAlgorithm();
    }

    public byte[] getHashValue() {
        OtherHashAlgAndValue v0 = this.otherHash;
        ASN1OctetString v1 = v0 == null ? this.sha1Hash : v0.getHashValue();
        return v1.getOctets();
    }

    public static OtherHash getInstance(Object arg1) {
        if((arg1 instanceof OtherHash)) {
            return arg1;
        }

        if((arg1 instanceof ASN1OctetString)) {
            return new OtherHash(((ASN1OctetString)arg1));
        }

        return new OtherHash(OtherHashAlgAndValue.getInstance(arg1));
    }

    public ASN1Primitive toASN1Primitive() {
        OtherHashAlgAndValue v0 = this.otherHash;
        if(v0 == null) {
            return this.sha1Hash;
        }

        return v0.toASN1Primitive();
    }
}

