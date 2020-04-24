import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable()
export class ProjectService {

  constructor(private apiService : ApiService)
  {

  }

  getAll():Observable<any>
  {
      return this.apiService.get("/project").pipe(map(
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


  getByid(id):Observable<any>
  {
    return this.apiService.get("/project",id).pipe(map(
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

  createProject(project):Observable<any>
  {
    return this.apiService.post("/project",project).pipe(map(
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
    return this.apiService.delete("/project",id).pipe(map(
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
