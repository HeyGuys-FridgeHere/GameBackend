package com.frjgames.dal.models.exceptions;

/**
 * Exception thrown when data read from the DB is in some invalid state.
 *
 * RuntimeException because this cause should never happen, and we don't want callers to explicitly handle this.
 * (should only be caught in a catch-all)
 *
 * @author fridge
 */
public class InvalidDataException extends DataAccessLayerException {

    public InvalidDataException(final String message) {
        super(message);
    }

}
