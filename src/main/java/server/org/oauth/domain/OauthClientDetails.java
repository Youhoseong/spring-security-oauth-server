package server.org.oauth.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class OauthClientDetails extends BaseClientDetails {
    @Id
    @Column(name="CLIENT_ID")
    private String clientId;

    @Column(name="CLIENT_SECRET")
    private String clientSecret;

    public void updateInfo(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        super.setScope(List.of("read","write"));
    }

}
