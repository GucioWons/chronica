package org.chronica.library.commons.exception;

public class NotImplementedException extends RuntimeException {
    public NotImplementedException() {
        super("This method is not implemented!");
    }
}
