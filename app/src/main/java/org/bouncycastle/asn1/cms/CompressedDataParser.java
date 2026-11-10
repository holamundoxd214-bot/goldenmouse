package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CompressedDataParser {
    private AlgorithmIdentifier _compressionAlgorithm;
    private ContentInfoParser _encapContentInfo;
    private ASN1Integer _version;

    public CompressedDataParser(ASN1SequenceParser arg2) throws IOException {
        super();
        this._version = arg2.readObject();
        this._compressionAlgorithm = AlgorithmIdentifier.getInstance(arg2.readObject().toASN1Primitive());
        this._encapContentInfo = new ContentInfoParser(arg2.readObject());
    }

    public AlgorithmIdentifier getCompressionAlgorithmIdentifier() {
        return this._compressionAlgorithm;
    }

    public ContentInfoParser getEncapContentInfo() {
        return this._encapContentInfo;
    }

    public ASN1Integer getVersion() {
        return this._version;
    }
}

