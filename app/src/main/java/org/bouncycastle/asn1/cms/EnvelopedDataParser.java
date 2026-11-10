package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;
import org.bouncycastle.asn1.ASN1Util;

public class EnvelopedDataParser {
    private ASN1Encodable _nextObject;
    private boolean _originatorInfoCalled;
    private ASN1SequenceParser _seq;
    private ASN1Integer _version;

    public EnvelopedDataParser(ASN1SequenceParser arg1) throws IOException {
        super();
        this._seq = arg1;
        this._version = ASN1Integer.getInstance(arg1.readObject());
    }

    public EncryptedContentInfoParser getEncryptedContentInfo() throws IOException {
        ASN1Encodable v0 = this._nextObject;
        if(v0 == null) {
            v0 = this._seq.readObject();
            this._nextObject = v0;
        }

        ASN1Encodable v1 = null;
        if(v0 != null) {
            this._nextObject = v1;
            return new EncryptedContentInfoParser(((ASN1SequenceParser)v0));
        }

        return ((EncryptedContentInfoParser)v1);
    }

    public OriginatorInfo getOriginatorInfo() throws IOException {
        this._originatorInfoCalled = true;
        ASN1Encodable v0 = this._nextObject;
        if(v0 == null) {
            v0 = this._seq.readObject();
            this._nextObject = v0;
        }

        ASN1Encodable v2 = null;
        if(((v0 instanceof ASN1TaggedObjectParser)) && (((ASN1TaggedObjectParser)v0).hasContextTag(0))) {
            v0 = ((ASN1TaggedObjectParser)v0).parseBaseUniversal(false, 16);
            this._nextObject = v2;
            return OriginatorInfo.getInstance(((ASN1SequenceParser)v0).getLoadedObject());
        }

        return ((OriginatorInfo)v2);
    }

    public ASN1SetParser getRecipientInfos() throws IOException {
        if(!this._originatorInfoCalled) {
            this.getOriginatorInfo();
        }

        ASN1Encodable v0 = this._nextObject;
        if(v0 == null) {
            v0 = this._seq.readObject();
            this._nextObject = v0;
        }

        this._nextObject = null;
        return ((ASN1SetParser)v0);
    }

    public ASN1SetParser getUnprotectedAttrs() throws IOException {
        ASN1Encodable v0 = this._nextObject;
        if(v0 == null) {
            v0 = this._seq.readObject();
            this._nextObject = v0;
        }

        ASN1Encodable v1 = null;
        if(v0 != null) {
            this._nextObject = v1;
            return ASN1Util.parseContextBaseUniversal(((ASN1TaggedObjectParser)v0), 1, false, 17);
        }

        return ((ASN1SetParser)v1);
    }

    public ASN1Integer getVersion() {
        return this._version;
    }
}

