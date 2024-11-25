package org.practice.mongopractice.exception;

public class CommentIsNullException extends RuntimeException {
    public CommentIsNullException(String message) {
        super(message);
    }
}
