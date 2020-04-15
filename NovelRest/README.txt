
This is the "server" part of the Oauth SSo example
FIRST Client is MemberRestOauthCode
      It allows access to a REST API  through authorization code/access token
SECOND Client is MemberRestOauthImplict
      It allows access to a REST API  through Browser login/access token
THIRD Client is MemberRestOauthPwd
      It allows access to a REST API  through Password/access token

Implemented logout in client BUT calls AUTH SERVER to remove token...  [See LogoutHandler]
Implemented custom  login page ON AUTH SERVER

RestHttpHeader places the access token in every request to the REST API
   authHeader = "Bearer " + accessToken

NOTE "stuff" is in memory ...