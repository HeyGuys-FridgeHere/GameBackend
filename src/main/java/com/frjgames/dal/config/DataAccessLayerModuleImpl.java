package com.frjgames.dal.config;

import com.frjgames.dal.accessors.EverlastHighScoreAccessorImplV2;
import com.frjgames.dal.accessors.GameAccessorImpl;
import com.frjgames.dal.accessors.GameBoardAccessorImpl;
import com.frjgames.dal.accessors.MatchMadeGameAccessorImpl;
import com.frjgames.dal.accessors.UserAccessorImplV2;
import com.frjgames.dal.accessors.UserSessionAccessorImplV2;
import com.frjgames.dal.ddb.accessors.DynamoDbAccessor;
import com.frjgames.dal.ddb.accessors.tablemgmt.FrjDynamoDbMapper;
import com.frjgames.dal.ddb.items.EverlastHighScoreDdbItem;
import com.frjgames.dal.ddb.items.GameBoardDdbItem;
import com.frjgames.dal.ddb.items.GameDdbItem;
import com.frjgames.dal.ddb.items.UserDdbItem;
import com.frjgames.dal.ddb.items.UserSessionDdbItem;
import com.frjgames.dal.models.interfaces.EverlastHighScoreAccessor;
import com.frjgames.dal.models.interfaces.GameAccessor;
import com.frjgames.dal.models.interfaces.GameBoardAccessor;
import com.frjgames.dal.models.interfaces.MatchMadeGameAccessor;
import com.frjgames.dal.models.interfaces.UserAccessor;
import com.frjgames.dal.models.interfaces.UserSessionAccessor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Configuration for the Data Access Layer, using DynamoDB SDK.
 *
 * @author fridge
 */
@RequiredArgsConstructor
@Accessors(fluent = true)
/* pkg */ class DataAccessLayerModuleImpl implements DataAccessLayerModule {

    /**
     * Dependencies
     */
    private final FrjDynamoDbMapper dynamoDBMapper;

    @Getter(lazy = true)
    private final UserAccessor userAccessor = new UserAccessorImplV2(
            new DynamoDbAccessor<>(dynamoDBMapper, UserDdbItem.class)
    );

    @Getter(lazy = true)
    private final UserSessionAccessor userSessionAccessor = new UserSessionAccessorImplV2(
            new DynamoDbAccessor<>(dynamoDBMapper, UserSessionDdbItem.class)
    );

    @Getter(lazy = true)
    private final EverlastHighScoreAccessor everlastHighScoreAccessor = new EverlastHighScoreAccessorImplV2(
            new DynamoDbAccessor<>(dynamoDBMapper, EverlastHighScoreDdbItem.class)
    );

    @Getter(lazy = true)
    private final MatchMadeGameAccessor matchMadeGameAccessor = new MatchMadeGameAccessorImpl(
            new DynamoDbAccessor<>(dynamoDBMapper, GameDdbItem.class)
    );

    @Getter(lazy = true)
    private final GameAccessor gameAccessor = new GameAccessorImpl(
            new DynamoDbAccessor<>(dynamoDBMapper, GameDdbItem.class)
    );

    @Getter(lazy = true)
    private final GameBoardAccessor gameBoardAccessor = new GameBoardAccessorImpl(
            new DynamoDbAccessor<>(dynamoDBMapper, GameBoardDdbItem.class)
    );

    private static <T> T unsupported() {
        throw new UnsupportedOperationException("Accessor is unsupported.");
    }
}
