package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.PKIPublicationInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class CMCPublicationInfo extends ASN1Object {
    private final ASN1Sequence certHashes;
    private final AlgorithmIdentifier hashAlg;
    private final PKIPublicationInfo pubInfo;

    private CMCPublicationInfo(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 3) {
            this.hashAlg = AlgorithmIdentifier.getInstance(arg3.getObjectAt(0));
            this.certHashes = ASN1Sequence.getInstance(arg3.getObjectAt(1));
            this.pubInfo = PKIPublicationInfo.getInstance(arg3.getObjectAt(2));
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public CMCPublicationInfo(AlgorithmIdentifier arg4, byte[][] arg5, PKIPublicationInfo arg6) {
        super();
        this.hashAlg = arg4;
        ASN1EncodableVector v4 = new ASN1EncodableVector(arg5.length);
        int v0;
        for(v0 = 0; v0 != arg5.length; ++v0) {
            v4.add(new DEROctetString(Arrays.clone(arg5[v0])));
        }

        this.certHashes = new DERSequence(v4);
        this.pubInfo = arg6;
    }

    public byte[][] getCertHashes() {
        int v0 = this.certHashes.size();
        byte[][] v1 = new byte[v0][];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = Arrays.clone(ASN1OctetString.getInstance(this.certHashes.getObjectAt(v2)).getOctets());
        }

        return v1;
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.hashAlg;
    }

    public static CMCPublicationInfo getInstance(Object arg1) {
        if((arg1 instanceof CMCPublicationInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CMCPublicationInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public PKIPublicationInfo getPubInfo() {
        return this.pubInfo;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.hashAlg);
        v0.add(this.certHashes);
        v0.add(this.pubInfo);
        return new DERSequence(v0);
    }
}

