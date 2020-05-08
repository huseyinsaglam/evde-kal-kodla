import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable()
export class SubjectService {

  constructor(private apiService : ApiService)
  {

  }

  getAll():Observable<any>
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
  }
}
