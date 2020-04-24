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
      return this.apiService.get("/subject").pipe(
       response =>
       {
         if (response != null)
         {
           return response
         }
         else
         {
           console.log(response);
         }
       }
       );
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

        }
      }
    ));
  }


}
