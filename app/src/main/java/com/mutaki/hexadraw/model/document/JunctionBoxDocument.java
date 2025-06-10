package com.mutaki.hexadraw.model.document;

import java.awt.Point;

import com.mutaki.hexadraw.model.JunctionBox;
import com.mutaki.hexadraw.model.Location;

public class JunctionBoxDocument implements Document<JunctionBox> {

    public Location location;

    public JunctionBoxDocument() {
    }

    public JunctionBoxDocument(Point location) {
	this.location = new Location(location.x, location.y);
    }

    @Override
    public JunctionBox toModel() {
	return new JunctionBox(new Point(location.x, location.y));
    }

}
