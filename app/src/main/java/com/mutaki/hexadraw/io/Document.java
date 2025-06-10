package com.mutaki.hexadraw.io;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public interface Document<M> {

    M toModel();
}
