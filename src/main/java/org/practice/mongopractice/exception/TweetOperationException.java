package org.practice.mongopractice.exception;

public class TweetOperationException extends RuntimeException {
    public TweetOperationException(String message) {
        super(message);
    }
}
