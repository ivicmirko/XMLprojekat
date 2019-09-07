import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpResponse, HttpHandler,HTTP_INTERCEPTORS } from '@angular/common/http';
import { SessionStorageService } from '../SessionStorage/session-storage.service';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorServiceService implements HttpInterceptor{
  
  constructor(private sessionStorageService:SessionStorageService) { }
  
  intercept(req: HttpRequest<any>, next: HttpHandler){
    
    let tokenizeReq=req;
    const token=this.sessionStorageService.getToken();
    
    let parametar='Bearer '+token;
    console.log("interceptr "+parametar);
    if(token != null){
      console.log(token);
      tokenizeReq=req.clone({
        setHeaders:{
          Buckuris: token
        }
        // headers: req.headers.set('Authorization', `Bearer ${token}`)
      });
    }else{
      console.log('NO TOKEN');
    }

    return next.handle(tokenizeReq);
  }

  // const req1 = req.clone({
  //   headers: req.headers.set('Authorization', `Bearer ${token}`),
  // });
}
