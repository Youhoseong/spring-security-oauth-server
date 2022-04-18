insert into oauth_client_details(
                                 client_id,
                                 resource_ids,
                                 client_secret,
                                 scope,
                                 authorized_grant_types,
                                 web_server_redirect_uri,
                                 authorities,
                                 access_token_validity,
                                 refresh_token_validity,
                                 additional_information,
                                 autoapprove
                                )

values(
       'id1',
       null,
       'password1',
       'read,write,profile,email',
       'client_credentials',
       null,
       'ROLE_USER',
       36000,
       50000,
       null,
       null);