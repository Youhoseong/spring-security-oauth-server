package server.org.oauth.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class OauthClientDetails extends BaseClientDetails {
    @Id
    @Column(name="CLIENT_ID")
    private String clientId;

    @Column
    private String clientSecret;

}
