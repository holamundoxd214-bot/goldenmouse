package org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSet;

public class AttributeTable {
    private Hashtable attributes;

    public AttributeTable(Hashtable arg2) {
        super();
        this.attributes = new Hashtable();
        this.attributes = this.copyTable(arg2);
    }

    public AttributeTable(ASN1EncodableVector arg4) {
        super();
        this.attributes = new Hashtable();
        int v0;
        for(v0 = 0; v0 != arg4.size(); ++v0) {
            Attribute v1 = Attribute.getInstance(arg4.get(v0));
            this.addAttribute(v1.getAttrType(), v1);
        }
    }

    public AttributeTable(ASN1Set arg4) {
        super();
        this.attributes = new Hashtable();
        int v0;
        for(v0 = 0; v0 != arg4.size(); ++v0) {
            Attribute v1 = Attribute.getInstance(arg4.getObjectAt(v0));
            this.addAttribute(v1.getAttrType(), v1);
        }
    }

    public AttributeTable(Attribute arg2) {
        super();
        this.attributes = new Hashtable();
        this.addAttribute(arg2.getAttrType(), arg2);
    }

    public AttributeTable(Attributes arg1) {
        this(ASN1Set.getInstance(arg1.toASN1Primitive()));
    }

    public AttributeTable add(ASN1ObjectIdentifier arg3, ASN1Encodable arg4) {
        AttributeTable v0 = new AttributeTable(this.attributes);
        v0.addAttribute(arg3, new Attribute(arg3, new DERSet(arg4)));
        return v0;
    }

    private void addAttribute(ASN1ObjectIdentifier arg3, Attribute arg4) {
        Object v1_1;
        Object v0 = this.attributes.get(arg3);
        if(v0 == null) {
            this.attributes.put(arg3, arg4);
            return;
        }

        if((v0 instanceof Attribute)) {
            Vector v1 = new Vector();
            v1.addElement(v0);
        }
        else {
            v1_1 = v0;
        }

        ((Vector)v1_1).addElement(arg4);
        this.attributes.put(arg3, v1_1);
    }

    private Hashtable copyTable(Hashtable arg4) {
        Hashtable v3 = new Hashtable();
        Enumeration v0 = arg4.keys();
        while(v0.hasMoreElements()) {
            Object v1 = v0.nextElement();
            v3.put(v1, arg4.get(v1));
        }

        return v3;
    }

    public Attribute get(ASN1ObjectIdentifier arg1) {
        Object v0 = this.attributes.get(arg1);
        if((v0 instanceof Vector)) {
            return ((Vector)v0).elementAt(0);
        }

        return ((Attribute)v0);
    }

    public ASN1EncodableVector getAll(ASN1ObjectIdentifier arg2) {
        ASN1EncodableVector v0 = new ASN1EncodableVector();
        Object v1 = this.attributes.get(arg2);
        if((v1 instanceof Vector)) {
            Enumeration v1_1 = ((Vector)v1).elements();
            while(v1_1.hasMoreElements()) {
                v0.add(v1_1.nextElement());
            }
        }
        else if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        return v0;
    }

    public AttributeTable remove(ASN1ObjectIdentifier arg2) {
        AttributeTable v0 = new AttributeTable(this.attributes);
        v0.attributes.remove(arg2);
        return v0;
    }

    public int size() {
        Enumeration v3 = this.attributes.elements();
        int v0;
        for(v0 = 0; v3.hasMoreElements(); ++v0) {
            Object v1 = v3.nextElement();
            if((v1 instanceof Vector)) {
                v0 += ((Vector)v1).size();
                continue;
            }
        }

        return v0;
    }

    public ASN1EncodableVector toASN1EncodableVector() {
        Enumeration v1_1;
        ASN1EncodableVector v0 = new ASN1EncodableVector();
        Enumeration v3 = this.attributes.elements();
    label_4:
        while(v3.hasMoreElements()) {
            Object v1 = v3.nextElement();
            if((v1 instanceof Vector)) {
                v1_1 = ((Vector)v1).elements();
                goto label_10;
            }

            v0.add(Attribute.getInstance(v1));
        }

        return v0;
        while(true) {
        label_10:
            if(!v1_1.hasMoreElements()) {
                goto label_4;
            }

            v0.add(Attribute.getInstance(v1_1.nextElement()));
        }
    }

    public Attributes toASN1Structure() {
        return new Attributes(this.toASN1EncodableVector());
    }

    public Hashtable toHashtable() {
        return this.copyTable(this.attributes);
    }
}

