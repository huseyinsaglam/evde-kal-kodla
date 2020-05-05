import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable()
export class UserService {

  constructor(private apiService : ApiService,private http: HttpClient)
  {

  }


  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  params: HttpParams = new HttpParams()
  // HttpClient API get() method => Fetch user list
  getAll(): Observable<any> {
    return this.http.get(environment.API_BASE_PATH + '/user')
      .pipe(map(
        response =>
        {
          if (response != null)
          {
            return response
          }
          else
          {
            console.log(response);
            return {};
          }
        }
      ));
  }

  // HttpClient API get() method => Fetch user
  getByid(id): Observable<any> {
    return this.http.get(environment.API_BASE_PATH  + '/user/' + id)
      .pipe(map(
        response =>
        {
          if (response != null)
          {
            return response
          }
          else
          {
            console.log(response);
            return {};

          }
        }
      ));
  }



  // HttpClient API post() method => Create user
  createProject(user): Observable<any> {
    return this.http.post(environment.API_BASE_PATH  + '/user', JSON.stringify(user), this.httpOptions)
      .pipe(map(
        response =>
        {
          if (response != null)
          {
            return response
          }
          else
          {
            console.log(response);
            return {};

          }
        }
      ))
  }




  // HttpClient API put() method => Update user
  updateProject(id, user): Observable<any> {
    return this.http.put(environment.API_BASE_PATH  + '/project/' + id, JSON.stringify(user), this.httpOptions)
      .pipe(map(
        response =>
        {
          if (response != null)
          {
            return response
          }
          else
          {
            console.log(response);
            return {};

          }
        }
      ));
  }





}
