import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SubjectComponent} from "./subject.component";
import {SubjectDetailComponent} from "./subject-detail/subject-detail.component";


const routes: Routes = [
  {
    path:'',
    component:SubjectComponent
  },
  {
    path:'subject-detail/:id',
    component:SubjectDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SubjectRoutingModule { }
