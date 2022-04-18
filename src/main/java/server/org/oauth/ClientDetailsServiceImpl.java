package server.org.oauth;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import server.org.oauth.domain.OauthClientDetails;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OauthClientDetails details = new OauthClientDetails();
        details.updateInfo("id2", "password1");

        return details;
    }
}
