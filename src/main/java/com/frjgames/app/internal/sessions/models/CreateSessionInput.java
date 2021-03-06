package com.frjgames.app.internal.sessions.models;

import lombok.Builder;
import lombok.Data;

/**
 * Input for creating a user session.
 *
 * @author fridge
 */
@Data
@Builder
public class CreateSessionInput {

    private final String userId;

}
