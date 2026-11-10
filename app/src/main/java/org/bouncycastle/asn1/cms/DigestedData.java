package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class DigestedData extends ASN1Object {
    private ASN1OctetString digest;
    private AlgorithmIdentifier digestAlgorithm;
    private ContentInfo encapContentInfo;
    private ASN1Integer version;

    private DigestedData(ASN1Sequence arg2) {
        super();
        this.version = arg2.getObjectAt(0);
        this.digestAlgorithm = AlgorithmIdentifier.getInstance(arg2.getObjectAt(1));
        this.encapContentInfo = ContentInfo.getInstance(arg2.getObjectAt(2));
        this.digest = ASN1OctetString.getInstance(arg2.getObjectAt(3));
    }

    public DigestedData(AlgorithmIdentifier arg4, ContentInfo arg5, byte[] arg6) {
        super();
        this.version = new ASN1Integer(0);
        this.digestAlgorithm = arg4;
        this.encapContentInfo = arg5;
        this.digest = new DEROctetString(Arrays.clone(arg6));
    }

    public byte[] getDigest() {
        return Arrays.clone(this.digest.getOctets());
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public ContentInfo getEncapContentInfo() {
        return this.encapContentInfo;
    }

    public static DigestedData getInstance(Object arg1) {
        if((arg1 instanceof DigestedData)) {
            return arg1;
        }

        if(arg1 != null) {
            return new DigestedData(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static DigestedData getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return DigestedData.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.version);
        v0.add(this.digestAlgorithm);
        v0.add(this.encapContentInfo);
        v0.add(this.digest);
        return new BERSequence(v0);
    }
}

