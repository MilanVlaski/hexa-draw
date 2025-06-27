package com.mutaki.hexadraw.canvas;

import com.mutaki.hexadraw.model.events.ElementHitEvent;

public interface OnHitListener {
    void hitSuccessful(ElementHitEvent elementHitEvent);
}
