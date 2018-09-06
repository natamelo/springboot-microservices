import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {User} from '../_models';
import {Headers} from '@angular/http';
import {RequestOptions} from '@angular/http';

import {map} from 'rxjs/operators';

@Injectable()
export class UserService {
  constructor(private http: HttpClient) {}

  register(user: User) {
    return this.http.post('http://localhost:8081/accounts/create', user);
  }

  get_user_by_login(username: string) {

    const getUserByLoginURL = 'http://localhost:8081/accounts';

    const params = {
      'login': username
    };

    return this.http.get<any>(getUserByLoginURL, {params});
  }
}
