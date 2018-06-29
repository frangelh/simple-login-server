package xyz.somniumproject.logindemo.commands

class CustomException extends RuntimeException {

    enum ERROR {
        SERVER_ERROR,
        VALIDATION_ERROR,
        CONNECTION_ERROR,
        SESSION_ERROR,
        DATABASE_ERROR
    }

    public String errorType
    public String messageText

    String getErrorType() {
        return errorType
    }

    void setErrorType(String errorType) {
        this.errorType = errorType
    }

    String getMessageText() {
        return messageText
    }

    void setMessageText(String messageText) {
        this.messageText = messageText
    }
}