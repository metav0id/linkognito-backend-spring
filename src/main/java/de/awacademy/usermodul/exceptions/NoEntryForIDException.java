package de.awacademy.usermodul.exceptions;

public class NoEntryForIDException extends Exception{
    public NoEntryForIDException(long id, long addressId) {
        super("No Message found for userId: " + id + " addressId: " + addressId);
    }
}
