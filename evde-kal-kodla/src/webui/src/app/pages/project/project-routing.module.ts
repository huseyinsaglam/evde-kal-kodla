import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProjectComponent} from "./project.component";
import {ModalModule} from "ngx-bootstrap/modal";


const routes: Routes = [
  {
    path :'',
    component:ProjectComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes),ModalModule.forRoot()],
  exports: [RouterModule]
})
export class ProjectRoutingModule { }
