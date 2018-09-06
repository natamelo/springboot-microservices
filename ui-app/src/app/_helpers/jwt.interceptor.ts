import {Injectable} from '@angular/core';
import {HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      
        let currentToken = localStorage.getItem('currentToken');
       
        if (currentToken) {
            request = this.addParamAccessToken(request, currentToken);
        }

        return next.handle(request);
    }


  private addParamAccessToken(request: HttpRequest<any>, access_token: string) {
    const params = {};
    params['access_token'] = access_token;

    for (let key in request.params.keys) {
      params[key] = request.params.get(key);
    }
    
    request = request.clone({
      setParams: params
    });
    
    return request;

  }
}
