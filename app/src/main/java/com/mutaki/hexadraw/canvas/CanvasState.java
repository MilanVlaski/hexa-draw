package com.mutaki.hexadraw.canvas;

import java.awt.Point;

interface CanvasState extends OnHitCallback {

    void click(Point point);

}
