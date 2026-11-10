package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

public class SignedDataParser {
    private boolean _certsCalled;
    private boolean _crlsCalled;
    private Object _nextObject;
    private ASN1SequenceParser _seq;
    private ASN1Integer _version;

    private SignedDataParser(ASN1SequenceParser arg1) throws IOException {
        super();
        this._seq = arg1;
        this._version = arg1.readObject();
    }

    public ASN1SetParser getCertificates() throws IOException {
        this._certsCalled = true;
        ASN1Encodable v0 = this._seq.readObject();
        this._nextObject = v0;
        Object v2 = null;
        if(((v0 instanceof ASN1TaggedObjectParser)) && (((ASN1TaggedObjectParser)v0).hasContextTag(0))) {
            v0 = ((ASN1TaggedObjectParser)v0).parseBaseUniversal(false, 17);
            this._nextObject = v2;
            return ((ASN1SetParser)v0);
        }

        return ((ASN1SetParser)v2);
    }

    public ASN1SetParser getCrls() throws IOException {
        if(this._certsCalled) {
            this._crlsCalled = true;
            if(this._nextObject == null) {
                this._nextObject = this._seq.readObject();
            }

            Object v1 = this._nextObject;
            Object v3 = null;
            if(((v1 instanceof ASN1TaggedObjectParser)) && (((ASN1TaggedObjectParser)v1).hasContextTag(1))) {
                ASN1Encodable v0 = ((ASN1TaggedObjectParser)v1).parseBaseUniversal(false, 17);
                this._nextObject = v3;
                return ((ASN1SetParser)v0);
            }

            return ((ASN1SetParser)v3);
        }

        throw new IOException("getCerts() has not been called.");
    }

    public ASN1SetParser getDigestAlgorithms() throws IOException {
        ASN1Encodable v1 = this._seq.readObject();
        if((v1 instanceof ASN1Set)) {
            return ((ASN1Set)v1).parser();
        }

        return ((ASN1SetParser)v1);
    }

    public ContentInfoParser getEncapContentInfo() throws IOException {
        return new ContentInfoParser(this._seq.readObject());
    }

    public static SignedDataParser getInstance(Object arg3) throws IOException {
        if((arg3 instanceof ASN1Sequence)) {
            return new SignedDataParser(((ASN1Sequence)arg3).parser());
        }

        if((arg3 instanceof ASN1SequenceParser)) {
            return new SignedDataParser(((ASN1SequenceParser)arg3));
        }

        throw new IOException("unknown object encountered: " + arg3.getClass().getName());
    }

    public ASN1SetParser getSignerInfos() throws IOException {
        if((this._certsCalled) && (this._crlsCalled)) {
            if(this._nextObject == null) {
                this._nextObject = this._seq.readObject();
            }

            return this._nextObject;
        }

        throw new IOException("getCerts() and/or getCrls() has not been called.");
    }

    public ASN1Integer getVersion() {
        return this._version;
    }
}

