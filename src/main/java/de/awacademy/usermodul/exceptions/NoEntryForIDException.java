package de.awacademy.usermodul.exceptions;

public class NoEntryForIDException extends Exception{
    public NoEntryForIDException(long id) {
        super("No Message found for userId: " + id);
    }
}
