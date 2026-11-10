package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class OOBCertHash extends ASN1Object {
    private final CertId certId;
    private final AlgorithmIdentifier hashAlg;
    private final ASN1BitString hashVal;

    private OOBCertHash(ASN1Sequence arg7) {
        ASN1Encodable v3;
        super();
        int v0 = arg7.size();
        int v1 = v0 - 1;
        v0 += -2;
        this.hashVal = ASN1BitString.getInstance(arg7.getObjectAt(v1));
        AlgorithmIdentifier v1_1 = null;
        CertId v2 = ((CertId)v1_1);
        while(true) {
            if(v0 < 0) {
                goto label_31;
            }

            v3 = arg7.getObjectAt(v0);
            if(((ASN1TaggedObject)v3).hasContextTag(0)) {
                v1_1 = AlgorithmIdentifier.getInstance(((ASN1TaggedObject)v3), true);
            }
            else if(((ASN1TaggedObject)v3).hasContextTag(1)) {
                v2 = CertId.getInstance(((ASN1TaggedObject)v3), true);
            }
            else {
                break;
            }

            --v0;
        }

        throw new IllegalArgumentException("unknown tag " + ASN1Util.getTagText(((ASN1TaggedObject)v3)));
    label_31:
        this.hashAlg = v1_1;
        this.certId = v2;
    }

    public OOBCertHash(AlgorithmIdentifier arg1, CertId arg2, DERBitString arg3) {
        super();
        this.hashAlg = arg1;
        this.certId = arg2;
        this.hashVal = ((ASN1BitString)arg3);
    }

    public OOBCertHash(AlgorithmIdentifier arg2, CertId arg3, byte[] arg4) {
        this(arg2, arg3, new DERBitString(arg4));
    }

    private void addOptional(ASN1EncodableVector arg2, int arg3, ASN1Encodable arg4) {
        if(arg4 != null) {
            arg2.add(new DERTaggedObject(true, arg3, arg4));
        }
    }

    public CertId getCertId() {
        return this.certId;
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.hashAlg;
    }

    public ASN1BitString getHashVal() {
        return this.hashVal;
    }

    public static OOBCertHash getInstance(Object arg1) {
        if((arg1 instanceof OOBCertHash)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OOBCertHash(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        this.addOptional(v0, 0, this.hashAlg);
        this.addOptional(v0, 1, this.certId);
        v0.add(this.hashVal);
        return new DERSequence(v0);
    }
}

