import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable()
export class ProjectService {

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
   // http://localhost:8080/project/pagination?page=0&size=10
  // HttpClient API get() method => Fetch project list
  getAll(): Observable<any> {
    return this.http.get(environment.API_BASE_PATH + '/project/pagination')
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


  getAlls(): Observable<any> {
    return this.http.get(environment.API_BASE_PATH+ '/project')
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

  // HttpClient API get() method => Fetch project
  getByid(id): Observable<any> {
    return this.http.get(environment.API_BASE_PATH  + '/project/' + id)
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



  // HttpClient API post() method => Create project
  createProject(project): Observable<any> {
    return this.http.post(environment.API_BASE_PATH  + '/project', JSON.stringify(project), this.httpOptions)
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



  // HttpClient API delete() method => Delete project
  delete(id){
    return this.http.delete(environment.API_BASE_PATH  + '/project/' + id, this.httpOptions)
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

  // HttpClient API put() method => Update project
  updateProject(id, project): Observable<any> {
    return this.http.put(environment.API_BASE_PATH  + '/project/' + id, JSON.stringify(project), this.httpOptions)
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
