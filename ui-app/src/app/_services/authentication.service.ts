import {HttpParams, HttpClient} from '@angular/common/http';
import {Headers, RequestOptions} from '@angular/http';
import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';

@Injectable()
export class AuthenticationService {
  constructor(private http: HttpClient) {}

  login(username: string, password: string) {

    const oauthTokenURL = 'http://localhost:8089/uaa/oauth/token';

    const params = {
      'username': username,
      'password': password,
      'grant_type': 'password',
      'client_id': 'client'
    };

    const headers = {
      'Authorization': 'Basic Y2xpZW50OmNsaWVudHBhc3N3b3Jk'
    };

    return this.http.post<any>(oauthTokenURL, null, {headers, params}
    )
      .pipe(map(user => {
        if (user && user.access_token) {
          localStorage.setItem('currentToken', user.access_token);
          localStorage.setItem('currentLogin', username);
        }
        return user;
      }));
  }

  logout() {
    localStorage.removeItem('currentToken');
    localStorage.removeItem('currentLogin');
    localStorage.removeItem('currentUser');
  }
}
