package com.mutaki.hexadraw;

import java.awt.Point;

import com.mutaki.hexadraw.io.Document;

/**
 * Element is a placeholder generic name. Obviously, a connector wouldn't have a
 * location, exactly.
 */
public interface Element extends Painting, Documentable<Document<?>> {
    boolean isAt(Point point);
}
