package androidx.compose.ui.text;

import android.text.Editable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0019\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000EH\u0016J\u0010\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\u0012H\u0002J\b\u0010\u0016\u001A\u00020\fH\u0002J\b\u0010\u0017\u001A\u00020\fH\u0002J\b\u0010\u0018\u001A\u00020\fH\u0002J\b\u0010\u0019\u001A\u00020\fH\u0002J\b\u0010\u001A\u001A\u00020\fH\u0002J\b\u0010\u001B\u001A\u00020\fH\u0002J)\u0010\u001C\u001A\u00020\f2\u000E\u0010\u001D\u001A\n \u001F*\u0004\u0018\u00010\u001E0\u001E2\u0006\u0010 \u001A\u00020\b2\u0006\u0010!\u001A\u00020\bH\u0096\u0001J\t\u0010\"\u001A\u00020\fH\u0096\u0001J\u0019\u0010#\u001A\u00020\f2\u000E\u0010\u001D\u001A\n \u001F*\u0004\u0018\u00010\u000E0\u000EH\u0096\u0001J)\u0010$\u001A\u00020\f2\u000E\u0010\u001D\u001A\n \u001F*\u0004\u0018\u00010\u001E0\u001E2\u0006\u0010 \u001A\u00020\b2\u0006\u0010!\u001A\u00020\bH\u0096\u0001J)\u0010%\u001A\u00020\f2\u000E\u0010\u001D\u001A\n \u001F*\u0004\u0018\u00010\u000E0\u000E2\u000E\u0010 \u001A\n \u001F*\u0004\u0018\u00010\u000E0\u000EH\u0096\u0001J\u0019\u0010&\u001A\u00020\f2\u000E\u0010\u001D\u001A\n \u001F*\u0004\u0018\u00010\'0\'H\u0096\u0001J\u0019\u0010(\u001A\u00020\f2\u000E\u0010\u001D\u001A\n \u001F*\u0004\u0018\u00010\u000E0\u000EH\u0096\u0001J\t\u0010)\u001A\u00020\fH\u0096\u0001J)\u0010*\u001A\u00020\f2\u000E\u0010\u001D\u001A\n \u001F*\u0004\u0018\u00010\u000E0\u000E2\u000E\u0010 \u001A\n \u001F*\u0004\u0018\u00010\u000E0\u000EH\u0096\u0001R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006+"}, d2={"Landroidx/compose/ui/text/AnnotationContentHandler;", "Lorg/xml/sax/ContentHandler;", "contentHandler", "output", "Landroid/text/Editable;", "<init>", "(Lorg/xml/sax/ContentHandler;Landroid/text/Editable;)V", "bulletIndentation", "", "currentBulletSpan", "Landroidx/compose/ui/text/BulletSpanWithLevel;", "startElement", "", "uri", "", "localName", "qName", "atts", "Lorg/xml/sax/Attributes;", "endElement", "handleAnnotationStart", "attributes", "handleAnnotationEnd", "handleUlStart", "handleUlEnd", "handleLiStart", "handleLiEnd", "commitCurrentBulletSpan", "characters", "p0", "", "kotlin.jvm.PlatformType", "p1", "p2", "endDocument", "endPrefixMapping", "ignorableWhitespace", "processingInstruction", "setDocumentLocator", "Lorg/xml/sax/Locator;", "skippedEntity", "startDocument", "startPrefixMapping", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class AnnotationContentHandler implements ContentHandler {
    private int bulletIndentation;
    private final ContentHandler contentHandler;
    private BulletSpanWithLevel currentBulletSpan;
    private final Editable output;

    public AnnotationContentHandler(ContentHandler arg1, Editable arg2) {
        super();
        this.contentHandler = arg1;
        this.output = arg2;
    }

    public void characters(char[] arg1, int arg2, int arg3) {
        this.contentHandler.characters(arg1, arg2, arg3);
    }

    private final void commitCurrentBulletSpan() {
        BulletSpanWithLevel v0 = this.currentBulletSpan;
        if(v0 != null) {
            this.output.setSpan(v0, v0.getStart(), this.output.length(), 33);
        }

        this.currentBulletSpan = null;
    }

    public void endDocument() {
        this.contentHandler.endDocument();
    }

    public void endElement(String arg3, String arg4, String arg5) {
        if(arg4 != null) {
            int v0 = arg4.hashCode();
            if(v0 != 0xA34FEB2F) {
                if(v0 != 0xD7D) {
                    if(v0 != 0xE97) {
                    }
                    else if(!arg4.equals("ul")) {
                    }
                    else {
                        this.handleUlEnd();
                        return;
                    }
                }
                else if(!arg4.equals("li")) {
                }
                else {
                    this.handleLiEnd();
                    return;
                }
            }
            else if(!arg4.equals("annotation")) {
            }
            else {
                this.handleAnnotationEnd();
                return;
            }
        }

        this.contentHandler.endElement(arg3, arg4, arg5);
    }

    public void endPrefixMapping(String arg1) {
        this.contentHandler.endPrefixMapping(arg1);
    }

    private final void handleAnnotationEnd() {
        int v3 = 0;
        Object[] v0 = this.output.getSpans(0, this.output.length(), AnnotationSpan.class);
        ArrayList v1 = new ArrayList();
        int v2 = v0.length;
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            Object v5 = v0[v4];
            if(this.output.getSpanFlags(v5) == 17) {
                ((Collection)v1).add(v5);
            }
        }

        int v0_1 = v1.size();
        while(v3 < v0_1) {
            Object v2_1 = ((List)v1).get(v3);
            v4 = this.output.getSpanStart(v2_1);
            int v5_1 = this.output.length();
            this.output.removeSpan(v2_1);
            if(v4 != v5_1) {
                this.output.setSpan(v2_1, v4, v5_1, 33);
            }

            ++v3;
        }
    }

    private final void handleAnnotationStart(Attributes arg8) {
        int v0 = arg8.getLength();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            String v2 = arg8.getLocalName(v1);
            String v3 = "";
            if(v2 == null) {
                v2 = v3;
            }

            String v4 = arg8.getValue(v1);
            if(v4 == null) {
            }
            else {
                v3 = v4;
            }

            if(v2.length() > 0 && v3.length() > 0) {
                int v4_1 = this.output.length();
                this.output.setSpan(new AnnotationSpan(v2, v3), v4_1, v4_1, 17);
            }
        }
    }

    private final void handleLiEnd() {
        this.commitCurrentBulletSpan();
    }

    private final void handleLiStart() {
        this.commitCurrentBulletSpan();
        this.currentBulletSpan = new BulletSpanWithLevel(Bullet.Companion.getDefault(), this.bulletIndentation, this.output.length());
    }

    private final void handleUlEnd() {
        this.commitCurrentBulletSpan();
        --this.bulletIndentation;
    }

    private final void handleUlStart() {
        this.commitCurrentBulletSpan();
        ++this.bulletIndentation;
    }

    public void ignorableWhitespace(char[] arg1, int arg2, int arg3) {
        this.contentHandler.ignorableWhitespace(arg1, arg2, arg3);
    }

    public void processingInstruction(String arg1, String arg2) {
        this.contentHandler.processingInstruction(arg1, arg2);
    }

    public void setDocumentLocator(Locator arg1) {
        this.contentHandler.setDocumentLocator(arg1);
    }

    public void skippedEntity(String arg1) {
        this.contentHandler.skippedEntity(arg1);
    }

    public void startDocument() {
        this.contentHandler.startDocument();
    }

    public void startElement(String arg3, String arg4, String arg5, Attributes arg6) {
        if(arg4 != null) {
            int v0 = arg4.hashCode();
            if(v0 != 0xA34FEB2F) {
                if(v0 != 0xD7D) {
                    if(v0 != 0xE97) {
                    }
                    else if(!arg4.equals("ul")) {
                    }
                    else {
                        this.handleUlStart();
                        return;
                    }
                }
                else if(!arg4.equals("li")) {
                }
                else {
                    this.handleLiStart();
                    return;
                }
            }
            else if(!arg4.equals("annotation")) {
            }
            else {
                if(arg6 != null) {
                    this.handleAnnotationStart(arg6);
                }

                return;
            }
        }

        this.contentHandler.startElement(arg3, arg4, arg5, arg6);
    }

    public void startPrefixMapping(String arg1, String arg2) {
        this.contentHandler.startPrefixMapping(arg1, arg2);
    }
}

