import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";

@Injectable()
export class ProjectService {

  constructor(private apiService : ApiService)
  {

  }

  getAll():Observable<any>
  {
      return this.apiService.get("/project").pipe(
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
    return this.apiService.get("/project",id).pipe(
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

  createProject(project):Observable<any>
  {
    return this.apiService.post("/project",project).pipe(
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
    )
  }


  delete(id):Observable<any>
  {
    return this.apiService.delete("/project",id).pipe(
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


}
