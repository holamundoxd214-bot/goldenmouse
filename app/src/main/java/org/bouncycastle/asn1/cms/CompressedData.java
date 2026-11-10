package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CompressedData extends ASN1Object {
    private AlgorithmIdentifier compressionAlgorithm;
    private ContentInfo encapContentInfo;
    private ASN1Integer version;

    private CompressedData(ASN1Sequence arg2) {
        super();
        this.version = arg2.getObjectAt(0);
        this.compressionAlgorithm = AlgorithmIdentifier.getInstance(arg2.getObjectAt(1));
        this.encapContentInfo = ContentInfo.getInstance(arg2.getObjectAt(2));
    }

    public CompressedData(AlgorithmIdentifier arg4, ContentInfo arg5) {
        super();
        this.version = new ASN1Integer(0);
        this.compressionAlgorithm = arg4;
        this.encapContentInfo = arg5;
    }

    public AlgorithmIdentifier getCompressionAlgorithmIdentifier() {
        return this.compressionAlgorithm;
    }

    public ContentInfo getEncapContentInfo() {
        return this.encapContentInfo;
    }

    public static CompressedData getInstance(Object arg1) {
        if((arg1 instanceof CompressedData)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CompressedData(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static CompressedData getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return CompressedData.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.version);
        v0.add(this.compressionAlgorithm);
        v0.add(this.encapContentInfo);
        return new BERSequence(v0);
    }
}

