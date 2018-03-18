package com.getItFree.exception;

import java.math.BigInteger;

public class ResourceConflictException extends RuntimeException {

    private static final long serialVersionUID = 1791564636123821405L;
    private BigInteger resourceId;

    public ResourceConflictException(BigInteger resourceId, String message) {
        super(message);
        this.setResourceId(resourceId);
    }

    public BigInteger getResourceId() {
        return resourceId;
    }

    public void setResourceId(BigInteger resourceId) {
        this.resourceId = resourceId;
    }
}
