package com.mutaki.hexadraw.model;

import com.mutaki.hexadraw.canvas.OnHitListener;
import com.mutaki.hexadraw.model.document.Document;

import java.awt.*;

/**
 * Element is a temporary generic name.
 */
public interface Element extends Painting, Documentable<Document<?>> {
    void hit(Point point, OnHitListener onHitListener);
}
