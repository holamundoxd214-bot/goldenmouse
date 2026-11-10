package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedContentInfoParser {
    private AlgorithmIdentifier _contentEncryptionAlgorithm;
    private ASN1ObjectIdentifier _contentType;
    private ASN1TaggedObjectParser _encryptedContent;

    public EncryptedContentInfoParser(ASN1SequenceParser arg2) throws IOException {
        super();
        this._contentType = arg2.readObject();
        this._contentEncryptionAlgorithm = AlgorithmIdentifier.getInstance(arg2.readObject().toASN1Primitive());
        this._encryptedContent = arg2.readObject();
    }

    public AlgorithmIdentifier getContentEncryptionAlgorithm() {
        return this._contentEncryptionAlgorithm;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this._contentType;
    }

    public ASN1Encodable getEncryptedContent(int arg2) throws IOException {
        return ASN1Util.parseContextBaseUniversal(this._encryptedContent, 0, false, arg2);
    }
}

