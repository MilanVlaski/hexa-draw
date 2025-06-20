package com.mutaki.hexadraw.model;

import com.mutaki.hexadraw.model.document.Document;

/**
 * Element is a placeholder generic name. Obviously, a connector wouldn't have a
 * location, exactly.
 */
public interface Element extends Painting, Documentable<Document<?>> {
}
