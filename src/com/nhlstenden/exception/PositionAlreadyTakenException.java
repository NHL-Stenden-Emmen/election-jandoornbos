package com.nhlstenden.exception;

/**
 * Use this exception when a position within a party is already taken.
 */
public class PositionAlreadyTakenException extends RuntimeException
{
    public PositionAlreadyTakenException()
    {
        super("Position already taken!");
    }
}
