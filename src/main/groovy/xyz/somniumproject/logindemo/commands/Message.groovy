package xyz.somniumproject.logindemo.commands

class Message {
    boolean error
    String message

    Message(boolean error, String message) {
        this.error = error
        this.message = message
    }
}
