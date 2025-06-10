package com.mutaki.hexadraw.model.document;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public interface Document<M> {

    M toModel();
}
