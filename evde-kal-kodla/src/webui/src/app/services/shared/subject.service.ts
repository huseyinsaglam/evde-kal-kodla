import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable()
export class SubjectService {

  constructor(private apiService : ApiService,private http: HttpClient)
  {

  }

/*  getAll():Observable<any>
  {
      return this.apiService.get("/subject").pipe(map(
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



  getByIdWithDetails(id: number) {
    return this.apiService.get("/subject/detail/"+ id).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          console.log(res);
          return {};
        }
      }
    ));
  }

  getByid(id):Observable<any>
  {
    return this.apiService.get("/subject",id).pipe(map(
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

  createSubject(subject):Observable<any>
  {
    return this.apiService.post("/subject",subject).pipe(map(
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


  delete(id):Observable<any>
  {
    return this.apiService.delete("/subject",id).pipe(map(
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


  getAllSubjectStatuses() {
    return this.apiService.get("/subject/statuses").pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          console.log(res);
          return {};
        }
      }
    ));
  }


  updateIssue(subject): Observable<any> {
    return this.apiService.put( '/subject/' + subject.id, subject).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          console.log(res);
          return {};
        }
      }
    ));
  }*/


  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  params: HttpParams = new HttpParams()
  // HttpClient API get() method => Fetch subject list
  getAll(): Observable<any> {
    return this.http.get(environment.API_BASE_PATH + '/subject/pagination')
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



  getByIdWithDetails(id: number) {
    return this.http.get(environment.API_BASE_PATH+ '/subject/detail/'+id)
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


  getAllSubjectStatusess():Observable<any> {
    return this.http.get(environment.API_BASE_PATH+ '/subject/statuses')
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

  getAllSubjectStatuses() {
    return this.apiService.get("/subject/statuses").pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          console.log(res);
          return {};
        }
      }
    ));
  }
  getAlls(): Observable<any> {
    return this.http.get(environment.API_BASE_PATH+ '/subject')
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
    return this.http.get(environment.API_BASE_PATH  + '/subject/' + id)
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
  createSubject(subject): Observable<any> {
    return this.http.post(environment.API_BASE_PATH  + '/subject', JSON.stringify(subject), this.httpOptions)
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
    return this.http.delete(environment.API_BASE_PATH  + '/subject/' + id, this.httpOptions)
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

/*  // HttpClient API put() method => Update project
  updateSubject(id, project): Observable<any> {
    return this.http.put(environment.API_BASE_PATH + '/subject/' + id, JSON.stringify(project), this.httpOptions)
      .pipe(map(
        response => {
          if (response != null) {
            return response
          } else {
            console.log(response);
            return {};

          }
        }
      ));
  }*/

  // HttpClient API put() method => Update project
  updateSubject(subject): Observable<any> {
    return this.http.put(environment.API_BASE_PATH + '/subject/' + subject.id, JSON.stringify(subject), this.httpOptions)
      .pipe(map(
        response => {
          if (response != null) {
            return response
          } else {
            console.log(response);
            return {};

          }
        }
      ));
  }

}
