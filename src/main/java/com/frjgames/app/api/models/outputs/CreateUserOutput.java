package com.frjgames.app.api.models.outputs;

import com.frjgames.app.api.CreateUserHandler;
import com.frjgames.app.sessions.models.SessionData;
import java.util.Optional;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;

/**
 * Output of the {@link CreateUserHandler}.
 *
 * @author fridge
 */
@Data
@Builder
public class CreateUserOutput {

    /**
     * The session token which can be provided with each request to prove user has signed in.
     *
     * If the session data is missing, it means there was a failure creating it, and user should
     * re-authenticate through the {@link com.frjgames.app.api.AuthenticateUserHandler}.
     */
    @Nullable
    private final SessionData sessionToken;

    public Optional<SessionData> getSessionToken() {
        return Optional.ofNullable(sessionToken);
    }
}
