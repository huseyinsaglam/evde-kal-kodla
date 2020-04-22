import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  /* Constructor ise biz http işlemleri yapacagımız için http get,post işlemleri yapacagımız için*/
  constructor(private http:HttpClient) { }


  /* ilk once bir path parametresi olsun.. bize bir takım parametrelerin gonderilmesi gerekiyor.. ve bu metot bize
* herhangi bir observable any  bir tip dönderecek*/


  /* this.http servisi üzerinden get işlemi yapacagız get işlemi yaparken öncelikle path vermemiz gerekiyor.*/
  /* ikincisi params vermemiz lazım gelen parametreleri vermemiz lazım ve bu işlem sonucunda pipe hata gelirse*/
  /* o hatayı dönüşüme ugartıyoruz hataları ortaklaştırmak için catch error kullandık.*/
  get(path: string, params: HttpParams = new HttpParams()):Observable<any> {
    return this.http.get( environment.API_BASE_PATH+path, {params});
  }


  /* gelen parametreler belli bir path gonderilecek path gönderildikten sonra error donuyorsak o errorları sadece */
  /* içersindeki error kullanıyor olacagız*/
  post(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.post(environment.API_BASE_PATH + path, JSON.stringify(params));
  }

  put(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.put(environment.API_BASE_PATH + path, JSON.stringify(params));
  }

  delete(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.delete( environment.API_BASE_PATH+path, {params});
  }


}
