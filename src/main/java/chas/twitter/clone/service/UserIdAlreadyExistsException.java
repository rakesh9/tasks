package chas.twitter.clone.service;

/**
 * Created by s-sumi on 2017/03/01.
 */
public class UserIdAlreadyExistsException extends RuntimeException{
    public UserIdAlreadyExistsException(String message) {
        super(message);
    }
}
