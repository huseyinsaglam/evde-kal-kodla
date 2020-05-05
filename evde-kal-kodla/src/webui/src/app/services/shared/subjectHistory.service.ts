import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable()
export class SubjectHistoryService {

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
  // HttpClient API get() method => Fetch subjecthistory list
  getAll(): Observable<any> {
    return this.http.get(environment.API_BASE_PATH + '/subject/history/pagination')
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

  // HttpClient API get() method => Fetch subjecthistory
  getByid(id): Observable<any> {
    return this.http.get(environment.API_BASE_PATH  + '/subject/history/' + id)
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



  // HttpClient API post() method => Create subjecthistory
  createProject(subjectHistory): Observable<any> {
    return this.http.post(environment.API_BASE_PATH  + '/subject/history', JSON.stringify(subjectHistory), this.httpOptions)
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



  // HttpClient API delete() method => Delete subjecthistory
  delete(id){
    return this.http.delete(environment.API_BASE_PATH  + '/subject/history/' + id, this.httpOptions)
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
