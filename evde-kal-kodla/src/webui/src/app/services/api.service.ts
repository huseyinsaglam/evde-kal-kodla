import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http:HttpClient) { }




    // HttpParams,  path ile gelen parametreleri alma islemini yapiyor..
  get(path: string, params: HttpParams = new HttpParams()):Observable<any> {
    return this.http.get( environment.API_BASE_PATH+path, {params});
  }

  // post ve put httpOptions ile Content icerikleri HttpHeaders koyarak gonderiyoruz JSON tipinde..
  // params ile gelen parametreleri JSON.stringify(params) Json a cevirip sonra header ile gonderme islemi yapiyoruz..
  post(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.post(environment.API_BASE_PATH + path, JSON.stringify(params),this.httpOptions);
  }

  put(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.put(environment.API_BASE_PATH + path, JSON.stringify(params),this.httpOptions);
  }

  delete(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.delete( environment.API_BASE_PATH+path, {params});
  }


}
