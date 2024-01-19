package com.d2.exception;

public class PersistenceException extends D2ApplicationException {

    public PersistenceException(final String message) {
        super(message);
    }

    public static class EntityNotFoundException extends PersistenceException {

        private static final String ERR_MSG_TEMPLATE = "Entity of type <%S> with id <%s> not found.";

        public <T, ID> EntityNotFoundException(final Class<T> type, final ID id) {
            super(ERR_MSG_TEMPLATE.formatted(type, id));
        }
    }
}
