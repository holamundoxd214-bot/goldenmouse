package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class PublishTrustAnchors extends ASN1Object {
    private final ASN1Sequence anchorHashes;
    private final AlgorithmIdentifier hashAlgorithm;
    private final ASN1Integer seqNumber;

    public PublishTrustAnchors(BigInteger arg3, AlgorithmIdentifier arg4, byte[][] arg5) {
        super();
        this.seqNumber = new ASN1Integer(arg3);
        this.hashAlgorithm = arg4;
        ASN1EncodableVector v3 = new ASN1EncodableVector(arg5.length);
        int v4;
        for(v4 = 0; v4 != arg5.length; ++v4) {
            v3.add(new DEROctetString(Arrays.clone(arg5[v4])));
        }

        this.anchorHashes = new DERSequence(v3);
    }

    private PublishTrustAnchors(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 3) {
            this.seqNumber = ASN1Integer.getInstance(arg3.getObjectAt(0));
            this.hashAlgorithm = AlgorithmIdentifier.getInstance(arg3.getObjectAt(1));
            this.anchorHashes = ASN1Sequence.getInstance(arg3.getObjectAt(2));
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public byte[][] getAnchorHashes() {
        int v0 = this.anchorHashes.size();
        byte[][] v1 = new byte[v0][];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = Arrays.clone(ASN1OctetString.getInstance(this.anchorHashes.getObjectAt(v2)).getOctets());
        }

        return v1;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public static PublishTrustAnchors getInstance(Object arg1) {
        if((arg1 instanceof PublishTrustAnchors)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PublishTrustAnchors(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public BigInteger getSeqNumber() {
        return this.seqNumber.getValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.seqNumber);
        v0.add(this.hashAlgorithm);
        v0.add(this.anchorHashes);
        return new DERSequence(v0);
    }
}

