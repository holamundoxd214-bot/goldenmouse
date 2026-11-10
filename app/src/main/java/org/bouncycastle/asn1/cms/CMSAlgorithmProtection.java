package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CMSAlgorithmProtection extends ASN1Object {
    public static final int MAC = 2;
    public static final int SIGNATURE = 1;
    private final AlgorithmIdentifier digestAlgorithm;
    private final AlgorithmIdentifier macAlgorithm;
    private final AlgorithmIdentifier signatureAlgorithm;

    private CMSAlgorithmProtection(ASN1Sequence arg6) {
        super();
        int v1 = 2;
        if(arg6.size() == v1) {
            this.digestAlgorithm = AlgorithmIdentifier.getInstance(arg6.getObjectAt(0));
            ASN1TaggedObject v6 = ASN1TaggedObject.getInstance(arg6.getObjectAt(1));
            AlgorithmIdentifier v4 = null;
            if(v6.getTagNo() == 1) {
                this.signatureAlgorithm = AlgorithmIdentifier.getInstance(v6, false);
                this.macAlgorithm = v4;
                return;
            }

            if(v6.getTagNo() == v1) {
                this.signatureAlgorithm = v4;
                this.macAlgorithm = AlgorithmIdentifier.getInstance(v6, false);
                return;
            }

            throw new IllegalArgumentException("Unknown tag found: " + v6.getTagNo());
        }

        throw new IllegalArgumentException("Sequence wrong size: One of signatureAlgorithm or macAlgorithm must be present");
    }

    public CMSAlgorithmProtection(AlgorithmIdentifier arg2, int arg3, AlgorithmIdentifier arg4) {
        super();
        if(arg2 != null && arg4 != null) {
            this.digestAlgorithm = arg2;
            AlgorithmIdentifier v0 = null;
            if(arg3 == 1) {
                this.signatureAlgorithm = arg4;
                this.macAlgorithm = v0;
                return;
            }
            else if(arg3 == 2) {
                this.signatureAlgorithm = v0;
                this.macAlgorithm = arg4;
                return;
            }
            else {
                throw new IllegalArgumentException("Unknown type: " + arg3);
            }
        }

        throw new NullPointerException("AlgorithmIdentifiers cannot be null");
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public static CMSAlgorithmProtection getInstance(Object arg1) {
        if((arg1 instanceof CMSAlgorithmProtection)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CMSAlgorithmProtection(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.digestAlgorithm);
        if(this.signatureAlgorithm != null) {
            v0.add(new DERTaggedObject(false, 1, this.signatureAlgorithm));
        }

        if(this.macAlgorithm != null) {
            v0.add(new DERTaggedObject(false, 2, this.macAlgorithm));
        }

        return new DERSequence(v0);
    }
}

