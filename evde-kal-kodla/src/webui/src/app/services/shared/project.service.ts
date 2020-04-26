import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable()
export class ProjectService {

  constructor(private apiService : ApiService)
  {

  }

  getAll(page):Observable<any>
  {
      return this.apiService.get("/project/pagination",page).pipe(map(
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

  // http://localhost:8080/project/2
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
          return {};

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
          return {};

        }
      }
    ))
  }


  // http://localhost:8080/project&id=3   (id=3) HttpParams ile aldi
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
          return {};

        }
      }
    ));
  }


}
