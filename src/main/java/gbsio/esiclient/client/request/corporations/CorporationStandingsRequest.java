package gbsio.esiclient.client.request.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.common.NPCStandings;
import gbsio.esiclient.api.request.specific.GetListRequest;

import java.util.Optional;

/**
 * Retrieves standings towards a corporation from NPCs, factions, and agents.
 */
final public class CorporationStandingsRequest implements GetListRequest<NPCStandings, ImmutableList<NPCStandings>> {
    private final int corporationID;
    private final String accessToken;

    /**
     * @param corporationID the ID of the corporation to query
     * @param accessToken an OAuth2 access token belonging to any character in
     *                    said corporation
     */
    public CorporationStandingsRequest(final int corporationID, final String accessToken) {
        this.corporationID = corporationID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/corporations/%d/standings/", corporationID);
    }

    @Override
    public TypeReference<ImmutableList<NPCStandings>> getExpectedType() {
        return new TypeReference<ImmutableList<NPCStandings>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
