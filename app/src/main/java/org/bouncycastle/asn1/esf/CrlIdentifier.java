package org.bouncycastle.asn1.esf;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;

public class CrlIdentifier extends ASN1Object {
    private ASN1UTCTime crlIssuedTime;
    private X500Name crlIssuer;
    private ASN1Integer crlNumber;

    private CrlIdentifier(ASN1Sequence arg4) {
        super();
        int v1 = 2;
        if(arg4.size() >= v1 && arg4.size() <= 3) {
            this.crlIssuer = X500Name.getInstance(arg4.getObjectAt(0));
            this.crlIssuedTime = ASN1UTCTime.getInstance(arg4.getObjectAt(1));
            if(arg4.size() > v1) {
                this.crlNumber = ASN1Integer.getInstance(arg4.getObjectAt(v1));
            }

            return;
        }

        throw new IllegalArgumentException();
    }

    public CrlIdentifier(X500Name arg2, ASN1UTCTime arg3) {
        this(arg2, arg3, null);
    }

    public CrlIdentifier(X500Name arg1, ASN1UTCTime arg2, BigInteger arg3) {
        super();
        this.crlIssuer = arg1;
        this.crlIssuedTime = arg2;
        if(arg3 != null) {
            this.crlNumber = new ASN1Integer(arg3);
        }
    }

    public ASN1UTCTime getCrlIssuedTime() {
        return this.crlIssuedTime;
    }

    public X500Name getCrlIssuer() {
        return this.crlIssuer;
    }

    public BigInteger getCrlNumber() {
        ASN1Integer v0 = this.crlNumber;
        if(v0 == null) {
            return null;
        }

        return v0.getValue();
    }

    public static CrlIdentifier getInstance(Object arg1) {
        if((arg1 instanceof CrlIdentifier)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CrlIdentifier(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.crlIssuer.toASN1Primitive());
        v0.add(this.crlIssuedTime);
        ASN1Integer v2 = this.crlNumber;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

